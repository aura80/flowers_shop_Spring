package com.shop.shop.service.impl;

import com.shop.shop.dto.AdminDto;
import com.shop.shop.exceptions.NotFoundException;
import com.shop.shop.model.Admin;
import com.shop.shop.repository.AdminRepository;
import com.shop.shop.service.AdminService;
import com.shop.shop.utils.DualEntityDtoConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public AdminDto saveAdmin(AdminDto adminDto) {
        log.info("---> Saving admin <---");
        Admin adminEntity = DualEntityDtoConverter.toEntity(adminDto);
        Admin savedAdminEntity = adminRepository.save(adminEntity);

        return DualEntityDtoConverter.toDto(savedAdminEntity);
    }

    @Override
    public void saveAllAdmins(List<Admin> admins) {
        log.info("---> Saving all the admins <---");

        adminRepository.saveAll(admins);
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        log.info("---> Retrieving all the admins <---");
        List<Admin> admins = adminRepository.findAll();

        return admins.stream()
                .map(DualEntityDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdminDto getAdminById(Long id) {
        log.info("---> Retrieving admin by ID: {} <---", id);
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Admin with id %s was not found", id)));

        return DualEntityDtoConverter.toDto(admin);
    }

    //    @Transactional
    @Override
    public AdminDto getAdminByName(String name) {
        log.info("---> Retrieving admin by name: {} <---", name);
        Admin admin = adminRepository.getAdminByName(name)
                .orElseThrow(() -> new NotFoundException("Admin with name: " + name + " was not found"));

        return DualEntityDtoConverter.toDto(admin);
    }

    @Override
    public AdminDto getAdminByNameAndEmail(String name, String email) {
        log.info("---> Retrieving admin by name: {} and email: {} <---", name, email);
        Admin admin = adminRepository.getAdminByNameAndEmail(name, email)
                .orElseThrow(() -> new NotFoundException(String.format("Admin with name %s and email %s not found", name, email)));

        return DualEntityDtoConverter.toDto(admin);
    }

    @Override
    public AdminDto updateAdminById(AdminDto adminDto, Long id) {
        log.info("---> Updating admin by ID: {} <---", id);
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("the admin with id: " + id + " was not found"));

        admin.setName(adminDto.getName());
        admin.setDateOfBirth(adminDto.getDateOfBirth());
        admin.setAge(adminDto.getAge());
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());
        admin.setRole(adminDto.getRole());

        Admin updatedAdmin = adminRepository.save(admin);

        return DualEntityDtoConverter.toDto(updatedAdmin);
    }

    @Override
    public void deleteAdminById(Long id) {
        log.info("---> Deleting admin by ID: {} <---", id);
        adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Admin with id: " + id + " was not found"));

        adminRepository.deleteById(id);
    }
}

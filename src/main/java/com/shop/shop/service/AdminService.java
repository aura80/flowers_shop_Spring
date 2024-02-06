package com.shop.shop.service;

import com.shop.shop.dto.AdminDto;
import com.shop.shop.model.Admin;

import java.util.List;

public interface AdminService {

    AdminDto saveAdmin(AdminDto adminDto);
    void saveAllAdmins(List<Admin> adminDto);
    List<AdminDto> getAllAdmins();
    AdminDto getAdminById(Long id);
    AdminDto getAdminByNameAndEmail(String name, String email);
    AdminDto getAdminByName(String name);
    AdminDto updateAdminById(AdminDto adminDto, Long id);
    void deleteAdminById(Long id);
}

package com.shop.shop.controller;

import com.shop.shop.dto.AdminDto;
import com.shop.shop.model.Admin;
import com.shop.shop.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/createAdmin")
    public ResponseEntity<AdminDto> saveAdmin(@RequestBody AdminDto adminDto) {
        AdminDto savedAdmin = adminService.saveAdmin(adminDto);

        return ResponseEntity.status((HttpStatus.CREATED))
                .header("Message", "Admin has been created successfully")
                .body(savedAdmin);
    }

    @PostMapping("/saveAllAdmins")
    public ResponseEntity<Void> saveAllAdmins(@RequestBody List<Admin> admins) {

        adminService.saveAllAdmins(admins);

        return ResponseEntity.noContent()
                .header("Message", "All admins added successfully")
                .build();
    }

    @GetMapping("/getAllAdmins")
    public ResponseEntity<List<AdminDto>> getAllAdmins() {
        return new ResponseEntity<>(adminService.getAllAdmins(), HttpStatus.OK);
    }

    @GetMapping("/getAdminById/{admin_id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable("admin_id") Long adminId) {
        AdminDto adminById = adminService.getAdminById(adminId);

        return new ResponseEntity<>(adminById, HttpStatus.OK);
    }

    @GetMapping("/getAdminByName/{name}")
    public ResponseEntity<AdminDto> getAdminByName(@PathVariable("name") String adminName) {
        AdminDto adminByName = adminService.getAdminByName(adminName);

        return new ResponseEntity<>(adminByName, HttpStatus.OK);
    }

    @GetMapping("/getAdminByNameAndEmail")
    public ResponseEntity<AdminDto> getAdminByNameAndEmail(@RequestParam String adminName,
                                                           @RequestParam String adminEmail) {
        AdminDto adminByNameAndEmail = adminService.getAdminByNameAndEmail(adminName, adminEmail);

        return new ResponseEntity<>(adminByNameAndEmail, HttpStatus.OK);
    }


    @PutMapping("/updateAdminById/{admin_id}")
    public ResponseEntity<AdminDto> updateProductById(@PathVariable("admin_id") Long adminId,
                                                        @RequestBody AdminDto adminDto) {
        AdminDto updatedAdmin = adminService.updateAdminById(adminDto, adminId);

        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", "Admin updated by id: " + adminId)
                .body(updatedAdmin);
    }

    @DeleteMapping("/deleteAdminById/{admin_id}")
    public ResponseEntity<Void> deleteAdminById(@PathVariable("admin_id") Long adminId) {
        adminService.deleteAdminById(adminId);

        return ResponseEntity.noContent()
                .header("Message", "Admin deleted by id: " + adminId)
                .build();
    }
}

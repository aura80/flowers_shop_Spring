package com.shop.shop.controller.jwt;

import com.shop.shop.dto.jwt.MessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class MessController {

    @GetMapping("/mess")
    public MessResponse mess(Principal principal) {
        return new MessResponse("Hello, " + principal.getName() + " you are in a secured page.");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        SecurityContextHolder.clearContext();
        return new ResponseEntity<String>("Logout Successfully!", HttpStatus.OK);
    }

}

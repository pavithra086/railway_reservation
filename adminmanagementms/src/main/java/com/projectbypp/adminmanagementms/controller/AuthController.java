package com.projectbypp.adminmanagementms.controller;

import com.projectbypp.adminmanagementms.customexception.AdminAlreadyExistException;
import com.projectbypp.adminmanagementms.model.Admin;
import com.projectbypp.adminmanagementms.model.AuthenticationRequest;
import com.projectbypp.adminmanagementms.model.AuthenticationResponse;
import com.projectbypp.adminmanagementms.service.AdminService;
import com.projectbypp.adminmanagementms.utils.JwtUtils;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("*")
@RestController
@RequestMapping("/admin/auth")
public class AuthController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity registerAdmin(@Valid @RequestBody Admin admin) throws AdminAlreadyExistException {
        try {
            Admin savedAdmin = adminService.add(admin);
            String userName = savedAdmin.getUserName();
            return ResponseEntity.ok(new AuthenticationResponse("succesfully signed up"));
        } catch (Exception exception) {
            return ResponseEntity.ok(new AuthenticationResponse("error occured while signing up"));
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody AuthenticationRequest authenticationRequest){
        String username = authenticationRequest.getUserName();
        String password = authenticationRequest.getPassword();
        try{
            Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            //UserDetails admin = (UserDetails) authentication.getPrincipal();
            UserDetails admin = adminService.loadUserByUsername(username);
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,jwtUtils.generateToken(admin)).body(admin);
        }
        catch (Exception exception){
            return ResponseEntity.ok(new AuthenticationResponse("Error during authentication"));
        }
//        UserDetails loadedUser = adminService.loadUserByUsername(username);
//        String generatedToken = jwtUtils.generateToken(loadedUser);
//        return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
    }



    @GetMapping("/test")
    public String testingtoken() {
        try {
            return "Testing Successful...!";
        } catch (Exception e) {
            return "Please login first..!";
        }
    }
}

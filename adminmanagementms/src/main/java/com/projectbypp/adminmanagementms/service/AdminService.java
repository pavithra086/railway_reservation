package com.projectbypp.adminmanagementms.service;


import com.projectbypp.adminmanagementms.model.Admin;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AdminService extends UserDetailsService {
    Admin add(Admin admin);

    public Optional<Admin> view(int adminId);

    public void deleteAdmin(int adminId);

    public Admin updateAdmin(int adminId,Admin admin);
}

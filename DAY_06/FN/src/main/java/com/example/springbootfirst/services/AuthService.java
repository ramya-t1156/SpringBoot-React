package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private RegisterDetailsRepository regRepo;

    public List<RegisterDetails> getRegisterDetails() {
        return regRepo.findAll();
    }

    public String addNewUser(RegisterDetails register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setName(register.getName());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(register.getPassword());
        registerDetails.setRole(register.getRole());
        registerDetails.setGender(register.getGender());
        registerDetails.setDateOfBirth(register.getDateOfBirth());
        regRepo.save(registerDetails);
        return "User registered successfully!";
    }

    public String authenticate(RegisterDetails login) {
        RegisterDetails user = (RegisterDetails) regRepo.findByEmail(login.getEmail());
        if(user != null){
            if(user.getPassword().equals(login.getPassword())){
                return "User logged in successfully!";
            }
        }
        return "User Login Failed!";
    }
}

package com.rohit.accounts.service;

import java.util.List;

import com.rohit.accounts.dto.SampleUserDto;
import com.rohit.accounts.entity.SampleUserAccountWithJPA;
import com.rohit.accounts.repository.SampleUserAccountsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
@Slf4j
public class SampleUserAccountService {

    // hashing the password
  // to use this we need to add deoendecy org.springframework.security:spring-security-crypto
    // // strength=12 is a good balance of security & performance
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    private final SampleUserAccountsRepository sampleUserAccountsRepository;

    public void save(SampleUserDto sampleUserDto) {

        SampleUserAccountWithJPA sampleUserAccountWithJPA = SampleUserAccountWithJPA.builder()
                .username(sampleUserDto.getUserName())
                .email(sampleUserDto.getEmail())
                .password(passwordEncoder.encode(sampleUserDto.getPassword())).build();

        // dont do this ever -- just for exampl purpose
        log.info("Saving account with password{}", sampleUserAccountWithJPA.getPassword());

        sampleUserAccountsRepository.save(sampleUserAccountWithJPA);

    }

    // checking The Query Paramater

    public SampleUserAccountWithJPA findByUsername(String username) {
        List<SampleUserAccountWithJPA>  users = sampleUserAccountsRepository.findUsingUserName(username);
        return users.isEmpty() ? null : users.get(0);
    }
}

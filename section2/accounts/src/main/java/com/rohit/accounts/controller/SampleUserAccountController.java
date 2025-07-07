package com.rohit.accounts.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import com.rohit.accounts.dto.SampleUserDto;
import com.rohit.accounts.entity.SampleUserAccountWithJPA;
import com.rohit.accounts.repository.SampleUserAccountsRepository;
import com.rohit.accounts.service.SampleUserAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/usersample", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
public class SampleUserAccountController {

    private final SampleUserAccountService sampleUserAccountService;
    private final SampleUserAccountsRepository sampleUserAccountsRepository;

    @PostMapping
    public ResponseEntity saveSampleUser(@Valid @RequestBody SampleUserDto sampleUserDto) {
        sampleUserAccountService.save(sampleUserDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<SampleUserAccountWithJPA>> getSampleUsers() {

        return ResponseEntity.status(OK).body(sampleUserAccountsRepository.findAll());
    }
}

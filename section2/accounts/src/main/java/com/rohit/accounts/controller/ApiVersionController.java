package com.rohit.accounts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/version")
@RestController
public class ApiVersionController {

    // we can do api versioning when we have new features and makes sure not to disrupt the old one
    // without affecting the client also used in feature flags

    //1. uri versiong from v1-v2

    // 2 param versioning - http://localhost:8085/api/version/uri/users?version=1 or http://localhost:8085/api/version/uri/users?version=1

    @GetMapping(value = "/uri/users", params = "version=1")
    public ResponseEntity<String> getParamVersionV1() {

        return ResponseEntity.ok("Param Version 1");
    }

    @GetMapping(value = "/uri/users", params = "version=2")
    public ResponseEntity<String> getParamVersionV2() {

        return ResponseEntity.ok("Param Version 2");
    }

    //3 Header versioning
    // http://localhost:8085/api/version/uri/person In header section
    //                                                 key           value
    //                                                 X-API-VERSION 1

    @GetMapping(value = "/uri/person", headers = "X-API-VERSION=1")
    public ResponseEntity<String> getHeaderVersionV1() {

        return ResponseEntity.ok("Hell Header Version 1");
    }

    @GetMapping(value = "/uri/person", headers = "X-API-VERSION=2")
    public ResponseEntity<String> getHeaderVersionV2() {

        return ResponseEntity.ok("Hell Header Version 2");
    }


    // 4. Mime Type or Accept Header Versioning
    // http://localhost:8085/api/version/uri/mime IN header section
    //                                                 key           value
    //                                                 Accept       application/vnd.company.app-v2+json
    @GetMapping(value = "/uri/mime", produces = "application/vnd.company.app-v1+json")
    public ResponseEntity<String> getMimeTypeVersionV1() {
        return ResponseEntity.ok("Mime Type Version 1");
    }

    @GetMapping(value = "/uri/mime", produces = "application/vnd.company.app-v2+json")
    public ResponseEntity<String> getMimeTypeVersionV2() {
        return ResponseEntity.ok("Mime Type Version 2");
    }

}

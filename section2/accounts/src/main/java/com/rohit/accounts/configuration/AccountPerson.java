package com.rohit.accounts.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "accounts") // reading properties from application.props
public record AccountPerson(String name, String email, String phone) {

}

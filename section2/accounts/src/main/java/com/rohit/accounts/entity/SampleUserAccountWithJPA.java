package com.rohit.accounts.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user_accounts_sample",uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_name"),
        @UniqueConstraint(columnNames = "email")
})
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SampleUserAccountWithJPA {

    //  UUID primary key:
    //
    //    @GenericGenerator + UUIDGenerator gives each new UserAccount a globally unique UUID (v4) at insert time.
    //
    //    Perfect for horizontal scaling: no coordination required.


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 50)
    private String email;

    // WRITE_ONLY means Jackson will use it from incoming JSON, but never include in outgoing JSON
    // that is good for deserialization
    //@JsonProperty(access = WRITE_ONLY) ensures you can accept it in your REST signup request,
    // but Jackson will strip it out on any response.
    //
    //Safer than @JsonIgnore, since it still lets you bind JSON→Java.
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false, length = 100)
    private String password;





}

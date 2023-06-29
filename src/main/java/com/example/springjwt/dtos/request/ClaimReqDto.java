package com.example.springjwt.dtos.request;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Rabina Shrestha
 * @Date : 29/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ClaimReqDto {

    private  String token;
    private List<String> role;

}

package io.github.pj.cattletraceabilitybackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactoryUser {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
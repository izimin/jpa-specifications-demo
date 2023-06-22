package ru.izimin.jpaspecificationsdemo.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchRequest {

    private String name;
    private String phone;
    private String email;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthDate;
}

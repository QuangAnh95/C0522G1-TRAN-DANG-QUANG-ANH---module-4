package com.customer.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CustomerDto implements Validator {

    private int id;

    @NotEmpty
    @Size(min = 5,max = 45, message = "abc")
    private String name;

    @NotEmpty
    @Size(min = 10,max = 11,message = "xyz")
    private String phone;

    @Min(value = 18)
    private String age;

    @Email
    private String email;

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, String phone, String age, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

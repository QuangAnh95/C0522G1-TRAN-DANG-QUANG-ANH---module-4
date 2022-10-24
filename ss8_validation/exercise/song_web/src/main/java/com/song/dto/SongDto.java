package com.song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SongDto implements Validator {
    private int id;
    @NotEmpty
    @Size(min = 1,max = 800, message = "khong qua 800 ki tu")
    private String name;

    @NotEmpty
    @Size(min = 1,max = 300, message = "khong qua 300 ki tu")
    private String singer;

    @NotEmpty
    @Size(min = 1,max = 1000, message = "khong qua 1000 ki tu")
    private String type;

    public SongDto() {
    }

    public SongDto(String name, String singer, String type) {
        this.name = name;
        this.singer = singer;
        this.type = type;
    }


    public SongDto(int id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

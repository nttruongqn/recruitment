package com.example.recruitment.demo.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.example.recruitment.demo.dto.JobDto;


public class JobValidator {

    public static List<String> validate(JobDto jobDto) {
        List<String> errors = new ArrayList<>();

        if(jobDto == null) {
            errors.add("Empty job");
        }

        if(!StringUtils.hasLength(jobDto.getName())) {
            errors.add("Name can not be empty");
        }
        return errors;
    }
    
}

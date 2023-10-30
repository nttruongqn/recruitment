package com.example.recruitment.demo.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.example.recruitment.demo.dto.PositionDto;

public class PositionValidator {
     public static List<String> validate(PositionDto positionDto) {
        List<String> errors = new ArrayList<>();

        if(positionDto == null) {
            errors.add("Empty position");
        }

        if(!StringUtils.hasLength(positionDto.getName())) {
            errors.add("Name can not be empty");
        }
        return errors;
    }
}

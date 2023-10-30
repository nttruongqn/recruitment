package com.example.recruitment.demo.dto;

import java.util.UUID;

import com.example.recruitment.demo.entity.Position;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PositionDto {
    private UUID id;
    private String name;

    public PositionDto fromEntity(Position position) {
        if(position == null) {
            return null;
        }
        return PositionDto.builder()
        .id(position.getId())
        .name(position.getName())
        .build();
    }

    public Position toEntity(PositionDto positionDto) {
        if(positionDto == null) {
            return null;
        }

       Position position = new Position();
       position.setId(positionDto.getId());
       position.setName(positionDto.getName());
       return position;
    }

}

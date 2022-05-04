package com.example.client.webclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDto {
    private int id;
    private String title;
    private String contents;
    private LocalDateTime regDt;
    private LocalDateTime updDt;
}

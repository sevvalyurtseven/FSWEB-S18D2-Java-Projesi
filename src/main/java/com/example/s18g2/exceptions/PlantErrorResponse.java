package com.example.s18g2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PlantErrorResponse {
    private String message;
    private int status;
    private long timestamp;
}

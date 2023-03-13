package com.caito.sucursalradicacionms.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDTO {
    private int code;
    private LocalDateTime timestamp;
    private String message;
    private String path;
}

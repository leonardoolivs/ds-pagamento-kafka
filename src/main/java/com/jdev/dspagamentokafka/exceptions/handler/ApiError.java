package com.jdev.dspagamentokafka.exceptions.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private Instant timestamp;
    private Integer status;
    private String message;
    private String path;

}

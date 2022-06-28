package com.tom.selling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageUploadClientResponse {
    private Map<String, Object> data;
    private boolean success;
    private int status;
}

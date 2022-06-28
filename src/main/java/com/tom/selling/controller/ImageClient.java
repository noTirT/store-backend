package com.tom.selling.controller;

import com.tom.selling.model.ImageUploadClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "imgBB-client", url = "https://api.imgbb.com/1/upload")
public interface ImageClient {
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    ImageUploadClientResponse uploadImage(@RequestParam String key, @RequestParam String base64Image);
}

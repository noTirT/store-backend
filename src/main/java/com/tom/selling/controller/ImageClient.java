package com.tom.selling.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "imgBB-client", url = "https://api.imgbb.com/1/upload")
public interface ImageClient {
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> uploadImage(@RequestParam String key, @RequestParam String base64Image);
}

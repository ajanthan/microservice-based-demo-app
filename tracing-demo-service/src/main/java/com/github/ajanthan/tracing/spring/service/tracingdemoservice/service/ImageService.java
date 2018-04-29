package com.github.ajanthan.tracing.spring.service.tracingdemoservice.service;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@RestController

public class ImageService {
    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) throws IOException {
        InputStream file = getClass().getClassLoader().getResourceAsStream(  "static/"+id + ".jpg");

        if (file==null) {
            file = getClass().getClassLoader().getResourceAsStream(  "static/no-thumbnail.jpg");
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(IOUtils.toByteArray(file));
    }
}

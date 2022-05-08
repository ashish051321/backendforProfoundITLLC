package com.profounditllc.backendforwebsite.controllers;

import com.profounditllc.backendforwebsite.models.communication.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @GetMapping("/checksanity")
    public ResponseEntity<ServerResponse> checkSanity() {
        return new ResponseEntity<>(new ServerResponse("Things look fine", "Object content"), HttpStatus.OK);
    }
}

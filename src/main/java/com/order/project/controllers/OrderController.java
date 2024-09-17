package com.order.project.controllers;

import com.order.project.dto.request.OrderRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/")
@RequiredArgsConstructor

public class OrderController {

    @PostMapping
    public ResponseEntity<String> createOrder (@Valid OrderRequestDTO request){

        return new ResponseEntity<String>("teste", HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<String> getOrderInformation (){

        return new ResponseEntity<String>("teste", HttpStatus.OK);

    }
}
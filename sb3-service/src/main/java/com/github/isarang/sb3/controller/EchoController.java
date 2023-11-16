package com.github.isarang.sb3.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EchoController {

  @Operation
  @GetMapping("/echo")
  String echo() {
    return "echo";
  }
}

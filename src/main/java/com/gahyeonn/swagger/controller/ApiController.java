package com.gahyeonn.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@Api(tags = "swagger 사용 Controller")
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/plus/{x}")
    public int plus(@ApiParam(value = "x 값") @PathVariable int x, @ApiParam(value = "y 값") @RequestParam int y){
        return x+y;
    }
}

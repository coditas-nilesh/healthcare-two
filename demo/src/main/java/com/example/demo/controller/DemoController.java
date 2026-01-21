package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Demo")
public class DemoController {

    @Operation(summary = "Get Demo Message", description = "This API returns a demo message for testing purposes.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Demo message returned successfully."),
            @ApiResponse(responseCode = "400", description = "Bad request."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    @GetMapping
    public String getDemoMessage() {
        if (true) { // Simulating a condition for an exception
            throw new DemoException("Something went wrong with the demo!");
        }
        return "This is a demo API response!";
    }


}
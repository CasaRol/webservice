package com.casarol.webservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class MainController {

    @GetMapping(value="/open")
    public String openEndpoint() {
        return "Open";
    }

    @GetMapping(value="/validation")
    @ValidateToken
    public String closedEndpoint(@RequestParam(value="token") String token) {
        return "Closed";
    }
}

package io.flats.controller;

import io.flats.dto.BasicResponce;
import io.flats.dto.ResponceCompletedDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class restfull {
    protected String response;

    @RequestMapping("/ping")
    @ResponseBody
    public ResponseEntity<BasicResponce> returnPong() {
        return ResponseEntity.ok(new ResponceCompletedDto());
    }

}

package com.miraknowledge.api.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/knowledge")
public class KnowledgeController {
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public String findAll(@RequestParam MultiValueMap<String, String> params) {
        return "ok";
    }
}

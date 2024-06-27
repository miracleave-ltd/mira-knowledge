package com.miraknowledge.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.miraknowledge.api.validator.OpinionValidator;
import com.miraknowledge.api.object.request.OpinionCreateRequest;
import com.miraknowledge.api.service.OpinionService;

import lombok.RequiredArgsConstructor;

/**
 * 意見 コントローラ
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/knowledge/{knowledgeId}/opinions")
public class OpinionController {
    private final OpinionValidator validator;
    private final OpinionService service;

    /**
     * 意見新規作成
     * @param knowledgeId ナレッジID
     * @param opinionCreateRequest 意見新規作成 リクエスト
     */
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@PathVariable Integer knowledgeId, @RequestBody OpinionCreateRequest opinionCreateRequest) {
        opinionCreateRequest.setKnowledgeId(knowledgeId);
        validator.validateCreate(opinionCreateRequest);
        service.create(opinionCreateRequest);
    }
}

package com.miraknowledge.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.miraknowledge.api.object.request.KnowledgeCreateRequest;
import com.miraknowledge.api.object.response.KnowledgeListResponse;
import com.miraknowledge.api.object.response.KnowledgeResponse;
import com.miraknowledge.api.service.KnowledgeService;
import com.miraknowledge.api.validator.KnowledgeValidator;

import lombok.RequiredArgsConstructor;

/**
 * ナレッジ コントローラ
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/knowledge")
@CrossOrigin(origins = "*")
public class KnowledgeController {
    private final KnowledgeValidator validator;
    private final KnowledgeService service;

    /**
     * ナレッジ一覧取得
     * @return
     */
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<KnowledgeListResponse> findAll() {
        return service.findAll();
    }

    /**
     * ナレッジ情報取得
     * @param knowledgeId ナレッジID
     * @return
     */
    @GetMapping("/{knowledgeId}")
    @ResponseStatus(code = HttpStatus.OK)
    public KnowledgeResponse findById(@PathVariable Integer knowledgeId) {
        validator.validateFindById(knowledgeId);
        return service.findById(knowledgeId);
    }

    /**
     * ナレッジ新規作成
     * @param knowledgeCreateRequest ナレッジ新規作成 リクエスト
     */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody KnowledgeCreateRequest knowledgeCreateRequest) {
        validator.validateCreate(knowledgeCreateRequest);
        service.create(knowledgeCreateRequest);
    }
}
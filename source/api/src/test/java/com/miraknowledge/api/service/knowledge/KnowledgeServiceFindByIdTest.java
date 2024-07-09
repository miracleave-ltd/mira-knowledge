package com.miraknowledge.api.service.knowledge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.object.response.KnowledgeResponse;
import com.miraknowledge.api.object.response.OpinionResponse;
import com.miraknowledge.api.repository.KnowledgeRepository;
import com.miraknowledge.api.service.KnowledgeService;

@ExtendWith(MockitoExtension.class)
public class KnowledgeServiceFindByIdTest {
    @InjectMocks
    KnowledgeService knowledgeService;
    @Mock
    KnowledgeRepository knowledgeRepository;

    /**
     * 取得
     */
    @Test
    public void testGet() {
        // 引数
        Integer knowledgeId = 1;
        // リポジトリ取得
        KnowledgeEntity entity = KnowledgeEntity
            .builder()
            .id(1)
            .name("name1")
            .title("title1")
            .content("content1")
            .createdAt(LocalDateTime.of(2023, 10, 12, 1, 23, 45))
            .updatedAt(LocalDateTime.of(2024, 12, 31, 23, 59, 59))
            .opinionEntities(null)
            .build();
        // 期待値
        KnowledgeResponse expected = KnowledgeResponse
            .builder()
            .id(1)
            .name("name1")
            .title("title1")
            .content("content1")
            .createdAt(LocalDateTime.of(2023, 10, 12, 1, 23, 45))
            .updatedAt(LocalDateTime.of(2024, 12, 31, 23, 59, 59))
            .opinions(new ArrayList<OpinionResponse>())
            .build();

        // テスト
        doReturn(entity).when(knowledgeRepository).findById(knowledgeId);
        KnowledgeResponse actual = knowledgeService.findById(knowledgeId);
        assertEquals(expected, actual);
    }

    /**
     * isEmpty
     */
    @Test
    public void testEmpty() {
        // 引数
        Integer knowledgeId = 0;
        // リポジトリ取得
        KnowledgeEntity entity = KnowledgeEntity
            .builder()
            .build();
        // 期待値
        KnowledgeResponse expected = KnowledgeResponse
            .builder()
            .opinions(new ArrayList<OpinionResponse>())
            .build();

        // テスト
        doReturn(entity).when(knowledgeRepository).findById(knowledgeId);
        KnowledgeResponse actual = knowledgeService.findById(knowledgeId);
        assertEquals(expected, actual);
    }

    /**
     * isNull
     */
    @Test
    public void testNull() {
        // 引数
        Integer knowledgeId = -1;
        // リポジトリ取得
        KnowledgeEntity entity = null;
        // 期待値
        String expected = null;

        // テスト
        doReturn(entity).when(knowledgeRepository).findById(knowledgeId);
        String actual = assertThrows(NullPointerException.class, () -> knowledgeService.findById(knowledgeId)).getMessage();
        assertEquals(expected, actual);
    }

    /**
     * 引数がNULL
     */
    @Test
    public void testNullKnowledgeId() {
        // 引数
        Integer knowledgeId = null;
        // 期待値
        String expected = null;

        // テスト
        String actual = assertThrows(IllegalArgumentException.class, () -> knowledgeService.findById(knowledgeId)).getMessage();
        assertEquals(expected, actual);
    }
}

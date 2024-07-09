package com.miraknowledge.api.service.opinion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.object.request.OpinionCreateRequest;
import com.miraknowledge.api.repository.KnowledgeRepository;
import com.miraknowledge.api.repository.OpinionRepository;
import com.miraknowledge.api.service.OpinionService;

@ExtendWith(MockitoExtension.class)
public class OpinionServiceCreateTest {
    @InjectMocks
    OpinionService opinionService;
    @Mock
    KnowledgeRepository knowledgeRepository;
    @Mock
    OpinionRepository opinionRepository;

    /**
     * 作成
     */
    @Test
    public void testCreate() {
        // 引数
        OpinionCreateRequest opinionCreateRequest = OpinionCreateRequest
            .builder()
            .knowledgeId(10)
            .name("name1")
            .content("content1")
            .build();
        // リポジトリ取得
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .id(10)
            .name("name1")
            .title("title1")
            .content("content1")
            .createdAt(LocalDateTime.of(2023, 10, 12, 1, 23, 45))
            .updatedAt(LocalDateTime.of(2024, 12, 31, 23, 59, 59))
            .build();

        doReturn(knowledgeEntity).when(knowledgeRepository).findById(opinionCreateRequest.getKnowledgeId());
        try {
            opinionService.create(opinionCreateRequest);
        }
        catch (Exception ex) {
            fail(ex);
        }
    }

    /**
     * isNull
     */
    @Test
    public void testNullKnowledgeEntity() {
        // 引数
        OpinionCreateRequest opinionCreateRequest = OpinionCreateRequest
            .builder()
            .knowledgeId(-1)
            .name("name1")
            .content("content1")
            .build();
        // リポジトリ取得
        KnowledgeEntity knowledgeEntity = null;
        // 期待値
        String expected = null;

        // テスト
        doReturn(knowledgeEntity).when(knowledgeRepository).findById(opinionCreateRequest.getKnowledgeId());
        String actual = assertThrows(NullPointerException.class, () -> opinionService.create(opinionCreateRequest)).getMessage();
        assertEquals(expected, actual);
    }

    /**
     * isNull
     */
    @Test
    public void testNullOpinionCreateRequest() {
        // 引数
        OpinionCreateRequest opinionCreateRequest = null;
        // 期待値
        String expected = null;

        // テスト
        String actual = assertThrows(NullPointerException.class, () -> opinionService.create(opinionCreateRequest)).getMessage();
        assertEquals(expected, actual);
    }
}

package com.miraknowledge.api.service.knowledge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.object.request.KnowledgeCreateRequest;
import com.miraknowledge.api.repository.KnowledgeRepository;
import com.miraknowledge.api.service.KnowledgeService;

@ExtendWith(MockitoExtension.class)
public class KnowledgeServiceCreateTest {
    @InjectMocks
    KnowledgeService knowledgeService;
    @Mock
    KnowledgeRepository knowledgeRepository;

    /**
     * 作成
     */
    @Test
    public void testCreate() {
        // 引数
        KnowledgeCreateRequest knowledgeCreateRequest = KnowledgeCreateRequest
            .builder()
            .name("name1")
            .title("title1")
            .content("content1")
            .build();

        // テスト
        try {
            knowledgeService.create(knowledgeCreateRequest);
        }
        catch (Exception ex) {
            fail(ex);
        }
    }

    /**
     * isNull
     */
    @Test
    public void testNull() {
        // 引数
        KnowledgeCreateRequest knowledgeCreateRequest = null;
        // 期待値
        String expected = null;

        // テスト
        String actual = assertThrows(NullPointerException.class, () -> knowledgeService.create(knowledgeCreateRequest)).getMessage();
        assertEquals(expected, actual);
    }
}

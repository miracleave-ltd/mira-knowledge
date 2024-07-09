package com.miraknowledge.api.service.knowledge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.object.response.KnowledgeListResponse;
import com.miraknowledge.api.repository.KnowledgeRepository;
import com.miraknowledge.api.service.KnowledgeService;

@ExtendWith(MockitoExtension.class)
public class KnowledgeServiceFindAllTest {
    @InjectMocks
    KnowledgeService knowledgeService;
    @Mock
    KnowledgeRepository knowledgeRepository;

    /**
     * 取得
     */
    @Test
    public void testList() {
        // リポジトリ取得
        List<KnowledgeEntity> entities = List.of(
            KnowledgeEntity.builder().build(),
            KnowledgeEntity
                .builder()
                .id(1)
                .name("name1")
                .title("title1")
                .content("content1")
                .createdAt(LocalDateTime.of(2023, 10, 12, 1, 23, 45))
                .updatedAt(LocalDateTime.of(2024, 12, 31, 23, 59, 59))
                .build(),
            KnowledgeEntity
                .builder()
                .id(2)
                .name("name2")
                .title("title2")
                .content("content2")
                .createdAt(LocalDateTime.of(2024, 10, 12, 1, 23, 45))
                .updatedAt(null)
                .build()
        );
        // 期待値
        List<KnowledgeListResponse> expected = List.of(
            KnowledgeListResponse.builder().build(),
            KnowledgeListResponse
                .builder()
                .id(1)
                .name("name1")
                .title("title1")
                .content("content1")
                .latestAt(LocalDateTime.of(2024, 12, 31, 23, 59, 59))
                .build(),
            KnowledgeListResponse
                .builder()
                .id(2)
                .name("name2")
                .title("title2")
                .content("content2")
                .latestAt(LocalDateTime.of(2024, 10, 12, 1, 23, 45))
                .build()
        );

        // テスト
        doReturn(entities).when(knowledgeRepository).findAll();
        List<KnowledgeListResponse> actual = knowledgeService.findAll();
        assertEquals(expected, actual);
    }

    /**
     * isEmpty
     */
    @Test
    public void testEmpty() {
        // リポジトリ取得
        List<KnowledgeEntity> entities = List.of();
        // 期待値
        List<KnowledgeListResponse> expected = List.of();

        // テスト
        doReturn(entities).when(knowledgeRepository).findAll();
        List<KnowledgeListResponse> actual = knowledgeService.findAll();
        assertEquals(expected, actual);
    }

    /**
     * isNull
     */
    @Test
    public void testNull() {
        // リポジトリ取得
        List<KnowledgeEntity> entities = null;
        // 期待値
        List<KnowledgeListResponse> expected = List.of();

        // テスト
        doReturn(entities).when(knowledgeRepository).findAll();
        List<KnowledgeListResponse> actual = knowledgeService.findAll();
        assertEquals(expected, actual);
    }
}

package com.miraknowledge.api.repository.impl.knowledge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.repository.impl.KnowledgeRepositoryImpl;
import com.miraknowledge.api.repository.jpa.KnowledgeJpaRepository;

@ExtendWith(MockitoExtension.class)
public class KnowledgeRepositoryImplFindAllTest {
    @InjectMocks
    private KnowledgeRepositoryImpl knowledgeRepositoryImpl;
    @Mock
    private KnowledgeJpaRepository knowledgeJpaRepository;

    /**
     * ソートされて返ってくることの確認は実テストで実施
     * JPAの引数とかが良くないのでマネしないこと
     */

    /**
     * 取得
     */
    @Test
    public void testList() {
        // 期待値
        List<KnowledgeEntity> expected = List.of(
            KnowledgeEntity
                .builder()
                .id(2)
                .createdAt(LocalDateTime.of(2024, 12, 31, 23, 59, 59))
                .build(),
            KnowledgeEntity
                .builder()
                .id(1)
                .createdAt(LocalDateTime.of(2023, 10, 12, 1, 23, 45))
                .build()
        );

        // テスト
        doReturn(expected).when(knowledgeJpaRepository).findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        List<KnowledgeEntity> actual = knowledgeRepositoryImpl.findAll();
        assertEquals(expected, actual);
    }

    /**
     * isEmpty
     */
    @Test
    public void testEmpty() {
        // 期待値
        List<KnowledgeEntity> expected = List.of();

        // テスト
        doReturn(expected).when(knowledgeJpaRepository).findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        List<KnowledgeEntity> actual = knowledgeRepositoryImpl.findAll();
        assertEquals(expected, actual);
    }

    /**
     * isNull
     */
    @Test
    public void testNull() {
        // 期待値
        List<KnowledgeEntity> expected = null;

        // テスト
        doReturn(expected).when(knowledgeJpaRepository).findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        List<KnowledgeEntity> actual = knowledgeRepositoryImpl.findAll();
        assertEquals(expected, actual);
    }
}

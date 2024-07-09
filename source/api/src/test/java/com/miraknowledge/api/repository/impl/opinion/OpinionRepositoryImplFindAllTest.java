package com.miraknowledge.api.repository.impl.opinion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import com.miraknowledge.api.object.entity.OpinionEntity;
import com.miraknowledge.api.repository.impl.OpinionRepositoryImpl;
import com.miraknowledge.api.repository.jpa.KnowledgeJpaRepository;
import com.miraknowledge.api.repository.jpa.OpinionJpaRepository;

@ExtendWith(MockitoExtension.class)
public class OpinionRepositoryImplFindAllTest {
    @InjectMocks
    private OpinionRepositoryImpl opinionRepositoryImpl;
    @Mock
    private KnowledgeJpaRepository knowledgeJpaRepository;
    @Mock
    private OpinionJpaRepository opinionJpaRepository;

    /**
     * ソートされて返ってくることの確認は実テストで実施
     * JPAの引数とかが良くないのでマネしないこと
     */

    /**
     * 取得
     */
    @Test
    public void testList() {
        // 引数
        Integer knowledgeId = 10;
        // 期待値
        List<OpinionEntity> expected = List.of(
            OpinionEntity
                .builder()
                .id(1)
                .knowledgeEntity(KnowledgeEntity.builder().id(knowledgeId).build())
                .name("name1")
                .content("content1")
                .createdAt(LocalDateTime.of(2023, 10, 12, 1, 23, 45))
                .build(),
            OpinionEntity
                .builder()
                .id(2)
                .knowledgeEntity(KnowledgeEntity.builder().id(knowledgeId).build())
                .name("name2")
                .content("content2")
                .createdAt(LocalDateTime.of(2024, 12, 31, 23, 59, 59))
                .build()
        );

        // テスト
        doReturn(expected).when(opinionJpaRepository).findAll(Sort.by(Sort.Direction.ASC, "id"));
        List<OpinionEntity> actual = opinionRepositoryImpl.findAll(knowledgeId);
        assertEquals(expected, actual);
    }

    /**
     * isEmpty
     */
    @Test
    public void testEmpty() {
        // 引数
        Integer knowledgeId = -1;
        // 期待値
        List<KnowledgeEntity> expected = List.of();

        // テスト
        doReturn(expected).when(opinionJpaRepository).findAll(Sort.by(Sort.Direction.ASC, "id"));
        List<OpinionEntity> actual = opinionRepositoryImpl.findAll(knowledgeId);
        assertEquals(expected, actual);
    }

    /**
     * isNull
     */
    @Test
    public void testNull() {
        // 引数
        Integer knowledgeId = null;
        // 期待値
        String expected = null;

        // テスト
        String actual = assertThrows(IllegalArgumentException.class, () -> opinionRepositoryImpl.findAll(knowledgeId)).getMessage();
        assertEquals(expected, actual);
    }
}

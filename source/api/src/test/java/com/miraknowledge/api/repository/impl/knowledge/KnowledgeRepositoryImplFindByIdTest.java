package com.miraknowledge.api.repository.impl.knowledge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.repository.impl.KnowledgeRepositoryImpl;
import com.miraknowledge.api.repository.jpa.KnowledgeJpaRepository;

@ExtendWith(MockitoExtension.class)
public class KnowledgeRepositoryImplFindByIdTest {
    @InjectMocks
    private KnowledgeRepositoryImpl knowledgeRepositoryImpl;
    @Mock
    private KnowledgeJpaRepository knowledgeJpaRepository;

    /**
     * 取得
     */
    @Test
    public void testGet() {
        // 引数
        Integer knowledgeId = 1;
        // リポジトリ取得
        KnowledgeEntity knowledgeEntity = KnowledgeEntity.builder().build();
        Optional<KnowledgeEntity> optional = Optional.ofNullable(knowledgeEntity);
        // 期待値
        KnowledgeEntity expected = knowledgeEntity;

        // テスト
        doReturn(optional).when(knowledgeJpaRepository).findById(knowledgeId);
        KnowledgeEntity actual = knowledgeRepositoryImpl.findById(knowledgeId);
        assertEquals(expected, actual);
    }

    /**
     * isEmpty
     */
    @Test
    public void testEmpty() {
        // 引数
        Integer knowledgeId = 1;
        // リポジトリ取得
        Optional<KnowledgeEntity> optional = Optional.empty();
        // 期待値
        KnowledgeEntity expected = null;

        // テスト
        doReturn(optional).when(knowledgeJpaRepository).findById(knowledgeId);
        KnowledgeEntity actual = knowledgeRepositoryImpl.findById(knowledgeId);
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
        String actual = assertThrows(IllegalArgumentException.class, () -> knowledgeRepositoryImpl.findById(knowledgeId)).getMessage();
        assertEquals(expected, actual);
    }
}

package com.miraknowledge.api.repository.impl.opinion;

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
import com.miraknowledge.api.object.entity.OpinionEntity;
import com.miraknowledge.api.repository.impl.OpinionRepositoryImpl;
import com.miraknowledge.api.repository.jpa.KnowledgeJpaRepository;
import com.miraknowledge.api.repository.jpa.OpinionJpaRepository;

@ExtendWith(MockitoExtension.class)
public class OpinionRepositoryImplCreateTest {
    @InjectMocks
    private OpinionRepositoryImpl opinionRepositoryImpl;
    @Mock
    private KnowledgeJpaRepository knowledgeJpaRepository;
    @Mock
    private OpinionJpaRepository opinionJpaRepository;

    /**
     * 作成
     */
    @Test
    public void testCreate() {
        // 引数
        OpinionEntity opinionEntity = OpinionEntity
            .builder()
            .knowledgeEntity(KnowledgeEntity.builder().id(10).build())
            .name("name")
            .content("content")
            .createdAt(LocalDateTime.now())
            .build();

        // テスト
        try {
            doReturn(true).when(knowledgeJpaRepository).existsById(opinionEntity.getKnowledgeEntity().getId());
            doReturn(opinionEntity).when(opinionJpaRepository).save(opinionEntity);
            opinionRepositoryImpl.create(opinionEntity);
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
        OpinionEntity opinionEntity = null;
        // 期待値
        String expected = null;

        // テスト
        String actual = assertThrows(IllegalArgumentException.class, () -> opinionRepositoryImpl.create(opinionEntity)).getMessage();
        assertEquals(expected, actual);
    }
}

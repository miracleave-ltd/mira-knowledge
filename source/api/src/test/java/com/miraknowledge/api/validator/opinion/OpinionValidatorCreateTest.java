// package com.miraknowledge.api.validator.opinion;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.fail;
// import static org.mockito.Mockito.doReturn;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
// import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.context.ConfigurableApplicationContext;
// import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
// import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;

// import com.miraknowledge.api.exception.BadRequestException;
// import com.miraknowledge.api.object.request.OpinionCreateRequest;
// import com.miraknowledge.api.repository.KnowledgeRepository;
// import com.miraknowledge.api.validator.OpinionValidator;

// import jakarta.validation.Validation;
// import jakarta.validation.Validator;

// @ExtendWith(MockitoExtension.class)
// @SpringBootTest
// public class OpinionValidatorCreateTest {
//     @Autowired
//     private ConfigurableApplicationContext applicationContext;
//     @Mock
//     private KnowledgeRepository knowledgeRepository;
//     private OpinionValidator opinionValidator;
//     //private Validator validator;
//     private LocalValidatorFactoryBean validator;


//     @BeforeEach
//     public void setUp() {
//         SpringConstraintValidatorFactory springConstraintValidatorFactory = new SpringConstraintValidatorFactory(applicationContext.getAutowireCapableBeanFactory());
//         validator = new LocalValidatorFactoryBean();
//         validator.setConstraintValidatorFactory(springConstraintValidatorFactory);
//         validator.setApplicationContext(applicationContext);
//         validator.afterPropertiesSet();
//         validator.setValidationMessageSource(applicationContext);

//         //validator = Validation.buildDefaultValidatorFactory().getValidator();
//         opinionValidator = new OpinionValidator(validator);
//     }

//     /**
//      * 正常
//      */
//     @Test
//     public void testOK() {
//         // 引数
//         OpinionCreateRequest opinionCreateRequest = OpinionCreateRequest
//             .builder()
//             .knowledgeId(10)
//             .name("name")
//             .content("content")
//             .build();

//         doReturn(true).when(knowledgeRepository).existsById(opinionCreateRequest.getKnowledgeId());

//         // テスト
//         try {
//             opinionValidator.validateCreate(opinionCreateRequest);
//         }
//         catch (Exception ex) {
//             fail(ex);
//         }
//     }

//     /**
//      * 異常
//      */
//     @Test
//     public void testNG() {
//         // 引数
//         OpinionCreateRequest opinionCreateRequest = OpinionCreateRequest.builder().build();
//         // 期待値
//         String expected = "Bad Request.";

//         // テスト
//         String actual = assertThrows(BadRequestException.class, () -> opinionValidator.validateCreate(opinionCreateRequest)).getMessage();
//         assertEquals(expected, actual);
//     }

//     /**
//      * isNull
//      */
//     @Test
//     public void testNull() {
//         // 引数
//         OpinionCreateRequest opinionCreateRequest = null;
//         // 期待値
//         String expected = "Bad Request.";

//         // テスト
//         String actual = assertThrows(BadRequestException.class, () -> opinionValidator.validateCreate(opinionCreateRequest)).getMessage();
//         assertEquals(expected, actual);
//     }
// }

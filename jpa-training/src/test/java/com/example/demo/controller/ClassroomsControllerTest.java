package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@ExtendWith(SpringExtension.class)
class ClassroomsControllerTest {
  /**
   * MockMvc.
   */
  private MockMvc mockMvc;

  /**
   * ObjectMapper.
   */
  private ObjectMapper mapper;

  @Mock
  private ClassroomsController controller;

  /**
   * setup.
   */
  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
        false);
    final JavaTimeModule javaTimeModule = new JavaTimeModule();
    mapper.registerModule(javaTimeModule);
  }

  /**
   * 教室初期データ登録.
   *
   * @test positive
   * @test.premised 正常系
   * @test.expected HTTPステータスコード200が返却される
   * @throws Throwable general
   */
  @Test
  public void positiveClassroomsInit() throws Throwable {
    // request.

    // execution.
    mockMvc.perform(post("/classrooms/init")
        // .content(mapper.writeValueAsString(request))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)).andDo(print())
        // assertions.
        .andExpect(status().isOk());
  }

  /**
   * 教室初期データ登録.
   *
   * @test positive
   * @test.premised 正常系
   * @test.expected HTTPステータスコード200が返却される
   * @throws Throwable general
   */
  @Test
  public void positiveClassrooms() throws Throwable {
    // request.

    // execution.
    mockMvc.perform(get("/classrooms")
        // .content(mapper.writeValueAsString(request))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)).andDo(print())
        // assertions.
        .andExpect(status().isOk());
  }

}

package com.example.book;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;;

@WebMvcTest
@AutoConfigureMockMvc
public class WebMVCTest{
   @Autowired
   private MockMvc mockMvc;
   @MockBean
   private BookService mockBookService;
   @MockBean
   private BookRepository mockBookRepository;

   @Test
   public void shouldReturnAllBooks() throws Exception 
   {
      when(mockBookService.list())
      .thenReturn(List.of(
         new Book(1,"Book1","Author1"),
         new Book(1,"Book2","Author2")
         ));

      mockMvc.perform(get("/books"))
         .andDo(print())
         .andExpect(status().isOk()) //HTTP response code 200
         .andExpect(jsonPath("$.size()").value(2))
         .andExpect(jsonPath("$[0].title").value("Book1"))
         .andExpect(jsonPath("$[0].author").value("Author1"))
         .andExpect(jsonPath("$[1].title").value("Book2"))
         .andExpect(jsonPath("$[1].author").value("Author2"));     
   }  
}
package com.agisoft.graphql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class GraphqlApplicationTests {

    @Autowired
    MockMvc mockMvc;

//    @Test
//    void listFoods() throws Exception {
//        String expectedResponse = "{query: \"{hero{name}}\", variables: null}";
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/graphql")
//                                              .content("{\"query\":\"{ hero { name } }\"}")
//                                              .contentType(MediaType.APPLICATION_JSON)
//                                              .accept(MediaType.APPLICATION_JSON))
//               .andExpect(status().isOk())
//               .andExpect(content().json(expectedResponse))
//               .andReturn();
//    }


    @Test
    void testHello() throws Exception {
        String expectedResponse = "<h1>Hello</h1>";

        mockMvc.perform(MockMvcRequestBuilders.get("/hello").contentType(MediaType.APPLICATION_JSON)
                                              .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().string(expectedResponse))
               .andReturn();
    }
}

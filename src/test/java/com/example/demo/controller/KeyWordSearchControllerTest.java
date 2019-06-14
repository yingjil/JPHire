package com.example.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class KeyWordSearchControllerTest {
    @Autowired
    MockMvc mvc;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void searchByKeyWork() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/search/baidu").param("keyWord","编程")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}

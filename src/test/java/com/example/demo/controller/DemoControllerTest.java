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

/**
 * The demoControllerTest class for JPHire.
 *
 * @author zhangxiaozhi
 * @version 1.0, 2019/5/5
 * @since demo 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoControllerTest {

    @Autowired
    MockMvc mvc;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void demo() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/demo/report")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("Note: if you cannot finish the test, you may still get the chance to next step of the hiring process if some shinning points were identified from your work: if you finish the work, you may still fail because your outcome did not meet the hiring bar.\n" + "\n" + "Test Description: we want to build a solution to hire the right people quickly. The development work of this solution is part of the solution. As a candidate, please contribute your idea and finish the assignment.\n" + "\n" + "Definition of done:\n" + "1. In this Github(Name: JPHire) project, build a web server which can be run on any Linux box.\n" + "2. Use Java as the main development language unless there is a solid reason for other choice.\n" + "3. The main page of the website should display the content of the latest TestX file. The X will crease continuously.\n" + "4. The UT coverage must > 80% if not 100%.\n"));
    }
}
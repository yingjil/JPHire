package com.example.demo.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

/**
 * The DemoServiceTest class for JPHire.
 *
 * @author zhangxiaozhi
 * @version 1.0, 2019/5/5
 * @since JPHire 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoServiceTest {

    @Resource
    private DemoService demoService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void demo() {
        assertEquals(demoService.demo(), "Note: if you cannot finish the test, you may still get the chance to next step of the hiring process if some shinning points were identified from your work: if you finish the work, you may still fail because your outcome did not meet the hiring bar.\n" + "\n" + "Test Description: we want to build a solution to hire the right people quickly. The development work of this solution is part of the solution. As a candidate, please contribute your idea and finish the assignment.\n" + "\n" + "Definition of done:\n" + "1. In this Github(Name: JPHire) project, build a web server which can be run on any Linux box.\n" + "2. Use Java as the main development language unless there is a solid reason for other choice.\n" + "3. The main page of the website should display the content of the latest TestX file. The X will crease continuously.\n" + "4. The UT coverage must > 80% if not 100%.\n");
    }
}
package com.meteo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Matt on 03.06.2019 at 19:04.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void mainSlashTest() throws Exception {
        this.mvc.perform(get("/")).andExpect(status().is3xxRedirection());
    }

    @Test
    public void indexTest() throws Exception {
        this.mvc.perform(get("/index")).andExpect(status().isOk());
    }
}

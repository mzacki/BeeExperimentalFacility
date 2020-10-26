package com.bxf.controller;

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
 * Created by Matt on 03.07.2019 at 20:15.
 */
/*
    Tests the web layer only without starting a server. Uses Mock MVC.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DBControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void db() throws Exception {
        this.mvc.perform(get("/db")).andExpect(status().isOk());
    }

    @Test
    public void datatable() {
    }

    @Test
    public void listNucs() {
    }

    @Test
    public void queenList() {
    }

    @Test
    public void showAddForm() {
    }

    @Test
    public void showUpdateForm() {
    }

    @Test
    public void saveBeehive() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void queenDetails() {
    }

    @Test
    public void disableContract() {
    }

}
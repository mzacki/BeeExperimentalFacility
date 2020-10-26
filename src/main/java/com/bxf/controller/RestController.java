package com.bxf.controller;

import com.bxf.persistence.entity.Beehive;
import com.bxf.persistence.service.BeehiveService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Created by Matt on 27.05.2019 at 18:01.
 * REST controller for jquery datatables implementation.
 */

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final BeehiveService beehiveService;

    @Autowired
    public RestController(BeehiveService beehiveService) {
        this.beehiveService = beehiveService;
    }

    @RequestMapping(value = "/getList")
    public @ResponseBody
    List<Beehive> getList() {
        return beehiveService.findAll();
    }

    @GetMapping(value = "/beehive/{id}")
    public @ResponseBody
    Beehive getContractById(@PathVariable("id") long id) {
        return beehiveService.findByID(id);
    }

}

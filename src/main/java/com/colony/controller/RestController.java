package com.colony.controller;

import com.colony.persistence.entity.Beehive;
import com.colony.persistence.service.BeehiveService;
import com.colony.persistence.service.QueenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Created by Matt on 27.05.2019 at 18:01.
 * REST controller for jquery datatables implementation.
 */

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private BeehiveService beehiveService;
    private QueenService queenService;

    @Autowired
    public RestController(BeehiveService beehiveService, QueenService queenService) {
        this.beehiveService = beehiveService;
        this.queenService = queenService;
    }

    @RequestMapping(value = "/getList")
    public @ResponseBody
    List<Beehive> getList() {
        return beehiveService.findAll();
    }

    @RequestMapping(value = "/beehive/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Beehive getContractById(@PathVariable("id") long id) {
        return beehiveService.findByID(id);
    }
}

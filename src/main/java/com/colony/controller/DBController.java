package com.colony.controller;

import com.colony.persistence.entity.Beehive;
import com.colony.persistence.entity.Queen;
import com.colony.persistence.service.BeehiveService;
import com.colony.persistence.service.QueenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Matt on 14.06.2019 at 16:52.
 */

@Controller
public class DBController {


    private BeehiveService beehiveService;
    private QueenService queenService;

    @Autowired
    public DBController(BeehiveService beehiveService, QueenService queenService) {
        this.beehiveService = beehiveService;
        this.queenService = queenService;
    }

    @GetMapping("/db")
    public String db(Model model) {
        List<Beehive> beehives = beehiveService.findAll();
        model.addAttribute( "beehives", beehives);
        return "db";
    }

    @GetMapping("/datatable")
    public String datatable() {
        return "datatable";
    }

    @GetMapping("/listNucs")
    public String listNucs(Model model) {
        List<Beehive> beehives = beehiveService.findAllNucs();
        model.addAttribute("beehives", beehives);
        return "db";
    }

    @GetMapping("/queenList")
    public String queenList(Model model) {
        List<Queen> queens = queenService.findAll();
        model.addAttribute("queens", queens);
        return "queen-list";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model) {
        Beehive beehive = new Beehive();
        model.addAttribute("beehive", beehive);
        return "new-beehive-form";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("id") long id, Model model) {
        Beehive beehive = beehiveService.findByID(id);
        model.addAttribute("beehive", beehive);
        return "beehive-form";
    }

    @PostMapping("/save")
    public String saveBeehive(@ModelAttribute("beehive") Beehive beehive) {
        beehiveService.save(beehive);
        return "redirect:/db";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        beehiveService.deleteByID(id);
        return "redirect:/db";
    }

    @GetMapping("/queenDetails")
    public String queenDetails(Model model, long id) {
        Beehive beehive = beehiveService.findByID(id);
        model.addAttribute("beehive", beehive);
        return "queen-details";
    }

    @GetMapping("/disableNuc")
    public String disableContract(@RequestParam long id) {
        Beehive beehive = beehiveService.findByID(id);
      //  beehive.setNuc(false);
        beehiveService.save(beehive);
        return "redirect:/db";
    }


}

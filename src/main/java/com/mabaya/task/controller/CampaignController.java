package com.mabaya.task.controller;

import com.mabaya.task.dto.Campaign;
import com.mabaya.task.dto.CampaignInput;
import com.mabaya.task.dto.Product;
import com.mabaya.task.exceptions.DataNotFoundException;
import com.mabaya.task.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CampaignController extends ResponseEntityExceptionHandler {
    @Autowired
    private CampaignService campaignService;

    @GetMapping("/serveAd")
    public Product serveAd(@RequestParam(value = "name") String categoryName) {
            return campaignService.getServeAd(categoryName);
    }

    @PostMapping("/campaign")
    public Campaign addCampaign(@RequestBody CampaignInput campaignInput) {
        return campaignService.addCampaign(campaignInput);
    }


}


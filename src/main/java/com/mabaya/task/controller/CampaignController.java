package com.mabaya.task.controller;

import com.mabaya.task.dto.Campaign;
import com.mabaya.task.dto.CampaignInput;
import com.mabaya.task.dto.Product;
import com.mabaya.task.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @GetMapping("/serveAd")
    public Product serveAd(@RequestParam(value = "name") String categoryName) {
        return campaignService.getServeAd(categoryName);
    }
    @PostMapping("/campaign")
    public Campaign addCampaign(@RequestBody CampaignInput campaignInput)  {
        return campaignService.addCampaign(campaignInput);
    }
}


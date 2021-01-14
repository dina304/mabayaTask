package com.mabaya.task.service;

import com.mabaya.task.dto.Campaign;
import com.mabaya.task.dto.CampaignInput;
import com.mabaya.task.dto.Product;
import com.mabaya.task.model.Category;
import com.mabaya.task.model.DataConnector;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {


    public Product getServeAd(String categoryName) {
        return new Product("tets1", Category.SHOES.getId(),1.2);
    }

    public Campaign addCampaign(CampaignInput campaignInput) {
        Campaign campaign=new Campaign(campaignInput.getName(),campaignInput.getCategoryName(),campaignInput.getBid(),campaignInput.getStartDate());
        // this code simulate add to DB
        DataConnector.campaign.put(campaign.getId(),campaign);
        return campaign;
    }
}

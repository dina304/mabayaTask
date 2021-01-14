package com.mabaya.task.service;

import com.mabaya.task.dto.Campaign;
import com.mabaya.task.dto.CampaignInput;
import com.mabaya.task.dto.Product;
import com.mabaya.task.model.Category;
import com.mabaya.task.model.DataConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CampaignService {

    public Product getServeAd(String categoryName) throws Exception {
        Long currentDate = new Date().getTime() / 1000;
        int categoryId = Category.getIdByName(categoryName);
        Comparator<Campaign> comparator = Comparator.comparing(Campaign::getBid);
        Optional<Campaign> maxCamp = DataConnector.campaign.values().stream()
                .filter(campaign -> campaign.getCategoryId() == categoryId && campaign.getEndDate() > currentDate)
                .max(comparator);
        if (maxCamp.isPresent()) {
            return maxCamp.get().getCampaignProducts().get(0);
        } else {
            throw new Exception("Not fit");
        }
    }

    public Campaign addCampaign(CampaignInput campaignInput) {
        Campaign campaign = new Campaign(campaignInput.getName(), campaignInput.getCategoryName(), campaignInput.getBid(), campaignInput.getStartDate());
        // this code simulate add to DB
        DataConnector.campaign.put(campaign.getId(), campaign);
        return campaign;
    }
}

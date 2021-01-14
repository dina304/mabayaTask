package com.mabaya.task.dto;


import com.mabaya.task.model.Category;
import com.mabaya.task.model.DataConnector;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Getter
@Setter
public class Campaign extends CampaignInput {
    private UUID id;
    private int categoryId;
    private List<Product> campaignProducts;
    private Long endDate;

    public Campaign(String name, String categoryName, double bid, Long startDate) {
        super(name, categoryName, bid, startDate);
        this.id = UUID.randomUUID();
        this.categoryId = Category.getIdByName(categoryName);
        this.campaignProducts = getProductsByCategory(categoryId);
        LocalDate date = Instant.ofEpochSecond(this.getStartDate()).atZone(ZoneId.systemDefault()).toLocalDate();
        this.endDate=date.plusDays(10).atStartOfDay().atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    private List getProductsByCategory(int categoryId) {
        List products = new ArrayList<Product>();

        for (Product p:DataConnector.products.values()) {
            if (p.getCategoryId()==categoryId) {
                products.add(p);
            }
        }
        return products;
    }
}

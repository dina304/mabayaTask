package com.mabaya.task.dto;


import com.mabaya.task.model.Category;
import com.mabaya.task.model.DataConnector;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Campaign extends CampaignInput {
    private UUID id;
    private int categoryId;
    private List campaignProducts;
    private Long endDate;

    public Campaign(String name, String categoryName, double bid, Long startDate) {
        super(name, categoryName, bid, startDate);
        this.id = UUID.randomUUID();
        this.categoryId = Category.getIdByName(categoryName);
        this.campaignProducts = getProductsByCategory(categoryId);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(this.getStartDate()));
        c.add(Calendar.DAY_OF_MONTH,10);
        this.endDate=c.getTime().getTime();
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

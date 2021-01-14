package com.mabaya.task.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CampaignInput {
    private String name;
    private String categoryName;
    private double bid;
    private Long startDate;
}

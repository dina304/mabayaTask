package com.mabaya.task.model;

import com.mabaya.task.dto.Campaign;
import com.mabaya.task.dto.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataConnector {
    public static Map<UUID, Product> products=new HashMap<>() ;
    public static Map<UUID, Campaign> campaign=new HashMap<>() ;
}

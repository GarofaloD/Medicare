package com.garofalo.medicare_simplilearn_backend.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class PurchaseResponse {

    //used to hold a tracker number
    @NonNull
    private String orderTrackingNumber;

}

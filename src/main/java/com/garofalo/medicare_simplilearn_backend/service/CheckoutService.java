package com.garofalo.medicare_simplilearn_backend.service;

import com.garofalo.medicare_simplilearn_backend.dto.Purchase;
import com.garofalo.medicare_simplilearn_backend.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);


}

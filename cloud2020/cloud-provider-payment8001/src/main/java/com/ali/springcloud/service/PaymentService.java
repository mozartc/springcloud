package com.ali.springcloud.service;

import com.ali.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @auther mozartc
 * @create 2020/12/9 21:40
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}

package com.ali.springcloud.service.impl;

import com.ali.springcloud.dao.PaymentDao;
import com.ali.springcloud.entities.Payment;
import com.ali.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther mozartc
 * @create 2020/12/9 21:42
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}

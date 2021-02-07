package com.ali.springcloud.controller;

import com.ali.springcloud.entities.CommonResult;
import com.ali.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @auther mozartc
 * @create 2020/12/29 22:27
 */
@RestController
@Slf4j
public class OrderController {
    //public static final String PAYMENT_URL="http://localhost:8001";   //服务端单机
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";   //服务端集群，在eureka中注册的微服务名称，通过负载均衡分配

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}

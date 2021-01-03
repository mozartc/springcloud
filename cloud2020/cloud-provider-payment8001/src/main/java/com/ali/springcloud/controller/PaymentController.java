package com.ali.springcloud.controller;

import com.ali.springcloud.entities.CommonResult;
import com.ali.springcloud.entities.Payment;
import com.ali.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @auther mozartc
 * @create 2020/12/9 21:46
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("*****插入结果："+result);

        if(result >0){
            return new CommonResult(200,"插入数据库成功",result);
        }else{
            return new CommonResult(400,"插入数据库失败",null);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("*****查询结果："+payment);

        if(payment != null){
            return new CommonResult(200,"查询数据库成功",payment);
        }else{
            return new CommonResult(400,"查询数据库失败,id:"+id,null);
        }
    }
}
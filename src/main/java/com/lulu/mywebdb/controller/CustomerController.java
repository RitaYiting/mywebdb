package com.lulu.mywebdb.controller;

import com.lulu.mywebdb.model.Customer;
import com.lulu.mywebdb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public String showCustomers(Model model) {
        //CustomerService 要資料
        List<Customer> custs = customerService.getCustomerALL();
        //放入 model
        model.addAttribute("custs", custs);
        return "customer_list";
    }
    @GetMapping("/customer/register") //未來做專案時,儘量用這方式-->/customer/register,主要為了做分類,也是為了較好辨別,是哪個分類的程式
    public String toCustomer_Register(){
        return "customer_create";
    }
    @PostMapping("/customer/new")
    public String Customer_Result(){
        return "customer_reg_result";
    }

    //透過PostMan來測試api
    @GetMapping("/customer/test")
    public String Customer_gettest(Model model, @RequestParam String name, @RequestParam int num){
        model.addAttribute("param1",name);
        model.addAttribute("param2",num);
        return "customer_gettest";
    }
    @PostMapping("/customer/test")
    public String Customer_posttest(){
        return "customer_posttest";
    }
}
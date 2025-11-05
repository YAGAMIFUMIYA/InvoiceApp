package com.example.invoicesystem.controller;

import com.example.invoicesystem.entity.Customer;
import com.example.invoicesystem.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // 一覧表示
    @GetMapping
    public String list(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customer/list";
    }

    // 新規登録フォーム
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/form/form";
    }

    // 編集フォーム
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/form/form";
    }

    // 新規・更新共通保存
    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    // 更新専用（※必要なければ省略可）
    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer) {
        customerService.update(customer);
        return "redirect:/customers";
    }

    // 削除
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        customerService.delete(id);
        return "redirect:/customers";
    }
}

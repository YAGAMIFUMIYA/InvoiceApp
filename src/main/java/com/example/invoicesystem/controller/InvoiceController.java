package com.example.invoicesystem.controller;

import com.example.invoicesystem.entity.Invoice;
import com.example.invoicesystem.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    // 一覧表示
    @GetMapping
    public String list(Model model) {
        model.addAttribute("invoices", invoiceService.findAll());
        return "invoice/list";
    }

    // 新規登録フォーム
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("invoice", new Invoice());
        return "invoice/form";
    }

    // 編集フォーム
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Invoice invoice = invoiceService.findById(id);
        model.addAttribute("invoice", invoice);
        return "invoice/form";
    }

    // 保存処理（新規登録・更新兼用）
    @PostMapping("/save")
    public String save(@ModelAttribute Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    // 削除処理
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
}

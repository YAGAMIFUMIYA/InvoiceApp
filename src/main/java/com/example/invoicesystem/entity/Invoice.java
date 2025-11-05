package com.example.invoicesystem.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {

    private Long id;                 // 請求書ID
    private String invoiceNumber;    // 請求書番号
    private LocalDate issueDate;     // 発行日
    private LocalDate dueDate;       // 支払期限
    private Long customerId;         // 顧客ID（外部キー）
    private String description;      // 内容
    private BigDecimal amount;       // 金額
    private String status;           // 状態（例：未払い、支払済）

    // ====== Getter / Setter ======

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {   // ← getter
        return amount;
    }

    public void setAmount(BigDecimal amount) {   // ← setter
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ====== toString（デバッグ用） ======
    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", customerId=" + customerId +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}

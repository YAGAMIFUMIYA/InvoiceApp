package com.example.invoicesystem.mapper;

import com.example.invoicesystem.entity.Invoice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InvoiceMapper {

    @Select("SELECT * FROM invoices")
    List<Invoice> findAll();

    @Select("SELECT * FROM invoices WHERE id = #{id}")
    Invoice findById(Long id);

    @Insert("INSERT INTO invoices (customer_id, issue_date, due_date, amount, status) " +
            "VALUES (#{customerId}, #{issueDate}, #{dueDate}, #{amount}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Invoice invoice);

    @Update("UPDATE invoices SET customer_id=#{customerId}, issue_date=#{issueDate}, due_date=#{dueDate}, " +
            "amount=#{amount}, status=#{status} WHERE id=#{id}")
    void update(Invoice invoice);

    @Delete("DELETE FROM invoices WHERE id = #{id}")
    void delete(Long id);
}

package com.example.invoicesystem.mapper;

import com.example.invoicesystem.entity.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapper {

    @Select("SELECT * FROM customers ORDER BY id ASC")
    List<Customer> findAll();

    @Select("SELECT * FROM customers WHERE id = #{id}")
    Customer findById(Long id);

    @Insert("INSERT INTO customers (name, email, phone) VALUES (#{name}, #{email}, #{phone})")
    void insert(Customer customer);

    @Update("UPDATE customers SET name = #{name}, email = #{email}, phone = #{phone} WHERE id = #{id}")
    void update(Customer customer);

    @Delete("DELETE FROM customers WHERE id = #{id}")
    void delete(Long id);
}

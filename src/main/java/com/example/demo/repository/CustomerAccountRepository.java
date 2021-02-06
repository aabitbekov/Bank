package com.example.demo.repository;

import com.example.demo.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {

    List<CustomerAccount> findCustomerAccountsByUserId(long id);

    CustomerAccount findCustomerAccountById(long id);

}

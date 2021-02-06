package com.example.demo.service;

import com.example.demo.entity.CustomerAccount;
import com.example.demo.entity.Deposits;
import com.example.demo.entity.User;
import com.example.demo.entity.Withdrawals;
import com.example.demo.resources.UserCreateForm;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<com.example.demo.entity.User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
    List<CustomerAccount> findCustomerAccountById(long id);
    List<Withdrawals> findTransactionsByCustomerAccountId(long id);
    User registerUser(UserCreateForm userCreateForm);
    boolean hasValidPassword(User user, String pwd);
    List<Deposits> findTransactionsByAccountId(long id);
}

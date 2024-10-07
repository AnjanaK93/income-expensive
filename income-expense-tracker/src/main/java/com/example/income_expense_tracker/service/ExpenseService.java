package com.example.income_expense_tracker.service;

import com.example.income_expense_tracker.entity.Expense;
import com.example.income_expense_tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;


    public double getBalanceByDate(Date date){
        List<Expense> entries = expenseRepository.findByDate(date);
        double balance = 0;
        for(Expense exp: entries){
            if(exp.isExpense()){
                balance -= exp.getAmount();
            }
            else{
                balance += exp.getAmount();
            }
        }
        return balance;
    }

    public double getExpenseByPaymentMethod(String paymentMethod){
        List<Expense> entries = expenseRepository.findByPaymentMethod(paymentMethod);
        double balance = 0;
        for(Expense exp: entries){
            if(exp.isExpense()){
                balance -= exp.getAmount();
            }
            else{
                balance += exp.getAmount();
            }
        }
        return balance;
    }

    public Expense addExpense(Expense exp){
        return expenseRepository.saveAndFlush(exp);
    }
}


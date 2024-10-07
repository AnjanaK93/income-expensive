package com.example.income_expense_tracker.repository;

import com.example.income_expense_tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByDate(Date date);
    List<Expense> findByPaymentMethod(String paymentMethod);
}

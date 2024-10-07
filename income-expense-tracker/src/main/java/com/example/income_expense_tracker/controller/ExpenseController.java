package com.example.income_expense_tracker.controller;

import com.example.income_expense_tracker.entity.Expense;
import com.example.income_expense_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/balance/date")
    public ResponseEntity<Double> getBalanceByDate(@RequestParam("date") Date date) {
        double balance = expenseService.getBalanceByDate(date);
        return ResponseEntity.ok(balance);
    }

    @GetMapping("/balance/payment-method")
    public ResponseEntity<Double> getExpenseByPaymentMethod(@RequestParam("paymentMethod") String paymentMethod) {
        double balance = expenseService.getExpenseByPaymentMethod(paymentMethod);
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@Valid @RequestBody Expense expense) {
        Expense createdExpense = expenseService.addExpense(expense);
        return ResponseEntity.status(200).body(createdExpense);
    }
}


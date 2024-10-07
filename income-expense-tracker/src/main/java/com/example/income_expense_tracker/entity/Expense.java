package com.example.income_expense_tracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="expense_tracker")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="description")
    @NotNull
    private String description;

    @Column(name="date")
    @NotNull
    private Date date;

    @Column(name="amount")
    @NotNull
    @Min(value = 0, message = "amount should be greater than 0")
    private double amount;

    @Column(name="isExpense")
    @NotNull
    private boolean isExpense;

    @Column(name="payment_method")
    @NotNull
    @Pattern(regexp = "CASH|BANK")
    private String paymentMethod;

    
}

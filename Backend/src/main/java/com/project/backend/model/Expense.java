package com.project.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.project.backend.enums.ExpenseCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="expenses")
public class Expense {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long expenseId;
	 
	
	
	
	private String description;
	private BigDecimal amount;
    private LocalDate date;
    
    @Enumerated(EnumType.STRING)
    private ExpenseCategory category;
	
	
	 @ManyToOne
	 @JoinColumn(name = "user_id", nullable = false)
	 private User user;

}

package com.sg.bank.account.model;

import java.time.LocalDateTime;

import com.sg.bank.account.util.OperationTypesEnum;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author guesmi
 * @version : 1.0
 *
 */
@Data
@AllArgsConstructor
public class Transaction {

	private final double amount;
	private final OperationTypesEnum operationType;
	private final LocalDateTime transactionDate;
}

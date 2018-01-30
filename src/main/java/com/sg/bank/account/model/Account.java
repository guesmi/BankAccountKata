package com.sg.bank.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author guesmi
 * @version : 1.0
 *
 */
@Data
@AllArgsConstructor
public class Account {

	private double balance;
	private AccountStatement accountStatement;
}

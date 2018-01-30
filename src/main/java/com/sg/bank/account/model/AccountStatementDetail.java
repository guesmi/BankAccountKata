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
public class AccountStatementDetail {

	private Transaction transaction;
	private double acutalBalance;
}

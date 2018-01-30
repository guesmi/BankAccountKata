package com.sg.bank.account.service;

import com.sg.bank.account.model.Account;

/**
 * @author guesmi
 * @version : 1.0
 *
 */
public interface AccountService {

	/**
	 * Make a deposit on specific account
	 * 
	 * @param account
	 * @param amount
	 */
	void makeDeposit(Account account, double amount);

	/**
	 * Execute a withdraw on specific account
	 * 
	 * @param account
	 * @param amount
	 */
	void makeWithdrawal(Account account, double amount);

	/**
	 * Print the account statement
	 * 
	 * @param account
	 * @return
	 */
	String printAccountStatement(Account account);

}

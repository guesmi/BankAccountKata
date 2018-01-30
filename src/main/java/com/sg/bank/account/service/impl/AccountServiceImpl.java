package com.sg.bank.account.service.impl;

import java.time.LocalDateTime;

import com.sg.bank.account.exception.InvalidAccountParametersException;
import com.sg.bank.account.model.Account;
import com.sg.bank.account.model.AccountStatementDetail;
import com.sg.bank.account.model.Transaction;
import com.sg.bank.account.service.AccountService;
import com.sg.bank.account.util.ErrorMessages;
import com.sg.bank.account.util.OperationTypesEnum;
import com.sg.bank.account.util.StringFormatterUtil;

/**
 * @author guesmi
 * @version : 1.0
 *
 */
public class AccountServiceImpl implements AccountService {

	public void makeDeposit(Account account, double amount) {
		if (account == null || amount < 0) {
			throw new InvalidAccountParametersException(
					ErrorMessages.INVALID_ACCOUNT);
		} else {
			Transaction transaction = new Transaction(amount,
					OperationTypesEnum.DEPOSITE, LocalDateTime.now());
			AccountStatementDetail accountStatementDetail = new AccountStatementDetail(
					transaction, account.getBalance() + amount);
			account.setBalance(account.getBalance() + amount);
			account.getAccountStatement().addStatementDetail(
					accountStatementDetail);
		}
	}

	public void makeWithdrawal(Account account, double amount) {
		if (account == null || amount < 0) {
			throw new InvalidAccountParametersException(
					ErrorMessages.INVALID_ACCOUNT);
		} else {
			Transaction transaction = new Transaction(amount,
					OperationTypesEnum.WITHDRAWAL, LocalDateTime.now());
			AccountStatementDetail accountStatementDetail = new AccountStatementDetail(
					transaction, account.getBalance() - amount);
			account.setBalance(account.getBalance() - amount);
			account.getAccountStatement().addStatementDetail(
					accountStatementDetail);
		}
	}

	public String printAccountStatement(Account account) {
		String statement = null;
		if (account == null
				|| account.getAccountStatement().getStatementDetails() == null
				|| account.getAccountStatement().getStatementDetails()
						.isEmpty()) {
			throw new InvalidAccountParametersException(
					ErrorMessages.INVALID_STATEMENT_PRINT);
		} else {
			StringBuilder statementBuilder = new StringBuilder();
			statementBuilder.append(StringFormatterUtil.STATEMENT_HEADER);
			for (AccountStatementDetail detail : account.getAccountStatement()
					.getStatementDetails()) {
				statementBuilder.append(StringFormatterUtil
						.constructStatementDetailRow(detail.getTransaction()
								.getOperationType(), detail.getTransaction()
								.getTransactionDate(), detail.getTransaction()
								.getAmount(), detail.getAcutalBalance()));
			}
			statement = statementBuilder.toString();
		}
		return statement;
	}

}

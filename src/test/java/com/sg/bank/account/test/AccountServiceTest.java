package com.sg.bank.account.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.sg.bank.account.exception.InvalidAccountParametersException;
import com.sg.bank.account.model.Account;
import com.sg.bank.account.model.AccountStatement;
import com.sg.bank.account.model.AccountStatementDetail;
import com.sg.bank.account.model.Transaction;
import com.sg.bank.account.service.AccountService;
import com.sg.bank.account.service.impl.AccountServiceImpl;
import com.sg.bank.account.util.OperationTypesEnum;
import com.sg.bank.account.util.StringFormatterUtil;

public class AccountServiceTest {
	private final double INITIAL_BALANCE = 0.0;
	private final double DELTA = 0.0;
	private Account account;
	private AccountService accountService;

	@Before
	public void setup() {
		account = new Account(INITIAL_BALANCE, new AccountStatement());
		accountService = new AccountServiceImpl();
	}

	@Test
	public void makeDepositAccountTest() {
		account.setBalance(1000);
		accountService.makeDeposit(account, 500);
		assertEquals(account.getBalance(), 1500, DELTA);
	}

	@Test
	public void makeWithDrawalAccountTest() {
		account.setBalance(1800);
		accountService.makeWithdrawal(account, 800);
		assertEquals(account.getBalance(), 1000, DELTA);
	}

	@Test
	public void printAccountStatementTest() {

		account = new Account(INITIAL_BALANCE, new AccountStatement());
		Transaction depositTransaction = new Transaction(100,
				OperationTypesEnum.DEPOSITE,
				LocalDateTime.parse("2018-01-29T00:00:00.000"));
		AccountStatementDetail depositeAccStat = new AccountStatementDetail(
				depositTransaction, 500);
		account.getAccountStatement().addStatementDetail(depositeAccStat);
		Transaction withDrawalTransaction = new Transaction(100,
				OperationTypesEnum.WITHDRAWAL,
				LocalDateTime.parse("2018-01-30T00:00:00.000"));
		AccountStatementDetail withdrawalAccStat = new AccountStatementDetail(
				withDrawalTransaction, 400);
		account.getAccountStatement().addStatementDetail(withdrawalAccStat);
		assertEquals(
				account.getAccountStatement().getStatementDetails().size(), 2,
				0);
		assertEquals(accountService.printAccountStatement(account),
				StringFormatterUtil.STATEMENT_HEADER
						+ StringFormatterUtil.NEW_LINE + "DEPOSITE"
						+ StringFormatterUtil.SEPARATOR + "2018-01-29T00:00"
						+ StringFormatterUtil.SEPARATOR + "100.0"
						+ StringFormatterUtil.SEPARATOR + "500.0"
						+ StringFormatterUtil.NEW_LINE + "WITHDRAWAL"
						+ StringFormatterUtil.SEPARATOR + "2018-01-30T00:00"
						+ StringFormatterUtil.SEPARATOR + "100.0"
						+ StringFormatterUtil.SEPARATOR + "400.0");
	}

	@Test(expected = InvalidAccountParametersException.class)
	public void makeDepositAccountWithBadParametersTest() {
		account.setBalance(1000);
		accountService.makeDeposit(account, -500);
		assertEquals(account.getBalance(), 1500, DELTA);
	}

	@Test(expected = InvalidAccountParametersException.class)
	public void makeWithDrawalAccountWithBadParametersTest() {
		account.setBalance(1800);
		accountService.makeWithdrawal(account, -800);
		assertEquals(account.getBalance(), 1000, DELTA);
	}

}

package com.sg.bank.account.util;

import java.time.LocalDateTime;

/**
 * @author guesmi
 * @version : 1.0
 *
 */
public class StringFormatterUtil {

	public static final String STATEMENT_HEADER = "OPERATION	DATE	AMOUNT	BALANCE";
	public static final String NEW_LINE = "\n";
	public static final String SEPARATOR = "\t";

	public static final String constructStatementDetailRow(
			OperationTypesEnum operation, LocalDateTime date, double amount,
			double balance) {

		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(NEW_LINE).append(operation).append(SEPARATOR)
				.append(date).append(SEPARATOR).append(amount)
				.append(SEPARATOR).append(balance);
		return strBuilder.toString();
	}

}

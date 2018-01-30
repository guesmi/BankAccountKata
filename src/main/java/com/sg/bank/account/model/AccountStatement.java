package com.sg.bank.account.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guesmi
 * @version : 1.0
 *
 */
@Data
@NoArgsConstructor
public class AccountStatement {
  
	private List<AccountStatementDetail> statementDetails;
    
	
	/**
	 *  method to add an Account Statement details to 
	 *  the list that represents the statement account
	 * @param accStatementDetail
	 */
	public void addStatementDetail(AccountStatementDetail accStatementDetail){
		if(statementDetails == null)
			statementDetails = new ArrayList<AccountStatementDetail>();
		this.statementDetails.add(accStatementDetail);
	}
  
}

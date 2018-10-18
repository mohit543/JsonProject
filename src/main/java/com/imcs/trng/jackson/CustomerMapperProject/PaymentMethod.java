package com.imcs.trng.jackson.CustomerMapperProject;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentMethod {
	
	private Long cardNumber;
	private String cardName;
	private Date dateFrom;
	private cardTypeEnum cardType;
	
	public PaymentMethod()
	{
		
	}
	
	
	
	public enum cardTypeEnum
	{
		DEBITCARD, CREDITCARD;
	}	
}



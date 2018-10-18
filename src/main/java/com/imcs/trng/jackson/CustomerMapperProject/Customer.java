package com.imcs.trng.jackson.CustomerMapperProject;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Customer {
	
	private Long customerId;
	private String name;
	
	private Date dateOfBirth;
	private Double annualSalary;
	private List<Address> address;
	private List<PaymentMethod> paymentMethod;
	
	public Customer() 
	{
		
	}

}

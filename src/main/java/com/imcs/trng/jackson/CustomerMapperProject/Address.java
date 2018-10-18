package com.imcs.trng.jackson.CustomerMapperProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class Address {
	
	private Long addressId;
	private String street;
	private String city;
	private String state;
	private Integer zipCode;
	
	public Address()
	{
		
	}

}

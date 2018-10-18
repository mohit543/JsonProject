package com.imcs.trng.jacks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.imcs.trng.jackson.CustomerMapperProject.Address;
import com.imcs.trng.jackson.CustomerMapperProject.Customer;
import com.imcs.trng.jackson.CustomerMapperProject.PaymentMethod;
import com.imcs.trng.jackson.CustomerMapperProject.PaymentMethod.cardTypeEnum;

@JsonDeserialize
@JsonSerialize

public class CustomerObjectMapper {
	static String pattern = "yyyy-mm-dd";
	static SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
	
		
		Address address = createAddress();
		List<Address> listAddress = new ArrayList<Address>();
		listAddress.add(address);
		
		PaymentMethod paymentMethod = createPaymentMethod();
		List<PaymentMethod> listPaymentMethod = new ArrayList<PaymentMethod>();
		listPaymentMethod.add(paymentMethod);
		
		Customer customer = createCustomer();
		customer.setAddress(listAddress);
		customer.setPaymentMethod(listPaymentMethod);
		
		//serialize(customer);
		deSerialize();

	}
	private static void serialize(Customer customer) throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("D:\\IMCS\\Customer.json");
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		objectMapper.writeValue(System.out, customer);
		objectMapper.writeValue(file, customer);
	}
	private static void deSerialize() throws IOException
	{
		byte[] jsonData = Files.readAllBytes(Paths.get("D:\\IMCS\\Customer.json"));
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		//objectMapper.registerModule(new JavaTimeModule());
		
		Customer customer = objectMapper.readValue(jsonData, Customer.class);
		
		System.out.println("Customer Object: " + customer);
		
	}
	private static Address createAddress()
	{
		Address address = new Address();
		address.setAddressId(1L);
		address.setStreet("ABC Street");
		address.setCity("Irving");
		address.setState("Texas");
		address.setZipCode(75063);
		
		return address;
	}
	private static Customer createCustomer() throws ParseException
	{
		Date dob = dateFormat.parse("2005-02-01");	
		Customer customer = new Customer();
		customer.setCustomerId(101L);
		customer.setName("John Doe");
		customer.setDateOfBirth(dob);
		customer.setAnnualSalary(120000.00);
		customer.setAddress(null);
		customer.setPaymentMethod(null);
		
		return customer;
		
	}
	
	private static PaymentMethod createPaymentMethod() throws ParseException
	{	
		
		Date date = dateFormat.parse("2005-02-01");
		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setCardNumber(1236549875213652L);
		paymentMethod.setCardName("Amit Kumar");
		paymentMethod.setDateFrom(date);
		paymentMethod.setCardType(cardTypeEnum.CREDITCARD);
		
		return paymentMethod;
	}
}

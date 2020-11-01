package com.merger.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MockData {
	
	public List<InitialIntermediateData> getInitialIntermediateData() {
		
		InitialIntermediateData initial1 = new InitialIntermediateData();
		
		Apple apple = new Apple();
		apple.setName("Shimla Apple");
		apple.setRate(new BigDecimal("50.0"));
		initial1.setId(1);
		initial1.setFruit(apple);
		initial1.setDeliveryType(DeliveryType.ONLINE);
		
		InitialIntermediateData initial2 = new InitialIntermediateData();
		
		Mango aam = new Mango();
		aam.setName("Langda");
		apple.setRate(new BigDecimal("60.01"));
		initial2.setId(2);
		initial2.setFruit(aam);
		initial2.setDeliveryType(DeliveryType.PHYSICAL);
		
		List<InitialIntermediateData> i = new ArrayList<>();
		
		i.add(initial1);
		i.add(initial2);
		
		return i;
	}
	
	public List<FinalIntermediateData> getFinalIntermediateData() {
		FinalIntermediateData final1 = new FinalIntermediateData();
		final1.setBoxType("wooden box");
		final1.setId(1);
		final1.setIsReceived(false);
		
		FinalIntermediateData final2 = new FinalIntermediateData();
		final2.setBoxType("cardboard box");
		final2.setId(2);
		final2.setIsReceived(true);
		
		FinalIntermediateData final3 = new FinalIntermediateData();
		final3.setBoxType("clay box");
		final3.setId(3);
		final3.setIsReceived(true);
		
		
		List<FinalIntermediateData> f = new ArrayList<FinalIntermediateData>();
		f.add(final1);
		f.add(final2);
		f.add(final3);
		
		return f;
	}

}

package com.merger.model;

import lombok.Data;

@Data
public class MainIntermediateData {
	
	private Integer id;
	
	private Fruit fruit;
	
	private DeliveryType deliveryType;

	private String boxType;
	
	private Boolean isReceived;
}

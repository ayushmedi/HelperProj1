package com.merger.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.merger.model.FinalIntermediateData;
import com.merger.model.InitialIntermediateData;
import com.merger.model.MainIntermediateData;
import com.merger.model.MockData;

@Component
public class Merger {

	@Autowired
	private MockData mockData;
	
	@PostConstruct
	public void merge() throws IllegalAccessException, InvocationTargetException {
		
		List<InitialIntermediateData> initialList = mockData.getInitialIntermediateData();
		List<FinalIntermediateData> finalList = mockData.getFinalIntermediateData();
		List<MainIntermediateData> mainList = new ArrayList<>();
		Map<Integer, Integer> mainMap = new HashMap<>();
		
		//Merge whole InitialIntermediateData List to Main list
		for(int index = 0; index< initialList.size(); index++) {
				MainIntermediateData main = new MainIntermediateData();  //create a new MainIntermediate Obj
				BeanUtils.copyProperties(main, initialList.get(index));  //Copies the properties from InitialIntermediate to the MainIntermediate obj
				mainList.add(main);                                      //add the MainIntermediate obj to the list... this will be our merged list
				mainMap.put(main.getId(), index);                        //Maintain a map of ID, Index. This will help in copying FinalIntermediateData later
		}
		
		//Merge FinalIntermediateData List now (there can be same, less or more data in this)
		for(int index = 0; index< finalList.size(); index++) {
			MainIntermediateData main = null;
			
			Integer indexFromMap = mainMap.get(finalList.get(index).getId()); //Fetch Index of MainIntermediateData of the given ID
			
			if(null!=indexFromMap) {
				main = mainList.get(indexFromMap);                            //Use existing MainIntermediate Obj created for given ID
				BeanUtils.copyProperties(main, finalList.get(index)); 
			}
			else {
				main = new MainIntermediateData();                            //create a new MainIntermediate Obj as the given ID was not foun`d
				BeanUtils.copyProperties(main, finalList.get(index));
				mainList.add(main);                                            //Add new obj to the List 
			}
	}
		
		System.out.println(mainList);  //Final MainIntermediateData List
		
	}
	
}

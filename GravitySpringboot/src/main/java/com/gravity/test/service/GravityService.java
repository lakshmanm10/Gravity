package com.gravity.test.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.stereotype.Service;

import com.gravity.test.model.RequestArray;
import com.gravity.test.model.ResponseVal;

@Service
public class GravityService {

	public ResponseVal firstOffer(RequestArray requestArray) {
		 List<Integer> discountedItems = findDiscountedItems(requestArray.getItems());
	        List<Integer> payableItems = findPayableItems(requestArray.getItems());
	        ResponseVal responseVal = new ResponseVal();
	        responseVal.setDiscountedList(discountedItems);
	        responseVal.setPayableList(payableItems);
	        return responseVal;
	        
	
	}
	
	public ResponseVal secondOffer(RequestArray requestArray) {
		 
		int pointer1 = 0;
    	int pointer2 = 1;
    	 List<Integer> discountedItems = new ArrayList<>();
    	 List<Integer> payableItems = new ArrayList<>();
         List<Integer> prices = requestArray.getItems();
         
         Collections.sort(prices, Collections.reverseOrder());
         
         while(pointer1 < prices.size()) {
        	 if(prices.get(pointer1) == -1) {
        		 pointer1++;
        		 continue;
        	 }
        	 payableItems.add(prices.get(pointer1));
        	 
        	 while(pointer2 < prices.size()-1 && (prices.get(pointer1) == prices.get(pointer2) || prices.get(pointer2) == -1)) {
        		 pointer2++;
        	 }
        	 pointer1 = pointer1+1;
        	 discountedItems.add(prices.get(pointer2));
        	 prices.set(pointer2, -1);
        	 pointer2 = pointer1;
         }	
		
         ResponseVal responseVal = new ResponseVal();
	        responseVal.setDiscountedList(discountedItems);
	        responseVal.setPayableList(payableItems);
	        return responseVal;
	        
	}
	
	public ResponseVal thirdOffer(RequestArray requestArray) {
		 
		List<Integer> discountedItems = new ArrayList<>();
      	 List<Integer> payableItems = new ArrayList<>();
       	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                   Collections.reverseOrder());
       		List<Integer> prices = requestArray.getItems();
       		for(Integer price: prices) {
       			pq.add(price);
       		}
       	  int first = -1;
       	  int second = -1;
       	  while(!pq.isEmpty()) {
       		  if(first == -1) {
       			  first = pq.poll();
       		  }
       		  else if(second == -1) {
       			  second = pq.poll();
       			  if(second == pq.peek()) {
       				  if(first == second) {
       					  payableItems.add(first);
       					  payableItems.add(second);
       					  first = -1;
       					  second = -1;
       				  }
       				  else {
       					  payableItems.add(first);
       					  discountedItems.add(second);
       					  first = -1;
       					  second = -1;
       				  }
       				  
       			  }
       			  else {
       				  payableItems.add(first);
   					  payableItems.add(second);
   					  discountedItems.add(pq.poll());
   					  discountedItems.add(pq.poll());
   					  first = -1;
   					  second = -1;
       			  }
       		  }
       		  
       		  
       	  }
		
         ResponseVal responseVal = new ResponseVal();
	        responseVal.setDiscountedList(discountedItems);
	        responseVal.setPayableList(payableItems);
	        return responseVal;
	        
	}
	
	
	  public static List<Integer> findDiscountedItems(List<Integer> priceList) {
	        List<Integer> discountedItems = new ArrayList<>();
	      
	        Collections.sort(priceList, Collections.reverseOrder());

	        for (int i = 1; i < priceList.size(); i += 2) {
	            discountedItems.add(priceList.get(i));
	        }
	        return discountedItems;
	    }

	    public static List<Integer> findPayableItems(List<Integer> priceList) {
	        List<Integer> payableItems = new ArrayList<>();
	        
	        Collections.sort(priceList, Collections.reverseOrder());

	        for (int i = 0; i < priceList.size(); i += 2) {
	        	payableItems.add(priceList.get(i));
	        }
	        
	        return payableItems;
	    }
}

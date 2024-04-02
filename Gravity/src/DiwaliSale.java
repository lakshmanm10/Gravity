import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class DiwaliSale {
    
    public static void main(String[] args) {
    	
    	
    	System.out.println("Select 1: Offer Rule 1, 2: Offer Rule 2, 3: Offer Rule 3 ");
    	 Scanner myObj = new Scanner(System.in);
    	 int option = myObj.nextInt();
    	int n = 0;
    	 System.out.println("Enter number of products");
    	
    	 n = myObj.nextInt();
        
        int[] priceList = new int[n];
        
        System.out.println("Enter products");

        for(int i =0;i<n;i++) {
        	 priceList[i] = myObj.nextInt();
        }

        if(option == 1) {
        List<Integer> discountedItems = findDiscountedItems(priceList);
        List<Integer> payableItems = findPayableItems(priceList, discountedItems);
        System.out.println("Discounted Items: " + discountedItems);
        System.out.println("Payable Items: " + payableItems);
        }
        else if(option == 2) {
        	int pointer1 = 0;
        	int pointer2 = 1;
        	 List<Integer> discountedItems = new ArrayList<>();
        	 List<Integer> payableItems = new ArrayList<>();
             List<Integer> prices = new ArrayList<>();
             for (int price : priceList) {
                 prices.add(price);
             }
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
             System.out.println("Discounted Items: " + discountedItems);
             System.out.println("Payable Items: " + payableItems);
        }
        else if(option == 3) {
        	List<Integer> discountedItems = new ArrayList<>();
       	 List<Integer> payableItems = new ArrayList<>();
        	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                    Collections.reverseOrder());
        	  for (int price : priceList) {
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
        	  System.out.println("Discounted Items: " + discountedItems);
              System.out.println("Payable Items: " + payableItems);
            	 
        }
        myObj.close();

    }
    
    
    
    public static List<Integer> findDiscountedItems(int[] priceList) {
        List<Integer> discountedItems = new ArrayList<>();
        List<Integer> prices = new ArrayList<>();
        for (int price : priceList) {
            prices.add(price);
        }
        Collections.sort(prices, Collections.reverseOrder());

        for (int i = 1; i < prices.size(); i += 2) {
            discountedItems.add(prices.get(i));
        }
        return discountedItems;
    }

    public static List<Integer> findPayableItems(int[] priceList, List<Integer> discountedItems) {
        List<Integer> payableItems = new ArrayList<>();
        List<Integer> prices = new ArrayList<>();
        for (int price : priceList) {
            prices.add(price);
        }
        Collections.sort(prices, Collections.reverseOrder());

        for (int i = 0; i < prices.size(); i += 2) {
        	payableItems.add(prices.get(i));
        }
        
        return payableItems;
    }
}

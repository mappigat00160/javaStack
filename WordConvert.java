package com.test.wordconvert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class WordConvert {
	 
	static ArrayList<String> str ;
    static HashMap<Integer, String> numberWords ;
    
   public WordConvert(){
    	initVal();
    }
    
	void initVal() {
		  str = new ArrayList<>();
	      numberWords = new HashMap<>();
	        numberWords.put(0, "");
	        numberWords.put(1, "One");
	        numberWords.put(2, "Two");
	        numberWords.put(3, "Three");
	        numberWords.put(4, "Four");
	        numberWords.put(5, "Five");
	        numberWords.put(6, "Six");
	        numberWords.put(7, "Seven");
	        numberWords.put(8, "Eight");
	        numberWords.put(9, "Nine");
	        numberWords.put(10, "Ten");
	        numberWords.put(11, "Eleven");
	        numberWords.put(12, "Twelve");
	        numberWords.put(13, "Thirteen");
	        numberWords.put(14, "Fourteen");
	        numberWords.put(15, "Fifteen");
	        numberWords.put(16, "Sixteen");
	        numberWords.put(17, "Seventeen");
	        numberWords.put(18, "Eighteen");
	        numberWords.put(19, "Nineteen");
	        numberWords.put(20, "Twenty");
	        numberWords.put(30, "Thirty");
	        numberWords.put(40, "Forty");
	        numberWords.put(50, "Fifty");
	        numberWords.put(60, "Sixty");
	        numberWords.put(70, "Seventy");
	        numberWords.put(80, "Eighty");
	        numberWords.put(90, "Ninety");	       
	}
    public static String convertDigitToWord(String provNumber) throws WordConvertException {
        BigDecimal bd = new BigDecimal(provNumber);
        long number = bd.longValue();        
        int i = 0;       
        long no = bd.longValue();        
        int digits_length = String.valueOf(no).length();
        String digits[] = {"", "Hundred", "Thousand", "Hundred","Million","Hundred"};
        try {
        while (i < digits_length) {
            int divider = (i == 2 || i==5 || i==9) ? 10 : 100;
            number = no % divider;
            no = no / divider;
            i += divider == 10 ? 1 : 2;
            if (number > 0) {
                int counter = str.size();
              
                System.out.println("A "+numberWords.get(Integer.valueOf((int) Math.floor(number / 10) * 10)));
                System.out.println("B "+numberWords.get(Integer.valueOf((int) (number % 10))) + " " + digits[counter]);
                String tmp = (number < 21) ? numberWords.get(Integer.valueOf((int) number)) + " " + digits[counter] 
                		: numberWords.get(Integer.valueOf((int) Math.floor(number / 10) * 10)) +
                		" " + numberWords.get(Integer.valueOf((int) (number % 10))) + " " + digits[counter] ;                
                str.add(tmp);
            } else {
                str.add("");
            }
            
        }
        }catch(NumberFormatException  exception) {
        	throw new WordConvertException(exception.getMessage());
        }
        Collections.reverse(str);
        String convertedLetters = String.join(" ", str).trim();
        
        return convertedLetters ;
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        try {
        	WordConvert convertWord = new WordConvert();
        	System.out.println("999999999 = " + convertWord.convertDigitToWord("999999999"));
        }catch(Exception superExcp) {
        	System.out.println("Error Occured during conversion "+superExcp);
        }
    }
 
}
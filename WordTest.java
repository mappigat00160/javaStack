package wordconvert;

import com.test.wordconvert.WordConvert;
import com.test.wordconvert.WordConvertException;

import junit.framework.*;

public class WordTest extends TestCase {
	
	WordConvert convertWord ;
	  
	   public void testAdd1() throws WordConvertException{
		   convertWord = new WordConvert();
		   String result1 = convertWord.convertDigitToWord("12345");
	      assertEquals(result1,"Twelve Thousand Three Hundred Forty Five");
	   }
	   
	   public void testAdd2() throws WordConvertException{
		   convertWord = new WordConvert();
		   String result = convertWord.convertDigitToWord("999999999");
	       assertTrue(result.equals("Nine Hundred Ninety Nine Million Nine Hundred Ninety Nine Thousand Nine Hundred Ninety Nine"));
	   }
}

package Assignment_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class TestCoinPurse {

	/*
	String msg = "should be leap year";
	assertTrue(msg, Year.isLeapYear(2000));
	assertFalse(msg, Year.isLeapYear(2300));
	*/
	
	@Test
	void testNegativeCoinPurse() {
		String msg = "should not be allowed (NEGATIVE)";
		//assertTrue(msg, CoinPurse.CoinPurse(-1,2,3));
		//Figure out how to test constructors, if it's different at all
		//maybe if i want to test I test the specific functions instead of constructor
	}
	
	@Test
	void testCapacityCoinPurse() {
		
	}

}
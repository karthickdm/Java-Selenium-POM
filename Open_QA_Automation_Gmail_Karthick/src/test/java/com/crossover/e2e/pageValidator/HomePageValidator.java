package test.java.com.crossover.e2e.pageValidator;

import junit.framework.Assert;

public class HomePageValidator {

	public void validateActualAndExpectedResultAreEqual(String expected_result, String actual_result)
	{
		Assert.assertEquals( "atcual result:"+actual_result+"is not matched with expected:"+expected_result+"", expected_result, actual_result);
	}
}

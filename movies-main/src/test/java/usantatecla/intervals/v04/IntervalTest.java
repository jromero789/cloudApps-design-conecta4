package usantatecla.intervals.v04;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

import org.junit.Test;

public class IntervalTest {

	private	Interval interval;
	
	@Before 
	public void before() {
		interval = new Interval(-2,2);
	}

	@Test
	public void testIsIncluded() {
    	assertTrue(interval.isIncluded(new Interval(-5,3)));
	}

	@Test
	public void testIsNotIncludedLeft() {
    	assertFalse(interval.isIncluded(new Interval(0,2)));
	}

	@Test
	public void testIsNotIncludedRight() {
    	assertFalse(interval.isIncluded(new Interval(-5,1)));
	}

	@Test
	public void testIsNotIncludedLeftAndRigth() {
    	assertFalse(interval.isIncluded(new Interval(0,1)));
	}

	@Test(expected = AssertionError.class)
	public void testIntervalMaxIsAboveMin() {
    	new Interval (5,3);
		
	}
}

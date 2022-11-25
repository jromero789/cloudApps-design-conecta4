package usantatecla.intervals.v01;

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

}

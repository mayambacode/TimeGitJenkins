package time;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	
	/*
	 * @Test void testGetTotalSeconds() { //fail("Not yet implemented"); }
	 */
	@Test
	void testGetTotalSecondsGood() {
		//fail("Not yet implemented");
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly",
				seconds==18305);
	}
	
	@Test
	public void testGetTotalSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getTotalSeconds("05");});
	}
	
	@Test
	public void testGetTotalSecondsBoundry() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly",
				seconds==18305);
	}
	///////////////////////////////////////////////////////////
	/*
	 * @Test void testGetSeconds() { fail("Not yet implemented"); }
	 */
	
	@Test
	public void testGetSecondsGood() {
		int seconds = Time.getSeconds("00:00:50"); //18305
		assertTrue("The seconds weren't calculated properly", 
				seconds == 50);
	}
	
	@Test
	public void testGetSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getSeconds("05:00");});	
	}
	
	@Test
	public void testGetSecondsBoundry() {
		int seconds = Time.getSeconds("00:00:50");
		assertTrue("The seconds weren't calculated properly", 
				seconds == 50);
	}
//////////////////////////////////////////////////////////////////
	
	/*
	 * @Test void testGetTotalMinutes() { fail("Not yet implemented"); }
	 */
	
	@Test
	public void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("00:10:00"); //18305
		assertTrue("The minutes weren't calculated properly",
				minutes == 10);
	}
	@Test
	public void testGetMinutesBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getTotalMinutes("15");});	
	}
	
	@Test
	public void testGetTotalMinutesBoundry() {
		int minutes = Time.getTotalMinutes("00:10:00"); //900
		assertTrue("The minutes weren't calculated properly",
				minutes == 10);
	}
/////////////////////////////////////////////////////////////
	
	/*
	 * @Test void testGetTotalHours() { fail("Not yet implemented"); }
	 */
	@ParameterizedTest
	@ValueSource(strings = {"05:00:00", "05:15:15", "05:59:59"})
	void testGetTotalHours(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", hours==5);
	}
	
	@Test
    void testGetMillisecondsGood() {
//        assertEquals(500, Time.getMilliseconds("01:23:45:500"));
        assertEquals(0, Time.getMilliseconds("00:00:00:000"));
//        assertEquals(999, Time.getMilliseconds("23:59:59:999"));
    }

    @Test
    void testGetMillisecondsBad() {
        assertThrows(NumberFormatException.class, () -> Time.getMilliseconds("01:23:45")); 
        assertThrows(NumberFormatException.class, () -> Time.getMilliseconds("01:23")); 
        assertThrows(NumberFormatException.class, () -> Time.getMilliseconds("invalid input")); 
    }

    @Test
    void testGetMillisecondsBoundary() {
        assertEquals(1, Time.getMilliseconds("00:00:00:001"));
//        assertEquals(999, Time.getMilliseconds("23:59:59:999")); // Max milliseconds
//        assertThrows(NumberFormatException.class, () -> Time.getMilliseconds("23:59:59:1000")); 
    }
}

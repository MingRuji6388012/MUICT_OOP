import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCase {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MyDate x = new MyDate();
        MyDate y = new MyDate();
        assertEquals(1, x.getObjectNumber());
        assertEquals(2, y.getObjectNumber());
    }

    @Test
    public void testLeapYear(){
        assertFalse(MyDate.isLeapYear(1900));
        assertFalse(MyDate.isLeapYear(1901));
        assertTrue(MyDate.isLeapYear(2000));
        assertTrue(MyDate.isLeapYear(2004));
    }

    @Test
    public void testNextDay(){
        MyDate a = new MyDate(1900, 12, 31);
        assertEquals(31, a.getDay());
        assertEquals(12, a.getMonth());
        assertEquals(1900, a.getYear());

        a.nextDay();
        assertEquals(1, a.getDay());
        assertEquals(1, a.getMonth());
        assertEquals(1901, a.getYear());

        a.setDate(2000, 4, 29);
        a.nextDay();
        assertEquals(30, a.getDay());
        assertEquals(4, a.getMonth());
        assertEquals(2000, a.getYear());

        a.nextDay();
        assertEquals(1, a.getDay());
        assertEquals(5, a.getMonth());
        assertEquals(2000, a.getYear());

        a.setDate(2000, 7, 30);
        a.nextDay();
        assertEquals(31, a.getDay());
        assertEquals(7, a.getMonth());
        assertEquals(2000, a.getYear());

        a.nextDay();
        assertEquals(1, a.getDay());
        assertEquals(8, a.getMonth());
        assertEquals(2000, a.getYear());

        // leap year
        a.setDate(2000, 2, 28);
        a.nextDay();
        assertEquals(29, a.getDay());
        assertEquals(2, a.getMonth());
        assertEquals(2000, a.getYear());

        a.nextDay();
        assertEquals(1, a.getDay());
        assertEquals(3, a.getMonth());
        assertEquals(2000, a.getYear());

        // not leap year
        a.setDate(2001, 2, 28);
        a.nextDay();
        assertEquals(1, a.getDay());
        assertEquals(3, a.getMonth());
        assertEquals(2001, a.getYear());
    }

    @Test
    public void testNextMonth() {
        MyDate a = new MyDate(2020, 12, 1);

        a.nextMonth();
        assertEquals(1, a.getDay());
        assertEquals(1, a.getMonth());
        assertEquals(2021, a.getYear());

        // not leap year
        a.setDate(2019, 1, 30);
        a.nextMonth();
        assertEquals(28, a.getDay());
        assertEquals(2, a.getMonth());
        assertEquals(2019, a.getYear());

        // leap year
        a.setDate(2020, 1, 30);
        a.nextMonth();
        assertEquals(29, a.getDay());
        assertEquals(2, a.getMonth());
        assertEquals(2020, a.getYear());

        a.setDate(2020, 5, 31);
        a.nextMonth();
        assertEquals(30, a.getDay());
        assertEquals(6, a.getMonth());
        assertEquals(2020, a.getYear());

        a.nextMonth();
        assertEquals(30, a.getDay());
        assertEquals(7, a.getMonth());
        assertEquals(2020, a.getYear());
    }

    @Test
    public void testNextYear() {
        MyDate a = new MyDate(2019, 3, 29);
        assertEquals(29, a.getDay());
        assertEquals(3, a.getMonth());
        assertEquals(2019, a.getYear());

        a.nextYear();
        assertEquals(29, a.getDay());
        assertEquals(3, a.getMonth());
        assertEquals(2020, a.getYear());

        // not leap year
        a.setDate(2019, 2, 28);
        a.nextYear();
        assertEquals(28, a.getDay());
        assertEquals(2, a.getMonth());
        assertEquals(2020, a.getYear());

        // leap year
        a.setDay(29);
        a.nextYear();
        assertEquals(28, a.getDay());
        assertEquals(2, a.getMonth());
        assertEquals(2021, a.getYear());
    }

    @Test
    public void testPreviousDay(){
        MyDate a = new MyDate();
        assertEquals(1, a.getDay());
        assertEquals(1, a.getMonth());
        assertEquals(1900, a.getYear());

        a.previousDay();
        assertEquals(31, a.getDay());
        assertEquals(12, a.getMonth());
        assertEquals(1899, a.getYear());

        a.setDate(2000, 5, 1);
        a.previousDay();
        assertEquals(30, a.getDay());
        assertEquals(4, a.getMonth());
        assertEquals(2000, a.getYear());

        a.setDate(2000, 7, 15);
        a.previousDay();
        assertEquals(14, a.getDay());
        assertEquals(7, a.getMonth());
        assertEquals(2000, a.getYear());

        a.setDate(2000, 3, 10);
        a.previousDay();
        assertEquals(9, a.getDay());
        assertEquals(3, a.getMonth());
        assertEquals(2000, a.getYear());

        // leap year
        a.setDate(2000, 3, 1);
        a.previousDay();
        assertEquals(29, a.getDay());
        assertEquals(2, a.getMonth());
        assertEquals(2000, a.getYear());

        // not leap year
        a.setDate(2001, 3, 1);
        a.previousDay();
        assertEquals(28, a.getDay());
        assertEquals(2, a.getMonth());
        assertEquals(2001, a.getYear());

        a.setDate(2001, 4, 1);
        a.previousDay();
        assertEquals(31, a.getDay());
        assertEquals(3, a.getMonth());
        assertEquals(2001, a.getYear());

        a.setDate(2001, 6, 10);
        a.previousDay();
        assertEquals(9, a.getDay());
        assertEquals(6, a.getMonth());
        assertEquals(2001, a.getYear());
    }

    @Test
    public void testPreviousMonth() {
        MyDate a = new MyDate(2020, 1, 1);

        a.previousMonth();
        assertEquals(1, a.getDay());
        assertEquals(12, a.getMonth());
        assertEquals(2019, a.getYear());

        // not leap year
        a.setDate(2019, 3, 30);
        a.previousMonth();
        assertEquals(28, a.getDay());
        assertEquals(2, a.getMonth());
        assertEquals(2019, a.getYear());

        // leap year
        a.setDate(2020, 3, 30);
        a.previousMonth();
        assertEquals(29, a.getDay());
        assertEquals(2, a.getMonth());
        assertEquals(2020, a.getYear());

        a.setDate(2020, 5, 31);
        a.previousMonth();
        assertEquals(30, a.getDay());
        assertEquals(4, a.getMonth());
        assertEquals(2020, a.getYear());

        a.previousMonth();
        assertEquals(30, a.getDay());
        assertEquals(3, a.getMonth());
        assertEquals(2020, a.getYear());
    }

    @Test
    public void testPreviousYear() {
        MyDate a = new MyDate(2019, 3, 29);
        assertEquals(29, a.getDay());
        assertEquals(3, a.getMonth());
        assertEquals(2019, a.getYear());

        a.previousYear();
        assertEquals(29, a.getDay());
        assertEquals(3, a.getMonth());
        assertEquals(2018, a.getYear());

        // not leap year
        a.setDate(2021, 2, 28);
        a.previousYear();
        assertEquals(28, a.getDay());
        assertEquals(2, a.getMonth());
        assertEquals(2020, a.getYear());

        // leap year
        a.setDay(29);
        a.previousYear();
        assertEquals(28, a.getDay());
        assertEquals(2, a.getMonth());
        assertEquals(2019, a.getYear());
    }

}

package dataTest;

import Exceptions.dataE.HealthCardFormatException;
import data.HealthCardID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HealthCardIDTest implements DataInterficies {

    private HealthCardID hCard;

    @Override
    @BeforeEach
    public void initialize() throws HealthCardFormatException {
        hCard = new HealthCardID("BBBBBBBBLD124357946587246587");
    }

    @Test
    @Override
    public void testCodeNull() {
        assertThrows(HealthCardFormatException.class, () -> new HealthCardID(null));
    }

    @Test
    public void testIncorrectCode() {
        assertThrows(HealthCardFormatException.class, () -> new HealthCardID("BBBBBDBB"));
        assertThrows(HealthCardFormatException.class, () -> new HealthCardID("BBBBBBBB3L156489561498964893"));
        assertThrows(HealthCardFormatException.class, () -> new HealthCardID("BBBBBBBBRL15648956149896489D"));
    }

    @Test
    public void testGetter() {
        String expectedHCardID = "BBBBBBBBLD124357946587246587";
        assertEquals(expectedHCardID, hCard.getPersonalID());
    }

    @Test
    @Override
    public void testEquals() throws  HealthCardFormatException {
        HealthCardID exceptedHCardID = new HealthCardID("BBBBBBBBLD124357946587246587");
        assertEquals(exceptedHCardID, hCard);
    }

    @Test
    @Override
    public void testNotEquals() throws HealthCardFormatException {
        HealthCardID exceptedHCardID = new HealthCardID("BBBBBBBBFD124345849246587666");
        assertNotEquals(exceptedHCardID, hCard);
    }

    @Test
    @Override
    public void testToString() {
        String expectedString = "HealthCardID{Personal Code='BBBBBBBBLD124357946587246587'}";
        assertEquals(expectedString,hCard.toString());
    }
}
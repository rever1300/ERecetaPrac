package dataTest;


import Exceptions.dataE.*;
import data.HealthCardID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HealthCardIDTest implements DataInterficies {

    private HealthCardID hCard;


    @Override
    @BeforeEach
    public void initialize() throws HealthCardIDException {
        hCard = new HealthCardID("BBBBBBBBLD124357946587246587");
    }

    @Test
    @Override
    public void testCodeNull() {
        assertThrows(HealthCardIDException.class, () -> new HealthCardID(null));
    }

    @Test
    @Override
    public void testIncorrectCode() {
        assertThrows(HealthCardIDException.class, () -> new HealthCardID("BBBBBDBB"));
        assertThrows(HealthCardIDException.class, () -> new HealthCardID("BBBBBBBB3L156489561498964893"));
        assertThrows(HealthCardIDException.class, () -> new HealthCardID("BBBBBBBBRL15648956149896489D"));
    }

    @Override
    @Test
    public void testGetter() {
        String expectedHCardID = "BBBBBBBBLD124357946587246587";
        assertEquals(expectedHCardID, hCard.getPersonalID());
    }

    @Test
    @Override
    public void testEquals() throws  HealthCardIDException {
        HealthCardID exceptedHCardID = new HealthCardID("BBBBBBBBLD124357946587246587");
        assertEquals(exceptedHCardID, hCard);
    }

    @Test
    @Override
    public void testNotEquals() throws HealthCardIDException {
        HealthCardID exceptedHCardID = new HealthCardID("BBBBBBBBFD124345849246587666");
        assertNotEquals(exceptedHCardID, hCard);
    }

    @Test
    @Override
    public void testToString() {
        String expectedString = "HealthCardID{personal code='BBBBBBBBLD124357946587246587\'}";
    }
}
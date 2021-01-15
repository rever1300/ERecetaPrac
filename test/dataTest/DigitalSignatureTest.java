package dataTest;

import Exceptions.dataE.eSignatureException;
import data.DigitalSignature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DigitalSignatureTest implements DataInterficies{

    private DigitalSignature dSign;

    @Override
    @BeforeEach
    public void initialize() throws eSignatureException {
        dSign = new DigitalSignature("Ana".getBytes());
    }

    @Test
    @Override
    public void testCodeNull() {
        assertThrows(eSignatureException.class, () -> new DigitalSignature(null));
    }

    @Test
    @Override
    public void testEquals() throws eSignatureException {
        DigitalSignature expectedSignature = new DigitalSignature("Ana".getBytes());
        assertEquals(expectedSignature, dSign);
    }

    @Test
    @Override
    public void testNotEquals() throws eSignatureException{
        DigitalSignature expectedSignature = new DigitalSignature("ana".getBytes());
        assertNotEquals(expectedSignature, dSign);
    }

    @Test
    @Override
    public void testToString() {
        String expectedString = "DigitalSignature{Signatura='Ana'}";
        assertEquals(expectedString, dSign.toString());
    }
}

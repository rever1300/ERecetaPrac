package dataTest;


import Exceptions.dataE.ProductIDException;
import data.ProductID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductIDTest implements DataInterficies{

    private ProductID pID;

    @Override
    @BeforeEach
    public void initialize() throws ProductIDException {
        pID = new ProductID("457326953405");
    }

    @Test
    @Override
    public void testCodeNull() {
        assertThrows(ProductIDException.class, () -> new ProductID(null));
    }

    @Test
    public void testIncorrectCode() {
        assertThrows(ProductIDException.class, () -> new ProductID("3257458"));
        assertThrows(ProductIDException.class, () -> new ProductID("32574E85F146"));
    }

    @Test
    public void testGetter() {
        String expectedProductID = "457326953405";
        assertEquals(expectedProductID, pID.getProductID());
    }

    @Test
    @Override
    public void testEquals() throws ProductIDException {
        ProductID expected_pID = new ProductID("457326953405");
        assertEquals(expected_pID,pID);
    }

    @Test
    @Override
    public void testNotEquals() throws ProductIDException {
        ProductID expected_pID = new ProductID("457574953405");
        assertNotEquals(expected_pID,pID);
    }

    @Test
    @Override
    public void testToString() {
        String expectedString = "ProductID{Product Code='457326953405'}";
        assertEquals(expectedString,pID.toString());
    }
}

package dataTest;

import Exceptions.dataE.*;

public interface DataInterficies {
    void initialize() throws ProductIDException, eSignatureException, HealthCardIDException;
    void testCodeNull();
    void testIncorrectCode();
    void testGetter();
    void testEquals() throws ProductIDException, eSignatureException, HealthCardIDException;
    void testNotEquals() throws ProductIDException, eSignatureException, HealthCardIDException;
    void testToString();
}

package dataTest;

import Exceptions.dataE.*;

public interface DataInterficies {
    void initialize() throws ProductIDException, eSignatureException, HealthCardFormatException;
    void testCodeNull();
    void testEquals() throws ProductIDException, eSignatureException, HealthCardFormatException;
    void testNotEquals() throws ProductIDException, eSignatureException, HealthCardFormatException;
    void testToString();
}

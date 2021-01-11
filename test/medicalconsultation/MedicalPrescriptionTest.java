package medicalconsultation;

import Exceptions.IncorrectTakingGuidelinesException;
import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MedicalPrescriptionTest {

    @Test
    void getPrescCode() throws IncorrectTakingGuidelinesException {
        Date dt = new Date();
        HealthCardID hId= new HealthCardID("BBBBBBBBQR648597807024000012");
        DigitalSignature dS = new DigitalSignature(new Byte[2222]);
        MedicalPrescription mP= new MedicalPrescription(1,dt,dt,hId,dS);
        ProductID pID = new ProductID("121345678941");
        String [] f= new String[1];
        f[0]="AFTERLUNCH";
        mP.addLine(pID,f);
    }
}
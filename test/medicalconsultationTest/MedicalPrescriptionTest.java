package medicalconsultationTest;

import Exceptions.IncorrectTakingGuidelinesException;
import Exceptions.ProductNotInPrescription;
import Exceptions.dataE.HealthCardIDException;
import Exceptions.dataE.ProductIDException;
import Exceptions.dataE.eSignatureException;
import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import medicalconsultation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MedicalPrescriptionTest {

    private MedicalPrescription MP;


    @BeforeEach
    public void initialize() throws HealthCardIDException {
        int presCode = 69;
        Date datePresc = new Date(2021, Calendar.JANUARY, 13);
        Date endDate = new Date(2022, Calendar.APRIL, 21);
        String codeHID = "BBBBBBBBOP412345678912345656";
        HealthCardID healthCardID = new HealthCardID(codeHID);
        MP = new MedicalPrescription(healthCardID);
        MP.setPrescCode(presCode);
        MP.setEndDate(endDate);
        MP.setPrescDate(datePresc);
    }


    @Test
    public void getterPresCode(){
        int expPresCode = 69;
        assertEquals(expPresCode,MP.getPrescCode());
    }

    @Test
    public void getterPresDate(){
        Date expDatePresc = new Date(2021, Calendar.JANUARY, 13);
        assertEquals(expDatePresc, MP.getPrescDate());
    }

    @Test
    public void getterEndDate(){
        Date expEndDate = new Date(2022, Calendar.APRIL, 21);
        assertEquals(expEndDate, MP.getEndDate());
    }

    @Test
    public void getterHealthCardID() throws HealthCardIDException {
        String codeHID = "BBBBBBBBOP412345678912345656";
        HealthCardID expHealthCardID = new HealthCardID(codeHID);
        assertEquals(expHealthCardID, MP.getHcID());
    }

    @Test
    public void setterPresCode(){
        int putPresCode = 26;
        MP.setPrescCode(putPresCode);
        assertEquals(putPresCode,MP.getPrescCode());
    }

    @Test
    public void setterPrescDate(){
        Date putDate = new Date(2021, Calendar.FEBRUARY, 1);
        MP.setPrescDate(putDate);
        assertEquals(putDate, MP.getPrescDate());
    }

    @Test
    public void setterEndDate(){
        Date putDate = new Date(2023, Calendar.MAY, 30);
        MP.setEndDate(putDate);
        assertEquals(putDate, MP.getEndDate());
    }

    @Test
    public void setterHealthCard() throws HealthCardIDException {
        String newCodeHID = "BBBBBBBBKJ415263214789654745";
        HealthCardID putHealthCard = new HealthCardID(newCodeHID);
        MP.setHcID(putHealthCard);
        assertEquals(putHealthCard, MP.getHcID());
    }

    @Test
    public void setterDigitalSignature() throws eSignatureException {
        DigitalSignature digitalSignature = new DigitalSignature("Doctora12".getBytes());
        MP.seteSign(digitalSignature);
        assertEquals(digitalSignature,MP.geteSign());

    }


    @Test
    public void addLineTest() throws ProductIDException, IncorrectTakingGuidelinesException {
        ProductID productID = new ProductID("987654321021");
        String[] instruccions = {"DURINGMEALS", "10", "Maxim 5 pastilles per dia", "2", "4", "HOUR"};
        MP.addLine(productID, instruccions);
        TakingGuideline newTakingGuideline = new TakingGuideline(dayMoment.DURINGMEALS,
                10f, "Maxim 5 pastilles per dia", 2f,4f, FqUnit.HOUR);
        MedicalPrescriptionLine medicalPrescriptionLine = new MedicalPrescriptionLine(productID);
        medicalPrescriptionLine.setTakingGuideline(newTakingGuideline);
        assertEquals(medicalPrescriptionLine,MP.getMedicalPrescLine(productID));
    }

    @Test
    public void wrongInstrucAdding() throws ProductIDException {
        ProductID productID = new ProductID("987654321021");
        String[] instruccions = {"DURINGMEALS", "Maxim 5 pastilles per dia", "2", "4", "HOUR"};
        String[] instruccions2 = {"DURINGMEALS", "10", "Maxim 5 pastilles per dia", "2", "4", "PNE"};
        assertThrows(IncorrectTakingGuidelinesException.class, () -> MP.addLine(productID,instruccions));
        assertThrows(IncorrectTakingGuidelinesException.class, () -> MP.addLine(productID,instruccions2));
    }

    @Test
    public void modifyLineTest() throws ProductIDException, IncorrectTakingGuidelinesException, ProductNotInPrescription {
        ProductID productID = new ProductID("987654321021");
        String[] instruccions = {"DURINGMEALS", "10", "Maxim 5 pastilles per dia", "2", "4", "HOUR"};
        MP.addLine(productID, instruccions);
        String[] newInstruccions = {"AFTERDINNER", "12", "Maxim 3 pastilles per dia", "1", "4", "DAY"};
        MP.modifyLine(productID, newInstruccions);
        TakingGuideline newTakingGuideline = new TakingGuideline(dayMoment.AFTERDINNER,
                12f, "Maxim 3 pastilles per dia", 1f,4f, FqUnit.DAY);
        MedicalPrescriptionLine medicalPrescriptionLine = new MedicalPrescriptionLine(productID);
        medicalPrescriptionLine.setTakingGuideline(newTakingGuideline);
        assertEquals(medicalPrescriptionLine, MP.getMedicalPrescLine(productID));
    }

    @Test
    public void productNotInPrescModify() throws ProductIDException, IncorrectTakingGuidelinesException {
        ProductID productID = new ProductID("987654321021");
        ProductID newProductID = new ProductID("147258369369");
        String[] instruccions = {"DURINGMEALS", "10", "Maxim 5 pastilles per dia", "2", "4", "HOUR"};
        MP.addLine(productID, instruccions);
        assertThrows(ProductNotInPrescription.class, ()-> MP.modifyLine(newProductID, instruccions));
    }

    @Test
    public void removeLineTest() throws ProductIDException, IncorrectTakingGuidelinesException, ProductNotInPrescription {
        ProductID productID = new ProductID("987654321021");
        String[] instruccions = {"DURINGMEALS", "14", "Maxim 2 pastilles per dia", "5", "1", "MONTH"};
        MP.addLine(productID, instruccions);
        MP.removeLine(productID);
        assertThrows(ProductNotInPrescription.class, () -> MP.removeLine(productID));
    }

}
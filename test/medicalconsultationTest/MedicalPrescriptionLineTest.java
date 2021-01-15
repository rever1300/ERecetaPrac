package medicalconsultationTest;

import Exceptions.dataE.ProductIDException;
import data.ProductID;
import medicalconsultation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicalPrescriptionLineTest {

    private MedicalPrescriptionLine medicalPrescriptionLine;
    @BeforeEach
    public void initialize() throws ProductIDException {
        String numCode = "123456789102";
        ProductID pID = new ProductID(numCode);
        dayMoment DayMoment = dayMoment.DURINGMEALS;
        float duration = 24f;
        String instructions = "Maxim 5 pastilles per dia";
        float dose = 1f;
        float freq = 7f;
        FqUnit freqUnit = FqUnit.HOUR;
        TakingGuideline tGLine = new TakingGuideline(DayMoment, duration, instructions, dose, freq, freqUnit);
        medicalPrescriptionLine = new MedicalPrescriptionLine();
        medicalPrescriptionLine.setpID(pID);
        medicalPrescriptionLine.setTakingGuideline(tGLine);
    }
    @Test
    public void getterPID() throws ProductIDException {
        ProductID productID = new ProductID("123456789102");
        assertEquals(productID, medicalPrescriptionLine.getpID());
    }
    @Test
    public void getterTKGL(){
        dayMoment DayMoment = dayMoment.DURINGMEALS;
        float duration = 24f;
        String instructions = "Maxim 5 pastilles per dia";
        float dose = 1f;
        float freq = 7f;
        FqUnit freqUnit = FqUnit.HOUR;
        TakingGuideline TGLine = new TakingGuideline(DayMoment, duration, instructions, dose, freq, freqUnit);
        assertEquals(TGLine, medicalPrescriptionLine.getTakingGuideline());
    }

    @Test
    public void setterPID() throws ProductIDException {
        ProductID pID = new ProductID("456789123022");
        medicalPrescriptionLine.setpID(pID);
        assertEquals(pID, medicalPrescriptionLine.getpID());
    }

    @Test
    public void setterTKGL(){
        dayMoment DayMoment = dayMoment.AFTERMEALS;
        float duration = 48f;
        String instructions = "Maxim 8 pastilles per dia";
        float dose = 0.5f;
        float freq = 4.45f;
        FqUnit freqUnit = FqUnit.MONTH;
        TakingGuideline setTakingGuideline = new TakingGuideline(DayMoment, duration, instructions, dose, freq, freqUnit);
        medicalPrescriptionLine.setTakingGuideline(setTakingGuideline);
        assertEquals(setTakingGuideline,medicalPrescriptionLine.getTakingGuideline());
    }
}
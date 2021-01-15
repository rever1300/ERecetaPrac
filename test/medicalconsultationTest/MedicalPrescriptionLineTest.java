package medicalconsultationTest;

import Exceptions.dataE.ProductIDException;
import data.ProductID;
import medicalconsultation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicalPrescriptionLineTest {

    private MedicalPrescriptionLine MPL;

    @BeforeEach
    public void initialize() throws ProductIDException {
        String numCode = "123456789102";
        ProductID pID = new ProductID(numCode);
        dayMoment DayMoment = dayMoment.DURINGMEALS;
        float duration = 24f;
        String instruc = "Maxim 5 pastilles per dia";
        float dose = 1f;
        float freq = 7f;
        FqUnit freqUnit = FqUnit.HOUR;
        TakingGuideline TGLine = new TakingGuideline(DayMoment, duration, instruc, dose, freq, freqUnit);
        MPL = new MedicalPrescriptionLine(pID);
        MPL.setTakingGuideline(TGLine);
    }

    @Test
    public void getterPID() throws ProductIDException {
        ProductID productID = new ProductID("123456789102");
        assertEquals(productID, MPL.getpID());
    }

    @Test
    public void getterTKGL(){
        dayMoment DayMoment = dayMoment.DURINGMEALS;
        float duration = 24f;
        String instruc = "Maxim 5 pastilles per dia";
        float dose = 1f;
        float freq = 7f;
        FqUnit freqUnit = FqUnit.HOUR;
        TakingGuideline TGLine = new TakingGuideline(DayMoment, duration, instruc, dose, freq, freqUnit);
        assertEquals(TGLine, MPL.getTakingGuideline());
    }

    @Test
    public void setterPID() throws ProductIDException {
        ProductID pID = new ProductID("456789123022");
        MPL.setpID(pID);
        assertEquals(pID, MPL.getpID());
    }

    @Test
    public void setterTKGL(){
        dayMoment DayMoment = dayMoment.AFTERMEALS;
        float duration = 48f;
        String instruc = "Maxim 8 pastilles per dia";
        float dose = 0.5f;
        float freq = 4.45f;
        FqUnit freqUnit = FqUnit.MONTH;
        TakingGuideline setTGline = new TakingGuideline(DayMoment, duration, instruc, dose, freq, freqUnit);
        MPL.setTakingGuideline(setTGline);
        assertEquals(setTGline, MPL.getTakingGuideline());
    }
}
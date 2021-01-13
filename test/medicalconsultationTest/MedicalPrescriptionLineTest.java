package medicalconsultationTest;

import Exceptions.dataE.ProductIDException;
import data.ProductID;
import medicalconsultation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        medicalPrescriptionLine = new MedicalPrescriptionLine(pID, tGLine);
    }
}
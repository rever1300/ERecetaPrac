package medicalconsultationTest;

import medicalconsultation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TakingGuidelineTest {

    private TakingGuideline takingGL;

    @BeforeEach
    public void initialize(){
        dayMoment DayMoment = dayMoment.DURINGMEALS;
        float duration = 24f;
        String instructions= "Maxim 5 pastilles per dia";
        float dose = 1f;
        float freq = 7f;
        FqUnit freqUnit = FqUnit.HOUR;
        takingGL = new TakingGuideline(DayMoment, duration, instructions, dose, freq, freqUnit);
    }
}

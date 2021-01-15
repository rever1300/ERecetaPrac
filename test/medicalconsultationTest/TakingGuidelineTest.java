package medicalconsultationTest;

import medicalconsultation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TakingGuidelineTest {

    private TakingGuideline takingGL;

    @BeforeEach
    public void initialize() {
        dayMoment DayMoment = dayMoment.DURINGMEALS;
        float duration = 24f;
        String instructions = "Maxim 5 pastilles per dia";
        float dose = 1f;
        float freq = 7f;
        FqUnit freqUnit = FqUnit.HOUR;
        takingGL = new TakingGuideline(DayMoment, duration, instructions, dose, freq, freqUnit);
    }

    @Test
    public void getterDayMoment(){
        assertEquals(dayMoment.DURINGMEALS, takingGL.getdMoment());
    }

    @Test
    public void getterDuration(){
        assertEquals(24f,takingGL.getDuration());
    }

    @Test
    public void getterInstructions(){
        assertEquals("Maxim 5 pastilles per dia", takingGL.getInstructions());
    }

    @Test
    public void getterPosology(){
        Posology expectedPosology = new Posology(1f,7f,FqUnit.HOUR);
        assertEquals(expectedPosology,takingGL.getPosology());
    }

    @Test
    public void setterDayMoment(){
        takingGL.setdMoment(dayMoment.DURINGDINNER);
        assertEquals(dayMoment.DURINGDINNER, takingGL.getdMoment());
    }

    @Test
    public void setterDuration(){
        takingGL.setDuration(48f);
        assertEquals(48f, takingGL.getDuration());
    }

    @Test
    public void setterInstructions(){
        takingGL.setInstructions("Ara 3 maxim");
        assertEquals("Ara 3 maxim", takingGL.getInstructions());
    }

    @Test
    public void setterPosology(){
        Posology expectedPosology = new Posology(34f, 56f, FqUnit.MONTH);
        takingGL.setPosology(expectedPosology);
        assertEquals(expectedPosology, takingGL.getPosology());
    }
}

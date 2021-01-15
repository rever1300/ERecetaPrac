package medicalconsultationTest;

import medicalconsultation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosologyTest {

    private Posology pos;

    @BeforeEach
    public void initialize(){
        float dose = 2.5f;
        float freq = 7f;
        FqUnit fqUnit = FqUnit.DAY;
        pos = new Posology(dose, freq, fqUnit);
    }

    @Test
    public void getterDose(){
        assertEquals(2.5f,pos.getDose());
    }
    @Test
    public void getterFreq(){
        assertEquals(7f,pos.getFreq());
    }
    @Test
    public void getterFreqUnit(){
        assertEquals(FqUnit.DAY,pos.getFreqUnit());
    }

    @Test
    public void setterDose() {
        pos.setDose(5f);
        assertEquals(5f, pos.getDose());
    }

    @Test
    public void setterFreq(){
        pos.setFreq(2f);
        assertEquals(2f, pos.getFreq());
    }

    @Test
    public void setterFreqUnit(){
        pos.setFreqUnit(FqUnit.WEEK);
        assertEquals(FqUnit.WEEK, pos.getFreqUnit());
    }
}

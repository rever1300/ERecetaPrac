package medicalconsultationTest;

import medicalconsultation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosologyTest {

    private Posology pos;

    @BeforeEach
    public void initialize(){
        pos = new Posology(2.5f,7f, FqUnit.DAY);
    }

    @Test
    public void getters(){
        assertEquals(2.5f,pos.getDose());
        assertEquals(7f,pos.getFreq());
        assertEquals(FqUnit.DAY,pos.getFreqUnit());

    }

    @Test
    public void settersBeforeGetters(){
        assertEquals(2.5f,pos.getDose());
        pos.setDose(1.4f);
        pos.setFreq(14f);
        assertEquals(1.4f,pos.getDose());
        assertEquals(14f,pos.getFreq());
        assertEquals(FqUnit.DAY,pos.getFreqUnit());
        pos.setFreq(1f);
        pos.setFreqUnit(FqUnit.MONTH);
        assertEquals(1f,pos.getFreq());
        assertEquals(FqUnit.MONTH,pos.getFreqUnit());
    }

}

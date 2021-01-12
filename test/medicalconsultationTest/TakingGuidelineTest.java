package medicalconsultationTest;

import medicalconsultation.*;
import org.junit.jupiter.api.BeforeEach;

public class TakingGuidelineTest {

    private TakingGuideline takingGL;

    @BeforeEach
    public void initialize(){
        takingGL = new TakingGuideline(dayMoment.DURINGMEALS,24f,"Pastillas para el colesterol",1f,7f, FqUnit.DAY);
    }
}

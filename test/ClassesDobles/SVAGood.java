package ClassesDobles;

import Exceptions.dataE.HealthCardException;
import Exceptions.dataE.HealthCardFormatException;
import data.HealthCardID;
import services.ScheduledVisitAgenda;

public class SVAGood implements ScheduledVisitAgenda {

    @Override
    public HealthCardID getHealthCardID() throws HealthCardException, HealthCardFormatException {
        return new HealthCardID("BBBBBBBBRT142536987898745610");
    }
}

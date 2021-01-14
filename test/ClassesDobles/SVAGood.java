package ClassesDobles;

import Exceptions.dataE.HealthCardIDException;
import data.HealthCardID;
import services.ScheduledVisitAgenda;

public class SVAGood implements ScheduledVisitAgenda {

    @Override
    public HealthCardID getHealthCardID() throws HealthCardIDException {
        return new HealthCardID("BBBBBBBBRT142536987898745610");
    }
}

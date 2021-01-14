package ClassesDobles;

import Exceptions.dataE.HealthCardIDException;
import data.HealthCardID;
import services.ScheduledVisitAgenda;

public class SVAHealthCardIDException implements ScheduledVisitAgenda {
    @Override
    public HealthCardID getHealthCardID() throws HealthCardIDException {
        throw new HealthCardIDException("El pacient no es troba en l'agenda");
    }
}

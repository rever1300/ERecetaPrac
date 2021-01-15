package ClassesDobles;

import Exceptions.dataE.HealthCardException;
import data.HealthCardID;
import services.ScheduledVisitAgenda;

public class SVAHealthCardIDException implements ScheduledVisitAgenda {
    @Override
    public HealthCardID getHealthCardID() throws HealthCardException {
        throw new HealthCardException("El pacient no es troba en l'agenda");
    }
}

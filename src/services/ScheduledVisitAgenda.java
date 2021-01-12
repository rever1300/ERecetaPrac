package services;

import Exceptions.dataE.HealthCardIDException;
import data.HealthCardID;

public interface ScheduledVisitAgenda {

    public HealthCardID getHealthCardID() throws HealthCardIDException;

}

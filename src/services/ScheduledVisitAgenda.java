package services;

import Exceptions.dataE.HealthCardIDException;
import data.HealthCardID;

public interface ScheduledVisitAgenda {

    HealthCardID getHealthCardID() throws HealthCardIDException;

}

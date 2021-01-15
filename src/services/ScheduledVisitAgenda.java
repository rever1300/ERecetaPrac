package services;

import Exceptions.dataE.HealthCardException;
import Exceptions.dataE.HealthCardFormatException;
import data.HealthCardID;

/**
 * The interface ScheduledVisitAgenda.
 */

public interface ScheduledVisitAgenda {

    HealthCardID getHealthCardID() throws HealthCardException, HealthCardFormatException;

}

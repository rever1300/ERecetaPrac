package services;

import data.HealthCardID;

public class ScheduledVisitAgenda {
    private final HealthCardID healthCardID;


    public ScheduledVisitAgenda(HealthCardID healthCardID){
        this.healthCardID=healthCardID;
    }

    public HealthCardID getHealthCardID() {
        return healthCardID;
    }
}

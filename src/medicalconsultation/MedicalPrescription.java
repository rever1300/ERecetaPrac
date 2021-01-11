package medicalconsultation;
import Exceptions.*;
import data.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class MedicalPrescription {
    private int prescCode;
    private Date prescDate;
    private Date endDate;
    private HealthCardID hcID; // the healthcard ID of the patient
    private DigitalSignature eSign; // the eSignature of the doctor
    private MedicalPrescriptionLine medicalPrescriptionLine;

    // Its components, that is, the set of medical prescription lines
    public MedicalPrescription (int prescCode, Date prescDate, Date endDate,
                                HealthCardID hcID, DigitalSignature eSign) {
        this.prescCode = prescCode;
        this.prescDate = prescDate;
        this.endDate = endDate;
        this.hcID = hcID;
        this.eSign = eSign;
        this.medicalPrescriptionLine = new MedicalPrescriptionLine();
    }
    // the getters and setters
    public int getPrescCode() {
        return prescCode;
    }
    public void setPrescCode(int prescCode) {
        this.prescCode = prescCode;
    }

    public Date getPrescDate() {
        return prescDate;
    }
    public void setPrescDate(Date prescDate) {
        this.prescDate = prescDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public HealthCardID getHcID() {
        return hcID;
    }
    public void setHcID(HealthCardID hcID) {
        this.hcID = hcID;
    }

    public DigitalSignature geteSign() {
        return eSign;
    }
    public void seteSign(DigitalSignature eSign) {
        this.eSign = eSign;
    }



    // Makes some inicialization
    public void addLine(ProductID prodID, String[] instruc)
            throws IncorrectTakingGuidelinesException {
//      if(instruc.length!=6) throw new IncorrectTakingGuidelinesException("Instruccions incorrectes");
        boolean trobat=false;
        dayMoment[] values_dayMoment = dayMoment.values();
        for(int i = 0; i<7; i++){
            if(i==0){
               for(dayMoment d:values_dayMoment){
                   if(d.toString().equals(instruc[i])) {
                       trobat=true;
                       break;
                   }
               }
               if(!trobat)throw new IncorrectTakingGuidelinesException("Puto");
            }
        }



    }
    public void modifyLine(ProductID prodID, String[] instruc)
            throws ProductNotInPrescription, IncorrectTakingGuidelinesException{

    }
    public void removeLine(ProductID prodID)
            throws ProductNotInPrescription{

    }

}

package medicalconsultation;

import Exceptions.*;
import data.DigitalSignature;
import data.ProductID;
import data.*;

import java.util.Date;
import java.util.HashMap;

public class MedicalPrescription {
    private int prescCode;
    private Date prescDate;
    private Date endDate;
    private HealthCardID hcID; // the healthcard ID of the patient
    private DigitalSignature eSign; // the eSignature of the doctor
    private final HashMap<ProductID, TakingGuideline> prescription;

    // Its components, that is, the set of medical prescription lines
    public MedicalPrescription(int prescCode, Date prescDate, Date endDate,
                               HealthCardID hcID, DigitalSignature eSign) {
        this.prescCode = prescCode;
        this.prescDate = prescDate;
        this.endDate = endDate;
        this.hcID = hcID;
        this.eSign = eSign;
        this.prescription = new HashMap<>();
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
        if (instruc.length != 6) throw new IncorrectTakingGuidelinesException("Intruccions No Valides");
        if (!checkInstruc(instruc)) throw new IncorrectTakingGuidelinesException("Instruccions No Valides");
        prescription.put(prodID, new TakingGuideline(
                dayMoment.valueOf(instruc[0]),
                Float.parseFloat(instruc[1]),
                instruc[2],
                Float.parseFloat(instruc[3]),
                Float.parseFloat(instruc[4]),
                FqUnit.valueOf(instruc[5]))
        );
    }

    public void modifyLine(ProductID prodID, String[] instruc)
            throws ProductNotInPrescription, IncorrectTakingGuidelinesException {
        if (!prescription.containsKey(prodID))
            throw new ProductNotInPrescription("Producte no es troba a la prescripció mèdica");
        if (instruc.length != 6) throw new IncorrectTakingGuidelinesException("Intruccions No Valides");
        if (!checkInstruc(instruc)) throw new IncorrectTakingGuidelinesException("Instruccions No Valides");
        prescription.replace(prodID, new TakingGuideline(
                dayMoment.valueOf(instruc[0]),
                Float.parseFloat(instruc[1]),
                instruc[2],
                Float.parseFloat(instruc[3]),
                Float.parseFloat(instruc[4]),
                FqUnit.valueOf(instruc[5]))
        );
    }

    public void removeLine(ProductID prodID)
            throws ProductNotInPrescription {
        if (!prescription.containsKey(prodID))
            throw new ProductNotInPrescription("Producte no es troba a la prescripció mèdica");
        prescription.remove(prodID);
    }

    private boolean checkInstruc(String[] instruccions) {
        //CHECK DAYMOMENT AND FREQUENCY
        dayMoment[] dayMoments = dayMoment.values();
        FqUnit[] fqUnits = FqUnit.values();
        boolean diferent = false;
        for (dayMoment d : dayMoments) {
            if ((d.toString().equals(instruccions[0]))) diferent = true;
        }
        for (FqUnit fqUnit : fqUnits) {
            if ((fqUnit.toString().equals(instruccions[instruccions.length - 1]))) diferent = true;
        }
        if (!diferent) return false;
        //CHECK OTHER ELEMENTS
        if (Integer.parseInt(instruccions[1]) < 0.0 || Integer.parseInt(instruccions[3]) < 0.0 || Integer.parseInt(instruccions[4]) < 0.0)
            return false;
        return true;
    }

}

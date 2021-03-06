package medicalconsultation;

import Exceptions.*;
import data.DigitalSignature;
import data.ProductID;
import data.*;
import java.util.Date;
import java.util.HashMap;

/**
 * The Medical Prescription of the patients linked with the Medical Prescription Line and the doctor.
 */

public class MedicalPrescription {
    private int prescCode;
    private Date prescDate;
    private Date endDate;
    private HealthCardID hcID; // the healthcard ID of the patient
    private DigitalSignature eSign; // the eSignature of the doctor
    private final HashMap<ProductID, MedicalPrescriptionLine> prescription;

    public MedicalPrescription(HealthCardID hcID) {
        this.hcID = hcID;
        this.prescription = new HashMap<>();
    }

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

    public MedicalPrescriptionLine getMedicalPrescLine(ProductID productID){return prescription.get(productID);}


    public void addLine(ProductID prodID, String[] instruc) throws IncorrectTakingGuidelinesException {
        MedicalPrescriptionLine MPL = check_setUp_MPL(prodID,instruc);
        prescription.put(prodID, MPL);
    }

    public void modifyLine(ProductID prodID, String[] instruc) throws ProductNotInPrescription, IncorrectTakingGuidelinesException {
        if (!prescription.containsKey(prodID))
            throw new ProductNotInPrescription("Producte no es troba a la prescripció mèdica");
        MedicalPrescriptionLine MPL = check_setUp_MPL(prodID,instruc);
        prescription.replace(prodID, MPL);
    }

    public void removeLine(ProductID prodID) throws ProductNotInPrescription {
        if (!prescription.containsKey(prodID))
            throw new ProductNotInPrescription("Producte no es troba a la prescripció mèdica");
        prescription.remove(prodID);
    }

    public boolean prescriptionEnabled() throws NotFinishedTreatmentException{
        Date currentDate = new Date();
        if(currentDate.after(this.endDate)) return true;
        throw new NotFinishedTreatmentException("No s'ha acabat el tractament en curs");
    }

    private boolean checkInstruc(String[] instruccions) {
        dayMoment[] dayMoments = dayMoment.values();
        FqUnit[] fqUnits = FqUnit.values();
        boolean diferent = false;
        for (dayMoment d : dayMoments) {
            if ((d.toString().equals(instruccions[0]))) diferent = true;
        }
        if(!diferent) return false;
        diferent = false;
        for (FqUnit fqUnit : fqUnits) {
            if ((fqUnit.toString().equals(instruccions[instruccions.length - 1]))) diferent = true;
        }
        if(!diferent) return false;
        if (Integer.parseInt(instruccions[1]) < 0.0 || Integer.parseInt(instruccions[3]) < 0.0 || Integer.parseInt(instruccions[4]) < 0.0)
        return false;
        return true;
    }

    private MedicalPrescriptionLine check_setUp_MPL(ProductID prod, String[] instruc) throws IncorrectTakingGuidelinesException{
        if (instruc.length != 6) throw new IncorrectTakingGuidelinesException("Intruccions No Valides");
        if (!checkInstruc(instruc)) throw new IncorrectTakingGuidelinesException("Instruccions No Valides");
        MedicalPrescriptionLine MPL = new MedicalPrescriptionLine(prod);
        MPL.setTakingGuideline(new TakingGuideline(
                dayMoment.valueOf(instruc[0]),
                Float.parseFloat(instruc[1]),
                instruc[2],
                Float.parseFloat(instruc[3]),
                Float.parseFloat(instruc[4]),
                FqUnit.valueOf(instruc[5]))
        );
        return MPL;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MedicalPrescription MP = (MedicalPrescription) obj;
        return hcID.equals(MP.hcID) &&
                prescription.equals(MP.prescription);
    }

}

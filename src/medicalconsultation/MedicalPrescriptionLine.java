package medicalconsultation;

import data.ProductID;

/**
 * The line of a Medical Prescription linked with the productID.
 */

public class MedicalPrescriptionLine {
    private ProductID pID;
    private TakingGuideline takingGuideline;

    public MedicalPrescriptionLine (ProductID productID){
        this.pID = productID;
    }

    public ProductID getpID() {
        return pID;
    }

    public void setpID(ProductID pID) {
        this.pID = pID;
    }

    public TakingGuideline getTakingGuideline() {
        return takingGuideline;
    }

    public void setTakingGuideline(TakingGuideline takingGuideline) {
        this.takingGuideline = takingGuideline;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MedicalPrescriptionLine MPL = (MedicalPrescriptionLine) obj;
        return pID.equals(MPL.pID) && takingGuideline.equals(MPL.takingGuideline);
    }
}
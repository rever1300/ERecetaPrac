package medicalconsultation;

import data.ProductID;

public class MedicalPrescriptionLine {
    private ProductID pID;
    private TakingGuideline takingGuideline;


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
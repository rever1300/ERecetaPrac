package medicalconsultation;

import data.ProductID;

import java.util.HashMap;

public class MedicalPrescriptionLine {
        private HashMap<ProductID,TakingGuideline> hashMap;

    public MedicalPrescriptionLine() {
        this.hashMap = new HashMap<>();
    }

    public void setLine(ProductID pID, dayMoment dM, float du, String i, float d, float f, FqUnit u) {
        hashMap.put(pID, new TakingGuideline(dM, du, i, d, f, u));
    }
}
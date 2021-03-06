package medicalconsultation;

/**
 * The medicine instructions.
 */

public class Posology {
    private float dose;
    private float freq;
    private FqUnit freqUnit;

    public Posology (float d, float f, FqUnit u) {
        this.dose=d;
        this.freq=f;
        this.freqUnit=u;
    }

    public float getDose() {
        return dose;
    }

    public void setDose(float dose) {
        this.dose = dose;
    }

    public float getFreq() {
        return freq;
    }

    public void setFreq(float freq) {
        this.freq = freq;
    }

    public FqUnit getFreqUnit() {
        return freqUnit;
    }

    public void setFreqUnit(FqUnit freqUnit) {
        this.freqUnit = freqUnit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Posology pos = (Posology) obj;
        return dose == pos.dose && freq == pos.freq && freqUnit.equals(pos.freqUnit);
    }
}



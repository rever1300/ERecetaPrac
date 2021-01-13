package medicalconsultation;


public class Posology {
    private float dose;
    private float freq;
    private FqUnit freqUnit;
    private float prova;


    // Initializes attributes
    public Posology (float d, float f, FqUnit u) {
        this.dose=d;
        this.freq=f;
        this.freqUnit=u;
    }

   // the getters and setters
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
}


package data;

import java.util.Arrays;

final public class DigitalSignature {
    private final Byte[] medicalSignature;

    public DigitalSignature(int mida) { //---INTRODUIM MIDA AL BYTE[]---//
        medicalSignature = new Byte[mida];
    }
    public DigitalSignature(){ //---PER DEFECTE -->20---//
        medicalSignature = new Byte[20];
    }

    public String getDigitalSignature() {
        return Arrays.toString(medicalSignature);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass()!= o.getClass()) return false;
        DigitalSignature ds = (DigitalSignature) o;
        return Arrays.equals(medicalSignature, ds.medicalSignature);
    }

    @Override
    public int hashCode(){
        return Arrays.hashCode(medicalSignature);
    }

    @Override
    public String toString(){
        String MSign="{ ";
        for (Byte aByte : medicalSignature) {
            MSign = MSign.concat(aByte + ", ");
        }
        MSign += " }";
        return MSign;
    }
}

package data;

import Exceptions.dataE.eSignatureException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * The Digital Signature of the doctor.
 */

final public class DigitalSignature {

    private final byte[] digitalSignature;

    public DigitalSignature(byte[] signature)throws eSignatureException {
        if(signature == null){
            throw new eSignatureException("No has introduit la signatura digital");
        }
        this.digitalSignature = signature;
    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass()!= o.getClass()) return false;
        DigitalSignature ds = (DigitalSignature) o;
        return Arrays.equals(digitalSignature, ds.digitalSignature);
    }

    @Override
    public int hashCode(){
        return Arrays.hashCode(digitalSignature);
    }

    @Override
    public String toString(){
        String dSignature= new String(digitalSignature, StandardCharsets.UTF_8);
        return "DigitalSignature{" + "Signatura='" + dSignature + '\'' + '}';
    }

}

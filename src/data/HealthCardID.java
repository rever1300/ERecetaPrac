package data;
/**
 * The personal identifying code in the National Health Service.
 */

final public class HealthCardID {
    private final String personalID;

    public HealthCardID(String code) throws IllegalArgumentException{
        if(code == null || isValid(code))throw new IllegalArgumentException("El codi de la tarjeta es incorrecte");
        this.personalID = code;
    }
    public boolean isValid(String code) {
        if(code.length()!=28) return false;
        for(int i=0; i < 28; i++){
            //---COMPROVEM LES B's---//
            if(i<8) {
                if(code.charAt(i)!='B') return false;
            }//---COMPROVEM LES 2 LLETRES---//
            else if(i<10){
                if(!Character.isLetter(code.charAt(i))) return false;
            }//---COMPROVEM ELS ULTIMS SON DIGITS---//
            else{
                if(!Character.isDigit(code.charAt(i))) return false;
            }
        }
        return true;
    }
    public String getPersonalID() { return personalID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthCardID hcardID = (HealthCardID) o;
        return personalID.equals(hcardID.personalID);
    }
    @Override
    public int hashCode() { return personalID.hashCode(); }
    @Override
    public String toString() {
        return "HealthCardID{" + "personal code='" + personalID + '\'' + '}';
    }
}

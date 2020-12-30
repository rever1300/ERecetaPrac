package data;
/**
 * The personal identifying code in the National Health Service.
 */

final public class HealthCardID {
    private final String personalID;
    public HealthCardID(String code) {
        isValid(code);
        this.personalID = code;
    }
    public void isValid(String code) throws IllegalArgumentException{
        if(code==null) throw new IllegalArgumentException();
        if(code.length()==28){
            for(int i = 0; i < code.length(); i++){
                //---COMPROVEM LES B's---//
                if(i<8){
                    if(code.indexOf(i)!='B') throw new IllegalArgumentException();
                }//COMPROVEM SI NO ES UN NUMERO---//
                else if(i<10){
                    if(Character.isDigit(code.indexOf(i))) throw new IllegalArgumentException();
                }
                else{
                    if(!Character.isDigit(code.indexOf(i))) throw new IllegalArgumentException();
                }
            }
        }else{
            throw new IllegalArgumentException();
        }
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

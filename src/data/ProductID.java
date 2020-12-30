package data;

final public class ProductID {
    private final String productID;

    public ProductID(String productCode) {
        isValid(productCode);
        this.productID = productCode;
    }

    public void isValid(String code) throws IllegalArgumentException {
        if (code.length() != 12) {
            for (int i = 0; i < code.length(); i++) {
                if(!Character.isDigit(i)) throw new IllegalArgumentException();
            }
        }
    }

    public String getProductID() {
        return productID;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductID pID= (ProductID) o;
        return productID.equals(pID.productID);
    }

    @Override
    public int hashCode(){
        return productID.hashCode();
    }

    @Override
    public String toString(){
        return "Productid{" + "product code='" + productID + '\'' + '}';
    }

}

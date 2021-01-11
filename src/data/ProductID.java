package data;

import Exceptions.dataE.ProductIDException;

final public class ProductID {
    private final String productID;

    public ProductID(String productCode) throws ProductIDException {
        if(productCode == null || !isValid(productCode)){
            throw new ProductIDException("El codi del producte es incorrecte");
        }
        this.productID = productCode;
    }

    public boolean isValid(String code) {
        if (code.length() != 12) return false;
        for (int i = 0; i < code.length(); i++) {
                if(!Character.isDigit(code.charAt(i))) return false;
        }
        return true;
    }

    public String getProductID() { return productID; }

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
        return "ProductID{" + "Product Code='" + productID + '\'' + '}';
    }

}

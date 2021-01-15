package ClassesDobles;

import Exceptions.*;
import Exceptions.dataE.HealthCardException;
import Exceptions.dataE.ProductIDException;
import Exceptions.dataE.eSignatureException;
import data.HealthCardID;
import data.ProductID;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;
import services.HealthNationalService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HNSeSignatureException  implements HealthNationalService {

    private final List<ProductSpecification> productSpecificationsList = new ArrayList<>();
    private MedicalPrescription MP;

    @Override
    public MedicalPrescription getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException, ProductIDException, IncorrectTakingGuidelinesException {
        MP = new MedicalPrescription(hcID);
        ProductID PID = new ProductID("147852369018");
        String[] instruccions = {"DURINGMEALS", "10", "Maxim 5 pastilles per dia", "2", "4", "HOUR"};
        MP.addLine(PID,instruccions);
        return MP;
    }

    @Override
    public List<ProductSpecification> getProductsByKW(String keyWord) throws AnyKeyWordMedicineException, ConnectException, ProductIDException {
        ProductID pid = new ProductID("987654321012");
        String desc = "Pastilles pel mal de cap";
        BigDecimal price = new BigDecimal(5);
        ProductSpecification pS = new ProductSpecification(pid, desc, price);
        ProductID pid2 = new ProductID("987654312345");
        String desc2 = "Pastilles pel mal de panxa";
        BigDecimal price2 = new BigDecimal(4);
        ProductSpecification pS2 = new ProductSpecification(pid2, desc2, price2);
        productSpecificationsList.add(pS);
        productSpecificationsList.add(pS2);
        return productSpecificationsList;
    }

    @Override
    public ProductSpecification getProductSpecific(int opt) throws AnyMedicineSearchException, ConnectException {
        return productSpecificationsList.get(opt);
    }

    @Override
    public MedicalPrescription sendePrescription(MedicalPrescription ePresc) throws ConnectException, NotValidePrescriptionException, eSignatureException, NotCompletedMedicalPrescription {
        throw new eSignatureException("No s'ha estampat la signatura");
    }
}

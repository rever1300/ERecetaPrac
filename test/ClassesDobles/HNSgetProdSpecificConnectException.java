package ClassesDobles;

import Exceptions.*;
import Exceptions.dataE.HealthCardIDException;
import Exceptions.dataE.ProductIDException;
import Exceptions.dataE.eSignatureException;
import data.HealthCardID;
import data.ProductID;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;
import services.HealthNationalService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HNSgetProdSpecificConnectException implements HealthNationalService {

    private List<ProductSpecification> productSpecificationsList = new ArrayList<>();
    private MedicalPrescription MP;

    @Override
    public MedicalPrescription getePrescription(HealthCardID hcID) throws HealthCardIDException, NotValidePrescriptionException, ConnectException, ProductIDException, IncorrectTakingGuidelinesException {
        Date prescDate = new Date(2020, Calendar.JANUARY,3);
        MP = new MedicalPrescription(prescDate, hcID);
        return MP;
    }

    @Override
    public List<ProductSpecification> getProductsByKW(String keyWord) throws AnyKeyWordMedicineException, ConnectException, ProductIDException {
        ProductID pid = new ProductID("987654321012");
        String desc = "Ibuprofeno";
        BigDecimal price = new BigDecimal(5);
        ProductSpecification pS = new ProductSpecification(pid, desc, price);
        ProductID pid2 = new ProductID("12345678945");
        String desc2 = "Paracetamol";
        BigDecimal price2 = new BigDecimal(4);
        ProductSpecification pS2 = new ProductSpecification(pid2, desc2, price2);
        productSpecificationsList.add(pS);
        productSpecificationsList.add(pS2);
        return productSpecificationsList;
    }

    @Override
    public ProductSpecification getProductSpecific(int opt) throws AnyMedicineSearchException, ConnectException {
        throw new ConnectException("Error al conectar amb el HNS");
    }

    @Override
    public MedicalPrescription sendePrescription(MedicalPrescription ePresc) throws ConnectException, NotValidePrescriptionException, eSignatureException, NotCompletedMedicalPrescription {
        MP = ePresc;
        MP.setPrescCode(38);
        MP.setEndDate(new Date(2032,Calendar.MAY,5));
        return MP;
    }
}

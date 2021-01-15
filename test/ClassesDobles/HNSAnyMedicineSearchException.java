package ClassesDobles;

import Exceptions.*;
import Exceptions.dataE.HealthCardException;
import Exceptions.dataE.ProductIDException;
import Exceptions.dataE.eSignatureException;
import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;
import services.HealthNationalService;

import java.util.List;

public class HNSAnyMedicineSearchException implements HealthNationalService {

    private MedicalPrescription MP;

    @Override
    public MedicalPrescription getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException, ProductIDException, IncorrectTakingGuidelinesException {
        MP = new MedicalPrescription(hcID);
        ProductID PID = new ProductID("222222222222");
        String[] instruc = {"DURINGMEALS", "10", "Maxim 5 pastilles per dia", "2", "4", "HOUR"};
        MP.addLine(PID,instruc);
        return MP;
    }

    @Override
    public List<ProductSpecification> getProductsByKW(String keyWord) throws AnyKeyWordMedicineException, ConnectException, ProductIDException {
        return null;
    }

    @Override
    public ProductSpecification getProductSpecific(int opt) throws AnyMedicineSearchException, ConnectException {
        throw new AnyMedicineSearchException("No hi ha cap cerca");
    }

    @Override
    public MedicalPrescription sendePrescription(MedicalPrescription ePresc) throws ConnectException, NotValidePrescriptionException, eSignatureException, NotCompletedMedicalPrescription {
        MP = ePresc;
        MP.setPrescCode(38);
        MP.seteSign(new DigitalSignature("Maria".getBytes()));
        return MP;
    }
}

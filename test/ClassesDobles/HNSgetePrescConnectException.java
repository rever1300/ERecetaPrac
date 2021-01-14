package ClassesDobles;

import Exceptions.*;
import Exceptions.dataE.HealthCardIDException;
import Exceptions.dataE.ProductIDException;
import Exceptions.dataE.eSignatureException;
import data.HealthCardID;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;
import services.HealthNationalService;

import java.util.List;

public class HNSgetePrescConnectException implements HealthNationalService {
    @Override
    public MedicalPrescription getePrescription(HealthCardID hcID) throws HealthCardIDException, NotValidePrescriptionException, ConnectException, ProductIDException, IncorrectTakingGuidelinesException {
        throw new ConnectException("Error al conectar amb el HNS");
    }

    @Override
    public List<ProductSpecification> getProductsByKW(String keyWord) throws AnyKeyWordMedicineException, ConnectException, ProductIDException {
        return null;
    }

    @Override
    public ProductSpecification getProductSpecific(int opt) throws AnyMedicineSearchException, ConnectException {
        return null;
    }

    @Override
    public MedicalPrescription sendePrescription(MedicalPrescription ePresc) throws ConnectException, NotValidePrescriptionException, eSignatureException, NotCompletedMedicalPrescription {
        return null;
    }
}

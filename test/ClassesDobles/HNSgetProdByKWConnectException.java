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
import java.util.List;

public class HNSgetProdByKWConnectException implements HealthNationalService {

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
        throw new ConnectException("Error al conectar amb el HNS");
    }

    @Override
    public ProductSpecification getProductSpecific(int opt) throws AnyMedicineSearchException, ConnectException {
        throw new AnyMedicineSearchException("No hi ha cap cerca");
    }

    @Override
    public MedicalPrescription sendePrescription(MedicalPrescription ePresc) throws ConnectException, NotValidePrescriptionException, eSignatureException, NotCompletedMedicalPrescription {
        MP = ePresc;
        MP.setPrescCode(38);
        return MP;
    }
}

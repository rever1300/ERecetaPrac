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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HNSAnyMedicineSearchException implements HealthNationalService {

    private MedicalPrescription MP;

    @Override
    public MedicalPrescription getePrescription(HealthCardID hcID) throws HealthCardIDException, NotValidePrescriptionException, ConnectException, ProductIDException, IncorrectTakingGuidelinesException {
        Date prescDate = new Date(2020, Calendar.JANUARY,3);
        MP = new MedicalPrescription(prescDate, hcID);
        ProductID PID = new ProductID("222222222222");
        String[] instruccions = {"DURINGMEALS", "10", "Maxim 5 pastilles per dia", "2", "4", "HOUR"};
        MP.addLine(PID,instruccions);
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
        MP.setEndDate(new Date(2032,Calendar.MAY,5));
        return MP;
    }
}

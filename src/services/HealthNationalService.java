package services;

import Exceptions.*;
import Exceptions.dataE.HealthCardIDException;
import Exceptions.dataE.ProductIDException;
import Exceptions.dataE.eSignatureException;
import data.*;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;

import java.util.List;

public interface HealthNationalService  {
    MedicalPrescription getePrescription(HealthCardID hcID)
            throws HealthCardIDException, NotValidePrescriptionException,
            ConnectException, ProductIDException, IncorrectTakingGuidelinesException;
    List<ProductSpecification> getProductsByKW(String keyWord)
            throws AnyKeyWordMedicineException, ConnectException, ProductIDException;
    ProductSpecification getProductSpecific(int opt)
            throws AnyMedicineSearchException, ConnectException;
    MedicalPrescription sendePrescription(MedicalPrescription ePresc)
            throws ConnectException, NotValidePrescriptionException, eSignatureException,
            NotCompletedMedicalPrescription;
}

package services;

import Exceptions.*;
import Exceptions.dataE.HealthCardException;
import Exceptions.dataE.ProductIDException;
import Exceptions.dataE.eSignatureException;
import data.*;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;

import java.util.List;

/**
 * The interface of the HealthNationalService.
 */

public interface HealthNationalService  {
    MedicalPrescription getePrescription(HealthCardID hcID)
            throws HealthCardException, NotValidePrescriptionException,
            ConnectException, ProductIDException, IncorrectTakingGuidelinesException;
    List<ProductSpecification> getProductsByKW(String keyWord)
            throws AnyKeyWordMedicineException, ConnectException, ProductIDException;
    ProductSpecification getProductSpecific(int opt)
            throws AnyMedicineSearchException, ConnectException;
    MedicalPrescription sendePrescription(MedicalPrescription ePresc)
            throws ConnectException, NotValidePrescriptionException, eSignatureException,
            NotCompletedMedicalPrescription;
}

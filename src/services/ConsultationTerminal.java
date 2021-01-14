package services;

import Exceptions.*;
import Exceptions.dataE.HealthCardIDException;
import Exceptions.dataE.ProductIDException;
import Exceptions.dataE.eSignatureException;
import data.DigitalSignature;
import data.HealthCardID;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;

import java.util.Date;
import java.util.List;

public class ConsultationTerminal {
    private HealthNationalService hns;
    private ScheduledVisitAgenda sva;
    private HealthCardID healthCardID;
    private MedicalPrescription medicalPrescription;
    private List<ProductSpecification> medicament;
    private ProductSpecification productSpecification;
    private DigitalSignature digitalSignature;



    public void setScheduledVisitAgenda(ScheduledVisitAgenda scheduledVisitAgenda) {
        this.sva = scheduledVisitAgenda;
    }

    public void setHNS(HealthNationalService hns) {
        this.hns = hns;
    }

    public void setDigitalSignature(DigitalSignature digitalSignature){
        this.digitalSignature=digitalSignature;
    }

    public void initRevision() throws HealthCardIDException, NotValidePrescriptionException, ConnectException, IncorrectTakingGuidelinesException, ProductIDException {
        healthCardID = sva.getHealthCardID();
        medicalPrescription = hns.getePrescription(healthCardID);
    }

    public void initPrescriptionEdition() throws AnyCurrentPrescriptionException, NotFinishedTreatmentException {
        if (medicalPrescription == null) throw new AnyCurrentPrescriptionException("No hi ha una prescripció en curs");
        medicalPrescription.prescriptionEnabled();
    }

    public void searchForProducts(String keyWord) throws AnyKeyWordMedicineException, ConnectException, ProductIDException {
        medicament = hns.getProductsByKW(keyWord);
    }

    public void selectProduct(int option) throws AnyMedicineSearchException, ConnectException {
        productSpecification = hns.getProductSpecific(option);
    }

    public void enterMedicineGuidelines(String[] instruc) throws AnySelectedMedicineException, IncorrectTakingGuidelinesException {
        if(productSpecification==null) throw new AnySelectedMedicineException("No s'ha seleccionat ningun medicament");
        medicalPrescription.addLine(productSpecification.getUPCcode(), instruc);
    }

    public void enterTreatmentEndingDate(Date date) throws IncorrectEndingDateException {
        Date actual = new Date();
        if(date==null || date.before(actual)) throw new IncorrectEndingDateException("Data incorrecta");
        medicalPrescription.setPrescDate(new Date());
        medicalPrescription.setEndDate(date);
    }

    public void sendePrescription() throws ConnectException, NotValidePrescriptionException, eSignatureException, NotCompletedMedicalPrescription {
        medicalPrescription.seteSign(this.digitalSignature);
        medicalPrescription = hns.sendePrescription(medicalPrescription);
    }

    public void printePresc() throws printingException {
    }


    // Other methods, apart from the input events

}

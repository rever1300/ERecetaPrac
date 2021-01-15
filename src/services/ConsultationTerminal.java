package services;

import Exceptions.*;
import Exceptions.dataE.HealthCardException;
import Exceptions.dataE.HealthCardFormatException;
import Exceptions.dataE.ProductIDException;
import Exceptions.dataE.eSignatureException;
import data.HealthCardID;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.ProductSpecification;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The terminal where the doctor will set the MedicalPrescriptions and the connection with the HNS.
 */

public class ConsultationTerminal {
    private HealthNationalService hns;
    private ScheduledVisitAgenda sva;
    private HealthCardID healthCardID;
    private MedicalPrescription medPrescription;
    private List<ProductSpecification> medicament;
    private ProductSpecification prodSpecification;



    public void setSVA(ScheduledVisitAgenda scheduledVisitAgenda) {
        this.sva = scheduledVisitAgenda;
    }

    public void setHNS(HealthNationalService hns) {
        this.hns = hns;
    }

    public HealthCardID getHCID(){
        return this.healthCardID;
    }

    public MedicalPrescription getMedPrescription(){
        return this.medPrescription;
    }

    public List<ProductSpecification> getMedicament(){
        return this.medicament;
    }

    public ProductSpecification getProdSpecification(){
        return this.prodSpecification;
    }

    public void initRevision() throws HealthCardException, NotValidePrescriptionException, ConnectException, IncorrectTakingGuidelinesException, ProductIDException, HealthCardFormatException {
        healthCardID = sva.getHealthCardID();
        medPrescription = hns.getePrescription(healthCardID);
    }

    public void initPrescriptionEdition() throws AnyCurrentPrescriptionException, NotFinishedTreatmentException {
        if (medPrescription == null) throw new AnyCurrentPrescriptionException("No hi ha una prescripció en curs");
        medPrescription.prescriptionEnabled();
    }

    public void searchForProducts(String keyWord) throws AnyKeyWordMedicineException, ConnectException, ProductIDException {
        medicament = hns.getProductsByKW(keyWord);
    }

    public void selectProduct(int option) throws AnyMedicineSearchException, ConnectException {
        prodSpecification = hns.getProductSpecific(option);
    }

    public void enterMedicineGuidelines(String[] instruc) throws AnySelectedMedicineException, IncorrectTakingGuidelinesException {
        if(prodSpecification ==null) throw new AnySelectedMedicineException("No s'ha seleccionat ningun medicament");
        medPrescription.addLine(prodSpecification.getUPCcode(), instruc);
    }

    public void enterTreatmentEndingDate(Date date) throws IncorrectEndingDateException {
        Date actual = new Date(2020, Calendar.JANUARY,3);
        if(date==null || date.before(actual)) throw new IncorrectEndingDateException("Data incorrecta");
        medPrescription.setPrescDate(actual);
        medPrescription.setEndDate(date);
    }

    public void sendePrescription() throws ConnectException, NotValidePrescriptionException, eSignatureException, NotCompletedMedicalPrescription {
        medPrescription = hns.sendePrescription(medPrescription);
    }

    public void printePresc() throws printingException {
    }

}

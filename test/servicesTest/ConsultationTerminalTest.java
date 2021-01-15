package servicesTest;

import ClassesDobles.HNSGood;
import ClassesDobles.SVAGood;
import Exceptions.*;
import Exceptions.dataE.HealthCardException;
import Exceptions.dataE.HealthCardFormatException;
import Exceptions.dataE.ProductIDException;
import Exceptions.dataE.eSignatureException;
import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import medicalconsultation.MedicalPrescription;
import medicalconsultation.MedicalPrescriptionLine;
import medicalconsultation.ProductSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ConsultationTerminal;
import services.HealthNationalService;
import services.ScheduledVisitAgenda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConsultationTerminalTest {

    private ConsultationTerminal ct;
    private HealthNationalService hns;
    private ScheduledVisitAgenda sva;
    private HealthCardID expectedhcid;
    private MedicalPrescription expectedMP;
    private List<ProductSpecification> listKW;


    @BeforeEach
    public void init() throws HealthCardFormatException, eSignatureException, ProductIDException, IncorrectTakingGuidelinesException {
        hns = new HNSGood();
        sva = new SVAGood();
        ct = new ConsultationTerminal();
        ct.setHNS(hns);
        ct.setSVA(sva);
        expectedhcid = new HealthCardID("BBBBBBBBRT142536987898745610");
        setUpExpectedMedicalPrescription();
        setUpList();
    }

    private void setUpExpectedMedicalPrescription() throws eSignatureException, ProductIDException, IncorrectTakingGuidelinesException {
        int prescCode = 38;
        Date prescDate = new Date(2020, Calendar.JANUARY,3);
        Date endDate = new Date(2032,Calendar.MAY,5);
        DigitalSignature ds = new DigitalSignature("Jaimito".getBytes());
        MedicalPrescriptionLine MPL = new MedicalPrescriptionLine();
        MPL.setpID(new ProductID("147852369018"));
        String[] ins = {"DURINGMEALS", "10", "Maxim 5 pastilles per dia", "2", "4", "HOUR"};
        expectedMP = new MedicalPrescription(expectedhcid);
        expectedMP.setPrescCode(prescCode);
        expectedMP.setEndDate(endDate);
        expectedMP.seteSign(ds);
        expectedMP.setPrescDate(prescDate);
        expectedMP.addLine(MPL.getpID(), ins);
    }

    private void setUpList() throws ProductIDException {
        listKW = new ArrayList<>();
        ProductID pid = new ProductID("987654321012");
        String desc = "Pastilles pel mal de cap";
        BigDecimal price = new BigDecimal(5);
        ProductSpecification pS = new ProductSpecification(pid, desc, price);
        ProductID pid2 = new ProductID("987654312345");
        String desc2 = "Pastilles pel mal de panxa";
        BigDecimal price2 = new BigDecimal(4);
        ProductSpecification pS2 = new ProductSpecification(pid2, desc2, price2);
        listKW.add(pS);
        listKW.add(pS2);

    }

    @Test
    public void initRevision () throws NotValidePrescriptionException, IncorrectTakingGuidelinesException, ConnectException, HealthCardException, ProductIDException, HealthCardFormatException {
        ct.initRevision();
        assertEquals(expectedhcid,ct.getHCID());
        assertEquals(expectedMP,ct.getMedicalPrescription());
    }

    @Test
    public void searchForProducts() throws NotValidePrescriptionException, IncorrectTakingGuidelinesException, ConnectException, HealthCardException, ProductIDException, AnyKeyWordMedicineException, HealthCardFormatException {
        ct.initRevision();
        ct.searchForProducts("9876543");
        assertEquals(listKW, ct.getMedicament());
    }

    @Test
    public void selectProduct() throws NotValidePrescriptionException, IncorrectTakingGuidelinesException, ConnectException, HealthCardException, ProductIDException, AnyKeyWordMedicineException, AnyMedicineSearchException, HealthCardFormatException {
        ct.initRevision();
        ct.searchForProducts("9876543");
        ct.selectProduct(1);
        assertEquals(listKW.get(1), ct.getProductSpecification());
    }

    @Test
    public void enterMedicineGuidelines() throws ProductIDException, NotValidePrescriptionException, IncorrectTakingGuidelinesException, ConnectException, HealthCardException, AnyKeyWordMedicineException, AnyMedicineSearchException, AnySelectedMedicineException, HealthCardFormatException {
        ProductID pid = new ProductID("987654312345");
        String[] instruc = {"DURINGDINNER", "6", "Maxim 5 pastilles per dia", "8", "7", "MONTH"};
        expectedMP.addLine(pid,instruc);
        ct.initRevision();
        ct.searchForProducts("9876543");
        ct.selectProduct(1);
        ct.enterMedicineGuidelines(instruc);
        assertEquals(expectedMP, ct.getMedicalPrescription());
    }

    @Test
    public void enterTreatmentEndingDate() throws NotValidePrescriptionException, IncorrectTakingGuidelinesException, ConnectException, HealthCardException, ProductIDException, IncorrectEndingDateException, HealthCardFormatException {
        ct.initRevision();
        ct.enterTreatmentEndingDate(new Date(2032,Calendar.MAY,5));
        assertEquals(expectedMP.getEndDate(), ct.getMedicalPrescription().getEndDate());
        assertEquals(expectedMP.getPrescDate(), ct.getMedicalPrescription().getPrescDate());
    }

    @Test
    public void sendePrescription() throws NotValidePrescriptionException, IncorrectTakingGuidelinesException, ConnectException, HealthCardException, ProductIDException, IncorrectEndingDateException, eSignatureException, NotCompletedMedicalPrescription, HealthCardFormatException {
        ct.initRevision();
        ct.enterTreatmentEndingDate(new Date(2032,Calendar.MAY,5));
        ct.sendePrescription();
        assertEquals(expectedMP.geteSign(), ct.getMedicalPrescription().geteSign());
        assertEquals(expectedMP.getPrescCode(), ct.getMedicalPrescription().getPrescCode());
    }

    @Test
    public void initPrescriptionEdition() throws NotValidePrescriptionException, IncorrectTakingGuidelinesException, ConnectException, HealthCardException, ProductIDException, eSignatureException, NotCompletedMedicalPrescription, IncorrectEndingDateException, HealthCardFormatException {
        ct.initRevision();
        ct.enterTreatmentEndingDate(new Date(2032,Calendar.MAY,5));
        ct.sendePrescription();
        assertThrows(NotFinishedTreatmentException.class, () -> ct.initPrescriptionEdition());
    }




















}

package servicesTest;

import ClassesDobles.*;
import Exceptions.*;
import Exceptions.dataE.HealthCardException;
import Exceptions.dataE.HealthCardFormatException;
import Exceptions.dataE.ProductIDException;
import Exceptions.dataE.eSignatureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ConsultationTerminal;
import services.HealthNationalService;
import services.ScheduledVisitAgenda;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConsultationTerminalExceptionTest {

    private ConsultationTerminal ct;

    @BeforeEach
    public void initialize(){
        ct = new ConsultationTerminal();
    }

    private void setUpConsultationTerminal(HealthNationalService hns, ScheduledVisitAgenda sva){
        ct.setHNS(hns);
        ct.setSVA(sva);
    }

    //----------- SVA Test -----------//

    @Test
    public void initRevisionSVAExceptionTest(){
        HealthNationalService hns = new HNSGood();
        ScheduledVisitAgenda sva = new SVAHealthCardIDException();
        setUpConsultationTerminal(hns, sva);
        assertThrows(HealthCardException.class, () -> ct.initRevision());
    }

    //----------- getePrescrition Tests -----------//

    @Test
    public void getePresc_ConnectException(){
        HealthNationalService hns = new HNSgetePrescConnectException();
        ScheduledVisitAgenda sva = new SVAGood();
        setUpConsultationTerminal(hns, sva);
        assertThrows(ConnectException.class, () -> ct.initRevision());
    }

    @Test
    public void getePresc_HealthCardException(){
        HealthNationalService hns = new HNSHealthCardException();
        ScheduledVisitAgenda sva = new SVAGood();
        setUpConsultationTerminal(hns, sva);
        assertThrows(HealthCardException.class, () -> ct.initRevision());
    }

    @Test
    public void getePresc_NoValidPrescException(){
        HealthNationalService hns = new HNSNoValidPrescException();
        ScheduledVisitAgenda sva = new SVAGood();
        setUpConsultationTerminal(hns, sva);
        assertThrows(NotValidePrescriptionException.class, () -> ct.initRevision());
    }


    //----------- getProductByKW Tests -----------//

    @Test
    public void getProdByKW_ConnectException() throws ConnectException, NotValidePrescriptionException, HealthCardFormatException, HealthCardException, ProductIDException, IncorrectTakingGuidelinesException {
        HealthNationalService hns = new HNSgetProdByKWConnectException();
        ScheduledVisitAgenda sva = new SVAGood();
        setUpConsultationTerminal(hns, sva);
        ct.initRevision();
        assertThrows(ConnectException.class, () -> ct.searchForProducts("9876543"));
    }

    @Test
    public void getProdByKW_AnyKWMedicineException() throws ConnectException, NotValidePrescriptionException, HealthCardFormatException, HealthCardException, ProductIDException, IncorrectTakingGuidelinesException {
        HealthNationalService hns = new HNSAnyKWMedicineException();
        ScheduledVisitAgenda sva = new SVAGood();
        setUpConsultationTerminal(hns, sva);
        ct.initRevision();
        assertThrows(AnyKeyWordMedicineException.class, () -> ct.searchForProducts("2135874"));
    }



    //----------- getProductSpecific Tests -----------//

    @Test
    public void getProdSpecific_ConnectException() throws ConnectException, NotValidePrescriptionException, HealthCardFormatException, HealthCardException, ProductIDException, IncorrectTakingGuidelinesException, AnyKeyWordMedicineException {
        HealthNationalService hns = new HNSgetProdSpecificConnectException();
        ScheduledVisitAgenda sva = new SVAGood();
        setUpConsultationTerminal(hns, sva);
        ct.initRevision();
        ct.searchForProducts("9876543");
        assertThrows(ConnectException.class, () -> ct.selectProduct(1));
    }

    @Test
    public void getProdSpecific_AnyMedicineSearchException() throws ConnectException, NotValidePrescriptionException, HealthCardFormatException, HealthCardException, ProductIDException, IncorrectTakingGuidelinesException, AnyKeyWordMedicineException, NotFinishedTreatmentException, AnyCurrentPrescriptionException {
        HealthNationalService hns = new HNSAnyMedicineSearchException();
        ScheduledVisitAgenda sva = new SVAGood();
        setUpConsultationTerminal(hns, sva);
        ct.initRevision();
        assertThrows(AnyMedicineSearchException.class, () -> ct.selectProduct(0));
    }


    //----------- ePrescrition Tests -----------//

    @Test
    public void sendEPresc_ConnectException() throws ConnectException, NotValidePrescriptionException, HealthCardFormatException, HealthCardException, ProductIDException, IncorrectTakingGuidelinesException, AnyKeyWordMedicineException, AnyMedicineSearchException, AnySelectedMedicineException, IncorrectEndingDateException {
        HealthNationalService hns = new HNSsendEPrescConnectException();
        ScheduledVisitAgenda sva = new SVAGood();
        setUpConsultationTerminal(hns, sva);
        ct.initRevision();
        ct.searchForProducts("9876543");
        ct.selectProduct(1);
        String[] instruc = {"DURINGDINNER", "6", "Maxim 5 pastilles per dia", "8", "7", "MONTH"};
        ct.enterMedicineGuidelines(instruc);
        ct.enterTreatmentEndingDate(new Date(2032, Calendar.MAY,5));
        assertThrows(ConnectException.class, () -> ct.sendePrescription());
    }

    @Test
    public void sendEPresc_eSignatureException() throws ConnectException, NotValidePrescriptionException, HealthCardFormatException, HealthCardException, ProductIDException, IncorrectTakingGuidelinesException, AnyKeyWordMedicineException, AnyMedicineSearchException, AnySelectedMedicineException, IncorrectEndingDateException {
        HealthNationalService hns = new HNSeSignatureException();
        ScheduledVisitAgenda sva = new SVAGood();
        setUpConsultationTerminal(hns, sva);
        ct.initRevision();
        ct.searchForProducts("9876543");
        ct.selectProduct(1);
        String[] instruc = {"DURINGDINNER", "6", "Maxim 5 pastilles per dia", "8", "7", "MONTH"};
        ct.enterMedicineGuidelines(instruc);
        ct.enterTreatmentEndingDate(new Date(2032, Calendar.MAY,5));
        assertThrows(eSignatureException.class, () -> ct.sendePrescription());
    }

}

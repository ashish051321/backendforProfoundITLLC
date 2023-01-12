package com.profounditllc.backendforwebsite.services;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.profounditllc.backendforwebsite.models.CptyLoanTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

@Component
public class AppCacheService {

    @Autowired
    HazelcastInstance hazelcastInstance;

    private final Random random = new Random();


    @PostConstruct
    public void populateDataOnStartup(){
        IMap<String, CptyLoanTransaction> loanTransactionsCache = hazelcastInstance.getMap("loanTransactions");
        for (int i = 1; i <= 100000; i++) {
            CptyLoanTransaction loanTransaction = new CptyLoanTransaction();
            loanTransaction.setLoanNumber("LN" + i);
            loanTransaction.setLoanStartDate(new Date());
            loanTransaction.setLoanMaturityDate(new Date());
            loanTransaction.setLoanAmount(new BigDecimal(random.nextInt(1000000)));
            loanTransaction.setRemainingLoanAmount(new BigDecimal(random.nextInt(1000000)));
            loanTransaction.setLoanCurrency("USD");
            loanTransaction.setLoanType("Personal");
            loanTransaction.setLoanPurpose("Home renovation");
            loanTransaction.setLoanCounterparty("John Smith");
            loanTransaction.setLoanCounterpartyType("Individual");
            loanTransaction.setLoanCounterpartyRating("A");
            loanTransaction.setLoanCounterpartyCountry("USA");
            loanTransaction.setLoanCounterpartyIndustry("Finance");
            loanTransaction.setLoanCounterpartyContactName("John Smith");
            loanTransaction.setLoanCounterpartyContactEmail("john.smith@gmail.com");
            loanTransaction.setLoanCounterpartyContactPhone("123-456-7890");
            loanTransaction.setLoanCollateral("Home");
            loanTransaction.setLoanGuarantor("Jane Smith");
            loanTransaction.setLoanRepaymentSchedule("Monthly");
            loanTransaction.setLoanRepaymentFrequency("1");
            loanTransaction.setLoanInterestRate(new BigDecimal(random.nextInt(10)));
            loanTransaction.setLoanServiceCharge(new BigDecimal(random.nextInt(10)));
            loanTransaction.setLoanDocumentationStatus("Completed");
            loanTransaction.setLoanDisbursementStatus("Completed");
            loanTransaction.setLoanRepaymentStatus("Completed");
            loanTransaction.setLoanRemarks("N/A");
            loanTransaction.setLoanCreatedBy("John Smith");
            loanTransaction.setLoanModifiedBy("John Smith");
            loanTransaction.setLoanCreatedDate(new Date());
            loanTransaction.setLoanModifiedDate(new Date());
            loanTransaction.setLoanStatus("Active");
            loanTransaction.setLoanUnderwriter("Jane Smith");
            loanTransaction.setLoanApprover("Jack Smith");
            loanTransaction.setLoanRegion("West");
            loanTransaction.setLoanSector("Pharma");
            loanTransactionsCache.put(loanTransaction.getLoanNumber(),loanTransaction);
        }
        System.out.println("Cache Population completed");
    }
}

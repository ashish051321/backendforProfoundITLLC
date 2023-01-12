package com.profounditllc.backendforwebsite.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class CptyLoanTransaction implements Serializable {

    private String loanNumber;
    private Date loanStartDate;
    private Date loanMaturityDate;
    private BigDecimal loanAmount;
    private BigDecimal remainingLoanAmount;
    private String loanCurrency;
    private String loanType;
    private String loanPurpose;
    private String loanCounterparty;
    private String loanCounterpartyType;
    private String loanCounterpartyRating;
    private String loanCounterpartyCountry;
    private String loanCounterpartyIndustry;
    private String loanCounterpartyContactName;
    private String loanCounterpartyContactEmail;
    private String loanCounterpartyContactPhone;
    private String loanCollateral;
    private String loanGuarantor;
    private String loanRepaymentSchedule;
    private String loanRepaymentFrequency;
    private BigDecimal loanInterestRate;
    private BigDecimal loanServiceCharge;
    private String loanDocumentationStatus;
    private String loanDisbursementStatus;
    private String loanRepaymentStatus;
    private String loanRemarks;
    private String loanCreatedBy;
    private String loanModifiedBy;
    private Date loanCreatedDate;
    private Date loanModifiedDate;
    private String loanStatus;
    private String loanUnderwriter;
    private String loanApprover;
    private String loanRegion;
    private String loanSector;
}

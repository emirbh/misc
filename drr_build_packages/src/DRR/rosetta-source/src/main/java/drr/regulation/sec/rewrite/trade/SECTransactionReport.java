package drr.regulation.sec.rewrite.trade;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RosettaIgnore;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneIgnore;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.base.trade.payment.OtherPayment;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.PricePeriod;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.Counterparty2IdentifierEnum;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.CommonTransactionReport;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.meta.SECTransactionReportMeta;
import drr.standards.iosco.cde.version1.LegV1;
import drr.standards.iosco.cde.version2.LegV2;
import drr.standards.iosco.cde.version3.Leg;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.ConfirmationEnum;
import drr.standards.iso.DeliveryTypeEnum;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.EmbeddedOptionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import drr.standards.iso.OptionStyleEnum;
import drr.standards.iso.OptionTypeCode;
import drr.standards.iso.ReportLevelEnum;
import drr.standards.iso.SeniorityEnum;
import drr.standards.iso.TradingCapacity7Code;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="SECTransactionReport", builder=SECTransactionReport.SECTransactionReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="SECTransactionReport", model="drr", builder=SECTransactionReport.SECTransactionReportBuilderImpl.class, version="7.7.0")
public interface SECTransactionReport extends CommonTransactionReport {

	SECTransactionReportMeta metaData = new SECTransactionReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.6" * field "Cleared"
	 *
	 * Provision Indicator of whether the transaction has been cleared, or is intended to be cleared, by a central counterparty.
	 *
	 */
	@Override
	ClearedEnum getCleared();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "7"
	 *
	 * Provision Identifier of the second counterparty to an OTC derivative transaction. In the case of an allocated derivative transaction executed by a fund manager on behalf of a fund, the fund and not the fund manager is reported as the counterparty.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220703"
	 *
	 * Provision Peer review recommended to detect private individual party representations (instead of LEI scheme). For natural persons who are acting as private individuals (not business entities): LEI of the reporting counterparty followed by a unique identifier assigned and maintained consistently by the reporting counterparty for that natural person(s) for regulatory reporting purpose.
	 *
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 2 "Version 2 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 2) includes certain revisions and new data elements to the April 2018 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data." 
	 * section "2" * field "7"
	 *
	 * Provision Identifier of the second counterparty to an OTC derivative transaction. In the case of an allocated derivative transaction executed by a fund manager on behalf of a fund, the fund and not the fund manager is reported as the counterparty.
	               - Format:
	               - Char(20), for an LEI code
	               - Varchar(72), for natural persons who are acting as private individuals (not eligible for an LEI per the ROC Statement - Individuals Acting in a Business Capacity)
	               - Allowable values:
	               - LEI code that is included in the LEI data as published by the Global LEI Foundation (GLEIF, www.gleif.org/).
	               - For natural persons who are acting as private individuals (not eligible for an LEI per the ROC Statement - Individuals Acting in a Business Capacity: LEI of the reporting counterparty followed by a unique identifier assigned and maintained consistently by the reporting counterparty for that natural person(s) for regulatory reporting purpose
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220703"
	 *
	 * Provision Peer review recommended to detect private individual party representations (instead of LEI scheme). For natural persons who are acting as private individuals (not business entities): LEI of the reporting counterparty followed by a unique identifier assigned and maintained consistently by the reporting counterparty for that natural person(s) for regulatory reporting purpose.
	 *
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data." 
	 * section "2" * field "7"
	 *
	 * Provision Identifier of the second counterparty to an OTC derivative transaction. In the case of an allocated derivative transaction executed by a fund manager on behalf of a fund, the fund and not the fund manager is reported as the counterparty. However, if the allocation of the block trade to specific funds does not take place prior to the reporting deadline, then the fund manager executing the transaction on behalf of the fund can be reported as the counterparty.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220703"
	 *
	 * Provision Peer review recommended to detect private individual party representations (instead of LEI scheme). For natural persons who are acting as private individuals (not business entities): LEI of the reporting counterparty followed by a unique identifier assigned and maintained consistently by the reporting counterparty for that natural person(s) for regulatory reporting purpose.
	 *
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.1" * field "Trade Party 2 - ID"
	 *
	 * Provision Identifier of the second counterparty to an OTC derivative transaction. In the case of an allocated derivative transaction executed by a fund manager on behalf of a fund, the fund, and not the fund manager is reported as the counterparty.
	 *
	 */
	@Override
	String getCounterparty2();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.1" * field "Trade Party 2 - ID Type"
	 *
	 * Provision Source used to identify the Counterparty 2.
	 *
	 */
	@Override
	Counterparty2IdentifierEnum getCounterparty2IdentifierSource();
	/**
	 *
	 * notionalAmount
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.4" * field "Notional Amount Leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable:
	                     - for OTC derivative transactions negotiated in monetary amounts, amount specified in the contract.
	                     - for OTC derivative transactions negotiated in non-monetary amounts, refer to appendix B for converting notional amounts for non-monetary amounts.
	                     In addition:
	                     - For OTC derivative transactions with a notional amount schedule, the initial notional amount, agreed by the counterparties at the inception of the transaction, is reported in this data element.
	                     - For OTC foreign exchange options, in addition to this data element, the amounts are reported using the data elements Call amount and Put amount.
	                     - For amendments or lifecycle events, the resulting outstanding notional amount is reported; (steps in notional amount schedules are not considered to be amendments or lifecycle events);
	                     - Where the notional amount is not known when a new transaction is reported, the notional amount is updated as it becomes available.
	 *
	 *
	 * notionalCurrency
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.4" * field "Notional Currency Leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable: currency in which the notional amount is denominated.
	 *
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.4" * field "CDE - Notional amount in effect on associated effective date - Leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable:
	                     for OTC derivative transactions negotiated in monetary amounts with a notional amount schedule:
	                         - Notional amount which becomes effective on the associated unadjusted effective date.
	                     The initial notional amount and associated unadjusted effective and end date are reported as the first values of the schedule.
	                     This data element is not applicable to OTC derivative transactions with notional amounts that are condition- or event-dependent. The currency of the varying notional amounts in the schedule is reported in Notional currency.
	 *
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.4" * field "CDE - Effective date of the notional amount - Leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable: for OTC derivative transactions negotiated in monetary amounts with a notional amount schedule: Unadjusted date on which the associated notional amount becomes effective This data element is not applicable to OTC derivative transactions with notional amounts that are condition- or event-dependent. The currency of the varying notional amounts in the schedule is reported in Notional currency.
	 *
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.4" * field "CDE - End date of the notional amount - Leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable: for OTC derivative transactions negotiated in monetary amounts with a notional amount schedule: Unadjusted end date of the notional amount (not applicable if the unadjusted end date of a given schedules period is back-to-back with the unadjusted effective date of the subsequent period). This data element is not applicable to OTC derivative transactions with notional amounts that are condition- or event-dependent. The currency of the varying notional amounts in the schedule is reported in Notional currency.
	 *
	 *
	 * quantityUnitOfMeasure
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.5" * field "Quantity Unit Of Measure Leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable: unit of measure in which the Total notional quantity and Notional quantity are expressed.
	 *
	 *
	 * totalNotionalQuantity
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.5" * field "Total Notional Quantity Leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable: aggregate Notional quantity of the underlying asset for the term of the transaction.
	                    Where the Total notional quantity is not known when a new transaction is reported, the Total notional quantity is updated as it becomes available.
	 *
	 *
	 * periodicPayment -> fixedRateDayCountConvention
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Fixed rate day count convention-leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable: day count convention (often also referred to as day count fraction or day count basis or day count method) that determines how interest payments are calculated. It is used to compute the year fraction of the calculation period, and indicates the number of days in the calculation period divided by the number of days in the year.
	 *
	 *
	 * periodicPayment -> floatingRateDayCountConvention
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Floating rate day count convention-leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable: day count convention (often also referred to as day count fraction or day count basis or day count method) that determines how interest payments are calculated. It is used to compute the year fraction of the calculation period, and indicates the number of days in the calculation period divided by the number of days in the year.
	 *
	 *
	 * periodicPayment -> floatingRateResetFrequencyPeriod
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Floating Rate Reset Frequency Period - Leg 1"
	 *
	 * Provision For each floating leg of the swap transaction, where applicable, time unit associated with the frequency of resets, e.g., day, week, month, year or term of the stream.
	 *
	 *
	 * periodicPayment -> floatingRateResetFrequencyMultiplier
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Floating Rate Reset Frequency Period Multiplier - Leg 1"
	 *
	 * Provision For each floating leg of the swap transaction, where applicable, number of time units (as expressed by the Floating rate reset frequency period) that determines the frequency at which periodic payment dates for reset occur. For example, a transaction with reset payments occurring every two months is represented with a Floating rate reset frequency period of MNTH (monthly) and a Floating rate reset frequency period multiplier of 2. This data element is not applicable if the Floating rate reset frequency period is ADHO. If Floating rate reset frequency period is TERM, then the Floating rate reset frequency period multiplier is 1. If the reset frequency period is intraday, then the Floating rate reset frequency period is DAIL and the Floating rate reset frequency period multiplier is 0.
	 *
	 *
	 * periodicPayment -> fixedRatePaymentFrequencyPeriod
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Fixed Rate Payment Frequency Period - Leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable: time unit associated with the frequency of payments, e.g., day, week, month, year or term of the stream.
	 *
	 *
	 * periodicPayment -> floatingRatePaymentFrequencyPeriod
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Floating Rate Payment Frequency Period - Leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable: time unit associated with the frequency of payments, e.g., day, week, month, year or term of the stream.
	 *
	 *
	 * periodicPayment -> fixedRatePaymentFrequencyPeriodMultiplier
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Fixed Rate Payment Frequency Period Multiplier - Leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable: number of time units (as expressed by the Payment frequency period) that determines the frequency at which periodic payment dates occur. For example, a transaction with payments occurring every two months is represented with a Payment frequency period of MNTH (monthly) and a Payment frequency period multiplier of 2.This data element is not applicable if the Payment frequency period is ADHO. If Payment frequency period is TERM, then the Payment frequency period multiplier is 1. If the Payment frequency is intraday, then the Payment frequency period is DAIL and the Payment frequency multiplier is 0.
	 *
	 *
	 * periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Floating Rate Payment Frequency Period Multiplier - Leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable: number of time units (as expressed by the Payment frequency period) that determines the frequency at which periodic payment dates occur. For example, a transaction with payments occurring every two months is represented with a Payment frequency period of MNTH (monthly) and a Payment frequency period multiplier of 2.This data element is not applicable if the Payment frequency period is ADHO. If Payment frequency period is TERM, then the Payment frequency period multiplier is 1. If the Payment frequency is intraday, then the Payment frequency period is DAIL and the Payment frequency multiplier is 0.
	 *
	 *
	 * fixedRate
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Fixed Rate - Leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable: for OTC derivative transactions with periodic payments, per annum rate of the fixed leg(s).
	 *
	 *
	 * spread
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.3" * field "SpreadLeg1"
	 *
	 * Provision For each leg of the transaction, where applicable: for OTC derivative transactions with periodic payments (e.g., interest rate fixed/float swaps, interest rate basis swaps, commodity swaps),
	                 - spread on the individual floating leg(s) index reference price, in the case where there is a spread on a floating leg(s). For example, USD-LIBOR-BBA plus .03 or WTI minus USD 14.65; or
	                 - difference between the reference prices of the two floating leg indexes. For example, the 9.00 USD Spread for a WCS vs. WTI basis swap where WCS is priced at 43 USD and WTI is priced at 52 USD.
	 *
	 *
	 * spreadCurrency
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.3" * field "Spread currency Leg 1"
	 *
	 * Provision For each leg of the transaction, where applicable: currency in which the spread is denominated. This data element is only applicable if Spread notation = 1.
	 *
	 *
	 * spreadNotation
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.3" * field "Spread Notation Leg 1 Enum"
	 *
	 * Provision For each leg of the transaction, where applicable: manner in which the spread is expressed.
	 *
	 *
	 * settlementCurrency
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.8" * field "Settlement Currency Leg 1"
	 *
	 * Provision Currency for the cash settlement of the transaction when applicable. For multicurrency products that do not net, the settlement currency of each leg. This data element is not applicable for physically settled products (eg physically settled swaptions).
	 *
	 */
	@Override
	SECLeg getLeg1();
	/**
	 *
	 * notionalAmount
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.4" * field "Notional Amount Leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable:
	                     - for OTC derivative transactions negotiated in monetary amounts, amount specified in the contract.
	                     - for OTC derivative transactions negotiated in non-monetary amounts, refer to appendix B for converting notional amounts for non-monetary amounts.
	                     In addition:
	                     - For OTC derivative transactions with a notional amount schedule, the initial notional amount, agreed by the counterparties at the inception of the transaction, is reported in this data element.
	                     - For OTC foreign exchange options, in addition to this data element, the amounts are reported using the data elements Call amount and Put amount.
	                     - For amendments or lifecycle events, the resulting outstanding notional amount is reported; (steps in notional amount schedules are not considered to be amendments or lifecycle events);
	                     - Where the notional amount is not known when a new transaction is reported, the notional amount is updated as it becomes available.
	 *
	 *
	 * notionalCurrency
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.4" * field "Notional Currency Leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable: currency in which the notional amount is denominated.
	 *
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.4" * field "CDE - Notional amount in effect on associated effective date - Leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable:
	                    for OTC derivative transactions negotiated in monetary amounts with a notional amount schedule:
	                         - Notional amount which becomes effective on the associated unadjusted effective date.
	                    The initial notional amount and associated unadjusted effective and end date are reported as the first values of the schedule.
	                    This data element is not applicable to OTC derivative transactions with notional amounts that are condition- or event-dependent. The currency of the varying notional amounts in the schedule is reported in Notional currency.
	 *
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.4" * field "CDE - Effective date of the notional amount - Leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable: for OTC derivative transactions negotiated in monetary amounts with a notional amount schedule: Unadjusted date on which the associated notional amount becomes effective This data element is not applicable to OTC derivative transactions with notional amounts that are condition- or event-dependent. The currency of the varying notional amounts in the schedule is reported in Notional currency.
	 *
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.4" * field "CDE - End date of the notional amount - Leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable: for OTC derivative transactions negotiated in monetary amounts with a notional amount schedule: Unadjusted end date of the notional amount (not applicable if the unadjusted end date of a given schedules period is back-to-back with the unadjusted effective date of the subsequent period). This data element is not applicable to OTC derivative transactions with notional amounts that are condition- or event-dependent. The currency of the varying notional amounts in the schedule is reported in Notional currency.
	 *
	 *
	 * quantityUnitOfMeasure
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.5" * field "Quantity Unit Of Measure Leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable: unit of measure in which the Total notional quantity and Notional quantity are expressed.
	 *
	 *
	 * totalNotionalQuantity
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.5" * field "Total Notional Quantity Leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable: aggregate Notional quantity of the underlying asset for the term of the transaction.
	                    Where the Total notional quantity is not known when a new transaction is reported, the Total notional quantity is updated as it becomes available.
	 *
	 *
	 * periodicPayment -> fixedRateDayCountConvention
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Fixed rate day count convention-leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable: day count convention (often also referred to as day count fraction or day count basis or day count method) that determines how interest payments are calculated. It is used to compute the year fraction of the calculation period, and indicates the number of days in the calculation period divided by the number of days in the year.
	 *
	 *
	 * periodicPayment -> floatingRateDayCountConvention
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Floating rate day count convention-leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable: day count convention (often also referred to as day count fraction or day count basis or day count method) that determines how interest payments are calculated. It is used to compute the year fraction of the calculation period, and indicates the number of days in the calculation period divided by the number of days in the year.
	 *
	 *
	 * periodicPayment -> floatingRateResetFrequencyPeriod
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Floating Rate Reset Frequency Period - Leg 2"
	 *
	 * Provision For each floating leg of the swap transaction, where applicable, time unit associated with the frequency of resets, e.g., day, week, month, year or term of the stream.
	 *
	 *
	 * periodicPayment -> floatingRateResetFrequencyMultiplier
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Floating Rate Reset Frequency Period Multiplier - Leg 2"
	 *
	 * Provision For each floating leg of the swap transaction, where applicable, number of time units (as expressed by the Floating rate reset frequency period) that determines the frequency at which periodic payment dates for reset occur. For example, a transaction with reset payments occurring every two months is represented with a Floating rate reset frequency period of MNTH (monthly) and a Floating rate reset frequency period multiplier of 2. This data element is not applicable if the Floating rate reset frequency period is ADHO. If Floating rate reset frequency period is TERM, then the Floating rate reset frequency period multiplier is 1. If the reset frequency period is intraday, then the Floating rate reset frequency period is DAIL and the Floating rate reset frequency period multiplier is 0.
	 *
	 *
	 * periodicPayment -> fixedRatePaymentFrequencyPeriod
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Fixed Rate Payment Frequency Period - Leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable: time unit associated with the frequency of payments, e.g., day, week, month, year or term of the stream.
	 *
	 *
	 * periodicPayment -> floatingRatePaymentFrequencyPeriod
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Floating Rate Payment Frequency Period - Leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable: time unit associated with the frequency of payments, e.g., day, week, month, year or term of the stream.
	 *
	 *
	 * periodicPayment -> fixedRatePaymentFrequencyPeriodMultiplier
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Fixed Rate Payment Frequency Period Multiplier - Leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable: number of time units (as expressed by the Payment frequency period) that determines the frequency at which periodic payment dates occur. For example, a transaction with payments occurring every two months is represented with a Payment frequency period of MNTH (monthly) and a Payment frequency period multiplier of 2.This data element is not applicable if the Payment frequency period is ADHO. If Payment frequency period is TERM, then the Payment frequency period multiplier is 1. If the Payment frequency is intraday, then the Payment frequency period is DAIL and the Payment frequency multiplier is 0.
	 *
	 *
	 * periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Floating Rate Payment Frequency Period Multiplier - Leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable: number of time units (as expressed by the Payment frequency period) that determines the frequency at which periodic payment dates occur. For example, a transaction with payments occurring every two months is represented with a Payment frequency period of MNTH (monthly) and a Payment frequency period multiplier of 2.This data element is not applicable if the Payment frequency period is ADHO. If Payment frequency period is TERM, then the Payment frequency period multiplier is 1. If the Payment frequency is intraday, then the Payment frequency period is DAIL and the Payment frequency multiplier is 0.
	 *
	 *
	 * fixedRate
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.3" * field "Fixed Rate - Leg 2"
	 *
	 * Provision For each leg of the transaction, where applicable: for OTC derivative transactions with periodic payments, per annum rate of the fixed leg(s).
	 *
	 *
	 * spread
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.3" * field "SpreadLeg2"
	 *
	 * Provision For each leg of the transaction, where applicable: for OTC derivative transactions with periodic payments (e.g., interest rate fixed/float swaps, interest rate basis swaps, commodity swaps),
	             - spread on the individual floating leg(s) index reference price, in the case where there is a spread on a floating leg(s). For example, USD-LIBOR-BBA plus .03 or WTI minus USD 14.65; or
	             - difference between the reference prices of the two floating leg indexes. For example, the 9.00 USD Spread for a WCS vs. WTI basis swap where WCS is priced at 43 USD and WTI is priced at 52 USD.
	 *
	 *
	 * spreadCurrency
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.3" * field "Leg 2 - Spread Currency"
	 *
	 * Provision For each leg of the transaction, where applicable: currency in which the spread is denominated. This data element is only applicable if Spread notation = 1.
	 *
	 *
	 * spreadNotation
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.3" * field "Spread Notation Leg 2 Enum"
	 *
	 * Provision For each leg of the transaction, where applicable: manner in which the spread is expressed.
	 *
	 *
	 * settlementCurrency
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.8" * field "Settlement Currency Leg 2"
	 *
	 * Provision Currency for the cash settlement of the transaction when applicable. For multicurrency products that do not net, the settlement currency of each leg. This data element is not applicable for physically settled products (eg physically settled swaptions).
	 *
	 */
	@Override
	SECLeg getLeg2();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.1.v" * field "Custom Basket Indicator"
	 *
	 * Provision Indicator of whether the swap transaction is based on a custom basket.
	 *
	 */
	@Override
	Boolean getCustomBasketIndicator();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.e.1.i; 901.c.2" * field "Latest Execution DateTime"
	 *
	 * Provision Date and time of occurrence of the event as determined by the reporting counterparty or a service provider. In the case of a clearing event, date and time when the original swap is accepted by the derivative clearing organization (DCO) for clearing and recorded by the DCOs system should be reported in this data element. The time element is as specific as technologically practicable.
	 *
	 */
	@Override
	ZonedDateTime getEventTimestamp();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.d.5" * field "Package Indicator"
	 *
	 * Provision Indicator of whether the swap transaction is part of a package transaction.
	 *
	 */
	@Override
	Boolean getPackageIndicator();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.1.ii" * field "Effective Date"
	 *
	 * Provision Unadjusted date at which obligations under the OTC derivative transaction come into effect, as included in the confirmation.
	 *
	 */
	@Override
	Date getEffectiveDate();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.c.2" * field "Execution Timestamp"
	 *
	 * Provision Date and time a transaction was originally executed, resulting in the generation of a new UTI. This data element remains unchanged throughout the life of the UTI.
	 *
	 */
	@Override
	ZonedDateTime getExecutionTimestamp();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * field "Post-priced swap indicator"
	 *
	 * Provision Indicator of whether the swap transaction satisfies the definition of 'post-priced swap' in  43.2(a) of the Commission's regulations.
	 *
	 */
	Boolean getPostPricedSwapIndicator();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * dataElement "901.g" * field "Unique Swap Identifier (USI)"
	 *
	 * Provision The USI is a unique identifier assigned to all swap transactions which identifies the transaction (the swap and its counterparties) uniquely throughout its duration. It consists of a namespace and a transaction identifier.
	 *
	 */
	String getUniqueSwapIdentifier();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * field "Trade Party 1 - CFTC Financial Entity Status"
	 *
	 * Provision Indicator of whether Counterparty 1 is a financial entity as defined in CEA  2(h)(7)(C).
	 *
	 */
	Boolean getCounterparty1FinancialEntityIndicator();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade   
	 * field "Trade Party 2 - CFTC Financial Entity Status"
	 *
	 * Provision Indicator of whether Counterparty 2 is a financial entity as defined in CEA  2(h)(7)(C).
	 *
	 */
	Boolean getCounterparty2FinancialEntityIndicator();
	DTCCAdditionalFields getDtccAdditionalFields();

	/*********************** Build Methods  ***********************/
	SECTransactionReport build();
	
	SECTransactionReport.SECTransactionReportBuilder toBuilder();
	
	static SECTransactionReport.SECTransactionReportBuilder builder() {
		return new SECTransactionReport.SECTransactionReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SECTransactionReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SECTransactionReport> getType() {
		return SECTransactionReport.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("earlyTerminationDate"), Date.class, getEarlyTerminationDate(), this);
		processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
		processor.processBasic(path.newSubPath("executionTimestamp"), ZonedDateTime.class, getExecutionTimestamp(), this);
		processor.processBasic(path.newSubPath("expirationDate"), Date.class, getExpirationDate(), this);
		processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
		processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
		processor.processBasic(path.newSubPath("beneficiary1"), String.class, getBeneficiary1(), this);
		processor.processBasic(path.newSubPath("beneficiary1IdentifierTypeIndicator"), Boolean.class, getBeneficiary1IdentifierTypeIndicator(), this);
		processor.processBasic(path.newSubPath("buyerIdentifier"), String.class, getBuyerIdentifier(), this);
		processor.processBasic(path.newSubPath("sellerIdentifier"), String.class, getSellerIdentifier(), this);
		processor.processBasic(path.newSubPath("cleared"), ClearedEnum.class, getCleared(), this);
		processor.processBasic(path.newSubPath("centralCounterparty"), String.class, getCentralCounterparty(), this);
		processor.processBasic(path.newSubPath("clearingMember"), String.class, getClearingMember(), this);
		processor.processBasic(path.newSubPath("confirmed"), ConfirmationEnum.class, getConfirmed(), this);
		processor.processBasic(path.newSubPath("callAmount"), BigDecimal.class, getCallAmount(), this);
		processor.processBasic(path.newSubPath("putAmount"), BigDecimal.class, getPutAmount(), this);
		processor.processBasic(path.newSubPath("callCurrency"), ISOCurrencyCodeEnum.class, getCallCurrency(), this);
		processor.processBasic(path.newSubPath("putCurrency"), ISOCurrencyCodeEnum.class, getPutCurrency(), this);
		processor.processBasic(path.newSubPath("delta"), BigDecimal.class, getDelta(), this);
		processRosetta(path.newSubPath("priceSchedule"), processor, PricePeriod.class, getPriceSchedule());
		processRosetta(path.newSubPath("strikePriceSchedule"), processor, PricePeriod.class, getStrikePriceSchedule());
		processRosetta(path.newSubPath("price"), processor, PriceFormat.class, getPrice());
		processor.processBasic(path.newSubPath("priceNotation"), PriceNotationEnum.class, getPriceNotation(), this);
		processor.processBasic(path.newSubPath("priceCurrency"), ISOCurrencyCodeEnum.class, getPriceCurrency(), this);
		processRosetta(path.newSubPath("packageTransactionPrice"), processor, PriceFormat.class, getPackageTransactionPrice());
		processor.processBasic(path.newSubPath("packageTransactionPriceNotation"), PriceNotationEnum.class, getPackageTransactionPriceNotation(), this);
		processor.processBasic(path.newSubPath("packageTransactionPriceCurrency"), ISOCurrencyCodeEnum.class, getPackageTransactionPriceCurrency(), this);
		processRosetta(path.newSubPath("packageTransactionSpread"), processor, PriceFormat.class, getPackageTransactionSpread());
		processor.processBasic(path.newSubPath("packageTransactionSpreadNotation"), PriceNotationEnum.class, getPackageTransactionSpreadNotation(), this);
		processor.processBasic(path.newSubPath("packageTransactionSpreadCurrency"), ISOCurrencyCodeEnum.class, getPackageTransactionSpreadCurrency(), this);
		processor.processBasic(path.newSubPath("packageIdentifier"), String.class, getPackageIdentifier(), this);
		processRosetta(path.newSubPath("strikePrice"), processor, PriceFormat.class, getStrikePrice());
		processor.processBasic(path.newSubPath("strikePriceNotation"), PriceNotationEnum.class, getStrikePriceNotation(), this);
		processor.processBasic(path.newSubPath("strikePriceCurrency"), String.class, getStrikePriceCurrency(), this);
		processor.processBasic(path.newSubPath("priceUnitOfMeasure"), String.class, getPriceUnitOfMeasure(), this);
		processor.processBasic(path.newSubPath("optionPremiumAmount"), BigDecimal.class, getOptionPremiumAmount(), this);
		processor.processBasic(path.newSubPath("optionPremiumCurrency"), ISOCurrencyCodeEnum.class, getOptionPremiumCurrency(), this);
		processor.processBasic(path.newSubPath("optionPremiumPaymentDate"), Date.class, getOptionPremiumPaymentDate(), this);
		processor.processBasic(path.newSubPath("exchangeRate"), BigDecimal.class, getExchangeRate(), this);
		processor.processBasic(path.newSubPath("exchangeRateBasis"), String.class, getExchangeRateBasis(), this);
		processor.processBasic(path.newSubPath("cdSIndexAttachmentPoint"), BigDecimal.class, getCdSIndexAttachmentPoint(), this);
		processor.processBasic(path.newSubPath("cdSIndexDetachmentPoint"), BigDecimal.class, getCdSIndexDetachmentPoint(), this);
		processor.processBasic(path.newSubPath("collateralPortfolioIndicator"), Boolean.class, getCollateralPortfolioIndicator(), this);
		processor.processBasic(path.newSubPath("firstExerciseDate"), Date.class, getFirstExerciseDate(), this);
		processor.processBasic(path.newSubPath("finalContractualSettlementDate"), Date.class, getFinalContractualSettlementDate(), this);
		processor.processBasic(path.newSubPath("settlementLocation"), ISOCountryCodeEnum.class, getSettlementLocation(), this);
		processor.processBasic(path.newSubPath("priorUTI"), String.class, getPriorUTI(), this);
		processor.processBasic(path.newSubPath("direction1"), Direction1Enum.class, getDirection1(), this);
		processor.processBasic(path.newSubPath("valuationAmount"), BigDecimal.class, getValuationAmount(), this);
		processor.processBasic(path.newSubPath("valuationCurrency"), ISOCurrencyCodeEnum.class, getValuationCurrency(), this);
		processor.processBasic(path.newSubPath("valuationMethod"), ValuationType1Code.class, getValuationMethod(), this);
		processor.processBasic(path.newSubPath("valuationTimestamp"), ZonedDateTime.class, getValuationTimestamp(), this);
		processor.processBasic(path.newSubPath("customBasketCode"), String.class, getCustomBasketCode(), this);
		processRosetta(path.newSubPath("basketConstituents"), processor, BasketConstituentsReport.class, getBasketConstituents());
		processRosetta(path.newSubPath("otherPayment"), processor, OtherPayment.class, getOtherPayment());
		processRosetta(path.newSubPath("leg1"), processor, SECLeg.class, getLeg1());
		processRosetta(path.newSubPath("leg2"), processor, SECLeg.class, getLeg2());
		processor.processBasic(path.newSubPath("underlyingIdOther"), String.class, getUnderlyingIdOther(), this);
		processor.processBasic(path.newSubPath("underlyingIdOtherSource"), AssetIdTypeEnum.class, getUnderlyingIdOtherSource(), this);
		processor.processBasic(path.newSubPath("underlyingAssetTradingPlatformIdentifier"), String.class, getUnderlyingAssetTradingPlatformIdentifier(), this);
		processor.processBasic(path.newSubPath("underlyingAssetPriceSource"), String.class, getUnderlyingAssetPriceSource(), this);
		processor.processBasic(path.newSubPath("cryptoAssetUnderlyingIndicator"), Boolean.class, getCryptoAssetUnderlyingIndicator(), this);
		processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
		processor.processBasic(path.newSubPath("actionType"), ActionTypeEnum.class, getActionType(), this);
		processor.processBasic(path.newSubPath("eventType"), EventTypeEnum.class, getEventType(), this);
		processor.processBasic(path.newSubPath("eventIdentifier"), String.class, getEventIdentifier(), this);
		processor.processBasic(path.newSubPath("eventTimestamp"), ZonedDateTime.class, getEventTimestamp(), this);
		processor.processBasic(path.newSubPath("confirmationTimestamp"), ZonedDateTime.class, getConfirmationTimestamp(), this);
		processor.processBasic(path.newSubPath("platformIdentifier"), String.class, getPlatformIdentifier(), this);
		processor.processBasic(path.newSubPath("bookingLocation"), ISOCountryCodeEnum.class, getBookingLocation(), this);
		processor.processBasic(path.newSubPath("traderLocation"), ISOCountryCodeEnum.class, getTraderLocation(), this);
		processor.processBasic(path.newSubPath("deliveryType"), DeliveryTypeEnum.class, getDeliveryType(), this);
		processor.processBasic(path.newSubPath("executionAgentCounterparty1"), String.class, getExecutionAgentCounterparty1(), this);
		processor.processBasic(path.newSubPath("executionAgentCounterparty2"), String.class, getExecutionAgentCounterparty2(), this);
		processor.processBasic(path.newSubPath("natureOfCounterparty1"), NatureOfCounterpartyEnum.class, getNatureOfCounterparty1(), this);
		processor.processBasic(path.newSubPath("natureOfCounterparty2"), NatureOfCounterpartyEnum.class, getNatureOfCounterparty2(), this);
		processor.processBasic(path.newSubPath("clearingExceptionsAndExemptionsCounterparty1"), ClearingExceptionsAndExemptionsEnum.class, getClearingExceptionsAndExemptionsCounterparty1(), this);
		processor.processBasic(path.newSubPath("clearingExceptionsAndExemptionsCounterparty2"), ClearingExceptionsAndExemptionsEnum.class, getClearingExceptionsAndExemptionsCounterparty2(), this);
		processor.processBasic(path.newSubPath("corporateSectorOfTheCounterparty1"), String.class, getCorporateSectorOfTheCounterparty1(), this);
		processor.processBasic(path.newSubPath("corporateSectorOfTheCounterparty2"), String.class, getCorporateSectorOfTheCounterparty2(), this);
		processor.processBasic(path.newSubPath("counterparty2Name"), String.class, getCounterparty2Name(), this);
		processor.processBasic(path.newSubPath("reportSubmittingEntityID"), String.class, getReportSubmittingEntityID(), this);
		processor.processBasic(path.newSubPath("entityResponsibleForReporting"), String.class, getEntityResponsibleForReporting(), this);
		processor.processBasic(path.newSubPath("countryOfTheCounterparty2"), ISOCountryCodeEnum.class, getCountryOfTheCounterparty2(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierSource"), Counterparty2IdentifierEnum.class, getCounterparty2IdentifierSource(), this);
		processor.processBasic(path.newSubPath("tradingCapacity"), TradingCapacity7Code.class, getTradingCapacity(), this);
		processor.processBasic(path.newSubPath("brokerID"), String.class, getBrokerID(), this);
		processor.processBasic(path.newSubPath("contractType"), CommonContractType.class, getContractType(), this);
		processor.processBasic(path.newSubPath("assetClass"), CommonAssetClass.class, getAssetClass(), this);
		processor.processBasic(path.newSubPath("optionType"), OptionTypeCode.class, getOptionType(), this);
		processor.processBasic(path.newSubPath("optionStyle"), OptionStyleEnum.class, getOptionStyle(), this);
		processor.processBasic(path.newSubPath("embeddedOptionType"), EmbeddedOptionTypeEnum.class, getEmbeddedOptionType(), this);
		processor.processBasic(path.newSubPath("masterAgreementType"), MasterAgreementEnum.class, getMasterAgreementType(), this);
		processor.processBasic(path.newSubPath("masterAgreementVersion"), Integer.class, getMasterAgreementVersion(), this);
		processor.processBasic(path.newSubPath("secondaryTransactionIdentifier"), String.class, getSecondaryTransactionIdentifier(), this);
		processor.processBasic(path.newSubPath("intragroup"), Boolean.class, getIntragroup(), this);
		processor.processBasic(path.newSubPath("nonStandardizedTermIndicator"), Boolean.class, getNonStandardizedTermIndicator(), this);
		processor.processBasic(path.newSubPath("amendmentIndicator"), Boolean.class, getAmendmentIndicator(), this);
		processor.processBasic(path.newSubPath("underlyingIdentification"), String.class, getUnderlyingIdentification(), this);
		processor.processBasic(path.newSubPath("underlyingIdentificationType"), UnderlyingIdentificationTypeEnum.class, getUnderlyingIdentificationType(), this);
		processor.processBasic(path.newSubPath("nameOfTheUnderlyingIndex"), String.class, getNameOfTheUnderlyingIndex(), this);
		processor.processBasic(path.newSubPath("maturityDateOfTheUnderlying"), Date.class, getMaturityDateOfTheUnderlying(), this);
		processor.processBasic(path.newSubPath("swapLinkID"), String.class, getSwapLinkID(), this);
		processor.processBasic(path.newSubPath("packageIndicator"), Boolean.class, getPackageIndicator(), this);
		processor.processBasic(path.newSubPath("customBasketIndicator"), Boolean.class, getCustomBasketIndicator(), this);
		processor.processBasic(path.newSubPath("priorUTIProprietary"), String.class, getPriorUTIProprietary(), this);
		processor.processBasic(path.newSubPath("clearingTimestamp"), ZonedDateTime.class, getClearingTimestamp(), this);
		processor.processBasic(path.newSubPath("clearingAccountOrigin"), ClearingAccountOriginEnum.class, getClearingAccountOrigin(), this);
		processor.processBasic(path.newSubPath("clearingReceiptTimestamp"), ZonedDateTime.class, getClearingReceiptTimestamp(), this);
		processor.processBasic(path.newSubPath("uniqueTransactionIdentifier"), String.class, getUniqueTransactionIdentifier(), this);
		processor.processBasic(path.newSubPath("uniqueTransactionIdentifierProprietary"), String.class, getUniqueTransactionIdentifierProprietary(), this);
		processor.processBasic(path.newSubPath("uniqueProductIdentifier"), String.class, getUniqueProductIdentifier(), this);
		processor.processBasic(path.newSubPath("originalSwapUTI"), String.class, getOriginalSwapUTI(), this);
		processor.processBasic(path.newSubPath("subsequentPositionUTI"), String.class, getSubsequentPositionUTI(), this);
		processor.processBasic(path.newSubPath("originalSwapSDRIdentifier"), String.class, getOriginalSwapSDRIdentifier(), this);
		processor.processBasic(path.newSubPath("priorUSI"), String.class, getPriorUSI(), this);
		processor.processBasic(path.newSubPath("newSDRIdentifier"), String.class, getNewSDRIdentifier(), this);
		processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
		processor.processBasic(path.newSubPath("referenceEntity"), String.class, getReferenceEntity(), this);
		processor.processBasic(path.newSubPath("seniority"), SeniorityEnum.class, getSeniority(), this);
		processor.processBasic(path.newSubPath("series"), Integer.class, getSeries(), this);
		processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
		processor.processBasic(path.newSubPath("seriesVersion"), Integer.class, getSeriesVersion(), this);
		processor.processBasic(path.newSubPath("baseProduct"), String.class, getBaseProduct(), this);
		processor.processBasic(path.newSubPath("subProduct"), String.class, getSubProduct(), this);
		processor.processBasic(path.newSubPath("furtherSubProduct"), String.class, getFurtherSubProduct(), this);
		processRosetta(path.newSubPath("barrier"), processor, SingleOrUpperAndLowerBarrier.class, getBarrier());
		processor.processBasic(path.newSubPath("initialMarginCollateralPortfolioCode"), String.class, getInitialMarginCollateralPortfolioCode(), this);
		processor.processBasic(path.newSubPath("variationMarginCollateralPortfolioCode"), String.class, getVariationMarginCollateralPortfolioCode(), this);
		processRosetta(path.newSubPath("nonReportable"), processor, NonReportable.class, getNonReportable());
		processor.processBasic(path.newSubPath("postPricedSwapIndicator"), Boolean.class, getPostPricedSwapIndicator(), this);
		processor.processBasic(path.newSubPath("uniqueSwapIdentifier"), String.class, getUniqueSwapIdentifier(), this);
		processor.processBasic(path.newSubPath("counterparty1FinancialEntityIndicator"), Boolean.class, getCounterparty1FinancialEntityIndicator(), this);
		processor.processBasic(path.newSubPath("counterparty2FinancialEntityIndicator"), Boolean.class, getCounterparty2FinancialEntityIndicator(), this);
		processRosetta(path.newSubPath("dtccAdditionalFields"), processor, DTCCAdditionalFields.class, getDtccAdditionalFields());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SECTransactionReportBuilder extends SECTransactionReport, CommonTransactionReport.CommonTransactionReportBuilder {
		SECLeg.SECLegBuilder getOrCreateLeg1();
		@Override
		SECLeg.SECLegBuilder getLeg1();
		SECLeg.SECLegBuilder getOrCreateLeg2();
		@Override
		SECLeg.SECLegBuilder getLeg2();
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder getOrCreateDtccAdditionalFields();
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder getDtccAdditionalFields();
		@Override
		SECTransactionReport.SECTransactionReportBuilder setEffectiveDate(Date effectiveDate);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setEarlyTerminationDate(Date earlyTerminationDate);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setExecutionTimestamp(ZonedDateTime executionTimestamp);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setExpirationDate(Date expirationDate);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCounterparty1(String counterparty1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCounterparty2(String counterparty2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setBeneficiary1(String beneficiary1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setBeneficiary1IdentifierTypeIndicator(Boolean beneficiary1IdentifierTypeIndicator);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setBuyerIdentifier(String buyerIdentifier);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setSellerIdentifier(String sellerIdentifier);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCleared(ClearedEnum cleared);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCentralCounterparty(String centralCounterparty);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setClearingMember(String clearingMember);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setConfirmed(ConfirmationEnum confirmed);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCallAmount(BigDecimal callAmount);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPutAmount(BigDecimal putAmount);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCallCurrency(ISOCurrencyCodeEnum callCurrency);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPutCurrency(ISOCurrencyCodeEnum putCurrency);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setDelta(BigDecimal delta);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addPriceSchedule(PricePeriod priceSchedule);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addPriceSchedule(PricePeriod priceSchedule, int idx);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addStrikePriceSchedule(PricePeriod strikePriceSchedule, int idx);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPrice(PriceFormat price);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPriceNotation(PriceNotationEnum priceNotation);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPriceCurrency(ISOCurrencyCodeEnum priceCurrency);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPackageTransactionPrice(PriceFormat packageTransactionPrice);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPackageTransactionPriceNotation(PriceNotationEnum packageTransactionPriceNotation);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum packageTransactionPriceCurrency);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPackageTransactionSpread(PriceFormat packageTransactionSpread);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPackageTransactionSpreadNotation(PriceNotationEnum packageTransactionSpreadNotation);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum packageTransactionSpreadCurrency);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPackageIdentifier(String packageIdentifier);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setStrikePrice(PriceFormat strikePrice);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setStrikePriceNotation(PriceNotationEnum strikePriceNotation);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setStrikePriceCurrency(String strikePriceCurrency);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPriceUnitOfMeasure(String priceUnitOfMeasure);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setOptionPremiumAmount(BigDecimal optionPremiumAmount);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum optionPremiumCurrency);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setOptionPremiumPaymentDate(Date optionPremiumPaymentDate);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setExchangeRate(BigDecimal exchangeRate);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setExchangeRateBasis(String exchangeRateBasis);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCdSIndexAttachmentPoint(BigDecimal cdSIndexAttachmentPoint);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCdSIndexDetachmentPoint(BigDecimal cdSIndexDetachmentPoint);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setFirstExerciseDate(Date firstExerciseDate);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setFinalContractualSettlementDate(Date finalContractualSettlementDate);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setSettlementLocation(ISOCountryCodeEnum settlementLocation);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPriorUTI(String priorUTI);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setDirection1(Direction1Enum direction1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setValuationAmount(BigDecimal valuationAmount);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCustomBasketCode(String customBasketCode);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addBasketConstituents(BasketConstituentsReport basketConstituents);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addBasketConstituents(BasketConstituentsReport basketConstituents, int idx);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addOtherPayment(OtherPayment otherPayment);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addOtherPayment(OtherPayment otherPayment, int idx);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setLeg1(LegV1 leg1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setLeg2(LegV1 leg2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setLeg1(LegV2 leg1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setLeg2(LegV2 leg2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setLeg1(Leg leg1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setLeg2(Leg leg2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setUnderlyingIdOther(String underlyingIdOther);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum underlyingIdOtherSource);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setUnderlyingAssetTradingPlatformIdentifier(String underlyingAssetTradingPlatformIdentifier);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setUnderlyingAssetPriceSource(String underlyingAssetPriceSource);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCryptoAssetUnderlyingIndicator(Boolean cryptoAssetUnderlyingIndicator);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setLevel(ReportLevelEnum level);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setActionType(ActionTypeEnum actionType);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setEventType(EventTypeEnum eventType);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setEventIdentifier(String eventIdentifier);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setEventTimestamp(ZonedDateTime eventTimestamp);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setLeg1(CommonLeg leg1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setLeg2(CommonLeg leg2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setConfirmationTimestamp(ZonedDateTime confirmationTimestamp);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPlatformIdentifier(String platformIdentifier);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setBookingLocation(ISOCountryCodeEnum bookingLocation);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setTraderLocation(ISOCountryCodeEnum traderLocation);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setDeliveryType(DeliveryTypeEnum deliveryType);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setExecutionAgentCounterparty1(String executionAgentCounterparty1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setExecutionAgentCounterparty2(String executionAgentCounterparty2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum natureOfCounterparty1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum natureOfCounterparty2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty1, int idx);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum clearingExceptionsAndExemptionsCounterparty2, int idx);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String corporateSectorOfTheCounterparty1, int idx);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String corporateSectorOfTheCounterparty2, int idx);
		@Override
		SECTransactionReport.SECTransactionReportBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCounterparty2Name(String counterparty2Name);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setReportSubmittingEntityID(String reportSubmittingEntityID);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setEntityResponsibleForReporting(String entityResponsibleForReporting);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum countryOfTheCounterparty2);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum counterparty2IdentifierSource);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setTradingCapacity(TradingCapacity7Code tradingCapacity);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setBrokerID(String brokerID);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setContractType(CommonContractType contractType);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setAssetClass(CommonAssetClass assetClass);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setOptionType(OptionTypeCode optionType);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setOptionStyle(OptionStyleEnum optionStyle);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum embeddedOptionType);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setMasterAgreementType(MasterAgreementEnum masterAgreementType);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setMasterAgreementVersion(Integer masterAgreementVersion);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setSecondaryTransactionIdentifier(String secondaryTransactionIdentifier);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setIntragroup(Boolean intragroup);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setNonStandardizedTermIndicator(Boolean nonStandardizedTermIndicator);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setAmendmentIndicator(Boolean amendmentIndicator);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setUnderlyingIdentification(String underlyingIdentification);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum underlyingIdentificationType);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setNameOfTheUnderlyingIndex(String nameOfTheUnderlyingIndex);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setMaturityDateOfTheUnderlying(Date maturityDateOfTheUnderlying);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setSwapLinkID(String swapLinkID);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPackageIndicator(Boolean packageIndicator);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setCustomBasketIndicator(Boolean customBasketIndicator);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPriorUTIProprietary(String priorUTIProprietary);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setClearingTimestamp(ZonedDateTime clearingTimestamp);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setClearingAccountOrigin(ClearingAccountOriginEnum clearingAccountOrigin);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setClearingReceiptTimestamp(ZonedDateTime clearingReceiptTimestamp);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setUniqueTransactionIdentifier(String uniqueTransactionIdentifier);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setUniqueTransactionIdentifierProprietary(String uniqueTransactionIdentifierProprietary);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setUniqueProductIdentifier(String uniqueProductIdentifier);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setOriginalSwapUTI(String originalSwapUTI);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setSubsequentPositionUTI(String subsequentPositionUTI);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setOriginalSwapSDRIdentifier(String originalSwapSDRIdentifier);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setPriorUSI(String priorUSI);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setNewSDRIdentifier(String newSDRIdentifier);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setTechnicalRecordId(String technicalRecordId);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setReferenceEntity(String referenceEntity);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setSeniority(SeniorityEnum seniority);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setSeries(Integer series);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setIndexFactor(BigDecimal indexFactor);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setSeriesVersion(Integer seriesVersion);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setBaseProduct(String baseProduct);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setSubProduct(String subProduct);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setFurtherSubProduct(String furtherSubProduct);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setBarrier(SingleOrUpperAndLowerBarrier barrier);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setInitialMarginCollateralPortfolioCode(String initialMarginCollateralPortfolioCode);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setVariationMarginCollateralPortfolioCode(String variationMarginCollateralPortfolioCode);
		@Override
		SECTransactionReport.SECTransactionReportBuilder setNonReportable(NonReportable nonReportable);
		SECTransactionReport.SECTransactionReportBuilder setClearedOverriddenAsClearedEnum(ClearedEnum cleared);
		SECTransactionReport.SECTransactionReportBuilder setCounterparty2OverriddenAsString(String counterparty2);
		SECTransactionReport.SECTransactionReportBuilder setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(Counterparty2IdentifierEnum counterparty2IdentifierSource);
		SECTransactionReport.SECTransactionReportBuilder setLeg1(SECLeg leg1);
		SECTransactionReport.SECTransactionReportBuilder setLeg2(SECLeg leg2);
		SECTransactionReport.SECTransactionReportBuilder setCustomBasketIndicatorOverriddenAsBoolean(Boolean customBasketIndicator);
		SECTransactionReport.SECTransactionReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime eventTimestamp);
		SECTransactionReport.SECTransactionReportBuilder setPackageIndicatorOverriddenAsBoolean(Boolean packageIndicator);
		SECTransactionReport.SECTransactionReportBuilder setEffectiveDateOverriddenAsDate(Date effectiveDate);
		SECTransactionReport.SECTransactionReportBuilder setExecutionTimestampOverriddenAsZonedDateTime(ZonedDateTime executionTimestamp);
		SECTransactionReport.SECTransactionReportBuilder setPostPricedSwapIndicator(Boolean postPricedSwapIndicator);
		SECTransactionReport.SECTransactionReportBuilder setUniqueSwapIdentifier(String uniqueSwapIdentifier);
		SECTransactionReport.SECTransactionReportBuilder setCounterparty1FinancialEntityIndicator(Boolean counterparty1FinancialEntityIndicator);
		SECTransactionReport.SECTransactionReportBuilder setCounterparty2FinancialEntityIndicator(Boolean counterparty2FinancialEntityIndicator);
		SECTransactionReport.SECTransactionReportBuilder setDtccAdditionalFields(DTCCAdditionalFields dtccAdditionalFields);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("earlyTerminationDate"), Date.class, getEarlyTerminationDate(), this);
			processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
			processor.processBasic(path.newSubPath("executionTimestamp"), ZonedDateTime.class, getExecutionTimestamp(), this);
			processor.processBasic(path.newSubPath("expirationDate"), Date.class, getExpirationDate(), this);
			processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
			processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
			processor.processBasic(path.newSubPath("beneficiary1"), String.class, getBeneficiary1(), this);
			processor.processBasic(path.newSubPath("beneficiary1IdentifierTypeIndicator"), Boolean.class, getBeneficiary1IdentifierTypeIndicator(), this);
			processor.processBasic(path.newSubPath("buyerIdentifier"), String.class, getBuyerIdentifier(), this);
			processor.processBasic(path.newSubPath("sellerIdentifier"), String.class, getSellerIdentifier(), this);
			processor.processBasic(path.newSubPath("cleared"), ClearedEnum.class, getCleared(), this);
			processor.processBasic(path.newSubPath("centralCounterparty"), String.class, getCentralCounterparty(), this);
			processor.processBasic(path.newSubPath("clearingMember"), String.class, getClearingMember(), this);
			processor.processBasic(path.newSubPath("confirmed"), ConfirmationEnum.class, getConfirmed(), this);
			processor.processBasic(path.newSubPath("callAmount"), BigDecimal.class, getCallAmount(), this);
			processor.processBasic(path.newSubPath("putAmount"), BigDecimal.class, getPutAmount(), this);
			processor.processBasic(path.newSubPath("callCurrency"), ISOCurrencyCodeEnum.class, getCallCurrency(), this);
			processor.processBasic(path.newSubPath("putCurrency"), ISOCurrencyCodeEnum.class, getPutCurrency(), this);
			processor.processBasic(path.newSubPath("delta"), BigDecimal.class, getDelta(), this);
			processRosetta(path.newSubPath("priceSchedule"), processor, PricePeriod.PricePeriodBuilder.class, getPriceSchedule());
			processRosetta(path.newSubPath("strikePriceSchedule"), processor, PricePeriod.PricePeriodBuilder.class, getStrikePriceSchedule());
			processRosetta(path.newSubPath("price"), processor, PriceFormat.PriceFormatBuilder.class, getPrice());
			processor.processBasic(path.newSubPath("priceNotation"), PriceNotationEnum.class, getPriceNotation(), this);
			processor.processBasic(path.newSubPath("priceCurrency"), ISOCurrencyCodeEnum.class, getPriceCurrency(), this);
			processRosetta(path.newSubPath("packageTransactionPrice"), processor, PriceFormat.PriceFormatBuilder.class, getPackageTransactionPrice());
			processor.processBasic(path.newSubPath("packageTransactionPriceNotation"), PriceNotationEnum.class, getPackageTransactionPriceNotation(), this);
			processor.processBasic(path.newSubPath("packageTransactionPriceCurrency"), ISOCurrencyCodeEnum.class, getPackageTransactionPriceCurrency(), this);
			processRosetta(path.newSubPath("packageTransactionSpread"), processor, PriceFormat.PriceFormatBuilder.class, getPackageTransactionSpread());
			processor.processBasic(path.newSubPath("packageTransactionSpreadNotation"), PriceNotationEnum.class, getPackageTransactionSpreadNotation(), this);
			processor.processBasic(path.newSubPath("packageTransactionSpreadCurrency"), ISOCurrencyCodeEnum.class, getPackageTransactionSpreadCurrency(), this);
			processor.processBasic(path.newSubPath("packageIdentifier"), String.class, getPackageIdentifier(), this);
			processRosetta(path.newSubPath("strikePrice"), processor, PriceFormat.PriceFormatBuilder.class, getStrikePrice());
			processor.processBasic(path.newSubPath("strikePriceNotation"), PriceNotationEnum.class, getStrikePriceNotation(), this);
			processor.processBasic(path.newSubPath("strikePriceCurrency"), String.class, getStrikePriceCurrency(), this);
			processor.processBasic(path.newSubPath("priceUnitOfMeasure"), String.class, getPriceUnitOfMeasure(), this);
			processor.processBasic(path.newSubPath("optionPremiumAmount"), BigDecimal.class, getOptionPremiumAmount(), this);
			processor.processBasic(path.newSubPath("optionPremiumCurrency"), ISOCurrencyCodeEnum.class, getOptionPremiumCurrency(), this);
			processor.processBasic(path.newSubPath("optionPremiumPaymentDate"), Date.class, getOptionPremiumPaymentDate(), this);
			processor.processBasic(path.newSubPath("exchangeRate"), BigDecimal.class, getExchangeRate(), this);
			processor.processBasic(path.newSubPath("exchangeRateBasis"), String.class, getExchangeRateBasis(), this);
			processor.processBasic(path.newSubPath("cdSIndexAttachmentPoint"), BigDecimal.class, getCdSIndexAttachmentPoint(), this);
			processor.processBasic(path.newSubPath("cdSIndexDetachmentPoint"), BigDecimal.class, getCdSIndexDetachmentPoint(), this);
			processor.processBasic(path.newSubPath("collateralPortfolioIndicator"), Boolean.class, getCollateralPortfolioIndicator(), this);
			processor.processBasic(path.newSubPath("firstExerciseDate"), Date.class, getFirstExerciseDate(), this);
			processor.processBasic(path.newSubPath("finalContractualSettlementDate"), Date.class, getFinalContractualSettlementDate(), this);
			processor.processBasic(path.newSubPath("settlementLocation"), ISOCountryCodeEnum.class, getSettlementLocation(), this);
			processor.processBasic(path.newSubPath("priorUTI"), String.class, getPriorUTI(), this);
			processor.processBasic(path.newSubPath("direction1"), Direction1Enum.class, getDirection1(), this);
			processor.processBasic(path.newSubPath("valuationAmount"), BigDecimal.class, getValuationAmount(), this);
			processor.processBasic(path.newSubPath("valuationCurrency"), ISOCurrencyCodeEnum.class, getValuationCurrency(), this);
			processor.processBasic(path.newSubPath("valuationMethod"), ValuationType1Code.class, getValuationMethod(), this);
			processor.processBasic(path.newSubPath("valuationTimestamp"), ZonedDateTime.class, getValuationTimestamp(), this);
			processor.processBasic(path.newSubPath("customBasketCode"), String.class, getCustomBasketCode(), this);
			processRosetta(path.newSubPath("basketConstituents"), processor, BasketConstituentsReport.BasketConstituentsReportBuilder.class, getBasketConstituents());
			processRosetta(path.newSubPath("otherPayment"), processor, OtherPayment.OtherPaymentBuilder.class, getOtherPayment());
			processRosetta(path.newSubPath("leg1"), processor, SECLeg.SECLegBuilder.class, getLeg1());
			processRosetta(path.newSubPath("leg2"), processor, SECLeg.SECLegBuilder.class, getLeg2());
			processor.processBasic(path.newSubPath("underlyingIdOther"), String.class, getUnderlyingIdOther(), this);
			processor.processBasic(path.newSubPath("underlyingIdOtherSource"), AssetIdTypeEnum.class, getUnderlyingIdOtherSource(), this);
			processor.processBasic(path.newSubPath("underlyingAssetTradingPlatformIdentifier"), String.class, getUnderlyingAssetTradingPlatformIdentifier(), this);
			processor.processBasic(path.newSubPath("underlyingAssetPriceSource"), String.class, getUnderlyingAssetPriceSource(), this);
			processor.processBasic(path.newSubPath("cryptoAssetUnderlyingIndicator"), Boolean.class, getCryptoAssetUnderlyingIndicator(), this);
			processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
			processor.processBasic(path.newSubPath("actionType"), ActionTypeEnum.class, getActionType(), this);
			processor.processBasic(path.newSubPath("eventType"), EventTypeEnum.class, getEventType(), this);
			processor.processBasic(path.newSubPath("eventIdentifier"), String.class, getEventIdentifier(), this);
			processor.processBasic(path.newSubPath("eventTimestamp"), ZonedDateTime.class, getEventTimestamp(), this);
			processor.processBasic(path.newSubPath("confirmationTimestamp"), ZonedDateTime.class, getConfirmationTimestamp(), this);
			processor.processBasic(path.newSubPath("platformIdentifier"), String.class, getPlatformIdentifier(), this);
			processor.processBasic(path.newSubPath("bookingLocation"), ISOCountryCodeEnum.class, getBookingLocation(), this);
			processor.processBasic(path.newSubPath("traderLocation"), ISOCountryCodeEnum.class, getTraderLocation(), this);
			processor.processBasic(path.newSubPath("deliveryType"), DeliveryTypeEnum.class, getDeliveryType(), this);
			processor.processBasic(path.newSubPath("executionAgentCounterparty1"), String.class, getExecutionAgentCounterparty1(), this);
			processor.processBasic(path.newSubPath("executionAgentCounterparty2"), String.class, getExecutionAgentCounterparty2(), this);
			processor.processBasic(path.newSubPath("natureOfCounterparty1"), NatureOfCounterpartyEnum.class, getNatureOfCounterparty1(), this);
			processor.processBasic(path.newSubPath("natureOfCounterparty2"), NatureOfCounterpartyEnum.class, getNatureOfCounterparty2(), this);
			processor.processBasic(path.newSubPath("clearingExceptionsAndExemptionsCounterparty1"), ClearingExceptionsAndExemptionsEnum.class, getClearingExceptionsAndExemptionsCounterparty1(), this);
			processor.processBasic(path.newSubPath("clearingExceptionsAndExemptionsCounterparty2"), ClearingExceptionsAndExemptionsEnum.class, getClearingExceptionsAndExemptionsCounterparty2(), this);
			processor.processBasic(path.newSubPath("corporateSectorOfTheCounterparty1"), String.class, getCorporateSectorOfTheCounterparty1(), this);
			processor.processBasic(path.newSubPath("corporateSectorOfTheCounterparty2"), String.class, getCorporateSectorOfTheCounterparty2(), this);
			processor.processBasic(path.newSubPath("counterparty2Name"), String.class, getCounterparty2Name(), this);
			processor.processBasic(path.newSubPath("reportSubmittingEntityID"), String.class, getReportSubmittingEntityID(), this);
			processor.processBasic(path.newSubPath("entityResponsibleForReporting"), String.class, getEntityResponsibleForReporting(), this);
			processor.processBasic(path.newSubPath("countryOfTheCounterparty2"), ISOCountryCodeEnum.class, getCountryOfTheCounterparty2(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierSource"), Counterparty2IdentifierEnum.class, getCounterparty2IdentifierSource(), this);
			processor.processBasic(path.newSubPath("tradingCapacity"), TradingCapacity7Code.class, getTradingCapacity(), this);
			processor.processBasic(path.newSubPath("brokerID"), String.class, getBrokerID(), this);
			processor.processBasic(path.newSubPath("contractType"), CommonContractType.class, getContractType(), this);
			processor.processBasic(path.newSubPath("assetClass"), CommonAssetClass.class, getAssetClass(), this);
			processor.processBasic(path.newSubPath("optionType"), OptionTypeCode.class, getOptionType(), this);
			processor.processBasic(path.newSubPath("optionStyle"), OptionStyleEnum.class, getOptionStyle(), this);
			processor.processBasic(path.newSubPath("embeddedOptionType"), EmbeddedOptionTypeEnum.class, getEmbeddedOptionType(), this);
			processor.processBasic(path.newSubPath("masterAgreementType"), MasterAgreementEnum.class, getMasterAgreementType(), this);
			processor.processBasic(path.newSubPath("masterAgreementVersion"), Integer.class, getMasterAgreementVersion(), this);
			processor.processBasic(path.newSubPath("secondaryTransactionIdentifier"), String.class, getSecondaryTransactionIdentifier(), this);
			processor.processBasic(path.newSubPath("intragroup"), Boolean.class, getIntragroup(), this);
			processor.processBasic(path.newSubPath("nonStandardizedTermIndicator"), Boolean.class, getNonStandardizedTermIndicator(), this);
			processor.processBasic(path.newSubPath("amendmentIndicator"), Boolean.class, getAmendmentIndicator(), this);
			processor.processBasic(path.newSubPath("underlyingIdentification"), String.class, getUnderlyingIdentification(), this);
			processor.processBasic(path.newSubPath("underlyingIdentificationType"), UnderlyingIdentificationTypeEnum.class, getUnderlyingIdentificationType(), this);
			processor.processBasic(path.newSubPath("nameOfTheUnderlyingIndex"), String.class, getNameOfTheUnderlyingIndex(), this);
			processor.processBasic(path.newSubPath("maturityDateOfTheUnderlying"), Date.class, getMaturityDateOfTheUnderlying(), this);
			processor.processBasic(path.newSubPath("swapLinkID"), String.class, getSwapLinkID(), this);
			processor.processBasic(path.newSubPath("packageIndicator"), Boolean.class, getPackageIndicator(), this);
			processor.processBasic(path.newSubPath("customBasketIndicator"), Boolean.class, getCustomBasketIndicator(), this);
			processor.processBasic(path.newSubPath("priorUTIProprietary"), String.class, getPriorUTIProprietary(), this);
			processor.processBasic(path.newSubPath("clearingTimestamp"), ZonedDateTime.class, getClearingTimestamp(), this);
			processor.processBasic(path.newSubPath("clearingAccountOrigin"), ClearingAccountOriginEnum.class, getClearingAccountOrigin(), this);
			processor.processBasic(path.newSubPath("clearingReceiptTimestamp"), ZonedDateTime.class, getClearingReceiptTimestamp(), this);
			processor.processBasic(path.newSubPath("uniqueTransactionIdentifier"), String.class, getUniqueTransactionIdentifier(), this);
			processor.processBasic(path.newSubPath("uniqueTransactionIdentifierProprietary"), String.class, getUniqueTransactionIdentifierProprietary(), this);
			processor.processBasic(path.newSubPath("uniqueProductIdentifier"), String.class, getUniqueProductIdentifier(), this);
			processor.processBasic(path.newSubPath("originalSwapUTI"), String.class, getOriginalSwapUTI(), this);
			processor.processBasic(path.newSubPath("subsequentPositionUTI"), String.class, getSubsequentPositionUTI(), this);
			processor.processBasic(path.newSubPath("originalSwapSDRIdentifier"), String.class, getOriginalSwapSDRIdentifier(), this);
			processor.processBasic(path.newSubPath("priorUSI"), String.class, getPriorUSI(), this);
			processor.processBasic(path.newSubPath("newSDRIdentifier"), String.class, getNewSDRIdentifier(), this);
			processor.processBasic(path.newSubPath("technicalRecordId"), String.class, getTechnicalRecordId(), this);
			processor.processBasic(path.newSubPath("referenceEntity"), String.class, getReferenceEntity(), this);
			processor.processBasic(path.newSubPath("seniority"), SeniorityEnum.class, getSeniority(), this);
			processor.processBasic(path.newSubPath("series"), Integer.class, getSeries(), this);
			processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
			processor.processBasic(path.newSubPath("seriesVersion"), Integer.class, getSeriesVersion(), this);
			processor.processBasic(path.newSubPath("baseProduct"), String.class, getBaseProduct(), this);
			processor.processBasic(path.newSubPath("subProduct"), String.class, getSubProduct(), this);
			processor.processBasic(path.newSubPath("furtherSubProduct"), String.class, getFurtherSubProduct(), this);
			processRosetta(path.newSubPath("barrier"), processor, SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder.class, getBarrier());
			processor.processBasic(path.newSubPath("initialMarginCollateralPortfolioCode"), String.class, getInitialMarginCollateralPortfolioCode(), this);
			processor.processBasic(path.newSubPath("variationMarginCollateralPortfolioCode"), String.class, getVariationMarginCollateralPortfolioCode(), this);
			processRosetta(path.newSubPath("nonReportable"), processor, NonReportable.NonReportableBuilder.class, getNonReportable());
			processor.processBasic(path.newSubPath("postPricedSwapIndicator"), Boolean.class, getPostPricedSwapIndicator(), this);
			processor.processBasic(path.newSubPath("uniqueSwapIdentifier"), String.class, getUniqueSwapIdentifier(), this);
			processor.processBasic(path.newSubPath("counterparty1FinancialEntityIndicator"), Boolean.class, getCounterparty1FinancialEntityIndicator(), this);
			processor.processBasic(path.newSubPath("counterparty2FinancialEntityIndicator"), Boolean.class, getCounterparty2FinancialEntityIndicator(), this);
			processRosetta(path.newSubPath("dtccAdditionalFields"), processor, DTCCAdditionalFields.DTCCAdditionalFieldsBuilder.class, getDtccAdditionalFields());
		}
		

		SECTransactionReport.SECTransactionReportBuilder prune();
	}

	/*********************** Immutable Implementation of SECTransactionReport  ***********************/
	class SECTransactionReportImpl extends CommonTransactionReport.CommonTransactionReportImpl implements SECTransactionReport {
		private final ClearedEnum cleared;
		private final String counterparty2;
		private final Counterparty2IdentifierEnum counterparty2IdentifierSource;
		private final SECLeg leg1;
		private final SECLeg leg2;
		private final Boolean customBasketIndicator;
		private final ZonedDateTime eventTimestamp;
		private final Boolean packageIndicator;
		private final Date effectiveDate;
		private final ZonedDateTime executionTimestamp;
		private final Boolean postPricedSwapIndicator;
		private final String uniqueSwapIdentifier;
		private final Boolean counterparty1FinancialEntityIndicator;
		private final Boolean counterparty2FinancialEntityIndicator;
		private final DTCCAdditionalFields dtccAdditionalFields;
		
		protected SECTransactionReportImpl(SECTransactionReport.SECTransactionReportBuilder builder) {
			super(builder);
			this.cleared = builder.getCleared();
			this.counterparty2 = builder.getCounterparty2();
			this.counterparty2IdentifierSource = builder.getCounterparty2IdentifierSource();
			this.leg1 = ofNullable(builder.getLeg1()).map(f->f.build()).orElse(null);
			this.leg2 = ofNullable(builder.getLeg2()).map(f->f.build()).orElse(null);
			this.customBasketIndicator = builder.getCustomBasketIndicator();
			this.eventTimestamp = builder.getEventTimestamp();
			this.packageIndicator = builder.getPackageIndicator();
			this.effectiveDate = builder.getEffectiveDate();
			this.executionTimestamp = builder.getExecutionTimestamp();
			this.postPricedSwapIndicator = builder.getPostPricedSwapIndicator();
			this.uniqueSwapIdentifier = builder.getUniqueSwapIdentifier();
			this.counterparty1FinancialEntityIndicator = builder.getCounterparty1FinancialEntityIndicator();
			this.counterparty2FinancialEntityIndicator = builder.getCounterparty2FinancialEntityIndicator();
			this.dtccAdditionalFields = ofNullable(builder.getDtccAdditionalFields()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cleared")
		public ClearedEnum getCleared() {
			return cleared;
		}
		
		@Override
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2")
		public String getCounterparty2() {
			return counterparty2;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		public Counterparty2IdentifierEnum getCounterparty2IdentifierSource() {
			return counterparty2IdentifierSource;
		}
		
		@Override
		@RosettaAttribute("leg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg1")
		public SECLeg getLeg1() {
			return leg1;
		}
		
		@Override
		@RosettaAttribute("leg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg2")
		public SECLeg getLeg2() {
			return leg2;
		}
		
		@Override
		@RosettaAttribute("customBasketIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("customBasketIndicator")
		public Boolean getCustomBasketIndicator() {
			return customBasketIndicator;
		}
		
		@Override
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		public ZonedDateTime getEventTimestamp() {
			return eventTimestamp;
		}
		
		@Override
		@RosettaAttribute("packageIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("packageIndicator")
		public Boolean getPackageIndicator() {
			return packageIndicator;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionTimestamp")
		public ZonedDateTime getExecutionTimestamp() {
			return executionTimestamp;
		}
		
		@Override
		@RosettaAttribute("postPricedSwapIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("postPricedSwapIndicator")
		public Boolean getPostPricedSwapIndicator() {
			return postPricedSwapIndicator;
		}
		
		@Override
		@RosettaAttribute("uniqueSwapIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueSwapIdentifier")
		public String getUniqueSwapIdentifier() {
			return uniqueSwapIdentifier;
		}
		
		@Override
		@RosettaAttribute("counterparty1FinancialEntityIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty1FinancialEntityIndicator")
		public Boolean getCounterparty1FinancialEntityIndicator() {
			return counterparty1FinancialEntityIndicator;
		}
		
		@Override
		@RosettaAttribute("counterparty2FinancialEntityIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2FinancialEntityIndicator")
		public Boolean getCounterparty2FinancialEntityIndicator() {
			return counterparty2FinancialEntityIndicator;
		}
		
		@Override
		@RosettaAttribute("dtccAdditionalFields")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dtccAdditionalFields")
		public DTCCAdditionalFields getDtccAdditionalFields() {
			return dtccAdditionalFields;
		}
		
		@Override
		public SECTransactionReport build() {
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder toBuilder() {
			SECTransactionReport.SECTransactionReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SECTransactionReport.SECTransactionReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCleared()).ifPresent(builder::setClearedOverriddenAsClearedEnum);
			ofNullable(getCounterparty2()).ifPresent(builder::setCounterparty2OverriddenAsString);
			ofNullable(getCounterparty2IdentifierSource()).ifPresent(builder::setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum);
			ofNullable(getLeg1()).ifPresent(builder::setLeg1);
			ofNullable(getLeg2()).ifPresent(builder::setLeg2);
			ofNullable(getCustomBasketIndicator()).ifPresent(builder::setCustomBasketIndicatorOverriddenAsBoolean);
			ofNullable(getEventTimestamp()).ifPresent(builder::setEventTimestampOverriddenAsZonedDateTime);
			ofNullable(getPackageIndicator()).ifPresent(builder::setPackageIndicatorOverriddenAsBoolean);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDateOverriddenAsDate);
			ofNullable(getExecutionTimestamp()).ifPresent(builder::setExecutionTimestampOverriddenAsZonedDateTime);
			ofNullable(getPostPricedSwapIndicator()).ifPresent(builder::setPostPricedSwapIndicator);
			ofNullable(getUniqueSwapIdentifier()).ifPresent(builder::setUniqueSwapIdentifier);
			ofNullable(getCounterparty1FinancialEntityIndicator()).ifPresent(builder::setCounterparty1FinancialEntityIndicator);
			ofNullable(getCounterparty2FinancialEntityIndicator()).ifPresent(builder::setCounterparty2FinancialEntityIndicator);
			ofNullable(getDtccAdditionalFields()).ifPresent(builder::setDtccAdditionalFields);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SECTransactionReport _that = getType().cast(o);
		
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(counterparty2IdentifierSource, _that.getCounterparty2IdentifierSource())) return false;
			if (!Objects.equals(leg1, _that.getLeg1())) return false;
			if (!Objects.equals(leg2, _that.getLeg2())) return false;
			if (!Objects.equals(customBasketIndicator, _that.getCustomBasketIndicator())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(packageIndicator, _that.getPackageIndicator())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(executionTimestamp, _that.getExecutionTimestamp())) return false;
			if (!Objects.equals(postPricedSwapIndicator, _that.getPostPricedSwapIndicator())) return false;
			if (!Objects.equals(uniqueSwapIdentifier, _that.getUniqueSwapIdentifier())) return false;
			if (!Objects.equals(counterparty1FinancialEntityIndicator, _that.getCounterparty1FinancialEntityIndicator())) return false;
			if (!Objects.equals(counterparty2FinancialEntityIndicator, _that.getCounterparty2FinancialEntityIndicator())) return false;
			if (!Objects.equals(dtccAdditionalFields, _that.getDtccAdditionalFields())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (cleared != null ? cleared.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierSource != null ? counterparty2IdentifierSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (leg1 != null ? leg1.hashCode() : 0);
			_result = 31 * _result + (leg2 != null ? leg2.hashCode() : 0);
			_result = 31 * _result + (customBasketIndicator != null ? customBasketIndicator.hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (packageIndicator != null ? packageIndicator.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (executionTimestamp != null ? executionTimestamp.hashCode() : 0);
			_result = 31 * _result + (postPricedSwapIndicator != null ? postPricedSwapIndicator.hashCode() : 0);
			_result = 31 * _result + (uniqueSwapIdentifier != null ? uniqueSwapIdentifier.hashCode() : 0);
			_result = 31 * _result + (counterparty1FinancialEntityIndicator != null ? counterparty1FinancialEntityIndicator.hashCode() : 0);
			_result = 31 * _result + (counterparty2FinancialEntityIndicator != null ? counterparty2FinancialEntityIndicator.hashCode() : 0);
			_result = 31 * _result + (dtccAdditionalFields != null ? dtccAdditionalFields.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SECTransactionReport {" +
				"cleared=" + this.cleared + ", " +
				"counterparty2=" + this.counterparty2 + ", " +
				"counterparty2IdentifierSource=" + this.counterparty2IdentifierSource + ", " +
				"leg1=" + this.leg1 + ", " +
				"leg2=" + this.leg2 + ", " +
				"customBasketIndicator=" + this.customBasketIndicator + ", " +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"packageIndicator=" + this.packageIndicator + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"executionTimestamp=" + this.executionTimestamp + ", " +
				"postPricedSwapIndicator=" + this.postPricedSwapIndicator + ", " +
				"uniqueSwapIdentifier=" + this.uniqueSwapIdentifier + ", " +
				"counterparty1FinancialEntityIndicator=" + this.counterparty1FinancialEntityIndicator + ", " +
				"counterparty2FinancialEntityIndicator=" + this.counterparty2FinancialEntityIndicator + ", " +
				"dtccAdditionalFields=" + this.dtccAdditionalFields +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SECTransactionReport  ***********************/
	class SECTransactionReportBuilderImpl implements SECTransactionReport.SECTransactionReportBuilder {
	
		protected Date effectiveDate;
		protected Date earlyTerminationDate;
		protected ZonedDateTime reportingTimestamp;
		protected ZonedDateTime executionTimestamp;
		protected Date expirationDate;
		protected String counterparty1;
		protected String counterparty2;
		protected Boolean counterparty2IdentifierType;
		protected String beneficiary1;
		protected Boolean beneficiary1IdentifierTypeIndicator;
		protected String buyerIdentifier;
		protected String sellerIdentifier;
		protected ClearedEnum cleared;
		protected String centralCounterparty;
		protected String clearingMember;
		protected ConfirmationEnum confirmed;
		protected BigDecimal callAmount;
		protected BigDecimal putAmount;
		protected ISOCurrencyCodeEnum callCurrency;
		protected ISOCurrencyCodeEnum putCurrency;
		protected BigDecimal delta;
		protected List<PricePeriod.PricePeriodBuilder> priceSchedule = new ArrayList<>();
		protected List<PricePeriod.PricePeriodBuilder> strikePriceSchedule = new ArrayList<>();
		protected PriceFormat.PriceFormatBuilder price;
		protected PriceNotationEnum priceNotation;
		protected ISOCurrencyCodeEnum priceCurrency;
		protected PriceFormat.PriceFormatBuilder packageTransactionPrice;
		protected PriceNotationEnum packageTransactionPriceNotation;
		protected ISOCurrencyCodeEnum packageTransactionPriceCurrency;
		protected PriceFormat.PriceFormatBuilder packageTransactionSpread;
		protected PriceNotationEnum packageTransactionSpreadNotation;
		protected ISOCurrencyCodeEnum packageTransactionSpreadCurrency;
		protected String packageIdentifier;
		protected PriceFormat.PriceFormatBuilder strikePrice;
		protected PriceNotationEnum strikePriceNotation;
		protected String strikePriceCurrency;
		protected String priceUnitOfMeasure;
		protected BigDecimal optionPremiumAmount;
		protected ISOCurrencyCodeEnum optionPremiumCurrency;
		protected Date optionPremiumPaymentDate;
		protected BigDecimal exchangeRate;
		protected String exchangeRateBasis;
		protected BigDecimal cdSIndexAttachmentPoint;
		protected BigDecimal cdSIndexDetachmentPoint;
		protected Boolean collateralPortfolioIndicator;
		protected Date firstExerciseDate;
		protected Date finalContractualSettlementDate;
		protected ISOCountryCodeEnum settlementLocation;
		protected String priorUTI;
		protected Direction1Enum direction1;
		protected BigDecimal valuationAmount;
		protected ISOCurrencyCodeEnum valuationCurrency;
		protected ValuationType1Code valuationMethod;
		protected ZonedDateTime valuationTimestamp;
		protected String customBasketCode;
		protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> basketConstituents = new ArrayList<>();
		protected List<OtherPayment.OtherPaymentBuilder> otherPayment = new ArrayList<>();
		protected SECLeg.SECLegBuilder leg1;
		protected SECLeg.SECLegBuilder leg2;
		protected String underlyingIdOther;
		protected AssetIdTypeEnum underlyingIdOtherSource;
		protected String underlyingAssetTradingPlatformIdentifier;
		protected String underlyingAssetPriceSource;
		protected Boolean cryptoAssetUnderlyingIndicator;
		protected ReportLevelEnum level;
		protected ActionTypeEnum actionType;
		protected EventTypeEnum eventType;
		protected String eventIdentifier;
		protected ZonedDateTime eventTimestamp;
		protected ZonedDateTime confirmationTimestamp;
		protected String platformIdentifier;
		protected ISOCountryCodeEnum bookingLocation;
		protected ISOCountryCodeEnum traderLocation;
		protected DeliveryTypeEnum deliveryType;
		protected String executionAgentCounterparty1;
		protected String executionAgentCounterparty2;
		protected NatureOfCounterpartyEnum natureOfCounterparty1;
		protected NatureOfCounterpartyEnum natureOfCounterparty2;
		protected List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1 = new ArrayList<>();
		protected List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2 = new ArrayList<>();
		protected List<String> corporateSectorOfTheCounterparty1 = new ArrayList<>();
		protected List<String> corporateSectorOfTheCounterparty2 = new ArrayList<>();
		protected String counterparty2Name;
		protected String reportSubmittingEntityID;
		protected String entityResponsibleForReporting;
		protected ISOCountryCodeEnum countryOfTheCounterparty2;
		protected Counterparty2IdentifierEnum counterparty2IdentifierSource;
		protected TradingCapacity7Code tradingCapacity;
		protected String brokerID;
		protected CommonContractType contractType;
		protected CommonAssetClass assetClass;
		protected OptionTypeCode optionType;
		protected OptionStyleEnum optionStyle;
		protected EmbeddedOptionTypeEnum embeddedOptionType;
		protected MasterAgreementEnum masterAgreementType;
		protected Integer masterAgreementVersion;
		protected String secondaryTransactionIdentifier;
		protected Boolean intragroup;
		protected Boolean nonStandardizedTermIndicator;
		protected Boolean amendmentIndicator;
		protected String underlyingIdentification;
		protected UnderlyingIdentificationTypeEnum underlyingIdentificationType;
		protected String nameOfTheUnderlyingIndex;
		protected Date maturityDateOfTheUnderlying;
		protected String swapLinkID;
		protected Boolean packageIndicator;
		protected Boolean customBasketIndicator;
		protected String priorUTIProprietary;
		protected ZonedDateTime clearingTimestamp;
		protected ClearingAccountOriginEnum clearingAccountOrigin;
		protected ZonedDateTime clearingReceiptTimestamp;
		protected String uniqueTransactionIdentifier;
		protected String uniqueTransactionIdentifierProprietary;
		protected String uniqueProductIdentifier;
		protected String originalSwapUTI;
		protected String subsequentPositionUTI;
		protected String originalSwapSDRIdentifier;
		protected String priorUSI;
		protected String newSDRIdentifier;
		protected String technicalRecordId;
		protected String referenceEntity;
		protected SeniorityEnum seniority;
		protected Integer series;
		protected BigDecimal indexFactor;
		protected Integer seriesVersion;
		protected String baseProduct;
		protected String subProduct;
		protected String furtherSubProduct;
		protected SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder barrier;
		protected String initialMarginCollateralPortfolioCode;
		protected String variationMarginCollateralPortfolioCode;
		protected NonReportable.NonReportableBuilder nonReportable;
		protected Boolean postPricedSwapIndicator;
		protected String uniqueSwapIdentifier;
		protected Boolean counterparty1FinancialEntityIndicator;
		protected Boolean counterparty2FinancialEntityIndicator;
		protected DTCCAdditionalFields.DTCCAdditionalFieldsBuilder dtccAdditionalFields;
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTerminationDate")
		public Date getEarlyTerminationDate() {
			return earlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		public ZonedDateTime getReportingTimestamp() {
			return reportingTimestamp;
		}
		
		@Override
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionTimestamp")
		public ZonedDateTime getExecutionTimestamp() {
			return executionTimestamp;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationDate")
		public Date getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty1")
		public String getCounterparty1() {
			return counterparty1;
		}
		
		@Override
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2")
		public String getCounterparty2() {
			return counterparty2;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
		}
		
		@Override
		@RosettaAttribute("beneficiary1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiary1")
		public String getBeneficiary1() {
			return beneficiary1;
		}
		
		@Override
		@RosettaAttribute("beneficiary1IdentifierTypeIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiary1IdentifierTypeIndicator")
		public Boolean getBeneficiary1IdentifierTypeIndicator() {
			return beneficiary1IdentifierTypeIndicator;
		}
		
		@Override
		@RosettaAttribute("buyerIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerIdentifier")
		public String getBuyerIdentifier() {
			return buyerIdentifier;
		}
		
		@Override
		@RosettaAttribute("sellerIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerIdentifier")
		public String getSellerIdentifier() {
			return sellerIdentifier;
		}
		
		@Override
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cleared")
		public ClearedEnum getCleared() {
			return cleared;
		}
		
		@Override
		@RosettaAttribute("centralCounterparty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("centralCounterparty")
		public String getCentralCounterparty() {
			return centralCounterparty;
		}
		
		@Override
		@RosettaAttribute("clearingMember")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingMember")
		public String getClearingMember() {
			return clearingMember;
		}
		
		@Override
		@RosettaAttribute("confirmed")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confirmed")
		public ConfirmationEnum getConfirmed() {
			return confirmed;
		}
		
		@Override
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callAmount")
		public BigDecimal getCallAmount() {
			return callAmount;
		}
		
		@Override
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("putAmount")
		public BigDecimal getPutAmount() {
			return putAmount;
		}
		
		@Override
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callCurrency")
		public ISOCurrencyCodeEnum getCallCurrency() {
			return callCurrency;
		}
		
		@Override
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("putCurrency")
		public ISOCurrencyCodeEnum getPutCurrency() {
			return putCurrency;
		}
		
		@Override
		@RosettaAttribute("delta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("delta")
		public BigDecimal getDelta() {
			return delta;
		}
		
		@Override
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("priceSchedule")
		public List<? extends PricePeriod.PricePeriodBuilder> getPriceSchedule() {
			return priceSchedule;
		}
		
		@Override
		public PricePeriod.PricePeriodBuilder getOrCreatePriceSchedule(int index) {
			if (priceSchedule==null) {
				this.priceSchedule = new ArrayList<>();
			}
			return getIndex(priceSchedule, index, () -> {
						PricePeriod.PricePeriodBuilder newPriceSchedule = PricePeriod.builder();
						return newPriceSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		public List<? extends PricePeriod.PricePeriodBuilder> getStrikePriceSchedule() {
			return strikePriceSchedule;
		}
		
		@Override
		public PricePeriod.PricePeriodBuilder getOrCreateStrikePriceSchedule(int index) {
			if (strikePriceSchedule==null) {
				this.strikePriceSchedule = new ArrayList<>();
			}
			return getIndex(strikePriceSchedule, index, () -> {
						PricePeriod.PricePeriodBuilder newStrikePriceSchedule = PricePeriod.builder();
						return newStrikePriceSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public PriceFormat.PriceFormatBuilder getPrice() {
			return price;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreatePrice() {
			PriceFormat.PriceFormatBuilder result;
			if (price!=null) {
				result = price;
			}
			else {
				result = price = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceNotation")
		public PriceNotationEnum getPriceNotation() {
			return priceNotation;
		}
		
		@Override
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceCurrency")
		public ISOCurrencyCodeEnum getPriceCurrency() {
			return priceCurrency;
		}
		
		@Override
		@RosettaAttribute("packageTransactionPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionPrice")
		public PriceFormat.PriceFormatBuilder getPackageTransactionPrice() {
			return packageTransactionPrice;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreatePackageTransactionPrice() {
			PriceFormat.PriceFormatBuilder result;
			if (packageTransactionPrice!=null) {
				result = packageTransactionPrice;
			}
			else {
				result = packageTransactionPrice = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("packageTransactionPriceNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionPriceNotation")
		public PriceNotationEnum getPackageTransactionPriceNotation() {
			return packageTransactionPriceNotation;
		}
		
		@Override
		@RosettaAttribute("packageTransactionPriceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionPriceCurrency")
		public ISOCurrencyCodeEnum getPackageTransactionPriceCurrency() {
			return packageTransactionPriceCurrency;
		}
		
		@Override
		@RosettaAttribute("packageTransactionSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionSpread")
		public PriceFormat.PriceFormatBuilder getPackageTransactionSpread() {
			return packageTransactionSpread;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreatePackageTransactionSpread() {
			PriceFormat.PriceFormatBuilder result;
			if (packageTransactionSpread!=null) {
				result = packageTransactionSpread;
			}
			else {
				result = packageTransactionSpread = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("packageTransactionSpreadNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionSpreadNotation")
		public PriceNotationEnum getPackageTransactionSpreadNotation() {
			return packageTransactionSpreadNotation;
		}
		
		@Override
		@RosettaAttribute("packageTransactionSpreadCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionSpreadCurrency")
		public ISOCurrencyCodeEnum getPackageTransactionSpreadCurrency() {
			return packageTransactionSpreadCurrency;
		}
		
		@Override
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageIdentifier")
		public String getPackageIdentifier() {
			return packageIdentifier;
		}
		
		@Override
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePrice")
		public PriceFormat.PriceFormatBuilder getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreateStrikePrice() {
			PriceFormat.PriceFormatBuilder result;
			if (strikePrice!=null) {
				result = strikePrice;
			}
			else {
				result = strikePrice = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceNotation")
		public PriceNotationEnum getStrikePriceNotation() {
			return strikePriceNotation;
		}
		
		@Override
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceCurrency")
		public String getStrikePriceCurrency() {
			return strikePriceCurrency;
		}
		
		@Override
		@RosettaAttribute("priceUnitOfMeasure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceUnitOfMeasure")
		public String getPriceUnitOfMeasure() {
			return priceUnitOfMeasure;
		}
		
		@Override
		@RosettaAttribute("optionPremiumAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionPremiumAmount")
		public BigDecimal getOptionPremiumAmount() {
			return optionPremiumAmount;
		}
		
		@Override
		@RosettaAttribute("optionPremiumCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionPremiumCurrency")
		public ISOCurrencyCodeEnum getOptionPremiumCurrency() {
			return optionPremiumCurrency;
		}
		
		@Override
		@RosettaAttribute("optionPremiumPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionPremiumPaymentDate")
		public Date getOptionPremiumPaymentDate() {
			return optionPremiumPaymentDate;
		}
		
		@Override
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeRate")
		public BigDecimal getExchangeRate() {
			return exchangeRate;
		}
		
		@Override
		@RosettaAttribute("exchangeRateBasis")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeRateBasis")
		public String getExchangeRateBasis() {
			return exchangeRateBasis;
		}
		
		@Override
		@RosettaAttribute("cdSIndexAttachmentPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdSIndexAttachmentPoint")
		public BigDecimal getCdSIndexAttachmentPoint() {
			return cdSIndexAttachmentPoint;
		}
		
		@Override
		@RosettaAttribute("cdSIndexDetachmentPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdSIndexDetachmentPoint")
		public BigDecimal getCdSIndexDetachmentPoint() {
			return cdSIndexDetachmentPoint;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		public Boolean getCollateralPortfolioIndicator() {
			return collateralPortfolioIndicator;
		}
		
		@Override
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstExerciseDate")
		public Date getFirstExerciseDate() {
			return firstExerciseDate;
		}
		
		@Override
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalContractualSettlementDate")
		public Date getFinalContractualSettlementDate() {
			return finalContractualSettlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementLocation")
		public ISOCountryCodeEnum getSettlementLocation() {
			return settlementLocation;
		}
		
		@Override
		@RosettaAttribute("priorUTI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorUTI")
		public String getPriorUTI() {
			return priorUTI;
		}
		
		@Override
		@RosettaAttribute("direction1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("direction1")
		public Direction1Enum getDirection1() {
			return direction1;
		}
		
		@Override
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationAmount")
		public BigDecimal getValuationAmount() {
			return valuationAmount;
		}
		
		@Override
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationCurrency")
		public ISOCurrencyCodeEnum getValuationCurrency() {
			return valuationCurrency;
		}
		
		@Override
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationMethod")
		public ValuationType1Code getValuationMethod() {
			return valuationMethod;
		}
		
		@Override
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationTimestamp")
		public ZonedDateTime getValuationTimestamp() {
			return valuationTimestamp;
		}
		
		@Override
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customBasketCode")
		public String getCustomBasketCode() {
			return customBasketCode;
		}
		
		@Override
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("basketConstituents")
		public List<? extends BasketConstituentsReport.BasketConstituentsReportBuilder> getBasketConstituents() {
			return basketConstituents;
		}
		
		@Override
		public BasketConstituentsReport.BasketConstituentsReportBuilder getOrCreateBasketConstituents(int index) {
			if (basketConstituents==null) {
				this.basketConstituents = new ArrayList<>();
			}
			return getIndex(basketConstituents, index, () -> {
						BasketConstituentsReport.BasketConstituentsReportBuilder newBasketConstituents = BasketConstituentsReport.builder();
						return newBasketConstituents;
					});
		}
		
		@Override
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPayment")
		public List<? extends OtherPayment.OtherPaymentBuilder> getOtherPayment() {
			return otherPayment;
		}
		
		@Override
		public OtherPayment.OtherPaymentBuilder getOrCreateOtherPayment(int index) {
			if (otherPayment==null) {
				this.otherPayment = new ArrayList<>();
			}
			return getIndex(otherPayment, index, () -> {
						OtherPayment.OtherPaymentBuilder newOtherPayment = OtherPayment.builder();
						return newOtherPayment;
					});
		}
		
		@Override
		@RosettaAttribute("leg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg1")
		public SECLeg.SECLegBuilder getLeg1() {
			return leg1;
		}
		
		@Override
		public SECLeg.SECLegBuilder getOrCreateLeg1() {
			SECLeg.SECLegBuilder result;
			if (leg1!=null) {
				result = leg1;
			}
			else {
				result = leg1 = SECLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("leg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg2")
		public SECLeg.SECLegBuilder getLeg2() {
			return leg2;
		}
		
		@Override
		public SECLeg.SECLegBuilder getOrCreateLeg2() {
			SECLeg.SECLegBuilder result;
			if (leg2!=null) {
				result = leg2;
			}
			else {
				result = leg2 = SECLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyingIdOther")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIdOther")
		public String getUnderlyingIdOther() {
			return underlyingIdOther;
		}
		
		@Override
		@RosettaAttribute("underlyingIdOtherSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIdOtherSource")
		public AssetIdTypeEnum getUnderlyingIdOtherSource() {
			return underlyingIdOtherSource;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetTradingPlatformIdentifier")
		public String getUnderlyingAssetTradingPlatformIdentifier() {
			return underlyingAssetTradingPlatformIdentifier;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		public String getUnderlyingAssetPriceSource() {
			return underlyingAssetPriceSource;
		}
		
		@Override
		@RosettaAttribute("cryptoAssetUnderlyingIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cryptoAssetUnderlyingIndicator")
		public Boolean getCryptoAssetUnderlyingIndicator() {
			return cryptoAssetUnderlyingIndicator;
		}
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("level")
		public ReportLevelEnum getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("actionType")
		public ActionTypeEnum getActionType() {
			return actionType;
		}
		
		@Override
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventType")
		public EventTypeEnum getEventType() {
			return eventType;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventIdentifier")
		public String getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		public ZonedDateTime getEventTimestamp() {
			return eventTimestamp;
		}
		
		@Override
		@RosettaAttribute("confirmationTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confirmationTimestamp")
		public ZonedDateTime getConfirmationTimestamp() {
			return confirmationTimestamp;
		}
		
		@Override
		@RosettaAttribute("platformIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("platformIdentifier")
		public String getPlatformIdentifier() {
			return platformIdentifier;
		}
		
		@Override
		@RosettaAttribute("bookingLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bookingLocation")
		public ISOCountryCodeEnum getBookingLocation() {
			return bookingLocation;
		}
		
		@Override
		@RosettaAttribute("traderLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("traderLocation")
		public ISOCountryCodeEnum getTraderLocation() {
			return traderLocation;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryType")
		public DeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("executionAgentCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentCounterparty1")
		public String getExecutionAgentCounterparty1() {
			return executionAgentCounterparty1;
		}
		
		@Override
		@RosettaAttribute("executionAgentCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionAgentCounterparty2")
		public String getExecutionAgentCounterparty2() {
			return executionAgentCounterparty2;
		}
		
		@Override
		@RosettaAttribute("natureOfCounterparty1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("natureOfCounterparty1")
		public NatureOfCounterpartyEnum getNatureOfCounterparty1() {
			return natureOfCounterparty1;
		}
		
		@Override
		@RosettaAttribute("natureOfCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("natureOfCounterparty2")
		public NatureOfCounterpartyEnum getNatureOfCounterparty2() {
			return natureOfCounterparty2;
		}
		
		@Override
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty1")
		public List<ClearingExceptionsAndExemptionsEnum> getClearingExceptionsAndExemptionsCounterparty1() {
			return clearingExceptionsAndExemptionsCounterparty1;
		}
		
		@Override
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty2")
		public List<ClearingExceptionsAndExemptionsEnum> getClearingExceptionsAndExemptionsCounterparty2() {
			return clearingExceptionsAndExemptionsCounterparty2;
		}
		
		@Override
		@RosettaAttribute("corporateSectorOfTheCounterparty1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("corporateSectorOfTheCounterparty1")
		public List<String> getCorporateSectorOfTheCounterparty1() {
			return corporateSectorOfTheCounterparty1;
		}
		
		@Override
		@RosettaAttribute("corporateSectorOfTheCounterparty2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("corporateSectorOfTheCounterparty2")
		public List<String> getCorporateSectorOfTheCounterparty2() {
			return corporateSectorOfTheCounterparty2;
		}
		
		@Override
		@RosettaAttribute("counterparty2Name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2Name")
		public String getCounterparty2Name() {
			return counterparty2Name;
		}
		
		@Override
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		public String getReportSubmittingEntityID() {
			return reportSubmittingEntityID;
		}
		
		@Override
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityResponsibleForReporting")
		public String getEntityResponsibleForReporting() {
			return entityResponsibleForReporting;
		}
		
		@Override
		@RosettaAttribute("countryOfTheCounterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("countryOfTheCounterparty2")
		public ISOCountryCodeEnum getCountryOfTheCounterparty2() {
			return countryOfTheCounterparty2;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		public Counterparty2IdentifierEnum getCounterparty2IdentifierSource() {
			return counterparty2IdentifierSource;
		}
		
		@Override
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradingCapacity")
		public TradingCapacity7Code getTradingCapacity() {
			return tradingCapacity;
		}
		
		@Override
		@RosettaAttribute("brokerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerID")
		public String getBrokerID() {
			return brokerID;
		}
		
		@Override
		@RosettaAttribute("contractType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractType")
		public CommonContractType getContractType() {
			return contractType;
		}
		
		@Override
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assetClass")
		public CommonAssetClass getAssetClass() {
			return assetClass;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public OptionTypeCode getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionStyle")
		public OptionStyleEnum getOptionStyle() {
			return optionStyle;
		}
		
		@Override
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("embeddedOptionType")
		public EmbeddedOptionTypeEnum getEmbeddedOptionType() {
			return embeddedOptionType;
		}
		
		@Override
		@RosettaAttribute("masterAgreementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementType")
		public MasterAgreementEnum getMasterAgreementType() {
			return masterAgreementType;
		}
		
		@Override
		@RosettaAttribute("masterAgreementVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementVersion")
		public Integer getMasterAgreementVersion() {
			return masterAgreementVersion;
		}
		
		@Override
		@RosettaAttribute("secondaryTransactionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secondaryTransactionIdentifier")
		public String getSecondaryTransactionIdentifier() {
			return secondaryTransactionIdentifier;
		}
		
		@Override
		@RosettaAttribute("intragroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intragroup")
		public Boolean getIntragroup() {
			return intragroup;
		}
		
		@Override
		@RosettaAttribute("nonStandardizedTermIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonStandardizedTermIndicator")
		public Boolean getNonStandardizedTermIndicator() {
			return nonStandardizedTermIndicator;
		}
		
		@Override
		@RosettaAttribute("amendmentIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amendmentIndicator")
		public Boolean getAmendmentIndicator() {
			return amendmentIndicator;
		}
		
		@Override
		@RosettaAttribute("underlyingIdentification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIdentification")
		public String getUnderlyingIdentification() {
			return underlyingIdentification;
		}
		
		@Override
		@RosettaAttribute("underlyingIdentificationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIdentificationType")
		public UnderlyingIdentificationTypeEnum getUnderlyingIdentificationType() {
			return underlyingIdentificationType;
		}
		
		@Override
		@RosettaAttribute("nameOfTheUnderlyingIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nameOfTheUnderlyingIndex")
		public String getNameOfTheUnderlyingIndex() {
			return nameOfTheUnderlyingIndex;
		}
		
		@Override
		@RosettaAttribute("maturityDateOfTheUnderlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDateOfTheUnderlying")
		public Date getMaturityDateOfTheUnderlying() {
			return maturityDateOfTheUnderlying;
		}
		
		@Override
		@RosettaAttribute("swapLinkID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("swapLinkID")
		public String getSwapLinkID() {
			return swapLinkID;
		}
		
		@Override
		@RosettaAttribute("packageIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("packageIndicator")
		public Boolean getPackageIndicator() {
			return packageIndicator;
		}
		
		@Override
		@RosettaAttribute("customBasketIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("customBasketIndicator")
		public Boolean getCustomBasketIndicator() {
			return customBasketIndicator;
		}
		
		@Override
		@RosettaAttribute("priorUTIProprietary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorUTIProprietary")
		public String getPriorUTIProprietary() {
			return priorUTIProprietary;
		}
		
		@Override
		@RosettaAttribute("clearingTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingTimestamp")
		public ZonedDateTime getClearingTimestamp() {
			return clearingTimestamp;
		}
		
		@Override
		@RosettaAttribute("clearingAccountOrigin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingAccountOrigin")
		public ClearingAccountOriginEnum getClearingAccountOrigin() {
			return clearingAccountOrigin;
		}
		
		@Override
		@RosettaAttribute("clearingReceiptTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingReceiptTimestamp")
		public ZonedDateTime getClearingReceiptTimestamp() {
			return clearingReceiptTimestamp;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifier")
		public String getUniqueTransactionIdentifier() {
			return uniqueTransactionIdentifier;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		public String getUniqueTransactionIdentifierProprietary() {
			return uniqueTransactionIdentifierProprietary;
		}
		
		@Override
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueProductIdentifier")
		public String getUniqueProductIdentifier() {
			return uniqueProductIdentifier;
		}
		
		@Override
		@RosettaAttribute("originalSwapUTI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalSwapUTI")
		public String getOriginalSwapUTI() {
			return originalSwapUTI;
		}
		
		@Override
		@RosettaAttribute("subsequentPositionUTI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subsequentPositionUTI")
		public String getSubsequentPositionUTI() {
			return subsequentPositionUTI;
		}
		
		@Override
		@RosettaAttribute("originalSwapSDRIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalSwapSDRIdentifier")
		public String getOriginalSwapSDRIdentifier() {
			return originalSwapSDRIdentifier;
		}
		
		@Override
		@RosettaAttribute("priorUSI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorUSI")
		public String getPriorUSI() {
			return priorUSI;
		}
		
		@Override
		@RosettaAttribute("newSDRIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("newSDRIdentifier")
		public String getNewSDRIdentifier() {
			return newSDRIdentifier;
		}
		
		@Override
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("technicalRecordId")
		public String getTechnicalRecordId() {
			return technicalRecordId;
		}
		
		@Override
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceEntity")
		public String getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public SeniorityEnum getSeniority() {
			return seniority;
		}
		
		@Override
		@RosettaAttribute("series")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("series")
		public Integer getSeries() {
			return series;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("seriesVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seriesVersion")
		public Integer getSeriesVersion() {
			return seriesVersion;
		}
		
		@Override
		@RosettaAttribute("baseProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseProduct")
		public String getBaseProduct() {
			return baseProduct;
		}
		
		@Override
		@RosettaAttribute("subProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subProduct")
		public String getSubProduct() {
			return subProduct;
		}
		
		@Override
		@RosettaAttribute("furtherSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("furtherSubProduct")
		public String getFurtherSubProduct() {
			return furtherSubProduct;
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrier")
		public SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder getBarrier() {
			return barrier;
		}
		
		@Override
		public SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder getOrCreateBarrier() {
			SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder result;
			if (barrier!=null) {
				result = barrier;
			}
			else {
				result = barrier = SingleOrUpperAndLowerBarrier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		public String getInitialMarginCollateralPortfolioCode() {
			return initialMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		public String getVariationMarginCollateralPortfolioCode() {
			return variationMarginCollateralPortfolioCode;
		}
		
		@Override
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportable")
		public NonReportable.NonReportableBuilder getNonReportable() {
			return nonReportable;
		}
		
		@Override
		public NonReportable.NonReportableBuilder getOrCreateNonReportable() {
			NonReportable.NonReportableBuilder result;
			if (nonReportable!=null) {
				result = nonReportable;
			}
			else {
				result = nonReportable = NonReportable.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("postPricedSwapIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("postPricedSwapIndicator")
		public Boolean getPostPricedSwapIndicator() {
			return postPricedSwapIndicator;
		}
		
		@Override
		@RosettaAttribute("uniqueSwapIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueSwapIdentifier")
		public String getUniqueSwapIdentifier() {
			return uniqueSwapIdentifier;
		}
		
		@Override
		@RosettaAttribute("counterparty1FinancialEntityIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty1FinancialEntityIndicator")
		public Boolean getCounterparty1FinancialEntityIndicator() {
			return counterparty1FinancialEntityIndicator;
		}
		
		@Override
		@RosettaAttribute("counterparty2FinancialEntityIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty2FinancialEntityIndicator")
		public Boolean getCounterparty2FinancialEntityIndicator() {
			return counterparty2FinancialEntityIndicator;
		}
		
		@Override
		@RosettaAttribute("dtccAdditionalFields")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dtccAdditionalFields")
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder getDtccAdditionalFields() {
			return dtccAdditionalFields;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder getOrCreateDtccAdditionalFields() {
			DTCCAdditionalFields.DTCCAdditionalFieldsBuilder result;
			if (dtccAdditionalFields!=null) {
				result = dtccAdditionalFields;
			}
			else {
				result = dtccAdditionalFields = DTCCAdditionalFields.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setEffectiveDateOverriddenAsDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setEffectiveDate(Date _effectiveDate) {
			return setEffectiveDateOverriddenAsDate(_effectiveDate);
		}
		
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTerminationDate")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setEarlyTerminationDate(Date _earlyTerminationDate) {
			this.earlyTerminationDate = _earlyTerminationDate == null ? null : _earlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executionTimestamp")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setExecutionTimestampOverriddenAsZonedDateTime(ZonedDateTime _executionTimestamp) {
			this.executionTimestamp = _executionTimestamp == null ? null : _executionTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setExecutionTimestamp(ZonedDateTime _executionTimestamp) {
			return setExecutionTimestampOverriddenAsZonedDateTime(_executionTimestamp);
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setExpirationDate(Date _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCounterparty2OverriddenAsString(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCounterparty2(String _counterparty2) {
			return setCounterparty2OverriddenAsString(_counterparty2);
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("beneficiary1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setBeneficiary1(String _beneficiary1) {
			this.beneficiary1 = _beneficiary1 == null ? null : _beneficiary1;
			return this;
		}
		
		@RosettaAttribute("beneficiary1IdentifierTypeIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1IdentifierTypeIndicator")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setBeneficiary1IdentifierTypeIndicator(Boolean _beneficiary1IdentifierTypeIndicator) {
			this.beneficiary1IdentifierTypeIndicator = _beneficiary1IdentifierTypeIndicator == null ? null : _beneficiary1IdentifierTypeIndicator;
			return this;
		}
		
		@RosettaAttribute("buyerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerIdentifier")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setBuyerIdentifier(String _buyerIdentifier) {
			this.buyerIdentifier = _buyerIdentifier == null ? null : _buyerIdentifier;
			return this;
		}
		
		@RosettaAttribute("sellerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerIdentifier")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setSellerIdentifier(String _sellerIdentifier) {
			this.sellerIdentifier = _sellerIdentifier == null ? null : _sellerIdentifier;
			return this;
		}
		
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cleared")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setClearedOverriddenAsClearedEnum(ClearedEnum _cleared) {
			this.cleared = _cleared == null ? null : _cleared;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCleared(ClearedEnum _cleared) {
			return setClearedOverriddenAsClearedEnum(_cleared);
		}
		
		@RosettaAttribute("centralCounterparty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("centralCounterparty")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCentralCounterparty(String _centralCounterparty) {
			this.centralCounterparty = _centralCounterparty == null ? null : _centralCounterparty;
			return this;
		}
		
		@RosettaAttribute("clearingMember")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingMember")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setClearingMember(String _clearingMember) {
			this.clearingMember = _clearingMember == null ? null : _clearingMember;
			return this;
		}
		
		@RosettaAttribute("confirmed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmed")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setConfirmed(ConfirmationEnum _confirmed) {
			this.confirmed = _confirmed == null ? null : _confirmed;
			return this;
		}
		
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callAmount")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCallAmount(BigDecimal _callAmount) {
			this.callAmount = _callAmount == null ? null : _callAmount;
			return this;
		}
		
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putAmount")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPutAmount(BigDecimal _putAmount) {
			this.putAmount = _putAmount == null ? null : _putAmount;
			return this;
		}
		
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callCurrency")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCallCurrency(ISOCurrencyCodeEnum _callCurrency) {
			this.callCurrency = _callCurrency == null ? null : _callCurrency;
			return this;
		}
		
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putCurrency")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPutCurrency(ISOCurrencyCodeEnum _putCurrency) {
			this.putCurrency = _putCurrency == null ? null : _putCurrency;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("priceSchedule")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addPriceSchedule(PricePeriod _priceSchedule) {
			if (_priceSchedule != null) {
				this.priceSchedule.add(_priceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addPriceSchedule(PricePeriod _priceSchedule, int idx) {
			getIndex(this.priceSchedule, idx, () -> _priceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addPriceSchedule(List<? extends PricePeriod> priceSchedules) {
			if (priceSchedules != null) {
				for (final PricePeriod toAdd : priceSchedules) {
					this.priceSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("priceSchedule")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPriceSchedule(List<? extends PricePeriod> priceSchedules) {
			if (priceSchedules == null) {
				this.priceSchedule = new ArrayList<>();
			} else {
				this.priceSchedule = priceSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule) {
			if (_strikePriceSchedule != null) {
				this.strikePriceSchedule.add(_strikePriceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addStrikePriceSchedule(PricePeriod _strikePriceSchedule, int idx) {
			getIndex(this.strikePriceSchedule, idx, () -> _strikePriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
			if (strikePriceSchedules != null) {
				for (final PricePeriod toAdd : strikePriceSchedules) {
					this.strikePriceSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
			if (strikePriceSchedules == null) {
				this.strikePriceSchedule = new ArrayList<>();
			} else {
				this.strikePriceSchedule = strikePriceSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("price")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPrice(PriceFormat _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceNotation")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPriceNotation(PriceNotationEnum _priceNotation) {
			this.priceNotation = _priceNotation == null ? null : _priceNotation;
			return this;
		}
		
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceCurrency")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPriceCurrency(ISOCurrencyCodeEnum _priceCurrency) {
			this.priceCurrency = _priceCurrency == null ? null : _priceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPrice")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPackageTransactionPrice(PriceFormat _packageTransactionPrice) {
			this.packageTransactionPrice = _packageTransactionPrice == null ? null : _packageTransactionPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceNotation")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPackageTransactionPriceNotation(PriceNotationEnum _packageTransactionPriceNotation) {
			this.packageTransactionPriceNotation = _packageTransactionPriceNotation == null ? null : _packageTransactionPriceNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceCurrency")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum _packageTransactionPriceCurrency) {
			this.packageTransactionPriceCurrency = _packageTransactionPriceCurrency == null ? null : _packageTransactionPriceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpread")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPackageTransactionSpread(PriceFormat _packageTransactionSpread) {
			this.packageTransactionSpread = _packageTransactionSpread == null ? null : _packageTransactionSpread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadNotation")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPackageTransactionSpreadNotation(PriceNotationEnum _packageTransactionSpreadNotation) {
			this.packageTransactionSpreadNotation = _packageTransactionSpreadNotation == null ? null : _packageTransactionSpreadNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadCurrency")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum _packageTransactionSpreadCurrency) {
			this.packageTransactionSpreadCurrency = _packageTransactionSpreadCurrency == null ? null : _packageTransactionSpreadCurrency;
			return this;
		}
		
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIdentifier")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPackageIdentifier(String _packageIdentifier) {
			this.packageIdentifier = _packageIdentifier == null ? null : _packageIdentifier;
			return this;
		}
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePrice")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setStrikePrice(PriceFormat _strikePrice) {
			this.strikePrice = _strikePrice == null ? null : _strikePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceNotation")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setStrikePriceNotation(PriceNotationEnum _strikePriceNotation) {
			this.strikePriceNotation = _strikePriceNotation == null ? null : _strikePriceNotation;
			return this;
		}
		
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceCurrency")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setStrikePriceCurrency(String _strikePriceCurrency) {
			this.strikePriceCurrency = _strikePriceCurrency == null ? null : _strikePriceCurrency;
			return this;
		}
		
		@RosettaAttribute("priceUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceUnitOfMeasure")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPriceUnitOfMeasure(String _priceUnitOfMeasure) {
			this.priceUnitOfMeasure = _priceUnitOfMeasure == null ? null : _priceUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("optionPremiumAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumAmount")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setOptionPremiumAmount(BigDecimal _optionPremiumAmount) {
			this.optionPremiumAmount = _optionPremiumAmount == null ? null : _optionPremiumAmount;
			return this;
		}
		
		@RosettaAttribute("optionPremiumCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumCurrency")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setOptionPremiumCurrency(ISOCurrencyCodeEnum _optionPremiumCurrency) {
			this.optionPremiumCurrency = _optionPremiumCurrency == null ? null : _optionPremiumCurrency;
			return this;
		}
		
		@RosettaAttribute("optionPremiumPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumPaymentDate")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setOptionPremiumPaymentDate(Date _optionPremiumPaymentDate) {
			this.optionPremiumPaymentDate = _optionPremiumPaymentDate == null ? null : _optionPremiumPaymentDate;
			return this;
		}
		
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRate")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setExchangeRate(BigDecimal _exchangeRate) {
			this.exchangeRate = _exchangeRate == null ? null : _exchangeRate;
			return this;
		}
		
		@RosettaAttribute("exchangeRateBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRateBasis")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setExchangeRateBasis(String _exchangeRateBasis) {
			this.exchangeRateBasis = _exchangeRateBasis == null ? null : _exchangeRateBasis;
			return this;
		}
		
		@RosettaAttribute("cdSIndexAttachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexAttachmentPoint")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCdSIndexAttachmentPoint(BigDecimal _cdSIndexAttachmentPoint) {
			this.cdSIndexAttachmentPoint = _cdSIndexAttachmentPoint == null ? null : _cdSIndexAttachmentPoint;
			return this;
		}
		
		@RosettaAttribute("cdSIndexDetachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexDetachmentPoint")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCdSIndexDetachmentPoint(BigDecimal _cdSIndexDetachmentPoint) {
			this.cdSIndexDetachmentPoint = _cdSIndexDetachmentPoint == null ? null : _cdSIndexDetachmentPoint;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstExerciseDate")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setFirstExerciseDate(Date _firstExerciseDate) {
			this.firstExerciseDate = _firstExerciseDate == null ? null : _firstExerciseDate;
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setFinalContractualSettlementDate(Date _finalContractualSettlementDate) {
			this.finalContractualSettlementDate = _finalContractualSettlementDate == null ? null : _finalContractualSettlementDate;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setSettlementLocation(ISOCountryCodeEnum _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation;
			return this;
		}
		
		@RosettaAttribute("priorUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTI")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPriorUTI(String _priorUTI) {
			this.priorUTI = _priorUTI == null ? null : _priorUTI;
			return this;
		}
		
		@RosettaAttribute("direction1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction1")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setDirection1(Direction1Enum _direction1) {
			this.direction1 = _direction1 == null ? null : _direction1;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationAmount")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationCurrency")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationMethod")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationTimestamp")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketCode")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCustomBasketCode(String _customBasketCode) {
			this.customBasketCode = _customBasketCode == null ? null : _customBasketCode;
			return this;
		}
		
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketConstituents")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents) {
			if (_basketConstituents != null) {
				this.basketConstituents.add(_basketConstituents.toBuilder());
			}
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addBasketConstituents(BasketConstituentsReport _basketConstituents, int idx) {
			getIndex(this.basketConstituents, idx, () -> _basketConstituents.toBuilder());
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
			if (basketConstituentss != null) {
				for (final BasketConstituentsReport toAdd : basketConstituentss) {
					this.basketConstituents.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("basketConstituents")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
			if (basketConstituentss == null) {
				this.basketConstituents = new ArrayList<>();
			} else {
				this.basketConstituents = basketConstituentss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otherPayment")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addOtherPayment(OtherPayment _otherPayment) {
			if (_otherPayment != null) {
				this.otherPayment.add(_otherPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addOtherPayment(OtherPayment _otherPayment, int idx) {
			getIndex(this.otherPayment, idx, () -> _otherPayment.toBuilder());
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addOtherPayment(List<? extends OtherPayment> otherPayments) {
			if (otherPayments != null) {
				for (final OtherPayment toAdd : otherPayments) {
					this.otherPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("otherPayment")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setOtherPayment(List<? extends OtherPayment> otherPayments) {
			if (otherPayments == null) {
				this.otherPayment = new ArrayList<>();
			} else {
				this.otherPayment = otherPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg1")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setLeg1(SECLeg _leg1) {
			this.leg1 = _leg1 == null ? null : _leg1.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setLeg1(CommonLeg _leg1) {
			final SECLeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof SECLeg ? SECLeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setLeg1(Leg _leg1) {
			final SECLeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof SECLeg ? SECLeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setLeg1(LegV2 _leg1) {
			final SECLeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof SECLeg ? SECLeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setLeg1(LegV1 _leg1) {
			final SECLeg ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof SECLeg ? SECLeg.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaAttribute("leg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg2")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setLeg2(SECLeg _leg2) {
			this.leg2 = _leg2 == null ? null : _leg2.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setLeg2(CommonLeg _leg2) {
			final SECLeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof SECLeg ? SECLeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setLeg2(Leg _leg2) {
			final SECLeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof SECLeg ? SECLeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setLeg2(LegV2 _leg2) {
			final SECLeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof SECLeg ? SECLeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setLeg2(LegV1 _leg2) {
			final SECLeg ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof SECLeg ? SECLeg.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@RosettaAttribute("underlyingIdOther")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdOther")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setUnderlyingIdOther(String _underlyingIdOther) {
			this.underlyingIdOther = _underlyingIdOther == null ? null : _underlyingIdOther;
			return this;
		}
		
		@RosettaAttribute("underlyingIdOtherSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdOtherSource")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setUnderlyingIdOtherSource(AssetIdTypeEnum _underlyingIdOtherSource) {
			this.underlyingIdOtherSource = _underlyingIdOtherSource == null ? null : _underlyingIdOtherSource;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetTradingPlatformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetTradingPlatformIdentifier")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setUnderlyingAssetTradingPlatformIdentifier(String _underlyingAssetTradingPlatformIdentifier) {
			this.underlyingAssetTradingPlatformIdentifier = _underlyingAssetTradingPlatformIdentifier == null ? null : _underlyingAssetTradingPlatformIdentifier;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setUnderlyingAssetPriceSource(String _underlyingAssetPriceSource) {
			this.underlyingAssetPriceSource = _underlyingAssetPriceSource == null ? null : _underlyingAssetPriceSource;
			return this;
		}
		
		@RosettaAttribute("cryptoAssetUnderlyingIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cryptoAssetUnderlyingIndicator")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCryptoAssetUnderlyingIndicator(Boolean _cryptoAssetUnderlyingIndicator) {
			this.cryptoAssetUnderlyingIndicator = _cryptoAssetUnderlyingIndicator == null ? null : _cryptoAssetUnderlyingIndicator;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventType")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setEventType(EventTypeEnum _eventType) {
			this.eventType = _eventType == null ? null : _eventType;
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventIdentifier")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setEventIdentifier(String _eventIdentifier) {
			this.eventIdentifier = _eventIdentifier == null ? null : _eventIdentifier;
			return this;
		}
		
		@RosettaAttribute("eventTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventTimestamp")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setEventTimestampOverriddenAsZonedDateTime(ZonedDateTime _eventTimestamp) {
			this.eventTimestamp = _eventTimestamp == null ? null : _eventTimestamp;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setEventTimestamp(ZonedDateTime _eventTimestamp) {
			return setEventTimestampOverriddenAsZonedDateTime(_eventTimestamp);
		}
		
		@RosettaAttribute("confirmationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmationTimestamp")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setConfirmationTimestamp(ZonedDateTime _confirmationTimestamp) {
			this.confirmationTimestamp = _confirmationTimestamp == null ? null : _confirmationTimestamp;
			return this;
		}
		
		@RosettaAttribute("platformIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("platformIdentifier")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPlatformIdentifier(String _platformIdentifier) {
			this.platformIdentifier = _platformIdentifier == null ? null : _platformIdentifier;
			return this;
		}
		
		@RosettaAttribute("bookingLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bookingLocation")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setBookingLocation(ISOCountryCodeEnum _bookingLocation) {
			this.bookingLocation = _bookingLocation == null ? null : _bookingLocation;
			return this;
		}
		
		@RosettaAttribute("traderLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("traderLocation")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setTraderLocation(ISOCountryCodeEnum _traderLocation) {
			this.traderLocation = _traderLocation == null ? null : _traderLocation;
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setDeliveryType(DeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("executionAgentCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty1")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setExecutionAgentCounterparty1(String _executionAgentCounterparty1) {
			this.executionAgentCounterparty1 = _executionAgentCounterparty1 == null ? null : _executionAgentCounterparty1;
			return this;
		}
		
		@RosettaAttribute("executionAgentCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionAgentCounterparty2")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setExecutionAgentCounterparty2(String _executionAgentCounterparty2) {
			this.executionAgentCounterparty2 = _executionAgentCounterparty2 == null ? null : _executionAgentCounterparty2;
			return this;
		}
		
		@RosettaAttribute("natureOfCounterparty1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("natureOfCounterparty1")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setNatureOfCounterparty1(NatureOfCounterpartyEnum _natureOfCounterparty1) {
			this.natureOfCounterparty1 = _natureOfCounterparty1 == null ? null : _natureOfCounterparty1;
			return this;
		}
		
		@RosettaAttribute("natureOfCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("natureOfCounterparty2")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setNatureOfCounterparty2(NatureOfCounterpartyEnum _natureOfCounterparty2) {
			this.natureOfCounterparty2 = _natureOfCounterparty2 == null ? null : _natureOfCounterparty2;
			return this;
		}
		
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1) {
			if (_clearingExceptionsAndExemptionsCounterparty1 != null) {
				this.clearingExceptionsAndExemptionsCounterparty1.add(_clearingExceptionsAndExemptionsCounterparty1);
			}
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty1, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty1, idx, () -> _clearingExceptionsAndExemptionsCounterparty1);
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
			if (clearingExceptionsAndExemptionsCounterparty1s != null) {
				for (final ClearingExceptionsAndExemptionsEnum toAdd : clearingExceptionsAndExemptionsCounterparty1s) {
					this.clearingExceptionsAndExemptionsCounterparty1.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty1")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty1(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty1s) {
			if (clearingExceptionsAndExemptionsCounterparty1s == null) {
				this.clearingExceptionsAndExemptionsCounterparty1 = new ArrayList<>();
			} else {
				this.clearingExceptionsAndExemptionsCounterparty1 = clearingExceptionsAndExemptionsCounterparty1s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty2")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2) {
			if (_clearingExceptionsAndExemptionsCounterparty2 != null) {
				this.clearingExceptionsAndExemptionsCounterparty2.add(_clearingExceptionsAndExemptionsCounterparty2);
			}
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(ClearingExceptionsAndExemptionsEnum _clearingExceptionsAndExemptionsCounterparty2, int idx) {
			getIndex(this.clearingExceptionsAndExemptionsCounterparty2, idx, () -> _clearingExceptionsAndExemptionsCounterparty2);
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
			if (clearingExceptionsAndExemptionsCounterparty2s != null) {
				for (final ClearingExceptionsAndExemptionsEnum toAdd : clearingExceptionsAndExemptionsCounterparty2s) {
					this.clearingExceptionsAndExemptionsCounterparty2.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("clearingExceptionsAndExemptionsCounterparty2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("clearingExceptionsAndExemptionsCounterparty2")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setClearingExceptionsAndExemptionsCounterparty2(List<ClearingExceptionsAndExemptionsEnum> clearingExceptionsAndExemptionsCounterparty2s) {
			if (clearingExceptionsAndExemptionsCounterparty2s == null) {
				this.clearingExceptionsAndExemptionsCounterparty2 = new ArrayList<>();
			} else {
				this.clearingExceptionsAndExemptionsCounterparty2 = clearingExceptionsAndExemptionsCounterparty2s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("corporateSectorOfTheCounterparty1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("corporateSectorOfTheCounterparty1")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1) {
			if (_corporateSectorOfTheCounterparty1 != null) {
				this.corporateSectorOfTheCounterparty1.add(_corporateSectorOfTheCounterparty1);
			}
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addCorporateSectorOfTheCounterparty1(String _corporateSectorOfTheCounterparty1, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty1, idx, () -> _corporateSectorOfTheCounterparty1);
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
			if (corporateSectorOfTheCounterparty1s != null) {
				for (final String toAdd : corporateSectorOfTheCounterparty1s) {
					this.corporateSectorOfTheCounterparty1.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("corporateSectorOfTheCounterparty1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("corporateSectorOfTheCounterparty1")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCorporateSectorOfTheCounterparty1(List<String> corporateSectorOfTheCounterparty1s) {
			if (corporateSectorOfTheCounterparty1s == null) {
				this.corporateSectorOfTheCounterparty1 = new ArrayList<>();
			} else {
				this.corporateSectorOfTheCounterparty1 = corporateSectorOfTheCounterparty1s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("corporateSectorOfTheCounterparty2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("corporateSectorOfTheCounterparty2")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2) {
			if (_corporateSectorOfTheCounterparty2 != null) {
				this.corporateSectorOfTheCounterparty2.add(_corporateSectorOfTheCounterparty2);
			}
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addCorporateSectorOfTheCounterparty2(String _corporateSectorOfTheCounterparty2, int idx) {
			getIndex(this.corporateSectorOfTheCounterparty2, idx, () -> _corporateSectorOfTheCounterparty2);
			return this;
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder addCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
			if (corporateSectorOfTheCounterparty2s != null) {
				for (final String toAdd : corporateSectorOfTheCounterparty2s) {
					this.corporateSectorOfTheCounterparty2.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("corporateSectorOfTheCounterparty2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("corporateSectorOfTheCounterparty2")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCorporateSectorOfTheCounterparty2(List<String> corporateSectorOfTheCounterparty2s) {
			if (corporateSectorOfTheCounterparty2s == null) {
				this.corporateSectorOfTheCounterparty2 = new ArrayList<>();
			} else {
				this.corporateSectorOfTheCounterparty2 = corporateSectorOfTheCounterparty2s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("counterparty2Name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2Name")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCounterparty2Name(String _counterparty2Name) {
			this.counterparty2Name = _counterparty2Name == null ? null : _counterparty2Name;
			return this;
		}
		
		@RosettaAttribute("reportSubmittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportSubmittingEntityID")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setReportSubmittingEntityID(String _reportSubmittingEntityID) {
			this.reportSubmittingEntityID = _reportSubmittingEntityID == null ? null : _reportSubmittingEntityID;
			return this;
		}
		
		@RosettaAttribute("entityResponsibleForReporting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityResponsibleForReporting")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setEntityResponsibleForReporting(String _entityResponsibleForReporting) {
			this.entityResponsibleForReporting = _entityResponsibleForReporting == null ? null : _entityResponsibleForReporting;
			return this;
		}
		
		@RosettaAttribute("countryOfTheCounterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("countryOfTheCounterparty2")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCountryOfTheCounterparty2(ISOCountryCodeEnum _countryOfTheCounterparty2) {
			this.countryOfTheCounterparty2 = _countryOfTheCounterparty2 == null ? null : _countryOfTheCounterparty2;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2IdentifierSource")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(Counterparty2IdentifierEnum _counterparty2IdentifierSource) {
			this.counterparty2IdentifierSource = _counterparty2IdentifierSource == null ? null : _counterparty2IdentifierSource;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCounterparty2IdentifierSource(Counterparty2IdentifierEnum _counterparty2IdentifierSource) {
			return setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(_counterparty2IdentifierSource);
		}
		
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradingCapacity")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setTradingCapacity(TradingCapacity7Code _tradingCapacity) {
			this.tradingCapacity = _tradingCapacity == null ? null : _tradingCapacity;
			return this;
		}
		
		@RosettaAttribute("brokerID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerID")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setBrokerID(String _brokerID) {
			this.brokerID = _brokerID == null ? null : _brokerID;
			return this;
		}
		
		@RosettaAttribute("contractType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractType")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setContractType(CommonContractType _contractType) {
			this.contractType = _contractType == null ? null : _contractType;
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("assetClass")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setAssetClass(CommonAssetClass _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setOptionType(OptionTypeCode _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionStyle")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setOptionStyle(OptionStyleEnum _optionStyle) {
			this.optionStyle = _optionStyle == null ? null : _optionStyle;
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("embeddedOptionType")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setEmbeddedOptionType(EmbeddedOptionTypeEnum _embeddedOptionType) {
			this.embeddedOptionType = _embeddedOptionType == null ? null : _embeddedOptionType;
			return this;
		}
		
		@RosettaAttribute("masterAgreementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementType")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setMasterAgreementType(MasterAgreementEnum _masterAgreementType) {
			this.masterAgreementType = _masterAgreementType == null ? null : _masterAgreementType;
			return this;
		}
		
		@RosettaAttribute("masterAgreementVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementVersion")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setMasterAgreementVersion(Integer _masterAgreementVersion) {
			this.masterAgreementVersion = _masterAgreementVersion == null ? null : _masterAgreementVersion;
			return this;
		}
		
		@RosettaAttribute("secondaryTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secondaryTransactionIdentifier")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setSecondaryTransactionIdentifier(String _secondaryTransactionIdentifier) {
			this.secondaryTransactionIdentifier = _secondaryTransactionIdentifier == null ? null : _secondaryTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("intragroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intragroup")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setIntragroup(Boolean _intragroup) {
			this.intragroup = _intragroup == null ? null : _intragroup;
			return this;
		}
		
		@RosettaAttribute("nonStandardizedTermIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonStandardizedTermIndicator")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setNonStandardizedTermIndicator(Boolean _nonStandardizedTermIndicator) {
			this.nonStandardizedTermIndicator = _nonStandardizedTermIndicator == null ? null : _nonStandardizedTermIndicator;
			return this;
		}
		
		@RosettaAttribute("amendmentIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendmentIndicator")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setAmendmentIndicator(Boolean _amendmentIndicator) {
			this.amendmentIndicator = _amendmentIndicator == null ? null : _amendmentIndicator;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentification")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setUnderlyingIdentification(String _underlyingIdentification) {
			this.underlyingIdentification = _underlyingIdentification == null ? null : _underlyingIdentification;
			return this;
		}
		
		@RosettaAttribute("underlyingIdentificationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIdentificationType")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setUnderlyingIdentificationType(UnderlyingIdentificationTypeEnum _underlyingIdentificationType) {
			this.underlyingIdentificationType = _underlyingIdentificationType == null ? null : _underlyingIdentificationType;
			return this;
		}
		
		@RosettaAttribute("nameOfTheUnderlyingIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nameOfTheUnderlyingIndex")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setNameOfTheUnderlyingIndex(String _nameOfTheUnderlyingIndex) {
			this.nameOfTheUnderlyingIndex = _nameOfTheUnderlyingIndex == null ? null : _nameOfTheUnderlyingIndex;
			return this;
		}
		
		@RosettaAttribute("maturityDateOfTheUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDateOfTheUnderlying")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setMaturityDateOfTheUnderlying(Date _maturityDateOfTheUnderlying) {
			this.maturityDateOfTheUnderlying = _maturityDateOfTheUnderlying == null ? null : _maturityDateOfTheUnderlying;
			return this;
		}
		
		@RosettaAttribute("swapLinkID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("swapLinkID")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setSwapLinkID(String _swapLinkID) {
			this.swapLinkID = _swapLinkID == null ? null : _swapLinkID;
			return this;
		}
		
		@RosettaAttribute("packageIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("packageIndicator")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPackageIndicatorOverriddenAsBoolean(Boolean _packageIndicator) {
			this.packageIndicator = _packageIndicator == null ? null : _packageIndicator;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPackageIndicator(Boolean _packageIndicator) {
			return setPackageIndicatorOverriddenAsBoolean(_packageIndicator);
		}
		
		@RosettaAttribute("customBasketIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("customBasketIndicator")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCustomBasketIndicatorOverriddenAsBoolean(Boolean _customBasketIndicator) {
			this.customBasketIndicator = _customBasketIndicator == null ? null : _customBasketIndicator;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCustomBasketIndicator(Boolean _customBasketIndicator) {
			return setCustomBasketIndicatorOverriddenAsBoolean(_customBasketIndicator);
		}
		
		@RosettaAttribute("priorUTIProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTIProprietary")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPriorUTIProprietary(String _priorUTIProprietary) {
			this.priorUTIProprietary = _priorUTIProprietary == null ? null : _priorUTIProprietary;
			return this;
		}
		
		@RosettaAttribute("clearingTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingTimestamp")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setClearingTimestamp(ZonedDateTime _clearingTimestamp) {
			this.clearingTimestamp = _clearingTimestamp == null ? null : _clearingTimestamp;
			return this;
		}
		
		@RosettaAttribute("clearingAccountOrigin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingAccountOrigin")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setClearingAccountOrigin(ClearingAccountOriginEnum _clearingAccountOrigin) {
			this.clearingAccountOrigin = _clearingAccountOrigin == null ? null : _clearingAccountOrigin;
			return this;
		}
		
		@RosettaAttribute("clearingReceiptTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingReceiptTimestamp")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setClearingReceiptTimestamp(ZonedDateTime _clearingReceiptTimestamp) {
			this.clearingReceiptTimestamp = _clearingReceiptTimestamp == null ? null : _clearingReceiptTimestamp;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setUniqueTransactionIdentifier(String _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier;
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifierProprietary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifierProprietary")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setUniqueTransactionIdentifierProprietary(String _uniqueTransactionIdentifierProprietary) {
			this.uniqueTransactionIdentifierProprietary = _uniqueTransactionIdentifierProprietary == null ? null : _uniqueTransactionIdentifierProprietary;
			return this;
		}
		
		@RosettaAttribute("uniqueProductIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueProductIdentifier")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setUniqueProductIdentifier(String _uniqueProductIdentifier) {
			this.uniqueProductIdentifier = _uniqueProductIdentifier == null ? null : _uniqueProductIdentifier;
			return this;
		}
		
		@RosettaAttribute("originalSwapUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapUTI")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setOriginalSwapUTI(String _originalSwapUTI) {
			this.originalSwapUTI = _originalSwapUTI == null ? null : _originalSwapUTI;
			return this;
		}
		
		@RosettaAttribute("subsequentPositionUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subsequentPositionUTI")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setSubsequentPositionUTI(String _subsequentPositionUTI) {
			this.subsequentPositionUTI = _subsequentPositionUTI == null ? null : _subsequentPositionUTI;
			return this;
		}
		
		@RosettaAttribute("originalSwapSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapSDRIdentifier")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setOriginalSwapSDRIdentifier(String _originalSwapSDRIdentifier) {
			this.originalSwapSDRIdentifier = _originalSwapSDRIdentifier == null ? null : _originalSwapSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("priorUSI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUSI")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPriorUSI(String _priorUSI) {
			this.priorUSI = _priorUSI == null ? null : _priorUSI;
			return this;
		}
		
		@RosettaAttribute("newSDRIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("newSDRIdentifier")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setNewSDRIdentifier(String _newSDRIdentifier) {
			this.newSDRIdentifier = _newSDRIdentifier == null ? null : _newSDRIdentifier;
			return this;
		}
		
		@RosettaAttribute("technicalRecordId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("technicalRecordId")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setTechnicalRecordId(String _technicalRecordId) {
			this.technicalRecordId = _technicalRecordId == null ? null : _technicalRecordId;
			return this;
		}
		
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceEntity")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setReferenceEntity(String _referenceEntity) {
			this.referenceEntity = _referenceEntity == null ? null : _referenceEntity;
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setSeniority(SeniorityEnum _seniority) {
			this.seniority = _seniority == null ? null : _seniority;
			return this;
		}
		
		@RosettaAttribute("series")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("series")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setSeries(Integer _series) {
			this.series = _series == null ? null : _series;
			return this;
		}
		
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexFactor")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setIndexFactor(BigDecimal _indexFactor) {
			this.indexFactor = _indexFactor == null ? null : _indexFactor;
			return this;
		}
		
		@RosettaAttribute("seriesVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seriesVersion")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setSeriesVersion(Integer _seriesVersion) {
			this.seriesVersion = _seriesVersion == null ? null : _seriesVersion;
			return this;
		}
		
		@RosettaAttribute("baseProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseProduct")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setBaseProduct(String _baseProduct) {
			this.baseProduct = _baseProduct == null ? null : _baseProduct;
			return this;
		}
		
		@RosettaAttribute("subProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subProduct")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setSubProduct(String _subProduct) {
			this.subProduct = _subProduct == null ? null : _subProduct;
			return this;
		}
		
		@RosettaAttribute("furtherSubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("furtherSubProduct")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setFurtherSubProduct(String _furtherSubProduct) {
			this.furtherSubProduct = _furtherSubProduct == null ? null : _furtherSubProduct;
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrier")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setBarrier(SingleOrUpperAndLowerBarrier _barrier) {
			this.barrier = _barrier == null ? null : _barrier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMarginCollateralPortfolioCode")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setInitialMarginCollateralPortfolioCode(String _initialMarginCollateralPortfolioCode) {
			this.initialMarginCollateralPortfolioCode = _initialMarginCollateralPortfolioCode == null ? null : _initialMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("variationMarginCollateralPortfolioCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("variationMarginCollateralPortfolioCode")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setVariationMarginCollateralPortfolioCode(String _variationMarginCollateralPortfolioCode) {
			this.variationMarginCollateralPortfolioCode = _variationMarginCollateralPortfolioCode == null ? null : _variationMarginCollateralPortfolioCode;
			return this;
		}
		
		@RosettaAttribute("nonReportable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReportable")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setNonReportable(NonReportable _nonReportable) {
			this.nonReportable = _nonReportable == null ? null : _nonReportable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("postPricedSwapIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("postPricedSwapIndicator")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setPostPricedSwapIndicator(Boolean _postPricedSwapIndicator) {
			this.postPricedSwapIndicator = _postPricedSwapIndicator == null ? null : _postPricedSwapIndicator;
			return this;
		}
		
		@RosettaAttribute("uniqueSwapIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueSwapIdentifier")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setUniqueSwapIdentifier(String _uniqueSwapIdentifier) {
			this.uniqueSwapIdentifier = _uniqueSwapIdentifier == null ? null : _uniqueSwapIdentifier;
			return this;
		}
		
		@RosettaAttribute("counterparty1FinancialEntityIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty1FinancialEntityIndicator")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCounterparty1FinancialEntityIndicator(Boolean _counterparty1FinancialEntityIndicator) {
			this.counterparty1FinancialEntityIndicator = _counterparty1FinancialEntityIndicator == null ? null : _counterparty1FinancialEntityIndicator;
			return this;
		}
		
		@RosettaAttribute("counterparty2FinancialEntityIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2FinancialEntityIndicator")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setCounterparty2FinancialEntityIndicator(Boolean _counterparty2FinancialEntityIndicator) {
			this.counterparty2FinancialEntityIndicator = _counterparty2FinancialEntityIndicator == null ? null : _counterparty2FinancialEntityIndicator;
			return this;
		}
		
		@RosettaAttribute("dtccAdditionalFields")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dtccAdditionalFields")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder setDtccAdditionalFields(DTCCAdditionalFields _dtccAdditionalFields) {
			this.dtccAdditionalFields = _dtccAdditionalFields == null ? null : _dtccAdditionalFields.toBuilder();
			return this;
		}
		
		@Override
		public SECTransactionReport build() {
			return new SECTransactionReport.SECTransactionReportImpl(this);
		}
		
		@Override
		public SECTransactionReport.SECTransactionReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder prune() {
			priceSchedule = priceSchedule.stream().filter(b->b!=null).<PricePeriod.PricePeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			strikePriceSchedule = strikePriceSchedule.stream().filter(b->b!=null).<PricePeriod.PricePeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (price!=null && !price.prune().hasData()) price = null;
			if (packageTransactionPrice!=null && !packageTransactionPrice.prune().hasData()) packageTransactionPrice = null;
			if (packageTransactionSpread!=null && !packageTransactionSpread.prune().hasData()) packageTransactionSpread = null;
			if (strikePrice!=null && !strikePrice.prune().hasData()) strikePrice = null;
			basketConstituents = basketConstituents.stream().filter(b->b!=null).<BasketConstituentsReport.BasketConstituentsReportBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			otherPayment = otherPayment.stream().filter(b->b!=null).<OtherPayment.OtherPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (leg1!=null && !leg1.prune().hasData()) leg1 = null;
			if (leg2!=null && !leg2.prune().hasData()) leg2 = null;
			if (barrier!=null && !barrier.prune().hasData()) barrier = null;
			if (nonReportable!=null && !nonReportable.prune().hasData()) nonReportable = null;
			if (dtccAdditionalFields!=null && !dtccAdditionalFields.prune().hasData()) dtccAdditionalFields = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null) return true;
			if (getEarlyTerminationDate()!=null) return true;
			if (getReportingTimestamp()!=null) return true;
			if (getExecutionTimestamp()!=null) return true;
			if (getExpirationDate()!=null) return true;
			if (getCounterparty1()!=null) return true;
			if (getCounterparty2()!=null) return true;
			if (getCounterparty2IdentifierType()!=null) return true;
			if (getBeneficiary1()!=null) return true;
			if (getBeneficiary1IdentifierTypeIndicator()!=null) return true;
			if (getBuyerIdentifier()!=null) return true;
			if (getSellerIdentifier()!=null) return true;
			if (getCleared()!=null) return true;
			if (getCentralCounterparty()!=null) return true;
			if (getClearingMember()!=null) return true;
			if (getConfirmed()!=null) return true;
			if (getCallAmount()!=null) return true;
			if (getPutAmount()!=null) return true;
			if (getCallCurrency()!=null) return true;
			if (getPutCurrency()!=null) return true;
			if (getDelta()!=null) return true;
			if (getPriceSchedule()!=null && getPriceSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getStrikePriceSchedule()!=null && getStrikePriceSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPrice()!=null && getPrice().hasData()) return true;
			if (getPriceNotation()!=null) return true;
			if (getPriceCurrency()!=null) return true;
			if (getPackageTransactionPrice()!=null && getPackageTransactionPrice().hasData()) return true;
			if (getPackageTransactionPriceNotation()!=null) return true;
			if (getPackageTransactionPriceCurrency()!=null) return true;
			if (getPackageTransactionSpread()!=null && getPackageTransactionSpread().hasData()) return true;
			if (getPackageTransactionSpreadNotation()!=null) return true;
			if (getPackageTransactionSpreadCurrency()!=null) return true;
			if (getPackageIdentifier()!=null) return true;
			if (getStrikePrice()!=null && getStrikePrice().hasData()) return true;
			if (getStrikePriceNotation()!=null) return true;
			if (getStrikePriceCurrency()!=null) return true;
			if (getPriceUnitOfMeasure()!=null) return true;
			if (getOptionPremiumAmount()!=null) return true;
			if (getOptionPremiumCurrency()!=null) return true;
			if (getOptionPremiumPaymentDate()!=null) return true;
			if (getExchangeRate()!=null) return true;
			if (getExchangeRateBasis()!=null) return true;
			if (getCdSIndexAttachmentPoint()!=null) return true;
			if (getCdSIndexDetachmentPoint()!=null) return true;
			if (getCollateralPortfolioIndicator()!=null) return true;
			if (getFirstExerciseDate()!=null) return true;
			if (getFinalContractualSettlementDate()!=null) return true;
			if (getSettlementLocation()!=null) return true;
			if (getPriorUTI()!=null) return true;
			if (getDirection1()!=null) return true;
			if (getValuationAmount()!=null) return true;
			if (getValuationCurrency()!=null) return true;
			if (getValuationMethod()!=null) return true;
			if (getValuationTimestamp()!=null) return true;
			if (getCustomBasketCode()!=null) return true;
			if (getBasketConstituents()!=null && getBasketConstituents().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOtherPayment()!=null && getOtherPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLeg1()!=null && getLeg1().hasData()) return true;
			if (getLeg2()!=null && getLeg2().hasData()) return true;
			if (getUnderlyingIdOther()!=null) return true;
			if (getUnderlyingIdOtherSource()!=null) return true;
			if (getUnderlyingAssetTradingPlatformIdentifier()!=null) return true;
			if (getUnderlyingAssetPriceSource()!=null) return true;
			if (getCryptoAssetUnderlyingIndicator()!=null) return true;
			if (getLevel()!=null) return true;
			if (getActionType()!=null) return true;
			if (getEventType()!=null) return true;
			if (getEventIdentifier()!=null) return true;
			if (getEventTimestamp()!=null) return true;
			if (getConfirmationTimestamp()!=null) return true;
			if (getPlatformIdentifier()!=null) return true;
			if (getBookingLocation()!=null) return true;
			if (getTraderLocation()!=null) return true;
			if (getDeliveryType()!=null) return true;
			if (getExecutionAgentCounterparty1()!=null) return true;
			if (getExecutionAgentCounterparty2()!=null) return true;
			if (getNatureOfCounterparty1()!=null) return true;
			if (getNatureOfCounterparty2()!=null) return true;
			if (getClearingExceptionsAndExemptionsCounterparty1()!=null && !getClearingExceptionsAndExemptionsCounterparty1().isEmpty()) return true;
			if (getClearingExceptionsAndExemptionsCounterparty2()!=null && !getClearingExceptionsAndExemptionsCounterparty2().isEmpty()) return true;
			if (getCorporateSectorOfTheCounterparty1()!=null && !getCorporateSectorOfTheCounterparty1().isEmpty()) return true;
			if (getCorporateSectorOfTheCounterparty2()!=null && !getCorporateSectorOfTheCounterparty2().isEmpty()) return true;
			if (getCounterparty2Name()!=null) return true;
			if (getReportSubmittingEntityID()!=null) return true;
			if (getEntityResponsibleForReporting()!=null) return true;
			if (getCountryOfTheCounterparty2()!=null) return true;
			if (getCounterparty2IdentifierSource()!=null) return true;
			if (getTradingCapacity()!=null) return true;
			if (getBrokerID()!=null) return true;
			if (getContractType()!=null) return true;
			if (getAssetClass()!=null) return true;
			if (getOptionType()!=null) return true;
			if (getOptionStyle()!=null) return true;
			if (getEmbeddedOptionType()!=null) return true;
			if (getMasterAgreementType()!=null) return true;
			if (getMasterAgreementVersion()!=null) return true;
			if (getSecondaryTransactionIdentifier()!=null) return true;
			if (getIntragroup()!=null) return true;
			if (getNonStandardizedTermIndicator()!=null) return true;
			if (getAmendmentIndicator()!=null) return true;
			if (getUnderlyingIdentification()!=null) return true;
			if (getUnderlyingIdentificationType()!=null) return true;
			if (getNameOfTheUnderlyingIndex()!=null) return true;
			if (getMaturityDateOfTheUnderlying()!=null) return true;
			if (getSwapLinkID()!=null) return true;
			if (getPackageIndicator()!=null) return true;
			if (getCustomBasketIndicator()!=null) return true;
			if (getPriorUTIProprietary()!=null) return true;
			if (getClearingTimestamp()!=null) return true;
			if (getClearingAccountOrigin()!=null) return true;
			if (getClearingReceiptTimestamp()!=null) return true;
			if (getUniqueTransactionIdentifier()!=null) return true;
			if (getUniqueTransactionIdentifierProprietary()!=null) return true;
			if (getUniqueProductIdentifier()!=null) return true;
			if (getOriginalSwapUTI()!=null) return true;
			if (getSubsequentPositionUTI()!=null) return true;
			if (getOriginalSwapSDRIdentifier()!=null) return true;
			if (getPriorUSI()!=null) return true;
			if (getNewSDRIdentifier()!=null) return true;
			if (getTechnicalRecordId()!=null) return true;
			if (getReferenceEntity()!=null) return true;
			if (getSeniority()!=null) return true;
			if (getSeries()!=null) return true;
			if (getIndexFactor()!=null) return true;
			if (getSeriesVersion()!=null) return true;
			if (getBaseProduct()!=null) return true;
			if (getSubProduct()!=null) return true;
			if (getFurtherSubProduct()!=null) return true;
			if (getBarrier()!=null && getBarrier().hasData()) return true;
			if (getInitialMarginCollateralPortfolioCode()!=null) return true;
			if (getVariationMarginCollateralPortfolioCode()!=null) return true;
			if (getNonReportable()!=null && getNonReportable().hasData()) return true;
			if (getPostPricedSwapIndicator()!=null) return true;
			if (getUniqueSwapIdentifier()!=null) return true;
			if (getCounterparty1FinancialEntityIndicator()!=null) return true;
			if (getCounterparty2FinancialEntityIndicator()!=null) return true;
			if (getDtccAdditionalFields()!=null && getDtccAdditionalFields().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SECTransactionReport.SECTransactionReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SECTransactionReport.SECTransactionReportBuilder o = (SECTransactionReport.SECTransactionReportBuilder) other;
			
			merger.mergeRosetta(getPriceSchedule(), o.getPriceSchedule(), this::getOrCreatePriceSchedule);
			merger.mergeRosetta(getStrikePriceSchedule(), o.getStrikePriceSchedule(), this::getOrCreateStrikePriceSchedule);
			merger.mergeRosetta(getPrice(), o.getPrice(), this::setPrice);
			merger.mergeRosetta(getPackageTransactionPrice(), o.getPackageTransactionPrice(), this::setPackageTransactionPrice);
			merger.mergeRosetta(getPackageTransactionSpread(), o.getPackageTransactionSpread(), this::setPackageTransactionSpread);
			merger.mergeRosetta(getStrikePrice(), o.getStrikePrice(), this::setStrikePrice);
			merger.mergeRosetta(getBasketConstituents(), o.getBasketConstituents(), this::getOrCreateBasketConstituents);
			merger.mergeRosetta(getOtherPayment(), o.getOtherPayment(), this::getOrCreateOtherPayment);
			merger.mergeRosetta(getLeg1(), o.getLeg1(), this::setLeg1);
			merger.mergeRosetta(getLeg2(), o.getLeg2(), this::setLeg2);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::setBarrier);
			merger.mergeRosetta(getNonReportable(), o.getNonReportable(), this::setNonReportable);
			merger.mergeRosetta(getDtccAdditionalFields(), o.getDtccAdditionalFields(), this::setDtccAdditionalFields);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDateOverriddenAsDate);
			merger.mergeBasic(getEarlyTerminationDate(), o.getEarlyTerminationDate(), this::setEarlyTerminationDate);
			merger.mergeBasic(getReportingTimestamp(), o.getReportingTimestamp(), this::setReportingTimestamp);
			merger.mergeBasic(getExecutionTimestamp(), o.getExecutionTimestamp(), this::setExecutionTimestampOverriddenAsZonedDateTime);
			merger.mergeBasic(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeBasic(getCounterparty1(), o.getCounterparty1(), this::setCounterparty1);
			merger.mergeBasic(getCounterparty2(), o.getCounterparty2(), this::setCounterparty2OverriddenAsString);
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierType);
			merger.mergeBasic(getBeneficiary1(), o.getBeneficiary1(), this::setBeneficiary1);
			merger.mergeBasic(getBeneficiary1IdentifierTypeIndicator(), o.getBeneficiary1IdentifierTypeIndicator(), this::setBeneficiary1IdentifierTypeIndicator);
			merger.mergeBasic(getBuyerIdentifier(), o.getBuyerIdentifier(), this::setBuyerIdentifier);
			merger.mergeBasic(getSellerIdentifier(), o.getSellerIdentifier(), this::setSellerIdentifier);
			merger.mergeBasic(getCleared(), o.getCleared(), this::setClearedOverriddenAsClearedEnum);
			merger.mergeBasic(getCentralCounterparty(), o.getCentralCounterparty(), this::setCentralCounterparty);
			merger.mergeBasic(getClearingMember(), o.getClearingMember(), this::setClearingMember);
			merger.mergeBasic(getConfirmed(), o.getConfirmed(), this::setConfirmed);
			merger.mergeBasic(getCallAmount(), o.getCallAmount(), this::setCallAmount);
			merger.mergeBasic(getPutAmount(), o.getPutAmount(), this::setPutAmount);
			merger.mergeBasic(getCallCurrency(), o.getCallCurrency(), this::setCallCurrency);
			merger.mergeBasic(getPutCurrency(), o.getPutCurrency(), this::setPutCurrency);
			merger.mergeBasic(getDelta(), o.getDelta(), this::setDelta);
			merger.mergeBasic(getPriceNotation(), o.getPriceNotation(), this::setPriceNotation);
			merger.mergeBasic(getPriceCurrency(), o.getPriceCurrency(), this::setPriceCurrency);
			merger.mergeBasic(getPackageTransactionPriceNotation(), o.getPackageTransactionPriceNotation(), this::setPackageTransactionPriceNotation);
			merger.mergeBasic(getPackageTransactionPriceCurrency(), o.getPackageTransactionPriceCurrency(), this::setPackageTransactionPriceCurrency);
			merger.mergeBasic(getPackageTransactionSpreadNotation(), o.getPackageTransactionSpreadNotation(), this::setPackageTransactionSpreadNotation);
			merger.mergeBasic(getPackageTransactionSpreadCurrency(), o.getPackageTransactionSpreadCurrency(), this::setPackageTransactionSpreadCurrency);
			merger.mergeBasic(getPackageIdentifier(), o.getPackageIdentifier(), this::setPackageIdentifier);
			merger.mergeBasic(getStrikePriceNotation(), o.getStrikePriceNotation(), this::setStrikePriceNotation);
			merger.mergeBasic(getStrikePriceCurrency(), o.getStrikePriceCurrency(), this::setStrikePriceCurrency);
			merger.mergeBasic(getPriceUnitOfMeasure(), o.getPriceUnitOfMeasure(), this::setPriceUnitOfMeasure);
			merger.mergeBasic(getOptionPremiumAmount(), o.getOptionPremiumAmount(), this::setOptionPremiumAmount);
			merger.mergeBasic(getOptionPremiumCurrency(), o.getOptionPremiumCurrency(), this::setOptionPremiumCurrency);
			merger.mergeBasic(getOptionPremiumPaymentDate(), o.getOptionPremiumPaymentDate(), this::setOptionPremiumPaymentDate);
			merger.mergeBasic(getExchangeRate(), o.getExchangeRate(), this::setExchangeRate);
			merger.mergeBasic(getExchangeRateBasis(), o.getExchangeRateBasis(), this::setExchangeRateBasis);
			merger.mergeBasic(getCdSIndexAttachmentPoint(), o.getCdSIndexAttachmentPoint(), this::setCdSIndexAttachmentPoint);
			merger.mergeBasic(getCdSIndexDetachmentPoint(), o.getCdSIndexDetachmentPoint(), this::setCdSIndexDetachmentPoint);
			merger.mergeBasic(getCollateralPortfolioIndicator(), o.getCollateralPortfolioIndicator(), this::setCollateralPortfolioIndicator);
			merger.mergeBasic(getFirstExerciseDate(), o.getFirstExerciseDate(), this::setFirstExerciseDate);
			merger.mergeBasic(getFinalContractualSettlementDate(), o.getFinalContractualSettlementDate(), this::setFinalContractualSettlementDate);
			merger.mergeBasic(getSettlementLocation(), o.getSettlementLocation(), this::setSettlementLocation);
			merger.mergeBasic(getPriorUTI(), o.getPriorUTI(), this::setPriorUTI);
			merger.mergeBasic(getDirection1(), o.getDirection1(), this::setDirection1);
			merger.mergeBasic(getValuationAmount(), o.getValuationAmount(), this::setValuationAmount);
			merger.mergeBasic(getValuationCurrency(), o.getValuationCurrency(), this::setValuationCurrency);
			merger.mergeBasic(getValuationMethod(), o.getValuationMethod(), this::setValuationMethod);
			merger.mergeBasic(getValuationTimestamp(), o.getValuationTimestamp(), this::setValuationTimestamp);
			merger.mergeBasic(getCustomBasketCode(), o.getCustomBasketCode(), this::setCustomBasketCode);
			merger.mergeBasic(getUnderlyingIdOther(), o.getUnderlyingIdOther(), this::setUnderlyingIdOther);
			merger.mergeBasic(getUnderlyingIdOtherSource(), o.getUnderlyingIdOtherSource(), this::setUnderlyingIdOtherSource);
			merger.mergeBasic(getUnderlyingAssetTradingPlatformIdentifier(), o.getUnderlyingAssetTradingPlatformIdentifier(), this::setUnderlyingAssetTradingPlatformIdentifier);
			merger.mergeBasic(getUnderlyingAssetPriceSource(), o.getUnderlyingAssetPriceSource(), this::setUnderlyingAssetPriceSource);
			merger.mergeBasic(getCryptoAssetUnderlyingIndicator(), o.getCryptoAssetUnderlyingIndicator(), this::setCryptoAssetUnderlyingIndicator);
			merger.mergeBasic(getLevel(), o.getLevel(), this::setLevel);
			merger.mergeBasic(getActionType(), o.getActionType(), this::setActionType);
			merger.mergeBasic(getEventType(), o.getEventType(), this::setEventType);
			merger.mergeBasic(getEventIdentifier(), o.getEventIdentifier(), this::setEventIdentifier);
			merger.mergeBasic(getEventTimestamp(), o.getEventTimestamp(), this::setEventTimestampOverriddenAsZonedDateTime);
			merger.mergeBasic(getConfirmationTimestamp(), o.getConfirmationTimestamp(), this::setConfirmationTimestamp);
			merger.mergeBasic(getPlatformIdentifier(), o.getPlatformIdentifier(), this::setPlatformIdentifier);
			merger.mergeBasic(getBookingLocation(), o.getBookingLocation(), this::setBookingLocation);
			merger.mergeBasic(getTraderLocation(), o.getTraderLocation(), this::setTraderLocation);
			merger.mergeBasic(getDeliveryType(), o.getDeliveryType(), this::setDeliveryType);
			merger.mergeBasic(getExecutionAgentCounterparty1(), o.getExecutionAgentCounterparty1(), this::setExecutionAgentCounterparty1);
			merger.mergeBasic(getExecutionAgentCounterparty2(), o.getExecutionAgentCounterparty2(), this::setExecutionAgentCounterparty2);
			merger.mergeBasic(getNatureOfCounterparty1(), o.getNatureOfCounterparty1(), this::setNatureOfCounterparty1);
			merger.mergeBasic(getNatureOfCounterparty2(), o.getNatureOfCounterparty2(), this::setNatureOfCounterparty2);
			merger.mergeBasic(getClearingExceptionsAndExemptionsCounterparty1(), o.getClearingExceptionsAndExemptionsCounterparty1(), (Consumer<ClearingExceptionsAndExemptionsEnum>) this::addClearingExceptionsAndExemptionsCounterparty1);
			merger.mergeBasic(getClearingExceptionsAndExemptionsCounterparty2(), o.getClearingExceptionsAndExemptionsCounterparty2(), (Consumer<ClearingExceptionsAndExemptionsEnum>) this::addClearingExceptionsAndExemptionsCounterparty2);
			merger.mergeBasic(getCorporateSectorOfTheCounterparty1(), o.getCorporateSectorOfTheCounterparty1(), (Consumer<String>) this::addCorporateSectorOfTheCounterparty1);
			merger.mergeBasic(getCorporateSectorOfTheCounterparty2(), o.getCorporateSectorOfTheCounterparty2(), (Consumer<String>) this::addCorporateSectorOfTheCounterparty2);
			merger.mergeBasic(getCounterparty2Name(), o.getCounterparty2Name(), this::setCounterparty2Name);
			merger.mergeBasic(getReportSubmittingEntityID(), o.getReportSubmittingEntityID(), this::setReportSubmittingEntityID);
			merger.mergeBasic(getEntityResponsibleForReporting(), o.getEntityResponsibleForReporting(), this::setEntityResponsibleForReporting);
			merger.mergeBasic(getCountryOfTheCounterparty2(), o.getCountryOfTheCounterparty2(), this::setCountryOfTheCounterparty2);
			merger.mergeBasic(getCounterparty2IdentifierSource(), o.getCounterparty2IdentifierSource(), this::setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum);
			merger.mergeBasic(getTradingCapacity(), o.getTradingCapacity(), this::setTradingCapacity);
			merger.mergeBasic(getBrokerID(), o.getBrokerID(), this::setBrokerID);
			merger.mergeBasic(getContractType(), o.getContractType(), this::setContractType);
			merger.mergeBasic(getAssetClass(), o.getAssetClass(), this::setAssetClass);
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getOptionStyle(), o.getOptionStyle(), this::setOptionStyle);
			merger.mergeBasic(getEmbeddedOptionType(), o.getEmbeddedOptionType(), this::setEmbeddedOptionType);
			merger.mergeBasic(getMasterAgreementType(), o.getMasterAgreementType(), this::setMasterAgreementType);
			merger.mergeBasic(getMasterAgreementVersion(), o.getMasterAgreementVersion(), this::setMasterAgreementVersion);
			merger.mergeBasic(getSecondaryTransactionIdentifier(), o.getSecondaryTransactionIdentifier(), this::setSecondaryTransactionIdentifier);
			merger.mergeBasic(getIntragroup(), o.getIntragroup(), this::setIntragroup);
			merger.mergeBasic(getNonStandardizedTermIndicator(), o.getNonStandardizedTermIndicator(), this::setNonStandardizedTermIndicator);
			merger.mergeBasic(getAmendmentIndicator(), o.getAmendmentIndicator(), this::setAmendmentIndicator);
			merger.mergeBasic(getUnderlyingIdentification(), o.getUnderlyingIdentification(), this::setUnderlyingIdentification);
			merger.mergeBasic(getUnderlyingIdentificationType(), o.getUnderlyingIdentificationType(), this::setUnderlyingIdentificationType);
			merger.mergeBasic(getNameOfTheUnderlyingIndex(), o.getNameOfTheUnderlyingIndex(), this::setNameOfTheUnderlyingIndex);
			merger.mergeBasic(getMaturityDateOfTheUnderlying(), o.getMaturityDateOfTheUnderlying(), this::setMaturityDateOfTheUnderlying);
			merger.mergeBasic(getSwapLinkID(), o.getSwapLinkID(), this::setSwapLinkID);
			merger.mergeBasic(getPackageIndicator(), o.getPackageIndicator(), this::setPackageIndicatorOverriddenAsBoolean);
			merger.mergeBasic(getCustomBasketIndicator(), o.getCustomBasketIndicator(), this::setCustomBasketIndicatorOverriddenAsBoolean);
			merger.mergeBasic(getPriorUTIProprietary(), o.getPriorUTIProprietary(), this::setPriorUTIProprietary);
			merger.mergeBasic(getClearingTimestamp(), o.getClearingTimestamp(), this::setClearingTimestamp);
			merger.mergeBasic(getClearingAccountOrigin(), o.getClearingAccountOrigin(), this::setClearingAccountOrigin);
			merger.mergeBasic(getClearingReceiptTimestamp(), o.getClearingReceiptTimestamp(), this::setClearingReceiptTimestamp);
			merger.mergeBasic(getUniqueTransactionIdentifier(), o.getUniqueTransactionIdentifier(), this::setUniqueTransactionIdentifier);
			merger.mergeBasic(getUniqueTransactionIdentifierProprietary(), o.getUniqueTransactionIdentifierProprietary(), this::setUniqueTransactionIdentifierProprietary);
			merger.mergeBasic(getUniqueProductIdentifier(), o.getUniqueProductIdentifier(), this::setUniqueProductIdentifier);
			merger.mergeBasic(getOriginalSwapUTI(), o.getOriginalSwapUTI(), this::setOriginalSwapUTI);
			merger.mergeBasic(getSubsequentPositionUTI(), o.getSubsequentPositionUTI(), this::setSubsequentPositionUTI);
			merger.mergeBasic(getOriginalSwapSDRIdentifier(), o.getOriginalSwapSDRIdentifier(), this::setOriginalSwapSDRIdentifier);
			merger.mergeBasic(getPriorUSI(), o.getPriorUSI(), this::setPriorUSI);
			merger.mergeBasic(getNewSDRIdentifier(), o.getNewSDRIdentifier(), this::setNewSDRIdentifier);
			merger.mergeBasic(getTechnicalRecordId(), o.getTechnicalRecordId(), this::setTechnicalRecordId);
			merger.mergeBasic(getReferenceEntity(), o.getReferenceEntity(), this::setReferenceEntity);
			merger.mergeBasic(getSeniority(), o.getSeniority(), this::setSeniority);
			merger.mergeBasic(getSeries(), o.getSeries(), this::setSeries);
			merger.mergeBasic(getIndexFactor(), o.getIndexFactor(), this::setIndexFactor);
			merger.mergeBasic(getSeriesVersion(), o.getSeriesVersion(), this::setSeriesVersion);
			merger.mergeBasic(getBaseProduct(), o.getBaseProduct(), this::setBaseProduct);
			merger.mergeBasic(getSubProduct(), o.getSubProduct(), this::setSubProduct);
			merger.mergeBasic(getFurtherSubProduct(), o.getFurtherSubProduct(), this::setFurtherSubProduct);
			merger.mergeBasic(getInitialMarginCollateralPortfolioCode(), o.getInitialMarginCollateralPortfolioCode(), this::setInitialMarginCollateralPortfolioCode);
			merger.mergeBasic(getVariationMarginCollateralPortfolioCode(), o.getVariationMarginCollateralPortfolioCode(), this::setVariationMarginCollateralPortfolioCode);
			merger.mergeBasic(getPostPricedSwapIndicator(), o.getPostPricedSwapIndicator(), this::setPostPricedSwapIndicator);
			merger.mergeBasic(getUniqueSwapIdentifier(), o.getUniqueSwapIdentifier(), this::setUniqueSwapIdentifier);
			merger.mergeBasic(getCounterparty1FinancialEntityIndicator(), o.getCounterparty1FinancialEntityIndicator(), this::setCounterparty1FinancialEntityIndicator);
			merger.mergeBasic(getCounterparty2FinancialEntityIndicator(), o.getCounterparty2FinancialEntityIndicator(), this::setCounterparty2FinancialEntityIndicator);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SECTransactionReport _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(earlyTerminationDate, _that.getEarlyTerminationDate())) return false;
			if (!Objects.equals(reportingTimestamp, _that.getReportingTimestamp())) return false;
			if (!Objects.equals(executionTimestamp, _that.getExecutionTimestamp())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(counterparty1, _that.getCounterparty1())) return false;
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(beneficiary1, _that.getBeneficiary1())) return false;
			if (!Objects.equals(beneficiary1IdentifierTypeIndicator, _that.getBeneficiary1IdentifierTypeIndicator())) return false;
			if (!Objects.equals(buyerIdentifier, _that.getBuyerIdentifier())) return false;
			if (!Objects.equals(sellerIdentifier, _that.getSellerIdentifier())) return false;
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(centralCounterparty, _that.getCentralCounterparty())) return false;
			if (!Objects.equals(clearingMember, _that.getClearingMember())) return false;
			if (!Objects.equals(confirmed, _that.getConfirmed())) return false;
			if (!Objects.equals(callAmount, _that.getCallAmount())) return false;
			if (!Objects.equals(putAmount, _that.getPutAmount())) return false;
			if (!Objects.equals(callCurrency, _that.getCallCurrency())) return false;
			if (!Objects.equals(putCurrency, _that.getPutCurrency())) return false;
			if (!Objects.equals(delta, _that.getDelta())) return false;
			if (!ListEquals.listEquals(priceSchedule, _that.getPriceSchedule())) return false;
			if (!ListEquals.listEquals(strikePriceSchedule, _that.getStrikePriceSchedule())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(priceNotation, _that.getPriceNotation())) return false;
			if (!Objects.equals(priceCurrency, _that.getPriceCurrency())) return false;
			if (!Objects.equals(packageTransactionPrice, _that.getPackageTransactionPrice())) return false;
			if (!Objects.equals(packageTransactionPriceNotation, _that.getPackageTransactionPriceNotation())) return false;
			if (!Objects.equals(packageTransactionPriceCurrency, _that.getPackageTransactionPriceCurrency())) return false;
			if (!Objects.equals(packageTransactionSpread, _that.getPackageTransactionSpread())) return false;
			if (!Objects.equals(packageTransactionSpreadNotation, _that.getPackageTransactionSpreadNotation())) return false;
			if (!Objects.equals(packageTransactionSpreadCurrency, _that.getPackageTransactionSpreadCurrency())) return false;
			if (!Objects.equals(packageIdentifier, _that.getPackageIdentifier())) return false;
			if (!Objects.equals(strikePrice, _that.getStrikePrice())) return false;
			if (!Objects.equals(strikePriceNotation, _that.getStrikePriceNotation())) return false;
			if (!Objects.equals(strikePriceCurrency, _that.getStrikePriceCurrency())) return false;
			if (!Objects.equals(priceUnitOfMeasure, _that.getPriceUnitOfMeasure())) return false;
			if (!Objects.equals(optionPremiumAmount, _that.getOptionPremiumAmount())) return false;
			if (!Objects.equals(optionPremiumCurrency, _that.getOptionPremiumCurrency())) return false;
			if (!Objects.equals(optionPremiumPaymentDate, _that.getOptionPremiumPaymentDate())) return false;
			if (!Objects.equals(exchangeRate, _that.getExchangeRate())) return false;
			if (!Objects.equals(exchangeRateBasis, _that.getExchangeRateBasis())) return false;
			if (!Objects.equals(cdSIndexAttachmentPoint, _that.getCdSIndexAttachmentPoint())) return false;
			if (!Objects.equals(cdSIndexDetachmentPoint, _that.getCdSIndexDetachmentPoint())) return false;
			if (!Objects.equals(collateralPortfolioIndicator, _that.getCollateralPortfolioIndicator())) return false;
			if (!Objects.equals(firstExerciseDate, _that.getFirstExerciseDate())) return false;
			if (!Objects.equals(finalContractualSettlementDate, _that.getFinalContractualSettlementDate())) return false;
			if (!Objects.equals(settlementLocation, _that.getSettlementLocation())) return false;
			if (!Objects.equals(priorUTI, _that.getPriorUTI())) return false;
			if (!Objects.equals(direction1, _that.getDirection1())) return false;
			if (!Objects.equals(valuationAmount, _that.getValuationAmount())) return false;
			if (!Objects.equals(valuationCurrency, _that.getValuationCurrency())) return false;
			if (!Objects.equals(valuationMethod, _that.getValuationMethod())) return false;
			if (!Objects.equals(valuationTimestamp, _that.getValuationTimestamp())) return false;
			if (!Objects.equals(customBasketCode, _that.getCustomBasketCode())) return false;
			if (!ListEquals.listEquals(basketConstituents, _that.getBasketConstituents())) return false;
			if (!ListEquals.listEquals(otherPayment, _that.getOtherPayment())) return false;
			if (!Objects.equals(leg1, _that.getLeg1())) return false;
			if (!Objects.equals(leg2, _that.getLeg2())) return false;
			if (!Objects.equals(underlyingIdOther, _that.getUnderlyingIdOther())) return false;
			if (!Objects.equals(underlyingIdOtherSource, _that.getUnderlyingIdOtherSource())) return false;
			if (!Objects.equals(underlyingAssetTradingPlatformIdentifier, _that.getUnderlyingAssetTradingPlatformIdentifier())) return false;
			if (!Objects.equals(underlyingAssetPriceSource, _that.getUnderlyingAssetPriceSource())) return false;
			if (!Objects.equals(cryptoAssetUnderlyingIndicator, _that.getCryptoAssetUnderlyingIndicator())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(eventType, _that.getEventType())) return false;
			if (!Objects.equals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(eventTimestamp, _that.getEventTimestamp())) return false;
			if (!Objects.equals(confirmationTimestamp, _that.getConfirmationTimestamp())) return false;
			if (!Objects.equals(platformIdentifier, _that.getPlatformIdentifier())) return false;
			if (!Objects.equals(bookingLocation, _that.getBookingLocation())) return false;
			if (!Objects.equals(traderLocation, _that.getTraderLocation())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(executionAgentCounterparty1, _that.getExecutionAgentCounterparty1())) return false;
			if (!Objects.equals(executionAgentCounterparty2, _that.getExecutionAgentCounterparty2())) return false;
			if (!Objects.equals(natureOfCounterparty1, _that.getNatureOfCounterparty1())) return false;
			if (!Objects.equals(natureOfCounterparty2, _that.getNatureOfCounterparty2())) return false;
			if (!ListEquals.listEquals(clearingExceptionsAndExemptionsCounterparty1, _that.getClearingExceptionsAndExemptionsCounterparty1())) return false;
			if (!ListEquals.listEquals(clearingExceptionsAndExemptionsCounterparty2, _that.getClearingExceptionsAndExemptionsCounterparty2())) return false;
			if (!ListEquals.listEquals(corporateSectorOfTheCounterparty1, _that.getCorporateSectorOfTheCounterparty1())) return false;
			if (!ListEquals.listEquals(corporateSectorOfTheCounterparty2, _that.getCorporateSectorOfTheCounterparty2())) return false;
			if (!Objects.equals(counterparty2Name, _that.getCounterparty2Name())) return false;
			if (!Objects.equals(reportSubmittingEntityID, _that.getReportSubmittingEntityID())) return false;
			if (!Objects.equals(entityResponsibleForReporting, _that.getEntityResponsibleForReporting())) return false;
			if (!Objects.equals(countryOfTheCounterparty2, _that.getCountryOfTheCounterparty2())) return false;
			if (!Objects.equals(counterparty2IdentifierSource, _that.getCounterparty2IdentifierSource())) return false;
			if (!Objects.equals(tradingCapacity, _that.getTradingCapacity())) return false;
			if (!Objects.equals(brokerID, _that.getBrokerID())) return false;
			if (!Objects.equals(contractType, _that.getContractType())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(optionStyle, _that.getOptionStyle())) return false;
			if (!Objects.equals(embeddedOptionType, _that.getEmbeddedOptionType())) return false;
			if (!Objects.equals(masterAgreementType, _that.getMasterAgreementType())) return false;
			if (!Objects.equals(masterAgreementVersion, _that.getMasterAgreementVersion())) return false;
			if (!Objects.equals(secondaryTransactionIdentifier, _that.getSecondaryTransactionIdentifier())) return false;
			if (!Objects.equals(intragroup, _that.getIntragroup())) return false;
			if (!Objects.equals(nonStandardizedTermIndicator, _that.getNonStandardizedTermIndicator())) return false;
			if (!Objects.equals(amendmentIndicator, _that.getAmendmentIndicator())) return false;
			if (!Objects.equals(underlyingIdentification, _that.getUnderlyingIdentification())) return false;
			if (!Objects.equals(underlyingIdentificationType, _that.getUnderlyingIdentificationType())) return false;
			if (!Objects.equals(nameOfTheUnderlyingIndex, _that.getNameOfTheUnderlyingIndex())) return false;
			if (!Objects.equals(maturityDateOfTheUnderlying, _that.getMaturityDateOfTheUnderlying())) return false;
			if (!Objects.equals(swapLinkID, _that.getSwapLinkID())) return false;
			if (!Objects.equals(packageIndicator, _that.getPackageIndicator())) return false;
			if (!Objects.equals(customBasketIndicator, _that.getCustomBasketIndicator())) return false;
			if (!Objects.equals(priorUTIProprietary, _that.getPriorUTIProprietary())) return false;
			if (!Objects.equals(clearingTimestamp, _that.getClearingTimestamp())) return false;
			if (!Objects.equals(clearingAccountOrigin, _that.getClearingAccountOrigin())) return false;
			if (!Objects.equals(clearingReceiptTimestamp, _that.getClearingReceiptTimestamp())) return false;
			if (!Objects.equals(uniqueTransactionIdentifier, _that.getUniqueTransactionIdentifier())) return false;
			if (!Objects.equals(uniqueTransactionIdentifierProprietary, _that.getUniqueTransactionIdentifierProprietary())) return false;
			if (!Objects.equals(uniqueProductIdentifier, _that.getUniqueProductIdentifier())) return false;
			if (!Objects.equals(originalSwapUTI, _that.getOriginalSwapUTI())) return false;
			if (!Objects.equals(subsequentPositionUTI, _that.getSubsequentPositionUTI())) return false;
			if (!Objects.equals(originalSwapSDRIdentifier, _that.getOriginalSwapSDRIdentifier())) return false;
			if (!Objects.equals(priorUSI, _that.getPriorUSI())) return false;
			if (!Objects.equals(newSDRIdentifier, _that.getNewSDRIdentifier())) return false;
			if (!Objects.equals(technicalRecordId, _that.getTechnicalRecordId())) return false;
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(series, _that.getSeries())) return false;
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(seriesVersion, _that.getSeriesVersion())) return false;
			if (!Objects.equals(baseProduct, _that.getBaseProduct())) return false;
			if (!Objects.equals(subProduct, _that.getSubProduct())) return false;
			if (!Objects.equals(furtherSubProduct, _that.getFurtherSubProduct())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(initialMarginCollateralPortfolioCode, _that.getInitialMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(variationMarginCollateralPortfolioCode, _that.getVariationMarginCollateralPortfolioCode())) return false;
			if (!Objects.equals(nonReportable, _that.getNonReportable())) return false;
			if (!Objects.equals(postPricedSwapIndicator, _that.getPostPricedSwapIndicator())) return false;
			if (!Objects.equals(uniqueSwapIdentifier, _that.getUniqueSwapIdentifier())) return false;
			if (!Objects.equals(counterparty1FinancialEntityIndicator, _that.getCounterparty1FinancialEntityIndicator())) return false;
			if (!Objects.equals(counterparty2FinancialEntityIndicator, _that.getCounterparty2FinancialEntityIndicator())) return false;
			if (!Objects.equals(dtccAdditionalFields, _that.getDtccAdditionalFields())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationDate != null ? earlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (reportingTimestamp != null ? reportingTimestamp.hashCode() : 0);
			_result = 31 * _result + (executionTimestamp != null ? executionTimestamp.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (counterparty1 != null ? counterparty1.hashCode() : 0);
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (beneficiary1 != null ? beneficiary1.hashCode() : 0);
			_result = 31 * _result + (beneficiary1IdentifierTypeIndicator != null ? beneficiary1IdentifierTypeIndicator.hashCode() : 0);
			_result = 31 * _result + (buyerIdentifier != null ? buyerIdentifier.hashCode() : 0);
			_result = 31 * _result + (sellerIdentifier != null ? sellerIdentifier.hashCode() : 0);
			_result = 31 * _result + (cleared != null ? cleared.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (centralCounterparty != null ? centralCounterparty.hashCode() : 0);
			_result = 31 * _result + (clearingMember != null ? clearingMember.hashCode() : 0);
			_result = 31 * _result + (confirmed != null ? confirmed.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (callAmount != null ? callAmount.hashCode() : 0);
			_result = 31 * _result + (putAmount != null ? putAmount.hashCode() : 0);
			_result = 31 * _result + (callCurrency != null ? callCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (putCurrency != null ? putCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (delta != null ? delta.hashCode() : 0);
			_result = 31 * _result + (priceSchedule != null ? priceSchedule.hashCode() : 0);
			_result = 31 * _result + (strikePriceSchedule != null ? strikePriceSchedule.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (priceNotation != null ? priceNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priceCurrency != null ? priceCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageTransactionPrice != null ? packageTransactionPrice.hashCode() : 0);
			_result = 31 * _result + (packageTransactionPriceNotation != null ? packageTransactionPriceNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageTransactionPriceCurrency != null ? packageTransactionPriceCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageTransactionSpread != null ? packageTransactionSpread.hashCode() : 0);
			_result = 31 * _result + (packageTransactionSpreadNotation != null ? packageTransactionSpreadNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageTransactionSpreadCurrency != null ? packageTransactionSpreadCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageIdentifier != null ? packageIdentifier.hashCode() : 0);
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (strikePriceNotation != null ? strikePriceNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikePriceCurrency != null ? strikePriceCurrency.hashCode() : 0);
			_result = 31 * _result + (priceUnitOfMeasure != null ? priceUnitOfMeasure.hashCode() : 0);
			_result = 31 * _result + (optionPremiumAmount != null ? optionPremiumAmount.hashCode() : 0);
			_result = 31 * _result + (optionPremiumCurrency != null ? optionPremiumCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionPremiumPaymentDate != null ? optionPremiumPaymentDate.hashCode() : 0);
			_result = 31 * _result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
			_result = 31 * _result + (exchangeRateBasis != null ? exchangeRateBasis.hashCode() : 0);
			_result = 31 * _result + (cdSIndexAttachmentPoint != null ? cdSIndexAttachmentPoint.hashCode() : 0);
			_result = 31 * _result + (cdSIndexDetachmentPoint != null ? cdSIndexDetachmentPoint.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioIndicator != null ? collateralPortfolioIndicator.hashCode() : 0);
			_result = 31 * _result + (firstExerciseDate != null ? firstExerciseDate.hashCode() : 0);
			_result = 31 * _result + (finalContractualSettlementDate != null ? finalContractualSettlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementLocation != null ? settlementLocation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priorUTI != null ? priorUTI.hashCode() : 0);
			_result = 31 * _result + (direction1 != null ? direction1.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationAmount != null ? valuationAmount.hashCode() : 0);
			_result = 31 * _result + (valuationCurrency != null ? valuationCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationMethod != null ? valuationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationTimestamp != null ? valuationTimestamp.hashCode() : 0);
			_result = 31 * _result + (customBasketCode != null ? customBasketCode.hashCode() : 0);
			_result = 31 * _result + (basketConstituents != null ? basketConstituents.hashCode() : 0);
			_result = 31 * _result + (otherPayment != null ? otherPayment.hashCode() : 0);
			_result = 31 * _result + (leg1 != null ? leg1.hashCode() : 0);
			_result = 31 * _result + (leg2 != null ? leg2.hashCode() : 0);
			_result = 31 * _result + (underlyingIdOther != null ? underlyingIdOther.hashCode() : 0);
			_result = 31 * _result + (underlyingIdOtherSource != null ? underlyingIdOtherSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingAssetTradingPlatformIdentifier != null ? underlyingAssetTradingPlatformIdentifier.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetPriceSource != null ? underlyingAssetPriceSource.hashCode() : 0);
			_result = 31 * _result + (cryptoAssetUnderlyingIndicator != null ? cryptoAssetUnderlyingIndicator.hashCode() : 0);
			_result = 31 * _result + (level != null ? level.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventType != null ? eventType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (eventTimestamp != null ? eventTimestamp.hashCode() : 0);
			_result = 31 * _result + (confirmationTimestamp != null ? confirmationTimestamp.hashCode() : 0);
			_result = 31 * _result + (platformIdentifier != null ? platformIdentifier.hashCode() : 0);
			_result = 31 * _result + (bookingLocation != null ? bookingLocation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (traderLocation != null ? traderLocation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (executionAgentCounterparty1 != null ? executionAgentCounterparty1.hashCode() : 0);
			_result = 31 * _result + (executionAgentCounterparty2 != null ? executionAgentCounterparty2.hashCode() : 0);
			_result = 31 * _result + (natureOfCounterparty1 != null ? natureOfCounterparty1.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (natureOfCounterparty2 != null ? natureOfCounterparty2.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (clearingExceptionsAndExemptionsCounterparty1 != null ? clearingExceptionsAndExemptionsCounterparty1.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (clearingExceptionsAndExemptionsCounterparty2 != null ? clearingExceptionsAndExemptionsCounterparty2.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (corporateSectorOfTheCounterparty1 != null ? corporateSectorOfTheCounterparty1.hashCode() : 0);
			_result = 31 * _result + (corporateSectorOfTheCounterparty2 != null ? corporateSectorOfTheCounterparty2.hashCode() : 0);
			_result = 31 * _result + (counterparty2Name != null ? counterparty2Name.hashCode() : 0);
			_result = 31 * _result + (reportSubmittingEntityID != null ? reportSubmittingEntityID.hashCode() : 0);
			_result = 31 * _result + (entityResponsibleForReporting != null ? entityResponsibleForReporting.hashCode() : 0);
			_result = 31 * _result + (countryOfTheCounterparty2 != null ? countryOfTheCounterparty2.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierSource != null ? counterparty2IdentifierSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradingCapacity != null ? tradingCapacity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (brokerID != null ? brokerID.hashCode() : 0);
			_result = 31 * _result + (contractType != null ? contractType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionStyle != null ? optionStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (embeddedOptionType != null ? embeddedOptionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (masterAgreementType != null ? masterAgreementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (masterAgreementVersion != null ? masterAgreementVersion.hashCode() : 0);
			_result = 31 * _result + (secondaryTransactionIdentifier != null ? secondaryTransactionIdentifier.hashCode() : 0);
			_result = 31 * _result + (intragroup != null ? intragroup.hashCode() : 0);
			_result = 31 * _result + (nonStandardizedTermIndicator != null ? nonStandardizedTermIndicator.hashCode() : 0);
			_result = 31 * _result + (amendmentIndicator != null ? amendmentIndicator.hashCode() : 0);
			_result = 31 * _result + (underlyingIdentification != null ? underlyingIdentification.hashCode() : 0);
			_result = 31 * _result + (underlyingIdentificationType != null ? underlyingIdentificationType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (nameOfTheUnderlyingIndex != null ? nameOfTheUnderlyingIndex.hashCode() : 0);
			_result = 31 * _result + (maturityDateOfTheUnderlying != null ? maturityDateOfTheUnderlying.hashCode() : 0);
			_result = 31 * _result + (swapLinkID != null ? swapLinkID.hashCode() : 0);
			_result = 31 * _result + (packageIndicator != null ? packageIndicator.hashCode() : 0);
			_result = 31 * _result + (customBasketIndicator != null ? customBasketIndicator.hashCode() : 0);
			_result = 31 * _result + (priorUTIProprietary != null ? priorUTIProprietary.hashCode() : 0);
			_result = 31 * _result + (clearingTimestamp != null ? clearingTimestamp.hashCode() : 0);
			_result = 31 * _result + (clearingAccountOrigin != null ? clearingAccountOrigin.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (clearingReceiptTimestamp != null ? clearingReceiptTimestamp.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifier != null ? uniqueTransactionIdentifier.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifierProprietary != null ? uniqueTransactionIdentifierProprietary.hashCode() : 0);
			_result = 31 * _result + (uniqueProductIdentifier != null ? uniqueProductIdentifier.hashCode() : 0);
			_result = 31 * _result + (originalSwapUTI != null ? originalSwapUTI.hashCode() : 0);
			_result = 31 * _result + (subsequentPositionUTI != null ? subsequentPositionUTI.hashCode() : 0);
			_result = 31 * _result + (originalSwapSDRIdentifier != null ? originalSwapSDRIdentifier.hashCode() : 0);
			_result = 31 * _result + (priorUSI != null ? priorUSI.hashCode() : 0);
			_result = 31 * _result + (newSDRIdentifier != null ? newSDRIdentifier.hashCode() : 0);
			_result = 31 * _result + (technicalRecordId != null ? technicalRecordId.hashCode() : 0);
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (series != null ? series.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (seriesVersion != null ? seriesVersion.hashCode() : 0);
			_result = 31 * _result + (baseProduct != null ? baseProduct.hashCode() : 0);
			_result = 31 * _result + (subProduct != null ? subProduct.hashCode() : 0);
			_result = 31 * _result + (furtherSubProduct != null ? furtherSubProduct.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (initialMarginCollateralPortfolioCode != null ? initialMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (variationMarginCollateralPortfolioCode != null ? variationMarginCollateralPortfolioCode.hashCode() : 0);
			_result = 31 * _result + (nonReportable != null ? nonReportable.hashCode() : 0);
			_result = 31 * _result + (postPricedSwapIndicator != null ? postPricedSwapIndicator.hashCode() : 0);
			_result = 31 * _result + (uniqueSwapIdentifier != null ? uniqueSwapIdentifier.hashCode() : 0);
			_result = 31 * _result + (counterparty1FinancialEntityIndicator != null ? counterparty1FinancialEntityIndicator.hashCode() : 0);
			_result = 31 * _result + (counterparty2FinancialEntityIndicator != null ? counterparty2FinancialEntityIndicator.hashCode() : 0);
			_result = 31 * _result + (dtccAdditionalFields != null ? dtccAdditionalFields.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SECTransactionReportBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"earlyTerminationDate=" + this.earlyTerminationDate + ", " +
				"reportingTimestamp=" + this.reportingTimestamp + ", " +
				"executionTimestamp=" + this.executionTimestamp + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"counterparty1=" + this.counterparty1 + ", " +
				"counterparty2=" + this.counterparty2 + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"beneficiary1=" + this.beneficiary1 + ", " +
				"beneficiary1IdentifierTypeIndicator=" + this.beneficiary1IdentifierTypeIndicator + ", " +
				"buyerIdentifier=" + this.buyerIdentifier + ", " +
				"sellerIdentifier=" + this.sellerIdentifier + ", " +
				"cleared=" + this.cleared + ", " +
				"centralCounterparty=" + this.centralCounterparty + ", " +
				"clearingMember=" + this.clearingMember + ", " +
				"confirmed=" + this.confirmed + ", " +
				"callAmount=" + this.callAmount + ", " +
				"putAmount=" + this.putAmount + ", " +
				"callCurrency=" + this.callCurrency + ", " +
				"putCurrency=" + this.putCurrency + ", " +
				"delta=" + this.delta + ", " +
				"priceSchedule=" + this.priceSchedule + ", " +
				"strikePriceSchedule=" + this.strikePriceSchedule + ", " +
				"price=" + this.price + ", " +
				"priceNotation=" + this.priceNotation + ", " +
				"priceCurrency=" + this.priceCurrency + ", " +
				"packageTransactionPrice=" + this.packageTransactionPrice + ", " +
				"packageTransactionPriceNotation=" + this.packageTransactionPriceNotation + ", " +
				"packageTransactionPriceCurrency=" + this.packageTransactionPriceCurrency + ", " +
				"packageTransactionSpread=" + this.packageTransactionSpread + ", " +
				"packageTransactionSpreadNotation=" + this.packageTransactionSpreadNotation + ", " +
				"packageTransactionSpreadCurrency=" + this.packageTransactionSpreadCurrency + ", " +
				"packageIdentifier=" + this.packageIdentifier + ", " +
				"strikePrice=" + this.strikePrice + ", " +
				"strikePriceNotation=" + this.strikePriceNotation + ", " +
				"strikePriceCurrency=" + this.strikePriceCurrency + ", " +
				"priceUnitOfMeasure=" + this.priceUnitOfMeasure + ", " +
				"optionPremiumAmount=" + this.optionPremiumAmount + ", " +
				"optionPremiumCurrency=" + this.optionPremiumCurrency + ", " +
				"optionPremiumPaymentDate=" + this.optionPremiumPaymentDate + ", " +
				"exchangeRate=" + this.exchangeRate + ", " +
				"exchangeRateBasis=" + this.exchangeRateBasis + ", " +
				"cdSIndexAttachmentPoint=" + this.cdSIndexAttachmentPoint + ", " +
				"cdSIndexDetachmentPoint=" + this.cdSIndexDetachmentPoint + ", " +
				"collateralPortfolioIndicator=" + this.collateralPortfolioIndicator + ", " +
				"firstExerciseDate=" + this.firstExerciseDate + ", " +
				"finalContractualSettlementDate=" + this.finalContractualSettlementDate + ", " +
				"settlementLocation=" + this.settlementLocation + ", " +
				"priorUTI=" + this.priorUTI + ", " +
				"direction1=" + this.direction1 + ", " +
				"valuationAmount=" + this.valuationAmount + ", " +
				"valuationCurrency=" + this.valuationCurrency + ", " +
				"valuationMethod=" + this.valuationMethod + ", " +
				"valuationTimestamp=" + this.valuationTimestamp + ", " +
				"customBasketCode=" + this.customBasketCode + ", " +
				"basketConstituents=" + this.basketConstituents + ", " +
				"otherPayment=" + this.otherPayment + ", " +
				"leg1=" + this.leg1 + ", " +
				"leg2=" + this.leg2 + ", " +
				"underlyingIdOther=" + this.underlyingIdOther + ", " +
				"underlyingIdOtherSource=" + this.underlyingIdOtherSource + ", " +
				"underlyingAssetTradingPlatformIdentifier=" + this.underlyingAssetTradingPlatformIdentifier + ", " +
				"underlyingAssetPriceSource=" + this.underlyingAssetPriceSource + ", " +
				"cryptoAssetUnderlyingIndicator=" + this.cryptoAssetUnderlyingIndicator + ", " +
				"level=" + this.level + ", " +
				"actionType=" + this.actionType + ", " +
				"eventType=" + this.eventType + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"eventTimestamp=" + this.eventTimestamp + ", " +
				"confirmationTimestamp=" + this.confirmationTimestamp + ", " +
				"platformIdentifier=" + this.platformIdentifier + ", " +
				"bookingLocation=" + this.bookingLocation + ", " +
				"traderLocation=" + this.traderLocation + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"executionAgentCounterparty1=" + this.executionAgentCounterparty1 + ", " +
				"executionAgentCounterparty2=" + this.executionAgentCounterparty2 + ", " +
				"natureOfCounterparty1=" + this.natureOfCounterparty1 + ", " +
				"natureOfCounterparty2=" + this.natureOfCounterparty2 + ", " +
				"clearingExceptionsAndExemptionsCounterparty1=" + this.clearingExceptionsAndExemptionsCounterparty1 + ", " +
				"clearingExceptionsAndExemptionsCounterparty2=" + this.clearingExceptionsAndExemptionsCounterparty2 + ", " +
				"corporateSectorOfTheCounterparty1=" + this.corporateSectorOfTheCounterparty1 + ", " +
				"corporateSectorOfTheCounterparty2=" + this.corporateSectorOfTheCounterparty2 + ", " +
				"counterparty2Name=" + this.counterparty2Name + ", " +
				"reportSubmittingEntityID=" + this.reportSubmittingEntityID + ", " +
				"entityResponsibleForReporting=" + this.entityResponsibleForReporting + ", " +
				"countryOfTheCounterparty2=" + this.countryOfTheCounterparty2 + ", " +
				"counterparty2IdentifierSource=" + this.counterparty2IdentifierSource + ", " +
				"tradingCapacity=" + this.tradingCapacity + ", " +
				"brokerID=" + this.brokerID + ", " +
				"contractType=" + this.contractType + ", " +
				"assetClass=" + this.assetClass + ", " +
				"optionType=" + this.optionType + ", " +
				"optionStyle=" + this.optionStyle + ", " +
				"embeddedOptionType=" + this.embeddedOptionType + ", " +
				"masterAgreementType=" + this.masterAgreementType + ", " +
				"masterAgreementVersion=" + this.masterAgreementVersion + ", " +
				"secondaryTransactionIdentifier=" + this.secondaryTransactionIdentifier + ", " +
				"intragroup=" + this.intragroup + ", " +
				"nonStandardizedTermIndicator=" + this.nonStandardizedTermIndicator + ", " +
				"amendmentIndicator=" + this.amendmentIndicator + ", " +
				"underlyingIdentification=" + this.underlyingIdentification + ", " +
				"underlyingIdentificationType=" + this.underlyingIdentificationType + ", " +
				"nameOfTheUnderlyingIndex=" + this.nameOfTheUnderlyingIndex + ", " +
				"maturityDateOfTheUnderlying=" + this.maturityDateOfTheUnderlying + ", " +
				"swapLinkID=" + this.swapLinkID + ", " +
				"packageIndicator=" + this.packageIndicator + ", " +
				"customBasketIndicator=" + this.customBasketIndicator + ", " +
				"priorUTIProprietary=" + this.priorUTIProprietary + ", " +
				"clearingTimestamp=" + this.clearingTimestamp + ", " +
				"clearingAccountOrigin=" + this.clearingAccountOrigin + ", " +
				"clearingReceiptTimestamp=" + this.clearingReceiptTimestamp + ", " +
				"uniqueTransactionIdentifier=" + this.uniqueTransactionIdentifier + ", " +
				"uniqueTransactionIdentifierProprietary=" + this.uniqueTransactionIdentifierProprietary + ", " +
				"uniqueProductIdentifier=" + this.uniqueProductIdentifier + ", " +
				"originalSwapUTI=" + this.originalSwapUTI + ", " +
				"subsequentPositionUTI=" + this.subsequentPositionUTI + ", " +
				"originalSwapSDRIdentifier=" + this.originalSwapSDRIdentifier + ", " +
				"priorUSI=" + this.priorUSI + ", " +
				"newSDRIdentifier=" + this.newSDRIdentifier + ", " +
				"technicalRecordId=" + this.technicalRecordId + ", " +
				"referenceEntity=" + this.referenceEntity + ", " +
				"seniority=" + this.seniority + ", " +
				"series=" + this.series + ", " +
				"indexFactor=" + this.indexFactor + ", " +
				"seriesVersion=" + this.seriesVersion + ", " +
				"baseProduct=" + this.baseProduct + ", " +
				"subProduct=" + this.subProduct + ", " +
				"furtherSubProduct=" + this.furtherSubProduct + ", " +
				"barrier=" + this.barrier + ", " +
				"initialMarginCollateralPortfolioCode=" + this.initialMarginCollateralPortfolioCode + ", " +
				"variationMarginCollateralPortfolioCode=" + this.variationMarginCollateralPortfolioCode + ", " +
				"nonReportable=" + this.nonReportable + ", " +
				"postPricedSwapIndicator=" + this.postPricedSwapIndicator + ", " +
				"uniqueSwapIdentifier=" + this.uniqueSwapIdentifier + ", " +
				"counterparty1FinancialEntityIndicator=" + this.counterparty1FinancialEntityIndicator + ", " +
				"counterparty2FinancialEntityIndicator=" + this.counterparty2FinancialEntityIndicator + ", " +
				"dtccAdditionalFields=" + this.dtccAdditionalFields +
			'}';
		}
	}
}

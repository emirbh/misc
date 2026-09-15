package drr.standards.iosco.cde.version1;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
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
import drr.standards.iosco.cde.version1.meta.CriticalDataElementV1Meta;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.ConfirmationEnum;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="CriticalDataElementV1", builder=CriticalDataElementV1.CriticalDataElementV1BuilderImpl.class, version="7.7.0")
@RuneDataType(value="CriticalDataElementV1", model="drr", builder=CriticalDataElementV1.CriticalDataElementV1BuilderImpl.class, version="7.7.0")
public interface CriticalDataElementV1 extends RosettaModelObject {

	CriticalDataElementV1Meta metaData = new CriticalDataElementV1Meta();

	/*********************** Getter Methods  ***********************/
	Date getEffectiveDate();
	Date getEarlyTerminationDate();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "4"
	 *
	 * Provision Date and time of the submission of the report to the trade repository.
	 *
	 */
	ZonedDateTime getReportingTimestamp();
	ZonedDateTime getExecutionTimestamp();
	Date getExpirationDate();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "6"
	 *
	 * Provision Identifier of the counterparty to an OTC derivative transaction who is fulfilling its reporting obligation via the report in question. In jurisdictions where both parties must report the transaction, the identifier of Counterparty 1 always identifies the reporting counterparty. In the case of an allocated derivative transaction executed by a fund manager on behalf of a fund, the fund and not the fund manager is reported as the counterparty.
	 *
	 */
	String getCounterparty1();
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
	 */
	String getCounterparty2();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "8"
	 *
	 * Provision Indicator of whether LEI was used to identify the Counterparty 2
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20220703"
	 *
	 * Provision Peer review recommended to detect private individual party representations (instead of LEI scheme). For natural persons who are acting as private individuals (not business entities): LEI of the reporting counterparty followed by a unique identifier assigned and maintained consistently by the reporting counterparty for that natural person(s) for regulatory reporting purpose.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20240606"
	 *
	 * Provision Peer Review agreed that a natural person involved as principal to a transaction can only appear as either the 'Buyer' or the 'Seller'. These roles are therefore used to identify natural persons acting in a private capacity. In such cases, Counterparty2IdentifierType must be set to False to indicate that the counterparty is not a legal entity with an LEI. For all other cases (legal entities with LEI), the value is set to True.
	 *
	 */
	Boolean getCounterparty2IdentifierType();
	String getBeneficiary1();
	Boolean getBeneficiary1IdentifierTypeIndicator();
	String getBuyerIdentifier();
	String getSellerIdentifier();
	ClearedEnum getCleared();
	String getCentralCounterparty();
	String getClearingMember();
	ConfirmationEnum getConfirmed();
	BigDecimal getCallAmount();
	BigDecimal getPutAmount();
	ISOCurrencyCodeEnum getCallCurrency();
	ISOCurrencyCodeEnum getPutCurrency();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "71"
	 *
	 * Provision The ratio of the absolute change in price of an OTC derivative transaction to the change in price of the underlier, at the time a new transaction is reported or when a change in the notional amount is reported.
	 *
	 */
	BigDecimal getDelta();
	List<? extends PricePeriod> getPriceSchedule();
	List<? extends PricePeriod> getStrikePriceSchedule();
	PriceFormat getPrice();
	PriceNotationEnum getPriceNotation();
	ISOCurrencyCodeEnum getPriceCurrency();
	PriceFormat getPackageTransactionPrice();
	PriceNotationEnum getPackageTransactionPriceNotation();
	ISOCurrencyCodeEnum getPackageTransactionPriceCurrency();
	PriceFormat getPackageTransactionSpread();
	PriceNotationEnum getPackageTransactionSpreadNotation();
	ISOCurrencyCodeEnum getPackageTransactionSpreadCurrency();
	String getPackageIdentifier();
	PriceFormat getStrikePrice();
	PriceNotationEnum getStrikePriceNotation();
	String getStrikePriceCurrency();
	String getPriceUnitOfMeasure();
	BigDecimal getOptionPremiumAmount();
	ISOCurrencyCodeEnum getOptionPremiumCurrency();
	Date getOptionPremiumPaymentDate();
	BigDecimal getExchangeRate();
	String getExchangeRateBasis();
	BigDecimal getCdSIndexAttachmentPoint();
	BigDecimal getCdSIndexDetachmentPoint();
	Boolean getCollateralPortfolioIndicator();
	Date getFirstExerciseDate();
	Date getFinalContractualSettlementDate();
	ISOCountryCodeEnum getSettlementLocation();
	String getPriorUTI();
	Direction1Enum getDirection1();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "25"
	 *
	 * Provision Current value of the outstanding contract. without applying any valuation adjustments (some examples include XVA adjustment such as CVA, DVA, etc).
	         Valuation amount is expressed as the exit cost of the contract or components of the contract, ie the price that would be received to sell the contract (in the market in an orderly transaction at the valuation date).
	 *
	 */
	BigDecimal getValuationAmount();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "26"
	 *
	 * Provision Currency in which the valuation amount is denominated.
	 *
	 */
	ISOCurrencyCodeEnum getValuationCurrency();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * table "2" * field "28"
	 *
	 * Provision Source and method used for the valuation of the transaction by the reporting counterparty.
	             If at least one valuation input is used that is classified as mark-to-model in the below table, then the whole valuation is classified as mark-to-model.
	             If only inputs are used that are classified as mark-to-market in the table below, then the whole valuation is classified as mark-to-market.
	 *
	 */
	ValuationType1Code getValuationMethod();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) "The G20 Leaders agreed in 2009 that all over-the-counter (OTC) derivative transactions should be reported to trade repositories (TRs) to further the goals of improving transparency, mitigating systemic risk and preventing market abuse.1 Aggregation of the data being reported across TRs will help authorities to obtain a comprehensive view of the OTC derivatives market and its activity. Such aggregation is feasible if the work on standardisation and harmonisation of important data elements [is] completed.2 Since November 2014, the CPMI and IOSCO working group for the harmonisation of key OTC derivatives data elements (Harmonisation Group) has worked to develop global guidance regarding the definition, format and usage of key OTC derivatives data elements reported to TRs, including the Unique Transaction Identifier (UTI), the Unique Product Identifier (UPI) and other critical data elements. Technical Guidance on the Harmonisation of the Unique Transaction Identifier (UTI) was published in February 20173 and Technical Guidance on the Harmonisation of the Unique Product Identifier (UPI) was published in September 2017.4 The CPMI and IOSCO also published consultative reports on a first, a second and a third batch of critical data elements other than UTI and UPI in September 2015, October 2016 and June 2017, respectively" 
	 * section "2" * field "27"
	 *
	 * Provision Date and time of the last valuation marked to market, provided by the central counterparty (CCP) or calculated using the current or last available market price of the inputs. If for example a currency exchange rate is the basis for a transactions valuation, then the valuation timestamp reflects the moment in time that exchange rate was current.
	 *
	 */
	ZonedDateTime getValuationTimestamp();
	String getCustomBasketCode();
	List<? extends BasketConstituentsReport> getBasketConstituents();
	List<? extends OtherPayment> getOtherPayment();
	LegV1 getLeg1();
	LegV1 getLeg2();

	/*********************** Build Methods  ***********************/
	CriticalDataElementV1 build();
	
	CriticalDataElementV1.CriticalDataElementV1Builder toBuilder();
	
	static CriticalDataElementV1.CriticalDataElementV1Builder builder() {
		return new CriticalDataElementV1.CriticalDataElementV1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CriticalDataElementV1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CriticalDataElementV1> getType() {
		return CriticalDataElementV1.class;
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
		processRosetta(path.newSubPath("leg1"), processor, LegV1.class, getLeg1());
		processRosetta(path.newSubPath("leg2"), processor, LegV1.class, getLeg2());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CriticalDataElementV1Builder extends CriticalDataElementV1, RosettaModelObjectBuilder {
		PricePeriod.PricePeriodBuilder getOrCreatePriceSchedule(int index);
		@Override
		List<? extends PricePeriod.PricePeriodBuilder> getPriceSchedule();
		PricePeriod.PricePeriodBuilder getOrCreateStrikePriceSchedule(int index);
		@Override
		List<? extends PricePeriod.PricePeriodBuilder> getStrikePriceSchedule();
		PriceFormat.PriceFormatBuilder getOrCreatePrice();
		@Override
		PriceFormat.PriceFormatBuilder getPrice();
		PriceFormat.PriceFormatBuilder getOrCreatePackageTransactionPrice();
		@Override
		PriceFormat.PriceFormatBuilder getPackageTransactionPrice();
		PriceFormat.PriceFormatBuilder getOrCreatePackageTransactionSpread();
		@Override
		PriceFormat.PriceFormatBuilder getPackageTransactionSpread();
		PriceFormat.PriceFormatBuilder getOrCreateStrikePrice();
		@Override
		PriceFormat.PriceFormatBuilder getStrikePrice();
		BasketConstituentsReport.BasketConstituentsReportBuilder getOrCreateBasketConstituents(int index);
		@Override
		List<? extends BasketConstituentsReport.BasketConstituentsReportBuilder> getBasketConstituents();
		OtherPayment.OtherPaymentBuilder getOrCreateOtherPayment(int index);
		@Override
		List<? extends OtherPayment.OtherPaymentBuilder> getOtherPayment();
		LegV1.LegV1Builder getOrCreateLeg1();
		@Override
		LegV1.LegV1Builder getLeg1();
		LegV1.LegV1Builder getOrCreateLeg2();
		@Override
		LegV1.LegV1Builder getLeg2();
		CriticalDataElementV1.CriticalDataElementV1Builder setEffectiveDate(Date effectiveDate);
		CriticalDataElementV1.CriticalDataElementV1Builder setEarlyTerminationDate(Date earlyTerminationDate);
		CriticalDataElementV1.CriticalDataElementV1Builder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		CriticalDataElementV1.CriticalDataElementV1Builder setExecutionTimestamp(ZonedDateTime executionTimestamp);
		CriticalDataElementV1.CriticalDataElementV1Builder setExpirationDate(Date expirationDate);
		CriticalDataElementV1.CriticalDataElementV1Builder setCounterparty1(String counterparty1);
		CriticalDataElementV1.CriticalDataElementV1Builder setCounterparty2(String counterparty2);
		CriticalDataElementV1.CriticalDataElementV1Builder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		CriticalDataElementV1.CriticalDataElementV1Builder setBeneficiary1(String beneficiary1);
		CriticalDataElementV1.CriticalDataElementV1Builder setBeneficiary1IdentifierTypeIndicator(Boolean beneficiary1IdentifierTypeIndicator);
		CriticalDataElementV1.CriticalDataElementV1Builder setBuyerIdentifier(String buyerIdentifier);
		CriticalDataElementV1.CriticalDataElementV1Builder setSellerIdentifier(String sellerIdentifier);
		CriticalDataElementV1.CriticalDataElementV1Builder setCleared(ClearedEnum cleared);
		CriticalDataElementV1.CriticalDataElementV1Builder setCentralCounterparty(String centralCounterparty);
		CriticalDataElementV1.CriticalDataElementV1Builder setClearingMember(String clearingMember);
		CriticalDataElementV1.CriticalDataElementV1Builder setConfirmed(ConfirmationEnum confirmed);
		CriticalDataElementV1.CriticalDataElementV1Builder setCallAmount(BigDecimal callAmount);
		CriticalDataElementV1.CriticalDataElementV1Builder setPutAmount(BigDecimal putAmount);
		CriticalDataElementV1.CriticalDataElementV1Builder setCallCurrency(ISOCurrencyCodeEnum callCurrency);
		CriticalDataElementV1.CriticalDataElementV1Builder setPutCurrency(ISOCurrencyCodeEnum putCurrency);
		CriticalDataElementV1.CriticalDataElementV1Builder setDelta(BigDecimal delta);
		CriticalDataElementV1.CriticalDataElementV1Builder addPriceSchedule(PricePeriod priceSchedule);
		CriticalDataElementV1.CriticalDataElementV1Builder addPriceSchedule(PricePeriod priceSchedule, int idx);
		CriticalDataElementV1.CriticalDataElementV1Builder addPriceSchedule(List<? extends PricePeriod> priceSchedule);
		CriticalDataElementV1.CriticalDataElementV1Builder setPriceSchedule(List<? extends PricePeriod> priceSchedule);
		CriticalDataElementV1.CriticalDataElementV1Builder addStrikePriceSchedule(PricePeriod strikePriceSchedule);
		CriticalDataElementV1.CriticalDataElementV1Builder addStrikePriceSchedule(PricePeriod strikePriceSchedule, int idx);
		CriticalDataElementV1.CriticalDataElementV1Builder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		CriticalDataElementV1.CriticalDataElementV1Builder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		CriticalDataElementV1.CriticalDataElementV1Builder setPrice(PriceFormat price);
		CriticalDataElementV1.CriticalDataElementV1Builder setPriceNotation(PriceNotationEnum priceNotation);
		CriticalDataElementV1.CriticalDataElementV1Builder setPriceCurrency(ISOCurrencyCodeEnum priceCurrency);
		CriticalDataElementV1.CriticalDataElementV1Builder setPackageTransactionPrice(PriceFormat packageTransactionPrice);
		CriticalDataElementV1.CriticalDataElementV1Builder setPackageTransactionPriceNotation(PriceNotationEnum packageTransactionPriceNotation);
		CriticalDataElementV1.CriticalDataElementV1Builder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum packageTransactionPriceCurrency);
		CriticalDataElementV1.CriticalDataElementV1Builder setPackageTransactionSpread(PriceFormat packageTransactionSpread);
		CriticalDataElementV1.CriticalDataElementV1Builder setPackageTransactionSpreadNotation(PriceNotationEnum packageTransactionSpreadNotation);
		CriticalDataElementV1.CriticalDataElementV1Builder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum packageTransactionSpreadCurrency);
		CriticalDataElementV1.CriticalDataElementV1Builder setPackageIdentifier(String packageIdentifier);
		CriticalDataElementV1.CriticalDataElementV1Builder setStrikePrice(PriceFormat strikePrice);
		CriticalDataElementV1.CriticalDataElementV1Builder setStrikePriceNotation(PriceNotationEnum strikePriceNotation);
		CriticalDataElementV1.CriticalDataElementV1Builder setStrikePriceCurrency(String strikePriceCurrency);
		CriticalDataElementV1.CriticalDataElementV1Builder setPriceUnitOfMeasure(String priceUnitOfMeasure);
		CriticalDataElementV1.CriticalDataElementV1Builder setOptionPremiumAmount(BigDecimal optionPremiumAmount);
		CriticalDataElementV1.CriticalDataElementV1Builder setOptionPremiumCurrency(ISOCurrencyCodeEnum optionPremiumCurrency);
		CriticalDataElementV1.CriticalDataElementV1Builder setOptionPremiumPaymentDate(Date optionPremiumPaymentDate);
		CriticalDataElementV1.CriticalDataElementV1Builder setExchangeRate(BigDecimal exchangeRate);
		CriticalDataElementV1.CriticalDataElementV1Builder setExchangeRateBasis(String exchangeRateBasis);
		CriticalDataElementV1.CriticalDataElementV1Builder setCdSIndexAttachmentPoint(BigDecimal cdSIndexAttachmentPoint);
		CriticalDataElementV1.CriticalDataElementV1Builder setCdSIndexDetachmentPoint(BigDecimal cdSIndexDetachmentPoint);
		CriticalDataElementV1.CriticalDataElementV1Builder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		CriticalDataElementV1.CriticalDataElementV1Builder setFirstExerciseDate(Date firstExerciseDate);
		CriticalDataElementV1.CriticalDataElementV1Builder setFinalContractualSettlementDate(Date finalContractualSettlementDate);
		CriticalDataElementV1.CriticalDataElementV1Builder setSettlementLocation(ISOCountryCodeEnum settlementLocation);
		CriticalDataElementV1.CriticalDataElementV1Builder setPriorUTI(String priorUTI);
		CriticalDataElementV1.CriticalDataElementV1Builder setDirection1(Direction1Enum direction1);
		CriticalDataElementV1.CriticalDataElementV1Builder setValuationAmount(BigDecimal valuationAmount);
		CriticalDataElementV1.CriticalDataElementV1Builder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		CriticalDataElementV1.CriticalDataElementV1Builder setValuationMethod(ValuationType1Code valuationMethod);
		CriticalDataElementV1.CriticalDataElementV1Builder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		CriticalDataElementV1.CriticalDataElementV1Builder setCustomBasketCode(String customBasketCode);
		CriticalDataElementV1.CriticalDataElementV1Builder addBasketConstituents(BasketConstituentsReport basketConstituents);
		CriticalDataElementV1.CriticalDataElementV1Builder addBasketConstituents(BasketConstituentsReport basketConstituents, int idx);
		CriticalDataElementV1.CriticalDataElementV1Builder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		CriticalDataElementV1.CriticalDataElementV1Builder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		CriticalDataElementV1.CriticalDataElementV1Builder addOtherPayment(OtherPayment otherPayment);
		CriticalDataElementV1.CriticalDataElementV1Builder addOtherPayment(OtherPayment otherPayment, int idx);
		CriticalDataElementV1.CriticalDataElementV1Builder addOtherPayment(List<? extends OtherPayment> otherPayment);
		CriticalDataElementV1.CriticalDataElementV1Builder setOtherPayment(List<? extends OtherPayment> otherPayment);
		CriticalDataElementV1.CriticalDataElementV1Builder setLeg1(LegV1 leg1);
		CriticalDataElementV1.CriticalDataElementV1Builder setLeg2(LegV1 leg2);

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
			processRosetta(path.newSubPath("leg1"), processor, LegV1.LegV1Builder.class, getLeg1());
			processRosetta(path.newSubPath("leg2"), processor, LegV1.LegV1Builder.class, getLeg2());
		}
		

		CriticalDataElementV1.CriticalDataElementV1Builder prune();
	}

	/*********************** Immutable Implementation of CriticalDataElementV1  ***********************/
	class CriticalDataElementV1Impl implements CriticalDataElementV1 {
		private final Date effectiveDate;
		private final Date earlyTerminationDate;
		private final ZonedDateTime reportingTimestamp;
		private final ZonedDateTime executionTimestamp;
		private final Date expirationDate;
		private final String counterparty1;
		private final String counterparty2;
		private final Boolean counterparty2IdentifierType;
		private final String beneficiary1;
		private final Boolean beneficiary1IdentifierTypeIndicator;
		private final String buyerIdentifier;
		private final String sellerIdentifier;
		private final ClearedEnum cleared;
		private final String centralCounterparty;
		private final String clearingMember;
		private final ConfirmationEnum confirmed;
		private final BigDecimal callAmount;
		private final BigDecimal putAmount;
		private final ISOCurrencyCodeEnum callCurrency;
		private final ISOCurrencyCodeEnum putCurrency;
		private final BigDecimal delta;
		private final List<? extends PricePeriod> priceSchedule;
		private final List<? extends PricePeriod> strikePriceSchedule;
		private final PriceFormat price;
		private final PriceNotationEnum priceNotation;
		private final ISOCurrencyCodeEnum priceCurrency;
		private final PriceFormat packageTransactionPrice;
		private final PriceNotationEnum packageTransactionPriceNotation;
		private final ISOCurrencyCodeEnum packageTransactionPriceCurrency;
		private final PriceFormat packageTransactionSpread;
		private final PriceNotationEnum packageTransactionSpreadNotation;
		private final ISOCurrencyCodeEnum packageTransactionSpreadCurrency;
		private final String packageIdentifier;
		private final PriceFormat strikePrice;
		private final PriceNotationEnum strikePriceNotation;
		private final String strikePriceCurrency;
		private final String priceUnitOfMeasure;
		private final BigDecimal optionPremiumAmount;
		private final ISOCurrencyCodeEnum optionPremiumCurrency;
		private final Date optionPremiumPaymentDate;
		private final BigDecimal exchangeRate;
		private final String exchangeRateBasis;
		private final BigDecimal cdSIndexAttachmentPoint;
		private final BigDecimal cdSIndexDetachmentPoint;
		private final Boolean collateralPortfolioIndicator;
		private final Date firstExerciseDate;
		private final Date finalContractualSettlementDate;
		private final ISOCountryCodeEnum settlementLocation;
		private final String priorUTI;
		private final Direction1Enum direction1;
		private final BigDecimal valuationAmount;
		private final ISOCurrencyCodeEnum valuationCurrency;
		private final ValuationType1Code valuationMethod;
		private final ZonedDateTime valuationTimestamp;
		private final String customBasketCode;
		private final List<? extends BasketConstituentsReport> basketConstituents;
		private final List<? extends OtherPayment> otherPayment;
		private final LegV1 leg1;
		private final LegV1 leg2;
		
		protected CriticalDataElementV1Impl(CriticalDataElementV1.CriticalDataElementV1Builder builder) {
			this.effectiveDate = builder.getEffectiveDate();
			this.earlyTerminationDate = builder.getEarlyTerminationDate();
			this.reportingTimestamp = builder.getReportingTimestamp();
			this.executionTimestamp = builder.getExecutionTimestamp();
			this.expirationDate = builder.getExpirationDate();
			this.counterparty1 = builder.getCounterparty1();
			this.counterparty2 = builder.getCounterparty2();
			this.counterparty2IdentifierType = builder.getCounterparty2IdentifierType();
			this.beneficiary1 = builder.getBeneficiary1();
			this.beneficiary1IdentifierTypeIndicator = builder.getBeneficiary1IdentifierTypeIndicator();
			this.buyerIdentifier = builder.getBuyerIdentifier();
			this.sellerIdentifier = builder.getSellerIdentifier();
			this.cleared = builder.getCleared();
			this.centralCounterparty = builder.getCentralCounterparty();
			this.clearingMember = builder.getClearingMember();
			this.confirmed = builder.getConfirmed();
			this.callAmount = builder.getCallAmount();
			this.putAmount = builder.getPutAmount();
			this.callCurrency = builder.getCallCurrency();
			this.putCurrency = builder.getPutCurrency();
			this.delta = builder.getDelta();
			this.priceSchedule = ofNullable(builder.getPriceSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.strikePriceSchedule = ofNullable(builder.getStrikePriceSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.price = ofNullable(builder.getPrice()).map(f->f.build()).orElse(null);
			this.priceNotation = builder.getPriceNotation();
			this.priceCurrency = builder.getPriceCurrency();
			this.packageTransactionPrice = ofNullable(builder.getPackageTransactionPrice()).map(f->f.build()).orElse(null);
			this.packageTransactionPriceNotation = builder.getPackageTransactionPriceNotation();
			this.packageTransactionPriceCurrency = builder.getPackageTransactionPriceCurrency();
			this.packageTransactionSpread = ofNullable(builder.getPackageTransactionSpread()).map(f->f.build()).orElse(null);
			this.packageTransactionSpreadNotation = builder.getPackageTransactionSpreadNotation();
			this.packageTransactionSpreadCurrency = builder.getPackageTransactionSpreadCurrency();
			this.packageIdentifier = builder.getPackageIdentifier();
			this.strikePrice = ofNullable(builder.getStrikePrice()).map(f->f.build()).orElse(null);
			this.strikePriceNotation = builder.getStrikePriceNotation();
			this.strikePriceCurrency = builder.getStrikePriceCurrency();
			this.priceUnitOfMeasure = builder.getPriceUnitOfMeasure();
			this.optionPremiumAmount = builder.getOptionPremiumAmount();
			this.optionPremiumCurrency = builder.getOptionPremiumCurrency();
			this.optionPremiumPaymentDate = builder.getOptionPremiumPaymentDate();
			this.exchangeRate = builder.getExchangeRate();
			this.exchangeRateBasis = builder.getExchangeRateBasis();
			this.cdSIndexAttachmentPoint = builder.getCdSIndexAttachmentPoint();
			this.cdSIndexDetachmentPoint = builder.getCdSIndexDetachmentPoint();
			this.collateralPortfolioIndicator = builder.getCollateralPortfolioIndicator();
			this.firstExerciseDate = builder.getFirstExerciseDate();
			this.finalContractualSettlementDate = builder.getFinalContractualSettlementDate();
			this.settlementLocation = builder.getSettlementLocation();
			this.priorUTI = builder.getPriorUTI();
			this.direction1 = builder.getDirection1();
			this.valuationAmount = builder.getValuationAmount();
			this.valuationCurrency = builder.getValuationCurrency();
			this.valuationMethod = builder.getValuationMethod();
			this.valuationTimestamp = builder.getValuationTimestamp();
			this.customBasketCode = builder.getCustomBasketCode();
			this.basketConstituents = ofNullable(builder.getBasketConstituents()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.otherPayment = ofNullable(builder.getOtherPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.leg1 = ofNullable(builder.getLeg1()).map(f->f.build()).orElse(null);
			this.leg2 = ofNullable(builder.getLeg2()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
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
		public List<? extends PricePeriod> getPriceSchedule() {
			return priceSchedule;
		}
		
		@Override
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		public List<? extends PricePeriod> getStrikePriceSchedule() {
			return strikePriceSchedule;
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public PriceFormat getPrice() {
			return price;
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
		public PriceFormat getPackageTransactionPrice() {
			return packageTransactionPrice;
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
		public PriceFormat getPackageTransactionSpread() {
			return packageTransactionSpread;
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
		public PriceFormat getStrikePrice() {
			return strikePrice;
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
		public List<? extends BasketConstituentsReport> getBasketConstituents() {
			return basketConstituents;
		}
		
		@Override
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPayment")
		public List<? extends OtherPayment> getOtherPayment() {
			return otherPayment;
		}
		
		@Override
		@RosettaAttribute("leg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg1")
		public LegV1 getLeg1() {
			return leg1;
		}
		
		@Override
		@RosettaAttribute("leg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg2")
		public LegV1 getLeg2() {
			return leg2;
		}
		
		@Override
		public CriticalDataElementV1 build() {
			return this;
		}
		
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder toBuilder() {
			CriticalDataElementV1.CriticalDataElementV1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CriticalDataElementV1.CriticalDataElementV1Builder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getEarlyTerminationDate()).ifPresent(builder::setEarlyTerminationDate);
			ofNullable(getReportingTimestamp()).ifPresent(builder::setReportingTimestamp);
			ofNullable(getExecutionTimestamp()).ifPresent(builder::setExecutionTimestamp);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getCounterparty1()).ifPresent(builder::setCounterparty1);
			ofNullable(getCounterparty2()).ifPresent(builder::setCounterparty2);
			ofNullable(getCounterparty2IdentifierType()).ifPresent(builder::setCounterparty2IdentifierType);
			ofNullable(getBeneficiary1()).ifPresent(builder::setBeneficiary1);
			ofNullable(getBeneficiary1IdentifierTypeIndicator()).ifPresent(builder::setBeneficiary1IdentifierTypeIndicator);
			ofNullable(getBuyerIdentifier()).ifPresent(builder::setBuyerIdentifier);
			ofNullable(getSellerIdentifier()).ifPresent(builder::setSellerIdentifier);
			ofNullable(getCleared()).ifPresent(builder::setCleared);
			ofNullable(getCentralCounterparty()).ifPresent(builder::setCentralCounterparty);
			ofNullable(getClearingMember()).ifPresent(builder::setClearingMember);
			ofNullable(getConfirmed()).ifPresent(builder::setConfirmed);
			ofNullable(getCallAmount()).ifPresent(builder::setCallAmount);
			ofNullable(getPutAmount()).ifPresent(builder::setPutAmount);
			ofNullable(getCallCurrency()).ifPresent(builder::setCallCurrency);
			ofNullable(getPutCurrency()).ifPresent(builder::setPutCurrency);
			ofNullable(getDelta()).ifPresent(builder::setDelta);
			ofNullable(getPriceSchedule()).ifPresent(builder::setPriceSchedule);
			ofNullable(getStrikePriceSchedule()).ifPresent(builder::setStrikePriceSchedule);
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getPriceNotation()).ifPresent(builder::setPriceNotation);
			ofNullable(getPriceCurrency()).ifPresent(builder::setPriceCurrency);
			ofNullable(getPackageTransactionPrice()).ifPresent(builder::setPackageTransactionPrice);
			ofNullable(getPackageTransactionPriceNotation()).ifPresent(builder::setPackageTransactionPriceNotation);
			ofNullable(getPackageTransactionPriceCurrency()).ifPresent(builder::setPackageTransactionPriceCurrency);
			ofNullable(getPackageTransactionSpread()).ifPresent(builder::setPackageTransactionSpread);
			ofNullable(getPackageTransactionSpreadNotation()).ifPresent(builder::setPackageTransactionSpreadNotation);
			ofNullable(getPackageTransactionSpreadCurrency()).ifPresent(builder::setPackageTransactionSpreadCurrency);
			ofNullable(getPackageIdentifier()).ifPresent(builder::setPackageIdentifier);
			ofNullable(getStrikePrice()).ifPresent(builder::setStrikePrice);
			ofNullable(getStrikePriceNotation()).ifPresent(builder::setStrikePriceNotation);
			ofNullable(getStrikePriceCurrency()).ifPresent(builder::setStrikePriceCurrency);
			ofNullable(getPriceUnitOfMeasure()).ifPresent(builder::setPriceUnitOfMeasure);
			ofNullable(getOptionPremiumAmount()).ifPresent(builder::setOptionPremiumAmount);
			ofNullable(getOptionPremiumCurrency()).ifPresent(builder::setOptionPremiumCurrency);
			ofNullable(getOptionPremiumPaymentDate()).ifPresent(builder::setOptionPremiumPaymentDate);
			ofNullable(getExchangeRate()).ifPresent(builder::setExchangeRate);
			ofNullable(getExchangeRateBasis()).ifPresent(builder::setExchangeRateBasis);
			ofNullable(getCdSIndexAttachmentPoint()).ifPresent(builder::setCdSIndexAttachmentPoint);
			ofNullable(getCdSIndexDetachmentPoint()).ifPresent(builder::setCdSIndexDetachmentPoint);
			ofNullable(getCollateralPortfolioIndicator()).ifPresent(builder::setCollateralPortfolioIndicator);
			ofNullable(getFirstExerciseDate()).ifPresent(builder::setFirstExerciseDate);
			ofNullable(getFinalContractualSettlementDate()).ifPresent(builder::setFinalContractualSettlementDate);
			ofNullable(getSettlementLocation()).ifPresent(builder::setSettlementLocation);
			ofNullable(getPriorUTI()).ifPresent(builder::setPriorUTI);
			ofNullable(getDirection1()).ifPresent(builder::setDirection1);
			ofNullable(getValuationAmount()).ifPresent(builder::setValuationAmount);
			ofNullable(getValuationCurrency()).ifPresent(builder::setValuationCurrency);
			ofNullable(getValuationMethod()).ifPresent(builder::setValuationMethod);
			ofNullable(getValuationTimestamp()).ifPresent(builder::setValuationTimestamp);
			ofNullable(getCustomBasketCode()).ifPresent(builder::setCustomBasketCode);
			ofNullable(getBasketConstituents()).ifPresent(builder::setBasketConstituents);
			ofNullable(getOtherPayment()).ifPresent(builder::setOtherPayment);
			ofNullable(getLeg1()).ifPresent(builder::setLeg1);
			ofNullable(getLeg2()).ifPresent(builder::setLeg2);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CriticalDataElementV1 _that = getType().cast(o);
		
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
			return _result;
		}
		
		@Override
		public String toString() {
			return "CriticalDataElementV1 {" +
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
				"leg2=" + this.leg2 +
			'}';
		}
	}

	/*********************** Builder Implementation of CriticalDataElementV1  ***********************/
	class CriticalDataElementV1BuilderImpl implements CriticalDataElementV1.CriticalDataElementV1Builder {
	
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
		protected LegV1.LegV1Builder leg1;
		protected LegV1.LegV1Builder leg2;
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
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
		public LegV1.LegV1Builder getLeg1() {
			return leg1;
		}
		
		@Override
		public LegV1.LegV1Builder getOrCreateLeg1() {
			LegV1.LegV1Builder result;
			if (leg1!=null) {
				result = leg1;
			}
			else {
				result = leg1 = LegV1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("leg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg2")
		public LegV1.LegV1Builder getLeg2() {
			return leg2;
		}
		
		@Override
		public LegV1.LegV1Builder getOrCreateLeg2() {
			LegV1.LegV1Builder result;
			if (leg2!=null) {
				result = leg2;
			}
			else {
				result = leg2 = LegV1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setEffectiveDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTerminationDate")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setEarlyTerminationDate(Date _earlyTerminationDate) {
			this.earlyTerminationDate = _earlyTerminationDate == null ? null : _earlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionTimestamp")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setExecutionTimestamp(ZonedDateTime _executionTimestamp) {
			this.executionTimestamp = _executionTimestamp == null ? null : _executionTimestamp;
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setExpirationDate(Date _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("beneficiary1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setBeneficiary1(String _beneficiary1) {
			this.beneficiary1 = _beneficiary1 == null ? null : _beneficiary1;
			return this;
		}
		
		@RosettaAttribute("beneficiary1IdentifierTypeIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1IdentifierTypeIndicator")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setBeneficiary1IdentifierTypeIndicator(Boolean _beneficiary1IdentifierTypeIndicator) {
			this.beneficiary1IdentifierTypeIndicator = _beneficiary1IdentifierTypeIndicator == null ? null : _beneficiary1IdentifierTypeIndicator;
			return this;
		}
		
		@RosettaAttribute("buyerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerIdentifier")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setBuyerIdentifier(String _buyerIdentifier) {
			this.buyerIdentifier = _buyerIdentifier == null ? null : _buyerIdentifier;
			return this;
		}
		
		@RosettaAttribute("sellerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerIdentifier")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setSellerIdentifier(String _sellerIdentifier) {
			this.sellerIdentifier = _sellerIdentifier == null ? null : _sellerIdentifier;
			return this;
		}
		
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cleared")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setCleared(ClearedEnum _cleared) {
			this.cleared = _cleared == null ? null : _cleared;
			return this;
		}
		
		@RosettaAttribute("centralCounterparty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("centralCounterparty")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setCentralCounterparty(String _centralCounterparty) {
			this.centralCounterparty = _centralCounterparty == null ? null : _centralCounterparty;
			return this;
		}
		
		@RosettaAttribute("clearingMember")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingMember")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setClearingMember(String _clearingMember) {
			this.clearingMember = _clearingMember == null ? null : _clearingMember;
			return this;
		}
		
		@RosettaAttribute("confirmed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmed")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setConfirmed(ConfirmationEnum _confirmed) {
			this.confirmed = _confirmed == null ? null : _confirmed;
			return this;
		}
		
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callAmount")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setCallAmount(BigDecimal _callAmount) {
			this.callAmount = _callAmount == null ? null : _callAmount;
			return this;
		}
		
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putAmount")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setPutAmount(BigDecimal _putAmount) {
			this.putAmount = _putAmount == null ? null : _putAmount;
			return this;
		}
		
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callCurrency")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setCallCurrency(ISOCurrencyCodeEnum _callCurrency) {
			this.callCurrency = _callCurrency == null ? null : _callCurrency;
			return this;
		}
		
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putCurrency")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setPutCurrency(ISOCurrencyCodeEnum _putCurrency) {
			this.putCurrency = _putCurrency == null ? null : _putCurrency;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("priceSchedule")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder addPriceSchedule(PricePeriod _priceSchedule) {
			if (_priceSchedule != null) {
				this.priceSchedule.add(_priceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder addPriceSchedule(PricePeriod _priceSchedule, int idx) {
			getIndex(this.priceSchedule, idx, () -> _priceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder addPriceSchedule(List<? extends PricePeriod> priceSchedules) {
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
		public CriticalDataElementV1.CriticalDataElementV1Builder setPriceSchedule(List<? extends PricePeriod> priceSchedules) {
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
		public CriticalDataElementV1.CriticalDataElementV1Builder addStrikePriceSchedule(PricePeriod _strikePriceSchedule) {
			if (_strikePriceSchedule != null) {
				this.strikePriceSchedule.add(_strikePriceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder addStrikePriceSchedule(PricePeriod _strikePriceSchedule, int idx) {
			getIndex(this.strikePriceSchedule, idx, () -> _strikePriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
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
		public CriticalDataElementV1.CriticalDataElementV1Builder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
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
		public CriticalDataElementV1.CriticalDataElementV1Builder setPrice(PriceFormat _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceNotation")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setPriceNotation(PriceNotationEnum _priceNotation) {
			this.priceNotation = _priceNotation == null ? null : _priceNotation;
			return this;
		}
		
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceCurrency")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setPriceCurrency(ISOCurrencyCodeEnum _priceCurrency) {
			this.priceCurrency = _priceCurrency == null ? null : _priceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPrice")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setPackageTransactionPrice(PriceFormat _packageTransactionPrice) {
			this.packageTransactionPrice = _packageTransactionPrice == null ? null : _packageTransactionPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceNotation")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setPackageTransactionPriceNotation(PriceNotationEnum _packageTransactionPriceNotation) {
			this.packageTransactionPriceNotation = _packageTransactionPriceNotation == null ? null : _packageTransactionPriceNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceCurrency")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum _packageTransactionPriceCurrency) {
			this.packageTransactionPriceCurrency = _packageTransactionPriceCurrency == null ? null : _packageTransactionPriceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpread")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setPackageTransactionSpread(PriceFormat _packageTransactionSpread) {
			this.packageTransactionSpread = _packageTransactionSpread == null ? null : _packageTransactionSpread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadNotation")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setPackageTransactionSpreadNotation(PriceNotationEnum _packageTransactionSpreadNotation) {
			this.packageTransactionSpreadNotation = _packageTransactionSpreadNotation == null ? null : _packageTransactionSpreadNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadCurrency")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum _packageTransactionSpreadCurrency) {
			this.packageTransactionSpreadCurrency = _packageTransactionSpreadCurrency == null ? null : _packageTransactionSpreadCurrency;
			return this;
		}
		
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIdentifier")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setPackageIdentifier(String _packageIdentifier) {
			this.packageIdentifier = _packageIdentifier == null ? null : _packageIdentifier;
			return this;
		}
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePrice")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setStrikePrice(PriceFormat _strikePrice) {
			this.strikePrice = _strikePrice == null ? null : _strikePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceNotation")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setStrikePriceNotation(PriceNotationEnum _strikePriceNotation) {
			this.strikePriceNotation = _strikePriceNotation == null ? null : _strikePriceNotation;
			return this;
		}
		
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceCurrency")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setStrikePriceCurrency(String _strikePriceCurrency) {
			this.strikePriceCurrency = _strikePriceCurrency == null ? null : _strikePriceCurrency;
			return this;
		}
		
		@RosettaAttribute("priceUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceUnitOfMeasure")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setPriceUnitOfMeasure(String _priceUnitOfMeasure) {
			this.priceUnitOfMeasure = _priceUnitOfMeasure == null ? null : _priceUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("optionPremiumAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumAmount")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setOptionPremiumAmount(BigDecimal _optionPremiumAmount) {
			this.optionPremiumAmount = _optionPremiumAmount == null ? null : _optionPremiumAmount;
			return this;
		}
		
		@RosettaAttribute("optionPremiumCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumCurrency")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setOptionPremiumCurrency(ISOCurrencyCodeEnum _optionPremiumCurrency) {
			this.optionPremiumCurrency = _optionPremiumCurrency == null ? null : _optionPremiumCurrency;
			return this;
		}
		
		@RosettaAttribute("optionPremiumPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumPaymentDate")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setOptionPremiumPaymentDate(Date _optionPremiumPaymentDate) {
			this.optionPremiumPaymentDate = _optionPremiumPaymentDate == null ? null : _optionPremiumPaymentDate;
			return this;
		}
		
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRate")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setExchangeRate(BigDecimal _exchangeRate) {
			this.exchangeRate = _exchangeRate == null ? null : _exchangeRate;
			return this;
		}
		
		@RosettaAttribute("exchangeRateBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRateBasis")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setExchangeRateBasis(String _exchangeRateBasis) {
			this.exchangeRateBasis = _exchangeRateBasis == null ? null : _exchangeRateBasis;
			return this;
		}
		
		@RosettaAttribute("cdSIndexAttachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexAttachmentPoint")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setCdSIndexAttachmentPoint(BigDecimal _cdSIndexAttachmentPoint) {
			this.cdSIndexAttachmentPoint = _cdSIndexAttachmentPoint == null ? null : _cdSIndexAttachmentPoint;
			return this;
		}
		
		@RosettaAttribute("cdSIndexDetachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexDetachmentPoint")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setCdSIndexDetachmentPoint(BigDecimal _cdSIndexDetachmentPoint) {
			this.cdSIndexDetachmentPoint = _cdSIndexDetachmentPoint == null ? null : _cdSIndexDetachmentPoint;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstExerciseDate")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setFirstExerciseDate(Date _firstExerciseDate) {
			this.firstExerciseDate = _firstExerciseDate == null ? null : _firstExerciseDate;
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setFinalContractualSettlementDate(Date _finalContractualSettlementDate) {
			this.finalContractualSettlementDate = _finalContractualSettlementDate == null ? null : _finalContractualSettlementDate;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setSettlementLocation(ISOCountryCodeEnum _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation;
			return this;
		}
		
		@RosettaAttribute("priorUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTI")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setPriorUTI(String _priorUTI) {
			this.priorUTI = _priorUTI == null ? null : _priorUTI;
			return this;
		}
		
		@RosettaAttribute("direction1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction1")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setDirection1(Direction1Enum _direction1) {
			this.direction1 = _direction1 == null ? null : _direction1;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationAmount")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationCurrency")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationMethod")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationTimestamp")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketCode")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setCustomBasketCode(String _customBasketCode) {
			this.customBasketCode = _customBasketCode == null ? null : _customBasketCode;
			return this;
		}
		
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketConstituents")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder addBasketConstituents(BasketConstituentsReport _basketConstituents) {
			if (_basketConstituents != null) {
				this.basketConstituents.add(_basketConstituents.toBuilder());
			}
			return this;
		}
		
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder addBasketConstituents(BasketConstituentsReport _basketConstituents, int idx) {
			getIndex(this.basketConstituents, idx, () -> _basketConstituents.toBuilder());
			return this;
		}
		
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
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
		public CriticalDataElementV1.CriticalDataElementV1Builder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
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
		public CriticalDataElementV1.CriticalDataElementV1Builder addOtherPayment(OtherPayment _otherPayment) {
			if (_otherPayment != null) {
				this.otherPayment.add(_otherPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder addOtherPayment(OtherPayment _otherPayment, int idx) {
			getIndex(this.otherPayment, idx, () -> _otherPayment.toBuilder());
			return this;
		}
		
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder addOtherPayment(List<? extends OtherPayment> otherPayments) {
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
		public CriticalDataElementV1.CriticalDataElementV1Builder setOtherPayment(List<? extends OtherPayment> otherPayments) {
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
		public CriticalDataElementV1.CriticalDataElementV1Builder setLeg1(LegV1 _leg1) {
			this.leg1 = _leg1 == null ? null : _leg1.toBuilder();
			return this;
		}
		
		@RosettaAttribute("leg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg2")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder setLeg2(LegV1 _leg2) {
			this.leg2 = _leg2 == null ? null : _leg2.toBuilder();
			return this;
		}
		
		@Override
		public CriticalDataElementV1 build() {
			return new CriticalDataElementV1.CriticalDataElementV1Impl(this);
		}
		
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder prune() {
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
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CriticalDataElementV1.CriticalDataElementV1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CriticalDataElementV1.CriticalDataElementV1Builder o = (CriticalDataElementV1.CriticalDataElementV1Builder) other;
			
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
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getEarlyTerminationDate(), o.getEarlyTerminationDate(), this::setEarlyTerminationDate);
			merger.mergeBasic(getReportingTimestamp(), o.getReportingTimestamp(), this::setReportingTimestamp);
			merger.mergeBasic(getExecutionTimestamp(), o.getExecutionTimestamp(), this::setExecutionTimestamp);
			merger.mergeBasic(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeBasic(getCounterparty1(), o.getCounterparty1(), this::setCounterparty1);
			merger.mergeBasic(getCounterparty2(), o.getCounterparty2(), this::setCounterparty2);
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierType);
			merger.mergeBasic(getBeneficiary1(), o.getBeneficiary1(), this::setBeneficiary1);
			merger.mergeBasic(getBeneficiary1IdentifierTypeIndicator(), o.getBeneficiary1IdentifierTypeIndicator(), this::setBeneficiary1IdentifierTypeIndicator);
			merger.mergeBasic(getBuyerIdentifier(), o.getBuyerIdentifier(), this::setBuyerIdentifier);
			merger.mergeBasic(getSellerIdentifier(), o.getSellerIdentifier(), this::setSellerIdentifier);
			merger.mergeBasic(getCleared(), o.getCleared(), this::setCleared);
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
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CriticalDataElementV1 _that = getType().cast(o);
		
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
			return _result;
		}
		
		@Override
		public String toString() {
			return "CriticalDataElementV1Builder {" +
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
				"leg2=" + this.leg2 +
			'}';
		}
	}
}

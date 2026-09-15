package fpml.consolidated.eq.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.eq.shared.meta.DividendConditionsMeta;
import fpml.consolidated.fpmlenum.DividendAmountTypeEnum;
import fpml.consolidated.fpmlenum.DividendCompositionEnum;
import fpml.consolidated.fpmlenum.DividendEntitlementEnum;
import fpml.consolidated.fpmlenum.DividendPeriodEnum;
import fpml.consolidated.fpmlenum.NonCashDividendTreatmentEnum;
import fpml.consolidated.shared.DateReference;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.IdentifiedCurrencyReference;
import fpml.consolidated.shared.InterestAccrualsCompoundingMethod;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the conditions governing the payment of dividends to the receiver of the equity return. With the exception of the dividend payout ratio, which is defined for each of the underlying components.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the conditions governing the payment of dividends to the receiver of the equity return. With the exception of the dividend payout ratio, which is defined for each of the underlying components.
 *
 */
@RosettaDataType(value="DividendConditions", builder=DividendConditions.DividendConditionsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DividendConditions", model="fpml", builder=DividendConditions.DividendConditionsBuilderImpl.class, version="2.1.1")
public interface DividendConditions extends RosettaModelObject {

	DividendConditionsMeta metaData = new DividendConditionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Boolean element that defines whether the dividend will be reinvested or not.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Boolean element that defines whether the dividend will be reinvested or not.
	 *
	 */
	Boolean getDividendReinvestment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the date on which the receiver on the equity return is entitled to the dividend.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the date on which the receiver on the equity return is entitled to the dividend.
	 *
	 */
	DividendEntitlementEnum getDividendEntitlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	DividendAmountTypeEnum getDividendAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies when the dividend will be paid to the receiver of the equity return. Has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. Is not applicable in the case of a dividend reinvestment election.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies when the dividend will be paid to the receiver of the equity return. Has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. Is not applicable in the case of a dividend reinvestment election.
	 *
	 */
	DividendPaymentDate getDividendPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Dividend period has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. This element specifies the date on which the dividend period will commence.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Dividend period has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. This element specifies the date on which the dividend period will commence.
	 *
	 */
	DateReference getDividendPeriodEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Dividend period has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. This element specifies the date on which the dividend period will end. It includes a boolean attribute for defining whether this end date is included or excluded from the dividend period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Dividend period has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. This element specifies the date on which the dividend period will end. It includes a boolean attribute for defining whether this end date is included or excluded from the dividend period.
	 *
	 */
	DateReference getDividendPeriodEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the First Period or the Second Period, as defined in the 2002 ISDA Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the First Period or the Second Period, as defined in the 2002 ISDA Equity Derivatives Definitions.
	 *
	 */
	DividendPeriodEnum getDividendPeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to the party which determines if dividends are extraordinary in relation to normal levels.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the party which determines if dividends are extraordinary in relation to normal levels.
	 *
	 */
	PartyReference getExtraOrdinaryDividends();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Determination of Gross Cash Dividend per Share.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Determination of Gross Cash Dividend per Share.
	 *
	 */
	DividendAmountTypeEnum getExcessDividendAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 */
	IdentifiedCurrency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the method according to which an amount or a date is determined.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the method according to which an amount or a date is determined.
	 *
	 */
	DeterminationMethod getDeterminationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a currency defined elsewhere in the document
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a currency defined elsewhere in the document
	 *
	 */
	IdentifiedCurrencyReference getCurrencyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the date on which the FX rate will be considered in the case of a Composite FX swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the date on which the FX rate will be considered in the case of a Composite FX swap.
	 *
	 */
	DividendPaymentDate getDividendFxTriggerDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the way in which interests are accrued: the applicable rate (fixed or floating reference) and the compounding method. FpML entity
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the way in which interests are accrued: the applicable rate (fixed or floating reference) and the compounding method. FpML entity
	 *
	 */
	InterestAccrualsCompoundingMethod getInterestAccrualsMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the Number Of Index Units applicable to a Dividend.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the Number Of Index Units applicable to a Dividend.
	 *
	 */
	BigDecimal getNumberOfIndexUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Declared Cash Dividend Percentage. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Declared Cash Dividend Percentage. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getDeclaredCashDividendPercentage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Declared Cash Equivalent Dividend Percentage. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Declared Cash Equivalent Dividend Percentage. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getDeclaredCashEquivalentDividendPercentage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines treatment of Non-Cash Dividends.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines treatment of Non-Cash Dividends.
	 *
	 */
	NonCashDividendTreatmentEnum getNonCashDividendTreatment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines how the composition of Dividends is to be determined.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines how the composition of Dividends is to be determined.
	 *
	 */
	DividendCompositionEnum getDividendComposition();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the method according to which special dividends are determined.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the method according to which special dividends are determined.
	 *
	 */
	Boolean getSpecialDividends();

	/*********************** Build Methods  ***********************/
	DividendConditions build();
	
	DividendConditions.DividendConditionsBuilder toBuilder();
	
	static DividendConditions.DividendConditionsBuilder builder() {
		return new DividendConditions.DividendConditionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendConditions> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DividendConditions> getType() {
		return DividendConditions.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dividendReinvestment"), Boolean.class, getDividendReinvestment(), this);
		processor.processBasic(path.newSubPath("dividendEntitlement"), DividendEntitlementEnum.class, getDividendEntitlement(), this);
		processor.processBasic(path.newSubPath("dividendAmount"), DividendAmountTypeEnum.class, getDividendAmount(), this);
		processRosetta(path.newSubPath("dividendPaymentDate"), processor, DividendPaymentDate.class, getDividendPaymentDate());
		processRosetta(path.newSubPath("dividendPeriodEffectiveDate"), processor, DateReference.class, getDividendPeriodEffectiveDate());
		processRosetta(path.newSubPath("dividendPeriodEndDate"), processor, DateReference.class, getDividendPeriodEndDate());
		processor.processBasic(path.newSubPath("dividendPeriod"), DividendPeriodEnum.class, getDividendPeriod(), this);
		processRosetta(path.newSubPath("extraOrdinaryDividends"), processor, PartyReference.class, getExtraOrdinaryDividends());
		processor.processBasic(path.newSubPath("excessDividendAmount"), DividendAmountTypeEnum.class, getExcessDividendAmount(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.class, getDeterminationMethod());
		processRosetta(path.newSubPath("currencyReference"), processor, IdentifiedCurrencyReference.class, getCurrencyReference());
		processRosetta(path.newSubPath("dividendFxTriggerDate"), processor, DividendPaymentDate.class, getDividendFxTriggerDate());
		processRosetta(path.newSubPath("interestAccrualsMethod"), processor, InterestAccrualsCompoundingMethod.class, getInterestAccrualsMethod());
		processor.processBasic(path.newSubPath("numberOfIndexUnits"), BigDecimal.class, getNumberOfIndexUnits(), this);
		processor.processBasic(path.newSubPath("declaredCashDividendPercentage"), BigDecimal.class, getDeclaredCashDividendPercentage(), this);
		processor.processBasic(path.newSubPath("declaredCashEquivalentDividendPercentage"), BigDecimal.class, getDeclaredCashEquivalentDividendPercentage(), this);
		processor.processBasic(path.newSubPath("nonCashDividendTreatment"), NonCashDividendTreatmentEnum.class, getNonCashDividendTreatment(), this);
		processor.processBasic(path.newSubPath("dividendComposition"), DividendCompositionEnum.class, getDividendComposition(), this);
		processor.processBasic(path.newSubPath("specialDividends"), Boolean.class, getSpecialDividends(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendConditionsBuilder extends DividendConditions, RosettaModelObjectBuilder {
		DividendPaymentDate.DividendPaymentDateBuilder getOrCreateDividendPaymentDate();
		@Override
		DividendPaymentDate.DividendPaymentDateBuilder getDividendPaymentDate();
		DateReference.DateReferenceBuilder getOrCreateDividendPeriodEffectiveDate();
		@Override
		DateReference.DateReferenceBuilder getDividendPeriodEffectiveDate();
		DateReference.DateReferenceBuilder getOrCreateDividendPeriodEndDate();
		@Override
		DateReference.DateReferenceBuilder getDividendPeriodEndDate();
		PartyReference.PartyReferenceBuilder getOrCreateExtraOrdinaryDividends();
		@Override
		PartyReference.PartyReferenceBuilder getExtraOrdinaryDividends();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateCurrency();
		@Override
		IdentifiedCurrency.IdentifiedCurrencyBuilder getCurrency();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod();
		@Override
		DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod();
		IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder getOrCreateCurrencyReference();
		@Override
		IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder getCurrencyReference();
		DividendPaymentDate.DividendPaymentDateBuilder getOrCreateDividendFxTriggerDate();
		@Override
		DividendPaymentDate.DividendPaymentDateBuilder getDividendFxTriggerDate();
		InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder getOrCreateInterestAccrualsMethod();
		@Override
		InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder getInterestAccrualsMethod();
		DividendConditions.DividendConditionsBuilder setDividendReinvestment(Boolean dividendReinvestment);
		DividendConditions.DividendConditionsBuilder setDividendEntitlement(DividendEntitlementEnum dividendEntitlement);
		DividendConditions.DividendConditionsBuilder setDividendAmount(DividendAmountTypeEnum dividendAmount);
		DividendConditions.DividendConditionsBuilder setDividendPaymentDate(DividendPaymentDate dividendPaymentDate);
		DividendConditions.DividendConditionsBuilder setDividendPeriodEffectiveDate(DateReference dividendPeriodEffectiveDate);
		DividendConditions.DividendConditionsBuilder setDividendPeriodEndDate(DateReference dividendPeriodEndDate);
		DividendConditions.DividendConditionsBuilder setDividendPeriod(DividendPeriodEnum dividendPeriod);
		DividendConditions.DividendConditionsBuilder setExtraOrdinaryDividends(PartyReference extraOrdinaryDividends);
		DividendConditions.DividendConditionsBuilder setExcessDividendAmount(DividendAmountTypeEnum excessDividendAmount);
		DividendConditions.DividendConditionsBuilder setCurrency(IdentifiedCurrency currency);
		DividendConditions.DividendConditionsBuilder setDeterminationMethod(DeterminationMethod determinationMethod);
		DividendConditions.DividendConditionsBuilder setCurrencyReference(IdentifiedCurrencyReference currencyReference);
		DividendConditions.DividendConditionsBuilder setDividendFxTriggerDate(DividendPaymentDate dividendFxTriggerDate);
		DividendConditions.DividendConditionsBuilder setInterestAccrualsMethod(InterestAccrualsCompoundingMethod interestAccrualsMethod);
		DividendConditions.DividendConditionsBuilder setNumberOfIndexUnits(BigDecimal numberOfIndexUnits);
		DividendConditions.DividendConditionsBuilder setDeclaredCashDividendPercentage(BigDecimal declaredCashDividendPercentage);
		DividendConditions.DividendConditionsBuilder setDeclaredCashEquivalentDividendPercentage(BigDecimal declaredCashEquivalentDividendPercentage);
		DividendConditions.DividendConditionsBuilder setNonCashDividendTreatment(NonCashDividendTreatmentEnum nonCashDividendTreatment);
		DividendConditions.DividendConditionsBuilder setDividendComposition(DividendCompositionEnum dividendComposition);
		DividendConditions.DividendConditionsBuilder setSpecialDividends(Boolean specialDividends);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dividendReinvestment"), Boolean.class, getDividendReinvestment(), this);
			processor.processBasic(path.newSubPath("dividendEntitlement"), DividendEntitlementEnum.class, getDividendEntitlement(), this);
			processor.processBasic(path.newSubPath("dividendAmount"), DividendAmountTypeEnum.class, getDividendAmount(), this);
			processRosetta(path.newSubPath("dividendPaymentDate"), processor, DividendPaymentDate.DividendPaymentDateBuilder.class, getDividendPaymentDate());
			processRosetta(path.newSubPath("dividendPeriodEffectiveDate"), processor, DateReference.DateReferenceBuilder.class, getDividendPeriodEffectiveDate());
			processRosetta(path.newSubPath("dividendPeriodEndDate"), processor, DateReference.DateReferenceBuilder.class, getDividendPeriodEndDate());
			processor.processBasic(path.newSubPath("dividendPeriod"), DividendPeriodEnum.class, getDividendPeriod(), this);
			processRosetta(path.newSubPath("extraOrdinaryDividends"), processor, PartyReference.PartyReferenceBuilder.class, getExtraOrdinaryDividends());
			processor.processBasic(path.newSubPath("excessDividendAmount"), DividendAmountTypeEnum.class, getExcessDividendAmount(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getDeterminationMethod());
			processRosetta(path.newSubPath("currencyReference"), processor, IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder.class, getCurrencyReference());
			processRosetta(path.newSubPath("dividendFxTriggerDate"), processor, DividendPaymentDate.DividendPaymentDateBuilder.class, getDividendFxTriggerDate());
			processRosetta(path.newSubPath("interestAccrualsMethod"), processor, InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder.class, getInterestAccrualsMethod());
			processor.processBasic(path.newSubPath("numberOfIndexUnits"), BigDecimal.class, getNumberOfIndexUnits(), this);
			processor.processBasic(path.newSubPath("declaredCashDividendPercentage"), BigDecimal.class, getDeclaredCashDividendPercentage(), this);
			processor.processBasic(path.newSubPath("declaredCashEquivalentDividendPercentage"), BigDecimal.class, getDeclaredCashEquivalentDividendPercentage(), this);
			processor.processBasic(path.newSubPath("nonCashDividendTreatment"), NonCashDividendTreatmentEnum.class, getNonCashDividendTreatment(), this);
			processor.processBasic(path.newSubPath("dividendComposition"), DividendCompositionEnum.class, getDividendComposition(), this);
			processor.processBasic(path.newSubPath("specialDividends"), Boolean.class, getSpecialDividends(), this);
		}
		

		DividendConditions.DividendConditionsBuilder prune();
	}

	/*********************** Immutable Implementation of DividendConditions  ***********************/
	class DividendConditionsImpl implements DividendConditions {
		private final Boolean dividendReinvestment;
		private final DividendEntitlementEnum dividendEntitlement;
		private final DividendAmountTypeEnum dividendAmount;
		private final DividendPaymentDate dividendPaymentDate;
		private final DateReference dividendPeriodEffectiveDate;
		private final DateReference dividendPeriodEndDate;
		private final DividendPeriodEnum dividendPeriod;
		private final PartyReference extraOrdinaryDividends;
		private final DividendAmountTypeEnum excessDividendAmount;
		private final IdentifiedCurrency currency;
		private final DeterminationMethod determinationMethod;
		private final IdentifiedCurrencyReference currencyReference;
		private final DividendPaymentDate dividendFxTriggerDate;
		private final InterestAccrualsCompoundingMethod interestAccrualsMethod;
		private final BigDecimal numberOfIndexUnits;
		private final BigDecimal declaredCashDividendPercentage;
		private final BigDecimal declaredCashEquivalentDividendPercentage;
		private final NonCashDividendTreatmentEnum nonCashDividendTreatment;
		private final DividendCompositionEnum dividendComposition;
		private final Boolean specialDividends;
		
		protected DividendConditionsImpl(DividendConditions.DividendConditionsBuilder builder) {
			this.dividendReinvestment = builder.getDividendReinvestment();
			this.dividendEntitlement = builder.getDividendEntitlement();
			this.dividendAmount = builder.getDividendAmount();
			this.dividendPaymentDate = ofNullable(builder.getDividendPaymentDate()).map(f->f.build()).orElse(null);
			this.dividendPeriodEffectiveDate = ofNullable(builder.getDividendPeriodEffectiveDate()).map(f->f.build()).orElse(null);
			this.dividendPeriodEndDate = ofNullable(builder.getDividendPeriodEndDate()).map(f->f.build()).orElse(null);
			this.dividendPeriod = builder.getDividendPeriod();
			this.extraOrdinaryDividends = ofNullable(builder.getExtraOrdinaryDividends()).map(f->f.build()).orElse(null);
			this.excessDividendAmount = builder.getExcessDividendAmount();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.determinationMethod = ofNullable(builder.getDeterminationMethod()).map(f->f.build()).orElse(null);
			this.currencyReference = ofNullable(builder.getCurrencyReference()).map(f->f.build()).orElse(null);
			this.dividendFxTriggerDate = ofNullable(builder.getDividendFxTriggerDate()).map(f->f.build()).orElse(null);
			this.interestAccrualsMethod = ofNullable(builder.getInterestAccrualsMethod()).map(f->f.build()).orElse(null);
			this.numberOfIndexUnits = builder.getNumberOfIndexUnits();
			this.declaredCashDividendPercentage = builder.getDeclaredCashDividendPercentage();
			this.declaredCashEquivalentDividendPercentage = builder.getDeclaredCashEquivalentDividendPercentage();
			this.nonCashDividendTreatment = builder.getNonCashDividendTreatment();
			this.dividendComposition = builder.getDividendComposition();
			this.specialDividends = builder.getSpecialDividends();
		}
		
		@Override
		@RosettaAttribute("dividendReinvestment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendReinvestment")
		public Boolean getDividendReinvestment() {
			return dividendReinvestment;
		}
		
		@Override
		@RosettaAttribute("dividendEntitlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendEntitlement")
		public DividendEntitlementEnum getDividendEntitlement() {
			return dividendEntitlement;
		}
		
		@Override
		@RosettaAttribute("dividendAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendAmount")
		public DividendAmountTypeEnum getDividendAmount() {
			return dividendAmount;
		}
		
		@Override
		@RosettaAttribute("dividendPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPaymentDate")
		public DividendPaymentDate getDividendPaymentDate() {
			return dividendPaymentDate;
		}
		
		@Override
		@RosettaAttribute("dividendPeriodEffectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPeriodEffectiveDate")
		public DateReference getDividendPeriodEffectiveDate() {
			return dividendPeriodEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("dividendPeriodEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPeriodEndDate")
		public DateReference getDividendPeriodEndDate() {
			return dividendPeriodEndDate;
		}
		
		@Override
		@RosettaAttribute("dividendPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPeriod")
		public DividendPeriodEnum getDividendPeriod() {
			return dividendPeriod;
		}
		
		@Override
		@RosettaAttribute("extraOrdinaryDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extraOrdinaryDividends")
		public PartyReference getExtraOrdinaryDividends() {
			return extraOrdinaryDividends;
		}
		
		@Override
		@RosettaAttribute("excessDividendAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("excessDividendAmount")
		public DividendAmountTypeEnum getExcessDividendAmount() {
			return excessDividendAmount;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public IdentifiedCurrency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determinationMethod")
		public DeterminationMethod getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		@RosettaAttribute("currencyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyReference")
		public IdentifiedCurrencyReference getCurrencyReference() {
			return currencyReference;
		}
		
		@Override
		@RosettaAttribute("dividendFxTriggerDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendFxTriggerDate")
		public DividendPaymentDate getDividendFxTriggerDate() {
			return dividendFxTriggerDate;
		}
		
		@Override
		@RosettaAttribute("interestAccrualsMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestAccrualsMethod")
		public InterestAccrualsCompoundingMethod getInterestAccrualsMethod() {
			return interestAccrualsMethod;
		}
		
		@Override
		@RosettaAttribute("numberOfIndexUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfIndexUnits")
		public BigDecimal getNumberOfIndexUnits() {
			return numberOfIndexUnits;
		}
		
		@Override
		@RosettaAttribute("declaredCashDividendPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("declaredCashDividendPercentage")
		public BigDecimal getDeclaredCashDividendPercentage() {
			return declaredCashDividendPercentage;
		}
		
		@Override
		@RosettaAttribute("declaredCashEquivalentDividendPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("declaredCashEquivalentDividendPercentage")
		public BigDecimal getDeclaredCashEquivalentDividendPercentage() {
			return declaredCashEquivalentDividendPercentage;
		}
		
		@Override
		@RosettaAttribute("nonCashDividendTreatment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonCashDividendTreatment")
		public NonCashDividendTreatmentEnum getNonCashDividendTreatment() {
			return nonCashDividendTreatment;
		}
		
		@Override
		@RosettaAttribute("dividendComposition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendComposition")
		public DividendCompositionEnum getDividendComposition() {
			return dividendComposition;
		}
		
		@Override
		@RosettaAttribute("specialDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specialDividends")
		public Boolean getSpecialDividends() {
			return specialDividends;
		}
		
		@Override
		public DividendConditions build() {
			return this;
		}
		
		@Override
		public DividendConditions.DividendConditionsBuilder toBuilder() {
			DividendConditions.DividendConditionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendConditions.DividendConditionsBuilder builder) {
			ofNullable(getDividendReinvestment()).ifPresent(builder::setDividendReinvestment);
			ofNullable(getDividendEntitlement()).ifPresent(builder::setDividendEntitlement);
			ofNullable(getDividendAmount()).ifPresent(builder::setDividendAmount);
			ofNullable(getDividendPaymentDate()).ifPresent(builder::setDividendPaymentDate);
			ofNullable(getDividendPeriodEffectiveDate()).ifPresent(builder::setDividendPeriodEffectiveDate);
			ofNullable(getDividendPeriodEndDate()).ifPresent(builder::setDividendPeriodEndDate);
			ofNullable(getDividendPeriod()).ifPresent(builder::setDividendPeriod);
			ofNullable(getExtraOrdinaryDividends()).ifPresent(builder::setExtraOrdinaryDividends);
			ofNullable(getExcessDividendAmount()).ifPresent(builder::setExcessDividendAmount);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
			ofNullable(getCurrencyReference()).ifPresent(builder::setCurrencyReference);
			ofNullable(getDividendFxTriggerDate()).ifPresent(builder::setDividendFxTriggerDate);
			ofNullable(getInterestAccrualsMethod()).ifPresent(builder::setInterestAccrualsMethod);
			ofNullable(getNumberOfIndexUnits()).ifPresent(builder::setNumberOfIndexUnits);
			ofNullable(getDeclaredCashDividendPercentage()).ifPresent(builder::setDeclaredCashDividendPercentage);
			ofNullable(getDeclaredCashEquivalentDividendPercentage()).ifPresent(builder::setDeclaredCashEquivalentDividendPercentage);
			ofNullable(getNonCashDividendTreatment()).ifPresent(builder::setNonCashDividendTreatment);
			ofNullable(getDividendComposition()).ifPresent(builder::setDividendComposition);
			ofNullable(getSpecialDividends()).ifPresent(builder::setSpecialDividends);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendConditions _that = getType().cast(o);
		
			if (!Objects.equals(dividendReinvestment, _that.getDividendReinvestment())) return false;
			if (!Objects.equals(dividendEntitlement, _that.getDividendEntitlement())) return false;
			if (!Objects.equals(dividendAmount, _that.getDividendAmount())) return false;
			if (!Objects.equals(dividendPaymentDate, _that.getDividendPaymentDate())) return false;
			if (!Objects.equals(dividendPeriodEffectiveDate, _that.getDividendPeriodEffectiveDate())) return false;
			if (!Objects.equals(dividendPeriodEndDate, _that.getDividendPeriodEndDate())) return false;
			if (!Objects.equals(dividendPeriod, _that.getDividendPeriod())) return false;
			if (!Objects.equals(extraOrdinaryDividends, _that.getExtraOrdinaryDividends())) return false;
			if (!Objects.equals(excessDividendAmount, _that.getExcessDividendAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(currencyReference, _that.getCurrencyReference())) return false;
			if (!Objects.equals(dividendFxTriggerDate, _that.getDividendFxTriggerDate())) return false;
			if (!Objects.equals(interestAccrualsMethod, _that.getInterestAccrualsMethod())) return false;
			if (!Objects.equals(numberOfIndexUnits, _that.getNumberOfIndexUnits())) return false;
			if (!Objects.equals(declaredCashDividendPercentage, _that.getDeclaredCashDividendPercentage())) return false;
			if (!Objects.equals(declaredCashEquivalentDividendPercentage, _that.getDeclaredCashEquivalentDividendPercentage())) return false;
			if (!Objects.equals(nonCashDividendTreatment, _that.getNonCashDividendTreatment())) return false;
			if (!Objects.equals(dividendComposition, _that.getDividendComposition())) return false;
			if (!Objects.equals(specialDividends, _that.getSpecialDividends())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendReinvestment != null ? dividendReinvestment.hashCode() : 0);
			_result = 31 * _result + (dividendEntitlement != null ? dividendEntitlement.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendAmount != null ? dividendAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendPaymentDate != null ? dividendPaymentDate.hashCode() : 0);
			_result = 31 * _result + (dividendPeriodEffectiveDate != null ? dividendPeriodEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (dividendPeriodEndDate != null ? dividendPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (dividendPeriod != null ? dividendPeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extraOrdinaryDividends != null ? extraOrdinaryDividends.hashCode() : 0);
			_result = 31 * _result + (excessDividendAmount != null ? excessDividendAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (currencyReference != null ? currencyReference.hashCode() : 0);
			_result = 31 * _result + (dividendFxTriggerDate != null ? dividendFxTriggerDate.hashCode() : 0);
			_result = 31 * _result + (interestAccrualsMethod != null ? interestAccrualsMethod.hashCode() : 0);
			_result = 31 * _result + (numberOfIndexUnits != null ? numberOfIndexUnits.hashCode() : 0);
			_result = 31 * _result + (declaredCashDividendPercentage != null ? declaredCashDividendPercentage.hashCode() : 0);
			_result = 31 * _result + (declaredCashEquivalentDividendPercentage != null ? declaredCashEquivalentDividendPercentage.hashCode() : 0);
			_result = 31 * _result + (nonCashDividendTreatment != null ? nonCashDividendTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendComposition != null ? dividendComposition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (specialDividends != null ? specialDividends.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendConditions {" +
				"dividendReinvestment=" + this.dividendReinvestment + ", " +
				"dividendEntitlement=" + this.dividendEntitlement + ", " +
				"dividendAmount=" + this.dividendAmount + ", " +
				"dividendPaymentDate=" + this.dividendPaymentDate + ", " +
				"dividendPeriodEffectiveDate=" + this.dividendPeriodEffectiveDate + ", " +
				"dividendPeriodEndDate=" + this.dividendPeriodEndDate + ", " +
				"dividendPeriod=" + this.dividendPeriod + ", " +
				"extraOrdinaryDividends=" + this.extraOrdinaryDividends + ", " +
				"excessDividendAmount=" + this.excessDividendAmount + ", " +
				"currency=" + this.currency + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"currencyReference=" + this.currencyReference + ", " +
				"dividendFxTriggerDate=" + this.dividendFxTriggerDate + ", " +
				"interestAccrualsMethod=" + this.interestAccrualsMethod + ", " +
				"numberOfIndexUnits=" + this.numberOfIndexUnits + ", " +
				"declaredCashDividendPercentage=" + this.declaredCashDividendPercentage + ", " +
				"declaredCashEquivalentDividendPercentage=" + this.declaredCashEquivalentDividendPercentage + ", " +
				"nonCashDividendTreatment=" + this.nonCashDividendTreatment + ", " +
				"dividendComposition=" + this.dividendComposition + ", " +
				"specialDividends=" + this.specialDividends +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendConditions  ***********************/
	class DividendConditionsBuilderImpl implements DividendConditions.DividendConditionsBuilder {
	
		protected Boolean dividendReinvestment;
		protected DividendEntitlementEnum dividendEntitlement;
		protected DividendAmountTypeEnum dividendAmount;
		protected DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDate;
		protected DateReference.DateReferenceBuilder dividendPeriodEffectiveDate;
		protected DateReference.DateReferenceBuilder dividendPeriodEndDate;
		protected DividendPeriodEnum dividendPeriod;
		protected PartyReference.PartyReferenceBuilder extraOrdinaryDividends;
		protected DividendAmountTypeEnum excessDividendAmount;
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder currency;
		protected DeterminationMethod.DeterminationMethodBuilder determinationMethod;
		protected IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder currencyReference;
		protected DividendPaymentDate.DividendPaymentDateBuilder dividendFxTriggerDate;
		protected InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder interestAccrualsMethod;
		protected BigDecimal numberOfIndexUnits;
		protected BigDecimal declaredCashDividendPercentage;
		protected BigDecimal declaredCashEquivalentDividendPercentage;
		protected NonCashDividendTreatmentEnum nonCashDividendTreatment;
		protected DividendCompositionEnum dividendComposition;
		protected Boolean specialDividends;
		
		@Override
		@RosettaAttribute("dividendReinvestment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendReinvestment")
		public Boolean getDividendReinvestment() {
			return dividendReinvestment;
		}
		
		@Override
		@RosettaAttribute("dividendEntitlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendEntitlement")
		public DividendEntitlementEnum getDividendEntitlement() {
			return dividendEntitlement;
		}
		
		@Override
		@RosettaAttribute("dividendAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendAmount")
		public DividendAmountTypeEnum getDividendAmount() {
			return dividendAmount;
		}
		
		@Override
		@RosettaAttribute("dividendPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPaymentDate")
		public DividendPaymentDate.DividendPaymentDateBuilder getDividendPaymentDate() {
			return dividendPaymentDate;
		}
		
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder getOrCreateDividendPaymentDate() {
			DividendPaymentDate.DividendPaymentDateBuilder result;
			if (dividendPaymentDate!=null) {
				result = dividendPaymentDate;
			}
			else {
				result = dividendPaymentDate = DividendPaymentDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendPeriodEffectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPeriodEffectiveDate")
		public DateReference.DateReferenceBuilder getDividendPeriodEffectiveDate() {
			return dividendPeriodEffectiveDate;
		}
		
		@Override
		public DateReference.DateReferenceBuilder getOrCreateDividendPeriodEffectiveDate() {
			DateReference.DateReferenceBuilder result;
			if (dividendPeriodEffectiveDate!=null) {
				result = dividendPeriodEffectiveDate;
			}
			else {
				result = dividendPeriodEffectiveDate = DateReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendPeriodEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPeriodEndDate")
		public DateReference.DateReferenceBuilder getDividendPeriodEndDate() {
			return dividendPeriodEndDate;
		}
		
		@Override
		public DateReference.DateReferenceBuilder getOrCreateDividendPeriodEndDate() {
			DateReference.DateReferenceBuilder result;
			if (dividendPeriodEndDate!=null) {
				result = dividendPeriodEndDate;
			}
			else {
				result = dividendPeriodEndDate = DateReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPeriod")
		public DividendPeriodEnum getDividendPeriod() {
			return dividendPeriod;
		}
		
		@Override
		@RosettaAttribute("extraOrdinaryDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extraOrdinaryDividends")
		public PartyReference.PartyReferenceBuilder getExtraOrdinaryDividends() {
			return extraOrdinaryDividends;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateExtraOrdinaryDividends() {
			PartyReference.PartyReferenceBuilder result;
			if (extraOrdinaryDividends!=null) {
				result = extraOrdinaryDividends;
			}
			else {
				result = extraOrdinaryDividends = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("excessDividendAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("excessDividendAmount")
		public DividendAmountTypeEnum getExcessDividendAmount() {
			return excessDividendAmount;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateCurrency() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = IdentifiedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determinationMethod")
		public DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (determinationMethod!=null) {
				result = determinationMethod;
			}
			else {
				result = determinationMethod = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currencyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyReference")
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder getCurrencyReference() {
			return currencyReference;
		}
		
		@Override
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder getOrCreateCurrencyReference() {
			IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder result;
			if (currencyReference!=null) {
				result = currencyReference;
			}
			else {
				result = currencyReference = IdentifiedCurrencyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendFxTriggerDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendFxTriggerDate")
		public DividendPaymentDate.DividendPaymentDateBuilder getDividendFxTriggerDate() {
			return dividendFxTriggerDate;
		}
		
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder getOrCreateDividendFxTriggerDate() {
			DividendPaymentDate.DividendPaymentDateBuilder result;
			if (dividendFxTriggerDate!=null) {
				result = dividendFxTriggerDate;
			}
			else {
				result = dividendFxTriggerDate = DividendPaymentDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestAccrualsMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestAccrualsMethod")
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder getInterestAccrualsMethod() {
			return interestAccrualsMethod;
		}
		
		@Override
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder getOrCreateInterestAccrualsMethod() {
			InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder result;
			if (interestAccrualsMethod!=null) {
				result = interestAccrualsMethod;
			}
			else {
				result = interestAccrualsMethod = InterestAccrualsCompoundingMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfIndexUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfIndexUnits")
		public BigDecimal getNumberOfIndexUnits() {
			return numberOfIndexUnits;
		}
		
		@Override
		@RosettaAttribute("declaredCashDividendPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("declaredCashDividendPercentage")
		public BigDecimal getDeclaredCashDividendPercentage() {
			return declaredCashDividendPercentage;
		}
		
		@Override
		@RosettaAttribute("declaredCashEquivalentDividendPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("declaredCashEquivalentDividendPercentage")
		public BigDecimal getDeclaredCashEquivalentDividendPercentage() {
			return declaredCashEquivalentDividendPercentage;
		}
		
		@Override
		@RosettaAttribute("nonCashDividendTreatment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonCashDividendTreatment")
		public NonCashDividendTreatmentEnum getNonCashDividendTreatment() {
			return nonCashDividendTreatment;
		}
		
		@Override
		@RosettaAttribute("dividendComposition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendComposition")
		public DividendCompositionEnum getDividendComposition() {
			return dividendComposition;
		}
		
		@Override
		@RosettaAttribute("specialDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specialDividends")
		public Boolean getSpecialDividends() {
			return specialDividends;
		}
		
		@RosettaAttribute("dividendReinvestment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendReinvestment")
		@Override
		public DividendConditions.DividendConditionsBuilder setDividendReinvestment(Boolean _dividendReinvestment) {
			this.dividendReinvestment = _dividendReinvestment == null ? null : _dividendReinvestment;
			return this;
		}
		
		@RosettaAttribute("dividendEntitlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendEntitlement")
		@Override
		public DividendConditions.DividendConditionsBuilder setDividendEntitlement(DividendEntitlementEnum _dividendEntitlement) {
			this.dividendEntitlement = _dividendEntitlement == null ? null : _dividendEntitlement;
			return this;
		}
		
		@RosettaAttribute("dividendAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendAmount")
		@Override
		public DividendConditions.DividendConditionsBuilder setDividendAmount(DividendAmountTypeEnum _dividendAmount) {
			this.dividendAmount = _dividendAmount == null ? null : _dividendAmount;
			return this;
		}
		
		@RosettaAttribute("dividendPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendPaymentDate")
		@Override
		public DividendConditions.DividendConditionsBuilder setDividendPaymentDate(DividendPaymentDate _dividendPaymentDate) {
			this.dividendPaymentDate = _dividendPaymentDate == null ? null : _dividendPaymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dividendPeriodEffectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendPeriodEffectiveDate")
		@Override
		public DividendConditions.DividendConditionsBuilder setDividendPeriodEffectiveDate(DateReference _dividendPeriodEffectiveDate) {
			this.dividendPeriodEffectiveDate = _dividendPeriodEffectiveDate == null ? null : _dividendPeriodEffectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dividendPeriodEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendPeriodEndDate")
		@Override
		public DividendConditions.DividendConditionsBuilder setDividendPeriodEndDate(DateReference _dividendPeriodEndDate) {
			this.dividendPeriodEndDate = _dividendPeriodEndDate == null ? null : _dividendPeriodEndDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dividendPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendPeriod")
		@Override
		public DividendConditions.DividendConditionsBuilder setDividendPeriod(DividendPeriodEnum _dividendPeriod) {
			this.dividendPeriod = _dividendPeriod == null ? null : _dividendPeriod;
			return this;
		}
		
		@RosettaAttribute("extraOrdinaryDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extraOrdinaryDividends")
		@Override
		public DividendConditions.DividendConditionsBuilder setExtraOrdinaryDividends(PartyReference _extraOrdinaryDividends) {
			this.extraOrdinaryDividends = _extraOrdinaryDividends == null ? null : _extraOrdinaryDividends.toBuilder();
			return this;
		}
		
		@RosettaAttribute("excessDividendAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excessDividendAmount")
		@Override
		public DividendConditions.DividendConditionsBuilder setExcessDividendAmount(DividendAmountTypeEnum _excessDividendAmount) {
			this.excessDividendAmount = _excessDividendAmount == null ? null : _excessDividendAmount;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public DividendConditions.DividendConditionsBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("determinationMethod")
		@Override
		public DividendConditions.DividendConditionsBuilder setDeterminationMethod(DeterminationMethod _determinationMethod) {
			this.determinationMethod = _determinationMethod == null ? null : _determinationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currencyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyReference")
		@Override
		public DividendConditions.DividendConditionsBuilder setCurrencyReference(IdentifiedCurrencyReference _currencyReference) {
			this.currencyReference = _currencyReference == null ? null : _currencyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dividendFxTriggerDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendFxTriggerDate")
		@Override
		public DividendConditions.DividendConditionsBuilder setDividendFxTriggerDate(DividendPaymentDate _dividendFxTriggerDate) {
			this.dividendFxTriggerDate = _dividendFxTriggerDate == null ? null : _dividendFxTriggerDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interestAccrualsMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interestAccrualsMethod")
		@Override
		public DividendConditions.DividendConditionsBuilder setInterestAccrualsMethod(InterestAccrualsCompoundingMethod _interestAccrualsMethod) {
			this.interestAccrualsMethod = _interestAccrualsMethod == null ? null : _interestAccrualsMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("numberOfIndexUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfIndexUnits")
		@Override
		public DividendConditions.DividendConditionsBuilder setNumberOfIndexUnits(BigDecimal _numberOfIndexUnits) {
			this.numberOfIndexUnits = _numberOfIndexUnits == null ? null : _numberOfIndexUnits;
			return this;
		}
		
		@RosettaAttribute("declaredCashDividendPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("declaredCashDividendPercentage")
		@Override
		public DividendConditions.DividendConditionsBuilder setDeclaredCashDividendPercentage(BigDecimal _declaredCashDividendPercentage) {
			this.declaredCashDividendPercentage = _declaredCashDividendPercentage == null ? null : _declaredCashDividendPercentage;
			return this;
		}
		
		@RosettaAttribute("declaredCashEquivalentDividendPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("declaredCashEquivalentDividendPercentage")
		@Override
		public DividendConditions.DividendConditionsBuilder setDeclaredCashEquivalentDividendPercentage(BigDecimal _declaredCashEquivalentDividendPercentage) {
			this.declaredCashEquivalentDividendPercentage = _declaredCashEquivalentDividendPercentage == null ? null : _declaredCashEquivalentDividendPercentage;
			return this;
		}
		
		@RosettaAttribute("nonCashDividendTreatment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonCashDividendTreatment")
		@Override
		public DividendConditions.DividendConditionsBuilder setNonCashDividendTreatment(NonCashDividendTreatmentEnum _nonCashDividendTreatment) {
			this.nonCashDividendTreatment = _nonCashDividendTreatment == null ? null : _nonCashDividendTreatment;
			return this;
		}
		
		@RosettaAttribute("dividendComposition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendComposition")
		@Override
		public DividendConditions.DividendConditionsBuilder setDividendComposition(DividendCompositionEnum _dividendComposition) {
			this.dividendComposition = _dividendComposition == null ? null : _dividendComposition;
			return this;
		}
		
		@RosettaAttribute("specialDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("specialDividends")
		@Override
		public DividendConditions.DividendConditionsBuilder setSpecialDividends(Boolean _specialDividends) {
			this.specialDividends = _specialDividends == null ? null : _specialDividends;
			return this;
		}
		
		@Override
		public DividendConditions build() {
			return new DividendConditions.DividendConditionsImpl(this);
		}
		
		@Override
		public DividendConditions.DividendConditionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendConditions.DividendConditionsBuilder prune() {
			if (dividendPaymentDate!=null && !dividendPaymentDate.prune().hasData()) dividendPaymentDate = null;
			if (dividendPeriodEffectiveDate!=null && !dividendPeriodEffectiveDate.prune().hasData()) dividendPeriodEffectiveDate = null;
			if (dividendPeriodEndDate!=null && !dividendPeriodEndDate.prune().hasData()) dividendPeriodEndDate = null;
			if (extraOrdinaryDividends!=null && !extraOrdinaryDividends.prune().hasData()) extraOrdinaryDividends = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (determinationMethod!=null && !determinationMethod.prune().hasData()) determinationMethod = null;
			if (currencyReference!=null && !currencyReference.prune().hasData()) currencyReference = null;
			if (dividendFxTriggerDate!=null && !dividendFxTriggerDate.prune().hasData()) dividendFxTriggerDate = null;
			if (interestAccrualsMethod!=null && !interestAccrualsMethod.prune().hasData()) interestAccrualsMethod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDividendReinvestment()!=null) return true;
			if (getDividendEntitlement()!=null) return true;
			if (getDividendAmount()!=null) return true;
			if (getDividendPaymentDate()!=null && getDividendPaymentDate().hasData()) return true;
			if (getDividendPeriodEffectiveDate()!=null && getDividendPeriodEffectiveDate().hasData()) return true;
			if (getDividendPeriodEndDate()!=null && getDividendPeriodEndDate().hasData()) return true;
			if (getDividendPeriod()!=null) return true;
			if (getExtraOrdinaryDividends()!=null && getExtraOrdinaryDividends().hasData()) return true;
			if (getExcessDividendAmount()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getDeterminationMethod()!=null && getDeterminationMethod().hasData()) return true;
			if (getCurrencyReference()!=null && getCurrencyReference().hasData()) return true;
			if (getDividendFxTriggerDate()!=null && getDividendFxTriggerDate().hasData()) return true;
			if (getInterestAccrualsMethod()!=null && getInterestAccrualsMethod().hasData()) return true;
			if (getNumberOfIndexUnits()!=null) return true;
			if (getDeclaredCashDividendPercentage()!=null) return true;
			if (getDeclaredCashEquivalentDividendPercentage()!=null) return true;
			if (getNonCashDividendTreatment()!=null) return true;
			if (getDividendComposition()!=null) return true;
			if (getSpecialDividends()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendConditions.DividendConditionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendConditions.DividendConditionsBuilder o = (DividendConditions.DividendConditionsBuilder) other;
			
			merger.mergeRosetta(getDividendPaymentDate(), o.getDividendPaymentDate(), this::setDividendPaymentDate);
			merger.mergeRosetta(getDividendPeriodEffectiveDate(), o.getDividendPeriodEffectiveDate(), this::setDividendPeriodEffectiveDate);
			merger.mergeRosetta(getDividendPeriodEndDate(), o.getDividendPeriodEndDate(), this::setDividendPeriodEndDate);
			merger.mergeRosetta(getExtraOrdinaryDividends(), o.getExtraOrdinaryDividends(), this::setExtraOrdinaryDividends);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			merger.mergeRosetta(getCurrencyReference(), o.getCurrencyReference(), this::setCurrencyReference);
			merger.mergeRosetta(getDividendFxTriggerDate(), o.getDividendFxTriggerDate(), this::setDividendFxTriggerDate);
			merger.mergeRosetta(getInterestAccrualsMethod(), o.getInterestAccrualsMethod(), this::setInterestAccrualsMethod);
			
			merger.mergeBasic(getDividendReinvestment(), o.getDividendReinvestment(), this::setDividendReinvestment);
			merger.mergeBasic(getDividendEntitlement(), o.getDividendEntitlement(), this::setDividendEntitlement);
			merger.mergeBasic(getDividendAmount(), o.getDividendAmount(), this::setDividendAmount);
			merger.mergeBasic(getDividendPeriod(), o.getDividendPeriod(), this::setDividendPeriod);
			merger.mergeBasic(getExcessDividendAmount(), o.getExcessDividendAmount(), this::setExcessDividendAmount);
			merger.mergeBasic(getNumberOfIndexUnits(), o.getNumberOfIndexUnits(), this::setNumberOfIndexUnits);
			merger.mergeBasic(getDeclaredCashDividendPercentage(), o.getDeclaredCashDividendPercentage(), this::setDeclaredCashDividendPercentage);
			merger.mergeBasic(getDeclaredCashEquivalentDividendPercentage(), o.getDeclaredCashEquivalentDividendPercentage(), this::setDeclaredCashEquivalentDividendPercentage);
			merger.mergeBasic(getNonCashDividendTreatment(), o.getNonCashDividendTreatment(), this::setNonCashDividendTreatment);
			merger.mergeBasic(getDividendComposition(), o.getDividendComposition(), this::setDividendComposition);
			merger.mergeBasic(getSpecialDividends(), o.getSpecialDividends(), this::setSpecialDividends);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendConditions _that = getType().cast(o);
		
			if (!Objects.equals(dividendReinvestment, _that.getDividendReinvestment())) return false;
			if (!Objects.equals(dividendEntitlement, _that.getDividendEntitlement())) return false;
			if (!Objects.equals(dividendAmount, _that.getDividendAmount())) return false;
			if (!Objects.equals(dividendPaymentDate, _that.getDividendPaymentDate())) return false;
			if (!Objects.equals(dividendPeriodEffectiveDate, _that.getDividendPeriodEffectiveDate())) return false;
			if (!Objects.equals(dividendPeriodEndDate, _that.getDividendPeriodEndDate())) return false;
			if (!Objects.equals(dividendPeriod, _that.getDividendPeriod())) return false;
			if (!Objects.equals(extraOrdinaryDividends, _that.getExtraOrdinaryDividends())) return false;
			if (!Objects.equals(excessDividendAmount, _that.getExcessDividendAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(currencyReference, _that.getCurrencyReference())) return false;
			if (!Objects.equals(dividendFxTriggerDate, _that.getDividendFxTriggerDate())) return false;
			if (!Objects.equals(interestAccrualsMethod, _that.getInterestAccrualsMethod())) return false;
			if (!Objects.equals(numberOfIndexUnits, _that.getNumberOfIndexUnits())) return false;
			if (!Objects.equals(declaredCashDividendPercentage, _that.getDeclaredCashDividendPercentage())) return false;
			if (!Objects.equals(declaredCashEquivalentDividendPercentage, _that.getDeclaredCashEquivalentDividendPercentage())) return false;
			if (!Objects.equals(nonCashDividendTreatment, _that.getNonCashDividendTreatment())) return false;
			if (!Objects.equals(dividendComposition, _that.getDividendComposition())) return false;
			if (!Objects.equals(specialDividends, _that.getSpecialDividends())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendReinvestment != null ? dividendReinvestment.hashCode() : 0);
			_result = 31 * _result + (dividendEntitlement != null ? dividendEntitlement.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendAmount != null ? dividendAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendPaymentDate != null ? dividendPaymentDate.hashCode() : 0);
			_result = 31 * _result + (dividendPeriodEffectiveDate != null ? dividendPeriodEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (dividendPeriodEndDate != null ? dividendPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (dividendPeriod != null ? dividendPeriod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extraOrdinaryDividends != null ? extraOrdinaryDividends.hashCode() : 0);
			_result = 31 * _result + (excessDividendAmount != null ? excessDividendAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (currencyReference != null ? currencyReference.hashCode() : 0);
			_result = 31 * _result + (dividendFxTriggerDate != null ? dividendFxTriggerDate.hashCode() : 0);
			_result = 31 * _result + (interestAccrualsMethod != null ? interestAccrualsMethod.hashCode() : 0);
			_result = 31 * _result + (numberOfIndexUnits != null ? numberOfIndexUnits.hashCode() : 0);
			_result = 31 * _result + (declaredCashDividendPercentage != null ? declaredCashDividendPercentage.hashCode() : 0);
			_result = 31 * _result + (declaredCashEquivalentDividendPercentage != null ? declaredCashEquivalentDividendPercentage.hashCode() : 0);
			_result = 31 * _result + (nonCashDividendTreatment != null ? nonCashDividendTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendComposition != null ? dividendComposition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (specialDividends != null ? specialDividends.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendConditionsBuilder {" +
				"dividendReinvestment=" + this.dividendReinvestment + ", " +
				"dividendEntitlement=" + this.dividendEntitlement + ", " +
				"dividendAmount=" + this.dividendAmount + ", " +
				"dividendPaymentDate=" + this.dividendPaymentDate + ", " +
				"dividendPeriodEffectiveDate=" + this.dividendPeriodEffectiveDate + ", " +
				"dividendPeriodEndDate=" + this.dividendPeriodEndDate + ", " +
				"dividendPeriod=" + this.dividendPeriod + ", " +
				"extraOrdinaryDividends=" + this.extraOrdinaryDividends + ", " +
				"excessDividendAmount=" + this.excessDividendAmount + ", " +
				"currency=" + this.currency + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"currencyReference=" + this.currencyReference + ", " +
				"dividendFxTriggerDate=" + this.dividendFxTriggerDate + ", " +
				"interestAccrualsMethod=" + this.interestAccrualsMethod + ", " +
				"numberOfIndexUnits=" + this.numberOfIndexUnits + ", " +
				"declaredCashDividendPercentage=" + this.declaredCashDividendPercentage + ", " +
				"declaredCashEquivalentDividendPercentage=" + this.declaredCashEquivalentDividendPercentage + ", " +
				"nonCashDividendTreatment=" + this.nonCashDividendTreatment + ", " +
				"dividendComposition=" + this.dividendComposition + ", " +
				"specialDividends=" + this.specialDividends +
			'}';
		}
	}
}

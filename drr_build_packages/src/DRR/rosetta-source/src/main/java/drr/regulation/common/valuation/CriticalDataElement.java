package drr.regulation.common.valuation;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import drr.regulation.common.valuation.meta.CriticalDataElementMeta;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ReportLevelEnum;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Critical Data Elements for the Valuation report
 * @version 7.7.0
 */
@RosettaDataType(value="CriticalDataElement", builder=CriticalDataElement.CriticalDataElementBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CriticalDataElement", model="drr", builder=CriticalDataElement.CriticalDataElementBuilderImpl.class, version="7.7.0")
public interface CriticalDataElement extends RosettaModelObject {

	CriticalDataElementMeta metaData = new CriticalDataElementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data."  * Corpus Dissemination Valuation   
	 * section "2" * field "4"
	 *
	 * Provision Date and time of the submission of the report as reported to the trade repository.
	 *
	 */
	ZonedDateTime getReportingTimestamp();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data."  * Corpus Dissemination Valuation   
	 * section "2" * field "6"
	 *
	 * Provision Identifier of the counterparty to an OTC derivative transaction who is fulfilling its reporting obligation via the report in question. In jurisdictions where both parties must report the transaction, the identifier of Counterparty 1 always identifies the reporting counterparty. In the case of an allocated derivative transaction executed by a fund manager on behalf of a fund, the fund and not the fund manager is reported as the counterparty. However, if the allocation of the block trade to specific funds does not take place prior to the reporting deadline, then the fund manager executing the transaction on behalf of the fund can be reported as the counterparty.
	 *
	 */
	String getCounterparty1();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data."  * Corpus Dissemination Valuation   
	 * section "2" * field "8"
	 *
	 * Provision Indicator of whether LEI was used to identify the Counterparty 2
	             - Allowable Values:
	                 - true, for legal entities
	                 - false, for natural persons who are acting as private individuals (not eligible for an LEI per the ROC Statement - Individuals Acting in a Business Capacity.
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
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data."  * Corpus Dissemination Valuation   
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
	 */
	String getCounterparty2();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data."  * Corpus Dissemination Valuation   
	 * section "2" * field "25"
	 *
	 * Provision Current value of the outstanding contract without applying any valuation adjustments (some examples include XVA adjustment such as CVA, DVA, etc).
	         Valuation amount is expressed as the exit cost of the contract or components of the contract, ie the price that would be received to sell the contract (in the market in an orderly transaction at the valuation date).
	 *
	 */
	BigDecimal getValuationAmount();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data."  * Corpus Dissemination Valuation   
	 * section "2" * field "26"
	 *
	 * Provision Currency in which the valuation amount is denominated.
	 *
	 */
	ISOCurrencyCodeEnum getValuationCurrency();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data."  * Corpus Dissemination Valuation   
	 * section "2" * field "27"
	 *
	 * Provision Date and time of the last valuation marked to market, provided by the central counterparty (CCP) or calculated using the current or last available market price of the inputs. If for example a currency exchange rate is the basis for a transactions valuation, then the valuation timestamp reflects the moment in time that exchange rate was current.
	 *
	 */
	ZonedDateTime getValuationTimestamp();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data."  * Corpus Dissemination Valuation   
	 * table "2" * field "28"
	 *
	 * Provision Source and method used for the valuation of the transaction by the reporting counterparty.
	             If at least one valuation input is used that is classified as mark-to-model in the below table, then the whole valuation is classified as mark-to-model.
	             If only inputs are used that are classified as mark-to-market in the table below, then the whole valuation is classified as mark-to-market.
	             - Format: Char(4)
	 *
	 */
	ValuationType1Code getValuationMethod();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data."  * Corpus Dissemination Valuation   
	 * section "2" * field "71"
	 *
	 * Provision The ratio of the absolute change in price of an OTC derivative transaction to the change in price of the underlier. 
	         - Allowable values: Any value
	 *
	 */
	BigDecimal getDelta();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data."  * Corpus Dissemination Valuation   
	 * section "2" * field "107"
	 *
	 * Provision Type of action taken on the transaction or type of end-of-day reporting.
	 *
	 */
	ActionTypeEnum getActionType();
	/**
	 *
	 * Body CPMI_IOSCO
	 * Corpus TechnicalGuidance CDE Harmonisation of Critical Data Elements (other than UTI and UPI) version 3 "Version 3 of the CDE Technical Guidance. This new version of the CDE Technical Guidance (version 3) includes certain revisions and new data elements to the September 2021 CDE Technical Guidance. These proposed revisions and additions are deemed necessary to further improve the standardisation and understanding of the data."  * Corpus Dissemination Valuation   
	 * section "2" * field "112"
	 *
	 * Provision Indication whether the report is done at trade or position level. Position level report can be used as a supplement to trade level reporting to report post trade events and if individual trades have been replaced by the position.
	 *
	 */
	ReportLevelEnum getLevel();

	/*********************** Build Methods  ***********************/
	CriticalDataElement build();
	
	CriticalDataElement.CriticalDataElementBuilder toBuilder();
	
	static CriticalDataElement.CriticalDataElementBuilder builder() {
		return new CriticalDataElement.CriticalDataElementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CriticalDataElement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CriticalDataElement> getType() {
		return CriticalDataElement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
		processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
		processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
		processor.processBasic(path.newSubPath("valuationAmount"), BigDecimal.class, getValuationAmount(), this);
		processor.processBasic(path.newSubPath("valuationCurrency"), ISOCurrencyCodeEnum.class, getValuationCurrency(), this);
		processor.processBasic(path.newSubPath("valuationTimestamp"), ZonedDateTime.class, getValuationTimestamp(), this);
		processor.processBasic(path.newSubPath("valuationMethod"), ValuationType1Code.class, getValuationMethod(), this);
		processor.processBasic(path.newSubPath("delta"), BigDecimal.class, getDelta(), this);
		processor.processBasic(path.newSubPath("actionType"), ActionTypeEnum.class, getActionType(), this);
		processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CriticalDataElementBuilder extends CriticalDataElement, RosettaModelObjectBuilder {
		CriticalDataElement.CriticalDataElementBuilder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		CriticalDataElement.CriticalDataElementBuilder setCounterparty1(String counterparty1);
		CriticalDataElement.CriticalDataElementBuilder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		CriticalDataElement.CriticalDataElementBuilder setCounterparty2(String counterparty2);
		CriticalDataElement.CriticalDataElementBuilder setValuationAmount(BigDecimal valuationAmount);
		CriticalDataElement.CriticalDataElementBuilder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		CriticalDataElement.CriticalDataElementBuilder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		CriticalDataElement.CriticalDataElementBuilder setValuationMethod(ValuationType1Code valuationMethod);
		CriticalDataElement.CriticalDataElementBuilder setDelta(BigDecimal delta);
		CriticalDataElement.CriticalDataElementBuilder setActionType(ActionTypeEnum actionType);
		CriticalDataElement.CriticalDataElementBuilder setLevel(ReportLevelEnum level);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
			processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
			processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
			processor.processBasic(path.newSubPath("valuationAmount"), BigDecimal.class, getValuationAmount(), this);
			processor.processBasic(path.newSubPath("valuationCurrency"), ISOCurrencyCodeEnum.class, getValuationCurrency(), this);
			processor.processBasic(path.newSubPath("valuationTimestamp"), ZonedDateTime.class, getValuationTimestamp(), this);
			processor.processBasic(path.newSubPath("valuationMethod"), ValuationType1Code.class, getValuationMethod(), this);
			processor.processBasic(path.newSubPath("delta"), BigDecimal.class, getDelta(), this);
			processor.processBasic(path.newSubPath("actionType"), ActionTypeEnum.class, getActionType(), this);
			processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
		}
		

		CriticalDataElement.CriticalDataElementBuilder prune();
	}

	/*********************** Immutable Implementation of CriticalDataElement  ***********************/
	class CriticalDataElementImpl implements CriticalDataElement {
		private final ZonedDateTime reportingTimestamp;
		private final String counterparty1;
		private final Boolean counterparty2IdentifierType;
		private final String counterparty2;
		private final BigDecimal valuationAmount;
		private final ISOCurrencyCodeEnum valuationCurrency;
		private final ZonedDateTime valuationTimestamp;
		private final ValuationType1Code valuationMethod;
		private final BigDecimal delta;
		private final ActionTypeEnum actionType;
		private final ReportLevelEnum level;
		
		protected CriticalDataElementImpl(CriticalDataElement.CriticalDataElementBuilder builder) {
			this.reportingTimestamp = builder.getReportingTimestamp();
			this.counterparty1 = builder.getCounterparty1();
			this.counterparty2IdentifierType = builder.getCounterparty2IdentifierType();
			this.counterparty2 = builder.getCounterparty2();
			this.valuationAmount = builder.getValuationAmount();
			this.valuationCurrency = builder.getValuationCurrency();
			this.valuationTimestamp = builder.getValuationTimestamp();
			this.valuationMethod = builder.getValuationMethod();
			this.delta = builder.getDelta();
			this.actionType = builder.getActionType();
			this.level = builder.getLevel();
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
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty1")
		public String getCounterparty1() {
			return counterparty1;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
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
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valuationAmount")
		public BigDecimal getValuationAmount() {
			return valuationAmount;
		}
		
		@Override
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valuationCurrency")
		public ISOCurrencyCodeEnum getValuationCurrency() {
			return valuationCurrency;
		}
		
		@Override
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valuationTimestamp")
		public ZonedDateTime getValuationTimestamp() {
			return valuationTimestamp;
		}
		
		@Override
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valuationMethod")
		public ValuationType1Code getValuationMethod() {
			return valuationMethod;
		}
		
		@Override
		@RosettaAttribute("delta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("delta")
		public BigDecimal getDelta() {
			return delta;
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
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("level")
		public ReportLevelEnum getLevel() {
			return level;
		}
		
		@Override
		public CriticalDataElement build() {
			return this;
		}
		
		@Override
		public CriticalDataElement.CriticalDataElementBuilder toBuilder() {
			CriticalDataElement.CriticalDataElementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CriticalDataElement.CriticalDataElementBuilder builder) {
			ofNullable(getReportingTimestamp()).ifPresent(builder::setReportingTimestamp);
			ofNullable(getCounterparty1()).ifPresent(builder::setCounterparty1);
			ofNullable(getCounterparty2IdentifierType()).ifPresent(builder::setCounterparty2IdentifierType);
			ofNullable(getCounterparty2()).ifPresent(builder::setCounterparty2);
			ofNullable(getValuationAmount()).ifPresent(builder::setValuationAmount);
			ofNullable(getValuationCurrency()).ifPresent(builder::setValuationCurrency);
			ofNullable(getValuationTimestamp()).ifPresent(builder::setValuationTimestamp);
			ofNullable(getValuationMethod()).ifPresent(builder::setValuationMethod);
			ofNullable(getDelta()).ifPresent(builder::setDelta);
			ofNullable(getActionType()).ifPresent(builder::setActionType);
			ofNullable(getLevel()).ifPresent(builder::setLevel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CriticalDataElement _that = getType().cast(o);
		
			if (!Objects.equals(reportingTimestamp, _that.getReportingTimestamp())) return false;
			if (!Objects.equals(counterparty1, _that.getCounterparty1())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(valuationAmount, _that.getValuationAmount())) return false;
			if (!Objects.equals(valuationCurrency, _that.getValuationCurrency())) return false;
			if (!Objects.equals(valuationTimestamp, _that.getValuationTimestamp())) return false;
			if (!Objects.equals(valuationMethod, _that.getValuationMethod())) return false;
			if (!Objects.equals(delta, _that.getDelta())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportingTimestamp != null ? reportingTimestamp.hashCode() : 0);
			_result = 31 * _result + (counterparty1 != null ? counterparty1.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (valuationAmount != null ? valuationAmount.hashCode() : 0);
			_result = 31 * _result + (valuationCurrency != null ? valuationCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationTimestamp != null ? valuationTimestamp.hashCode() : 0);
			_result = 31 * _result + (valuationMethod != null ? valuationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (delta != null ? delta.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (level != null ? level.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CriticalDataElement {" +
				"reportingTimestamp=" + this.reportingTimestamp + ", " +
				"counterparty1=" + this.counterparty1 + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"counterparty2=" + this.counterparty2 + ", " +
				"valuationAmount=" + this.valuationAmount + ", " +
				"valuationCurrency=" + this.valuationCurrency + ", " +
				"valuationTimestamp=" + this.valuationTimestamp + ", " +
				"valuationMethod=" + this.valuationMethod + ", " +
				"delta=" + this.delta + ", " +
				"actionType=" + this.actionType + ", " +
				"level=" + this.level +
			'}';
		}
	}

	/*********************** Builder Implementation of CriticalDataElement  ***********************/
	class CriticalDataElementBuilderImpl implements CriticalDataElement.CriticalDataElementBuilder {
	
		protected ZonedDateTime reportingTimestamp;
		protected String counterparty1;
		protected Boolean counterparty2IdentifierType;
		protected String counterparty2;
		protected BigDecimal valuationAmount;
		protected ISOCurrencyCodeEnum valuationCurrency;
		protected ZonedDateTime valuationTimestamp;
		protected ValuationType1Code valuationMethod;
		protected BigDecimal delta;
		protected ActionTypeEnum actionType;
		protected ReportLevelEnum level;
		
		@Override
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		public ZonedDateTime getReportingTimestamp() {
			return reportingTimestamp;
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
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
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
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valuationAmount")
		public BigDecimal getValuationAmount() {
			return valuationAmount;
		}
		
		@Override
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valuationCurrency")
		public ISOCurrencyCodeEnum getValuationCurrency() {
			return valuationCurrency;
		}
		
		@Override
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valuationTimestamp")
		public ZonedDateTime getValuationTimestamp() {
			return valuationTimestamp;
		}
		
		@Override
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valuationMethod")
		public ValuationType1Code getValuationMethod() {
			return valuationMethod;
		}
		
		@Override
		@RosettaAttribute("delta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("delta")
		public BigDecimal getDelta() {
			return delta;
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
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("level")
		public ReportLevelEnum getLevel() {
			return level;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty2")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationAmount")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationCurrency")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationTimestamp")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valuationMethod")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionType")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setActionType(ActionTypeEnum _actionType) {
			this.actionType = _actionType == null ? null : _actionType;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@Override
		public CriticalDataElement build() {
			return new CriticalDataElement.CriticalDataElementImpl(this);
		}
		
		@Override
		public CriticalDataElement.CriticalDataElementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReportingTimestamp()!=null) return true;
			if (getCounterparty1()!=null) return true;
			if (getCounterparty2IdentifierType()!=null) return true;
			if (getCounterparty2()!=null) return true;
			if (getValuationAmount()!=null) return true;
			if (getValuationCurrency()!=null) return true;
			if (getValuationTimestamp()!=null) return true;
			if (getValuationMethod()!=null) return true;
			if (getDelta()!=null) return true;
			if (getActionType()!=null) return true;
			if (getLevel()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CriticalDataElement.CriticalDataElementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CriticalDataElement.CriticalDataElementBuilder o = (CriticalDataElement.CriticalDataElementBuilder) other;
			
			
			merger.mergeBasic(getReportingTimestamp(), o.getReportingTimestamp(), this::setReportingTimestamp);
			merger.mergeBasic(getCounterparty1(), o.getCounterparty1(), this::setCounterparty1);
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierType);
			merger.mergeBasic(getCounterparty2(), o.getCounterparty2(), this::setCounterparty2);
			merger.mergeBasic(getValuationAmount(), o.getValuationAmount(), this::setValuationAmount);
			merger.mergeBasic(getValuationCurrency(), o.getValuationCurrency(), this::setValuationCurrency);
			merger.mergeBasic(getValuationTimestamp(), o.getValuationTimestamp(), this::setValuationTimestamp);
			merger.mergeBasic(getValuationMethod(), o.getValuationMethod(), this::setValuationMethod);
			merger.mergeBasic(getDelta(), o.getDelta(), this::setDelta);
			merger.mergeBasic(getActionType(), o.getActionType(), this::setActionType);
			merger.mergeBasic(getLevel(), o.getLevel(), this::setLevel);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CriticalDataElement _that = getType().cast(o);
		
			if (!Objects.equals(reportingTimestamp, _that.getReportingTimestamp())) return false;
			if (!Objects.equals(counterparty1, _that.getCounterparty1())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(valuationAmount, _that.getValuationAmount())) return false;
			if (!Objects.equals(valuationCurrency, _that.getValuationCurrency())) return false;
			if (!Objects.equals(valuationTimestamp, _that.getValuationTimestamp())) return false;
			if (!Objects.equals(valuationMethod, _that.getValuationMethod())) return false;
			if (!Objects.equals(delta, _that.getDelta())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportingTimestamp != null ? reportingTimestamp.hashCode() : 0);
			_result = 31 * _result + (counterparty1 != null ? counterparty1.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (valuationAmount != null ? valuationAmount.hashCode() : 0);
			_result = 31 * _result + (valuationCurrency != null ? valuationCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationTimestamp != null ? valuationTimestamp.hashCode() : 0);
			_result = 31 * _result + (valuationMethod != null ? valuationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (delta != null ? delta.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (level != null ? level.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CriticalDataElementBuilder {" +
				"reportingTimestamp=" + this.reportingTimestamp + ", " +
				"counterparty1=" + this.counterparty1 + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"counterparty2=" + this.counterparty2 + ", " +
				"valuationAmount=" + this.valuationAmount + ", " +
				"valuationCurrency=" + this.valuationCurrency + ", " +
				"valuationTimestamp=" + this.valuationTimestamp + ", " +
				"valuationMethod=" + this.valuationMethod + ", " +
				"delta=" + this.delta + ", " +
				"actionType=" + this.actionType + ", " +
				"level=" + this.level +
			'}';
		}
	}
}

package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanFloatingRateAccrualMeta;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A full definition of the accrual characteristics of a loan contract. This structure defines both the underlying base rate as well as any additional margins and costs associated with the loan contract.
 *
 */
@RosettaDataType(value="LoanFloatingRateAccrual", builder=LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanFloatingRateAccrual", model="fpml", builder=LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilderImpl.class, version="2.1.1")
public interface LoanFloatingRateAccrual extends AbstractLoanFloatingRateOptionBase {

	LoanFloatingRateAccrualMeta metaData = new LoanFloatingRateAccrualMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period begins.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period ends.
	 *
	 */
	ZonedDateTime getEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The actual number of days represented within the 'period'. This takes into account counting the appropriate convention.
	 *
	 */
	Integer getNumberOfDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the underlying interest rate is set or repriced. It is an actual (adjusted) date.
	 *
	 */
	ZonedDateTime getRateEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The actual underlying base rate associated with the period, defined as a percentage.
	 *
	 */
	BigDecimal getBaseRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Optionally defines a PIK spread.
	 *
	 */
	BigDecimal getPikSpread();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The funding loss spread currently applied to the interest rate period.
	 *
	 */
	BigDecimal getFundingLossSpread();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The default spread currently applied to the interest rate period.
	 *
	 */
	BigDecimal getDefaultSpread();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The mandatory cost rate currently applied to the interest rate period.
	 *
	 */
	BigDecimal getMandatoryCostRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The actual percentage rate charged to the borrower. (Base Rate + Interest Spread Adjustment + Spread + Default Rate + Funding Loss Rate + Mandatory Cost Rate) = All In Rate. This rate NEVER includes PIK.
	 *
	 */
	BigDecimal getAllInRate();

	/*********************** Build Methods  ***********************/
	LoanFloatingRateAccrual build();
	
	LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder toBuilder();
	
	static LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder builder() {
		return new LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanFloatingRateAccrual> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanFloatingRateAccrual> getType() {
		return LoanFloatingRateAccrual.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processRosetta(path.newSubPath("rate"), processor, LoanFloatingRate.class, getRate());
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
		processor.processBasic(path.newSubPath("rateEffectiveDate"), ZonedDateTime.class, getRateEffectiveDate(), this);
		processor.processBasic(path.newSubPath("baseRate"), BigDecimal.class, getBaseRate(), this);
		processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
		processor.processBasic(path.newSubPath("fundingLossSpread"), BigDecimal.class, getFundingLossSpread(), this);
		processor.processBasic(path.newSubPath("defaultSpread"), BigDecimal.class, getDefaultSpread(), this);
		processor.processBasic(path.newSubPath("mandatoryCostRate"), BigDecimal.class, getMandatoryCostRate(), this);
		processor.processBasic(path.newSubPath("allInRate"), BigDecimal.class, getAllInRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanFloatingRateAccrualBuilder extends LoanFloatingRateAccrual, AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilder {
		@Override
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		@Override
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		@Override
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setPaymentFrequency(Period paymentFrequency);
		@Override
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setRate(LoanFloatingRate rate);
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setStartDate(ZonedDateTime startDate);
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setEndDate(ZonedDateTime endDate);
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setNumberOfDays(Integer numberOfDays);
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setRateEffectiveDate(ZonedDateTime rateEffectiveDate);
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setBaseRate(BigDecimal baseRate);
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setPikSpread(BigDecimal pikSpread);
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setFundingLossSpread(BigDecimal fundingLossSpread);
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setDefaultSpread(BigDecimal defaultSpread);
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setMandatoryCostRate(BigDecimal mandatoryCostRate);
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setAllInRate(BigDecimal allInRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("rate"), processor, LoanFloatingRate.LoanFloatingRateBuilder.class, getRate());
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
			processor.processBasic(path.newSubPath("rateEffectiveDate"), ZonedDateTime.class, getRateEffectiveDate(), this);
			processor.processBasic(path.newSubPath("baseRate"), BigDecimal.class, getBaseRate(), this);
			processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
			processor.processBasic(path.newSubPath("fundingLossSpread"), BigDecimal.class, getFundingLossSpread(), this);
			processor.processBasic(path.newSubPath("defaultSpread"), BigDecimal.class, getDefaultSpread(), this);
			processor.processBasic(path.newSubPath("mandatoryCostRate"), BigDecimal.class, getMandatoryCostRate(), this);
			processor.processBasic(path.newSubPath("allInRate"), BigDecimal.class, getAllInRate(), this);
		}
		

		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of LoanFloatingRateAccrual  ***********************/
	class LoanFloatingRateAccrualImpl extends AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseImpl implements LoanFloatingRateAccrual {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final Integer numberOfDays;
		private final ZonedDateTime rateEffectiveDate;
		private final BigDecimal baseRate;
		private final BigDecimal pikSpread;
		private final BigDecimal fundingLossSpread;
		private final BigDecimal defaultSpread;
		private final BigDecimal mandatoryCostRate;
		private final BigDecimal allInRate;
		
		protected LoanFloatingRateAccrualImpl(LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder builder) {
			super(builder);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.numberOfDays = builder.getNumberOfDays();
			this.rateEffectiveDate = builder.getRateEffectiveDate();
			this.baseRate = builder.getBaseRate();
			this.pikSpread = builder.getPikSpread();
			this.fundingLossSpread = builder.getFundingLossSpread();
			this.defaultSpread = builder.getDefaultSpread();
			this.mandatoryCostRate = builder.getMandatoryCostRate();
			this.allInRate = builder.getAllInRate();
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberOfDays")
		public Integer getNumberOfDays() {
			return numberOfDays;
		}
		
		@Override
		@RosettaAttribute("rateEffectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateEffectiveDate")
		public ZonedDateTime getRateEffectiveDate() {
			return rateEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("baseRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseRate")
		public BigDecimal getBaseRate() {
			return baseRate;
		}
		
		@Override
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pikSpread")
		public BigDecimal getPikSpread() {
			return pikSpread;
		}
		
		@Override
		@RosettaAttribute("fundingLossSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fundingLossSpread")
		public BigDecimal getFundingLossSpread() {
			return fundingLossSpread;
		}
		
		@Override
		@RosettaAttribute("defaultSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("defaultSpread")
		public BigDecimal getDefaultSpread() {
			return defaultSpread;
		}
		
		@Override
		@RosettaAttribute("mandatoryCostRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryCostRate")
		public BigDecimal getMandatoryCostRate() {
			return mandatoryCostRate;
		}
		
		@Override
		@RosettaAttribute("allInRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allInRate")
		public BigDecimal getAllInRate() {
			return allInRate;
		}
		
		@Override
		public LoanFloatingRateAccrual build() {
			return this;
		}
		
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder toBuilder() {
			LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getNumberOfDays()).ifPresent(builder::setNumberOfDays);
			ofNullable(getRateEffectiveDate()).ifPresent(builder::setRateEffectiveDate);
			ofNullable(getBaseRate()).ifPresent(builder::setBaseRate);
			ofNullable(getPikSpread()).ifPresent(builder::setPikSpread);
			ofNullable(getFundingLossSpread()).ifPresent(builder::setFundingLossSpread);
			ofNullable(getDefaultSpread()).ifPresent(builder::setDefaultSpread);
			ofNullable(getMandatoryCostRate()).ifPresent(builder::setMandatoryCostRate);
			ofNullable(getAllInRate()).ifPresent(builder::setAllInRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanFloatingRateAccrual _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(rateEffectiveDate, _that.getRateEffectiveDate())) return false;
			if (!Objects.equals(baseRate, _that.getBaseRate())) return false;
			if (!Objects.equals(pikSpread, _that.getPikSpread())) return false;
			if (!Objects.equals(fundingLossSpread, _that.getFundingLossSpread())) return false;
			if (!Objects.equals(defaultSpread, _that.getDefaultSpread())) return false;
			if (!Objects.equals(mandatoryCostRate, _that.getMandatoryCostRate())) return false;
			if (!Objects.equals(allInRate, _that.getAllInRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			_result = 31 * _result + (rateEffectiveDate != null ? rateEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (baseRate != null ? baseRate.hashCode() : 0);
			_result = 31 * _result + (pikSpread != null ? pikSpread.hashCode() : 0);
			_result = 31 * _result + (fundingLossSpread != null ? fundingLossSpread.hashCode() : 0);
			_result = 31 * _result + (defaultSpread != null ? defaultSpread.hashCode() : 0);
			_result = 31 * _result + (mandatoryCostRate != null ? mandatoryCostRate.hashCode() : 0);
			_result = 31 * _result + (allInRate != null ? allInRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanFloatingRateAccrual {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"numberOfDays=" + this.numberOfDays + ", " +
				"rateEffectiveDate=" + this.rateEffectiveDate + ", " +
				"baseRate=" + this.baseRate + ", " +
				"pikSpread=" + this.pikSpread + ", " +
				"fundingLossSpread=" + this.fundingLossSpread + ", " +
				"defaultSpread=" + this.defaultSpread + ", " +
				"mandatoryCostRate=" + this.mandatoryCostRate + ", " +
				"allInRate=" + this.allInRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanFloatingRateAccrual  ***********************/
	class LoanFloatingRateAccrualBuilderImpl extends AbstractLoanFloatingRateOptionBase.AbstractLoanFloatingRateOptionBaseBuilderImpl implements LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected Integer numberOfDays;
		protected ZonedDateTime rateEffectiveDate;
		protected BigDecimal baseRate;
		protected BigDecimal pikSpread;
		protected BigDecimal fundingLossSpread;
		protected BigDecimal defaultSpread;
		protected BigDecimal mandatoryCostRate;
		protected BigDecimal allInRate;
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberOfDays")
		public Integer getNumberOfDays() {
			return numberOfDays;
		}
		
		@Override
		@RosettaAttribute("rateEffectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateEffectiveDate")
		public ZonedDateTime getRateEffectiveDate() {
			return rateEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("baseRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseRate")
		public BigDecimal getBaseRate() {
			return baseRate;
		}
		
		@Override
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pikSpread")
		public BigDecimal getPikSpread() {
			return pikSpread;
		}
		
		@Override
		@RosettaAttribute("fundingLossSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fundingLossSpread")
		public BigDecimal getFundingLossSpread() {
			return fundingLossSpread;
		}
		
		@Override
		@RosettaAttribute("defaultSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("defaultSpread")
		public BigDecimal getDefaultSpread() {
			return defaultSpread;
		}
		
		@Override
		@RosettaAttribute("mandatoryCostRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryCostRate")
		public BigDecimal getMandatoryCostRate() {
			return mandatoryCostRate;
		}
		
		@Override
		@RosettaAttribute("allInRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allInRate")
		public BigDecimal getAllInRate() {
			return allInRate;
		}
		
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setRate(LoanFloatingRate _rate) {
			this.rate = _rate == null ? null : _rate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("numberOfDays")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setNumberOfDays(Integer _numberOfDays) {
			this.numberOfDays = _numberOfDays == null ? null : _numberOfDays;
			return this;
		}
		
		@RosettaAttribute("rateEffectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateEffectiveDate")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setRateEffectiveDate(ZonedDateTime _rateEffectiveDate) {
			this.rateEffectiveDate = _rateEffectiveDate == null ? null : _rateEffectiveDate;
			return this;
		}
		
		@RosettaAttribute("baseRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseRate")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setBaseRate(BigDecimal _baseRate) {
			this.baseRate = _baseRate == null ? null : _baseRate;
			return this;
		}
		
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pikSpread")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setPikSpread(BigDecimal _pikSpread) {
			this.pikSpread = _pikSpread == null ? null : _pikSpread;
			return this;
		}
		
		@RosettaAttribute("fundingLossSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fundingLossSpread")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setFundingLossSpread(BigDecimal _fundingLossSpread) {
			this.fundingLossSpread = _fundingLossSpread == null ? null : _fundingLossSpread;
			return this;
		}
		
		@RosettaAttribute("defaultSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("defaultSpread")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setDefaultSpread(BigDecimal _defaultSpread) {
			this.defaultSpread = _defaultSpread == null ? null : _defaultSpread;
			return this;
		}
		
		@RosettaAttribute("mandatoryCostRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryCostRate")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setMandatoryCostRate(BigDecimal _mandatoryCostRate) {
			this.mandatoryCostRate = _mandatoryCostRate == null ? null : _mandatoryCostRate;
			return this;
		}
		
		@RosettaAttribute("allInRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allInRate")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder setAllInRate(BigDecimal _allInRate) {
			this.allInRate = _allInRate == null ? null : _allInRate;
			return this;
		}
		
		@Override
		public LoanFloatingRateAccrual build() {
			return new LoanFloatingRateAccrual.LoanFloatingRateAccrualImpl(this);
		}
		
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getNumberOfDays()!=null) return true;
			if (getRateEffectiveDate()!=null) return true;
			if (getBaseRate()!=null) return true;
			if (getPikSpread()!=null) return true;
			if (getFundingLossSpread()!=null) return true;
			if (getDefaultSpread()!=null) return true;
			if (getMandatoryCostRate()!=null) return true;
			if (getAllInRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder o = (LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder) other;
			
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getNumberOfDays(), o.getNumberOfDays(), this::setNumberOfDays);
			merger.mergeBasic(getRateEffectiveDate(), o.getRateEffectiveDate(), this::setRateEffectiveDate);
			merger.mergeBasic(getBaseRate(), o.getBaseRate(), this::setBaseRate);
			merger.mergeBasic(getPikSpread(), o.getPikSpread(), this::setPikSpread);
			merger.mergeBasic(getFundingLossSpread(), o.getFundingLossSpread(), this::setFundingLossSpread);
			merger.mergeBasic(getDefaultSpread(), o.getDefaultSpread(), this::setDefaultSpread);
			merger.mergeBasic(getMandatoryCostRate(), o.getMandatoryCostRate(), this::setMandatoryCostRate);
			merger.mergeBasic(getAllInRate(), o.getAllInRate(), this::setAllInRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanFloatingRateAccrual _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(rateEffectiveDate, _that.getRateEffectiveDate())) return false;
			if (!Objects.equals(baseRate, _that.getBaseRate())) return false;
			if (!Objects.equals(pikSpread, _that.getPikSpread())) return false;
			if (!Objects.equals(fundingLossSpread, _that.getFundingLossSpread())) return false;
			if (!Objects.equals(defaultSpread, _that.getDefaultSpread())) return false;
			if (!Objects.equals(mandatoryCostRate, _that.getMandatoryCostRate())) return false;
			if (!Objects.equals(allInRate, _that.getAllInRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			_result = 31 * _result + (rateEffectiveDate != null ? rateEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (baseRate != null ? baseRate.hashCode() : 0);
			_result = 31 * _result + (pikSpread != null ? pikSpread.hashCode() : 0);
			_result = 31 * _result + (fundingLossSpread != null ? fundingLossSpread.hashCode() : 0);
			_result = 31 * _result + (defaultSpread != null ? defaultSpread.hashCode() : 0);
			_result = 31 * _result + (mandatoryCostRate != null ? mandatoryCostRate.hashCode() : 0);
			_result = 31 * _result + (allInRate != null ? allInRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanFloatingRateAccrualBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"numberOfDays=" + this.numberOfDays + ", " +
				"rateEffectiveDate=" + this.rateEffectiveDate + ", " +
				"baseRate=" + this.baseRate + ", " +
				"pikSpread=" + this.pikSpread + ", " +
				"fundingLossSpread=" + this.fundingLossSpread + ", " +
				"defaultSpread=" + this.defaultSpread + ", " +
				"mandatoryCostRate=" + this.mandatoryCostRate + ", " +
				"allInRate=" + this.allInRate +
			'}' + " " + super.toString();
		}
	}
}

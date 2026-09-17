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
import fpml.consolidated.loan.meta.LegacyFloatingRateAccrualMeta;
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
 * Provision A full definition of the legacy version (pre-IBOR replacement) of accrual characteristics of a loan contract. This structure defines both the underlying base rate as well as any additional margins and costs associated with the loan contract.
 *
 */
@RosettaDataType(value="LegacyFloatingRateAccrual", builder=LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LegacyFloatingRateAccrual", model="fpml", builder=LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilderImpl.class, version="2.1.1")
public interface LegacyFloatingRateAccrual extends AbstractLegacyFloatingRateOptionBase {

	LegacyFloatingRateAccrualMeta metaData = new LegacyFloatingRateAccrualMeta();

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
	 * Provision The date on which the underlying interest rate is fixed. It is an actual (adjusted) date. Note: This should default to the effective date of the loan contract in the case of a PRIME base rate.
	 *
	 */
	ZonedDateTime getRateFixingDate();
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
	 * Provision The penalty spread currently applied to the interest rate period.
	 *
	 */
	BigDecimal getPenaltySpread();
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
	 * Provision The actual percentage rate charged to the borrower. (Base Rate + Spread + Default Rate + Penalty Rate + Mandatory Cost Rate) = All In Rate. This rate NEVER includes PIK.
	 *
	 */
	BigDecimal getAllInRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Projected interest payment details.
	 *
	 */
	PaymentProjection getPaymentProjection();

	/*********************** Build Methods  ***********************/
	LegacyFloatingRateAccrual build();
	
	LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder toBuilder();
	
	static LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder builder() {
		return new LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyFloatingRateAccrual> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyFloatingRateAccrual> getType() {
		return LegacyFloatingRateAccrual.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processRosetta(path.newSubPath("legacyFloatingRateIndex"), processor, LegacyFloatingRateIndexLoan.class, getLegacyFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
		processor.processBasic(path.newSubPath("rateFixingDate"), ZonedDateTime.class, getRateFixingDate(), this);
		processor.processBasic(path.newSubPath("baseRate"), BigDecimal.class, getBaseRate(), this);
		processor.processBasic(path.newSubPath("penaltySpread"), BigDecimal.class, getPenaltySpread(), this);
		processor.processBasic(path.newSubPath("defaultSpread"), BigDecimal.class, getDefaultSpread(), this);
		processor.processBasic(path.newSubPath("mandatoryCostRate"), BigDecimal.class, getMandatoryCostRate(), this);
		processor.processBasic(path.newSubPath("allInRate"), BigDecimal.class, getAllInRate(), this);
		processRosetta(path.newSubPath("paymentProjection"), processor, PaymentProjection.class, getPaymentProjection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyFloatingRateAccrualBuilder extends LegacyFloatingRateAccrual, AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilder {
		PaymentProjection.PaymentProjectionBuilder getOrCreatePaymentProjection();
		@Override
		PaymentProjection.PaymentProjectionBuilder getPaymentProjection();
		@Override
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		@Override
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		@Override
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setPaymentFrequency(Period paymentFrequency);
		@Override
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setLegacyFloatingRateIndex(LegacyFloatingRateIndexLoan legacyFloatingRateIndex);
		@Override
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setIndexTenor(Period indexTenor);
		@Override
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setSpread(BigDecimal spread);
		@Override
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setPikSpread(BigDecimal pikSpread);
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setStartDate(ZonedDateTime startDate);
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setEndDate(ZonedDateTime endDate);
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setNumberOfDays(Integer numberOfDays);
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setRateFixingDate(ZonedDateTime rateFixingDate);
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setBaseRate(BigDecimal baseRate);
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setPenaltySpread(BigDecimal penaltySpread);
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setDefaultSpread(BigDecimal defaultSpread);
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setMandatoryCostRate(BigDecimal mandatoryCostRate);
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setAllInRate(BigDecimal allInRate);
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setPaymentProjection(PaymentProjection paymentProjection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("legacyFloatingRateIndex"), processor, LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder.class, getLegacyFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
			processor.processBasic(path.newSubPath("rateFixingDate"), ZonedDateTime.class, getRateFixingDate(), this);
			processor.processBasic(path.newSubPath("baseRate"), BigDecimal.class, getBaseRate(), this);
			processor.processBasic(path.newSubPath("penaltySpread"), BigDecimal.class, getPenaltySpread(), this);
			processor.processBasic(path.newSubPath("defaultSpread"), BigDecimal.class, getDefaultSpread(), this);
			processor.processBasic(path.newSubPath("mandatoryCostRate"), BigDecimal.class, getMandatoryCostRate(), this);
			processor.processBasic(path.newSubPath("allInRate"), BigDecimal.class, getAllInRate(), this);
			processRosetta(path.newSubPath("paymentProjection"), processor, PaymentProjection.PaymentProjectionBuilder.class, getPaymentProjection());
		}
		

		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyFloatingRateAccrual  ***********************/
	class LegacyFloatingRateAccrualImpl extends AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseImpl implements LegacyFloatingRateAccrual {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final Integer numberOfDays;
		private final ZonedDateTime rateFixingDate;
		private final BigDecimal baseRate;
		private final BigDecimal penaltySpread;
		private final BigDecimal defaultSpread;
		private final BigDecimal mandatoryCostRate;
		private final BigDecimal allInRate;
		private final PaymentProjection paymentProjection;
		
		protected LegacyFloatingRateAccrualImpl(LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder builder) {
			super(builder);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.numberOfDays = builder.getNumberOfDays();
			this.rateFixingDate = builder.getRateFixingDate();
			this.baseRate = builder.getBaseRate();
			this.penaltySpread = builder.getPenaltySpread();
			this.defaultSpread = builder.getDefaultSpread();
			this.mandatoryCostRate = builder.getMandatoryCostRate();
			this.allInRate = builder.getAllInRate();
			this.paymentProjection = ofNullable(builder.getPaymentProjection()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("rateFixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateFixingDate")
		public ZonedDateTime getRateFixingDate() {
			return rateFixingDate;
		}
		
		@Override
		@RosettaAttribute("baseRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseRate")
		public BigDecimal getBaseRate() {
			return baseRate;
		}
		
		@Override
		@RosettaAttribute("penaltySpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("penaltySpread")
		public BigDecimal getPenaltySpread() {
			return penaltySpread;
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
		@RosettaAttribute("paymentProjection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentProjection")
		public PaymentProjection getPaymentProjection() {
			return paymentProjection;
		}
		
		@Override
		public LegacyFloatingRateAccrual build() {
			return this;
		}
		
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder toBuilder() {
			LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getNumberOfDays()).ifPresent(builder::setNumberOfDays);
			ofNullable(getRateFixingDate()).ifPresent(builder::setRateFixingDate);
			ofNullable(getBaseRate()).ifPresent(builder::setBaseRate);
			ofNullable(getPenaltySpread()).ifPresent(builder::setPenaltySpread);
			ofNullable(getDefaultSpread()).ifPresent(builder::setDefaultSpread);
			ofNullable(getMandatoryCostRate()).ifPresent(builder::setMandatoryCostRate);
			ofNullable(getAllInRate()).ifPresent(builder::setAllInRate);
			ofNullable(getPaymentProjection()).ifPresent(builder::setPaymentProjection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LegacyFloatingRateAccrual _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(rateFixingDate, _that.getRateFixingDate())) return false;
			if (!Objects.equals(baseRate, _that.getBaseRate())) return false;
			if (!Objects.equals(penaltySpread, _that.getPenaltySpread())) return false;
			if (!Objects.equals(defaultSpread, _that.getDefaultSpread())) return false;
			if (!Objects.equals(mandatoryCostRate, _that.getMandatoryCostRate())) return false;
			if (!Objects.equals(allInRate, _that.getAllInRate())) return false;
			if (!Objects.equals(paymentProjection, _that.getPaymentProjection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			_result = 31 * _result + (rateFixingDate != null ? rateFixingDate.hashCode() : 0);
			_result = 31 * _result + (baseRate != null ? baseRate.hashCode() : 0);
			_result = 31 * _result + (penaltySpread != null ? penaltySpread.hashCode() : 0);
			_result = 31 * _result + (defaultSpread != null ? defaultSpread.hashCode() : 0);
			_result = 31 * _result + (mandatoryCostRate != null ? mandatoryCostRate.hashCode() : 0);
			_result = 31 * _result + (allInRate != null ? allInRate.hashCode() : 0);
			_result = 31 * _result + (paymentProjection != null ? paymentProjection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyFloatingRateAccrual {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"numberOfDays=" + this.numberOfDays + ", " +
				"rateFixingDate=" + this.rateFixingDate + ", " +
				"baseRate=" + this.baseRate + ", " +
				"penaltySpread=" + this.penaltySpread + ", " +
				"defaultSpread=" + this.defaultSpread + ", " +
				"mandatoryCostRate=" + this.mandatoryCostRate + ", " +
				"allInRate=" + this.allInRate + ", " +
				"paymentProjection=" + this.paymentProjection +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LegacyFloatingRateAccrual  ***********************/
	class LegacyFloatingRateAccrualBuilderImpl extends AbstractLegacyFloatingRateOptionBase.AbstractLegacyFloatingRateOptionBaseBuilderImpl implements LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected Integer numberOfDays;
		protected ZonedDateTime rateFixingDate;
		protected BigDecimal baseRate;
		protected BigDecimal penaltySpread;
		protected BigDecimal defaultSpread;
		protected BigDecimal mandatoryCostRate;
		protected BigDecimal allInRate;
		protected PaymentProjection.PaymentProjectionBuilder paymentProjection;
		
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
		@RosettaAttribute("rateFixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateFixingDate")
		public ZonedDateTime getRateFixingDate() {
			return rateFixingDate;
		}
		
		@Override
		@RosettaAttribute("baseRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseRate")
		public BigDecimal getBaseRate() {
			return baseRate;
		}
		
		@Override
		@RosettaAttribute("penaltySpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("penaltySpread")
		public BigDecimal getPenaltySpread() {
			return penaltySpread;
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
		@RosettaAttribute("paymentProjection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentProjection")
		public PaymentProjection.PaymentProjectionBuilder getPaymentProjection() {
			return paymentProjection;
		}
		
		@Override
		public PaymentProjection.PaymentProjectionBuilder getOrCreatePaymentProjection() {
			PaymentProjection.PaymentProjectionBuilder result;
			if (paymentProjection!=null) {
				result = paymentProjection;
			}
			else {
				result = paymentProjection = PaymentProjection.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyFloatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legacyFloatingRateIndex")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setLegacyFloatingRateIndex(LegacyFloatingRateIndexLoan _legacyFloatingRateIndex) {
			this.legacyFloatingRateIndex = _legacyFloatingRateIndex == null ? null : _legacyFloatingRateIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexTenor")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setIndexTenor(Period _indexTenor) {
			this.indexTenor = _indexTenor == null ? null : _indexTenor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("spread")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setSpread(BigDecimal _spread) {
			this.spread = _spread == null ? null : _spread;
			return this;
		}
		
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pikSpread")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setPikSpread(BigDecimal _pikSpread) {
			this.pikSpread = _pikSpread == null ? null : _pikSpread;
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("numberOfDays")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setNumberOfDays(Integer _numberOfDays) {
			this.numberOfDays = _numberOfDays == null ? null : _numberOfDays;
			return this;
		}
		
		@RosettaAttribute("rateFixingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateFixingDate")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setRateFixingDate(ZonedDateTime _rateFixingDate) {
			this.rateFixingDate = _rateFixingDate == null ? null : _rateFixingDate;
			return this;
		}
		
		@RosettaAttribute("baseRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseRate")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setBaseRate(BigDecimal _baseRate) {
			this.baseRate = _baseRate == null ? null : _baseRate;
			return this;
		}
		
		@RosettaAttribute("penaltySpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("penaltySpread")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setPenaltySpread(BigDecimal _penaltySpread) {
			this.penaltySpread = _penaltySpread == null ? null : _penaltySpread;
			return this;
		}
		
		@RosettaAttribute("defaultSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("defaultSpread")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setDefaultSpread(BigDecimal _defaultSpread) {
			this.defaultSpread = _defaultSpread == null ? null : _defaultSpread;
			return this;
		}
		
		@RosettaAttribute("mandatoryCostRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryCostRate")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setMandatoryCostRate(BigDecimal _mandatoryCostRate) {
			this.mandatoryCostRate = _mandatoryCostRate == null ? null : _mandatoryCostRate;
			return this;
		}
		
		@RosettaAttribute("allInRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allInRate")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setAllInRate(BigDecimal _allInRate) {
			this.allInRate = _allInRate == null ? null : _allInRate;
			return this;
		}
		
		@RosettaAttribute("paymentProjection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentProjection")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder setPaymentProjection(PaymentProjection _paymentProjection) {
			this.paymentProjection = _paymentProjection == null ? null : _paymentProjection.toBuilder();
			return this;
		}
		
		@Override
		public LegacyFloatingRateAccrual build() {
			return new LegacyFloatingRateAccrual.LegacyFloatingRateAccrualImpl(this);
		}
		
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder prune() {
			super.prune();
			if (paymentProjection!=null && !paymentProjection.prune().hasData()) paymentProjection = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getNumberOfDays()!=null) return true;
			if (getRateFixingDate()!=null) return true;
			if (getBaseRate()!=null) return true;
			if (getPenaltySpread()!=null) return true;
			if (getDefaultSpread()!=null) return true;
			if (getMandatoryCostRate()!=null) return true;
			if (getAllInRate()!=null) return true;
			if (getPaymentProjection()!=null && getPaymentProjection().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder o = (LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder) other;
			
			merger.mergeRosetta(getPaymentProjection(), o.getPaymentProjection(), this::setPaymentProjection);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getNumberOfDays(), o.getNumberOfDays(), this::setNumberOfDays);
			merger.mergeBasic(getRateFixingDate(), o.getRateFixingDate(), this::setRateFixingDate);
			merger.mergeBasic(getBaseRate(), o.getBaseRate(), this::setBaseRate);
			merger.mergeBasic(getPenaltySpread(), o.getPenaltySpread(), this::setPenaltySpread);
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
		
			LegacyFloatingRateAccrual _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(rateFixingDate, _that.getRateFixingDate())) return false;
			if (!Objects.equals(baseRate, _that.getBaseRate())) return false;
			if (!Objects.equals(penaltySpread, _that.getPenaltySpread())) return false;
			if (!Objects.equals(defaultSpread, _that.getDefaultSpread())) return false;
			if (!Objects.equals(mandatoryCostRate, _that.getMandatoryCostRate())) return false;
			if (!Objects.equals(allInRate, _that.getAllInRate())) return false;
			if (!Objects.equals(paymentProjection, _that.getPaymentProjection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			_result = 31 * _result + (rateFixingDate != null ? rateFixingDate.hashCode() : 0);
			_result = 31 * _result + (baseRate != null ? baseRate.hashCode() : 0);
			_result = 31 * _result + (penaltySpread != null ? penaltySpread.hashCode() : 0);
			_result = 31 * _result + (defaultSpread != null ? defaultSpread.hashCode() : 0);
			_result = 31 * _result + (mandatoryCostRate != null ? mandatoryCostRate.hashCode() : 0);
			_result = 31 * _result + (allInRate != null ? allInRate.hashCode() : 0);
			_result = 31 * _result + (paymentProjection != null ? paymentProjection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyFloatingRateAccrualBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"numberOfDays=" + this.numberOfDays + ", " +
				"rateFixingDate=" + this.rateFixingDate + ", " +
				"baseRate=" + this.baseRate + ", " +
				"penaltySpread=" + this.penaltySpread + ", " +
				"defaultSpread=" + this.defaultSpread + ", " +
				"mandatoryCostRate=" + this.mandatoryCostRate + ", " +
				"allInRate=" + this.allInRate + ", " +
				"paymentProjection=" + this.paymentProjection +
			'}' + " " + super.toString();
		}
	}
}

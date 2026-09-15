package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.CalculationPeriodMeta;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the parameters used in the calculation of a fixed or floating rate calculation period amount. This type forms part of cashflows representation of a swap stream.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the parameters used in the calculation of a fixed or floating rate calculation period amount. This type forms part of cashflows representation of a swap stream.
 *
 */
@RosettaDataType(value="CalculationPeriod", builder=CalculationPeriod.CalculationPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CalculationPeriod", model="fpml", builder=CalculationPeriod.CalculationPeriodBuilderImpl.class, version="2.1.1")
public interface CalculationPeriod extends RosettaModelObject {

	CalculationPeriodMeta metaData = new CalculationPeriodMeta();

	/*********************** Getter Methods  ***********************/
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
	String getId();
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
	ZonedDateTime getUnadjustedStartDate();
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
	ZonedDateTime getUnadjustedEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calculation period start date, adjusted according to any relevant business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculation period start date, adjusted according to any relevant business day convention.
	 *
	 */
	ZonedDateTime getAdjustedStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calculation period end date, adjusted according to any relevant business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculation period end date, adjusted according to any relevant business day convention.
	 *
	 */
	ZonedDateTime getAdjustedEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of days from the adjusted effective / start date to the adjusted termination / end date calculated in accordance with the applicable day count fraction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of days from the adjusted effective / start date to the adjusted termination / end date calculated in accordance with the applicable day count fraction.
	 *
	 */
	Integer getCalculationPeriodNumberOfDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount that a cashflow will accrue interest on.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount that a cashflow will accrue interest on.
	 *
	 */
	BigDecimal getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount that a cashflow will accrue interest on. This is the calculated amount of the fx linked - ie the other currency notional amount multiplied by the appropriate fx spot rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount that a cashflow will accrue interest on. This is the calculated amount of the fx linked - ie the other currency notional amount multiplied by the appropriate fx spot rate.
	 *
	 */
	FxLinkedNotionalAmount getFxLinkedNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The floating rate reset information for the calculation period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The floating rate reset information for the calculation period.
	 *
	 */
	FloatingRateDefinition getFloatingRateDefinition();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculation period fixed rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05.
	 *
	 */
	BigDecimal getFixedRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The year fraction value of the calculation period, result of applying the ISDA rules for day count fraction defined in the ISDA Annex.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The year fraction value of the calculation period, result of applying the ISDA rules for day count fraction defined in the ISDA Annex.
	 *
	 */
	BigDecimal getDayCountYearFraction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount representing the forecast of the accrued value of the calculation period. An intermediate value used to generate the forecastPaymentAmount in the PaymentCalculationPeriod.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount representing the forecast of the accrued value of the calculation period. An intermediate value used to generate the forecastPaymentAmount in the PaymentCalculationPeriod.
	 *
	 */
	Money getForecastAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A value representing the forecast rate used to calculate the forecast future value of the accrual period. This is a calculated rate determined based on averaging the rates in the rateObservation elements, and incorporates all of the rate treatment and averaging rules. A value of 1% should be represented as 0.01
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A value representing the forecast rate used to calculate the forecast future value of the accrual period. This is a calculated rate determined based on averaging the rates in the rateObservation elements, and incorporates all of the rate treatment and averaging rules. A value of 1% should be represented as 0.01
	 *
	 */
	BigDecimal getForecastRate();

	/*********************** Build Methods  ***********************/
	CalculationPeriod build();
	
	CalculationPeriod.CalculationPeriodBuilder toBuilder();
	
	static CalculationPeriod.CalculationPeriodBuilder builder() {
		return new CalculationPeriod.CalculationPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationPeriod> getType() {
		return CalculationPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("unadjustedStartDate"), ZonedDateTime.class, getUnadjustedStartDate(), this);
		processor.processBasic(path.newSubPath("unadjustedEndDate"), ZonedDateTime.class, getUnadjustedEndDate(), this);
		processor.processBasic(path.newSubPath("adjustedStartDate"), ZonedDateTime.class, getAdjustedStartDate(), this);
		processor.processBasic(path.newSubPath("adjustedEndDate"), ZonedDateTime.class, getAdjustedEndDate(), this);
		processor.processBasic(path.newSubPath("calculationPeriodNumberOfDays"), Integer.class, getCalculationPeriodNumberOfDays(), this);
		processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
		processRosetta(path.newSubPath("fxLinkedNotionalAmount"), processor, FxLinkedNotionalAmount.class, getFxLinkedNotionalAmount());
		processRosetta(path.newSubPath("floatingRateDefinition"), processor, FloatingRateDefinition.class, getFloatingRateDefinition());
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		processor.processBasic(path.newSubPath("dayCountYearFraction"), BigDecimal.class, getDayCountYearFraction(), this);
		processRosetta(path.newSubPath("forecastAmount"), processor, Money.class, getForecastAmount());
		processor.processBasic(path.newSubPath("forecastRate"), BigDecimal.class, getForecastRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationPeriodBuilder extends CalculationPeriod, RosettaModelObjectBuilder {
		FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder getOrCreateFxLinkedNotionalAmount();
		@Override
		FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder getFxLinkedNotionalAmount();
		FloatingRateDefinition.FloatingRateDefinitionBuilder getOrCreateFloatingRateDefinition();
		@Override
		FloatingRateDefinition.FloatingRateDefinitionBuilder getFloatingRateDefinition();
		Money.MoneyBuilder getOrCreateForecastAmount();
		@Override
		Money.MoneyBuilder getForecastAmount();
		CalculationPeriod.CalculationPeriodBuilder setId(String id);
		CalculationPeriod.CalculationPeriodBuilder setUnadjustedStartDate(ZonedDateTime unadjustedStartDate);
		CalculationPeriod.CalculationPeriodBuilder setUnadjustedEndDate(ZonedDateTime unadjustedEndDate);
		CalculationPeriod.CalculationPeriodBuilder setAdjustedStartDate(ZonedDateTime adjustedStartDate);
		CalculationPeriod.CalculationPeriodBuilder setAdjustedEndDate(ZonedDateTime adjustedEndDate);
		CalculationPeriod.CalculationPeriodBuilder setCalculationPeriodNumberOfDays(Integer calculationPeriodNumberOfDays);
		CalculationPeriod.CalculationPeriodBuilder setNotionalAmount(BigDecimal notionalAmount);
		CalculationPeriod.CalculationPeriodBuilder setFxLinkedNotionalAmount(FxLinkedNotionalAmount fxLinkedNotionalAmount);
		CalculationPeriod.CalculationPeriodBuilder setFloatingRateDefinition(FloatingRateDefinition floatingRateDefinition);
		CalculationPeriod.CalculationPeriodBuilder setFixedRate(BigDecimal fixedRate);
		CalculationPeriod.CalculationPeriodBuilder setDayCountYearFraction(BigDecimal dayCountYearFraction);
		CalculationPeriod.CalculationPeriodBuilder setForecastAmount(Money forecastAmount);
		CalculationPeriod.CalculationPeriodBuilder setForecastRate(BigDecimal forecastRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("unadjustedStartDate"), ZonedDateTime.class, getUnadjustedStartDate(), this);
			processor.processBasic(path.newSubPath("unadjustedEndDate"), ZonedDateTime.class, getUnadjustedEndDate(), this);
			processor.processBasic(path.newSubPath("adjustedStartDate"), ZonedDateTime.class, getAdjustedStartDate(), this);
			processor.processBasic(path.newSubPath("adjustedEndDate"), ZonedDateTime.class, getAdjustedEndDate(), this);
			processor.processBasic(path.newSubPath("calculationPeriodNumberOfDays"), Integer.class, getCalculationPeriodNumberOfDays(), this);
			processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
			processRosetta(path.newSubPath("fxLinkedNotionalAmount"), processor, FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder.class, getFxLinkedNotionalAmount());
			processRosetta(path.newSubPath("floatingRateDefinition"), processor, FloatingRateDefinition.FloatingRateDefinitionBuilder.class, getFloatingRateDefinition());
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
			processor.processBasic(path.newSubPath("dayCountYearFraction"), BigDecimal.class, getDayCountYearFraction(), this);
			processRosetta(path.newSubPath("forecastAmount"), processor, Money.MoneyBuilder.class, getForecastAmount());
			processor.processBasic(path.newSubPath("forecastRate"), BigDecimal.class, getForecastRate(), this);
		}
		

		CalculationPeriod.CalculationPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationPeriod  ***********************/
	class CalculationPeriodImpl implements CalculationPeriod {
		private final String id;
		private final ZonedDateTime unadjustedStartDate;
		private final ZonedDateTime unadjustedEndDate;
		private final ZonedDateTime adjustedStartDate;
		private final ZonedDateTime adjustedEndDate;
		private final Integer calculationPeriodNumberOfDays;
		private final BigDecimal notionalAmount;
		private final FxLinkedNotionalAmount fxLinkedNotionalAmount;
		private final FloatingRateDefinition floatingRateDefinition;
		private final BigDecimal fixedRate;
		private final BigDecimal dayCountYearFraction;
		private final Money forecastAmount;
		private final BigDecimal forecastRate;
		
		protected CalculationPeriodImpl(CalculationPeriod.CalculationPeriodBuilder builder) {
			this.id = builder.getId();
			this.unadjustedStartDate = builder.getUnadjustedStartDate();
			this.unadjustedEndDate = builder.getUnadjustedEndDate();
			this.adjustedStartDate = builder.getAdjustedStartDate();
			this.adjustedEndDate = builder.getAdjustedEndDate();
			this.calculationPeriodNumberOfDays = builder.getCalculationPeriodNumberOfDays();
			this.notionalAmount = builder.getNotionalAmount();
			this.fxLinkedNotionalAmount = ofNullable(builder.getFxLinkedNotionalAmount()).map(f->f.build()).orElse(null);
			this.floatingRateDefinition = ofNullable(builder.getFloatingRateDefinition()).map(f->f.build()).orElse(null);
			this.fixedRate = builder.getFixedRate();
			this.dayCountYearFraction = builder.getDayCountYearFraction();
			this.forecastAmount = ofNullable(builder.getForecastAmount()).map(f->f.build()).orElse(null);
			this.forecastRate = builder.getForecastRate();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("unadjustedStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedStartDate")
		public ZonedDateTime getUnadjustedStartDate() {
			return unadjustedStartDate;
		}
		
		@Override
		@RosettaAttribute("unadjustedEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedEndDate")
		public ZonedDateTime getUnadjustedEndDate() {
			return unadjustedEndDate;
		}
		
		@Override
		@RosettaAttribute("adjustedStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedStartDate")
		public ZonedDateTime getAdjustedStartDate() {
			return adjustedStartDate;
		}
		
		@Override
		@RosettaAttribute("adjustedEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedEndDate")
		public ZonedDateTime getAdjustedEndDate() {
			return adjustedEndDate;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodNumberOfDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodNumberOfDays")
		public Integer getCalculationPeriodNumberOfDays() {
			return calculationPeriodNumberOfDays;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("fxLinkedNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxLinkedNotionalAmount")
		public FxLinkedNotionalAmount getFxLinkedNotionalAmount() {
			return fxLinkedNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("floatingRateDefinition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateDefinition")
		public FloatingRateDefinition getFloatingRateDefinition() {
			return floatingRateDefinition;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("dayCountYearFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountYearFraction")
		public BigDecimal getDayCountYearFraction() {
			return dayCountYearFraction;
		}
		
		@Override
		@RosettaAttribute("forecastAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forecastAmount")
		public Money getForecastAmount() {
			return forecastAmount;
		}
		
		@Override
		@RosettaAttribute("forecastRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forecastRate")
		public BigDecimal getForecastRate() {
			return forecastRate;
		}
		
		@Override
		public CalculationPeriod build() {
			return this;
		}
		
		@Override
		public CalculationPeriod.CalculationPeriodBuilder toBuilder() {
			CalculationPeriod.CalculationPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationPeriod.CalculationPeriodBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getUnadjustedStartDate()).ifPresent(builder::setUnadjustedStartDate);
			ofNullable(getUnadjustedEndDate()).ifPresent(builder::setUnadjustedEndDate);
			ofNullable(getAdjustedStartDate()).ifPresent(builder::setAdjustedStartDate);
			ofNullable(getAdjustedEndDate()).ifPresent(builder::setAdjustedEndDate);
			ofNullable(getCalculationPeriodNumberOfDays()).ifPresent(builder::setCalculationPeriodNumberOfDays);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getFxLinkedNotionalAmount()).ifPresent(builder::setFxLinkedNotionalAmount);
			ofNullable(getFloatingRateDefinition()).ifPresent(builder::setFloatingRateDefinition);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getDayCountYearFraction()).ifPresent(builder::setDayCountYearFraction);
			ofNullable(getForecastAmount()).ifPresent(builder::setForecastAmount);
			ofNullable(getForecastRate()).ifPresent(builder::setForecastRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(unadjustedStartDate, _that.getUnadjustedStartDate())) return false;
			if (!Objects.equals(unadjustedEndDate, _that.getUnadjustedEndDate())) return false;
			if (!Objects.equals(adjustedStartDate, _that.getAdjustedStartDate())) return false;
			if (!Objects.equals(adjustedEndDate, _that.getAdjustedEndDate())) return false;
			if (!Objects.equals(calculationPeriodNumberOfDays, _that.getCalculationPeriodNumberOfDays())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(fxLinkedNotionalAmount, _that.getFxLinkedNotionalAmount())) return false;
			if (!Objects.equals(floatingRateDefinition, _that.getFloatingRateDefinition())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(dayCountYearFraction, _that.getDayCountYearFraction())) return false;
			if (!Objects.equals(forecastAmount, _that.getForecastAmount())) return false;
			if (!Objects.equals(forecastRate, _that.getForecastRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (unadjustedStartDate != null ? unadjustedStartDate.hashCode() : 0);
			_result = 31 * _result + (unadjustedEndDate != null ? unadjustedEndDate.hashCode() : 0);
			_result = 31 * _result + (adjustedStartDate != null ? adjustedStartDate.hashCode() : 0);
			_result = 31 * _result + (adjustedEndDate != null ? adjustedEndDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodNumberOfDays != null ? calculationPeriodNumberOfDays.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (fxLinkedNotionalAmount != null ? fxLinkedNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (floatingRateDefinition != null ? floatingRateDefinition.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (dayCountYearFraction != null ? dayCountYearFraction.hashCode() : 0);
			_result = 31 * _result + (forecastAmount != null ? forecastAmount.hashCode() : 0);
			_result = 31 * _result + (forecastRate != null ? forecastRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriod {" +
				"id=" + this.id + ", " +
				"unadjustedStartDate=" + this.unadjustedStartDate + ", " +
				"unadjustedEndDate=" + this.unadjustedEndDate + ", " +
				"adjustedStartDate=" + this.adjustedStartDate + ", " +
				"adjustedEndDate=" + this.adjustedEndDate + ", " +
				"calculationPeriodNumberOfDays=" + this.calculationPeriodNumberOfDays + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"fxLinkedNotionalAmount=" + this.fxLinkedNotionalAmount + ", " +
				"floatingRateDefinition=" + this.floatingRateDefinition + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"dayCountYearFraction=" + this.dayCountYearFraction + ", " +
				"forecastAmount=" + this.forecastAmount + ", " +
				"forecastRate=" + this.forecastRate +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationPeriod  ***********************/
	class CalculationPeriodBuilderImpl implements CalculationPeriod.CalculationPeriodBuilder {
	
		protected String id;
		protected ZonedDateTime unadjustedStartDate;
		protected ZonedDateTime unadjustedEndDate;
		protected ZonedDateTime adjustedStartDate;
		protected ZonedDateTime adjustedEndDate;
		protected Integer calculationPeriodNumberOfDays;
		protected BigDecimal notionalAmount;
		protected FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder fxLinkedNotionalAmount;
		protected FloatingRateDefinition.FloatingRateDefinitionBuilder floatingRateDefinition;
		protected BigDecimal fixedRate;
		protected BigDecimal dayCountYearFraction;
		protected Money.MoneyBuilder forecastAmount;
		protected BigDecimal forecastRate;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("unadjustedStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedStartDate")
		public ZonedDateTime getUnadjustedStartDate() {
			return unadjustedStartDate;
		}
		
		@Override
		@RosettaAttribute("unadjustedEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedEndDate")
		public ZonedDateTime getUnadjustedEndDate() {
			return unadjustedEndDate;
		}
		
		@Override
		@RosettaAttribute("adjustedStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedStartDate")
		public ZonedDateTime getAdjustedStartDate() {
			return adjustedStartDate;
		}
		
		@Override
		@RosettaAttribute("adjustedEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedEndDate")
		public ZonedDateTime getAdjustedEndDate() {
			return adjustedEndDate;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodNumberOfDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodNumberOfDays")
		public Integer getCalculationPeriodNumberOfDays() {
			return calculationPeriodNumberOfDays;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("fxLinkedNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxLinkedNotionalAmount")
		public FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder getFxLinkedNotionalAmount() {
			return fxLinkedNotionalAmount;
		}
		
		@Override
		public FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder getOrCreateFxLinkedNotionalAmount() {
			FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder result;
			if (fxLinkedNotionalAmount!=null) {
				result = fxLinkedNotionalAmount;
			}
			else {
				result = fxLinkedNotionalAmount = FxLinkedNotionalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateDefinition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateDefinition")
		public FloatingRateDefinition.FloatingRateDefinitionBuilder getFloatingRateDefinition() {
			return floatingRateDefinition;
		}
		
		@Override
		public FloatingRateDefinition.FloatingRateDefinitionBuilder getOrCreateFloatingRateDefinition() {
			FloatingRateDefinition.FloatingRateDefinitionBuilder result;
			if (floatingRateDefinition!=null) {
				result = floatingRateDefinition;
			}
			else {
				result = floatingRateDefinition = FloatingRateDefinition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("dayCountYearFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountYearFraction")
		public BigDecimal getDayCountYearFraction() {
			return dayCountYearFraction;
		}
		
		@Override
		@RosettaAttribute("forecastAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forecastAmount")
		public Money.MoneyBuilder getForecastAmount() {
			return forecastAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateForecastAmount() {
			Money.MoneyBuilder result;
			if (forecastAmount!=null) {
				result = forecastAmount;
			}
			else {
				result = forecastAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("forecastRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forecastRate")
		public BigDecimal getForecastRate() {
			return forecastRate;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("unadjustedStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedStartDate")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder setUnadjustedStartDate(ZonedDateTime _unadjustedStartDate) {
			this.unadjustedStartDate = _unadjustedStartDate == null ? null : _unadjustedStartDate;
			return this;
		}
		
		@RosettaAttribute("unadjustedEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedEndDate")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder setUnadjustedEndDate(ZonedDateTime _unadjustedEndDate) {
			this.unadjustedEndDate = _unadjustedEndDate == null ? null : _unadjustedEndDate;
			return this;
		}
		
		@RosettaAttribute("adjustedStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedStartDate")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder setAdjustedStartDate(ZonedDateTime _adjustedStartDate) {
			this.adjustedStartDate = _adjustedStartDate == null ? null : _adjustedStartDate;
			return this;
		}
		
		@RosettaAttribute("adjustedEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedEndDate")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder setAdjustedEndDate(ZonedDateTime _adjustedEndDate) {
			this.adjustedEndDate = _adjustedEndDate == null ? null : _adjustedEndDate;
			return this;
		}
		
		@RosettaAttribute("calculationPeriodNumberOfDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodNumberOfDays")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder setCalculationPeriodNumberOfDays(Integer _calculationPeriodNumberOfDays) {
			this.calculationPeriodNumberOfDays = _calculationPeriodNumberOfDays == null ? null : _calculationPeriodNumberOfDays;
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder setNotionalAmount(BigDecimal _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount;
			return this;
		}
		
		@RosettaAttribute("fxLinkedNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxLinkedNotionalAmount")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder setFxLinkedNotionalAmount(FxLinkedNotionalAmount _fxLinkedNotionalAmount) {
			this.fxLinkedNotionalAmount = _fxLinkedNotionalAmount == null ? null : _fxLinkedNotionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRateDefinition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateDefinition")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder setFloatingRateDefinition(FloatingRateDefinition _floatingRateDefinition) {
			this.floatingRateDefinition = _floatingRateDefinition == null ? null : _floatingRateDefinition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRate")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder setFixedRate(BigDecimal _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate;
			return this;
		}
		
		@RosettaAttribute("dayCountYearFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountYearFraction")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder setDayCountYearFraction(BigDecimal _dayCountYearFraction) {
			this.dayCountYearFraction = _dayCountYearFraction == null ? null : _dayCountYearFraction;
			return this;
		}
		
		@RosettaAttribute("forecastAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forecastAmount")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder setForecastAmount(Money _forecastAmount) {
			this.forecastAmount = _forecastAmount == null ? null : _forecastAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("forecastRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forecastRate")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder setForecastRate(BigDecimal _forecastRate) {
			this.forecastRate = _forecastRate == null ? null : _forecastRate;
			return this;
		}
		
		@Override
		public CalculationPeriod build() {
			return new CalculationPeriod.CalculationPeriodImpl(this);
		}
		
		@Override
		public CalculationPeriod.CalculationPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder prune() {
			if (fxLinkedNotionalAmount!=null && !fxLinkedNotionalAmount.prune().hasData()) fxLinkedNotionalAmount = null;
			if (floatingRateDefinition!=null && !floatingRateDefinition.prune().hasData()) floatingRateDefinition = null;
			if (forecastAmount!=null && !forecastAmount.prune().hasData()) forecastAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getUnadjustedStartDate()!=null) return true;
			if (getUnadjustedEndDate()!=null) return true;
			if (getAdjustedStartDate()!=null) return true;
			if (getAdjustedEndDate()!=null) return true;
			if (getCalculationPeriodNumberOfDays()!=null) return true;
			if (getNotionalAmount()!=null) return true;
			if (getFxLinkedNotionalAmount()!=null && getFxLinkedNotionalAmount().hasData()) return true;
			if (getFloatingRateDefinition()!=null && getFloatingRateDefinition().hasData()) return true;
			if (getFixedRate()!=null) return true;
			if (getDayCountYearFraction()!=null) return true;
			if (getForecastAmount()!=null && getForecastAmount().hasData()) return true;
			if (getForecastRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriod.CalculationPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationPeriod.CalculationPeriodBuilder o = (CalculationPeriod.CalculationPeriodBuilder) other;
			
			merger.mergeRosetta(getFxLinkedNotionalAmount(), o.getFxLinkedNotionalAmount(), this::setFxLinkedNotionalAmount);
			merger.mergeRosetta(getFloatingRateDefinition(), o.getFloatingRateDefinition(), this::setFloatingRateDefinition);
			merger.mergeRosetta(getForecastAmount(), o.getForecastAmount(), this::setForecastAmount);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getUnadjustedStartDate(), o.getUnadjustedStartDate(), this::setUnadjustedStartDate);
			merger.mergeBasic(getUnadjustedEndDate(), o.getUnadjustedEndDate(), this::setUnadjustedEndDate);
			merger.mergeBasic(getAdjustedStartDate(), o.getAdjustedStartDate(), this::setAdjustedStartDate);
			merger.mergeBasic(getAdjustedEndDate(), o.getAdjustedEndDate(), this::setAdjustedEndDate);
			merger.mergeBasic(getCalculationPeriodNumberOfDays(), o.getCalculationPeriodNumberOfDays(), this::setCalculationPeriodNumberOfDays);
			merger.mergeBasic(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeBasic(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			merger.mergeBasic(getDayCountYearFraction(), o.getDayCountYearFraction(), this::setDayCountYearFraction);
			merger.mergeBasic(getForecastRate(), o.getForecastRate(), this::setForecastRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(unadjustedStartDate, _that.getUnadjustedStartDate())) return false;
			if (!Objects.equals(unadjustedEndDate, _that.getUnadjustedEndDate())) return false;
			if (!Objects.equals(adjustedStartDate, _that.getAdjustedStartDate())) return false;
			if (!Objects.equals(adjustedEndDate, _that.getAdjustedEndDate())) return false;
			if (!Objects.equals(calculationPeriodNumberOfDays, _that.getCalculationPeriodNumberOfDays())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(fxLinkedNotionalAmount, _that.getFxLinkedNotionalAmount())) return false;
			if (!Objects.equals(floatingRateDefinition, _that.getFloatingRateDefinition())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(dayCountYearFraction, _that.getDayCountYearFraction())) return false;
			if (!Objects.equals(forecastAmount, _that.getForecastAmount())) return false;
			if (!Objects.equals(forecastRate, _that.getForecastRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (unadjustedStartDate != null ? unadjustedStartDate.hashCode() : 0);
			_result = 31 * _result + (unadjustedEndDate != null ? unadjustedEndDate.hashCode() : 0);
			_result = 31 * _result + (adjustedStartDate != null ? adjustedStartDate.hashCode() : 0);
			_result = 31 * _result + (adjustedEndDate != null ? adjustedEndDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodNumberOfDays != null ? calculationPeriodNumberOfDays.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (fxLinkedNotionalAmount != null ? fxLinkedNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (floatingRateDefinition != null ? floatingRateDefinition.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (dayCountYearFraction != null ? dayCountYearFraction.hashCode() : 0);
			_result = 31 * _result + (forecastAmount != null ? forecastAmount.hashCode() : 0);
			_result = 31 * _result + (forecastRate != null ? forecastRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodBuilder {" +
				"id=" + this.id + ", " +
				"unadjustedStartDate=" + this.unadjustedStartDate + ", " +
				"unadjustedEndDate=" + this.unadjustedEndDate + ", " +
				"adjustedStartDate=" + this.adjustedStartDate + ", " +
				"adjustedEndDate=" + this.adjustedEndDate + ", " +
				"calculationPeriodNumberOfDays=" + this.calculationPeriodNumberOfDays + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"fxLinkedNotionalAmount=" + this.fxLinkedNotionalAmount + ", " +
				"floatingRateDefinition=" + this.floatingRateDefinition + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"dayCountYearFraction=" + this.dayCountYearFraction + ", " +
				"forecastAmount=" + this.forecastAmount + ", " +
				"forecastRate=" + this.forecastRate +
			'}';
		}
	}
}

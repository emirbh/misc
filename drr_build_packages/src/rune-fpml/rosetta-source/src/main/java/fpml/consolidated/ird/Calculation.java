package fpml.consolidated.ird;

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
import fpml.consolidated.fpmlenum.CompoundingMethodEnum;
import fpml.consolidated.ird.meta.CalculationMeta;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.FutureValueAmount;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.Rate;
import fpml.consolidated.shared.Schedule;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type definining the parameters used in the calculation of fixed or floating calculation period amounts.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type definining the parameters used in the calculation of fixed or floating calculation period amounts.
 *
 */
@RosettaDataType(value="Calculation", builder=Calculation.CalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Calculation", model="fpml", builder=Calculation.CalculationBuilderImpl.class, version="2.1.1")
public interface Calculation extends RosettaModelObject {

	CalculationMeta metaData = new CalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The notional amount or notional amount schedule. Some reporting implementations may place the current notional in the "initialValue" element of the schedule for historical convenience. In the future the "currentNotional" element should be used for this purpose.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The notional amount or notional amount schedule.
	 *
	 */
	Notional getNotionalSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A notional amount schedule where each notional that applied to a calculation period is calculated with reference to a notional amount or notional amount schedule in a different currency by means of a spot currency exchange rate which is normally observed at the beginning of each period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A notional amount schedule where each notional that applied to a calculation period is calculated with reference to a notional amount or notional amount schedule in a different currency by means of a spot currency exchange rate which is normally observed at the beginning of each period.
	 *
	 */
	FxLinkedNotionalSchedule getFxLinkedNotionalSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The notional in effect on the as-of date.
	 *
	 */
	Money getCurrentNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The fixed rate or fixed rate schedule expressed as explicit fixed rates and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The fixed rate or fixed rate schedule expressed as explicit fixed rates and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 */
	Schedule getFixedRateSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The future value notional is normally only required for BRL CDI Swaps. The value is calculated as follows: Future Value Notional = Notional Amount * (1 + Fixed Rate) ^ (Fixed Rate Day Count Fraction). The currency should always match that expressed in the notional schedule. The value date should match the adjusted termination date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The future value notional is normally only required for BRL CDI Swaps. The value is calculated as follows: Future Value Notional = Notional Amount * (1 + Fixed Rate) ^ (Fixed Rate Day Count Fraction). The currency should always match that expressed in the notional schedule. The value date should match the adjusted termination date.
	 *
	 */
	FutureValueAmount getFutureValueNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element is the head of a substitution group. It is substituted by the floatingRateCalculation element for standard Floating Rate legs, or the inflationRateCalculation element for inflation swaps.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element is the head of a substitution group. It is substituted by the floatingRateCalculation element for standard Floating Rate legs, or the inflationRateCalculation element for inflation swaps.
	 *
	 */
	Rate getRateCalculation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The day count fraction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The day count fraction.
	 *
	 */
	DayCountFraction getDayCountFraction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters specifying any discounting conventions that may apply. This element must only be included if discounting applies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters specifying any discounting conventions that may apply. This element must only be included if discounting applies.
	 *
	 */
	Discounting getDiscounting();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If more that one calculation period contributes to a single payment amount this element specifies whether compounding is applicable, and if so, what compounding method is to be used. This element must only be included when more that one calculation period contributes to a single payment amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If more that one calculation period contributes to a single payment amount this element specifies whether compounding is applicable, and if so, what compounding method is to be used. This element must only be included when more that one calculation period contributes to a single payment amount.
	 *
	 */
	CompoundingMethodEnum getCompoundingMethod();

	/*********************** Build Methods  ***********************/
	Calculation build();
	
	Calculation.CalculationBuilder toBuilder();
	
	static Calculation.CalculationBuilder builder() {
		return new Calculation.CalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Calculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Calculation> getType() {
		return Calculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalSchedule"), processor, Notional.class, getNotionalSchedule());
		processRosetta(path.newSubPath("fxLinkedNotionalSchedule"), processor, FxLinkedNotionalSchedule.class, getFxLinkedNotionalSchedule());
		processRosetta(path.newSubPath("currentNotional"), processor, Money.class, getCurrentNotional());
		processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.class, getFixedRateSchedule());
		processRosetta(path.newSubPath("futureValueNotional"), processor, FutureValueAmount.class, getFutureValueNotional());
		processRosetta(path.newSubPath("rateCalculation"), processor, Rate.class, getRateCalculation());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("discounting"), processor, Discounting.class, getDiscounting());
		processor.processBasic(path.newSubPath("compoundingMethod"), CompoundingMethodEnum.class, getCompoundingMethod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationBuilder extends Calculation, RosettaModelObjectBuilder {
		Notional.NotionalBuilder getOrCreateNotionalSchedule();
		@Override
		Notional.NotionalBuilder getNotionalSchedule();
		FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder getOrCreateFxLinkedNotionalSchedule();
		@Override
		FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder getFxLinkedNotionalSchedule();
		Money.MoneyBuilder getOrCreateCurrentNotional();
		@Override
		Money.MoneyBuilder getCurrentNotional();
		Schedule.ScheduleBuilder getOrCreateFixedRateSchedule();
		@Override
		Schedule.ScheduleBuilder getFixedRateSchedule();
		FutureValueAmount.FutureValueAmountBuilder getOrCreateFutureValueNotional();
		@Override
		FutureValueAmount.FutureValueAmountBuilder getFutureValueNotional();
		Rate.RateBuilder getOrCreateRateCalculation();
		@Override
		Rate.RateBuilder getRateCalculation();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		Discounting.DiscountingBuilder getOrCreateDiscounting();
		@Override
		Discounting.DiscountingBuilder getDiscounting();
		Calculation.CalculationBuilder setNotionalSchedule(Notional notionalSchedule);
		Calculation.CalculationBuilder setFxLinkedNotionalSchedule(FxLinkedNotionalSchedule fxLinkedNotionalSchedule);
		Calculation.CalculationBuilder setCurrentNotional(Money currentNotional);
		Calculation.CalculationBuilder setFixedRateSchedule(Schedule fixedRateSchedule);
		Calculation.CalculationBuilder setFutureValueNotional(FutureValueAmount futureValueNotional);
		Calculation.CalculationBuilder setRateCalculation(Rate rateCalculation);
		Calculation.CalculationBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		Calculation.CalculationBuilder setDiscounting(Discounting discounting);
		Calculation.CalculationBuilder setCompoundingMethod(CompoundingMethodEnum compoundingMethod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalSchedule"), processor, Notional.NotionalBuilder.class, getNotionalSchedule());
			processRosetta(path.newSubPath("fxLinkedNotionalSchedule"), processor, FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder.class, getFxLinkedNotionalSchedule());
			processRosetta(path.newSubPath("currentNotional"), processor, Money.MoneyBuilder.class, getCurrentNotional());
			processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.ScheduleBuilder.class, getFixedRateSchedule());
			processRosetta(path.newSubPath("futureValueNotional"), processor, FutureValueAmount.FutureValueAmountBuilder.class, getFutureValueNotional());
			processRosetta(path.newSubPath("rateCalculation"), processor, Rate.RateBuilder.class, getRateCalculation());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("discounting"), processor, Discounting.DiscountingBuilder.class, getDiscounting());
			processor.processBasic(path.newSubPath("compoundingMethod"), CompoundingMethodEnum.class, getCompoundingMethod(), this);
		}
		

		Calculation.CalculationBuilder prune();
	}

	/*********************** Immutable Implementation of Calculation  ***********************/
	class CalculationImpl implements Calculation {
		private final Notional notionalSchedule;
		private final FxLinkedNotionalSchedule fxLinkedNotionalSchedule;
		private final Money currentNotional;
		private final Schedule fixedRateSchedule;
		private final FutureValueAmount futureValueNotional;
		private final Rate rateCalculation;
		private final DayCountFraction dayCountFraction;
		private final Discounting discounting;
		private final CompoundingMethodEnum compoundingMethod;
		
		protected CalculationImpl(Calculation.CalculationBuilder builder) {
			this.notionalSchedule = ofNullable(builder.getNotionalSchedule()).map(f->f.build()).orElse(null);
			this.fxLinkedNotionalSchedule = ofNullable(builder.getFxLinkedNotionalSchedule()).map(f->f.build()).orElse(null);
			this.currentNotional = ofNullable(builder.getCurrentNotional()).map(f->f.build()).orElse(null);
			this.fixedRateSchedule = ofNullable(builder.getFixedRateSchedule()).map(f->f.build()).orElse(null);
			this.futureValueNotional = ofNullable(builder.getFutureValueNotional()).map(f->f.build()).orElse(null);
			this.rateCalculation = ofNullable(builder.getRateCalculation()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.discounting = ofNullable(builder.getDiscounting()).map(f->f.build()).orElse(null);
			this.compoundingMethod = builder.getCompoundingMethod();
		}
		
		@Override
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalSchedule")
		public Notional getNotionalSchedule() {
			return notionalSchedule;
		}
		
		@Override
		@RosettaAttribute("fxLinkedNotionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxLinkedNotionalSchedule")
		public FxLinkedNotionalSchedule getFxLinkedNotionalSchedule() {
			return fxLinkedNotionalSchedule;
		}
		
		@Override
		@RosettaAttribute("currentNotional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currentNotional")
		public Money getCurrentNotional() {
			return currentNotional;
		}
		
		@Override
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateSchedule")
		public Schedule getFixedRateSchedule() {
			return fixedRateSchedule;
		}
		
		@Override
		@RosettaAttribute("futureValueNotional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("futureValueNotional")
		public FutureValueAmount getFutureValueNotional() {
			return futureValueNotional;
		}
		
		@Override
		@RosettaAttribute("rateCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateCalculation")
		public Rate getRateCalculation() {
			return rateCalculation;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("discounting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discounting")
		public Discounting getDiscounting() {
			return discounting;
		}
		
		@Override
		@RosettaAttribute("compoundingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compoundingMethod")
		public CompoundingMethodEnum getCompoundingMethod() {
			return compoundingMethod;
		}
		
		@Override
		public Calculation build() {
			return this;
		}
		
		@Override
		public Calculation.CalculationBuilder toBuilder() {
			Calculation.CalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Calculation.CalculationBuilder builder) {
			ofNullable(getNotionalSchedule()).ifPresent(builder::setNotionalSchedule);
			ofNullable(getFxLinkedNotionalSchedule()).ifPresent(builder::setFxLinkedNotionalSchedule);
			ofNullable(getCurrentNotional()).ifPresent(builder::setCurrentNotional);
			ofNullable(getFixedRateSchedule()).ifPresent(builder::setFixedRateSchedule);
			ofNullable(getFutureValueNotional()).ifPresent(builder::setFutureValueNotional);
			ofNullable(getRateCalculation()).ifPresent(builder::setRateCalculation);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getDiscounting()).ifPresent(builder::setDiscounting);
			ofNullable(getCompoundingMethod()).ifPresent(builder::setCompoundingMethod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Calculation _that = getType().cast(o);
		
			if (!Objects.equals(notionalSchedule, _that.getNotionalSchedule())) return false;
			if (!Objects.equals(fxLinkedNotionalSchedule, _that.getFxLinkedNotionalSchedule())) return false;
			if (!Objects.equals(currentNotional, _that.getCurrentNotional())) return false;
			if (!Objects.equals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!Objects.equals(futureValueNotional, _that.getFutureValueNotional())) return false;
			if (!Objects.equals(rateCalculation, _that.getRateCalculation())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(discounting, _that.getDiscounting())) return false;
			if (!Objects.equals(compoundingMethod, _that.getCompoundingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalSchedule != null ? notionalSchedule.hashCode() : 0);
			_result = 31 * _result + (fxLinkedNotionalSchedule != null ? fxLinkedNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (currentNotional != null ? currentNotional.hashCode() : 0);
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (futureValueNotional != null ? futureValueNotional.hashCode() : 0);
			_result = 31 * _result + (rateCalculation != null ? rateCalculation.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (discounting != null ? discounting.hashCode() : 0);
			_result = 31 * _result + (compoundingMethod != null ? compoundingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Calculation {" +
				"notionalSchedule=" + this.notionalSchedule + ", " +
				"fxLinkedNotionalSchedule=" + this.fxLinkedNotionalSchedule + ", " +
				"currentNotional=" + this.currentNotional + ", " +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"futureValueNotional=" + this.futureValueNotional + ", " +
				"rateCalculation=" + this.rateCalculation + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"discounting=" + this.discounting + ", " +
				"compoundingMethod=" + this.compoundingMethod +
			'}';
		}
	}

	/*********************** Builder Implementation of Calculation  ***********************/
	class CalculationBuilderImpl implements Calculation.CalculationBuilder {
	
		protected Notional.NotionalBuilder notionalSchedule;
		protected FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder fxLinkedNotionalSchedule;
		protected Money.MoneyBuilder currentNotional;
		protected Schedule.ScheduleBuilder fixedRateSchedule;
		protected FutureValueAmount.FutureValueAmountBuilder futureValueNotional;
		protected Rate.RateBuilder rateCalculation;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected Discounting.DiscountingBuilder discounting;
		protected CompoundingMethodEnum compoundingMethod;
		
		@Override
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalSchedule")
		public Notional.NotionalBuilder getNotionalSchedule() {
			return notionalSchedule;
		}
		
		@Override
		public Notional.NotionalBuilder getOrCreateNotionalSchedule() {
			Notional.NotionalBuilder result;
			if (notionalSchedule!=null) {
				result = notionalSchedule;
			}
			else {
				result = notionalSchedule = Notional.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxLinkedNotionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxLinkedNotionalSchedule")
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder getFxLinkedNotionalSchedule() {
			return fxLinkedNotionalSchedule;
		}
		
		@Override
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder getOrCreateFxLinkedNotionalSchedule() {
			FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder result;
			if (fxLinkedNotionalSchedule!=null) {
				result = fxLinkedNotionalSchedule;
			}
			else {
				result = fxLinkedNotionalSchedule = FxLinkedNotionalSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currentNotional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currentNotional")
		public Money.MoneyBuilder getCurrentNotional() {
			return currentNotional;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCurrentNotional() {
			Money.MoneyBuilder result;
			if (currentNotional!=null) {
				result = currentNotional;
			}
			else {
				result = currentNotional = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateSchedule")
		public Schedule.ScheduleBuilder getFixedRateSchedule() {
			return fixedRateSchedule;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateFixedRateSchedule() {
			Schedule.ScheduleBuilder result;
			if (fixedRateSchedule!=null) {
				result = fixedRateSchedule;
			}
			else {
				result = fixedRateSchedule = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("futureValueNotional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("futureValueNotional")
		public FutureValueAmount.FutureValueAmountBuilder getFutureValueNotional() {
			return futureValueNotional;
		}
		
		@Override
		public FutureValueAmount.FutureValueAmountBuilder getOrCreateFutureValueNotional() {
			FutureValueAmount.FutureValueAmountBuilder result;
			if (futureValueNotional!=null) {
				result = futureValueNotional;
			}
			else {
				result = futureValueNotional = FutureValueAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateCalculation")
		public Rate.RateBuilder getRateCalculation() {
			return rateCalculation;
		}
		
		@Override
		public Rate.RateBuilder getOrCreateRateCalculation() {
			Rate.RateBuilder result;
			if (rateCalculation!=null) {
				result = rateCalculation;
			}
			else {
				result = rateCalculation = Rate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("discounting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discounting")
		public Discounting.DiscountingBuilder getDiscounting() {
			return discounting;
		}
		
		@Override
		public Discounting.DiscountingBuilder getOrCreateDiscounting() {
			Discounting.DiscountingBuilder result;
			if (discounting!=null) {
				result = discounting;
			}
			else {
				result = discounting = Discounting.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compoundingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compoundingMethod")
		public CompoundingMethodEnum getCompoundingMethod() {
			return compoundingMethod;
		}
		
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalSchedule")
		@Override
		public Calculation.CalculationBuilder setNotionalSchedule(Notional _notionalSchedule) {
			this.notionalSchedule = _notionalSchedule == null ? null : _notionalSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxLinkedNotionalSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxLinkedNotionalSchedule")
		@Override
		public Calculation.CalculationBuilder setFxLinkedNotionalSchedule(FxLinkedNotionalSchedule _fxLinkedNotionalSchedule) {
			this.fxLinkedNotionalSchedule = _fxLinkedNotionalSchedule == null ? null : _fxLinkedNotionalSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currentNotional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currentNotional")
		@Override
		public Calculation.CalculationBuilder setCurrentNotional(Money _currentNotional) {
			this.currentNotional = _currentNotional == null ? null : _currentNotional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRateSchedule")
		@Override
		public Calculation.CalculationBuilder setFixedRateSchedule(Schedule _fixedRateSchedule) {
			this.fixedRateSchedule = _fixedRateSchedule == null ? null : _fixedRateSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("futureValueNotional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("futureValueNotional")
		@Override
		public Calculation.CalculationBuilder setFutureValueNotional(FutureValueAmount _futureValueNotional) {
			this.futureValueNotional = _futureValueNotional == null ? null : _futureValueNotional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rateCalculation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateCalculation")
		@Override
		public Calculation.CalculationBuilder setRateCalculation(Rate _rateCalculation) {
			this.rateCalculation = _rateCalculation == null ? null : _rateCalculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public Calculation.CalculationBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("discounting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("discounting")
		@Override
		public Calculation.CalculationBuilder setDiscounting(Discounting _discounting) {
			this.discounting = _discounting == null ? null : _discounting.toBuilder();
			return this;
		}
		
		@RosettaAttribute("compoundingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("compoundingMethod")
		@Override
		public Calculation.CalculationBuilder setCompoundingMethod(CompoundingMethodEnum _compoundingMethod) {
			this.compoundingMethod = _compoundingMethod == null ? null : _compoundingMethod;
			return this;
		}
		
		@Override
		public Calculation build() {
			return new Calculation.CalculationImpl(this);
		}
		
		@Override
		public Calculation.CalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Calculation.CalculationBuilder prune() {
			if (notionalSchedule!=null && !notionalSchedule.prune().hasData()) notionalSchedule = null;
			if (fxLinkedNotionalSchedule!=null && !fxLinkedNotionalSchedule.prune().hasData()) fxLinkedNotionalSchedule = null;
			if (currentNotional!=null && !currentNotional.prune().hasData()) currentNotional = null;
			if (fixedRateSchedule!=null && !fixedRateSchedule.prune().hasData()) fixedRateSchedule = null;
			if (futureValueNotional!=null && !futureValueNotional.prune().hasData()) futureValueNotional = null;
			if (rateCalculation!=null && !rateCalculation.prune().hasData()) rateCalculation = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (discounting!=null && !discounting.prune().hasData()) discounting = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalSchedule()!=null && getNotionalSchedule().hasData()) return true;
			if (getFxLinkedNotionalSchedule()!=null && getFxLinkedNotionalSchedule().hasData()) return true;
			if (getCurrentNotional()!=null && getCurrentNotional().hasData()) return true;
			if (getFixedRateSchedule()!=null && getFixedRateSchedule().hasData()) return true;
			if (getFutureValueNotional()!=null && getFutureValueNotional().hasData()) return true;
			if (getRateCalculation()!=null && getRateCalculation().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getDiscounting()!=null && getDiscounting().hasData()) return true;
			if (getCompoundingMethod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Calculation.CalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Calculation.CalculationBuilder o = (Calculation.CalculationBuilder) other;
			
			merger.mergeRosetta(getNotionalSchedule(), o.getNotionalSchedule(), this::setNotionalSchedule);
			merger.mergeRosetta(getFxLinkedNotionalSchedule(), o.getFxLinkedNotionalSchedule(), this::setFxLinkedNotionalSchedule);
			merger.mergeRosetta(getCurrentNotional(), o.getCurrentNotional(), this::setCurrentNotional);
			merger.mergeRosetta(getFixedRateSchedule(), o.getFixedRateSchedule(), this::setFixedRateSchedule);
			merger.mergeRosetta(getFutureValueNotional(), o.getFutureValueNotional(), this::setFutureValueNotional);
			merger.mergeRosetta(getRateCalculation(), o.getRateCalculation(), this::setRateCalculation);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getDiscounting(), o.getDiscounting(), this::setDiscounting);
			
			merger.mergeBasic(getCompoundingMethod(), o.getCompoundingMethod(), this::setCompoundingMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Calculation _that = getType().cast(o);
		
			if (!Objects.equals(notionalSchedule, _that.getNotionalSchedule())) return false;
			if (!Objects.equals(fxLinkedNotionalSchedule, _that.getFxLinkedNotionalSchedule())) return false;
			if (!Objects.equals(currentNotional, _that.getCurrentNotional())) return false;
			if (!Objects.equals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!Objects.equals(futureValueNotional, _that.getFutureValueNotional())) return false;
			if (!Objects.equals(rateCalculation, _that.getRateCalculation())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(discounting, _that.getDiscounting())) return false;
			if (!Objects.equals(compoundingMethod, _that.getCompoundingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalSchedule != null ? notionalSchedule.hashCode() : 0);
			_result = 31 * _result + (fxLinkedNotionalSchedule != null ? fxLinkedNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (currentNotional != null ? currentNotional.hashCode() : 0);
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (futureValueNotional != null ? futureValueNotional.hashCode() : 0);
			_result = 31 * _result + (rateCalculation != null ? rateCalculation.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (discounting != null ? discounting.hashCode() : 0);
			_result = 31 * _result + (compoundingMethod != null ? compoundingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationBuilder {" +
				"notionalSchedule=" + this.notionalSchedule + ", " +
				"fxLinkedNotionalSchedule=" + this.fxLinkedNotionalSchedule + ", " +
				"currentNotional=" + this.currentNotional + ", " +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"futureValueNotional=" + this.futureValueNotional + ", " +
				"rateCalculation=" + this.rateCalculation + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"discounting=" + this.discounting + ", " +
				"compoundingMethod=" + this.compoundingMethod +
			'}';
		}
	}
}

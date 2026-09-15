package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.FloatingAmountCalculationMeta;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.DayCountFraction;
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
@RosettaDataType(value="FloatingAmountCalculation", builder=FloatingAmountCalculation.FloatingAmountCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FloatingAmountCalculation", model="fpml", builder=FloatingAmountCalculation.FloatingAmountCalculationBuilderImpl.class, version="2.1.1")
public interface FloatingAmountCalculation extends RosettaModelObject {

	FloatingAmountCalculationMeta metaData = new FloatingAmountCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The notional amount used in the calculation of fixed amounts where an amount is calculated on a formula basis, i.e. fixed amount = fixed rate payer calculation amount x fixed rate x fixed rate day count fraction. ISDA 2003 Term: Fixed Rate Payer Calculation Amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The notional amount used in the calculation of fixed amounts where an amount is calculated on a formula basis, i.e. fixed amount = fixed rate payer calculation amount x fixed rate x fixed rate day count fraction. ISDA 2003 Term: Fixed Rate Payer Calculation Amount.
	 *
	 */
	CalculationAmount getCalculationAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calculation period floating rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculation period floating rate.
	 *
	 */
	FloatingRateCalculation getFloatingRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The day count fraction. ISDA 2003 Term: Fixed Rate Day Count Fraction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The day count fraction. ISDA 2003 Term: Fixed Rate Day Count Fraction.
	 *
	 */
	DayCountFraction getDayCountFraction();
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
	ZonedDateTime getInitialFixingDate();
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
	AdjustableDate getFinalFixingDate();

	/*********************** Build Methods  ***********************/
	FloatingAmountCalculation build();
	
	FloatingAmountCalculation.FloatingAmountCalculationBuilder toBuilder();
	
	static FloatingAmountCalculation.FloatingAmountCalculationBuilder builder() {
		return new FloatingAmountCalculation.FloatingAmountCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingAmountCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingAmountCalculation> getType() {
		return FloatingAmountCalculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationAmount"), processor, CalculationAmount.class, getCalculationAmount());
		processRosetta(path.newSubPath("floatingRate"), processor, FloatingRateCalculation.class, getFloatingRate());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processor.processBasic(path.newSubPath("initialFixingDate"), ZonedDateTime.class, getInitialFixingDate(), this);
		processRosetta(path.newSubPath("finalFixingDate"), processor, AdjustableDate.class, getFinalFixingDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingAmountCalculationBuilder extends FloatingAmountCalculation, RosettaModelObjectBuilder {
		CalculationAmount.CalculationAmountBuilder getOrCreateCalculationAmount();
		@Override
		CalculationAmount.CalculationAmountBuilder getCalculationAmount();
		FloatingRateCalculation.FloatingRateCalculationBuilder getOrCreateFloatingRate();
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder getFloatingRate();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		AdjustableDate.AdjustableDateBuilder getOrCreateFinalFixingDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getFinalFixingDate();
		FloatingAmountCalculation.FloatingAmountCalculationBuilder setCalculationAmount(CalculationAmount calculationAmount);
		FloatingAmountCalculation.FloatingAmountCalculationBuilder setFloatingRate(FloatingRateCalculation floatingRate);
		FloatingAmountCalculation.FloatingAmountCalculationBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		FloatingAmountCalculation.FloatingAmountCalculationBuilder setInitialFixingDate(ZonedDateTime initialFixingDate);
		FloatingAmountCalculation.FloatingAmountCalculationBuilder setFinalFixingDate(AdjustableDate finalFixingDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationAmount"), processor, CalculationAmount.CalculationAmountBuilder.class, getCalculationAmount());
			processRosetta(path.newSubPath("floatingRate"), processor, FloatingRateCalculation.FloatingRateCalculationBuilder.class, getFloatingRate());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processor.processBasic(path.newSubPath("initialFixingDate"), ZonedDateTime.class, getInitialFixingDate(), this);
			processRosetta(path.newSubPath("finalFixingDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getFinalFixingDate());
		}
		

		FloatingAmountCalculation.FloatingAmountCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingAmountCalculation  ***********************/
	class FloatingAmountCalculationImpl implements FloatingAmountCalculation {
		private final CalculationAmount calculationAmount;
		private final FloatingRateCalculation floatingRate;
		private final DayCountFraction dayCountFraction;
		private final ZonedDateTime initialFixingDate;
		private final AdjustableDate finalFixingDate;
		
		protected FloatingAmountCalculationImpl(FloatingAmountCalculation.FloatingAmountCalculationBuilder builder) {
			this.calculationAmount = ofNullable(builder.getCalculationAmount()).map(f->f.build()).orElse(null);
			this.floatingRate = ofNullable(builder.getFloatingRate()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.initialFixingDate = builder.getInitialFixingDate();
			this.finalFixingDate = ofNullable(builder.getFinalFixingDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAmount")
		public CalculationAmount getCalculationAmount() {
			return calculationAmount;
		}
		
		@Override
		@RosettaAttribute("floatingRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("floatingRate")
		public FloatingRateCalculation getFloatingRate() {
			return floatingRate;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("initialFixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialFixingDate")
		public ZonedDateTime getInitialFixingDate() {
			return initialFixingDate;
		}
		
		@Override
		@RosettaAttribute("finalFixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalFixingDate")
		public AdjustableDate getFinalFixingDate() {
			return finalFixingDate;
		}
		
		@Override
		public FloatingAmountCalculation build() {
			return this;
		}
		
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder toBuilder() {
			FloatingAmountCalculation.FloatingAmountCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingAmountCalculation.FloatingAmountCalculationBuilder builder) {
			ofNullable(getCalculationAmount()).ifPresent(builder::setCalculationAmount);
			ofNullable(getFloatingRate()).ifPresent(builder::setFloatingRate);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getInitialFixingDate()).ifPresent(builder::setInitialFixingDate);
			ofNullable(getFinalFixingDate()).ifPresent(builder::setFinalFixingDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingAmountCalculation _that = getType().cast(o);
		
			if (!Objects.equals(calculationAmount, _that.getCalculationAmount())) return false;
			if (!Objects.equals(floatingRate, _that.getFloatingRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(initialFixingDate, _that.getInitialFixingDate())) return false;
			if (!Objects.equals(finalFixingDate, _that.getFinalFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAmount != null ? calculationAmount.hashCode() : 0);
			_result = 31 * _result + (floatingRate != null ? floatingRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (initialFixingDate != null ? initialFixingDate.hashCode() : 0);
			_result = 31 * _result + (finalFixingDate != null ? finalFixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingAmountCalculation {" +
				"calculationAmount=" + this.calculationAmount + ", " +
				"floatingRate=" + this.floatingRate + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"initialFixingDate=" + this.initialFixingDate + ", " +
				"finalFixingDate=" + this.finalFixingDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingAmountCalculation  ***********************/
	class FloatingAmountCalculationBuilderImpl implements FloatingAmountCalculation.FloatingAmountCalculationBuilder {
	
		protected CalculationAmount.CalculationAmountBuilder calculationAmount;
		protected FloatingRateCalculation.FloatingRateCalculationBuilder floatingRate;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected ZonedDateTime initialFixingDate;
		protected AdjustableDate.AdjustableDateBuilder finalFixingDate;
		
		@Override
		@RosettaAttribute("calculationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAmount")
		public CalculationAmount.CalculationAmountBuilder getCalculationAmount() {
			return calculationAmount;
		}
		
		@Override
		public CalculationAmount.CalculationAmountBuilder getOrCreateCalculationAmount() {
			CalculationAmount.CalculationAmountBuilder result;
			if (calculationAmount!=null) {
				result = calculationAmount;
			}
			else {
				result = calculationAmount = CalculationAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("floatingRate")
		public FloatingRateCalculation.FloatingRateCalculationBuilder getFloatingRate() {
			return floatingRate;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder getOrCreateFloatingRate() {
			FloatingRateCalculation.FloatingRateCalculationBuilder result;
			if (floatingRate!=null) {
				result = floatingRate;
			}
			else {
				result = floatingRate = FloatingRateCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("initialFixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialFixingDate")
		public ZonedDateTime getInitialFixingDate() {
			return initialFixingDate;
		}
		
		@Override
		@RosettaAttribute("finalFixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalFixingDate")
		public AdjustableDate.AdjustableDateBuilder getFinalFixingDate() {
			return finalFixingDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateFinalFixingDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (finalFixingDate!=null) {
				result = finalFixingDate;
			}
			else {
				result = finalFixingDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("calculationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationAmount")
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder setCalculationAmount(CalculationAmount _calculationAmount) {
			this.calculationAmount = _calculationAmount == null ? null : _calculationAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("floatingRate")
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder setFloatingRate(FloatingRateCalculation _floatingRate) {
			this.floatingRate = _floatingRate == null ? null : _floatingRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFraction")
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialFixingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialFixingDate")
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder setInitialFixingDate(ZonedDateTime _initialFixingDate) {
			this.initialFixingDate = _initialFixingDate == null ? null : _initialFixingDate;
			return this;
		}
		
		@RosettaAttribute("finalFixingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalFixingDate")
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder setFinalFixingDate(AdjustableDate _finalFixingDate) {
			this.finalFixingDate = _finalFixingDate == null ? null : _finalFixingDate.toBuilder();
			return this;
		}
		
		@Override
		public FloatingAmountCalculation build() {
			return new FloatingAmountCalculation.FloatingAmountCalculationImpl(this);
		}
		
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder prune() {
			if (calculationAmount!=null && !calculationAmount.prune().hasData()) calculationAmount = null;
			if (floatingRate!=null && !floatingRate.prune().hasData()) floatingRate = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (finalFixingDate!=null && !finalFixingDate.prune().hasData()) finalFixingDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationAmount()!=null && getCalculationAmount().hasData()) return true;
			if (getFloatingRate()!=null && getFloatingRate().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getInitialFixingDate()!=null) return true;
			if (getFinalFixingDate()!=null && getFinalFixingDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingAmountCalculation.FloatingAmountCalculationBuilder o = (FloatingAmountCalculation.FloatingAmountCalculationBuilder) other;
			
			merger.mergeRosetta(getCalculationAmount(), o.getCalculationAmount(), this::setCalculationAmount);
			merger.mergeRosetta(getFloatingRate(), o.getFloatingRate(), this::setFloatingRate);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getFinalFixingDate(), o.getFinalFixingDate(), this::setFinalFixingDate);
			
			merger.mergeBasic(getInitialFixingDate(), o.getInitialFixingDate(), this::setInitialFixingDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingAmountCalculation _that = getType().cast(o);
		
			if (!Objects.equals(calculationAmount, _that.getCalculationAmount())) return false;
			if (!Objects.equals(floatingRate, _that.getFloatingRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(initialFixingDate, _that.getInitialFixingDate())) return false;
			if (!Objects.equals(finalFixingDate, _that.getFinalFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAmount != null ? calculationAmount.hashCode() : 0);
			_result = 31 * _result + (floatingRate != null ? floatingRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (initialFixingDate != null ? initialFixingDate.hashCode() : 0);
			_result = 31 * _result + (finalFixingDate != null ? finalFixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingAmountCalculationBuilder {" +
				"calculationAmount=" + this.calculationAmount + ", " +
				"floatingRate=" + this.floatingRate + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"initialFixingDate=" + this.initialFixingDate + ", " +
				"finalFixingDate=" + this.finalFixingDate +
			'}';
		}
	}
}

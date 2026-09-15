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
import fpml.consolidated.cd.meta.FixedAmountCalculationMeta;
import fpml.consolidated.shared.DayCountFraction;
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
@RosettaDataType(value="FixedAmountCalculation", builder=FixedAmountCalculation.FixedAmountCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FixedAmountCalculation", model="fpml", builder=FixedAmountCalculation.FixedAmountCalculationBuilderImpl.class, version="2.1.1")
public interface FixedAmountCalculation extends RosettaModelObject {

	FixedAmountCalculationMeta metaData = new FixedAmountCalculationMeta();

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
	FixedRate getFixedRate();
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

	/*********************** Build Methods  ***********************/
	FixedAmountCalculation build();
	
	FixedAmountCalculation.FixedAmountCalculationBuilder toBuilder();
	
	static FixedAmountCalculation.FixedAmountCalculationBuilder builder() {
		return new FixedAmountCalculation.FixedAmountCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedAmountCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FixedAmountCalculation> getType() {
		return FixedAmountCalculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationAmount"), processor, CalculationAmount.class, getCalculationAmount());
		processRosetta(path.newSubPath("fixedRate"), processor, FixedRate.class, getFixedRate());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedAmountCalculationBuilder extends FixedAmountCalculation, RosettaModelObjectBuilder {
		CalculationAmount.CalculationAmountBuilder getOrCreateCalculationAmount();
		@Override
		CalculationAmount.CalculationAmountBuilder getCalculationAmount();
		FixedRate.FixedRateBuilder getOrCreateFixedRate();
		@Override
		FixedRate.FixedRateBuilder getFixedRate();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		FixedAmountCalculation.FixedAmountCalculationBuilder setCalculationAmount(CalculationAmount calculationAmount);
		FixedAmountCalculation.FixedAmountCalculationBuilder setFixedRate(FixedRate fixedRate);
		FixedAmountCalculation.FixedAmountCalculationBuilder setDayCountFraction(DayCountFraction dayCountFraction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationAmount"), processor, CalculationAmount.CalculationAmountBuilder.class, getCalculationAmount());
			processRosetta(path.newSubPath("fixedRate"), processor, FixedRate.FixedRateBuilder.class, getFixedRate());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
		}
		

		FixedAmountCalculation.FixedAmountCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of FixedAmountCalculation  ***********************/
	class FixedAmountCalculationImpl implements FixedAmountCalculation {
		private final CalculationAmount calculationAmount;
		private final FixedRate fixedRate;
		private final DayCountFraction dayCountFraction;
		
		protected FixedAmountCalculationImpl(FixedAmountCalculation.FixedAmountCalculationBuilder builder) {
			this.calculationAmount = ofNullable(builder.getCalculationAmount()).map(f->f.build()).orElse(null);
			this.fixedRate = ofNullable(builder.getFixedRate()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAmount")
		public CalculationAmount getCalculationAmount() {
			return calculationAmount;
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixedRate")
		public FixedRate getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public FixedAmountCalculation build() {
			return this;
		}
		
		@Override
		public FixedAmountCalculation.FixedAmountCalculationBuilder toBuilder() {
			FixedAmountCalculation.FixedAmountCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedAmountCalculation.FixedAmountCalculationBuilder builder) {
			ofNullable(getCalculationAmount()).ifPresent(builder::setCalculationAmount);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedAmountCalculation _that = getType().cast(o);
		
			if (!Objects.equals(calculationAmount, _that.getCalculationAmount())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAmount != null ? calculationAmount.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedAmountCalculation {" +
				"calculationAmount=" + this.calculationAmount + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}';
		}
	}

	/*********************** Builder Implementation of FixedAmountCalculation  ***********************/
	class FixedAmountCalculationBuilderImpl implements FixedAmountCalculation.FixedAmountCalculationBuilder {
	
		protected CalculationAmount.CalculationAmountBuilder calculationAmount;
		protected FixedRate.FixedRateBuilder fixedRate;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		
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
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixedRate")
		public FixedRate.FixedRateBuilder getFixedRate() {
			return fixedRate;
		}
		
		@Override
		public FixedRate.FixedRateBuilder getOrCreateFixedRate() {
			FixedRate.FixedRateBuilder result;
			if (fixedRate!=null) {
				result = fixedRate;
			}
			else {
				result = fixedRate = FixedRate.builder();
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
		
		@RosettaAttribute("calculationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationAmount")
		@Override
		public FixedAmountCalculation.FixedAmountCalculationBuilder setCalculationAmount(CalculationAmount _calculationAmount) {
			this.calculationAmount = _calculationAmount == null ? null : _calculationAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fixedRate")
		@Override
		public FixedAmountCalculation.FixedAmountCalculationBuilder setFixedRate(FixedRate _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFraction")
		@Override
		public FixedAmountCalculation.FixedAmountCalculationBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public FixedAmountCalculation build() {
			return new FixedAmountCalculation.FixedAmountCalculationImpl(this);
		}
		
		@Override
		public FixedAmountCalculation.FixedAmountCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedAmountCalculation.FixedAmountCalculationBuilder prune() {
			if (calculationAmount!=null && !calculationAmount.prune().hasData()) calculationAmount = null;
			if (fixedRate!=null && !fixedRate.prune().hasData()) fixedRate = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationAmount()!=null && getCalculationAmount().hasData()) return true;
			if (getFixedRate()!=null && getFixedRate().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedAmountCalculation.FixedAmountCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FixedAmountCalculation.FixedAmountCalculationBuilder o = (FixedAmountCalculation.FixedAmountCalculationBuilder) other;
			
			merger.mergeRosetta(getCalculationAmount(), o.getCalculationAmount(), this::setCalculationAmount);
			merger.mergeRosetta(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedAmountCalculation _that = getType().cast(o);
		
			if (!Objects.equals(calculationAmount, _that.getCalculationAmount())) return false;
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAmount != null ? calculationAmount.hashCode() : 0);
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedAmountCalculationBuilder {" +
				"calculationAmount=" + this.calculationAmount + ", " +
				"fixedRate=" + this.fixedRate + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}';
		}
	}
}

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
import fpml.consolidated.ird.meta.CalculationPeriodAmountMeta;
import fpml.consolidated.shared.AmountSchedule;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the parameters used in the calculation of fixed or floating rate calculation period amounts or for specifying a known calculation period amount or known amount schedule.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the parameters used in the calculation of fixed or floating rate calculation period amounts or for specifying a known calculation period amount or known amount schedule.
 *
 */
@RosettaDataType(value="CalculationPeriodAmount", builder=CalculationPeriodAmount.CalculationPeriodAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CalculationPeriodAmount", model="fpml", builder=CalculationPeriodAmount.CalculationPeriodAmountBuilderImpl.class, version="2.1.1")
public interface CalculationPeriodAmount extends RosettaModelObject {

	CalculationPeriodAmountMeta metaData = new CalculationPeriodAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters used in the calculation of fixed or floaring rate calculation period amounts.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters used in the calculation of fixed or floaring rate calculation period amounts.
	 *
	 */
	Calculation getCalculation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The known calculation period amount or a known amount schedule expressed as explicit known amounts and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The known calculation period amount or a known amount schedule expressed as explicit known amounts and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 */
	AmountSchedule getKnownAmountSchedule();

	/*********************** Build Methods  ***********************/
	CalculationPeriodAmount build();
	
	CalculationPeriodAmount.CalculationPeriodAmountBuilder toBuilder();
	
	static CalculationPeriodAmount.CalculationPeriodAmountBuilder builder() {
		return new CalculationPeriodAmount.CalculationPeriodAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationPeriodAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationPeriodAmount> getType() {
		return CalculationPeriodAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculation"), processor, Calculation.class, getCalculation());
		processRosetta(path.newSubPath("knownAmountSchedule"), processor, AmountSchedule.class, getKnownAmountSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationPeriodAmountBuilder extends CalculationPeriodAmount, RosettaModelObjectBuilder {
		Calculation.CalculationBuilder getOrCreateCalculation();
		@Override
		Calculation.CalculationBuilder getCalculation();
		AmountSchedule.AmountScheduleBuilder getOrCreateKnownAmountSchedule();
		@Override
		AmountSchedule.AmountScheduleBuilder getKnownAmountSchedule();
		CalculationPeriodAmount.CalculationPeriodAmountBuilder setCalculation(Calculation calculation);
		CalculationPeriodAmount.CalculationPeriodAmountBuilder setKnownAmountSchedule(AmountSchedule knownAmountSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculation"), processor, Calculation.CalculationBuilder.class, getCalculation());
			processRosetta(path.newSubPath("knownAmountSchedule"), processor, AmountSchedule.AmountScheduleBuilder.class, getKnownAmountSchedule());
		}
		

		CalculationPeriodAmount.CalculationPeriodAmountBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationPeriodAmount  ***********************/
	class CalculationPeriodAmountImpl implements CalculationPeriodAmount {
		private final Calculation calculation;
		private final AmountSchedule knownAmountSchedule;
		
		protected CalculationPeriodAmountImpl(CalculationPeriodAmount.CalculationPeriodAmountBuilder builder) {
			this.calculation = ofNullable(builder.getCalculation()).map(f->f.build()).orElse(null);
			this.knownAmountSchedule = ofNullable(builder.getKnownAmountSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculation")
		public Calculation getCalculation() {
			return calculation;
		}
		
		@Override
		@RosettaAttribute("knownAmountSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knownAmountSchedule")
		public AmountSchedule getKnownAmountSchedule() {
			return knownAmountSchedule;
		}
		
		@Override
		public CalculationPeriodAmount build() {
			return this;
		}
		
		@Override
		public CalculationPeriodAmount.CalculationPeriodAmountBuilder toBuilder() {
			CalculationPeriodAmount.CalculationPeriodAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationPeriodAmount.CalculationPeriodAmountBuilder builder) {
			ofNullable(getCalculation()).ifPresent(builder::setCalculation);
			ofNullable(getKnownAmountSchedule()).ifPresent(builder::setKnownAmountSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationPeriodAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(knownAmountSchedule, _that.getKnownAmountSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (knownAmountSchedule != null ? knownAmountSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodAmount {" +
				"calculation=" + this.calculation + ", " +
				"knownAmountSchedule=" + this.knownAmountSchedule +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationPeriodAmount  ***********************/
	class CalculationPeriodAmountBuilderImpl implements CalculationPeriodAmount.CalculationPeriodAmountBuilder {
	
		protected Calculation.CalculationBuilder calculation;
		protected AmountSchedule.AmountScheduleBuilder knownAmountSchedule;
		
		@Override
		@RosettaAttribute("calculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculation")
		public Calculation.CalculationBuilder getCalculation() {
			return calculation;
		}
		
		@Override
		public Calculation.CalculationBuilder getOrCreateCalculation() {
			Calculation.CalculationBuilder result;
			if (calculation!=null) {
				result = calculation;
			}
			else {
				result = calculation = Calculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("knownAmountSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knownAmountSchedule")
		public AmountSchedule.AmountScheduleBuilder getKnownAmountSchedule() {
			return knownAmountSchedule;
		}
		
		@Override
		public AmountSchedule.AmountScheduleBuilder getOrCreateKnownAmountSchedule() {
			AmountSchedule.AmountScheduleBuilder result;
			if (knownAmountSchedule!=null) {
				result = knownAmountSchedule;
			}
			else {
				result = knownAmountSchedule = AmountSchedule.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("calculation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculation")
		@Override
		public CalculationPeriodAmount.CalculationPeriodAmountBuilder setCalculation(Calculation _calculation) {
			this.calculation = _calculation == null ? null : _calculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("knownAmountSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("knownAmountSchedule")
		@Override
		public CalculationPeriodAmount.CalculationPeriodAmountBuilder setKnownAmountSchedule(AmountSchedule _knownAmountSchedule) {
			this.knownAmountSchedule = _knownAmountSchedule == null ? null : _knownAmountSchedule.toBuilder();
			return this;
		}
		
		@Override
		public CalculationPeriodAmount build() {
			return new CalculationPeriodAmount.CalculationPeriodAmountImpl(this);
		}
		
		@Override
		public CalculationPeriodAmount.CalculationPeriodAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodAmount.CalculationPeriodAmountBuilder prune() {
			if (calculation!=null && !calculation.prune().hasData()) calculation = null;
			if (knownAmountSchedule!=null && !knownAmountSchedule.prune().hasData()) knownAmountSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculation()!=null && getCalculation().hasData()) return true;
			if (getKnownAmountSchedule()!=null && getKnownAmountSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodAmount.CalculationPeriodAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationPeriodAmount.CalculationPeriodAmountBuilder o = (CalculationPeriodAmount.CalculationPeriodAmountBuilder) other;
			
			merger.mergeRosetta(getCalculation(), o.getCalculation(), this::setCalculation);
			merger.mergeRosetta(getKnownAmountSchedule(), o.getKnownAmountSchedule(), this::setKnownAmountSchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationPeriodAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(knownAmountSchedule, _that.getKnownAmountSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (knownAmountSchedule != null ? knownAmountSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodAmountBuilder {" +
				"calculation=" + this.calculation + ", " +
				"knownAmountSchedule=" + this.knownAmountSchedule +
			'}';
		}
	}
}

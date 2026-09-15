package fpml.consolidated.ird;

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
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.NegativeInterestRateTreatmentEnum;
import fpml.consolidated.fpmlenum.RateTreatmentEnum;
import fpml.consolidated.ird.meta.FloatingRateCalculationMeta;
import fpml.consolidated.shared.CalculationParameters;
import fpml.consolidated.shared.FallbackRate;
import fpml.consolidated.shared.FloatingRate;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.Rounding;
import fpml.consolidated.shared.Schedule;
import fpml.consolidated.shared.SpreadSchedule;
import fpml.consolidated.shared.StrikeSchedule;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the floating rate and definitions relating to the calculation of floating rate amounts.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the floating rate and definitions relating to the calculation of floating rate amounts.
 *
 */
@RosettaDataType(value="FloatingRateCalculation", builder=FloatingRateCalculation.FloatingRateCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FloatingRateCalculation", model="fpml", builder=FloatingRateCalculation.FloatingRateCalculationBuilderImpl.class, version="2.1.1")
public interface FloatingRateCalculation extends FloatingRate {

	FloatingRateCalculationMeta metaData = new FloatingRateCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The initial floating rate reset agreed between the principal parties involved in the trade. This is assumed to be the first required reset rate for the first regular calculation period. It should only be included when the rate is not equal to the rate published on the source implied by the floating rate index. An initial rate of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The initial floating rate reset agreed between the principal parties involved in the trade. This is assumed to be the first required reset rate for the first regular calculation period. It should only be included when the rate is not equal to the rate published on the source implied by the floating rate index. An initial rate of 5% would be represented as 0.05.
	 *
	 */
	BigDecimal getInitialRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The rounding convention to apply to the final rate used in determination of a calculation period amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The rounding convention to apply to the final rate used in determination of a calculation period amount.
	 *
	 */
	Rounding getFinalRateRounding();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If averaging is applicable, this component specifies whether a weighted or unweighted average method of calculation is to be used. The component must only be included when averaging applies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If averaging is applicable, this component specifies whether a weighted or unweighted average method of calculation is to be used. The component must only be included when averaging applies.
	 *
	 */
	AveragingMethodEnum getAveragingMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specification of any provisions for calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification of any provisions for calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
	 *
	 */
	NegativeInterestRateTreatmentEnum getNegativeInterestRateTreatment();

	/*********************** Build Methods  ***********************/
	FloatingRateCalculation build();
	
	FloatingRateCalculation.FloatingRateCalculationBuilder toBuilder();
	
	static FloatingRateCalculation.FloatingRateCalculationBuilder builder() {
		return new FloatingRateCalculation.FloatingRateCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateCalculation> getType() {
		return FloatingRateCalculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
		processRosetta(path.newSubPath("calculationParameters"), processor, CalculationParameters.class, getCalculationParameters());
		processRosetta(path.newSubPath("fallbackRate"), processor, FallbackRate.class, getFallbackRate());
		processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, Schedule.class, getFloatingRateMultiplierSchedule());
		processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.class, getSpreadSchedule());
		processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
		processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.class, getCapRateSchedule());
		processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.class, getFloorRateSchedule());
		processor.processBasic(path.newSubPath("initialRate"), BigDecimal.class, getInitialRate(), this);
		processRosetta(path.newSubPath("finalRateRounding"), processor, Rounding.class, getFinalRateRounding());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("negativeInterestRateTreatment"), NegativeInterestRateTreatmentEnum.class, getNegativeInterestRateTreatment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateCalculationBuilder extends FloatingRateCalculation, FloatingRate.FloatingRateBuilder {
		Rounding.RoundingBuilder getOrCreateFinalRateRounding();
		@Override
		Rounding.RoundingBuilder getFinalRateRounding();
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder setId(String id);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder setIndexTenor(Period indexTenor);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder setCalculationParameters(CalculationParameters calculationParameters);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder setFallbackRate(FallbackRate fallbackRate);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder setFloatingRateMultiplierSchedule(Schedule floatingRateMultiplierSchedule);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int idx);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int idx);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int idx);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		FloatingRateCalculation.FloatingRateCalculationBuilder setInitialRate(BigDecimal initialRate);
		FloatingRateCalculation.FloatingRateCalculationBuilder setFinalRateRounding(Rounding finalRateRounding);
		FloatingRateCalculation.FloatingRateCalculationBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		FloatingRateCalculation.FloatingRateCalculationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum negativeInterestRateTreatment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
			processRosetta(path.newSubPath("calculationParameters"), processor, CalculationParameters.CalculationParametersBuilder.class, getCalculationParameters());
			processRosetta(path.newSubPath("fallbackRate"), processor, FallbackRate.FallbackRateBuilder.class, getFallbackRate());
			processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, Schedule.ScheduleBuilder.class, getFloatingRateMultiplierSchedule());
			processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpreadSchedule());
			processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
			processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getCapRateSchedule());
			processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getFloorRateSchedule());
			processor.processBasic(path.newSubPath("initialRate"), BigDecimal.class, getInitialRate(), this);
			processRosetta(path.newSubPath("finalRateRounding"), processor, Rounding.RoundingBuilder.class, getFinalRateRounding());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("negativeInterestRateTreatment"), NegativeInterestRateTreatmentEnum.class, getNegativeInterestRateTreatment(), this);
		}
		

		FloatingRateCalculation.FloatingRateCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateCalculation  ***********************/
	class FloatingRateCalculationImpl extends FloatingRate.FloatingRateImpl implements FloatingRateCalculation {
		private final BigDecimal initialRate;
		private final Rounding finalRateRounding;
		private final AveragingMethodEnum averagingMethod;
		private final NegativeInterestRateTreatmentEnum negativeInterestRateTreatment;
		
		protected FloatingRateCalculationImpl(FloatingRateCalculation.FloatingRateCalculationBuilder builder) {
			super(builder);
			this.initialRate = builder.getInitialRate();
			this.finalRateRounding = ofNullable(builder.getFinalRateRounding()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.negativeInterestRateTreatment = builder.getNegativeInterestRateTreatment();
		}
		
		@Override
		@RosettaAttribute("initialRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialRate")
		public BigDecimal getInitialRate() {
			return initialRate;
		}
		
		@Override
		@RosettaAttribute("finalRateRounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalRateRounding")
		public Rounding getFinalRateRounding() {
			return finalRateRounding;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("negativeInterestRateTreatment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("negativeInterestRateTreatment")
		public NegativeInterestRateTreatmentEnum getNegativeInterestRateTreatment() {
			return negativeInterestRateTreatment;
		}
		
		@Override
		public FloatingRateCalculation build() {
			return this;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder toBuilder() {
			FloatingRateCalculation.FloatingRateCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateCalculation.FloatingRateCalculationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInitialRate()).ifPresent(builder::setInitialRate);
			ofNullable(getFinalRateRounding()).ifPresent(builder::setFinalRateRounding);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getNegativeInterestRateTreatment()).ifPresent(builder::setNegativeInterestRateTreatment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateCalculation _that = getType().cast(o);
		
			if (!Objects.equals(initialRate, _that.getInitialRate())) return false;
			if (!Objects.equals(finalRateRounding, _that.getFinalRateRounding())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(negativeInterestRateTreatment, _that.getNegativeInterestRateTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (initialRate != null ? initialRate.hashCode() : 0);
			_result = 31 * _result + (finalRateRounding != null ? finalRateRounding.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (negativeInterestRateTreatment != null ? negativeInterestRateTreatment.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateCalculation {" +
				"initialRate=" + this.initialRate + ", " +
				"finalRateRounding=" + this.finalRateRounding + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"negativeInterestRateTreatment=" + this.negativeInterestRateTreatment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingRateCalculation  ***********************/
	class FloatingRateCalculationBuilderImpl extends FloatingRate.FloatingRateBuilderImpl implements FloatingRateCalculation.FloatingRateCalculationBuilder {
	
		protected BigDecimal initialRate;
		protected Rounding.RoundingBuilder finalRateRounding;
		protected AveragingMethodEnum averagingMethod;
		protected NegativeInterestRateTreatmentEnum negativeInterestRateTreatment;
		
		@Override
		@RosettaAttribute("initialRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialRate")
		public BigDecimal getInitialRate() {
			return initialRate;
		}
		
		@Override
		@RosettaAttribute("finalRateRounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalRateRounding")
		public Rounding.RoundingBuilder getFinalRateRounding() {
			return finalRateRounding;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreateFinalRateRounding() {
			Rounding.RoundingBuilder result;
			if (finalRateRounding!=null) {
				result = finalRateRounding;
			}
			else {
				result = finalRateRounding = Rounding.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("negativeInterestRateTreatment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("negativeInterestRateTreatment")
		public NegativeInterestRateTreatmentEnum getNegativeInterestRateTreatment() {
			return negativeInterestRateTreatment;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("floatingRateIndex")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setFloatingRateIndex(FloatingRateIndex _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexTenor")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setIndexTenor(Period _indexTenor) {
			this.indexTenor = _indexTenor == null ? null : _indexTenor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationParameters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationParameters")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setCalculationParameters(CalculationParameters _calculationParameters) {
			this.calculationParameters = _calculationParameters == null ? null : _calculationParameters.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fallbackRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackRate")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setFallbackRate(FallbackRate _fallbackRate) {
			this.fallbackRate = _fallbackRate == null ? null : _fallbackRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRateMultiplierSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateMultiplierSchedule")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setFloatingRateMultiplierSchedule(Schedule _floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = _floatingRateMultiplierSchedule == null ? null : _floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("spreadSchedule")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addSpreadSchedule(SpreadSchedule _spreadSchedule) {
			if (_spreadSchedule != null) {
				this.spreadSchedule.add(_spreadSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addSpreadSchedule(SpreadSchedule _spreadSchedule, int idx) {
			getIndex(this.spreadSchedule, idx, () -> _spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (final SpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("spreadSchedule")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules == null) {
				this.spreadSchedule = new ArrayList<>();
			} else {
				this.spreadSchedule = spreadSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("rateTreatment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateTreatment")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setRateTreatment(RateTreatmentEnum _rateTreatment) {
			this.rateTreatment = _rateTreatment == null ? null : _rateTreatment;
			return this;
		}
		
		@RosettaAttribute("capRateSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("capRateSchedule")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addCapRateSchedule(StrikeSchedule _capRateSchedule) {
			if (_capRateSchedule != null) {
				this.capRateSchedule.add(_capRateSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addCapRateSchedule(StrikeSchedule _capRateSchedule, int idx) {
			getIndex(this.capRateSchedule, idx, () -> _capRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules != null) {
				for (final StrikeSchedule toAdd : capRateSchedules) {
					this.capRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("capRateSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("capRateSchedule")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules == null) {
				this.capRateSchedule = new ArrayList<>();
			} else {
				this.capRateSchedule = capRateSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("floorRateSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("floorRateSchedule")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addFloorRateSchedule(StrikeSchedule _floorRateSchedule) {
			if (_floorRateSchedule != null) {
				this.floorRateSchedule.add(_floorRateSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addFloorRateSchedule(StrikeSchedule _floorRateSchedule, int idx) {
			getIndex(this.floorRateSchedule, idx, () -> _floorRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules != null) {
				for (final StrikeSchedule toAdd : floorRateSchedules) {
					this.floorRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("floorRateSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("floorRateSchedule")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules == null) {
				this.floorRateSchedule = new ArrayList<>();
			} else {
				this.floorRateSchedule = floorRateSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("initialRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialRate")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setInitialRate(BigDecimal _initialRate) {
			this.initialRate = _initialRate == null ? null : _initialRate;
			return this;
		}
		
		@RosettaAttribute("finalRateRounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalRateRounding")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setFinalRateRounding(Rounding _finalRateRounding) {
			this.finalRateRounding = _finalRateRounding == null ? null : _finalRateRounding.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingMethod")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setAveragingMethod(AveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("negativeInterestRateTreatment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("negativeInterestRateTreatment")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum _negativeInterestRateTreatment) {
			this.negativeInterestRateTreatment = _negativeInterestRateTreatment == null ? null : _negativeInterestRateTreatment;
			return this;
		}
		
		@Override
		public FloatingRateCalculation build() {
			return new FloatingRateCalculation.FloatingRateCalculationImpl(this);
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder prune() {
			super.prune();
			if (finalRateRounding!=null && !finalRateRounding.prune().hasData()) finalRateRounding = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInitialRate()!=null) return true;
			if (getFinalRateRounding()!=null && getFinalRateRounding().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getNegativeInterestRateTreatment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FloatingRateCalculation.FloatingRateCalculationBuilder o = (FloatingRateCalculation.FloatingRateCalculationBuilder) other;
			
			merger.mergeRosetta(getFinalRateRounding(), o.getFinalRateRounding(), this::setFinalRateRounding);
			
			merger.mergeBasic(getInitialRate(), o.getInitialRate(), this::setInitialRate);
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeBasic(getNegativeInterestRateTreatment(), o.getNegativeInterestRateTreatment(), this::setNegativeInterestRateTreatment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateCalculation _that = getType().cast(o);
		
			if (!Objects.equals(initialRate, _that.getInitialRate())) return false;
			if (!Objects.equals(finalRateRounding, _that.getFinalRateRounding())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(negativeInterestRateTreatment, _that.getNegativeInterestRateTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (initialRate != null ? initialRate.hashCode() : 0);
			_result = 31 * _result + (finalRateRounding != null ? finalRateRounding.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (negativeInterestRateTreatment != null ? negativeInterestRateTreatment.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateCalculationBuilder {" +
				"initialRate=" + this.initialRate + ", " +
				"finalRateRounding=" + this.finalRateRounding + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"negativeInterestRateTreatment=" + this.negativeInterestRateTreatment +
			'}' + " " + super.toString();
		}
	}
}

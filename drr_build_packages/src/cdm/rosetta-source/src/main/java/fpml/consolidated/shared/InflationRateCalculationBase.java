package fpml.consolidated.shared;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.NegativeInterestRateTreatmentEnum;
import fpml.consolidated.fpmlenum.RateTreatmentEnum;
import fpml.consolidated.shared.meta.InflationRateCalculationBaseMeta;
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
 * Provision A type defining the floating rate and definitions relating to the calculation of floating rate amounts. This type mimics the "FloatingRateCalculation" type but excludes the option of defining modular calculated rates and fallback rates. It provides an extension point for the InflationRateCalculation which does not require those features.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the floating rate and definitions relating to the calculation of floating rate amounts. This type mimics the "FloatingRateCalculation" type but excludes the option of defining modular calculated rates and fallback rates. It provides an extension point for the InflationRateCalculation which does not require those features.
 *
 */
@RosettaDataType(value="InflationRateCalculationBase", builder=InflationRateCalculationBase.InflationRateCalculationBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InflationRateCalculationBase", model="fpml", builder=InflationRateCalculationBase.InflationRateCalculationBaseBuilderImpl.class, version="2.1.1")
public interface InflationRateCalculationBase extends Rate {

	InflationRateCalculationBaseMeta metaData = new InflationRateCalculationBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA Floating Rate Option, i.e. the name of the floating rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA Floating Rate Option, i.e. the name of the floating rate.
	 *
	 */
	FloatingRateIndex getFloatingRateIndex();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA Designated Maturity, i.e. the tenor of the floating rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA Designated Maturity, i.e. the tenor of the floating rate.
	 *
	 */
	Period getIndexTenor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
	 *
	 */
	Schedule getFloatingRateMultiplierSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
	 *
	 */
	List<? extends SpreadSchedule> getSpreadSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
	 *
	 */
	RateTreatmentEnum getRateTreatment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
	 *
	 */
	List<? extends StrikeSchedule> getCapRateSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
	 *
	 */
	List<? extends StrikeSchedule> getFloorRateSchedule();
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
	InflationRateCalculationBase build();
	
	InflationRateCalculationBase.InflationRateCalculationBaseBuilder toBuilder();
	
	static InflationRateCalculationBase.InflationRateCalculationBaseBuilder builder() {
		return new InflationRateCalculationBase.InflationRateCalculationBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InflationRateCalculationBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InflationRateCalculationBase> getType() {
		return InflationRateCalculationBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
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
	interface InflationRateCalculationBaseBuilder extends InflationRateCalculationBase, Rate.RateBuilder {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex();
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor();
		@Override
		Period.PeriodBuilder getIndexTenor();
		Schedule.ScheduleBuilder getOrCreateFloatingRateMultiplierSchedule();
		@Override
		Schedule.ScheduleBuilder getFloatingRateMultiplierSchedule();
		SpreadSchedule.SpreadScheduleBuilder getOrCreateSpreadSchedule(int index);
		@Override
		List<? extends SpreadSchedule.SpreadScheduleBuilder> getSpreadSchedule();
		StrikeSchedule.StrikeScheduleBuilder getOrCreateCapRateSchedule(int index);
		@Override
		List<? extends StrikeSchedule.StrikeScheduleBuilder> getCapRateSchedule();
		StrikeSchedule.StrikeScheduleBuilder getOrCreateFloorRateSchedule(int index);
		@Override
		List<? extends StrikeSchedule.StrikeScheduleBuilder> getFloorRateSchedule();
		Rounding.RoundingBuilder getOrCreateFinalRateRounding();
		@Override
		Rounding.RoundingBuilder getFinalRateRounding();
		@Override
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder setId(String id);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder setIndexTenor(Period indexTenor);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder setFloatingRateMultiplierSchedule(Schedule floatingRateMultiplierSchedule);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder addSpreadSchedule(SpreadSchedule spreadSchedule);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int idx);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder addCapRateSchedule(StrikeSchedule capRateSchedule);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int idx);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int idx);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder setInitialRate(BigDecimal initialRate);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder setFinalRateRounding(Rounding finalRateRounding);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		InflationRateCalculationBase.InflationRateCalculationBaseBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum negativeInterestRateTreatment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
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
		

		InflationRateCalculationBase.InflationRateCalculationBaseBuilder prune();
	}

	/*********************** Immutable Implementation of InflationRateCalculationBase  ***********************/
	class InflationRateCalculationBaseImpl extends Rate.RateImpl implements InflationRateCalculationBase {
		private final FloatingRateIndex floatingRateIndex;
		private final Period indexTenor;
		private final Schedule floatingRateMultiplierSchedule;
		private final List<? extends SpreadSchedule> spreadSchedule;
		private final RateTreatmentEnum rateTreatment;
		private final List<? extends StrikeSchedule> capRateSchedule;
		private final List<? extends StrikeSchedule> floorRateSchedule;
		private final BigDecimal initialRate;
		private final Rounding finalRateRounding;
		private final AveragingMethodEnum averagingMethod;
		private final NegativeInterestRateTreatmentEnum negativeInterestRateTreatment;
		
		protected InflationRateCalculationBaseImpl(InflationRateCalculationBase.InflationRateCalculationBaseBuilder builder) {
			super(builder);
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).map(f->f.build()).orElse(null);
			this.floatingRateMultiplierSchedule = ofNullable(builder.getFloatingRateMultiplierSchedule()).map(f->f.build()).orElse(null);
			this.spreadSchedule = ofNullable(builder.getSpreadSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rateTreatment = builder.getRateTreatment();
			this.capRateSchedule = ofNullable(builder.getCapRateSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.floorRateSchedule = ofNullable(builder.getFloorRateSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.initialRate = builder.getInitialRate();
			this.finalRateRounding = ofNullable(builder.getFinalRateRounding()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.negativeInterestRateTreatment = builder.getNegativeInterestRateTreatment();
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("floatingRateIndex")
		public FloatingRateIndex getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexTenor")
		public Period getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		@RosettaAttribute("floatingRateMultiplierSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateMultiplierSchedule")
		public Schedule getFloatingRateMultiplierSchedule() {
			return floatingRateMultiplierSchedule;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spreadSchedule")
		public List<? extends SpreadSchedule> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		@RosettaAttribute("rateTreatment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateTreatment")
		public RateTreatmentEnum getRateTreatment() {
			return rateTreatment;
		}
		
		@Override
		@RosettaAttribute("capRateSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("capRateSchedule")
		public List<? extends StrikeSchedule> getCapRateSchedule() {
			return capRateSchedule;
		}
		
		@Override
		@RosettaAttribute("floorRateSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("floorRateSchedule")
		public List<? extends StrikeSchedule> getFloorRateSchedule() {
			return floorRateSchedule;
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
		public InflationRateCalculationBase build() {
			return this;
		}
		
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder toBuilder() {
			InflationRateCalculationBase.InflationRateCalculationBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InflationRateCalculationBase.InflationRateCalculationBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
			ofNullable(getFloatingRateMultiplierSchedule()).ifPresent(builder::setFloatingRateMultiplierSchedule);
			ofNullable(getSpreadSchedule()).ifPresent(builder::setSpreadSchedule);
			ofNullable(getRateTreatment()).ifPresent(builder::setRateTreatment);
			ofNullable(getCapRateSchedule()).ifPresent(builder::setCapRateSchedule);
			ofNullable(getFloorRateSchedule()).ifPresent(builder::setFloorRateSchedule);
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
		
			InflationRateCalculationBase _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(floatingRateMultiplierSchedule, _that.getFloatingRateMultiplierSchedule())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			if (!Objects.equals(rateTreatment, _that.getRateTreatment())) return false;
			if (!ListEquals.listEquals(capRateSchedule, _that.getCapRateSchedule())) return false;
			if (!ListEquals.listEquals(floorRateSchedule, _that.getFloorRateSchedule())) return false;
			if (!Objects.equals(initialRate, _that.getInitialRate())) return false;
			if (!Objects.equals(finalRateRounding, _that.getFinalRateRounding())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(negativeInterestRateTreatment, _that.getNegativeInterestRateTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (floatingRateMultiplierSchedule != null ? floatingRateMultiplierSchedule.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			_result = 31 * _result + (rateTreatment != null ? rateTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (capRateSchedule != null ? capRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floorRateSchedule != null ? floorRateSchedule.hashCode() : 0);
			_result = 31 * _result + (initialRate != null ? initialRate.hashCode() : 0);
			_result = 31 * _result + (finalRateRounding != null ? finalRateRounding.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (negativeInterestRateTreatment != null ? negativeInterestRateTreatment.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InflationRateCalculationBase {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"floatingRateMultiplierSchedule=" + this.floatingRateMultiplierSchedule + ", " +
				"spreadSchedule=" + this.spreadSchedule + ", " +
				"rateTreatment=" + this.rateTreatment + ", " +
				"capRateSchedule=" + this.capRateSchedule + ", " +
				"floorRateSchedule=" + this.floorRateSchedule + ", " +
				"initialRate=" + this.initialRate + ", " +
				"finalRateRounding=" + this.finalRateRounding + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"negativeInterestRateTreatment=" + this.negativeInterestRateTreatment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InflationRateCalculationBase  ***********************/
	class InflationRateCalculationBaseBuilderImpl extends Rate.RateBuilderImpl implements InflationRateCalculationBase.InflationRateCalculationBaseBuilder {
	
		protected FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex;
		protected Period.PeriodBuilder indexTenor;
		protected Schedule.ScheduleBuilder floatingRateMultiplierSchedule;
		protected List<SpreadSchedule.SpreadScheduleBuilder> spreadSchedule = new ArrayList<>();
		protected RateTreatmentEnum rateTreatment;
		protected List<StrikeSchedule.StrikeScheduleBuilder> capRateSchedule = new ArrayList<>();
		protected List<StrikeSchedule.StrikeScheduleBuilder> floorRateSchedule = new ArrayList<>();
		protected BigDecimal initialRate;
		protected Rounding.RoundingBuilder finalRateRounding;
		protected AveragingMethodEnum averagingMethod;
		protected NegativeInterestRateTreatmentEnum negativeInterestRateTreatment;
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("floatingRateIndex")
		public FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex() {
			FloatingRateIndex.FloatingRateIndexBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FloatingRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexTenor")
		public Period.PeriodBuilder getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateIndexTenor() {
			Period.PeriodBuilder result;
			if (indexTenor!=null) {
				result = indexTenor;
			}
			else {
				result = indexTenor = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateMultiplierSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateMultiplierSchedule")
		public Schedule.ScheduleBuilder getFloatingRateMultiplierSchedule() {
			return floatingRateMultiplierSchedule;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateFloatingRateMultiplierSchedule() {
			Schedule.ScheduleBuilder result;
			if (floatingRateMultiplierSchedule!=null) {
				result = floatingRateMultiplierSchedule;
			}
			else {
				result = floatingRateMultiplierSchedule = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spreadSchedule")
		public List<? extends SpreadSchedule.SpreadScheduleBuilder> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		public SpreadSchedule.SpreadScheduleBuilder getOrCreateSpreadSchedule(int index) {
			if (spreadSchedule==null) {
				this.spreadSchedule = new ArrayList<>();
			}
			return getIndex(spreadSchedule, index, () -> {
						SpreadSchedule.SpreadScheduleBuilder newSpreadSchedule = SpreadSchedule.builder();
						return newSpreadSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("rateTreatment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateTreatment")
		public RateTreatmentEnum getRateTreatment() {
			return rateTreatment;
		}
		
		@Override
		@RosettaAttribute("capRateSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("capRateSchedule")
		public List<? extends StrikeSchedule.StrikeScheduleBuilder> getCapRateSchedule() {
			return capRateSchedule;
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder getOrCreateCapRateSchedule(int index) {
			if (capRateSchedule==null) {
				this.capRateSchedule = new ArrayList<>();
			}
			return getIndex(capRateSchedule, index, () -> {
						StrikeSchedule.StrikeScheduleBuilder newCapRateSchedule = StrikeSchedule.builder();
						return newCapRateSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("floorRateSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("floorRateSchedule")
		public List<? extends StrikeSchedule.StrikeScheduleBuilder> getFloorRateSchedule() {
			return floorRateSchedule;
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder getOrCreateFloorRateSchedule(int index) {
			if (floorRateSchedule==null) {
				this.floorRateSchedule = new ArrayList<>();
			}
			return getIndex(floorRateSchedule, index, () -> {
						StrikeSchedule.StrikeScheduleBuilder newFloorRateSchedule = StrikeSchedule.builder();
						return newFloorRateSchedule;
					});
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
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("floatingRateIndex")
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder setFloatingRateIndex(FloatingRateIndex _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexTenor")
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder setIndexTenor(Period _indexTenor) {
			this.indexTenor = _indexTenor == null ? null : _indexTenor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRateMultiplierSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateMultiplierSchedule")
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder setFloatingRateMultiplierSchedule(Schedule _floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = _floatingRateMultiplierSchedule == null ? null : _floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("spreadSchedule")
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder addSpreadSchedule(SpreadSchedule _spreadSchedule) {
			if (_spreadSchedule != null) {
				this.spreadSchedule.add(_spreadSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder addSpreadSchedule(SpreadSchedule _spreadSchedule, int idx) {
			getIndex(this.spreadSchedule, idx, () -> _spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
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
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
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
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder setRateTreatment(RateTreatmentEnum _rateTreatment) {
			this.rateTreatment = _rateTreatment == null ? null : _rateTreatment;
			return this;
		}
		
		@RosettaAttribute("capRateSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("capRateSchedule")
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder addCapRateSchedule(StrikeSchedule _capRateSchedule) {
			if (_capRateSchedule != null) {
				this.capRateSchedule.add(_capRateSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder addCapRateSchedule(StrikeSchedule _capRateSchedule, int idx) {
			getIndex(this.capRateSchedule, idx, () -> _capRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
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
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
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
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder addFloorRateSchedule(StrikeSchedule _floorRateSchedule) {
			if (_floorRateSchedule != null) {
				this.floorRateSchedule.add(_floorRateSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder addFloorRateSchedule(StrikeSchedule _floorRateSchedule, int idx) {
			getIndex(this.floorRateSchedule, idx, () -> _floorRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
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
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
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
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder setInitialRate(BigDecimal _initialRate) {
			this.initialRate = _initialRate == null ? null : _initialRate;
			return this;
		}
		
		@RosettaAttribute("finalRateRounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalRateRounding")
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder setFinalRateRounding(Rounding _finalRateRounding) {
			this.finalRateRounding = _finalRateRounding == null ? null : _finalRateRounding.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingMethod")
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder setAveragingMethod(AveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("negativeInterestRateTreatment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("negativeInterestRateTreatment")
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum _negativeInterestRateTreatment) {
			this.negativeInterestRateTreatment = _negativeInterestRateTreatment == null ? null : _negativeInterestRateTreatment;
			return this;
		}
		
		@Override
		public InflationRateCalculationBase build() {
			return new InflationRateCalculationBase.InflationRateCalculationBaseImpl(this);
		}
		
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder prune() {
			super.prune();
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (indexTenor!=null && !indexTenor.prune().hasData()) indexTenor = null;
			if (floatingRateMultiplierSchedule!=null && !floatingRateMultiplierSchedule.prune().hasData()) floatingRateMultiplierSchedule = null;
			spreadSchedule = spreadSchedule.stream().filter(b->b!=null).<SpreadSchedule.SpreadScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			capRateSchedule = capRateSchedule.stream().filter(b->b!=null).<StrikeSchedule.StrikeScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			floorRateSchedule = floorRateSchedule.stream().filter(b->b!=null).<StrikeSchedule.StrikeScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (finalRateRounding!=null && !finalRateRounding.prune().hasData()) finalRateRounding = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFloatingRateIndex()!=null && getFloatingRateIndex().hasData()) return true;
			if (getIndexTenor()!=null && getIndexTenor().hasData()) return true;
			if (getFloatingRateMultiplierSchedule()!=null && getFloatingRateMultiplierSchedule().hasData()) return true;
			if (getSpreadSchedule()!=null && getSpreadSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateTreatment()!=null) return true;
			if (getCapRateSchedule()!=null && getCapRateSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFloorRateSchedule()!=null && getFloorRateSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInitialRate()!=null) return true;
			if (getFinalRateRounding()!=null && getFinalRateRounding().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getNegativeInterestRateTreatment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InflationRateCalculationBase.InflationRateCalculationBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			InflationRateCalculationBase.InflationRateCalculationBaseBuilder o = (InflationRateCalculationBase.InflationRateCalculationBaseBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			merger.mergeRosetta(getFloatingRateMultiplierSchedule(), o.getFloatingRateMultiplierSchedule(), this::setFloatingRateMultiplierSchedule);
			merger.mergeRosetta(getSpreadSchedule(), o.getSpreadSchedule(), this::getOrCreateSpreadSchedule);
			merger.mergeRosetta(getCapRateSchedule(), o.getCapRateSchedule(), this::getOrCreateCapRateSchedule);
			merger.mergeRosetta(getFloorRateSchedule(), o.getFloorRateSchedule(), this::getOrCreateFloorRateSchedule);
			merger.mergeRosetta(getFinalRateRounding(), o.getFinalRateRounding(), this::setFinalRateRounding);
			
			merger.mergeBasic(getRateTreatment(), o.getRateTreatment(), this::setRateTreatment);
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
		
			InflationRateCalculationBase _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(floatingRateMultiplierSchedule, _that.getFloatingRateMultiplierSchedule())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			if (!Objects.equals(rateTreatment, _that.getRateTreatment())) return false;
			if (!ListEquals.listEquals(capRateSchedule, _that.getCapRateSchedule())) return false;
			if (!ListEquals.listEquals(floorRateSchedule, _that.getFloorRateSchedule())) return false;
			if (!Objects.equals(initialRate, _that.getInitialRate())) return false;
			if (!Objects.equals(finalRateRounding, _that.getFinalRateRounding())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(negativeInterestRateTreatment, _that.getNegativeInterestRateTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (floatingRateMultiplierSchedule != null ? floatingRateMultiplierSchedule.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			_result = 31 * _result + (rateTreatment != null ? rateTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (capRateSchedule != null ? capRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floorRateSchedule != null ? floorRateSchedule.hashCode() : 0);
			_result = 31 * _result + (initialRate != null ? initialRate.hashCode() : 0);
			_result = 31 * _result + (finalRateRounding != null ? finalRateRounding.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (negativeInterestRateTreatment != null ? negativeInterestRateTreatment.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InflationRateCalculationBaseBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"floatingRateMultiplierSchedule=" + this.floatingRateMultiplierSchedule + ", " +
				"spreadSchedule=" + this.spreadSchedule + ", " +
				"rateTreatment=" + this.rateTreatment + ", " +
				"capRateSchedule=" + this.capRateSchedule + ", " +
				"floorRateSchedule=" + this.floorRateSchedule + ", " +
				"initialRate=" + this.initialRate + ", " +
				"finalRateRounding=" + this.finalRateRounding + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"negativeInterestRateTreatment=" + this.negativeInterestRateTreatment +
			'}' + " " + super.toString();
		}
	}
}

package fpml.consolidated.shared;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.fpmlenum.RateTreatmentEnum;
import fpml.consolidated.shared.meta.StubFloatingRateMeta;
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
 * Provision A type defining a floating rate.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a floating rate.
 *
 */
@RosettaDataType(value="StubFloatingRate", builder=StubFloatingRate.StubFloatingRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="StubFloatingRate", model="fpml", builder=StubFloatingRate.StubFloatingRateBuilderImpl.class, version="2.1.1")
public interface StubFloatingRate extends Rate {

	StubFloatingRateMeta metaData = new StubFloatingRateMeta();

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
	 * Provision A fallback rate calculated using an averaging or compounding formula to be used in case of the cessation of the original term rate. This structure is provided to allow an approximate representation to be created for published fallback rates to allow operations such as valuation, accrual calculation, and risk calculation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A fallback rate calculated using an averaging or compounding formula to be used in case of the cessation of the original term rate. This structure is provided to allow an approximate representation to be created for published fallback rates to allow operations such as valuation, accrual calculation, and risk calculation.
	 *
	 */
	FallbackRate getFallbackRate();
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

	/*********************** Build Methods  ***********************/
	StubFloatingRate build();
	
	StubFloatingRate.StubFloatingRateBuilder toBuilder();
	
	static StubFloatingRate.StubFloatingRateBuilder builder() {
		return new StubFloatingRate.StubFloatingRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StubFloatingRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends StubFloatingRate> getType() {
		return StubFloatingRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
		processRosetta(path.newSubPath("fallbackRate"), processor, FallbackRate.class, getFallbackRate());
		processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, Schedule.class, getFloatingRateMultiplierSchedule());
		processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.class, getSpreadSchedule());
		processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
		processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.class, getCapRateSchedule());
		processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.class, getFloorRateSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StubFloatingRateBuilder extends StubFloatingRate, Rate.RateBuilder {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex();
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor();
		@Override
		Period.PeriodBuilder getIndexTenor();
		FallbackRate.FallbackRateBuilder getOrCreateFallbackRate();
		@Override
		FallbackRate.FallbackRateBuilder getFallbackRate();
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
		@Override
		StubFloatingRate.StubFloatingRateBuilder setId(String id);
		StubFloatingRate.StubFloatingRateBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		StubFloatingRate.StubFloatingRateBuilder setIndexTenor(Period indexTenor);
		StubFloatingRate.StubFloatingRateBuilder setFallbackRate(FallbackRate fallbackRate);
		StubFloatingRate.StubFloatingRateBuilder setFloatingRateMultiplierSchedule(Schedule floatingRateMultiplierSchedule);
		StubFloatingRate.StubFloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule);
		StubFloatingRate.StubFloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int idx);
		StubFloatingRate.StubFloatingRateBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		StubFloatingRate.StubFloatingRateBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		StubFloatingRate.StubFloatingRateBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		StubFloatingRate.StubFloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule);
		StubFloatingRate.StubFloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int idx);
		StubFloatingRate.StubFloatingRateBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		StubFloatingRate.StubFloatingRateBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		StubFloatingRate.StubFloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule);
		StubFloatingRate.StubFloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int idx);
		StubFloatingRate.StubFloatingRateBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		StubFloatingRate.StubFloatingRateBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
			processRosetta(path.newSubPath("fallbackRate"), processor, FallbackRate.FallbackRateBuilder.class, getFallbackRate());
			processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, Schedule.ScheduleBuilder.class, getFloatingRateMultiplierSchedule());
			processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpreadSchedule());
			processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
			processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getCapRateSchedule());
			processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getFloorRateSchedule());
		}
		

		StubFloatingRate.StubFloatingRateBuilder prune();
	}

	/*********************** Immutable Implementation of StubFloatingRate  ***********************/
	class StubFloatingRateImpl extends Rate.RateImpl implements StubFloatingRate {
		private final FloatingRateIndex floatingRateIndex;
		private final Period indexTenor;
		private final FallbackRate fallbackRate;
		private final Schedule floatingRateMultiplierSchedule;
		private final List<? extends SpreadSchedule> spreadSchedule;
		private final RateTreatmentEnum rateTreatment;
		private final List<? extends StrikeSchedule> capRateSchedule;
		private final List<? extends StrikeSchedule> floorRateSchedule;
		
		protected StubFloatingRateImpl(StubFloatingRate.StubFloatingRateBuilder builder) {
			super(builder);
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).map(f->f.build()).orElse(null);
			this.fallbackRate = ofNullable(builder.getFallbackRate()).map(f->f.build()).orElse(null);
			this.floatingRateMultiplierSchedule = ofNullable(builder.getFloatingRateMultiplierSchedule()).map(f->f.build()).orElse(null);
			this.spreadSchedule = ofNullable(builder.getSpreadSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rateTreatment = builder.getRateTreatment();
			this.capRateSchedule = ofNullable(builder.getCapRateSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.floorRateSchedule = ofNullable(builder.getFloorRateSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("fallbackRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackRate")
		public FallbackRate getFallbackRate() {
			return fallbackRate;
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
		public StubFloatingRate build() {
			return this;
		}
		
		@Override
		public StubFloatingRate.StubFloatingRateBuilder toBuilder() {
			StubFloatingRate.StubFloatingRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StubFloatingRate.StubFloatingRateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
			ofNullable(getFallbackRate()).ifPresent(builder::setFallbackRate);
			ofNullable(getFloatingRateMultiplierSchedule()).ifPresent(builder::setFloatingRateMultiplierSchedule);
			ofNullable(getSpreadSchedule()).ifPresent(builder::setSpreadSchedule);
			ofNullable(getRateTreatment()).ifPresent(builder::setRateTreatment);
			ofNullable(getCapRateSchedule()).ifPresent(builder::setCapRateSchedule);
			ofNullable(getFloorRateSchedule()).ifPresent(builder::setFloorRateSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StubFloatingRate _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(fallbackRate, _that.getFallbackRate())) return false;
			if (!Objects.equals(floatingRateMultiplierSchedule, _that.getFloatingRateMultiplierSchedule())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			if (!Objects.equals(rateTreatment, _that.getRateTreatment())) return false;
			if (!ListEquals.listEquals(capRateSchedule, _that.getCapRateSchedule())) return false;
			if (!ListEquals.listEquals(floorRateSchedule, _that.getFloorRateSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (fallbackRate != null ? fallbackRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateMultiplierSchedule != null ? floatingRateMultiplierSchedule.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			_result = 31 * _result + (rateTreatment != null ? rateTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (capRateSchedule != null ? capRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floorRateSchedule != null ? floorRateSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StubFloatingRate {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"fallbackRate=" + this.fallbackRate + ", " +
				"floatingRateMultiplierSchedule=" + this.floatingRateMultiplierSchedule + ", " +
				"spreadSchedule=" + this.spreadSchedule + ", " +
				"rateTreatment=" + this.rateTreatment + ", " +
				"capRateSchedule=" + this.capRateSchedule + ", " +
				"floorRateSchedule=" + this.floorRateSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of StubFloatingRate  ***********************/
	class StubFloatingRateBuilderImpl extends Rate.RateBuilderImpl implements StubFloatingRate.StubFloatingRateBuilder {
	
		protected FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex;
		protected Period.PeriodBuilder indexTenor;
		protected FallbackRate.FallbackRateBuilder fallbackRate;
		protected Schedule.ScheduleBuilder floatingRateMultiplierSchedule;
		protected List<SpreadSchedule.SpreadScheduleBuilder> spreadSchedule = new ArrayList<>();
		protected RateTreatmentEnum rateTreatment;
		protected List<StrikeSchedule.StrikeScheduleBuilder> capRateSchedule = new ArrayList<>();
		protected List<StrikeSchedule.StrikeScheduleBuilder> floorRateSchedule = new ArrayList<>();
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("fallbackRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackRate")
		public FallbackRate.FallbackRateBuilder getFallbackRate() {
			return fallbackRate;
		}
		
		@Override
		public FallbackRate.FallbackRateBuilder getOrCreateFallbackRate() {
			FallbackRate.FallbackRateBuilder result;
			if (fallbackRate!=null) {
				result = fallbackRate;
			}
			else {
				result = fallbackRate = FallbackRate.builder();
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public StubFloatingRate.StubFloatingRateBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateIndex")
		@Override
		public StubFloatingRate.StubFloatingRateBuilder setFloatingRateIndex(FloatingRateIndex _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexTenor")
		@Override
		public StubFloatingRate.StubFloatingRateBuilder setIndexTenor(Period _indexTenor) {
			this.indexTenor = _indexTenor == null ? null : _indexTenor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fallbackRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackRate")
		@Override
		public StubFloatingRate.StubFloatingRateBuilder setFallbackRate(FallbackRate _fallbackRate) {
			this.fallbackRate = _fallbackRate == null ? null : _fallbackRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRateMultiplierSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateMultiplierSchedule")
		@Override
		public StubFloatingRate.StubFloatingRateBuilder setFloatingRateMultiplierSchedule(Schedule _floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = _floatingRateMultiplierSchedule == null ? null : _floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("spreadSchedule")
		@Override
		public StubFloatingRate.StubFloatingRateBuilder addSpreadSchedule(SpreadSchedule _spreadSchedule) {
			if (_spreadSchedule != null) {
				this.spreadSchedule.add(_spreadSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public StubFloatingRate.StubFloatingRateBuilder addSpreadSchedule(SpreadSchedule _spreadSchedule, int idx) {
			getIndex(this.spreadSchedule, idx, () -> _spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public StubFloatingRate.StubFloatingRateBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
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
		public StubFloatingRate.StubFloatingRateBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
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
		public StubFloatingRate.StubFloatingRateBuilder setRateTreatment(RateTreatmentEnum _rateTreatment) {
			this.rateTreatment = _rateTreatment == null ? null : _rateTreatment;
			return this;
		}
		
		@RosettaAttribute("capRateSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("capRateSchedule")
		@Override
		public StubFloatingRate.StubFloatingRateBuilder addCapRateSchedule(StrikeSchedule _capRateSchedule) {
			if (_capRateSchedule != null) {
				this.capRateSchedule.add(_capRateSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public StubFloatingRate.StubFloatingRateBuilder addCapRateSchedule(StrikeSchedule _capRateSchedule, int idx) {
			getIndex(this.capRateSchedule, idx, () -> _capRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public StubFloatingRate.StubFloatingRateBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
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
		public StubFloatingRate.StubFloatingRateBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
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
		public StubFloatingRate.StubFloatingRateBuilder addFloorRateSchedule(StrikeSchedule _floorRateSchedule) {
			if (_floorRateSchedule != null) {
				this.floorRateSchedule.add(_floorRateSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public StubFloatingRate.StubFloatingRateBuilder addFloorRateSchedule(StrikeSchedule _floorRateSchedule, int idx) {
			getIndex(this.floorRateSchedule, idx, () -> _floorRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public StubFloatingRate.StubFloatingRateBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
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
		public StubFloatingRate.StubFloatingRateBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules == null) {
				this.floorRateSchedule = new ArrayList<>();
			} else {
				this.floorRateSchedule = floorRateSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public StubFloatingRate build() {
			return new StubFloatingRate.StubFloatingRateImpl(this);
		}
		
		@Override
		public StubFloatingRate.StubFloatingRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubFloatingRate.StubFloatingRateBuilder prune() {
			super.prune();
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (indexTenor!=null && !indexTenor.prune().hasData()) indexTenor = null;
			if (fallbackRate!=null && !fallbackRate.prune().hasData()) fallbackRate = null;
			if (floatingRateMultiplierSchedule!=null && !floatingRateMultiplierSchedule.prune().hasData()) floatingRateMultiplierSchedule = null;
			spreadSchedule = spreadSchedule.stream().filter(b->b!=null).<SpreadSchedule.SpreadScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			capRateSchedule = capRateSchedule.stream().filter(b->b!=null).<StrikeSchedule.StrikeScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			floorRateSchedule = floorRateSchedule.stream().filter(b->b!=null).<StrikeSchedule.StrikeScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFloatingRateIndex()!=null && getFloatingRateIndex().hasData()) return true;
			if (getIndexTenor()!=null && getIndexTenor().hasData()) return true;
			if (getFallbackRate()!=null && getFallbackRate().hasData()) return true;
			if (getFloatingRateMultiplierSchedule()!=null && getFloatingRateMultiplierSchedule().hasData()) return true;
			if (getSpreadSchedule()!=null && getSpreadSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateTreatment()!=null) return true;
			if (getCapRateSchedule()!=null && getCapRateSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFloorRateSchedule()!=null && getFloorRateSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubFloatingRate.StubFloatingRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			StubFloatingRate.StubFloatingRateBuilder o = (StubFloatingRate.StubFloatingRateBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			merger.mergeRosetta(getFallbackRate(), o.getFallbackRate(), this::setFallbackRate);
			merger.mergeRosetta(getFloatingRateMultiplierSchedule(), o.getFloatingRateMultiplierSchedule(), this::setFloatingRateMultiplierSchedule);
			merger.mergeRosetta(getSpreadSchedule(), o.getSpreadSchedule(), this::getOrCreateSpreadSchedule);
			merger.mergeRosetta(getCapRateSchedule(), o.getCapRateSchedule(), this::getOrCreateCapRateSchedule);
			merger.mergeRosetta(getFloorRateSchedule(), o.getFloorRateSchedule(), this::getOrCreateFloorRateSchedule);
			
			merger.mergeBasic(getRateTreatment(), o.getRateTreatment(), this::setRateTreatment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StubFloatingRate _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			if (!Objects.equals(fallbackRate, _that.getFallbackRate())) return false;
			if (!Objects.equals(floatingRateMultiplierSchedule, _that.getFloatingRateMultiplierSchedule())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			if (!Objects.equals(rateTreatment, _that.getRateTreatment())) return false;
			if (!ListEquals.listEquals(capRateSchedule, _that.getCapRateSchedule())) return false;
			if (!ListEquals.listEquals(floorRateSchedule, _that.getFloorRateSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			_result = 31 * _result + (fallbackRate != null ? fallbackRate.hashCode() : 0);
			_result = 31 * _result + (floatingRateMultiplierSchedule != null ? floatingRateMultiplierSchedule.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			_result = 31 * _result + (rateTreatment != null ? rateTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (capRateSchedule != null ? capRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floorRateSchedule != null ? floorRateSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StubFloatingRateBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor + ", " +
				"fallbackRate=" + this.fallbackRate + ", " +
				"floatingRateMultiplierSchedule=" + this.floatingRateMultiplierSchedule + ", " +
				"spreadSchedule=" + this.spreadSchedule + ", " +
				"rateTreatment=" + this.rateTreatment + ", " +
				"capRateSchedule=" + this.capRateSchedule + ", " +
				"floorRateSchedule=" + this.floorRateSchedule +
			'}' + " " + super.toString();
		}
	}
}

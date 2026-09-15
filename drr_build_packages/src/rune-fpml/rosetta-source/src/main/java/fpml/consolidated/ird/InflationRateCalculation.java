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
import fpml.consolidated.fpmlenum.InflationCalculationMethodEnum;
import fpml.consolidated.fpmlenum.InflationCalculationStyleEnum;
import fpml.consolidated.fpmlenum.NegativeInterestRateTreatmentEnum;
import fpml.consolidated.fpmlenum.RateTreatmentEnum;
import fpml.consolidated.ird.meta.InflationRateCalculationMeta;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.InflationRateCalculationBase;
import fpml.consolidated.shared.InterpolationMethod;
import fpml.consolidated.shared.MainPublication;
import fpml.consolidated.shared.Offset;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.RateSourcePage;
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
 * Provision A type defining the components specifiying an Inflation Rate Calculation
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the components specifiying an Inflation Rate Calculation
 *
 */
@RosettaDataType(value="InflationRateCalculation", builder=InflationRateCalculation.InflationRateCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InflationRateCalculation", model="fpml", builder=InflationRateCalculation.InflationRateCalculationBuilderImpl.class, version="2.1.1")
public interface InflationRateCalculation extends InflationRateCalculationBase {

	InflationRateCalculationMeta metaData = new InflationRateCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision an offsetting period from the payment date which determines the reference period for which the inflation index is onserved.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision an offsetting period from the payment date which determines the reference period for which the inflation index is onserved.
	 *
	 */
	Offset getInflationLag();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The reference source such as Reuters or Bloomberg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The reference source such as Reuters or Bloomberg.
	 *
	 */
	RateSourcePage getIndexSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The current main publication source such as relevant web site or a government body.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The current main publication source such as relevant web site or a government body.
	 *
	 */
	MainPublication getMainPublication();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The method used when calculating the Inflation Index Level from multiple points - the most common is Linear.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The method used when calculating the Inflation Index Level from multiple points - the most common is Linear.
	 *
	 */
	InterpolationMethod getInterpolationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision initial known index level for the first calculation period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision initial known index level for the first calculation period.
	 *
	 */
	BigDecimal getInitialIndexLevel();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The applicability of a fallback bond as defined in the 2006 ISDA Inflation Derivatives Definitions, sections 1.3 and 1.8.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The applicability of a fallback bond as defined in the 2006 ISDA Inflation Derivatives Definitions, sections 1.3 and 1.8.
	 *
	 */
	Boolean getFallbackBondApplicable();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates how to use the inflation index to calculate the payment (e.g. Ratio, Return, Spread). Added for Inflation Asset Swap
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates how to use the inflation index to calculate the payment (e.g. Ratio, Return, Spread). Added for Inflation Asset Swap
	 *
	 */
	InflationCalculationMethodEnum getCalculationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the style of how the inflation index calculates the payment (e.g. YearOnYear, ZeroCoupon).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the style of how the inflation index calculates the payment (e.g. YearOnYear, ZeroCoupon).
	 *
	 */
	InflationCalculationStyleEnum getCalculationStyle();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision To be specified only for inflation products that embed a redemption payment, e.g. inflation linked asset swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision To be specified only for inflation products that embed a redemption payment, e.g. inflation linked asset swap.
	 *
	 */
	FinalPrincipalExchangeCalculation getFinalPrincipalExchangeCalculation();

	/*********************** Build Methods  ***********************/
	InflationRateCalculation build();
	
	InflationRateCalculation.InflationRateCalculationBuilder toBuilder();
	
	static InflationRateCalculation.InflationRateCalculationBuilder builder() {
		return new InflationRateCalculation.InflationRateCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InflationRateCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InflationRateCalculation> getType() {
		return InflationRateCalculation.class;
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
		processRosetta(path.newSubPath("inflationLag"), processor, Offset.class, getInflationLag());
		processRosetta(path.newSubPath("indexSource"), processor, RateSourcePage.class, getIndexSource());
		processRosetta(path.newSubPath("mainPublication"), processor, MainPublication.class, getMainPublication());
		processRosetta(path.newSubPath("interpolationMethod"), processor, InterpolationMethod.class, getInterpolationMethod());
		processor.processBasic(path.newSubPath("initialIndexLevel"), BigDecimal.class, getInitialIndexLevel(), this);
		processor.processBasic(path.newSubPath("fallbackBondApplicable"), Boolean.class, getFallbackBondApplicable(), this);
		processor.processBasic(path.newSubPath("calculationMethod"), InflationCalculationMethodEnum.class, getCalculationMethod(), this);
		processor.processBasic(path.newSubPath("calculationStyle"), InflationCalculationStyleEnum.class, getCalculationStyle(), this);
		processRosetta(path.newSubPath("finalPrincipalExchangeCalculation"), processor, FinalPrincipalExchangeCalculation.class, getFinalPrincipalExchangeCalculation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InflationRateCalculationBuilder extends InflationRateCalculation, InflationRateCalculationBase.InflationRateCalculationBaseBuilder {
		Offset.OffsetBuilder getOrCreateInflationLag();
		@Override
		Offset.OffsetBuilder getInflationLag();
		RateSourcePage.RateSourcePageBuilder getOrCreateIndexSource();
		@Override
		RateSourcePage.RateSourcePageBuilder getIndexSource();
		MainPublication.MainPublicationBuilder getOrCreateMainPublication();
		@Override
		MainPublication.MainPublicationBuilder getMainPublication();
		InterpolationMethod.InterpolationMethodBuilder getOrCreateInterpolationMethod();
		@Override
		InterpolationMethod.InterpolationMethodBuilder getInterpolationMethod();
		FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder getOrCreateFinalPrincipalExchangeCalculation();
		@Override
		FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder getFinalPrincipalExchangeCalculation();
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder setId(String id);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder setIndexTenor(Period indexTenor);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder setFloatingRateMultiplierSchedule(Schedule floatingRateMultiplierSchedule);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int idx);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int idx);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int idx);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder setInitialRate(BigDecimal initialRate);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder setFinalRateRounding(Rounding finalRateRounding);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		@Override
		InflationRateCalculation.InflationRateCalculationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum negativeInterestRateTreatment);
		InflationRateCalculation.InflationRateCalculationBuilder setInflationLag(Offset inflationLag);
		InflationRateCalculation.InflationRateCalculationBuilder setIndexSource(RateSourcePage indexSource);
		InflationRateCalculation.InflationRateCalculationBuilder setMainPublication(MainPublication mainPublication);
		InflationRateCalculation.InflationRateCalculationBuilder setInterpolationMethod(InterpolationMethod interpolationMethod);
		InflationRateCalculation.InflationRateCalculationBuilder setInitialIndexLevel(BigDecimal initialIndexLevel);
		InflationRateCalculation.InflationRateCalculationBuilder setFallbackBondApplicable(Boolean fallbackBondApplicable);
		InflationRateCalculation.InflationRateCalculationBuilder setCalculationMethod(InflationCalculationMethodEnum calculationMethod);
		InflationRateCalculation.InflationRateCalculationBuilder setCalculationStyle(InflationCalculationStyleEnum calculationStyle);
		InflationRateCalculation.InflationRateCalculationBuilder setFinalPrincipalExchangeCalculation(FinalPrincipalExchangeCalculation finalPrincipalExchangeCalculation);

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
			processRosetta(path.newSubPath("inflationLag"), processor, Offset.OffsetBuilder.class, getInflationLag());
			processRosetta(path.newSubPath("indexSource"), processor, RateSourcePage.RateSourcePageBuilder.class, getIndexSource());
			processRosetta(path.newSubPath("mainPublication"), processor, MainPublication.MainPublicationBuilder.class, getMainPublication());
			processRosetta(path.newSubPath("interpolationMethod"), processor, InterpolationMethod.InterpolationMethodBuilder.class, getInterpolationMethod());
			processor.processBasic(path.newSubPath("initialIndexLevel"), BigDecimal.class, getInitialIndexLevel(), this);
			processor.processBasic(path.newSubPath("fallbackBondApplicable"), Boolean.class, getFallbackBondApplicable(), this);
			processor.processBasic(path.newSubPath("calculationMethod"), InflationCalculationMethodEnum.class, getCalculationMethod(), this);
			processor.processBasic(path.newSubPath("calculationStyle"), InflationCalculationStyleEnum.class, getCalculationStyle(), this);
			processRosetta(path.newSubPath("finalPrincipalExchangeCalculation"), processor, FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder.class, getFinalPrincipalExchangeCalculation());
		}
		

		InflationRateCalculation.InflationRateCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of InflationRateCalculation  ***********************/
	class InflationRateCalculationImpl extends InflationRateCalculationBase.InflationRateCalculationBaseImpl implements InflationRateCalculation {
		private final Offset inflationLag;
		private final RateSourcePage indexSource;
		private final MainPublication mainPublication;
		private final InterpolationMethod interpolationMethod;
		private final BigDecimal initialIndexLevel;
		private final Boolean fallbackBondApplicable;
		private final InflationCalculationMethodEnum calculationMethod;
		private final InflationCalculationStyleEnum calculationStyle;
		private final FinalPrincipalExchangeCalculation finalPrincipalExchangeCalculation;
		
		protected InflationRateCalculationImpl(InflationRateCalculation.InflationRateCalculationBuilder builder) {
			super(builder);
			this.inflationLag = ofNullable(builder.getInflationLag()).map(f->f.build()).orElse(null);
			this.indexSource = ofNullable(builder.getIndexSource()).map(f->f.build()).orElse(null);
			this.mainPublication = ofNullable(builder.getMainPublication()).map(f->f.build()).orElse(null);
			this.interpolationMethod = ofNullable(builder.getInterpolationMethod()).map(f->f.build()).orElse(null);
			this.initialIndexLevel = builder.getInitialIndexLevel();
			this.fallbackBondApplicable = builder.getFallbackBondApplicable();
			this.calculationMethod = builder.getCalculationMethod();
			this.calculationStyle = builder.getCalculationStyle();
			this.finalPrincipalExchangeCalculation = ofNullable(builder.getFinalPrincipalExchangeCalculation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("inflationLag")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inflationLag")
		public Offset getInflationLag() {
			return inflationLag;
		}
		
		@Override
		@RosettaAttribute("indexSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexSource")
		public RateSourcePage getIndexSource() {
			return indexSource;
		}
		
		@Override
		@RosettaAttribute("mainPublication")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mainPublication")
		public MainPublication getMainPublication() {
			return mainPublication;
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interpolationMethod")
		public InterpolationMethod getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		@RosettaAttribute("initialIndexLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialIndexLevel")
		public BigDecimal getInitialIndexLevel() {
			return initialIndexLevel;
		}
		
		@Override
		@RosettaAttribute("fallbackBondApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackBondApplicable")
		public Boolean getFallbackBondApplicable() {
			return fallbackBondApplicable;
		}
		
		@Override
		@RosettaAttribute("calculationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationMethod")
		public InflationCalculationMethodEnum getCalculationMethod() {
			return calculationMethod;
		}
		
		@Override
		@RosettaAttribute("calculationStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationStyle")
		public InflationCalculationStyleEnum getCalculationStyle() {
			return calculationStyle;
		}
		
		@Override
		@RosettaAttribute("finalPrincipalExchangeCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalPrincipalExchangeCalculation")
		public FinalPrincipalExchangeCalculation getFinalPrincipalExchangeCalculation() {
			return finalPrincipalExchangeCalculation;
		}
		
		@Override
		public InflationRateCalculation build() {
			return this;
		}
		
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder toBuilder() {
			InflationRateCalculation.InflationRateCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InflationRateCalculation.InflationRateCalculationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInflationLag()).ifPresent(builder::setInflationLag);
			ofNullable(getIndexSource()).ifPresent(builder::setIndexSource);
			ofNullable(getMainPublication()).ifPresent(builder::setMainPublication);
			ofNullable(getInterpolationMethod()).ifPresent(builder::setInterpolationMethod);
			ofNullable(getInitialIndexLevel()).ifPresent(builder::setInitialIndexLevel);
			ofNullable(getFallbackBondApplicable()).ifPresent(builder::setFallbackBondApplicable);
			ofNullable(getCalculationMethod()).ifPresent(builder::setCalculationMethod);
			ofNullable(getCalculationStyle()).ifPresent(builder::setCalculationStyle);
			ofNullable(getFinalPrincipalExchangeCalculation()).ifPresent(builder::setFinalPrincipalExchangeCalculation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InflationRateCalculation _that = getType().cast(o);
		
			if (!Objects.equals(inflationLag, _that.getInflationLag())) return false;
			if (!Objects.equals(indexSource, _that.getIndexSource())) return false;
			if (!Objects.equals(mainPublication, _that.getMainPublication())) return false;
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(initialIndexLevel, _that.getInitialIndexLevel())) return false;
			if (!Objects.equals(fallbackBondApplicable, _that.getFallbackBondApplicable())) return false;
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
			if (!Objects.equals(calculationStyle, _that.getCalculationStyle())) return false;
			if (!Objects.equals(finalPrincipalExchangeCalculation, _that.getFinalPrincipalExchangeCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inflationLag != null ? inflationLag.hashCode() : 0);
			_result = 31 * _result + (indexSource != null ? indexSource.hashCode() : 0);
			_result = 31 * _result + (mainPublication != null ? mainPublication.hashCode() : 0);
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (initialIndexLevel != null ? initialIndexLevel.hashCode() : 0);
			_result = 31 * _result + (fallbackBondApplicable != null ? fallbackBondApplicable.hashCode() : 0);
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationStyle != null ? calculationStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (finalPrincipalExchangeCalculation != null ? finalPrincipalExchangeCalculation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InflationRateCalculation {" +
				"inflationLag=" + this.inflationLag + ", " +
				"indexSource=" + this.indexSource + ", " +
				"mainPublication=" + this.mainPublication + ", " +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"initialIndexLevel=" + this.initialIndexLevel + ", " +
				"fallbackBondApplicable=" + this.fallbackBondApplicable + ", " +
				"calculationMethod=" + this.calculationMethod + ", " +
				"calculationStyle=" + this.calculationStyle + ", " +
				"finalPrincipalExchangeCalculation=" + this.finalPrincipalExchangeCalculation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InflationRateCalculation  ***********************/
	class InflationRateCalculationBuilderImpl extends InflationRateCalculationBase.InflationRateCalculationBaseBuilderImpl implements InflationRateCalculation.InflationRateCalculationBuilder {
	
		protected Offset.OffsetBuilder inflationLag;
		protected RateSourcePage.RateSourcePageBuilder indexSource;
		protected MainPublication.MainPublicationBuilder mainPublication;
		protected InterpolationMethod.InterpolationMethodBuilder interpolationMethod;
		protected BigDecimal initialIndexLevel;
		protected Boolean fallbackBondApplicable;
		protected InflationCalculationMethodEnum calculationMethod;
		protected InflationCalculationStyleEnum calculationStyle;
		protected FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder finalPrincipalExchangeCalculation;
		
		@Override
		@RosettaAttribute("inflationLag")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inflationLag")
		public Offset.OffsetBuilder getInflationLag() {
			return inflationLag;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateInflationLag() {
			Offset.OffsetBuilder result;
			if (inflationLag!=null) {
				result = inflationLag;
			}
			else {
				result = inflationLag = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexSource")
		public RateSourcePage.RateSourcePageBuilder getIndexSource() {
			return indexSource;
		}
		
		@Override
		public RateSourcePage.RateSourcePageBuilder getOrCreateIndexSource() {
			RateSourcePage.RateSourcePageBuilder result;
			if (indexSource!=null) {
				result = indexSource;
			}
			else {
				result = indexSource = RateSourcePage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mainPublication")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mainPublication")
		public MainPublication.MainPublicationBuilder getMainPublication() {
			return mainPublication;
		}
		
		@Override
		public MainPublication.MainPublicationBuilder getOrCreateMainPublication() {
			MainPublication.MainPublicationBuilder result;
			if (mainPublication!=null) {
				result = mainPublication;
			}
			else {
				result = mainPublication = MainPublication.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interpolationMethod")
		public InterpolationMethod.InterpolationMethodBuilder getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		public InterpolationMethod.InterpolationMethodBuilder getOrCreateInterpolationMethod() {
			InterpolationMethod.InterpolationMethodBuilder result;
			if (interpolationMethod!=null) {
				result = interpolationMethod;
			}
			else {
				result = interpolationMethod = InterpolationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialIndexLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialIndexLevel")
		public BigDecimal getInitialIndexLevel() {
			return initialIndexLevel;
		}
		
		@Override
		@RosettaAttribute("fallbackBondApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackBondApplicable")
		public Boolean getFallbackBondApplicable() {
			return fallbackBondApplicable;
		}
		
		@Override
		@RosettaAttribute("calculationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationMethod")
		public InflationCalculationMethodEnum getCalculationMethod() {
			return calculationMethod;
		}
		
		@Override
		@RosettaAttribute("calculationStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationStyle")
		public InflationCalculationStyleEnum getCalculationStyle() {
			return calculationStyle;
		}
		
		@Override
		@RosettaAttribute("finalPrincipalExchangeCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalPrincipalExchangeCalculation")
		public FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder getFinalPrincipalExchangeCalculation() {
			return finalPrincipalExchangeCalculation;
		}
		
		@Override
		public FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder getOrCreateFinalPrincipalExchangeCalculation() {
			FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder result;
			if (finalPrincipalExchangeCalculation!=null) {
				result = finalPrincipalExchangeCalculation;
			}
			else {
				result = finalPrincipalExchangeCalculation = FinalPrincipalExchangeCalculation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("floatingRateIndex")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setFloatingRateIndex(FloatingRateIndex _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexTenor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexTenor")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setIndexTenor(Period _indexTenor) {
			this.indexTenor = _indexTenor == null ? null : _indexTenor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRateMultiplierSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateMultiplierSchedule")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setFloatingRateMultiplierSchedule(Schedule _floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = _floatingRateMultiplierSchedule == null ? null : _floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("spreadSchedule")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder addSpreadSchedule(SpreadSchedule _spreadSchedule) {
			if (_spreadSchedule != null) {
				this.spreadSchedule.add(_spreadSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder addSpreadSchedule(SpreadSchedule _spreadSchedule, int idx) {
			getIndex(this.spreadSchedule, idx, () -> _spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
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
		public InflationRateCalculation.InflationRateCalculationBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
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
		public InflationRateCalculation.InflationRateCalculationBuilder setRateTreatment(RateTreatmentEnum _rateTreatment) {
			this.rateTreatment = _rateTreatment == null ? null : _rateTreatment;
			return this;
		}
		
		@RosettaAttribute("capRateSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("capRateSchedule")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder addCapRateSchedule(StrikeSchedule _capRateSchedule) {
			if (_capRateSchedule != null) {
				this.capRateSchedule.add(_capRateSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder addCapRateSchedule(StrikeSchedule _capRateSchedule, int idx) {
			getIndex(this.capRateSchedule, idx, () -> _capRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
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
		public InflationRateCalculation.InflationRateCalculationBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
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
		public InflationRateCalculation.InflationRateCalculationBuilder addFloorRateSchedule(StrikeSchedule _floorRateSchedule) {
			if (_floorRateSchedule != null) {
				this.floorRateSchedule.add(_floorRateSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder addFloorRateSchedule(StrikeSchedule _floorRateSchedule, int idx) {
			getIndex(this.floorRateSchedule, idx, () -> _floorRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
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
		public InflationRateCalculation.InflationRateCalculationBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
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
		public InflationRateCalculation.InflationRateCalculationBuilder setInitialRate(BigDecimal _initialRate) {
			this.initialRate = _initialRate == null ? null : _initialRate;
			return this;
		}
		
		@RosettaAttribute("finalRateRounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalRateRounding")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setFinalRateRounding(Rounding _finalRateRounding) {
			this.finalRateRounding = _finalRateRounding == null ? null : _finalRateRounding.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingMethod")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setAveragingMethod(AveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("negativeInterestRateTreatment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("negativeInterestRateTreatment")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum _negativeInterestRateTreatment) {
			this.negativeInterestRateTreatment = _negativeInterestRateTreatment == null ? null : _negativeInterestRateTreatment;
			return this;
		}
		
		@RosettaAttribute("inflationLag")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inflationLag")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setInflationLag(Offset _inflationLag) {
			this.inflationLag = _inflationLag == null ? null : _inflationLag.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexSource")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setIndexSource(RateSourcePage _indexSource) {
			this.indexSource = _indexSource == null ? null : _indexSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mainPublication")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mainPublication")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setMainPublication(MainPublication _mainPublication) {
			this.mainPublication = _mainPublication == null ? null : _mainPublication.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interpolationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interpolationMethod")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setInterpolationMethod(InterpolationMethod _interpolationMethod) {
			this.interpolationMethod = _interpolationMethod == null ? null : _interpolationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialIndexLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialIndexLevel")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setInitialIndexLevel(BigDecimal _initialIndexLevel) {
			this.initialIndexLevel = _initialIndexLevel == null ? null : _initialIndexLevel;
			return this;
		}
		
		@RosettaAttribute("fallbackBondApplicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackBondApplicable")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setFallbackBondApplicable(Boolean _fallbackBondApplicable) {
			this.fallbackBondApplicable = _fallbackBondApplicable == null ? null : _fallbackBondApplicable;
			return this;
		}
		
		@RosettaAttribute("calculationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationMethod")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setCalculationMethod(InflationCalculationMethodEnum _calculationMethod) {
			this.calculationMethod = _calculationMethod == null ? null : _calculationMethod;
			return this;
		}
		
		@RosettaAttribute("calculationStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationStyle")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setCalculationStyle(InflationCalculationStyleEnum _calculationStyle) {
			this.calculationStyle = _calculationStyle == null ? null : _calculationStyle;
			return this;
		}
		
		@RosettaAttribute("finalPrincipalExchangeCalculation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalPrincipalExchangeCalculation")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder setFinalPrincipalExchangeCalculation(FinalPrincipalExchangeCalculation _finalPrincipalExchangeCalculation) {
			this.finalPrincipalExchangeCalculation = _finalPrincipalExchangeCalculation == null ? null : _finalPrincipalExchangeCalculation.toBuilder();
			return this;
		}
		
		@Override
		public InflationRateCalculation build() {
			return new InflationRateCalculation.InflationRateCalculationImpl(this);
		}
		
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder prune() {
			super.prune();
			if (inflationLag!=null && !inflationLag.prune().hasData()) inflationLag = null;
			if (indexSource!=null && !indexSource.prune().hasData()) indexSource = null;
			if (mainPublication!=null && !mainPublication.prune().hasData()) mainPublication = null;
			if (interpolationMethod!=null && !interpolationMethod.prune().hasData()) interpolationMethod = null;
			if (finalPrincipalExchangeCalculation!=null && !finalPrincipalExchangeCalculation.prune().hasData()) finalPrincipalExchangeCalculation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInflationLag()!=null && getInflationLag().hasData()) return true;
			if (getIndexSource()!=null && getIndexSource().hasData()) return true;
			if (getMainPublication()!=null && getMainPublication().hasData()) return true;
			if (getInterpolationMethod()!=null && getInterpolationMethod().hasData()) return true;
			if (getInitialIndexLevel()!=null) return true;
			if (getFallbackBondApplicable()!=null) return true;
			if (getCalculationMethod()!=null) return true;
			if (getCalculationStyle()!=null) return true;
			if (getFinalPrincipalExchangeCalculation()!=null && getFinalPrincipalExchangeCalculation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			InflationRateCalculation.InflationRateCalculationBuilder o = (InflationRateCalculation.InflationRateCalculationBuilder) other;
			
			merger.mergeRosetta(getInflationLag(), o.getInflationLag(), this::setInflationLag);
			merger.mergeRosetta(getIndexSource(), o.getIndexSource(), this::setIndexSource);
			merger.mergeRosetta(getMainPublication(), o.getMainPublication(), this::setMainPublication);
			merger.mergeRosetta(getInterpolationMethod(), o.getInterpolationMethod(), this::setInterpolationMethod);
			merger.mergeRosetta(getFinalPrincipalExchangeCalculation(), o.getFinalPrincipalExchangeCalculation(), this::setFinalPrincipalExchangeCalculation);
			
			merger.mergeBasic(getInitialIndexLevel(), o.getInitialIndexLevel(), this::setInitialIndexLevel);
			merger.mergeBasic(getFallbackBondApplicable(), o.getFallbackBondApplicable(), this::setFallbackBondApplicable);
			merger.mergeBasic(getCalculationMethod(), o.getCalculationMethod(), this::setCalculationMethod);
			merger.mergeBasic(getCalculationStyle(), o.getCalculationStyle(), this::setCalculationStyle);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InflationRateCalculation _that = getType().cast(o);
		
			if (!Objects.equals(inflationLag, _that.getInflationLag())) return false;
			if (!Objects.equals(indexSource, _that.getIndexSource())) return false;
			if (!Objects.equals(mainPublication, _that.getMainPublication())) return false;
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(initialIndexLevel, _that.getInitialIndexLevel())) return false;
			if (!Objects.equals(fallbackBondApplicable, _that.getFallbackBondApplicable())) return false;
			if (!Objects.equals(calculationMethod, _that.getCalculationMethod())) return false;
			if (!Objects.equals(calculationStyle, _that.getCalculationStyle())) return false;
			if (!Objects.equals(finalPrincipalExchangeCalculation, _that.getFinalPrincipalExchangeCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inflationLag != null ? inflationLag.hashCode() : 0);
			_result = 31 * _result + (indexSource != null ? indexSource.hashCode() : 0);
			_result = 31 * _result + (mainPublication != null ? mainPublication.hashCode() : 0);
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (initialIndexLevel != null ? initialIndexLevel.hashCode() : 0);
			_result = 31 * _result + (fallbackBondApplicable != null ? fallbackBondApplicable.hashCode() : 0);
			_result = 31 * _result + (calculationMethod != null ? calculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calculationStyle != null ? calculationStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (finalPrincipalExchangeCalculation != null ? finalPrincipalExchangeCalculation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InflationRateCalculationBuilder {" +
				"inflationLag=" + this.inflationLag + ", " +
				"indexSource=" + this.indexSource + ", " +
				"mainPublication=" + this.mainPublication + ", " +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"initialIndexLevel=" + this.initialIndexLevel + ", " +
				"fallbackBondApplicable=" + this.fallbackBondApplicable + ", " +
				"calculationMethod=" + this.calculationMethod + ", " +
				"calculationStyle=" + this.calculationStyle + ", " +
				"finalPrincipalExchangeCalculation=" + this.finalPrincipalExchangeCalculation +
			'}' + " " + super.toString();
		}
	}
}

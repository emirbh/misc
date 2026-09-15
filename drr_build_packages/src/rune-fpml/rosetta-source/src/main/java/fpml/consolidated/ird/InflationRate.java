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
import fpml.consolidated.fpmlenum.InflationCalculationMethodEnum;
import fpml.consolidated.fpmlenum.InflationCalculationStyleEnum;
import fpml.consolidated.ird.meta.InflationRateMeta;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.InterpolationMethod;
import fpml.consolidated.shared.MainPublication;
import fpml.consolidated.shared.Offset;
import fpml.consolidated.shared.RateSourcePage;
import java.math.BigDecimal;
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
@RosettaDataType(value="InflationRate", builder=InflationRate.InflationRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InflationRate", model="fpml", builder=InflationRate.InflationRateBuilderImpl.class, version="2.1.1")
public interface InflationRate extends RosettaModelObject {

	InflationRateMeta metaData = new InflationRateMeta();

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
	FloatingRateIndex getInflationRateIndex();
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
	InflationRate build();
	
	InflationRate.InflationRateBuilder toBuilder();
	
	static InflationRate.InflationRateBuilder builder() {
		return new InflationRate.InflationRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InflationRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InflationRate> getType() {
		return InflationRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("inflationRateIndex"), processor, FloatingRateIndex.class, getInflationRateIndex());
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
	interface InflationRateBuilder extends InflationRate, RosettaModelObjectBuilder {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateInflationRateIndex();
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder getInflationRateIndex();
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
		InflationRate.InflationRateBuilder setInflationRateIndex(FloatingRateIndex inflationRateIndex);
		InflationRate.InflationRateBuilder setInflationLag(Offset inflationLag);
		InflationRate.InflationRateBuilder setIndexSource(RateSourcePage indexSource);
		InflationRate.InflationRateBuilder setMainPublication(MainPublication mainPublication);
		InflationRate.InflationRateBuilder setInterpolationMethod(InterpolationMethod interpolationMethod);
		InflationRate.InflationRateBuilder setInitialIndexLevel(BigDecimal initialIndexLevel);
		InflationRate.InflationRateBuilder setFallbackBondApplicable(Boolean fallbackBondApplicable);
		InflationRate.InflationRateBuilder setCalculationMethod(InflationCalculationMethodEnum calculationMethod);
		InflationRate.InflationRateBuilder setCalculationStyle(InflationCalculationStyleEnum calculationStyle);
		InflationRate.InflationRateBuilder setFinalPrincipalExchangeCalculation(FinalPrincipalExchangeCalculation finalPrincipalExchangeCalculation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("inflationRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getInflationRateIndex());
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
		

		InflationRate.InflationRateBuilder prune();
	}

	/*********************** Immutable Implementation of InflationRate  ***********************/
	class InflationRateImpl implements InflationRate {
		private final FloatingRateIndex inflationRateIndex;
		private final Offset inflationLag;
		private final RateSourcePage indexSource;
		private final MainPublication mainPublication;
		private final InterpolationMethod interpolationMethod;
		private final BigDecimal initialIndexLevel;
		private final Boolean fallbackBondApplicable;
		private final InflationCalculationMethodEnum calculationMethod;
		private final InflationCalculationStyleEnum calculationStyle;
		private final FinalPrincipalExchangeCalculation finalPrincipalExchangeCalculation;
		
		protected InflationRateImpl(InflationRate.InflationRateBuilder builder) {
			this.inflationRateIndex = ofNullable(builder.getInflationRateIndex()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("inflationRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inflationRateIndex")
		public FloatingRateIndex getInflationRateIndex() {
			return inflationRateIndex;
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
		public InflationRate build() {
			return this;
		}
		
		@Override
		public InflationRate.InflationRateBuilder toBuilder() {
			InflationRate.InflationRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InflationRate.InflationRateBuilder builder) {
			ofNullable(getInflationRateIndex()).ifPresent(builder::setInflationRateIndex);
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
		
			InflationRate _that = getType().cast(o);
		
			if (!Objects.equals(inflationRateIndex, _that.getInflationRateIndex())) return false;
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
			int _result = 0;
			_result = 31 * _result + (inflationRateIndex != null ? inflationRateIndex.hashCode() : 0);
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
			return "InflationRate {" +
				"inflationRateIndex=" + this.inflationRateIndex + ", " +
				"inflationLag=" + this.inflationLag + ", " +
				"indexSource=" + this.indexSource + ", " +
				"mainPublication=" + this.mainPublication + ", " +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"initialIndexLevel=" + this.initialIndexLevel + ", " +
				"fallbackBondApplicable=" + this.fallbackBondApplicable + ", " +
				"calculationMethod=" + this.calculationMethod + ", " +
				"calculationStyle=" + this.calculationStyle + ", " +
				"finalPrincipalExchangeCalculation=" + this.finalPrincipalExchangeCalculation +
			'}';
		}
	}

	/*********************** Builder Implementation of InflationRate  ***********************/
	class InflationRateBuilderImpl implements InflationRate.InflationRateBuilder {
	
		protected FloatingRateIndex.FloatingRateIndexBuilder inflationRateIndex;
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
		@RosettaAttribute("inflationRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inflationRateIndex")
		public FloatingRateIndex.FloatingRateIndexBuilder getInflationRateIndex() {
			return inflationRateIndex;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder getOrCreateInflationRateIndex() {
			FloatingRateIndex.FloatingRateIndexBuilder result;
			if (inflationRateIndex!=null) {
				result = inflationRateIndex;
			}
			else {
				result = inflationRateIndex = FloatingRateIndex.builder();
			}
			
			return result;
		}
		
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
		
		@RosettaAttribute("inflationRateIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inflationRateIndex")
		@Override
		public InflationRate.InflationRateBuilder setInflationRateIndex(FloatingRateIndex _inflationRateIndex) {
			this.inflationRateIndex = _inflationRateIndex == null ? null : _inflationRateIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inflationLag")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inflationLag")
		@Override
		public InflationRate.InflationRateBuilder setInflationLag(Offset _inflationLag) {
			this.inflationLag = _inflationLag == null ? null : _inflationLag.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexSource")
		@Override
		public InflationRate.InflationRateBuilder setIndexSource(RateSourcePage _indexSource) {
			this.indexSource = _indexSource == null ? null : _indexSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mainPublication")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mainPublication")
		@Override
		public InflationRate.InflationRateBuilder setMainPublication(MainPublication _mainPublication) {
			this.mainPublication = _mainPublication == null ? null : _mainPublication.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interpolationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interpolationMethod")
		@Override
		public InflationRate.InflationRateBuilder setInterpolationMethod(InterpolationMethod _interpolationMethod) {
			this.interpolationMethod = _interpolationMethod == null ? null : _interpolationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialIndexLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialIndexLevel")
		@Override
		public InflationRate.InflationRateBuilder setInitialIndexLevel(BigDecimal _initialIndexLevel) {
			this.initialIndexLevel = _initialIndexLevel == null ? null : _initialIndexLevel;
			return this;
		}
		
		@RosettaAttribute("fallbackBondApplicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackBondApplicable")
		@Override
		public InflationRate.InflationRateBuilder setFallbackBondApplicable(Boolean _fallbackBondApplicable) {
			this.fallbackBondApplicable = _fallbackBondApplicable == null ? null : _fallbackBondApplicable;
			return this;
		}
		
		@RosettaAttribute("calculationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationMethod")
		@Override
		public InflationRate.InflationRateBuilder setCalculationMethod(InflationCalculationMethodEnum _calculationMethod) {
			this.calculationMethod = _calculationMethod == null ? null : _calculationMethod;
			return this;
		}
		
		@RosettaAttribute("calculationStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationStyle")
		@Override
		public InflationRate.InflationRateBuilder setCalculationStyle(InflationCalculationStyleEnum _calculationStyle) {
			this.calculationStyle = _calculationStyle == null ? null : _calculationStyle;
			return this;
		}
		
		@RosettaAttribute("finalPrincipalExchangeCalculation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalPrincipalExchangeCalculation")
		@Override
		public InflationRate.InflationRateBuilder setFinalPrincipalExchangeCalculation(FinalPrincipalExchangeCalculation _finalPrincipalExchangeCalculation) {
			this.finalPrincipalExchangeCalculation = _finalPrincipalExchangeCalculation == null ? null : _finalPrincipalExchangeCalculation.toBuilder();
			return this;
		}
		
		@Override
		public InflationRate build() {
			return new InflationRate.InflationRateImpl(this);
		}
		
		@Override
		public InflationRate.InflationRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InflationRate.InflationRateBuilder prune() {
			if (inflationRateIndex!=null && !inflationRateIndex.prune().hasData()) inflationRateIndex = null;
			if (inflationLag!=null && !inflationLag.prune().hasData()) inflationLag = null;
			if (indexSource!=null && !indexSource.prune().hasData()) indexSource = null;
			if (mainPublication!=null && !mainPublication.prune().hasData()) mainPublication = null;
			if (interpolationMethod!=null && !interpolationMethod.prune().hasData()) interpolationMethod = null;
			if (finalPrincipalExchangeCalculation!=null && !finalPrincipalExchangeCalculation.prune().hasData()) finalPrincipalExchangeCalculation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInflationRateIndex()!=null && getInflationRateIndex().hasData()) return true;
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
		public InflationRate.InflationRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InflationRate.InflationRateBuilder o = (InflationRate.InflationRateBuilder) other;
			
			merger.mergeRosetta(getInflationRateIndex(), o.getInflationRateIndex(), this::setInflationRateIndex);
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
		
			InflationRate _that = getType().cast(o);
		
			if (!Objects.equals(inflationRateIndex, _that.getInflationRateIndex())) return false;
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
			int _result = 0;
			_result = 31 * _result + (inflationRateIndex != null ? inflationRateIndex.hashCode() : 0);
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
			return "InflationRateBuilder {" +
				"inflationRateIndex=" + this.inflationRateIndex + ", " +
				"inflationLag=" + this.inflationLag + ", " +
				"indexSource=" + this.indexSource + ", " +
				"mainPublication=" + this.mainPublication + ", " +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"initialIndexLevel=" + this.initialIndexLevel + ", " +
				"fallbackBondApplicable=" + this.fallbackBondApplicable + ", " +
				"calculationMethod=" + this.calculationMethod + ", " +
				"calculationStyle=" + this.calculationStyle + ", " +
				"finalPrincipalExchangeCalculation=" + this.finalPrincipalExchangeCalculation +
			'}';
		}
	}
}

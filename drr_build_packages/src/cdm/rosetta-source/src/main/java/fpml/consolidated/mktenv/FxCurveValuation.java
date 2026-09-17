package fpml.consolidated.mktenv;

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
import fpml.consolidated.asset.AnyAssetReference;
import fpml.consolidated.mktenv.meta.FxCurveValuationMeta;
import fpml.consolidated.riskdef.PricingStructureValuation;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.PricingStructureReference;
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
 * Provision A valuation of an FX curve object., which includes pricing inputs and term structures for fx forwards.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A valuation of an FX curve object., which includes pricing inputs and term structures for fx forwards.
 *
 */
@RosettaDataType(value="FxCurveValuation", builder=FxCurveValuation.FxCurveValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxCurveValuation", model="fpml", builder=FxCurveValuation.FxCurveValuationBuilderImpl.class, version="2.1.1")
public interface FxCurveValuation extends PricingStructureValuation {

	FxCurveValuationMeta metaData = new FxCurveValuationMeta();

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
	PricingStructureReference getSettlementCurrencyYieldCurve();
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
	PricingStructureReference getForecastCurrencyYieldCurve();
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
	FxRateSet getSpotRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A curve of fx forward rates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A curve of fx forward rates.
	 *
	 */
	TermCurve getFxForwardCurve();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A curve of fx forward point spreads.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A curve of fx forward point spreads.
	 *
	 */
	TermCurve getFxForwardPointsCurve();

	/*********************** Build Methods  ***********************/
	FxCurveValuation build();
	
	FxCurveValuation.FxCurveValuationBuilder toBuilder();
	
	static FxCurveValuation.FxCurveValuationBuilder builder() {
		return new FxCurveValuation.FxCurveValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCurveValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxCurveValuation> getType() {
		return FxCurveValuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processRosetta(path.newSubPath("baseDate"), processor, IdentifiedDate.class, getBaseDate());
		processRosetta(path.newSubPath("spotDate"), processor, IdentifiedDate.class, getSpotDate());
		processRosetta(path.newSubPath("inputDataDate"), processor, IdentifiedDate.class, getInputDataDate());
		processRosetta(path.newSubPath("endDate"), processor, IdentifiedDate.class, getEndDate());
		processor.processBasic(path.newSubPath("buildDateTime"), ZonedDateTime.class, getBuildDateTime(), this);
		processRosetta(path.newSubPath("settlementCurrencyYieldCurve"), processor, PricingStructureReference.class, getSettlementCurrencyYieldCurve());
		processRosetta(path.newSubPath("forecastCurrencyYieldCurve"), processor, PricingStructureReference.class, getForecastCurrencyYieldCurve());
		processRosetta(path.newSubPath("spotRate"), processor, FxRateSet.class, getSpotRate());
		processRosetta(path.newSubPath("fxForwardCurve"), processor, TermCurve.class, getFxForwardCurve());
		processRosetta(path.newSubPath("fxForwardPointsCurve"), processor, TermCurve.class, getFxForwardPointsCurve());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCurveValuationBuilder extends FxCurveValuation, PricingStructureValuation.PricingStructureValuationBuilder {
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreateSettlementCurrencyYieldCurve();
		@Override
		PricingStructureReference.PricingStructureReferenceBuilder getSettlementCurrencyYieldCurve();
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreateForecastCurrencyYieldCurve();
		@Override
		PricingStructureReference.PricingStructureReferenceBuilder getForecastCurrencyYieldCurve();
		FxRateSet.FxRateSetBuilder getOrCreateSpotRate();
		@Override
		FxRateSet.FxRateSetBuilder getSpotRate();
		TermCurve.TermCurveBuilder getOrCreateFxForwardCurve();
		@Override
		TermCurve.TermCurveBuilder getFxForwardCurve();
		TermCurve.TermCurveBuilder getOrCreateFxForwardPointsCurve();
		@Override
		TermCurve.TermCurveBuilder getFxForwardPointsCurve();
		@Override
		FxCurveValuation.FxCurveValuationBuilder setId(String id);
		@Override
		FxCurveValuation.FxCurveValuationBuilder setDefinitionRef(String definitionRef);
		@Override
		FxCurveValuation.FxCurveValuationBuilder setObjectReference(AnyAssetReference objectReference);
		@Override
		FxCurveValuation.FxCurveValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		@Override
		FxCurveValuation.FxCurveValuationBuilder setBaseDate(IdentifiedDate baseDate);
		@Override
		FxCurveValuation.FxCurveValuationBuilder setSpotDate(IdentifiedDate spotDate);
		@Override
		FxCurveValuation.FxCurveValuationBuilder setInputDataDate(IdentifiedDate inputDataDate);
		@Override
		FxCurveValuation.FxCurveValuationBuilder setEndDate(IdentifiedDate endDate);
		@Override
		FxCurveValuation.FxCurveValuationBuilder setBuildDateTime(ZonedDateTime buildDateTime);
		FxCurveValuation.FxCurveValuationBuilder setSettlementCurrencyYieldCurve(PricingStructureReference settlementCurrencyYieldCurve);
		FxCurveValuation.FxCurveValuationBuilder setForecastCurrencyYieldCurve(PricingStructureReference forecastCurrencyYieldCurve);
		FxCurveValuation.FxCurveValuationBuilder setSpotRate(FxRateSet spotRate);
		FxCurveValuation.FxCurveValuationBuilder setFxForwardCurve(TermCurve fxForwardCurve);
		FxCurveValuation.FxCurveValuationBuilder setFxForwardPointsCurve(TermCurve fxForwardPointsCurve);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processRosetta(path.newSubPath("baseDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getBaseDate());
			processRosetta(path.newSubPath("spotDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getSpotDate());
			processRosetta(path.newSubPath("inputDataDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getInputDataDate());
			processRosetta(path.newSubPath("endDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getEndDate());
			processor.processBasic(path.newSubPath("buildDateTime"), ZonedDateTime.class, getBuildDateTime(), this);
			processRosetta(path.newSubPath("settlementCurrencyYieldCurve"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getSettlementCurrencyYieldCurve());
			processRosetta(path.newSubPath("forecastCurrencyYieldCurve"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getForecastCurrencyYieldCurve());
			processRosetta(path.newSubPath("spotRate"), processor, FxRateSet.FxRateSetBuilder.class, getSpotRate());
			processRosetta(path.newSubPath("fxForwardCurve"), processor, TermCurve.TermCurveBuilder.class, getFxForwardCurve());
			processRosetta(path.newSubPath("fxForwardPointsCurve"), processor, TermCurve.TermCurveBuilder.class, getFxForwardPointsCurve());
		}
		

		FxCurveValuation.FxCurveValuationBuilder prune();
	}

	/*********************** Immutable Implementation of FxCurveValuation  ***********************/
	class FxCurveValuationImpl extends PricingStructureValuation.PricingStructureValuationImpl implements FxCurveValuation {
		private final PricingStructureReference settlementCurrencyYieldCurve;
		private final PricingStructureReference forecastCurrencyYieldCurve;
		private final FxRateSet spotRate;
		private final TermCurve fxForwardCurve;
		private final TermCurve fxForwardPointsCurve;
		
		protected FxCurveValuationImpl(FxCurveValuation.FxCurveValuationBuilder builder) {
			super(builder);
			this.settlementCurrencyYieldCurve = ofNullable(builder.getSettlementCurrencyYieldCurve()).map(f->f.build()).orElse(null);
			this.forecastCurrencyYieldCurve = ofNullable(builder.getForecastCurrencyYieldCurve()).map(f->f.build()).orElse(null);
			this.spotRate = ofNullable(builder.getSpotRate()).map(f->f.build()).orElse(null);
			this.fxForwardCurve = ofNullable(builder.getFxForwardCurve()).map(f->f.build()).orElse(null);
			this.fxForwardPointsCurve = ofNullable(builder.getFxForwardPointsCurve()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementCurrencyYieldCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrencyYieldCurve")
		public PricingStructureReference getSettlementCurrencyYieldCurve() {
			return settlementCurrencyYieldCurve;
		}
		
		@Override
		@RosettaAttribute("forecastCurrencyYieldCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forecastCurrencyYieldCurve")
		public PricingStructureReference getForecastCurrencyYieldCurve() {
			return forecastCurrencyYieldCurve;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public FxRateSet getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("fxForwardCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxForwardCurve")
		public TermCurve getFxForwardCurve() {
			return fxForwardCurve;
		}
		
		@Override
		@RosettaAttribute("fxForwardPointsCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxForwardPointsCurve")
		public TermCurve getFxForwardPointsCurve() {
			return fxForwardPointsCurve;
		}
		
		@Override
		public FxCurveValuation build() {
			return this;
		}
		
		@Override
		public FxCurveValuation.FxCurveValuationBuilder toBuilder() {
			FxCurveValuation.FxCurveValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCurveValuation.FxCurveValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementCurrencyYieldCurve()).ifPresent(builder::setSettlementCurrencyYieldCurve);
			ofNullable(getForecastCurrencyYieldCurve()).ifPresent(builder::setForecastCurrencyYieldCurve);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getFxForwardCurve()).ifPresent(builder::setFxForwardCurve);
			ofNullable(getFxForwardPointsCurve()).ifPresent(builder::setFxForwardPointsCurve);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrencyYieldCurve, _that.getSettlementCurrencyYieldCurve())) return false;
			if (!Objects.equals(forecastCurrencyYieldCurve, _that.getForecastCurrencyYieldCurve())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(fxForwardCurve, _that.getFxForwardCurve())) return false;
			if (!Objects.equals(fxForwardPointsCurve, _that.getFxForwardPointsCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementCurrencyYieldCurve != null ? settlementCurrencyYieldCurve.hashCode() : 0);
			_result = 31 * _result + (forecastCurrencyYieldCurve != null ? forecastCurrencyYieldCurve.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (fxForwardCurve != null ? fxForwardCurve.hashCode() : 0);
			_result = 31 * _result + (fxForwardPointsCurve != null ? fxForwardPointsCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCurveValuation {" +
				"settlementCurrencyYieldCurve=" + this.settlementCurrencyYieldCurve + ", " +
				"forecastCurrencyYieldCurve=" + this.forecastCurrencyYieldCurve + ", " +
				"spotRate=" + this.spotRate + ", " +
				"fxForwardCurve=" + this.fxForwardCurve + ", " +
				"fxForwardPointsCurve=" + this.fxForwardPointsCurve +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxCurveValuation  ***********************/
	class FxCurveValuationBuilderImpl extends PricingStructureValuation.PricingStructureValuationBuilderImpl implements FxCurveValuation.FxCurveValuationBuilder {
	
		protected PricingStructureReference.PricingStructureReferenceBuilder settlementCurrencyYieldCurve;
		protected PricingStructureReference.PricingStructureReferenceBuilder forecastCurrencyYieldCurve;
		protected FxRateSet.FxRateSetBuilder spotRate;
		protected TermCurve.TermCurveBuilder fxForwardCurve;
		protected TermCurve.TermCurveBuilder fxForwardPointsCurve;
		
		@Override
		@RosettaAttribute("settlementCurrencyYieldCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrencyYieldCurve")
		public PricingStructureReference.PricingStructureReferenceBuilder getSettlementCurrencyYieldCurve() {
			return settlementCurrencyYieldCurve;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreateSettlementCurrencyYieldCurve() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (settlementCurrencyYieldCurve!=null) {
				result = settlementCurrencyYieldCurve;
			}
			else {
				result = settlementCurrencyYieldCurve = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("forecastCurrencyYieldCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forecastCurrencyYieldCurve")
		public PricingStructureReference.PricingStructureReferenceBuilder getForecastCurrencyYieldCurve() {
			return forecastCurrencyYieldCurve;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreateForecastCurrencyYieldCurve() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (forecastCurrencyYieldCurve!=null) {
				result = forecastCurrencyYieldCurve;
			}
			else {
				result = forecastCurrencyYieldCurve = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public FxRateSet.FxRateSetBuilder getSpotRate() {
			return spotRate;
		}
		
		@Override
		public FxRateSet.FxRateSetBuilder getOrCreateSpotRate() {
			FxRateSet.FxRateSetBuilder result;
			if (spotRate!=null) {
				result = spotRate;
			}
			else {
				result = spotRate = FxRateSet.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxForwardCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxForwardCurve")
		public TermCurve.TermCurveBuilder getFxForwardCurve() {
			return fxForwardCurve;
		}
		
		@Override
		public TermCurve.TermCurveBuilder getOrCreateFxForwardCurve() {
			TermCurve.TermCurveBuilder result;
			if (fxForwardCurve!=null) {
				result = fxForwardCurve;
			}
			else {
				result = fxForwardCurve = TermCurve.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxForwardPointsCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxForwardPointsCurve")
		public TermCurve.TermCurveBuilder getFxForwardPointsCurve() {
			return fxForwardPointsCurve;
		}
		
		@Override
		public TermCurve.TermCurveBuilder getOrCreateFxForwardPointsCurve() {
			TermCurve.TermCurveBuilder result;
			if (fxForwardPointsCurve!=null) {
				result = fxForwardPointsCurve;
			}
			else {
				result = fxForwardPointsCurve = TermCurve.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definitionRef")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setDefinitionRef(String _definitionRef) {
			this.definitionRef = _definitionRef == null ? null : _definitionRef;
			return this;
		}
		
		@RosettaAttribute("objectReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("objectReference")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setObjectReference(AnyAssetReference _objectReference) {
			this.objectReference = _objectReference == null ? null : _objectReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationScenarioReference")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference) {
			this.valuationScenarioReference = _valuationScenarioReference == null ? null : _valuationScenarioReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("baseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseDate")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setBaseDate(IdentifiedDate _baseDate) {
			this.baseDate = _baseDate == null ? null : _baseDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotDate")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setSpotDate(IdentifiedDate _spotDate) {
			this.spotDate = _spotDate == null ? null : _spotDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inputDataDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inputDataDate")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setInputDataDate(IdentifiedDate _inputDataDate) {
			this.inputDataDate = _inputDataDate == null ? null : _inputDataDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setEndDate(IdentifiedDate _endDate) {
			this.endDate = _endDate == null ? null : _endDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buildDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buildDateTime")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setBuildDateTime(ZonedDateTime _buildDateTime) {
			this.buildDateTime = _buildDateTime == null ? null : _buildDateTime;
			return this;
		}
		
		@RosettaAttribute("settlementCurrencyYieldCurve")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrencyYieldCurve")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setSettlementCurrencyYieldCurve(PricingStructureReference _settlementCurrencyYieldCurve) {
			this.settlementCurrencyYieldCurve = _settlementCurrencyYieldCurve == null ? null : _settlementCurrencyYieldCurve.toBuilder();
			return this;
		}
		
		@RosettaAttribute("forecastCurrencyYieldCurve")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forecastCurrencyYieldCurve")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setForecastCurrencyYieldCurve(PricingStructureReference _forecastCurrencyYieldCurve) {
			this.forecastCurrencyYieldCurve = _forecastCurrencyYieldCurve == null ? null : _forecastCurrencyYieldCurve.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotRate")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setSpotRate(FxRateSet _spotRate) {
			this.spotRate = _spotRate == null ? null : _spotRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxForwardCurve")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxForwardCurve")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setFxForwardCurve(TermCurve _fxForwardCurve) {
			this.fxForwardCurve = _fxForwardCurve == null ? null : _fxForwardCurve.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxForwardPointsCurve")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxForwardPointsCurve")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder setFxForwardPointsCurve(TermCurve _fxForwardPointsCurve) {
			this.fxForwardPointsCurve = _fxForwardPointsCurve == null ? null : _fxForwardPointsCurve.toBuilder();
			return this;
		}
		
		@Override
		public FxCurveValuation build() {
			return new FxCurveValuation.FxCurveValuationImpl(this);
		}
		
		@Override
		public FxCurveValuation.FxCurveValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder prune() {
			super.prune();
			if (settlementCurrencyYieldCurve!=null && !settlementCurrencyYieldCurve.prune().hasData()) settlementCurrencyYieldCurve = null;
			if (forecastCurrencyYieldCurve!=null && !forecastCurrencyYieldCurve.prune().hasData()) forecastCurrencyYieldCurve = null;
			if (spotRate!=null && !spotRate.prune().hasData()) spotRate = null;
			if (fxForwardCurve!=null && !fxForwardCurve.prune().hasData()) fxForwardCurve = null;
			if (fxForwardPointsCurve!=null && !fxForwardPointsCurve.prune().hasData()) fxForwardPointsCurve = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementCurrencyYieldCurve()!=null && getSettlementCurrencyYieldCurve().hasData()) return true;
			if (getForecastCurrencyYieldCurve()!=null && getForecastCurrencyYieldCurve().hasData()) return true;
			if (getSpotRate()!=null && getSpotRate().hasData()) return true;
			if (getFxForwardCurve()!=null && getFxForwardCurve().hasData()) return true;
			if (getFxForwardPointsCurve()!=null && getFxForwardPointsCurve().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCurveValuation.FxCurveValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxCurveValuation.FxCurveValuationBuilder o = (FxCurveValuation.FxCurveValuationBuilder) other;
			
			merger.mergeRosetta(getSettlementCurrencyYieldCurve(), o.getSettlementCurrencyYieldCurve(), this::setSettlementCurrencyYieldCurve);
			merger.mergeRosetta(getForecastCurrencyYieldCurve(), o.getForecastCurrencyYieldCurve(), this::setForecastCurrencyYieldCurve);
			merger.mergeRosetta(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			merger.mergeRosetta(getFxForwardCurve(), o.getFxForwardCurve(), this::setFxForwardCurve);
			merger.mergeRosetta(getFxForwardPointsCurve(), o.getFxForwardPointsCurve(), this::setFxForwardPointsCurve);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(settlementCurrencyYieldCurve, _that.getSettlementCurrencyYieldCurve())) return false;
			if (!Objects.equals(forecastCurrencyYieldCurve, _that.getForecastCurrencyYieldCurve())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(fxForwardCurve, _that.getFxForwardCurve())) return false;
			if (!Objects.equals(fxForwardPointsCurve, _that.getFxForwardPointsCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementCurrencyYieldCurve != null ? settlementCurrencyYieldCurve.hashCode() : 0);
			_result = 31 * _result + (forecastCurrencyYieldCurve != null ? forecastCurrencyYieldCurve.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (fxForwardCurve != null ? fxForwardCurve.hashCode() : 0);
			_result = 31 * _result + (fxForwardPointsCurve != null ? fxForwardPointsCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCurveValuationBuilder {" +
				"settlementCurrencyYieldCurve=" + this.settlementCurrencyYieldCurve + ", " +
				"forecastCurrencyYieldCurve=" + this.forecastCurrencyYieldCurve + ", " +
				"spotRate=" + this.spotRate + ", " +
				"fxForwardCurve=" + this.fxForwardCurve + ", " +
				"fxForwardPointsCurve=" + this.fxForwardPointsCurve +
			'}' + " " + super.toString();
		}
	}
}

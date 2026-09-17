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
import fpml.consolidated.mktenv.meta.DefaultProbabilityCurveMeta;
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
 * Provision A set of default probabilities.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A set of default probabilities.
 *
 */
@RosettaDataType(value="DefaultProbabilityCurve", builder=DefaultProbabilityCurve.DefaultProbabilityCurveBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DefaultProbabilityCurve", model="fpml", builder=DefaultProbabilityCurve.DefaultProbabilityCurveBuilderImpl.class, version="2.1.1")
public interface DefaultProbabilityCurve extends PricingStructureValuation {

	DefaultProbabilityCurveMeta metaData = new DefaultProbabilityCurveMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the yield curve values used as a basis for this credit curve valuation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the yield curve values used as a basis for this credit curve valuation.
	 *
	 */
	PricingStructureReference getBaseYieldCurve();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A collection of default probabilities.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A collection of default probabilities.
	 *
	 */
	TermCurve getDefaultProbabilities();

	/*********************** Build Methods  ***********************/
	DefaultProbabilityCurve build();
	
	DefaultProbabilityCurve.DefaultProbabilityCurveBuilder toBuilder();
	
	static DefaultProbabilityCurve.DefaultProbabilityCurveBuilder builder() {
		return new DefaultProbabilityCurve.DefaultProbabilityCurveBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DefaultProbabilityCurve> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DefaultProbabilityCurve> getType() {
		return DefaultProbabilityCurve.class;
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
		processRosetta(path.newSubPath("baseYieldCurve"), processor, PricingStructureReference.class, getBaseYieldCurve());
		processRosetta(path.newSubPath("defaultProbabilities"), processor, TermCurve.class, getDefaultProbabilities());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DefaultProbabilityCurveBuilder extends DefaultProbabilityCurve, PricingStructureValuation.PricingStructureValuationBuilder {
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreateBaseYieldCurve();
		@Override
		PricingStructureReference.PricingStructureReferenceBuilder getBaseYieldCurve();
		TermCurve.TermCurveBuilder getOrCreateDefaultProbabilities();
		@Override
		TermCurve.TermCurveBuilder getDefaultProbabilities();
		@Override
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setId(String id);
		@Override
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setDefinitionRef(String definitionRef);
		@Override
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setObjectReference(AnyAssetReference objectReference);
		@Override
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		@Override
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setBaseDate(IdentifiedDate baseDate);
		@Override
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setSpotDate(IdentifiedDate spotDate);
		@Override
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setInputDataDate(IdentifiedDate inputDataDate);
		@Override
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setEndDate(IdentifiedDate endDate);
		@Override
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setBuildDateTime(ZonedDateTime buildDateTime);
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setBaseYieldCurve(PricingStructureReference baseYieldCurve);
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setDefaultProbabilities(TermCurve defaultProbabilities);

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
			processRosetta(path.newSubPath("baseYieldCurve"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getBaseYieldCurve());
			processRosetta(path.newSubPath("defaultProbabilities"), processor, TermCurve.TermCurveBuilder.class, getDefaultProbabilities());
		}
		

		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder prune();
	}

	/*********************** Immutable Implementation of DefaultProbabilityCurve  ***********************/
	class DefaultProbabilityCurveImpl extends PricingStructureValuation.PricingStructureValuationImpl implements DefaultProbabilityCurve {
		private final PricingStructureReference baseYieldCurve;
		private final TermCurve defaultProbabilities;
		
		protected DefaultProbabilityCurveImpl(DefaultProbabilityCurve.DefaultProbabilityCurveBuilder builder) {
			super(builder);
			this.baseYieldCurve = ofNullable(builder.getBaseYieldCurve()).map(f->f.build()).orElse(null);
			this.defaultProbabilities = ofNullable(builder.getDefaultProbabilities()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("baseYieldCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseYieldCurve")
		public PricingStructureReference getBaseYieldCurve() {
			return baseYieldCurve;
		}
		
		@Override
		@RosettaAttribute("defaultProbabilities")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("defaultProbabilities")
		public TermCurve getDefaultProbabilities() {
			return defaultProbabilities;
		}
		
		@Override
		public DefaultProbabilityCurve build() {
			return this;
		}
		
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder toBuilder() {
			DefaultProbabilityCurve.DefaultProbabilityCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DefaultProbabilityCurve.DefaultProbabilityCurveBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBaseYieldCurve()).ifPresent(builder::setBaseYieldCurve);
			ofNullable(getDefaultProbabilities()).ifPresent(builder::setDefaultProbabilities);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DefaultProbabilityCurve _that = getType().cast(o);
		
			if (!Objects.equals(baseYieldCurve, _that.getBaseYieldCurve())) return false;
			if (!Objects.equals(defaultProbabilities, _that.getDefaultProbabilities())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (baseYieldCurve != null ? baseYieldCurve.hashCode() : 0);
			_result = 31 * _result + (defaultProbabilities != null ? defaultProbabilities.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DefaultProbabilityCurve {" +
				"baseYieldCurve=" + this.baseYieldCurve + ", " +
				"defaultProbabilities=" + this.defaultProbabilities +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DefaultProbabilityCurve  ***********************/
	class DefaultProbabilityCurveBuilderImpl extends PricingStructureValuation.PricingStructureValuationBuilderImpl implements DefaultProbabilityCurve.DefaultProbabilityCurveBuilder {
	
		protected PricingStructureReference.PricingStructureReferenceBuilder baseYieldCurve;
		protected TermCurve.TermCurveBuilder defaultProbabilities;
		
		@Override
		@RosettaAttribute("baseYieldCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseYieldCurve")
		public PricingStructureReference.PricingStructureReferenceBuilder getBaseYieldCurve() {
			return baseYieldCurve;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreateBaseYieldCurve() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (baseYieldCurve!=null) {
				result = baseYieldCurve;
			}
			else {
				result = baseYieldCurve = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("defaultProbabilities")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("defaultProbabilities")
		public TermCurve.TermCurveBuilder getDefaultProbabilities() {
			return defaultProbabilities;
		}
		
		@Override
		public TermCurve.TermCurveBuilder getOrCreateDefaultProbabilities() {
			TermCurve.TermCurveBuilder result;
			if (defaultProbabilities!=null) {
				result = defaultProbabilities;
			}
			else {
				result = defaultProbabilities = TermCurve.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definitionRef")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setDefinitionRef(String _definitionRef) {
			this.definitionRef = _definitionRef == null ? null : _definitionRef;
			return this;
		}
		
		@RosettaAttribute("objectReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("objectReference")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setObjectReference(AnyAssetReference _objectReference) {
			this.objectReference = _objectReference == null ? null : _objectReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationScenarioReference")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference) {
			this.valuationScenarioReference = _valuationScenarioReference == null ? null : _valuationScenarioReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("baseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseDate")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setBaseDate(IdentifiedDate _baseDate) {
			this.baseDate = _baseDate == null ? null : _baseDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotDate")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setSpotDate(IdentifiedDate _spotDate) {
			this.spotDate = _spotDate == null ? null : _spotDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inputDataDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inputDataDate")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setInputDataDate(IdentifiedDate _inputDataDate) {
			this.inputDataDate = _inputDataDate == null ? null : _inputDataDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setEndDate(IdentifiedDate _endDate) {
			this.endDate = _endDate == null ? null : _endDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buildDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buildDateTime")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setBuildDateTime(ZonedDateTime _buildDateTime) {
			this.buildDateTime = _buildDateTime == null ? null : _buildDateTime;
			return this;
		}
		
		@RosettaAttribute("baseYieldCurve")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseYieldCurve")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setBaseYieldCurve(PricingStructureReference _baseYieldCurve) {
			this.baseYieldCurve = _baseYieldCurve == null ? null : _baseYieldCurve.toBuilder();
			return this;
		}
		
		@RosettaAttribute("defaultProbabilities")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("defaultProbabilities")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder setDefaultProbabilities(TermCurve _defaultProbabilities) {
			this.defaultProbabilities = _defaultProbabilities == null ? null : _defaultProbabilities.toBuilder();
			return this;
		}
		
		@Override
		public DefaultProbabilityCurve build() {
			return new DefaultProbabilityCurve.DefaultProbabilityCurveImpl(this);
		}
		
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder prune() {
			super.prune();
			if (baseYieldCurve!=null && !baseYieldCurve.prune().hasData()) baseYieldCurve = null;
			if (defaultProbabilities!=null && !defaultProbabilities.prune().hasData()) defaultProbabilities = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBaseYieldCurve()!=null && getBaseYieldCurve().hasData()) return true;
			if (getDefaultProbabilities()!=null && getDefaultProbabilities().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DefaultProbabilityCurve.DefaultProbabilityCurveBuilder o = (DefaultProbabilityCurve.DefaultProbabilityCurveBuilder) other;
			
			merger.mergeRosetta(getBaseYieldCurve(), o.getBaseYieldCurve(), this::setBaseYieldCurve);
			merger.mergeRosetta(getDefaultProbabilities(), o.getDefaultProbabilities(), this::setDefaultProbabilities);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DefaultProbabilityCurve _that = getType().cast(o);
		
			if (!Objects.equals(baseYieldCurve, _that.getBaseYieldCurve())) return false;
			if (!Objects.equals(defaultProbabilities, _that.getDefaultProbabilities())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (baseYieldCurve != null ? baseYieldCurve.hashCode() : 0);
			_result = 31 * _result + (defaultProbabilities != null ? defaultProbabilities.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DefaultProbabilityCurveBuilder {" +
				"baseYieldCurve=" + this.baseYieldCurve + ", " +
				"defaultProbabilities=" + this.defaultProbabilities +
			'}' + " " + super.toString();
		}
	}
}

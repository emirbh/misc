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
import fpml.consolidated.mktenv.meta.CreditCurveValuationMeta;
import fpml.consolidated.riskdef.PricingStructureValuation;
import fpml.consolidated.riskdef.QuotedAssetSet;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import fpml.consolidated.shared.IdentifiedDate;
import java.math.BigDecimal;
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
 * Provision A set of credit curve values, which can include pricing inputs (which are typically credit spreads), default probabilities, and recovery rates.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A set of credit curve values, which can include pricing inputs (which are typically credit spreads), default probabilities, and recovery rates.
 *
 */
@RosettaDataType(value="CreditCurveValuation", builder=CreditCurveValuation.CreditCurveValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditCurveValuation", model="fpml", builder=CreditCurveValuation.CreditCurveValuationBuilderImpl.class, version="2.1.1")
public interface CreditCurveValuation extends PricingStructureValuation {

	CreditCurveValuationMeta metaData = new CreditCurveValuationMeta();

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
	QuotedAssetSet getInputs();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A curve of default probabilities.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A curve of default probabilities.
	 *
	 */
	DefaultProbabilityCurve getDefaultProbabilityCurve();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A single recovery rate, to be used for all terms.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A single recovery rate, to be used for all terms.
	 *
	 */
	BigDecimal getRecoveryRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A curve of recovery rates, allowing different terms to have different recovery rates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A curve of recovery rates, allowing different terms to have different recovery rates.
	 *
	 */
	TermCurve getRecoveryRateCurve();

	/*********************** Build Methods  ***********************/
	CreditCurveValuation build();
	
	CreditCurveValuation.CreditCurveValuationBuilder toBuilder();
	
	static CreditCurveValuation.CreditCurveValuationBuilder builder() {
		return new CreditCurveValuation.CreditCurveValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditCurveValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditCurveValuation> getType() {
		return CreditCurveValuation.class;
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
		processRosetta(path.newSubPath("inputs"), processor, QuotedAssetSet.class, getInputs());
		processRosetta(path.newSubPath("defaultProbabilityCurve"), processor, DefaultProbabilityCurve.class, getDefaultProbabilityCurve());
		processor.processBasic(path.newSubPath("recoveryRate"), BigDecimal.class, getRecoveryRate(), this);
		processRosetta(path.newSubPath("recoveryRateCurve"), processor, TermCurve.class, getRecoveryRateCurve());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditCurveValuationBuilder extends CreditCurveValuation, PricingStructureValuation.PricingStructureValuationBuilder {
		QuotedAssetSet.QuotedAssetSetBuilder getOrCreateInputs();
		@Override
		QuotedAssetSet.QuotedAssetSetBuilder getInputs();
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder getOrCreateDefaultProbabilityCurve();
		@Override
		DefaultProbabilityCurve.DefaultProbabilityCurveBuilder getDefaultProbabilityCurve();
		TermCurve.TermCurveBuilder getOrCreateRecoveryRateCurve();
		@Override
		TermCurve.TermCurveBuilder getRecoveryRateCurve();
		@Override
		CreditCurveValuation.CreditCurveValuationBuilder setId(String id);
		@Override
		CreditCurveValuation.CreditCurveValuationBuilder setDefinitionRef(String definitionRef);
		@Override
		CreditCurveValuation.CreditCurveValuationBuilder setObjectReference(AnyAssetReference objectReference);
		@Override
		CreditCurveValuation.CreditCurveValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		@Override
		CreditCurveValuation.CreditCurveValuationBuilder setBaseDate(IdentifiedDate baseDate);
		@Override
		CreditCurveValuation.CreditCurveValuationBuilder setSpotDate(IdentifiedDate spotDate);
		@Override
		CreditCurveValuation.CreditCurveValuationBuilder setInputDataDate(IdentifiedDate inputDataDate);
		@Override
		CreditCurveValuation.CreditCurveValuationBuilder setEndDate(IdentifiedDate endDate);
		@Override
		CreditCurveValuation.CreditCurveValuationBuilder setBuildDateTime(ZonedDateTime buildDateTime);
		CreditCurveValuation.CreditCurveValuationBuilder setInputs(QuotedAssetSet inputs);
		CreditCurveValuation.CreditCurveValuationBuilder setDefaultProbabilityCurve(DefaultProbabilityCurve defaultProbabilityCurve);
		CreditCurveValuation.CreditCurveValuationBuilder setRecoveryRate(BigDecimal recoveryRate);
		CreditCurveValuation.CreditCurveValuationBuilder setRecoveryRateCurve(TermCurve recoveryRateCurve);

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
			processRosetta(path.newSubPath("inputs"), processor, QuotedAssetSet.QuotedAssetSetBuilder.class, getInputs());
			processRosetta(path.newSubPath("defaultProbabilityCurve"), processor, DefaultProbabilityCurve.DefaultProbabilityCurveBuilder.class, getDefaultProbabilityCurve());
			processor.processBasic(path.newSubPath("recoveryRate"), BigDecimal.class, getRecoveryRate(), this);
			processRosetta(path.newSubPath("recoveryRateCurve"), processor, TermCurve.TermCurveBuilder.class, getRecoveryRateCurve());
		}
		

		CreditCurveValuation.CreditCurveValuationBuilder prune();
	}

	/*********************** Immutable Implementation of CreditCurveValuation  ***********************/
	class CreditCurveValuationImpl extends PricingStructureValuation.PricingStructureValuationImpl implements CreditCurveValuation {
		private final QuotedAssetSet inputs;
		private final DefaultProbabilityCurve defaultProbabilityCurve;
		private final BigDecimal recoveryRate;
		private final TermCurve recoveryRateCurve;
		
		protected CreditCurveValuationImpl(CreditCurveValuation.CreditCurveValuationBuilder builder) {
			super(builder);
			this.inputs = ofNullable(builder.getInputs()).map(f->f.build()).orElse(null);
			this.defaultProbabilityCurve = ofNullable(builder.getDefaultProbabilityCurve()).map(f->f.build()).orElse(null);
			this.recoveryRate = builder.getRecoveryRate();
			this.recoveryRateCurve = ofNullable(builder.getRecoveryRateCurve()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("inputs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inputs")
		public QuotedAssetSet getInputs() {
			return inputs;
		}
		
		@Override
		@RosettaAttribute("defaultProbabilityCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("defaultProbabilityCurve")
		public DefaultProbabilityCurve getDefaultProbabilityCurve() {
			return defaultProbabilityCurve;
		}
		
		@Override
		@RosettaAttribute("recoveryRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recoveryRate")
		public BigDecimal getRecoveryRate() {
			return recoveryRate;
		}
		
		@Override
		@RosettaAttribute("recoveryRateCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recoveryRateCurve")
		public TermCurve getRecoveryRateCurve() {
			return recoveryRateCurve;
		}
		
		@Override
		public CreditCurveValuation build() {
			return this;
		}
		
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder toBuilder() {
			CreditCurveValuation.CreditCurveValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditCurveValuation.CreditCurveValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInputs()).ifPresent(builder::setInputs);
			ofNullable(getDefaultProbabilityCurve()).ifPresent(builder::setDefaultProbabilityCurve);
			ofNullable(getRecoveryRate()).ifPresent(builder::setRecoveryRate);
			ofNullable(getRecoveryRateCurve()).ifPresent(builder::setRecoveryRateCurve);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(inputs, _that.getInputs())) return false;
			if (!Objects.equals(defaultProbabilityCurve, _that.getDefaultProbabilityCurve())) return false;
			if (!Objects.equals(recoveryRate, _that.getRecoveryRate())) return false;
			if (!Objects.equals(recoveryRateCurve, _that.getRecoveryRateCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inputs != null ? inputs.hashCode() : 0);
			_result = 31 * _result + (defaultProbabilityCurve != null ? defaultProbabilityCurve.hashCode() : 0);
			_result = 31 * _result + (recoveryRate != null ? recoveryRate.hashCode() : 0);
			_result = 31 * _result + (recoveryRateCurve != null ? recoveryRateCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditCurveValuation {" +
				"inputs=" + this.inputs + ", " +
				"defaultProbabilityCurve=" + this.defaultProbabilityCurve + ", " +
				"recoveryRate=" + this.recoveryRate + ", " +
				"recoveryRateCurve=" + this.recoveryRateCurve +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditCurveValuation  ***********************/
	class CreditCurveValuationBuilderImpl extends PricingStructureValuation.PricingStructureValuationBuilderImpl implements CreditCurveValuation.CreditCurveValuationBuilder {
	
		protected QuotedAssetSet.QuotedAssetSetBuilder inputs;
		protected DefaultProbabilityCurve.DefaultProbabilityCurveBuilder defaultProbabilityCurve;
		protected BigDecimal recoveryRate;
		protected TermCurve.TermCurveBuilder recoveryRateCurve;
		
		@Override
		@RosettaAttribute("inputs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inputs")
		public QuotedAssetSet.QuotedAssetSetBuilder getInputs() {
			return inputs;
		}
		
		@Override
		public QuotedAssetSet.QuotedAssetSetBuilder getOrCreateInputs() {
			QuotedAssetSet.QuotedAssetSetBuilder result;
			if (inputs!=null) {
				result = inputs;
			}
			else {
				result = inputs = QuotedAssetSet.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("defaultProbabilityCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("defaultProbabilityCurve")
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder getDefaultProbabilityCurve() {
			return defaultProbabilityCurve;
		}
		
		@Override
		public DefaultProbabilityCurve.DefaultProbabilityCurveBuilder getOrCreateDefaultProbabilityCurve() {
			DefaultProbabilityCurve.DefaultProbabilityCurveBuilder result;
			if (defaultProbabilityCurve!=null) {
				result = defaultProbabilityCurve;
			}
			else {
				result = defaultProbabilityCurve = DefaultProbabilityCurve.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("recoveryRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recoveryRate")
		public BigDecimal getRecoveryRate() {
			return recoveryRate;
		}
		
		@Override
		@RosettaAttribute("recoveryRateCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recoveryRateCurve")
		public TermCurve.TermCurveBuilder getRecoveryRateCurve() {
			return recoveryRateCurve;
		}
		
		@Override
		public TermCurve.TermCurveBuilder getOrCreateRecoveryRateCurve() {
			TermCurve.TermCurveBuilder result;
			if (recoveryRateCurve!=null) {
				result = recoveryRateCurve;
			}
			else {
				result = recoveryRateCurve = TermCurve.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definitionRef")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder setDefinitionRef(String _definitionRef) {
			this.definitionRef = _definitionRef == null ? null : _definitionRef;
			return this;
		}
		
		@RosettaAttribute("objectReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("objectReference")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder setObjectReference(AnyAssetReference _objectReference) {
			this.objectReference = _objectReference == null ? null : _objectReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationScenarioReference")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder setValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference) {
			this.valuationScenarioReference = _valuationScenarioReference == null ? null : _valuationScenarioReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("baseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseDate")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder setBaseDate(IdentifiedDate _baseDate) {
			this.baseDate = _baseDate == null ? null : _baseDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotDate")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder setSpotDate(IdentifiedDate _spotDate) {
			this.spotDate = _spotDate == null ? null : _spotDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inputDataDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inputDataDate")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder setInputDataDate(IdentifiedDate _inputDataDate) {
			this.inputDataDate = _inputDataDate == null ? null : _inputDataDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder setEndDate(IdentifiedDate _endDate) {
			this.endDate = _endDate == null ? null : _endDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buildDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buildDateTime")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder setBuildDateTime(ZonedDateTime _buildDateTime) {
			this.buildDateTime = _buildDateTime == null ? null : _buildDateTime;
			return this;
		}
		
		@RosettaAttribute("inputs")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inputs")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder setInputs(QuotedAssetSet _inputs) {
			this.inputs = _inputs == null ? null : _inputs.toBuilder();
			return this;
		}
		
		@RosettaAttribute("defaultProbabilityCurve")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("defaultProbabilityCurve")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder setDefaultProbabilityCurve(DefaultProbabilityCurve _defaultProbabilityCurve) {
			this.defaultProbabilityCurve = _defaultProbabilityCurve == null ? null : _defaultProbabilityCurve.toBuilder();
			return this;
		}
		
		@RosettaAttribute("recoveryRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("recoveryRate")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder setRecoveryRate(BigDecimal _recoveryRate) {
			this.recoveryRate = _recoveryRate == null ? null : _recoveryRate;
			return this;
		}
		
		@RosettaAttribute("recoveryRateCurve")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("recoveryRateCurve")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder setRecoveryRateCurve(TermCurve _recoveryRateCurve) {
			this.recoveryRateCurve = _recoveryRateCurve == null ? null : _recoveryRateCurve.toBuilder();
			return this;
		}
		
		@Override
		public CreditCurveValuation build() {
			return new CreditCurveValuation.CreditCurveValuationImpl(this);
		}
		
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder prune() {
			super.prune();
			if (inputs!=null && !inputs.prune().hasData()) inputs = null;
			if (defaultProbabilityCurve!=null && !defaultProbabilityCurve.prune().hasData()) defaultProbabilityCurve = null;
			if (recoveryRateCurve!=null && !recoveryRateCurve.prune().hasData()) recoveryRateCurve = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInputs()!=null && getInputs().hasData()) return true;
			if (getDefaultProbabilityCurve()!=null && getDefaultProbabilityCurve().hasData()) return true;
			if (getRecoveryRate()!=null) return true;
			if (getRecoveryRateCurve()!=null && getRecoveryRateCurve().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditCurveValuation.CreditCurveValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CreditCurveValuation.CreditCurveValuationBuilder o = (CreditCurveValuation.CreditCurveValuationBuilder) other;
			
			merger.mergeRosetta(getInputs(), o.getInputs(), this::setInputs);
			merger.mergeRosetta(getDefaultProbabilityCurve(), o.getDefaultProbabilityCurve(), this::setDefaultProbabilityCurve);
			merger.mergeRosetta(getRecoveryRateCurve(), o.getRecoveryRateCurve(), this::setRecoveryRateCurve);
			
			merger.mergeBasic(getRecoveryRate(), o.getRecoveryRate(), this::setRecoveryRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditCurveValuation _that = getType().cast(o);
		
			if (!Objects.equals(inputs, _that.getInputs())) return false;
			if (!Objects.equals(defaultProbabilityCurve, _that.getDefaultProbabilityCurve())) return false;
			if (!Objects.equals(recoveryRate, _that.getRecoveryRate())) return false;
			if (!Objects.equals(recoveryRateCurve, _that.getRecoveryRateCurve())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inputs != null ? inputs.hashCode() : 0);
			_result = 31 * _result + (defaultProbabilityCurve != null ? defaultProbabilityCurve.hashCode() : 0);
			_result = 31 * _result + (recoveryRate != null ? recoveryRate.hashCode() : 0);
			_result = 31 * _result + (recoveryRateCurve != null ? recoveryRateCurve.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditCurveValuationBuilder {" +
				"inputs=" + this.inputs + ", " +
				"defaultProbabilityCurve=" + this.defaultProbabilityCurve + ", " +
				"recoveryRate=" + this.recoveryRate + ", " +
				"recoveryRateCurve=" + this.recoveryRateCurve +
			'}' + " " + super.toString();
		}
	}
}

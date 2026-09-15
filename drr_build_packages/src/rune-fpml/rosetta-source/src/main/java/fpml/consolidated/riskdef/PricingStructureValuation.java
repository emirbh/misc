package fpml.consolidated.riskdef;

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
import fpml.consolidated.riskdef.meta.PricingStructureValuationMeta;
import fpml.consolidated.shared.IdentifiedDate;
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
 * Provision An abstract pricing structure valuation base type. Used as a base for values of pricing structures such as yield curves and volatility matrices. Derived from the "Valuation" type.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An abstract pricing structure valuation base type. Used as a base for values of pricing structures such as yield curves and volatility matrices. Derived from the "Valuation" type.
 *
 */
@RosettaDataType(value="PricingStructureValuation", builder=PricingStructureValuation.PricingStructureValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PricingStructureValuation", model="fpml", builder=PricingStructureValuation.PricingStructureValuationBuilderImpl.class, version="2.1.1")
public interface PricingStructureValuation extends Valuation {

	PricingStructureValuationMeta metaData = new PricingStructureValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The base date for which the structure applies, i.e. the curve date. Normally this will align with the valuation date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The base date for which the structure applies, i.e. the curve date. Normally this will align with the valuation date.
	 *
	 */
	IdentifiedDate getBaseDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The spot settlement date for which the structure applies, normally 0-2 days after the base date. The difference between the baseDate and the spotDate is termed the settlement lag, and is sometimes called "days to spot".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The spot settlement date for which the structure applies, normally 0-2 days after the base date. The difference between the baseDate and the spotDate is termed the settlement lag, and is sometimes called "days to spot".
	 *
	 */
	IdentifiedDate getSpotDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date from which the input data used to construct the pricing input was obtained. Often the same as the baseDate, but sometimes the pricing input may be "rolled forward", in which input data from one date is used to generate a curve for a later date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date from which the input data used to construct the pricing input was obtained. Often the same as the baseDate, but sometimes the pricing input may be "rolled forward", in which input data from one date is used to generate a curve for a later date.
	 *
	 */
	IdentifiedDate getInputDataDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The last date for which data is supplied in this pricing input.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The last date for which data is supplied in this pricing input.
	 *
	 */
	IdentifiedDate getEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date and time when the pricing input was generated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date and time when the pricing input was generated.
	 *
	 */
	ZonedDateTime getBuildDateTime();

	/*********************** Build Methods  ***********************/
	PricingStructureValuation build();
	
	PricingStructureValuation.PricingStructureValuationBuilder toBuilder();
	
	static PricingStructureValuation.PricingStructureValuationBuilder builder() {
		return new PricingStructureValuation.PricingStructureValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingStructureValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PricingStructureValuation> getType() {
		return PricingStructureValuation.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingStructureValuationBuilder extends PricingStructureValuation, Valuation.ValuationBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateBaseDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getBaseDate();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateSpotDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getSpotDate();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateInputDataDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getInputDataDate();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateEndDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getEndDate();
		@Override
		PricingStructureValuation.PricingStructureValuationBuilder setId(String id);
		@Override
		PricingStructureValuation.PricingStructureValuationBuilder setDefinitionRef(String definitionRef);
		@Override
		PricingStructureValuation.PricingStructureValuationBuilder setObjectReference(AnyAssetReference objectReference);
		@Override
		PricingStructureValuation.PricingStructureValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		PricingStructureValuation.PricingStructureValuationBuilder setBaseDate(IdentifiedDate baseDate);
		PricingStructureValuation.PricingStructureValuationBuilder setSpotDate(IdentifiedDate spotDate);
		PricingStructureValuation.PricingStructureValuationBuilder setInputDataDate(IdentifiedDate inputDataDate);
		PricingStructureValuation.PricingStructureValuationBuilder setEndDate(IdentifiedDate endDate);
		PricingStructureValuation.PricingStructureValuationBuilder setBuildDateTime(ZonedDateTime buildDateTime);

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
		}
		

		PricingStructureValuation.PricingStructureValuationBuilder prune();
	}

	/*********************** Immutable Implementation of PricingStructureValuation  ***********************/
	class PricingStructureValuationImpl extends Valuation.ValuationImpl implements PricingStructureValuation {
		private final IdentifiedDate baseDate;
		private final IdentifiedDate spotDate;
		private final IdentifiedDate inputDataDate;
		private final IdentifiedDate endDate;
		private final ZonedDateTime buildDateTime;
		
		protected PricingStructureValuationImpl(PricingStructureValuation.PricingStructureValuationBuilder builder) {
			super(builder);
			this.baseDate = ofNullable(builder.getBaseDate()).map(f->f.build()).orElse(null);
			this.spotDate = ofNullable(builder.getSpotDate()).map(f->f.build()).orElse(null);
			this.inputDataDate = ofNullable(builder.getInputDataDate()).map(f->f.build()).orElse(null);
			this.endDate = ofNullable(builder.getEndDate()).map(f->f.build()).orElse(null);
			this.buildDateTime = builder.getBuildDateTime();
		}
		
		@Override
		@RosettaAttribute("baseDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseDate")
		public IdentifiedDate getBaseDate() {
			return baseDate;
		}
		
		@Override
		@RosettaAttribute("spotDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotDate")
		public IdentifiedDate getSpotDate() {
			return spotDate;
		}
		
		@Override
		@RosettaAttribute("inputDataDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inputDataDate")
		public IdentifiedDate getInputDataDate() {
			return inputDataDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public IdentifiedDate getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("buildDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buildDateTime")
		public ZonedDateTime getBuildDateTime() {
			return buildDateTime;
		}
		
		@Override
		public PricingStructureValuation build() {
			return this;
		}
		
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder toBuilder() {
			PricingStructureValuation.PricingStructureValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingStructureValuation.PricingStructureValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBaseDate()).ifPresent(builder::setBaseDate);
			ofNullable(getSpotDate()).ifPresent(builder::setSpotDate);
			ofNullable(getInputDataDate()).ifPresent(builder::setInputDataDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getBuildDateTime()).ifPresent(builder::setBuildDateTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PricingStructureValuation _that = getType().cast(o);
		
			if (!Objects.equals(baseDate, _that.getBaseDate())) return false;
			if (!Objects.equals(spotDate, _that.getSpotDate())) return false;
			if (!Objects.equals(inputDataDate, _that.getInputDataDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(buildDateTime, _that.getBuildDateTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (baseDate != null ? baseDate.hashCode() : 0);
			_result = 31 * _result + (spotDate != null ? spotDate.hashCode() : 0);
			_result = 31 * _result + (inputDataDate != null ? inputDataDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (buildDateTime != null ? buildDateTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructureValuation {" +
				"baseDate=" + this.baseDate + ", " +
				"spotDate=" + this.spotDate + ", " +
				"inputDataDate=" + this.inputDataDate + ", " +
				"endDate=" + this.endDate + ", " +
				"buildDateTime=" + this.buildDateTime +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PricingStructureValuation  ***********************/
	class PricingStructureValuationBuilderImpl extends Valuation.ValuationBuilderImpl implements PricingStructureValuation.PricingStructureValuationBuilder {
	
		protected IdentifiedDate.IdentifiedDateBuilder baseDate;
		protected IdentifiedDate.IdentifiedDateBuilder spotDate;
		protected IdentifiedDate.IdentifiedDateBuilder inputDataDate;
		protected IdentifiedDate.IdentifiedDateBuilder endDate;
		protected ZonedDateTime buildDateTime;
		
		@Override
		@RosettaAttribute("baseDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("baseDate")
		public IdentifiedDate.IdentifiedDateBuilder getBaseDate() {
			return baseDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateBaseDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (baseDate!=null) {
				result = baseDate;
			}
			else {
				result = baseDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotDate")
		public IdentifiedDate.IdentifiedDateBuilder getSpotDate() {
			return spotDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateSpotDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (spotDate!=null) {
				result = spotDate;
			}
			else {
				result = spotDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("inputDataDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inputDataDate")
		public IdentifiedDate.IdentifiedDateBuilder getInputDataDate() {
			return inputDataDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateInputDataDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (inputDataDate!=null) {
				result = inputDataDate;
			}
			else {
				result = inputDataDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public IdentifiedDate.IdentifiedDateBuilder getEndDate() {
			return endDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateEndDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (endDate!=null) {
				result = endDate;
			}
			else {
				result = endDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buildDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buildDateTime")
		public ZonedDateTime getBuildDateTime() {
			return buildDateTime;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definitionRef")
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder setDefinitionRef(String _definitionRef) {
			this.definitionRef = _definitionRef == null ? null : _definitionRef;
			return this;
		}
		
		@RosettaAttribute("objectReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("objectReference")
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder setObjectReference(AnyAssetReference _objectReference) {
			this.objectReference = _objectReference == null ? null : _objectReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationScenarioReference")
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder setValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference) {
			this.valuationScenarioReference = _valuationScenarioReference == null ? null : _valuationScenarioReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("baseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseDate")
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder setBaseDate(IdentifiedDate _baseDate) {
			this.baseDate = _baseDate == null ? null : _baseDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotDate")
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder setSpotDate(IdentifiedDate _spotDate) {
			this.spotDate = _spotDate == null ? null : _spotDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inputDataDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inputDataDate")
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder setInputDataDate(IdentifiedDate _inputDataDate) {
			this.inputDataDate = _inputDataDate == null ? null : _inputDataDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder setEndDate(IdentifiedDate _endDate) {
			this.endDate = _endDate == null ? null : _endDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buildDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buildDateTime")
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder setBuildDateTime(ZonedDateTime _buildDateTime) {
			this.buildDateTime = _buildDateTime == null ? null : _buildDateTime;
			return this;
		}
		
		@Override
		public PricingStructureValuation build() {
			return new PricingStructureValuation.PricingStructureValuationImpl(this);
		}
		
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder prune() {
			super.prune();
			if (baseDate!=null && !baseDate.prune().hasData()) baseDate = null;
			if (spotDate!=null && !spotDate.prune().hasData()) spotDate = null;
			if (inputDataDate!=null && !inputDataDate.prune().hasData()) inputDataDate = null;
			if (endDate!=null && !endDate.prune().hasData()) endDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBaseDate()!=null && getBaseDate().hasData()) return true;
			if (getSpotDate()!=null && getSpotDate().hasData()) return true;
			if (getInputDataDate()!=null && getInputDataDate().hasData()) return true;
			if (getEndDate()!=null && getEndDate().hasData()) return true;
			if (getBuildDateTime()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructureValuation.PricingStructureValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PricingStructureValuation.PricingStructureValuationBuilder o = (PricingStructureValuation.PricingStructureValuationBuilder) other;
			
			merger.mergeRosetta(getBaseDate(), o.getBaseDate(), this::setBaseDate);
			merger.mergeRosetta(getSpotDate(), o.getSpotDate(), this::setSpotDate);
			merger.mergeRosetta(getInputDataDate(), o.getInputDataDate(), this::setInputDataDate);
			merger.mergeRosetta(getEndDate(), o.getEndDate(), this::setEndDate);
			
			merger.mergeBasic(getBuildDateTime(), o.getBuildDateTime(), this::setBuildDateTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PricingStructureValuation _that = getType().cast(o);
		
			if (!Objects.equals(baseDate, _that.getBaseDate())) return false;
			if (!Objects.equals(spotDate, _that.getSpotDate())) return false;
			if (!Objects.equals(inputDataDate, _that.getInputDataDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(buildDateTime, _that.getBuildDateTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (baseDate != null ? baseDate.hashCode() : 0);
			_result = 31 * _result + (spotDate != null ? spotDate.hashCode() : 0);
			_result = 31 * _result + (inputDataDate != null ? inputDataDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (buildDateTime != null ? buildDateTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructureValuationBuilder {" +
				"baseDate=" + this.baseDate + ", " +
				"spotDate=" + this.spotDate + ", " +
				"inputDataDate=" + this.inputDataDate + ", " +
				"endDate=" + this.endDate + ", " +
				"buildDateTime=" + this.buildDateTime +
			'}' + " " + super.toString();
		}
	}
}

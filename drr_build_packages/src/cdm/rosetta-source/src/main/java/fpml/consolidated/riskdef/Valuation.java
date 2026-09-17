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
import fpml.consolidated.riskdef.meta.ValuationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A valuation of an valuable object - an asset or a pricing input. This is an abstract type, used as a base for values of pricing structures such as yield curves as well as asset values.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A valuation of an valuable object - an asset or a pricing input. This is an abstract type, used as a base for values of pricing structures such as yield curves as well as asset values.
 *
 */
@RosettaDataType(value="Valuation", builder=Valuation.ValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Valuation", model="fpml", builder=Valuation.ValuationBuilderImpl.class, version="2.1.1")
public interface Valuation extends RosettaModelObject {

	ValuationMeta metaData = new ValuationMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. An optional reference to the scenario that this valuation applies to.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision DEPRECATED. An optional reference to the scenario that this valuation applies to.
	 *
	 */
	String getDefinitionRef();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the asset or pricing structure that this values.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the asset or pricing structure that this values.
	 *
	 */
	AnyAssetReference getObjectReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the valuation scenario used to calculate this valuation. If the Valuation occurs within a ValuationSet, this value is optional and is defaulted from the ValuationSet. If this value occurs in both places, the lower level value (i.e. the one here) overrides that in the higher (i.e. ValuationSet).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the valuation scenario used to calculate this valuation. If the Valuation occurs within a ValuationSet, this value is optional and is defaulted from the ValuationSet. If this value occurs in both places, the lower level value (i.e. the one here) overrides that in the higher (i.e. ValuationSet).
	 *
	 */
	ValuationScenarioReference getValuationScenarioReference();

	/*********************** Build Methods  ***********************/
	Valuation build();
	
	Valuation.ValuationBuilder toBuilder();
	
	static Valuation.ValuationBuilder builder() {
		return new Valuation.ValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Valuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Valuation> getType() {
		return Valuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationBuilder extends Valuation, RosettaModelObjectBuilder {
		AnyAssetReference.AnyAssetReferenceBuilder getOrCreateObjectReference();
		@Override
		AnyAssetReference.AnyAssetReferenceBuilder getObjectReference();
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference();
		@Override
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getValuationScenarioReference();
		Valuation.ValuationBuilder setId(String id);
		Valuation.ValuationBuilder setDefinitionRef(String definitionRef);
		Valuation.ValuationBuilder setObjectReference(AnyAssetReference objectReference);
		Valuation.ValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
		}
		

		Valuation.ValuationBuilder prune();
	}

	/*********************** Immutable Implementation of Valuation  ***********************/
	class ValuationImpl implements Valuation {
		private final String id;
		private final String definitionRef;
		private final AnyAssetReference objectReference;
		private final ValuationScenarioReference valuationScenarioReference;
		
		protected ValuationImpl(Valuation.ValuationBuilder builder) {
			this.id = builder.getId();
			this.definitionRef = builder.getDefinitionRef();
			this.objectReference = ofNullable(builder.getObjectReference()).map(f->f.build()).orElse(null);
			this.valuationScenarioReference = ofNullable(builder.getValuationScenarioReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("definitionRef")
		public String getDefinitionRef() {
			return definitionRef;
		}
		
		@Override
		@RosettaAttribute("objectReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("objectReference")
		public AnyAssetReference getObjectReference() {
			return objectReference;
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationScenarioReference")
		public ValuationScenarioReference getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		public Valuation build() {
			return this;
		}
		
		@Override
		public Valuation.ValuationBuilder toBuilder() {
			Valuation.ValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Valuation.ValuationBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getDefinitionRef()).ifPresent(builder::setDefinitionRef);
			ofNullable(getObjectReference()).ifPresent(builder::setObjectReference);
			ofNullable(getValuationScenarioReference()).ifPresent(builder::setValuationScenarioReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Valuation _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(definitionRef, _that.getDefinitionRef())) return false;
			if (!Objects.equals(objectReference, _that.getObjectReference())) return false;
			if (!Objects.equals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (definitionRef != null ? definitionRef.hashCode() : 0);
			_result = 31 * _result + (objectReference != null ? objectReference.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Valuation {" +
				"id=" + this.id + ", " +
				"definitionRef=" + this.definitionRef + ", " +
				"objectReference=" + this.objectReference + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference +
			'}';
		}
	}

	/*********************** Builder Implementation of Valuation  ***********************/
	class ValuationBuilderImpl implements Valuation.ValuationBuilder {
	
		protected String id;
		protected String definitionRef;
		protected AnyAssetReference.AnyAssetReferenceBuilder objectReference;
		protected ValuationScenarioReference.ValuationScenarioReferenceBuilder valuationScenarioReference;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("definitionRef")
		public String getDefinitionRef() {
			return definitionRef;
		}
		
		@Override
		@RosettaAttribute("objectReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("objectReference")
		public AnyAssetReference.AnyAssetReferenceBuilder getObjectReference() {
			return objectReference;
		}
		
		@Override
		public AnyAssetReference.AnyAssetReferenceBuilder getOrCreateObjectReference() {
			AnyAssetReference.AnyAssetReferenceBuilder result;
			if (objectReference!=null) {
				result = objectReference;
			}
			else {
				result = objectReference = AnyAssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationScenarioReference")
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference() {
			ValuationScenarioReference.ValuationScenarioReferenceBuilder result;
			if (valuationScenarioReference!=null) {
				result = valuationScenarioReference;
			}
			else {
				result = valuationScenarioReference = ValuationScenarioReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Valuation.ValuationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definitionRef")
		@Override
		public Valuation.ValuationBuilder setDefinitionRef(String _definitionRef) {
			this.definitionRef = _definitionRef == null ? null : _definitionRef;
			return this;
		}
		
		@RosettaAttribute("objectReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("objectReference")
		@Override
		public Valuation.ValuationBuilder setObjectReference(AnyAssetReference _objectReference) {
			this.objectReference = _objectReference == null ? null : _objectReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationScenarioReference")
		@Override
		public Valuation.ValuationBuilder setValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference) {
			this.valuationScenarioReference = _valuationScenarioReference == null ? null : _valuationScenarioReference.toBuilder();
			return this;
		}
		
		@Override
		public Valuation build() {
			return new Valuation.ValuationImpl(this);
		}
		
		@Override
		public Valuation.ValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Valuation.ValuationBuilder prune() {
			if (objectReference!=null && !objectReference.prune().hasData()) objectReference = null;
			if (valuationScenarioReference!=null && !valuationScenarioReference.prune().hasData()) valuationScenarioReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getDefinitionRef()!=null) return true;
			if (getObjectReference()!=null && getObjectReference().hasData()) return true;
			if (getValuationScenarioReference()!=null && getValuationScenarioReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Valuation.ValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Valuation.ValuationBuilder o = (Valuation.ValuationBuilder) other;
			
			merger.mergeRosetta(getObjectReference(), o.getObjectReference(), this::setObjectReference);
			merger.mergeRosetta(getValuationScenarioReference(), o.getValuationScenarioReference(), this::setValuationScenarioReference);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getDefinitionRef(), o.getDefinitionRef(), this::setDefinitionRef);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Valuation _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(definitionRef, _that.getDefinitionRef())) return false;
			if (!Objects.equals(objectReference, _that.getObjectReference())) return false;
			if (!Objects.equals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (definitionRef != null ? definitionRef.hashCode() : 0);
			_result = 31 * _result + (objectReference != null ? objectReference.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationBuilder {" +
				"id=" + this.id + ", " +
				"definitionRef=" + this.definitionRef + ", " +
				"objectReference=" + this.objectReference + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference +
			'}';
		}
	}
}

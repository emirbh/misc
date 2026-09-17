package fpml.consolidated.doc;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.doc.meta.PartyEntityClassificationMeta;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that specifies the classification of a party.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that specifies the classification of a party.
 *
 */
@RosettaDataType(value="PartyEntityClassification", builder=PartyEntityClassification.PartyEntityClassificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyEntityClassification", model="fpml", builder=PartyEntityClassification.PartyEntityClassificationBuilderImpl.class, version="2.1.1")
public interface PartyEntityClassification extends RosettaModelObject {

	PartyEntityClassificationMeta metaData = new PartyEntityClassificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. The party referenced has the classification in the associated "entityClassification" element below.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. The party referenced has the classification in the associated "entityClassification" element below.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the category or classification or business role of the organization referenced by the partyTradeInformation with respect to this reporting regime, for example Financial, NonFinancial etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the category or classification or business role of the organization referenced by the partyTradeInformation with respect to this reporting regime, for example Financial, NonFinancial etc.
	 *
	 */
	EntityClassification getEntityClassification();

	/*********************** Build Methods  ***********************/
	PartyEntityClassification build();
	
	PartyEntityClassification.PartyEntityClassificationBuilder toBuilder();
	
	static PartyEntityClassification.PartyEntityClassificationBuilder builder() {
		return new PartyEntityClassification.PartyEntityClassificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyEntityClassification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyEntityClassification> getType() {
		return PartyEntityClassification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("entityClassification"), processor, EntityClassification.class, getEntityClassification());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyEntityClassificationBuilder extends PartyEntityClassification, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		EntityClassification.EntityClassificationBuilder getOrCreateEntityClassification();
		@Override
		EntityClassification.EntityClassificationBuilder getEntityClassification();
		PartyEntityClassification.PartyEntityClassificationBuilder setPartyReference(PartyReference partyReference);
		PartyEntityClassification.PartyEntityClassificationBuilder setEntityClassification(EntityClassification entityClassification);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("entityClassification"), processor, EntityClassification.EntityClassificationBuilder.class, getEntityClassification());
		}
		

		PartyEntityClassification.PartyEntityClassificationBuilder prune();
	}

	/*********************** Immutable Implementation of PartyEntityClassification  ***********************/
	class PartyEntityClassificationImpl implements PartyEntityClassification {
		private final PartyReference partyReference;
		private final EntityClassification entityClassification;
		
		protected PartyEntityClassificationImpl(PartyEntityClassification.PartyEntityClassificationBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.entityClassification = ofNullable(builder.getEntityClassification()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("entityClassification")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("entityClassification")
		public EntityClassification getEntityClassification() {
			return entityClassification;
		}
		
		@Override
		public PartyEntityClassification build() {
			return this;
		}
		
		@Override
		public PartyEntityClassification.PartyEntityClassificationBuilder toBuilder() {
			PartyEntityClassification.PartyEntityClassificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyEntityClassification.PartyEntityClassificationBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getEntityClassification()).ifPresent(builder::setEntityClassification);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyEntityClassification _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(entityClassification, _that.getEntityClassification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (entityClassification != null ? entityClassification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyEntityClassification {" +
				"partyReference=" + this.partyReference + ", " +
				"entityClassification=" + this.entityClassification +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyEntityClassification  ***********************/
	class PartyEntityClassificationBuilderImpl implements PartyEntityClassification.PartyEntityClassificationBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected EntityClassification.EntityClassificationBuilder entityClassification;
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("entityClassification")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("entityClassification")
		public EntityClassification.EntityClassificationBuilder getEntityClassification() {
			return entityClassification;
		}
		
		@Override
		public EntityClassification.EntityClassificationBuilder getOrCreateEntityClassification() {
			EntityClassification.EntityClassificationBuilder result;
			if (entityClassification!=null) {
				result = entityClassification;
			}
			else {
				result = entityClassification = EntityClassification.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public PartyEntityClassification.PartyEntityClassificationBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("entityClassification")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("entityClassification")
		@Override
		public PartyEntityClassification.PartyEntityClassificationBuilder setEntityClassification(EntityClassification _entityClassification) {
			this.entityClassification = _entityClassification == null ? null : _entityClassification.toBuilder();
			return this;
		}
		
		@Override
		public PartyEntityClassification build() {
			return new PartyEntityClassification.PartyEntityClassificationImpl(this);
		}
		
		@Override
		public PartyEntityClassification.PartyEntityClassificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyEntityClassification.PartyEntityClassificationBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (entityClassification!=null && !entityClassification.prune().hasData()) entityClassification = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getEntityClassification()!=null && getEntityClassification().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyEntityClassification.PartyEntityClassificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyEntityClassification.PartyEntityClassificationBuilder o = (PartyEntityClassification.PartyEntityClassificationBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getEntityClassification(), o.getEntityClassification(), this::setEntityClassification);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyEntityClassification _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(entityClassification, _that.getEntityClassification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (entityClassification != null ? entityClassification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyEntityClassificationBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"entityClassification=" + this.entityClassification +
			'}';
		}
	}
}

package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.AssociationToAssetIdentifierMeta;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining an association between party or settlement information with an asset or assets
 *
 */
@RosettaDataType(value="AssociationToAssetIdentifier", builder=AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AssociationToAssetIdentifier", model="fpml", builder=AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilderImpl.class, version="2.1.1")
public interface AssociationToAssetIdentifier extends RosettaModelObject {

	AssociationToAssetIdentifierMeta metaData = new AssociationToAssetIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique association ID, based on a scheme.
	 *
	 */
	AssociationToAssetId getAssociationId();

	/*********************** Build Methods  ***********************/
	AssociationToAssetIdentifier build();
	
	AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder toBuilder();
	
	static AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder builder() {
		return new AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssociationToAssetIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssociationToAssetIdentifier> getType() {
		return AssociationToAssetIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("associationId"), processor, AssociationToAssetId.class, getAssociationId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssociationToAssetIdentifierBuilder extends AssociationToAssetIdentifier, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		AssociationToAssetId.AssociationToAssetIdBuilder getOrCreateAssociationId();
		@Override
		AssociationToAssetId.AssociationToAssetIdBuilder getAssociationId();
		AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder setId(String id);
		AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder setPartyReference(PartyReference partyReference);
		AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder setAssociationId(AssociationToAssetId associationId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("associationId"), processor, AssociationToAssetId.AssociationToAssetIdBuilder.class, getAssociationId());
		}
		

		AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of AssociationToAssetIdentifier  ***********************/
	class AssociationToAssetIdentifierImpl implements AssociationToAssetIdentifier {
		private final String id;
		private final PartyReference partyReference;
		private final AssociationToAssetId associationId;
		
		protected AssociationToAssetIdentifierImpl(AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder builder) {
			this.id = builder.getId();
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.associationId = ofNullable(builder.getAssociationId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
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
		@RosettaAttribute("associationId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("associationId")
		public AssociationToAssetId getAssociationId() {
			return associationId;
		}
		
		@Override
		public AssociationToAssetIdentifier build() {
			return this;
		}
		
		@Override
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder toBuilder() {
			AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getAssociationId()).ifPresent(builder::setAssociationId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssociationToAssetIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(associationId, _that.getAssociationId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (associationId != null ? associationId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssociationToAssetIdentifier {" +
				"id=" + this.id + ", " +
				"partyReference=" + this.partyReference + ", " +
				"associationId=" + this.associationId +
			'}';
		}
	}

	/*********************** Builder Implementation of AssociationToAssetIdentifier  ***********************/
	class AssociationToAssetIdentifierBuilderImpl implements AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder {
	
		protected String id;
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected AssociationToAssetId.AssociationToAssetIdBuilder associationId;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
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
		@RosettaAttribute("associationId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("associationId")
		public AssociationToAssetId.AssociationToAssetIdBuilder getAssociationId() {
			return associationId;
		}
		
		@Override
		public AssociationToAssetId.AssociationToAssetIdBuilder getOrCreateAssociationId() {
			AssociationToAssetId.AssociationToAssetIdBuilder result;
			if (associationId!=null) {
				result = associationId;
			}
			else {
				result = associationId = AssociationToAssetId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("associationId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("associationId")
		@Override
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder setAssociationId(AssociationToAssetId _associationId) {
			this.associationId = _associationId == null ? null : _associationId.toBuilder();
			return this;
		}
		
		@Override
		public AssociationToAssetIdentifier build() {
			return new AssociationToAssetIdentifier.AssociationToAssetIdentifierImpl(this);
		}
		
		@Override
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (associationId!=null && !associationId.prune().hasData()) associationId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getAssociationId()!=null && getAssociationId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder o = (AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getAssociationId(), o.getAssociationId(), this::setAssociationId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssociationToAssetIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(associationId, _that.getAssociationId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (associationId != null ? associationId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssociationToAssetIdentifierBuilder {" +
				"id=" + this.id + ", " +
				"partyReference=" + this.partyReference + ", " +
				"associationId=" + this.associationId +
			'}';
		}
	}
}

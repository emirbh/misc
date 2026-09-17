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
import fpml.consolidated.loan.meta.PartyProfileIdentifierMeta;
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
 * Provision A type that identifies a party profile record.
 *
 */
@RosettaDataType(value="PartyProfileIdentifier", builder=PartyProfileIdentifier.PartyProfileIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyProfileIdentifier", model="fpml", builder=PartyProfileIdentifier.PartyProfileIdentifierBuilderImpl.class, version="2.1.1")
public interface PartyProfileIdentifier extends RosettaModelObject {

	PartyProfileIdentifierMeta metaData = new PartyProfileIdentifierMeta();

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
	 * Provision 
	 *
	 */
	PartyProfileId getPartyProfileId();

	/*********************** Build Methods  ***********************/
	PartyProfileIdentifier build();
	
	PartyProfileIdentifier.PartyProfileIdentifierBuilder toBuilder();
	
	static PartyProfileIdentifier.PartyProfileIdentifierBuilder builder() {
		return new PartyProfileIdentifier.PartyProfileIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyProfileIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyProfileIdentifier> getType() {
		return PartyProfileIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("partyProfileId"), processor, PartyProfileId.class, getPartyProfileId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyProfileIdentifierBuilder extends PartyProfileIdentifier, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		PartyProfileId.PartyProfileIdBuilder getOrCreatePartyProfileId();
		@Override
		PartyProfileId.PartyProfileIdBuilder getPartyProfileId();
		PartyProfileIdentifier.PartyProfileIdentifierBuilder setId(String id);
		PartyProfileIdentifier.PartyProfileIdentifierBuilder setPartyReference(PartyReference partyReference);
		PartyProfileIdentifier.PartyProfileIdentifierBuilder setPartyProfileId(PartyProfileId partyProfileId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("partyProfileId"), processor, PartyProfileId.PartyProfileIdBuilder.class, getPartyProfileId());
		}
		

		PartyProfileIdentifier.PartyProfileIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of PartyProfileIdentifier  ***********************/
	class PartyProfileIdentifierImpl implements PartyProfileIdentifier {
		private final String id;
		private final PartyReference partyReference;
		private final PartyProfileId partyProfileId;
		
		protected PartyProfileIdentifierImpl(PartyProfileIdentifier.PartyProfileIdentifierBuilder builder) {
			this.id = builder.getId();
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.partyProfileId = ofNullable(builder.getPartyProfileId()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("partyProfileId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyProfileId")
		public PartyProfileId getPartyProfileId() {
			return partyProfileId;
		}
		
		@Override
		public PartyProfileIdentifier build() {
			return this;
		}
		
		@Override
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder toBuilder() {
			PartyProfileIdentifier.PartyProfileIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyProfileIdentifier.PartyProfileIdentifierBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getPartyProfileId()).ifPresent(builder::setPartyProfileId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyProfileIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(partyProfileId, _that.getPartyProfileId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (partyProfileId != null ? partyProfileId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileIdentifier {" +
				"id=" + this.id + ", " +
				"partyReference=" + this.partyReference + ", " +
				"partyProfileId=" + this.partyProfileId +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyProfileIdentifier  ***********************/
	class PartyProfileIdentifierBuilderImpl implements PartyProfileIdentifier.PartyProfileIdentifierBuilder {
	
		protected String id;
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected PartyProfileId.PartyProfileIdBuilder partyProfileId;
		
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
		@RosettaAttribute("partyProfileId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyProfileId")
		public PartyProfileId.PartyProfileIdBuilder getPartyProfileId() {
			return partyProfileId;
		}
		
		@Override
		public PartyProfileId.PartyProfileIdBuilder getOrCreatePartyProfileId() {
			PartyProfileId.PartyProfileIdBuilder result;
			if (partyProfileId!=null) {
				result = partyProfileId;
			}
			else {
				result = partyProfileId = PartyProfileId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyProfileId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyProfileId")
		@Override
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder setPartyProfileId(PartyProfileId _partyProfileId) {
			this.partyProfileId = _partyProfileId == null ? null : _partyProfileId.toBuilder();
			return this;
		}
		
		@Override
		public PartyProfileIdentifier build() {
			return new PartyProfileIdentifier.PartyProfileIdentifierImpl(this);
		}
		
		@Override
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (partyProfileId!=null && !partyProfileId.prune().hasData()) partyProfileId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getPartyProfileId()!=null && getPartyProfileId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyProfileIdentifier.PartyProfileIdentifierBuilder o = (PartyProfileIdentifier.PartyProfileIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getPartyProfileId(), o.getPartyProfileId(), this::setPartyProfileId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyProfileIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(partyProfileId, _that.getPartyProfileId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (partyProfileId != null ? partyProfileId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileIdentifierBuilder {" +
				"id=" + this.id + ", " +
				"partyReference=" + this.partyReference + ", " +
				"partyProfileId=" + this.partyProfileId +
			'}';
		}
	}
}

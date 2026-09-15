package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.MutuallyAgreedClearinghouseMeta;
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
@RosettaDataType(value="MutuallyAgreedClearinghouse", builder=MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MutuallyAgreedClearinghouse", model="fpml", builder=MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilderImpl.class, version="2.1.1")
public interface MutuallyAgreedClearinghouse extends RosettaModelObject {

	MutuallyAgreedClearinghouseMeta metaData = new MutuallyAgreedClearinghouseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party structure for the clearinghouse
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party structure for the clearinghouse
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A string that identifies the clearinghouse
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A string that identifies the clearinghouse
	 *
	 */
	OrganizationIdentifier getIdentifier();

	/*********************** Build Methods  ***********************/
	MutuallyAgreedClearinghouse build();
	
	MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder toBuilder();
	
	static MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder builder() {
		return new MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MutuallyAgreedClearinghouse> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MutuallyAgreedClearinghouse> getType() {
		return MutuallyAgreedClearinghouse.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("identifier"), processor, OrganizationIdentifier.class, getIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MutuallyAgreedClearinghouseBuilder extends MutuallyAgreedClearinghouse, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		OrganizationIdentifier.OrganizationIdentifierBuilder getOrCreateIdentifier();
		@Override
		OrganizationIdentifier.OrganizationIdentifierBuilder getIdentifier();
		MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder setPartyReference(PartyReference partyReference);
		MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder setIdentifier(OrganizationIdentifier identifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("identifier"), processor, OrganizationIdentifier.OrganizationIdentifierBuilder.class, getIdentifier());
		}
		

		MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder prune();
	}

	/*********************** Immutable Implementation of MutuallyAgreedClearinghouse  ***********************/
	class MutuallyAgreedClearinghouseImpl implements MutuallyAgreedClearinghouse {
		private final PartyReference partyReference;
		private final OrganizationIdentifier identifier;
		
		protected MutuallyAgreedClearinghouseImpl(MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifier")
		public OrganizationIdentifier getIdentifier() {
			return identifier;
		}
		
		@Override
		public MutuallyAgreedClearinghouse build() {
			return this;
		}
		
		@Override
		public MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder toBuilder() {
			MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MutuallyAgreedClearinghouse _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MutuallyAgreedClearinghouse {" +
				"partyReference=" + this.partyReference + ", " +
				"identifier=" + this.identifier +
			'}';
		}
	}

	/*********************** Builder Implementation of MutuallyAgreedClearinghouse  ***********************/
	class MutuallyAgreedClearinghouseBuilderImpl implements MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected OrganizationIdentifier.OrganizationIdentifierBuilder identifier;
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifier")
		public OrganizationIdentifier.OrganizationIdentifierBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public OrganizationIdentifier.OrganizationIdentifierBuilder getOrCreateIdentifier() {
			OrganizationIdentifier.OrganizationIdentifierBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = OrganizationIdentifier.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("identifier")
		@Override
		public MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder setIdentifier(OrganizationIdentifier _identifier) {
			this.identifier = _identifier == null ? null : _identifier.toBuilder();
			return this;
		}
		
		@Override
		public MutuallyAgreedClearinghouse build() {
			return new MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseImpl(this);
		}
		
		@Override
		public MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getIdentifier()!=null && getIdentifier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder o = (MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MutuallyAgreedClearinghouse _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MutuallyAgreedClearinghouseBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"identifier=" + this.identifier +
			'}';
		}
	}
}

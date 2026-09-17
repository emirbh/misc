package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.loan.meta.DealIdentifierMeta;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A unique reference to a syndicated bank loan deal (credit agreement).
 *
 */
@RosettaDataType(value="DealIdentifier", builder=DealIdentifier.DealIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DealIdentifier", model="fpml", builder=DealIdentifier.DealIdentifierBuilderImpl.class, version="2.1.1")
public interface DealIdentifier extends IdentifiedAssetWithParty {

	DealIdentifierMeta metaData = new DealIdentifierMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	DealIdentifier build();
	
	DealIdentifier.DealIdentifierBuilder toBuilder();
	
	static DealIdentifier.DealIdentifierBuilder builder() {
		return new DealIdentifier.DealIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DealIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DealIdentifier> getType() {
		return DealIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DealIdentifierBuilder extends DealIdentifier, IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder {
		@Override
		DealIdentifier.DealIdentifierBuilder setId(String id);
		@Override
		DealIdentifier.DealIdentifierBuilder setPartyReference(PartyReference partyReference);
		@Override
		DealIdentifier.DealIdentifierBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		DealIdentifier.DealIdentifierBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		DealIdentifier.DealIdentifierBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		DealIdentifier.DealIdentifierBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		DealIdentifier.DealIdentifierBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		DealIdentifier.DealIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of DealIdentifier  ***********************/
	class DealIdentifierImpl extends IdentifiedAssetWithParty.IdentifiedAssetWithPartyImpl implements DealIdentifier {
		
		protected DealIdentifierImpl(DealIdentifier.DealIdentifierBuilder builder) {
			super(builder);
		}
		
		@Override
		public DealIdentifier build() {
			return this;
		}
		
		@Override
		public DealIdentifier.DealIdentifierBuilder toBuilder() {
			DealIdentifier.DealIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DealIdentifier.DealIdentifierBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealIdentifier {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DealIdentifier  ***********************/
	class DealIdentifierBuilderImpl extends IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilderImpl implements DealIdentifier.DealIdentifierBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DealIdentifier.DealIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public DealIdentifier.DealIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public DealIdentifier.DealIdentifierBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public DealIdentifier.DealIdentifierBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public DealIdentifier.DealIdentifierBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public DealIdentifier.DealIdentifierBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public DealIdentifier.DealIdentifierBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public DealIdentifier build() {
			return new DealIdentifier.DealIdentifierImpl(this);
		}
		
		@Override
		public DealIdentifier.DealIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealIdentifier.DealIdentifierBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealIdentifier.DealIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DealIdentifier.DealIdentifierBuilder o = (DealIdentifier.DealIdentifierBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealIdentifierBuilder {" +
			'}' + " " + super.toString();
		}
	}
}

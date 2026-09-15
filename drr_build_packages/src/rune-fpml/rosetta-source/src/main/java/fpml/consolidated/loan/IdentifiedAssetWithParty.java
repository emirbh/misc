package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.loan.meta.IdentifiedAssetWithPartyMeta;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An extension of IdentifiedAsset to include PartyAndAccountReferences.model.
 *
 */
@RosettaDataType(value="IdentifiedAssetWithParty", builder=IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IdentifiedAssetWithParty", model="fpml", builder=IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilderImpl.class, version="2.1.1")
public interface IdentifiedAssetWithParty extends Asset {

	IdentifiedAssetWithPartyMeta metaData = new IdentifiedAssetWithPartyMeta();

	/*********************** Getter Methods  ***********************/
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
	 * Provision Identification of the underlying asset, using public and/or private identifiers.
	 *
	 */
	List<? extends InstrumentId> getInstrumentId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Long name of the underlying asset.
	 *
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	IdentifiedAssetWithParty build();
	
	IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder toBuilder();
	
	static IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder builder() {
		return new IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IdentifiedAssetWithParty> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IdentifiedAssetWithParty> getType() {
		return IdentifiedAssetWithParty.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IdentifiedAssetWithPartyBuilder extends IdentifiedAssetWithParty, Asset.AssetBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int index);
		@Override
		List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId();
		@Override
		IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder setId(String id);
		IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder setPartyReference(PartyReference partyReference);
		IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder addInstrumentId(InstrumentId instrumentId);
		IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder prune();
	}

	/*********************** Immutable Implementation of IdentifiedAssetWithParty  ***********************/
	class IdentifiedAssetWithPartyImpl extends Asset.AssetImpl implements IdentifiedAssetWithParty {
		private final PartyReference partyReference;
		private final List<? extends InstrumentId> instrumentId;
		private final String description;
		
		protected IdentifiedAssetWithPartyImpl(IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder builder) {
			super(builder);
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.instrumentId = ofNullable(builder.getInstrumentId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.description = builder.getDescription();
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
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		public List<? extends InstrumentId> getInstrumentId() {
			return instrumentId;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		public IdentifiedAssetWithParty build() {
			return this;
		}
		
		@Override
		public IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder toBuilder() {
			IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getInstrumentId()).ifPresent(builder::setInstrumentId);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedAssetWithParty _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedAssetWithParty {" +
				"partyReference=" + this.partyReference + ", " +
				"instrumentId=" + this.instrumentId + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of IdentifiedAssetWithParty  ***********************/
	class IdentifiedAssetWithPartyBuilderImpl extends Asset.AssetBuilderImpl implements IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected List<InstrumentId.InstrumentIdBuilder> instrumentId = new ArrayList<>();
		protected String description;
		
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
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		public List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId() {
			return instrumentId;
		}
		
		@Override
		public InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int index) {
			if (instrumentId==null) {
				this.instrumentId = new ArrayList<>();
			}
			return getIndex(instrumentId, index, () -> {
						InstrumentId.InstrumentIdBuilder newInstrumentId = InstrumentId.builder();
						return newInstrumentId;
					});
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public IdentifiedAssetWithParty build() {
			return new IdentifiedAssetWithParty.IdentifiedAssetWithPartyImpl(this);
		}
		
		@Override
		public IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder prune() {
			super.prune();
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			instrumentId = instrumentId.stream().filter(b->b!=null).<InstrumentId.InstrumentIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getInstrumentId()!=null && getInstrumentId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder o = (IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getInstrumentId(), o.getInstrumentId(), this::getOrCreateInstrumentId);
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedAssetWithParty _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedAssetWithPartyBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"instrumentId=" + this.instrumentId + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}
}

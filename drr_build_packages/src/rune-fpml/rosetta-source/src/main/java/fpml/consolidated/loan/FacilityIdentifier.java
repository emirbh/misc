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
import fpml.consolidated.loan.meta.FacilityIdentifierMeta;
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
 * Provision A unique identifier to a facility.
 *
 */
@RosettaDataType(value="FacilityIdentifier", builder=FacilityIdentifier.FacilityIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FacilityIdentifier", model="fpml", builder=FacilityIdentifier.FacilityIdentifierBuilderImpl.class, version="2.1.1")
public interface FacilityIdentifier extends IdentifiedAssetWithParty {

	FacilityIdentifierMeta metaData = new FacilityIdentifierMeta();

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
	DealReference getDealReference();

	/*********************** Build Methods  ***********************/
	FacilityIdentifier build();
	
	FacilityIdentifier.FacilityIdentifierBuilder toBuilder();
	
	static FacilityIdentifier.FacilityIdentifierBuilder builder() {
		return new FacilityIdentifier.FacilityIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FacilityIdentifier> getType() {
		return FacilityIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("dealReference"), processor, DealReference.class, getDealReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityIdentifierBuilder extends FacilityIdentifier, IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilder {
		DealReference.DealReferenceBuilder getOrCreateDealReference();
		@Override
		DealReference.DealReferenceBuilder getDealReference();
		@Override
		FacilityIdentifier.FacilityIdentifierBuilder setId(String id);
		@Override
		FacilityIdentifier.FacilityIdentifierBuilder setPartyReference(PartyReference partyReference);
		@Override
		FacilityIdentifier.FacilityIdentifierBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		FacilityIdentifier.FacilityIdentifierBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		FacilityIdentifier.FacilityIdentifierBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		FacilityIdentifier.FacilityIdentifierBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		FacilityIdentifier.FacilityIdentifierBuilder setDescription(String description);
		FacilityIdentifier.FacilityIdentifierBuilder setDealReference(DealReference dealReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("dealReference"), processor, DealReference.DealReferenceBuilder.class, getDealReference());
		}
		

		FacilityIdentifier.FacilityIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityIdentifier  ***********************/
	class FacilityIdentifierImpl extends IdentifiedAssetWithParty.IdentifiedAssetWithPartyImpl implements FacilityIdentifier {
		private final DealReference dealReference;
		
		protected FacilityIdentifierImpl(FacilityIdentifier.FacilityIdentifierBuilder builder) {
			super(builder);
			this.dealReference = ofNullable(builder.getDealReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealReference")
		public DealReference getDealReference() {
			return dealReference;
		}
		
		@Override
		public FacilityIdentifier build() {
			return this;
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder toBuilder() {
			FacilityIdentifier.FacilityIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityIdentifier.FacilityIdentifierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDealReference()).ifPresent(builder::setDealReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(dealReference, _that.getDealReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dealReference != null ? dealReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityIdentifier {" +
				"dealReference=" + this.dealReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityIdentifier  ***********************/
	class FacilityIdentifierBuilderImpl extends IdentifiedAssetWithParty.IdentifiedAssetWithPartyBuilderImpl implements FacilityIdentifier.FacilityIdentifierBuilder {
	
		protected DealReference.DealReferenceBuilder dealReference;
		
		@Override
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealReference")
		public DealReference.DealReferenceBuilder getDealReference() {
			return dealReference;
		}
		
		@Override
		public DealReference.DealReferenceBuilder getOrCreateDealReference() {
			DealReference.DealReferenceBuilder result;
			if (dealReference!=null) {
				result = dealReference;
			}
			else {
				result = dealReference = DealReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public FacilityIdentifier.FacilityIdentifierBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public FacilityIdentifier.FacilityIdentifierBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@Override
		public FacilityIdentifier build() {
			return new FacilityIdentifier.FacilityIdentifierImpl(this);
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder prune() {
			super.prune();
			if (dealReference!=null && !dealReference.prune().hasData()) dealReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDealReference()!=null && getDealReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FacilityIdentifier.FacilityIdentifierBuilder o = (FacilityIdentifier.FacilityIdentifierBuilder) other;
			
			merger.mergeRosetta(getDealReference(), o.getDealReference(), this::setDealReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(dealReference, _that.getDealReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dealReference != null ? dealReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityIdentifierBuilder {" +
				"dealReference=" + this.dealReference +
			'}' + " " + super.toString();
		}
	}
}

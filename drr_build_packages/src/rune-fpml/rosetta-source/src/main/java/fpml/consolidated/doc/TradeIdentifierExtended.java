package fpml.consolidated.doc;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.doc.meta.TradeIdentifierExtendedMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.TradeId;
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
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a trade identifier with a reference to the party that this trade is associated with.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a trade identifier with a reference to the party that this trade is associated with.
 *
 */
@RosettaDataType(value="TradeIdentifierExtended", builder=TradeIdentifierExtended.TradeIdentifierExtendedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeIdentifierExtended", model="fpml", builder=TradeIdentifierExtended.TradeIdentifierExtendedBuilderImpl.class, version="2.1.1")
public interface TradeIdentifierExtended extends TradeIdentifier {

	TradeIdentifierExtendedMeta metaData = new TradeIdentifierExtendedMeta();

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
	PartyReference getAssociatedPartyReference();

	/*********************** Build Methods  ***********************/
	TradeIdentifierExtended build();
	
	TradeIdentifierExtended.TradeIdentifierExtendedBuilder toBuilder();
	
	static TradeIdentifierExtended.TradeIdentifierExtendedBuilder builder() {
		return new TradeIdentifierExtended.TradeIdentifierExtendedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeIdentifierExtended> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeIdentifierExtended> getType() {
		return TradeIdentifierExtended.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("issuer"), processor, IssuerId.class, getIssuer());
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.class, getTradeIdentifierChoice());
		processRosetta(path.newSubPath("associatedPartyReference"), processor, PartyReference.class, getAssociatedPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeIdentifierExtendedBuilder extends TradeIdentifierExtended, TradeIdentifier.TradeIdentifierBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateAssociatedPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getAssociatedPartyReference();
		@Override
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder setId(String id);
		@Override
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder setIssuer(IssuerId issuer);
		@Override
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder setTradeId(TradeId tradeId);
		@Override
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder setPartyReference(PartyReference partyReference);
		@Override
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder setAccountReference(AccountReference accountReference);
		@Override
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice);
		@Override
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice, int idx);
		@Override
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		@Override
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder setAssociatedPartyReference(PartyReference associatedPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("issuer"), processor, IssuerId.IssuerIdBuilder.class, getIssuer());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.TradeIdentifierChoiceBuilder.class, getTradeIdentifierChoice());
			processRosetta(path.newSubPath("associatedPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAssociatedPartyReference());
		}
		

		TradeIdentifierExtended.TradeIdentifierExtendedBuilder prune();
	}

	/*********************** Immutable Implementation of TradeIdentifierExtended  ***********************/
	class TradeIdentifierExtendedImpl extends TradeIdentifier.TradeIdentifierImpl implements TradeIdentifierExtended {
		private final PartyReference associatedPartyReference;
		
		protected TradeIdentifierExtendedImpl(TradeIdentifierExtended.TradeIdentifierExtendedBuilder builder) {
			super(builder);
			this.associatedPartyReference = ofNullable(builder.getAssociatedPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("associatedPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("associatedPartyReference")
		public PartyReference getAssociatedPartyReference() {
			return associatedPartyReference;
		}
		
		@Override
		public TradeIdentifierExtended build() {
			return this;
		}
		
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder toBuilder() {
			TradeIdentifierExtended.TradeIdentifierExtendedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeIdentifierExtended.TradeIdentifierExtendedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAssociatedPartyReference()).ifPresent(builder::setAssociatedPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeIdentifierExtended _that = getType().cast(o);
		
			if (!Objects.equals(associatedPartyReference, _that.getAssociatedPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (associatedPartyReference != null ? associatedPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifierExtended {" +
				"associatedPartyReference=" + this.associatedPartyReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeIdentifierExtended  ***********************/
	class TradeIdentifierExtendedBuilderImpl extends TradeIdentifier.TradeIdentifierBuilderImpl implements TradeIdentifierExtended.TradeIdentifierExtendedBuilder {
	
		protected PartyReference.PartyReferenceBuilder associatedPartyReference;
		
		@Override
		@RosettaAttribute("associatedPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("associatedPartyReference")
		public PartyReference.PartyReferenceBuilder getAssociatedPartyReference() {
			return associatedPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAssociatedPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (associatedPartyReference!=null) {
				result = associatedPartyReference;
			}
			else {
				result = associatedPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("issuer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuer")
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder setIssuer(IssuerId _issuer) {
			this.issuer = _issuer == null ? null : _issuer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeId")
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder setTradeId(TradeId _tradeId) {
			this.tradeId = _tradeId == null ? null : _tradeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice) {
			if (_tradeIdentifierChoice != null) {
				this.tradeIdentifierChoice.add(_tradeIdentifierChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice, int idx) {
			getIndex(this.tradeIdentifierChoice, idx, () -> _tradeIdentifierChoice.toBuilder());
			return this;
		}
		
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
			if (tradeIdentifierChoices != null) {
				for (final TradeIdentifierChoice toAdd : tradeIdentifierChoices) {
					this.tradeIdentifierChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
			if (tradeIdentifierChoices == null) {
				this.tradeIdentifierChoice = new ArrayList<>();
			} else {
				this.tradeIdentifierChoice = tradeIdentifierChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("associatedPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("associatedPartyReference")
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder setAssociatedPartyReference(PartyReference _associatedPartyReference) {
			this.associatedPartyReference = _associatedPartyReference == null ? null : _associatedPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public TradeIdentifierExtended build() {
			return new TradeIdentifierExtended.TradeIdentifierExtendedImpl(this);
		}
		
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder prune() {
			super.prune();
			if (associatedPartyReference!=null && !associatedPartyReference.prune().hasData()) associatedPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAssociatedPartyReference()!=null && getAssociatedPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			TradeIdentifierExtended.TradeIdentifierExtendedBuilder o = (TradeIdentifierExtended.TradeIdentifierExtendedBuilder) other;
			
			merger.mergeRosetta(getAssociatedPartyReference(), o.getAssociatedPartyReference(), this::setAssociatedPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeIdentifierExtended _that = getType().cast(o);
		
			if (!Objects.equals(associatedPartyReference, _that.getAssociatedPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (associatedPartyReference != null ? associatedPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifierExtendedBuilder {" +
				"associatedPartyReference=" + this.associatedPartyReference +
			'}' + " " + super.toString();
		}
	}
}

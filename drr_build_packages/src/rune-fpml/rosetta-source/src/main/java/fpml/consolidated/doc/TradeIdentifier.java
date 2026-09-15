package fpml.consolidated.doc;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.doc.meta.TradeIdentifierMeta;
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
 * Provision A type defining a trade identifier issued by the indicated party.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a trade identifier issued by the indicated party.
 *
 */
@RosettaDataType(value="TradeIdentifier", builder=TradeIdentifier.TradeIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeIdentifier", model="fpml", builder=TradeIdentifier.TradeIdentifierBuilderImpl.class, version="2.1.1")
public interface TradeIdentifier extends RosettaModelObject {

	TradeIdentifierMeta metaData = new TradeIdentifierMeta();

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
	IssuerId getIssuer();
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
	TradeId getTradeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a party.
	 *
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
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 */
	AccountReference getAccountReference();
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
	List<? extends TradeIdentifierChoice> getTradeIdentifierChoice();

	/*********************** Build Methods  ***********************/
	TradeIdentifier build();
	
	TradeIdentifier.TradeIdentifierBuilder toBuilder();
	
	static TradeIdentifier.TradeIdentifierBuilder builder() {
		return new TradeIdentifier.TradeIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeIdentifier> getType() {
		return TradeIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("issuer"), processor, IssuerId.class, getIssuer());
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.class, getTradeIdentifierChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeIdentifierBuilder extends TradeIdentifier, RosettaModelObjectBuilder {
		IssuerId.IssuerIdBuilder getOrCreateIssuer();
		@Override
		IssuerId.IssuerIdBuilder getIssuer();
		TradeId.TradeIdBuilder getOrCreateTradeId();
		@Override
		TradeId.TradeIdBuilder getTradeId();
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getAccountReference();
		TradeIdentifierChoice.TradeIdentifierChoiceBuilder getOrCreateTradeIdentifierChoice(int index);
		@Override
		List<? extends TradeIdentifierChoice.TradeIdentifierChoiceBuilder> getTradeIdentifierChoice();
		TradeIdentifier.TradeIdentifierBuilder setId(String id);
		TradeIdentifier.TradeIdentifierBuilder setIssuer(IssuerId issuer);
		TradeIdentifier.TradeIdentifierBuilder setTradeId(TradeId tradeId);
		TradeIdentifier.TradeIdentifierBuilder setPartyReference(PartyReference partyReference);
		TradeIdentifier.TradeIdentifierBuilder setAccountReference(AccountReference accountReference);
		TradeIdentifier.TradeIdentifierBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice);
		TradeIdentifier.TradeIdentifierBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice, int idx);
		TradeIdentifier.TradeIdentifierBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		TradeIdentifier.TradeIdentifierBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("issuer"), processor, IssuerId.IssuerIdBuilder.class, getIssuer());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.TradeIdentifierChoiceBuilder.class, getTradeIdentifierChoice());
		}
		

		TradeIdentifier.TradeIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of TradeIdentifier  ***********************/
	class TradeIdentifierImpl implements TradeIdentifier {
		private final String id;
		private final IssuerId issuer;
		private final TradeId tradeId;
		private final PartyReference partyReference;
		private final AccountReference accountReference;
		private final List<? extends TradeIdentifierChoice> tradeIdentifierChoice;
		
		protected TradeIdentifierImpl(TradeIdentifier.TradeIdentifierBuilder builder) {
			this.id = builder.getId();
			this.issuer = ofNullable(builder.getIssuer()).map(f->f.build()).orElse(null);
			this.tradeId = ofNullable(builder.getTradeId()).map(f->f.build()).orElse(null);
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.accountReference = ofNullable(builder.getAccountReference()).map(f->f.build()).orElse(null);
			this.tradeIdentifierChoice = ofNullable(builder.getTradeIdentifierChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("issuer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issuer")
		public IssuerId getIssuer() {
			return issuer;
		}
		
		@Override
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeId")
		public TradeId getTradeId() {
			return tradeId;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference getAccountReference() {
			return accountReference;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		public List<? extends TradeIdentifierChoice> getTradeIdentifierChoice() {
			return tradeIdentifierChoice;
		}
		
		@Override
		public TradeIdentifier build() {
			return this;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder toBuilder() {
			TradeIdentifier.TradeIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeIdentifier.TradeIdentifierBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getIssuer()).ifPresent(builder::setIssuer);
			ofNullable(getTradeId()).ifPresent(builder::setTradeId);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
			ofNullable(getTradeIdentifierChoice()).ifPresent(builder::setTradeIdentifierChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(issuer, _that.getIssuer())) return false;
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!ListEquals.listEquals(tradeIdentifierChoice, _that.getTradeIdentifierChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifierChoice != null ? tradeIdentifierChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifier {" +
				"id=" + this.id + ", " +
				"issuer=" + this.issuer + ", " +
				"tradeId=" + this.tradeId + ", " +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"tradeIdentifierChoice=" + this.tradeIdentifierChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeIdentifier  ***********************/
	class TradeIdentifierBuilderImpl implements TradeIdentifier.TradeIdentifierBuilder {
	
		protected String id;
		protected IssuerId.IssuerIdBuilder issuer;
		protected TradeId.TradeIdBuilder tradeId;
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected AccountReference.AccountReferenceBuilder accountReference;
		protected List<TradeIdentifierChoice.TradeIdentifierChoiceBuilder> tradeIdentifierChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("issuer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issuer")
		public IssuerId.IssuerIdBuilder getIssuer() {
			return issuer;
		}
		
		@Override
		public IssuerId.IssuerIdBuilder getOrCreateIssuer() {
			IssuerId.IssuerIdBuilder result;
			if (issuer!=null) {
				result = issuer;
			}
			else {
				result = issuer = IssuerId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeId")
		public TradeId.TradeIdBuilder getTradeId() {
			return tradeId;
		}
		
		@Override
		public TradeId.TradeIdBuilder getOrCreateTradeId() {
			TradeId.TradeIdBuilder result;
			if (tradeId!=null) {
				result = tradeId;
			}
			else {
				result = tradeId = TradeId.builder();
			}
			
			return result;
		}
		
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
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference.AccountReferenceBuilder getAccountReference() {
			return accountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (accountReference!=null) {
				result = accountReference;
			}
			else {
				result = accountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		public List<? extends TradeIdentifierChoice.TradeIdentifierChoiceBuilder> getTradeIdentifierChoice() {
			return tradeIdentifierChoice;
		}
		
		@Override
		public TradeIdentifierChoice.TradeIdentifierChoiceBuilder getOrCreateTradeIdentifierChoice(int index) {
			if (tradeIdentifierChoice==null) {
				this.tradeIdentifierChoice = new ArrayList<>();
			}
			return getIndex(tradeIdentifierChoice, index, () -> {
						TradeIdentifierChoice.TradeIdentifierChoiceBuilder newTradeIdentifierChoice = TradeIdentifierChoice.builder();
						return newTradeIdentifierChoice;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public TradeIdentifier.TradeIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("issuer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuer")
		@Override
		public TradeIdentifier.TradeIdentifierBuilder setIssuer(IssuerId _issuer) {
			this.issuer = _issuer == null ? null : _issuer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeId")
		@Override
		public TradeIdentifier.TradeIdentifierBuilder setTradeId(TradeId _tradeId) {
			this.tradeId = _tradeId == null ? null : _tradeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public TradeIdentifier.TradeIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public TradeIdentifier.TradeIdentifierBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		@Override
		public TradeIdentifier.TradeIdentifierBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice) {
			if (_tradeIdentifierChoice != null) {
				this.tradeIdentifierChoice.add(_tradeIdentifierChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice, int idx) {
			getIndex(this.tradeIdentifierChoice, idx, () -> _tradeIdentifierChoice.toBuilder());
			return this;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
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
		public TradeIdentifier.TradeIdentifierBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
			if (tradeIdentifierChoices == null) {
				this.tradeIdentifierChoice = new ArrayList<>();
			} else {
				this.tradeIdentifierChoice = tradeIdentifierChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TradeIdentifier build() {
			return new TradeIdentifier.TradeIdentifierImpl(this);
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifier.TradeIdentifierBuilder prune() {
			if (issuer!=null && !issuer.prune().hasData()) issuer = null;
			if (tradeId!=null && !tradeId.prune().hasData()) tradeId = null;
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (accountReference!=null && !accountReference.prune().hasData()) accountReference = null;
			tradeIdentifierChoice = tradeIdentifierChoice.stream().filter(b->b!=null).<TradeIdentifierChoice.TradeIdentifierChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getIssuer()!=null && getIssuer().hasData()) return true;
			if (getTradeId()!=null && getTradeId().hasData()) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getAccountReference()!=null && getAccountReference().hasData()) return true;
			if (getTradeIdentifierChoice()!=null && getTradeIdentifierChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifier.TradeIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeIdentifier.TradeIdentifierBuilder o = (TradeIdentifier.TradeIdentifierBuilder) other;
			
			merger.mergeRosetta(getIssuer(), o.getIssuer(), this::setIssuer);
			merger.mergeRosetta(getTradeId(), o.getTradeId(), this::setTradeId);
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::setAccountReference);
			merger.mergeRosetta(getTradeIdentifierChoice(), o.getTradeIdentifierChoice(), this::getOrCreateTradeIdentifierChoice);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(issuer, _that.getIssuer())) return false;
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!ListEquals.listEquals(tradeIdentifierChoice, _that.getTradeIdentifierChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (issuer != null ? issuer.hashCode() : 0);
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifierChoice != null ? tradeIdentifierChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifierBuilder {" +
				"id=" + this.id + ", " +
				"issuer=" + this.issuer + ", " +
				"tradeId=" + this.tradeId + ", " +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"tradeIdentifierChoice=" + this.tradeIdentifierChoice +
			'}';
		}
	}
}

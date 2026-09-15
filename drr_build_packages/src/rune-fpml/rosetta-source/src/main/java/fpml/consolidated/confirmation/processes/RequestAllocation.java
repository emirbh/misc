package fpml.consolidated.confirmation.processes;

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
import fpml.consolidated.confirmation.processes.meta.RequestAllocationMeta;
import fpml.consolidated.doc.Allocations;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrectableRequestMessage;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.RelatedParty;
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
 * Provision A message requesting that a trade be split among several accounts.
 *
 */
@RosettaDataType(value="RequestAllocation", builder=RequestAllocation.RequestAllocationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequestAllocation", model="fpml", builder=RequestAllocation.RequestAllocationBuilderImpl.class, version="2.1.1")
public interface RequestAllocation extends CorrectableRequestMessage {

	RequestAllocationMeta metaData = new RequestAllocationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies a related party performing a role within the transaction.
	 *
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeIdentifier getBlockTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Allocations getAllocations();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A legal entity or a subdivision of a legal entity. Parties can perform multiple roles in a trade lifecycle. For example, the principal parties obligated to make payments from time to time during the term of the trade, but may include other parties involved in, or incidental to, the trade, such as parties acting in the role of novation transferor/transferee, broker, calculation agent, etc. In FpML roles are defined in multiple places within a document.
	 *
	 */
	List<? extends Party> getParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Optional account information used to precisely define the origination and destination of financial instruments.
	 *
	 */
	List<? extends Account> getAccount();

	/*********************** Build Methods  ***********************/
	RequestAllocation build();
	
	RequestAllocation.RequestAllocationBuilder toBuilder();
	
	static RequestAllocation.RequestAllocationBuilder builder() {
		return new RequestAllocation.RequestAllocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestAllocation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequestAllocation> getType() {
		return RequestAllocation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("blockTradeIdentifier"), processor, TradeIdentifier.class, getBlockTradeIdentifier());
		processRosetta(path.newSubPath("allocations"), processor, Allocations.class, getAllocations());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestAllocationBuilder extends RequestAllocation, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateBlockTradeIdentifier();
		@Override
		TradeIdentifier.TradeIdentifierBuilder getBlockTradeIdentifier();
		Allocations.AllocationsBuilder getOrCreateAllocations();
		@Override
		Allocations.AllocationsBuilder getAllocations();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		RequestAllocation.RequestAllocationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RequestAllocation.RequestAllocationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RequestAllocation.RequestAllocationBuilder setActualBuild(Integer actualBuild);
		@Override
		RequestAllocation.RequestAllocationBuilder setHeader(RequestMessageHeader header);
		@Override
		RequestAllocation.RequestAllocationBuilder addValidation(Validation validation);
		@Override
		RequestAllocation.RequestAllocationBuilder addValidation(Validation validation, int idx);
		@Override
		RequestAllocation.RequestAllocationBuilder addValidation(List<? extends Validation> validation);
		@Override
		RequestAllocation.RequestAllocationBuilder setValidation(List<? extends Validation> validation);
		@Override
		RequestAllocation.RequestAllocationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		RequestAllocation.RequestAllocationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		RequestAllocation.RequestAllocationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		RequestAllocation.RequestAllocationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		RequestAllocation.RequestAllocationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestAllocation.RequestAllocationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestAllocation.RequestAllocationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		RequestAllocation.RequestAllocationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		RequestAllocation.RequestAllocationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		RequestAllocation.RequestAllocationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		RequestAllocation.RequestAllocationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		RequestAllocation.RequestAllocationBuilder addRelatedParty(RelatedParty relatedParty);
		RequestAllocation.RequestAllocationBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		RequestAllocation.RequestAllocationBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		RequestAllocation.RequestAllocationBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		RequestAllocation.RequestAllocationBuilder setBlockTradeIdentifier(TradeIdentifier blockTradeIdentifier);
		RequestAllocation.RequestAllocationBuilder setAllocations(Allocations allocations);
		RequestAllocation.RequestAllocationBuilder addParty(Party party);
		RequestAllocation.RequestAllocationBuilder addParty(Party party, int idx);
		RequestAllocation.RequestAllocationBuilder addParty(List<? extends Party> party);
		RequestAllocation.RequestAllocationBuilder setParty(List<? extends Party> party);
		RequestAllocation.RequestAllocationBuilder addAccount(Account account);
		RequestAllocation.RequestAllocationBuilder addAccount(Account account, int idx);
		RequestAllocation.RequestAllocationBuilder addAccount(List<? extends Account> account);
		RequestAllocation.RequestAllocationBuilder setAccount(List<? extends Account> account);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("blockTradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getBlockTradeIdentifier());
			processRosetta(path.newSubPath("allocations"), processor, Allocations.AllocationsBuilder.class, getAllocations());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		RequestAllocation.RequestAllocationBuilder prune();
	}

	/*********************** Immutable Implementation of RequestAllocation  ***********************/
	class RequestAllocationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements RequestAllocation {
		private final List<? extends RelatedParty> relatedParty;
		private final TradeIdentifier blockTradeIdentifier;
		private final Allocations allocations;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected RequestAllocationImpl(RequestAllocation.RequestAllocationBuilder builder) {
			super(builder);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.blockTradeIdentifier = ofNullable(builder.getBlockTradeIdentifier()).map(f->f.build()).orElse(null);
			this.allocations = ofNullable(builder.getAllocations()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		@RosettaAttribute("blockTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("blockTradeIdentifier")
		public TradeIdentifier getBlockTradeIdentifier() {
			return blockTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("allocations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("allocations")
		public Allocations getAllocations() {
			return allocations;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("account")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("account")
		public List<? extends Account> getAccount() {
			return account;
		}
		
		@Override
		public RequestAllocation build() {
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder toBuilder() {
			RequestAllocation.RequestAllocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestAllocation.RequestAllocationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getBlockTradeIdentifier()).ifPresent(builder::setBlockTradeIdentifier);
			ofNullable(getAllocations()).ifPresent(builder::setAllocations);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestAllocation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(blockTradeIdentifier, _that.getBlockTradeIdentifier())) return false;
			if (!Objects.equals(allocations, _that.getAllocations())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (blockTradeIdentifier != null ? blockTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestAllocation {" +
				"relatedParty=" + this.relatedParty + ", " +
				"blockTradeIdentifier=" + this.blockTradeIdentifier + ", " +
				"allocations=" + this.allocations + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestAllocation  ***********************/
	class RequestAllocationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl implements RequestAllocation.RequestAllocationBuilder {
	
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected TradeIdentifier.TradeIdentifierBuilder blockTradeIdentifier;
		protected Allocations.AllocationsBuilder allocations;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index) {
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			return getIndex(relatedParty, index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("blockTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("blockTradeIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getBlockTradeIdentifier() {
			return blockTradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateBlockTradeIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (blockTradeIdentifier!=null) {
				result = blockTradeIdentifier;
			}
			else {
				result = blockTradeIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("allocations")
		public Allocations.AllocationsBuilder getAllocations() {
			return allocations;
		}
		
		@Override
		public Allocations.AllocationsBuilder getOrCreateAllocations() {
			Allocations.AllocationsBuilder result;
			if (allocations!=null) {
				result = allocations;
			}
			else {
				result = allocations = Allocations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty(int index) {
			if (party==null) {
				this.party = new ArrayList<>();
			}
			return getIndex(party, index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@Override
		@RosettaAttribute("account")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("account")
		public List<? extends Account.AccountBuilder> getAccount() {
			return account;
		}
		
		@Override
		public Account.AccountBuilder getOrCreateAccount(int index) {
			if (account==null) {
				this.account = new ArrayList<>();
			}
			return getIndex(account, index, () -> {
						Account.AccountBuilder newAccount = Account.builder();
						return newAccount;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public RequestAllocation.RequestAllocationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RequestAllocation.RequestAllocationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RequestAllocation.RequestAllocationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RequestAllocation.RequestAllocationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public RequestAllocation.RequestAllocationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder addValidation(List<? extends Validation> validations) {
			if (validations != null) {
				for (final Validation toAdd : validations) {
					this.validation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public RequestAllocation.RequestAllocationBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("isCorrection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCorrection")
		@Override
		public RequestAllocation.RequestAllocationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public RequestAllocation.RequestAllocationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public RequestAllocation.RequestAllocationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds != null) {
				for (final CorrelationId toAdd : correlationIds) {
					this.correlationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public RequestAllocation.RequestAllocationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds == null) {
				this.correlationId = new ArrayList<>();
			} else {
				this.correlationId = correlationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sequenceNumber")
		@Override
		public RequestAllocation.RequestAllocationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RequestAllocation.RequestAllocationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs != null) {
				for (final OnBehalfOf toAdd : onBehalfOfs) {
					this.onBehalfOf.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RequestAllocation.RequestAllocationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public RequestAllocation.RequestAllocationBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (final RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public RequestAllocation.RequestAllocationBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null) {
				this.relatedParty = new ArrayList<>();
			} else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("blockTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("blockTradeIdentifier")
		@Override
		public RequestAllocation.RequestAllocationBuilder setBlockTradeIdentifier(TradeIdentifier _blockTradeIdentifier) {
			this.blockTradeIdentifier = _blockTradeIdentifier == null ? null : _blockTradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("allocations")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("allocations")
		@Override
		public RequestAllocation.RequestAllocationBuilder setAllocations(Allocations _allocations) {
			this.allocations = _allocations == null ? null : _allocations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public RequestAllocation.RequestAllocationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public RequestAllocation.RequestAllocationBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("account")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("account")
		@Override
		public RequestAllocation.RequestAllocationBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder addAccount(List<? extends Account> accounts) {
			if (accounts != null) {
				for (final Account toAdd : accounts) {
					this.account.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("account")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("account")
		@Override
		public RequestAllocation.RequestAllocationBuilder setAccount(List<? extends Account> accounts) {
			if (accounts == null) {
				this.account = new ArrayList<>();
			} else {
				this.account = accounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RequestAllocation build() {
			return new RequestAllocation.RequestAllocationImpl(this);
		}
		
		@Override
		public RequestAllocation.RequestAllocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestAllocation.RequestAllocationBuilder prune() {
			super.prune();
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (blockTradeIdentifier!=null && !blockTradeIdentifier.prune().hasData()) blockTradeIdentifier = null;
			if (allocations!=null && !allocations.prune().hasData()) allocations = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBlockTradeIdentifier()!=null && getBlockTradeIdentifier().hasData()) return true;
			if (getAllocations()!=null && getAllocations().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestAllocation.RequestAllocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RequestAllocation.RequestAllocationBuilder o = (RequestAllocation.RequestAllocationBuilder) other;
			
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getBlockTradeIdentifier(), o.getBlockTradeIdentifier(), this::setBlockTradeIdentifier);
			merger.mergeRosetta(getAllocations(), o.getAllocations(), this::setAllocations);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestAllocation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(blockTradeIdentifier, _that.getBlockTradeIdentifier())) return false;
			if (!Objects.equals(allocations, _that.getAllocations())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (blockTradeIdentifier != null ? blockTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestAllocationBuilder {" +
				"relatedParty=" + this.relatedParty + ", " +
				"blockTradeIdentifier=" + this.blockTradeIdentifier + ", " +
				"allocations=" + this.allocations + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

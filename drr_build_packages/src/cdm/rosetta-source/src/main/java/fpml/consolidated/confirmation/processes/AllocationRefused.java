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
import fpml.consolidated.confirmation.processes.meta.AllocationRefusedMeta;
import fpml.consolidated.doc.Allocations;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.ResponseMessage;
import fpml.consolidated.msg.ResponseMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
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
 * Provision A message indicating that a request to allocate a trade has been refused by the sender.
 *
 */
@RosettaDataType(value="AllocationRefused", builder=AllocationRefused.AllocationRefusedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AllocationRefused", model="fpml", builder=AllocationRefused.AllocationRefusedBuilderImpl.class, version="2.1.1")
public interface AllocationRefused extends ResponseMessage {

	AllocationRefusedMeta metaData = new AllocationRefusedMeta();

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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends Reason> getReason();

	/*********************** Build Methods  ***********************/
	AllocationRefused build();
	
	AllocationRefused.AllocationRefusedBuilder toBuilder();
	
	static AllocationRefused.AllocationRefusedBuilder builder() {
		return new AllocationRefused.AllocationRefusedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AllocationRefused> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AllocationRefused> getType() {
		return AllocationRefused.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("blockTradeIdentifier"), processor, TradeIdentifier.class, getBlockTradeIdentifier());
		processRosetta(path.newSubPath("allocations"), processor, Allocations.class, getAllocations());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AllocationRefusedBuilder extends AllocationRefused, ResponseMessage.ResponseMessageBuilder {
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
		Reason.ReasonBuilder getOrCreateReason(int index);
		@Override
		List<? extends Reason.ReasonBuilder> getReason();
		@Override
		AllocationRefused.AllocationRefusedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		AllocationRefused.AllocationRefusedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		AllocationRefused.AllocationRefusedBuilder setActualBuild(Integer actualBuild);
		@Override
		AllocationRefused.AllocationRefusedBuilder setHeader(ResponseMessageHeader header);
		@Override
		AllocationRefused.AllocationRefusedBuilder addValidation(Validation validation);
		@Override
		AllocationRefused.AllocationRefusedBuilder addValidation(Validation validation, int idx);
		@Override
		AllocationRefused.AllocationRefusedBuilder addValidation(List<? extends Validation> validation);
		@Override
		AllocationRefused.AllocationRefusedBuilder setValidation(List<? extends Validation> validation);
		@Override
		AllocationRefused.AllocationRefusedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		AllocationRefused.AllocationRefusedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		AllocationRefused.AllocationRefusedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		AllocationRefused.AllocationRefusedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AllocationRefused.AllocationRefusedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AllocationRefused.AllocationRefusedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		AllocationRefused.AllocationRefusedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		AllocationRefused.AllocationRefusedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		AllocationRefused.AllocationRefusedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		AllocationRefused.AllocationRefusedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		AllocationRefused.AllocationRefusedBuilder setBlockTradeIdentifier(TradeIdentifier blockTradeIdentifier);
		AllocationRefused.AllocationRefusedBuilder setAllocations(Allocations allocations);
		AllocationRefused.AllocationRefusedBuilder addParty(Party party);
		AllocationRefused.AllocationRefusedBuilder addParty(Party party, int idx);
		AllocationRefused.AllocationRefusedBuilder addParty(List<? extends Party> party);
		AllocationRefused.AllocationRefusedBuilder setParty(List<? extends Party> party);
		AllocationRefused.AllocationRefusedBuilder addAccount(Account account);
		AllocationRefused.AllocationRefusedBuilder addAccount(Account account, int idx);
		AllocationRefused.AllocationRefusedBuilder addAccount(List<? extends Account> account);
		AllocationRefused.AllocationRefusedBuilder setAccount(List<? extends Account> account);
		AllocationRefused.AllocationRefusedBuilder addReason(Reason reason);
		AllocationRefused.AllocationRefusedBuilder addReason(Reason reason, int idx);
		AllocationRefused.AllocationRefusedBuilder addReason(List<? extends Reason> reason);
		AllocationRefused.AllocationRefusedBuilder setReason(List<? extends Reason> reason);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("blockTradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getBlockTradeIdentifier());
			processRosetta(path.newSubPath("allocations"), processor, Allocations.AllocationsBuilder.class, getAllocations());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
		}
		

		AllocationRefused.AllocationRefusedBuilder prune();
	}

	/*********************** Immutable Implementation of AllocationRefused  ***********************/
	class AllocationRefusedImpl extends ResponseMessage.ResponseMessageImpl implements AllocationRefused {
		private final TradeIdentifier blockTradeIdentifier;
		private final Allocations allocations;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		private final List<? extends Reason> reason;
		
		protected AllocationRefusedImpl(AllocationRefused.AllocationRefusedBuilder builder) {
			super(builder);
			this.blockTradeIdentifier = ofNullable(builder.getBlockTradeIdentifier()).map(f->f.build()).orElse(null);
			this.allocations = ofNullable(builder.getAllocations()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("blockTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("blockTradeIdentifier")
		public TradeIdentifier getBlockTradeIdentifier() {
			return blockTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("allocations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocations")
		public Allocations getAllocations() {
			return allocations;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends Reason> getReason() {
			return reason;
		}
		
		@Override
		public AllocationRefused build() {
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder toBuilder() {
			AllocationRefused.AllocationRefusedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AllocationRefused.AllocationRefusedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBlockTradeIdentifier()).ifPresent(builder::setBlockTradeIdentifier);
			ofNullable(getAllocations()).ifPresent(builder::setAllocations);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
			ofNullable(getReason()).ifPresent(builder::setReason);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AllocationRefused _that = getType().cast(o);
		
			if (!Objects.equals(blockTradeIdentifier, _that.getBlockTradeIdentifier())) return false;
			if (!Objects.equals(allocations, _that.getAllocations())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (blockTradeIdentifier != null ? blockTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationRefused {" +
				"blockTradeIdentifier=" + this.blockTradeIdentifier + ", " +
				"allocations=" + this.allocations + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account + ", " +
				"reason=" + this.reason +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AllocationRefused  ***********************/
	class AllocationRefusedBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl implements AllocationRefused.AllocationRefusedBuilder {
	
		protected TradeIdentifier.TradeIdentifierBuilder blockTradeIdentifier;
		protected Allocations.AllocationsBuilder allocations;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
		
		@Override
		@RosettaAttribute("blockTradeIdentifier")
		@Accessor(AccessorType.GETTER)
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
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends Reason.ReasonBuilder> getReason() {
			return reason;
		}
		
		@Override
		public Reason.ReasonBuilder getOrCreateReason(int index) {
			if (reason==null) {
				this.reason = new ArrayList<>();
			}
			return getIndex(reason, index, () -> {
						Reason.ReasonBuilder newReason = Reason.builder();
						return newReason;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public AllocationRefused.AllocationRefusedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public AllocationRefused.AllocationRefusedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public AllocationRefused.AllocationRefusedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public AllocationRefused.AllocationRefusedBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public AllocationRefused.AllocationRefusedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder addValidation(List<? extends Validation> validations) {
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
		public AllocationRefused.AllocationRefusedBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public AllocationRefused.AllocationRefusedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public AllocationRefused.AllocationRefusedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AllocationRefused.AllocationRefusedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AllocationRefused.AllocationRefusedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public AllocationRefused.AllocationRefusedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public AllocationRefused.AllocationRefusedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("blockTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("blockTradeIdentifier")
		@Override
		public AllocationRefused.AllocationRefusedBuilder setBlockTradeIdentifier(TradeIdentifier _blockTradeIdentifier) {
			this.blockTradeIdentifier = _blockTradeIdentifier == null ? null : _blockTradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("allocations")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allocations")
		@Override
		public AllocationRefused.AllocationRefusedBuilder setAllocations(Allocations _allocations) {
			this.allocations = _allocations == null ? null : _allocations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public AllocationRefused.AllocationRefusedBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("party")
		@Override
		public AllocationRefused.AllocationRefusedBuilder setParty(List<? extends Party> partys) {
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
		public AllocationRefused.AllocationRefusedBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder addAccount(List<? extends Account> accounts) {
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
		public AllocationRefused.AllocationRefusedBuilder setAccount(List<? extends Account> accounts) {
			if (accounts == null) {
				this.account = new ArrayList<>();
			} else {
				this.account = accounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public AllocationRefused.AllocationRefusedBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (final Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public AllocationRefused.AllocationRefusedBuilder setReason(List<? extends Reason> reasons) {
			if (reasons == null) {
				this.reason = new ArrayList<>();
			} else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AllocationRefused build() {
			return new AllocationRefused.AllocationRefusedImpl(this);
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationRefused.AllocationRefusedBuilder prune() {
			super.prune();
			if (blockTradeIdentifier!=null && !blockTradeIdentifier.prune().hasData()) blockTradeIdentifier = null;
			if (allocations!=null && !allocations.prune().hasData()) allocations = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBlockTradeIdentifier()!=null && getBlockTradeIdentifier().hasData()) return true;
			if (getAllocations()!=null && getAllocations().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationRefused.AllocationRefusedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AllocationRefused.AllocationRefusedBuilder o = (AllocationRefused.AllocationRefusedBuilder) other;
			
			merger.mergeRosetta(getBlockTradeIdentifier(), o.getBlockTradeIdentifier(), this::setBlockTradeIdentifier);
			merger.mergeRosetta(getAllocations(), o.getAllocations(), this::setAllocations);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AllocationRefused _that = getType().cast(o);
		
			if (!Objects.equals(blockTradeIdentifier, _that.getBlockTradeIdentifier())) return false;
			if (!Objects.equals(allocations, _that.getAllocations())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (blockTradeIdentifier != null ? blockTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationRefusedBuilder {" +
				"blockTradeIdentifier=" + this.blockTradeIdentifier + ", " +
				"allocations=" + this.allocations + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account + ", " +
				"reason=" + this.reason +
			'}' + " " + super.toString();
		}
	}
}

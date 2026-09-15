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
import fpml.consolidated.confirmation.processes.meta.AllocationApprovedMeta;
import fpml.consolidated.doc.Allocations;
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
 * Provision A message indicating that a request to allocate a trade has been approved by the sender.
 *
 */
@RosettaDataType(value="AllocationApproved", builder=AllocationApproved.AllocationApprovedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AllocationApproved", model="fpml", builder=AllocationApproved.AllocationApprovedBuilderImpl.class, version="2.1.1")
public interface AllocationApproved extends ResponseMessage {

	AllocationApprovedMeta metaData = new AllocationApprovedMeta();

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

	/*********************** Build Methods  ***********************/
	AllocationApproved build();
	
	AllocationApproved.AllocationApprovedBuilder toBuilder();
	
	static AllocationApproved.AllocationApprovedBuilder builder() {
		return new AllocationApproved.AllocationApprovedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AllocationApproved> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AllocationApproved> getType() {
		return AllocationApproved.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface AllocationApprovedBuilder extends AllocationApproved, ResponseMessage.ResponseMessageBuilder {
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
		AllocationApproved.AllocationApprovedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		AllocationApproved.AllocationApprovedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		AllocationApproved.AllocationApprovedBuilder setActualBuild(Integer actualBuild);
		@Override
		AllocationApproved.AllocationApprovedBuilder setHeader(ResponseMessageHeader header);
		@Override
		AllocationApproved.AllocationApprovedBuilder addValidation(Validation validation);
		@Override
		AllocationApproved.AllocationApprovedBuilder addValidation(Validation validation, int idx);
		@Override
		AllocationApproved.AllocationApprovedBuilder addValidation(List<? extends Validation> validation);
		@Override
		AllocationApproved.AllocationApprovedBuilder setValidation(List<? extends Validation> validation);
		@Override
		AllocationApproved.AllocationApprovedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		AllocationApproved.AllocationApprovedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		AllocationApproved.AllocationApprovedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		AllocationApproved.AllocationApprovedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AllocationApproved.AllocationApprovedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		AllocationApproved.AllocationApprovedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		AllocationApproved.AllocationApprovedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		AllocationApproved.AllocationApprovedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		AllocationApproved.AllocationApprovedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		AllocationApproved.AllocationApprovedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		AllocationApproved.AllocationApprovedBuilder setBlockTradeIdentifier(TradeIdentifier blockTradeIdentifier);
		AllocationApproved.AllocationApprovedBuilder setAllocations(Allocations allocations);
		AllocationApproved.AllocationApprovedBuilder addParty(Party party);
		AllocationApproved.AllocationApprovedBuilder addParty(Party party, int idx);
		AllocationApproved.AllocationApprovedBuilder addParty(List<? extends Party> party);
		AllocationApproved.AllocationApprovedBuilder setParty(List<? extends Party> party);
		AllocationApproved.AllocationApprovedBuilder addAccount(Account account);
		AllocationApproved.AllocationApprovedBuilder addAccount(Account account, int idx);
		AllocationApproved.AllocationApprovedBuilder addAccount(List<? extends Account> account);
		AllocationApproved.AllocationApprovedBuilder setAccount(List<? extends Account> account);

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
		}
		

		AllocationApproved.AllocationApprovedBuilder prune();
	}

	/*********************** Immutable Implementation of AllocationApproved  ***********************/
	class AllocationApprovedImpl extends ResponseMessage.ResponseMessageImpl implements AllocationApproved {
		private final TradeIdentifier blockTradeIdentifier;
		private final Allocations allocations;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected AllocationApprovedImpl(AllocationApproved.AllocationApprovedBuilder builder) {
			super(builder);
			this.blockTradeIdentifier = ofNullable(builder.getBlockTradeIdentifier()).map(f->f.build()).orElse(null);
			this.allocations = ofNullable(builder.getAllocations()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		public AllocationApproved build() {
			return this;
		}
		
		@Override
		public AllocationApproved.AllocationApprovedBuilder toBuilder() {
			AllocationApproved.AllocationApprovedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AllocationApproved.AllocationApprovedBuilder builder) {
			super.setBuilderFields(builder);
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
		
			AllocationApproved _that = getType().cast(o);
		
			if (!Objects.equals(blockTradeIdentifier, _that.getBlockTradeIdentifier())) return false;
			if (!Objects.equals(allocations, _that.getAllocations())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (blockTradeIdentifier != null ? blockTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationApproved {" +
				"blockTradeIdentifier=" + this.blockTradeIdentifier + ", " +
				"allocations=" + this.allocations + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AllocationApproved  ***********************/
	class AllocationApprovedBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl implements AllocationApproved.AllocationApprovedBuilder {
	
		protected TradeIdentifier.TradeIdentifierBuilder blockTradeIdentifier;
		protected Allocations.AllocationsBuilder allocations;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
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
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public AllocationApproved.AllocationApprovedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public AllocationApproved.AllocationApprovedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public AllocationApproved.AllocationApprovedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public AllocationApproved.AllocationApprovedBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public AllocationApproved.AllocationApprovedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public AllocationApproved.AllocationApprovedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public AllocationApproved.AllocationApprovedBuilder addValidation(List<? extends Validation> validations) {
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
		public AllocationApproved.AllocationApprovedBuilder setValidation(List<? extends Validation> validations) {
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
		public AllocationApproved.AllocationApprovedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public AllocationApproved.AllocationApprovedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public AllocationApproved.AllocationApprovedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public AllocationApproved.AllocationApprovedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AllocationApproved.AllocationApprovedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public AllocationApproved.AllocationApprovedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public AllocationApproved.AllocationApprovedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public AllocationApproved.AllocationApprovedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public AllocationApproved.AllocationApprovedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public AllocationApproved.AllocationApprovedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public AllocationApproved.AllocationApprovedBuilder setBlockTradeIdentifier(TradeIdentifier _blockTradeIdentifier) {
			this.blockTradeIdentifier = _blockTradeIdentifier == null ? null : _blockTradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("allocations")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allocations")
		@Override
		public AllocationApproved.AllocationApprovedBuilder setAllocations(Allocations _allocations) {
			this.allocations = _allocations == null ? null : _allocations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public AllocationApproved.AllocationApprovedBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public AllocationApproved.AllocationApprovedBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public AllocationApproved.AllocationApprovedBuilder addParty(List<? extends Party> partys) {
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
		public AllocationApproved.AllocationApprovedBuilder setParty(List<? extends Party> partys) {
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
		public AllocationApproved.AllocationApprovedBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public AllocationApproved.AllocationApprovedBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public AllocationApproved.AllocationApprovedBuilder addAccount(List<? extends Account> accounts) {
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
		public AllocationApproved.AllocationApprovedBuilder setAccount(List<? extends Account> accounts) {
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
		public AllocationApproved build() {
			return new AllocationApproved.AllocationApprovedImpl(this);
		}
		
		@Override
		public AllocationApproved.AllocationApprovedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationApproved.AllocationApprovedBuilder prune() {
			super.prune();
			if (blockTradeIdentifier!=null && !blockTradeIdentifier.prune().hasData()) blockTradeIdentifier = null;
			if (allocations!=null && !allocations.prune().hasData()) allocations = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBlockTradeIdentifier()!=null && getBlockTradeIdentifier().hasData()) return true;
			if (getAllocations()!=null && getAllocations().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationApproved.AllocationApprovedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AllocationApproved.AllocationApprovedBuilder o = (AllocationApproved.AllocationApprovedBuilder) other;
			
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
		
			AllocationApproved _that = getType().cast(o);
		
			if (!Objects.equals(blockTradeIdentifier, _that.getBlockTradeIdentifier())) return false;
			if (!Objects.equals(allocations, _that.getAllocations())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (blockTradeIdentifier != null ? blockTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationApprovedBuilder {" +
				"blockTradeIdentifier=" + this.blockTradeIdentifier + ", " +
				"allocations=" + this.allocations + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

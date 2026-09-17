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
import fpml.consolidated.confirmation.processes.meta.ApprovalStatusNotificationMeta;
import fpml.consolidated.doc.Approvals;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NotificationMessage;
import fpml.consolidated.msg.NotificationMessageHeader;
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
 * Provision A message describing the approvals currently applied to the trade and their status (e.g. pending, approved, refused).
 *
 */
@RosettaDataType(value="ApprovalStatusNotification", builder=ApprovalStatusNotification.ApprovalStatusNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ApprovalStatusNotification", model="fpml", builder=ApprovalStatusNotification.ApprovalStatusNotificationBuilderImpl.class, version="2.1.1")
public interface ApprovalStatusNotification extends NotificationMessage {

	ApprovalStatusNotificationMeta metaData = new ApprovalStatusNotificationMeta();

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
	Trade getTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeIdentifier getTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision All of the approvals for a specific trade.
	 *
	 */
	Approvals getApprovals();
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
	ApprovalStatusNotification build();
	
	ApprovalStatusNotification.ApprovalStatusNotificationBuilder toBuilder();
	
	static ApprovalStatusNotification.ApprovalStatusNotificationBuilder builder() {
		return new ApprovalStatusNotification.ApprovalStatusNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApprovalStatusNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ApprovalStatusNotification> getType() {
		return ApprovalStatusNotification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("approvals"), processor, Approvals.class, getApprovals());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApprovalStatusNotificationBuilder extends ApprovalStatusNotification, NotificationMessage.NotificationMessageBuilder {
		Trade.TradeBuilder getOrCreateTrade();
		@Override
		Trade.TradeBuilder getTrade();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier();
		@Override
		TradeIdentifier.TradeIdentifierBuilder getTradeIdentifier();
		Approvals.ApprovalsBuilder getOrCreateApprovals();
		@Override
		Approvals.ApprovalsBuilder getApprovals();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setHeader(NotificationMessageHeader header);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addValidation(Validation validation);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setTrade(Trade trade);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setApprovals(Approvals approvals);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addParty(Party party);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addParty(Party party, int idx);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addParty(List<? extends Party> party);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setParty(List<? extends Party> party);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addAccount(Account account);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addAccount(Account account, int idx);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder addAccount(List<? extends Account> account);
		ApprovalStatusNotification.ApprovalStatusNotificationBuilder setAccount(List<? extends Account> account);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("approvals"), processor, Approvals.ApprovalsBuilder.class, getApprovals());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		ApprovalStatusNotification.ApprovalStatusNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of ApprovalStatusNotification  ***********************/
	class ApprovalStatusNotificationImpl extends NotificationMessage.NotificationMessageImpl implements ApprovalStatusNotification {
		private final Trade trade;
		private final TradeIdentifier tradeIdentifier;
		private final Approvals approvals;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected ApprovalStatusNotificationImpl(ApprovalStatusNotification.ApprovalStatusNotificationBuilder builder) {
			super(builder);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).map(f->f.build()).orElse(null);
			this.approvals = ofNullable(builder.getApprovals()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeIdentifier")
		public TradeIdentifier getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("approvals")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("approvals")
		public Approvals getApprovals() {
			return approvals;
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
		public ApprovalStatusNotification build() {
			return this;
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder toBuilder() {
			ApprovalStatusNotification.ApprovalStatusNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApprovalStatusNotification.ApprovalStatusNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getApprovals()).ifPresent(builder::setApprovals);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ApprovalStatusNotification _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalStatusNotification {" +
				"trade=" + this.trade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"approvals=" + this.approvals + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ApprovalStatusNotification  ***********************/
	class ApprovalStatusNotificationBuilderImpl extends NotificationMessage.NotificationMessageBuilderImpl implements ApprovalStatusNotification.ApprovalStatusNotificationBuilder {
	
		protected Trade.TradeBuilder trade;
		protected TradeIdentifier.TradeIdentifierBuilder tradeIdentifier;
		protected Approvals.ApprovalsBuilder approvals;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public Trade.TradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade() {
			Trade.TradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (tradeIdentifier!=null) {
				result = tradeIdentifier;
			}
			else {
				result = tradeIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvals")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("approvals")
		public Approvals.ApprovalsBuilder getApprovals() {
			return approvals;
		}
		
		@Override
		public Approvals.ApprovalsBuilder getOrCreateApprovals() {
			Approvals.ApprovalsBuilder result;
			if (approvals!=null) {
				result = approvals;
			}
			else {
				result = approvals = Approvals.builder();
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
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setHeader(NotificationMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addValidation(List<? extends Validation> validations) {
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
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setValidation(List<? extends Validation> validations) {
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
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeIdentifier")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setTradeIdentifier(TradeIdentifier _tradeIdentifier) {
			this.tradeIdentifier = _tradeIdentifier == null ? null : _tradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("approvals")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("approvals")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setApprovals(Approvals _approvals) {
			this.approvals = _approvals == null ? null : _approvals.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addParty(List<? extends Party> partys) {
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
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setParty(List<? extends Party> partys) {
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
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder addAccount(List<? extends Account> accounts) {
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
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder setAccount(List<? extends Account> accounts) {
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
		public ApprovalStatusNotification build() {
			return new ApprovalStatusNotification.ApprovalStatusNotificationImpl(this);
		}
		
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder prune() {
			super.prune();
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (tradeIdentifier!=null && !tradeIdentifier.prune().hasData()) tradeIdentifier = null;
			if (approvals!=null && !approvals.prune().hasData()) approvals = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().hasData()) return true;
			if (getApprovals()!=null && getApprovals().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalStatusNotification.ApprovalStatusNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ApprovalStatusNotification.ApprovalStatusNotificationBuilder o = (ApprovalStatusNotification.ApprovalStatusNotificationBuilder) other;
			
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::setTradeIdentifier);
			merger.mergeRosetta(getApprovals(), o.getApprovals(), this::setApprovals);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ApprovalStatusNotification _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalStatusNotificationBuilder {" +
				"trade=" + this.trade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"approvals=" + this.approvals + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

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
import fpml.consolidated.business.events.EventProposedMatch;
import fpml.consolidated.business.events.EventsChoice;
import fpml.consolidated.confirmation.processes.meta.ConfirmationStatusMeta;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.EventStatus;
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
 * Provision Message for sending matching results. Response message that returns the status of an event that have been submitted for matching.
 *
 */
@RosettaDataType(value="ConfirmationStatus", builder=ConfirmationStatus.ConfirmationStatusBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ConfirmationStatus", model="fpml", builder=ConfirmationStatus.ConfirmationStatusBuilderImpl.class, version="2.1.1")
public interface ConfirmationStatus extends ResponseMessage {

	ConfirmationStatusMeta metaData = new ConfirmationStatusMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the confirmation status of a trade or post-trade event (e.g. Matched, Mismatched, Unmatched, Alleged).
	 *
	 */
	EventStatus getStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Event (trade or post-trade event) asserted by one of the parties.
	 *
	 */
	EventsChoice getAssertedEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision "Other side's" event (trade or post-trade event) that meets the minimimum matching criteria and is proposed as match to the event that is being asserted.
	 *
	 */
	List<? extends EventProposedMatch> getProposedMatch();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Event (trade post-trade event) asserted by the "other side's" party.
	 *
	 */
	EventsChoice getAllegedEvent();
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
	ConfirmationStatus build();
	
	ConfirmationStatus.ConfirmationStatusBuilder toBuilder();
	
	static ConfirmationStatus.ConfirmationStatusBuilder builder() {
		return new ConfirmationStatus.ConfirmationStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConfirmationStatus> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ConfirmationStatus> getType() {
		return ConfirmationStatus.class;
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
		processRosetta(path.newSubPath("status"), processor, EventStatus.class, getStatus());
		processRosetta(path.newSubPath("assertedEvent"), processor, EventsChoice.class, getAssertedEvent());
		processRosetta(path.newSubPath("proposedMatch"), processor, EventProposedMatch.class, getProposedMatch());
		processRosetta(path.newSubPath("allegedEvent"), processor, EventsChoice.class, getAllegedEvent());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConfirmationStatusBuilder extends ConfirmationStatus, ResponseMessage.ResponseMessageBuilder {
		EventStatus.EventStatusBuilder getOrCreateStatus();
		@Override
		EventStatus.EventStatusBuilder getStatus();
		EventsChoice.EventsChoiceBuilder getOrCreateAssertedEvent();
		@Override
		EventsChoice.EventsChoiceBuilder getAssertedEvent();
		EventProposedMatch.EventProposedMatchBuilder getOrCreateProposedMatch(int index);
		@Override
		List<? extends EventProposedMatch.EventProposedMatchBuilder> getProposedMatch();
		EventsChoice.EventsChoiceBuilder getOrCreateAllegedEvent();
		@Override
		EventsChoice.EventsChoiceBuilder getAllegedEvent();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder setFpmlVersion(String fpmlVersion);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder setActualBuild(Integer actualBuild);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder setHeader(ResponseMessageHeader header);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder addValidation(Validation validation);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder addValidation(Validation validation, int idx);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder addValidation(List<? extends Validation> validation);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder setValidation(List<? extends Validation> validation);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		ConfirmationStatus.ConfirmationStatusBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		ConfirmationStatus.ConfirmationStatusBuilder setStatus(EventStatus status);
		ConfirmationStatus.ConfirmationStatusBuilder setAssertedEvent(EventsChoice assertedEvent);
		ConfirmationStatus.ConfirmationStatusBuilder addProposedMatch(EventProposedMatch proposedMatch);
		ConfirmationStatus.ConfirmationStatusBuilder addProposedMatch(EventProposedMatch proposedMatch, int idx);
		ConfirmationStatus.ConfirmationStatusBuilder addProposedMatch(List<? extends EventProposedMatch> proposedMatch);
		ConfirmationStatus.ConfirmationStatusBuilder setProposedMatch(List<? extends EventProposedMatch> proposedMatch);
		ConfirmationStatus.ConfirmationStatusBuilder setAllegedEvent(EventsChoice allegedEvent);
		ConfirmationStatus.ConfirmationStatusBuilder addParty(Party party);
		ConfirmationStatus.ConfirmationStatusBuilder addParty(Party party, int idx);
		ConfirmationStatus.ConfirmationStatusBuilder addParty(List<? extends Party> party);
		ConfirmationStatus.ConfirmationStatusBuilder setParty(List<? extends Party> party);
		ConfirmationStatus.ConfirmationStatusBuilder addAccount(Account account);
		ConfirmationStatus.ConfirmationStatusBuilder addAccount(Account account, int idx);
		ConfirmationStatus.ConfirmationStatusBuilder addAccount(List<? extends Account> account);
		ConfirmationStatus.ConfirmationStatusBuilder setAccount(List<? extends Account> account);

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
			processRosetta(path.newSubPath("status"), processor, EventStatus.EventStatusBuilder.class, getStatus());
			processRosetta(path.newSubPath("assertedEvent"), processor, EventsChoice.EventsChoiceBuilder.class, getAssertedEvent());
			processRosetta(path.newSubPath("proposedMatch"), processor, EventProposedMatch.EventProposedMatchBuilder.class, getProposedMatch());
			processRosetta(path.newSubPath("allegedEvent"), processor, EventsChoice.EventsChoiceBuilder.class, getAllegedEvent());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		ConfirmationStatus.ConfirmationStatusBuilder prune();
	}

	/*********************** Immutable Implementation of ConfirmationStatus  ***********************/
	class ConfirmationStatusImpl extends ResponseMessage.ResponseMessageImpl implements ConfirmationStatus {
		private final EventStatus status;
		private final EventsChoice assertedEvent;
		private final List<? extends EventProposedMatch> proposedMatch;
		private final EventsChoice allegedEvent;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected ConfirmationStatusImpl(ConfirmationStatus.ConfirmationStatusBuilder builder) {
			super(builder);
			this.status = ofNullable(builder.getStatus()).map(f->f.build()).orElse(null);
			this.assertedEvent = ofNullable(builder.getAssertedEvent()).map(f->f.build()).orElse(null);
			this.proposedMatch = ofNullable(builder.getProposedMatch()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.allegedEvent = ofNullable(builder.getAllegedEvent()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("status")
		public EventStatus getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("assertedEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assertedEvent")
		public EventsChoice getAssertedEvent() {
			return assertedEvent;
		}
		
		@Override
		@RosettaAttribute("proposedMatch")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("proposedMatch")
		public List<? extends EventProposedMatch> getProposedMatch() {
			return proposedMatch;
		}
		
		@Override
		@RosettaAttribute("allegedEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allegedEvent")
		public EventsChoice getAllegedEvent() {
			return allegedEvent;
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
		public ConfirmationStatus build() {
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder toBuilder() {
			ConfirmationStatus.ConfirmationStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConfirmationStatus.ConfirmationStatusBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStatus()).ifPresent(builder::setStatus);
			ofNullable(getAssertedEvent()).ifPresent(builder::setAssertedEvent);
			ofNullable(getProposedMatch()).ifPresent(builder::setProposedMatch);
			ofNullable(getAllegedEvent()).ifPresent(builder::setAllegedEvent);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConfirmationStatus _that = getType().cast(o);
		
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(assertedEvent, _that.getAssertedEvent())) return false;
			if (!ListEquals.listEquals(proposedMatch, _that.getProposedMatch())) return false;
			if (!Objects.equals(allegedEvent, _that.getAllegedEvent())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (assertedEvent != null ? assertedEvent.hashCode() : 0);
			_result = 31 * _result + (proposedMatch != null ? proposedMatch.hashCode() : 0);
			_result = 31 * _result + (allegedEvent != null ? allegedEvent.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConfirmationStatus {" +
				"status=" + this.status + ", " +
				"assertedEvent=" + this.assertedEvent + ", " +
				"proposedMatch=" + this.proposedMatch + ", " +
				"allegedEvent=" + this.allegedEvent + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ConfirmationStatus  ***********************/
	class ConfirmationStatusBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl implements ConfirmationStatus.ConfirmationStatusBuilder {
	
		protected EventStatus.EventStatusBuilder status;
		protected EventsChoice.EventsChoiceBuilder assertedEvent;
		protected List<EventProposedMatch.EventProposedMatchBuilder> proposedMatch = new ArrayList<>();
		protected EventsChoice.EventsChoiceBuilder allegedEvent;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("status")
		public EventStatus.EventStatusBuilder getStatus() {
			return status;
		}
		
		@Override
		public EventStatus.EventStatusBuilder getOrCreateStatus() {
			EventStatus.EventStatusBuilder result;
			if (status!=null) {
				result = status;
			}
			else {
				result = status = EventStatus.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assertedEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assertedEvent")
		public EventsChoice.EventsChoiceBuilder getAssertedEvent() {
			return assertedEvent;
		}
		
		@Override
		public EventsChoice.EventsChoiceBuilder getOrCreateAssertedEvent() {
			EventsChoice.EventsChoiceBuilder result;
			if (assertedEvent!=null) {
				result = assertedEvent;
			}
			else {
				result = assertedEvent = EventsChoice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("proposedMatch")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("proposedMatch")
		public List<? extends EventProposedMatch.EventProposedMatchBuilder> getProposedMatch() {
			return proposedMatch;
		}
		
		@Override
		public EventProposedMatch.EventProposedMatchBuilder getOrCreateProposedMatch(int index) {
			if (proposedMatch==null) {
				this.proposedMatch = new ArrayList<>();
			}
			return getIndex(proposedMatch, index, () -> {
						EventProposedMatch.EventProposedMatchBuilder newProposedMatch = EventProposedMatch.builder();
						return newProposedMatch;
					});
		}
		
		@Override
		@RosettaAttribute("allegedEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allegedEvent")
		public EventsChoice.EventsChoiceBuilder getAllegedEvent() {
			return allegedEvent;
		}
		
		@Override
		public EventsChoice.EventsChoiceBuilder getOrCreateAllegedEvent() {
			EventsChoice.EventsChoiceBuilder result;
			if (allegedEvent!=null) {
				result = allegedEvent;
			}
			else {
				result = allegedEvent = EventsChoice.builder();
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
		public ConfirmationStatus.ConfirmationStatusBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addValidation(List<? extends Validation> validations) {
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
		public ConfirmationStatus.ConfirmationStatusBuilder setValidation(List<? extends Validation> validations) {
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
		public ConfirmationStatus.ConfirmationStatusBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ConfirmationStatus.ConfirmationStatusBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ConfirmationStatus.ConfirmationStatusBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public ConfirmationStatus.ConfirmationStatusBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("status")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("status")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder setStatus(EventStatus _status) {
			this.status = _status == null ? null : _status.toBuilder();
			return this;
		}
		
		@RosettaAttribute("assertedEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("assertedEvent")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder setAssertedEvent(EventsChoice _assertedEvent) {
			this.assertedEvent = _assertedEvent == null ? null : _assertedEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("proposedMatch")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("proposedMatch")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addProposedMatch(EventProposedMatch _proposedMatch) {
			if (_proposedMatch != null) {
				this.proposedMatch.add(_proposedMatch.toBuilder());
			}
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addProposedMatch(EventProposedMatch _proposedMatch, int idx) {
			getIndex(this.proposedMatch, idx, () -> _proposedMatch.toBuilder());
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addProposedMatch(List<? extends EventProposedMatch> proposedMatchs) {
			if (proposedMatchs != null) {
				for (final EventProposedMatch toAdd : proposedMatchs) {
					this.proposedMatch.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("proposedMatch")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("proposedMatch")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder setProposedMatch(List<? extends EventProposedMatch> proposedMatchs) {
			if (proposedMatchs == null) {
				this.proposedMatch = new ArrayList<>();
			} else {
				this.proposedMatch = proposedMatchs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("allegedEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allegedEvent")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder setAllegedEvent(EventsChoice _allegedEvent) {
			this.allegedEvent = _allegedEvent == null ? null : _allegedEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addParty(List<? extends Party> partys) {
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
		public ConfirmationStatus.ConfirmationStatusBuilder setParty(List<? extends Party> partys) {
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
		public ConfirmationStatus.ConfirmationStatusBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder addAccount(List<? extends Account> accounts) {
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
		public ConfirmationStatus.ConfirmationStatusBuilder setAccount(List<? extends Account> accounts) {
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
		public ConfirmationStatus build() {
			return new ConfirmationStatus.ConfirmationStatusImpl(this);
		}
		
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder prune() {
			super.prune();
			if (status!=null && !status.prune().hasData()) status = null;
			if (assertedEvent!=null && !assertedEvent.prune().hasData()) assertedEvent = null;
			proposedMatch = proposedMatch.stream().filter(b->b!=null).<EventProposedMatch.EventProposedMatchBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (allegedEvent!=null && !allegedEvent.prune().hasData()) allegedEvent = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStatus()!=null && getStatus().hasData()) return true;
			if (getAssertedEvent()!=null && getAssertedEvent().hasData()) return true;
			if (getProposedMatch()!=null && getProposedMatch().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAllegedEvent()!=null && getAllegedEvent().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationStatus.ConfirmationStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ConfirmationStatus.ConfirmationStatusBuilder o = (ConfirmationStatus.ConfirmationStatusBuilder) other;
			
			merger.mergeRosetta(getStatus(), o.getStatus(), this::setStatus);
			merger.mergeRosetta(getAssertedEvent(), o.getAssertedEvent(), this::setAssertedEvent);
			merger.mergeRosetta(getProposedMatch(), o.getProposedMatch(), this::getOrCreateProposedMatch);
			merger.mergeRosetta(getAllegedEvent(), o.getAllegedEvent(), this::setAllegedEvent);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConfirmationStatus _that = getType().cast(o);
		
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(assertedEvent, _that.getAssertedEvent())) return false;
			if (!ListEquals.listEquals(proposedMatch, _that.getProposedMatch())) return false;
			if (!Objects.equals(allegedEvent, _that.getAllegedEvent())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (assertedEvent != null ? assertedEvent.hashCode() : 0);
			_result = 31 * _result + (proposedMatch != null ? proposedMatch.hashCode() : 0);
			_result = 31 * _result + (allegedEvent != null ? allegedEvent.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConfirmationStatusBuilder {" +
				"status=" + this.status + ", " +
				"assertedEvent=" + this.assertedEvent + ", " +
				"proposedMatch=" + this.proposedMatch + ", " +
				"allegedEvent=" + this.allegedEvent + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

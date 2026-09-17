package fpml.consolidated.msg;

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
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.meta.VerificationStatusNotificationMeta;
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
@RosettaDataType(value="VerificationStatusNotification", builder=VerificationStatusNotification.VerificationStatusNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VerificationStatusNotification", model="fpml", builder=VerificationStatusNotification.VerificationStatusNotificationBuilderImpl.class, version="2.1.1")
public interface VerificationStatusNotification extends NonCorrectableRequestMessage {

	VerificationStatusNotificationMeta metaData = new VerificationStatusNotificationMeta();

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
	VerificationStatus getStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The reason for any dispute or change in verification status.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The reason for any dispute or change in verification status.
	 *
	 */
	List<? extends Reason> getReason();
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
	PartyTradeIdentifier getPartyTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A legal entity or a subdivision of a legal entity. Parties can perform multiple roles in a trade lifecycle. For example, the principal parties obligated to make payments from time to time during the term of the trade, but may include other parties involved in, or incidental to, the trade, such as parties acting in the role of novation transferor/transferee, broker, calculation agent, etc. In FpML roles are defined in multiple places within a document.
	 *
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
	 * version "recordkeeping-5.13"
	 *
	 * Provision Optional account information used to precisely define the origination and destination of financial instruments.
	 *
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
	VerificationStatusNotification build();
	
	VerificationStatusNotification.VerificationStatusNotificationBuilder toBuilder();
	
	static VerificationStatusNotification.VerificationStatusNotificationBuilder builder() {
		return new VerificationStatusNotification.VerificationStatusNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VerificationStatusNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VerificationStatusNotification> getType() {
		return VerificationStatusNotification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("status"), processor, VerificationStatus.class, getStatus());
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VerificationStatusNotificationBuilder extends VerificationStatusNotification, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		VerificationStatus.VerificationStatusBuilder getOrCreateStatus();
		@Override
		VerificationStatus.VerificationStatusBuilder getStatus();
		Reason.ReasonBuilder getOrCreateReason(int index);
		@Override
		List<? extends Reason.ReasonBuilder> getReason();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier();
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getPartyTradeIdentifier();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder addValidation(Validation validation);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		VerificationStatusNotification.VerificationStatusNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setStatus(VerificationStatus status);
		VerificationStatusNotification.VerificationStatusNotificationBuilder addReason(Reason reason);
		VerificationStatusNotification.VerificationStatusNotificationBuilder addReason(Reason reason, int idx);
		VerificationStatusNotification.VerificationStatusNotificationBuilder addReason(List<? extends Reason> reason);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setReason(List<? extends Reason> reason);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier);
		VerificationStatusNotification.VerificationStatusNotificationBuilder addParty(Party party);
		VerificationStatusNotification.VerificationStatusNotificationBuilder addParty(Party party, int idx);
		VerificationStatusNotification.VerificationStatusNotificationBuilder addParty(List<? extends Party> party);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setParty(List<? extends Party> party);
		VerificationStatusNotification.VerificationStatusNotificationBuilder addAccount(Account account);
		VerificationStatusNotification.VerificationStatusNotificationBuilder addAccount(Account account, int idx);
		VerificationStatusNotification.VerificationStatusNotificationBuilder addAccount(List<? extends Account> account);
		VerificationStatusNotification.VerificationStatusNotificationBuilder setAccount(List<? extends Account> account);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("status"), processor, VerificationStatus.VerificationStatusBuilder.class, getStatus());
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		VerificationStatusNotification.VerificationStatusNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of VerificationStatusNotification  ***********************/
	class VerificationStatusNotificationImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements VerificationStatusNotification {
		private final VerificationStatus status;
		private final List<? extends Reason> reason;
		private final PartyTradeIdentifier partyTradeIdentifier;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected VerificationStatusNotificationImpl(VerificationStatusNotification.VerificationStatusNotificationBuilder builder) {
			super(builder);
			this.status = ofNullable(builder.getStatus()).map(f->f.build()).orElse(null);
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("status")
		public VerificationStatus getStatus() {
			return status;
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
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyTradeIdentifier")
		public PartyTradeIdentifier getPartyTradeIdentifier() {
			return partyTradeIdentifier;
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
		public VerificationStatusNotification build() {
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder toBuilder() {
			VerificationStatusNotification.VerificationStatusNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VerificationStatusNotification.VerificationStatusNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStatus()).ifPresent(builder::setStatus);
			ofNullable(getReason()).ifPresent(builder::setReason);
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VerificationStatusNotification _that = getType().cast(o);
		
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!Objects.equals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VerificationStatusNotification {" +
				"status=" + this.status + ", " +
				"reason=" + this.reason + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VerificationStatusNotification  ***********************/
	class VerificationStatusNotificationBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl implements VerificationStatusNotification.VerificationStatusNotificationBuilder {
	
		protected VerificationStatus.VerificationStatusBuilder status;
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder partyTradeIdentifier;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("status")
		public VerificationStatus.VerificationStatusBuilder getStatus() {
			return status;
		}
		
		@Override
		public VerificationStatus.VerificationStatusBuilder getOrCreateStatus() {
			VerificationStatus.VerificationStatusBuilder result;
			if (status!=null) {
				result = status;
			}
			else {
				result = status = VerificationStatus.builder();
			}
			
			return result;
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
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyTradeIdentifier")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier() {
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			if (partyTradeIdentifier!=null) {
				result = partyTradeIdentifier;
			}
			else {
				result = partyTradeIdentifier = PartyTradeIdentifier.builder();
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
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addValidation(List<? extends Validation> validations) {
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
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setValidation(List<? extends Validation> validations) {
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
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setStatus(VerificationStatus _status) {
			this.status = _status == null ? null : _status.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addReason(List<? extends Reason> reasons) {
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
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setReason(List<? extends Reason> reasons) {
			if (reasons == null) {
				this.reason = new ArrayList<>();
			} else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier) {
			this.partyTradeIdentifier = _partyTradeIdentifier == null ? null : _partyTradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addParty(List<? extends Party> partys) {
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
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setParty(List<? extends Party> partys) {
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
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder addAccount(List<? extends Account> accounts) {
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
		public VerificationStatusNotification.VerificationStatusNotificationBuilder setAccount(List<? extends Account> accounts) {
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
		public VerificationStatusNotification build() {
			return new VerificationStatusNotification.VerificationStatusNotificationImpl(this);
		}
		
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder prune() {
			super.prune();
			if (status!=null && !status.prune().hasData()) status = null;
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partyTradeIdentifier!=null && !partyTradeIdentifier.prune().hasData()) partyTradeIdentifier = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStatus()!=null && getStatus().hasData()) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VerificationStatusNotification.VerificationStatusNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			VerificationStatusNotification.VerificationStatusNotificationBuilder o = (VerificationStatusNotification.VerificationStatusNotificationBuilder) other;
			
			merger.mergeRosetta(getStatus(), o.getStatus(), this::setStatus);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::setPartyTradeIdentifier);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VerificationStatusNotification _that = getType().cast(o);
		
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!Objects.equals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VerificationStatusNotificationBuilder {" +
				"status=" + this.status + ", " +
				"reason=" + this.reason + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

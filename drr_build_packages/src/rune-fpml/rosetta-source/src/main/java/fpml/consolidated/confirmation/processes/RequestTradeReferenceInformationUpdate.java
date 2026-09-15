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
import fpml.consolidated.business.events.TradeReferenceInformation;
import fpml.consolidated.confirmation.processes.meta.RequestTradeReferenceInformationUpdateMeta;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrectableRequestMessage;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
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
 * Provision Defines the structure for a message requesting information updates to a trade. The trade reference information should contain at least one trade identifier that the recipient is aware of.
 *
 */
@RosettaDataType(value="RequestTradeReferenceInformationUpdate", builder=RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequestTradeReferenceInformationUpdate", model="fpml", builder=RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilderImpl.class, version="2.1.1")
public interface RequestTradeReferenceInformationUpdate extends CorrectableRequestMessage {

	RequestTradeReferenceInformationUpdateMeta metaData = new RequestTradeReferenceInformationUpdateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Information about a trade.
	 *
	 */
	TradeReferenceInformation getTradeReferenceInformation();
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
	RequestTradeReferenceInformationUpdate build();
	
	RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder toBuilder();
	
	static RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder builder() {
		return new RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestTradeReferenceInformationUpdate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequestTradeReferenceInformationUpdate> getType() {
		return RequestTradeReferenceInformationUpdate.class;
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
		processRosetta(path.newSubPath("tradeReferenceInformation"), processor, TradeReferenceInformation.class, getTradeReferenceInformation());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestTradeReferenceInformationUpdateBuilder extends RequestTradeReferenceInformationUpdate, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		TradeReferenceInformation.TradeReferenceInformationBuilder getOrCreateTradeReferenceInformation();
		@Override
		TradeReferenceInformation.TradeReferenceInformationBuilder getTradeReferenceInformation();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setActualBuild(Integer actualBuild);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setHeader(RequestMessageHeader header);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addValidation(Validation validation);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addValidation(Validation validation, int idx);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addValidation(List<? extends Validation> validation);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setValidation(List<? extends Validation> validation);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setIsCorrection(Boolean isCorrection);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setTradeReferenceInformation(TradeReferenceInformation tradeReferenceInformation);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addParty(Party party);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addParty(Party party, int idx);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addParty(List<? extends Party> party);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setParty(List<? extends Party> party);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addAccount(Account account);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addAccount(Account account, int idx);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addAccount(List<? extends Account> account);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setAccount(List<? extends Account> account);

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
			processRosetta(path.newSubPath("tradeReferenceInformation"), processor, TradeReferenceInformation.TradeReferenceInformationBuilder.class, getTradeReferenceInformation());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder prune();
	}

	/*********************** Immutable Implementation of RequestTradeReferenceInformationUpdate  ***********************/
	class RequestTradeReferenceInformationUpdateImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements RequestTradeReferenceInformationUpdate {
		private final TradeReferenceInformation tradeReferenceInformation;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected RequestTradeReferenceInformationUpdateImpl(RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder builder) {
			super(builder);
			this.tradeReferenceInformation = ofNullable(builder.getTradeReferenceInformation()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeReferenceInformation")
		public TradeReferenceInformation getTradeReferenceInformation() {
			return tradeReferenceInformation;
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
		public RequestTradeReferenceInformationUpdate build() {
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder toBuilder() {
			RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeReferenceInformation()).ifPresent(builder::setTradeReferenceInformation);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestTradeReferenceInformationUpdate _that = getType().cast(o);
		
			if (!Objects.equals(tradeReferenceInformation, _that.getTradeReferenceInformation())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeReferenceInformation != null ? tradeReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestTradeReferenceInformationUpdate {" +
				"tradeReferenceInformation=" + this.tradeReferenceInformation + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestTradeReferenceInformationUpdate  ***********************/
	class RequestTradeReferenceInformationUpdateBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl implements RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder {
	
		protected TradeReferenceInformation.TradeReferenceInformationBuilder tradeReferenceInformation;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("tradeReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeReferenceInformation")
		public TradeReferenceInformation.TradeReferenceInformationBuilder getTradeReferenceInformation() {
			return tradeReferenceInformation;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder getOrCreateTradeReferenceInformation() {
			TradeReferenceInformation.TradeReferenceInformationBuilder result;
			if (tradeReferenceInformation!=null) {
				result = tradeReferenceInformation;
			}
			else {
				result = tradeReferenceInformation = TradeReferenceInformation.builder();
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
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addValidation(List<? extends Validation> validations) {
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
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setValidation(List<? extends Validation> validations) {
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
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeReferenceInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradeReferenceInformation")
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setTradeReferenceInformation(TradeReferenceInformation _tradeReferenceInformation) {
			this.tradeReferenceInformation = _tradeReferenceInformation == null ? null : _tradeReferenceInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addParty(List<? extends Party> partys) {
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
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setParty(List<? extends Party> partys) {
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
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder addAccount(List<? extends Account> accounts) {
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
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setAccount(List<? extends Account> accounts) {
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
		public RequestTradeReferenceInformationUpdate build() {
			return new RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateImpl(this);
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder prune() {
			super.prune();
			if (tradeReferenceInformation!=null && !tradeReferenceInformation.prune().hasData()) tradeReferenceInformation = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeReferenceInformation()!=null && getTradeReferenceInformation().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder o = (RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder) other;
			
			merger.mergeRosetta(getTradeReferenceInformation(), o.getTradeReferenceInformation(), this::setTradeReferenceInformation);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestTradeReferenceInformationUpdate _that = getType().cast(o);
		
			if (!Objects.equals(tradeReferenceInformation, _that.getTradeReferenceInformation())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeReferenceInformation != null ? tradeReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestTradeReferenceInformationUpdateBuilder {" +
				"tradeReferenceInformation=" + this.tradeReferenceInformation + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

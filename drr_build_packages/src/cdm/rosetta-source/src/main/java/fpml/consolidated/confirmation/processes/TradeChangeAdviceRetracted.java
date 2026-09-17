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
import fpml.consolidated.business.events.TradeChangeContent;
import fpml.consolidated.confirmation.processes.meta.TradeChangeAdviceRetractedMeta;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NonCorrectableRequestMessage;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PaymentDetails;
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
 * Provision Defines the structure for a message retracting a prior change advice.
 *
 */
@RosettaDataType(value="TradeChangeAdviceRetracted", builder=TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeChangeAdviceRetracted", model="fpml", builder=TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilderImpl.class, version="2.1.1")
public interface TradeChangeAdviceRetracted extends NonCorrectableRequestMessage {

	TradeChangeAdviceRetractedMeta metaData = new TradeChangeAdviceRetractedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The qualified identifiers of the subject trade.
	 *
	 */
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the details of the change being retracted.
	 *
	 */
	TradeChangeContent getChange();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Details of the payments, like amount breakdowns, settlement information.
	 *
	 */
	List<? extends PaymentDetails> getPaymentDetails();
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
	TradeChangeAdviceRetracted build();
	
	TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder toBuilder();
	
	static TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder builder() {
		return new TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeChangeAdviceRetracted> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeChangeAdviceRetracted> getType() {
		return TradeChangeAdviceRetracted.class;
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
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("change"), processor, TradeChangeContent.class, getChange());
		processRosetta(path.newSubPath("paymentDetails"), processor, PaymentDetails.class, getPaymentDetails());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeChangeAdviceRetractedBuilder extends TradeChangeAdviceRetracted, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		TradeChangeContent.TradeChangeContentBuilder getOrCreateChange();
		@Override
		TradeChangeContent.TradeChangeContentBuilder getChange();
		PaymentDetails.PaymentDetailsBuilder getOrCreatePaymentDetails(int index);
		@Override
		List<? extends PaymentDetails.PaymentDetailsBuilder> getPaymentDetails();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setActualBuild(Integer actualBuild);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setHeader(RequestMessageHeader header);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addValidation(Validation validation);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addValidation(Validation validation, int idx);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addValidation(List<? extends Validation> validation);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setValidation(List<? extends Validation> validation);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int idx);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setChange(TradeChangeContent change);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addPaymentDetails(PaymentDetails paymentDetails);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addPaymentDetails(PaymentDetails paymentDetails, int idx);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addPaymentDetails(List<? extends PaymentDetails> paymentDetails);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setPaymentDetails(List<? extends PaymentDetails> paymentDetails);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addParty(Party party);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addParty(Party party, int idx);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addParty(List<? extends Party> party);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setParty(List<? extends Party> party);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addAccount(Account account);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addAccount(Account account, int idx);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addAccount(List<? extends Account> account);
		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setAccount(List<? extends Account> account);

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
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("change"), processor, TradeChangeContent.TradeChangeContentBuilder.class, getChange());
			processRosetta(path.newSubPath("paymentDetails"), processor, PaymentDetails.PaymentDetailsBuilder.class, getPaymentDetails());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of TradeChangeAdviceRetracted  ***********************/
	class TradeChangeAdviceRetractedImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements TradeChangeAdviceRetracted {
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final TradeChangeContent change;
		private final List<? extends PaymentDetails> paymentDetails;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected TradeChangeAdviceRetractedImpl(TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder builder) {
			super(builder);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.change = ofNullable(builder.getChange()).map(f->f.build()).orElse(null);
			this.paymentDetails = ofNullable(builder.getPaymentDetails()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("change")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("change")
		public TradeChangeContent getChange() {
			return change;
		}
		
		@Override
		@RosettaAttribute("paymentDetails")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("paymentDetails")
		public List<? extends PaymentDetails> getPaymentDetails() {
			return paymentDetails;
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
		public TradeChangeAdviceRetracted build() {
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder toBuilder() {
			TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getChange()).ifPresent(builder::setChange);
			ofNullable(getPaymentDetails()).ifPresent(builder::setPaymentDetails);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeChangeAdviceRetracted _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!ListEquals.listEquals(paymentDetails, _that.getPaymentDetails())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeAdviceRetracted {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"change=" + this.change + ", " +
				"paymentDetails=" + this.paymentDetails + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeChangeAdviceRetracted  ***********************/
	class TradeChangeAdviceRetractedBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl implements TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected TradeChangeContent.TradeChangeContentBuilder change;
		protected List<PaymentDetails.PaymentDetailsBuilder> paymentDetails = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int index) {
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			return getIndex(tradeIdentifier, index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newTradeIdentifier = PartyTradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("change")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("change")
		public TradeChangeContent.TradeChangeContentBuilder getChange() {
			return change;
		}
		
		@Override
		public TradeChangeContent.TradeChangeContentBuilder getOrCreateChange() {
			TradeChangeContent.TradeChangeContentBuilder result;
			if (change!=null) {
				result = change;
			}
			else {
				result = change = TradeChangeContent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDetails")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("paymentDetails")
		public List<? extends PaymentDetails.PaymentDetailsBuilder> getPaymentDetails() {
			return paymentDetails;
		}
		
		@Override
		public PaymentDetails.PaymentDetailsBuilder getOrCreatePaymentDetails(int index) {
			if (paymentDetails==null) {
				this.paymentDetails = new ArrayList<>();
			}
			return getIndex(paymentDetails, index, () -> {
						PaymentDetails.PaymentDetailsBuilder newPaymentDetails = PaymentDetails.builder();
						return newPaymentDetails;
					});
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
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addValidation(List<? extends Validation> validations) {
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
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setValidation(List<? extends Validation> validations) {
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
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			if (_tradeIdentifier != null) {
				this.tradeIdentifier.add(_tradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier, int idx) {
			getIndex(this.tradeIdentifier, idx, () -> _tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (final PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null) {
				this.tradeIdentifier = new ArrayList<>();
			} else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("change")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("change")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setChange(TradeChangeContent _change) {
			this.change = _change == null ? null : _change.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDetails")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("paymentDetails")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addPaymentDetails(PaymentDetails _paymentDetails) {
			if (_paymentDetails != null) {
				this.paymentDetails.add(_paymentDetails.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addPaymentDetails(PaymentDetails _paymentDetails, int idx) {
			getIndex(this.paymentDetails, idx, () -> _paymentDetails.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addPaymentDetails(List<? extends PaymentDetails> paymentDetailss) {
			if (paymentDetailss != null) {
				for (final PaymentDetails toAdd : paymentDetailss) {
					this.paymentDetails.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("paymentDetails")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("paymentDetails")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setPaymentDetails(List<? extends PaymentDetails> paymentDetailss) {
			if (paymentDetailss == null) {
				this.paymentDetails = new ArrayList<>();
			} else {
				this.paymentDetails = paymentDetailss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addParty(List<? extends Party> partys) {
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
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setParty(List<? extends Party> partys) {
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
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder addAccount(List<? extends Account> accounts) {
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
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder setAccount(List<? extends Account> accounts) {
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
		public TradeChangeAdviceRetracted build() {
			return new TradeChangeAdviceRetracted.TradeChangeAdviceRetractedImpl(this);
		}
		
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder prune() {
			super.prune();
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (change!=null && !change.prune().hasData()) change = null;
			paymentDetails = paymentDetails.stream().filter(b->b!=null).<PaymentDetails.PaymentDetailsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getChange()!=null && getChange().hasData()) return true;
			if (getPaymentDetails()!=null && getPaymentDetails().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder o = (TradeChangeAdviceRetracted.TradeChangeAdviceRetractedBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getChange(), o.getChange(), this::setChange);
			merger.mergeRosetta(getPaymentDetails(), o.getPaymentDetails(), this::getOrCreatePaymentDetails);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeChangeAdviceRetracted _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!ListEquals.listEquals(paymentDetails, _that.getPaymentDetails())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeAdviceRetractedBuilder {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"change=" + this.change + ", " +
				"paymentDetails=" + this.paymentDetails + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

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
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.business.events.TradeChangeContent;
import fpml.consolidated.confirmation.processes.meta.TradeChangeAdviceMeta;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrectableRequestMessage;
import fpml.consolidated.msg.CorrelationId;
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
 * Provision Defines the structure for a message indicating that a trade is being changed due to a non-negotiated event.
 *
 */
@RosettaDataType(value="TradeChangeAdvice", builder=TradeChangeAdvice.TradeChangeAdviceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeChangeAdvice", model="fpml", builder=TradeChangeAdvice.TradeChangeAdviceBuilderImpl.class, version="2.1.1")
public interface TradeChangeAdvice extends CorrectableRequestMessage {

	TradeChangeAdviceMeta metaData = new TradeChangeAdviceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the details of the change.
	 *
	 */
	TradeChangeContent getChange();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Pricing information for the trade.
	 *
	 */
	List<? extends BasicQuotation> getQuote();
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
	TradeChangeAdvice build();
	
	TradeChangeAdvice.TradeChangeAdviceBuilder toBuilder();
	
	static TradeChangeAdvice.TradeChangeAdviceBuilder builder() {
		return new TradeChangeAdvice.TradeChangeAdviceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeChangeAdvice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeChangeAdvice> getType() {
		return TradeChangeAdvice.class;
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
		processRosetta(path.newSubPath("change"), processor, TradeChangeContent.class, getChange());
		processRosetta(path.newSubPath("quote"), processor, BasicQuotation.class, getQuote());
		processRosetta(path.newSubPath("paymentDetails"), processor, PaymentDetails.class, getPaymentDetails());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeChangeAdviceBuilder extends TradeChangeAdvice, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		TradeChangeContent.TradeChangeContentBuilder getOrCreateChange();
		@Override
		TradeChangeContent.TradeChangeContentBuilder getChange();
		BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int index);
		@Override
		List<? extends BasicQuotation.BasicQuotationBuilder> getQuote();
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
		TradeChangeAdvice.TradeChangeAdviceBuilder setFpmlVersion(String fpmlVersion);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder setActualBuild(Integer actualBuild);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder setHeader(RequestMessageHeader header);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder addValidation(Validation validation);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder addValidation(Validation validation, int idx);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder addValidation(List<? extends Validation> validation);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder setValidation(List<? extends Validation> validation);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder setIsCorrection(Boolean isCorrection);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		TradeChangeAdvice.TradeChangeAdviceBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		TradeChangeAdvice.TradeChangeAdviceBuilder setChange(TradeChangeContent change);
		TradeChangeAdvice.TradeChangeAdviceBuilder addQuote(BasicQuotation quote);
		TradeChangeAdvice.TradeChangeAdviceBuilder addQuote(BasicQuotation quote, int idx);
		TradeChangeAdvice.TradeChangeAdviceBuilder addQuote(List<? extends BasicQuotation> quote);
		TradeChangeAdvice.TradeChangeAdviceBuilder setQuote(List<? extends BasicQuotation> quote);
		TradeChangeAdvice.TradeChangeAdviceBuilder addPaymentDetails(PaymentDetails paymentDetails);
		TradeChangeAdvice.TradeChangeAdviceBuilder addPaymentDetails(PaymentDetails paymentDetails, int idx);
		TradeChangeAdvice.TradeChangeAdviceBuilder addPaymentDetails(List<? extends PaymentDetails> paymentDetails);
		TradeChangeAdvice.TradeChangeAdviceBuilder setPaymentDetails(List<? extends PaymentDetails> paymentDetails);
		TradeChangeAdvice.TradeChangeAdviceBuilder addParty(Party party);
		TradeChangeAdvice.TradeChangeAdviceBuilder addParty(Party party, int idx);
		TradeChangeAdvice.TradeChangeAdviceBuilder addParty(List<? extends Party> party);
		TradeChangeAdvice.TradeChangeAdviceBuilder setParty(List<? extends Party> party);
		TradeChangeAdvice.TradeChangeAdviceBuilder addAccount(Account account);
		TradeChangeAdvice.TradeChangeAdviceBuilder addAccount(Account account, int idx);
		TradeChangeAdvice.TradeChangeAdviceBuilder addAccount(List<? extends Account> account);
		TradeChangeAdvice.TradeChangeAdviceBuilder setAccount(List<? extends Account> account);

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
			processRosetta(path.newSubPath("change"), processor, TradeChangeContent.TradeChangeContentBuilder.class, getChange());
			processRosetta(path.newSubPath("quote"), processor, BasicQuotation.BasicQuotationBuilder.class, getQuote());
			processRosetta(path.newSubPath("paymentDetails"), processor, PaymentDetails.PaymentDetailsBuilder.class, getPaymentDetails());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		TradeChangeAdvice.TradeChangeAdviceBuilder prune();
	}

	/*********************** Immutable Implementation of TradeChangeAdvice  ***********************/
	class TradeChangeAdviceImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements TradeChangeAdvice {
		private final TradeChangeContent change;
		private final List<? extends BasicQuotation> quote;
		private final List<? extends PaymentDetails> paymentDetails;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected TradeChangeAdviceImpl(TradeChangeAdvice.TradeChangeAdviceBuilder builder) {
			super(builder);
			this.change = ofNullable(builder.getChange()).map(f->f.build()).orElse(null);
			this.quote = ofNullable(builder.getQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.paymentDetails = ofNullable(builder.getPaymentDetails()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("change")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("change")
		public TradeChangeContent getChange() {
			return change;
		}
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends BasicQuotation> getQuote() {
			return quote;
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
		public TradeChangeAdvice build() {
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder toBuilder() {
			TradeChangeAdvice.TradeChangeAdviceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeChangeAdvice.TradeChangeAdviceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getChange()).ifPresent(builder::setChange);
			ofNullable(getQuote()).ifPresent(builder::setQuote);
			ofNullable(getPaymentDetails()).ifPresent(builder::setPaymentDetails);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeChangeAdvice _that = getType().cast(o);
		
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!ListEquals.listEquals(paymentDetails, _that.getPaymentDetails())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeAdvice {" +
				"change=" + this.change + ", " +
				"quote=" + this.quote + ", " +
				"paymentDetails=" + this.paymentDetails + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeChangeAdvice  ***********************/
	class TradeChangeAdviceBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl implements TradeChangeAdvice.TradeChangeAdviceBuilder {
	
		protected TradeChangeContent.TradeChangeContentBuilder change;
		protected List<BasicQuotation.BasicQuotationBuilder> quote = new ArrayList<>();
		protected List<PaymentDetails.PaymentDetailsBuilder> paymentDetails = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("change")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends BasicQuotation.BasicQuotationBuilder> getQuote() {
			return quote;
		}
		
		@Override
		public BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int index) {
			if (quote==null) {
				this.quote = new ArrayList<>();
			}
			return getIndex(quote, index, () -> {
						BasicQuotation.BasicQuotationBuilder newQuote = BasicQuotation.builder();
						return newQuote;
					});
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
		public TradeChangeAdvice.TradeChangeAdviceBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addValidation(List<? extends Validation> validations) {
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
		public TradeChangeAdvice.TradeChangeAdviceBuilder setValidation(List<? extends Validation> validations) {
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
		public TradeChangeAdvice.TradeChangeAdviceBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public TradeChangeAdvice.TradeChangeAdviceBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public TradeChangeAdvice.TradeChangeAdviceBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public TradeChangeAdvice.TradeChangeAdviceBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("change")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("change")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder setChange(TradeChangeContent _change) {
			this.change = _change == null ? null : _change.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addQuote(BasicQuotation _quote) {
			if (_quote != null) {
				this.quote.add(_quote.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addQuote(BasicQuotation _quote, int idx) {
			getIndex(this.quote, idx, () -> _quote.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addQuote(List<? extends BasicQuotation> quotes) {
			if (quotes != null) {
				for (final BasicQuotation toAdd : quotes) {
					this.quote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder setQuote(List<? extends BasicQuotation> quotes) {
			if (quotes == null) {
				this.quote = new ArrayList<>();
			} else {
				this.quote = quotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("paymentDetails")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("paymentDetails")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addPaymentDetails(PaymentDetails _paymentDetails) {
			if (_paymentDetails != null) {
				this.paymentDetails.add(_paymentDetails.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addPaymentDetails(PaymentDetails _paymentDetails, int idx) {
			getIndex(this.paymentDetails, idx, () -> _paymentDetails.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addPaymentDetails(List<? extends PaymentDetails> paymentDetailss) {
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
		public TradeChangeAdvice.TradeChangeAdviceBuilder setPaymentDetails(List<? extends PaymentDetails> paymentDetailss) {
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
		public TradeChangeAdvice.TradeChangeAdviceBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addParty(List<? extends Party> partys) {
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
		public TradeChangeAdvice.TradeChangeAdviceBuilder setParty(List<? extends Party> partys) {
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
		public TradeChangeAdvice.TradeChangeAdviceBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder addAccount(List<? extends Account> accounts) {
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
		public TradeChangeAdvice.TradeChangeAdviceBuilder setAccount(List<? extends Account> accounts) {
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
		public TradeChangeAdvice build() {
			return new TradeChangeAdvice.TradeChangeAdviceImpl(this);
		}
		
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder prune() {
			super.prune();
			if (change!=null && !change.prune().hasData()) change = null;
			quote = quote.stream().filter(b->b!=null).<BasicQuotation.BasicQuotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			paymentDetails = paymentDetails.stream().filter(b->b!=null).<PaymentDetails.PaymentDetailsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getChange()!=null && getChange().hasData()) return true;
			if (getQuote()!=null && getQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPaymentDetails()!=null && getPaymentDetails().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeAdvice.TradeChangeAdviceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			TradeChangeAdvice.TradeChangeAdviceBuilder o = (TradeChangeAdvice.TradeChangeAdviceBuilder) other;
			
			merger.mergeRosetta(getChange(), o.getChange(), this::setChange);
			merger.mergeRosetta(getQuote(), o.getQuote(), this::getOrCreateQuote);
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
		
			TradeChangeAdvice _that = getType().cast(o);
		
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!ListEquals.listEquals(paymentDetails, _that.getPaymentDetails())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeAdviceBuilder {" +
				"change=" + this.change + ", " +
				"quote=" + this.quote + ", " +
				"paymentDetails=" + this.paymentDetails + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

package fpml.consolidated.loan;

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
import fpml.consolidated.doc.UnprocessedElementWrapper;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.meta.LoanAcknowledgementMeta;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.Message;
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
 * Provision A base type to extend the FpML basic 'message' type, similar in function to the 'response' message, but specific to the needs of the loan asset class.
 *
 */
@RosettaDataType(value="LoanAcknowledgement", builder=LoanAcknowledgement.LoanAcknowledgementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAcknowledgement", model="fpml", builder=LoanAcknowledgement.LoanAcknowledgementBuilderImpl.class, version="2.1.1")
public interface LoanAcknowledgement extends Message {

	LoanAcknowledgementMeta metaData = new LoanAcknowledgementMeta();

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
	ResponseMessageHeader getHeader();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A list of validation sets the sender asserts the document is valid with respect to.
	 *
	 */
	List<? extends Validation> getValidation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional identifier used to correlate between related processes
	 *
	 */
	CorrelationId getParentCorrelationId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A qualified identifier used to correlate between messages
	 *
	 */
	CorrelationId getCorrelationId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A numeric value that can be used to order messages with the same correlation identifier from the same sender.
	 *
	 */
	Integer getSequenceNumber();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates which party (or parties) (and accounts) a trade or event is being processed for. Normally there will only be a maximum of 2 parties, but in the case of a novation there could be a transferor, transferee, remaining party, and other remaining party. Also, in the context of a trade package there could be several parties for which limit check is requested, necessitating multiple onBehalfOf elements. Except for these cases, there should be no more than two onBehalfOf references in a message.
	 *
	 */
	OnBehalfOf getOnBehalfOf();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	UnprocessedElementWrapper getOriginalMessage();
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
	LoanAcknowledgement build();
	
	LoanAcknowledgement.LoanAcknowledgementBuilder toBuilder();
	
	static LoanAcknowledgement.LoanAcknowledgementBuilder builder() {
		return new LoanAcknowledgement.LoanAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAcknowledgement> getType() {
		return LoanAcknowledgement.class;
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
		processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.class, getOriginalMessage());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAcknowledgementBuilder extends LoanAcknowledgement, Message.MessageBuilder {
		ResponseMessageHeader.ResponseMessageHeaderBuilder getOrCreateHeader();
		@Override
		ResponseMessageHeader.ResponseMessageHeaderBuilder getHeader();
		Validation.ValidationBuilder getOrCreateValidation(int index);
		@Override
		List<? extends Validation.ValidationBuilder> getValidation();
		CorrelationId.CorrelationIdBuilder getOrCreateParentCorrelationId();
		@Override
		CorrelationId.CorrelationIdBuilder getParentCorrelationId();
		CorrelationId.CorrelationIdBuilder getOrCreateCorrelationId();
		@Override
		CorrelationId.CorrelationIdBuilder getCorrelationId();
		OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf();
		@Override
		OnBehalfOf.OnBehalfOfBuilder getOnBehalfOf();
		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOrCreateOriginalMessage();
		@Override
		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOriginalMessage();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		LoanAcknowledgement.LoanAcknowledgementBuilder setFpmlVersion(String fpmlVersion);
		@Override
		LoanAcknowledgement.LoanAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		LoanAcknowledgement.LoanAcknowledgementBuilder setActualBuild(Integer actualBuild);
		LoanAcknowledgement.LoanAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		LoanAcknowledgement.LoanAcknowledgementBuilder addValidation(Validation validation);
		LoanAcknowledgement.LoanAcknowledgementBuilder addValidation(Validation validation, int idx);
		LoanAcknowledgement.LoanAcknowledgementBuilder addValidation(List<? extends Validation> validation);
		LoanAcknowledgement.LoanAcknowledgementBuilder setValidation(List<? extends Validation> validation);
		LoanAcknowledgement.LoanAcknowledgementBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		LoanAcknowledgement.LoanAcknowledgementBuilder setCorrelationId(CorrelationId correlationId);
		LoanAcknowledgement.LoanAcknowledgementBuilder setSequenceNumber(Integer sequenceNumber);
		LoanAcknowledgement.LoanAcknowledgementBuilder setOnBehalfOf(OnBehalfOf onBehalfOf);
		LoanAcknowledgement.LoanAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);
		LoanAcknowledgement.LoanAcknowledgementBuilder addParty(Party party);
		LoanAcknowledgement.LoanAcknowledgementBuilder addParty(Party party, int idx);
		LoanAcknowledgement.LoanAcknowledgementBuilder addParty(List<? extends Party> party);
		LoanAcknowledgement.LoanAcknowledgementBuilder setParty(List<? extends Party> party);
		LoanAcknowledgement.LoanAcknowledgementBuilder addAccount(Account account);
		LoanAcknowledgement.LoanAcknowledgementBuilder addAccount(Account account, int idx);
		LoanAcknowledgement.LoanAcknowledgementBuilder addAccount(List<? extends Account> account);
		LoanAcknowledgement.LoanAcknowledgementBuilder setAccount(List<? extends Account> account);

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
			processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.UnprocessedElementWrapperBuilder.class, getOriginalMessage());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		LoanAcknowledgement.LoanAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAcknowledgement  ***********************/
	class LoanAcknowledgementImpl extends Message.MessageImpl implements LoanAcknowledgement {
		private final ResponseMessageHeader header;
		private final List<? extends Validation> validation;
		private final CorrelationId parentCorrelationId;
		private final CorrelationId correlationId;
		private final Integer sequenceNumber;
		private final OnBehalfOf onBehalfOf;
		private final UnprocessedElementWrapper originalMessage;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected LoanAcknowledgementImpl(LoanAcknowledgement.LoanAcknowledgementBuilder builder) {
			super(builder);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.validation = ofNullable(builder.getValidation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.parentCorrelationId = ofNullable(builder.getParentCorrelationId()).map(f->f.build()).orElse(null);
			this.correlationId = ofNullable(builder.getCorrelationId()).map(f->f.build()).orElse(null);
			this.sequenceNumber = builder.getSequenceNumber();
			this.onBehalfOf = ofNullable(builder.getOnBehalfOf()).map(f->f.build()).orElse(null);
			this.originalMessage = ofNullable(builder.getOriginalMessage()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("header")
		public ResponseMessageHeader getHeader() {
			return header;
		}
		
		@Override
		@RosettaAttribute("validation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("validation")
		public List<? extends Validation> getValidation() {
			return validation;
		}
		
		@Override
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parentCorrelationId")
		public CorrelationId getParentCorrelationId() {
			return parentCorrelationId;
		}
		
		@Override
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("correlationId")
		public CorrelationId getCorrelationId() {
			return correlationId;
		}
		
		@Override
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sequenceNumber")
		public Integer getSequenceNumber() {
			return sequenceNumber;
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("onBehalfOf")
		public OnBehalfOf getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		@RosettaAttribute("originalMessage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalMessage")
		public UnprocessedElementWrapper getOriginalMessage() {
			return originalMessage;
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
		public LoanAcknowledgement build() {
			return this;
		}
		
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder toBuilder() {
			LoanAcknowledgement.LoanAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAcknowledgement.LoanAcknowledgementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getValidation()).ifPresent(builder::setValidation);
			ofNullable(getParentCorrelationId()).ifPresent(builder::setParentCorrelationId);
			ofNullable(getCorrelationId()).ifPresent(builder::setCorrelationId);
			ofNullable(getSequenceNumber()).ifPresent(builder::setSequenceNumber);
			ofNullable(getOnBehalfOf()).ifPresent(builder::setOnBehalfOf);
			ofNullable(getOriginalMessage()).ifPresent(builder::setOriginalMessage);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAcknowledgement _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!ListEquals.listEquals(validation, _that.getValidation())) return false;
			if (!Objects.equals(parentCorrelationId, _that.getParentCorrelationId())) return false;
			if (!Objects.equals(correlationId, _that.getCorrelationId())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!Objects.equals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!Objects.equals(originalMessage, _that.getOriginalMessage())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validation != null ? validation.hashCode() : 0);
			_result = 31 * _result + (parentCorrelationId != null ? parentCorrelationId.hashCode() : 0);
			_result = 31 * _result + (correlationId != null ? correlationId.hashCode() : 0);
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			_result = 31 * _result + (originalMessage != null ? originalMessage.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAcknowledgement {" +
				"header=" + this.header + ", " +
				"validation=" + this.validation + ", " +
				"parentCorrelationId=" + this.parentCorrelationId + ", " +
				"correlationId=" + this.correlationId + ", " +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"originalMessage=" + this.originalMessage + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAcknowledgement  ***********************/
	class LoanAcknowledgementBuilderImpl extends Message.MessageBuilderImpl implements LoanAcknowledgement.LoanAcknowledgementBuilder {
	
		protected ResponseMessageHeader.ResponseMessageHeaderBuilder header;
		protected List<Validation.ValidationBuilder> validation = new ArrayList<>();
		protected CorrelationId.CorrelationIdBuilder parentCorrelationId;
		protected CorrelationId.CorrelationIdBuilder correlationId;
		protected Integer sequenceNumber;
		protected OnBehalfOf.OnBehalfOfBuilder onBehalfOf;
		protected UnprocessedElementWrapper.UnprocessedElementWrapperBuilder originalMessage;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("header")
		public ResponseMessageHeader.ResponseMessageHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder getOrCreateHeader() {
			ResponseMessageHeader.ResponseMessageHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = ResponseMessageHeader.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("validation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("validation")
		public List<? extends Validation.ValidationBuilder> getValidation() {
			return validation;
		}
		
		@Override
		public Validation.ValidationBuilder getOrCreateValidation(int index) {
			if (validation==null) {
				this.validation = new ArrayList<>();
			}
			return getIndex(validation, index, () -> {
						Validation.ValidationBuilder newValidation = Validation.builder();
						return newValidation;
					});
		}
		
		@Override
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parentCorrelationId")
		public CorrelationId.CorrelationIdBuilder getParentCorrelationId() {
			return parentCorrelationId;
		}
		
		@Override
		public CorrelationId.CorrelationIdBuilder getOrCreateParentCorrelationId() {
			CorrelationId.CorrelationIdBuilder result;
			if (parentCorrelationId!=null) {
				result = parentCorrelationId;
			}
			else {
				result = parentCorrelationId = CorrelationId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("correlationId")
		public CorrelationId.CorrelationIdBuilder getCorrelationId() {
			return correlationId;
		}
		
		@Override
		public CorrelationId.CorrelationIdBuilder getOrCreateCorrelationId() {
			CorrelationId.CorrelationIdBuilder result;
			if (correlationId!=null) {
				result = correlationId;
			}
			else {
				result = correlationId = CorrelationId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sequenceNumber")
		public Integer getSequenceNumber() {
			return sequenceNumber;
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("onBehalfOf")
		public OnBehalfOf.OnBehalfOfBuilder getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf() {
			OnBehalfOf.OnBehalfOfBuilder result;
			if (onBehalfOf!=null) {
				result = onBehalfOf;
			}
			else {
				result = onBehalfOf = OnBehalfOf.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originalMessage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalMessage")
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOriginalMessage() {
			return originalMessage;
		}
		
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOrCreateOriginalMessage() {
			UnprocessedElementWrapper.UnprocessedElementWrapperBuilder result;
			if (originalMessage!=null) {
				result = originalMessage;
			}
			else {
				result = originalMessage = UnprocessedElementWrapper.builder();
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
		public LoanAcknowledgement.LoanAcknowledgementBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("header")
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder addValidation(List<? extends Validation> validations) {
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
		public LoanAcknowledgement.LoanAcknowledgementBuilder setValidation(List<? extends Validation> validations) {
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
		public LoanAcknowledgement.LoanAcknowledgementBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correlationId")
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder setCorrelationId(CorrelationId _correlationId) {
			this.correlationId = _correlationId == null ? null : _correlationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sequenceNumber")
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder setOnBehalfOf(OnBehalfOf _onBehalfOf) {
			this.onBehalfOf = _onBehalfOf == null ? null : _onBehalfOf.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originalMessage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalMessage")
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder setOriginalMessage(UnprocessedElementWrapper _originalMessage) {
			this.originalMessage = _originalMessage == null ? null : _originalMessage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder addParty(List<? extends Party> partys) {
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
		public LoanAcknowledgement.LoanAcknowledgementBuilder setParty(List<? extends Party> partys) {
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
		public LoanAcknowledgement.LoanAcknowledgementBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder addAccount(List<? extends Account> accounts) {
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
		public LoanAcknowledgement.LoanAcknowledgementBuilder setAccount(List<? extends Account> accounts) {
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
		public LoanAcknowledgement build() {
			return new LoanAcknowledgement.LoanAcknowledgementImpl(this);
		}
		
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder prune() {
			super.prune();
			if (header!=null && !header.prune().hasData()) header = null;
			validation = validation.stream().filter(b->b!=null).<Validation.ValidationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (parentCorrelationId!=null && !parentCorrelationId.prune().hasData()) parentCorrelationId = null;
			if (correlationId!=null && !correlationId.prune().hasData()) correlationId = null;
			if (onBehalfOf!=null && !onBehalfOf.prune().hasData()) onBehalfOf = null;
			if (originalMessage!=null && !originalMessage.prune().hasData()) originalMessage = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getValidation()!=null && getValidation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParentCorrelationId()!=null && getParentCorrelationId().hasData()) return true;
			if (getCorrelationId()!=null && getCorrelationId().hasData()) return true;
			if (getSequenceNumber()!=null) return true;
			if (getOnBehalfOf()!=null && getOnBehalfOf().hasData()) return true;
			if (getOriginalMessage()!=null && getOriginalMessage().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAcknowledgement.LoanAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanAcknowledgement.LoanAcknowledgementBuilder o = (LoanAcknowledgement.LoanAcknowledgementBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getValidation(), o.getValidation(), this::getOrCreateValidation);
			merger.mergeRosetta(getParentCorrelationId(), o.getParentCorrelationId(), this::setParentCorrelationId);
			merger.mergeRosetta(getCorrelationId(), o.getCorrelationId(), this::setCorrelationId);
			merger.mergeRosetta(getOnBehalfOf(), o.getOnBehalfOf(), this::setOnBehalfOf);
			merger.mergeRosetta(getOriginalMessage(), o.getOriginalMessage(), this::setOriginalMessage);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			merger.mergeBasic(getSequenceNumber(), o.getSequenceNumber(), this::setSequenceNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAcknowledgement _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!ListEquals.listEquals(validation, _that.getValidation())) return false;
			if (!Objects.equals(parentCorrelationId, _that.getParentCorrelationId())) return false;
			if (!Objects.equals(correlationId, _that.getCorrelationId())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!Objects.equals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!Objects.equals(originalMessage, _that.getOriginalMessage())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validation != null ? validation.hashCode() : 0);
			_result = 31 * _result + (parentCorrelationId != null ? parentCorrelationId.hashCode() : 0);
			_result = 31 * _result + (correlationId != null ? correlationId.hashCode() : 0);
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			_result = 31 * _result + (originalMessage != null ? originalMessage.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAcknowledgementBuilder {" +
				"header=" + this.header + ", " +
				"validation=" + this.validation + ", " +
				"parentCorrelationId=" + this.parentCorrelationId + ", " +
				"correlationId=" + this.correlationId + ", " +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"originalMessage=" + this.originalMessage + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

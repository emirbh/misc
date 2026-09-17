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
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.meta.RequestRetransmissionMeta;
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
 * Provision A message to request that a message be retransmitted. The original message will typically be a component of a group of messages, such as a portfolio or a report in multiple parts.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A message to request that a message be retransmitted. The original message will typically be a component of a group of messages, such as a portfolio or a report in multiple parts.
 *
 */
@RosettaDataType(value="RequestRetransmission", builder=RequestRetransmission.RequestRetransmissionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequestRetransmission", model="fpml", builder=RequestRetransmission.RequestRetransmissionBuilderImpl.class, version="2.1.1")
public interface RequestRetransmission extends NonCorrectableRequestMessage {

	RequestRetransmissionMeta metaData = new RequestRetransmissionMeta();

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
	PortfolioConstituentReference getPortfolioReference();
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
	ReportSectionIdentification getReportIdentification();
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
	RequestRetransmission build();
	
	RequestRetransmission.RequestRetransmissionBuilder toBuilder();
	
	static RequestRetransmission.RequestRetransmissionBuilder builder() {
		return new RequestRetransmission.RequestRetransmissionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestRetransmission> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequestRetransmission> getType() {
		return RequestRetransmission.class;
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
		processRosetta(path.newSubPath("portfolioReference"), processor, PortfolioConstituentReference.class, getPortfolioReference());
		processRosetta(path.newSubPath("reportIdentification"), processor, ReportSectionIdentification.class, getReportIdentification());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestRetransmissionBuilder extends RequestRetransmission, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		PortfolioConstituentReference.PortfolioConstituentReferenceBuilder getOrCreatePortfolioReference();
		@Override
		PortfolioConstituentReference.PortfolioConstituentReferenceBuilder getPortfolioReference();
		ReportSectionIdentification.ReportSectionIdentificationBuilder getOrCreateReportIdentification();
		@Override
		ReportSectionIdentification.ReportSectionIdentificationBuilder getReportIdentification();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		RequestRetransmission.RequestRetransmissionBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder setActualBuild(Integer actualBuild);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder setHeader(RequestMessageHeader header);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder addValidation(Validation validation);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder addValidation(Validation validation, int idx);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder addValidation(List<? extends Validation> validation);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder setValidation(List<? extends Validation> validation);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		RequestRetransmission.RequestRetransmissionBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		RequestRetransmission.RequestRetransmissionBuilder setPortfolioReference(PortfolioConstituentReference portfolioReference);
		RequestRetransmission.RequestRetransmissionBuilder setReportIdentification(ReportSectionIdentification reportIdentification);
		RequestRetransmission.RequestRetransmissionBuilder addParty(Party party);
		RequestRetransmission.RequestRetransmissionBuilder addParty(Party party, int idx);
		RequestRetransmission.RequestRetransmissionBuilder addParty(List<? extends Party> party);
		RequestRetransmission.RequestRetransmissionBuilder setParty(List<? extends Party> party);
		RequestRetransmission.RequestRetransmissionBuilder addAccount(Account account);
		RequestRetransmission.RequestRetransmissionBuilder addAccount(Account account, int idx);
		RequestRetransmission.RequestRetransmissionBuilder addAccount(List<? extends Account> account);
		RequestRetransmission.RequestRetransmissionBuilder setAccount(List<? extends Account> account);

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
			processRosetta(path.newSubPath("portfolioReference"), processor, PortfolioConstituentReference.PortfolioConstituentReferenceBuilder.class, getPortfolioReference());
			processRosetta(path.newSubPath("reportIdentification"), processor, ReportSectionIdentification.ReportSectionIdentificationBuilder.class, getReportIdentification());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		RequestRetransmission.RequestRetransmissionBuilder prune();
	}

	/*********************** Immutable Implementation of RequestRetransmission  ***********************/
	class RequestRetransmissionImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements RequestRetransmission {
		private final PortfolioConstituentReference portfolioReference;
		private final ReportSectionIdentification reportIdentification;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected RequestRetransmissionImpl(RequestRetransmission.RequestRetransmissionBuilder builder) {
			super(builder);
			this.portfolioReference = ofNullable(builder.getPortfolioReference()).map(f->f.build()).orElse(null);
			this.reportIdentification = ofNullable(builder.getReportIdentification()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("portfolioReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portfolioReference")
		public PortfolioConstituentReference getPortfolioReference() {
			return portfolioReference;
		}
		
		@Override
		@RosettaAttribute("reportIdentification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportIdentification")
		public ReportSectionIdentification getReportIdentification() {
			return reportIdentification;
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
		public RequestRetransmission build() {
			return this;
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder toBuilder() {
			RequestRetransmission.RequestRetransmissionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestRetransmission.RequestRetransmissionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPortfolioReference()).ifPresent(builder::setPortfolioReference);
			ofNullable(getReportIdentification()).ifPresent(builder::setReportIdentification);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestRetransmission _that = getType().cast(o);
		
			if (!Objects.equals(portfolioReference, _that.getPortfolioReference())) return false;
			if (!Objects.equals(reportIdentification, _that.getReportIdentification())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (portfolioReference != null ? portfolioReference.hashCode() : 0);
			_result = 31 * _result + (reportIdentification != null ? reportIdentification.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestRetransmission {" +
				"portfolioReference=" + this.portfolioReference + ", " +
				"reportIdentification=" + this.reportIdentification + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestRetransmission  ***********************/
	class RequestRetransmissionBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl implements RequestRetransmission.RequestRetransmissionBuilder {
	
		protected PortfolioConstituentReference.PortfolioConstituentReferenceBuilder portfolioReference;
		protected ReportSectionIdentification.ReportSectionIdentificationBuilder reportIdentification;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("portfolioReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portfolioReference")
		public PortfolioConstituentReference.PortfolioConstituentReferenceBuilder getPortfolioReference() {
			return portfolioReference;
		}
		
		@Override
		public PortfolioConstituentReference.PortfolioConstituentReferenceBuilder getOrCreatePortfolioReference() {
			PortfolioConstituentReference.PortfolioConstituentReferenceBuilder result;
			if (portfolioReference!=null) {
				result = portfolioReference;
			}
			else {
				result = portfolioReference = PortfolioConstituentReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportIdentification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportIdentification")
		public ReportSectionIdentification.ReportSectionIdentificationBuilder getReportIdentification() {
			return reportIdentification;
		}
		
		@Override
		public ReportSectionIdentification.ReportSectionIdentificationBuilder getOrCreateReportIdentification() {
			ReportSectionIdentification.ReportSectionIdentificationBuilder result;
			if (reportIdentification!=null) {
				result = reportIdentification;
			}
			else {
				result = reportIdentification = ReportSectionIdentification.builder();
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
		public RequestRetransmission.RequestRetransmissionBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addValidation(List<? extends Validation> validations) {
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
		public RequestRetransmission.RequestRetransmissionBuilder setValidation(List<? extends Validation> validations) {
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
		public RequestRetransmission.RequestRetransmissionBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public RequestRetransmission.RequestRetransmissionBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public RequestRetransmission.RequestRetransmissionBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public RequestRetransmission.RequestRetransmissionBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("portfolioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("portfolioReference")
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder setPortfolioReference(PortfolioConstituentReference _portfolioReference) {
			this.portfolioReference = _portfolioReference == null ? null : _portfolioReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportIdentification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportIdentification")
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder setReportIdentification(ReportSectionIdentification _reportIdentification) {
			this.reportIdentification = _reportIdentification == null ? null : _reportIdentification.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addParty(List<? extends Party> partys) {
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
		public RequestRetransmission.RequestRetransmissionBuilder setParty(List<? extends Party> partys) {
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
		public RequestRetransmission.RequestRetransmissionBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder addAccount(List<? extends Account> accounts) {
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
		public RequestRetransmission.RequestRetransmissionBuilder setAccount(List<? extends Account> accounts) {
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
		public RequestRetransmission build() {
			return new RequestRetransmission.RequestRetransmissionImpl(this);
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder prune() {
			super.prune();
			if (portfolioReference!=null && !portfolioReference.prune().hasData()) portfolioReference = null;
			if (reportIdentification!=null && !reportIdentification.prune().hasData()) reportIdentification = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPortfolioReference()!=null && getPortfolioReference().hasData()) return true;
			if (getReportIdentification()!=null && getReportIdentification().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RequestRetransmission.RequestRetransmissionBuilder o = (RequestRetransmission.RequestRetransmissionBuilder) other;
			
			merger.mergeRosetta(getPortfolioReference(), o.getPortfolioReference(), this::setPortfolioReference);
			merger.mergeRosetta(getReportIdentification(), o.getReportIdentification(), this::setReportIdentification);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestRetransmission _that = getType().cast(o);
		
			if (!Objects.equals(portfolioReference, _that.getPortfolioReference())) return false;
			if (!Objects.equals(reportIdentification, _that.getReportIdentification())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (portfolioReference != null ? portfolioReference.hashCode() : 0);
			_result = 31 * _result + (reportIdentification != null ? reportIdentification.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestRetransmissionBuilder {" +
				"portfolioReference=" + this.portfolioReference + ", " +
				"reportIdentification=" + this.reportIdentification + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

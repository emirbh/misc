package fpml.consolidated.valuation.fpmlreporting;

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
import fpml.consolidated.doc.PartyTradeInformationSimple;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NotificationMessage;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.msg.ReportIdentification;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.valuation.fpmlreporting.meta.ValuationReportRetractedMeta;
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
 * Provision A type defining the content model for a message that retracts a valuation report. This says that the most recently supplied valuation is erroneous and a previous value should be used.
 *
 */
@RosettaDataType(value="ValuationReportRetracted", builder=ValuationReportRetracted.ValuationReportRetractedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ValuationReportRetracted", model="fpml", builder=ValuationReportRetracted.ValuationReportRetractedBuilderImpl.class, version="2.1.1")
public interface ValuationReportRetracted extends NotificationMessage {

	ValuationReportRetractedMeta metaData = new ValuationReportRetractedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifiers for the report instance and section.
	 *
	 */
	ReportIdentification getReportIdentification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specific characteristics included in the report.
	 *
	 */
	ReportContents getReportContents();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date for which this request was generated.
	 *
	 */
	IdentifiedDate getAsOfDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision One or more trade identifiers needed to uniquely identify a trade.
	 *
	 */
	List<? extends PartyTradeIdentifier> getPartyTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Holds party-specific information about the trade that is being retracted.
	 *
	 */
	List<? extends PartyTradeInformationSimple> getPartyTradeInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
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
	 */
	List<? extends Account> getAccount();

	/*********************** Build Methods  ***********************/
	ValuationReportRetracted build();
	
	ValuationReportRetracted.ValuationReportRetractedBuilder toBuilder();
	
	static ValuationReportRetracted.ValuationReportRetractedBuilder builder() {
		return new ValuationReportRetracted.ValuationReportRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationReportRetracted> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuationReportRetracted> getType() {
		return ValuationReportRetracted.class;
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
		processRosetta(path.newSubPath("reportIdentification"), processor, ReportIdentification.class, getReportIdentification());
		processRosetta(path.newSubPath("reportContents"), processor, ReportContents.class, getReportContents());
		processRosetta(path.newSubPath("asOfDate"), processor, IdentifiedDate.class, getAsOfDate());
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processRosetta(path.newSubPath("partyTradeInformation"), processor, PartyTradeInformationSimple.class, getPartyTradeInformation());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationReportRetractedBuilder extends ValuationReportRetracted, NotificationMessage.NotificationMessageBuilder {
		ReportIdentification.ReportIdentificationBuilder getOrCreateReportIdentification();
		@Override
		ReportIdentification.ReportIdentificationBuilder getReportIdentification();
		ReportContents.ReportContentsBuilder getOrCreateReportContents();
		@Override
		ReportContents.ReportContentsBuilder getReportContents();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateAsOfDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getAsOfDate();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier();
		PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder getOrCreatePartyTradeInformation(int index);
		@Override
		List<? extends PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder> getPartyTradeInformation();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder setActualBuild(Integer actualBuild);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder setHeader(NotificationMessageHeader header);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder addValidation(Validation validation);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder addValidation(Validation validation, int idx);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder addValidation(List<? extends Validation> validation);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder setValidation(List<? extends Validation> validation);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		ValuationReportRetracted.ValuationReportRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		ValuationReportRetracted.ValuationReportRetractedBuilder setReportIdentification(ReportIdentification reportIdentification);
		ValuationReportRetracted.ValuationReportRetractedBuilder setReportContents(ReportContents reportContents);
		ValuationReportRetracted.ValuationReportRetractedBuilder setAsOfDate(IdentifiedDate asOfDate);
		ValuationReportRetracted.ValuationReportRetractedBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier);
		ValuationReportRetracted.ValuationReportRetractedBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier, int idx);
		ValuationReportRetracted.ValuationReportRetractedBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		ValuationReportRetracted.ValuationReportRetractedBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		ValuationReportRetracted.ValuationReportRetractedBuilder addPartyTradeInformation(PartyTradeInformationSimple partyTradeInformation);
		ValuationReportRetracted.ValuationReportRetractedBuilder addPartyTradeInformation(PartyTradeInformationSimple partyTradeInformation, int idx);
		ValuationReportRetracted.ValuationReportRetractedBuilder addPartyTradeInformation(List<? extends PartyTradeInformationSimple> partyTradeInformation);
		ValuationReportRetracted.ValuationReportRetractedBuilder setPartyTradeInformation(List<? extends PartyTradeInformationSimple> partyTradeInformation);
		ValuationReportRetracted.ValuationReportRetractedBuilder addParty(Party party);
		ValuationReportRetracted.ValuationReportRetractedBuilder addParty(Party party, int idx);
		ValuationReportRetracted.ValuationReportRetractedBuilder addParty(List<? extends Party> party);
		ValuationReportRetracted.ValuationReportRetractedBuilder setParty(List<? extends Party> party);
		ValuationReportRetracted.ValuationReportRetractedBuilder addAccount(Account account);
		ValuationReportRetracted.ValuationReportRetractedBuilder addAccount(Account account, int idx);
		ValuationReportRetracted.ValuationReportRetractedBuilder addAccount(List<? extends Account> account);
		ValuationReportRetracted.ValuationReportRetractedBuilder setAccount(List<? extends Account> account);

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
			processRosetta(path.newSubPath("reportIdentification"), processor, ReportIdentification.ReportIdentificationBuilder.class, getReportIdentification());
			processRosetta(path.newSubPath("reportContents"), processor, ReportContents.ReportContentsBuilder.class, getReportContents());
			processRosetta(path.newSubPath("asOfDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAsOfDate());
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processRosetta(path.newSubPath("partyTradeInformation"), processor, PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder.class, getPartyTradeInformation());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		ValuationReportRetracted.ValuationReportRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationReportRetracted  ***********************/
	class ValuationReportRetractedImpl extends NotificationMessage.NotificationMessageImpl implements ValuationReportRetracted {
		private final ReportIdentification reportIdentification;
		private final ReportContents reportContents;
		private final IdentifiedDate asOfDate;
		private final List<? extends PartyTradeIdentifier> partyTradeIdentifier;
		private final List<? extends PartyTradeInformationSimple> partyTradeInformation;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected ValuationReportRetractedImpl(ValuationReportRetracted.ValuationReportRetractedBuilder builder) {
			super(builder);
			this.reportIdentification = ofNullable(builder.getReportIdentification()).map(f->f.build()).orElse(null);
			this.reportContents = ofNullable(builder.getReportContents()).map(f->f.build()).orElse(null);
			this.asOfDate = ofNullable(builder.getAsOfDate()).map(f->f.build()).orElse(null);
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyTradeInformation = ofNullable(builder.getPartyTradeInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reportIdentification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportIdentification")
		public ReportIdentification getReportIdentification() {
			return reportIdentification;
		}
		
		@Override
		@RosettaAttribute("reportContents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportContents")
		public ReportContents getReportContents() {
			return reportContents;
		}
		
		@Override
		@RosettaAttribute("asOfDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asOfDate")
		public IdentifiedDate getAsOfDate() {
			return asOfDate;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("partyTradeInformation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeInformation")
		public List<? extends PartyTradeInformationSimple> getPartyTradeInformation() {
			return partyTradeInformation;
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
		public ValuationReportRetracted build() {
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder toBuilder() {
			ValuationReportRetracted.ValuationReportRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationReportRetracted.ValuationReportRetractedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReportIdentification()).ifPresent(builder::setReportIdentification);
			ofNullable(getReportContents()).ifPresent(builder::setReportContents);
			ofNullable(getAsOfDate()).ifPresent(builder::setAsOfDate);
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getPartyTradeInformation()).ifPresent(builder::setPartyTradeInformation);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationReportRetracted _that = getType().cast(o);
		
			if (!Objects.equals(reportIdentification, _that.getReportIdentification())) return false;
			if (!Objects.equals(reportContents, _that.getReportContents())) return false;
			if (!Objects.equals(asOfDate, _that.getAsOfDate())) return false;
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportIdentification != null ? reportIdentification.hashCode() : 0);
			_result = 31 * _result + (reportContents != null ? reportContents.hashCode() : 0);
			_result = 31 * _result + (asOfDate != null ? asOfDate.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationReportRetracted {" +
				"reportIdentification=" + this.reportIdentification + ", " +
				"reportContents=" + this.reportContents + ", " +
				"asOfDate=" + this.asOfDate + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ValuationReportRetracted  ***********************/
	class ValuationReportRetractedBuilderImpl extends NotificationMessage.NotificationMessageBuilderImpl implements ValuationReportRetracted.ValuationReportRetractedBuilder {
	
		protected ReportIdentification.ReportIdentificationBuilder reportIdentification;
		protected ReportContents.ReportContentsBuilder reportContents;
		protected IdentifiedDate.IdentifiedDateBuilder asOfDate;
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> partyTradeIdentifier = new ArrayList<>();
		protected List<PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder> partyTradeInformation = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("reportIdentification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportIdentification")
		public ReportIdentification.ReportIdentificationBuilder getReportIdentification() {
			return reportIdentification;
		}
		
		@Override
		public ReportIdentification.ReportIdentificationBuilder getOrCreateReportIdentification() {
			ReportIdentification.ReportIdentificationBuilder result;
			if (reportIdentification!=null) {
				result = reportIdentification;
			}
			else {
				result = reportIdentification = ReportIdentification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportContents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportContents")
		public ReportContents.ReportContentsBuilder getReportContents() {
			return reportContents;
		}
		
		@Override
		public ReportContents.ReportContentsBuilder getOrCreateReportContents() {
			ReportContents.ReportContentsBuilder result;
			if (reportContents!=null) {
				result = reportContents;
			}
			else {
				result = reportContents = ReportContents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("asOfDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asOfDate")
		public IdentifiedDate.IdentifiedDateBuilder getAsOfDate() {
			return asOfDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateAsOfDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (asOfDate!=null) {
				result = asOfDate;
			}
			else {
				result = asOfDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int index) {
			if (partyTradeIdentifier==null) {
				this.partyTradeIdentifier = new ArrayList<>();
			}
			return getIndex(partyTradeIdentifier, index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newPartyTradeIdentifier = PartyTradeIdentifier.builder();
						return newPartyTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("partyTradeInformation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeInformation")
		public List<? extends PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder> getPartyTradeInformation() {
			return partyTradeInformation;
		}
		
		@Override
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder getOrCreatePartyTradeInformation(int index) {
			if (partyTradeInformation==null) {
				this.partyTradeInformation = new ArrayList<>();
			}
			return getIndex(partyTradeInformation, index, () -> {
						PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder newPartyTradeInformation = PartyTradeInformationSimple.builder();
						return newPartyTradeInformation;
					});
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
		public ValuationReportRetracted.ValuationReportRetractedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder setHeader(NotificationMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addValidation(List<? extends Validation> validations) {
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
		public ValuationReportRetracted.ValuationReportRetractedBuilder setValidation(List<? extends Validation> validations) {
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
		public ValuationReportRetracted.ValuationReportRetractedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ValuationReportRetracted.ValuationReportRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ValuationReportRetracted.ValuationReportRetractedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public ValuationReportRetracted.ValuationReportRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportIdentification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportIdentification")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder setReportIdentification(ReportIdentification _reportIdentification) {
			this.reportIdentification = _reportIdentification == null ? null : _reportIdentification.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportContents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportContents")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder setReportContents(ReportContents _reportContents) {
			this.reportContents = _reportContents == null ? null : _reportContents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("asOfDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asOfDate")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder setAsOfDate(IdentifiedDate _asOfDate) {
			this.asOfDate = _asOfDate == null ? null : _asOfDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier) {
			if (_partyTradeIdentifier != null) {
				this.partyTradeIdentifier.add(_partyTradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier, int idx) {
			getIndex(this.partyTradeIdentifier, idx, () -> _partyTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers != null) {
				for (final PartyTradeIdentifier toAdd : partyTradeIdentifiers) {
					this.partyTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers == null) {
				this.partyTradeIdentifier = new ArrayList<>();
			} else {
				this.partyTradeIdentifier = partyTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeInformation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyTradeInformation")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addPartyTradeInformation(PartyTradeInformationSimple _partyTradeInformation) {
			if (_partyTradeInformation != null) {
				this.partyTradeInformation.add(_partyTradeInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addPartyTradeInformation(PartyTradeInformationSimple _partyTradeInformation, int idx) {
			getIndex(this.partyTradeInformation, idx, () -> _partyTradeInformation.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addPartyTradeInformation(List<? extends PartyTradeInformationSimple> partyTradeInformations) {
			if (partyTradeInformations != null) {
				for (final PartyTradeInformationSimple toAdd : partyTradeInformations) {
					this.partyTradeInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeInformation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyTradeInformation")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder setPartyTradeInformation(List<? extends PartyTradeInformationSimple> partyTradeInformations) {
			if (partyTradeInformations == null) {
				this.partyTradeInformation = new ArrayList<>();
			} else {
				this.partyTradeInformation = partyTradeInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addParty(List<? extends Party> partys) {
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
		public ValuationReportRetracted.ValuationReportRetractedBuilder setParty(List<? extends Party> partys) {
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
		public ValuationReportRetracted.ValuationReportRetractedBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder addAccount(List<? extends Account> accounts) {
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
		public ValuationReportRetracted.ValuationReportRetractedBuilder setAccount(List<? extends Account> accounts) {
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
		public ValuationReportRetracted build() {
			return new ValuationReportRetracted.ValuationReportRetractedImpl(this);
		}
		
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder prune() {
			super.prune();
			if (reportIdentification!=null && !reportIdentification.prune().hasData()) reportIdentification = null;
			if (reportContents!=null && !reportContents.prune().hasData()) reportContents = null;
			if (asOfDate!=null && !asOfDate.prune().hasData()) asOfDate = null;
			partyTradeIdentifier = partyTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyTradeInformation = partyTradeInformation.stream().filter(b->b!=null).<PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getReportIdentification()!=null && getReportIdentification().hasData()) return true;
			if (getReportContents()!=null && getReportContents().hasData()) return true;
			if (getAsOfDate()!=null && getAsOfDate().hasData()) return true;
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyTradeInformation()!=null && getPartyTradeInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationReportRetracted.ValuationReportRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ValuationReportRetracted.ValuationReportRetractedBuilder o = (ValuationReportRetracted.ValuationReportRetractedBuilder) other;
			
			merger.mergeRosetta(getReportIdentification(), o.getReportIdentification(), this::setReportIdentification);
			merger.mergeRosetta(getReportContents(), o.getReportContents(), this::setReportContents);
			merger.mergeRosetta(getAsOfDate(), o.getAsOfDate(), this::setAsOfDate);
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::getOrCreatePartyTradeIdentifier);
			merger.mergeRosetta(getPartyTradeInformation(), o.getPartyTradeInformation(), this::getOrCreatePartyTradeInformation);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationReportRetracted _that = getType().cast(o);
		
			if (!Objects.equals(reportIdentification, _that.getReportIdentification())) return false;
			if (!Objects.equals(reportContents, _that.getReportContents())) return false;
			if (!Objects.equals(asOfDate, _that.getAsOfDate())) return false;
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportIdentification != null ? reportIdentification.hashCode() : 0);
			_result = 31 * _result + (reportContents != null ? reportContents.hashCode() : 0);
			_result = 31 * _result + (asOfDate != null ? asOfDate.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationReportRetractedBuilder {" +
				"reportIdentification=" + this.reportIdentification + ", " +
				"reportContents=" + this.reportContents + ", " +
				"asOfDate=" + this.asOfDate + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

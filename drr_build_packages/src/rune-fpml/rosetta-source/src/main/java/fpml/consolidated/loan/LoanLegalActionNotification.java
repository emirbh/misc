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
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.meta.LoanLegalActionNotificationMeta;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import java.time.ZonedDateTime;
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
 * Provision A loan servicing notification which can be used to communicate any legal action-related servicing event.
 *
 */
@RosettaDataType(value="LoanLegalActionNotification", builder=LoanLegalActionNotification.LoanLegalActionNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionNotification", model="fpml", builder=LoanLegalActionNotification.LoanLegalActionNotificationBuilderImpl.class, version="2.1.1")
public interface LoanLegalActionNotification extends AbstractServicingNotification {

	LoanLegalActionNotificationMeta metaData = new LoanLegalActionNotificationMeta();

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
	List<? extends LoanLegalActionNotificationChoice0> getLoanLegalActionNotificationChoice0();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	LegalActionIdentifier getLegalActionIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	LoanLegalActionSummary getLegalActionSummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	LoanLegalAction getLegalAction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanLegalActionNotificationChoice1> getLoanLegalActionNotificationChoice1();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A legal entity or a subdivision of a legal entity.
	 *
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanLegalActionNotification build();
	
	LoanLegalActionNotification.LoanLegalActionNotificationBuilder toBuilder();
	
	static LoanLegalActionNotification.LoanLegalActionNotificationBuilder builder() {
		return new LoanLegalActionNotification.LoanLegalActionNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionNotification> getType() {
		return LoanLegalActionNotification.class;
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
		processor.processBasic(path.newSubPath("noticeDate"), ZonedDateTime.class, getNoticeDate(), this);
		processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
		processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.class, getEventPayment());
		processRosetta(path.newSubPath("loanLegalActionNotificationChoice0"), processor, LoanLegalActionNotificationChoice0.class, getLoanLegalActionNotificationChoice0());
		processRosetta(path.newSubPath("legalActionIdentifier"), processor, LegalActionIdentifier.class, getLegalActionIdentifier());
		processRosetta(path.newSubPath("legalActionSummary"), processor, LoanLegalActionSummary.class, getLegalActionSummary());
		processRosetta(path.newSubPath("legalAction"), processor, LoanLegalAction.class, getLegalAction());
		processRosetta(path.newSubPath("loanLegalActionNotificationChoice1"), processor, LoanLegalActionNotificationChoice1.class, getLoanLegalActionNotificationChoice1());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionNotificationBuilder extends LoanLegalActionNotification, AbstractServicingNotification.AbstractServicingNotificationBuilder {
		LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder getOrCreateLoanLegalActionNotificationChoice0(int index);
		@Override
		List<? extends LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder> getLoanLegalActionNotificationChoice0();
		LegalActionIdentifier.LegalActionIdentifierBuilder getOrCreateLegalActionIdentifier();
		@Override
		LegalActionIdentifier.LegalActionIdentifierBuilder getLegalActionIdentifier();
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder getOrCreateLegalActionSummary();
		@Override
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder getLegalActionSummary();
		LoanLegalAction.LoanLegalActionBuilder getOrCreateLegalAction();
		@Override
		LoanLegalAction.LoanLegalActionBuilder getLegalAction();
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder getOrCreateLoanLegalActionNotificationChoice1(int index);
		@Override
		List<? extends LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder> getLoanLegalActionNotificationChoice1();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addValidation(Validation validation);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setNoticeDate(ZonedDateTime noticeDate);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addEventPayment(EventPayment eventPayment);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addEventPayment(EventPayment eventPayment, int idx);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment);
		@Override
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addLoanLegalActionNotificationChoice0(LoanLegalActionNotificationChoice0 loanLegalActionNotificationChoice0);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addLoanLegalActionNotificationChoice0(LoanLegalActionNotificationChoice0 loanLegalActionNotificationChoice0, int idx);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addLoanLegalActionNotificationChoice0(List<? extends LoanLegalActionNotificationChoice0> loanLegalActionNotificationChoice0);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setLoanLegalActionNotificationChoice0(List<? extends LoanLegalActionNotificationChoice0> loanLegalActionNotificationChoice0);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setLegalActionIdentifier(LegalActionIdentifier legalActionIdentifier);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setLegalActionSummary(LoanLegalActionSummary legalActionSummary);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setLegalAction(LoanLegalAction legalAction);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addLoanLegalActionNotificationChoice1(LoanLegalActionNotificationChoice1 loanLegalActionNotificationChoice1);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addLoanLegalActionNotificationChoice1(LoanLegalActionNotificationChoice1 loanLegalActionNotificationChoice1, int idx);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addLoanLegalActionNotificationChoice1(List<? extends LoanLegalActionNotificationChoice1> loanLegalActionNotificationChoice1);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setLoanLegalActionNotificationChoice1(List<? extends LoanLegalActionNotificationChoice1> loanLegalActionNotificationChoice1);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addParty(Party party);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addParty(Party party, int idx);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder addParty(List<? extends Party> party);
		LoanLegalActionNotification.LoanLegalActionNotificationBuilder setParty(List<? extends Party> party);

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
			processor.processBasic(path.newSubPath("noticeDate"), ZonedDateTime.class, getNoticeDate(), this);
			processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
			processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.EventPaymentBuilder.class, getEventPayment());
			processRosetta(path.newSubPath("loanLegalActionNotificationChoice0"), processor, LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder.class, getLoanLegalActionNotificationChoice0());
			processRosetta(path.newSubPath("legalActionIdentifier"), processor, LegalActionIdentifier.LegalActionIdentifierBuilder.class, getLegalActionIdentifier());
			processRosetta(path.newSubPath("legalActionSummary"), processor, LoanLegalActionSummary.LoanLegalActionSummaryBuilder.class, getLegalActionSummary());
			processRosetta(path.newSubPath("legalAction"), processor, LoanLegalAction.LoanLegalActionBuilder.class, getLegalAction());
			processRosetta(path.newSubPath("loanLegalActionNotificationChoice1"), processor, LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder.class, getLoanLegalActionNotificationChoice1());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanLegalActionNotification.LoanLegalActionNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionNotification  ***********************/
	class LoanLegalActionNotificationImpl extends AbstractServicingNotification.AbstractServicingNotificationImpl implements LoanLegalActionNotification {
		private final List<? extends LoanLegalActionNotificationChoice0> loanLegalActionNotificationChoice0;
		private final LegalActionIdentifier legalActionIdentifier;
		private final LoanLegalActionSummary legalActionSummary;
		private final LoanLegalAction legalAction;
		private final List<? extends LoanLegalActionNotificationChoice1> loanLegalActionNotificationChoice1;
		private final List<? extends Party> party;
		
		protected LoanLegalActionNotificationImpl(LoanLegalActionNotification.LoanLegalActionNotificationBuilder builder) {
			super(builder);
			this.loanLegalActionNotificationChoice0 = ofNullable(builder.getLoanLegalActionNotificationChoice0()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.legalActionIdentifier = ofNullable(builder.getLegalActionIdentifier()).map(f->f.build()).orElse(null);
			this.legalActionSummary = ofNullable(builder.getLegalActionSummary()).map(f->f.build()).orElse(null);
			this.legalAction = ofNullable(builder.getLegalAction()).map(f->f.build()).orElse(null);
			this.loanLegalActionNotificationChoice1 = ofNullable(builder.getLoanLegalActionNotificationChoice1()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanLegalActionNotificationChoice0")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoice0")
		public List<? extends LoanLegalActionNotificationChoice0> getLoanLegalActionNotificationChoice0() {
			return loanLegalActionNotificationChoice0;
		}
		
		@Override
		@RosettaAttribute("legalActionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionIdentifier")
		public LegalActionIdentifier getLegalActionIdentifier() {
			return legalActionIdentifier;
		}
		
		@Override
		@RosettaAttribute("legalActionSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionSummary")
		public LoanLegalActionSummary getLegalActionSummary() {
			return legalActionSummary;
		}
		
		@Override
		@RosettaAttribute("legalAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalAction")
		public LoanLegalAction getLegalAction() {
			return legalAction;
		}
		
		@Override
		@RosettaAttribute("loanLegalActionNotificationChoice1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoice1")
		public List<? extends LoanLegalActionNotificationChoice1> getLoanLegalActionNotificationChoice1() {
			return loanLegalActionNotificationChoice1;
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
		public LoanLegalActionNotification build() {
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder toBuilder() {
			LoanLegalActionNotification.LoanLegalActionNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionNotification.LoanLegalActionNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanLegalActionNotificationChoice0()).ifPresent(builder::setLoanLegalActionNotificationChoice0);
			ofNullable(getLegalActionIdentifier()).ifPresent(builder::setLegalActionIdentifier);
			ofNullable(getLegalActionSummary()).ifPresent(builder::setLegalActionSummary);
			ofNullable(getLegalAction()).ifPresent(builder::setLegalAction);
			ofNullable(getLoanLegalActionNotificationChoice1()).ifPresent(builder::setLoanLegalActionNotificationChoice1);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanLegalActionNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanLegalActionNotificationChoice0, _that.getLoanLegalActionNotificationChoice0())) return false;
			if (!Objects.equals(legalActionIdentifier, _that.getLegalActionIdentifier())) return false;
			if (!Objects.equals(legalActionSummary, _that.getLegalActionSummary())) return false;
			if (!Objects.equals(legalAction, _that.getLegalAction())) return false;
			if (!ListEquals.listEquals(loanLegalActionNotificationChoice1, _that.getLoanLegalActionNotificationChoice1())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanLegalActionNotificationChoice0 != null ? loanLegalActionNotificationChoice0.hashCode() : 0);
			_result = 31 * _result + (legalActionIdentifier != null ? legalActionIdentifier.hashCode() : 0);
			_result = 31 * _result + (legalActionSummary != null ? legalActionSummary.hashCode() : 0);
			_result = 31 * _result + (legalAction != null ? legalAction.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionNotificationChoice1 != null ? loanLegalActionNotificationChoice1.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionNotification {" +
				"loanLegalActionNotificationChoice0=" + this.loanLegalActionNotificationChoice0 + ", " +
				"legalActionIdentifier=" + this.legalActionIdentifier + ", " +
				"legalActionSummary=" + this.legalActionSummary + ", " +
				"legalAction=" + this.legalAction + ", " +
				"loanLegalActionNotificationChoice1=" + this.loanLegalActionNotificationChoice1 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanLegalActionNotification  ***********************/
	class LoanLegalActionNotificationBuilderImpl extends AbstractServicingNotification.AbstractServicingNotificationBuilderImpl implements LoanLegalActionNotification.LoanLegalActionNotificationBuilder {
	
		protected List<LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder> loanLegalActionNotificationChoice0 = new ArrayList<>();
		protected LegalActionIdentifier.LegalActionIdentifierBuilder legalActionIdentifier;
		protected LoanLegalActionSummary.LoanLegalActionSummaryBuilder legalActionSummary;
		protected LoanLegalAction.LoanLegalActionBuilder legalAction;
		protected List<LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder> loanLegalActionNotificationChoice1 = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("loanLegalActionNotificationChoice0")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoice0")
		public List<? extends LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder> getLoanLegalActionNotificationChoice0() {
			return loanLegalActionNotificationChoice0;
		}
		
		@Override
		public LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder getOrCreateLoanLegalActionNotificationChoice0(int index) {
			if (loanLegalActionNotificationChoice0==null) {
				this.loanLegalActionNotificationChoice0 = new ArrayList<>();
			}
			return getIndex(loanLegalActionNotificationChoice0, index, () -> {
						LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder newLoanLegalActionNotificationChoice0 = LoanLegalActionNotificationChoice0.builder();
						return newLoanLegalActionNotificationChoice0;
					});
		}
		
		@Override
		@RosettaAttribute("legalActionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionIdentifier")
		public LegalActionIdentifier.LegalActionIdentifierBuilder getLegalActionIdentifier() {
			return legalActionIdentifier;
		}
		
		@Override
		public LegalActionIdentifier.LegalActionIdentifierBuilder getOrCreateLegalActionIdentifier() {
			LegalActionIdentifier.LegalActionIdentifierBuilder result;
			if (legalActionIdentifier!=null) {
				result = legalActionIdentifier;
			}
			else {
				result = legalActionIdentifier = LegalActionIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legalActionSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionSummary")
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder getLegalActionSummary() {
			return legalActionSummary;
		}
		
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder getOrCreateLegalActionSummary() {
			LoanLegalActionSummary.LoanLegalActionSummaryBuilder result;
			if (legalActionSummary!=null) {
				result = legalActionSummary;
			}
			else {
				result = legalActionSummary = LoanLegalActionSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legalAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalAction")
		public LoanLegalAction.LoanLegalActionBuilder getLegalAction() {
			return legalAction;
		}
		
		@Override
		public LoanLegalAction.LoanLegalActionBuilder getOrCreateLegalAction() {
			LoanLegalAction.LoanLegalActionBuilder result;
			if (legalAction!=null) {
				result = legalAction;
			}
			else {
				result = legalAction = LoanLegalAction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanLegalActionNotificationChoice1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoice1")
		public List<? extends LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder> getLoanLegalActionNotificationChoice1() {
			return loanLegalActionNotificationChoice1;
		}
		
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder getOrCreateLoanLegalActionNotificationChoice1(int index) {
			if (loanLegalActionNotificationChoice1==null) {
				this.loanLegalActionNotificationChoice1 = new ArrayList<>();
			}
			return getIndex(loanLegalActionNotificationChoice1, index, () -> {
						LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder newLoanLegalActionNotificationChoice1 = LoanLegalActionNotificationChoice1.builder();
						return newLoanLegalActionNotificationChoice1;
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
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addValidation(List<? extends Validation> validations) {
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
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setValidation(List<? extends Validation> validations) {
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
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("noticeDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("noticeDate")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setNoticeDate(ZonedDateTime _noticeDate) {
			this.noticeDate = _noticeDate == null ? null : _noticeDate;
			return this;
		}
		
		@RosettaAttribute("isGlobalOnly")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isGlobalOnly")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setIsGlobalOnly(Boolean _isGlobalOnly) {
			this.isGlobalOnly = _isGlobalOnly == null ? null : _isGlobalOnly;
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addEventPayment(EventPayment _eventPayment) {
			if (_eventPayment != null) {
				this.eventPayment.add(_eventPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addEventPayment(EventPayment _eventPayment, int idx) {
			getIndex(this.eventPayment, idx, () -> _eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (final EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments == null) {
				this.eventPayment = new ArrayList<>();
			} else {
				this.eventPayment = eventPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalActionNotificationChoice0")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoice0")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addLoanLegalActionNotificationChoice0(LoanLegalActionNotificationChoice0 _loanLegalActionNotificationChoice0) {
			if (_loanLegalActionNotificationChoice0 != null) {
				this.loanLegalActionNotificationChoice0.add(_loanLegalActionNotificationChoice0.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addLoanLegalActionNotificationChoice0(LoanLegalActionNotificationChoice0 _loanLegalActionNotificationChoice0, int idx) {
			getIndex(this.loanLegalActionNotificationChoice0, idx, () -> _loanLegalActionNotificationChoice0.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addLoanLegalActionNotificationChoice0(List<? extends LoanLegalActionNotificationChoice0> loanLegalActionNotificationChoice0s) {
			if (loanLegalActionNotificationChoice0s != null) {
				for (final LoanLegalActionNotificationChoice0 toAdd : loanLegalActionNotificationChoice0s) {
					this.loanLegalActionNotificationChoice0.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalActionNotificationChoice0")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoice0")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setLoanLegalActionNotificationChoice0(List<? extends LoanLegalActionNotificationChoice0> loanLegalActionNotificationChoice0s) {
			if (loanLegalActionNotificationChoice0s == null) {
				this.loanLegalActionNotificationChoice0 = new ArrayList<>();
			} else {
				this.loanLegalActionNotificationChoice0 = loanLegalActionNotificationChoice0s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("legalActionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionIdentifier")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setLegalActionIdentifier(LegalActionIdentifier _legalActionIdentifier) {
			this.legalActionIdentifier = _legalActionIdentifier == null ? null : _legalActionIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legalActionSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionSummary")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setLegalActionSummary(LoanLegalActionSummary _legalActionSummary) {
			this.legalActionSummary = _legalActionSummary == null ? null : _legalActionSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legalAction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalAction")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setLegalAction(LoanLegalAction _legalAction) {
			this.legalAction = _legalAction == null ? null : _legalAction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanLegalActionNotificationChoice1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoice1")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addLoanLegalActionNotificationChoice1(LoanLegalActionNotificationChoice1 _loanLegalActionNotificationChoice1) {
			if (_loanLegalActionNotificationChoice1 != null) {
				this.loanLegalActionNotificationChoice1.add(_loanLegalActionNotificationChoice1.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addLoanLegalActionNotificationChoice1(LoanLegalActionNotificationChoice1 _loanLegalActionNotificationChoice1, int idx) {
			getIndex(this.loanLegalActionNotificationChoice1, idx, () -> _loanLegalActionNotificationChoice1.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addLoanLegalActionNotificationChoice1(List<? extends LoanLegalActionNotificationChoice1> loanLegalActionNotificationChoice1s) {
			if (loanLegalActionNotificationChoice1s != null) {
				for (final LoanLegalActionNotificationChoice1 toAdd : loanLegalActionNotificationChoice1s) {
					this.loanLegalActionNotificationChoice1.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalActionNotificationChoice1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoice1")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setLoanLegalActionNotificationChoice1(List<? extends LoanLegalActionNotificationChoice1> loanLegalActionNotificationChoice1s) {
			if (loanLegalActionNotificationChoice1s == null) {
				this.loanLegalActionNotificationChoice1 = new ArrayList<>();
			} else {
				this.loanLegalActionNotificationChoice1 = loanLegalActionNotificationChoice1s.stream()
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
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder addParty(List<? extends Party> partys) {
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
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanLegalActionNotification build() {
			return new LoanLegalActionNotification.LoanLegalActionNotificationImpl(this);
		}
		
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder prune() {
			super.prune();
			loanLegalActionNotificationChoice0 = loanLegalActionNotificationChoice0.stream().filter(b->b!=null).<LoanLegalActionNotificationChoice0.LoanLegalActionNotificationChoice0Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (legalActionIdentifier!=null && !legalActionIdentifier.prune().hasData()) legalActionIdentifier = null;
			if (legalActionSummary!=null && !legalActionSummary.prune().hasData()) legalActionSummary = null;
			if (legalAction!=null && !legalAction.prune().hasData()) legalAction = null;
			loanLegalActionNotificationChoice1 = loanLegalActionNotificationChoice1.stream().filter(b->b!=null).<LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanLegalActionNotificationChoice0()!=null && getLoanLegalActionNotificationChoice0().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLegalActionIdentifier()!=null && getLegalActionIdentifier().hasData()) return true;
			if (getLegalActionSummary()!=null && getLegalActionSummary().hasData()) return true;
			if (getLegalAction()!=null && getLegalAction().hasData()) return true;
			if (getLoanLegalActionNotificationChoice1()!=null && getLoanLegalActionNotificationChoice1().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionNotification.LoanLegalActionNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanLegalActionNotification.LoanLegalActionNotificationBuilder o = (LoanLegalActionNotification.LoanLegalActionNotificationBuilder) other;
			
			merger.mergeRosetta(getLoanLegalActionNotificationChoice0(), o.getLoanLegalActionNotificationChoice0(), this::getOrCreateLoanLegalActionNotificationChoice0);
			merger.mergeRosetta(getLegalActionIdentifier(), o.getLegalActionIdentifier(), this::setLegalActionIdentifier);
			merger.mergeRosetta(getLegalActionSummary(), o.getLegalActionSummary(), this::setLegalActionSummary);
			merger.mergeRosetta(getLegalAction(), o.getLegalAction(), this::setLegalAction);
			merger.mergeRosetta(getLoanLegalActionNotificationChoice1(), o.getLoanLegalActionNotificationChoice1(), this::getOrCreateLoanLegalActionNotificationChoice1);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanLegalActionNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanLegalActionNotificationChoice0, _that.getLoanLegalActionNotificationChoice0())) return false;
			if (!Objects.equals(legalActionIdentifier, _that.getLegalActionIdentifier())) return false;
			if (!Objects.equals(legalActionSummary, _that.getLegalActionSummary())) return false;
			if (!Objects.equals(legalAction, _that.getLegalAction())) return false;
			if (!ListEquals.listEquals(loanLegalActionNotificationChoice1, _that.getLoanLegalActionNotificationChoice1())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanLegalActionNotificationChoice0 != null ? loanLegalActionNotificationChoice0.hashCode() : 0);
			_result = 31 * _result + (legalActionIdentifier != null ? legalActionIdentifier.hashCode() : 0);
			_result = 31 * _result + (legalActionSummary != null ? legalActionSummary.hashCode() : 0);
			_result = 31 * _result + (legalAction != null ? legalAction.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionNotificationChoice1 != null ? loanLegalActionNotificationChoice1.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionNotificationBuilder {" +
				"loanLegalActionNotificationChoice0=" + this.loanLegalActionNotificationChoice0 + ", " +
				"legalActionIdentifier=" + this.legalActionIdentifier + ", " +
				"legalActionSummary=" + this.legalActionSummary + ", " +
				"legalAction=" + this.legalAction + ", " +
				"loanLegalActionNotificationChoice1=" + this.loanLegalActionNotificationChoice1 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}

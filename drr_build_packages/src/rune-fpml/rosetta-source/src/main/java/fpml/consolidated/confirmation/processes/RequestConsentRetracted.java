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
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.DeClear;
import fpml.consolidated.business.events.ObservationEvent;
import fpml.consolidated.business.events.ResetEvent;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.confirmation.processes.meta.RequestConsentRetractedMeta;
import fpml.consolidated.doc.ApprovalType;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NonCorrectableRequestMessage;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PersonId;
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
 * Provision A message withdrawing a request that the sender be authorized by the recipient to peform an action.
 *
 */
@RosettaDataType(value="RequestConsentRetracted", builder=RequestConsentRetracted.RequestConsentRetractedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequestConsentRetracted", model="fpml", builder=RequestConsentRetracted.RequestConsentRetractedBuilderImpl.class, version="2.1.1")
public interface RequestConsentRetracted extends NonCorrectableRequestMessage {

	RequestConsentRetractedMeta metaData = new RequestConsentRetractedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of approval (e.g. "pre-clearing credit").
	 *
	 */
	ApprovalType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The full name or identifiying ID of the relevant approver.
	 *
	 */
	PersonId getApprover();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a party defined elsewhere in the document. The party referenced needs to approve the specified item (e.g. trade or allocation).
	 *
	 */
	PartyReference getApprovingPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TradePackage getTradePackage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	OriginatingEvent getOriginatingEvent();
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
	TradeAmendmentContent getAmendment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeNotionalChange getIncrease();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to describe why a trade was terminated.
	 *
	 */
	TerminatingEvent getTerminatingEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeNotionalChange getTermination();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeNovationContent getNovation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Withdrawal getWithdrawal();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends ObservationEvent> getObservation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends ResetEvent> getReset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AdditionalEvent getAdditionalEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure describing a declear event. The deClear event allows a firm to request that a trade be removed from clearing, or a clearing service to request consent for this, or to report that it has been done.
	 *
	 */
	DeClear getDeClear();
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
	RequestConsentRetracted build();
	
	RequestConsentRetracted.RequestConsentRetractedBuilder toBuilder();
	
	static RequestConsentRetracted.RequestConsentRetractedBuilder builder() {
		return new RequestConsentRetracted.RequestConsentRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestConsentRetracted> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequestConsentRetracted> getType() {
		return RequestConsentRetracted.class;
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
		processRosetta(path.newSubPath("type"), processor, ApprovalType.class, _getType());
		processRosetta(path.newSubPath("approver"), processor, PersonId.class, getApprover());
		processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.class, getApprovingPartyReference());
		processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.class, getTradePackage());
		processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.class, getOriginatingEvent());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("amendment"), processor, TradeAmendmentContent.class, getAmendment());
		processRosetta(path.newSubPath("increase"), processor, TradeNotionalChange.class, getIncrease());
		processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.class, getTerminatingEvent());
		processRosetta(path.newSubPath("termination"), processor, TradeNotionalChange.class, getTermination());
		processRosetta(path.newSubPath("novation"), processor, TradeNovationContent.class, getNovation());
		processRosetta(path.newSubPath("withdrawal"), processor, Withdrawal.class, getWithdrawal());
		processRosetta(path.newSubPath("observation"), processor, ObservationEvent.class, getObservation());
		processRosetta(path.newSubPath("reset"), processor, ResetEvent.class, getReset());
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
		processRosetta(path.newSubPath("deClear"), processor, DeClear.class, getDeClear());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestConsentRetractedBuilder extends RequestConsentRetracted, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		ApprovalType.ApprovalTypeBuilder getOrCreateType();
		@Override
		ApprovalType.ApprovalTypeBuilder _getType();
		PersonId.PersonIdBuilder getOrCreateApprover();
		@Override
		PersonId.PersonIdBuilder getApprover();
		PartyReference.PartyReferenceBuilder getOrCreateApprovingPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getApprovingPartyReference();
		TradePackage.TradePackageBuilder getOrCreateTradePackage();
		@Override
		TradePackage.TradePackageBuilder getTradePackage();
		OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent();
		@Override
		OriginatingEvent.OriginatingEventBuilder getOriginatingEvent();
		Trade.TradeBuilder getOrCreateTrade();
		@Override
		Trade.TradeBuilder getTrade();
		TradeAmendmentContent.TradeAmendmentContentBuilder getOrCreateAmendment();
		@Override
		TradeAmendmentContent.TradeAmendmentContentBuilder getAmendment();
		TradeNotionalChange.TradeNotionalChangeBuilder getOrCreateIncrease();
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder getIncrease();
		TerminatingEvent.TerminatingEventBuilder getOrCreateTerminatingEvent();
		@Override
		TerminatingEvent.TerminatingEventBuilder getTerminatingEvent();
		TradeNotionalChange.TradeNotionalChangeBuilder getOrCreateTermination();
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder getTermination();
		TradeNovationContent.TradeNovationContentBuilder getOrCreateNovation();
		@Override
		TradeNovationContent.TradeNovationContentBuilder getNovation();
		Withdrawal.WithdrawalBuilder getOrCreateWithdrawal();
		@Override
		Withdrawal.WithdrawalBuilder getWithdrawal();
		ObservationEvent.ObservationEventBuilder getOrCreateObservation(int index);
		@Override
		List<? extends ObservationEvent.ObservationEventBuilder> getObservation();
		ResetEvent.ResetEventBuilder getOrCreateReset(int index);
		@Override
		List<? extends ResetEvent.ResetEventBuilder> getReset();
		AdditionalEvent.AdditionalEventBuilder getOrCreateAdditionalEvent();
		@Override
		AdditionalEvent.AdditionalEventBuilder getAdditionalEvent();
		DeClear.DeClearBuilder getOrCreateDeClear();
		@Override
		DeClear.DeClearBuilder getDeClear();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder setActualBuild(Integer actualBuild);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder setHeader(RequestMessageHeader header);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder addValidation(Validation validation);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder addValidation(Validation validation, int idx);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder addValidation(List<? extends Validation> validation);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder setValidation(List<? extends Validation> validation);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		RequestConsentRetracted.RequestConsentRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		RequestConsentRetracted.RequestConsentRetractedBuilder setType(ApprovalType type);
		RequestConsentRetracted.RequestConsentRetractedBuilder setApprover(PersonId approver);
		RequestConsentRetracted.RequestConsentRetractedBuilder setApprovingPartyReference(PartyReference approvingPartyReference);
		RequestConsentRetracted.RequestConsentRetractedBuilder setTradePackage(TradePackage tradePackage);
		RequestConsentRetracted.RequestConsentRetractedBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		RequestConsentRetracted.RequestConsentRetractedBuilder setTrade(Trade trade);
		RequestConsentRetracted.RequestConsentRetractedBuilder setAmendment(TradeAmendmentContent amendment);
		RequestConsentRetracted.RequestConsentRetractedBuilder setIncrease(TradeNotionalChange increase);
		RequestConsentRetracted.RequestConsentRetractedBuilder setTerminatingEvent(TerminatingEvent terminatingEvent);
		RequestConsentRetracted.RequestConsentRetractedBuilder setTermination(TradeNotionalChange termination);
		RequestConsentRetracted.RequestConsentRetractedBuilder setNovation(TradeNovationContent novation);
		RequestConsentRetracted.RequestConsentRetractedBuilder setWithdrawal(Withdrawal withdrawal);
		RequestConsentRetracted.RequestConsentRetractedBuilder addObservation(ObservationEvent observation);
		RequestConsentRetracted.RequestConsentRetractedBuilder addObservation(ObservationEvent observation, int idx);
		RequestConsentRetracted.RequestConsentRetractedBuilder addObservation(List<? extends ObservationEvent> observation);
		RequestConsentRetracted.RequestConsentRetractedBuilder setObservation(List<? extends ObservationEvent> observation);
		RequestConsentRetracted.RequestConsentRetractedBuilder addReset(ResetEvent reset);
		RequestConsentRetracted.RequestConsentRetractedBuilder addReset(ResetEvent reset, int idx);
		RequestConsentRetracted.RequestConsentRetractedBuilder addReset(List<? extends ResetEvent> reset);
		RequestConsentRetracted.RequestConsentRetractedBuilder setReset(List<? extends ResetEvent> reset);
		RequestConsentRetracted.RequestConsentRetractedBuilder setAdditionalEvent(AdditionalEvent additionalEvent);
		RequestConsentRetracted.RequestConsentRetractedBuilder setDeClear(DeClear deClear);
		RequestConsentRetracted.RequestConsentRetractedBuilder addParty(Party party);
		RequestConsentRetracted.RequestConsentRetractedBuilder addParty(Party party, int idx);
		RequestConsentRetracted.RequestConsentRetractedBuilder addParty(List<? extends Party> party);
		RequestConsentRetracted.RequestConsentRetractedBuilder setParty(List<? extends Party> party);
		RequestConsentRetracted.RequestConsentRetractedBuilder addAccount(Account account);
		RequestConsentRetracted.RequestConsentRetractedBuilder addAccount(Account account, int idx);
		RequestConsentRetracted.RequestConsentRetractedBuilder addAccount(List<? extends Account> account);
		RequestConsentRetracted.RequestConsentRetractedBuilder setAccount(List<? extends Account> account);

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
			processRosetta(path.newSubPath("type"), processor, ApprovalType.ApprovalTypeBuilder.class, _getType());
			processRosetta(path.newSubPath("approver"), processor, PersonId.PersonIdBuilder.class, getApprover());
			processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getApprovingPartyReference());
			processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.TradePackageBuilder.class, getTradePackage());
			processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.OriginatingEventBuilder.class, getOriginatingEvent());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("amendment"), processor, TradeAmendmentContent.TradeAmendmentContentBuilder.class, getAmendment());
			processRosetta(path.newSubPath("increase"), processor, TradeNotionalChange.TradeNotionalChangeBuilder.class, getIncrease());
			processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.TerminatingEventBuilder.class, getTerminatingEvent());
			processRosetta(path.newSubPath("termination"), processor, TradeNotionalChange.TradeNotionalChangeBuilder.class, getTermination());
			processRosetta(path.newSubPath("novation"), processor, TradeNovationContent.TradeNovationContentBuilder.class, getNovation());
			processRosetta(path.newSubPath("withdrawal"), processor, Withdrawal.WithdrawalBuilder.class, getWithdrawal());
			processRosetta(path.newSubPath("observation"), processor, ObservationEvent.ObservationEventBuilder.class, getObservation());
			processRosetta(path.newSubPath("reset"), processor, ResetEvent.ResetEventBuilder.class, getReset());
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
			processRosetta(path.newSubPath("deClear"), processor, DeClear.DeClearBuilder.class, getDeClear());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		RequestConsentRetracted.RequestConsentRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of RequestConsentRetracted  ***********************/
	class RequestConsentRetractedImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements RequestConsentRetracted {
		private final ApprovalType type;
		private final PersonId approver;
		private final PartyReference approvingPartyReference;
		private final TradePackage tradePackage;
		private final OriginatingEvent originatingEvent;
		private final Trade trade;
		private final TradeAmendmentContent amendment;
		private final TradeNotionalChange increase;
		private final TerminatingEvent terminatingEvent;
		private final TradeNotionalChange termination;
		private final TradeNovationContent novation;
		private final Withdrawal withdrawal;
		private final List<? extends ObservationEvent> observation;
		private final List<? extends ResetEvent> reset;
		private final AdditionalEvent additionalEvent;
		private final DeClear deClear;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected RequestConsentRetractedImpl(RequestConsentRetracted.RequestConsentRetractedBuilder builder) {
			super(builder);
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.approver = ofNullable(builder.getApprover()).map(f->f.build()).orElse(null);
			this.approvingPartyReference = ofNullable(builder.getApprovingPartyReference()).map(f->f.build()).orElse(null);
			this.tradePackage = ofNullable(builder.getTradePackage()).map(f->f.build()).orElse(null);
			this.originatingEvent = ofNullable(builder.getOriginatingEvent()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.amendment = ofNullable(builder.getAmendment()).map(f->f.build()).orElse(null);
			this.increase = ofNullable(builder.getIncrease()).map(f->f.build()).orElse(null);
			this.terminatingEvent = ofNullable(builder.getTerminatingEvent()).map(f->f.build()).orElse(null);
			this.termination = ofNullable(builder.getTermination()).map(f->f.build()).orElse(null);
			this.novation = ofNullable(builder.getNovation()).map(f->f.build()).orElse(null);
			this.withdrawal = ofNullable(builder.getWithdrawal()).map(f->f.build()).orElse(null);
			this.observation = ofNullable(builder.getObservation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reset = ofNullable(builder.getReset()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalEvent = ofNullable(builder.getAdditionalEvent()).map(f->f.build()).orElse(null);
			this.deClear = ofNullable(builder.getDeClear()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public ApprovalType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("approver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approver")
		public PersonId getApprover() {
			return approver;
		}
		
		@Override
		@RosettaAttribute("approvingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvingPartyReference")
		public PartyReference getApprovingPartyReference() {
			return approvingPartyReference;
		}
		
		@Override
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradePackage")
		public TradePackage getTradePackage() {
			return tradePackage;
		}
		
		@Override
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originatingEvent")
		public OriginatingEvent getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("amendment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amendment")
		public TradeAmendmentContent getAmendment() {
			return amendment;
		}
		
		@Override
		@RosettaAttribute("increase")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("increase")
		public TradeNotionalChange getIncrease() {
			return increase;
		}
		
		@Override
		@RosettaAttribute("terminatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminatingEvent")
		public TerminatingEvent getTerminatingEvent() {
			return terminatingEvent;
		}
		
		@Override
		@RosettaAttribute("termination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termination")
		public TradeNotionalChange getTermination() {
			return termination;
		}
		
		@Override
		@RosettaAttribute("novation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("novation")
		public TradeNovationContent getNovation() {
			return novation;
		}
		
		@Override
		@RosettaAttribute("withdrawal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withdrawal")
		public Withdrawal getWithdrawal() {
			return withdrawal;
		}
		
		@Override
		@RosettaAttribute("observation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("observation")
		public List<? extends ObservationEvent> getObservation() {
			return observation;
		}
		
		@Override
		@RosettaAttribute("reset")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reset")
		public List<? extends ResetEvent> getReset() {
			return reset;
		}
		
		@Override
		@RosettaAttribute("additionalEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalEvent")
		public AdditionalEvent getAdditionalEvent() {
			return additionalEvent;
		}
		
		@Override
		@RosettaAttribute("deClear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deClear")
		public DeClear getDeClear() {
			return deClear;
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
		public RequestConsentRetracted build() {
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder toBuilder() {
			RequestConsentRetracted.RequestConsentRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestConsentRetracted.RequestConsentRetractedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getApprover()).ifPresent(builder::setApprover);
			ofNullable(getApprovingPartyReference()).ifPresent(builder::setApprovingPartyReference);
			ofNullable(getTradePackage()).ifPresent(builder::setTradePackage);
			ofNullable(getOriginatingEvent()).ifPresent(builder::setOriginatingEvent);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getAmendment()).ifPresent(builder::setAmendment);
			ofNullable(getIncrease()).ifPresent(builder::setIncrease);
			ofNullable(getTerminatingEvent()).ifPresent(builder::setTerminatingEvent);
			ofNullable(getTermination()).ifPresent(builder::setTermination);
			ofNullable(getNovation()).ifPresent(builder::setNovation);
			ofNullable(getWithdrawal()).ifPresent(builder::setWithdrawal);
			ofNullable(getObservation()).ifPresent(builder::setObservation);
			ofNullable(getReset()).ifPresent(builder::setReset);
			ofNullable(getAdditionalEvent()).ifPresent(builder::setAdditionalEvent);
			ofNullable(getDeClear()).ifPresent(builder::setDeClear);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestConsentRetracted _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(amendment, _that.getAmendment())) return false;
			if (!Objects.equals(increase, _that.getIncrease())) return false;
			if (!Objects.equals(terminatingEvent, _that.getTerminatingEvent())) return false;
			if (!Objects.equals(termination, _that.getTermination())) return false;
			if (!Objects.equals(novation, _that.getNovation())) return false;
			if (!Objects.equals(withdrawal, _that.getWithdrawal())) return false;
			if (!ListEquals.listEquals(observation, _that.getObservation())) return false;
			if (!ListEquals.listEquals(reset, _that.getReset())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (amendment != null ? amendment.hashCode() : 0);
			_result = 31 * _result + (increase != null ? increase.hashCode() : 0);
			_result = 31 * _result + (terminatingEvent != null ? terminatingEvent.hashCode() : 0);
			_result = 31 * _result + (termination != null ? termination.hashCode() : 0);
			_result = 31 * _result + (novation != null ? novation.hashCode() : 0);
			_result = 31 * _result + (withdrawal != null ? withdrawal.hashCode() : 0);
			_result = 31 * _result + (observation != null ? observation.hashCode() : 0);
			_result = 31 * _result + (reset != null ? reset.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestConsentRetracted {" +
				"type=" + this.type + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"tradePackage=" + this.tradePackage + ", " +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"amendment=" + this.amendment + ", " +
				"increase=" + this.increase + ", " +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"termination=" + this.termination + ", " +
				"novation=" + this.novation + ", " +
				"withdrawal=" + this.withdrawal + ", " +
				"observation=" + this.observation + ", " +
				"reset=" + this.reset + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"deClear=" + this.deClear + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestConsentRetracted  ***********************/
	class RequestConsentRetractedBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl implements RequestConsentRetracted.RequestConsentRetractedBuilder {
	
		protected ApprovalType.ApprovalTypeBuilder type;
		protected PersonId.PersonIdBuilder approver;
		protected PartyReference.PartyReferenceBuilder approvingPartyReference;
		protected TradePackage.TradePackageBuilder tradePackage;
		protected OriginatingEvent.OriginatingEventBuilder originatingEvent;
		protected Trade.TradeBuilder trade;
		protected TradeAmendmentContent.TradeAmendmentContentBuilder amendment;
		protected TradeNotionalChange.TradeNotionalChangeBuilder increase;
		protected TerminatingEvent.TerminatingEventBuilder terminatingEvent;
		protected TradeNotionalChange.TradeNotionalChangeBuilder termination;
		protected TradeNovationContent.TradeNovationContentBuilder novation;
		protected Withdrawal.WithdrawalBuilder withdrawal;
		protected List<ObservationEvent.ObservationEventBuilder> observation = new ArrayList<>();
		protected List<ResetEvent.ResetEventBuilder> reset = new ArrayList<>();
		protected AdditionalEvent.AdditionalEventBuilder additionalEvent;
		protected DeClear.DeClearBuilder deClear;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public ApprovalType.ApprovalTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public ApprovalType.ApprovalTypeBuilder getOrCreateType() {
			ApprovalType.ApprovalTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = ApprovalType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approver")
		public PersonId.PersonIdBuilder getApprover() {
			return approver;
		}
		
		@Override
		public PersonId.PersonIdBuilder getOrCreateApprover() {
			PersonId.PersonIdBuilder result;
			if (approver!=null) {
				result = approver;
			}
			else {
				result = approver = PersonId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvingPartyReference")
		public PartyReference.PartyReferenceBuilder getApprovingPartyReference() {
			return approvingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateApprovingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (approvingPartyReference!=null) {
				result = approvingPartyReference;
			}
			else {
				result = approvingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradePackage")
		public TradePackage.TradePackageBuilder getTradePackage() {
			return tradePackage;
		}
		
		@Override
		public TradePackage.TradePackageBuilder getOrCreateTradePackage() {
			TradePackage.TradePackageBuilder result;
			if (tradePackage!=null) {
				result = tradePackage;
			}
			else {
				result = tradePackage = TradePackage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originatingEvent")
		public OriginatingEvent.OriginatingEventBuilder getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		public OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent() {
			OriginatingEvent.OriginatingEventBuilder result;
			if (originatingEvent!=null) {
				result = originatingEvent;
			}
			else {
				result = originatingEvent = OriginatingEvent.builder();
			}
			
			return result;
		}
		
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
		@RosettaAttribute("amendment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amendment")
		public TradeAmendmentContent.TradeAmendmentContentBuilder getAmendment() {
			return amendment;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder getOrCreateAmendment() {
			TradeAmendmentContent.TradeAmendmentContentBuilder result;
			if (amendment!=null) {
				result = amendment;
			}
			else {
				result = amendment = TradeAmendmentContent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("increase")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("increase")
		public TradeNotionalChange.TradeNotionalChangeBuilder getIncrease() {
			return increase;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder getOrCreateIncrease() {
			TradeNotionalChange.TradeNotionalChangeBuilder result;
			if (increase!=null) {
				result = increase;
			}
			else {
				result = increase = TradeNotionalChange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminatingEvent")
		public TerminatingEvent.TerminatingEventBuilder getTerminatingEvent() {
			return terminatingEvent;
		}
		
		@Override
		public TerminatingEvent.TerminatingEventBuilder getOrCreateTerminatingEvent() {
			TerminatingEvent.TerminatingEventBuilder result;
			if (terminatingEvent!=null) {
				result = terminatingEvent;
			}
			else {
				result = terminatingEvent = TerminatingEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("termination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termination")
		public TradeNotionalChange.TradeNotionalChangeBuilder getTermination() {
			return termination;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder getOrCreateTermination() {
			TradeNotionalChange.TradeNotionalChangeBuilder result;
			if (termination!=null) {
				result = termination;
			}
			else {
				result = termination = TradeNotionalChange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("novation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("novation")
		public TradeNovationContent.TradeNovationContentBuilder getNovation() {
			return novation;
		}
		
		@Override
		public TradeNovationContent.TradeNovationContentBuilder getOrCreateNovation() {
			TradeNovationContent.TradeNovationContentBuilder result;
			if (novation!=null) {
				result = novation;
			}
			else {
				result = novation = TradeNovationContent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("withdrawal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withdrawal")
		public Withdrawal.WithdrawalBuilder getWithdrawal() {
			return withdrawal;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder getOrCreateWithdrawal() {
			Withdrawal.WithdrawalBuilder result;
			if (withdrawal!=null) {
				result = withdrawal;
			}
			else {
				result = withdrawal = Withdrawal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("observation")
		public List<? extends ObservationEvent.ObservationEventBuilder> getObservation() {
			return observation;
		}
		
		@Override
		public ObservationEvent.ObservationEventBuilder getOrCreateObservation(int index) {
			if (observation==null) {
				this.observation = new ArrayList<>();
			}
			return getIndex(observation, index, () -> {
						ObservationEvent.ObservationEventBuilder newObservation = ObservationEvent.builder();
						return newObservation;
					});
		}
		
		@Override
		@RosettaAttribute("reset")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reset")
		public List<? extends ResetEvent.ResetEventBuilder> getReset() {
			return reset;
		}
		
		@Override
		public ResetEvent.ResetEventBuilder getOrCreateReset(int index) {
			if (reset==null) {
				this.reset = new ArrayList<>();
			}
			return getIndex(reset, index, () -> {
						ResetEvent.ResetEventBuilder newReset = ResetEvent.builder();
						return newReset;
					});
		}
		
		@Override
		@RosettaAttribute("additionalEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalEvent")
		public AdditionalEvent.AdditionalEventBuilder getAdditionalEvent() {
			return additionalEvent;
		}
		
		@Override
		public AdditionalEvent.AdditionalEventBuilder getOrCreateAdditionalEvent() {
			AdditionalEvent.AdditionalEventBuilder result;
			if (additionalEvent!=null) {
				result = additionalEvent;
			}
			else {
				result = additionalEvent = AdditionalEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deClear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deClear")
		public DeClear.DeClearBuilder getDeClear() {
			return deClear;
		}
		
		@Override
		public DeClear.DeClearBuilder getOrCreateDeClear() {
			DeClear.DeClearBuilder result;
			if (deClear!=null) {
				result = deClear;
			}
			else {
				result = deClear = DeClear.builder();
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
		public RequestConsentRetracted.RequestConsentRetractedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addValidation(List<? extends Validation> validations) {
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
		public RequestConsentRetracted.RequestConsentRetractedBuilder setValidation(List<? extends Validation> validations) {
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
		public RequestConsentRetracted.RequestConsentRetractedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public RequestConsentRetracted.RequestConsentRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public RequestConsentRetracted.RequestConsentRetractedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public RequestConsentRetracted.RequestConsentRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setType(ApprovalType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("approver")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("approver")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setApprover(PersonId _approver) {
			this.approver = _approver == null ? null : _approver.toBuilder();
			return this;
		}
		
		@RosettaAttribute("approvingPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("approvingPartyReference")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setApprovingPartyReference(PartyReference _approvingPartyReference) {
			this.approvingPartyReference = _approvingPartyReference == null ? null : _approvingPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradePackage")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setTradePackage(TradePackage _tradePackage) {
			this.tradePackage = _tradePackage == null ? null : _tradePackage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingEvent")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setOriginatingEvent(OriginatingEvent _originatingEvent) {
			this.originatingEvent = _originatingEvent == null ? null : _originatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amendment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendment")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setAmendment(TradeAmendmentContent _amendment) {
			this.amendment = _amendment == null ? null : _amendment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("increase")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("increase")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setIncrease(TradeNotionalChange _increase) {
			this.increase = _increase == null ? null : _increase.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminatingEvent")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setTerminatingEvent(TerminatingEvent _terminatingEvent) {
			this.terminatingEvent = _terminatingEvent == null ? null : _terminatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("termination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("termination")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setTermination(TradeNotionalChange _termination) {
			this.termination = _termination == null ? null : _termination.toBuilder();
			return this;
		}
		
		@RosettaAttribute("novation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("novation")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setNovation(TradeNovationContent _novation) {
			this.novation = _novation == null ? null : _novation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("withdrawal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("withdrawal")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setWithdrawal(Withdrawal _withdrawal) {
			this.withdrawal = _withdrawal == null ? null : _withdrawal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("observation")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addObservation(ObservationEvent _observation) {
			if (_observation != null) {
				this.observation.add(_observation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addObservation(ObservationEvent _observation, int idx) {
			getIndex(this.observation, idx, () -> _observation.toBuilder());
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addObservation(List<? extends ObservationEvent> observations) {
			if (observations != null) {
				for (final ObservationEvent toAdd : observations) {
					this.observation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("observation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("observation")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setObservation(List<? extends ObservationEvent> observations) {
			if (observations == null) {
				this.observation = new ArrayList<>();
			} else {
				this.observation = observations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reset")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reset")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addReset(ResetEvent _reset) {
			if (_reset != null) {
				this.reset.add(_reset.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addReset(ResetEvent _reset, int idx) {
			getIndex(this.reset, idx, () -> _reset.toBuilder());
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addReset(List<? extends ResetEvent> resets) {
			if (resets != null) {
				for (final ResetEvent toAdd : resets) {
					this.reset.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reset")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reset")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setReset(List<? extends ResetEvent> resets) {
			if (resets == null) {
				this.reset = new ArrayList<>();
			} else {
				this.reset = resets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("additionalEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalEvent")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setAdditionalEvent(AdditionalEvent _additionalEvent) {
			this.additionalEvent = _additionalEvent == null ? null : _additionalEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deClear")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deClear")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder setDeClear(DeClear _deClear) {
			this.deClear = _deClear == null ? null : _deClear.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addParty(List<? extends Party> partys) {
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
		public RequestConsentRetracted.RequestConsentRetractedBuilder setParty(List<? extends Party> partys) {
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
		public RequestConsentRetracted.RequestConsentRetractedBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder addAccount(List<? extends Account> accounts) {
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
		public RequestConsentRetracted.RequestConsentRetractedBuilder setAccount(List<? extends Account> accounts) {
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
		public RequestConsentRetracted build() {
			return new RequestConsentRetracted.RequestConsentRetractedImpl(this);
		}
		
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder prune() {
			super.prune();
			if (type!=null && !type.prune().hasData()) type = null;
			if (approver!=null && !approver.prune().hasData()) approver = null;
			if (approvingPartyReference!=null && !approvingPartyReference.prune().hasData()) approvingPartyReference = null;
			if (tradePackage!=null && !tradePackage.prune().hasData()) tradePackage = null;
			if (originatingEvent!=null && !originatingEvent.prune().hasData()) originatingEvent = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (amendment!=null && !amendment.prune().hasData()) amendment = null;
			if (increase!=null && !increase.prune().hasData()) increase = null;
			if (terminatingEvent!=null && !terminatingEvent.prune().hasData()) terminatingEvent = null;
			if (termination!=null && !termination.prune().hasData()) termination = null;
			if (novation!=null && !novation.prune().hasData()) novation = null;
			if (withdrawal!=null && !withdrawal.prune().hasData()) withdrawal = null;
			observation = observation.stream().filter(b->b!=null).<ObservationEvent.ObservationEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			reset = reset.stream().filter(b->b!=null).<ResetEvent.ResetEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (additionalEvent!=null && !additionalEvent.prune().hasData()) additionalEvent = null;
			if (deClear!=null && !deClear.prune().hasData()) deClear = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			if (getApprover()!=null && getApprover().hasData()) return true;
			if (getApprovingPartyReference()!=null && getApprovingPartyReference().hasData()) return true;
			if (getTradePackage()!=null && getTradePackage().hasData()) return true;
			if (getOriginatingEvent()!=null && getOriginatingEvent().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getAmendment()!=null && getAmendment().hasData()) return true;
			if (getIncrease()!=null && getIncrease().hasData()) return true;
			if (getTerminatingEvent()!=null && getTerminatingEvent().hasData()) return true;
			if (getTermination()!=null && getTermination().hasData()) return true;
			if (getNovation()!=null && getNovation().hasData()) return true;
			if (getWithdrawal()!=null && getWithdrawal().hasData()) return true;
			if (getObservation()!=null && getObservation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReset()!=null && getReset().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalEvent()!=null && getAdditionalEvent().hasData()) return true;
			if (getDeClear()!=null && getDeClear().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestConsentRetracted.RequestConsentRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RequestConsentRetracted.RequestConsentRetractedBuilder o = (RequestConsentRetracted.RequestConsentRetractedBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			merger.mergeRosetta(getApprover(), o.getApprover(), this::setApprover);
			merger.mergeRosetta(getApprovingPartyReference(), o.getApprovingPartyReference(), this::setApprovingPartyReference);
			merger.mergeRosetta(getTradePackage(), o.getTradePackage(), this::setTradePackage);
			merger.mergeRosetta(getOriginatingEvent(), o.getOriginatingEvent(), this::setOriginatingEvent);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getAmendment(), o.getAmendment(), this::setAmendment);
			merger.mergeRosetta(getIncrease(), o.getIncrease(), this::setIncrease);
			merger.mergeRosetta(getTerminatingEvent(), o.getTerminatingEvent(), this::setTerminatingEvent);
			merger.mergeRosetta(getTermination(), o.getTermination(), this::setTermination);
			merger.mergeRosetta(getNovation(), o.getNovation(), this::setNovation);
			merger.mergeRosetta(getWithdrawal(), o.getWithdrawal(), this::setWithdrawal);
			merger.mergeRosetta(getObservation(), o.getObservation(), this::getOrCreateObservation);
			merger.mergeRosetta(getReset(), o.getReset(), this::getOrCreateReset);
			merger.mergeRosetta(getAdditionalEvent(), o.getAdditionalEvent(), this::setAdditionalEvent);
			merger.mergeRosetta(getDeClear(), o.getDeClear(), this::setDeClear);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestConsentRetracted _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(amendment, _that.getAmendment())) return false;
			if (!Objects.equals(increase, _that.getIncrease())) return false;
			if (!Objects.equals(terminatingEvent, _that.getTerminatingEvent())) return false;
			if (!Objects.equals(termination, _that.getTermination())) return false;
			if (!Objects.equals(novation, _that.getNovation())) return false;
			if (!Objects.equals(withdrawal, _that.getWithdrawal())) return false;
			if (!ListEquals.listEquals(observation, _that.getObservation())) return false;
			if (!ListEquals.listEquals(reset, _that.getReset())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (amendment != null ? amendment.hashCode() : 0);
			_result = 31 * _result + (increase != null ? increase.hashCode() : 0);
			_result = 31 * _result + (terminatingEvent != null ? terminatingEvent.hashCode() : 0);
			_result = 31 * _result + (termination != null ? termination.hashCode() : 0);
			_result = 31 * _result + (novation != null ? novation.hashCode() : 0);
			_result = 31 * _result + (withdrawal != null ? withdrawal.hashCode() : 0);
			_result = 31 * _result + (observation != null ? observation.hashCode() : 0);
			_result = 31 * _result + (reset != null ? reset.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestConsentRetractedBuilder {" +
				"type=" + this.type + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"tradePackage=" + this.tradePackage + ", " +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"amendment=" + this.amendment + ", " +
				"increase=" + this.increase + ", " +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"termination=" + this.termination + ", " +
				"novation=" + this.novation + ", " +
				"withdrawal=" + this.withdrawal + ", " +
				"observation=" + this.observation + ", " +
				"reset=" + this.reset + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"deClear=" + this.deClear + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.ObservationEvent;
import fpml.consolidated.business.events.OptionEvent;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.OptionExpiry;
import fpml.consolidated.business.events.ResetEvent;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeChangeContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.TradingEventSummary;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NonCorrectableRequestMessage;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.recordkeeping.processes.meta.NonpublicExecutionReportRetractedMeta;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.RelatedParty;
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
 * Provision Retraction message for nonpublicExecutionReport.
 *
 */
@RosettaDataType(value="NonpublicExecutionReportRetracted", builder=NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NonpublicExecutionReportRetracted", model="fpml", builder=NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilderImpl.class, version="2.1.1")
public interface NonpublicExecutionReportRetracted extends NonCorrectableRequestMessage {

	NonpublicExecutionReportRetractedMeta metaData = new NonpublicExecutionReportRetractedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	OriginatingEvent getOriginatingEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	Trade getTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This is provided to support snapshot reporting that requires trading history. Some implementations are using the "trade" event to report the current snapshot of a contract. In these cases it may also be necessary to report the most recent trading event to support regulatory reporting mandates. For this reason the tradingEvent is provided to allow that event to be attached to the trade report.
	 *
	 */
	List<? extends TradingEventSummary> getTradingEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeAmendmentContent getAmendment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeNotionalChange getIncrease();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to describe why a trade was terminated.
	 *
	 */
	TerminatingEvent getTerminatingEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeNotionalChange getTermination();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeNovationContent getNovation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	Withdrawal getWithdrawal();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends ObservationEvent> getObservation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends ResetEvent> getReset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeChangeContent getChange();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A structure describing an option exercise event. The optionExercise event supports partial exercise (specify the number of options or amount to exercise), full exercise (use fullExercise flag), as well as the option to request options not to be exercised.
	 *
	 */
	OptionExercise getOptionExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A structure describing an option expiring event (i.e. passing its last exercise time and becoming worthless.)
	 *
	 */
	List<? extends OptionExpiry> getOptionExpiry();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A structure describing knock in, knock out, touch and no touch events.
	 *
	 */
	OptionEvent getOptionEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	AdditionalEvent getAdditionalEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	AssetClass getPrimaryAssetClass();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	PartyTradeIdentifier getTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Individual parties should only use a single event identifier to identify a retraction. Platforms providing services on behalf of both parties in a transaction may provide event identifiers for both parties; in this case it is up to the recipient (the trade repository) to validate that the event IDs refer to the same event.
	 *
	 */
	List<? extends BusinessEventIdentifier> getEventIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to identify one or more parties that perform a role within the transaction. If this is within a partyTradeInformation block, the related party performs the role with respect to the party identifie by the "partyReference" in the partyTradeInformation block.
	 *
	 */
	List<? extends RelatedParty> getRelatedParty();
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
	NonpublicExecutionReportRetracted build();
	
	NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder toBuilder();
	
	static NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder builder() {
		return new NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonpublicExecutionReportRetracted> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonpublicExecutionReportRetracted> getType() {
		return NonpublicExecutionReportRetracted.class;
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
		processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.class, getOriginatingEvent());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("tradingEvent"), processor, TradingEventSummary.class, getTradingEvent());
		processRosetta(path.newSubPath("amendment"), processor, TradeAmendmentContent.class, getAmendment());
		processRosetta(path.newSubPath("increase"), processor, TradeNotionalChange.class, getIncrease());
		processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.class, getTerminatingEvent());
		processRosetta(path.newSubPath("termination"), processor, TradeNotionalChange.class, getTermination());
		processRosetta(path.newSubPath("novation"), processor, TradeNovationContent.class, getNovation());
		processRosetta(path.newSubPath("withdrawal"), processor, Withdrawal.class, getWithdrawal());
		processRosetta(path.newSubPath("observation"), processor, ObservationEvent.class, getObservation());
		processRosetta(path.newSubPath("reset"), processor, ResetEvent.class, getReset());
		processRosetta(path.newSubPath("change"), processor, TradeChangeContent.class, getChange());
		processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.class, getOptionExercise());
		processRosetta(path.newSubPath("optionExpiry"), processor, OptionExpiry.class, getOptionExpiry());
		processRosetta(path.newSubPath("optionEvent"), processor, OptionEvent.class, getOptionEvent());
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
		processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.class, getPrimaryAssetClass());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonpublicExecutionReportRetractedBuilder extends NonpublicExecutionReportRetracted, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent();
		@Override
		OriginatingEvent.OriginatingEventBuilder getOriginatingEvent();
		Trade.TradeBuilder getOrCreateTrade();
		@Override
		Trade.TradeBuilder getTrade();
		TradingEventSummary.TradingEventSummaryBuilder getOrCreateTradingEvent(int index);
		@Override
		List<? extends TradingEventSummary.TradingEventSummaryBuilder> getTradingEvent();
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
		TradeChangeContent.TradeChangeContentBuilder getOrCreateChange();
		@Override
		TradeChangeContent.TradeChangeContentBuilder getChange();
		OptionExercise.OptionExerciseBuilder getOrCreateOptionExercise();
		@Override
		OptionExercise.OptionExerciseBuilder getOptionExercise();
		OptionExpiry.OptionExpiryBuilder getOrCreateOptionExpiry(int index);
		@Override
		List<? extends OptionExpiry.OptionExpiryBuilder> getOptionExpiry();
		OptionEvent.OptionEventBuilder getOrCreateOptionEvent();
		@Override
		OptionEvent.OptionEventBuilder getOptionEvent();
		AdditionalEvent.AdditionalEventBuilder getOrCreateAdditionalEvent();
		@Override
		AdditionalEvent.AdditionalEventBuilder getAdditionalEvent();
		AssetClass.AssetClassBuilder getOrCreatePrimaryAssetClass();
		@Override
		AssetClass.AssetClassBuilder getPrimaryAssetClass();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier();
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getTradeIdentifier();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier(int index);
		@Override
		List<? extends BusinessEventIdentifier.BusinessEventIdentifierBuilder> getEventIdentifier();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setActualBuild(Integer actualBuild);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setHeader(RequestMessageHeader header);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addValidation(Validation validation);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addValidation(Validation validation, int idx);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addValidation(List<? extends Validation> validation);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setValidation(List<? extends Validation> validation);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setTrade(Trade trade);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addTradingEvent(TradingEventSummary tradingEvent);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addTradingEvent(TradingEventSummary tradingEvent, int idx);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addTradingEvent(List<? extends TradingEventSummary> tradingEvent);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setTradingEvent(List<? extends TradingEventSummary> tradingEvent);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setAmendment(TradeAmendmentContent amendment);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setIncrease(TradeNotionalChange increase);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setTerminatingEvent(TerminatingEvent terminatingEvent);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setTermination(TradeNotionalChange termination);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setNovation(TradeNovationContent novation);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setWithdrawal(Withdrawal withdrawal);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addObservation(ObservationEvent observation);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addObservation(ObservationEvent observation, int idx);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addObservation(List<? extends ObservationEvent> observation);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setObservation(List<? extends ObservationEvent> observation);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addReset(ResetEvent reset);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addReset(ResetEvent reset, int idx);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addReset(List<? extends ResetEvent> reset);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setReset(List<? extends ResetEvent> reset);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setChange(TradeChangeContent change);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setOptionExercise(OptionExercise optionExercise);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addOptionExpiry(OptionExpiry optionExpiry);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addOptionExpiry(OptionExpiry optionExpiry, int idx);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addOptionExpiry(List<? extends OptionExpiry> optionExpiry);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setOptionExpiry(List<? extends OptionExpiry> optionExpiry);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setOptionEvent(OptionEvent optionEvent);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setAdditionalEvent(AdditionalEvent additionalEvent);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addRelatedParty(RelatedParty relatedParty);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addParty(Party party);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addParty(Party party, int idx);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addParty(List<? extends Party> party);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setParty(List<? extends Party> party);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addAccount(Account account);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addAccount(Account account, int idx);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addAccount(List<? extends Account> account);
		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setAccount(List<? extends Account> account);

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
			processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.OriginatingEventBuilder.class, getOriginatingEvent());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("tradingEvent"), processor, TradingEventSummary.TradingEventSummaryBuilder.class, getTradingEvent());
			processRosetta(path.newSubPath("amendment"), processor, TradeAmendmentContent.TradeAmendmentContentBuilder.class, getAmendment());
			processRosetta(path.newSubPath("increase"), processor, TradeNotionalChange.TradeNotionalChangeBuilder.class, getIncrease());
			processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.TerminatingEventBuilder.class, getTerminatingEvent());
			processRosetta(path.newSubPath("termination"), processor, TradeNotionalChange.TradeNotionalChangeBuilder.class, getTermination());
			processRosetta(path.newSubPath("novation"), processor, TradeNovationContent.TradeNovationContentBuilder.class, getNovation());
			processRosetta(path.newSubPath("withdrawal"), processor, Withdrawal.WithdrawalBuilder.class, getWithdrawal());
			processRosetta(path.newSubPath("observation"), processor, ObservationEvent.ObservationEventBuilder.class, getObservation());
			processRosetta(path.newSubPath("reset"), processor, ResetEvent.ResetEventBuilder.class, getReset());
			processRosetta(path.newSubPath("change"), processor, TradeChangeContent.TradeChangeContentBuilder.class, getChange());
			processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.OptionExerciseBuilder.class, getOptionExercise());
			processRosetta(path.newSubPath("optionExpiry"), processor, OptionExpiry.OptionExpiryBuilder.class, getOptionExpiry());
			processRosetta(path.newSubPath("optionEvent"), processor, OptionEvent.OptionEventBuilder.class, getOptionEvent());
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of NonpublicExecutionReportRetracted  ***********************/
	class NonpublicExecutionReportRetractedImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements NonpublicExecutionReportRetracted {
		private final OriginatingEvent originatingEvent;
		private final Trade trade;
		private final List<? extends TradingEventSummary> tradingEvent;
		private final TradeAmendmentContent amendment;
		private final TradeNotionalChange increase;
		private final TerminatingEvent terminatingEvent;
		private final TradeNotionalChange termination;
		private final TradeNovationContent novation;
		private final Withdrawal withdrawal;
		private final List<? extends ObservationEvent> observation;
		private final List<? extends ResetEvent> reset;
		private final TradeChangeContent change;
		private final OptionExercise optionExercise;
		private final List<? extends OptionExpiry> optionExpiry;
		private final OptionEvent optionEvent;
		private final AdditionalEvent additionalEvent;
		private final AssetClass primaryAssetClass;
		private final PartyTradeIdentifier tradeIdentifier;
		private final List<? extends BusinessEventIdentifier> eventIdentifier;
		private final List<? extends RelatedParty> relatedParty;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected NonpublicExecutionReportRetractedImpl(NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder builder) {
			super(builder);
			this.originatingEvent = ofNullable(builder.getOriginatingEvent()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.tradingEvent = ofNullable(builder.getTradingEvent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.amendment = ofNullable(builder.getAmendment()).map(f->f.build()).orElse(null);
			this.increase = ofNullable(builder.getIncrease()).map(f->f.build()).orElse(null);
			this.terminatingEvent = ofNullable(builder.getTerminatingEvent()).map(f->f.build()).orElse(null);
			this.termination = ofNullable(builder.getTermination()).map(f->f.build()).orElse(null);
			this.novation = ofNullable(builder.getNovation()).map(f->f.build()).orElse(null);
			this.withdrawal = ofNullable(builder.getWithdrawal()).map(f->f.build()).orElse(null);
			this.observation = ofNullable(builder.getObservation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reset = ofNullable(builder.getReset()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.change = ofNullable(builder.getChange()).map(f->f.build()).orElse(null);
			this.optionExercise = ofNullable(builder.getOptionExercise()).map(f->f.build()).orElse(null);
			this.optionExpiry = ofNullable(builder.getOptionExpiry()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.optionEvent = ofNullable(builder.getOptionEvent()).map(f->f.build()).orElse(null);
			this.additionalEvent = ofNullable(builder.getAdditionalEvent()).map(f->f.build()).orElse(null);
			this.primaryAssetClass = ofNullable(builder.getPrimaryAssetClass()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).map(f->f.build()).orElse(null);
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("tradingEvent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradingEvent")
		public List<? extends TradingEventSummary> getTradingEvent() {
			return tradingEvent;
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
		@RosettaAttribute("change")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("change")
		public TradeChangeContent getChange() {
			return change;
		}
		
		@Override
		@RosettaAttribute("optionExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionExercise")
		public OptionExercise getOptionExercise() {
			return optionExercise;
		}
		
		@Override
		@RosettaAttribute("optionExpiry")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionExpiry")
		public List<? extends OptionExpiry> getOptionExpiry() {
			return optionExpiry;
		}
		
		@Override
		@RosettaAttribute("optionEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionEvent")
		public OptionEvent getOptionEvent() {
			return optionEvent;
		}
		
		@Override
		@RosettaAttribute("additionalEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalEvent")
		public AdditionalEvent getAdditionalEvent() {
			return additionalEvent;
		}
		
		@Override
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryAssetClass")
		public AssetClass getPrimaryAssetClass() {
			return primaryAssetClass;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeIdentifier")
		public PartyTradeIdentifier getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		public List<? extends BusinessEventIdentifier> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
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
		public NonpublicExecutionReportRetracted build() {
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder toBuilder() {
			NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOriginatingEvent()).ifPresent(builder::setOriginatingEvent);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getTradingEvent()).ifPresent(builder::setTradingEvent);
			ofNullable(getAmendment()).ifPresent(builder::setAmendment);
			ofNullable(getIncrease()).ifPresent(builder::setIncrease);
			ofNullable(getTerminatingEvent()).ifPresent(builder::setTerminatingEvent);
			ofNullable(getTermination()).ifPresent(builder::setTermination);
			ofNullable(getNovation()).ifPresent(builder::setNovation);
			ofNullable(getWithdrawal()).ifPresent(builder::setWithdrawal);
			ofNullable(getObservation()).ifPresent(builder::setObservation);
			ofNullable(getReset()).ifPresent(builder::setReset);
			ofNullable(getChange()).ifPresent(builder::setChange);
			ofNullable(getOptionExercise()).ifPresent(builder::setOptionExercise);
			ofNullable(getOptionExpiry()).ifPresent(builder::setOptionExpiry);
			ofNullable(getOptionEvent()).ifPresent(builder::setOptionEvent);
			ofNullable(getAdditionalEvent()).ifPresent(builder::setAdditionalEvent);
			ofNullable(getPrimaryAssetClass()).ifPresent(builder::setPrimaryAssetClass);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonpublicExecutionReportRetracted _that = getType().cast(o);
		
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(tradingEvent, _that.getTradingEvent())) return false;
			if (!Objects.equals(amendment, _that.getAmendment())) return false;
			if (!Objects.equals(increase, _that.getIncrease())) return false;
			if (!Objects.equals(terminatingEvent, _that.getTerminatingEvent())) return false;
			if (!Objects.equals(termination, _that.getTermination())) return false;
			if (!Objects.equals(novation, _that.getNovation())) return false;
			if (!Objects.equals(withdrawal, _that.getWithdrawal())) return false;
			if (!ListEquals.listEquals(observation, _that.getObservation())) return false;
			if (!ListEquals.listEquals(reset, _that.getReset())) return false;
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!Objects.equals(optionExercise, _that.getOptionExercise())) return false;
			if (!ListEquals.listEquals(optionExpiry, _that.getOptionExpiry())) return false;
			if (!Objects.equals(optionEvent, _that.getOptionEvent())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradingEvent != null ? tradingEvent.hashCode() : 0);
			_result = 31 * _result + (amendment != null ? amendment.hashCode() : 0);
			_result = 31 * _result + (increase != null ? increase.hashCode() : 0);
			_result = 31 * _result + (terminatingEvent != null ? terminatingEvent.hashCode() : 0);
			_result = 31 * _result + (termination != null ? termination.hashCode() : 0);
			_result = 31 * _result + (novation != null ? novation.hashCode() : 0);
			_result = 31 * _result + (withdrawal != null ? withdrawal.hashCode() : 0);
			_result = 31 * _result + (observation != null ? observation.hashCode() : 0);
			_result = 31 * _result + (reset != null ? reset.hashCode() : 0);
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (optionExercise != null ? optionExercise.hashCode() : 0);
			_result = 31 * _result + (optionExpiry != null ? optionExpiry.hashCode() : 0);
			_result = 31 * _result + (optionEvent != null ? optionEvent.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonpublicExecutionReportRetracted {" +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"tradingEvent=" + this.tradingEvent + ", " +
				"amendment=" + this.amendment + ", " +
				"increase=" + this.increase + ", " +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"termination=" + this.termination + ", " +
				"novation=" + this.novation + ", " +
				"withdrawal=" + this.withdrawal + ", " +
				"observation=" + this.observation + ", " +
				"reset=" + this.reset + ", " +
				"change=" + this.change + ", " +
				"optionExercise=" + this.optionExercise + ", " +
				"optionExpiry=" + this.optionExpiry + ", " +
				"optionEvent=" + this.optionEvent + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonpublicExecutionReportRetracted  ***********************/
	class NonpublicExecutionReportRetractedBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl implements NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder {
	
		protected OriginatingEvent.OriginatingEventBuilder originatingEvent;
		protected Trade.TradeBuilder trade;
		protected List<TradingEventSummary.TradingEventSummaryBuilder> tradingEvent = new ArrayList<>();
		protected TradeAmendmentContent.TradeAmendmentContentBuilder amendment;
		protected TradeNotionalChange.TradeNotionalChangeBuilder increase;
		protected TerminatingEvent.TerminatingEventBuilder terminatingEvent;
		protected TradeNotionalChange.TradeNotionalChangeBuilder termination;
		protected TradeNovationContent.TradeNovationContentBuilder novation;
		protected Withdrawal.WithdrawalBuilder withdrawal;
		protected List<ObservationEvent.ObservationEventBuilder> observation = new ArrayList<>();
		protected List<ResetEvent.ResetEventBuilder> reset = new ArrayList<>();
		protected TradeChangeContent.TradeChangeContentBuilder change;
		protected OptionExercise.OptionExerciseBuilder optionExercise;
		protected List<OptionExpiry.OptionExpiryBuilder> optionExpiry = new ArrayList<>();
		protected OptionEvent.OptionEventBuilder optionEvent;
		protected AdditionalEvent.AdditionalEventBuilder additionalEvent;
		protected AssetClass.AssetClassBuilder primaryAssetClass;
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder tradeIdentifier;
		protected List<BusinessEventIdentifier.BusinessEventIdentifierBuilder> eventIdentifier = new ArrayList<>();
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
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
		@RosettaAttribute("tradingEvent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradingEvent")
		public List<? extends TradingEventSummary.TradingEventSummaryBuilder> getTradingEvent() {
			return tradingEvent;
		}
		
		@Override
		public TradingEventSummary.TradingEventSummaryBuilder getOrCreateTradingEvent(int index) {
			if (tradingEvent==null) {
				this.tradingEvent = new ArrayList<>();
			}
			return getIndex(tradingEvent, index, () -> {
						TradingEventSummary.TradingEventSummaryBuilder newTradingEvent = TradingEventSummary.builder();
						return newTradingEvent;
					});
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
		@RosettaAttribute("optionExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionExercise")
		public OptionExercise.OptionExerciseBuilder getOptionExercise() {
			return optionExercise;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder getOrCreateOptionExercise() {
			OptionExercise.OptionExerciseBuilder result;
			if (optionExercise!=null) {
				result = optionExercise;
			}
			else {
				result = optionExercise = OptionExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionExpiry")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionExpiry")
		public List<? extends OptionExpiry.OptionExpiryBuilder> getOptionExpiry() {
			return optionExpiry;
		}
		
		@Override
		public OptionExpiry.OptionExpiryBuilder getOrCreateOptionExpiry(int index) {
			if (optionExpiry==null) {
				this.optionExpiry = new ArrayList<>();
			}
			return getIndex(optionExpiry, index, () -> {
						OptionExpiry.OptionExpiryBuilder newOptionExpiry = OptionExpiry.builder();
						return newOptionExpiry;
					});
		}
		
		@Override
		@RosettaAttribute("optionEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionEvent")
		public OptionEvent.OptionEventBuilder getOptionEvent() {
			return optionEvent;
		}
		
		@Override
		public OptionEvent.OptionEventBuilder getOrCreateOptionEvent() {
			OptionEvent.OptionEventBuilder result;
			if (optionEvent!=null) {
				result = optionEvent;
			}
			else {
				result = optionEvent = OptionEvent.builder();
			}
			
			return result;
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
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryAssetClass")
		public AssetClass.AssetClassBuilder getPrimaryAssetClass() {
			return primaryAssetClass;
		}
		
		@Override
		public AssetClass.AssetClassBuilder getOrCreatePrimaryAssetClass() {
			AssetClass.AssetClassBuilder result;
			if (primaryAssetClass!=null) {
				result = primaryAssetClass;
			}
			else {
				result = primaryAssetClass = AssetClass.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeIdentifier")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier() {
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			if (tradeIdentifier!=null) {
				result = tradeIdentifier;
			}
			else {
				result = tradeIdentifier = PartyTradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		public List<? extends BusinessEventIdentifier.BusinessEventIdentifierBuilder> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateEventIdentifier(int index) {
			if (eventIdentifier==null) {
				this.eventIdentifier = new ArrayList<>();
			}
			return getIndex(eventIdentifier, index, () -> {
						BusinessEventIdentifier.BusinessEventIdentifierBuilder newEventIdentifier = BusinessEventIdentifier.builder();
						return newEventIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index) {
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			return getIndex(relatedParty, index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
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
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addValidation(List<? extends Validation> validations) {
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
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setValidation(List<? extends Validation> validations) {
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
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingEvent")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setOriginatingEvent(OriginatingEvent _originatingEvent) {
			this.originatingEvent = _originatingEvent == null ? null : _originatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradingEvent")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradingEvent")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addTradingEvent(TradingEventSummary _tradingEvent) {
			if (_tradingEvent != null) {
				this.tradingEvent.add(_tradingEvent.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addTradingEvent(TradingEventSummary _tradingEvent, int idx) {
			getIndex(this.tradingEvent, idx, () -> _tradingEvent.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addTradingEvent(List<? extends TradingEventSummary> tradingEvents) {
			if (tradingEvents != null) {
				for (final TradingEventSummary toAdd : tradingEvents) {
					this.tradingEvent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradingEvent")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradingEvent")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setTradingEvent(List<? extends TradingEventSummary> tradingEvents) {
			if (tradingEvents == null) {
				this.tradingEvent = new ArrayList<>();
			} else {
				this.tradingEvent = tradingEvents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("amendment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendment")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setAmendment(TradeAmendmentContent _amendment) {
			this.amendment = _amendment == null ? null : _amendment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("increase")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("increase")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setIncrease(TradeNotionalChange _increase) {
			this.increase = _increase == null ? null : _increase.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminatingEvent")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setTerminatingEvent(TerminatingEvent _terminatingEvent) {
			this.terminatingEvent = _terminatingEvent == null ? null : _terminatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("termination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("termination")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setTermination(TradeNotionalChange _termination) {
			this.termination = _termination == null ? null : _termination.toBuilder();
			return this;
		}
		
		@RosettaAttribute("novation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("novation")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setNovation(TradeNovationContent _novation) {
			this.novation = _novation == null ? null : _novation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("withdrawal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("withdrawal")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setWithdrawal(Withdrawal _withdrawal) {
			this.withdrawal = _withdrawal == null ? null : _withdrawal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("observation")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addObservation(ObservationEvent _observation) {
			if (_observation != null) {
				this.observation.add(_observation.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addObservation(ObservationEvent _observation, int idx) {
			getIndex(this.observation, idx, () -> _observation.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addObservation(List<? extends ObservationEvent> observations) {
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
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setObservation(List<? extends ObservationEvent> observations) {
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
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addReset(ResetEvent _reset) {
			if (_reset != null) {
				this.reset.add(_reset.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addReset(ResetEvent _reset, int idx) {
			getIndex(this.reset, idx, () -> _reset.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addReset(List<? extends ResetEvent> resets) {
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
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setReset(List<? extends ResetEvent> resets) {
			if (resets == null) {
				this.reset = new ArrayList<>();
			} else {
				this.reset = resets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("change")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("change")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setChange(TradeChangeContent _change) {
			this.change = _change == null ? null : _change.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionExercise")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setOptionExercise(OptionExercise _optionExercise) {
			this.optionExercise = _optionExercise == null ? null : _optionExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionExpiry")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("optionExpiry")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addOptionExpiry(OptionExpiry _optionExpiry) {
			if (_optionExpiry != null) {
				this.optionExpiry.add(_optionExpiry.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addOptionExpiry(OptionExpiry _optionExpiry, int idx) {
			getIndex(this.optionExpiry, idx, () -> _optionExpiry.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addOptionExpiry(List<? extends OptionExpiry> optionExpirys) {
			if (optionExpirys != null) {
				for (final OptionExpiry toAdd : optionExpirys) {
					this.optionExpiry.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("optionExpiry")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("optionExpiry")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setOptionExpiry(List<? extends OptionExpiry> optionExpirys) {
			if (optionExpirys == null) {
				this.optionExpiry = new ArrayList<>();
			} else {
				this.optionExpiry = optionExpirys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionEvent")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setOptionEvent(OptionEvent _optionEvent) {
			this.optionEvent = _optionEvent == null ? null : _optionEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalEvent")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setAdditionalEvent(AdditionalEvent _additionalEvent) {
			this.additionalEvent = _additionalEvent == null ? null : _additionalEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeIdentifier")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			this.tradeIdentifier = _tradeIdentifier == null ? null : _tradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (final RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null) {
				this.relatedParty = new ArrayList<>();
			} else {
				this.relatedParty = relatedPartys.stream()
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
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addParty(List<? extends Party> partys) {
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
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setParty(List<? extends Party> partys) {
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
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder addAccount(List<? extends Account> accounts) {
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
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder setAccount(List<? extends Account> accounts) {
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
		public NonpublicExecutionReportRetracted build() {
			return new NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedImpl(this);
		}
		
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder prune() {
			super.prune();
			if (originatingEvent!=null && !originatingEvent.prune().hasData()) originatingEvent = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			tradingEvent = tradingEvent.stream().filter(b->b!=null).<TradingEventSummary.TradingEventSummaryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (amendment!=null && !amendment.prune().hasData()) amendment = null;
			if (increase!=null && !increase.prune().hasData()) increase = null;
			if (terminatingEvent!=null && !terminatingEvent.prune().hasData()) terminatingEvent = null;
			if (termination!=null && !termination.prune().hasData()) termination = null;
			if (novation!=null && !novation.prune().hasData()) novation = null;
			if (withdrawal!=null && !withdrawal.prune().hasData()) withdrawal = null;
			observation = observation.stream().filter(b->b!=null).<ObservationEvent.ObservationEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			reset = reset.stream().filter(b->b!=null).<ResetEvent.ResetEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (change!=null && !change.prune().hasData()) change = null;
			if (optionExercise!=null && !optionExercise.prune().hasData()) optionExercise = null;
			optionExpiry = optionExpiry.stream().filter(b->b!=null).<OptionExpiry.OptionExpiryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (optionEvent!=null && !optionEvent.prune().hasData()) optionEvent = null;
			if (additionalEvent!=null && !additionalEvent.prune().hasData()) additionalEvent = null;
			if (primaryAssetClass!=null && !primaryAssetClass.prune().hasData()) primaryAssetClass = null;
			if (tradeIdentifier!=null && !tradeIdentifier.prune().hasData()) tradeIdentifier = null;
			eventIdentifier = eventIdentifier.stream().filter(b->b!=null).<BusinessEventIdentifier.BusinessEventIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOriginatingEvent()!=null && getOriginatingEvent().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getTradingEvent()!=null && getTradingEvent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAmendment()!=null && getAmendment().hasData()) return true;
			if (getIncrease()!=null && getIncrease().hasData()) return true;
			if (getTerminatingEvent()!=null && getTerminatingEvent().hasData()) return true;
			if (getTermination()!=null && getTermination().hasData()) return true;
			if (getNovation()!=null && getNovation().hasData()) return true;
			if (getWithdrawal()!=null && getWithdrawal().hasData()) return true;
			if (getObservation()!=null && getObservation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReset()!=null && getReset().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getChange()!=null && getChange().hasData()) return true;
			if (getOptionExercise()!=null && getOptionExercise().hasData()) return true;
			if (getOptionExpiry()!=null && getOptionExpiry().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOptionEvent()!=null && getOptionEvent().hasData()) return true;
			if (getAdditionalEvent()!=null && getAdditionalEvent().hasData()) return true;
			if (getPrimaryAssetClass()!=null && getPrimaryAssetClass().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().hasData()) return true;
			if (getEventIdentifier()!=null && getEventIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder o = (NonpublicExecutionReportRetracted.NonpublicExecutionReportRetractedBuilder) other;
			
			merger.mergeRosetta(getOriginatingEvent(), o.getOriginatingEvent(), this::setOriginatingEvent);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getTradingEvent(), o.getTradingEvent(), this::getOrCreateTradingEvent);
			merger.mergeRosetta(getAmendment(), o.getAmendment(), this::setAmendment);
			merger.mergeRosetta(getIncrease(), o.getIncrease(), this::setIncrease);
			merger.mergeRosetta(getTerminatingEvent(), o.getTerminatingEvent(), this::setTerminatingEvent);
			merger.mergeRosetta(getTermination(), o.getTermination(), this::setTermination);
			merger.mergeRosetta(getNovation(), o.getNovation(), this::setNovation);
			merger.mergeRosetta(getWithdrawal(), o.getWithdrawal(), this::setWithdrawal);
			merger.mergeRosetta(getObservation(), o.getObservation(), this::getOrCreateObservation);
			merger.mergeRosetta(getReset(), o.getReset(), this::getOrCreateReset);
			merger.mergeRosetta(getChange(), o.getChange(), this::setChange);
			merger.mergeRosetta(getOptionExercise(), o.getOptionExercise(), this::setOptionExercise);
			merger.mergeRosetta(getOptionExpiry(), o.getOptionExpiry(), this::getOrCreateOptionExpiry);
			merger.mergeRosetta(getOptionEvent(), o.getOptionEvent(), this::setOptionEvent);
			merger.mergeRosetta(getAdditionalEvent(), o.getAdditionalEvent(), this::setAdditionalEvent);
			merger.mergeRosetta(getPrimaryAssetClass(), o.getPrimaryAssetClass(), this::setPrimaryAssetClass);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::setTradeIdentifier);
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::getOrCreateEventIdentifier);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonpublicExecutionReportRetracted _that = getType().cast(o);
		
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(tradingEvent, _that.getTradingEvent())) return false;
			if (!Objects.equals(amendment, _that.getAmendment())) return false;
			if (!Objects.equals(increase, _that.getIncrease())) return false;
			if (!Objects.equals(terminatingEvent, _that.getTerminatingEvent())) return false;
			if (!Objects.equals(termination, _that.getTermination())) return false;
			if (!Objects.equals(novation, _that.getNovation())) return false;
			if (!Objects.equals(withdrawal, _that.getWithdrawal())) return false;
			if (!ListEquals.listEquals(observation, _that.getObservation())) return false;
			if (!ListEquals.listEquals(reset, _that.getReset())) return false;
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!Objects.equals(optionExercise, _that.getOptionExercise())) return false;
			if (!ListEquals.listEquals(optionExpiry, _that.getOptionExpiry())) return false;
			if (!Objects.equals(optionEvent, _that.getOptionEvent())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradingEvent != null ? tradingEvent.hashCode() : 0);
			_result = 31 * _result + (amendment != null ? amendment.hashCode() : 0);
			_result = 31 * _result + (increase != null ? increase.hashCode() : 0);
			_result = 31 * _result + (terminatingEvent != null ? terminatingEvent.hashCode() : 0);
			_result = 31 * _result + (termination != null ? termination.hashCode() : 0);
			_result = 31 * _result + (novation != null ? novation.hashCode() : 0);
			_result = 31 * _result + (withdrawal != null ? withdrawal.hashCode() : 0);
			_result = 31 * _result + (observation != null ? observation.hashCode() : 0);
			_result = 31 * _result + (reset != null ? reset.hashCode() : 0);
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (optionExercise != null ? optionExercise.hashCode() : 0);
			_result = 31 * _result + (optionExpiry != null ? optionExpiry.hashCode() : 0);
			_result = 31 * _result + (optionEvent != null ? optionEvent.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonpublicExecutionReportRetractedBuilder {" +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"tradingEvent=" + this.tradingEvent + ", " +
				"amendment=" + this.amendment + ", " +
				"increase=" + this.increase + ", " +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"termination=" + this.termination + ", " +
				"novation=" + this.novation + ", " +
				"withdrawal=" + this.withdrawal + ", " +
				"observation=" + this.observation + ", " +
				"reset=" + this.reset + ", " +
				"change=" + this.change + ", " +
				"optionExercise=" + this.optionExercise + ", " +
				"optionExpiry=" + this.optionExpiry + ", " +
				"optionEvent=" + this.optionEvent + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

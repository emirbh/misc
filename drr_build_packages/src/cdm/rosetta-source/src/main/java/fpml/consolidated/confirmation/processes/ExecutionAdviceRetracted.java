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
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.confirmation.processes.meta.ExecutionAdviceRetractedMeta;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NonCorrectableRequestMessage;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatoryReportingCollateralization;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.OriginatingEvent;
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
 * Provision A message that withdraws an advice to a third party that a trade execution has occurred.
 *
 */
@RosettaDataType(value="ExecutionAdviceRetracted", builder=ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExecutionAdviceRetracted", model="fpml", builder=ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilderImpl.class, version="2.1.1")
public interface ExecutionAdviceRetracted extends NonCorrectableRequestMessage {

	ExecutionAdviceRetractedMeta metaData = new ExecutionAdviceRetractedMeta();

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
	TradeChangeContent getChange();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure describing an option exercise event. The optionExercise event supports partial exercise (specify the number of options or amount to exercise), full exercise (use fullExercise flag), as well as the option to request options not to be exercised.
	 *
	 */
	OptionExercise getOptionExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure describing an option expiring event (i.e. passing its last exercise time and becoming worthless.)
	 *
	 */
	List<? extends OptionExpiry> getOptionExpiry();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure describing knock in, knock out, touch and no touch events.
	 *
	 */
	OptionEvent getOptionEvent();
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
	 * Provision 
	 *
	 */
	List<? extends RegulatoryReportingCollateralization> getCollateralization();
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
	ExecutionAdviceRetracted build();
	
	ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder toBuilder();
	
	static ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder builder() {
		return new ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionAdviceRetracted> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExecutionAdviceRetracted> getType() {
		return ExecutionAdviceRetracted.class;
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
		processRosetta(path.newSubPath("change"), processor, TradeChangeContent.class, getChange());
		processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.class, getOptionExercise());
		processRosetta(path.newSubPath("optionExpiry"), processor, OptionExpiry.class, getOptionExpiry());
		processRosetta(path.newSubPath("optionEvent"), processor, OptionEvent.class, getOptionEvent());
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
		processRosetta(path.newSubPath("collateralization"), processor, RegulatoryReportingCollateralization.class, getCollateralization());
		processRosetta(path.newSubPath("paymentDetails"), processor, PaymentDetails.class, getPaymentDetails());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutionAdviceRetractedBuilder extends ExecutionAdviceRetracted, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
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
		RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder getOrCreateCollateralization(int index);
		@Override
		List<? extends RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder> getCollateralization();
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
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setActualBuild(Integer actualBuild);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setHeader(RequestMessageHeader header);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addValidation(Validation validation);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addValidation(Validation validation, int idx);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addValidation(List<? extends Validation> validation);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setValidation(List<? extends Validation> validation);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setTradePackage(TradePackage tradePackage);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setTrade(Trade trade);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setAmendment(TradeAmendmentContent amendment);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setIncrease(TradeNotionalChange increase);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setTerminatingEvent(TerminatingEvent terminatingEvent);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setTermination(TradeNotionalChange termination);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setNovation(TradeNovationContent novation);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setWithdrawal(Withdrawal withdrawal);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addObservation(ObservationEvent observation);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addObservation(ObservationEvent observation, int idx);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addObservation(List<? extends ObservationEvent> observation);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setObservation(List<? extends ObservationEvent> observation);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addReset(ResetEvent reset);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addReset(ResetEvent reset, int idx);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addReset(List<? extends ResetEvent> reset);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setReset(List<? extends ResetEvent> reset);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setChange(TradeChangeContent change);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setOptionExercise(OptionExercise optionExercise);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addOptionExpiry(OptionExpiry optionExpiry);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addOptionExpiry(OptionExpiry optionExpiry, int idx);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addOptionExpiry(List<? extends OptionExpiry> optionExpiry);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setOptionExpiry(List<? extends OptionExpiry> optionExpiry);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setOptionEvent(OptionEvent optionEvent);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setAdditionalEvent(AdditionalEvent additionalEvent);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addCollateralization(RegulatoryReportingCollateralization collateralization);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addCollateralization(RegulatoryReportingCollateralization collateralization, int idx);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addCollateralization(List<? extends RegulatoryReportingCollateralization> collateralization);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setCollateralization(List<? extends RegulatoryReportingCollateralization> collateralization);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addPaymentDetails(PaymentDetails paymentDetails);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addPaymentDetails(PaymentDetails paymentDetails, int idx);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addPaymentDetails(List<? extends PaymentDetails> paymentDetails);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setPaymentDetails(List<? extends PaymentDetails> paymentDetails);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addParty(Party party);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addParty(Party party, int idx);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addParty(List<? extends Party> party);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setParty(List<? extends Party> party);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addAccount(Account account);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addAccount(Account account, int idx);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addAccount(List<? extends Account> account);
		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setAccount(List<? extends Account> account);

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
			processRosetta(path.newSubPath("change"), processor, TradeChangeContent.TradeChangeContentBuilder.class, getChange());
			processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.OptionExerciseBuilder.class, getOptionExercise());
			processRosetta(path.newSubPath("optionExpiry"), processor, OptionExpiry.OptionExpiryBuilder.class, getOptionExpiry());
			processRosetta(path.newSubPath("optionEvent"), processor, OptionEvent.OptionEventBuilder.class, getOptionEvent());
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
			processRosetta(path.newSubPath("collateralization"), processor, RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder.class, getCollateralization());
			processRosetta(path.newSubPath("paymentDetails"), processor, PaymentDetails.PaymentDetailsBuilder.class, getPaymentDetails());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionAdviceRetracted  ***********************/
	class ExecutionAdviceRetractedImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements ExecutionAdviceRetracted {
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
		private final TradeChangeContent change;
		private final OptionExercise optionExercise;
		private final List<? extends OptionExpiry> optionExpiry;
		private final OptionEvent optionEvent;
		private final AdditionalEvent additionalEvent;
		private final List<? extends RegulatoryReportingCollateralization> collateralization;
		private final List<? extends PaymentDetails> paymentDetails;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected ExecutionAdviceRetractedImpl(ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder builder) {
			super(builder);
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
			this.change = ofNullable(builder.getChange()).map(f->f.build()).orElse(null);
			this.optionExercise = ofNullable(builder.getOptionExercise()).map(f->f.build()).orElse(null);
			this.optionExpiry = ofNullable(builder.getOptionExpiry()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.optionEvent = ofNullable(builder.getOptionEvent()).map(f->f.build()).orElse(null);
			this.additionalEvent = ofNullable(builder.getAdditionalEvent()).map(f->f.build()).orElse(null);
			this.collateralization = ofNullable(builder.getCollateralization()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.paymentDetails = ofNullable(builder.getPaymentDetails()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("collateralization")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("collateralization")
		public List<? extends RegulatoryReportingCollateralization> getCollateralization() {
			return collateralization;
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
		public ExecutionAdviceRetracted build() {
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder toBuilder() {
			ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder builder) {
			super.setBuilderFields(builder);
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
			ofNullable(getChange()).ifPresent(builder::setChange);
			ofNullable(getOptionExercise()).ifPresent(builder::setOptionExercise);
			ofNullable(getOptionExpiry()).ifPresent(builder::setOptionExpiry);
			ofNullable(getOptionEvent()).ifPresent(builder::setOptionEvent);
			ofNullable(getAdditionalEvent()).ifPresent(builder::setAdditionalEvent);
			ofNullable(getCollateralization()).ifPresent(builder::setCollateralization);
			ofNullable(getPaymentDetails()).ifPresent(builder::setPaymentDetails);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExecutionAdviceRetracted _that = getType().cast(o);
		
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
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!Objects.equals(optionExercise, _that.getOptionExercise())) return false;
			if (!ListEquals.listEquals(optionExpiry, _that.getOptionExpiry())) return false;
			if (!Objects.equals(optionEvent, _that.getOptionEvent())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!ListEquals.listEquals(collateralization, _that.getCollateralization())) return false;
			if (!ListEquals.listEquals(paymentDetails, _that.getPaymentDetails())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
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
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (optionExercise != null ? optionExercise.hashCode() : 0);
			_result = 31 * _result + (optionExpiry != null ? optionExpiry.hashCode() : 0);
			_result = 31 * _result + (optionEvent != null ? optionEvent.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (collateralization != null ? collateralization.hashCode() : 0);
			_result = 31 * _result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionAdviceRetracted {" +
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
				"change=" + this.change + ", " +
				"optionExercise=" + this.optionExercise + ", " +
				"optionExpiry=" + this.optionExpiry + ", " +
				"optionEvent=" + this.optionEvent + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"collateralization=" + this.collateralization + ", " +
				"paymentDetails=" + this.paymentDetails + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExecutionAdviceRetracted  ***********************/
	class ExecutionAdviceRetractedBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl implements ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder {
	
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
		protected TradeChangeContent.TradeChangeContentBuilder change;
		protected OptionExercise.OptionExerciseBuilder optionExercise;
		protected List<OptionExpiry.OptionExpiryBuilder> optionExpiry = new ArrayList<>();
		protected OptionEvent.OptionEventBuilder optionEvent;
		protected AdditionalEvent.AdditionalEventBuilder additionalEvent;
		protected List<RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder> collateralization = new ArrayList<>();
		protected List<PaymentDetails.PaymentDetailsBuilder> paymentDetails = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
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
		@RosettaAttribute("collateralization")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("collateralization")
		public List<? extends RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder> getCollateralization() {
			return collateralization;
		}
		
		@Override
		public RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder getOrCreateCollateralization(int index) {
			if (collateralization==null) {
				this.collateralization = new ArrayList<>();
			}
			return getIndex(collateralization, index, () -> {
						RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder newCollateralization = RegulatoryReportingCollateralization.builder();
						return newCollateralization;
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addValidation(List<? extends Validation> validations) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setValidation(List<? extends Validation> validations) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradePackage")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setTradePackage(TradePackage _tradePackage) {
			this.tradePackage = _tradePackage == null ? null : _tradePackage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingEvent")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setOriginatingEvent(OriginatingEvent _originatingEvent) {
			this.originatingEvent = _originatingEvent == null ? null : _originatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amendment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendment")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setAmendment(TradeAmendmentContent _amendment) {
			this.amendment = _amendment == null ? null : _amendment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("increase")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("increase")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setIncrease(TradeNotionalChange _increase) {
			this.increase = _increase == null ? null : _increase.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminatingEvent")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setTerminatingEvent(TerminatingEvent _terminatingEvent) {
			this.terminatingEvent = _terminatingEvent == null ? null : _terminatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("termination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("termination")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setTermination(TradeNotionalChange _termination) {
			this.termination = _termination == null ? null : _termination.toBuilder();
			return this;
		}
		
		@RosettaAttribute("novation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("novation")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setNovation(TradeNovationContent _novation) {
			this.novation = _novation == null ? null : _novation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("withdrawal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("withdrawal")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setWithdrawal(Withdrawal _withdrawal) {
			this.withdrawal = _withdrawal == null ? null : _withdrawal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("observation")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addObservation(ObservationEvent _observation) {
			if (_observation != null) {
				this.observation.add(_observation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addObservation(ObservationEvent _observation, int idx) {
			getIndex(this.observation, idx, () -> _observation.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addObservation(List<? extends ObservationEvent> observations) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setObservation(List<? extends ObservationEvent> observations) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addReset(ResetEvent _reset) {
			if (_reset != null) {
				this.reset.add(_reset.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addReset(ResetEvent _reset, int idx) {
			getIndex(this.reset, idx, () -> _reset.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addReset(List<? extends ResetEvent> resets) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setReset(List<? extends ResetEvent> resets) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setChange(TradeChangeContent _change) {
			this.change = _change == null ? null : _change.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionExercise")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setOptionExercise(OptionExercise _optionExercise) {
			this.optionExercise = _optionExercise == null ? null : _optionExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionExpiry")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("optionExpiry")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addOptionExpiry(OptionExpiry _optionExpiry) {
			if (_optionExpiry != null) {
				this.optionExpiry.add(_optionExpiry.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addOptionExpiry(OptionExpiry _optionExpiry, int idx) {
			getIndex(this.optionExpiry, idx, () -> _optionExpiry.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addOptionExpiry(List<? extends OptionExpiry> optionExpirys) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setOptionExpiry(List<? extends OptionExpiry> optionExpirys) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setOptionEvent(OptionEvent _optionEvent) {
			this.optionEvent = _optionEvent == null ? null : _optionEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalEvent")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setAdditionalEvent(AdditionalEvent _additionalEvent) {
			this.additionalEvent = _additionalEvent == null ? null : _additionalEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralization")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("collateralization")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addCollateralization(RegulatoryReportingCollateralization _collateralization) {
			if (_collateralization != null) {
				this.collateralization.add(_collateralization.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addCollateralization(RegulatoryReportingCollateralization _collateralization, int idx) {
			getIndex(this.collateralization, idx, () -> _collateralization.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addCollateralization(List<? extends RegulatoryReportingCollateralization> collateralizations) {
			if (collateralizations != null) {
				for (final RegulatoryReportingCollateralization toAdd : collateralizations) {
					this.collateralization.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("collateralization")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("collateralization")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setCollateralization(List<? extends RegulatoryReportingCollateralization> collateralizations) {
			if (collateralizations == null) {
				this.collateralization = new ArrayList<>();
			} else {
				this.collateralization = collateralizations.stream()
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addPaymentDetails(PaymentDetails _paymentDetails) {
			if (_paymentDetails != null) {
				this.paymentDetails.add(_paymentDetails.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addPaymentDetails(PaymentDetails _paymentDetails, int idx) {
			getIndex(this.paymentDetails, idx, () -> _paymentDetails.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addPaymentDetails(List<? extends PaymentDetails> paymentDetailss) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setPaymentDetails(List<? extends PaymentDetails> paymentDetailss) {
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
		@Multi
		@RuneAttribute("party")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addParty(List<? extends Party> partys) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setParty(List<? extends Party> partys) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder addAccount(List<? extends Account> accounts) {
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
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder setAccount(List<? extends Account> accounts) {
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
		public ExecutionAdviceRetracted build() {
			return new ExecutionAdviceRetracted.ExecutionAdviceRetractedImpl(this);
		}
		
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder prune() {
			super.prune();
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
			if (change!=null && !change.prune().hasData()) change = null;
			if (optionExercise!=null && !optionExercise.prune().hasData()) optionExercise = null;
			optionExpiry = optionExpiry.stream().filter(b->b!=null).<OptionExpiry.OptionExpiryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (optionEvent!=null && !optionEvent.prune().hasData()) optionEvent = null;
			if (additionalEvent!=null && !additionalEvent.prune().hasData()) additionalEvent = null;
			collateralization = collateralization.stream().filter(b->b!=null).<RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			paymentDetails = paymentDetails.stream().filter(b->b!=null).<PaymentDetails.PaymentDetailsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
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
			if (getChange()!=null && getChange().hasData()) return true;
			if (getOptionExercise()!=null && getOptionExercise().hasData()) return true;
			if (getOptionExpiry()!=null && getOptionExpiry().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOptionEvent()!=null && getOptionEvent().hasData()) return true;
			if (getAdditionalEvent()!=null && getAdditionalEvent().hasData()) return true;
			if (getCollateralization()!=null && getCollateralization().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPaymentDetails()!=null && getPaymentDetails().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder o = (ExecutionAdviceRetracted.ExecutionAdviceRetractedBuilder) other;
			
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
			merger.mergeRosetta(getChange(), o.getChange(), this::setChange);
			merger.mergeRosetta(getOptionExercise(), o.getOptionExercise(), this::setOptionExercise);
			merger.mergeRosetta(getOptionExpiry(), o.getOptionExpiry(), this::getOrCreateOptionExpiry);
			merger.mergeRosetta(getOptionEvent(), o.getOptionEvent(), this::setOptionEvent);
			merger.mergeRosetta(getAdditionalEvent(), o.getAdditionalEvent(), this::setAdditionalEvent);
			merger.mergeRosetta(getCollateralization(), o.getCollateralization(), this::getOrCreateCollateralization);
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
		
			ExecutionAdviceRetracted _that = getType().cast(o);
		
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
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!Objects.equals(optionExercise, _that.getOptionExercise())) return false;
			if (!ListEquals.listEquals(optionExpiry, _that.getOptionExpiry())) return false;
			if (!Objects.equals(optionEvent, _that.getOptionEvent())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!ListEquals.listEquals(collateralization, _that.getCollateralization())) return false;
			if (!ListEquals.listEquals(paymentDetails, _that.getPaymentDetails())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
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
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (optionExercise != null ? optionExercise.hashCode() : 0);
			_result = 31 * _result + (optionExpiry != null ? optionExpiry.hashCode() : 0);
			_result = 31 * _result + (optionEvent != null ? optionEvent.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (collateralization != null ? collateralization.hashCode() : 0);
			_result = 31 * _result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionAdviceRetractedBuilder {" +
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
				"change=" + this.change + ", " +
				"optionExercise=" + this.optionExercise + ", " +
				"optionExpiry=" + this.optionExpiry + ", " +
				"optionEvent=" + this.optionEvent + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"collateralization=" + this.collateralization + ", " +
				"paymentDetails=" + this.paymentDetails + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}

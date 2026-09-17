package fpml.consolidated.confirmation.processes;

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
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.ObservationEvent;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.ResetEvent;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.confirmation.processes.meta.RequestConfirmationRetractedMeta;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.Party;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A requestConfirmation message may be cancelled using the requestConfirmationRetracted message.
 *
 */
@RosettaDataType(value="RequestConfirmationRetracted", builder=RequestConfirmationRetracted.RequestConfirmationRetractedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequestConfirmationRetracted", model="fpml", builder=RequestConfirmationRetracted.RequestConfirmationRetractedBuilderImpl.class, version="2.1.1")
public interface RequestConfirmationRetracted extends ConfirmationRetracted {

	RequestConfirmationRetractedMeta metaData = new RequestConfirmationRetractedMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RequestConfirmationRetracted build();
	
	RequestConfirmationRetracted.RequestConfirmationRetractedBuilder toBuilder();
	
	static RequestConfirmationRetracted.RequestConfirmationRetractedBuilder builder() {
		return new RequestConfirmationRetracted.RequestConfirmationRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestConfirmationRetracted> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequestConfirmationRetracted> getType() {
		return RequestConfirmationRetracted.class;
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
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
		processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.class, getOptionExercise());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestConfirmationRetractedBuilder extends RequestConfirmationRetracted, ConfirmationRetracted.ConfirmationRetractedBuilder {
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setActualBuild(Integer actualBuild);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setHeader(RequestMessageHeader header);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addValidation(Validation validation);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addValidation(Validation validation, int idx);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addValidation(List<? extends Validation> validation);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setValidation(List<? extends Validation> validation);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setTradePackage(TradePackage tradePackage);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setTrade(Trade trade);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setAmendment(TradeAmendmentContent amendment);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setIncrease(TradeNotionalChange increase);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setTerminatingEvent(TerminatingEvent terminatingEvent);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setTermination(TradeNotionalChange termination);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setNovation(TradeNovationContent novation);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setWithdrawal(Withdrawal withdrawal);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addObservation(ObservationEvent observation);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addObservation(ObservationEvent observation, int idx);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addObservation(List<? extends ObservationEvent> observation);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setObservation(List<? extends ObservationEvent> observation);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addReset(ResetEvent reset);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addReset(ResetEvent reset, int idx);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addReset(List<? extends ResetEvent> reset);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setReset(List<? extends ResetEvent> reset);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setAdditionalEvent(AdditionalEvent additionalEvent);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setOptionExercise(OptionExercise optionExercise);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addParty(Party party);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addParty(Party party, int idx);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addParty(List<? extends Party> party);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setParty(List<? extends Party> party);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addAccount(Account account);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addAccount(Account account, int idx);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addAccount(List<? extends Account> account);
		@Override
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setAccount(List<? extends Account> account);

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
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
			processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.OptionExerciseBuilder.class, getOptionExercise());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of RequestConfirmationRetracted  ***********************/
	class RequestConfirmationRetractedImpl extends ConfirmationRetracted.ConfirmationRetractedImpl implements RequestConfirmationRetracted {
		
		protected RequestConfirmationRetractedImpl(RequestConfirmationRetracted.RequestConfirmationRetractedBuilder builder) {
			super(builder);
		}
		
		@Override
		public RequestConfirmationRetracted build() {
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder toBuilder() {
			RequestConfirmationRetracted.RequestConfirmationRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestConfirmationRetracted.RequestConfirmationRetractedBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestConfirmationRetracted {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestConfirmationRetracted  ***********************/
	class RequestConfirmationRetractedBuilderImpl extends ConfirmationRetracted.ConfirmationRetractedBuilderImpl implements RequestConfirmationRetracted.RequestConfirmationRetractedBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addValidation(List<? extends Validation> validations) {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setValidation(List<? extends Validation> validations) {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setTradePackage(TradePackage _tradePackage) {
			this.tradePackage = _tradePackage == null ? null : _tradePackage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingEvent")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setOriginatingEvent(OriginatingEvent _originatingEvent) {
			this.originatingEvent = _originatingEvent == null ? null : _originatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amendment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendment")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setAmendment(TradeAmendmentContent _amendment) {
			this.amendment = _amendment == null ? null : _amendment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("increase")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("increase")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setIncrease(TradeNotionalChange _increase) {
			this.increase = _increase == null ? null : _increase.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminatingEvent")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setTerminatingEvent(TerminatingEvent _terminatingEvent) {
			this.terminatingEvent = _terminatingEvent == null ? null : _terminatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("termination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("termination")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setTermination(TradeNotionalChange _termination) {
			this.termination = _termination == null ? null : _termination.toBuilder();
			return this;
		}
		
		@RosettaAttribute("novation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("novation")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setNovation(TradeNovationContent _novation) {
			this.novation = _novation == null ? null : _novation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("withdrawal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("withdrawal")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setWithdrawal(Withdrawal _withdrawal) {
			this.withdrawal = _withdrawal == null ? null : _withdrawal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("observation")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addObservation(ObservationEvent _observation) {
			if (_observation != null) {
				this.observation.add(_observation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addObservation(ObservationEvent _observation, int idx) {
			getIndex(this.observation, idx, () -> _observation.toBuilder());
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addObservation(List<? extends ObservationEvent> observations) {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setObservation(List<? extends ObservationEvent> observations) {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addReset(ResetEvent _reset) {
			if (_reset != null) {
				this.reset.add(_reset.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addReset(ResetEvent _reset, int idx) {
			getIndex(this.reset, idx, () -> _reset.toBuilder());
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addReset(List<? extends ResetEvent> resets) {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setReset(List<? extends ResetEvent> resets) {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setAdditionalEvent(AdditionalEvent _additionalEvent) {
			this.additionalEvent = _additionalEvent == null ? null : _additionalEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionExercise")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setOptionExercise(OptionExercise _optionExercise) {
			this.optionExercise = _optionExercise == null ? null : _optionExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addParty(List<? extends Party> partys) {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setParty(List<? extends Party> partys) {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder addAccount(List<? extends Account> accounts) {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setAccount(List<? extends Account> accounts) {
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
		public RequestConfirmationRetracted build() {
			return new RequestConfirmationRetracted.RequestConfirmationRetractedImpl(this);
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RequestConfirmationRetracted.RequestConfirmationRetractedBuilder o = (RequestConfirmationRetracted.RequestConfirmationRetractedBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestConfirmationRetractedBuilder {" +
			'}' + " " + super.toString();
		}
	}
}

package fpml.consolidated.business.events;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.business.events.meta.EventProposedMatchMeta;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeDifference;
import fpml.consolidated.shared.MatchId;
import fpml.consolidated.shared.OriginatingEvent;
import java.math.BigDecimal;
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
 * Provision A structure that describes a proposed match between trades or post-trade event reports.
 *
 */
@RosettaDataType(value="EventProposedMatch", builder=EventProposedMatch.EventProposedMatchBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EventProposedMatch", model="fpml", builder=EventProposedMatch.EventProposedMatchBuilderImpl.class, version="2.1.1")
public interface EventProposedMatch extends RosettaModelObject {

	EventProposedMatchMeta metaData = new EventProposedMatchMeta();

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
	 * Provision A unique identifier assigned by the matching service to each set of matched positions.
	 *
	 */
	MatchId getMatchId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A type used to record the details of a difference between two sides of a business event.
	 *
	 */
	List<? extends TradeDifference> getDifference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Numeric score to represent the quality of the match.
	 *
	 */
	BigDecimal getMatchScore();

	/*********************** Build Methods  ***********************/
	EventProposedMatch build();
	
	EventProposedMatch.EventProposedMatchBuilder toBuilder();
	
	static EventProposedMatch.EventProposedMatchBuilder builder() {
		return new EventProposedMatch.EventProposedMatchBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventProposedMatch> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EventProposedMatch> getType() {
		return EventProposedMatch.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
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
		processRosetta(path.newSubPath("matchId"), processor, MatchId.class, getMatchId());
		processRosetta(path.newSubPath("difference"), processor, TradeDifference.class, getDifference());
		processor.processBasic(path.newSubPath("matchScore"), BigDecimal.class, getMatchScore(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventProposedMatchBuilder extends EventProposedMatch, RosettaModelObjectBuilder {
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
		MatchId.MatchIdBuilder getOrCreateMatchId();
		@Override
		MatchId.MatchIdBuilder getMatchId();
		TradeDifference.TradeDifferenceBuilder getOrCreateDifference(int index);
		@Override
		List<? extends TradeDifference.TradeDifferenceBuilder> getDifference();
		EventProposedMatch.EventProposedMatchBuilder setTradePackage(TradePackage tradePackage);
		EventProposedMatch.EventProposedMatchBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		EventProposedMatch.EventProposedMatchBuilder setTrade(Trade trade);
		EventProposedMatch.EventProposedMatchBuilder setAmendment(TradeAmendmentContent amendment);
		EventProposedMatch.EventProposedMatchBuilder setIncrease(TradeNotionalChange increase);
		EventProposedMatch.EventProposedMatchBuilder setTerminatingEvent(TerminatingEvent terminatingEvent);
		EventProposedMatch.EventProposedMatchBuilder setTermination(TradeNotionalChange termination);
		EventProposedMatch.EventProposedMatchBuilder setNovation(TradeNovationContent novation);
		EventProposedMatch.EventProposedMatchBuilder setWithdrawal(Withdrawal withdrawal);
		EventProposedMatch.EventProposedMatchBuilder addObservation(ObservationEvent observation);
		EventProposedMatch.EventProposedMatchBuilder addObservation(ObservationEvent observation, int idx);
		EventProposedMatch.EventProposedMatchBuilder addObservation(List<? extends ObservationEvent> observation);
		EventProposedMatch.EventProposedMatchBuilder setObservation(List<? extends ObservationEvent> observation);
		EventProposedMatch.EventProposedMatchBuilder addReset(ResetEvent reset);
		EventProposedMatch.EventProposedMatchBuilder addReset(ResetEvent reset, int idx);
		EventProposedMatch.EventProposedMatchBuilder addReset(List<? extends ResetEvent> reset);
		EventProposedMatch.EventProposedMatchBuilder setReset(List<? extends ResetEvent> reset);
		EventProposedMatch.EventProposedMatchBuilder setChange(TradeChangeContent change);
		EventProposedMatch.EventProposedMatchBuilder setOptionExercise(OptionExercise optionExercise);
		EventProposedMatch.EventProposedMatchBuilder addOptionExpiry(OptionExpiry optionExpiry);
		EventProposedMatch.EventProposedMatchBuilder addOptionExpiry(OptionExpiry optionExpiry, int idx);
		EventProposedMatch.EventProposedMatchBuilder addOptionExpiry(List<? extends OptionExpiry> optionExpiry);
		EventProposedMatch.EventProposedMatchBuilder setOptionExpiry(List<? extends OptionExpiry> optionExpiry);
		EventProposedMatch.EventProposedMatchBuilder setOptionEvent(OptionEvent optionEvent);
		EventProposedMatch.EventProposedMatchBuilder setAdditionalEvent(AdditionalEvent additionalEvent);
		EventProposedMatch.EventProposedMatchBuilder setMatchId(MatchId matchId);
		EventProposedMatch.EventProposedMatchBuilder addDifference(TradeDifference difference);
		EventProposedMatch.EventProposedMatchBuilder addDifference(TradeDifference difference, int idx);
		EventProposedMatch.EventProposedMatchBuilder addDifference(List<? extends TradeDifference> difference);
		EventProposedMatch.EventProposedMatchBuilder setDifference(List<? extends TradeDifference> difference);
		EventProposedMatch.EventProposedMatchBuilder setMatchScore(BigDecimal matchScore);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
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
			processRosetta(path.newSubPath("matchId"), processor, MatchId.MatchIdBuilder.class, getMatchId());
			processRosetta(path.newSubPath("difference"), processor, TradeDifference.TradeDifferenceBuilder.class, getDifference());
			processor.processBasic(path.newSubPath("matchScore"), BigDecimal.class, getMatchScore(), this);
		}
		

		EventProposedMatch.EventProposedMatchBuilder prune();
	}

	/*********************** Immutable Implementation of EventProposedMatch  ***********************/
	class EventProposedMatchImpl implements EventProposedMatch {
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
		private final MatchId matchId;
		private final List<? extends TradeDifference> difference;
		private final BigDecimal matchScore;
		
		protected EventProposedMatchImpl(EventProposedMatch.EventProposedMatchBuilder builder) {
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
			this.matchId = ofNullable(builder.getMatchId()).map(f->f.build()).orElse(null);
			this.difference = ofNullable(builder.getDifference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.matchScore = builder.getMatchScore();
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
		@RosettaAttribute("matchId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("matchId")
		public MatchId getMatchId() {
			return matchId;
		}
		
		@Override
		@RosettaAttribute("difference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("difference")
		public List<? extends TradeDifference> getDifference() {
			return difference;
		}
		
		@Override
		@RosettaAttribute("matchScore")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("matchScore")
		public BigDecimal getMatchScore() {
			return matchScore;
		}
		
		@Override
		public EventProposedMatch build() {
			return this;
		}
		
		@Override
		public EventProposedMatch.EventProposedMatchBuilder toBuilder() {
			EventProposedMatch.EventProposedMatchBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventProposedMatch.EventProposedMatchBuilder builder) {
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
			ofNullable(getMatchId()).ifPresent(builder::setMatchId);
			ofNullable(getDifference()).ifPresent(builder::setDifference);
			ofNullable(getMatchScore()).ifPresent(builder::setMatchScore);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventProposedMatch _that = getType().cast(o);
		
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
			if (!Objects.equals(matchId, _that.getMatchId())) return false;
			if (!ListEquals.listEquals(difference, _that.getDifference())) return false;
			if (!Objects.equals(matchScore, _that.getMatchScore())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
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
			_result = 31 * _result + (matchId != null ? matchId.hashCode() : 0);
			_result = 31 * _result + (difference != null ? difference.hashCode() : 0);
			_result = 31 * _result + (matchScore != null ? matchScore.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventProposedMatch {" +
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
				"matchId=" + this.matchId + ", " +
				"difference=" + this.difference + ", " +
				"matchScore=" + this.matchScore +
			'}';
		}
	}

	/*********************** Builder Implementation of EventProposedMatch  ***********************/
	class EventProposedMatchBuilderImpl implements EventProposedMatch.EventProposedMatchBuilder {
	
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
		protected MatchId.MatchIdBuilder matchId;
		protected List<TradeDifference.TradeDifferenceBuilder> difference = new ArrayList<>();
		protected BigDecimal matchScore;
		
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
		@RosettaAttribute("matchId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("matchId")
		public MatchId.MatchIdBuilder getMatchId() {
			return matchId;
		}
		
		@Override
		public MatchId.MatchIdBuilder getOrCreateMatchId() {
			MatchId.MatchIdBuilder result;
			if (matchId!=null) {
				result = matchId;
			}
			else {
				result = matchId = MatchId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("difference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("difference")
		public List<? extends TradeDifference.TradeDifferenceBuilder> getDifference() {
			return difference;
		}
		
		@Override
		public TradeDifference.TradeDifferenceBuilder getOrCreateDifference(int index) {
			if (difference==null) {
				this.difference = new ArrayList<>();
			}
			return getIndex(difference, index, () -> {
						TradeDifference.TradeDifferenceBuilder newDifference = TradeDifference.builder();
						return newDifference;
					});
		}
		
		@Override
		@RosettaAttribute("matchScore")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("matchScore")
		public BigDecimal getMatchScore() {
			return matchScore;
		}
		
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradePackage")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setTradePackage(TradePackage _tradePackage) {
			this.tradePackage = _tradePackage == null ? null : _tradePackage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingEvent")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setOriginatingEvent(OriginatingEvent _originatingEvent) {
			this.originatingEvent = _originatingEvent == null ? null : _originatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amendment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amendment")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setAmendment(TradeAmendmentContent _amendment) {
			this.amendment = _amendment == null ? null : _amendment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("increase")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("increase")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setIncrease(TradeNotionalChange _increase) {
			this.increase = _increase == null ? null : _increase.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminatingEvent")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setTerminatingEvent(TerminatingEvent _terminatingEvent) {
			this.terminatingEvent = _terminatingEvent == null ? null : _terminatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("termination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("termination")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setTermination(TradeNotionalChange _termination) {
			this.termination = _termination == null ? null : _termination.toBuilder();
			return this;
		}
		
		@RosettaAttribute("novation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("novation")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setNovation(TradeNovationContent _novation) {
			this.novation = _novation == null ? null : _novation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("withdrawal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("withdrawal")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setWithdrawal(Withdrawal _withdrawal) {
			this.withdrawal = _withdrawal == null ? null : _withdrawal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("observation")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder addObservation(ObservationEvent _observation) {
			if (_observation != null) {
				this.observation.add(_observation.toBuilder());
			}
			return this;
		}
		
		@Override
		public EventProposedMatch.EventProposedMatchBuilder addObservation(ObservationEvent _observation, int idx) {
			getIndex(this.observation, idx, () -> _observation.toBuilder());
			return this;
		}
		
		@Override
		public EventProposedMatch.EventProposedMatchBuilder addObservation(List<? extends ObservationEvent> observations) {
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
		public EventProposedMatch.EventProposedMatchBuilder setObservation(List<? extends ObservationEvent> observations) {
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
		public EventProposedMatch.EventProposedMatchBuilder addReset(ResetEvent _reset) {
			if (_reset != null) {
				this.reset.add(_reset.toBuilder());
			}
			return this;
		}
		
		@Override
		public EventProposedMatch.EventProposedMatchBuilder addReset(ResetEvent _reset, int idx) {
			getIndex(this.reset, idx, () -> _reset.toBuilder());
			return this;
		}
		
		@Override
		public EventProposedMatch.EventProposedMatchBuilder addReset(List<? extends ResetEvent> resets) {
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
		public EventProposedMatch.EventProposedMatchBuilder setReset(List<? extends ResetEvent> resets) {
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
		public EventProposedMatch.EventProposedMatchBuilder setChange(TradeChangeContent _change) {
			this.change = _change == null ? null : _change.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionExercise")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setOptionExercise(OptionExercise _optionExercise) {
			this.optionExercise = _optionExercise == null ? null : _optionExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionExpiry")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("optionExpiry")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder addOptionExpiry(OptionExpiry _optionExpiry) {
			if (_optionExpiry != null) {
				this.optionExpiry.add(_optionExpiry.toBuilder());
			}
			return this;
		}
		
		@Override
		public EventProposedMatch.EventProposedMatchBuilder addOptionExpiry(OptionExpiry _optionExpiry, int idx) {
			getIndex(this.optionExpiry, idx, () -> _optionExpiry.toBuilder());
			return this;
		}
		
		@Override
		public EventProposedMatch.EventProposedMatchBuilder addOptionExpiry(List<? extends OptionExpiry> optionExpirys) {
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
		public EventProposedMatch.EventProposedMatchBuilder setOptionExpiry(List<? extends OptionExpiry> optionExpirys) {
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
		public EventProposedMatch.EventProposedMatchBuilder setOptionEvent(OptionEvent _optionEvent) {
			this.optionEvent = _optionEvent == null ? null : _optionEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalEvent")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setAdditionalEvent(AdditionalEvent _additionalEvent) {
			this.additionalEvent = _additionalEvent == null ? null : _additionalEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("matchId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("matchId")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setMatchId(MatchId _matchId) {
			this.matchId = _matchId == null ? null : _matchId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("difference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("difference")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder addDifference(TradeDifference _difference) {
			if (_difference != null) {
				this.difference.add(_difference.toBuilder());
			}
			return this;
		}
		
		@Override
		public EventProposedMatch.EventProposedMatchBuilder addDifference(TradeDifference _difference, int idx) {
			getIndex(this.difference, idx, () -> _difference.toBuilder());
			return this;
		}
		
		@Override
		public EventProposedMatch.EventProposedMatchBuilder addDifference(List<? extends TradeDifference> differences) {
			if (differences != null) {
				for (final TradeDifference toAdd : differences) {
					this.difference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("difference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("difference")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setDifference(List<? extends TradeDifference> differences) {
			if (differences == null) {
				this.difference = new ArrayList<>();
			} else {
				this.difference = differences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("matchScore")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("matchScore")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder setMatchScore(BigDecimal _matchScore) {
			this.matchScore = _matchScore == null ? null : _matchScore;
			return this;
		}
		
		@Override
		public EventProposedMatch build() {
			return new EventProposedMatch.EventProposedMatchImpl(this);
		}
		
		@Override
		public EventProposedMatch.EventProposedMatchBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder prune() {
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
			if (matchId!=null && !matchId.prune().hasData()) matchId = null;
			difference = difference.stream().filter(b->b!=null).<TradeDifference.TradeDifferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
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
			if (getMatchId()!=null && getMatchId().hasData()) return true;
			if (getDifference()!=null && getDifference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMatchScore()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventProposedMatch.EventProposedMatchBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EventProposedMatch.EventProposedMatchBuilder o = (EventProposedMatch.EventProposedMatchBuilder) other;
			
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
			merger.mergeRosetta(getMatchId(), o.getMatchId(), this::setMatchId);
			merger.mergeRosetta(getDifference(), o.getDifference(), this::getOrCreateDifference);
			
			merger.mergeBasic(getMatchScore(), o.getMatchScore(), this::setMatchScore);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EventProposedMatch _that = getType().cast(o);
		
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
			if (!Objects.equals(matchId, _that.getMatchId())) return false;
			if (!ListEquals.listEquals(difference, _that.getDifference())) return false;
			if (!Objects.equals(matchScore, _that.getMatchScore())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
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
			_result = 31 * _result + (matchId != null ? matchId.hashCode() : 0);
			_result = 31 * _result + (difference != null ? difference.hashCode() : 0);
			_result = 31 * _result + (matchScore != null ? matchScore.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventProposedMatchBuilder {" +
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
				"matchId=" + this.matchId + ", " +
				"difference=" + this.difference + ", " +
				"matchScore=" + this.matchScore +
			'}';
		}
	}
}

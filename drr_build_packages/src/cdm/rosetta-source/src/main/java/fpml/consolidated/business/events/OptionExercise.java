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
import fpml.consolidated.business.events.meta.OptionExerciseMeta;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.fpmlenum.ExerciseActionEnum;
import fpml.consolidated.fpmlenum.ExerciseSideEnum;
import fpml.consolidated.fpmlenum.ExerciseTimingEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SimplePayment;
import java.math.BigDecimal;
import java.time.LocalTime;
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
 * version "recordkeeping-5.13"
 *
 * Provision A structure describing an option exercise. The OptionExercise type supports partial exercise (specify the number of options or amount to exercise), full exercise (use fullExercise flag), as well as the option to request options not to be exercised.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure describing an option exercise. The OptionExercise type supports partial exercise (specify the number of options or amount to exercise), full exercise (use fullExercise flag), as well as the option to request options not to be exercised.
 *
 */
@RosettaDataType(value="OptionExercise", builder=OptionExercise.OptionExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OptionExercise", model="fpml", builder=OptionExercise.OptionExerciseBuilderImpl.class, version="2.1.1")
public interface OptionExercise extends AbstractEvent {

	OptionExerciseMeta metaData = new OptionExerciseMeta();

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
	PartyReference getOptionSeller();
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
	PartyReference getOptionBuyer();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Fully describes the original trade (prior to the exercise).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Fully describes the original trade (prior to the exercise).
	 *
	 */
	Trade getOriginalTrade();
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
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
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
	ZonedDateTime getExerciseDate();
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
	LocalTime getExerciseTime();
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
	ExerciseTimingEnum getExerciseTiming();
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
	ExerciseActionEnum getExerciseAction();
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
	Boolean getExpiry();
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
	Boolean getFullExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised expressed as notional amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised expressed as notional amount.
	 *
	 */
	Money getExerciseInNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Notional amount after the Change
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Notional amount after the Change
	 *
	 */
	Money getOutstandingNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised expressed as number of options.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised expressed as number of options.
	 *
	 */
	BigDecimal getExerciseInNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Number of Options after the Change.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Number of Options after the Change.
	 *
	 */
	BigDecimal getOutstandingNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised express as number of units.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised express as number of units.
	 *
	 */
	BigDecimal getExerciseInNumberOfUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Number of Units
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Number of Units
	 *
	 */
	BigDecimal getOutstandingNumberOfUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Number of Units
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Number of Units
	 *
	 */
	List<? extends OptionExerciseAmounts> getSpecifiedExercise();
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
	ExerciseSideEnum getExerciseSide();
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
	SettlementTypeEnum getSettlementType();
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
	SimplePayment getCashSettlement();
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
	PhysicalSettlement getPhysicalSettlement();
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
	NonNegativePayment getPayment();
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
	ClearingInstructions getClearingInstructions();

	/*********************** Build Methods  ***********************/
	OptionExercise build();
	
	OptionExercise.OptionExerciseBuilder toBuilder();
	
	static OptionExercise.OptionExerciseBuilder builder() {
		return new OptionExercise.OptionExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionExercise> getType() {
		return OptionExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("optionSeller"), processor, PartyReference.class, getOptionSeller());
		processRosetta(path.newSubPath("optionBuyer"), processor, PartyReference.class, getOptionBuyer());
		processRosetta(path.newSubPath("originalTrade"), processor, Trade.class, getOriginalTrade());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processor.processBasic(path.newSubPath("exerciseDate"), ZonedDateTime.class, getExerciseDate(), this);
		processor.processBasic(path.newSubPath("exerciseTime"), LocalTime.class, getExerciseTime(), this);
		processor.processBasic(path.newSubPath("exerciseTiming"), ExerciseTimingEnum.class, getExerciseTiming(), this);
		processor.processBasic(path.newSubPath("exerciseAction"), ExerciseActionEnum.class, getExerciseAction(), this);
		processor.processBasic(path.newSubPath("expiry"), Boolean.class, getExpiry(), this);
		processor.processBasic(path.newSubPath("fullExercise"), Boolean.class, getFullExercise(), this);
		processRosetta(path.newSubPath("exerciseInNotionalAmount"), processor, Money.class, getExerciseInNotionalAmount());
		processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, Money.class, getOutstandingNotionalAmount());
		processor.processBasic(path.newSubPath("exerciseInNumberOfOptions"), BigDecimal.class, getExerciseInNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("exerciseInNumberOfUnits"), BigDecimal.class, getExerciseInNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
		processRosetta(path.newSubPath("specifiedExercise"), processor, OptionExerciseAmounts.class, getSpecifiedExercise());
		processor.processBasic(path.newSubPath("exerciseSide"), ExerciseSideEnum.class, getExerciseSide(), this);
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("cashSettlement"), processor, SimplePayment.class, getCashSettlement());
		processRosetta(path.newSubPath("physicalSettlement"), processor, PhysicalSettlement.class, getPhysicalSettlement());
		processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.class, getPayment());
		processRosetta(path.newSubPath("clearingInstructions"), processor, ClearingInstructions.class, getClearingInstructions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExerciseBuilder extends OptionExercise, AbstractEvent.AbstractEventBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateOptionSeller();
		@Override
		PartyReference.PartyReferenceBuilder getOptionSeller();
		PartyReference.PartyReferenceBuilder getOrCreateOptionBuyer();
		@Override
		PartyReference.PartyReferenceBuilder getOptionBuyer();
		Trade.TradeBuilder getOrCreateOriginalTrade();
		@Override
		Trade.TradeBuilder getOriginalTrade();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		Money.MoneyBuilder getOrCreateExerciseInNotionalAmount();
		@Override
		Money.MoneyBuilder getExerciseInNotionalAmount();
		Money.MoneyBuilder getOrCreateOutstandingNotionalAmount();
		@Override
		Money.MoneyBuilder getOutstandingNotionalAmount();
		OptionExerciseAmounts.OptionExerciseAmountsBuilder getOrCreateSpecifiedExercise(int index);
		@Override
		List<? extends OptionExerciseAmounts.OptionExerciseAmountsBuilder> getSpecifiedExercise();
		SimplePayment.SimplePaymentBuilder getOrCreateCashSettlement();
		@Override
		SimplePayment.SimplePaymentBuilder getCashSettlement();
		PhysicalSettlement.PhysicalSettlementBuilder getOrCreatePhysicalSettlement();
		@Override
		PhysicalSettlement.PhysicalSettlementBuilder getPhysicalSettlement();
		NonNegativePayment.NonNegativePaymentBuilder getOrCreatePayment();
		@Override
		NonNegativePayment.NonNegativePaymentBuilder getPayment();
		ClearingInstructions.ClearingInstructionsBuilder getOrCreateClearingInstructions();
		@Override
		ClearingInstructions.ClearingInstructionsBuilder getClearingInstructions();
		@Override
		OptionExercise.OptionExerciseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		OptionExercise.OptionExerciseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		OptionExercise.OptionExerciseBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		OptionExercise.OptionExerciseBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		OptionExercise.OptionExerciseBuilder setOptionSeller(PartyReference optionSeller);
		OptionExercise.OptionExerciseBuilder setOptionBuyer(PartyReference optionBuyer);
		OptionExercise.OptionExerciseBuilder setOriginalTrade(Trade originalTrade);
		OptionExercise.OptionExerciseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		OptionExercise.OptionExerciseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int idx);
		OptionExercise.OptionExerciseBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		OptionExercise.OptionExerciseBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier);
		OptionExercise.OptionExerciseBuilder setExerciseDate(ZonedDateTime exerciseDate);
		OptionExercise.OptionExerciseBuilder setExerciseTime(LocalTime exerciseTime);
		OptionExercise.OptionExerciseBuilder setExerciseTiming(ExerciseTimingEnum exerciseTiming);
		OptionExercise.OptionExerciseBuilder setExerciseAction(ExerciseActionEnum exerciseAction);
		OptionExercise.OptionExerciseBuilder setExpiry(Boolean expiry);
		OptionExercise.OptionExerciseBuilder setFullExercise(Boolean fullExercise);
		OptionExercise.OptionExerciseBuilder setExerciseInNotionalAmount(Money exerciseInNotionalAmount);
		OptionExercise.OptionExerciseBuilder setOutstandingNotionalAmount(Money outstandingNotionalAmount);
		OptionExercise.OptionExerciseBuilder setExerciseInNumberOfOptions(BigDecimal exerciseInNumberOfOptions);
		OptionExercise.OptionExerciseBuilder setOutstandingNumberOfOptions(BigDecimal outstandingNumberOfOptions);
		OptionExercise.OptionExerciseBuilder setExerciseInNumberOfUnits(BigDecimal exerciseInNumberOfUnits);
		OptionExercise.OptionExerciseBuilder setOutstandingNumberOfUnits(BigDecimal outstandingNumberOfUnits);
		OptionExercise.OptionExerciseBuilder addSpecifiedExercise(OptionExerciseAmounts specifiedExercise);
		OptionExercise.OptionExerciseBuilder addSpecifiedExercise(OptionExerciseAmounts specifiedExercise, int idx);
		OptionExercise.OptionExerciseBuilder addSpecifiedExercise(List<? extends OptionExerciseAmounts> specifiedExercise);
		OptionExercise.OptionExerciseBuilder setSpecifiedExercise(List<? extends OptionExerciseAmounts> specifiedExercise);
		OptionExercise.OptionExerciseBuilder setExerciseSide(ExerciseSideEnum exerciseSide);
		OptionExercise.OptionExerciseBuilder setSettlementType(SettlementTypeEnum settlementType);
		OptionExercise.OptionExerciseBuilder setCashSettlement(SimplePayment cashSettlement);
		OptionExercise.OptionExerciseBuilder setPhysicalSettlement(PhysicalSettlement physicalSettlement);
		OptionExercise.OptionExerciseBuilder setPayment(NonNegativePayment payment);
		OptionExercise.OptionExerciseBuilder setClearingInstructions(ClearingInstructions clearingInstructions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("optionSeller"), processor, PartyReference.PartyReferenceBuilder.class, getOptionSeller());
			processRosetta(path.newSubPath("optionBuyer"), processor, PartyReference.PartyReferenceBuilder.class, getOptionBuyer());
			processRosetta(path.newSubPath("originalTrade"), processor, Trade.TradeBuilder.class, getOriginalTrade());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processor.processBasic(path.newSubPath("exerciseDate"), ZonedDateTime.class, getExerciseDate(), this);
			processor.processBasic(path.newSubPath("exerciseTime"), LocalTime.class, getExerciseTime(), this);
			processor.processBasic(path.newSubPath("exerciseTiming"), ExerciseTimingEnum.class, getExerciseTiming(), this);
			processor.processBasic(path.newSubPath("exerciseAction"), ExerciseActionEnum.class, getExerciseAction(), this);
			processor.processBasic(path.newSubPath("expiry"), Boolean.class, getExpiry(), this);
			processor.processBasic(path.newSubPath("fullExercise"), Boolean.class, getFullExercise(), this);
			processRosetta(path.newSubPath("exerciseInNotionalAmount"), processor, Money.MoneyBuilder.class, getExerciseInNotionalAmount());
			processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, Money.MoneyBuilder.class, getOutstandingNotionalAmount());
			processor.processBasic(path.newSubPath("exerciseInNumberOfOptions"), BigDecimal.class, getExerciseInNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("exerciseInNumberOfUnits"), BigDecimal.class, getExerciseInNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
			processRosetta(path.newSubPath("specifiedExercise"), processor, OptionExerciseAmounts.OptionExerciseAmountsBuilder.class, getSpecifiedExercise());
			processor.processBasic(path.newSubPath("exerciseSide"), ExerciseSideEnum.class, getExerciseSide(), this);
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("cashSettlement"), processor, SimplePayment.SimplePaymentBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("physicalSettlement"), processor, PhysicalSettlement.PhysicalSettlementBuilder.class, getPhysicalSettlement());
			processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.NonNegativePaymentBuilder.class, getPayment());
			processRosetta(path.newSubPath("clearingInstructions"), processor, ClearingInstructions.ClearingInstructionsBuilder.class, getClearingInstructions());
		}
		

		OptionExercise.OptionExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of OptionExercise  ***********************/
	class OptionExerciseImpl extends AbstractEvent.AbstractEventImpl implements OptionExercise {
		private final PartyReference optionSeller;
		private final PartyReference optionBuyer;
		private final Trade originalTrade;
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final ZonedDateTime exerciseDate;
		private final LocalTime exerciseTime;
		private final ExerciseTimingEnum exerciseTiming;
		private final ExerciseActionEnum exerciseAction;
		private final Boolean expiry;
		private final Boolean fullExercise;
		private final Money exerciseInNotionalAmount;
		private final Money outstandingNotionalAmount;
		private final BigDecimal exerciseInNumberOfOptions;
		private final BigDecimal outstandingNumberOfOptions;
		private final BigDecimal exerciseInNumberOfUnits;
		private final BigDecimal outstandingNumberOfUnits;
		private final List<? extends OptionExerciseAmounts> specifiedExercise;
		private final ExerciseSideEnum exerciseSide;
		private final SettlementTypeEnum settlementType;
		private final SimplePayment cashSettlement;
		private final PhysicalSettlement physicalSettlement;
		private final NonNegativePayment payment;
		private final ClearingInstructions clearingInstructions;
		
		protected OptionExerciseImpl(OptionExercise.OptionExerciseBuilder builder) {
			super(builder);
			this.optionSeller = ofNullable(builder.getOptionSeller()).map(f->f.build()).orElse(null);
			this.optionBuyer = ofNullable(builder.getOptionBuyer()).map(f->f.build()).orElse(null);
			this.originalTrade = ofNullable(builder.getOriginalTrade()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.exerciseDate = builder.getExerciseDate();
			this.exerciseTime = builder.getExerciseTime();
			this.exerciseTiming = builder.getExerciseTiming();
			this.exerciseAction = builder.getExerciseAction();
			this.expiry = builder.getExpiry();
			this.fullExercise = builder.getFullExercise();
			this.exerciseInNotionalAmount = ofNullable(builder.getExerciseInNotionalAmount()).map(f->f.build()).orElse(null);
			this.outstandingNotionalAmount = ofNullable(builder.getOutstandingNotionalAmount()).map(f->f.build()).orElse(null);
			this.exerciseInNumberOfOptions = builder.getExerciseInNumberOfOptions();
			this.outstandingNumberOfOptions = builder.getOutstandingNumberOfOptions();
			this.exerciseInNumberOfUnits = builder.getExerciseInNumberOfUnits();
			this.outstandingNumberOfUnits = builder.getOutstandingNumberOfUnits();
			this.specifiedExercise = ofNullable(builder.getSpecifiedExercise()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.exerciseSide = builder.getExerciseSide();
			this.settlementType = builder.getSettlementType();
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.physicalSettlement = ofNullable(builder.getPhysicalSettlement()).map(f->f.build()).orElse(null);
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
			this.clearingInstructions = ofNullable(builder.getClearingInstructions()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionSeller")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionSeller")
		public PartyReference getOptionSeller() {
			return optionSeller;
		}
		
		@Override
		@RosettaAttribute("optionBuyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionBuyer")
		public PartyReference getOptionBuyer() {
			return optionBuyer;
		}
		
		@Override
		@RosettaAttribute("originalTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalTrade")
		public Trade getOriginalTrade() {
			return originalTrade;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("exerciseDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseDate")
		public ZonedDateTime getExerciseDate() {
			return exerciseDate;
		}
		
		@Override
		@RosettaAttribute("exerciseTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseTime")
		public LocalTime getExerciseTime() {
			return exerciseTime;
		}
		
		@Override
		@RosettaAttribute("exerciseTiming")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseTiming")
		public ExerciseTimingEnum getExerciseTiming() {
			return exerciseTiming;
		}
		
		@Override
		@RosettaAttribute("exerciseAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseAction")
		public ExerciseActionEnum getExerciseAction() {
			return exerciseAction;
		}
		
		@Override
		@RosettaAttribute("expiry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiry")
		public Boolean getExpiry() {
			return expiry;
		}
		
		@Override
		@RosettaAttribute("fullExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fullExercise")
		public Boolean getFullExercise() {
			return fullExercise;
		}
		
		@Override
		@RosettaAttribute("exerciseInNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNotionalAmount")
		public Money getExerciseInNotionalAmount() {
			return exerciseInNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNotionalAmount")
		public Money getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("exerciseInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNumberOfOptions")
		public BigDecimal getExerciseInNumberOfOptions() {
			return exerciseInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("exerciseInNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNumberOfUnits")
		public BigDecimal getExerciseInNumberOfUnits() {
			return exerciseInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("specifiedExercise")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("specifiedExercise")
		public List<? extends OptionExerciseAmounts> getSpecifiedExercise() {
			return specifiedExercise;
		}
		
		@Override
		@RosettaAttribute("exerciseSide")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseSide")
		public ExerciseSideEnum getExerciseSide() {
			return exerciseSide;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public SimplePayment getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlement")
		public PhysicalSettlement getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public NonNegativePayment getPayment() {
			return payment;
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingInstructions")
		public ClearingInstructions getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		public OptionExercise build() {
			return this;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder toBuilder() {
			OptionExercise.OptionExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExercise.OptionExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOptionSeller()).ifPresent(builder::setOptionSeller);
			ofNullable(getOptionBuyer()).ifPresent(builder::setOptionBuyer);
			ofNullable(getOriginalTrade()).ifPresent(builder::setOriginalTrade);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getExerciseDate()).ifPresent(builder::setExerciseDate);
			ofNullable(getExerciseTime()).ifPresent(builder::setExerciseTime);
			ofNullable(getExerciseTiming()).ifPresent(builder::setExerciseTiming);
			ofNullable(getExerciseAction()).ifPresent(builder::setExerciseAction);
			ofNullable(getExpiry()).ifPresent(builder::setExpiry);
			ofNullable(getFullExercise()).ifPresent(builder::setFullExercise);
			ofNullable(getExerciseInNotionalAmount()).ifPresent(builder::setExerciseInNotionalAmount);
			ofNullable(getOutstandingNotionalAmount()).ifPresent(builder::setOutstandingNotionalAmount);
			ofNullable(getExerciseInNumberOfOptions()).ifPresent(builder::setExerciseInNumberOfOptions);
			ofNullable(getOutstandingNumberOfOptions()).ifPresent(builder::setOutstandingNumberOfOptions);
			ofNullable(getExerciseInNumberOfUnits()).ifPresent(builder::setExerciseInNumberOfUnits);
			ofNullable(getOutstandingNumberOfUnits()).ifPresent(builder::setOutstandingNumberOfUnits);
			ofNullable(getSpecifiedExercise()).ifPresent(builder::setSpecifiedExercise);
			ofNullable(getExerciseSide()).ifPresent(builder::setExerciseSide);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getPhysicalSettlement()).ifPresent(builder::setPhysicalSettlement);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
			ofNullable(getClearingInstructions()).ifPresent(builder::setClearingInstructions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionExercise _that = getType().cast(o);
		
			if (!Objects.equals(optionSeller, _that.getOptionSeller())) return false;
			if (!Objects.equals(optionBuyer, _that.getOptionBuyer())) return false;
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(exerciseDate, _that.getExerciseDate())) return false;
			if (!Objects.equals(exerciseTime, _that.getExerciseTime())) return false;
			if (!Objects.equals(exerciseTiming, _that.getExerciseTiming())) return false;
			if (!Objects.equals(exerciseAction, _that.getExerciseAction())) return false;
			if (!Objects.equals(expiry, _that.getExpiry())) return false;
			if (!Objects.equals(fullExercise, _that.getFullExercise())) return false;
			if (!Objects.equals(exerciseInNotionalAmount, _that.getExerciseInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			if (!Objects.equals(exerciseInNumberOfOptions, _that.getExerciseInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			if (!Objects.equals(exerciseInNumberOfUnits, _that.getExerciseInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			if (!ListEquals.listEquals(specifiedExercise, _that.getSpecifiedExercise())) return false;
			if (!Objects.equals(exerciseSide, _that.getExerciseSide())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionSeller != null ? optionSeller.hashCode() : 0);
			_result = 31 * _result + (optionBuyer != null ? optionBuyer.hashCode() : 0);
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (exerciseDate != null ? exerciseDate.hashCode() : 0);
			_result = 31 * _result + (exerciseTime != null ? exerciseTime.hashCode() : 0);
			_result = 31 * _result + (exerciseTiming != null ? exerciseTiming.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exerciseAction != null ? exerciseAction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (expiry != null ? expiry.hashCode() : 0);
			_result = 31 * _result + (fullExercise != null ? fullExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseInNotionalAmount != null ? exerciseInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfOptions != null ? exerciseInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfUnits != null ? exerciseInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (specifiedExercise != null ? specifiedExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseSide != null ? exerciseSide.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExercise {" +
				"optionSeller=" + this.optionSeller + ", " +
				"optionBuyer=" + this.optionBuyer + ", " +
				"originalTrade=" + this.originalTrade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"exerciseDate=" + this.exerciseDate + ", " +
				"exerciseTime=" + this.exerciseTime + ", " +
				"exerciseTiming=" + this.exerciseTiming + ", " +
				"exerciseAction=" + this.exerciseAction + ", " +
				"expiry=" + this.expiry + ", " +
				"fullExercise=" + this.fullExercise + ", " +
				"exerciseInNotionalAmount=" + this.exerciseInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount + ", " +
				"exerciseInNumberOfOptions=" + this.exerciseInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions + ", " +
				"exerciseInNumberOfUnits=" + this.exerciseInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits + ", " +
				"specifiedExercise=" + this.specifiedExercise + ", " +
				"exerciseSide=" + this.exerciseSide + ", " +
				"settlementType=" + this.settlementType + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"payment=" + this.payment + ", " +
				"clearingInstructions=" + this.clearingInstructions +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionExercise  ***********************/
	class OptionExerciseBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl implements OptionExercise.OptionExerciseBuilder {
	
		protected PartyReference.PartyReferenceBuilder optionSeller;
		protected PartyReference.PartyReferenceBuilder optionBuyer;
		protected Trade.TradeBuilder originalTrade;
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected ZonedDateTime exerciseDate;
		protected LocalTime exerciseTime;
		protected ExerciseTimingEnum exerciseTiming;
		protected ExerciseActionEnum exerciseAction;
		protected Boolean expiry;
		protected Boolean fullExercise;
		protected Money.MoneyBuilder exerciseInNotionalAmount;
		protected Money.MoneyBuilder outstandingNotionalAmount;
		protected BigDecimal exerciseInNumberOfOptions;
		protected BigDecimal outstandingNumberOfOptions;
		protected BigDecimal exerciseInNumberOfUnits;
		protected BigDecimal outstandingNumberOfUnits;
		protected List<OptionExerciseAmounts.OptionExerciseAmountsBuilder> specifiedExercise = new ArrayList<>();
		protected ExerciseSideEnum exerciseSide;
		protected SettlementTypeEnum settlementType;
		protected SimplePayment.SimplePaymentBuilder cashSettlement;
		protected PhysicalSettlement.PhysicalSettlementBuilder physicalSettlement;
		protected NonNegativePayment.NonNegativePaymentBuilder payment;
		protected ClearingInstructions.ClearingInstructionsBuilder clearingInstructions;
		
		@Override
		@RosettaAttribute("optionSeller")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionSeller")
		public PartyReference.PartyReferenceBuilder getOptionSeller() {
			return optionSeller;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOptionSeller() {
			PartyReference.PartyReferenceBuilder result;
			if (optionSeller!=null) {
				result = optionSeller;
			}
			else {
				result = optionSeller = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionBuyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionBuyer")
		public PartyReference.PartyReferenceBuilder getOptionBuyer() {
			return optionBuyer;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOptionBuyer() {
			PartyReference.PartyReferenceBuilder result;
			if (optionBuyer!=null) {
				result = optionBuyer;
			}
			else {
				result = optionBuyer = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originalTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalTrade")
		public Trade.TradeBuilder getOriginalTrade() {
			return originalTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateOriginalTrade() {
			Trade.TradeBuilder result;
			if (originalTrade!=null) {
				result = originalTrade;
			}
			else {
				result = originalTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int index) {
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			return getIndex(tradeIdentifier, index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newTradeIdentifier = PartyTradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("exerciseDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseDate")
		public ZonedDateTime getExerciseDate() {
			return exerciseDate;
		}
		
		@Override
		@RosettaAttribute("exerciseTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseTime")
		public LocalTime getExerciseTime() {
			return exerciseTime;
		}
		
		@Override
		@RosettaAttribute("exerciseTiming")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseTiming")
		public ExerciseTimingEnum getExerciseTiming() {
			return exerciseTiming;
		}
		
		@Override
		@RosettaAttribute("exerciseAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseAction")
		public ExerciseActionEnum getExerciseAction() {
			return exerciseAction;
		}
		
		@Override
		@RosettaAttribute("expiry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiry")
		public Boolean getExpiry() {
			return expiry;
		}
		
		@Override
		@RosettaAttribute("fullExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fullExercise")
		public Boolean getFullExercise() {
			return fullExercise;
		}
		
		@Override
		@RosettaAttribute("exerciseInNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNotionalAmount")
		public Money.MoneyBuilder getExerciseInNotionalAmount() {
			return exerciseInNotionalAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateExerciseInNotionalAmount() {
			Money.MoneyBuilder result;
			if (exerciseInNotionalAmount!=null) {
				result = exerciseInNotionalAmount;
			}
			else {
				result = exerciseInNotionalAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNotionalAmount")
		public Money.MoneyBuilder getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateOutstandingNotionalAmount() {
			Money.MoneyBuilder result;
			if (outstandingNotionalAmount!=null) {
				result = outstandingNotionalAmount;
			}
			else {
				result = outstandingNotionalAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNumberOfOptions")
		public BigDecimal getExerciseInNumberOfOptions() {
			return exerciseInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("exerciseInNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNumberOfUnits")
		public BigDecimal getExerciseInNumberOfUnits() {
			return exerciseInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("specifiedExercise")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("specifiedExercise")
		public List<? extends OptionExerciseAmounts.OptionExerciseAmountsBuilder> getSpecifiedExercise() {
			return specifiedExercise;
		}
		
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder getOrCreateSpecifiedExercise(int index) {
			if (specifiedExercise==null) {
				this.specifiedExercise = new ArrayList<>();
			}
			return getIndex(specifiedExercise, index, () -> {
						OptionExerciseAmounts.OptionExerciseAmountsBuilder newSpecifiedExercise = OptionExerciseAmounts.builder();
						return newSpecifiedExercise;
					});
		}
		
		@Override
		@RosettaAttribute("exerciseSide")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseSide")
		public ExerciseSideEnum getExerciseSide() {
			return exerciseSide;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public SimplePayment.SimplePaymentBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getOrCreateCashSettlement() {
			SimplePayment.SimplePaymentBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = SimplePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlement")
		public PhysicalSettlement.PhysicalSettlementBuilder getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		public PhysicalSettlement.PhysicalSettlementBuilder getOrCreatePhysicalSettlement() {
			PhysicalSettlement.PhysicalSettlementBuilder result;
			if (physicalSettlement!=null) {
				result = physicalSettlement;
			}
			else {
				result = physicalSettlement = PhysicalSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public NonNegativePayment.NonNegativePaymentBuilder getPayment() {
			return payment;
		}
		
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder getOrCreatePayment() {
			NonNegativePayment.NonNegativePaymentBuilder result;
			if (payment!=null) {
				result = payment;
			}
			else {
				result = payment = NonNegativePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingInstructions")
		public ClearingInstructions.ClearingInstructionsBuilder getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		public ClearingInstructions.ClearingInstructionsBuilder getOrCreateClearingInstructions() {
			ClearingInstructions.ClearingInstructionsBuilder result;
			if (clearingInstructions!=null) {
				result = clearingInstructions;
			}
			else {
				result = clearingInstructions = ClearingInstructions.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public OptionExercise.OptionExerciseBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public OptionExercise.OptionExerciseBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionSeller")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionSeller")
		@Override
		public OptionExercise.OptionExerciseBuilder setOptionSeller(PartyReference _optionSeller) {
			this.optionSeller = _optionSeller == null ? null : _optionSeller.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionBuyer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionBuyer")
		@Override
		public OptionExercise.OptionExerciseBuilder setOptionBuyer(PartyReference _optionBuyer) {
			this.optionBuyer = _optionBuyer == null ? null : _optionBuyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originalTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalTrade")
		@Override
		public OptionExercise.OptionExerciseBuilder setOriginalTrade(Trade _originalTrade) {
			this.originalTrade = _originalTrade == null ? null : _originalTrade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public OptionExercise.OptionExerciseBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			if (_tradeIdentifier != null) {
				this.tradeIdentifier.add(_tradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder addTradeIdentifier(PartyTradeIdentifier _tradeIdentifier, int idx) {
			getIndex(this.tradeIdentifier, idx, () -> _tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (final PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public OptionExercise.OptionExerciseBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null) {
				this.tradeIdentifier = new ArrayList<>();
			} else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("exerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseDate")
		@Override
		public OptionExercise.OptionExerciseBuilder setExerciseDate(ZonedDateTime _exerciseDate) {
			this.exerciseDate = _exerciseDate == null ? null : _exerciseDate;
			return this;
		}
		
		@RosettaAttribute("exerciseTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseTime")
		@Override
		public OptionExercise.OptionExerciseBuilder setExerciseTime(LocalTime _exerciseTime) {
			this.exerciseTime = _exerciseTime == null ? null : _exerciseTime;
			return this;
		}
		
		@RosettaAttribute("exerciseTiming")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseTiming")
		@Override
		public OptionExercise.OptionExerciseBuilder setExerciseTiming(ExerciseTimingEnum _exerciseTiming) {
			this.exerciseTiming = _exerciseTiming == null ? null : _exerciseTiming;
			return this;
		}
		
		@RosettaAttribute("exerciseAction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseAction")
		@Override
		public OptionExercise.OptionExerciseBuilder setExerciseAction(ExerciseActionEnum _exerciseAction) {
			this.exerciseAction = _exerciseAction == null ? null : _exerciseAction;
			return this;
		}
		
		@RosettaAttribute("expiry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiry")
		@Override
		public OptionExercise.OptionExerciseBuilder setExpiry(Boolean _expiry) {
			this.expiry = _expiry == null ? null : _expiry;
			return this;
		}
		
		@RosettaAttribute("fullExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fullExercise")
		@Override
		public OptionExercise.OptionExerciseBuilder setFullExercise(Boolean _fullExercise) {
			this.fullExercise = _fullExercise == null ? null : _fullExercise;
			return this;
		}
		
		@RosettaAttribute("exerciseInNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseInNotionalAmount")
		@Override
		public OptionExercise.OptionExerciseBuilder setExerciseInNotionalAmount(Money _exerciseInNotionalAmount) {
			this.exerciseInNotionalAmount = _exerciseInNotionalAmount == null ? null : _exerciseInNotionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNotionalAmount")
		@Override
		public OptionExercise.OptionExerciseBuilder setOutstandingNotionalAmount(Money _outstandingNotionalAmount) {
			this.outstandingNotionalAmount = _outstandingNotionalAmount == null ? null : _outstandingNotionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseInNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseInNumberOfOptions")
		@Override
		public OptionExercise.OptionExerciseBuilder setExerciseInNumberOfOptions(BigDecimal _exerciseInNumberOfOptions) {
			this.exerciseInNumberOfOptions = _exerciseInNumberOfOptions == null ? null : _exerciseInNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("outstandingNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNumberOfOptions")
		@Override
		public OptionExercise.OptionExerciseBuilder setOutstandingNumberOfOptions(BigDecimal _outstandingNumberOfOptions) {
			this.outstandingNumberOfOptions = _outstandingNumberOfOptions == null ? null : _outstandingNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("exerciseInNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseInNumberOfUnits")
		@Override
		public OptionExercise.OptionExerciseBuilder setExerciseInNumberOfUnits(BigDecimal _exerciseInNumberOfUnits) {
			this.exerciseInNumberOfUnits = _exerciseInNumberOfUnits == null ? null : _exerciseInNumberOfUnits;
			return this;
		}
		
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		@Override
		public OptionExercise.OptionExerciseBuilder setOutstandingNumberOfUnits(BigDecimal _outstandingNumberOfUnits) {
			this.outstandingNumberOfUnits = _outstandingNumberOfUnits == null ? null : _outstandingNumberOfUnits;
			return this;
		}
		
		@RosettaAttribute("specifiedExercise")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("specifiedExercise")
		@Override
		public OptionExercise.OptionExerciseBuilder addSpecifiedExercise(OptionExerciseAmounts _specifiedExercise) {
			if (_specifiedExercise != null) {
				this.specifiedExercise.add(_specifiedExercise.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder addSpecifiedExercise(OptionExerciseAmounts _specifiedExercise, int idx) {
			getIndex(this.specifiedExercise, idx, () -> _specifiedExercise.toBuilder());
			return this;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder addSpecifiedExercise(List<? extends OptionExerciseAmounts> specifiedExercises) {
			if (specifiedExercises != null) {
				for (final OptionExerciseAmounts toAdd : specifiedExercises) {
					this.specifiedExercise.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("specifiedExercise")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("specifiedExercise")
		@Override
		public OptionExercise.OptionExerciseBuilder setSpecifiedExercise(List<? extends OptionExerciseAmounts> specifiedExercises) {
			if (specifiedExercises == null) {
				this.specifiedExercise = new ArrayList<>();
			} else {
				this.specifiedExercise = specifiedExercises.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("exerciseSide")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseSide")
		@Override
		public OptionExercise.OptionExerciseBuilder setExerciseSide(ExerciseSideEnum _exerciseSide) {
			this.exerciseSide = _exerciseSide == null ? null : _exerciseSide;
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public OptionExercise.OptionExerciseBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlement")
		@Override
		public OptionExercise.OptionExerciseBuilder setCashSettlement(SimplePayment _cashSettlement) {
			this.cashSettlement = _cashSettlement == null ? null : _cashSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalSettlement")
		@Override
		public OptionExercise.OptionExerciseBuilder setPhysicalSettlement(PhysicalSettlement _physicalSettlement) {
			this.physicalSettlement = _physicalSettlement == null ? null : _physicalSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payment")
		@Override
		public OptionExercise.OptionExerciseBuilder setPayment(NonNegativePayment _payment) {
			this.payment = _payment == null ? null : _payment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearingInstructions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingInstructions")
		@Override
		public OptionExercise.OptionExerciseBuilder setClearingInstructions(ClearingInstructions _clearingInstructions) {
			this.clearingInstructions = _clearingInstructions == null ? null : _clearingInstructions.toBuilder();
			return this;
		}
		
		@Override
		public OptionExercise build() {
			return new OptionExercise.OptionExerciseImpl(this);
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExercise.OptionExerciseBuilder prune() {
			super.prune();
			if (optionSeller!=null && !optionSeller.prune().hasData()) optionSeller = null;
			if (optionBuyer!=null && !optionBuyer.prune().hasData()) optionBuyer = null;
			if (originalTrade!=null && !originalTrade.prune().hasData()) originalTrade = null;
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (exerciseInNotionalAmount!=null && !exerciseInNotionalAmount.prune().hasData()) exerciseInNotionalAmount = null;
			if (outstandingNotionalAmount!=null && !outstandingNotionalAmount.prune().hasData()) outstandingNotionalAmount = null;
			specifiedExercise = specifiedExercise.stream().filter(b->b!=null).<OptionExerciseAmounts.OptionExerciseAmountsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (physicalSettlement!=null && !physicalSettlement.prune().hasData()) physicalSettlement = null;
			if (payment!=null && !payment.prune().hasData()) payment = null;
			if (clearingInstructions!=null && !clearingInstructions.prune().hasData()) clearingInstructions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOptionSeller()!=null && getOptionSeller().hasData()) return true;
			if (getOptionBuyer()!=null && getOptionBuyer().hasData()) return true;
			if (getOriginalTrade()!=null && getOriginalTrade().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExerciseDate()!=null) return true;
			if (getExerciseTime()!=null) return true;
			if (getExerciseTiming()!=null) return true;
			if (getExerciseAction()!=null) return true;
			if (getExpiry()!=null) return true;
			if (getFullExercise()!=null) return true;
			if (getExerciseInNotionalAmount()!=null && getExerciseInNotionalAmount().hasData()) return true;
			if (getOutstandingNotionalAmount()!=null && getOutstandingNotionalAmount().hasData()) return true;
			if (getExerciseInNumberOfOptions()!=null) return true;
			if (getOutstandingNumberOfOptions()!=null) return true;
			if (getExerciseInNumberOfUnits()!=null) return true;
			if (getOutstandingNumberOfUnits()!=null) return true;
			if (getSpecifiedExercise()!=null && getSpecifiedExercise().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExerciseSide()!=null) return true;
			if (getSettlementType()!=null) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getPhysicalSettlement()!=null && getPhysicalSettlement().hasData()) return true;
			if (getPayment()!=null && getPayment().hasData()) return true;
			if (getClearingInstructions()!=null && getClearingInstructions().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExercise.OptionExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			OptionExercise.OptionExerciseBuilder o = (OptionExercise.OptionExerciseBuilder) other;
			
			merger.mergeRosetta(getOptionSeller(), o.getOptionSeller(), this::setOptionSeller);
			merger.mergeRosetta(getOptionBuyer(), o.getOptionBuyer(), this::setOptionBuyer);
			merger.mergeRosetta(getOriginalTrade(), o.getOriginalTrade(), this::setOriginalTrade);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getExerciseInNotionalAmount(), o.getExerciseInNotionalAmount(), this::setExerciseInNotionalAmount);
			merger.mergeRosetta(getOutstandingNotionalAmount(), o.getOutstandingNotionalAmount(), this::setOutstandingNotionalAmount);
			merger.mergeRosetta(getSpecifiedExercise(), o.getSpecifiedExercise(), this::getOrCreateSpecifiedExercise);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getPhysicalSettlement(), o.getPhysicalSettlement(), this::setPhysicalSettlement);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			merger.mergeRosetta(getClearingInstructions(), o.getClearingInstructions(), this::setClearingInstructions);
			
			merger.mergeBasic(getExerciseDate(), o.getExerciseDate(), this::setExerciseDate);
			merger.mergeBasic(getExerciseTime(), o.getExerciseTime(), this::setExerciseTime);
			merger.mergeBasic(getExerciseTiming(), o.getExerciseTiming(), this::setExerciseTiming);
			merger.mergeBasic(getExerciseAction(), o.getExerciseAction(), this::setExerciseAction);
			merger.mergeBasic(getExpiry(), o.getExpiry(), this::setExpiry);
			merger.mergeBasic(getFullExercise(), o.getFullExercise(), this::setFullExercise);
			merger.mergeBasic(getExerciseInNumberOfOptions(), o.getExerciseInNumberOfOptions(), this::setExerciseInNumberOfOptions);
			merger.mergeBasic(getOutstandingNumberOfOptions(), o.getOutstandingNumberOfOptions(), this::setOutstandingNumberOfOptions);
			merger.mergeBasic(getExerciseInNumberOfUnits(), o.getExerciseInNumberOfUnits(), this::setExerciseInNumberOfUnits);
			merger.mergeBasic(getOutstandingNumberOfUnits(), o.getOutstandingNumberOfUnits(), this::setOutstandingNumberOfUnits);
			merger.mergeBasic(getExerciseSide(), o.getExerciseSide(), this::setExerciseSide);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionExercise _that = getType().cast(o);
		
			if (!Objects.equals(optionSeller, _that.getOptionSeller())) return false;
			if (!Objects.equals(optionBuyer, _that.getOptionBuyer())) return false;
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(exerciseDate, _that.getExerciseDate())) return false;
			if (!Objects.equals(exerciseTime, _that.getExerciseTime())) return false;
			if (!Objects.equals(exerciseTiming, _that.getExerciseTiming())) return false;
			if (!Objects.equals(exerciseAction, _that.getExerciseAction())) return false;
			if (!Objects.equals(expiry, _that.getExpiry())) return false;
			if (!Objects.equals(fullExercise, _that.getFullExercise())) return false;
			if (!Objects.equals(exerciseInNotionalAmount, _that.getExerciseInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			if (!Objects.equals(exerciseInNumberOfOptions, _that.getExerciseInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			if (!Objects.equals(exerciseInNumberOfUnits, _that.getExerciseInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			if (!ListEquals.listEquals(specifiedExercise, _that.getSpecifiedExercise())) return false;
			if (!Objects.equals(exerciseSide, _that.getExerciseSide())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			if (!Objects.equals(payment, _that.getPayment())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionSeller != null ? optionSeller.hashCode() : 0);
			_result = 31 * _result + (optionBuyer != null ? optionBuyer.hashCode() : 0);
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (exerciseDate != null ? exerciseDate.hashCode() : 0);
			_result = 31 * _result + (exerciseTime != null ? exerciseTime.hashCode() : 0);
			_result = 31 * _result + (exerciseTiming != null ? exerciseTiming.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exerciseAction != null ? exerciseAction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (expiry != null ? expiry.hashCode() : 0);
			_result = 31 * _result + (fullExercise != null ? fullExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseInNotionalAmount != null ? exerciseInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfOptions != null ? exerciseInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfUnits != null ? exerciseInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (specifiedExercise != null ? specifiedExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseSide != null ? exerciseSide.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseBuilder {" +
				"optionSeller=" + this.optionSeller + ", " +
				"optionBuyer=" + this.optionBuyer + ", " +
				"originalTrade=" + this.originalTrade + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"exerciseDate=" + this.exerciseDate + ", " +
				"exerciseTime=" + this.exerciseTime + ", " +
				"exerciseTiming=" + this.exerciseTiming + ", " +
				"exerciseAction=" + this.exerciseAction + ", " +
				"expiry=" + this.expiry + ", " +
				"fullExercise=" + this.fullExercise + ", " +
				"exerciseInNotionalAmount=" + this.exerciseInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount + ", " +
				"exerciseInNumberOfOptions=" + this.exerciseInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions + ", " +
				"exerciseInNumberOfUnits=" + this.exerciseInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits + ", " +
				"specifiedExercise=" + this.specifiedExercise + ", " +
				"exerciseSide=" + this.exerciseSide + ", " +
				"settlementType=" + this.settlementType + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"payment=" + this.payment + ", " +
				"clearingInstructions=" + this.clearingInstructions +
			'}' + " " + super.toString();
		}
	}
}

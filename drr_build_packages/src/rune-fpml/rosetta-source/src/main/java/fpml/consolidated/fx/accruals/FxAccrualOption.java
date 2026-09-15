package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.FxOptionPremium;
import fpml.consolidated.fx.accruals.meta.FxAccrualOptionMeta;
import fpml.consolidated.fx.targets.FxExpirySchedule;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import fpml.consolidated.option.shared.Option;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
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
 * version "recordkeeping-5.13"
 *
 * Provision An FX Accrual Option product The product defines a list of fixing (or observation) dates. There are m total fixings. At the expiry date of the product, the buyer of the option has the right to an FX settlement with n/m * Notional. Payout can be cash or physical.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An FX Accrual Option product The product defines a list of fixing (or observation) dates. There are m total fixings. At the expiry date of the product, the buyer of the option has the right to an FX settlement with n/m * Notional. Payout can be cash or physical.
 *
 */
@RosettaDataType(value="FxAccrualOption", builder=FxAccrualOption.FxAccrualOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualOption", model="fpml", builder=FxAccrualOption.FxAccrualOptionBuilderImpl.class, version="2.1.1")
public interface FxAccrualOption extends Option {

	FxAccrualOptionMeta metaData = new FxAccrualOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency which: - the option buyer will pay (sell) - the option writer will receive (buy)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency which: - the option buyer will pay (sell) - the option writer will receive (buy)
	 *
	 */
	Currency getPutCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency which: - the option buyer will receive (buy) - the option writer will pay (sell)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency which: - the option buyer will receive (buy) - the option writer will pay (sell)
	 *
	 */
	Currency getCallCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Notional amount Schedule. The notional value of the product. This number divided by the total number of fixings in the fixing schedule is the amount that is accrued at each fixing if the accrual factor is one.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Notional amount Schedule. The notional value of the product. This number divided by the total number of fixings in the fixing schedule is the amount that is accrued at each fixing if the accrual factor is one.
	 *
	 */
	NonNegativeAmountSchedule getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes accrual features within the product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes accrual features within the product.
	 *
	 */
	FxAccrual getAccrual();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the expiry of a single period accrual forward FX transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the expiry of a single period accrual forward FX transaction.
	 *
	 */
	FxExpiryDate getExpiryDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining a schedule of expiry periods for an accrual forward FX transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining a schedule of expiry periods for an accrual forward FX transaction.
	 *
	 */
	FxExpirySchedule getExpirySchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which settlement takes place for a settlement period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which settlement takes place for a settlement period.
	 *
	 */
	FxAdjustedDateAndDateAdjustments getSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining a schedule of settlement periods for a accrual forward FX transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining a schedule of settlement periods for a accrual forward FX transaction.
	 *
	 */
	FxSettlementSchedule getSettlementSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A set of parameters defining procedures associated with the exercise.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A set of parameters defining procedures associated with the exercise.
	 *
	 */
	ExerciseProcedure getExerciseProcedure();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional element used for FX forwards and certain types of FX OTC options. For deals consummated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the option needs to move "up" or "down" to be triggered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional element used for FX forwards and certain types of FX OTC options. For deals consummated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the option needs to move "up" or "down" to be triggered.
	 *
	 */
	BigDecimal getSpotRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the option strike price.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the option strike price.
	 *
	 */
	FxOptionStrikePrice getStrike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The opposite currency amount the amount which is not always deterministic.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The opposite currency amount the amount which is not always deterministic.
	 *
	 */
	NonNegativeAmountSchedule getCounterCurrencyAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Average Strike: means the average of the Reference Spot Rate on each Business Day from and including the Calculation Start Date up to and including the Calculation End Date rounded to the precision decimal places.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Average Strike: means the average of the Reference Spot Rate on each Business Day from and including the Calculation Start Date up to and including the Calculation End Date rounded to the precision decimal places.
	 *
	 */
	FxAverageStrike getAverageStrike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Average Rate: means the average of the Reference Spot Rate on each Business Day from and including the Calculation Start Date up to and including the Calculation End Date rounded to the precision decimal places.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Average Rate: means the average of the Reference Spot Rate on each Business Day from and including the Calculation Start Date up to and including the Calculation End Date rounded to the precision decimal places.
	 *
	 */
	FxAverageRate getAverageRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines a knockout barrier conditions where if a barrier event occurs, the accrual process is terminated for the duration of all remaining accrual periods. Settlement rights for the next settlement are either retained or extinguished.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines a knockout barrier conditions where if a barrier event occurs, the accrual process is terminated for the duration of all remaining accrual periods. Settlement rights for the next settlement are either retained or extinguished.
	 *
	 */
	List<? extends FxAccrualBarrier> getBarrier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Premium amount or premium installment amount for an option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Premium amount or premium installment amount for an option.
	 *
	 */
	List<? extends FxOptionPremium> getPremium();

	/*********************** Build Methods  ***********************/
	FxAccrualOption build();
	
	FxAccrualOption.FxAccrualOptionBuilder toBuilder();
	
	static FxAccrualOption.FxAccrualOptionBuilder builder() {
		return new FxAccrualOption.FxAccrualOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualOption> getType() {
		return FxAccrualOption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.class, getPrimaryAssetClass());
		processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.class, getSecondaryAssetClass());
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("productId"), processor, ProductId.class, getProductId());
		processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.class, getEmbeddedOptionType());
		processRosetta(path.newSubPath("assetClass"), processor, AssetClass.class, getAssetClass());
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.class, getBuyerAccountReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.class, getSellerAccountReference());
		processRosetta(path.newSubPath("putCurrency"), processor, Currency.class, getPutCurrency());
		processRosetta(path.newSubPath("callCurrency"), processor, Currency.class, getCallCurrency());
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("accrual"), processor, FxAccrual.class, getAccrual());
		processRosetta(path.newSubPath("expiryDate"), processor, FxExpiryDate.class, getExpiryDate());
		processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.class, getExpirySchedule());
		processRosetta(path.newSubPath("settlementDate"), processor, FxAdjustedDateAndDateAdjustments.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.class, getSettlementSchedule());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("strike"), processor, FxOptionStrikePrice.class, getStrike());
		processRosetta(path.newSubPath("counterCurrencyAmount"), processor, NonNegativeAmountSchedule.class, getCounterCurrencyAmount());
		processRosetta(path.newSubPath("averageStrike"), processor, FxAverageStrike.class, getAverageStrike());
		processRosetta(path.newSubPath("averageRate"), processor, FxAverageRate.class, getAverageRate());
		processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.class, getBarrier());
		processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.class, getPremium());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualOptionBuilder extends FxAccrualOption, Option.OptionBuilder {
		Currency.CurrencyBuilder getOrCreatePutCurrency();
		@Override
		Currency.CurrencyBuilder getPutCurrency();
		Currency.CurrencyBuilder getOrCreateCallCurrency();
		@Override
		Currency.CurrencyBuilder getCallCurrency();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount();
		FxAccrual.FxAccrualBuilder getOrCreateAccrual();
		@Override
		FxAccrual.FxAccrualBuilder getAccrual();
		FxExpiryDate.FxExpiryDateBuilder getOrCreateExpiryDate();
		@Override
		FxExpiryDate.FxExpiryDateBuilder getExpiryDate();
		FxExpirySchedule.FxExpiryScheduleBuilder getOrCreateExpirySchedule();
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder getExpirySchedule();
		FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder getOrCreateSettlementDate();
		@Override
		FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder getSettlementDate();
		FxSettlementSchedule.FxSettlementScheduleBuilder getOrCreateSettlementSchedule();
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder getSettlementSchedule();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		@Override
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		FxOptionStrikePrice.FxOptionStrikePriceBuilder getOrCreateStrike();
		@Override
		FxOptionStrikePrice.FxOptionStrikePriceBuilder getStrike();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateCounterCurrencyAmount();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getCounterCurrencyAmount();
		FxAverageStrike.FxAverageStrikeBuilder getOrCreateAverageStrike();
		@Override
		FxAverageStrike.FxAverageStrikeBuilder getAverageStrike();
		FxAverageRate.FxAverageRateBuilder getOrCreateAverageRate();
		@Override
		FxAverageRate.FxAverageRateBuilder getAverageRate();
		FxAccrualBarrier.FxAccrualBarrierBuilder getOrCreateBarrier(int index);
		@Override
		List<? extends FxAccrualBarrier.FxAccrualBarrierBuilder> getBarrier();
		FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int index);
		@Override
		List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium();
		@Override
		FxAccrualOption.FxAccrualOptionBuilder setId(String id);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addProductType(ProductType productType);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addProductType(ProductType productType, int idx);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addProductType(List<? extends ProductType> productType);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder setProductType(List<? extends ProductType> productType);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addProductId(ProductId productId);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addProductId(ProductId productId, int idx);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addProductId(List<? extends ProductId> productId);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder setProductId(List<? extends ProductId> productId);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addAssetClass(AssetClass assetClass);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		FxAccrualOption.FxAccrualOptionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		FxAccrualOption.FxAccrualOptionBuilder setPutCurrency(Currency putCurrency);
		FxAccrualOption.FxAccrualOptionBuilder setCallCurrency(Currency callCurrency);
		FxAccrualOption.FxAccrualOptionBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxAccrualOption.FxAccrualOptionBuilder setAccrual(FxAccrual accrual);
		FxAccrualOption.FxAccrualOptionBuilder setExpiryDate(FxExpiryDate expiryDate);
		FxAccrualOption.FxAccrualOptionBuilder setExpirySchedule(FxExpirySchedule expirySchedule);
		FxAccrualOption.FxAccrualOptionBuilder setSettlementDate(FxAdjustedDateAndDateAdjustments settlementDate);
		FxAccrualOption.FxAccrualOptionBuilder setSettlementSchedule(FxSettlementSchedule settlementSchedule);
		FxAccrualOption.FxAccrualOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		FxAccrualOption.FxAccrualOptionBuilder setSpotRate(BigDecimal spotRate);
		FxAccrualOption.FxAccrualOptionBuilder setStrike(FxOptionStrikePrice strike);
		FxAccrualOption.FxAccrualOptionBuilder setCounterCurrencyAmount(NonNegativeAmountSchedule counterCurrencyAmount);
		FxAccrualOption.FxAccrualOptionBuilder setAverageStrike(FxAverageStrike averageStrike);
		FxAccrualOption.FxAccrualOptionBuilder setAverageRate(FxAverageRate averageRate);
		FxAccrualOption.FxAccrualOptionBuilder addBarrier(FxAccrualBarrier barrier);
		FxAccrualOption.FxAccrualOptionBuilder addBarrier(FxAccrualBarrier barrier, int idx);
		FxAccrualOption.FxAccrualOptionBuilder addBarrier(List<? extends FxAccrualBarrier> barrier);
		FxAccrualOption.FxAccrualOptionBuilder setBarrier(List<? extends FxAccrualBarrier> barrier);
		FxAccrualOption.FxAccrualOptionBuilder addPremium(FxOptionPremium premium);
		FxAccrualOption.FxAccrualOptionBuilder addPremium(FxOptionPremium premium, int idx);
		FxAccrualOption.FxAccrualOptionBuilder addPremium(List<? extends FxOptionPremium> premium);
		FxAccrualOption.FxAccrualOptionBuilder setPremium(List<? extends FxOptionPremium> premium);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
			processRosetta(path.newSubPath("putCurrency"), processor, Currency.CurrencyBuilder.class, getPutCurrency());
			processRosetta(path.newSubPath("callCurrency"), processor, Currency.CurrencyBuilder.class, getCallCurrency());
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("accrual"), processor, FxAccrual.FxAccrualBuilder.class, getAccrual());
			processRosetta(path.newSubPath("expiryDate"), processor, FxExpiryDate.FxExpiryDateBuilder.class, getExpiryDate());
			processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.FxExpiryScheduleBuilder.class, getExpirySchedule());
			processRosetta(path.newSubPath("settlementDate"), processor, FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.FxSettlementScheduleBuilder.class, getSettlementSchedule());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("strike"), processor, FxOptionStrikePrice.FxOptionStrikePriceBuilder.class, getStrike());
			processRosetta(path.newSubPath("counterCurrencyAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getCounterCurrencyAmount());
			processRosetta(path.newSubPath("averageStrike"), processor, FxAverageStrike.FxAverageStrikeBuilder.class, getAverageStrike());
			processRosetta(path.newSubPath("averageRate"), processor, FxAverageRate.FxAverageRateBuilder.class, getAverageRate());
			processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.FxAccrualBarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.FxOptionPremiumBuilder.class, getPremium());
		}
		

		FxAccrualOption.FxAccrualOptionBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualOption  ***********************/
	class FxAccrualOptionImpl extends Option.OptionImpl implements FxAccrualOption {
		private final Currency putCurrency;
		private final Currency callCurrency;
		private final NonNegativeAmountSchedule notionalAmount;
		private final FxAccrual accrual;
		private final FxExpiryDate expiryDate;
		private final FxExpirySchedule expirySchedule;
		private final FxAdjustedDateAndDateAdjustments settlementDate;
		private final FxSettlementSchedule settlementSchedule;
		private final ExerciseProcedure exerciseProcedure;
		private final BigDecimal spotRate;
		private final FxOptionStrikePrice strike;
		private final NonNegativeAmountSchedule counterCurrencyAmount;
		private final FxAverageStrike averageStrike;
		private final FxAverageRate averageRate;
		private final List<? extends FxAccrualBarrier> barrier;
		private final List<? extends FxOptionPremium> premium;
		
		protected FxAccrualOptionImpl(FxAccrualOption.FxAccrualOptionBuilder builder) {
			super(builder);
			this.putCurrency = ofNullable(builder.getPutCurrency()).map(f->f.build()).orElse(null);
			this.callCurrency = ofNullable(builder.getCallCurrency()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.accrual = ofNullable(builder.getAccrual()).map(f->f.build()).orElse(null);
			this.expiryDate = ofNullable(builder.getExpiryDate()).map(f->f.build()).orElse(null);
			this.expirySchedule = ofNullable(builder.getExpirySchedule()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.settlementSchedule = ofNullable(builder.getSettlementSchedule()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.spotRate = builder.getSpotRate();
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.counterCurrencyAmount = ofNullable(builder.getCounterCurrencyAmount()).map(f->f.build()).orElse(null);
			this.averageStrike = ofNullable(builder.getAverageStrike()).map(f->f.build()).orElse(null);
			this.averageRate = ofNullable(builder.getAverageRate()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("putCurrency")
		public Currency getPutCurrency() {
			return putCurrency;
		}
		
		@Override
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("callCurrency")
		public Currency getCallCurrency() {
			return callCurrency;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notionalAmount")
		public NonNegativeAmountSchedule getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("accrual")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accrual")
		public FxAccrual getAccrual() {
			return accrual;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryDate")
		public FxExpiryDate getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("expirySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirySchedule")
		public FxExpirySchedule getExpirySchedule() {
			return expirySchedule;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public FxAdjustedDateAndDateAdjustments getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementSchedule")
		public FxSettlementSchedule getSettlementSchedule() {
			return settlementSchedule;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseProcedure")
		public ExerciseProcedure getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public FxOptionStrikePrice getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterCurrencyAmount")
		public NonNegativeAmountSchedule getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		@RosettaAttribute("averageStrike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageStrike")
		public FxAverageStrike getAverageStrike() {
			return averageStrike;
		}
		
		@Override
		@RosettaAttribute("averageRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageRate")
		public FxAverageRate getAverageRate() {
			return averageRate;
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("barrier")
		public List<? extends FxAccrualBarrier> getBarrier() {
			return barrier;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("premium")
		public List<? extends FxOptionPremium> getPremium() {
			return premium;
		}
		
		@Override
		public FxAccrualOption build() {
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder toBuilder() {
			FxAccrualOption.FxAccrualOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualOption.FxAccrualOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPutCurrency()).ifPresent(builder::setPutCurrency);
			ofNullable(getCallCurrency()).ifPresent(builder::setCallCurrency);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getAccrual()).ifPresent(builder::setAccrual);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getExpirySchedule()).ifPresent(builder::setExpirySchedule);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getSettlementSchedule()).ifPresent(builder::setSettlementSchedule);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
			ofNullable(getAverageStrike()).ifPresent(builder::setAverageStrike);
			ofNullable(getAverageRate()).ifPresent(builder::setAverageRate);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualOption _that = getType().cast(o);
		
			if (!Objects.equals(putCurrency, _that.getPutCurrency())) return false;
			if (!Objects.equals(callCurrency, _that.getCallCurrency())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			if (!Objects.equals(averageStrike, _that.getAverageStrike())) return false;
			if (!Objects.equals(averageRate, _that.getAverageRate())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (putCurrency != null ? putCurrency.hashCode() : 0);
			_result = 31 * _result + (callCurrency != null ? callCurrency.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expirySchedule != null ? expirySchedule.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementSchedule != null ? settlementSchedule.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (averageStrike != null ? averageStrike.hashCode() : 0);
			_result = 31 * _result + (averageRate != null ? averageRate.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualOption {" +
				"putCurrency=" + this.putCurrency + ", " +
				"callCurrency=" + this.callCurrency + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"expirySchedule=" + this.expirySchedule + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementSchedule=" + this.settlementSchedule + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"spotRate=" + this.spotRate + ", " +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount + ", " +
				"averageStrike=" + this.averageStrike + ", " +
				"averageRate=" + this.averageRate + ", " +
				"barrier=" + this.barrier + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualOption  ***********************/
	class FxAccrualOptionBuilderImpl extends Option.OptionBuilderImpl implements FxAccrualOption.FxAccrualOptionBuilder {
	
		protected Currency.CurrencyBuilder putCurrency;
		protected Currency.CurrencyBuilder callCurrency;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected FxAccrual.FxAccrualBuilder accrual;
		protected FxExpiryDate.FxExpiryDateBuilder expiryDate;
		protected FxExpirySchedule.FxExpiryScheduleBuilder expirySchedule;
		protected FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder settlementDate;
		protected FxSettlementSchedule.FxSettlementScheduleBuilder settlementSchedule;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected BigDecimal spotRate;
		protected FxOptionStrikePrice.FxOptionStrikePriceBuilder strike;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder counterCurrencyAmount;
		protected FxAverageStrike.FxAverageStrikeBuilder averageStrike;
		protected FxAverageRate.FxAverageRateBuilder averageRate;
		protected List<FxAccrualBarrier.FxAccrualBarrierBuilder> barrier = new ArrayList<>();
		protected List<FxOptionPremium.FxOptionPremiumBuilder> premium = new ArrayList<>();
		
		@Override
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("putCurrency")
		public Currency.CurrencyBuilder getPutCurrency() {
			return putCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreatePutCurrency() {
			Currency.CurrencyBuilder result;
			if (putCurrency!=null) {
				result = putCurrency;
			}
			else {
				result = putCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("callCurrency")
		public Currency.CurrencyBuilder getCallCurrency() {
			return callCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCallCurrency() {
			Currency.CurrencyBuilder result;
			if (callCurrency!=null) {
				result = callCurrency;
			}
			else {
				result = callCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notionalAmount")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrual")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accrual")
		public FxAccrual.FxAccrualBuilder getAccrual() {
			return accrual;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder getOrCreateAccrual() {
			FxAccrual.FxAccrualBuilder result;
			if (accrual!=null) {
				result = accrual;
			}
			else {
				result = accrual = FxAccrual.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryDate")
		public FxExpiryDate.FxExpiryDateBuilder getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		public FxExpiryDate.FxExpiryDateBuilder getOrCreateExpiryDate() {
			FxExpiryDate.FxExpiryDateBuilder result;
			if (expiryDate!=null) {
				result = expiryDate;
			}
			else {
				result = expiryDate = FxExpiryDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirySchedule")
		public FxExpirySchedule.FxExpiryScheduleBuilder getExpirySchedule() {
			return expirySchedule;
		}
		
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder getOrCreateExpirySchedule() {
			FxExpirySchedule.FxExpiryScheduleBuilder result;
			if (expirySchedule!=null) {
				result = expirySchedule;
			}
			else {
				result = expirySchedule = FxExpirySchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder getOrCreateSettlementDate() {
			FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = FxAdjustedDateAndDateAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementSchedule")
		public FxSettlementSchedule.FxSettlementScheduleBuilder getSettlementSchedule() {
			return settlementSchedule;
		}
		
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder getOrCreateSettlementSchedule() {
			FxSettlementSchedule.FxSettlementScheduleBuilder result;
			if (settlementSchedule!=null) {
				result = settlementSchedule;
			}
			else {
				result = settlementSchedule = FxSettlementSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseProcedure")
		public ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure() {
			ExerciseProcedure.ExerciseProcedureBuilder result;
			if (exerciseProcedure!=null) {
				result = exerciseProcedure;
			}
			else {
				result = exerciseProcedure = ExerciseProcedure.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder getStrike() {
			return strike;
		}
		
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder getOrCreateStrike() {
			FxOptionStrikePrice.FxOptionStrikePriceBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = FxOptionStrikePrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterCurrencyAmount")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateCounterCurrencyAmount() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (counterCurrencyAmount!=null) {
				result = counterCurrencyAmount;
			}
			else {
				result = counterCurrencyAmount = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averageStrike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageStrike")
		public FxAverageStrike.FxAverageStrikeBuilder getAverageStrike() {
			return averageStrike;
		}
		
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder getOrCreateAverageStrike() {
			FxAverageStrike.FxAverageStrikeBuilder result;
			if (averageStrike!=null) {
				result = averageStrike;
			}
			else {
				result = averageStrike = FxAverageStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averageRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageRate")
		public FxAverageRate.FxAverageRateBuilder getAverageRate() {
			return averageRate;
		}
		
		@Override
		public FxAverageRate.FxAverageRateBuilder getOrCreateAverageRate() {
			FxAverageRate.FxAverageRateBuilder result;
			if (averageRate!=null) {
				result = averageRate;
			}
			else {
				result = averageRate = FxAverageRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("barrier")
		public List<? extends FxAccrualBarrier.FxAccrualBarrierBuilder> getBarrier() {
			return barrier;
		}
		
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder getOrCreateBarrier(int index) {
			if (barrier==null) {
				this.barrier = new ArrayList<>();
			}
			return getIndex(barrier, index, () -> {
						FxAccrualBarrier.FxAccrualBarrierBuilder newBarrier = FxAccrualBarrier.builder();
						return newBarrier;
					});
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("premium")
		public List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium() {
			return premium;
		}
		
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int index) {
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			return getIndex(premium, index, () -> {
						FxOptionPremium.FxOptionPremiumBuilder newPremium = FxOptionPremium.builder();
						return newPremium;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss != null) {
				for (final AssetClass toAdd : secondaryAssetClasss) {
					this.secondaryAssetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss == null) {
				this.secondaryAssetClass = new ArrayList<>();
			} else {
				this.secondaryAssetClass = secondaryAssetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addProductType(List<? extends ProductType> productTypes) {
			if (productTypes != null) {
				for (final ProductType toAdd : productTypes) {
					this.productType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setProductType(List<? extends ProductType> productTypes) {
			if (productTypes == null) {
				this.productType = new ArrayList<>();
			} else {
				this.productType = productTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addProductId(List<? extends ProductId> productIds) {
			if (productIds != null) {
				for (final ProductId toAdd : productIds) {
					this.productId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setProductId(List<? extends ProductId> productIds) {
			if (productIds == null) {
				this.productId = new ArrayList<>();
			} else {
				this.productId = productIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes != null) {
				for (final EmbeddedOptionType toAdd : embeddedOptionTypes) {
					this.embeddedOptionType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes == null) {
				this.embeddedOptionType = new ArrayList<>();
			} else {
				this.embeddedOptionType = embeddedOptionTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss != null) {
				for (final AssetClass toAdd : assetClasss) {
					this.assetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("putCurrency")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setPutCurrency(Currency _putCurrency) {
			this.putCurrency = _putCurrency == null ? null : _putCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("callCurrency")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setCallCurrency(Currency _callCurrency) {
			this.callCurrency = _callCurrency == null ? null : _callCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notionalAmount")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setNotionalAmount(NonNegativeAmountSchedule _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrual")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrual")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setAccrual(FxAccrual _accrual) {
			this.accrual = _accrual == null ? null : _accrual.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryDate")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setExpiryDate(FxExpiryDate _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirySchedule")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setExpirySchedule(FxExpirySchedule _expirySchedule) {
			this.expirySchedule = _expirySchedule == null ? null : _expirySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setSettlementDate(FxAdjustedDateAndDateAdjustments _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementSchedule")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setSettlementSchedule(FxSettlementSchedule _settlementSchedule) {
			this.settlementSchedule = _settlementSchedule == null ? null : _settlementSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseProcedure")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setExerciseProcedure(ExerciseProcedure _exerciseProcedure) {
			this.exerciseProcedure = _exerciseProcedure == null ? null : _exerciseProcedure.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotRate")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setSpotRate(BigDecimal _spotRate) {
			this.spotRate = _spotRate == null ? null : _spotRate;
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strike")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setStrike(FxOptionStrikePrice _strike) {
			this.strike = _strike == null ? null : _strike.toBuilder();
			return this;
		}
		
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterCurrencyAmount")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setCounterCurrencyAmount(NonNegativeAmountSchedule _counterCurrencyAmount) {
			this.counterCurrencyAmount = _counterCurrencyAmount == null ? null : _counterCurrencyAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averageStrike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averageStrike")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setAverageStrike(FxAverageStrike _averageStrike) {
			this.averageStrike = _averageStrike == null ? null : _averageStrike.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averageRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averageRate")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setAverageRate(FxAverageRate _averageRate) {
			this.averageRate = _averageRate == null ? null : _averageRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("barrier")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addBarrier(FxAccrualBarrier _barrier) {
			if (_barrier != null) {
				this.barrier.add(_barrier.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addBarrier(FxAccrualBarrier _barrier, int idx) {
			getIndex(this.barrier, idx, () -> _barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addBarrier(List<? extends FxAccrualBarrier> barriers) {
			if (barriers != null) {
				for (final FxAccrualBarrier toAdd : barriers) {
					this.barrier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("barrier")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setBarrier(List<? extends FxAccrualBarrier> barriers) {
			if (barriers == null) {
				this.barrier = new ArrayList<>();
			} else {
				this.barrier = barriers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addPremium(FxOptionPremium _premium) {
			if (_premium != null) {
				this.premium.add(_premium.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addPremium(FxOptionPremium _premium, int idx) {
			getIndex(this.premium, idx, () -> _premium.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder addPremium(List<? extends FxOptionPremium> premiums) {
			if (premiums != null) {
				for (final FxOptionPremium toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder setPremium(List<? extends FxOptionPremium> premiums) {
			if (premiums == null) {
				this.premium = new ArrayList<>();
			} else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxAccrualOption build() {
			return new FxAccrualOption.FxAccrualOptionImpl(this);
		}
		
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder prune() {
			super.prune();
			if (putCurrency!=null && !putCurrency.prune().hasData()) putCurrency = null;
			if (callCurrency!=null && !callCurrency.prune().hasData()) callCurrency = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (accrual!=null && !accrual.prune().hasData()) accrual = null;
			if (expiryDate!=null && !expiryDate.prune().hasData()) expiryDate = null;
			if (expirySchedule!=null && !expirySchedule.prune().hasData()) expirySchedule = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (settlementSchedule!=null && !settlementSchedule.prune().hasData()) settlementSchedule = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (counterCurrencyAmount!=null && !counterCurrencyAmount.prune().hasData()) counterCurrencyAmount = null;
			if (averageStrike!=null && !averageStrike.prune().hasData()) averageStrike = null;
			if (averageRate!=null && !averageRate.prune().hasData()) averageRate = null;
			barrier = barrier.stream().filter(b->b!=null).<FxAccrualBarrier.FxAccrualBarrierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			premium = premium.stream().filter(b->b!=null).<FxOptionPremium.FxOptionPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPutCurrency()!=null && getPutCurrency().hasData()) return true;
			if (getCallCurrency()!=null && getCallCurrency().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getAccrual()!=null && getAccrual().hasData()) return true;
			if (getExpiryDate()!=null && getExpiryDate().hasData()) return true;
			if (getExpirySchedule()!=null && getExpirySchedule().hasData()) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getSettlementSchedule()!=null && getSettlementSchedule().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getSpotRate()!=null) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getCounterCurrencyAmount()!=null && getCounterCurrencyAmount().hasData()) return true;
			if (getAverageStrike()!=null && getAverageStrike().hasData()) return true;
			if (getAverageRate()!=null && getAverageRate().hasData()) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualOption.FxAccrualOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxAccrualOption.FxAccrualOptionBuilder o = (FxAccrualOption.FxAccrualOptionBuilder) other;
			
			merger.mergeRosetta(getPutCurrency(), o.getPutCurrency(), this::setPutCurrency);
			merger.mergeRosetta(getCallCurrency(), o.getCallCurrency(), this::setCallCurrency);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getAccrual(), o.getAccrual(), this::setAccrual);
			merger.mergeRosetta(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeRosetta(getExpirySchedule(), o.getExpirySchedule(), this::setExpirySchedule);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getSettlementSchedule(), o.getSettlementSchedule(), this::setSettlementSchedule);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::setCounterCurrencyAmount);
			merger.mergeRosetta(getAverageStrike(), o.getAverageStrike(), this::setAverageStrike);
			merger.mergeRosetta(getAverageRate(), o.getAverageRate(), this::setAverageRate);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::getOrCreateBarrier);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualOption _that = getType().cast(o);
		
			if (!Objects.equals(putCurrency, _that.getPutCurrency())) return false;
			if (!Objects.equals(callCurrency, _that.getCallCurrency())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			if (!Objects.equals(averageStrike, _that.getAverageStrike())) return false;
			if (!Objects.equals(averageRate, _that.getAverageRate())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (putCurrency != null ? putCurrency.hashCode() : 0);
			_result = 31 * _result + (callCurrency != null ? callCurrency.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expirySchedule != null ? expirySchedule.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementSchedule != null ? settlementSchedule.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (averageStrike != null ? averageStrike.hashCode() : 0);
			_result = 31 * _result + (averageRate != null ? averageRate.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualOptionBuilder {" +
				"putCurrency=" + this.putCurrency + ", " +
				"callCurrency=" + this.callCurrency + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"expirySchedule=" + this.expirySchedule + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementSchedule=" + this.settlementSchedule + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"spotRate=" + this.spotRate + ", " +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount + ", " +
				"averageStrike=" + this.averageStrike + ", " +
				"averageRate=" + this.averageRate + ", " +
				"barrier=" + this.barrier + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}
}

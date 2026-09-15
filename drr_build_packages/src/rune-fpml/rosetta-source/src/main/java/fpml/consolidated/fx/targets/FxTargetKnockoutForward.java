package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fx.targets.meta.FxTargetKnockoutForwardMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.FxInformationSource;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.QuotedCurrencyPair;
import fpml.consolidated.shared.SimplePayment;
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
 * Provision A structured forward product which consists of a strip of forwards. Each forward may be settled as an exchange of currencies or cash settled. At each settlement, the amount of gain that one party achieves is measured. The product has a target level of gain. Once the accumulated gain exceeds the target level, the product terminates and there are no further settlements.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structured forward product which consists of a strip of forwards. Each forward may be settled as an exchange of currencies or cash settled. At each settlement, the amount of gain that one party achieves is measured. The product has a target level of gain. Once the accumulated gain exceeds the target level, the product terminates and there are no further settlements.
 *
 */
@RosettaDataType(value="FxTargetKnockoutForward", builder=FxTargetKnockoutForward.FxTargetKnockoutForwardBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTargetKnockoutForward", model="fpml", builder=FxTargetKnockoutForward.FxTargetKnockoutForwardBuilderImpl.class, version="2.1.1")
public interface FxTargetKnockoutForward extends Product {

	FxTargetKnockoutForwardMeta metaData = new FxTargetKnockoutForwardMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Quoted Currency Pair that is used accross the product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Quoted Currency Pair that is used accross the product.
	 *
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Notional amount of the Target.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Notional amount of the Target.
	 *
	 */
	NonNegativeAmountSchedule getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision It defines the target level of gain. Once the accumulated gain exceeds the target level, the product terminates and there are no further settlements.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision It defines the target level of gain. Once the accumulated gain exceeds the target level, the product terminates and there are no further settlements.
	 *
	 */
	List<? extends FxTarget> getTarget();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the expiry/observation schedule of the target product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the expiry/observation schedule of the target product.
	 *
	 */
	FxExpirySchedule getExpirySchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the settlement/payment schedule of the target product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the settlement/payment schedule of the target product.
	 *
	 */
	FxSettlementSchedule getSettlementSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Information source for fixing the exchange rate. It is the same for all fixing periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Information source for fixing the exchange rate. It is the same for all fixing periods.
	 *
	 */
	FxInformationSource getFixingInformationSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Spot rate
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Spot rate
	 *
	 */
	BigDecimal getSpotRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The boundary where the contract flips from being long and short is the pivot point. So the pivot indicates the level in which there is a change in direction of the currencies exchanged by the parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The boundary where the contract flips from being long and short is the pivot point. So the pivot indicates the level in which there is a change in direction of the currencies exchanged by the parties.
	 *
	 */
	FxPivot getPivot();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A region in which constant payoff applies i.e. the payoff is defined as a contant currency amount or fixing adjustment, unrelated to the fixing. In absence of the "payoff" element, zero payoff is assumed (note: zero payoff does not necessarily imply that no settlement occurs).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A region in which constant payoff applies i.e. the payoff is defined as a contant currency amount or fixing adjustment, unrelated to the fixing. In absence of the "payoff" element, zero payoff is assumed (note: zero payoff does not necessarily imply that no settlement occurs).
	 *
	 */
	List<? extends FxTargetConstantPayoffRegion> getConstantPayoffRegion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A region in which linear payoff applies i.e. the payoff bears a linear relationship to the fixing value (increases/decreases linearly with the fixing).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A region in which linear payoff applies i.e. the payoff bears a linear relationship to the fixing value (increases/decreases linearly with the fixing).
	 *
	 */
	FxTargetLinearPayoffRegion getLinearPayoffRegion();
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
	List<? extends FxTargetKnockoutForwardChoice> getFxTargetKnockoutForwardChoice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Generic FxTarget barrier. Element "scope" specifies whether the barrier has effect for the expiry period in which it is observed, or globally for whole product. Optional element "rebate" may be produced in conjunction with a Global Knockout barrier, to specify a rebate payable in the event of knockout.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Generic FxTarget barrier. Element "scope" specifies whether the barrier has effect for the expiry period in which it is observed, or globally for whole product. Optional element "rebate" may be produced in conjunction with a Global Knockout barrier, to specify a rebate payable in the event of knockout.
	 *
	 */
	List<? extends FxTargetBarrier> getBarrier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision It supports the representation of premiums, fees, etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision It supports the representation of premiums, fees, etc.
	 *
	 */
	List<? extends SimplePayment> getAdditionalPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Cash settlement currency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Cash settlement currency.
	 *
	 */
	FxCashSettlementSimple getCashSettlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision It supports the representation of a matrix/tabular approach of the product by defining a set of settlement periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision It supports the representation of a matrix/tabular approach of the product by defining a set of settlement periods.
	 *
	 */
	FxTargetSettlementPeriodSchedule getSettlementPeriodSchedule();

	/*********************** Build Methods  ***********************/
	FxTargetKnockoutForward build();
	
	FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder toBuilder();
	
	static FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder builder() {
		return new FxTargetKnockoutForward.FxTargetKnockoutForwardBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetKnockoutForward> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTargetKnockoutForward> getType() {
		return FxTargetKnockoutForward.class;
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
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("target"), processor, FxTarget.class, getTarget());
		processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.class, getExpirySchedule());
		processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.class, getSettlementSchedule());
		processRosetta(path.newSubPath("fixingInformationSource"), processor, FxInformationSource.class, getFixingInformationSource());
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("pivot"), processor, FxPivot.class, getPivot());
		processRosetta(path.newSubPath("constantPayoffRegion"), processor, FxTargetConstantPayoffRegion.class, getConstantPayoffRegion());
		processRosetta(path.newSubPath("linearPayoffRegion"), processor, FxTargetLinearPayoffRegion.class, getLinearPayoffRegion());
		processRosetta(path.newSubPath("fxTargetKnockoutForwardChoice"), processor, FxTargetKnockoutForwardChoice.class, getFxTargetKnockoutForwardChoice());
		processRosetta(path.newSubPath("barrier"), processor, FxTargetBarrier.class, getBarrier());
		processRosetta(path.newSubPath("additionalPayment"), processor, SimplePayment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.class, getCashSettlement());
		processRosetta(path.newSubPath("settlementPeriodSchedule"), processor, FxTargetSettlementPeriodSchedule.class, getSettlementPeriodSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetKnockoutForwardBuilder extends FxTargetKnockoutForward, Product.ProductBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount();
		FxTarget.FxTargetBuilder getOrCreateTarget(int index);
		@Override
		List<? extends FxTarget.FxTargetBuilder> getTarget();
		FxExpirySchedule.FxExpiryScheduleBuilder getOrCreateExpirySchedule();
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder getExpirySchedule();
		FxSettlementSchedule.FxSettlementScheduleBuilder getOrCreateSettlementSchedule();
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder getSettlementSchedule();
		FxInformationSource.FxInformationSourceBuilder getOrCreateFixingInformationSource();
		@Override
		FxInformationSource.FxInformationSourceBuilder getFixingInformationSource();
		FxPivot.FxPivotBuilder getOrCreatePivot();
		@Override
		FxPivot.FxPivotBuilder getPivot();
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder getOrCreateConstantPayoffRegion(int index);
		@Override
		List<? extends FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder> getConstantPayoffRegion();
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getOrCreateLinearPayoffRegion();
		@Override
		FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getLinearPayoffRegion();
		FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder getOrCreateFxTargetKnockoutForwardChoice(int index);
		@Override
		List<? extends FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder> getFxTargetKnockoutForwardChoice();
		FxTargetBarrier.FxTargetBarrierBuilder getOrCreateBarrier(int index);
		@Override
		List<? extends FxTargetBarrier.FxTargetBarrierBuilder> getBarrier();
		SimplePayment.SimplePaymentBuilder getOrCreateAdditionalPayment(int index);
		@Override
		List<? extends SimplePayment.SimplePaymentBuilder> getAdditionalPayment();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement();
		@Override
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement();
		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder getOrCreateSettlementPeriodSchedule();
		@Override
		FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder getSettlementPeriodSchedule();
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setId(String id);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addProductType(ProductType productType);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addProductType(ProductType productType, int idx);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addProductType(List<? extends ProductType> productType);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setProductType(List<? extends ProductType> productType);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addProductId(ProductId productId);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addProductId(ProductId productId, int idx);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addProductId(List<? extends ProductId> productId);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setProductId(List<? extends ProductId> productId);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAssetClass(AssetClass assetClass);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setAssetClass(List<? extends AssetClass> assetClass);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addTarget(FxTarget target);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addTarget(FxTarget target, int idx);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addTarget(List<? extends FxTarget> target);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setTarget(List<? extends FxTarget> target);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setExpirySchedule(FxExpirySchedule expirySchedule);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSettlementSchedule(FxSettlementSchedule settlementSchedule);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setFixingInformationSource(FxInformationSource fixingInformationSource);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSpotRate(BigDecimal spotRate);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setPivot(FxPivot pivot);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addConstantPayoffRegion(FxTargetConstantPayoffRegion constantPayoffRegion);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addConstantPayoffRegion(FxTargetConstantPayoffRegion constantPayoffRegion, int idx);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addConstantPayoffRegion(List<? extends FxTargetConstantPayoffRegion> constantPayoffRegion);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setConstantPayoffRegion(List<? extends FxTargetConstantPayoffRegion> constantPayoffRegion);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setLinearPayoffRegion(FxTargetLinearPayoffRegion linearPayoffRegion);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addFxTargetKnockoutForwardChoice(FxTargetKnockoutForwardChoice fxTargetKnockoutForwardChoice);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addFxTargetKnockoutForwardChoice(FxTargetKnockoutForwardChoice fxTargetKnockoutForwardChoice, int idx);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addFxTargetKnockoutForwardChoice(List<? extends FxTargetKnockoutForwardChoice> fxTargetKnockoutForwardChoice);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setFxTargetKnockoutForwardChoice(List<? extends FxTargetKnockoutForwardChoice> fxTargetKnockoutForwardChoice);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addBarrier(FxTargetBarrier barrier);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addBarrier(FxTargetBarrier barrier, int idx);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addBarrier(List<? extends FxTargetBarrier> barrier);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setBarrier(List<? extends FxTargetBarrier> barrier);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAdditionalPayment(SimplePayment additionalPayment);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAdditionalPayment(SimplePayment additionalPayment, int idx);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAdditionalPayment(List<? extends SimplePayment> additionalPayment);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setAdditionalPayment(List<? extends SimplePayment> additionalPayment);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setCashSettlement(FxCashSettlementSimple cashSettlement);
		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSettlementPeriodSchedule(FxTargetSettlementPeriodSchedule settlementPeriodSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("target"), processor, FxTarget.FxTargetBuilder.class, getTarget());
			processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.FxExpiryScheduleBuilder.class, getExpirySchedule());
			processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.FxSettlementScheduleBuilder.class, getSettlementSchedule());
			processRosetta(path.newSubPath("fixingInformationSource"), processor, FxInformationSource.FxInformationSourceBuilder.class, getFixingInformationSource());
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("pivot"), processor, FxPivot.FxPivotBuilder.class, getPivot());
			processRosetta(path.newSubPath("constantPayoffRegion"), processor, FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder.class, getConstantPayoffRegion());
			processRosetta(path.newSubPath("linearPayoffRegion"), processor, FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder.class, getLinearPayoffRegion());
			processRosetta(path.newSubPath("fxTargetKnockoutForwardChoice"), processor, FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder.class, getFxTargetKnockoutForwardChoice());
			processRosetta(path.newSubPath("barrier"), processor, FxTargetBarrier.FxTargetBarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("additionalPayment"), processor, SimplePayment.SimplePaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.FxCashSettlementSimpleBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("settlementPeriodSchedule"), processor, FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder.class, getSettlementPeriodSchedule());
		}
		

		FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetKnockoutForward  ***********************/
	class FxTargetKnockoutForwardImpl extends Product.ProductImpl implements FxTargetKnockoutForward {
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final NonNegativeAmountSchedule notionalAmount;
		private final List<? extends FxTarget> target;
		private final FxExpirySchedule expirySchedule;
		private final FxSettlementSchedule settlementSchedule;
		private final FxInformationSource fixingInformationSource;
		private final BigDecimal spotRate;
		private final FxPivot pivot;
		private final List<? extends FxTargetConstantPayoffRegion> constantPayoffRegion;
		private final FxTargetLinearPayoffRegion linearPayoffRegion;
		private final List<? extends FxTargetKnockoutForwardChoice> fxTargetKnockoutForwardChoice;
		private final List<? extends FxTargetBarrier> barrier;
		private final List<? extends SimplePayment> additionalPayment;
		private final FxCashSettlementSimple cashSettlement;
		private final FxTargetSettlementPeriodSchedule settlementPeriodSchedule;
		
		protected FxTargetKnockoutForwardImpl(FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder builder) {
			super(builder);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.target = ofNullable(builder.getTarget()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.expirySchedule = ofNullable(builder.getExpirySchedule()).map(f->f.build()).orElse(null);
			this.settlementSchedule = ofNullable(builder.getSettlementSchedule()).map(f->f.build()).orElse(null);
			this.fixingInformationSource = ofNullable(builder.getFixingInformationSource()).map(f->f.build()).orElse(null);
			this.spotRate = builder.getSpotRate();
			this.pivot = ofNullable(builder.getPivot()).map(f->f.build()).orElse(null);
			this.constantPayoffRegion = ofNullable(builder.getConstantPayoffRegion()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.linearPayoffRegion = ofNullable(builder.getLinearPayoffRegion()).map(f->f.build()).orElse(null);
			this.fxTargetKnockoutForwardChoice = ofNullable(builder.getFxTargetKnockoutForwardChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.settlementPeriodSchedule = ofNullable(builder.getSettlementPeriodSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
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
		@RosettaAttribute("target")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("target")
		public List<? extends FxTarget> getTarget() {
			return target;
		}
		
		@Override
		@RosettaAttribute("expirySchedule")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expirySchedule")
		public FxExpirySchedule getExpirySchedule() {
			return expirySchedule;
		}
		
		@Override
		@RosettaAttribute("settlementSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementSchedule")
		public FxSettlementSchedule getSettlementSchedule() {
			return settlementSchedule;
		}
		
		@Override
		@RosettaAttribute("fixingInformationSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingInformationSource")
		public FxInformationSource getFixingInformationSource() {
			return fixingInformationSource;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("pivot")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pivot")
		public FxPivot getPivot() {
			return pivot;
		}
		
		@Override
		@RosettaAttribute("constantPayoffRegion")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("constantPayoffRegion")
		public List<? extends FxTargetConstantPayoffRegion> getConstantPayoffRegion() {
			return constantPayoffRegion;
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("linearPayoffRegion")
		public FxTargetLinearPayoffRegion getLinearPayoffRegion() {
			return linearPayoffRegion;
		}
		
		@Override
		@RosettaAttribute("fxTargetKnockoutForwardChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fxTargetKnockoutForwardChoice")
		public List<? extends FxTargetKnockoutForwardChoice> getFxTargetKnockoutForwardChoice() {
			return fxTargetKnockoutForwardChoice;
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("barrier")
		public List<? extends FxTargetBarrier> getBarrier() {
			return barrier;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends SimplePayment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public FxCashSettlementSimple getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPeriodSchedule")
		public FxTargetSettlementPeriodSchedule getSettlementPeriodSchedule() {
			return settlementPeriodSchedule;
		}
		
		@Override
		public FxTargetKnockoutForward build() {
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder toBuilder() {
			FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getTarget()).ifPresent(builder::setTarget);
			ofNullable(getExpirySchedule()).ifPresent(builder::setExpirySchedule);
			ofNullable(getSettlementSchedule()).ifPresent(builder::setSettlementSchedule);
			ofNullable(getFixingInformationSource()).ifPresent(builder::setFixingInformationSource);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getPivot()).ifPresent(builder::setPivot);
			ofNullable(getConstantPayoffRegion()).ifPresent(builder::setConstantPayoffRegion);
			ofNullable(getLinearPayoffRegion()).ifPresent(builder::setLinearPayoffRegion);
			ofNullable(getFxTargetKnockoutForwardChoice()).ifPresent(builder::setFxTargetKnockoutForwardChoice);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getSettlementPeriodSchedule()).ifPresent(builder::setSettlementPeriodSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetKnockoutForward _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(target, _that.getTarget())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			if (!Objects.equals(fixingInformationSource, _that.getFixingInformationSource())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(pivot, _that.getPivot())) return false;
			if (!ListEquals.listEquals(constantPayoffRegion, _that.getConstantPayoffRegion())) return false;
			if (!Objects.equals(linearPayoffRegion, _that.getLinearPayoffRegion())) return false;
			if (!ListEquals.listEquals(fxTargetKnockoutForwardChoice, _that.getFxTargetKnockoutForwardChoice())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(settlementPeriodSchedule, _that.getSettlementPeriodSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (target != null ? target.hashCode() : 0);
			_result = 31 * _result + (expirySchedule != null ? expirySchedule.hashCode() : 0);
			_result = 31 * _result + (settlementSchedule != null ? settlementSchedule.hashCode() : 0);
			_result = 31 * _result + (fixingInformationSource != null ? fixingInformationSource.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (pivot != null ? pivot.hashCode() : 0);
			_result = 31 * _result + (constantPayoffRegion != null ? constantPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (linearPayoffRegion != null ? linearPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (fxTargetKnockoutForwardChoice != null ? fxTargetKnockoutForwardChoice.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodSchedule != null ? settlementPeriodSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetKnockoutForward {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"target=" + this.target + ", " +
				"expirySchedule=" + this.expirySchedule + ", " +
				"settlementSchedule=" + this.settlementSchedule + ", " +
				"fixingInformationSource=" + this.fixingInformationSource + ", " +
				"spotRate=" + this.spotRate + ", " +
				"pivot=" + this.pivot + ", " +
				"constantPayoffRegion=" + this.constantPayoffRegion + ", " +
				"linearPayoffRegion=" + this.linearPayoffRegion + ", " +
				"fxTargetKnockoutForwardChoice=" + this.fxTargetKnockoutForwardChoice + ", " +
				"barrier=" + this.barrier + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"settlementPeriodSchedule=" + this.settlementPeriodSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTargetKnockoutForward  ***********************/
	class FxTargetKnockoutForwardBuilderImpl extends Product.ProductBuilderImpl implements FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected List<FxTarget.FxTargetBuilder> target = new ArrayList<>();
		protected FxExpirySchedule.FxExpiryScheduleBuilder expirySchedule;
		protected FxSettlementSchedule.FxSettlementScheduleBuilder settlementSchedule;
		protected FxInformationSource.FxInformationSourceBuilder fixingInformationSource;
		protected BigDecimal spotRate;
		protected FxPivot.FxPivotBuilder pivot;
		protected List<FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder> constantPayoffRegion = new ArrayList<>();
		protected FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder linearPayoffRegion;
		protected List<FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder> fxTargetKnockoutForwardChoice = new ArrayList<>();
		protected List<FxTargetBarrier.FxTargetBarrierBuilder> barrier = new ArrayList<>();
		protected List<SimplePayment.SimplePaymentBuilder> additionalPayment = new ArrayList<>();
		protected FxCashSettlementSimple.FxCashSettlementSimpleBuilder cashSettlement;
		protected FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder settlementPeriodSchedule;
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
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
		@RosettaAttribute("target")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("target")
		public List<? extends FxTarget.FxTargetBuilder> getTarget() {
			return target;
		}
		
		@Override
		public FxTarget.FxTargetBuilder getOrCreateTarget(int index) {
			if (target==null) {
				this.target = new ArrayList<>();
			}
			return getIndex(target, index, () -> {
						FxTarget.FxTargetBuilder newTarget = FxTarget.builder();
						return newTarget;
					});
		}
		
		@Override
		@RosettaAttribute("expirySchedule")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("fixingInformationSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingInformationSource")
		public FxInformationSource.FxInformationSourceBuilder getFixingInformationSource() {
			return fixingInformationSource;
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder getOrCreateFixingInformationSource() {
			FxInformationSource.FxInformationSourceBuilder result;
			if (fixingInformationSource!=null) {
				result = fixingInformationSource;
			}
			else {
				result = fixingInformationSource = FxInformationSource.builder();
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
		@RosettaAttribute("pivot")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pivot")
		public FxPivot.FxPivotBuilder getPivot() {
			return pivot;
		}
		
		@Override
		public FxPivot.FxPivotBuilder getOrCreatePivot() {
			FxPivot.FxPivotBuilder result;
			if (pivot!=null) {
				result = pivot;
			}
			else {
				result = pivot = FxPivot.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("constantPayoffRegion")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("constantPayoffRegion")
		public List<? extends FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder> getConstantPayoffRegion() {
			return constantPayoffRegion;
		}
		
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder getOrCreateConstantPayoffRegion(int index) {
			if (constantPayoffRegion==null) {
				this.constantPayoffRegion = new ArrayList<>();
			}
			return getIndex(constantPayoffRegion, index, () -> {
						FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder newConstantPayoffRegion = FxTargetConstantPayoffRegion.builder();
						return newConstantPayoffRegion;
					});
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("linearPayoffRegion")
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getLinearPayoffRegion() {
			return linearPayoffRegion;
		}
		
		@Override
		public FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder getOrCreateLinearPayoffRegion() {
			FxTargetLinearPayoffRegion.FxTargetLinearPayoffRegionBuilder result;
			if (linearPayoffRegion!=null) {
				result = linearPayoffRegion;
			}
			else {
				result = linearPayoffRegion = FxTargetLinearPayoffRegion.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxTargetKnockoutForwardChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fxTargetKnockoutForwardChoice")
		public List<? extends FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder> getFxTargetKnockoutForwardChoice() {
			return fxTargetKnockoutForwardChoice;
		}
		
		@Override
		public FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder getOrCreateFxTargetKnockoutForwardChoice(int index) {
			if (fxTargetKnockoutForwardChoice==null) {
				this.fxTargetKnockoutForwardChoice = new ArrayList<>();
			}
			return getIndex(fxTargetKnockoutForwardChoice, index, () -> {
						FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder newFxTargetKnockoutForwardChoice = FxTargetKnockoutForwardChoice.builder();
						return newFxTargetKnockoutForwardChoice;
					});
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("barrier")
		public List<? extends FxTargetBarrier.FxTargetBarrierBuilder> getBarrier() {
			return barrier;
		}
		
		@Override
		public FxTargetBarrier.FxTargetBarrierBuilder getOrCreateBarrier(int index) {
			if (barrier==null) {
				this.barrier = new ArrayList<>();
			}
			return getIndex(barrier, index, () -> {
						FxTargetBarrier.FxTargetBarrierBuilder newBarrier = FxTargetBarrier.builder();
						return newBarrier;
					});
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends SimplePayment.SimplePaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getOrCreateAdditionalPayment(int index) {
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			return getIndex(additionalPayment, index, () -> {
						SimplePayment.SimplePaymentBuilder newAdditionalPayment = SimplePayment.builder();
						return newAdditionalPayment;
					});
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement() {
			FxCashSettlementSimple.FxCashSettlementSimpleBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = FxCashSettlementSimple.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPeriodSchedule")
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder getSettlementPeriodSchedule() {
			return settlementPeriodSchedule;
		}
		
		@Override
		public FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder getOrCreateSettlementPeriodSchedule() {
			FxTargetSettlementPeriodSchedule.FxTargetSettlementPeriodScheduleBuilder result;
			if (settlementPeriodSchedule!=null) {
				result = settlementPeriodSchedule;
			}
			else {
				result = settlementPeriodSchedule = FxTargetSettlementPeriodSchedule.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addProductId(List<? extends ProductId> productIds) {
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
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setProductId(List<? extends ProductId> productIds) {
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
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notionalAmount")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setNotionalAmount(NonNegativeAmountSchedule _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("target")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("target")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addTarget(FxTarget _target) {
			if (_target != null) {
				this.target.add(_target.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addTarget(FxTarget _target, int idx) {
			getIndex(this.target, idx, () -> _target.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addTarget(List<? extends FxTarget> targets) {
			if (targets != null) {
				for (final FxTarget toAdd : targets) {
					this.target.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("target")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("target")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setTarget(List<? extends FxTarget> targets) {
			if (targets == null) {
				this.target = new ArrayList<>();
			} else {
				this.target = targets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("expirySchedule")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expirySchedule")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setExpirySchedule(FxExpirySchedule _expirySchedule) {
			this.expirySchedule = _expirySchedule == null ? null : _expirySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementSchedule")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSettlementSchedule(FxSettlementSchedule _settlementSchedule) {
			this.settlementSchedule = _settlementSchedule == null ? null : _settlementSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingInformationSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingInformationSource")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setFixingInformationSource(FxInformationSource _fixingInformationSource) {
			this.fixingInformationSource = _fixingInformationSource == null ? null : _fixingInformationSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotRate")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSpotRate(BigDecimal _spotRate) {
			this.spotRate = _spotRate == null ? null : _spotRate;
			return this;
		}
		
		@RosettaAttribute("pivot")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pivot")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setPivot(FxPivot _pivot) {
			this.pivot = _pivot == null ? null : _pivot.toBuilder();
			return this;
		}
		
		@RosettaAttribute("constantPayoffRegion")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("constantPayoffRegion")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addConstantPayoffRegion(FxTargetConstantPayoffRegion _constantPayoffRegion) {
			if (_constantPayoffRegion != null) {
				this.constantPayoffRegion.add(_constantPayoffRegion.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addConstantPayoffRegion(FxTargetConstantPayoffRegion _constantPayoffRegion, int idx) {
			getIndex(this.constantPayoffRegion, idx, () -> _constantPayoffRegion.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addConstantPayoffRegion(List<? extends FxTargetConstantPayoffRegion> constantPayoffRegions) {
			if (constantPayoffRegions != null) {
				for (final FxTargetConstantPayoffRegion toAdd : constantPayoffRegions) {
					this.constantPayoffRegion.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("constantPayoffRegion")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("constantPayoffRegion")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setConstantPayoffRegion(List<? extends FxTargetConstantPayoffRegion> constantPayoffRegions) {
			if (constantPayoffRegions == null) {
				this.constantPayoffRegion = new ArrayList<>();
			} else {
				this.constantPayoffRegion = constantPayoffRegions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("linearPayoffRegion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("linearPayoffRegion")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setLinearPayoffRegion(FxTargetLinearPayoffRegion _linearPayoffRegion) {
			this.linearPayoffRegion = _linearPayoffRegion == null ? null : _linearPayoffRegion.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxTargetKnockoutForwardChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fxTargetKnockoutForwardChoice")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addFxTargetKnockoutForwardChoice(FxTargetKnockoutForwardChoice _fxTargetKnockoutForwardChoice) {
			if (_fxTargetKnockoutForwardChoice != null) {
				this.fxTargetKnockoutForwardChoice.add(_fxTargetKnockoutForwardChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addFxTargetKnockoutForwardChoice(FxTargetKnockoutForwardChoice _fxTargetKnockoutForwardChoice, int idx) {
			getIndex(this.fxTargetKnockoutForwardChoice, idx, () -> _fxTargetKnockoutForwardChoice.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addFxTargetKnockoutForwardChoice(List<? extends FxTargetKnockoutForwardChoice> fxTargetKnockoutForwardChoices) {
			if (fxTargetKnockoutForwardChoices != null) {
				for (final FxTargetKnockoutForwardChoice toAdd : fxTargetKnockoutForwardChoices) {
					this.fxTargetKnockoutForwardChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("fxTargetKnockoutForwardChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fxTargetKnockoutForwardChoice")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setFxTargetKnockoutForwardChoice(List<? extends FxTargetKnockoutForwardChoice> fxTargetKnockoutForwardChoices) {
			if (fxTargetKnockoutForwardChoices == null) {
				this.fxTargetKnockoutForwardChoice = new ArrayList<>();
			} else {
				this.fxTargetKnockoutForwardChoice = fxTargetKnockoutForwardChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("barrier")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addBarrier(FxTargetBarrier _barrier) {
			if (_barrier != null) {
				this.barrier.add(_barrier.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addBarrier(FxTargetBarrier _barrier, int idx) {
			getIndex(this.barrier, idx, () -> _barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addBarrier(List<? extends FxTargetBarrier> barriers) {
			if (barriers != null) {
				for (final FxTargetBarrier toAdd : barriers) {
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
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setBarrier(List<? extends FxTargetBarrier> barriers) {
			if (barriers == null) {
				this.barrier = new ArrayList<>();
			} else {
				this.barrier = barriers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAdditionalPayment(SimplePayment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAdditionalPayment(SimplePayment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder addAdditionalPayment(List<? extends SimplePayment> additionalPayments) {
			if (additionalPayments != null) {
				for (final SimplePayment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setAdditionalPayment(List<? extends SimplePayment> additionalPayments) {
			if (additionalPayments == null) {
				this.additionalPayment = new ArrayList<>();
			} else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlement")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setCashSettlement(FxCashSettlementSimple _cashSettlement) {
			this.cashSettlement = _cashSettlement == null ? null : _cashSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPeriodSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementPeriodSchedule")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder setSettlementPeriodSchedule(FxTargetSettlementPeriodSchedule _settlementPeriodSchedule) {
			this.settlementPeriodSchedule = _settlementPeriodSchedule == null ? null : _settlementPeriodSchedule.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetKnockoutForward build() {
			return new FxTargetKnockoutForward.FxTargetKnockoutForwardImpl(this);
		}
		
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder prune() {
			super.prune();
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			target = target.stream().filter(b->b!=null).<FxTarget.FxTargetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (expirySchedule!=null && !expirySchedule.prune().hasData()) expirySchedule = null;
			if (settlementSchedule!=null && !settlementSchedule.prune().hasData()) settlementSchedule = null;
			if (fixingInformationSource!=null && !fixingInformationSource.prune().hasData()) fixingInformationSource = null;
			if (pivot!=null && !pivot.prune().hasData()) pivot = null;
			constantPayoffRegion = constantPayoffRegion.stream().filter(b->b!=null).<FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (linearPayoffRegion!=null && !linearPayoffRegion.prune().hasData()) linearPayoffRegion = null;
			fxTargetKnockoutForwardChoice = fxTargetKnockoutForwardChoice.stream().filter(b->b!=null).<FxTargetKnockoutForwardChoice.FxTargetKnockoutForwardChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			barrier = barrier.stream().filter(b->b!=null).<FxTargetBarrier.FxTargetBarrierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<SimplePayment.SimplePaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (settlementPeriodSchedule!=null && !settlementPeriodSchedule.prune().hasData()) settlementPeriodSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getTarget()!=null && getTarget().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExpirySchedule()!=null && getExpirySchedule().hasData()) return true;
			if (getSettlementSchedule()!=null && getSettlementSchedule().hasData()) return true;
			if (getFixingInformationSource()!=null && getFixingInformationSource().hasData()) return true;
			if (getSpotRate()!=null) return true;
			if (getPivot()!=null && getPivot().hasData()) return true;
			if (getConstantPayoffRegion()!=null && getConstantPayoffRegion().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLinearPayoffRegion()!=null && getLinearPayoffRegion().hasData()) return true;
			if (getFxTargetKnockoutForwardChoice()!=null && getFxTargetKnockoutForwardChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getSettlementPeriodSchedule()!=null && getSettlementPeriodSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder o = (FxTargetKnockoutForward.FxTargetKnockoutForwardBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getTarget(), o.getTarget(), this::getOrCreateTarget);
			merger.mergeRosetta(getExpirySchedule(), o.getExpirySchedule(), this::setExpirySchedule);
			merger.mergeRosetta(getSettlementSchedule(), o.getSettlementSchedule(), this::setSettlementSchedule);
			merger.mergeRosetta(getFixingInformationSource(), o.getFixingInformationSource(), this::setFixingInformationSource);
			merger.mergeRosetta(getPivot(), o.getPivot(), this::setPivot);
			merger.mergeRosetta(getConstantPayoffRegion(), o.getConstantPayoffRegion(), this::getOrCreateConstantPayoffRegion);
			merger.mergeRosetta(getLinearPayoffRegion(), o.getLinearPayoffRegion(), this::setLinearPayoffRegion);
			merger.mergeRosetta(getFxTargetKnockoutForwardChoice(), o.getFxTargetKnockoutForwardChoice(), this::getOrCreateFxTargetKnockoutForwardChoice);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::getOrCreateBarrier);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getSettlementPeriodSchedule(), o.getSettlementPeriodSchedule(), this::setSettlementPeriodSchedule);
			
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetKnockoutForward _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(target, _that.getTarget())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			if (!Objects.equals(fixingInformationSource, _that.getFixingInformationSource())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(pivot, _that.getPivot())) return false;
			if (!ListEquals.listEquals(constantPayoffRegion, _that.getConstantPayoffRegion())) return false;
			if (!Objects.equals(linearPayoffRegion, _that.getLinearPayoffRegion())) return false;
			if (!ListEquals.listEquals(fxTargetKnockoutForwardChoice, _that.getFxTargetKnockoutForwardChoice())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(settlementPeriodSchedule, _that.getSettlementPeriodSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (target != null ? target.hashCode() : 0);
			_result = 31 * _result + (expirySchedule != null ? expirySchedule.hashCode() : 0);
			_result = 31 * _result + (settlementSchedule != null ? settlementSchedule.hashCode() : 0);
			_result = 31 * _result + (fixingInformationSource != null ? fixingInformationSource.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (pivot != null ? pivot.hashCode() : 0);
			_result = 31 * _result + (constantPayoffRegion != null ? constantPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (linearPayoffRegion != null ? linearPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (fxTargetKnockoutForwardChoice != null ? fxTargetKnockoutForwardChoice.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodSchedule != null ? settlementPeriodSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetKnockoutForwardBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"target=" + this.target + ", " +
				"expirySchedule=" + this.expirySchedule + ", " +
				"settlementSchedule=" + this.settlementSchedule + ", " +
				"fixingInformationSource=" + this.fixingInformationSource + ", " +
				"spotRate=" + this.spotRate + ", " +
				"pivot=" + this.pivot + ", " +
				"constantPayoffRegion=" + this.constantPayoffRegion + ", " +
				"linearPayoffRegion=" + this.linearPayoffRegion + ", " +
				"fxTargetKnockoutForwardChoice=" + this.fxTargetKnockoutForwardChoice + ", " +
				"barrier=" + this.barrier + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"settlementPeriodSchedule=" + this.settlementPeriodSchedule +
			'}' + " " + super.toString();
		}
	}
}

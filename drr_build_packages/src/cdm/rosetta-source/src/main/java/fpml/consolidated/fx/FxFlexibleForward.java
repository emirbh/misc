package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.FxFlexibleForwardMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.RelativeDateOffset;
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
 * Provision Product model for a flexible-term fx forward (also known as callable forward, window forward). This is a term forward transaction over a specific period, allowing the client full flexibility on the timing of the transactional flow(s). The product allows for (full or partial) execution at a predetermined forward rate, at any time between the start date and the expiry date. Although, the product is an outright, it has some option-like characteristics, leading to the use of option components in the model: (i) the BuyerSeller model expresses the roles of the parties in the overall transaction - the client "buys" the product (ii) the PutCallCurrency model expresses the buyer's perspective on the exchanged currencies i.e. the client may buy (call) or sell (put) the notional currency for the alternative currency.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Product model for a flexible-term fx forward (also known as callable forward, window forward). This is a term forward transaction over a specific period, allowing the client full flexibility on the timing of the transactional flow(s). The product allows for (full or partial) execution at a predetermined forward rate, at any time between the start date and the expiry date. Although, the product is an outright, it has some option-like characteristics, leading to the use of option components in the model: (i) the BuyerSeller model expresses the roles of the parties in the overall transaction - the client "buys" the product (ii) the PutCallCurrency model expresses the buyer's perspective on the exchanged currencies i.e. the client may buy (call) or sell (put) the notional currency for the alternative currency.
 *
 */
@RosettaDataType(value="FxFlexibleForward", builder=FxFlexibleForward.FxFlexibleForwardBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxFlexibleForward", model="fpml", builder=FxFlexibleForward.FxFlexibleForwardBuilderImpl.class, version="2.1.1")
public interface FxFlexibleForward extends Product {

	FxFlexibleForwardMeta metaData = new FxFlexibleForwardMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 */
	PartyReference getBuyerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 */
	AccountReference getBuyerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 */
	PartyReference getSellerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 */
	AccountReference getSellerAccountReference();
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
	 * Provision The aggregate notional amount which will be exchanged, possibly as multiple partial executions, during the course of the execution period. Any residual notional which remains unexchanged at the expiry date will automatically be executed at the applicable exchange rate (strike).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The aggregate notional amount which will be exchanged, possibly as multiple partial executions, during the course of the execution period. Any residual notional which remains unexchanged at the expiry date will automatically be executed at the applicable exchange rate (strike).
	 *
	 */
	NonNegativeMoney getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The minimum notional amount which must be executed in any single transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The minimum notional amount which must be executed in any single transaction.
	 *
	 */
	PositiveMoney getMinimumExecutionAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The total amount of settlement currency that will be paid over the life of the trade if calculable. The Settlement Amount element is a synonym for Contra Amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The total amount of settlement currency that will be paid over the life of the trade if calculable. The Settlement Amount element is a synonym for Contra Amount.
	 *
	 */
	NonNegativeMoney getSettlementAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The period during which the client has the right to execute a transaction, on any business day defined by reference to the specified business centers, subject to the constraints of the minimum execution amount and aggregate total notional amount. * Period dates are inclusive i.e. the expiry date is the final date on which execution may occur.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The period during which the client has the right to execute a transaction, on any business day defined by reference to the specified business centers, subject to the constraints of the minimum execution amount and aggregate total notional amount. * Period dates are inclusive i.e. the expiry date is the final date on which execution may occur.
	 *
	 */
	FxFlexibleForwardExecutionPeriod getExecutionPeriodDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The earliest time of day at the specified business center, at which the client may execute a transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The earliest time of day at the specified business center, at which the client may execute a transaction.
	 *
	 */
	BusinessCenterTime getEarliestExecutionTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The latest time of day at the specified business center, at which the client may execute a transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The latest time of day at the specified business center, at which the client may execute a transaction.
	 *
	 */
	BusinessCenterTime getLatestExecutionTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which delivery of the transacted currency amounts will occur, expressed as an offset from the execution date. * This property is optional in the schema, allowing it to be omitted by systems which do not support it; however this information would be expected in contractual documentation (e.g. termsheet, confirmation).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which delivery of the transacted currency amounts will occur, expressed as an offset from the execution date. * This property is optional in the schema, allowing it to be omitted by systems which do not support it; however this information would be expected in contractual documentation (e.g. termsheet, confirmation).
	 *
	 */
	RelativeDateOffset getSettlementDateOffset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The final date for settlement. This is the date on which any residual exchange amount will be delivered. * This is an adjusted date i.e. a good business day for delivery in the location(s) specified in executionPeriodDates /businessCenters
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The final date for settlement. This is the date on which any residual exchange amount will be delivered. * This is an adjusted date i.e. a good business day for delivery in the location(s) specified in executionPeriodDates /businessCenters
	 *
	 */
	ZonedDateTime getFinalSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Definition of the forward exchange rate for transactions executed during the execution period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Definition of the forward exchange rate for transactions executed during the execution period.
	 *
	 */
	FxFlexibleForwardRate getForwardRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Fee paid by the client at inception (analagous to an option premium).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Fee paid by the client at inception (analagous to an option premium).
	 *
	 */
	Payment getAdditionalPayment();

	/*********************** Build Methods  ***********************/
	FxFlexibleForward build();
	
	FxFlexibleForward.FxFlexibleForwardBuilder toBuilder();
	
	static FxFlexibleForward.FxFlexibleForwardBuilder builder() {
		return new FxFlexibleForward.FxFlexibleForwardBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFlexibleForward> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxFlexibleForward> getType() {
		return FxFlexibleForward.class;
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
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeMoney.class, getNotionalAmount());
		processRosetta(path.newSubPath("minimumExecutionAmount"), processor, PositiveMoney.class, getMinimumExecutionAmount());
		processRosetta(path.newSubPath("settlementAmount"), processor, NonNegativeMoney.class, getSettlementAmount());
		processRosetta(path.newSubPath("executionPeriodDates"), processor, FxFlexibleForwardExecutionPeriod.class, getExecutionPeriodDates());
		processRosetta(path.newSubPath("earliestExecutionTime"), processor, BusinessCenterTime.class, getEarliestExecutionTime());
		processRosetta(path.newSubPath("latestExecutionTime"), processor, BusinessCenterTime.class, getLatestExecutionTime());
		processRosetta(path.newSubPath("settlementDateOffset"), processor, RelativeDateOffset.class, getSettlementDateOffset());
		processor.processBasic(path.newSubPath("finalSettlementDate"), ZonedDateTime.class, getFinalSettlementDate(), this);
		processRosetta(path.newSubPath("forwardRate"), processor, FxFlexibleForwardRate.class, getForwardRate());
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFlexibleForwardBuilder extends FxFlexibleForward, Product.ProductBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getBuyerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getSellerAccountReference();
		Currency.CurrencyBuilder getOrCreatePutCurrency();
		@Override
		Currency.CurrencyBuilder getPutCurrency();
		Currency.CurrencyBuilder getOrCreateCallCurrency();
		@Override
		Currency.CurrencyBuilder getCallCurrency();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotionalAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getNotionalAmount();
		PositiveMoney.PositiveMoneyBuilder getOrCreateMinimumExecutionAmount();
		@Override
		PositiveMoney.PositiveMoneyBuilder getMinimumExecutionAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateSettlementAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getSettlementAmount();
		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder getOrCreateExecutionPeriodDates();
		@Override
		FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder getExecutionPeriodDates();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExecutionTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExecutionTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExecutionTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getLatestExecutionTime();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateSettlementDateOffset();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getSettlementDateOffset();
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder getOrCreateForwardRate();
		@Override
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder getForwardRate();
		Payment.PaymentBuilder getOrCreateAdditionalPayment();
		@Override
		Payment.PaymentBuilder getAdditionalPayment();
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder setId(String id);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addProductType(ProductType productType);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addProductType(ProductType productType, int idx);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addProductType(List<? extends ProductType> productType);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder setProductType(List<? extends ProductType> productType);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addProductId(ProductId productId);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addProductId(ProductId productId, int idx);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addProductId(List<? extends ProductId> productId);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder setProductId(List<? extends ProductId> productId);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addAssetClass(AssetClass assetClass);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxFlexibleForward.FxFlexibleForwardBuilder setAssetClass(List<? extends AssetClass> assetClass);
		FxFlexibleForward.FxFlexibleForwardBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		FxFlexibleForward.FxFlexibleForwardBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		FxFlexibleForward.FxFlexibleForwardBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		FxFlexibleForward.FxFlexibleForwardBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		FxFlexibleForward.FxFlexibleForwardBuilder setPutCurrency(Currency putCurrency);
		FxFlexibleForward.FxFlexibleForwardBuilder setCallCurrency(Currency callCurrency);
		FxFlexibleForward.FxFlexibleForwardBuilder setNotionalAmount(NonNegativeMoney notionalAmount);
		FxFlexibleForward.FxFlexibleForwardBuilder setMinimumExecutionAmount(PositiveMoney minimumExecutionAmount);
		FxFlexibleForward.FxFlexibleForwardBuilder setSettlementAmount(NonNegativeMoney settlementAmount);
		FxFlexibleForward.FxFlexibleForwardBuilder setExecutionPeriodDates(FxFlexibleForwardExecutionPeriod executionPeriodDates);
		FxFlexibleForward.FxFlexibleForwardBuilder setEarliestExecutionTime(BusinessCenterTime earliestExecutionTime);
		FxFlexibleForward.FxFlexibleForwardBuilder setLatestExecutionTime(BusinessCenterTime latestExecutionTime);
		FxFlexibleForward.FxFlexibleForwardBuilder setSettlementDateOffset(RelativeDateOffset settlementDateOffset);
		FxFlexibleForward.FxFlexibleForwardBuilder setFinalSettlementDate(ZonedDateTime finalSettlementDate);
		FxFlexibleForward.FxFlexibleForwardBuilder setForwardRate(FxFlexibleForwardRate forwardRate);
		FxFlexibleForward.FxFlexibleForwardBuilder setAdditionalPayment(Payment additionalPayment);

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
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("minimumExecutionAmount"), processor, PositiveMoney.PositiveMoneyBuilder.class, getMinimumExecutionAmount());
			processRosetta(path.newSubPath("settlementAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getSettlementAmount());
			processRosetta(path.newSubPath("executionPeriodDates"), processor, FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder.class, getExecutionPeriodDates());
			processRosetta(path.newSubPath("earliestExecutionTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getEarliestExecutionTime());
			processRosetta(path.newSubPath("latestExecutionTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestExecutionTime());
			processRosetta(path.newSubPath("settlementDateOffset"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getSettlementDateOffset());
			processor.processBasic(path.newSubPath("finalSettlementDate"), ZonedDateTime.class, getFinalSettlementDate(), this);
			processRosetta(path.newSubPath("forwardRate"), processor, FxFlexibleForwardRate.FxFlexibleForwardRateBuilder.class, getForwardRate());
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
		}
		

		FxFlexibleForward.FxFlexibleForwardBuilder prune();
	}

	/*********************** Immutable Implementation of FxFlexibleForward  ***********************/
	class FxFlexibleForwardImpl extends Product.ProductImpl implements FxFlexibleForward {
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final Currency putCurrency;
		private final Currency callCurrency;
		private final NonNegativeMoney notionalAmount;
		private final PositiveMoney minimumExecutionAmount;
		private final NonNegativeMoney settlementAmount;
		private final FxFlexibleForwardExecutionPeriod executionPeriodDates;
		private final BusinessCenterTime earliestExecutionTime;
		private final BusinessCenterTime latestExecutionTime;
		private final RelativeDateOffset settlementDateOffset;
		private final ZonedDateTime finalSettlementDate;
		private final FxFlexibleForwardRate forwardRate;
		private final Payment additionalPayment;
		
		protected FxFlexibleForwardImpl(FxFlexibleForward.FxFlexibleForwardBuilder builder) {
			super(builder);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.putCurrency = ofNullable(builder.getPutCurrency()).map(f->f.build()).orElse(null);
			this.callCurrency = ofNullable(builder.getCallCurrency()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.minimumExecutionAmount = ofNullable(builder.getMinimumExecutionAmount()).map(f->f.build()).orElse(null);
			this.settlementAmount = ofNullable(builder.getSettlementAmount()).map(f->f.build()).orElse(null);
			this.executionPeriodDates = ofNullable(builder.getExecutionPeriodDates()).map(f->f.build()).orElse(null);
			this.earliestExecutionTime = ofNullable(builder.getEarliestExecutionTime()).map(f->f.build()).orElse(null);
			this.latestExecutionTime = ofNullable(builder.getLatestExecutionTime()).map(f->f.build()).orElse(null);
			this.settlementDateOffset = ofNullable(builder.getSettlementDateOffset()).map(f->f.build()).orElse(null);
			this.finalSettlementDate = builder.getFinalSettlementDate();
			this.forwardRate = ofNullable(builder.getForwardRate()).map(f->f.build()).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference getSellerAccountReference() {
			return sellerAccountReference;
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
		public NonNegativeMoney getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("minimumExecutionAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumExecutionAmount")
		public PositiveMoney getMinimumExecutionAmount() {
			return minimumExecutionAmount;
		}
		
		@Override
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementAmount")
		public NonNegativeMoney getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		@RosettaAttribute("executionPeriodDates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionPeriodDates")
		public FxFlexibleForwardExecutionPeriod getExecutionPeriodDates() {
			return executionPeriodDates;
		}
		
		@Override
		@RosettaAttribute("earliestExecutionTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earliestExecutionTime")
		public BusinessCenterTime getEarliestExecutionTime() {
			return earliestExecutionTime;
		}
		
		@Override
		@RosettaAttribute("latestExecutionTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestExecutionTime")
		public BusinessCenterTime getLatestExecutionTime() {
			return latestExecutionTime;
		}
		
		@Override
		@RosettaAttribute("settlementDateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDateOffset")
		public RelativeDateOffset getSettlementDateOffset() {
			return settlementDateOffset;
		}
		
		@Override
		@RosettaAttribute("finalSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalSettlementDate")
		public ZonedDateTime getFinalSettlementDate() {
			return finalSettlementDate;
		}
		
		@Override
		@RosettaAttribute("forwardRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("forwardRate")
		public FxFlexibleForwardRate getForwardRate() {
			return forwardRate;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalPayment")
		public Payment getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public FxFlexibleForward build() {
			return this;
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder toBuilder() {
			FxFlexibleForward.FxFlexibleForwardBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFlexibleForward.FxFlexibleForwardBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getPutCurrency()).ifPresent(builder::setPutCurrency);
			ofNullable(getCallCurrency()).ifPresent(builder::setCallCurrency);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getMinimumExecutionAmount()).ifPresent(builder::setMinimumExecutionAmount);
			ofNullable(getSettlementAmount()).ifPresent(builder::setSettlementAmount);
			ofNullable(getExecutionPeriodDates()).ifPresent(builder::setExecutionPeriodDates);
			ofNullable(getEarliestExecutionTime()).ifPresent(builder::setEarliestExecutionTime);
			ofNullable(getLatestExecutionTime()).ifPresent(builder::setLatestExecutionTime);
			ofNullable(getSettlementDateOffset()).ifPresent(builder::setSettlementDateOffset);
			ofNullable(getFinalSettlementDate()).ifPresent(builder::setFinalSettlementDate);
			ofNullable(getForwardRate()).ifPresent(builder::setForwardRate);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFlexibleForward _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(putCurrency, _that.getPutCurrency())) return false;
			if (!Objects.equals(callCurrency, _that.getCallCurrency())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(minimumExecutionAmount, _that.getMinimumExecutionAmount())) return false;
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(executionPeriodDates, _that.getExecutionPeriodDates())) return false;
			if (!Objects.equals(earliestExecutionTime, _that.getEarliestExecutionTime())) return false;
			if (!Objects.equals(latestExecutionTime, _that.getLatestExecutionTime())) return false;
			if (!Objects.equals(settlementDateOffset, _that.getSettlementDateOffset())) return false;
			if (!Objects.equals(finalSettlementDate, _that.getFinalSettlementDate())) return false;
			if (!Objects.equals(forwardRate, _that.getForwardRate())) return false;
			if (!Objects.equals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (putCurrency != null ? putCurrency.hashCode() : 0);
			_result = 31 * _result + (callCurrency != null ? callCurrency.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (minimumExecutionAmount != null ? minimumExecutionAmount.hashCode() : 0);
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (executionPeriodDates != null ? executionPeriodDates.hashCode() : 0);
			_result = 31 * _result + (earliestExecutionTime != null ? earliestExecutionTime.hashCode() : 0);
			_result = 31 * _result + (latestExecutionTime != null ? latestExecutionTime.hashCode() : 0);
			_result = 31 * _result + (settlementDateOffset != null ? settlementDateOffset.hashCode() : 0);
			_result = 31 * _result + (finalSettlementDate != null ? finalSettlementDate.hashCode() : 0);
			_result = 31 * _result + (forwardRate != null ? forwardRate.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForward {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"putCurrency=" + this.putCurrency + ", " +
				"callCurrency=" + this.callCurrency + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"minimumExecutionAmount=" + this.minimumExecutionAmount + ", " +
				"settlementAmount=" + this.settlementAmount + ", " +
				"executionPeriodDates=" + this.executionPeriodDates + ", " +
				"earliestExecutionTime=" + this.earliestExecutionTime + ", " +
				"latestExecutionTime=" + this.latestExecutionTime + ", " +
				"settlementDateOffset=" + this.settlementDateOffset + ", " +
				"finalSettlementDate=" + this.finalSettlementDate + ", " +
				"forwardRate=" + this.forwardRate + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxFlexibleForward  ***********************/
	class FxFlexibleForwardBuilderImpl extends Product.ProductBuilderImpl implements FxFlexibleForward.FxFlexibleForwardBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected Currency.CurrencyBuilder putCurrency;
		protected Currency.CurrencyBuilder callCurrency;
		protected NonNegativeMoney.NonNegativeMoneyBuilder notionalAmount;
		protected PositiveMoney.PositiveMoneyBuilder minimumExecutionAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder settlementAmount;
		protected FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder executionPeriodDates;
		protected BusinessCenterTime.BusinessCenterTimeBuilder earliestExecutionTime;
		protected BusinessCenterTime.BusinessCenterTimeBuilder latestExecutionTime;
		protected RelativeDateOffset.RelativeDateOffsetBuilder settlementDateOffset;
		protected ZonedDateTime finalSettlementDate;
		protected FxFlexibleForwardRate.FxFlexibleForwardRateBuilder forwardRate;
		protected Payment.PaymentBuilder additionalPayment;
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference.PartyReferenceBuilder getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (buyerPartyReference!=null) {
				result = buyerPartyReference;
			}
			else {
				result = buyerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference.AccountReferenceBuilder getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (buyerAccountReference!=null) {
				result = buyerAccountReference;
			}
			else {
				result = buyerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference.PartyReferenceBuilder getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (sellerPartyReference!=null) {
				result = sellerPartyReference;
			}
			else {
				result = sellerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference.AccountReferenceBuilder getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (sellerAccountReference!=null) {
				result = sellerAccountReference;
			}
			else {
				result = sellerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
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
		public NonNegativeMoney.NonNegativeMoneyBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotionalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minimumExecutionAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumExecutionAmount")
		public PositiveMoney.PositiveMoneyBuilder getMinimumExecutionAmount() {
			return minimumExecutionAmount;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateMinimumExecutionAmount() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (minimumExecutionAmount!=null) {
				result = minimumExecutionAmount;
			}
			else {
				result = minimumExecutionAmount = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateSettlementAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (settlementAmount!=null) {
				result = settlementAmount;
			}
			else {
				result = settlementAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("executionPeriodDates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionPeriodDates")
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder getExecutionPeriodDates() {
			return executionPeriodDates;
		}
		
		@Override
		public FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder getOrCreateExecutionPeriodDates() {
			FxFlexibleForwardExecutionPeriod.FxFlexibleForwardExecutionPeriodBuilder result;
			if (executionPeriodDates!=null) {
				result = executionPeriodDates;
			}
			else {
				result = executionPeriodDates = FxFlexibleForwardExecutionPeriod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("earliestExecutionTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earliestExecutionTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExecutionTime() {
			return earliestExecutionTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExecutionTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (earliestExecutionTime!=null) {
				result = earliestExecutionTime;
			}
			else {
				result = earliestExecutionTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("latestExecutionTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestExecutionTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getLatestExecutionTime() {
			return latestExecutionTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExecutionTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (latestExecutionTime!=null) {
				result = latestExecutionTime;
			}
			else {
				result = latestExecutionTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDateOffset")
		public RelativeDateOffset.RelativeDateOffsetBuilder getSettlementDateOffset() {
			return settlementDateOffset;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateSettlementDateOffset() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (settlementDateOffset!=null) {
				result = settlementDateOffset;
			}
			else {
				result = settlementDateOffset = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalSettlementDate")
		public ZonedDateTime getFinalSettlementDate() {
			return finalSettlementDate;
		}
		
		@Override
		@RosettaAttribute("forwardRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("forwardRate")
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder getForwardRate() {
			return forwardRate;
		}
		
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder getOrCreateForwardRate() {
			FxFlexibleForwardRate.FxFlexibleForwardRateBuilder result;
			if (forwardRate!=null) {
				result = forwardRate;
			}
			else {
				result = forwardRate = FxFlexibleForwardRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalPayment")
		public Payment.PaymentBuilder getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreateAdditionalPayment() {
			Payment.PaymentBuilder result;
			if (additionalPayment!=null) {
				result = additionalPayment;
			}
			else {
				result = additionalPayment = Payment.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxFlexibleForward.FxFlexibleForwardBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxFlexibleForward.FxFlexibleForwardBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public FxFlexibleForward.FxFlexibleForwardBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public FxFlexibleForward.FxFlexibleForwardBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder addProductId(List<? extends ProductId> productIds) {
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
		public FxFlexibleForward.FxFlexibleForwardBuilder setProductId(List<? extends ProductId> productIds) {
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
		public FxFlexibleForward.FxFlexibleForwardBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxFlexibleForward.FxFlexibleForwardBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxFlexibleForward.FxFlexibleForwardBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxFlexibleForward.FxFlexibleForwardBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxFlexibleForward.FxFlexibleForwardBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("putCurrency")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setPutCurrency(Currency _putCurrency) {
			this.putCurrency = _putCurrency == null ? null : _putCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("callCurrency")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setCallCurrency(Currency _callCurrency) {
			this.callCurrency = _callCurrency == null ? null : _callCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notionalAmount")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setNotionalAmount(NonNegativeMoney _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minimumExecutionAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumExecutionAmount")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setMinimumExecutionAmount(PositiveMoney _minimumExecutionAmount) {
			this.minimumExecutionAmount = _minimumExecutionAmount == null ? null : _minimumExecutionAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementAmount")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setSettlementAmount(NonNegativeMoney _settlementAmount) {
			this.settlementAmount = _settlementAmount == null ? null : _settlementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("executionPeriodDates")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executionPeriodDates")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setExecutionPeriodDates(FxFlexibleForwardExecutionPeriod _executionPeriodDates) {
			this.executionPeriodDates = _executionPeriodDates == null ? null : _executionPeriodDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("earliestExecutionTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earliestExecutionTime")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setEarliestExecutionTime(BusinessCenterTime _earliestExecutionTime) {
			this.earliestExecutionTime = _earliestExecutionTime == null ? null : _earliestExecutionTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("latestExecutionTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("latestExecutionTime")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setLatestExecutionTime(BusinessCenterTime _latestExecutionTime) {
			this.latestExecutionTime = _latestExecutionTime == null ? null : _latestExecutionTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDateOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDateOffset")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setSettlementDateOffset(RelativeDateOffset _settlementDateOffset) {
			this.settlementDateOffset = _settlementDateOffset == null ? null : _settlementDateOffset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("finalSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalSettlementDate")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setFinalSettlementDate(ZonedDateTime _finalSettlementDate) {
			this.finalSettlementDate = _finalSettlementDate == null ? null : _finalSettlementDate;
			return this;
		}
		
		@RosettaAttribute("forwardRate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("forwardRate")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setForwardRate(FxFlexibleForwardRate _forwardRate) {
			this.forwardRate = _forwardRate == null ? null : _forwardRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalPayment")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder setAdditionalPayment(Payment _additionalPayment) {
			this.additionalPayment = _additionalPayment == null ? null : _additionalPayment.toBuilder();
			return this;
		}
		
		@Override
		public FxFlexibleForward build() {
			return new FxFlexibleForward.FxFlexibleForwardImpl(this);
		}
		
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder prune() {
			super.prune();
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			if (putCurrency!=null && !putCurrency.prune().hasData()) putCurrency = null;
			if (callCurrency!=null && !callCurrency.prune().hasData()) callCurrency = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (minimumExecutionAmount!=null && !minimumExecutionAmount.prune().hasData()) minimumExecutionAmount = null;
			if (settlementAmount!=null && !settlementAmount.prune().hasData()) settlementAmount = null;
			if (executionPeriodDates!=null && !executionPeriodDates.prune().hasData()) executionPeriodDates = null;
			if (earliestExecutionTime!=null && !earliestExecutionTime.prune().hasData()) earliestExecutionTime = null;
			if (latestExecutionTime!=null && !latestExecutionTime.prune().hasData()) latestExecutionTime = null;
			if (settlementDateOffset!=null && !settlementDateOffset.prune().hasData()) settlementDateOffset = null;
			if (forwardRate!=null && !forwardRate.prune().hasData()) forwardRate = null;
			if (additionalPayment!=null && !additionalPayment.prune().hasData()) additionalPayment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			if (getPutCurrency()!=null && getPutCurrency().hasData()) return true;
			if (getCallCurrency()!=null && getCallCurrency().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getMinimumExecutionAmount()!=null && getMinimumExecutionAmount().hasData()) return true;
			if (getSettlementAmount()!=null && getSettlementAmount().hasData()) return true;
			if (getExecutionPeriodDates()!=null && getExecutionPeriodDates().hasData()) return true;
			if (getEarliestExecutionTime()!=null && getEarliestExecutionTime().hasData()) return true;
			if (getLatestExecutionTime()!=null && getLatestExecutionTime().hasData()) return true;
			if (getSettlementDateOffset()!=null && getSettlementDateOffset().hasData()) return true;
			if (getFinalSettlementDate()!=null) return true;
			if (getForwardRate()!=null && getForwardRate().hasData()) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForward.FxFlexibleForwardBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxFlexibleForward.FxFlexibleForwardBuilder o = (FxFlexibleForward.FxFlexibleForwardBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getPutCurrency(), o.getPutCurrency(), this::setPutCurrency);
			merger.mergeRosetta(getCallCurrency(), o.getCallCurrency(), this::setCallCurrency);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getMinimumExecutionAmount(), o.getMinimumExecutionAmount(), this::setMinimumExecutionAmount);
			merger.mergeRosetta(getSettlementAmount(), o.getSettlementAmount(), this::setSettlementAmount);
			merger.mergeRosetta(getExecutionPeriodDates(), o.getExecutionPeriodDates(), this::setExecutionPeriodDates);
			merger.mergeRosetta(getEarliestExecutionTime(), o.getEarliestExecutionTime(), this::setEarliestExecutionTime);
			merger.mergeRosetta(getLatestExecutionTime(), o.getLatestExecutionTime(), this::setLatestExecutionTime);
			merger.mergeRosetta(getSettlementDateOffset(), o.getSettlementDateOffset(), this::setSettlementDateOffset);
			merger.mergeRosetta(getForwardRate(), o.getForwardRate(), this::setForwardRate);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::setAdditionalPayment);
			
			merger.mergeBasic(getFinalSettlementDate(), o.getFinalSettlementDate(), this::setFinalSettlementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFlexibleForward _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(putCurrency, _that.getPutCurrency())) return false;
			if (!Objects.equals(callCurrency, _that.getCallCurrency())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(minimumExecutionAmount, _that.getMinimumExecutionAmount())) return false;
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(executionPeriodDates, _that.getExecutionPeriodDates())) return false;
			if (!Objects.equals(earliestExecutionTime, _that.getEarliestExecutionTime())) return false;
			if (!Objects.equals(latestExecutionTime, _that.getLatestExecutionTime())) return false;
			if (!Objects.equals(settlementDateOffset, _that.getSettlementDateOffset())) return false;
			if (!Objects.equals(finalSettlementDate, _that.getFinalSettlementDate())) return false;
			if (!Objects.equals(forwardRate, _that.getForwardRate())) return false;
			if (!Objects.equals(additionalPayment, _that.getAdditionalPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (putCurrency != null ? putCurrency.hashCode() : 0);
			_result = 31 * _result + (callCurrency != null ? callCurrency.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (minimumExecutionAmount != null ? minimumExecutionAmount.hashCode() : 0);
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (executionPeriodDates != null ? executionPeriodDates.hashCode() : 0);
			_result = 31 * _result + (earliestExecutionTime != null ? earliestExecutionTime.hashCode() : 0);
			_result = 31 * _result + (latestExecutionTime != null ? latestExecutionTime.hashCode() : 0);
			_result = 31 * _result + (settlementDateOffset != null ? settlementDateOffset.hashCode() : 0);
			_result = 31 * _result + (finalSettlementDate != null ? finalSettlementDate.hashCode() : 0);
			_result = 31 * _result + (forwardRate != null ? forwardRate.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForwardBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"putCurrency=" + this.putCurrency + ", " +
				"callCurrency=" + this.callCurrency + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"minimumExecutionAmount=" + this.minimumExecutionAmount + ", " +
				"settlementAmount=" + this.settlementAmount + ", " +
				"executionPeriodDates=" + this.executionPeriodDates + ", " +
				"earliestExecutionTime=" + this.earliestExecutionTime + ", " +
				"latestExecutionTime=" + this.latestExecutionTime + ", " +
				"settlementDateOffset=" + this.settlementDateOffset + ", " +
				"finalSettlementDate=" + this.finalSettlementDate + ", " +
				"forwardRate=" + this.forwardRate + ", " +
				"additionalPayment=" + this.additionalPayment +
			'}' + " " + super.toString();
		}
	}
}

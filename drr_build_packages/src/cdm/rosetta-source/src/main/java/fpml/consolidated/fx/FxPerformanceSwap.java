package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.FxPerformanceSwapMeta;
import fpml.consolidated.shared.AdjustableOrAdjustedDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
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
 * Provision Describes an FX volatility and variance swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes an FX volatility and variance swap.
 *
 */
@RosettaDataType(value="FxPerformanceSwap", builder=FxPerformanceSwap.FxPerformanceSwapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxPerformanceSwap", model="fpml", builder=FxPerformanceSwap.FxPerformanceSwapBuilderImpl.class, version="2.1.1")
public interface FxPerformanceSwap extends Product {

	FxPerformanceSwapMeta metaData = new FxPerformanceSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A Currency Pair with regards to this transaction and the quoting convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A Currency Pair with regards to this transaction and the quoting convention.
	 *
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Vega Notional means the currency and amount specified as such in the related Confirmation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Vega Notional means the currency and amount specified as such in the related Confirmation.
	 *
	 */
	NonNegativeMoney getVegaNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Notional Amount means, in the case of Transaction Type Variance Swap, the currency and amount specified as such in the related Confirmation or an amount calculated in accordance with the following: Notional Amount = Vega Notional Amount / (0.02 x Fixed FX Rate). This element must be produced in case of Variance Swap transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Notional Amount means, in the case of Transaction Type Variance Swap, the currency and amount specified as such in the related Confirmation or an amount calculated in accordance with the following: Notional Amount = Vega Notional Amount / (0.02 x Fixed FX Rate). This element must be produced in case of Variance Swap transaction.
	 *
	 */
	NonNegativeMoney getNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Fixed FX Rate component describes the Fixed FX Rate and Fixed FX Rate Payer as such in the Confirmation for the Non-Deliverable Swap FX Transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Fixed FX Rate component describes the Fixed FX Rate and Fixed FX Rate Payer as such in the Confirmation for the Non-Deliverable Swap FX Transaction.
	 *
	 */
	FxPerformanceFixedLeg getFixedLeg();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Floating FX Rate component describes the Floating FX Rate Payer of the rate determined in accordance with the Floating FX Rate Option specified in the Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Floating FX Rate component describes the Floating FX Rate Payer of the rate determined in accordance with the Floating FX Rate Option specified in the Definitions.
	 *
	 */
	FxPerformanceFloatingLeg getFloatingLeg();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Fixing Information source parameters to determine the rate observed for each good business day within the Fixing Schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Fixing Information source parameters to determine the rate observed for each good business day within the Fixing Schedule.
	 *
	 */
	FxSpotRateSource getFixingInformationSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Parametric schedule of rate observation dates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Parametric schedule of rate observation dates.
	 *
	 */
	FxFixingScheduleSimple getFixingSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Final Observation Date when Settlement Amount and Settlement Amount Payer determination date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Final Observation Date when Settlement Amount and Settlement Amount Payer determination date.
	 *
	 */
	ZonedDateTime getValuationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Valuation date offset relative to the Final Observation Date and can be: [Final Observation Date][The first Business Day following the Final Observation Date].
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Valuation date offset relative to the Final Observation Date and can be: [Final Observation Date][The first Business Day following the Final Observation Date].
	 *
	 */
	FxValuationDateOffset getValuationDateOffset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the Settlement Amount will be settled.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the Settlement Amount will be settled.
	 *
	 */
	AdjustableOrAdjustedDate getSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This specifies the numerator of an annualization factor. Frequently this number is equal to the number of rate observations in a year e.g. Daily Observations: 252.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This specifies the numerator of an annualization factor. Frequently this number is equal to the number of rate observations in a year e.g. Daily Observations: 252.
	 *
	 */
	BigDecimal getAnnualizationFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether "Mean Adjustment" is applicable or not in the calculation of the Realized Volatility.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether "Mean Adjustment" is applicable or not in the calculation of the Realized Volatility.
	 *
	 */
	Boolean getMeanAdjustment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Additional Payment means, in respect of an FX Transaction, where such fee is required, and a Transaction Fee Payment Date, the amount, if any, that is specified or otherwise determined as provided in the related Confirmation and, subject to any applicable condition precedent, is payable by one party to the other as further specified or otherwise determined as provided in the related Confirmation on the Transaction Fee Payment Date or on each Transaction Fee Payment Date if more than one is specified, for value on such date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Additional Payment means, in respect of an FX Transaction, where such fee is required, and a Transaction Fee Payment Date, the amount, if any, that is specified or otherwise determined as provided in the related Confirmation and, subject to any applicable condition precedent, is payable by one party to the other as further specified or otherwise determined as provided in the related Confirmation on the Transaction Fee Payment Date or on each Transaction Fee Payment Date if more than one is specified, for value on such date.
	 *
	 */
	List<? extends Payment> getAdditionalPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Settlement currency and fixing details for cash settlement. The FX Volatility and FX Variance Swaps are inherently cash settled, but into the notional currency. The optional cashSettlement block is provided for the case where the Settlement Currency differs from that of the Notional.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Settlement currency and fixing details for cash settlement. The FX Volatility and FX Variance Swaps are inherently cash settled, but into the notional currency. The optional cashSettlement block is provided for the case where the Settlement Currency differs from that of the Notional.
	 *
	 */
	FxCashSettlementSimple getCashSettlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Number of Returns is the number of Observation Dates in the Observation Period, excluding the Initial Observation Date (where the Observation Rate on the Initial Observation Date shall equal S0).
	 *
	 */
	Integer getNumberOfReturns();

	/*********************** Build Methods  ***********************/
	FxPerformanceSwap build();
	
	FxPerformanceSwap.FxPerformanceSwapBuilder toBuilder();
	
	static FxPerformanceSwap.FxPerformanceSwapBuilder builder() {
		return new FxPerformanceSwap.FxPerformanceSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxPerformanceSwap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxPerformanceSwap> getType() {
		return FxPerformanceSwap.class;
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
		processRosetta(path.newSubPath("vegaNotional"), processor, NonNegativeMoney.class, getVegaNotional());
		processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.class, getNotional());
		processRosetta(path.newSubPath("fixedLeg"), processor, FxPerformanceFixedLeg.class, getFixedLeg());
		processRosetta(path.newSubPath("floatingLeg"), processor, FxPerformanceFloatingLeg.class, getFloatingLeg());
		processRosetta(path.newSubPath("fixingInformationSource"), processor, FxSpotRateSource.class, getFixingInformationSource());
		processRosetta(path.newSubPath("fixingSchedule"), processor, FxFixingScheduleSimple.class, getFixingSchedule());
		processor.processBasic(path.newSubPath("valuationDate"), ZonedDateTime.class, getValuationDate(), this);
		processRosetta(path.newSubPath("valuationDateOffset"), processor, FxValuationDateOffset.class, getValuationDateOffset());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedDate.class, getSettlementDate());
		processor.processBasic(path.newSubPath("annualizationFactor"), BigDecimal.class, getAnnualizationFactor(), this);
		processor.processBasic(path.newSubPath("meanAdjustment"), Boolean.class, getMeanAdjustment(), this);
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.class, getCashSettlement());
		processor.processBasic(path.newSubPath("numberOfReturns"), Integer.class, getNumberOfReturns(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxPerformanceSwapBuilder extends FxPerformanceSwap, Product.ProductBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateVegaNotional();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getVegaNotional();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getNotional();
		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder getOrCreateFixedLeg();
		@Override
		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder getFixedLeg();
		FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder getOrCreateFloatingLeg();
		@Override
		FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder getFloatingLeg();
		FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFixingInformationSource();
		@Override
		FxSpotRateSource.FxSpotRateSourceBuilder getFixingInformationSource();
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder getOrCreateFixingSchedule();
		@Override
		FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder getFixingSchedule();
		FxValuationDateOffset.FxValuationDateOffsetBuilder getOrCreateValuationDateOffset();
		@Override
		FxValuationDateOffset.FxValuationDateOffsetBuilder getValuationDateOffset();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateSettlementDate();
		@Override
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getSettlementDate();
		Payment.PaymentBuilder getOrCreateAdditionalPayment(int index);
		@Override
		List<? extends Payment.PaymentBuilder> getAdditionalPayment();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement();
		@Override
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement();
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder setId(String id);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addProductType(ProductType productType);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addProductType(ProductType productType, int idx);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addProductType(List<? extends ProductType> productType);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder setProductType(List<? extends ProductType> productType);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addProductId(ProductId productId);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addProductId(ProductId productId, int idx);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addProductId(List<? extends ProductId> productId);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder setProductId(List<? extends ProductId> productId);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addAssetClass(AssetClass assetClass);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxPerformanceSwap.FxPerformanceSwapBuilder setAssetClass(List<? extends AssetClass> assetClass);
		FxPerformanceSwap.FxPerformanceSwapBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxPerformanceSwap.FxPerformanceSwapBuilder setVegaNotional(NonNegativeMoney vegaNotional);
		FxPerformanceSwap.FxPerformanceSwapBuilder setNotional(NonNegativeMoney notional);
		FxPerformanceSwap.FxPerformanceSwapBuilder setFixedLeg(FxPerformanceFixedLeg fixedLeg);
		FxPerformanceSwap.FxPerformanceSwapBuilder setFloatingLeg(FxPerformanceFloatingLeg floatingLeg);
		FxPerformanceSwap.FxPerformanceSwapBuilder setFixingInformationSource(FxSpotRateSource fixingInformationSource);
		FxPerformanceSwap.FxPerformanceSwapBuilder setFixingSchedule(FxFixingScheduleSimple fixingSchedule);
		FxPerformanceSwap.FxPerformanceSwapBuilder setValuationDate(ZonedDateTime valuationDate);
		FxPerformanceSwap.FxPerformanceSwapBuilder setValuationDateOffset(FxValuationDateOffset valuationDateOffset);
		FxPerformanceSwap.FxPerformanceSwapBuilder setSettlementDate(AdjustableOrAdjustedDate settlementDate);
		FxPerformanceSwap.FxPerformanceSwapBuilder setAnnualizationFactor(BigDecimal annualizationFactor);
		FxPerformanceSwap.FxPerformanceSwapBuilder setMeanAdjustment(Boolean meanAdjustment);
		FxPerformanceSwap.FxPerformanceSwapBuilder addAdditionalPayment(Payment additionalPayment);
		FxPerformanceSwap.FxPerformanceSwapBuilder addAdditionalPayment(Payment additionalPayment, int idx);
		FxPerformanceSwap.FxPerformanceSwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayment);
		FxPerformanceSwap.FxPerformanceSwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayment);
		FxPerformanceSwap.FxPerformanceSwapBuilder setCashSettlement(FxCashSettlementSimple cashSettlement);
		FxPerformanceSwap.FxPerformanceSwapBuilder setNumberOfReturns(Integer numberOfReturns);

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
			processRosetta(path.newSubPath("vegaNotional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getVegaNotional());
			processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNotional());
			processRosetta(path.newSubPath("fixedLeg"), processor, FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder.class, getFixedLeg());
			processRosetta(path.newSubPath("floatingLeg"), processor, FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder.class, getFloatingLeg());
			processRosetta(path.newSubPath("fixingInformationSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getFixingInformationSource());
			processRosetta(path.newSubPath("fixingSchedule"), processor, FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder.class, getFixingSchedule());
			processor.processBasic(path.newSubPath("valuationDate"), ZonedDateTime.class, getValuationDate(), this);
			processRosetta(path.newSubPath("valuationDateOffset"), processor, FxValuationDateOffset.FxValuationDateOffsetBuilder.class, getValuationDateOffset());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder.class, getSettlementDate());
			processor.processBasic(path.newSubPath("annualizationFactor"), BigDecimal.class, getAnnualizationFactor(), this);
			processor.processBasic(path.newSubPath("meanAdjustment"), Boolean.class, getMeanAdjustment(), this);
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.FxCashSettlementSimpleBuilder.class, getCashSettlement());
			processor.processBasic(path.newSubPath("numberOfReturns"), Integer.class, getNumberOfReturns(), this);
		}
		

		FxPerformanceSwap.FxPerformanceSwapBuilder prune();
	}

	/*********************** Immutable Implementation of FxPerformanceSwap  ***********************/
	class FxPerformanceSwapImpl extends Product.ProductImpl implements FxPerformanceSwap {
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final NonNegativeMoney vegaNotional;
		private final NonNegativeMoney notional;
		private final FxPerformanceFixedLeg fixedLeg;
		private final FxPerformanceFloatingLeg floatingLeg;
		private final FxSpotRateSource fixingInformationSource;
		private final FxFixingScheduleSimple fixingSchedule;
		private final ZonedDateTime valuationDate;
		private final FxValuationDateOffset valuationDateOffset;
		private final AdjustableOrAdjustedDate settlementDate;
		private final BigDecimal annualizationFactor;
		private final Boolean meanAdjustment;
		private final List<? extends Payment> additionalPayment;
		private final FxCashSettlementSimple cashSettlement;
		private final Integer numberOfReturns;
		
		protected FxPerformanceSwapImpl(FxPerformanceSwap.FxPerformanceSwapBuilder builder) {
			super(builder);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.vegaNotional = ofNullable(builder.getVegaNotional()).map(f->f.build()).orElse(null);
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.fixedLeg = ofNullable(builder.getFixedLeg()).map(f->f.build()).orElse(null);
			this.floatingLeg = ofNullable(builder.getFloatingLeg()).map(f->f.build()).orElse(null);
			this.fixingInformationSource = ofNullable(builder.getFixingInformationSource()).map(f->f.build()).orElse(null);
			this.fixingSchedule = ofNullable(builder.getFixingSchedule()).map(f->f.build()).orElse(null);
			this.valuationDate = builder.getValuationDate();
			this.valuationDateOffset = ofNullable(builder.getValuationDateOffset()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.annualizationFactor = builder.getAnnualizationFactor();
			this.meanAdjustment = builder.getMeanAdjustment();
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.numberOfReturns = builder.getNumberOfReturns();
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
		@RosettaAttribute("vegaNotional")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("vegaNotional")
		public NonNegativeMoney getVegaNotional() {
			return vegaNotional;
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notional")
		public NonNegativeMoney getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("fixedLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixedLeg")
		public FxPerformanceFixedLeg getFixedLeg() {
			return fixedLeg;
		}
		
		@Override
		@RosettaAttribute("floatingLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("floatingLeg")
		public FxPerformanceFloatingLeg getFloatingLeg() {
			return floatingLeg;
		}
		
		@Override
		@RosettaAttribute("fixingInformationSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingInformationSource")
		public FxSpotRateSource getFixingInformationSource() {
			return fixingInformationSource;
		}
		
		@Override
		@RosettaAttribute("fixingSchedule")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixingSchedule")
		public FxFixingScheduleSimple getFixingSchedule() {
			return fixingSchedule;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public ZonedDateTime getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("valuationDateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDateOffset")
		public FxValuationDateOffset getValuationDateOffset() {
			return valuationDateOffset;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementDate")
		public AdjustableOrAdjustedDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("annualizationFactor")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("annualizationFactor")
		public BigDecimal getAnnualizationFactor() {
			return annualizationFactor;
		}
		
		@Override
		@RosettaAttribute("meanAdjustment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("meanAdjustment")
		public Boolean getMeanAdjustment() {
			return meanAdjustment;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends Payment> getAdditionalPayment() {
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
		@RosettaAttribute("numberOfReturns")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfReturns")
		public Integer getNumberOfReturns() {
			return numberOfReturns;
		}
		
		@Override
		public FxPerformanceSwap build() {
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder toBuilder() {
			FxPerformanceSwap.FxPerformanceSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxPerformanceSwap.FxPerformanceSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getVegaNotional()).ifPresent(builder::setVegaNotional);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getFixedLeg()).ifPresent(builder::setFixedLeg);
			ofNullable(getFloatingLeg()).ifPresent(builder::setFloatingLeg);
			ofNullable(getFixingInformationSource()).ifPresent(builder::setFixingInformationSource);
			ofNullable(getFixingSchedule()).ifPresent(builder::setFixingSchedule);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
			ofNullable(getValuationDateOffset()).ifPresent(builder::setValuationDateOffset);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getAnnualizationFactor()).ifPresent(builder::setAnnualizationFactor);
			ofNullable(getMeanAdjustment()).ifPresent(builder::setMeanAdjustment);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getNumberOfReturns()).ifPresent(builder::setNumberOfReturns);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxPerformanceSwap _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(vegaNotional, _that.getVegaNotional())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(fixedLeg, _that.getFixedLeg())) return false;
			if (!Objects.equals(floatingLeg, _that.getFloatingLeg())) return false;
			if (!Objects.equals(fixingInformationSource, _that.getFixingInformationSource())) return false;
			if (!Objects.equals(fixingSchedule, _that.getFixingSchedule())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationDateOffset, _that.getValuationDateOffset())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(annualizationFactor, _that.getAnnualizationFactor())) return false;
			if (!Objects.equals(meanAdjustment, _that.getMeanAdjustment())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(numberOfReturns, _that.getNumberOfReturns())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (vegaNotional != null ? vegaNotional.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (fixedLeg != null ? fixedLeg.hashCode() : 0);
			_result = 31 * _result + (floatingLeg != null ? floatingLeg.hashCode() : 0);
			_result = 31 * _result + (fixingInformationSource != null ? fixingInformationSource.hashCode() : 0);
			_result = 31 * _result + (fixingSchedule != null ? fixingSchedule.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationDateOffset != null ? valuationDateOffset.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (annualizationFactor != null ? annualizationFactor.hashCode() : 0);
			_result = 31 * _result + (meanAdjustment != null ? meanAdjustment.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (numberOfReturns != null ? numberOfReturns.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPerformanceSwap {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"vegaNotional=" + this.vegaNotional + ", " +
				"notional=" + this.notional + ", " +
				"fixedLeg=" + this.fixedLeg + ", " +
				"floatingLeg=" + this.floatingLeg + ", " +
				"fixingInformationSource=" + this.fixingInformationSource + ", " +
				"fixingSchedule=" + this.fixingSchedule + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationDateOffset=" + this.valuationDateOffset + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"annualizationFactor=" + this.annualizationFactor + ", " +
				"meanAdjustment=" + this.meanAdjustment + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"numberOfReturns=" + this.numberOfReturns +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxPerformanceSwap  ***********************/
	class FxPerformanceSwapBuilderImpl extends Product.ProductBuilderImpl implements FxPerformanceSwap.FxPerformanceSwapBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected NonNegativeMoney.NonNegativeMoneyBuilder vegaNotional;
		protected NonNegativeMoney.NonNegativeMoneyBuilder notional;
		protected FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder fixedLeg;
		protected FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder floatingLeg;
		protected FxSpotRateSource.FxSpotRateSourceBuilder fixingInformationSource;
		protected FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder fixingSchedule;
		protected ZonedDateTime valuationDate;
		protected FxValuationDateOffset.FxValuationDateOffsetBuilder valuationDateOffset;
		protected AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder settlementDate;
		protected BigDecimal annualizationFactor;
		protected Boolean meanAdjustment;
		protected List<Payment.PaymentBuilder> additionalPayment = new ArrayList<>();
		protected FxCashSettlementSimple.FxCashSettlementSimpleBuilder cashSettlement;
		protected Integer numberOfReturns;
		
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
		@RosettaAttribute("vegaNotional")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("vegaNotional")
		public NonNegativeMoney.NonNegativeMoneyBuilder getVegaNotional() {
			return vegaNotional;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateVegaNotional() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (vegaNotional!=null) {
				result = vegaNotional;
			}
			else {
				result = vegaNotional = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notional")
		public NonNegativeMoney.NonNegativeMoneyBuilder getNotional() {
			return notional;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixedLeg")
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder getFixedLeg() {
			return fixedLeg;
		}
		
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder getOrCreateFixedLeg() {
			FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder result;
			if (fixedLeg!=null) {
				result = fixedLeg;
			}
			else {
				result = fixedLeg = FxPerformanceFixedLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("floatingLeg")
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder getFloatingLeg() {
			return floatingLeg;
		}
		
		@Override
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder getOrCreateFloatingLeg() {
			FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder result;
			if (floatingLeg!=null) {
				result = floatingLeg;
			}
			else {
				result = floatingLeg = FxPerformanceFloatingLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingInformationSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingInformationSource")
		public FxSpotRateSource.FxSpotRateSourceBuilder getFixingInformationSource() {
			return fixingInformationSource;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFixingInformationSource() {
			FxSpotRateSource.FxSpotRateSourceBuilder result;
			if (fixingInformationSource!=null) {
				result = fixingInformationSource;
			}
			else {
				result = fixingInformationSource = FxSpotRateSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingSchedule")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixingSchedule")
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder getFixingSchedule() {
			return fixingSchedule;
		}
		
		@Override
		public FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder getOrCreateFixingSchedule() {
			FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder result;
			if (fixingSchedule!=null) {
				result = fixingSchedule;
			}
			else {
				result = fixingSchedule = FxFixingScheduleSimple.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public ZonedDateTime getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("valuationDateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDateOffset")
		public FxValuationDateOffset.FxValuationDateOffsetBuilder getValuationDateOffset() {
			return valuationDateOffset;
		}
		
		@Override
		public FxValuationDateOffset.FxValuationDateOffsetBuilder getOrCreateValuationDateOffset() {
			FxValuationDateOffset.FxValuationDateOffsetBuilder result;
			if (valuationDateOffset!=null) {
				result = valuationDateOffset;
			}
			else {
				result = valuationDateOffset = FxValuationDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementDate")
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateSettlementDate() {
			AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrAdjustedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("annualizationFactor")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("annualizationFactor")
		public BigDecimal getAnnualizationFactor() {
			return annualizationFactor;
		}
		
		@Override
		@RosettaAttribute("meanAdjustment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("meanAdjustment")
		public Boolean getMeanAdjustment() {
			return meanAdjustment;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends Payment.PaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreateAdditionalPayment(int index) {
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			return getIndex(additionalPayment, index, () -> {
						Payment.PaymentBuilder newAdditionalPayment = Payment.builder();
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
		@RosettaAttribute("numberOfReturns")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfReturns")
		public Integer getNumberOfReturns() {
			return numberOfReturns;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxPerformanceSwap.FxPerformanceSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxPerformanceSwap.FxPerformanceSwapBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public FxPerformanceSwap.FxPerformanceSwapBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public FxPerformanceSwap.FxPerformanceSwapBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addProductId(List<? extends ProductId> productIds) {
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
		public FxPerformanceSwap.FxPerformanceSwapBuilder setProductId(List<? extends ProductId> productIds) {
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
		public FxPerformanceSwap.FxPerformanceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxPerformanceSwap.FxPerformanceSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxPerformanceSwap.FxPerformanceSwapBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxPerformanceSwap.FxPerformanceSwapBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxPerformanceSwap.FxPerformanceSwapBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vegaNotional")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("vegaNotional")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setVegaNotional(NonNegativeMoney _vegaNotional) {
			this.vegaNotional = _vegaNotional == null ? null : _vegaNotional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notional")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setNotional(NonNegativeMoney _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fixedLeg")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setFixedLeg(FxPerformanceFixedLeg _fixedLeg) {
			this.fixedLeg = _fixedLeg == null ? null : _fixedLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("floatingLeg")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setFloatingLeg(FxPerformanceFloatingLeg _floatingLeg) {
			this.floatingLeg = _floatingLeg == null ? null : _floatingLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingInformationSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingInformationSource")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setFixingInformationSource(FxSpotRateSource _fixingInformationSource) {
			this.fixingInformationSource = _fixingInformationSource == null ? null : _fixingInformationSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingSchedule")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fixingSchedule")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setFixingSchedule(FxFixingScheduleSimple _fixingSchedule) {
			this.fixingSchedule = _fixingSchedule == null ? null : _fixingSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDate")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setValuationDate(ZonedDateTime _valuationDate) {
			this.valuationDate = _valuationDate == null ? null : _valuationDate;
			return this;
		}
		
		@RosettaAttribute("valuationDateOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDateOffset")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setValuationDateOffset(FxValuationDateOffset _valuationDateOffset) {
			this.valuationDateOffset = _valuationDateOffset == null ? null : _valuationDateOffset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementDate")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setSettlementDate(AdjustableOrAdjustedDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("annualizationFactor")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("annualizationFactor")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setAnnualizationFactor(BigDecimal _annualizationFactor) {
			this.annualizationFactor = _annualizationFactor == null ? null : _annualizationFactor;
			return this;
		}
		
		@RosettaAttribute("meanAdjustment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("meanAdjustment")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setMeanAdjustment(Boolean _meanAdjustment) {
			this.meanAdjustment = _meanAdjustment == null ? null : _meanAdjustment;
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addAdditionalPayment(Payment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addAdditionalPayment(Payment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments != null) {
				for (final Payment toAdd : additionalPayments) {
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
		public FxPerformanceSwap.FxPerformanceSwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
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
		public FxPerformanceSwap.FxPerformanceSwapBuilder setCashSettlement(FxCashSettlementSimple _cashSettlement) {
			this.cashSettlement = _cashSettlement == null ? null : _cashSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("numberOfReturns")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfReturns")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder setNumberOfReturns(Integer _numberOfReturns) {
			this.numberOfReturns = _numberOfReturns == null ? null : _numberOfReturns;
			return this;
		}
		
		@Override
		public FxPerformanceSwap build() {
			return new FxPerformanceSwap.FxPerformanceSwapImpl(this);
		}
		
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder prune() {
			super.prune();
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (vegaNotional!=null && !vegaNotional.prune().hasData()) vegaNotional = null;
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (fixedLeg!=null && !fixedLeg.prune().hasData()) fixedLeg = null;
			if (floatingLeg!=null && !floatingLeg.prune().hasData()) floatingLeg = null;
			if (fixingInformationSource!=null && !fixingInformationSource.prune().hasData()) fixingInformationSource = null;
			if (fixingSchedule!=null && !fixingSchedule.prune().hasData()) fixingSchedule = null;
			if (valuationDateOffset!=null && !valuationDateOffset.prune().hasData()) valuationDateOffset = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getVegaNotional()!=null && getVegaNotional().hasData()) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getFixedLeg()!=null && getFixedLeg().hasData()) return true;
			if (getFloatingLeg()!=null && getFloatingLeg().hasData()) return true;
			if (getFixingInformationSource()!=null && getFixingInformationSource().hasData()) return true;
			if (getFixingSchedule()!=null && getFixingSchedule().hasData()) return true;
			if (getValuationDate()!=null) return true;
			if (getValuationDateOffset()!=null && getValuationDateOffset().hasData()) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getAnnualizationFactor()!=null) return true;
			if (getMeanAdjustment()!=null) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getNumberOfReturns()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPerformanceSwap.FxPerformanceSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxPerformanceSwap.FxPerformanceSwapBuilder o = (FxPerformanceSwap.FxPerformanceSwapBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getVegaNotional(), o.getVegaNotional(), this::setVegaNotional);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getFixedLeg(), o.getFixedLeg(), this::setFixedLeg);
			merger.mergeRosetta(getFloatingLeg(), o.getFloatingLeg(), this::setFloatingLeg);
			merger.mergeRosetta(getFixingInformationSource(), o.getFixingInformationSource(), this::setFixingInformationSource);
			merger.mergeRosetta(getFixingSchedule(), o.getFixingSchedule(), this::setFixingSchedule);
			merger.mergeRosetta(getValuationDateOffset(), o.getValuationDateOffset(), this::setValuationDateOffset);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			
			merger.mergeBasic(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			merger.mergeBasic(getAnnualizationFactor(), o.getAnnualizationFactor(), this::setAnnualizationFactor);
			merger.mergeBasic(getMeanAdjustment(), o.getMeanAdjustment(), this::setMeanAdjustment);
			merger.mergeBasic(getNumberOfReturns(), o.getNumberOfReturns(), this::setNumberOfReturns);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxPerformanceSwap _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(vegaNotional, _that.getVegaNotional())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(fixedLeg, _that.getFixedLeg())) return false;
			if (!Objects.equals(floatingLeg, _that.getFloatingLeg())) return false;
			if (!Objects.equals(fixingInformationSource, _that.getFixingInformationSource())) return false;
			if (!Objects.equals(fixingSchedule, _that.getFixingSchedule())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationDateOffset, _that.getValuationDateOffset())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(annualizationFactor, _that.getAnnualizationFactor())) return false;
			if (!Objects.equals(meanAdjustment, _that.getMeanAdjustment())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(numberOfReturns, _that.getNumberOfReturns())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (vegaNotional != null ? vegaNotional.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (fixedLeg != null ? fixedLeg.hashCode() : 0);
			_result = 31 * _result + (floatingLeg != null ? floatingLeg.hashCode() : 0);
			_result = 31 * _result + (fixingInformationSource != null ? fixingInformationSource.hashCode() : 0);
			_result = 31 * _result + (fixingSchedule != null ? fixingSchedule.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationDateOffset != null ? valuationDateOffset.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (annualizationFactor != null ? annualizationFactor.hashCode() : 0);
			_result = 31 * _result + (meanAdjustment != null ? meanAdjustment.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (numberOfReturns != null ? numberOfReturns.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPerformanceSwapBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"vegaNotional=" + this.vegaNotional + ", " +
				"notional=" + this.notional + ", " +
				"fixedLeg=" + this.fixedLeg + ", " +
				"floatingLeg=" + this.floatingLeg + ", " +
				"fixingInformationSource=" + this.fixingInformationSource + ", " +
				"fixingSchedule=" + this.fixingSchedule + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationDateOffset=" + this.valuationDateOffset + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"annualizationFactor=" + this.annualizationFactor + ", " +
				"meanAdjustment=" + this.meanAdjustment + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"numberOfReturns=" + this.numberOfReturns +
			'}' + " " + super.toString();
		}
	}
}

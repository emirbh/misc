package fpml.consolidated.accumulator;

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
import fpml.consolidated.accumulator.meta.EquityAccumulatorMeta;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eqd.PrePayment;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.SettlementPriceSource;
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
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="EquityAccumulator", builder=EquityAccumulator.EquityAccumulatorBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityAccumulator", model="fpml", builder=EquityAccumulator.EquityAccumulatorBuilderImpl.class, version="2.1.1")
public interface EquityAccumulator extends Product {

	EquityAccumulatorMeta metaData = new EquityAccumulatorMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision The notional amount
	 *
	 */
	NonNegativeMoney getNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the underlying component, which can be either one security or a basket.
	 *
	 */
	Underlyer getUnderlyer();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The price the shares will be accumulated at.
	 *
	 */
	NonNegativeMoney getForwardPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The current price of the stock
	 *
	 */
	NonNegativeMoney getSpotPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of shares to be purchased per day
	 *
	 */
	BigDecimal getNumberOfSharesPerDay();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Maximum number of trading days
	 *
	 */
	Integer getMaxNoOfTradingDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Leverage or Gearing. Optional condition where if shares fall below trigger price, number of shares purchased increase by the gearing factor.
	 *
	 */
	Gearing getGearing();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision End date of guaranteed period. If knock out is triggered within guaranteed period, guaranteed number of shares will be delivered.
	 *
	 */
	ZonedDateTime getGuaranteedPeriodEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Period when accumulator will accumulate shares
	 *
	 */
	List<? extends ObservationPeriod> getObservationPeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Expiration date of accumulator.
	 *
	 */
	EquityForwardExpiration getExpiration();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A payment made in advance for the purchase of the shares.
	 *
	 */
	PrePayment getPrePayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision How the accululator will be settled.
	 *
	 */
	SettlementTypeEnum getSettlementType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which a cash settlement for non-deliverable forward and non-deliverable options.
	 *
	 */
	Currency getSettlementCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The source from which the settlement price is to be obtained, e.g. a Reuters page, Prezzo di Riferimento, etc.
	 *
	 */
	SettlementPriceSource getSettlementPriceSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Termination of contract prior to maturity date as a result of stock price exceeding specified level or performance reaching target performance.
	 *
	 */
	AccumulatorKnockOut getKnockOut();

	/*********************** Build Methods  ***********************/
	EquityAccumulator build();
	
	EquityAccumulator.EquityAccumulatorBuilder toBuilder();
	
	static EquityAccumulator.EquityAccumulatorBuilder builder() {
		return new EquityAccumulator.EquityAccumulatorBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityAccumulator> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityAccumulator> getType() {
		return EquityAccumulator.class;
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
		processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.class, getNotional());
		processRosetta(path.newSubPath("underlyer"), processor, Underlyer.class, getUnderlyer());
		processRosetta(path.newSubPath("forwardPrice"), processor, NonNegativeMoney.class, getForwardPrice());
		processRosetta(path.newSubPath("spotPrice"), processor, NonNegativeMoney.class, getSpotPrice());
		processor.processBasic(path.newSubPath("numberOfSharesPerDay"), BigDecimal.class, getNumberOfSharesPerDay(), this);
		processor.processBasic(path.newSubPath("maxNoOfTradingDays"), Integer.class, getMaxNoOfTradingDays(), this);
		processRosetta(path.newSubPath("gearing"), processor, Gearing.class, getGearing());
		processor.processBasic(path.newSubPath("guaranteedPeriodEndDate"), ZonedDateTime.class, getGuaranteedPeriodEndDate(), this);
		processRosetta(path.newSubPath("observationPeriod"), processor, ObservationPeriod.class, getObservationPeriod());
		processRosetta(path.newSubPath("expiration"), processor, EquityForwardExpiration.class, getExpiration());
		processRosetta(path.newSubPath("prePayment"), processor, PrePayment.class, getPrePayment());
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("settlementPriceSource"), processor, SettlementPriceSource.class, getSettlementPriceSource());
		processRosetta(path.newSubPath("knockOut"), processor, AccumulatorKnockOut.class, getKnockOut());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityAccumulatorBuilder extends EquityAccumulator, Product.ProductBuilder {
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
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getNotional();
		Underlyer.UnderlyerBuilder getOrCreateUnderlyer();
		@Override
		Underlyer.UnderlyerBuilder getUnderlyer();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateForwardPrice();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getForwardPrice();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateSpotPrice();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getSpotPrice();
		Gearing.GearingBuilder getOrCreateGearing();
		@Override
		Gearing.GearingBuilder getGearing();
		ObservationPeriod.ObservationPeriodBuilder getOrCreateObservationPeriod(int index);
		@Override
		List<? extends ObservationPeriod.ObservationPeriodBuilder> getObservationPeriod();
		EquityForwardExpiration.EquityForwardExpirationBuilder getOrCreateExpiration();
		@Override
		EquityForwardExpiration.EquityForwardExpirationBuilder getExpiration();
		PrePayment.PrePaymentBuilder getOrCreatePrePayment();
		@Override
		PrePayment.PrePaymentBuilder getPrePayment();
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		@Override
		Currency.CurrencyBuilder getSettlementCurrency();
		SettlementPriceSource.SettlementPriceSourceBuilder getOrCreateSettlementPriceSource();
		@Override
		SettlementPriceSource.SettlementPriceSourceBuilder getSettlementPriceSource();
		AccumulatorKnockOut.AccumulatorKnockOutBuilder getOrCreateKnockOut();
		@Override
		AccumulatorKnockOut.AccumulatorKnockOutBuilder getKnockOut();
		@Override
		EquityAccumulator.EquityAccumulatorBuilder setId(String id);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addProductType(ProductType productType);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addProductType(ProductType productType, int idx);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addProductType(List<? extends ProductType> productType);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder setProductType(List<? extends ProductType> productType);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addProductId(ProductId productId);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addProductId(ProductId productId, int idx);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addProductId(List<? extends ProductId> productId);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder setProductId(List<? extends ProductId> productId);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addAssetClass(AssetClass assetClass);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		EquityAccumulator.EquityAccumulatorBuilder setAssetClass(List<? extends AssetClass> assetClass);
		EquityAccumulator.EquityAccumulatorBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		EquityAccumulator.EquityAccumulatorBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		EquityAccumulator.EquityAccumulatorBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		EquityAccumulator.EquityAccumulatorBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		EquityAccumulator.EquityAccumulatorBuilder setNotional(NonNegativeMoney notional);
		EquityAccumulator.EquityAccumulatorBuilder setUnderlyer(Underlyer underlyer);
		EquityAccumulator.EquityAccumulatorBuilder setForwardPrice(NonNegativeMoney forwardPrice);
		EquityAccumulator.EquityAccumulatorBuilder setSpotPrice(NonNegativeMoney spotPrice);
		EquityAccumulator.EquityAccumulatorBuilder setNumberOfSharesPerDay(BigDecimal numberOfSharesPerDay);
		EquityAccumulator.EquityAccumulatorBuilder setMaxNoOfTradingDays(Integer maxNoOfTradingDays);
		EquityAccumulator.EquityAccumulatorBuilder setGearing(Gearing gearing);
		EquityAccumulator.EquityAccumulatorBuilder setGuaranteedPeriodEndDate(ZonedDateTime guaranteedPeriodEndDate);
		EquityAccumulator.EquityAccumulatorBuilder addObservationPeriod(ObservationPeriod observationPeriod);
		EquityAccumulator.EquityAccumulatorBuilder addObservationPeriod(ObservationPeriod observationPeriod, int idx);
		EquityAccumulator.EquityAccumulatorBuilder addObservationPeriod(List<? extends ObservationPeriod> observationPeriod);
		EquityAccumulator.EquityAccumulatorBuilder setObservationPeriod(List<? extends ObservationPeriod> observationPeriod);
		EquityAccumulator.EquityAccumulatorBuilder setExpiration(EquityForwardExpiration expiration);
		EquityAccumulator.EquityAccumulatorBuilder setPrePayment(PrePayment prePayment);
		EquityAccumulator.EquityAccumulatorBuilder setSettlementType(SettlementTypeEnum settlementType);
		EquityAccumulator.EquityAccumulatorBuilder setSettlementCurrency(Currency settlementCurrency);
		EquityAccumulator.EquityAccumulatorBuilder setSettlementPriceSource(SettlementPriceSource settlementPriceSource);
		EquityAccumulator.EquityAccumulatorBuilder setKnockOut(AccumulatorKnockOut knockOut);

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
			processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNotional());
			processRosetta(path.newSubPath("underlyer"), processor, Underlyer.UnderlyerBuilder.class, getUnderlyer());
			processRosetta(path.newSubPath("forwardPrice"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getForwardPrice());
			processRosetta(path.newSubPath("spotPrice"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getSpotPrice());
			processor.processBasic(path.newSubPath("numberOfSharesPerDay"), BigDecimal.class, getNumberOfSharesPerDay(), this);
			processor.processBasic(path.newSubPath("maxNoOfTradingDays"), Integer.class, getMaxNoOfTradingDays(), this);
			processRosetta(path.newSubPath("gearing"), processor, Gearing.GearingBuilder.class, getGearing());
			processor.processBasic(path.newSubPath("guaranteedPeriodEndDate"), ZonedDateTime.class, getGuaranteedPeriodEndDate(), this);
			processRosetta(path.newSubPath("observationPeriod"), processor, ObservationPeriod.ObservationPeriodBuilder.class, getObservationPeriod());
			processRosetta(path.newSubPath("expiration"), processor, EquityForwardExpiration.EquityForwardExpirationBuilder.class, getExpiration());
			processRosetta(path.newSubPath("prePayment"), processor, PrePayment.PrePaymentBuilder.class, getPrePayment());
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("settlementPriceSource"), processor, SettlementPriceSource.SettlementPriceSourceBuilder.class, getSettlementPriceSource());
			processRosetta(path.newSubPath("knockOut"), processor, AccumulatorKnockOut.AccumulatorKnockOutBuilder.class, getKnockOut());
		}
		

		EquityAccumulator.EquityAccumulatorBuilder prune();
	}

	/*********************** Immutable Implementation of EquityAccumulator  ***********************/
	class EquityAccumulatorImpl extends Product.ProductImpl implements EquityAccumulator {
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final NonNegativeMoney notional;
		private final Underlyer underlyer;
		private final NonNegativeMoney forwardPrice;
		private final NonNegativeMoney spotPrice;
		private final BigDecimal numberOfSharesPerDay;
		private final Integer maxNoOfTradingDays;
		private final Gearing gearing;
		private final ZonedDateTime guaranteedPeriodEndDate;
		private final List<? extends ObservationPeriod> observationPeriod;
		private final EquityForwardExpiration expiration;
		private final PrePayment prePayment;
		private final SettlementTypeEnum settlementType;
		private final Currency settlementCurrency;
		private final SettlementPriceSource settlementPriceSource;
		private final AccumulatorKnockOut knockOut;
		
		protected EquityAccumulatorImpl(EquityAccumulator.EquityAccumulatorBuilder builder) {
			super(builder);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
			this.forwardPrice = ofNullable(builder.getForwardPrice()).map(f->f.build()).orElse(null);
			this.spotPrice = ofNullable(builder.getSpotPrice()).map(f->f.build()).orElse(null);
			this.numberOfSharesPerDay = builder.getNumberOfSharesPerDay();
			this.maxNoOfTradingDays = builder.getMaxNoOfTradingDays();
			this.gearing = ofNullable(builder.getGearing()).map(f->f.build()).orElse(null);
			this.guaranteedPeriodEndDate = builder.getGuaranteedPeriodEndDate();
			this.observationPeriod = ofNullable(builder.getObservationPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.expiration = ofNullable(builder.getExpiration()).map(f->f.build()).orElse(null);
			this.prePayment = ofNullable(builder.getPrePayment()).map(f->f.build()).orElse(null);
			this.settlementType = builder.getSettlementType();
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.settlementPriceSource = ofNullable(builder.getSettlementPriceSource()).map(f->f.build()).orElse(null);
			this.knockOut = ofNullable(builder.getKnockOut()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notional")
		public NonNegativeMoney getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("underlyer")
		public Underlyer getUnderlyer() {
			return underlyer;
		}
		
		@Override
		@RosettaAttribute("forwardPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forwardPrice")
		public NonNegativeMoney getForwardPrice() {
			return forwardPrice;
		}
		
		@Override
		@RosettaAttribute("spotPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotPrice")
		public NonNegativeMoney getSpotPrice() {
			return spotPrice;
		}
		
		@Override
		@RosettaAttribute("numberOfSharesPerDay")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberOfSharesPerDay")
		public BigDecimal getNumberOfSharesPerDay() {
			return numberOfSharesPerDay;
		}
		
		@Override
		@RosettaAttribute("maxNoOfTradingDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maxNoOfTradingDays")
		public Integer getMaxNoOfTradingDays() {
			return maxNoOfTradingDays;
		}
		
		@Override
		@RosettaAttribute("gearing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("gearing")
		public Gearing getGearing() {
			return gearing;
		}
		
		@Override
		@RosettaAttribute("guaranteedPeriodEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("guaranteedPeriodEndDate")
		public ZonedDateTime getGuaranteedPeriodEndDate() {
			return guaranteedPeriodEndDate;
		}
		
		@Override
		@RosettaAttribute("observationPeriod")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("observationPeriod")
		public List<? extends ObservationPeriod> getObservationPeriod() {
			return observationPeriod;
		}
		
		@Override
		@RosettaAttribute("expiration")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expiration")
		public EquityForwardExpiration getExpiration() {
			return expiration;
		}
		
		@Override
		@RosettaAttribute("prePayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prePayment")
		public PrePayment getPrePayment() {
			return prePayment;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("settlementPriceSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPriceSource")
		public SettlementPriceSource getSettlementPriceSource() {
			return settlementPriceSource;
		}
		
		@Override
		@RosettaAttribute("knockOut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knockOut")
		public AccumulatorKnockOut getKnockOut() {
			return knockOut;
		}
		
		@Override
		public EquityAccumulator build() {
			return this;
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder toBuilder() {
			EquityAccumulator.EquityAccumulatorBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityAccumulator.EquityAccumulatorBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
			ofNullable(getForwardPrice()).ifPresent(builder::setForwardPrice);
			ofNullable(getSpotPrice()).ifPresent(builder::setSpotPrice);
			ofNullable(getNumberOfSharesPerDay()).ifPresent(builder::setNumberOfSharesPerDay);
			ofNullable(getMaxNoOfTradingDays()).ifPresent(builder::setMaxNoOfTradingDays);
			ofNullable(getGearing()).ifPresent(builder::setGearing);
			ofNullable(getGuaranteedPeriodEndDate()).ifPresent(builder::setGuaranteedPeriodEndDate);
			ofNullable(getObservationPeriod()).ifPresent(builder::setObservationPeriod);
			ofNullable(getExpiration()).ifPresent(builder::setExpiration);
			ofNullable(getPrePayment()).ifPresent(builder::setPrePayment);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getSettlementPriceSource()).ifPresent(builder::setSettlementPriceSource);
			ofNullable(getKnockOut()).ifPresent(builder::setKnockOut);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityAccumulator _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(forwardPrice, _that.getForwardPrice())) return false;
			if (!Objects.equals(spotPrice, _that.getSpotPrice())) return false;
			if (!Objects.equals(numberOfSharesPerDay, _that.getNumberOfSharesPerDay())) return false;
			if (!Objects.equals(maxNoOfTradingDays, _that.getMaxNoOfTradingDays())) return false;
			if (!Objects.equals(gearing, _that.getGearing())) return false;
			if (!Objects.equals(guaranteedPeriodEndDate, _that.getGuaranteedPeriodEndDate())) return false;
			if (!ListEquals.listEquals(observationPeriod, _that.getObservationPeriod())) return false;
			if (!Objects.equals(expiration, _that.getExpiration())) return false;
			if (!Objects.equals(prePayment, _that.getPrePayment())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementPriceSource, _that.getSettlementPriceSource())) return false;
			if (!Objects.equals(knockOut, _that.getKnockOut())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (forwardPrice != null ? forwardPrice.hashCode() : 0);
			_result = 31 * _result + (spotPrice != null ? spotPrice.hashCode() : 0);
			_result = 31 * _result + (numberOfSharesPerDay != null ? numberOfSharesPerDay.hashCode() : 0);
			_result = 31 * _result + (maxNoOfTradingDays != null ? maxNoOfTradingDays.hashCode() : 0);
			_result = 31 * _result + (gearing != null ? gearing.hashCode() : 0);
			_result = 31 * _result + (guaranteedPeriodEndDate != null ? guaranteedPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (observationPeriod != null ? observationPeriod.hashCode() : 0);
			_result = 31 * _result + (expiration != null ? expiration.hashCode() : 0);
			_result = 31 * _result + (prePayment != null ? prePayment.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementPriceSource != null ? settlementPriceSource.hashCode() : 0);
			_result = 31 * _result + (knockOut != null ? knockOut.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityAccumulator {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"notional=" + this.notional + ", " +
				"underlyer=" + this.underlyer + ", " +
				"forwardPrice=" + this.forwardPrice + ", " +
				"spotPrice=" + this.spotPrice + ", " +
				"numberOfSharesPerDay=" + this.numberOfSharesPerDay + ", " +
				"maxNoOfTradingDays=" + this.maxNoOfTradingDays + ", " +
				"gearing=" + this.gearing + ", " +
				"guaranteedPeriodEndDate=" + this.guaranteedPeriodEndDate + ", " +
				"observationPeriod=" + this.observationPeriod + ", " +
				"expiration=" + this.expiration + ", " +
				"prePayment=" + this.prePayment + ", " +
				"settlementType=" + this.settlementType + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementPriceSource=" + this.settlementPriceSource + ", " +
				"knockOut=" + this.knockOut +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityAccumulator  ***********************/
	class EquityAccumulatorBuilderImpl extends Product.ProductBuilderImpl implements EquityAccumulator.EquityAccumulatorBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected NonNegativeMoney.NonNegativeMoneyBuilder notional;
		protected Underlyer.UnderlyerBuilder underlyer;
		protected NonNegativeMoney.NonNegativeMoneyBuilder forwardPrice;
		protected NonNegativeMoney.NonNegativeMoneyBuilder spotPrice;
		protected BigDecimal numberOfSharesPerDay;
		protected Integer maxNoOfTradingDays;
		protected Gearing.GearingBuilder gearing;
		protected ZonedDateTime guaranteedPeriodEndDate;
		protected List<ObservationPeriod.ObservationPeriodBuilder> observationPeriod = new ArrayList<>();
		protected EquityForwardExpiration.EquityForwardExpirationBuilder expiration;
		protected PrePayment.PrePaymentBuilder prePayment;
		protected SettlementTypeEnum settlementType;
		protected Currency.CurrencyBuilder settlementCurrency;
		protected SettlementPriceSource.SettlementPriceSourceBuilder settlementPriceSource;
		protected AccumulatorKnockOut.AccumulatorKnockOutBuilder knockOut;
		
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
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("underlyer")
		public Underlyer.UnderlyerBuilder getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public Underlyer.UnderlyerBuilder getOrCreateUnderlyer() {
			Underlyer.UnderlyerBuilder result;
			if (underlyer!=null) {
				result = underlyer;
			}
			else {
				result = underlyer = Underlyer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("forwardPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forwardPrice")
		public NonNegativeMoney.NonNegativeMoneyBuilder getForwardPrice() {
			return forwardPrice;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateForwardPrice() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (forwardPrice!=null) {
				result = forwardPrice;
			}
			else {
				result = forwardPrice = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotPrice")
		public NonNegativeMoney.NonNegativeMoneyBuilder getSpotPrice() {
			return spotPrice;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateSpotPrice() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (spotPrice!=null) {
				result = spotPrice;
			}
			else {
				result = spotPrice = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfSharesPerDay")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberOfSharesPerDay")
		public BigDecimal getNumberOfSharesPerDay() {
			return numberOfSharesPerDay;
		}
		
		@Override
		@RosettaAttribute("maxNoOfTradingDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maxNoOfTradingDays")
		public Integer getMaxNoOfTradingDays() {
			return maxNoOfTradingDays;
		}
		
		@Override
		@RosettaAttribute("gearing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("gearing")
		public Gearing.GearingBuilder getGearing() {
			return gearing;
		}
		
		@Override
		public Gearing.GearingBuilder getOrCreateGearing() {
			Gearing.GearingBuilder result;
			if (gearing!=null) {
				result = gearing;
			}
			else {
				result = gearing = Gearing.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("guaranteedPeriodEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("guaranteedPeriodEndDate")
		public ZonedDateTime getGuaranteedPeriodEndDate() {
			return guaranteedPeriodEndDate;
		}
		
		@Override
		@RosettaAttribute("observationPeriod")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("observationPeriod")
		public List<? extends ObservationPeriod.ObservationPeriodBuilder> getObservationPeriod() {
			return observationPeriod;
		}
		
		@Override
		public ObservationPeriod.ObservationPeriodBuilder getOrCreateObservationPeriod(int index) {
			if (observationPeriod==null) {
				this.observationPeriod = new ArrayList<>();
			}
			return getIndex(observationPeriod, index, () -> {
						ObservationPeriod.ObservationPeriodBuilder newObservationPeriod = ObservationPeriod.builder();
						return newObservationPeriod;
					});
		}
		
		@Override
		@RosettaAttribute("expiration")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expiration")
		public EquityForwardExpiration.EquityForwardExpirationBuilder getExpiration() {
			return expiration;
		}
		
		@Override
		public EquityForwardExpiration.EquityForwardExpirationBuilder getOrCreateExpiration() {
			EquityForwardExpiration.EquityForwardExpirationBuilder result;
			if (expiration!=null) {
				result = expiration;
			}
			else {
				result = expiration = EquityForwardExpiration.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("prePayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prePayment")
		public PrePayment.PrePaymentBuilder getPrePayment() {
			return prePayment;
		}
		
		@Override
		public PrePayment.PrePaymentBuilder getOrCreatePrePayment() {
			PrePayment.PrePaymentBuilder result;
			if (prePayment!=null) {
				result = prePayment;
			}
			else {
				result = prePayment = PrePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public Currency.CurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPriceSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPriceSource")
		public SettlementPriceSource.SettlementPriceSourceBuilder getSettlementPriceSource() {
			return settlementPriceSource;
		}
		
		@Override
		public SettlementPriceSource.SettlementPriceSourceBuilder getOrCreateSettlementPriceSource() {
			SettlementPriceSource.SettlementPriceSourceBuilder result;
			if (settlementPriceSource!=null) {
				result = settlementPriceSource;
			}
			else {
				result = settlementPriceSource = SettlementPriceSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("knockOut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knockOut")
		public AccumulatorKnockOut.AccumulatorKnockOutBuilder getKnockOut() {
			return knockOut;
		}
		
		@Override
		public AccumulatorKnockOut.AccumulatorKnockOutBuilder getOrCreateKnockOut() {
			AccumulatorKnockOut.AccumulatorKnockOutBuilder result;
			if (knockOut!=null) {
				result = knockOut;
			}
			else {
				result = knockOut = AccumulatorKnockOut.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquityAccumulator.EquityAccumulatorBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquityAccumulator.EquityAccumulatorBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public EquityAccumulator.EquityAccumulatorBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public EquityAccumulator.EquityAccumulatorBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addProductId(List<? extends ProductId> productIds) {
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
		public EquityAccumulator.EquityAccumulatorBuilder setProductId(List<? extends ProductId> productIds) {
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
		public EquityAccumulator.EquityAccumulatorBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquityAccumulator.EquityAccumulatorBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquityAccumulator.EquityAccumulatorBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public EquityAccumulator.EquityAccumulatorBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public EquityAccumulator.EquityAccumulatorBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notional")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setNotional(NonNegativeMoney _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyer")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("forwardPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forwardPrice")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setForwardPrice(NonNegativeMoney _forwardPrice) {
			this.forwardPrice = _forwardPrice == null ? null : _forwardPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotPrice")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setSpotPrice(NonNegativeMoney _spotPrice) {
			this.spotPrice = _spotPrice == null ? null : _spotPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("numberOfSharesPerDay")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("numberOfSharesPerDay")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setNumberOfSharesPerDay(BigDecimal _numberOfSharesPerDay) {
			this.numberOfSharesPerDay = _numberOfSharesPerDay == null ? null : _numberOfSharesPerDay;
			return this;
		}
		
		@RosettaAttribute("maxNoOfTradingDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maxNoOfTradingDays")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setMaxNoOfTradingDays(Integer _maxNoOfTradingDays) {
			this.maxNoOfTradingDays = _maxNoOfTradingDays == null ? null : _maxNoOfTradingDays;
			return this;
		}
		
		@RosettaAttribute("gearing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("gearing")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setGearing(Gearing _gearing) {
			this.gearing = _gearing == null ? null : _gearing.toBuilder();
			return this;
		}
		
		@RosettaAttribute("guaranteedPeriodEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("guaranteedPeriodEndDate")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setGuaranteedPeriodEndDate(ZonedDateTime _guaranteedPeriodEndDate) {
			this.guaranteedPeriodEndDate = _guaranteedPeriodEndDate == null ? null : _guaranteedPeriodEndDate;
			return this;
		}
		
		@RosettaAttribute("observationPeriod")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("observationPeriod")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addObservationPeriod(ObservationPeriod _observationPeriod) {
			if (_observationPeriod != null) {
				this.observationPeriod.add(_observationPeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addObservationPeriod(ObservationPeriod _observationPeriod, int idx) {
			getIndex(this.observationPeriod, idx, () -> _observationPeriod.toBuilder());
			return this;
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder addObservationPeriod(List<? extends ObservationPeriod> observationPeriods) {
			if (observationPeriods != null) {
				for (final ObservationPeriod toAdd : observationPeriods) {
					this.observationPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("observationPeriod")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("observationPeriod")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setObservationPeriod(List<? extends ObservationPeriod> observationPeriods) {
			if (observationPeriods == null) {
				this.observationPeriod = new ArrayList<>();
			} else {
				this.observationPeriod = observationPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("expiration")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expiration")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setExpiration(EquityForwardExpiration _expiration) {
			this.expiration = _expiration == null ? null : _expiration.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prePayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prePayment")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setPrePayment(PrePayment _prePayment) {
			this.prePayment = _prePayment == null ? null : _prePayment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementType")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPriceSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementPriceSource")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setSettlementPriceSource(SettlementPriceSource _settlementPriceSource) {
			this.settlementPriceSource = _settlementPriceSource == null ? null : _settlementPriceSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("knockOut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("knockOut")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder setKnockOut(AccumulatorKnockOut _knockOut) {
			this.knockOut = _knockOut == null ? null : _knockOut.toBuilder();
			return this;
		}
		
		@Override
		public EquityAccumulator build() {
			return new EquityAccumulator.EquityAccumulatorImpl(this);
		}
		
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder prune() {
			super.prune();
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			if (forwardPrice!=null && !forwardPrice.prune().hasData()) forwardPrice = null;
			if (spotPrice!=null && !spotPrice.prune().hasData()) spotPrice = null;
			if (gearing!=null && !gearing.prune().hasData()) gearing = null;
			observationPeriod = observationPeriod.stream().filter(b->b!=null).<ObservationPeriod.ObservationPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (expiration!=null && !expiration.prune().hasData()) expiration = null;
			if (prePayment!=null && !prePayment.prune().hasData()) prePayment = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (settlementPriceSource!=null && !settlementPriceSource.prune().hasData()) settlementPriceSource = null;
			if (knockOut!=null && !knockOut.prune().hasData()) knockOut = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			if (getForwardPrice()!=null && getForwardPrice().hasData()) return true;
			if (getSpotPrice()!=null && getSpotPrice().hasData()) return true;
			if (getNumberOfSharesPerDay()!=null) return true;
			if (getMaxNoOfTradingDays()!=null) return true;
			if (getGearing()!=null && getGearing().hasData()) return true;
			if (getGuaranteedPeriodEndDate()!=null) return true;
			if (getObservationPeriod()!=null && getObservationPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExpiration()!=null && getExpiration().hasData()) return true;
			if (getPrePayment()!=null && getPrePayment().hasData()) return true;
			if (getSettlementType()!=null) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getSettlementPriceSource()!=null && getSettlementPriceSource().hasData()) return true;
			if (getKnockOut()!=null && getKnockOut().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityAccumulator.EquityAccumulatorBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EquityAccumulator.EquityAccumulatorBuilder o = (EquityAccumulator.EquityAccumulatorBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			merger.mergeRosetta(getForwardPrice(), o.getForwardPrice(), this::setForwardPrice);
			merger.mergeRosetta(getSpotPrice(), o.getSpotPrice(), this::setSpotPrice);
			merger.mergeRosetta(getGearing(), o.getGearing(), this::setGearing);
			merger.mergeRosetta(getObservationPeriod(), o.getObservationPeriod(), this::getOrCreateObservationPeriod);
			merger.mergeRosetta(getExpiration(), o.getExpiration(), this::setExpiration);
			merger.mergeRosetta(getPrePayment(), o.getPrePayment(), this::setPrePayment);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getSettlementPriceSource(), o.getSettlementPriceSource(), this::setSettlementPriceSource);
			merger.mergeRosetta(getKnockOut(), o.getKnockOut(), this::setKnockOut);
			
			merger.mergeBasic(getNumberOfSharesPerDay(), o.getNumberOfSharesPerDay(), this::setNumberOfSharesPerDay);
			merger.mergeBasic(getMaxNoOfTradingDays(), o.getMaxNoOfTradingDays(), this::setMaxNoOfTradingDays);
			merger.mergeBasic(getGuaranteedPeriodEndDate(), o.getGuaranteedPeriodEndDate(), this::setGuaranteedPeriodEndDate);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityAccumulator _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(forwardPrice, _that.getForwardPrice())) return false;
			if (!Objects.equals(spotPrice, _that.getSpotPrice())) return false;
			if (!Objects.equals(numberOfSharesPerDay, _that.getNumberOfSharesPerDay())) return false;
			if (!Objects.equals(maxNoOfTradingDays, _that.getMaxNoOfTradingDays())) return false;
			if (!Objects.equals(gearing, _that.getGearing())) return false;
			if (!Objects.equals(guaranteedPeriodEndDate, _that.getGuaranteedPeriodEndDate())) return false;
			if (!ListEquals.listEquals(observationPeriod, _that.getObservationPeriod())) return false;
			if (!Objects.equals(expiration, _that.getExpiration())) return false;
			if (!Objects.equals(prePayment, _that.getPrePayment())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementPriceSource, _that.getSettlementPriceSource())) return false;
			if (!Objects.equals(knockOut, _that.getKnockOut())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (forwardPrice != null ? forwardPrice.hashCode() : 0);
			_result = 31 * _result + (spotPrice != null ? spotPrice.hashCode() : 0);
			_result = 31 * _result + (numberOfSharesPerDay != null ? numberOfSharesPerDay.hashCode() : 0);
			_result = 31 * _result + (maxNoOfTradingDays != null ? maxNoOfTradingDays.hashCode() : 0);
			_result = 31 * _result + (gearing != null ? gearing.hashCode() : 0);
			_result = 31 * _result + (guaranteedPeriodEndDate != null ? guaranteedPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (observationPeriod != null ? observationPeriod.hashCode() : 0);
			_result = 31 * _result + (expiration != null ? expiration.hashCode() : 0);
			_result = 31 * _result + (prePayment != null ? prePayment.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementPriceSource != null ? settlementPriceSource.hashCode() : 0);
			_result = 31 * _result + (knockOut != null ? knockOut.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityAccumulatorBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"notional=" + this.notional + ", " +
				"underlyer=" + this.underlyer + ", " +
				"forwardPrice=" + this.forwardPrice + ", " +
				"spotPrice=" + this.spotPrice + ", " +
				"numberOfSharesPerDay=" + this.numberOfSharesPerDay + ", " +
				"maxNoOfTradingDays=" + this.maxNoOfTradingDays + ", " +
				"gearing=" + this.gearing + ", " +
				"guaranteedPeriodEndDate=" + this.guaranteedPeriodEndDate + ", " +
				"observationPeriod=" + this.observationPeriod + ", " +
				"expiration=" + this.expiration + ", " +
				"prePayment=" + this.prePayment + ", " +
				"settlementType=" + this.settlementType + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementPriceSource=" + this.settlementPriceSource + ", " +
				"knockOut=" + this.knockOut +
			'}' + " " + super.toString();
		}
	}
}

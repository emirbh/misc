package fpml.consolidated.eqd;

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
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.EquityPremium;
import fpml.consolidated.eq.shared.EquityStrike;
import fpml.consolidated.eq.shared.ExtraordinaryEvents;
import fpml.consolidated.eq.shared.OptionFeatures;
import fpml.consolidated.eqd.meta.EquityOptionTransactionSupplementMeta;
import fpml.consolidated.fpmlenum.EquityOptionTypeEnum;
import fpml.consolidated.fpmlenum.MethodOfAdjustmentEnum;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.option.shared.StrategyFeature;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
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
 * Provision A type for defining equity option transaction supplements.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining equity option transaction supplements.
 *
 */
@RosettaDataType(value="EquityOptionTransactionSupplement", builder=EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityOptionTransactionSupplement", model="fpml", builder=EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilderImpl.class, version="2.1.1")
public interface EquityOptionTransactionSupplement extends EquityDerivativeShortFormBase {

	EquityOptionTransactionSupplementMeta metaData = new EquityOptionTransactionSupplementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For a share option transaction, a flag used to indicate whether the transaction is to be treated as an 'exchange look-alike'. This designation has significance for how share adjustments (arising from corporate actions) will be determined for the transaction. For an 'exchange look-alike' transaction the relevant share adjustments will follow that for a corresponding designated contract listed on the related exchange (referred to as Options Exchange Adjustment (ISDA defined term), otherwise the share adjustments will be determined by the calculation agent (referred to as Calculation Agent Adjustment (ISDA defined term)).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For a share option transaction, a flag used to indicate whether the transaction is to be treated as an 'exchange look-alike'. This designation has significance for how share adjustments (arising from corporate actions) will be determined for the transaction. For an 'exchange look-alike' transaction the relevant share adjustments will follow that for a corresponding designated contract listed on the related exchange (referred to as Options Exchange Adjustment (ISDA defined term), otherwise the share adjustments will be determined by the calculation agent (referred to as Calculation Agent Adjustment (ISDA defined term)).
	 *
	 */
	Boolean getExchangeLookAlike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For an index option transaction, a flag used in conjuction with Futures Price Valuation (ISDA defined term) to indicate whether the Nearest Index Contract provision is applicable. The Nearest Index Contract provision is a rule for determining the Exchange-traded Contract (ISDA defined term) without having to explicitly state the actual contract, delivery month and exchange on which it is traded.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For an index option transaction, a flag used in conjuction with Futures Price Valuation (ISDA defined term) to indicate whether the Nearest Index Contract provision is applicable. The Nearest Index Contract provision is a rule for determining the Exchange-traded Contract (ISDA defined term) without having to explicitly state the actual contract, delivery month and exchange on which it is traded.
	 *
	 */
	Boolean getExchangeTradedContractNearest();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For an index option transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For an index option transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.
	 *
	 */
	Boolean getMultipleExchangeIndexAnnexFallback();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For an index option transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For an index option transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.
	 *
	 */
	Boolean getComponentSecurityIndexAnnexFallback();
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
	MethodOfAdjustmentEnum getMethodOfAdjustment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Local Jurisdiction is a term used in the AEJ Master Confirmation, which is used to determine local taxes, which shall mean taxes, duties, and similar charges imposed by the taxing authority of the Local Jurisdiction If this element is not present Local Jurisdiction is Not Applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Local Jurisdiction is a term used in the AEJ Master Confirmation, which is used to determine local taxes, which shall mean taxes, duties, and similar charges imposed by the taxing authority of the Local Jurisdiction If this element is not present Local Jurisdiction is Not Applicable.
	 *
	 */
	CountryCode getLocalJurisdiction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of shares per option comprised in the option transaction supplement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of shares per option comprised in the option transaction supplement.
	 *
	 */
	BigDecimal getOptionEntitlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the contract multiplier that can be associated with an index option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the contract multiplier that can be associated with an index option.
	 *
	 */
	BigDecimal getMultiplier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A component to contain elements that represent an extraordinary event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A component to contain elements that represent an extraordinary event.
	 *
	 */
	ExtraordinaryEvents getExtraordinaryEvents();

	/*********************** Build Methods  ***********************/
	EquityOptionTransactionSupplement build();
	
	EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder toBuilder();
	
	static EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder builder() {
		return new EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityOptionTransactionSupplement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityOptionTransactionSupplement> getType() {
		return EquityOptionTransactionSupplement.class;
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
		processor.processBasic(path.newSubPath("optionType"), EquityOptionTypeEnum.class, getOptionType(), this);
		processor.processBasic(path.newSubPath("equityEffectiveDate"), ZonedDateTime.class, getEquityEffectiveDate(), this);
		processRosetta(path.newSubPath("underlyer"), processor, Underlyer.class, getUnderlyer());
		processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.class, getNotional());
		processRosetta(path.newSubPath("equityExercise"), processor, EquityExerciseValuationSettlement.class, getEquityExercise());
		processRosetta(path.newSubPath("feature"), processor, OptionFeatures.class, getFeature());
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
		processRosetta(path.newSubPath("strategyFeature"), processor, StrategyFeature.class, getStrategyFeature());
		processRosetta(path.newSubPath("strike"), processor, EquityStrike.class, getStrike());
		processor.processBasic(path.newSubPath("spotPrice"), BigDecimal.class, getSpotPrice(), this);
		processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
		processRosetta(path.newSubPath("equityPremium"), processor, EquityPremium.class, getEquityPremium());
		processor.processBasic(path.newSubPath("exchangeLookAlike"), Boolean.class, getExchangeLookAlike(), this);
		processor.processBasic(path.newSubPath("exchangeTradedContractNearest"), Boolean.class, getExchangeTradedContractNearest(), this);
		processor.processBasic(path.newSubPath("multipleExchangeIndexAnnexFallback"), Boolean.class, getMultipleExchangeIndexAnnexFallback(), this);
		processor.processBasic(path.newSubPath("componentSecurityIndexAnnexFallback"), Boolean.class, getComponentSecurityIndexAnnexFallback(), this);
		processor.processBasic(path.newSubPath("methodOfAdjustment"), MethodOfAdjustmentEnum.class, getMethodOfAdjustment(), this);
		processRosetta(path.newSubPath("localJurisdiction"), processor, CountryCode.class, getLocalJurisdiction());
		processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityOptionTransactionSupplementBuilder extends EquityOptionTransactionSupplement, EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder {
		CountryCode.CountryCodeBuilder getOrCreateLocalJurisdiction();
		@Override
		CountryCode.CountryCodeBuilder getLocalJurisdiction();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents();
		@Override
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents();
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setId(String id);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addProductType(ProductType productType);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addProductType(ProductType productType, int idx);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addProductType(List<? extends ProductType> productType);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setProductType(List<? extends ProductType> productType);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addProductId(ProductId productId);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addProductId(ProductId productId, int idx);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addProductId(List<? extends ProductId> productId);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setProductId(List<? extends ProductId> productId);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addAssetClass(AssetClass assetClass);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setOptionType(EquityOptionTypeEnum optionType);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEquityEffectiveDate(ZonedDateTime equityEffectiveDate);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setUnderlyer(Underlyer underlyer);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setNotional(NonNegativeMoney notional);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setFeature(OptionFeatures feature);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setFxFeature(FxFeature fxFeature);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setStrategyFeature(StrategyFeature strategyFeature);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setStrike(EquityStrike strike);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setSpotPrice(BigDecimal spotPrice);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setNumberOfOptions(BigDecimal numberOfOptions);
		@Override
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEquityPremium(EquityPremium equityPremium);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setExchangeLookAlike(Boolean exchangeLookAlike);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setExchangeTradedContractNearest(Boolean exchangeTradedContractNearest);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setMultipleExchangeIndexAnnexFallback(Boolean multipleExchangeIndexAnnexFallback);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setComponentSecurityIndexAnnexFallback(Boolean componentSecurityIndexAnnexFallback);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setLocalJurisdiction(CountryCode localJurisdiction);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setOptionEntitlement(BigDecimal optionEntitlement);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setMultiplier(BigDecimal multiplier);
		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);

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
			processor.processBasic(path.newSubPath("optionType"), EquityOptionTypeEnum.class, getOptionType(), this);
			processor.processBasic(path.newSubPath("equityEffectiveDate"), ZonedDateTime.class, getEquityEffectiveDate(), this);
			processRosetta(path.newSubPath("underlyer"), processor, Underlyer.UnderlyerBuilder.class, getUnderlyer());
			processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNotional());
			processRosetta(path.newSubPath("equityExercise"), processor, EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder.class, getEquityExercise());
			processRosetta(path.newSubPath("feature"), processor, OptionFeatures.OptionFeaturesBuilder.class, getFeature());
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
			processRosetta(path.newSubPath("strategyFeature"), processor, StrategyFeature.StrategyFeatureBuilder.class, getStrategyFeature());
			processRosetta(path.newSubPath("strike"), processor, EquityStrike.EquityStrikeBuilder.class, getStrike());
			processor.processBasic(path.newSubPath("spotPrice"), BigDecimal.class, getSpotPrice(), this);
			processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
			processRosetta(path.newSubPath("equityPremium"), processor, EquityPremium.EquityPremiumBuilder.class, getEquityPremium());
			processor.processBasic(path.newSubPath("exchangeLookAlike"), Boolean.class, getExchangeLookAlike(), this);
			processor.processBasic(path.newSubPath("exchangeTradedContractNearest"), Boolean.class, getExchangeTradedContractNearest(), this);
			processor.processBasic(path.newSubPath("multipleExchangeIndexAnnexFallback"), Boolean.class, getMultipleExchangeIndexAnnexFallback(), this);
			processor.processBasic(path.newSubPath("componentSecurityIndexAnnexFallback"), Boolean.class, getComponentSecurityIndexAnnexFallback(), this);
			processor.processBasic(path.newSubPath("methodOfAdjustment"), MethodOfAdjustmentEnum.class, getMethodOfAdjustment(), this);
			processRosetta(path.newSubPath("localJurisdiction"), processor, CountryCode.CountryCodeBuilder.class, getLocalJurisdiction());
			processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
		}
		

		EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of EquityOptionTransactionSupplement  ***********************/
	class EquityOptionTransactionSupplementImpl extends EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseImpl implements EquityOptionTransactionSupplement {
		private final Boolean exchangeLookAlike;
		private final Boolean exchangeTradedContractNearest;
		private final Boolean multipleExchangeIndexAnnexFallback;
		private final Boolean componentSecurityIndexAnnexFallback;
		private final MethodOfAdjustmentEnum methodOfAdjustment;
		private final CountryCode localJurisdiction;
		private final BigDecimal optionEntitlement;
		private final BigDecimal multiplier;
		private final ExtraordinaryEvents extraordinaryEvents;
		
		protected EquityOptionTransactionSupplementImpl(EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder builder) {
			super(builder);
			this.exchangeLookAlike = builder.getExchangeLookAlike();
			this.exchangeTradedContractNearest = builder.getExchangeTradedContractNearest();
			this.multipleExchangeIndexAnnexFallback = builder.getMultipleExchangeIndexAnnexFallback();
			this.componentSecurityIndexAnnexFallback = builder.getComponentSecurityIndexAnnexFallback();
			this.methodOfAdjustment = builder.getMethodOfAdjustment();
			this.localJurisdiction = ofNullable(builder.getLocalJurisdiction()).map(f->f.build()).orElse(null);
			this.optionEntitlement = builder.getOptionEntitlement();
			this.multiplier = builder.getMultiplier();
			this.extraordinaryEvents = ofNullable(builder.getExtraordinaryEvents()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exchangeLookAlike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeLookAlike")
		public Boolean getExchangeLookAlike() {
			return exchangeLookAlike;
		}
		
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeTradedContractNearest")
		public Boolean getExchangeTradedContractNearest() {
			return exchangeTradedContractNearest;
		}
		
		@Override
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multipleExchangeIndexAnnexFallback")
		public Boolean getMultipleExchangeIndexAnnexFallback() {
			return multipleExchangeIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("componentSecurityIndexAnnexFallback")
		public Boolean getComponentSecurityIndexAnnexFallback() {
			return componentSecurityIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("methodOfAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("methodOfAdjustment")
		public MethodOfAdjustmentEnum getMethodOfAdjustment() {
			return methodOfAdjustment;
		}
		
		@Override
		@RosettaAttribute("localJurisdiction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localJurisdiction")
		public CountryCode getLocalJurisdiction() {
			return localJurisdiction;
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extraordinaryEvents")
		public ExtraordinaryEvents getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public EquityOptionTransactionSupplement build() {
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder toBuilder() {
			EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExchangeLookAlike()).ifPresent(builder::setExchangeLookAlike);
			ofNullable(getExchangeTradedContractNearest()).ifPresent(builder::setExchangeTradedContractNearest);
			ofNullable(getMultipleExchangeIndexAnnexFallback()).ifPresent(builder::setMultipleExchangeIndexAnnexFallback);
			ofNullable(getComponentSecurityIndexAnnexFallback()).ifPresent(builder::setComponentSecurityIndexAnnexFallback);
			ofNullable(getMethodOfAdjustment()).ifPresent(builder::setMethodOfAdjustment);
			ofNullable(getLocalJurisdiction()).ifPresent(builder::setLocalJurisdiction);
			ofNullable(getOptionEntitlement()).ifPresent(builder::setOptionEntitlement);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
			ofNullable(getExtraordinaryEvents()).ifPresent(builder::setExtraordinaryEvents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityOptionTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(exchangeLookAlike, _that.getExchangeLookAlike())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			if (!Objects.equals(multipleExchangeIndexAnnexFallback, _that.getMultipleExchangeIndexAnnexFallback())) return false;
			if (!Objects.equals(componentSecurityIndexAnnexFallback, _that.getComponentSecurityIndexAnnexFallback())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(localJurisdiction, _that.getLocalJurisdiction())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exchangeLookAlike != null ? exchangeLookAlike.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			_result = 31 * _result + (multipleExchangeIndexAnnexFallback != null ? multipleExchangeIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (componentSecurityIndexAnnexFallback != null ? componentSecurityIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (methodOfAdjustment != null ? methodOfAdjustment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (localJurisdiction != null ? localJurisdiction.hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityOptionTransactionSupplement {" +
				"exchangeLookAlike=" + this.exchangeLookAlike + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest + ", " +
				"multipleExchangeIndexAnnexFallback=" + this.multipleExchangeIndexAnnexFallback + ", " +
				"componentSecurityIndexAnnexFallback=" + this.componentSecurityIndexAnnexFallback + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"localJurisdiction=" + this.localJurisdiction + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"multiplier=" + this.multiplier + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityOptionTransactionSupplement  ***********************/
	class EquityOptionTransactionSupplementBuilderImpl extends EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilderImpl implements EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder {
	
		protected Boolean exchangeLookAlike;
		protected Boolean exchangeTradedContractNearest;
		protected Boolean multipleExchangeIndexAnnexFallback;
		protected Boolean componentSecurityIndexAnnexFallback;
		protected MethodOfAdjustmentEnum methodOfAdjustment;
		protected CountryCode.CountryCodeBuilder localJurisdiction;
		protected BigDecimal optionEntitlement;
		protected BigDecimal multiplier;
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents;
		
		@Override
		@RosettaAttribute("exchangeLookAlike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeLookAlike")
		public Boolean getExchangeLookAlike() {
			return exchangeLookAlike;
		}
		
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeTradedContractNearest")
		public Boolean getExchangeTradedContractNearest() {
			return exchangeTradedContractNearest;
		}
		
		@Override
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multipleExchangeIndexAnnexFallback")
		public Boolean getMultipleExchangeIndexAnnexFallback() {
			return multipleExchangeIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("componentSecurityIndexAnnexFallback")
		public Boolean getComponentSecurityIndexAnnexFallback() {
			return componentSecurityIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("methodOfAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("methodOfAdjustment")
		public MethodOfAdjustmentEnum getMethodOfAdjustment() {
			return methodOfAdjustment;
		}
		
		@Override
		@RosettaAttribute("localJurisdiction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localJurisdiction")
		public CountryCode.CountryCodeBuilder getLocalJurisdiction() {
			return localJurisdiction;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder getOrCreateLocalJurisdiction() {
			CountryCode.CountryCodeBuilder result;
			if (localJurisdiction!=null) {
				result = localJurisdiction;
			}
			else {
				result = localJurisdiction = CountryCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extraordinaryEvents")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents() {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder result;
			if (extraordinaryEvents!=null) {
				result = extraordinaryEvents;
			}
			else {
				result = extraordinaryEvents = ExtraordinaryEvents.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addProductId(List<? extends ProductId> productIds) {
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
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setProductId(List<? extends ProductId> productIds) {
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
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setOptionType(EquityOptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("equityEffectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityEffectiveDate")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEquityEffectiveDate(ZonedDateTime _equityEffectiveDate) {
			this.equityEffectiveDate = _equityEffectiveDate == null ? null : _equityEffectiveDate;
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyer")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notional")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setNotional(NonNegativeMoney _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equityExercise")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("equityExercise")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEquityExercise(EquityExerciseValuationSettlement _equityExercise) {
			this.equityExercise = _equityExercise == null ? null : _equityExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feature")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setFeature(OptionFeatures _feature) {
			this.feature = _feature == null ? null : _feature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFeature")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setFxFeature(FxFeature _fxFeature) {
			this.fxFeature = _fxFeature == null ? null : _fxFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strategyFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strategyFeature")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setStrategyFeature(StrategyFeature _strategyFeature) {
			this.strategyFeature = _strategyFeature == null ? null : _strategyFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strike")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setStrike(EquityStrike _strike) {
			this.strike = _strike == null ? null : _strike.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotPrice")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setSpotPrice(BigDecimal _spotPrice) {
			this.spotPrice = _spotPrice == null ? null : _spotPrice;
			return this;
		}
		
		@RosettaAttribute("numberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfOptions")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setNumberOfOptions(BigDecimal _numberOfOptions) {
			this.numberOfOptions = _numberOfOptions == null ? null : _numberOfOptions;
			return this;
		}
		
		@RosettaAttribute("equityPremium")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityPremium")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setEquityPremium(EquityPremium _equityPremium) {
			this.equityPremium = _equityPremium == null ? null : _equityPremium.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeLookAlike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeLookAlike")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setExchangeLookAlike(Boolean _exchangeLookAlike) {
			this.exchangeLookAlike = _exchangeLookAlike == null ? null : _exchangeLookAlike;
			return this;
		}
		
		@RosettaAttribute("exchangeTradedContractNearest")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeTradedContractNearest")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setExchangeTradedContractNearest(Boolean _exchangeTradedContractNearest) {
			this.exchangeTradedContractNearest = _exchangeTradedContractNearest == null ? null : _exchangeTradedContractNearest;
			return this;
		}
		
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multipleExchangeIndexAnnexFallback")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setMultipleExchangeIndexAnnexFallback(Boolean _multipleExchangeIndexAnnexFallback) {
			this.multipleExchangeIndexAnnexFallback = _multipleExchangeIndexAnnexFallback == null ? null : _multipleExchangeIndexAnnexFallback;
			return this;
		}
		
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("componentSecurityIndexAnnexFallback")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setComponentSecurityIndexAnnexFallback(Boolean _componentSecurityIndexAnnexFallback) {
			this.componentSecurityIndexAnnexFallback = _componentSecurityIndexAnnexFallback == null ? null : _componentSecurityIndexAnnexFallback;
			return this;
		}
		
		@RosettaAttribute("methodOfAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("methodOfAdjustment")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum _methodOfAdjustment) {
			this.methodOfAdjustment = _methodOfAdjustment == null ? null : _methodOfAdjustment;
			return this;
		}
		
		@RosettaAttribute("localJurisdiction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("localJurisdiction")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setLocalJurisdiction(CountryCode _localJurisdiction) {
			this.localJurisdiction = _localJurisdiction == null ? null : _localJurisdiction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionEntitlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionEntitlement")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setOptionEntitlement(BigDecimal _optionEntitlement) {
			this.optionEntitlement = _optionEntitlement == null ? null : _optionEntitlement;
			return this;
		}
		
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiplier")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setMultiplier(BigDecimal _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier;
			return this;
		}
		
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extraordinaryEvents")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder setExtraordinaryEvents(ExtraordinaryEvents _extraordinaryEvents) {
			this.extraordinaryEvents = _extraordinaryEvents == null ? null : _extraordinaryEvents.toBuilder();
			return this;
		}
		
		@Override
		public EquityOptionTransactionSupplement build() {
			return new EquityOptionTransactionSupplement.EquityOptionTransactionSupplementImpl(this);
		}
		
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder prune() {
			super.prune();
			if (localJurisdiction!=null && !localJurisdiction.prune().hasData()) localJurisdiction = null;
			if (extraordinaryEvents!=null && !extraordinaryEvents.prune().hasData()) extraordinaryEvents = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExchangeLookAlike()!=null) return true;
			if (getExchangeTradedContractNearest()!=null) return true;
			if (getMultipleExchangeIndexAnnexFallback()!=null) return true;
			if (getComponentSecurityIndexAnnexFallback()!=null) return true;
			if (getMethodOfAdjustment()!=null) return true;
			if (getLocalJurisdiction()!=null && getLocalJurisdiction().hasData()) return true;
			if (getOptionEntitlement()!=null) return true;
			if (getMultiplier()!=null) return true;
			if (getExtraordinaryEvents()!=null && getExtraordinaryEvents().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder o = (EquityOptionTransactionSupplement.EquityOptionTransactionSupplementBuilder) other;
			
			merger.mergeRosetta(getLocalJurisdiction(), o.getLocalJurisdiction(), this::setLocalJurisdiction);
			merger.mergeRosetta(getExtraordinaryEvents(), o.getExtraordinaryEvents(), this::setExtraordinaryEvents);
			
			merger.mergeBasic(getExchangeLookAlike(), o.getExchangeLookAlike(), this::setExchangeLookAlike);
			merger.mergeBasic(getExchangeTradedContractNearest(), o.getExchangeTradedContractNearest(), this::setExchangeTradedContractNearest);
			merger.mergeBasic(getMultipleExchangeIndexAnnexFallback(), o.getMultipleExchangeIndexAnnexFallback(), this::setMultipleExchangeIndexAnnexFallback);
			merger.mergeBasic(getComponentSecurityIndexAnnexFallback(), o.getComponentSecurityIndexAnnexFallback(), this::setComponentSecurityIndexAnnexFallback);
			merger.mergeBasic(getMethodOfAdjustment(), o.getMethodOfAdjustment(), this::setMethodOfAdjustment);
			merger.mergeBasic(getOptionEntitlement(), o.getOptionEntitlement(), this::setOptionEntitlement);
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityOptionTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(exchangeLookAlike, _that.getExchangeLookAlike())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			if (!Objects.equals(multipleExchangeIndexAnnexFallback, _that.getMultipleExchangeIndexAnnexFallback())) return false;
			if (!Objects.equals(componentSecurityIndexAnnexFallback, _that.getComponentSecurityIndexAnnexFallback())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(localJurisdiction, _that.getLocalJurisdiction())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exchangeLookAlike != null ? exchangeLookAlike.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			_result = 31 * _result + (multipleExchangeIndexAnnexFallback != null ? multipleExchangeIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (componentSecurityIndexAnnexFallback != null ? componentSecurityIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (methodOfAdjustment != null ? methodOfAdjustment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (localJurisdiction != null ? localJurisdiction.hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityOptionTransactionSupplementBuilder {" +
				"exchangeLookAlike=" + this.exchangeLookAlike + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest + ", " +
				"multipleExchangeIndexAnnexFallback=" + this.multipleExchangeIndexAnnexFallback + ", " +
				"componentSecurityIndexAnnexFallback=" + this.componentSecurityIndexAnnexFallback + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"localJurisdiction=" + this.localJurisdiction + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"multiplier=" + this.multiplier + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}
}

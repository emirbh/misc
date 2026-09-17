package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommoditySwaptionMeta;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.fpmlenum.PutCallEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.Rounding;
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
 * Provision Commodity Swaption.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Commodity Swaption.
 *
 */
@RosettaDataType(value="CommoditySwaption", builder=CommoditySwaption.CommoditySwaptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommoditySwaption", model="fpml", builder=CommoditySwaption.CommoditySwaptionBuilderImpl.class, version="2.1.1")
public interface CommoditySwaption extends Product {

	CommoditySwaptionMeta metaData = new CommoditySwaptionMeta();

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
	 * Provision The type of option transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of option transaction.
	 *
	 */
	PutCallEnum getOptionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The underlying commodity swap definiton.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The underlying commodity swap definiton.
	 *
	 */
	CommoditySwaptionUnderlying getCommoditySwap();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining how the commodity option can be exercised into a physical transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining how the commodity option can be exercised into a physical transaction.
	 *
	 */
	CommodityPhysicalExercise getPhysicalExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The option premium payable by the buyer to the seller.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The option premium payable by the buyer to the seller.
	 *
	 */
	CommodityPremium getPremium();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If Common Pricing is elected (“true”) for a Transaction with referencing more than one Commodity Reference Price then no date will be a Pricing Date unless such a date is a day on which all Commodity Reference Prices are scheduled to be published.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If Common Pricing is elected (“true”) for a Transaction with referencing more than one Commodity Reference Price then no date will be a Pricing Date unless such a date is a day on which all Commodity Reference Prices are scheduled to be published.
	 *
	 */
	Boolean getCommonPricing();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Contains contract terms related to triggers and responses to market disruptions as defined in the 1993 or 2005 Commodity Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Contains contract terms related to triggers and responses to market disruptions as defined in the 1993 or 2005 Commodity Definitions.
	 *
	 */
	CommodityMarketDisruption getMarketDisruption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes contract terms related to the consequences of Bullion Settlement Disruption Events.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes contract terms related to the consequences of Bullion Settlement Disruption Events.
	 *
	 */
	CommodityBullionSettlementDisruptionEnum getSettlementDisruption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Rounding direction and precision for amounts.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Rounding direction and precision for amounts.
	 *
	 */
	Rounding getRounding();

	/*********************** Build Methods  ***********************/
	CommoditySwaption build();
	
	CommoditySwaption.CommoditySwaptionBuilder toBuilder();
	
	static CommoditySwaption.CommoditySwaptionBuilder builder() {
		return new CommoditySwaption.CommoditySwaptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySwaption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommoditySwaption> getType() {
		return CommoditySwaption.class;
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
		processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
		processRosetta(path.newSubPath("commoditySwap"), processor, CommoditySwaptionUnderlying.class, getCommoditySwap());
		processRosetta(path.newSubPath("physicalExercise"), processor, CommodityPhysicalExercise.class, getPhysicalExercise());
		processRosetta(path.newSubPath("premium"), processor, CommodityPremium.class, getPremium());
		processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
		processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.class, getMarketDisruption());
		processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
		processRosetta(path.newSubPath("rounding"), processor, Rounding.class, getRounding());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySwaptionBuilder extends CommoditySwaption, Product.ProductBuilder {
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
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder getOrCreateCommoditySwap();
		@Override
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder getCommoditySwap();
		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getOrCreatePhysicalExercise();
		@Override
		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getPhysicalExercise();
		CommodityPremium.CommodityPremiumBuilder getOrCreatePremium();
		@Override
		CommodityPremium.CommodityPremiumBuilder getPremium();
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder getOrCreateMarketDisruption();
		@Override
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder getMarketDisruption();
		Rounding.RoundingBuilder getOrCreateRounding();
		@Override
		Rounding.RoundingBuilder getRounding();
		@Override
		CommoditySwaption.CommoditySwaptionBuilder setId(String id);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addProductType(ProductType productType);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addProductType(ProductType productType, int idx);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addProductType(List<? extends ProductType> productType);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder setProductType(List<? extends ProductType> productType);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addProductId(ProductId productId);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addProductId(ProductId productId, int idx);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addProductId(List<? extends ProductId> productId);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder setProductId(List<? extends ProductId> productId);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addAssetClass(AssetClass assetClass);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CommoditySwaption.CommoditySwaptionBuilder setAssetClass(List<? extends AssetClass> assetClass);
		CommoditySwaption.CommoditySwaptionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		CommoditySwaption.CommoditySwaptionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		CommoditySwaption.CommoditySwaptionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		CommoditySwaption.CommoditySwaptionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		CommoditySwaption.CommoditySwaptionBuilder setOptionType(PutCallEnum optionType);
		CommoditySwaption.CommoditySwaptionBuilder setCommoditySwap(CommoditySwaptionUnderlying commoditySwap);
		CommoditySwaption.CommoditySwaptionBuilder setPhysicalExercise(CommodityPhysicalExercise physicalExercise);
		CommoditySwaption.CommoditySwaptionBuilder setPremium(CommodityPremium premium);
		CommoditySwaption.CommoditySwaptionBuilder setCommonPricing(Boolean commonPricing);
		CommoditySwaption.CommoditySwaptionBuilder setMarketDisruption(CommodityMarketDisruption marketDisruption);
		CommoditySwaption.CommoditySwaptionBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum settlementDisruption);
		CommoditySwaption.CommoditySwaptionBuilder setRounding(Rounding rounding);

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
			processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
			processRosetta(path.newSubPath("commoditySwap"), processor, CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder.class, getCommoditySwap());
			processRosetta(path.newSubPath("physicalExercise"), processor, CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder.class, getPhysicalExercise());
			processRosetta(path.newSubPath("premium"), processor, CommodityPremium.CommodityPremiumBuilder.class, getPremium());
			processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
			processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.CommodityMarketDisruptionBuilder.class, getMarketDisruption());
			processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
			processRosetta(path.newSubPath("rounding"), processor, Rounding.RoundingBuilder.class, getRounding());
		}
		

		CommoditySwaption.CommoditySwaptionBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySwaption  ***********************/
	class CommoditySwaptionImpl extends Product.ProductImpl implements CommoditySwaption {
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final PutCallEnum optionType;
		private final CommoditySwaptionUnderlying commoditySwap;
		private final CommodityPhysicalExercise physicalExercise;
		private final CommodityPremium premium;
		private final Boolean commonPricing;
		private final CommodityMarketDisruption marketDisruption;
		private final CommodityBullionSettlementDisruptionEnum settlementDisruption;
		private final Rounding rounding;
		
		protected CommoditySwaptionImpl(CommoditySwaption.CommoditySwaptionBuilder builder) {
			super(builder);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.optionType = builder.getOptionType();
			this.commoditySwap = ofNullable(builder.getCommoditySwap()).map(f->f.build()).orElse(null);
			this.physicalExercise = ofNullable(builder.getPhysicalExercise()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).map(f->f.build()).orElse(null);
			this.commonPricing = builder.getCommonPricing();
			this.marketDisruption = ofNullable(builder.getMarketDisruption()).map(f->f.build()).orElse(null);
			this.settlementDisruption = builder.getSettlementDisruption();
			this.rounding = ofNullable(builder.getRounding()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("commoditySwap")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("commoditySwap")
		public CommoditySwaptionUnderlying getCommoditySwap() {
			return commoditySwap;
		}
		
		@Override
		@RosettaAttribute("physicalExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalExercise")
		public CommodityPhysicalExercise getPhysicalExercise() {
			return physicalExercise;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premium")
		public CommodityPremium getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("commonPricing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commonPricing")
		public Boolean getCommonPricing() {
			return commonPricing;
		}
		
		@Override
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketDisruption")
		public CommodityMarketDisruption getMarketDisruption() {
			return marketDisruption;
		}
		
		@Override
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDisruption")
		public CommodityBullionSettlementDisruptionEnum getSettlementDisruption() {
			return settlementDisruption;
		}
		
		@Override
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rounding")
		public Rounding getRounding() {
			return rounding;
		}
		
		@Override
		public CommoditySwaption build() {
			return this;
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder toBuilder() {
			CommoditySwaption.CommoditySwaptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySwaption.CommoditySwaptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getCommoditySwap()).ifPresent(builder::setCommoditySwap);
			ofNullable(getPhysicalExercise()).ifPresent(builder::setPhysicalExercise);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getCommonPricing()).ifPresent(builder::setCommonPricing);
			ofNullable(getMarketDisruption()).ifPresent(builder::setMarketDisruption);
			ofNullable(getSettlementDisruption()).ifPresent(builder::setSettlementDisruption);
			ofNullable(getRounding()).ifPresent(builder::setRounding);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommoditySwaption _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commoditySwap, _that.getCommoditySwap())) return false;
			if (!Objects.equals(physicalExercise, _that.getPhysicalExercise())) return false;
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(commonPricing, _that.getCommonPricing())) return false;
			if (!Objects.equals(marketDisruption, _that.getMarketDisruption())) return false;
			if (!Objects.equals(settlementDisruption, _that.getSettlementDisruption())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commoditySwap != null ? commoditySwap.hashCode() : 0);
			_result = 31 * _result + (physicalExercise != null ? physicalExercise.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commonPricing != null ? commonPricing.hashCode() : 0);
			_result = 31 * _result + (marketDisruption != null ? marketDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementDisruption != null ? settlementDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySwaption {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"optionType=" + this.optionType + ", " +
				"commoditySwap=" + this.commoditySwap + ", " +
				"physicalExercise=" + this.physicalExercise + ", " +
				"premium=" + this.premium + ", " +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommoditySwaption  ***********************/
	class CommoditySwaptionBuilderImpl extends Product.ProductBuilderImpl implements CommoditySwaption.CommoditySwaptionBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected PutCallEnum optionType;
		protected CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder commoditySwap;
		protected CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder physicalExercise;
		protected CommodityPremium.CommodityPremiumBuilder premium;
		protected Boolean commonPricing;
		protected CommodityMarketDisruption.CommodityMarketDisruptionBuilder marketDisruption;
		protected CommodityBullionSettlementDisruptionEnum settlementDisruption;
		protected Rounding.RoundingBuilder rounding;
		
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
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("commoditySwap")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("commoditySwap")
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder getCommoditySwap() {
			return commoditySwap;
		}
		
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder getOrCreateCommoditySwap() {
			CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder result;
			if (commoditySwap!=null) {
				result = commoditySwap;
			}
			else {
				result = commoditySwap = CommoditySwaptionUnderlying.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalExercise")
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getPhysicalExercise() {
			return physicalExercise;
		}
		
		@Override
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getOrCreatePhysicalExercise() {
			CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder result;
			if (physicalExercise!=null) {
				result = physicalExercise;
			}
			else {
				result = physicalExercise = CommodityPhysicalExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premium")
		public CommodityPremium.CommodityPremiumBuilder getPremium() {
			return premium;
		}
		
		@Override
		public CommodityPremium.CommodityPremiumBuilder getOrCreatePremium() {
			CommodityPremium.CommodityPremiumBuilder result;
			if (premium!=null) {
				result = premium;
			}
			else {
				result = premium = CommodityPremium.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commonPricing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commonPricing")
		public Boolean getCommonPricing() {
			return commonPricing;
		}
		
		@Override
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketDisruption")
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder getMarketDisruption() {
			return marketDisruption;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder getOrCreateMarketDisruption() {
			CommodityMarketDisruption.CommodityMarketDisruptionBuilder result;
			if (marketDisruption!=null) {
				result = marketDisruption;
			}
			else {
				result = marketDisruption = CommodityMarketDisruption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDisruption")
		public CommodityBullionSettlementDisruptionEnum getSettlementDisruption() {
			return settlementDisruption;
		}
		
		@Override
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rounding")
		public Rounding.RoundingBuilder getRounding() {
			return rounding;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreateRounding() {
			Rounding.RoundingBuilder result;
			if (rounding!=null) {
				result = rounding;
			}
			else {
				result = rounding = Rounding.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CommoditySwaption.CommoditySwaptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CommoditySwaption.CommoditySwaptionBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public CommoditySwaption.CommoditySwaptionBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public CommoditySwaption.CommoditySwaptionBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder addProductId(List<? extends ProductId> productIds) {
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
		public CommoditySwaption.CommoditySwaptionBuilder setProductId(List<? extends ProductId> productIds) {
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
		public CommoditySwaption.CommoditySwaptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CommoditySwaption.CommoditySwaptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CommoditySwaption.CommoditySwaptionBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CommoditySwaption.CommoditySwaptionBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CommoditySwaption.CommoditySwaptionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("optionType")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder setOptionType(PutCallEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("commoditySwap")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("commoditySwap")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder setCommoditySwap(CommoditySwaptionUnderlying _commoditySwap) {
			this.commoditySwap = _commoditySwap == null ? null : _commoditySwap.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalExercise")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder setPhysicalExercise(CommodityPhysicalExercise _physicalExercise) {
			this.physicalExercise = _physicalExercise == null ? null : _physicalExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("premium")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder setPremium(CommodityPremium _premium) {
			this.premium = _premium == null ? null : _premium.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commonPricing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commonPricing")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder setCommonPricing(Boolean _commonPricing) {
			this.commonPricing = _commonPricing == null ? null : _commonPricing;
			return this;
		}
		
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketDisruption")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder setMarketDisruption(CommodityMarketDisruption _marketDisruption) {
			this.marketDisruption = _marketDisruption == null ? null : _marketDisruption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDisruption")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum _settlementDisruption) {
			this.settlementDisruption = _settlementDisruption == null ? null : _settlementDisruption;
			return this;
		}
		
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rounding")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder setRounding(Rounding _rounding) {
			this.rounding = _rounding == null ? null : _rounding.toBuilder();
			return this;
		}
		
		@Override
		public CommoditySwaption build() {
			return new CommoditySwaption.CommoditySwaptionImpl(this);
		}
		
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder prune() {
			super.prune();
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			if (commoditySwap!=null && !commoditySwap.prune().hasData()) commoditySwap = null;
			if (physicalExercise!=null && !physicalExercise.prune().hasData()) physicalExercise = null;
			if (premium!=null && !premium.prune().hasData()) premium = null;
			if (marketDisruption!=null && !marketDisruption.prune().hasData()) marketDisruption = null;
			if (rounding!=null && !rounding.prune().hasData()) rounding = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			if (getOptionType()!=null) return true;
			if (getCommoditySwap()!=null && getCommoditySwap().hasData()) return true;
			if (getPhysicalExercise()!=null && getPhysicalExercise().hasData()) return true;
			if (getPremium()!=null && getPremium().hasData()) return true;
			if (getCommonPricing()!=null) return true;
			if (getMarketDisruption()!=null && getMarketDisruption().hasData()) return true;
			if (getSettlementDisruption()!=null) return true;
			if (getRounding()!=null && getRounding().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwaption.CommoditySwaptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommoditySwaption.CommoditySwaptionBuilder o = (CommoditySwaption.CommoditySwaptionBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getCommoditySwap(), o.getCommoditySwap(), this::setCommoditySwap);
			merger.mergeRosetta(getPhysicalExercise(), o.getPhysicalExercise(), this::setPhysicalExercise);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::setPremium);
			merger.mergeRosetta(getMarketDisruption(), o.getMarketDisruption(), this::setMarketDisruption);
			merger.mergeRosetta(getRounding(), o.getRounding(), this::setRounding);
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getCommonPricing(), o.getCommonPricing(), this::setCommonPricing);
			merger.mergeBasic(getSettlementDisruption(), o.getSettlementDisruption(), this::setSettlementDisruption);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommoditySwaption _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commoditySwap, _that.getCommoditySwap())) return false;
			if (!Objects.equals(physicalExercise, _that.getPhysicalExercise())) return false;
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(commonPricing, _that.getCommonPricing())) return false;
			if (!Objects.equals(marketDisruption, _that.getMarketDisruption())) return false;
			if (!Objects.equals(settlementDisruption, _that.getSettlementDisruption())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commoditySwap != null ? commoditySwap.hashCode() : 0);
			_result = 31 * _result + (physicalExercise != null ? physicalExercise.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commonPricing != null ? commonPricing.hashCode() : 0);
			_result = 31 * _result + (marketDisruption != null ? marketDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementDisruption != null ? settlementDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySwaptionBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"optionType=" + this.optionType + ", " +
				"commoditySwap=" + this.commoditySwap + ", " +
				"physicalExercise=" + this.physicalExercise + ", " +
				"premium=" + this.premium + ", " +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}' + " " + super.toString();
		}
	}
}

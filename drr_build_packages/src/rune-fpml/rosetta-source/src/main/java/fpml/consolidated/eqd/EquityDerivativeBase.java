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
import fpml.consolidated.eq.shared.OptionFeatures;
import fpml.consolidated.eqd.meta.EquityDerivativeBaseMeta;
import fpml.consolidated.fpmlenum.EquityOptionTypeEnum;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.option.shared.StrategyFeature;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
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
 * Provision A type for defining the common features of equity derivatives.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining the common features of equity derivatives.
 *
 */
@RosettaDataType(value="EquityDerivativeBase", builder=EquityDerivativeBase.EquityDerivativeBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityDerivativeBase", model="fpml", builder=EquityDerivativeBase.EquityDerivativeBaseBuilderImpl.class, version="2.1.1")
public interface EquityDerivativeBase extends Product {

	EquityDerivativeBaseMeta metaData = new EquityDerivativeBaseMeta();

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
	EquityOptionTypeEnum getOptionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Effective date for a forward starting option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Effective date for a forward starting option.
	 *
	 */
	ZonedDateTime getEquityEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the underlying component, which can be either one or many and consists in either equity, index or convertible bond component, or a combination of these.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the underlying component, which can be either one or many and consists in either equity, index or convertible bond component, or a combination of these.
	 *
	 */
	Underlyer getUnderlyer();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The notional amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The notional amount.
	 *
	 */
	NonNegativeMoney getNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining how the equity option can be exercised, how it is valued and how it is settled.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining how the equity option can be exercised, how it is valued and how it is settled.
	 *
	 */
	EquityExerciseValuationSettlement getEquityExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Asian, Barrier, Knock and Pass Through features.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Asian, Barrier, Knock and Pass Through features.
	 *
	 */
	OptionFeatures getFeature();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Quanto, Composite, or Cross Currency FX features.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Quanto, Composite, or Cross Currency FX features.
	 *
	 */
	FxFeature getFxFeature();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A equity option simple strategy feature.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A equity option simple strategy feature.
	 *
	 */
	StrategyFeature getStrategyFeature();

	/*********************** Build Methods  ***********************/
	EquityDerivativeBase build();
	
	EquityDerivativeBase.EquityDerivativeBaseBuilder toBuilder();
	
	static EquityDerivativeBase.EquityDerivativeBaseBuilder builder() {
		return new EquityDerivativeBase.EquityDerivativeBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityDerivativeBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityDerivativeBase> getType() {
		return EquityDerivativeBase.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityDerivativeBaseBuilder extends EquityDerivativeBase, Product.ProductBuilder {
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
		Underlyer.UnderlyerBuilder getOrCreateUnderlyer();
		@Override
		Underlyer.UnderlyerBuilder getUnderlyer();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getNotional();
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getOrCreateEquityExercise();
		@Override
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getEquityExercise();
		OptionFeatures.OptionFeaturesBuilder getOrCreateFeature();
		@Override
		OptionFeatures.OptionFeaturesBuilder getFeature();
		FxFeature.FxFeatureBuilder getOrCreateFxFeature();
		@Override
		FxFeature.FxFeatureBuilder getFxFeature();
		StrategyFeature.StrategyFeatureBuilder getOrCreateStrategyFeature();
		@Override
		StrategyFeature.StrategyFeatureBuilder getStrategyFeature();
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder setId(String id);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addProductType(ProductType productType);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addProductType(ProductType productType, int idx);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addProductType(List<? extends ProductType> productType);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder setProductType(List<? extends ProductType> productType);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addProductId(ProductId productId);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addProductId(ProductId productId, int idx);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addProductId(List<? extends ProductId> productId);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder setProductId(List<? extends ProductId> productId);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addAssetClass(AssetClass assetClass);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		EquityDerivativeBase.EquityDerivativeBaseBuilder setAssetClass(List<? extends AssetClass> assetClass);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setOptionType(EquityOptionTypeEnum optionType);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setEquityEffectiveDate(ZonedDateTime equityEffectiveDate);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setUnderlyer(Underlyer underlyer);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setNotional(NonNegativeMoney notional);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setFeature(OptionFeatures feature);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setFxFeature(FxFeature fxFeature);
		EquityDerivativeBase.EquityDerivativeBaseBuilder setStrategyFeature(StrategyFeature strategyFeature);

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
		}
		

		EquityDerivativeBase.EquityDerivativeBaseBuilder prune();
	}

	/*********************** Immutable Implementation of EquityDerivativeBase  ***********************/
	class EquityDerivativeBaseImpl extends Product.ProductImpl implements EquityDerivativeBase {
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final EquityOptionTypeEnum optionType;
		private final ZonedDateTime equityEffectiveDate;
		private final Underlyer underlyer;
		private final NonNegativeMoney notional;
		private final EquityExerciseValuationSettlement equityExercise;
		private final OptionFeatures feature;
		private final FxFeature fxFeature;
		private final StrategyFeature strategyFeature;
		
		protected EquityDerivativeBaseImpl(EquityDerivativeBase.EquityDerivativeBaseBuilder builder) {
			super(builder);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.optionType = builder.getOptionType();
			this.equityEffectiveDate = builder.getEquityEffectiveDate();
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.equityExercise = ofNullable(builder.getEquityExercise()).map(f->f.build()).orElse(null);
			this.feature = ofNullable(builder.getFeature()).map(f->f.build()).orElse(null);
			this.fxFeature = ofNullable(builder.getFxFeature()).map(f->f.build()).orElse(null);
			this.strategyFeature = ofNullable(builder.getStrategyFeature()).map(f->f.build()).orElse(null);
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
		@RuneAttribute("optionType")
		public EquityOptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("equityEffectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityEffectiveDate")
		public ZonedDateTime getEquityEffectiveDate() {
			return equityEffectiveDate;
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
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notional")
		public NonNegativeMoney getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("equityExercise")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("equityExercise")
		public EquityExerciseValuationSettlement getEquityExercise() {
			return equityExercise;
		}
		
		@Override
		@RosettaAttribute("feature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feature")
		public OptionFeatures getFeature() {
			return feature;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxFeature")
		public FxFeature getFxFeature() {
			return fxFeature;
		}
		
		@Override
		@RosettaAttribute("strategyFeature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strategyFeature")
		public StrategyFeature getStrategyFeature() {
			return strategyFeature;
		}
		
		@Override
		public EquityDerivativeBase build() {
			return this;
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder toBuilder() {
			EquityDerivativeBase.EquityDerivativeBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityDerivativeBase.EquityDerivativeBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getEquityEffectiveDate()).ifPresent(builder::setEquityEffectiveDate);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getEquityExercise()).ifPresent(builder::setEquityExercise);
			ofNullable(getFeature()).ifPresent(builder::setFeature);
			ofNullable(getFxFeature()).ifPresent(builder::setFxFeature);
			ofNullable(getStrategyFeature()).ifPresent(builder::setStrategyFeature);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityDerivativeBase _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(equityEffectiveDate, _that.getEquityEffectiveDate())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(equityExercise, _that.getEquityExercise())) return false;
			if (!Objects.equals(feature, _that.getFeature())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(strategyFeature, _that.getStrategyFeature())) return false;
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
			_result = 31 * _result + (equityEffectiveDate != null ? equityEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (equityExercise != null ? equityExercise.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (strategyFeature != null ? strategyFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityDerivativeBase {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"optionType=" + this.optionType + ", " +
				"equityEffectiveDate=" + this.equityEffectiveDate + ", " +
				"underlyer=" + this.underlyer + ", " +
				"notional=" + this.notional + ", " +
				"equityExercise=" + this.equityExercise + ", " +
				"feature=" + this.feature + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"strategyFeature=" + this.strategyFeature +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityDerivativeBase  ***********************/
	class EquityDerivativeBaseBuilderImpl extends Product.ProductBuilderImpl implements EquityDerivativeBase.EquityDerivativeBaseBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected EquityOptionTypeEnum optionType;
		protected ZonedDateTime equityEffectiveDate;
		protected Underlyer.UnderlyerBuilder underlyer;
		protected NonNegativeMoney.NonNegativeMoneyBuilder notional;
		protected EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder equityExercise;
		protected OptionFeatures.OptionFeaturesBuilder feature;
		protected FxFeature.FxFeatureBuilder fxFeature;
		protected StrategyFeature.StrategyFeatureBuilder strategyFeature;
		
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
		@RuneAttribute("optionType")
		public EquityOptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("equityEffectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityEffectiveDate")
		public ZonedDateTime getEquityEffectiveDate() {
			return equityEffectiveDate;
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
		@RosettaAttribute("equityExercise")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("equityExercise")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getEquityExercise() {
			return equityExercise;
		}
		
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getOrCreateEquityExercise() {
			EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder result;
			if (equityExercise!=null) {
				result = equityExercise;
			}
			else {
				result = equityExercise = EquityExerciseValuationSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feature")
		public OptionFeatures.OptionFeaturesBuilder getFeature() {
			return feature;
		}
		
		@Override
		public OptionFeatures.OptionFeaturesBuilder getOrCreateFeature() {
			OptionFeatures.OptionFeaturesBuilder result;
			if (feature!=null) {
				result = feature;
			}
			else {
				result = feature = OptionFeatures.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxFeature")
		public FxFeature.FxFeatureBuilder getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder getOrCreateFxFeature() {
			FxFeature.FxFeatureBuilder result;
			if (fxFeature!=null) {
				result = fxFeature;
			}
			else {
				result = fxFeature = FxFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strategyFeature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strategyFeature")
		public StrategyFeature.StrategyFeatureBuilder getStrategyFeature() {
			return strategyFeature;
		}
		
		@Override
		public StrategyFeature.StrategyFeatureBuilder getOrCreateStrategyFeature() {
			StrategyFeature.StrategyFeatureBuilder result;
			if (strategyFeature!=null) {
				result = strategyFeature;
			}
			else {
				result = strategyFeature = StrategyFeature.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addProductId(List<? extends ProductId> productIds) {
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
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setProductId(List<? extends ProductId> productIds) {
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
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setOptionType(EquityOptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("equityEffectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityEffectiveDate")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setEquityEffectiveDate(ZonedDateTime _equityEffectiveDate) {
			this.equityEffectiveDate = _equityEffectiveDate == null ? null : _equityEffectiveDate;
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyer")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notional")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setNotional(NonNegativeMoney _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equityExercise")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("equityExercise")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setEquityExercise(EquityExerciseValuationSettlement _equityExercise) {
			this.equityExercise = _equityExercise == null ? null : _equityExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feature")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setFeature(OptionFeatures _feature) {
			this.feature = _feature == null ? null : _feature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFeature")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setFxFeature(FxFeature _fxFeature) {
			this.fxFeature = _fxFeature == null ? null : _fxFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strategyFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strategyFeature")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder setStrategyFeature(StrategyFeature _strategyFeature) {
			this.strategyFeature = _strategyFeature == null ? null : _strategyFeature.toBuilder();
			return this;
		}
		
		@Override
		public EquityDerivativeBase build() {
			return new EquityDerivativeBase.EquityDerivativeBaseImpl(this);
		}
		
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder prune() {
			super.prune();
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (equityExercise!=null && !equityExercise.prune().hasData()) equityExercise = null;
			if (feature!=null && !feature.prune().hasData()) feature = null;
			if (fxFeature!=null && !fxFeature.prune().hasData()) fxFeature = null;
			if (strategyFeature!=null && !strategyFeature.prune().hasData()) strategyFeature = null;
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
			if (getEquityEffectiveDate()!=null) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getEquityExercise()!=null && getEquityExercise().hasData()) return true;
			if (getFeature()!=null && getFeature().hasData()) return true;
			if (getFxFeature()!=null && getFxFeature().hasData()) return true;
			if (getStrategyFeature()!=null && getStrategyFeature().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityDerivativeBase.EquityDerivativeBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EquityDerivativeBase.EquityDerivativeBaseBuilder o = (EquityDerivativeBase.EquityDerivativeBaseBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getEquityExercise(), o.getEquityExercise(), this::setEquityExercise);
			merger.mergeRosetta(getFeature(), o.getFeature(), this::setFeature);
			merger.mergeRosetta(getFxFeature(), o.getFxFeature(), this::setFxFeature);
			merger.mergeRosetta(getStrategyFeature(), o.getStrategyFeature(), this::setStrategyFeature);
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getEquityEffectiveDate(), o.getEquityEffectiveDate(), this::setEquityEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityDerivativeBase _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(equityEffectiveDate, _that.getEquityEffectiveDate())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(equityExercise, _that.getEquityExercise())) return false;
			if (!Objects.equals(feature, _that.getFeature())) return false;
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(strategyFeature, _that.getStrategyFeature())) return false;
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
			_result = 31 * _result + (equityEffectiveDate != null ? equityEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (equityExercise != null ? equityExercise.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (strategyFeature != null ? strategyFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityDerivativeBaseBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"optionType=" + this.optionType + ", " +
				"equityEffectiveDate=" + this.equityEffectiveDate + ", " +
				"underlyer=" + this.underlyer + ", " +
				"notional=" + this.notional + ", " +
				"equityExercise=" + this.equityExercise + ", " +
				"feature=" + this.feature + ", " +
				"fxFeature=" + this.fxFeature + ", " +
				"strategyFeature=" + this.strategyFeature +
			'}' + " " + super.toString();
		}
	}
}

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
import fpml.consolidated.eq.shared.OptionFeatures;
import fpml.consolidated.eqd.meta.EquityDerivativeShortFormBaseMeta;
import fpml.consolidated.fpmlenum.EquityOptionTypeEnum;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.option.shared.StrategyFeature;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
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
 * Provision A type for defining short form equity option basic features.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining short form equity option basic features.
 *
 */
@RosettaDataType(value="EquityDerivativeShortFormBase", builder=EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityDerivativeShortFormBase", model="fpml", builder=EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilderImpl.class, version="2.1.1")
public interface EquityDerivativeShortFormBase extends EquityDerivativeBase {

	EquityDerivativeShortFormBaseMeta metaData = new EquityDerivativeShortFormBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines whether it is a price or level at which the option has been, or will be, struck.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines whether it is a price or level at which the option has been, or will be, struck.
	 *
	 */
	EquityStrike getStrike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The price per share, index or basket observed on the trade or effective date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The price per share, index or basket observed on the trade or effective date.
	 *
	 */
	BigDecimal getSpotPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of options comprised in the option transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of options comprised in the option transaction.
	 *
	 */
	BigDecimal getNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The equity option premium payable by the buyer to the seller.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The equity option premium payable by the buyer to the seller.
	 *
	 */
	EquityPremium getEquityPremium();

	/*********************** Build Methods  ***********************/
	EquityDerivativeShortFormBase build();
	
	EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder toBuilder();
	
	static EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder builder() {
		return new EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityDerivativeShortFormBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityDerivativeShortFormBase> getType() {
		return EquityDerivativeShortFormBase.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityDerivativeShortFormBaseBuilder extends EquityDerivativeShortFormBase, EquityDerivativeBase.EquityDerivativeBaseBuilder {
		EquityStrike.EquityStrikeBuilder getOrCreateStrike();
		@Override
		EquityStrike.EquityStrikeBuilder getStrike();
		EquityPremium.EquityPremiumBuilder getOrCreateEquityPremium();
		@Override
		EquityPremium.EquityPremiumBuilder getEquityPremium();
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setId(String id);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addProductType(ProductType productType);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addProductType(ProductType productType, int idx);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addProductType(List<? extends ProductType> productType);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setProductType(List<? extends ProductType> productType);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addProductId(ProductId productId);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addProductId(ProductId productId, int idx);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addProductId(List<? extends ProductId> productId);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setProductId(List<? extends ProductId> productId);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addAssetClass(AssetClass assetClass);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setOptionType(EquityOptionTypeEnum optionType);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEquityEffectiveDate(ZonedDateTime equityEffectiveDate);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setUnderlyer(Underlyer underlyer);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setNotional(NonNegativeMoney notional);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setFeature(OptionFeatures feature);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setFxFeature(FxFeature fxFeature);
		@Override
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setStrategyFeature(StrategyFeature strategyFeature);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setStrike(EquityStrike strike);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setSpotPrice(BigDecimal spotPrice);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setNumberOfOptions(BigDecimal numberOfOptions);
		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEquityPremium(EquityPremium equityPremium);

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
		}
		

		EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder prune();
	}

	/*********************** Immutable Implementation of EquityDerivativeShortFormBase  ***********************/
	class EquityDerivativeShortFormBaseImpl extends EquityDerivativeBase.EquityDerivativeBaseImpl implements EquityDerivativeShortFormBase {
		private final EquityStrike strike;
		private final BigDecimal spotPrice;
		private final BigDecimal numberOfOptions;
		private final EquityPremium equityPremium;
		
		protected EquityDerivativeShortFormBaseImpl(EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder builder) {
			super(builder);
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.spotPrice = builder.getSpotPrice();
			this.numberOfOptions = builder.getNumberOfOptions();
			this.equityPremium = ofNullable(builder.getEquityPremium()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public EquityStrike getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("spotPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotPrice")
		public BigDecimal getSpotPrice() {
			return spotPrice;
		}
		
		@Override
		@RosettaAttribute("numberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfOptions")
		public BigDecimal getNumberOfOptions() {
			return numberOfOptions;
		}
		
		@Override
		@RosettaAttribute("equityPremium")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityPremium")
		public EquityPremium getEquityPremium() {
			return equityPremium;
		}
		
		@Override
		public EquityDerivativeShortFormBase build() {
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder toBuilder() {
			EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getSpotPrice()).ifPresent(builder::setSpotPrice);
			ofNullable(getNumberOfOptions()).ifPresent(builder::setNumberOfOptions);
			ofNullable(getEquityPremium()).ifPresent(builder::setEquityPremium);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityDerivativeShortFormBase _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotPrice, _that.getSpotPrice())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			if (!Objects.equals(equityPremium, _that.getEquityPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotPrice != null ? spotPrice.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			_result = 31 * _result + (equityPremium != null ? equityPremium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityDerivativeShortFormBase {" +
				"strike=" + this.strike + ", " +
				"spotPrice=" + this.spotPrice + ", " +
				"numberOfOptions=" + this.numberOfOptions + ", " +
				"equityPremium=" + this.equityPremium +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityDerivativeShortFormBase  ***********************/
	class EquityDerivativeShortFormBaseBuilderImpl extends EquityDerivativeBase.EquityDerivativeBaseBuilderImpl implements EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder {
	
		protected EquityStrike.EquityStrikeBuilder strike;
		protected BigDecimal spotPrice;
		protected BigDecimal numberOfOptions;
		protected EquityPremium.EquityPremiumBuilder equityPremium;
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public EquityStrike.EquityStrikeBuilder getStrike() {
			return strike;
		}
		
		@Override
		public EquityStrike.EquityStrikeBuilder getOrCreateStrike() {
			EquityStrike.EquityStrikeBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = EquityStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotPrice")
		public BigDecimal getSpotPrice() {
			return spotPrice;
		}
		
		@Override
		@RosettaAttribute("numberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfOptions")
		public BigDecimal getNumberOfOptions() {
			return numberOfOptions;
		}
		
		@Override
		@RosettaAttribute("equityPremium")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityPremium")
		public EquityPremium.EquityPremiumBuilder getEquityPremium() {
			return equityPremium;
		}
		
		@Override
		public EquityPremium.EquityPremiumBuilder getOrCreateEquityPremium() {
			EquityPremium.EquityPremiumBuilder result;
			if (equityPremium!=null) {
				result = equityPremium;
			}
			else {
				result = equityPremium = EquityPremium.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addProductId(List<? extends ProductId> productIds) {
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
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setProductId(List<? extends ProductId> productIds) {
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
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setOptionType(EquityOptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("equityEffectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityEffectiveDate")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEquityEffectiveDate(ZonedDateTime _equityEffectiveDate) {
			this.equityEffectiveDate = _equityEffectiveDate == null ? null : _equityEffectiveDate;
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyer")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notional")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setNotional(NonNegativeMoney _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equityExercise")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("equityExercise")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEquityExercise(EquityExerciseValuationSettlement _equityExercise) {
			this.equityExercise = _equityExercise == null ? null : _equityExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feature")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setFeature(OptionFeatures _feature) {
			this.feature = _feature == null ? null : _feature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFeature")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setFxFeature(FxFeature _fxFeature) {
			this.fxFeature = _fxFeature == null ? null : _fxFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strategyFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strategyFeature")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setStrategyFeature(StrategyFeature _strategyFeature) {
			this.strategyFeature = _strategyFeature == null ? null : _strategyFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strike")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setStrike(EquityStrike _strike) {
			this.strike = _strike == null ? null : _strike.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotPrice")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setSpotPrice(BigDecimal _spotPrice) {
			this.spotPrice = _spotPrice == null ? null : _spotPrice;
			return this;
		}
		
		@RosettaAttribute("numberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfOptions")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setNumberOfOptions(BigDecimal _numberOfOptions) {
			this.numberOfOptions = _numberOfOptions == null ? null : _numberOfOptions;
			return this;
		}
		
		@RosettaAttribute("equityPremium")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityPremium")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder setEquityPremium(EquityPremium _equityPremium) {
			this.equityPremium = _equityPremium == null ? null : _equityPremium.toBuilder();
			return this;
		}
		
		@Override
		public EquityDerivativeShortFormBase build() {
			return new EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseImpl(this);
		}
		
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder prune() {
			super.prune();
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (equityPremium!=null && !equityPremium.prune().hasData()) equityPremium = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getSpotPrice()!=null) return true;
			if (getNumberOfOptions()!=null) return true;
			if (getEquityPremium()!=null && getEquityPremium().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder o = (EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder) other;
			
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getEquityPremium(), o.getEquityPremium(), this::setEquityPremium);
			
			merger.mergeBasic(getSpotPrice(), o.getSpotPrice(), this::setSpotPrice);
			merger.mergeBasic(getNumberOfOptions(), o.getNumberOfOptions(), this::setNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityDerivativeShortFormBase _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotPrice, _that.getSpotPrice())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			if (!Objects.equals(equityPremium, _that.getEquityPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotPrice != null ? spotPrice.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			_result = 31 * _result + (equityPremium != null ? equityPremium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityDerivativeShortFormBaseBuilder {" +
				"strike=" + this.strike + ", " +
				"spotPrice=" + this.spotPrice + ", " +
				"numberOfOptions=" + this.numberOfOptions + ", " +
				"equityPremium=" + this.equityPremium +
			'}' + " " + super.toString();
		}
	}
}

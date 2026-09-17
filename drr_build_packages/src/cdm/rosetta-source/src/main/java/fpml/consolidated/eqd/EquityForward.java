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
import fpml.consolidated.eq.shared.DividendConditions;
import fpml.consolidated.eq.shared.ExtraordinaryEvents;
import fpml.consolidated.eq.shared.OptionFeatures;
import fpml.consolidated.eqd.meta.EquityForwardMeta;
import fpml.consolidated.fpmlenum.EquityOptionTypeEnum;
import fpml.consolidated.fpmlenum.MethodOfAdjustmentEnum;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.option.shared.StrategyFeature;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
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
 * Provision A type for defining equity forwards.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining equity forwards.
 *
 */
@RosettaDataType(value="EquityForward", builder=EquityForward.EquityForwardBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityForward", model="fpml", builder=EquityForward.EquityForwardBuilderImpl.class, version="2.1.1")
public interface EquityForward extends EquityDerivativeLongFormBase {

	EquityForwardMeta metaData = new EquityForwardMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The forward price per share, index or basket.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The forward price per share, index or basket.
	 *
	 */
	NonNegativeMoney getForwardPrice();

	/*********************** Build Methods  ***********************/
	EquityForward build();
	
	EquityForward.EquityForwardBuilder toBuilder();
	
	static EquityForward.EquityForwardBuilder builder() {
		return new EquityForward.EquityForwardBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityForward> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityForward> getType() {
		return EquityForward.class;
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
		processRosetta(path.newSubPath("dividendConditions"), processor, DividendConditions.class, getDividendConditions());
		processor.processBasic(path.newSubPath("methodOfAdjustment"), MethodOfAdjustmentEnum.class, getMethodOfAdjustment(), this);
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
		processRosetta(path.newSubPath("forwardPrice"), processor, NonNegativeMoney.class, getForwardPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityForwardBuilder extends EquityForward, EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateForwardPrice();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getForwardPrice();
		@Override
		EquityForward.EquityForwardBuilder setId(String id);
		@Override
		EquityForward.EquityForwardBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		EquityForward.EquityForwardBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		EquityForward.EquityForwardBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		EquityForward.EquityForwardBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquityForward.EquityForwardBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquityForward.EquityForwardBuilder addProductType(ProductType productType);
		@Override
		EquityForward.EquityForwardBuilder addProductType(ProductType productType, int idx);
		@Override
		EquityForward.EquityForwardBuilder addProductType(List<? extends ProductType> productType);
		@Override
		EquityForward.EquityForwardBuilder setProductType(List<? extends ProductType> productType);
		@Override
		EquityForward.EquityForwardBuilder addProductId(ProductId productId);
		@Override
		EquityForward.EquityForwardBuilder addProductId(ProductId productId, int idx);
		@Override
		EquityForward.EquityForwardBuilder addProductId(List<? extends ProductId> productId);
		@Override
		EquityForward.EquityForwardBuilder setProductId(List<? extends ProductId> productId);
		@Override
		EquityForward.EquityForwardBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		EquityForward.EquityForwardBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		EquityForward.EquityForwardBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquityForward.EquityForwardBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquityForward.EquityForwardBuilder addAssetClass(AssetClass assetClass);
		@Override
		EquityForward.EquityForwardBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		EquityForward.EquityForwardBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		EquityForward.EquityForwardBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		EquityForward.EquityForwardBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		EquityForward.EquityForwardBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		EquityForward.EquityForwardBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		EquityForward.EquityForwardBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		@Override
		EquityForward.EquityForwardBuilder setOptionType(EquityOptionTypeEnum optionType);
		@Override
		EquityForward.EquityForwardBuilder setEquityEffectiveDate(ZonedDateTime equityEffectiveDate);
		@Override
		EquityForward.EquityForwardBuilder setUnderlyer(Underlyer underlyer);
		@Override
		EquityForward.EquityForwardBuilder setNotional(NonNegativeMoney notional);
		@Override
		EquityForward.EquityForwardBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		@Override
		EquityForward.EquityForwardBuilder setFeature(OptionFeatures feature);
		@Override
		EquityForward.EquityForwardBuilder setFxFeature(FxFeature fxFeature);
		@Override
		EquityForward.EquityForwardBuilder setStrategyFeature(StrategyFeature strategyFeature);
		@Override
		EquityForward.EquityForwardBuilder setDividendConditions(DividendConditions dividendConditions);
		@Override
		EquityForward.EquityForwardBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment);
		@Override
		EquityForward.EquityForwardBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);
		EquityForward.EquityForwardBuilder setForwardPrice(NonNegativeMoney forwardPrice);

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
			processRosetta(path.newSubPath("dividendConditions"), processor, DividendConditions.DividendConditionsBuilder.class, getDividendConditions());
			processor.processBasic(path.newSubPath("methodOfAdjustment"), MethodOfAdjustmentEnum.class, getMethodOfAdjustment(), this);
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
			processRosetta(path.newSubPath("forwardPrice"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getForwardPrice());
		}
		

		EquityForward.EquityForwardBuilder prune();
	}

	/*********************** Immutable Implementation of EquityForward  ***********************/
	class EquityForwardImpl extends EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseImpl implements EquityForward {
		private final NonNegativeMoney forwardPrice;
		
		protected EquityForwardImpl(EquityForward.EquityForwardBuilder builder) {
			super(builder);
			this.forwardPrice = ofNullable(builder.getForwardPrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("forwardPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forwardPrice")
		public NonNegativeMoney getForwardPrice() {
			return forwardPrice;
		}
		
		@Override
		public EquityForward build() {
			return this;
		}
		
		@Override
		public EquityForward.EquityForwardBuilder toBuilder() {
			EquityForward.EquityForwardBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityForward.EquityForwardBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getForwardPrice()).ifPresent(builder::setForwardPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityForward _that = getType().cast(o);
		
			if (!Objects.equals(forwardPrice, _that.getForwardPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (forwardPrice != null ? forwardPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityForward {" +
				"forwardPrice=" + this.forwardPrice +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityForward  ***********************/
	class EquityForwardBuilderImpl extends EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilderImpl implements EquityForward.EquityForwardBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder forwardPrice;
		
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EquityForward.EquityForwardBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public EquityForward.EquityForwardBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public EquityForward.EquityForwardBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityForward.EquityForwardBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquityForward.EquityForwardBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquityForward.EquityForwardBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquityForward.EquityForwardBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityForward.EquityForwardBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public EquityForward.EquityForwardBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public EquityForward.EquityForwardBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public EquityForward.EquityForwardBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityForward.EquityForwardBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public EquityForward.EquityForwardBuilder addProductId(List<? extends ProductId> productIds) {
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
		public EquityForward.EquityForwardBuilder setProductId(List<? extends ProductId> productIds) {
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
		public EquityForward.EquityForwardBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityForward.EquityForwardBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public EquityForward.EquityForwardBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquityForward.EquityForwardBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquityForward.EquityForwardBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityForward.EquityForwardBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquityForward.EquityForwardBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public EquityForward.EquityForwardBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public EquityForward.EquityForwardBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public EquityForward.EquityForwardBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public EquityForward.EquityForwardBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public EquityForward.EquityForwardBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public EquityForward.EquityForwardBuilder setOptionType(EquityOptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("equityEffectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityEffectiveDate")
		@Override
		public EquityForward.EquityForwardBuilder setEquityEffectiveDate(ZonedDateTime _equityEffectiveDate) {
			this.equityEffectiveDate = _equityEffectiveDate == null ? null : _equityEffectiveDate;
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyer")
		@Override
		public EquityForward.EquityForwardBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notional")
		@Override
		public EquityForward.EquityForwardBuilder setNotional(NonNegativeMoney _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equityExercise")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("equityExercise")
		@Override
		public EquityForward.EquityForwardBuilder setEquityExercise(EquityExerciseValuationSettlement _equityExercise) {
			this.equityExercise = _equityExercise == null ? null : _equityExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feature")
		@Override
		public EquityForward.EquityForwardBuilder setFeature(OptionFeatures _feature) {
			this.feature = _feature == null ? null : _feature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFeature")
		@Override
		public EquityForward.EquityForwardBuilder setFxFeature(FxFeature _fxFeature) {
			this.fxFeature = _fxFeature == null ? null : _fxFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strategyFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strategyFeature")
		@Override
		public EquityForward.EquityForwardBuilder setStrategyFeature(StrategyFeature _strategyFeature) {
			this.strategyFeature = _strategyFeature == null ? null : _strategyFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dividendConditions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendConditions")
		@Override
		public EquityForward.EquityForwardBuilder setDividendConditions(DividendConditions _dividendConditions) {
			this.dividendConditions = _dividendConditions == null ? null : _dividendConditions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("methodOfAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("methodOfAdjustment")
		@Override
		public EquityForward.EquityForwardBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum _methodOfAdjustment) {
			this.methodOfAdjustment = _methodOfAdjustment == null ? null : _methodOfAdjustment;
			return this;
		}
		
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extraordinaryEvents")
		@Override
		public EquityForward.EquityForwardBuilder setExtraordinaryEvents(ExtraordinaryEvents _extraordinaryEvents) {
			this.extraordinaryEvents = _extraordinaryEvents == null ? null : _extraordinaryEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("forwardPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forwardPrice")
		@Override
		public EquityForward.EquityForwardBuilder setForwardPrice(NonNegativeMoney _forwardPrice) {
			this.forwardPrice = _forwardPrice == null ? null : _forwardPrice.toBuilder();
			return this;
		}
		
		@Override
		public EquityForward build() {
			return new EquityForward.EquityForwardImpl(this);
		}
		
		@Override
		public EquityForward.EquityForwardBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityForward.EquityForwardBuilder prune() {
			super.prune();
			if (forwardPrice!=null && !forwardPrice.prune().hasData()) forwardPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getForwardPrice()!=null && getForwardPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityForward.EquityForwardBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EquityForward.EquityForwardBuilder o = (EquityForward.EquityForwardBuilder) other;
			
			merger.mergeRosetta(getForwardPrice(), o.getForwardPrice(), this::setForwardPrice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityForward _that = getType().cast(o);
		
			if (!Objects.equals(forwardPrice, _that.getForwardPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (forwardPrice != null ? forwardPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityForwardBuilder {" +
				"forwardPrice=" + this.forwardPrice +
			'}' + " " + super.toString();
		}
	}
}

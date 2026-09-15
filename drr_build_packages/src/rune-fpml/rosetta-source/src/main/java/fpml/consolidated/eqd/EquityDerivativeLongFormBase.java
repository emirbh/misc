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
import fpml.consolidated.eqd.meta.EquityDerivativeLongFormBaseMeta;
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
 * Provision type for defining the common features of equity derivatives.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision type for defining the common features of equity derivatives.
 *
 */
@RosettaDataType(value="EquityDerivativeLongFormBase", builder=EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityDerivativeLongFormBase", model="fpml", builder=EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilderImpl.class, version="2.1.1")
public interface EquityDerivativeLongFormBase extends EquityDerivativeBase {

	EquityDerivativeLongFormBaseMeta metaData = new EquityDerivativeLongFormBaseMeta();

	/*********************** Getter Methods  ***********************/
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
	DividendConditions getDividendConditions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines how adjustments will be made to the contract should one or more of the extraordinary events occur.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines how adjustments will be made to the contract should one or more of the extraordinary events occur.
	 *
	 */
	MethodOfAdjustmentEnum getMethodOfAdjustment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Where the underlying is shares, specifies events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Where the underlying is shares, specifies events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
	 *
	 */
	ExtraordinaryEvents getExtraordinaryEvents();

	/*********************** Build Methods  ***********************/
	EquityDerivativeLongFormBase build();
	
	EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder toBuilder();
	
	static EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder builder() {
		return new EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityDerivativeLongFormBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityDerivativeLongFormBase> getType() {
		return EquityDerivativeLongFormBase.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityDerivativeLongFormBaseBuilder extends EquityDerivativeLongFormBase, EquityDerivativeBase.EquityDerivativeBaseBuilder {
		DividendConditions.DividendConditionsBuilder getOrCreateDividendConditions();
		@Override
		DividendConditions.DividendConditionsBuilder getDividendConditions();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents();
		@Override
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents();
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setId(String id);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addProductType(ProductType productType);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addProductType(ProductType productType, int idx);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addProductType(List<? extends ProductType> productType);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setProductType(List<? extends ProductType> productType);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addProductId(ProductId productId);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addProductId(ProductId productId, int idx);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addProductId(List<? extends ProductId> productId);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setProductId(List<? extends ProductId> productId);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addAssetClass(AssetClass assetClass);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setOptionType(EquityOptionTypeEnum optionType);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setEquityEffectiveDate(ZonedDateTime equityEffectiveDate);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setUnderlyer(Underlyer underlyer);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setNotional(NonNegativeMoney notional);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setFeature(OptionFeatures feature);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setFxFeature(FxFeature fxFeature);
		@Override
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setStrategyFeature(StrategyFeature strategyFeature);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setDividendConditions(DividendConditions dividendConditions);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment);
		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);

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
		}
		

		EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder prune();
	}

	/*********************** Immutable Implementation of EquityDerivativeLongFormBase  ***********************/
	class EquityDerivativeLongFormBaseImpl extends EquityDerivativeBase.EquityDerivativeBaseImpl implements EquityDerivativeLongFormBase {
		private final DividendConditions dividendConditions;
		private final MethodOfAdjustmentEnum methodOfAdjustment;
		private final ExtraordinaryEvents extraordinaryEvents;
		
		protected EquityDerivativeLongFormBaseImpl(EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder builder) {
			super(builder);
			this.dividendConditions = ofNullable(builder.getDividendConditions()).map(f->f.build()).orElse(null);
			this.methodOfAdjustment = builder.getMethodOfAdjustment();
			this.extraordinaryEvents = ofNullable(builder.getExtraordinaryEvents()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dividendConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendConditions")
		public DividendConditions getDividendConditions() {
			return dividendConditions;
		}
		
		@Override
		@RosettaAttribute("methodOfAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("methodOfAdjustment")
		public MethodOfAdjustmentEnum getMethodOfAdjustment() {
			return methodOfAdjustment;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extraordinaryEvents")
		public ExtraordinaryEvents getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public EquityDerivativeLongFormBase build() {
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder toBuilder() {
			EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDividendConditions()).ifPresent(builder::setDividendConditions);
			ofNullable(getMethodOfAdjustment()).ifPresent(builder::setMethodOfAdjustment);
			ofNullable(getExtraordinaryEvents()).ifPresent(builder::setExtraordinaryEvents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityDerivativeLongFormBase _that = getType().cast(o);
		
			if (!Objects.equals(dividendConditions, _that.getDividendConditions())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dividendConditions != null ? dividendConditions.hashCode() : 0);
			_result = 31 * _result + (methodOfAdjustment != null ? methodOfAdjustment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityDerivativeLongFormBase {" +
				"dividendConditions=" + this.dividendConditions + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityDerivativeLongFormBase  ***********************/
	class EquityDerivativeLongFormBaseBuilderImpl extends EquityDerivativeBase.EquityDerivativeBaseBuilderImpl implements EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder {
	
		protected DividendConditions.DividendConditionsBuilder dividendConditions;
		protected MethodOfAdjustmentEnum methodOfAdjustment;
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents;
		
		@Override
		@RosettaAttribute("dividendConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendConditions")
		public DividendConditions.DividendConditionsBuilder getDividendConditions() {
			return dividendConditions;
		}
		
		@Override
		public DividendConditions.DividendConditionsBuilder getOrCreateDividendConditions() {
			DividendConditions.DividendConditionsBuilder result;
			if (dividendConditions!=null) {
				result = dividendConditions;
			}
			else {
				result = dividendConditions = DividendConditions.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("methodOfAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("methodOfAdjustment")
		public MethodOfAdjustmentEnum getMethodOfAdjustment() {
			return methodOfAdjustment;
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
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addProductId(List<? extends ProductId> productIds) {
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
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setProductId(List<? extends ProductId> productIds) {
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
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setOptionType(EquityOptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("equityEffectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityEffectiveDate")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setEquityEffectiveDate(ZonedDateTime _equityEffectiveDate) {
			this.equityEffectiveDate = _equityEffectiveDate == null ? null : _equityEffectiveDate;
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyer")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notional")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setNotional(NonNegativeMoney _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equityExercise")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("equityExercise")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setEquityExercise(EquityExerciseValuationSettlement _equityExercise) {
			this.equityExercise = _equityExercise == null ? null : _equityExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feature")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setFeature(OptionFeatures _feature) {
			this.feature = _feature == null ? null : _feature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFeature")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setFxFeature(FxFeature _fxFeature) {
			this.fxFeature = _fxFeature == null ? null : _fxFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strategyFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strategyFeature")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setStrategyFeature(StrategyFeature _strategyFeature) {
			this.strategyFeature = _strategyFeature == null ? null : _strategyFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dividendConditions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendConditions")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setDividendConditions(DividendConditions _dividendConditions) {
			this.dividendConditions = _dividendConditions == null ? null : _dividendConditions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("methodOfAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("methodOfAdjustment")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum _methodOfAdjustment) {
			this.methodOfAdjustment = _methodOfAdjustment == null ? null : _methodOfAdjustment;
			return this;
		}
		
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extraordinaryEvents")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder setExtraordinaryEvents(ExtraordinaryEvents _extraordinaryEvents) {
			this.extraordinaryEvents = _extraordinaryEvents == null ? null : _extraordinaryEvents.toBuilder();
			return this;
		}
		
		@Override
		public EquityDerivativeLongFormBase build() {
			return new EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseImpl(this);
		}
		
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder prune() {
			super.prune();
			if (dividendConditions!=null && !dividendConditions.prune().hasData()) dividendConditions = null;
			if (extraordinaryEvents!=null && !extraordinaryEvents.prune().hasData()) extraordinaryEvents = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDividendConditions()!=null && getDividendConditions().hasData()) return true;
			if (getMethodOfAdjustment()!=null) return true;
			if (getExtraordinaryEvents()!=null && getExtraordinaryEvents().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder o = (EquityDerivativeLongFormBase.EquityDerivativeLongFormBaseBuilder) other;
			
			merger.mergeRosetta(getDividendConditions(), o.getDividendConditions(), this::setDividendConditions);
			merger.mergeRosetta(getExtraordinaryEvents(), o.getExtraordinaryEvents(), this::setExtraordinaryEvents);
			
			merger.mergeBasic(getMethodOfAdjustment(), o.getMethodOfAdjustment(), this::setMethodOfAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityDerivativeLongFormBase _that = getType().cast(o);
		
			if (!Objects.equals(dividendConditions, _that.getDividendConditions())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dividendConditions != null ? dividendConditions.hashCode() : 0);
			_result = 31 * _result + (methodOfAdjustment != null ? methodOfAdjustment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityDerivativeLongFormBaseBuilder {" +
				"dividendConditions=" + this.dividendConditions + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}
}

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
import fpml.consolidated.eqd.meta.BrokerEquityOptionMeta;
import fpml.consolidated.fpmlenum.EquityOptionTypeEnum;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.option.shared.StrategyFeature;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Money;
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
 * Provision A type for defining the broker equity options.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining the broker equity options.
 *
 */
@RosettaDataType(value="BrokerEquityOption", builder=BrokerEquityOption.BrokerEquityOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BrokerEquityOption", model="fpml", builder=BrokerEquityOption.BrokerEquityOptionBuilderImpl.class, version="2.1.1")
public interface BrokerEquityOption extends EquityDerivativeShortFormBase {

	BrokerEquityOptionMeta metaData = new BrokerEquityOptionMeta();

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
	Boolean getDeltaCrossed();
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
	Money getBrokerageFee();
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
	String getBrokerNotes();

	/*********************** Build Methods  ***********************/
	BrokerEquityOption build();
	
	BrokerEquityOption.BrokerEquityOptionBuilder toBuilder();
	
	static BrokerEquityOption.BrokerEquityOptionBuilder builder() {
		return new BrokerEquityOption.BrokerEquityOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BrokerEquityOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BrokerEquityOption> getType() {
		return BrokerEquityOption.class;
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
		processor.processBasic(path.newSubPath("deltaCrossed"), Boolean.class, getDeltaCrossed(), this);
		processRosetta(path.newSubPath("brokerageFee"), processor, Money.class, getBrokerageFee());
		processor.processBasic(path.newSubPath("brokerNotes"), String.class, getBrokerNotes(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BrokerEquityOptionBuilder extends BrokerEquityOption, EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilder {
		Money.MoneyBuilder getOrCreateBrokerageFee();
		@Override
		Money.MoneyBuilder getBrokerageFee();
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setId(String id);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addProductType(ProductType productType);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addProductType(ProductType productType, int idx);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addProductType(List<? extends ProductType> productType);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setProductType(List<? extends ProductType> productType);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addProductId(ProductId productId);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addProductId(ProductId productId, int idx);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addProductId(List<? extends ProductId> productId);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setProductId(List<? extends ProductId> productId);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addAssetClass(AssetClass assetClass);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setOptionType(EquityOptionTypeEnum optionType);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setEquityEffectiveDate(ZonedDateTime equityEffectiveDate);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setUnderlyer(Underlyer underlyer);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setNotional(NonNegativeMoney notional);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setFeature(OptionFeatures feature);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setFxFeature(FxFeature fxFeature);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setStrategyFeature(StrategyFeature strategyFeature);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setStrike(EquityStrike strike);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setSpotPrice(BigDecimal spotPrice);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setNumberOfOptions(BigDecimal numberOfOptions);
		@Override
		BrokerEquityOption.BrokerEquityOptionBuilder setEquityPremium(EquityPremium equityPremium);
		BrokerEquityOption.BrokerEquityOptionBuilder setDeltaCrossed(Boolean deltaCrossed);
		BrokerEquityOption.BrokerEquityOptionBuilder setBrokerageFee(Money brokerageFee);
		BrokerEquityOption.BrokerEquityOptionBuilder setBrokerNotes(String brokerNotes);

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
			processor.processBasic(path.newSubPath("deltaCrossed"), Boolean.class, getDeltaCrossed(), this);
			processRosetta(path.newSubPath("brokerageFee"), processor, Money.MoneyBuilder.class, getBrokerageFee());
			processor.processBasic(path.newSubPath("brokerNotes"), String.class, getBrokerNotes(), this);
		}
		

		BrokerEquityOption.BrokerEquityOptionBuilder prune();
	}

	/*********************** Immutable Implementation of BrokerEquityOption  ***********************/
	class BrokerEquityOptionImpl extends EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseImpl implements BrokerEquityOption {
		private final Boolean deltaCrossed;
		private final Money brokerageFee;
		private final String brokerNotes;
		
		protected BrokerEquityOptionImpl(BrokerEquityOption.BrokerEquityOptionBuilder builder) {
			super(builder);
			this.deltaCrossed = builder.getDeltaCrossed();
			this.brokerageFee = ofNullable(builder.getBrokerageFee()).map(f->f.build()).orElse(null);
			this.brokerNotes = builder.getBrokerNotes();
		}
		
		@Override
		@RosettaAttribute("deltaCrossed")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deltaCrossed")
		public Boolean getDeltaCrossed() {
			return deltaCrossed;
		}
		
		@Override
		@RosettaAttribute("brokerageFee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerageFee")
		public Money getBrokerageFee() {
			return brokerageFee;
		}
		
		@Override
		@RosettaAttribute("brokerNotes")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerNotes")
		public String getBrokerNotes() {
			return brokerNotes;
		}
		
		@Override
		public BrokerEquityOption build() {
			return this;
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder toBuilder() {
			BrokerEquityOption.BrokerEquityOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BrokerEquityOption.BrokerEquityOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeltaCrossed()).ifPresent(builder::setDeltaCrossed);
			ofNullable(getBrokerageFee()).ifPresent(builder::setBrokerageFee);
			ofNullable(getBrokerNotes()).ifPresent(builder::setBrokerNotes);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BrokerEquityOption _that = getType().cast(o);
		
			if (!Objects.equals(deltaCrossed, _that.getDeltaCrossed())) return false;
			if (!Objects.equals(brokerageFee, _that.getBrokerageFee())) return false;
			if (!Objects.equals(brokerNotes, _that.getBrokerNotes())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deltaCrossed != null ? deltaCrossed.hashCode() : 0);
			_result = 31 * _result + (brokerageFee != null ? brokerageFee.hashCode() : 0);
			_result = 31 * _result + (brokerNotes != null ? brokerNotes.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BrokerEquityOption {" +
				"deltaCrossed=" + this.deltaCrossed + ", " +
				"brokerageFee=" + this.brokerageFee + ", " +
				"brokerNotes=" + this.brokerNotes +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BrokerEquityOption  ***********************/
	class BrokerEquityOptionBuilderImpl extends EquityDerivativeShortFormBase.EquityDerivativeShortFormBaseBuilderImpl implements BrokerEquityOption.BrokerEquityOptionBuilder {
	
		protected Boolean deltaCrossed;
		protected Money.MoneyBuilder brokerageFee;
		protected String brokerNotes;
		
		@Override
		@RosettaAttribute("deltaCrossed")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deltaCrossed")
		public Boolean getDeltaCrossed() {
			return deltaCrossed;
		}
		
		@Override
		@RosettaAttribute("brokerageFee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerageFee")
		public Money.MoneyBuilder getBrokerageFee() {
			return brokerageFee;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateBrokerageFee() {
			Money.MoneyBuilder result;
			if (brokerageFee!=null) {
				result = brokerageFee;
			}
			else {
				result = brokerageFee = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("brokerNotes")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerNotes")
		public String getBrokerNotes() {
			return brokerNotes;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public BrokerEquityOption.BrokerEquityOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public BrokerEquityOption.BrokerEquityOptionBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public BrokerEquityOption.BrokerEquityOptionBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public BrokerEquityOption.BrokerEquityOptionBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder addProductId(List<? extends ProductId> productIds) {
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
		public BrokerEquityOption.BrokerEquityOptionBuilder setProductId(List<? extends ProductId> productIds) {
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
		public BrokerEquityOption.BrokerEquityOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public BrokerEquityOption.BrokerEquityOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public BrokerEquityOption.BrokerEquityOptionBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public BrokerEquityOption.BrokerEquityOptionBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public BrokerEquityOption.BrokerEquityOptionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setOptionType(EquityOptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("equityEffectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityEffectiveDate")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setEquityEffectiveDate(ZonedDateTime _equityEffectiveDate) {
			this.equityEffectiveDate = _equityEffectiveDate == null ? null : _equityEffectiveDate;
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyer")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setUnderlyer(Underlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notional")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setNotional(NonNegativeMoney _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equityExercise")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("equityExercise")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setEquityExercise(EquityExerciseValuationSettlement _equityExercise) {
			this.equityExercise = _equityExercise == null ? null : _equityExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feature")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setFeature(OptionFeatures _feature) {
			this.feature = _feature == null ? null : _feature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFeature")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setFxFeature(FxFeature _fxFeature) {
			this.fxFeature = _fxFeature == null ? null : _fxFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strategyFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strategyFeature")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setStrategyFeature(StrategyFeature _strategyFeature) {
			this.strategyFeature = _strategyFeature == null ? null : _strategyFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strike")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setStrike(EquityStrike _strike) {
			this.strike = _strike == null ? null : _strike.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotPrice")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setSpotPrice(BigDecimal _spotPrice) {
			this.spotPrice = _spotPrice == null ? null : _spotPrice;
			return this;
		}
		
		@RosettaAttribute("numberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfOptions")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setNumberOfOptions(BigDecimal _numberOfOptions) {
			this.numberOfOptions = _numberOfOptions == null ? null : _numberOfOptions;
			return this;
		}
		
		@RosettaAttribute("equityPremium")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityPremium")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setEquityPremium(EquityPremium _equityPremium) {
			this.equityPremium = _equityPremium == null ? null : _equityPremium.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deltaCrossed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deltaCrossed")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setDeltaCrossed(Boolean _deltaCrossed) {
			this.deltaCrossed = _deltaCrossed == null ? null : _deltaCrossed;
			return this;
		}
		
		@RosettaAttribute("brokerageFee")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerageFee")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setBrokerageFee(Money _brokerageFee) {
			this.brokerageFee = _brokerageFee == null ? null : _brokerageFee.toBuilder();
			return this;
		}
		
		@RosettaAttribute("brokerNotes")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerNotes")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder setBrokerNotes(String _brokerNotes) {
			this.brokerNotes = _brokerNotes == null ? null : _brokerNotes;
			return this;
		}
		
		@Override
		public BrokerEquityOption build() {
			return new BrokerEquityOption.BrokerEquityOptionImpl(this);
		}
		
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder prune() {
			super.prune();
			if (brokerageFee!=null && !brokerageFee.prune().hasData()) brokerageFee = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeltaCrossed()!=null) return true;
			if (getBrokerageFee()!=null && getBrokerageFee().hasData()) return true;
			if (getBrokerNotes()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BrokerEquityOption.BrokerEquityOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			BrokerEquityOption.BrokerEquityOptionBuilder o = (BrokerEquityOption.BrokerEquityOptionBuilder) other;
			
			merger.mergeRosetta(getBrokerageFee(), o.getBrokerageFee(), this::setBrokerageFee);
			
			merger.mergeBasic(getDeltaCrossed(), o.getDeltaCrossed(), this::setDeltaCrossed);
			merger.mergeBasic(getBrokerNotes(), o.getBrokerNotes(), this::setBrokerNotes);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BrokerEquityOption _that = getType().cast(o);
		
			if (!Objects.equals(deltaCrossed, _that.getDeltaCrossed())) return false;
			if (!Objects.equals(brokerageFee, _that.getBrokerageFee())) return false;
			if (!Objects.equals(brokerNotes, _that.getBrokerNotes())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deltaCrossed != null ? deltaCrossed.hashCode() : 0);
			_result = 31 * _result + (brokerageFee != null ? brokerageFee.hashCode() : 0);
			_result = 31 * _result + (brokerNotes != null ? brokerNotes.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BrokerEquityOptionBuilder {" +
				"deltaCrossed=" + this.deltaCrossed + ", " +
				"brokerageFee=" + this.brokerageFee + ", " +
				"brokerNotes=" + this.brokerNotes +
			'}' + " " + super.toString();
		}
	}
}

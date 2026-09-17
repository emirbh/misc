package fpml.consolidated.bond.option;

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
import fpml.consolidated.asset.Bond;
import fpml.consolidated.asset.ConvertibleBond;
import fpml.consolidated.bond.option.meta.BondOptionMeta;
import fpml.consolidated.fpmlenum.OptionTypeEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.option.shared.OptionBaseExtended;
import fpml.consolidated.option.shared.OptionFeature;
import fpml.consolidated.option.shared.Premium;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NotionalAmountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.math.BigDecimal;
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
 * Provision A Bond Option
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A Bond Option
 *
 */
@RosettaDataType(value="BondOption", builder=BondOption.BondOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BondOption", model="fpml", builder=BondOption.BondOptionBuilderImpl.class, version="2.1.1")
public interface BondOption extends OptionBaseExtended {

	BondOptionMeta metaData = new BondOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Strike of the the Bond Option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Strike of the the Bond Option.
	 *
	 */
	BondOptionStrike getStrike();
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
	Bond getBond();
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
	ConvertibleBond getConvertibleBond();

	/*********************** Build Methods  ***********************/
	BondOption build();
	
	BondOption.BondOptionBuilder toBuilder();
	
	static BondOption.BondOptionBuilder builder() {
		return new BondOption.BondOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BondOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BondOption> getType() {
		return BondOption.class;
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
		processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
		processRosetta(path.newSubPath("premium"), processor, Premium.class, getPremium());
		processRosetta(path.newSubPath("exercise"), processor, Exercise.class, getExercise());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("feature"), processor, OptionFeature.class, getFeature());
		processRosetta(path.newSubPath("notionalReference"), processor, NotionalAmountReference.class, getNotionalReference());
		processRosetta(path.newSubPath("notionalAmount"), processor, Money.class, getNotionalAmount());
		processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
		processRosetta(path.newSubPath("entitlementCurrency"), processor, Currency.class, getEntitlementCurrency());
		processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementAmount"), processor, Money.class, getSettlementAmount());
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("strike"), processor, BondOptionStrike.class, getStrike());
		processRosetta(path.newSubPath("bond"), processor, Bond.class, getBond());
		processRosetta(path.newSubPath("convertibleBond"), processor, ConvertibleBond.class, getConvertibleBond());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BondOptionBuilder extends BondOption, OptionBaseExtended.OptionBaseExtendedBuilder {
		BondOptionStrike.BondOptionStrikeBuilder getOrCreateStrike();
		@Override
		BondOptionStrike.BondOptionStrikeBuilder getStrike();
		Bond.BondBuilder getOrCreateBond();
		@Override
		Bond.BondBuilder getBond();
		ConvertibleBond.ConvertibleBondBuilder getOrCreateConvertibleBond();
		@Override
		ConvertibleBond.ConvertibleBondBuilder getConvertibleBond();
		@Override
		BondOption.BondOptionBuilder setId(String id);
		@Override
		BondOption.BondOptionBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		BondOption.BondOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		BondOption.BondOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		BondOption.BondOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		BondOption.BondOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		BondOption.BondOptionBuilder addProductType(ProductType productType);
		@Override
		BondOption.BondOptionBuilder addProductType(ProductType productType, int idx);
		@Override
		BondOption.BondOptionBuilder addProductType(List<? extends ProductType> productType);
		@Override
		BondOption.BondOptionBuilder setProductType(List<? extends ProductType> productType);
		@Override
		BondOption.BondOptionBuilder addProductId(ProductId productId);
		@Override
		BondOption.BondOptionBuilder addProductId(ProductId productId, int idx);
		@Override
		BondOption.BondOptionBuilder addProductId(List<? extends ProductId> productId);
		@Override
		BondOption.BondOptionBuilder setProductId(List<? extends ProductId> productId);
		@Override
		BondOption.BondOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		BondOption.BondOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		BondOption.BondOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		BondOption.BondOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		BondOption.BondOptionBuilder addAssetClass(AssetClass assetClass);
		@Override
		BondOption.BondOptionBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		BondOption.BondOptionBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		BondOption.BondOptionBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		BondOption.BondOptionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		BondOption.BondOptionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		BondOption.BondOptionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		BondOption.BondOptionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		@Override
		BondOption.BondOptionBuilder setOptionType(OptionTypeEnum optionType);
		@Override
		BondOption.BondOptionBuilder setPremium(Premium premium);
		@Override
		BondOption.BondOptionBuilder setExercise(Exercise exercise);
		@Override
		BondOption.BondOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		@Override
		BondOption.BondOptionBuilder setFeature(OptionFeature feature);
		@Override
		BondOption.BondOptionBuilder setNotionalReference(NotionalAmountReference notionalReference);
		@Override
		BondOption.BondOptionBuilder setNotionalAmount(Money notionalAmount);
		@Override
		BondOption.BondOptionBuilder setOptionEntitlement(BigDecimal optionEntitlement);
		@Override
		BondOption.BondOptionBuilder setEntitlementCurrency(Currency entitlementCurrency);
		@Override
		BondOption.BondOptionBuilder setNumberOfOptions(BigDecimal numberOfOptions);
		@Override
		BondOption.BondOptionBuilder setSettlementType(SettlementTypeEnum settlementType);
		@Override
		BondOption.BondOptionBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		@Override
		BondOption.BondOptionBuilder setSettlementAmount(Money settlementAmount);
		@Override
		BondOption.BondOptionBuilder setSettlementCurrency(Currency settlementCurrency);
		BondOption.BondOptionBuilder setStrike(BondOptionStrike strike);
		BondOption.BondOptionBuilder setBond(Bond bond);
		BondOption.BondOptionBuilder setConvertibleBond(ConvertibleBond convertibleBond);

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
			processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
			processRosetta(path.newSubPath("premium"), processor, Premium.PremiumBuilder.class, getPremium());
			processRosetta(path.newSubPath("exercise"), processor, Exercise.ExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("feature"), processor, OptionFeature.OptionFeatureBuilder.class, getFeature());
			processRosetta(path.newSubPath("notionalReference"), processor, NotionalAmountReference.NotionalAmountReferenceBuilder.class, getNotionalReference());
			processRosetta(path.newSubPath("notionalAmount"), processor, Money.MoneyBuilder.class, getNotionalAmount());
			processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
			processRosetta(path.newSubPath("entitlementCurrency"), processor, Currency.CurrencyBuilder.class, getEntitlementCurrency());
			processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementAmount"), processor, Money.MoneyBuilder.class, getSettlementAmount());
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("strike"), processor, BondOptionStrike.BondOptionStrikeBuilder.class, getStrike());
			processRosetta(path.newSubPath("bond"), processor, Bond.BondBuilder.class, getBond());
			processRosetta(path.newSubPath("convertibleBond"), processor, ConvertibleBond.ConvertibleBondBuilder.class, getConvertibleBond());
		}
		

		BondOption.BondOptionBuilder prune();
	}

	/*********************** Immutable Implementation of BondOption  ***********************/
	class BondOptionImpl extends OptionBaseExtended.OptionBaseExtendedImpl implements BondOption {
		private final BondOptionStrike strike;
		private final Bond bond;
		private final ConvertibleBond convertibleBond;
		
		protected BondOptionImpl(BondOption.BondOptionBuilder builder) {
			super(builder);
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.bond = ofNullable(builder.getBond()).map(f->f.build()).orElse(null);
			this.convertibleBond = ofNullable(builder.getConvertibleBond()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("strike")
		public BondOptionStrike getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("bond")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bond")
		public Bond getBond() {
			return bond;
		}
		
		@Override
		@RosettaAttribute("convertibleBond")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("convertibleBond")
		public ConvertibleBond getConvertibleBond() {
			return convertibleBond;
		}
		
		@Override
		public BondOption build() {
			return this;
		}
		
		@Override
		public BondOption.BondOptionBuilder toBuilder() {
			BondOption.BondOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BondOption.BondOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getBond()).ifPresent(builder::setBond);
			ofNullable(getConvertibleBond()).ifPresent(builder::setConvertibleBond);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BondOption _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(bond, _that.getBond())) return false;
			if (!Objects.equals(convertibleBond, _that.getConvertibleBond())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (bond != null ? bond.hashCode() : 0);
			_result = 31 * _result + (convertibleBond != null ? convertibleBond.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondOption {" +
				"strike=" + this.strike + ", " +
				"bond=" + this.bond + ", " +
				"convertibleBond=" + this.convertibleBond +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BondOption  ***********************/
	class BondOptionBuilderImpl extends OptionBaseExtended.OptionBaseExtendedBuilderImpl implements BondOption.BondOptionBuilder {
	
		protected BondOptionStrike.BondOptionStrikeBuilder strike;
		protected Bond.BondBuilder bond;
		protected ConvertibleBond.ConvertibleBondBuilder convertibleBond;
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("strike")
		public BondOptionStrike.BondOptionStrikeBuilder getStrike() {
			return strike;
		}
		
		@Override
		public BondOptionStrike.BondOptionStrikeBuilder getOrCreateStrike() {
			BondOptionStrike.BondOptionStrikeBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = BondOptionStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bond")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bond")
		public Bond.BondBuilder getBond() {
			return bond;
		}
		
		@Override
		public Bond.BondBuilder getOrCreateBond() {
			Bond.BondBuilder result;
			if (bond!=null) {
				result = bond;
			}
			else {
				result = bond = Bond.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("convertibleBond")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("convertibleBond")
		public ConvertibleBond.ConvertibleBondBuilder getConvertibleBond() {
			return convertibleBond;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder getOrCreateConvertibleBond() {
			ConvertibleBond.ConvertibleBondBuilder result;
			if (convertibleBond!=null) {
				result = convertibleBond;
			}
			else {
				result = convertibleBond = ConvertibleBond.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public BondOption.BondOptionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public BondOption.BondOptionBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public BondOption.BondOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public BondOption.BondOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public BondOption.BondOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public BondOption.BondOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public BondOption.BondOptionBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public BondOption.BondOptionBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public BondOption.BondOptionBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public BondOption.BondOptionBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public BondOption.BondOptionBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public BondOption.BondOptionBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public BondOption.BondOptionBuilder addProductId(List<? extends ProductId> productIds) {
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
		public BondOption.BondOptionBuilder setProductId(List<? extends ProductId> productIds) {
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
		public BondOption.BondOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public BondOption.BondOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public BondOption.BondOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public BondOption.BondOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public BondOption.BondOptionBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public BondOption.BondOptionBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public BondOption.BondOptionBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public BondOption.BondOptionBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public BondOption.BondOptionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public BondOption.BondOptionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public BondOption.BondOptionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public BondOption.BondOptionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("optionType")
		@Override
		public BondOption.BondOptionBuilder setOptionType(OptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("premium")
		@Override
		public BondOption.BondOptionBuilder setPremium(Premium _premium) {
			this.premium = _premium == null ? null : _premium.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exercise")
		@Override
		public BondOption.BondOptionBuilder setExercise(Exercise _exercise) {
			this.exercise = _exercise == null ? null : _exercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseProcedure")
		@Override
		public BondOption.BondOptionBuilder setExerciseProcedure(ExerciseProcedure _exerciseProcedure) {
			this.exerciseProcedure = _exerciseProcedure == null ? null : _exerciseProcedure.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feature")
		@Override
		public BondOption.BondOptionBuilder setFeature(OptionFeature _feature) {
			this.feature = _feature == null ? null : _feature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalReference")
		@Override
		public BondOption.BondOptionBuilder setNotionalReference(NotionalAmountReference _notionalReference) {
			this.notionalReference = _notionalReference == null ? null : _notionalReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public BondOption.BondOptionBuilder setNotionalAmount(Money _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionEntitlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionEntitlement")
		@Override
		public BondOption.BondOptionBuilder setOptionEntitlement(BigDecimal _optionEntitlement) {
			this.optionEntitlement = _optionEntitlement == null ? null : _optionEntitlement;
			return this;
		}
		
		@RosettaAttribute("entitlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entitlementCurrency")
		@Override
		public BondOption.BondOptionBuilder setEntitlementCurrency(Currency _entitlementCurrency) {
			this.entitlementCurrency = _entitlementCurrency == null ? null : _entitlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("numberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfOptions")
		@Override
		public BondOption.BondOptionBuilder setNumberOfOptions(BigDecimal _numberOfOptions) {
			this.numberOfOptions = _numberOfOptions == null ? null : _numberOfOptions;
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public BondOption.BondOptionBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public BondOption.BondOptionBuilder setSettlementDate(AdjustableOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementAmount")
		@Override
		public BondOption.BondOptionBuilder setSettlementAmount(Money _settlementAmount) {
			this.settlementAmount = _settlementAmount == null ? null : _settlementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public BondOption.BondOptionBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("strike")
		@Override
		public BondOption.BondOptionBuilder setStrike(BondOptionStrike _strike) {
			this.strike = _strike == null ? null : _strike.toBuilder();
			return this;
		}
		
		@RosettaAttribute("bond")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bond")
		@Override
		public BondOption.BondOptionBuilder setBond(Bond _bond) {
			this.bond = _bond == null ? null : _bond.toBuilder();
			return this;
		}
		
		@RosettaAttribute("convertibleBond")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("convertibleBond")
		@Override
		public BondOption.BondOptionBuilder setConvertibleBond(ConvertibleBond _convertibleBond) {
			this.convertibleBond = _convertibleBond == null ? null : _convertibleBond.toBuilder();
			return this;
		}
		
		@Override
		public BondOption build() {
			return new BondOption.BondOptionImpl(this);
		}
		
		@Override
		public BondOption.BondOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondOption.BondOptionBuilder prune() {
			super.prune();
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (bond!=null && !bond.prune().hasData()) bond = null;
			if (convertibleBond!=null && !convertibleBond.prune().hasData()) convertibleBond = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getBond()!=null && getBond().hasData()) return true;
			if (getConvertibleBond()!=null && getConvertibleBond().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondOption.BondOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			BondOption.BondOptionBuilder o = (BondOption.BondOptionBuilder) other;
			
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getBond(), o.getBond(), this::setBond);
			merger.mergeRosetta(getConvertibleBond(), o.getConvertibleBond(), this::setConvertibleBond);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BondOption _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(bond, _that.getBond())) return false;
			if (!Objects.equals(convertibleBond, _that.getConvertibleBond())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (bond != null ? bond.hashCode() : 0);
			_result = 31 * _result + (convertibleBond != null ? convertibleBond.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondOptionBuilder {" +
				"strike=" + this.strike + ", " +
				"bond=" + this.bond + ", " +
				"convertibleBond=" + this.convertibleBond +
			'}' + " " + super.toString();
		}
	}
}

package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.CreditDefaultSwapOptionMeta;
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
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
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
 * Provision A complex type to support the credit default swap option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A complex type to support the credit default swap option.
 *
 */
@RosettaDataType(value="CreditDefaultSwapOption", builder=CreditDefaultSwapOption.CreditDefaultSwapOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditDefaultSwapOption", model="fpml", builder=CreditDefaultSwapOption.CreditDefaultSwapOptionBuilderImpl.class, version="2.1.1")
public interface CreditDefaultSwapOption extends OptionBaseExtended {

	CreditDefaultSwapOptionMeta metaData = new CreditDefaultSwapOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies any instructions on how the physical settlement is to be effected when the option is exercised.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies any instructions on how the physical settlement is to be effected when the option is exercised.
	 *
	 */
	SwaptionPhysicalSettlement getClearingInstructions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the strike of the option on credit default swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the strike of the option on credit default swap.
	 *
	 */
	CreditOptionStrike getStrike();
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
	CreditDefaultSwap getCreditDefaultSwap();

	/*********************** Build Methods  ***********************/
	CreditDefaultSwapOption build();
	
	CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder toBuilder();
	
	static CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder builder() {
		return new CreditDefaultSwapOption.CreditDefaultSwapOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditDefaultSwapOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditDefaultSwapOption> getType() {
		return CreditDefaultSwapOption.class;
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
		processRosetta(path.newSubPath("clearingInstructions"), processor, SwaptionPhysicalSettlement.class, getClearingInstructions());
		processRosetta(path.newSubPath("strike"), processor, CreditOptionStrike.class, getStrike());
		processRosetta(path.newSubPath("creditDefaultSwap"), processor, CreditDefaultSwap.class, getCreditDefaultSwap());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditDefaultSwapOptionBuilder extends CreditDefaultSwapOption, OptionBaseExtended.OptionBaseExtendedBuilder {
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreateClearingInstructions();
		@Override
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getClearingInstructions();
		CreditOptionStrike.CreditOptionStrikeBuilder getOrCreateStrike();
		@Override
		CreditOptionStrike.CreditOptionStrikeBuilder getStrike();
		CreditDefaultSwap.CreditDefaultSwapBuilder getOrCreateCreditDefaultSwap();
		@Override
		CreditDefaultSwap.CreditDefaultSwapBuilder getCreditDefaultSwap();
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setId(String id);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addProductType(ProductType productType);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addProductType(ProductType productType, int idx);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addProductType(List<? extends ProductType> productType);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setProductType(List<? extends ProductType> productType);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addProductId(ProductId productId);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addProductId(ProductId productId, int idx);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addProductId(List<? extends ProductId> productId);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setProductId(List<? extends ProductId> productId);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addAssetClass(AssetClass assetClass);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setOptionType(OptionTypeEnum optionType);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setPremium(Premium premium);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setExercise(Exercise exercise);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setFeature(OptionFeature feature);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setNotionalReference(NotionalAmountReference notionalReference);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setNotionalAmount(Money notionalAmount);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setOptionEntitlement(BigDecimal optionEntitlement);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setEntitlementCurrency(Currency entitlementCurrency);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setNumberOfOptions(BigDecimal numberOfOptions);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSettlementType(SettlementTypeEnum settlementType);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSettlementAmount(Money settlementAmount);
		@Override
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSettlementCurrency(Currency settlementCurrency);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setClearingInstructions(SwaptionPhysicalSettlement clearingInstructions);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setStrike(CreditOptionStrike strike);
		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setCreditDefaultSwap(CreditDefaultSwap creditDefaultSwap);

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
			processRosetta(path.newSubPath("clearingInstructions"), processor, SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder.class, getClearingInstructions());
			processRosetta(path.newSubPath("strike"), processor, CreditOptionStrike.CreditOptionStrikeBuilder.class, getStrike());
			processRosetta(path.newSubPath("creditDefaultSwap"), processor, CreditDefaultSwap.CreditDefaultSwapBuilder.class, getCreditDefaultSwap());
		}
		

		CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder prune();
	}

	/*********************** Immutable Implementation of CreditDefaultSwapOption  ***********************/
	class CreditDefaultSwapOptionImpl extends OptionBaseExtended.OptionBaseExtendedImpl implements CreditDefaultSwapOption {
		private final SwaptionPhysicalSettlement clearingInstructions;
		private final CreditOptionStrike strike;
		private final CreditDefaultSwap creditDefaultSwap;
		
		protected CreditDefaultSwapOptionImpl(CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder builder) {
			super(builder);
			this.clearingInstructions = ofNullable(builder.getClearingInstructions()).map(f->f.build()).orElse(null);
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.creditDefaultSwap = ofNullable(builder.getCreditDefaultSwap()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingInstructions")
		public SwaptionPhysicalSettlement getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("strike")
		public CreditOptionStrike getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("creditDefaultSwap")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditDefaultSwap")
		public CreditDefaultSwap getCreditDefaultSwap() {
			return creditDefaultSwap;
		}
		
		@Override
		public CreditDefaultSwapOption build() {
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder toBuilder() {
			CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getClearingInstructions()).ifPresent(builder::setClearingInstructions);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getCreditDefaultSwap()).ifPresent(builder::setCreditDefaultSwap);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditDefaultSwapOption _that = getType().cast(o);
		
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(creditDefaultSwap, _that.getCreditDefaultSwap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (creditDefaultSwap != null ? creditDefaultSwap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultSwapOption {" +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"strike=" + this.strike + ", " +
				"creditDefaultSwap=" + this.creditDefaultSwap +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditDefaultSwapOption  ***********************/
	class CreditDefaultSwapOptionBuilderImpl extends OptionBaseExtended.OptionBaseExtendedBuilderImpl implements CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder {
	
		protected SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder clearingInstructions;
		protected CreditOptionStrike.CreditOptionStrikeBuilder strike;
		protected CreditDefaultSwap.CreditDefaultSwapBuilder creditDefaultSwap;
		
		@Override
		@RosettaAttribute("clearingInstructions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingInstructions")
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreateClearingInstructions() {
			SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder result;
			if (clearingInstructions!=null) {
				result = clearingInstructions;
			}
			else {
				result = clearingInstructions = SwaptionPhysicalSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("strike")
		public CreditOptionStrike.CreditOptionStrikeBuilder getStrike() {
			return strike;
		}
		
		@Override
		public CreditOptionStrike.CreditOptionStrikeBuilder getOrCreateStrike() {
			CreditOptionStrike.CreditOptionStrikeBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = CreditOptionStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditDefaultSwap")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditDefaultSwap")
		public CreditDefaultSwap.CreditDefaultSwapBuilder getCreditDefaultSwap() {
			return creditDefaultSwap;
		}
		
		@Override
		public CreditDefaultSwap.CreditDefaultSwapBuilder getOrCreateCreditDefaultSwap() {
			CreditDefaultSwap.CreditDefaultSwapBuilder result;
			if (creditDefaultSwap!=null) {
				result = creditDefaultSwap;
			}
			else {
				result = creditDefaultSwap = CreditDefaultSwap.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addProductId(List<? extends ProductId> productIds) {
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
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setProductId(List<? extends ProductId> productIds) {
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
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("optionType")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setOptionType(OptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("premium")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setPremium(Premium _premium) {
			this.premium = _premium == null ? null : _premium.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exercise")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setExercise(Exercise _exercise) {
			this.exercise = _exercise == null ? null : _exercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseProcedure")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setExerciseProcedure(ExerciseProcedure _exerciseProcedure) {
			this.exerciseProcedure = _exerciseProcedure == null ? null : _exerciseProcedure.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feature")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setFeature(OptionFeature _feature) {
			this.feature = _feature == null ? null : _feature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalReference")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setNotionalReference(NotionalAmountReference _notionalReference) {
			this.notionalReference = _notionalReference == null ? null : _notionalReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setNotionalAmount(Money _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionEntitlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionEntitlement")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setOptionEntitlement(BigDecimal _optionEntitlement) {
			this.optionEntitlement = _optionEntitlement == null ? null : _optionEntitlement;
			return this;
		}
		
		@RosettaAttribute("entitlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entitlementCurrency")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setEntitlementCurrency(Currency _entitlementCurrency) {
			this.entitlementCurrency = _entitlementCurrency == null ? null : _entitlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("numberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfOptions")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setNumberOfOptions(BigDecimal _numberOfOptions) {
			this.numberOfOptions = _numberOfOptions == null ? null : _numberOfOptions;
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSettlementDate(AdjustableOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementAmount")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSettlementAmount(Money _settlementAmount) {
			this.settlementAmount = _settlementAmount == null ? null : _settlementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearingInstructions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingInstructions")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setClearingInstructions(SwaptionPhysicalSettlement _clearingInstructions) {
			this.clearingInstructions = _clearingInstructions == null ? null : _clearingInstructions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("strike")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setStrike(CreditOptionStrike _strike) {
			this.strike = _strike == null ? null : _strike.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditDefaultSwap")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditDefaultSwap")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder setCreditDefaultSwap(CreditDefaultSwap _creditDefaultSwap) {
			this.creditDefaultSwap = _creditDefaultSwap == null ? null : _creditDefaultSwap.toBuilder();
			return this;
		}
		
		@Override
		public CreditDefaultSwapOption build() {
			return new CreditDefaultSwapOption.CreditDefaultSwapOptionImpl(this);
		}
		
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder prune() {
			super.prune();
			if (clearingInstructions!=null && !clearingInstructions.prune().hasData()) clearingInstructions = null;
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (creditDefaultSwap!=null && !creditDefaultSwap.prune().hasData()) creditDefaultSwap = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getClearingInstructions()!=null && getClearingInstructions().hasData()) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getCreditDefaultSwap()!=null && getCreditDefaultSwap().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder o = (CreditDefaultSwapOption.CreditDefaultSwapOptionBuilder) other;
			
			merger.mergeRosetta(getClearingInstructions(), o.getClearingInstructions(), this::setClearingInstructions);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getCreditDefaultSwap(), o.getCreditDefaultSwap(), this::setCreditDefaultSwap);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditDefaultSwapOption _that = getType().cast(o);
		
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(creditDefaultSwap, _that.getCreditDefaultSwap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (creditDefaultSwap != null ? creditDefaultSwap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultSwapOptionBuilder {" +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"strike=" + this.strike + ", " +
				"creditDefaultSwap=" + this.creditDefaultSwap +
			'}' + " " + super.toString();
		}
	}
}

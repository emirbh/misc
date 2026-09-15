package fpml.consolidated.option.shared;

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
import fpml.consolidated.fpmlenum.OptionTypeEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.option.shared.meta.OptionBaseExtendedMeta;
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
 * Provision Base type for options starting with the 4-3 release, until we refactor the schema as part of the 5-0 release series.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Base type for options starting with the 4-3 release, until we refactor the schema as part of the 5-0 release series.
 *
 */
@RosettaDataType(value="OptionBaseExtended", builder=OptionBaseExtended.OptionBaseExtendedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OptionBaseExtended", model="fpml", builder=OptionBaseExtended.OptionBaseExtendedBuilderImpl.class, version="2.1.1")
public interface OptionBaseExtended extends OptionBase {

	OptionBaseExtendedMeta metaData = new OptionBaseExtendedMeta();

	/*********************** Getter Methods  ***********************/
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
	Premium getPremium();
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
	Exercise getExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A set of parameters defining procedures associated with the exercise.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A set of parameters defining procedures associated with the exercise.
	 *
	 */
	ExerciseProcedure getExerciseProcedure();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An Option feature such as quanto, asian, barrier, knock.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An Option feature such as quanto, asian, barrier, knock.
	 *
	 */
	OptionFeature getFeature();
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
	NotionalAmountReference getNotionalReference();
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
	Money getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of units of underlyer per option comprised in the option transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of units of underlyer per option comprised in the option transaction.
	 *
	 */
	BigDecimal getOptionEntitlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Currency of the relevant bonds to which one option relates. For Bond Options this element should be used to define the currency of the bonds instead of the currency element present in the Bond underlyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Currency of the relevant bonds to which one option relates. For Bond Options this element should be used to define the currency of the bonds instead of the currency element present in the Bond underlyer.
	 *
	 */
	Currency getEntitlementCurrency();
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
	SettlementTypeEnum getSettlementType();
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
	AdjustableOrRelativeDate getSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Settlement Amount
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settlement Amount
	 *
	 */
	Money getSettlementAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Settlement Currency for use where the Settlement Amount cannot be known in advance
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settlement Currency for use where the Settlement Amount cannot be known in advance
	 *
	 */
	Currency getSettlementCurrency();

	/*********************** Build Methods  ***********************/
	OptionBaseExtended build();
	
	OptionBaseExtended.OptionBaseExtendedBuilder toBuilder();
	
	static OptionBaseExtended.OptionBaseExtendedBuilder builder() {
		return new OptionBaseExtended.OptionBaseExtendedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionBaseExtended> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionBaseExtended> getType() {
		return OptionBaseExtended.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionBaseExtendedBuilder extends OptionBaseExtended, OptionBase.OptionBaseBuilder {
		Premium.PremiumBuilder getOrCreatePremium();
		@Override
		Premium.PremiumBuilder getPremium();
		Exercise.ExerciseBuilder getOrCreateExercise();
		@Override
		Exercise.ExerciseBuilder getExercise();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		@Override
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		OptionFeature.OptionFeatureBuilder getOrCreateFeature();
		@Override
		OptionFeature.OptionFeatureBuilder getFeature();
		NotionalAmountReference.NotionalAmountReferenceBuilder getOrCreateNotionalReference();
		@Override
		NotionalAmountReference.NotionalAmountReferenceBuilder getNotionalReference();
		Money.MoneyBuilder getOrCreateNotionalAmount();
		@Override
		Money.MoneyBuilder getNotionalAmount();
		Currency.CurrencyBuilder getOrCreateEntitlementCurrency();
		@Override
		Currency.CurrencyBuilder getEntitlementCurrency();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate();
		Money.MoneyBuilder getOrCreateSettlementAmount();
		@Override
		Money.MoneyBuilder getSettlementAmount();
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		@Override
		Currency.CurrencyBuilder getSettlementCurrency();
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder setId(String id);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addProductType(ProductType productType);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addProductType(ProductType productType, int idx);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addProductType(List<? extends ProductType> productType);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder setProductType(List<? extends ProductType> productType);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addProductId(ProductId productId);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addProductId(ProductId productId, int idx);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addProductId(List<? extends ProductId> productId);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder setProductId(List<? extends ProductId> productId);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addAssetClass(AssetClass assetClass);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		@Override
		OptionBaseExtended.OptionBaseExtendedBuilder setOptionType(OptionTypeEnum optionType);
		OptionBaseExtended.OptionBaseExtendedBuilder setPremium(Premium premium);
		OptionBaseExtended.OptionBaseExtendedBuilder setExercise(Exercise exercise);
		OptionBaseExtended.OptionBaseExtendedBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		OptionBaseExtended.OptionBaseExtendedBuilder setFeature(OptionFeature feature);
		OptionBaseExtended.OptionBaseExtendedBuilder setNotionalReference(NotionalAmountReference notionalReference);
		OptionBaseExtended.OptionBaseExtendedBuilder setNotionalAmount(Money notionalAmount);
		OptionBaseExtended.OptionBaseExtendedBuilder setOptionEntitlement(BigDecimal optionEntitlement);
		OptionBaseExtended.OptionBaseExtendedBuilder setEntitlementCurrency(Currency entitlementCurrency);
		OptionBaseExtended.OptionBaseExtendedBuilder setNumberOfOptions(BigDecimal numberOfOptions);
		OptionBaseExtended.OptionBaseExtendedBuilder setSettlementType(SettlementTypeEnum settlementType);
		OptionBaseExtended.OptionBaseExtendedBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		OptionBaseExtended.OptionBaseExtendedBuilder setSettlementAmount(Money settlementAmount);
		OptionBaseExtended.OptionBaseExtendedBuilder setSettlementCurrency(Currency settlementCurrency);

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
		}
		

		OptionBaseExtended.OptionBaseExtendedBuilder prune();
	}

	/*********************** Immutable Implementation of OptionBaseExtended  ***********************/
	class OptionBaseExtendedImpl extends OptionBase.OptionBaseImpl implements OptionBaseExtended {
		private final Premium premium;
		private final Exercise exercise;
		private final ExerciseProcedure exerciseProcedure;
		private final OptionFeature feature;
		private final NotionalAmountReference notionalReference;
		private final Money notionalAmount;
		private final BigDecimal optionEntitlement;
		private final Currency entitlementCurrency;
		private final BigDecimal numberOfOptions;
		private final SettlementTypeEnum settlementType;
		private final AdjustableOrRelativeDate settlementDate;
		private final Money settlementAmount;
		private final Currency settlementCurrency;
		
		protected OptionBaseExtendedImpl(OptionBaseExtended.OptionBaseExtendedBuilder builder) {
			super(builder);
			this.premium = ofNullable(builder.getPremium()).map(f->f.build()).orElse(null);
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.feature = ofNullable(builder.getFeature()).map(f->f.build()).orElse(null);
			this.notionalReference = ofNullable(builder.getNotionalReference()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.optionEntitlement = builder.getOptionEntitlement();
			this.entitlementCurrency = ofNullable(builder.getEntitlementCurrency()).map(f->f.build()).orElse(null);
			this.numberOfOptions = builder.getNumberOfOptions();
			this.settlementType = builder.getSettlementType();
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.settlementAmount = ofNullable(builder.getSettlementAmount()).map(f->f.build()).orElse(null);
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premium")
		public Premium getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exercise")
		public Exercise getExercise() {
			return exercise;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseProcedure")
		public ExerciseProcedure getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("feature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feature")
		public OptionFeature getFeature() {
			return feature;
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalReference")
		public NotionalAmountReference getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public Money getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("entitlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entitlementCurrency")
		public Currency getEntitlementCurrency() {
			return entitlementCurrency;
		}
		
		@Override
		@RosettaAttribute("numberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfOptions")
		public BigDecimal getNumberOfOptions() {
			return numberOfOptions;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustableOrRelativeDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementAmount")
		public Money getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public OptionBaseExtended build() {
			return this;
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder toBuilder() {
			OptionBaseExtended.OptionBaseExtendedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionBaseExtended.OptionBaseExtendedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getFeature()).ifPresent(builder::setFeature);
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getOptionEntitlement()).ifPresent(builder::setOptionEntitlement);
			ofNullable(getEntitlementCurrency()).ifPresent(builder::setEntitlementCurrency);
			ofNullable(getNumberOfOptions()).ifPresent(builder::setNumberOfOptions);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getSettlementAmount()).ifPresent(builder::setSettlementAmount);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionBaseExtended _that = getType().cast(o);
		
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(feature, _that.getFeature())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(entitlementCurrency, _that.getEntitlementCurrency())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (entitlementCurrency != null ? entitlementCurrency.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionBaseExtended {" +
				"premium=" + this.premium + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"feature=" + this.feature + ", " +
				"notionalReference=" + this.notionalReference + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"entitlementCurrency=" + this.entitlementCurrency + ", " +
				"numberOfOptions=" + this.numberOfOptions + ", " +
				"settlementType=" + this.settlementType + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementAmount=" + this.settlementAmount + ", " +
				"settlementCurrency=" + this.settlementCurrency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OptionBaseExtended  ***********************/
	class OptionBaseExtendedBuilderImpl extends OptionBase.OptionBaseBuilderImpl implements OptionBaseExtended.OptionBaseExtendedBuilder {
	
		protected Premium.PremiumBuilder premium;
		protected Exercise.ExerciseBuilder exercise;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected OptionFeature.OptionFeatureBuilder feature;
		protected NotionalAmountReference.NotionalAmountReferenceBuilder notionalReference;
		protected Money.MoneyBuilder notionalAmount;
		protected BigDecimal optionEntitlement;
		protected Currency.CurrencyBuilder entitlementCurrency;
		protected BigDecimal numberOfOptions;
		protected SettlementTypeEnum settlementType;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder settlementDate;
		protected Money.MoneyBuilder settlementAmount;
		protected Currency.CurrencyBuilder settlementCurrency;
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premium")
		public Premium.PremiumBuilder getPremium() {
			return premium;
		}
		
		@Override
		public Premium.PremiumBuilder getOrCreatePremium() {
			Premium.PremiumBuilder result;
			if (premium!=null) {
				result = premium;
			}
			else {
				result = premium = Premium.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exercise")
		public Exercise.ExerciseBuilder getExercise() {
			return exercise;
		}
		
		@Override
		public Exercise.ExerciseBuilder getOrCreateExercise() {
			Exercise.ExerciseBuilder result;
			if (exercise!=null) {
				result = exercise;
			}
			else {
				result = exercise = Exercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseProcedure")
		public ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure() {
			ExerciseProcedure.ExerciseProcedureBuilder result;
			if (exerciseProcedure!=null) {
				result = exerciseProcedure;
			}
			else {
				result = exerciseProcedure = ExerciseProcedure.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("feature")
		public OptionFeature.OptionFeatureBuilder getFeature() {
			return feature;
		}
		
		@Override
		public OptionFeature.OptionFeatureBuilder getOrCreateFeature() {
			OptionFeature.OptionFeatureBuilder result;
			if (feature!=null) {
				result = feature;
			}
			else {
				result = feature = OptionFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalReference")
		public NotionalAmountReference.NotionalAmountReferenceBuilder getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public NotionalAmountReference.NotionalAmountReferenceBuilder getOrCreateNotionalReference() {
			NotionalAmountReference.NotionalAmountReferenceBuilder result;
			if (notionalReference!=null) {
				result = notionalReference;
			}
			else {
				result = notionalReference = NotionalAmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public Money.MoneyBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateNotionalAmount() {
			Money.MoneyBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = Money.builder();
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
		@RosettaAttribute("entitlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entitlementCurrency")
		public Currency.CurrencyBuilder getEntitlementCurrency() {
			return entitlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateEntitlementCurrency() {
			Currency.CurrencyBuilder result;
			if (entitlementCurrency!=null) {
				result = entitlementCurrency;
			}
			else {
				result = entitlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfOptions")
		public BigDecimal getNumberOfOptions() {
			return numberOfOptions;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementAmount")
		public Money.MoneyBuilder getSettlementAmount() {
			return settlementAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateSettlementAmount() {
			Money.MoneyBuilder result;
			if (settlementAmount!=null) {
				result = settlementAmount;
			}
			else {
				result = settlementAmount = Money.builder();
			}
			
			return result;
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public OptionBaseExtended.OptionBaseExtendedBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public OptionBaseExtended.OptionBaseExtendedBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public OptionBaseExtended.OptionBaseExtendedBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public OptionBaseExtended.OptionBaseExtendedBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder addProductId(List<? extends ProductId> productIds) {
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
		public OptionBaseExtended.OptionBaseExtendedBuilder setProductId(List<? extends ProductId> productIds) {
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
		public OptionBaseExtended.OptionBaseExtendedBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public OptionBaseExtended.OptionBaseExtendedBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public OptionBaseExtended.OptionBaseExtendedBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public OptionBaseExtended.OptionBaseExtendedBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public OptionBaseExtended.OptionBaseExtendedBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("optionType")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setOptionType(OptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("premium")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setPremium(Premium _premium) {
			this.premium = _premium == null ? null : _premium.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exercise")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setExercise(Exercise _exercise) {
			this.exercise = _exercise == null ? null : _exercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseProcedure")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setExerciseProcedure(ExerciseProcedure _exerciseProcedure) {
			this.exerciseProcedure = _exerciseProcedure == null ? null : _exerciseProcedure.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("feature")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setFeature(OptionFeature _feature) {
			this.feature = _feature == null ? null : _feature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalReference")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setNotionalReference(NotionalAmountReference _notionalReference) {
			this.notionalReference = _notionalReference == null ? null : _notionalReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setNotionalAmount(Money _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionEntitlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionEntitlement")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setOptionEntitlement(BigDecimal _optionEntitlement) {
			this.optionEntitlement = _optionEntitlement == null ? null : _optionEntitlement;
			return this;
		}
		
		@RosettaAttribute("entitlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entitlementCurrency")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setEntitlementCurrency(Currency _entitlementCurrency) {
			this.entitlementCurrency = _entitlementCurrency == null ? null : _entitlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("numberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfOptions")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setNumberOfOptions(BigDecimal _numberOfOptions) {
			this.numberOfOptions = _numberOfOptions == null ? null : _numberOfOptions;
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setSettlementDate(AdjustableOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementAmount")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setSettlementAmount(Money _settlementAmount) {
			this.settlementAmount = _settlementAmount == null ? null : _settlementAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@Override
		public OptionBaseExtended build() {
			return new OptionBaseExtended.OptionBaseExtendedImpl(this);
		}
		
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder prune() {
			super.prune();
			if (premium!=null && !premium.prune().hasData()) premium = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (feature!=null && !feature.prune().hasData()) feature = null;
			if (notionalReference!=null && !notionalReference.prune().hasData()) notionalReference = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (entitlementCurrency!=null && !entitlementCurrency.prune().hasData()) entitlementCurrency = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (settlementAmount!=null && !settlementAmount.prune().hasData()) settlementAmount = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPremium()!=null && getPremium().hasData()) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getFeature()!=null && getFeature().hasData()) return true;
			if (getNotionalReference()!=null && getNotionalReference().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getOptionEntitlement()!=null) return true;
			if (getEntitlementCurrency()!=null && getEntitlementCurrency().hasData()) return true;
			if (getNumberOfOptions()!=null) return true;
			if (getSettlementType()!=null) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getSettlementAmount()!=null && getSettlementAmount().hasData()) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionBaseExtended.OptionBaseExtendedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			OptionBaseExtended.OptionBaseExtendedBuilder o = (OptionBaseExtended.OptionBaseExtendedBuilder) other;
			
			merger.mergeRosetta(getPremium(), o.getPremium(), this::setPremium);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getFeature(), o.getFeature(), this::setFeature);
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::setNotionalReference);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getEntitlementCurrency(), o.getEntitlementCurrency(), this::setEntitlementCurrency);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getSettlementAmount(), o.getSettlementAmount(), this::setSettlementAmount);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			
			merger.mergeBasic(getOptionEntitlement(), o.getOptionEntitlement(), this::setOptionEntitlement);
			merger.mergeBasic(getNumberOfOptions(), o.getNumberOfOptions(), this::setNumberOfOptions);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OptionBaseExtended _that = getType().cast(o);
		
			if (!Objects.equals(premium, _that.getPremium())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(feature, _that.getFeature())) return false;
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(entitlementCurrency, _that.getEntitlementCurrency())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementAmount, _that.getSettlementAmount())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (entitlementCurrency != null ? entitlementCurrency.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementAmount != null ? settlementAmount.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionBaseExtendedBuilder {" +
				"premium=" + this.premium + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"feature=" + this.feature + ", " +
				"notionalReference=" + this.notionalReference + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"entitlementCurrency=" + this.entitlementCurrency + ", " +
				"numberOfOptions=" + this.numberOfOptions + ", " +
				"settlementType=" + this.settlementType + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementAmount=" + this.settlementAmount + ", " +
				"settlementCurrency=" + this.settlementCurrency +
			'}' + " " + super.toString();
		}
	}
}

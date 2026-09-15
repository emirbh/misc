package fpml.consolidated.fx;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.fpmlenum.PutCallEnum;
import fpml.consolidated.fx.meta.FxOptionMeta;
import fpml.consolidated.option.shared.Option;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.FxCashSettlement;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Period;
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
 * Provision Describes an FX option with optional asian and barrier features.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes an FX option with optional asian and barrier features.
 *
 */
@RosettaDataType(value="FxOption", builder=FxOption.FxOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxOption", model="fpml", builder=FxOption.FxOptionBuilderImpl.class, version="2.1.1")
public interface FxOption extends Option {

	FxOptionMeta metaData = new FxOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Effective date for a forward starting derivative. If this element is not present, the effective date is the trade date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Effective date for a forward starting derivative. If this element is not present, the effective date is the trade date.
	 *
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)
	 *
	 */
	Period getTenorPeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining the exercise period for an American style option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining the exercise period for an American style option.
	 *
	 */
	FxAmericanExercise getAmericanExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining the exercise period for an European style option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining the exercise period for an European style option.
	 *
	 */
	FxEuropeanExercise getEuropeanExercise();
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
	 * Provision The currency amount that the option gives the right to sell.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency amount that the option gives the right to sell.
	 *
	 */
	NonNegativeMoney getPutCurrencyAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency amount that the option gives the right to buy.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency amount that the option gives the right to buy.
	 *
	 */
	NonNegativeMoney getCallCurrencyAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates how the product was original sold as a Put or a Call.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates how the product was original sold as a Put or a Call.
	 *
	 */
	PutCallEnum getSoldAs();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the option strike price.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the option strike price.
	 *
	 */
	FxStrikePrice getStrike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the option needs to move "up" or "down" to be triggered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the option needs to move "up" or "down" to be triggered.
	 *
	 */
	BigDecimal getSpotRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes additional features within the option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes additional features within the option.
	 *
	 */
	FxOptionFeatures getFeatures();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Premium amount or premium installment amount for an option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Premium amount or premium installment amount for an option.
	 *
	 */
	List<? extends FxOptionPremium> getPremium();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the currency and fixing details for cash settlement. This optional element is produced only where it has been specified at execution time that the option wlll be settled into a single cash payment - for example, in the case of a non-deliverable option (although note that an Fx option may be contractually cash settled, without necessarily being non-deliverable).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the currency and fixing details for cash settlement. This optional element is produced only where it has been specified at execution time that the option wlll be settled into a single cash payment - for example, in the case of a non-deliverable option (although note that an Fx option may be contractually cash settled, without necessarily being non-deliverable).
	 *
	 */
	FxCashSettlement getCashSettlement();

	/*********************** Build Methods  ***********************/
	FxOption build();
	
	FxOption.FxOptionBuilder toBuilder();
	
	static FxOption.FxOptionBuilder builder() {
		return new FxOption.FxOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxOption> getType() {
		return FxOption.class;
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
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("tenorPeriod"), processor, Period.class, getTenorPeriod());
		processRosetta(path.newSubPath("americanExercise"), processor, FxAmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("europeanExercise"), processor, FxEuropeanExercise.class, getEuropeanExercise());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("putCurrencyAmount"), processor, NonNegativeMoney.class, getPutCurrencyAmount());
		processRosetta(path.newSubPath("callCurrencyAmount"), processor, NonNegativeMoney.class, getCallCurrencyAmount());
		processor.processBasic(path.newSubPath("soldAs"), PutCallEnum.class, getSoldAs(), this);
		processRosetta(path.newSubPath("strike"), processor, FxStrikePrice.class, getStrike());
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("features"), processor, FxOptionFeatures.class, getFeatures());
		processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.class, getPremium());
		processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlement.class, getCashSettlement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxOptionBuilder extends FxOption, Option.OptionBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		Period.PeriodBuilder getOrCreateTenorPeriod();
		@Override
		Period.PeriodBuilder getTenorPeriod();
		FxAmericanExercise.FxAmericanExerciseBuilder getOrCreateAmericanExercise();
		@Override
		FxAmericanExercise.FxAmericanExerciseBuilder getAmericanExercise();
		FxEuropeanExercise.FxEuropeanExerciseBuilder getOrCreateEuropeanExercise();
		@Override
		FxEuropeanExercise.FxEuropeanExerciseBuilder getEuropeanExercise();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		@Override
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePutCurrencyAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getPutCurrencyAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateCallCurrencyAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getCallCurrencyAmount();
		FxStrikePrice.FxStrikePriceBuilder getOrCreateStrike();
		@Override
		FxStrikePrice.FxStrikePriceBuilder getStrike();
		FxOptionFeatures.FxOptionFeaturesBuilder getOrCreateFeatures();
		@Override
		FxOptionFeatures.FxOptionFeaturesBuilder getFeatures();
		FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int index);
		@Override
		List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium();
		FxCashSettlement.FxCashSettlementBuilder getOrCreateCashSettlement();
		@Override
		FxCashSettlement.FxCashSettlementBuilder getCashSettlement();
		@Override
		FxOption.FxOptionBuilder setId(String id);
		@Override
		FxOption.FxOptionBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		FxOption.FxOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		FxOption.FxOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		FxOption.FxOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxOption.FxOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxOption.FxOptionBuilder addProductType(ProductType productType);
		@Override
		FxOption.FxOptionBuilder addProductType(ProductType productType, int idx);
		@Override
		FxOption.FxOptionBuilder addProductType(List<? extends ProductType> productType);
		@Override
		FxOption.FxOptionBuilder setProductType(List<? extends ProductType> productType);
		@Override
		FxOption.FxOptionBuilder addProductId(ProductId productId);
		@Override
		FxOption.FxOptionBuilder addProductId(ProductId productId, int idx);
		@Override
		FxOption.FxOptionBuilder addProductId(List<? extends ProductId> productId);
		@Override
		FxOption.FxOptionBuilder setProductId(List<? extends ProductId> productId);
		@Override
		FxOption.FxOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		FxOption.FxOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		FxOption.FxOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxOption.FxOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxOption.FxOptionBuilder addAssetClass(AssetClass assetClass);
		@Override
		FxOption.FxOptionBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		FxOption.FxOptionBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxOption.FxOptionBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxOption.FxOptionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		FxOption.FxOptionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		FxOption.FxOptionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		FxOption.FxOptionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		FxOption.FxOptionBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		FxOption.FxOptionBuilder setTenorPeriod(Period tenorPeriod);
		FxOption.FxOptionBuilder setAmericanExercise(FxAmericanExercise americanExercise);
		FxOption.FxOptionBuilder setEuropeanExercise(FxEuropeanExercise europeanExercise);
		FxOption.FxOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		FxOption.FxOptionBuilder setPutCurrencyAmount(NonNegativeMoney putCurrencyAmount);
		FxOption.FxOptionBuilder setCallCurrencyAmount(NonNegativeMoney callCurrencyAmount);
		FxOption.FxOptionBuilder setSoldAs(PutCallEnum soldAs);
		FxOption.FxOptionBuilder setStrike(FxStrikePrice strike);
		FxOption.FxOptionBuilder setSpotRate(BigDecimal spotRate);
		FxOption.FxOptionBuilder setFeatures(FxOptionFeatures features);
		FxOption.FxOptionBuilder addPremium(FxOptionPremium premium);
		FxOption.FxOptionBuilder addPremium(FxOptionPremium premium, int idx);
		FxOption.FxOptionBuilder addPremium(List<? extends FxOptionPremium> premium);
		FxOption.FxOptionBuilder setPremium(List<? extends FxOptionPremium> premium);
		FxOption.FxOptionBuilder setCashSettlement(FxCashSettlement cashSettlement);

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
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("tenorPeriod"), processor, Period.PeriodBuilder.class, getTenorPeriod());
			processRosetta(path.newSubPath("americanExercise"), processor, FxAmericanExercise.FxAmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("europeanExercise"), processor, FxEuropeanExercise.FxEuropeanExerciseBuilder.class, getEuropeanExercise());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("putCurrencyAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPutCurrencyAmount());
			processRosetta(path.newSubPath("callCurrencyAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getCallCurrencyAmount());
			processor.processBasic(path.newSubPath("soldAs"), PutCallEnum.class, getSoldAs(), this);
			processRosetta(path.newSubPath("strike"), processor, FxStrikePrice.FxStrikePriceBuilder.class, getStrike());
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("features"), processor, FxOptionFeatures.FxOptionFeaturesBuilder.class, getFeatures());
			processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.FxOptionPremiumBuilder.class, getPremium());
			processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlement.FxCashSettlementBuilder.class, getCashSettlement());
		}
		

		FxOption.FxOptionBuilder prune();
	}

	/*********************** Immutable Implementation of FxOption  ***********************/
	class FxOptionImpl extends Option.OptionImpl implements FxOption {
		private final AdjustableOrRelativeDate effectiveDate;
		private final Period tenorPeriod;
		private final FxAmericanExercise americanExercise;
		private final FxEuropeanExercise europeanExercise;
		private final ExerciseProcedure exerciseProcedure;
		private final NonNegativeMoney putCurrencyAmount;
		private final NonNegativeMoney callCurrencyAmount;
		private final PutCallEnum soldAs;
		private final FxStrikePrice strike;
		private final BigDecimal spotRate;
		private final FxOptionFeatures features;
		private final List<? extends FxOptionPremium> premium;
		private final FxCashSettlement cashSettlement;
		
		protected FxOptionImpl(FxOption.FxOptionBuilder builder) {
			super(builder);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.tenorPeriod = ofNullable(builder.getTenorPeriod()).map(f->f.build()).orElse(null);
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.putCurrencyAmount = ofNullable(builder.getPutCurrencyAmount()).map(f->f.build()).orElse(null);
			this.callCurrencyAmount = ofNullable(builder.getCallCurrencyAmount()).map(f->f.build()).orElse(null);
			this.soldAs = builder.getSoldAs();
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.spotRate = builder.getSpotRate();
			this.features = ofNullable(builder.getFeatures()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenorPeriod")
		public Period getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		@RosettaAttribute("americanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("americanExercise")
		public FxAmericanExercise getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("europeanExercise")
		public FxEuropeanExercise getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseProcedure")
		public ExerciseProcedure getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("putCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("putCurrencyAmount")
		public NonNegativeMoney getPutCurrencyAmount() {
			return putCurrencyAmount;
		}
		
		@Override
		@RosettaAttribute("callCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("callCurrencyAmount")
		public NonNegativeMoney getCallCurrencyAmount() {
			return callCurrencyAmount;
		}
		
		@Override
		@RosettaAttribute("soldAs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("soldAs")
		public PutCallEnum getSoldAs() {
			return soldAs;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("strike")
		public FxStrikePrice getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("features")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("features")
		public FxOptionFeatures getFeatures() {
			return features;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("premium")
		public List<? extends FxOptionPremium> getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public FxCashSettlement getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public FxOption build() {
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder toBuilder() {
			FxOption.FxOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxOption.FxOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTenorPeriod()).ifPresent(builder::setTenorPeriod);
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getPutCurrencyAmount()).ifPresent(builder::setPutCurrencyAmount);
			ofNullable(getCallCurrencyAmount()).ifPresent(builder::setCallCurrencyAmount);
			ofNullable(getSoldAs()).ifPresent(builder::setSoldAs);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getFeatures()).ifPresent(builder::setFeatures);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOption _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(putCurrencyAmount, _that.getPutCurrencyAmount())) return false;
			if (!Objects.equals(callCurrencyAmount, _that.getCallCurrencyAmount())) return false;
			if (!Objects.equals(soldAs, _that.getSoldAs())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(features, _that.getFeatures())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (putCurrencyAmount != null ? putCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (callCurrencyAmount != null ? callCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (soldAs != null ? soldAs.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (features != null ? features.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOption {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"putCurrencyAmount=" + this.putCurrencyAmount + ", " +
				"callCurrencyAmount=" + this.callCurrencyAmount + ", " +
				"soldAs=" + this.soldAs + ", " +
				"strike=" + this.strike + ", " +
				"spotRate=" + this.spotRate + ", " +
				"features=" + this.features + ", " +
				"premium=" + this.premium + ", " +
				"cashSettlement=" + this.cashSettlement +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxOption  ***********************/
	class FxOptionBuilderImpl extends Option.OptionBuilderImpl implements FxOption.FxOptionBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected Period.PeriodBuilder tenorPeriod;
		protected FxAmericanExercise.FxAmericanExerciseBuilder americanExercise;
		protected FxEuropeanExercise.FxEuropeanExerciseBuilder europeanExercise;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected NonNegativeMoney.NonNegativeMoneyBuilder putCurrencyAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder callCurrencyAmount;
		protected PutCallEnum soldAs;
		protected FxStrikePrice.FxStrikePriceBuilder strike;
		protected BigDecimal spotRate;
		protected FxOptionFeatures.FxOptionFeaturesBuilder features;
		protected List<FxOptionPremium.FxOptionPremiumBuilder> premium = new ArrayList<>();
		protected FxCashSettlement.FxCashSettlementBuilder cashSettlement;
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenorPeriod")
		public Period.PeriodBuilder getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTenorPeriod() {
			Period.PeriodBuilder result;
			if (tenorPeriod!=null) {
				result = tenorPeriod;
			}
			else {
				result = tenorPeriod = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("americanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("americanExercise")
		public FxAmericanExercise.FxAmericanExerciseBuilder getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder getOrCreateAmericanExercise() {
			FxAmericanExercise.FxAmericanExerciseBuilder result;
			if (americanExercise!=null) {
				result = americanExercise;
			}
			else {
				result = americanExercise = FxAmericanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("europeanExercise")
		public FxEuropeanExercise.FxEuropeanExerciseBuilder getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder getOrCreateEuropeanExercise() {
			FxEuropeanExercise.FxEuropeanExerciseBuilder result;
			if (europeanExercise!=null) {
				result = europeanExercise;
			}
			else {
				result = europeanExercise = FxEuropeanExercise.builder();
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
		@RosettaAttribute("putCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("putCurrencyAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPutCurrencyAmount() {
			return putCurrencyAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePutCurrencyAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (putCurrencyAmount!=null) {
				result = putCurrencyAmount;
			}
			else {
				result = putCurrencyAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("callCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("callCurrencyAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getCallCurrencyAmount() {
			return callCurrencyAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateCallCurrencyAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (callCurrencyAmount!=null) {
				result = callCurrencyAmount;
			}
			else {
				result = callCurrencyAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("soldAs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("soldAs")
		public PutCallEnum getSoldAs() {
			return soldAs;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("strike")
		public FxStrikePrice.FxStrikePriceBuilder getStrike() {
			return strike;
		}
		
		@Override
		public FxStrikePrice.FxStrikePriceBuilder getOrCreateStrike() {
			FxStrikePrice.FxStrikePriceBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = FxStrikePrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("features")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("features")
		public FxOptionFeatures.FxOptionFeaturesBuilder getFeatures() {
			return features;
		}
		
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder getOrCreateFeatures() {
			FxOptionFeatures.FxOptionFeaturesBuilder result;
			if (features!=null) {
				result = features;
			}
			else {
				result = features = FxOptionFeatures.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("premium")
		public List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium() {
			return premium;
		}
		
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int index) {
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			return getIndex(premium, index, () -> {
						FxOptionPremium.FxOptionPremiumBuilder newPremium = FxOptionPremium.builder();
						return newPremium;
					});
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public FxCashSettlement.FxCashSettlementBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public FxCashSettlement.FxCashSettlementBuilder getOrCreateCashSettlement() {
			FxCashSettlement.FxCashSettlementBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = FxCashSettlement.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxOption.FxOptionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public FxOption.FxOptionBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxOption.FxOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxOption.FxOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxOption.FxOptionBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public FxOption.FxOptionBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public FxOption.FxOptionBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder addProductId(List<? extends ProductId> productIds) {
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
		public FxOption.FxOptionBuilder setProductId(List<? extends ProductId> productIds) {
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
		public FxOption.FxOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxOption.FxOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxOption.FxOptionBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxOption.FxOptionBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxOption.FxOptionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public FxOption.FxOptionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public FxOption.FxOptionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public FxOption.FxOptionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public FxOption.FxOptionBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tenorPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tenorPeriod")
		@Override
		public FxOption.FxOptionBuilder setTenorPeriod(Period _tenorPeriod) {
			this.tenorPeriod = _tenorPeriod == null ? null : _tenorPeriod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("americanExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("americanExercise")
		@Override
		public FxOption.FxOptionBuilder setAmericanExercise(FxAmericanExercise _americanExercise) {
			this.americanExercise = _americanExercise == null ? null : _americanExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("europeanExercise")
		@Override
		public FxOption.FxOptionBuilder setEuropeanExercise(FxEuropeanExercise _europeanExercise) {
			this.europeanExercise = _europeanExercise == null ? null : _europeanExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseProcedure")
		@Override
		public FxOption.FxOptionBuilder setExerciseProcedure(ExerciseProcedure _exerciseProcedure) {
			this.exerciseProcedure = _exerciseProcedure == null ? null : _exerciseProcedure.toBuilder();
			return this;
		}
		
		@RosettaAttribute("putCurrencyAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("putCurrencyAmount")
		@Override
		public FxOption.FxOptionBuilder setPutCurrencyAmount(NonNegativeMoney _putCurrencyAmount) {
			this.putCurrencyAmount = _putCurrencyAmount == null ? null : _putCurrencyAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("callCurrencyAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("callCurrencyAmount")
		@Override
		public FxOption.FxOptionBuilder setCallCurrencyAmount(NonNegativeMoney _callCurrencyAmount) {
			this.callCurrencyAmount = _callCurrencyAmount == null ? null : _callCurrencyAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("soldAs")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("soldAs")
		@Override
		public FxOption.FxOptionBuilder setSoldAs(PutCallEnum _soldAs) {
			this.soldAs = _soldAs == null ? null : _soldAs;
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("strike")
		@Override
		public FxOption.FxOptionBuilder setStrike(FxStrikePrice _strike) {
			this.strike = _strike == null ? null : _strike.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotRate")
		@Override
		public FxOption.FxOptionBuilder setSpotRate(BigDecimal _spotRate) {
			this.spotRate = _spotRate == null ? null : _spotRate;
			return this;
		}
		
		@RosettaAttribute("features")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("features")
		@Override
		public FxOption.FxOptionBuilder setFeatures(FxOptionFeatures _features) {
			this.features = _features == null ? null : _features.toBuilder();
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public FxOption.FxOptionBuilder addPremium(FxOptionPremium _premium) {
			if (_premium != null) {
				this.premium.add(_premium.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder addPremium(FxOptionPremium _premium, int idx) {
			getIndex(this.premium, idx, () -> _premium.toBuilder());
			return this;
		}
		
		@Override
		public FxOption.FxOptionBuilder addPremium(List<? extends FxOptionPremium> premiums) {
			if (premiums != null) {
				for (final FxOptionPremium toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public FxOption.FxOptionBuilder setPremium(List<? extends FxOptionPremium> premiums) {
			if (premiums == null) {
				this.premium = new ArrayList<>();
			} else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlement")
		@Override
		public FxOption.FxOptionBuilder setCashSettlement(FxCashSettlement _cashSettlement) {
			this.cashSettlement = _cashSettlement == null ? null : _cashSettlement.toBuilder();
			return this;
		}
		
		@Override
		public FxOption build() {
			return new FxOption.FxOptionImpl(this);
		}
		
		@Override
		public FxOption.FxOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOption.FxOptionBuilder prune() {
			super.prune();
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (tenorPeriod!=null && !tenorPeriod.prune().hasData()) tenorPeriod = null;
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (putCurrencyAmount!=null && !putCurrencyAmount.prune().hasData()) putCurrencyAmount = null;
			if (callCurrencyAmount!=null && !callCurrencyAmount.prune().hasData()) callCurrencyAmount = null;
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (features!=null && !features.prune().hasData()) features = null;
			premium = premium.stream().filter(b->b!=null).<FxOptionPremium.FxOptionPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTenorPeriod()!=null && getTenorPeriod().hasData()) return true;
			if (getAmericanExercise()!=null && getAmericanExercise().hasData()) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getPutCurrencyAmount()!=null && getPutCurrencyAmount().hasData()) return true;
			if (getCallCurrencyAmount()!=null && getCallCurrencyAmount().hasData()) return true;
			if (getSoldAs()!=null) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getSpotRate()!=null) return true;
			if (getFeatures()!=null && getFeatures().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOption.FxOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxOption.FxOptionBuilder o = (FxOption.FxOptionBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTenorPeriod(), o.getTenorPeriod(), this::setTenorPeriod);
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getPutCurrencyAmount(), o.getPutCurrencyAmount(), this::setPutCurrencyAmount);
			merger.mergeRosetta(getCallCurrencyAmount(), o.getCallCurrencyAmount(), this::setCallCurrencyAmount);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getFeatures(), o.getFeatures(), this::setFeatures);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			
			merger.mergeBasic(getSoldAs(), o.getSoldAs(), this::setSoldAs);
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOption _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(putCurrencyAmount, _that.getPutCurrencyAmount())) return false;
			if (!Objects.equals(callCurrencyAmount, _that.getCallCurrencyAmount())) return false;
			if (!Objects.equals(soldAs, _that.getSoldAs())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(features, _that.getFeatures())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (putCurrencyAmount != null ? putCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (callCurrencyAmount != null ? callCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (soldAs != null ? soldAs.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (features != null ? features.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"putCurrencyAmount=" + this.putCurrencyAmount + ", " +
				"callCurrencyAmount=" + this.callCurrencyAmount + ", " +
				"soldAs=" + this.soldAs + ", " +
				"strike=" + this.strike + ", " +
				"spotRate=" + this.spotRate + ", " +
				"features=" + this.features + ", " +
				"premium=" + this.premium + ", " +
				"cashSettlement=" + this.cashSettlement +
			'}' + " " + super.toString();
		}
	}
}

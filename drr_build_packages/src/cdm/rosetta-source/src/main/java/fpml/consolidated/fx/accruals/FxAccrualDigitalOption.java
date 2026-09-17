package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.FxOptionPremium;
import fpml.consolidated.fx.accruals.meta.FxAccrualDigitalOptionMeta;
import fpml.consolidated.fx.targets.FxExpirySchedule;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import fpml.consolidated.option.shared.Option;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
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
 * Provision An FX Accrual Digital Option product The product defines a list of fixing (or observation) dates. There are m total fixings. At the expiry date of the product, the buyer of the option has the right to an FX settlement with n/m * Notional. Payout can be cash or physical.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An FX Accrual Digital Option product The product defines a list of fixing (or observation) dates. There are m total fixings. At the expiry date of the product, the buyer of the option has the right to an FX settlement with n/m * Notional. Payout can be cash or physical.
 *
 */
@RosettaDataType(value="FxAccrualDigitalOption", builder=FxAccrualDigitalOption.FxAccrualDigitalOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualDigitalOption", model="fpml", builder=FxAccrualDigitalOption.FxAccrualDigitalOptionBuilderImpl.class, version="2.1.1")
public interface FxAccrualDigitalOption extends Option {

	FxAccrualDigitalOptionMeta metaData = new FxAccrualDigitalOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Notional amount Schedule. The notional value of the product. This number divided by the total number of fixings in the fixing schedule is the amount that is accrued at each fixing if the accrual factor is one.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Notional amount Schedule. The notional value of the product. This number divided by the total number of fixings in the fixing schedule is the amount that is accrued at each fixing if the accrual factor is one.
	 *
	 */
	NonNegativeAmountSchedule getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes accrual features within the product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes accrual features within the product.
	 *
	 */
	FxAccrual getAccrual();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the expiry of a single period accrual forward FX transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the expiry of a single period accrual forward FX transaction.
	 *
	 */
	FxExpiryDate getExpiryDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining a schedule of expiry periods for an accrual forward FX transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining a schedule of expiry periods for an accrual forward FX transaction.
	 *
	 */
	FxExpirySchedule getExpirySchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which settlement takes place for a settlement period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which settlement takes place for a settlement period.
	 *
	 */
	FxAdjustedDateAndDateAdjustments getSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining a schedule of settlement periods for a accrual forward FX transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining a schedule of settlement periods for a accrual forward FX transaction.
	 *
	 */
	FxSettlementSchedule getSettlementSchedule();
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
	 * Provision Defines one or more conditions under which the option will payout if exercisable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines one or more conditions under which the option will payout if exercisable.
	 *
	 */
	FxAccrualTrigger getTrigger();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines a knockout barrier conditions where if a barrier event occurs, the accrual process is terminated for the duration of all remaining accrual periods. Settlement rights for the next settlement are either retained or extinguished.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines a knockout barrier conditions where if a barrier event occurs, the accrual process is terminated for the duration of all remaining accrual periods. Settlement rights for the next settlement are either retained or extinguished.
	 *
	 */
	List<? extends FxAccrualBarrier> getBarrier();
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

	/*********************** Build Methods  ***********************/
	FxAccrualDigitalOption build();
	
	FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder toBuilder();
	
	static FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder builder() {
		return new FxAccrualDigitalOption.FxAccrualDigitalOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualDigitalOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualDigitalOption> getType() {
		return FxAccrualDigitalOption.class;
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
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("accrual"), processor, FxAccrual.class, getAccrual());
		processRosetta(path.newSubPath("expiryDate"), processor, FxExpiryDate.class, getExpiryDate());
		processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.class, getExpirySchedule());
		processRosetta(path.newSubPath("settlementDate"), processor, FxAdjustedDateAndDateAdjustments.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.class, getSettlementSchedule());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("trigger"), processor, FxAccrualTrigger.class, getTrigger());
		processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.class, getBarrier());
		processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.class, getPremium());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualDigitalOptionBuilder extends FxAccrualDigitalOption, Option.OptionBuilder {
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount();
		FxAccrual.FxAccrualBuilder getOrCreateAccrual();
		@Override
		FxAccrual.FxAccrualBuilder getAccrual();
		FxExpiryDate.FxExpiryDateBuilder getOrCreateExpiryDate();
		@Override
		FxExpiryDate.FxExpiryDateBuilder getExpiryDate();
		FxExpirySchedule.FxExpiryScheduleBuilder getOrCreateExpirySchedule();
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder getExpirySchedule();
		FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder getOrCreateSettlementDate();
		@Override
		FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder getSettlementDate();
		FxSettlementSchedule.FxSettlementScheduleBuilder getOrCreateSettlementSchedule();
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder getSettlementSchedule();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		@Override
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		FxAccrualTrigger.FxAccrualTriggerBuilder getOrCreateTrigger();
		@Override
		FxAccrualTrigger.FxAccrualTriggerBuilder getTrigger();
		FxAccrualBarrier.FxAccrualBarrierBuilder getOrCreateBarrier(int index);
		@Override
		List<? extends FxAccrualBarrier.FxAccrualBarrierBuilder> getBarrier();
		FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int index);
		@Override
		List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium();
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setId(String id);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addProductType(ProductType productType);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addProductType(ProductType productType, int idx);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addProductType(List<? extends ProductType> productType);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setProductType(List<? extends ProductType> productType);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addProductId(ProductId productId);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addProductId(ProductId productId, int idx);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addProductId(List<? extends ProductId> productId);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setProductId(List<? extends ProductId> productId);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addAssetClass(AssetClass assetClass);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setAccrual(FxAccrual accrual);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setExpiryDate(FxExpiryDate expiryDate);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setExpirySchedule(FxExpirySchedule expirySchedule);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setSettlementDate(FxAdjustedDateAndDateAdjustments settlementDate);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setSettlementSchedule(FxSettlementSchedule settlementSchedule);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setTrigger(FxAccrualTrigger trigger);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addBarrier(FxAccrualBarrier barrier);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addBarrier(FxAccrualBarrier barrier, int idx);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addBarrier(List<? extends FxAccrualBarrier> barrier);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setBarrier(List<? extends FxAccrualBarrier> barrier);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addPremium(FxOptionPremium premium);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addPremium(FxOptionPremium premium, int idx);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addPremium(List<? extends FxOptionPremium> premium);
		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setPremium(List<? extends FxOptionPremium> premium);

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
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("accrual"), processor, FxAccrual.FxAccrualBuilder.class, getAccrual());
			processRosetta(path.newSubPath("expiryDate"), processor, FxExpiryDate.FxExpiryDateBuilder.class, getExpiryDate());
			processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.FxExpiryScheduleBuilder.class, getExpirySchedule());
			processRosetta(path.newSubPath("settlementDate"), processor, FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.FxSettlementScheduleBuilder.class, getSettlementSchedule());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("trigger"), processor, FxAccrualTrigger.FxAccrualTriggerBuilder.class, getTrigger());
			processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.FxAccrualBarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.FxOptionPremiumBuilder.class, getPremium());
		}
		

		FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualDigitalOption  ***********************/
	class FxAccrualDigitalOptionImpl extends Option.OptionImpl implements FxAccrualDigitalOption {
		private final NonNegativeAmountSchedule notionalAmount;
		private final FxAccrual accrual;
		private final FxExpiryDate expiryDate;
		private final FxExpirySchedule expirySchedule;
		private final FxAdjustedDateAndDateAdjustments settlementDate;
		private final FxSettlementSchedule settlementSchedule;
		private final ExerciseProcedure exerciseProcedure;
		private final FxAccrualTrigger trigger;
		private final List<? extends FxAccrualBarrier> barrier;
		private final List<? extends FxOptionPremium> premium;
		
		protected FxAccrualDigitalOptionImpl(FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder builder) {
			super(builder);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.accrual = ofNullable(builder.getAccrual()).map(f->f.build()).orElse(null);
			this.expiryDate = ofNullable(builder.getExpiryDate()).map(f->f.build()).orElse(null);
			this.expirySchedule = ofNullable(builder.getExpirySchedule()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.settlementSchedule = ofNullable(builder.getSettlementSchedule()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.trigger = ofNullable(builder.getTrigger()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notionalAmount")
		public NonNegativeAmountSchedule getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("accrual")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accrual")
		public FxAccrual getAccrual() {
			return accrual;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryDate")
		public FxExpiryDate getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("expirySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirySchedule")
		public FxExpirySchedule getExpirySchedule() {
			return expirySchedule;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public FxAdjustedDateAndDateAdjustments getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementSchedule")
		public FxSettlementSchedule getSettlementSchedule() {
			return settlementSchedule;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseProcedure")
		public ExerciseProcedure getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("trigger")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("trigger")
		public FxAccrualTrigger getTrigger() {
			return trigger;
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("barrier")
		public List<? extends FxAccrualBarrier> getBarrier() {
			return barrier;
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
		public FxAccrualDigitalOption build() {
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder toBuilder() {
			FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getAccrual()).ifPresent(builder::setAccrual);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getExpirySchedule()).ifPresent(builder::setExpirySchedule);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getSettlementSchedule()).ifPresent(builder::setSettlementSchedule);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getTrigger()).ifPresent(builder::setTrigger);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualDigitalOption _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expirySchedule != null ? expirySchedule.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementSchedule != null ? settlementSchedule.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualDigitalOption {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"expirySchedule=" + this.expirySchedule + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementSchedule=" + this.settlementSchedule + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"trigger=" + this.trigger + ", " +
				"barrier=" + this.barrier + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualDigitalOption  ***********************/
	class FxAccrualDigitalOptionBuilderImpl extends Option.OptionBuilderImpl implements FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder {
	
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected FxAccrual.FxAccrualBuilder accrual;
		protected FxExpiryDate.FxExpiryDateBuilder expiryDate;
		protected FxExpirySchedule.FxExpiryScheduleBuilder expirySchedule;
		protected FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder settlementDate;
		protected FxSettlementSchedule.FxSettlementScheduleBuilder settlementSchedule;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected FxAccrualTrigger.FxAccrualTriggerBuilder trigger;
		protected List<FxAccrualBarrier.FxAccrualBarrierBuilder> barrier = new ArrayList<>();
		protected List<FxOptionPremium.FxOptionPremiumBuilder> premium = new ArrayList<>();
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notionalAmount")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrual")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accrual")
		public FxAccrual.FxAccrualBuilder getAccrual() {
			return accrual;
		}
		
		@Override
		public FxAccrual.FxAccrualBuilder getOrCreateAccrual() {
			FxAccrual.FxAccrualBuilder result;
			if (accrual!=null) {
				result = accrual;
			}
			else {
				result = accrual = FxAccrual.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryDate")
		public FxExpiryDate.FxExpiryDateBuilder getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		public FxExpiryDate.FxExpiryDateBuilder getOrCreateExpiryDate() {
			FxExpiryDate.FxExpiryDateBuilder result;
			if (expiryDate!=null) {
				result = expiryDate;
			}
			else {
				result = expiryDate = FxExpiryDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirySchedule")
		public FxExpirySchedule.FxExpiryScheduleBuilder getExpirySchedule() {
			return expirySchedule;
		}
		
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder getOrCreateExpirySchedule() {
			FxExpirySchedule.FxExpiryScheduleBuilder result;
			if (expirySchedule!=null) {
				result = expirySchedule;
			}
			else {
				result = expirySchedule = FxExpirySchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder getOrCreateSettlementDate() {
			FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = FxAdjustedDateAndDateAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementSchedule")
		public FxSettlementSchedule.FxSettlementScheduleBuilder getSettlementSchedule() {
			return settlementSchedule;
		}
		
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder getOrCreateSettlementSchedule() {
			FxSettlementSchedule.FxSettlementScheduleBuilder result;
			if (settlementSchedule!=null) {
				result = settlementSchedule;
			}
			else {
				result = settlementSchedule = FxSettlementSchedule.builder();
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
		@RosettaAttribute("trigger")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("trigger")
		public FxAccrualTrigger.FxAccrualTriggerBuilder getTrigger() {
			return trigger;
		}
		
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder getOrCreateTrigger() {
			FxAccrualTrigger.FxAccrualTriggerBuilder result;
			if (trigger!=null) {
				result = trigger;
			}
			else {
				result = trigger = FxAccrualTrigger.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("barrier")
		public List<? extends FxAccrualBarrier.FxAccrualBarrierBuilder> getBarrier() {
			return barrier;
		}
		
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder getOrCreateBarrier(int index) {
			if (barrier==null) {
				this.barrier = new ArrayList<>();
			}
			return getIndex(barrier, index, () -> {
						FxAccrualBarrier.FxAccrualBarrierBuilder newBarrier = FxAccrualBarrier.builder();
						return newBarrier;
					});
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addProductId(List<? extends ProductId> productIds) {
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
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setProductId(List<? extends ProductId> productIds) {
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
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notionalAmount")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setNotionalAmount(NonNegativeAmountSchedule _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrual")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrual")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setAccrual(FxAccrual _accrual) {
			this.accrual = _accrual == null ? null : _accrual.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryDate")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setExpiryDate(FxExpiryDate _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirySchedule")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setExpirySchedule(FxExpirySchedule _expirySchedule) {
			this.expirySchedule = _expirySchedule == null ? null : _expirySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setSettlementDate(FxAdjustedDateAndDateAdjustments _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementSchedule")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setSettlementSchedule(FxSettlementSchedule _settlementSchedule) {
			this.settlementSchedule = _settlementSchedule == null ? null : _settlementSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseProcedure")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setExerciseProcedure(ExerciseProcedure _exerciseProcedure) {
			this.exerciseProcedure = _exerciseProcedure == null ? null : _exerciseProcedure.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trigger")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("trigger")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setTrigger(FxAccrualTrigger _trigger) {
			this.trigger = _trigger == null ? null : _trigger.toBuilder();
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("barrier")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addBarrier(FxAccrualBarrier _barrier) {
			if (_barrier != null) {
				this.barrier.add(_barrier.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addBarrier(FxAccrualBarrier _barrier, int idx) {
			getIndex(this.barrier, idx, () -> _barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addBarrier(List<? extends FxAccrualBarrier> barriers) {
			if (barriers != null) {
				for (final FxAccrualBarrier toAdd : barriers) {
					this.barrier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("barrier")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setBarrier(List<? extends FxAccrualBarrier> barriers) {
			if (barriers == null) {
				this.barrier = new ArrayList<>();
			} else {
				this.barrier = barriers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addPremium(FxOptionPremium _premium) {
			if (_premium != null) {
				this.premium.add(_premium.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addPremium(FxOptionPremium _premium, int idx) {
			getIndex(this.premium, idx, () -> _premium.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder addPremium(List<? extends FxOptionPremium> premiums) {
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
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder setPremium(List<? extends FxOptionPremium> premiums) {
			if (premiums == null) {
				this.premium = new ArrayList<>();
			} else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxAccrualDigitalOption build() {
			return new FxAccrualDigitalOption.FxAccrualDigitalOptionImpl(this);
		}
		
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder prune() {
			super.prune();
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (accrual!=null && !accrual.prune().hasData()) accrual = null;
			if (expiryDate!=null && !expiryDate.prune().hasData()) expiryDate = null;
			if (expirySchedule!=null && !expirySchedule.prune().hasData()) expirySchedule = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (settlementSchedule!=null && !settlementSchedule.prune().hasData()) settlementSchedule = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (trigger!=null && !trigger.prune().hasData()) trigger = null;
			barrier = barrier.stream().filter(b->b!=null).<FxAccrualBarrier.FxAccrualBarrierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			premium = premium.stream().filter(b->b!=null).<FxOptionPremium.FxOptionPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getAccrual()!=null && getAccrual().hasData()) return true;
			if (getExpiryDate()!=null && getExpiryDate().hasData()) return true;
			if (getExpirySchedule()!=null && getExpirySchedule().hasData()) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getSettlementSchedule()!=null && getSettlementSchedule().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getTrigger()!=null && getTrigger().hasData()) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder o = (FxAccrualDigitalOption.FxAccrualDigitalOptionBuilder) other;
			
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getAccrual(), o.getAccrual(), this::setAccrual);
			merger.mergeRosetta(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeRosetta(getExpirySchedule(), o.getExpirySchedule(), this::setExpirySchedule);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getSettlementSchedule(), o.getSettlementSchedule(), this::setSettlementSchedule);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getTrigger(), o.getTrigger(), this::setTrigger);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::getOrCreateBarrier);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualDigitalOption _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expirySchedule != null ? expirySchedule.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementSchedule != null ? settlementSchedule.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualDigitalOptionBuilder {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"expirySchedule=" + this.expirySchedule + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementSchedule=" + this.settlementSchedule + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"trigger=" + this.trigger + ", " +
				"barrier=" + this.barrier + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}
}

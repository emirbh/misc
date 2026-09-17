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
import fpml.consolidated.fx.meta.FxDigitalOptionMeta;
import fpml.consolidated.option.shared.Option;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Period;
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
 * Provision Describes an option having a triggerable fixed payout.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes an option having a triggerable fixed payout.
 *
 */
@RosettaDataType(value="FxDigitalOption", builder=FxDigitalOption.FxDigitalOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxDigitalOption", model="fpml", builder=FxDigitalOption.FxDigitalOptionBuilderImpl.class, version="2.1.1")
public interface FxDigitalOption extends Option {

	FxDigitalOptionMeta metaData = new FxDigitalOptionMeta();

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
	FxDigitalAmericanExercise getAmericanExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines one or more conditions underwhich the option will payout if exercisable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines one or more conditions underwhich the option will payout if exercisable.
	 *
	 */
	List<? extends FxTouch> getTouch();
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
	 * Provision Defines one or more conditions underwhich the option will payout if exercisable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines one or more conditions underwhich the option will payout if exercisable.
	 *
	 */
	List<? extends FxTrigger> getTrigger();
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
	 * Provision The amount of currency which becomes payable if and when a trigger event occurs.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of currency which becomes payable if and when a trigger event occurs.
	 *
	 */
	FxOptionPayout getPayout();
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
	FxDigitalOption build();
	
	FxDigitalOption.FxDigitalOptionBuilder toBuilder();
	
	static FxDigitalOption.FxDigitalOptionBuilder builder() {
		return new FxDigitalOption.FxDigitalOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDigitalOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxDigitalOption> getType() {
		return FxDigitalOption.class;
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
		processRosetta(path.newSubPath("americanExercise"), processor, FxDigitalAmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("touch"), processor, FxTouch.class, getTouch());
		processRosetta(path.newSubPath("europeanExercise"), processor, FxEuropeanExercise.class, getEuropeanExercise());
		processRosetta(path.newSubPath("trigger"), processor, FxTrigger.class, getTrigger());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("payout"), processor, FxOptionPayout.class, getPayout());
		processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.class, getPremium());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDigitalOptionBuilder extends FxDigitalOption, Option.OptionBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		Period.PeriodBuilder getOrCreateTenorPeriod();
		@Override
		Period.PeriodBuilder getTenorPeriod();
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder getOrCreateAmericanExercise();
		@Override
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder getAmericanExercise();
		FxTouch.FxTouchBuilder getOrCreateTouch(int index);
		@Override
		List<? extends FxTouch.FxTouchBuilder> getTouch();
		FxEuropeanExercise.FxEuropeanExerciseBuilder getOrCreateEuropeanExercise();
		@Override
		FxEuropeanExercise.FxEuropeanExerciseBuilder getEuropeanExercise();
		FxTrigger.FxTriggerBuilder getOrCreateTrigger(int index);
		@Override
		List<? extends FxTrigger.FxTriggerBuilder> getTrigger();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		@Override
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		FxOptionPayout.FxOptionPayoutBuilder getOrCreatePayout();
		@Override
		FxOptionPayout.FxOptionPayoutBuilder getPayout();
		FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int index);
		@Override
		List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium();
		@Override
		FxDigitalOption.FxDigitalOptionBuilder setId(String id);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addProductType(ProductType productType);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addProductType(ProductType productType, int idx);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addProductType(List<? extends ProductType> productType);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder setProductType(List<? extends ProductType> productType);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addProductId(ProductId productId);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addProductId(ProductId productId, int idx);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addProductId(List<? extends ProductId> productId);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder setProductId(List<? extends ProductId> productId);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addAssetClass(AssetClass assetClass);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		FxDigitalOption.FxDigitalOptionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		FxDigitalOption.FxDigitalOptionBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		FxDigitalOption.FxDigitalOptionBuilder setTenorPeriod(Period tenorPeriod);
		FxDigitalOption.FxDigitalOptionBuilder setAmericanExercise(FxDigitalAmericanExercise americanExercise);
		FxDigitalOption.FxDigitalOptionBuilder addTouch(FxTouch touch);
		FxDigitalOption.FxDigitalOptionBuilder addTouch(FxTouch touch, int idx);
		FxDigitalOption.FxDigitalOptionBuilder addTouch(List<? extends FxTouch> touch);
		FxDigitalOption.FxDigitalOptionBuilder setTouch(List<? extends FxTouch> touch);
		FxDigitalOption.FxDigitalOptionBuilder setEuropeanExercise(FxEuropeanExercise europeanExercise);
		FxDigitalOption.FxDigitalOptionBuilder addTrigger(FxTrigger trigger);
		FxDigitalOption.FxDigitalOptionBuilder addTrigger(FxTrigger trigger, int idx);
		FxDigitalOption.FxDigitalOptionBuilder addTrigger(List<? extends FxTrigger> trigger);
		FxDigitalOption.FxDigitalOptionBuilder setTrigger(List<? extends FxTrigger> trigger);
		FxDigitalOption.FxDigitalOptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		FxDigitalOption.FxDigitalOptionBuilder setPayout(FxOptionPayout payout);
		FxDigitalOption.FxDigitalOptionBuilder addPremium(FxOptionPremium premium);
		FxDigitalOption.FxDigitalOptionBuilder addPremium(FxOptionPremium premium, int idx);
		FxDigitalOption.FxDigitalOptionBuilder addPremium(List<? extends FxOptionPremium> premium);
		FxDigitalOption.FxDigitalOptionBuilder setPremium(List<? extends FxOptionPremium> premium);

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
			processRosetta(path.newSubPath("americanExercise"), processor, FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("touch"), processor, FxTouch.FxTouchBuilder.class, getTouch());
			processRosetta(path.newSubPath("europeanExercise"), processor, FxEuropeanExercise.FxEuropeanExerciseBuilder.class, getEuropeanExercise());
			processRosetta(path.newSubPath("trigger"), processor, FxTrigger.FxTriggerBuilder.class, getTrigger());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("payout"), processor, FxOptionPayout.FxOptionPayoutBuilder.class, getPayout());
			processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.FxOptionPremiumBuilder.class, getPremium());
		}
		

		FxDigitalOption.FxDigitalOptionBuilder prune();
	}

	/*********************** Immutable Implementation of FxDigitalOption  ***********************/
	class FxDigitalOptionImpl extends Option.OptionImpl implements FxDigitalOption {
		private final AdjustableOrRelativeDate effectiveDate;
		private final Period tenorPeriod;
		private final FxDigitalAmericanExercise americanExercise;
		private final List<? extends FxTouch> touch;
		private final FxEuropeanExercise europeanExercise;
		private final List<? extends FxTrigger> trigger;
		private final ExerciseProcedure exerciseProcedure;
		private final FxOptionPayout payout;
		private final List<? extends FxOptionPremium> premium;
		
		protected FxDigitalOptionImpl(FxDigitalOption.FxDigitalOptionBuilder builder) {
			super(builder);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.tenorPeriod = ofNullable(builder.getTenorPeriod()).map(f->f.build()).orElse(null);
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.touch = ofNullable(builder.getTouch()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.trigger = ofNullable(builder.getTrigger()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.payout = ofNullable(builder.getPayout()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		public FxDigitalAmericanExercise getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		@RosettaAttribute("touch")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("touch")
		public List<? extends FxTouch> getTouch() {
			return touch;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("europeanExercise")
		public FxEuropeanExercise getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		@RosettaAttribute("trigger")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("trigger")
		public List<? extends FxTrigger> getTrigger() {
			return trigger;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseProcedure")
		public ExerciseProcedure getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("payout")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("payout")
		public FxOptionPayout getPayout() {
			return payout;
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
		public FxDigitalOption build() {
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder toBuilder() {
			FxDigitalOption.FxDigitalOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDigitalOption.FxDigitalOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTenorPeriod()).ifPresent(builder::setTenorPeriod);
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getTouch()).ifPresent(builder::setTouch);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getTrigger()).ifPresent(builder::setTrigger);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getPayout()).ifPresent(builder::setPayout);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxDigitalOption _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!ListEquals.listEquals(touch, _that.getTouch())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!ListEquals.listEquals(trigger, _that.getTrigger())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(payout, _that.getPayout())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (touch != null ? touch.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDigitalOption {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"americanExercise=" + this.americanExercise + ", " +
				"touch=" + this.touch + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"trigger=" + this.trigger + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"payout=" + this.payout + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxDigitalOption  ***********************/
	class FxDigitalOptionBuilderImpl extends Option.OptionBuilderImpl implements FxDigitalOption.FxDigitalOptionBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected Period.PeriodBuilder tenorPeriod;
		protected FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder americanExercise;
		protected List<FxTouch.FxTouchBuilder> touch = new ArrayList<>();
		protected FxEuropeanExercise.FxEuropeanExerciseBuilder europeanExercise;
		protected List<FxTrigger.FxTriggerBuilder> trigger = new ArrayList<>();
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected FxOptionPayout.FxOptionPayoutBuilder payout;
		protected List<FxOptionPremium.FxOptionPremiumBuilder> premium = new ArrayList<>();
		
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
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder getOrCreateAmericanExercise() {
			FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder result;
			if (americanExercise!=null) {
				result = americanExercise;
			}
			else {
				result = americanExercise = FxDigitalAmericanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("touch")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("touch")
		public List<? extends FxTouch.FxTouchBuilder> getTouch() {
			return touch;
		}
		
		@Override
		public FxTouch.FxTouchBuilder getOrCreateTouch(int index) {
			if (touch==null) {
				this.touch = new ArrayList<>();
			}
			return getIndex(touch, index, () -> {
						FxTouch.FxTouchBuilder newTouch = FxTouch.builder();
						return newTouch;
					});
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
		@RosettaAttribute("trigger")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("trigger")
		public List<? extends FxTrigger.FxTriggerBuilder> getTrigger() {
			return trigger;
		}
		
		@Override
		public FxTrigger.FxTriggerBuilder getOrCreateTrigger(int index) {
			if (trigger==null) {
				this.trigger = new ArrayList<>();
			}
			return getIndex(trigger, index, () -> {
						FxTrigger.FxTriggerBuilder newTrigger = FxTrigger.builder();
						return newTrigger;
					});
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
		@RosettaAttribute("payout")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("payout")
		public FxOptionPayout.FxOptionPayoutBuilder getPayout() {
			return payout;
		}
		
		@Override
		public FxOptionPayout.FxOptionPayoutBuilder getOrCreatePayout() {
			FxOptionPayout.FxOptionPayoutBuilder result;
			if (payout!=null) {
				result = payout;
			}
			else {
				result = payout = FxOptionPayout.builder();
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxDigitalOption.FxDigitalOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxDigitalOption.FxDigitalOptionBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public FxDigitalOption.FxDigitalOptionBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public FxDigitalOption.FxDigitalOptionBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addProductId(List<? extends ProductId> productIds) {
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
		public FxDigitalOption.FxDigitalOptionBuilder setProductId(List<? extends ProductId> productIds) {
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
		public FxDigitalOption.FxDigitalOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxDigitalOption.FxDigitalOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxDigitalOption.FxDigitalOptionBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxDigitalOption.FxDigitalOptionBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxDigitalOption.FxDigitalOptionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tenorPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tenorPeriod")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder setTenorPeriod(Period _tenorPeriod) {
			this.tenorPeriod = _tenorPeriod == null ? null : _tenorPeriod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("americanExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("americanExercise")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder setAmericanExercise(FxDigitalAmericanExercise _americanExercise) {
			this.americanExercise = _americanExercise == null ? null : _americanExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("touch")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("touch")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addTouch(FxTouch _touch) {
			if (_touch != null) {
				this.touch.add(_touch.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addTouch(FxTouch _touch, int idx) {
			getIndex(this.touch, idx, () -> _touch.toBuilder());
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addTouch(List<? extends FxTouch> touchs) {
			if (touchs != null) {
				for (final FxTouch toAdd : touchs) {
					this.touch.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("touch")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("touch")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder setTouch(List<? extends FxTouch> touchs) {
			if (touchs == null) {
				this.touch = new ArrayList<>();
			} else {
				this.touch = touchs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("europeanExercise")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder setEuropeanExercise(FxEuropeanExercise _europeanExercise) {
			this.europeanExercise = _europeanExercise == null ? null : _europeanExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trigger")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("trigger")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addTrigger(FxTrigger _trigger) {
			if (_trigger != null) {
				this.trigger.add(_trigger.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addTrigger(FxTrigger _trigger, int idx) {
			getIndex(this.trigger, idx, () -> _trigger.toBuilder());
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addTrigger(List<? extends FxTrigger> triggers) {
			if (triggers != null) {
				for (final FxTrigger toAdd : triggers) {
					this.trigger.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("trigger")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("trigger")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder setTrigger(List<? extends FxTrigger> triggers) {
			if (triggers == null) {
				this.trigger = new ArrayList<>();
			} else {
				this.trigger = triggers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseProcedure")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder setExerciseProcedure(ExerciseProcedure _exerciseProcedure) {
			this.exerciseProcedure = _exerciseProcedure == null ? null : _exerciseProcedure.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payout")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payout")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder setPayout(FxOptionPayout _payout) {
			this.payout = _payout == null ? null : _payout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addPremium(FxOptionPremium _premium) {
			if (_premium != null) {
				this.premium.add(_premium.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addPremium(FxOptionPremium _premium, int idx) {
			getIndex(this.premium, idx, () -> _premium.toBuilder());
			return this;
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder addPremium(List<? extends FxOptionPremium> premiums) {
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
		public FxDigitalOption.FxDigitalOptionBuilder setPremium(List<? extends FxOptionPremium> premiums) {
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
		public FxDigitalOption build() {
			return new FxDigitalOption.FxDigitalOptionImpl(this);
		}
		
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder prune() {
			super.prune();
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (tenorPeriod!=null && !tenorPeriod.prune().hasData()) tenorPeriod = null;
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			touch = touch.stream().filter(b->b!=null).<FxTouch.FxTouchBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			trigger = trigger.stream().filter(b->b!=null).<FxTrigger.FxTriggerBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (payout!=null && !payout.prune().hasData()) payout = null;
			premium = premium.stream().filter(b->b!=null).<FxOptionPremium.FxOptionPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTenorPeriod()!=null && getTenorPeriod().hasData()) return true;
			if (getAmericanExercise()!=null && getAmericanExercise().hasData()) return true;
			if (getTouch()!=null && getTouch().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getTrigger()!=null && getTrigger().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getPayout()!=null && getPayout().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDigitalOption.FxDigitalOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxDigitalOption.FxDigitalOptionBuilder o = (FxDigitalOption.FxDigitalOptionBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTenorPeriod(), o.getTenorPeriod(), this::setTenorPeriod);
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getTouch(), o.getTouch(), this::getOrCreateTouch);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getTrigger(), o.getTrigger(), this::getOrCreateTrigger);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getPayout(), o.getPayout(), this::setPayout);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxDigitalOption _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!ListEquals.listEquals(touch, _that.getTouch())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!ListEquals.listEquals(trigger, _that.getTrigger())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(payout, _that.getPayout())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (touch != null ? touch.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDigitalOptionBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"americanExercise=" + this.americanExercise + ", " +
				"touch=" + this.touch + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"trigger=" + this.trigger + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"payout=" + this.payout + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}
}

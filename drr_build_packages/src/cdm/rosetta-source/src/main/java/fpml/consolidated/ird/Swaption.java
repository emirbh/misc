package fpml.consolidated.ird;

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
import fpml.consolidated.fpmlenum.SwaptionTypeEnum;
import fpml.consolidated.ird.meta.SwaptionMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
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
 * Provision A type to define an option on a swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type to define an option on a swap.
 *
 */
@RosettaDataType(value="Swaption", builder=Swaption.SwaptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Swaption", model="fpml", builder=Swaption.SwaptionBuilderImpl.class, version="2.1.1")
public interface Swaption extends Product {

	SwaptionMeta metaData = new SwaptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 */
	PartyReference getBuyerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 */
	AccountReference getBuyerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 */
	PartyReference getSellerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 */
	AccountReference getSellerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The option premium amount payable by buyer to seller on the specified payment date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The option premium amount payable by buyer to seller on the specified payment date.
	 *
	 */
	List<? extends Payment> getPremium();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of option transaction. From a usage standpoint, put/call is the default option type, while payer/receiver indicator is used for options index credit default swaps, consistently with the industry practice. Straddle is used for the case of straddle strategy, that combine a call and a put with the same strike. This element is needed for transparency reporting because the counterparties are not available, and is made available in other views for convenience; it is not intended to be used for confirmation processing. If the swaption straddle indicator is provided, this must not be in conflict with that indicator.
	 *
	 */
	SwaptionTypeEnum getOptionType();
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
	 * Provision The ISDA Calculation Agent responsible for performing duties associated with an optional early termination.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA Calculation Agent responsible for performing duties associated with an optional early termination.
	 *
	 */
	CalculationAgent getCalculationAgent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement procedure. If not specified, then physical settlement is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement procedure. If not specified, then physical settlement is applicable.
	 *
	 */
	CashSettlement getCashSettlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If specified, this defines physical settlement terms which apply to the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If specified, this defines physical settlement terms which apply to the transaction.
	 *
	 */
	SwaptionPhysicalSettlement getPhysicalSettlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether the option is a swaption or a swaption straddle.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Whether the option is a swaption or a swaption straddle.
	 *
	 */
	Boolean getSwaptionStraddle();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Parameters specifying provisions relating to the optional and mandatory early terminarion of a swap transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Parameters specifying provisions relating to the optional and mandatory early terminarion of a swap transaction.
	 *
	 */
	EarlyTerminationProvision getEarlyTerminationProvision();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The adjusted dates associated with swaption exercise. These dates have been adjusted for any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The adjusted dates associated with swaption exercise. These dates have been adjusted for any applicable business day convention.
	 *
	 */
	SwaptionAdjustedDates getSwaptionAdjustedDates();
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
	Swap getSwap();

	/*********************** Build Methods  ***********************/
	Swaption build();
	
	Swaption.SwaptionBuilder toBuilder();
	
	static Swaption.SwaptionBuilder builder() {
		return new Swaption.SwaptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Swaption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Swaption> getType() {
		return Swaption.class;
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
		processRosetta(path.newSubPath("premium"), processor, Payment.class, getPremium());
		processor.processBasic(path.newSubPath("optionType"), SwaptionTypeEnum.class, getOptionType(), this);
		processRosetta(path.newSubPath("exercise"), processor, Exercise.class, getExercise());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.class, getCalculationAgent());
		processRosetta(path.newSubPath("cashSettlement"), processor, CashSettlement.class, getCashSettlement());
		processRosetta(path.newSubPath("physicalSettlement"), processor, SwaptionPhysicalSettlement.class, getPhysicalSettlement());
		processor.processBasic(path.newSubPath("swaptionStraddle"), Boolean.class, getSwaptionStraddle(), this);
		processRosetta(path.newSubPath("earlyTerminationProvision"), processor, EarlyTerminationProvision.class, getEarlyTerminationProvision());
		processRosetta(path.newSubPath("swaptionAdjustedDates"), processor, SwaptionAdjustedDates.class, getSwaptionAdjustedDates());
		processRosetta(path.newSubPath("swap"), processor, Swap.class, getSwap());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SwaptionBuilder extends Swaption, Product.ProductBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getBuyerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getSellerAccountReference();
		Payment.PaymentBuilder getOrCreatePremium(int index);
		@Override
		List<? extends Payment.PaymentBuilder> getPremium();
		Exercise.ExerciseBuilder getOrCreateExercise();
		@Override
		Exercise.ExerciseBuilder getExercise();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		@Override
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent();
		@Override
		CalculationAgent.CalculationAgentBuilder getCalculationAgent();
		CashSettlement.CashSettlementBuilder getOrCreateCashSettlement();
		@Override
		CashSettlement.CashSettlementBuilder getCashSettlement();
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreatePhysicalSettlement();
		@Override
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getPhysicalSettlement();
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder getOrCreateEarlyTerminationProvision();
		@Override
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder getEarlyTerminationProvision();
		SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder getOrCreateSwaptionAdjustedDates();
		@Override
		SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder getSwaptionAdjustedDates();
		Swap.SwapBuilder getOrCreateSwap();
		@Override
		Swap.SwapBuilder getSwap();
		@Override
		Swaption.SwaptionBuilder setId(String id);
		@Override
		Swaption.SwaptionBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		Swaption.SwaptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		Swaption.SwaptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		Swaption.SwaptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		Swaption.SwaptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		Swaption.SwaptionBuilder addProductType(ProductType productType);
		@Override
		Swaption.SwaptionBuilder addProductType(ProductType productType, int idx);
		@Override
		Swaption.SwaptionBuilder addProductType(List<? extends ProductType> productType);
		@Override
		Swaption.SwaptionBuilder setProductType(List<? extends ProductType> productType);
		@Override
		Swaption.SwaptionBuilder addProductId(ProductId productId);
		@Override
		Swaption.SwaptionBuilder addProductId(ProductId productId, int idx);
		@Override
		Swaption.SwaptionBuilder addProductId(List<? extends ProductId> productId);
		@Override
		Swaption.SwaptionBuilder setProductId(List<? extends ProductId> productId);
		@Override
		Swaption.SwaptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		Swaption.SwaptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		Swaption.SwaptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		Swaption.SwaptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		Swaption.SwaptionBuilder addAssetClass(AssetClass assetClass);
		@Override
		Swaption.SwaptionBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		Swaption.SwaptionBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		Swaption.SwaptionBuilder setAssetClass(List<? extends AssetClass> assetClass);
		Swaption.SwaptionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		Swaption.SwaptionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		Swaption.SwaptionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		Swaption.SwaptionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		Swaption.SwaptionBuilder addPremium(Payment premium);
		Swaption.SwaptionBuilder addPremium(Payment premium, int idx);
		Swaption.SwaptionBuilder addPremium(List<? extends Payment> premium);
		Swaption.SwaptionBuilder setPremium(List<? extends Payment> premium);
		Swaption.SwaptionBuilder setOptionType(SwaptionTypeEnum optionType);
		Swaption.SwaptionBuilder setExercise(Exercise exercise);
		Swaption.SwaptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		Swaption.SwaptionBuilder setCalculationAgent(CalculationAgent calculationAgent);
		Swaption.SwaptionBuilder setCashSettlement(CashSettlement cashSettlement);
		Swaption.SwaptionBuilder setPhysicalSettlement(SwaptionPhysicalSettlement physicalSettlement);
		Swaption.SwaptionBuilder setSwaptionStraddle(Boolean swaptionStraddle);
		Swaption.SwaptionBuilder setEarlyTerminationProvision(EarlyTerminationProvision earlyTerminationProvision);
		Swaption.SwaptionBuilder setSwaptionAdjustedDates(SwaptionAdjustedDates swaptionAdjustedDates);
		Swaption.SwaptionBuilder setSwap(Swap swap);

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
			processRosetta(path.newSubPath("premium"), processor, Payment.PaymentBuilder.class, getPremium());
			processor.processBasic(path.newSubPath("optionType"), SwaptionTypeEnum.class, getOptionType(), this);
			processRosetta(path.newSubPath("exercise"), processor, Exercise.ExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.CalculationAgentBuilder.class, getCalculationAgent());
			processRosetta(path.newSubPath("cashSettlement"), processor, CashSettlement.CashSettlementBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("physicalSettlement"), processor, SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder.class, getPhysicalSettlement());
			processor.processBasic(path.newSubPath("swaptionStraddle"), Boolean.class, getSwaptionStraddle(), this);
			processRosetta(path.newSubPath("earlyTerminationProvision"), processor, EarlyTerminationProvision.EarlyTerminationProvisionBuilder.class, getEarlyTerminationProvision());
			processRosetta(path.newSubPath("swaptionAdjustedDates"), processor, SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder.class, getSwaptionAdjustedDates());
			processRosetta(path.newSubPath("swap"), processor, Swap.SwapBuilder.class, getSwap());
		}
		

		Swaption.SwaptionBuilder prune();
	}

	/*********************** Immutable Implementation of Swaption  ***********************/
	class SwaptionImpl extends Product.ProductImpl implements Swaption {
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final List<? extends Payment> premium;
		private final SwaptionTypeEnum optionType;
		private final Exercise exercise;
		private final ExerciseProcedure exerciseProcedure;
		private final CalculationAgent calculationAgent;
		private final CashSettlement cashSettlement;
		private final SwaptionPhysicalSettlement physicalSettlement;
		private final Boolean swaptionStraddle;
		private final EarlyTerminationProvision earlyTerminationProvision;
		private final SwaptionAdjustedDates swaptionAdjustedDates;
		private final Swap swap;
		
		protected SwaptionImpl(Swaption.SwaptionBuilder builder) {
			super(builder);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.optionType = builder.getOptionType();
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.calculationAgent = ofNullable(builder.getCalculationAgent()).map(f->f.build()).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.physicalSettlement = ofNullable(builder.getPhysicalSettlement()).map(f->f.build()).orElse(null);
			this.swaptionStraddle = builder.getSwaptionStraddle();
			this.earlyTerminationProvision = ofNullable(builder.getEarlyTerminationProvision()).map(f->f.build()).orElse(null);
			this.swaptionAdjustedDates = ofNullable(builder.getSwaptionAdjustedDates()).map(f->f.build()).orElse(null);
			this.swap = ofNullable(builder.getSwap()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("premium")
		public List<? extends Payment> getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public SwaptionTypeEnum getOptionType() {
			return optionType;
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
		@RosettaAttribute("calculationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgent")
		public CalculationAgent getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public CashSettlement getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlement")
		public SwaptionPhysicalSettlement getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		@RosettaAttribute("swaptionStraddle")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("swaptionStraddle")
		public Boolean getSwaptionStraddle() {
			return swaptionStraddle;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTerminationProvision")
		public EarlyTerminationProvision getEarlyTerminationProvision() {
			return earlyTerminationProvision;
		}
		
		@Override
		@RosettaAttribute("swaptionAdjustedDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("swaptionAdjustedDates")
		public SwaptionAdjustedDates getSwaptionAdjustedDates() {
			return swaptionAdjustedDates;
		}
		
		@Override
		@RosettaAttribute("swap")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("swap")
		public Swap getSwap() {
			return swap;
		}
		
		@Override
		public Swaption build() {
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder toBuilder() {
			Swaption.SwaptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Swaption.SwaptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getCalculationAgent()).ifPresent(builder::setCalculationAgent);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getPhysicalSettlement()).ifPresent(builder::setPhysicalSettlement);
			ofNullable(getSwaptionStraddle()).ifPresent(builder::setSwaptionStraddle);
			ofNullable(getEarlyTerminationProvision()).ifPresent(builder::setEarlyTerminationProvision);
			ofNullable(getSwaptionAdjustedDates()).ifPresent(builder::setSwaptionAdjustedDates);
			ofNullable(getSwap()).ifPresent(builder::setSwap);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Swaption _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			if (!Objects.equals(swaptionStraddle, _that.getSwaptionStraddle())) return false;
			if (!Objects.equals(earlyTerminationProvision, _that.getEarlyTerminationProvision())) return false;
			if (!Objects.equals(swaptionAdjustedDates, _that.getSwaptionAdjustedDates())) return false;
			if (!Objects.equals(swap, _that.getSwap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			_result = 31 * _result + (swaptionStraddle != null ? swaptionStraddle.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationProvision != null ? earlyTerminationProvision.hashCode() : 0);
			_result = 31 * _result + (swaptionAdjustedDates != null ? swaptionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (swap != null ? swap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Swaption {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"premium=" + this.premium + ", " +
				"optionType=" + this.optionType + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"swaptionStraddle=" + this.swaptionStraddle + ", " +
				"earlyTerminationProvision=" + this.earlyTerminationProvision + ", " +
				"swaptionAdjustedDates=" + this.swaptionAdjustedDates + ", " +
				"swap=" + this.swap +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Swaption  ***********************/
	class SwaptionBuilderImpl extends Product.ProductBuilderImpl implements Swaption.SwaptionBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected List<Payment.PaymentBuilder> premium = new ArrayList<>();
		protected SwaptionTypeEnum optionType;
		protected Exercise.ExerciseBuilder exercise;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected CalculationAgent.CalculationAgentBuilder calculationAgent;
		protected CashSettlement.CashSettlementBuilder cashSettlement;
		protected SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder physicalSettlement;
		protected Boolean swaptionStraddle;
		protected EarlyTerminationProvision.EarlyTerminationProvisionBuilder earlyTerminationProvision;
		protected SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder swaptionAdjustedDates;
		protected Swap.SwapBuilder swap;
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference.PartyReferenceBuilder getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (buyerPartyReference!=null) {
				result = buyerPartyReference;
			}
			else {
				result = buyerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference.AccountReferenceBuilder getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (buyerAccountReference!=null) {
				result = buyerAccountReference;
			}
			else {
				result = buyerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference.PartyReferenceBuilder getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (sellerPartyReference!=null) {
				result = sellerPartyReference;
			}
			else {
				result = sellerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference.AccountReferenceBuilder getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (sellerAccountReference!=null) {
				result = sellerAccountReference;
			}
			else {
				result = sellerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("premium")
		public List<? extends Payment.PaymentBuilder> getPremium() {
			return premium;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreatePremium(int index) {
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			return getIndex(premium, index, () -> {
						Payment.PaymentBuilder newPremium = Payment.builder();
						return newPremium;
					});
		}
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public SwaptionTypeEnum getOptionType() {
			return optionType;
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
		@RosettaAttribute("calculationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgent")
		public CalculationAgent.CalculationAgentBuilder getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent() {
			CalculationAgent.CalculationAgentBuilder result;
			if (calculationAgent!=null) {
				result = calculationAgent;
			}
			else {
				result = calculationAgent = CalculationAgent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public CashSettlement.CashSettlementBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public CashSettlement.CashSettlementBuilder getOrCreateCashSettlement() {
			CashSettlement.CashSettlementBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = CashSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlement")
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreatePhysicalSettlement() {
			SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder result;
			if (physicalSettlement!=null) {
				result = physicalSettlement;
			}
			else {
				result = physicalSettlement = SwaptionPhysicalSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("swaptionStraddle")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("swaptionStraddle")
		public Boolean getSwaptionStraddle() {
			return swaptionStraddle;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTerminationProvision")
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder getEarlyTerminationProvision() {
			return earlyTerminationProvision;
		}
		
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder getOrCreateEarlyTerminationProvision() {
			EarlyTerminationProvision.EarlyTerminationProvisionBuilder result;
			if (earlyTerminationProvision!=null) {
				result = earlyTerminationProvision;
			}
			else {
				result = earlyTerminationProvision = EarlyTerminationProvision.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("swaptionAdjustedDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("swaptionAdjustedDates")
		public SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder getSwaptionAdjustedDates() {
			return swaptionAdjustedDates;
		}
		
		@Override
		public SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder getOrCreateSwaptionAdjustedDates() {
			SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder result;
			if (swaptionAdjustedDates!=null) {
				result = swaptionAdjustedDates;
			}
			else {
				result = swaptionAdjustedDates = SwaptionAdjustedDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("swap")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("swap")
		public Swap.SwapBuilder getSwap() {
			return swap;
		}
		
		@Override
		public Swap.SwapBuilder getOrCreateSwap() {
			Swap.SwapBuilder result;
			if (swap!=null) {
				result = swap;
			}
			else {
				result = swap = Swap.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Swaption.SwaptionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public Swaption.SwaptionBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public Swaption.SwaptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public Swaption.SwaptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public Swaption.SwaptionBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public Swaption.SwaptionBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public Swaption.SwaptionBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder addProductId(List<? extends ProductId> productIds) {
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
		public Swaption.SwaptionBuilder setProductId(List<? extends ProductId> productIds) {
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
		public Swaption.SwaptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public Swaption.SwaptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public Swaption.SwaptionBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public Swaption.SwaptionBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public Swaption.SwaptionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public Swaption.SwaptionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public Swaption.SwaptionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public Swaption.SwaptionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public Swaption.SwaptionBuilder addPremium(Payment _premium) {
			if (_premium != null) {
				this.premium.add(_premium.toBuilder());
			}
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder addPremium(Payment _premium, int idx) {
			getIndex(this.premium, idx, () -> _premium.toBuilder());
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder addPremium(List<? extends Payment> premiums) {
			if (premiums != null) {
				for (final Payment toAdd : premiums) {
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
		public Swaption.SwaptionBuilder setPremium(List<? extends Payment> premiums) {
			if (premiums == null) {
				this.premium = new ArrayList<>();
			} else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public Swaption.SwaptionBuilder setOptionType(SwaptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exercise")
		@Override
		public Swaption.SwaptionBuilder setExercise(Exercise _exercise) {
			this.exercise = _exercise == null ? null : _exercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseProcedure")
		@Override
		public Swaption.SwaptionBuilder setExerciseProcedure(ExerciseProcedure _exerciseProcedure) {
			this.exerciseProcedure = _exerciseProcedure == null ? null : _exerciseProcedure.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationAgent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationAgent")
		@Override
		public Swaption.SwaptionBuilder setCalculationAgent(CalculationAgent _calculationAgent) {
			this.calculationAgent = _calculationAgent == null ? null : _calculationAgent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlement")
		@Override
		public Swaption.SwaptionBuilder setCashSettlement(CashSettlement _cashSettlement) {
			this.cashSettlement = _cashSettlement == null ? null : _cashSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalSettlement")
		@Override
		public Swaption.SwaptionBuilder setPhysicalSettlement(SwaptionPhysicalSettlement _physicalSettlement) {
			this.physicalSettlement = _physicalSettlement == null ? null : _physicalSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("swaptionStraddle")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("swaptionStraddle")
		@Override
		public Swaption.SwaptionBuilder setSwaptionStraddle(Boolean _swaptionStraddle) {
			this.swaptionStraddle = _swaptionStraddle == null ? null : _swaptionStraddle;
			return this;
		}
		
		@RosettaAttribute("earlyTerminationProvision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTerminationProvision")
		@Override
		public Swaption.SwaptionBuilder setEarlyTerminationProvision(EarlyTerminationProvision _earlyTerminationProvision) {
			this.earlyTerminationProvision = _earlyTerminationProvision == null ? null : _earlyTerminationProvision.toBuilder();
			return this;
		}
		
		@RosettaAttribute("swaptionAdjustedDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("swaptionAdjustedDates")
		@Override
		public Swaption.SwaptionBuilder setSwaptionAdjustedDates(SwaptionAdjustedDates _swaptionAdjustedDates) {
			this.swaptionAdjustedDates = _swaptionAdjustedDates == null ? null : _swaptionAdjustedDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("swap")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("swap")
		@Override
		public Swaption.SwaptionBuilder setSwap(Swap _swap) {
			this.swap = _swap == null ? null : _swap.toBuilder();
			return this;
		}
		
		@Override
		public Swaption build() {
			return new Swaption.SwaptionImpl(this);
		}
		
		@Override
		public Swaption.SwaptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Swaption.SwaptionBuilder prune() {
			super.prune();
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			premium = premium.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (calculationAgent!=null && !calculationAgent.prune().hasData()) calculationAgent = null;
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (physicalSettlement!=null && !physicalSettlement.prune().hasData()) physicalSettlement = null;
			if (earlyTerminationProvision!=null && !earlyTerminationProvision.prune().hasData()) earlyTerminationProvision = null;
			if (swaptionAdjustedDates!=null && !swaptionAdjustedDates.prune().hasData()) swaptionAdjustedDates = null;
			if (swap!=null && !swap.prune().hasData()) swap = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOptionType()!=null) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getCalculationAgent()!=null && getCalculationAgent().hasData()) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getPhysicalSettlement()!=null && getPhysicalSettlement().hasData()) return true;
			if (getSwaptionStraddle()!=null) return true;
			if (getEarlyTerminationProvision()!=null && getEarlyTerminationProvision().hasData()) return true;
			if (getSwaptionAdjustedDates()!=null && getSwaptionAdjustedDates().hasData()) return true;
			if (getSwap()!=null && getSwap().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Swaption.SwaptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Swaption.SwaptionBuilder o = (Swaption.SwaptionBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getCalculationAgent(), o.getCalculationAgent(), this::setCalculationAgent);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getPhysicalSettlement(), o.getPhysicalSettlement(), this::setPhysicalSettlement);
			merger.mergeRosetta(getEarlyTerminationProvision(), o.getEarlyTerminationProvision(), this::setEarlyTerminationProvision);
			merger.mergeRosetta(getSwaptionAdjustedDates(), o.getSwaptionAdjustedDates(), this::setSwaptionAdjustedDates);
			merger.mergeRosetta(getSwap(), o.getSwap(), this::setSwap);
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getSwaptionStraddle(), o.getSwaptionStraddle(), this::setSwaptionStraddle);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Swaption _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			if (!Objects.equals(swaptionStraddle, _that.getSwaptionStraddle())) return false;
			if (!Objects.equals(earlyTerminationProvision, _that.getEarlyTerminationProvision())) return false;
			if (!Objects.equals(swaptionAdjustedDates, _that.getSwaptionAdjustedDates())) return false;
			if (!Objects.equals(swap, _that.getSwap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			_result = 31 * _result + (swaptionStraddle != null ? swaptionStraddle.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationProvision != null ? earlyTerminationProvision.hashCode() : 0);
			_result = 31 * _result + (swaptionAdjustedDates != null ? swaptionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (swap != null ? swap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwaptionBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"premium=" + this.premium + ", " +
				"optionType=" + this.optionType + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"swaptionStraddle=" + this.swaptionStraddle + ", " +
				"earlyTerminationProvision=" + this.earlyTerminationProvision + ", " +
				"swaptionAdjustedDates=" + this.swaptionAdjustedDates + ", " +
				"swap=" + this.swap +
			'}' + " " + super.toString();
		}
	}
}

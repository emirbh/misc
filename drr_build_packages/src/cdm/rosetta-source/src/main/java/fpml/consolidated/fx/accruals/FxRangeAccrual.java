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
import fpml.consolidated.fx.accruals.meta.FxRangeAccrualMeta;
import fpml.consolidated.fx.targets.FxExpirySchedule;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Product;
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
 * Provision An FX Range Accrual product. A strip of Digital Options product The product defines a list of fixing (or observation) dates. There are m total fixings. On the relevant Settlement Date, the Option Seller shall pay to the Option Buyer an amount, in the Settlement Currency, calculated according to the following formula: Accrual Currency and Notional Amount x (the total number of Accrual Days / Total Number of Calendar Days in the Accrual Period). Payout can be cash.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An FX Range Accrual product. A strip of Digital Options product The product defines a list of fixing (or observation) dates. There are m total fixings. On the relevant Settlement Date, the Option Seller shall pay to the Option Buyer an amount, in the Settlement Currency, calculated according to the following formula: Accrual Currency and Notional Amount x (the total number of Accrual Days / Total Number of Calendar Days in the Accrual Period). Payout can be cash.
 *
 */
@RosettaDataType(value="FxRangeAccrual", builder=FxRangeAccrual.FxRangeAccrualBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxRangeAccrual", model="fpml", builder=FxRangeAccrual.FxRangeAccrualBuilderImpl.class, version="2.1.1")
public interface FxRangeAccrual extends Product {

	FxRangeAccrualMeta metaData = new FxRangeAccrualMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party responsible for making the payments defined by this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party responsible for making the payments defined by this structure.
	 *
	 */
	PartyReference getPayerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account responsible for making the payments defined by this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account responsible for making the payments defined by this structure.
	 *
	 */
	AccountReference getPayerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that receives the payments corresponding to this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that receives the payments corresponding to this structure.
	 *
	 */
	PartyReference getReceiverPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that receives the payments corresponding to this structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that receives the payments corresponding to this structure.
	 *
	 */
	AccountReference getReceiverAccountReference();
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
	FxRangeAccrual build();
	
	FxRangeAccrual.FxRangeAccrualBuilder toBuilder();
	
	static FxRangeAccrual.FxRangeAccrualBuilder builder() {
		return new FxRangeAccrual.FxRangeAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxRangeAccrual> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxRangeAccrual> getType() {
		return FxRangeAccrual.class;
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
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("accrual"), processor, FxAccrual.class, getAccrual());
		processRosetta(path.newSubPath("expiryDate"), processor, FxExpiryDate.class, getExpiryDate());
		processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.class, getExpirySchedule());
		processRosetta(path.newSubPath("settlementDate"), processor, FxAdjustedDateAndDateAdjustments.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.class, getSettlementSchedule());
		processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.class, getBarrier());
		processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.class, getPremium());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxRangeAccrualBuilder extends FxRangeAccrual, Product.ProductBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getPayerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getReceiverPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getReceiverAccountReference();
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
		FxAccrualBarrier.FxAccrualBarrierBuilder getOrCreateBarrier(int index);
		@Override
		List<? extends FxAccrualBarrier.FxAccrualBarrierBuilder> getBarrier();
		FxOptionPremium.FxOptionPremiumBuilder getOrCreatePremium(int index);
		@Override
		List<? extends FxOptionPremium.FxOptionPremiumBuilder> getPremium();
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder setId(String id);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addProductType(ProductType productType);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addProductType(ProductType productType, int idx);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addProductType(List<? extends ProductType> productType);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder setProductType(List<? extends ProductType> productType);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addProductId(ProductId productId);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addProductId(ProductId productId, int idx);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addProductId(List<? extends ProductId> productId);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder setProductId(List<? extends ProductId> productId);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addAssetClass(AssetClass assetClass);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxRangeAccrual.FxRangeAccrualBuilder setAssetClass(List<? extends AssetClass> assetClass);
		FxRangeAccrual.FxRangeAccrualBuilder setPayerPartyReference(PartyReference payerPartyReference);
		FxRangeAccrual.FxRangeAccrualBuilder setPayerAccountReference(AccountReference payerAccountReference);
		FxRangeAccrual.FxRangeAccrualBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		FxRangeAccrual.FxRangeAccrualBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		FxRangeAccrual.FxRangeAccrualBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxRangeAccrual.FxRangeAccrualBuilder setAccrual(FxAccrual accrual);
		FxRangeAccrual.FxRangeAccrualBuilder setExpiryDate(FxExpiryDate expiryDate);
		FxRangeAccrual.FxRangeAccrualBuilder setExpirySchedule(FxExpirySchedule expirySchedule);
		FxRangeAccrual.FxRangeAccrualBuilder setSettlementDate(FxAdjustedDateAndDateAdjustments settlementDate);
		FxRangeAccrual.FxRangeAccrualBuilder setSettlementSchedule(FxSettlementSchedule settlementSchedule);
		FxRangeAccrual.FxRangeAccrualBuilder addBarrier(FxAccrualBarrier barrier);
		FxRangeAccrual.FxRangeAccrualBuilder addBarrier(FxAccrualBarrier barrier, int idx);
		FxRangeAccrual.FxRangeAccrualBuilder addBarrier(List<? extends FxAccrualBarrier> barrier);
		FxRangeAccrual.FxRangeAccrualBuilder setBarrier(List<? extends FxAccrualBarrier> barrier);
		FxRangeAccrual.FxRangeAccrualBuilder addPremium(FxOptionPremium premium);
		FxRangeAccrual.FxRangeAccrualBuilder addPremium(FxOptionPremium premium, int idx);
		FxRangeAccrual.FxRangeAccrualBuilder addPremium(List<? extends FxOptionPremium> premium);
		FxRangeAccrual.FxRangeAccrualBuilder setPremium(List<? extends FxOptionPremium> premium);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("accrual"), processor, FxAccrual.FxAccrualBuilder.class, getAccrual());
			processRosetta(path.newSubPath("expiryDate"), processor, FxExpiryDate.FxExpiryDateBuilder.class, getExpiryDate());
			processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.FxExpiryScheduleBuilder.class, getExpirySchedule());
			processRosetta(path.newSubPath("settlementDate"), processor, FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.FxSettlementScheduleBuilder.class, getSettlementSchedule());
			processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.FxAccrualBarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("premium"), processor, FxOptionPremium.FxOptionPremiumBuilder.class, getPremium());
		}
		

		FxRangeAccrual.FxRangeAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of FxRangeAccrual  ***********************/
	class FxRangeAccrualImpl extends Product.ProductImpl implements FxRangeAccrual {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final NonNegativeAmountSchedule notionalAmount;
		private final FxAccrual accrual;
		private final FxExpiryDate expiryDate;
		private final FxExpirySchedule expirySchedule;
		private final FxAdjustedDateAndDateAdjustments settlementDate;
		private final FxSettlementSchedule settlementSchedule;
		private final List<? extends FxAccrualBarrier> barrier;
		private final List<? extends FxOptionPremium> premium;
		
		protected FxRangeAccrualImpl(FxRangeAccrual.FxRangeAccrualBuilder builder) {
			super(builder);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.accrual = ofNullable(builder.getAccrual()).map(f->f.build()).orElse(null);
			this.expiryDate = ofNullable(builder.getExpiryDate()).map(f->f.build()).orElse(null);
			this.expirySchedule = ofNullable(builder.getExpirySchedule()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.settlementSchedule = ofNullable(builder.getSettlementSchedule()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		public PartyReference getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerAccountReference")
		public AccountReference getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverPartyReference")
		public PartyReference getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverAccountReference")
		public AccountReference getReceiverAccountReference() {
			return receiverAccountReference;
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
		public FxRangeAccrual build() {
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder toBuilder() {
			FxRangeAccrual.FxRangeAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxRangeAccrual.FxRangeAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getAccrual()).ifPresent(builder::setAccrual);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getExpirySchedule()).ifPresent(builder::setExpirySchedule);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getSettlementSchedule()).ifPresent(builder::setSettlementSchedule);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxRangeAccrual _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expirySchedule != null ? expirySchedule.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementSchedule != null ? settlementSchedule.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRangeAccrual {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"expirySchedule=" + this.expirySchedule + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementSchedule=" + this.settlementSchedule + ", " +
				"barrier=" + this.barrier + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxRangeAccrual  ***********************/
	class FxRangeAccrualBuilderImpl extends Product.ProductBuilderImpl implements FxRangeAccrual.FxRangeAccrualBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected FxAccrual.FxAccrualBuilder accrual;
		protected FxExpiryDate.FxExpiryDateBuilder expiryDate;
		protected FxExpirySchedule.FxExpiryScheduleBuilder expirySchedule;
		protected FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder settlementDate;
		protected FxSettlementSchedule.FxSettlementScheduleBuilder settlementSchedule;
		protected List<FxAccrualBarrier.FxAccrualBarrierBuilder> barrier = new ArrayList<>();
		protected List<FxOptionPremium.FxOptionPremiumBuilder> premium = new ArrayList<>();
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		public PartyReference.PartyReferenceBuilder getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (payerPartyReference!=null) {
				result = payerPartyReference;
			}
			else {
				result = payerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerAccountReference")
		public AccountReference.AccountReferenceBuilder getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (payerAccountReference!=null) {
				result = payerAccountReference;
			}
			else {
				result = payerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverPartyReference")
		public PartyReference.PartyReferenceBuilder getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (receiverPartyReference!=null) {
				result = receiverPartyReference;
			}
			else {
				result = receiverPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverAccountReference")
		public AccountReference.AccountReferenceBuilder getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (receiverAccountReference!=null) {
				result = receiverAccountReference;
			}
			else {
				result = receiverAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
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
		public FxRangeAccrual.FxRangeAccrualBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxRangeAccrual.FxRangeAccrualBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxRangeAccrual.FxRangeAccrualBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public FxRangeAccrual.FxRangeAccrualBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public FxRangeAccrual.FxRangeAccrualBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addProductId(List<? extends ProductId> productIds) {
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
		public FxRangeAccrual.FxRangeAccrualBuilder setProductId(List<? extends ProductId> productIds) {
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
		public FxRangeAccrual.FxRangeAccrualBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxRangeAccrual.FxRangeAccrualBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxRangeAccrual.FxRangeAccrualBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxRangeAccrual.FxRangeAccrualBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notionalAmount")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder setNotionalAmount(NonNegativeAmountSchedule _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrual")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrual")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder setAccrual(FxAccrual _accrual) {
			this.accrual = _accrual == null ? null : _accrual.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryDate")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder setExpiryDate(FxExpiryDate _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirySchedule")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder setExpirySchedule(FxExpirySchedule _expirySchedule) {
			this.expirySchedule = _expirySchedule == null ? null : _expirySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder setSettlementDate(FxAdjustedDateAndDateAdjustments _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementSchedule")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder setSettlementSchedule(FxSettlementSchedule _settlementSchedule) {
			this.settlementSchedule = _settlementSchedule == null ? null : _settlementSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("barrier")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addBarrier(FxAccrualBarrier _barrier) {
			if (_barrier != null) {
				this.barrier.add(_barrier.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addBarrier(FxAccrualBarrier _barrier, int idx) {
			getIndex(this.barrier, idx, () -> _barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addBarrier(List<? extends FxAccrualBarrier> barriers) {
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
		public FxRangeAccrual.FxRangeAccrualBuilder setBarrier(List<? extends FxAccrualBarrier> barriers) {
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
		public FxRangeAccrual.FxRangeAccrualBuilder addPremium(FxOptionPremium _premium) {
			if (_premium != null) {
				this.premium.add(_premium.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addPremium(FxOptionPremium _premium, int idx) {
			getIndex(this.premium, idx, () -> _premium.toBuilder());
			return this;
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder addPremium(List<? extends FxOptionPremium> premiums) {
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
		public FxRangeAccrual.FxRangeAccrualBuilder setPremium(List<? extends FxOptionPremium> premiums) {
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
		public FxRangeAccrual build() {
			return new FxRangeAccrual.FxRangeAccrualImpl(this);
		}
		
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder prune() {
			super.prune();
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (accrual!=null && !accrual.prune().hasData()) accrual = null;
			if (expiryDate!=null && !expiryDate.prune().hasData()) expiryDate = null;
			if (expirySchedule!=null && !expirySchedule.prune().hasData()) expirySchedule = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (settlementSchedule!=null && !settlementSchedule.prune().hasData()) settlementSchedule = null;
			barrier = barrier.stream().filter(b->b!=null).<FxAccrualBarrier.FxAccrualBarrierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			premium = premium.stream().filter(b->b!=null).<FxOptionPremium.FxOptionPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getAccrual()!=null && getAccrual().hasData()) return true;
			if (getExpiryDate()!=null && getExpiryDate().hasData()) return true;
			if (getExpirySchedule()!=null && getExpirySchedule().hasData()) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getSettlementSchedule()!=null && getSettlementSchedule().hasData()) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRangeAccrual.FxRangeAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxRangeAccrual.FxRangeAccrualBuilder o = (FxRangeAccrual.FxRangeAccrualBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getAccrual(), o.getAccrual(), this::setAccrual);
			merger.mergeRosetta(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeRosetta(getExpirySchedule(), o.getExpirySchedule(), this::setExpirySchedule);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getSettlementSchedule(), o.getSettlementSchedule(), this::setSettlementSchedule);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::getOrCreateBarrier);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxRangeAccrual _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (accrual != null ? accrual.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expirySchedule != null ? expirySchedule.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementSchedule != null ? settlementSchedule.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxRangeAccrualBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"expirySchedule=" + this.expirySchedule + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementSchedule=" + this.settlementSchedule + ", " +
				"barrier=" + this.barrier + ", " +
				"premium=" + this.premium +
			'}' + " " + super.toString();
		}
	}
}

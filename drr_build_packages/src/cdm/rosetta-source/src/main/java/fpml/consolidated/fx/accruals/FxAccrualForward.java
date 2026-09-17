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
import fpml.consolidated.fx.accruals.meta.FxAccrualForwardMeta;
import fpml.consolidated.fx.targets.FxExpirySchedule;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.SimplePayment;
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
 * Provision The product defines a schedule of expiry and delivery dates which specify settlement periods. The product further defines a schedule of fixing (or observation) dates and defines regions of spot where the product settlement amounts will accrue. There are n total fixings. One accumulates a fixed proportion of Notional (1/n) for every observation date that spot fixes within the pre-defined limits of the accrual regions. If spot breaks the limits, the Notional stops accumulating during the fixings outside the limits, but continues accruing once spot comes back to the accruing region. At expiry, one buys the accrued Notional at the pre-agreed hedge rate. Payout can be cash or physical. The variation of this product include: Accrual Forward (European and American), Double Accrual Forward (DAF), Boosted Accrual Forward, Fading Forward, Leveraged Accrual Forward, Accrual Forward with Collars, etc.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The product defines a schedule of expiry and delivery dates which specify settlement periods. The product further defines a schedule of fixing (or observation) dates and defines regions of spot where the product settlement amounts will accrue. There are n total fixings. One accumulates a fixed proportion of Notional (1/n) for every observation date that spot fixes within the pre-defined limits of the accrual regions. If spot breaks the limits, the Notional stops accumulating during the fixings outside the limits, but continues accruing once spot comes back to the accruing region. At expiry, one buys the accrued Notional at the pre-agreed hedge rate. Payout can be cash or physical. The variation of this product include: Accrual Forward (European and American), Double Accrual Forward (DAF), Boosted Accrual Forward, Fading Forward, Leveraged Accrual Forward, Accrual Forward with Collars, etc.
 *
 */
@RosettaDataType(value="FxAccrualForward", builder=FxAccrualForward.FxAccrualForwardBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualForward", model="fpml", builder=FxAccrualForward.FxAccrualForwardBuilderImpl.class, version="2.1.1")
public interface FxAccrualForward extends Product {

	FxAccrualForwardMeta metaData = new FxAccrualForwardMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Notional amount Schedule. The notional value of the product per settlement period. The notional amount may differ for each settlement period. This number divided by the total number of fixings in the settlement period is the amount that is accrued at each fixing if the accrual factor is one.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Notional amount Schedule. The notional value of the product per settlement period. The notional amount may differ for each settlement period. This number divided by the total number of fixings in the settlement period is the amount that is accrued at each fixing if the accrual factor is one.
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
	 * Provision An optional element used for FX forwards and certain types of FX OTC options. For deals consummated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the option needs to move "up" or "down" to be triggered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional element used for FX forwards and certain types of FX OTC options. For deals consummated in the FX Forwards Market, this represents the current market rate for a particular currency pair. For barrier and digital/binary options, it can be useful to include the spot rate at the time the option was executed to make it easier to know whether the option needs to move "up" or "down" to be triggered.
	 *
	 */
	BigDecimal getSpotRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A region in which linear payoff applies i.e. the payoff bears a linear relationship to the fixing value (increases/decreases linearly with the fixing).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A region in which linear payoff applies i.e. the payoff bears a linear relationship to the fixing value (increases/decreases linearly with the fixing).
	 *
	 */
	List<? extends FxAccrualLinearPayoffRegion> getLinearPayoffRegion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Average Rate Forward: means the average of the Reference Spot Rate on each Business Day from and including the Calculation Start Date up to and including the Calculation End Date rounded to the precision decimal places.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Average Rate Forward: means the average of the Reference Spot Rate on each Business Day from and including the Calculation Start Date up to and including the Calculation End Date rounded to the precision decimal places.
	 *
	 */
	FxAverageRate getAverageRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines a FX Accrual barrier conditions. Element barrier/scope specifies whether the barrier applies to the expiry period in which it is observed, or globally for whole product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines a FX Accrual barrier conditions. Element barrier/scope specifies whether the barrier applies to the expiry period in which it is observed, or globally for whole product.
	 *
	 */
	List<? extends FxAccrualBarrier> getBarrier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision It supports the representation of premiums, fees, etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision It supports the representation of premiums, fees, etc.
	 *
	 */
	List<? extends SimplePayment> getAdditionalPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Cash settlement currency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Cash settlement currency.
	 *
	 */
	FxCashSettlementSimple getCashSettlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision It supports the representation of a matrix/tabular approach of the product by defining a set of settlement periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision It supports the representation of a matrix/tabular approach of the product by defining a set of settlement periods.
	 *
	 */
	FxAccrualSettlementPeriodSchedule getSettlementPeriodSchedule();

	/*********************** Build Methods  ***********************/
	FxAccrualForward build();
	
	FxAccrualForward.FxAccrualForwardBuilder toBuilder();
	
	static FxAccrualForward.FxAccrualForwardBuilder builder() {
		return new FxAccrualForward.FxAccrualForwardBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualForward> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualForward> getType() {
		return FxAccrualForward.class;
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
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("accrual"), processor, FxAccrual.class, getAccrual());
		processRosetta(path.newSubPath("expiryDate"), processor, FxExpiryDate.class, getExpiryDate());
		processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.class, getExpirySchedule());
		processRosetta(path.newSubPath("settlementDate"), processor, FxAdjustedDateAndDateAdjustments.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.class, getSettlementSchedule());
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("linearPayoffRegion"), processor, FxAccrualLinearPayoffRegion.class, getLinearPayoffRegion());
		processRosetta(path.newSubPath("averageRate"), processor, FxAverageRate.class, getAverageRate());
		processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.class, getBarrier());
		processRosetta(path.newSubPath("additionalPayment"), processor, SimplePayment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.class, getCashSettlement());
		processRosetta(path.newSubPath("settlementPeriodSchedule"), processor, FxAccrualSettlementPeriodSchedule.class, getSettlementPeriodSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualForwardBuilder extends FxAccrualForward, Product.ProductBuilder {
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
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder getOrCreateLinearPayoffRegion(int index);
		@Override
		List<? extends FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder> getLinearPayoffRegion();
		FxAverageRate.FxAverageRateBuilder getOrCreateAverageRate();
		@Override
		FxAverageRate.FxAverageRateBuilder getAverageRate();
		FxAccrualBarrier.FxAccrualBarrierBuilder getOrCreateBarrier(int index);
		@Override
		List<? extends FxAccrualBarrier.FxAccrualBarrierBuilder> getBarrier();
		SimplePayment.SimplePaymentBuilder getOrCreateAdditionalPayment(int index);
		@Override
		List<? extends SimplePayment.SimplePaymentBuilder> getAdditionalPayment();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement();
		@Override
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement();
		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder getOrCreateSettlementPeriodSchedule();
		@Override
		FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder getSettlementPeriodSchedule();
		@Override
		FxAccrualForward.FxAccrualForwardBuilder setId(String id);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addProductType(ProductType productType);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addProductType(ProductType productType, int idx);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addProductType(List<? extends ProductType> productType);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder setProductType(List<? extends ProductType> productType);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addProductId(ProductId productId);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addProductId(ProductId productId, int idx);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addProductId(List<? extends ProductId> productId);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder setProductId(List<? extends ProductId> productId);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addAssetClass(AssetClass assetClass);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxAccrualForward.FxAccrualForwardBuilder setAssetClass(List<? extends AssetClass> assetClass);
		FxAccrualForward.FxAccrualForwardBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxAccrualForward.FxAccrualForwardBuilder setAccrual(FxAccrual accrual);
		FxAccrualForward.FxAccrualForwardBuilder setExpiryDate(FxExpiryDate expiryDate);
		FxAccrualForward.FxAccrualForwardBuilder setExpirySchedule(FxExpirySchedule expirySchedule);
		FxAccrualForward.FxAccrualForwardBuilder setSettlementDate(FxAdjustedDateAndDateAdjustments settlementDate);
		FxAccrualForward.FxAccrualForwardBuilder setSettlementSchedule(FxSettlementSchedule settlementSchedule);
		FxAccrualForward.FxAccrualForwardBuilder setSpotRate(BigDecimal spotRate);
		FxAccrualForward.FxAccrualForwardBuilder addLinearPayoffRegion(FxAccrualLinearPayoffRegion linearPayoffRegion);
		FxAccrualForward.FxAccrualForwardBuilder addLinearPayoffRegion(FxAccrualLinearPayoffRegion linearPayoffRegion, int idx);
		FxAccrualForward.FxAccrualForwardBuilder addLinearPayoffRegion(List<? extends FxAccrualLinearPayoffRegion> linearPayoffRegion);
		FxAccrualForward.FxAccrualForwardBuilder setLinearPayoffRegion(List<? extends FxAccrualLinearPayoffRegion> linearPayoffRegion);
		FxAccrualForward.FxAccrualForwardBuilder setAverageRate(FxAverageRate averageRate);
		FxAccrualForward.FxAccrualForwardBuilder addBarrier(FxAccrualBarrier barrier);
		FxAccrualForward.FxAccrualForwardBuilder addBarrier(FxAccrualBarrier barrier, int idx);
		FxAccrualForward.FxAccrualForwardBuilder addBarrier(List<? extends FxAccrualBarrier> barrier);
		FxAccrualForward.FxAccrualForwardBuilder setBarrier(List<? extends FxAccrualBarrier> barrier);
		FxAccrualForward.FxAccrualForwardBuilder addAdditionalPayment(SimplePayment additionalPayment);
		FxAccrualForward.FxAccrualForwardBuilder addAdditionalPayment(SimplePayment additionalPayment, int idx);
		FxAccrualForward.FxAccrualForwardBuilder addAdditionalPayment(List<? extends SimplePayment> additionalPayment);
		FxAccrualForward.FxAccrualForwardBuilder setAdditionalPayment(List<? extends SimplePayment> additionalPayment);
		FxAccrualForward.FxAccrualForwardBuilder setCashSettlement(FxCashSettlementSimple cashSettlement);
		FxAccrualForward.FxAccrualForwardBuilder setSettlementPeriodSchedule(FxAccrualSettlementPeriodSchedule settlementPeriodSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("accrual"), processor, FxAccrual.FxAccrualBuilder.class, getAccrual());
			processRosetta(path.newSubPath("expiryDate"), processor, FxExpiryDate.FxExpiryDateBuilder.class, getExpiryDate());
			processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.FxExpiryScheduleBuilder.class, getExpirySchedule());
			processRosetta(path.newSubPath("settlementDate"), processor, FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.FxSettlementScheduleBuilder.class, getSettlementSchedule());
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("linearPayoffRegion"), processor, FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder.class, getLinearPayoffRegion());
			processRosetta(path.newSubPath("averageRate"), processor, FxAverageRate.FxAverageRateBuilder.class, getAverageRate());
			processRosetta(path.newSubPath("barrier"), processor, FxAccrualBarrier.FxAccrualBarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("additionalPayment"), processor, SimplePayment.SimplePaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.FxCashSettlementSimpleBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("settlementPeriodSchedule"), processor, FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder.class, getSettlementPeriodSchedule());
		}
		

		FxAccrualForward.FxAccrualForwardBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualForward  ***********************/
	class FxAccrualForwardImpl extends Product.ProductImpl implements FxAccrualForward {
		private final NonNegativeAmountSchedule notionalAmount;
		private final FxAccrual accrual;
		private final FxExpiryDate expiryDate;
		private final FxExpirySchedule expirySchedule;
		private final FxAdjustedDateAndDateAdjustments settlementDate;
		private final FxSettlementSchedule settlementSchedule;
		private final BigDecimal spotRate;
		private final List<? extends FxAccrualLinearPayoffRegion> linearPayoffRegion;
		private final FxAverageRate averageRate;
		private final List<? extends FxAccrualBarrier> barrier;
		private final List<? extends SimplePayment> additionalPayment;
		private final FxCashSettlementSimple cashSettlement;
		private final FxAccrualSettlementPeriodSchedule settlementPeriodSchedule;
		
		protected FxAccrualForwardImpl(FxAccrualForward.FxAccrualForwardBuilder builder) {
			super(builder);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.accrual = ofNullable(builder.getAccrual()).map(f->f.build()).orElse(null);
			this.expiryDate = ofNullable(builder.getExpiryDate()).map(f->f.build()).orElse(null);
			this.expirySchedule = ofNullable(builder.getExpirySchedule()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.settlementSchedule = ofNullable(builder.getSettlementSchedule()).map(f->f.build()).orElse(null);
			this.spotRate = builder.getSpotRate();
			this.linearPayoffRegion = ofNullable(builder.getLinearPayoffRegion()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.averageRate = ofNullable(builder.getAverageRate()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.settlementPeriodSchedule = ofNullable(builder.getSettlementPeriodSchedule()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("linearPayoffRegion")
		public List<? extends FxAccrualLinearPayoffRegion> getLinearPayoffRegion() {
			return linearPayoffRegion;
		}
		
		@Override
		@RosettaAttribute("averageRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageRate")
		public FxAverageRate getAverageRate() {
			return averageRate;
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
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends SimplePayment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public FxCashSettlementSimple getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPeriodSchedule")
		public FxAccrualSettlementPeriodSchedule getSettlementPeriodSchedule() {
			return settlementPeriodSchedule;
		}
		
		@Override
		public FxAccrualForward build() {
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder toBuilder() {
			FxAccrualForward.FxAccrualForwardBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualForward.FxAccrualForwardBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getAccrual()).ifPresent(builder::setAccrual);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getExpirySchedule()).ifPresent(builder::setExpirySchedule);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getSettlementSchedule()).ifPresent(builder::setSettlementSchedule);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getLinearPayoffRegion()).ifPresent(builder::setLinearPayoffRegion);
			ofNullable(getAverageRate()).ifPresent(builder::setAverageRate);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getSettlementPeriodSchedule()).ifPresent(builder::setSettlementPeriodSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualForward _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!ListEquals.listEquals(linearPayoffRegion, _that.getLinearPayoffRegion())) return false;
			if (!Objects.equals(averageRate, _that.getAverageRate())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(settlementPeriodSchedule, _that.getSettlementPeriodSchedule())) return false;
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
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (linearPayoffRegion != null ? linearPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (averageRate != null ? averageRate.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodSchedule != null ? settlementPeriodSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualForward {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"expirySchedule=" + this.expirySchedule + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementSchedule=" + this.settlementSchedule + ", " +
				"spotRate=" + this.spotRate + ", " +
				"linearPayoffRegion=" + this.linearPayoffRegion + ", " +
				"averageRate=" + this.averageRate + ", " +
				"barrier=" + this.barrier + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"settlementPeriodSchedule=" + this.settlementPeriodSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualForward  ***********************/
	class FxAccrualForwardBuilderImpl extends Product.ProductBuilderImpl implements FxAccrualForward.FxAccrualForwardBuilder {
	
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected FxAccrual.FxAccrualBuilder accrual;
		protected FxExpiryDate.FxExpiryDateBuilder expiryDate;
		protected FxExpirySchedule.FxExpiryScheduleBuilder expirySchedule;
		protected FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder settlementDate;
		protected FxSettlementSchedule.FxSettlementScheduleBuilder settlementSchedule;
		protected BigDecimal spotRate;
		protected List<FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder> linearPayoffRegion = new ArrayList<>();
		protected FxAverageRate.FxAverageRateBuilder averageRate;
		protected List<FxAccrualBarrier.FxAccrualBarrierBuilder> barrier = new ArrayList<>();
		protected List<SimplePayment.SimplePaymentBuilder> additionalPayment = new ArrayList<>();
		protected FxCashSettlementSimple.FxCashSettlementSimpleBuilder cashSettlement;
		protected FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder settlementPeriodSchedule;
		
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
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("linearPayoffRegion")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("linearPayoffRegion")
		public List<? extends FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder> getLinearPayoffRegion() {
			return linearPayoffRegion;
		}
		
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder getOrCreateLinearPayoffRegion(int index) {
			if (linearPayoffRegion==null) {
				this.linearPayoffRegion = new ArrayList<>();
			}
			return getIndex(linearPayoffRegion, index, () -> {
						FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder newLinearPayoffRegion = FxAccrualLinearPayoffRegion.builder();
						return newLinearPayoffRegion;
					});
		}
		
		@Override
		@RosettaAttribute("averageRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageRate")
		public FxAverageRate.FxAverageRateBuilder getAverageRate() {
			return averageRate;
		}
		
		@Override
		public FxAverageRate.FxAverageRateBuilder getOrCreateAverageRate() {
			FxAverageRate.FxAverageRateBuilder result;
			if (averageRate!=null) {
				result = averageRate;
			}
			else {
				result = averageRate = FxAverageRate.builder();
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
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends SimplePayment.SimplePaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getOrCreateAdditionalPayment(int index) {
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			return getIndex(additionalPayment, index, () -> {
						SimplePayment.SimplePaymentBuilder newAdditionalPayment = SimplePayment.builder();
						return newAdditionalPayment;
					});
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement() {
			FxCashSettlementSimple.FxCashSettlementSimpleBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = FxCashSettlementSimple.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPeriodSchedule")
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder getSettlementPeriodSchedule() {
			return settlementPeriodSchedule;
		}
		
		@Override
		public FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder getOrCreateSettlementPeriodSchedule() {
			FxAccrualSettlementPeriodSchedule.FxAccrualSettlementPeriodScheduleBuilder result;
			if (settlementPeriodSchedule!=null) {
				result = settlementPeriodSchedule;
			}
			else {
				result = settlementPeriodSchedule = FxAccrualSettlementPeriodSchedule.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxAccrualForward.FxAccrualForwardBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxAccrualForward.FxAccrualForwardBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public FxAccrualForward.FxAccrualForwardBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public FxAccrualForward.FxAccrualForwardBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addProductId(List<? extends ProductId> productIds) {
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
		public FxAccrualForward.FxAccrualForwardBuilder setProductId(List<? extends ProductId> productIds) {
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
		public FxAccrualForward.FxAccrualForwardBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxAccrualForward.FxAccrualForwardBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxAccrualForward.FxAccrualForwardBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxAccrualForward.FxAccrualForwardBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notionalAmount")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setNotionalAmount(NonNegativeAmountSchedule _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrual")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrual")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setAccrual(FxAccrual _accrual) {
			this.accrual = _accrual == null ? null : _accrual.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryDate")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setExpiryDate(FxExpiryDate _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirySchedule")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setExpirySchedule(FxExpirySchedule _expirySchedule) {
			this.expirySchedule = _expirySchedule == null ? null : _expirySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setSettlementDate(FxAdjustedDateAndDateAdjustments _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementSchedule")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setSettlementSchedule(FxSettlementSchedule _settlementSchedule) {
			this.settlementSchedule = _settlementSchedule == null ? null : _settlementSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotRate")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setSpotRate(BigDecimal _spotRate) {
			this.spotRate = _spotRate == null ? null : _spotRate;
			return this;
		}
		
		@RosettaAttribute("linearPayoffRegion")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("linearPayoffRegion")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addLinearPayoffRegion(FxAccrualLinearPayoffRegion _linearPayoffRegion) {
			if (_linearPayoffRegion != null) {
				this.linearPayoffRegion.add(_linearPayoffRegion.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addLinearPayoffRegion(FxAccrualLinearPayoffRegion _linearPayoffRegion, int idx) {
			getIndex(this.linearPayoffRegion, idx, () -> _linearPayoffRegion.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addLinearPayoffRegion(List<? extends FxAccrualLinearPayoffRegion> linearPayoffRegions) {
			if (linearPayoffRegions != null) {
				for (final FxAccrualLinearPayoffRegion toAdd : linearPayoffRegions) {
					this.linearPayoffRegion.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("linearPayoffRegion")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("linearPayoffRegion")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setLinearPayoffRegion(List<? extends FxAccrualLinearPayoffRegion> linearPayoffRegions) {
			if (linearPayoffRegions == null) {
				this.linearPayoffRegion = new ArrayList<>();
			} else {
				this.linearPayoffRegion = linearPayoffRegions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("averageRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averageRate")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setAverageRate(FxAverageRate _averageRate) {
			this.averageRate = _averageRate == null ? null : _averageRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("barrier")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addBarrier(FxAccrualBarrier _barrier) {
			if (_barrier != null) {
				this.barrier.add(_barrier.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addBarrier(FxAccrualBarrier _barrier, int idx) {
			getIndex(this.barrier, idx, () -> _barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addBarrier(List<? extends FxAccrualBarrier> barriers) {
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
		public FxAccrualForward.FxAccrualForwardBuilder setBarrier(List<? extends FxAccrualBarrier> barriers) {
			if (barriers == null) {
				this.barrier = new ArrayList<>();
			} else {
				this.barrier = barriers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addAdditionalPayment(SimplePayment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addAdditionalPayment(SimplePayment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder addAdditionalPayment(List<? extends SimplePayment> additionalPayments) {
			if (additionalPayments != null) {
				for (final SimplePayment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setAdditionalPayment(List<? extends SimplePayment> additionalPayments) {
			if (additionalPayments == null) {
				this.additionalPayment = new ArrayList<>();
			} else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlement")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setCashSettlement(FxCashSettlementSimple _cashSettlement) {
			this.cashSettlement = _cashSettlement == null ? null : _cashSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPeriodSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementPeriodSchedule")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder setSettlementPeriodSchedule(FxAccrualSettlementPeriodSchedule _settlementPeriodSchedule) {
			this.settlementPeriodSchedule = _settlementPeriodSchedule == null ? null : _settlementPeriodSchedule.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualForward build() {
			return new FxAccrualForward.FxAccrualForwardImpl(this);
		}
		
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder prune() {
			super.prune();
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (accrual!=null && !accrual.prune().hasData()) accrual = null;
			if (expiryDate!=null && !expiryDate.prune().hasData()) expiryDate = null;
			if (expirySchedule!=null && !expirySchedule.prune().hasData()) expirySchedule = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (settlementSchedule!=null && !settlementSchedule.prune().hasData()) settlementSchedule = null;
			linearPayoffRegion = linearPayoffRegion.stream().filter(b->b!=null).<FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (averageRate!=null && !averageRate.prune().hasData()) averageRate = null;
			barrier = barrier.stream().filter(b->b!=null).<FxAccrualBarrier.FxAccrualBarrierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<SimplePayment.SimplePaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (settlementPeriodSchedule!=null && !settlementPeriodSchedule.prune().hasData()) settlementPeriodSchedule = null;
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
			if (getSpotRate()!=null) return true;
			if (getLinearPayoffRegion()!=null && getLinearPayoffRegion().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAverageRate()!=null && getAverageRate().hasData()) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getSettlementPeriodSchedule()!=null && getSettlementPeriodSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualForward.FxAccrualForwardBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxAccrualForward.FxAccrualForwardBuilder o = (FxAccrualForward.FxAccrualForwardBuilder) other;
			
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getAccrual(), o.getAccrual(), this::setAccrual);
			merger.mergeRosetta(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeRosetta(getExpirySchedule(), o.getExpirySchedule(), this::setExpirySchedule);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getSettlementSchedule(), o.getSettlementSchedule(), this::setSettlementSchedule);
			merger.mergeRosetta(getLinearPayoffRegion(), o.getLinearPayoffRegion(), this::getOrCreateLinearPayoffRegion);
			merger.mergeRosetta(getAverageRate(), o.getAverageRate(), this::setAverageRate);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::getOrCreateBarrier);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getSettlementPeriodSchedule(), o.getSettlementPeriodSchedule(), this::setSettlementPeriodSchedule);
			
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualForward _that = getType().cast(o);
		
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(accrual, _that.getAccrual())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!ListEquals.listEquals(linearPayoffRegion, _that.getLinearPayoffRegion())) return false;
			if (!Objects.equals(averageRate, _that.getAverageRate())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(settlementPeriodSchedule, _that.getSettlementPeriodSchedule())) return false;
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
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (linearPayoffRegion != null ? linearPayoffRegion.hashCode() : 0);
			_result = 31 * _result + (averageRate != null ? averageRate.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodSchedule != null ? settlementPeriodSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualForwardBuilder {" +
				"notionalAmount=" + this.notionalAmount + ", " +
				"accrual=" + this.accrual + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"expirySchedule=" + this.expirySchedule + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementSchedule=" + this.settlementSchedule + ", " +
				"spotRate=" + this.spotRate + ", " +
				"linearPayoffRegion=" + this.linearPayoffRegion + ", " +
				"averageRate=" + this.averageRate + ", " +
				"barrier=" + this.barrier + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"settlementPeriodSchedule=" + this.settlementPeriodSchedule +
			'}' + " " + super.toString();
		}
	}
}

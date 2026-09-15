package fpml.consolidated.variance.swaps;

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
import fpml.consolidated.eq.shared.EquityPremium;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.fpmlenum.MethodOfAdjustmentEnum;
import fpml.consolidated.fpmlenum.OptionTypeEnum;
import fpml.consolidated.option.shared.OptionBase;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import fpml.consolidated.variance.swaps.meta.VarianceOptionTransactionSupplementMeta;
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
 * Provision Specifies the structure of a variance option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Specifies the structure of a variance option.
 *
 */
@RosettaDataType(value="VarianceOptionTransactionSupplement", builder=VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VarianceOptionTransactionSupplement", model="fpml", builder=VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilderImpl.class, version="2.1.1")
public interface VarianceOptionTransactionSupplement extends OptionBase {

	VarianceOptionTransactionSupplementMeta metaData = new VarianceOptionTransactionSupplementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The variance option premium payable by the buyer to the seller.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The variance option premium payable by the buyer to the seller.
	 *
	 */
	EquityPremium getEquityPremium();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining how the equity option can be exercised, how it is valued and how it is settled.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining how the equity option can be exercised, how it is valued and how it is settled.
	 *
	 */
	EquityExerciseValuationSettlement getEquityExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For a share option transaction, a flag used to indicate whether the transaction is to be treated as an 'exchange look-alike'. This designation has significance for how share adjustments (arising from corporate actions) will be determined for the transaction. For an 'exchange look-alike' transaction the relevant share adjustments will follow that for a corresponding designated contract listed on the related exchange (referred to as Options Exchange Adjustment (ISDA defined term), otherwise the share adjustments will be determined by the calculation agent (referred to as Calculation Agent Adjustment (ISDA defined term)).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For a share option transaction, a flag used to indicate whether the transaction is to be treated as an 'exchange look-alike'. This designation has significance for how share adjustments (arising from corporate actions) will be determined for the transaction. For an 'exchange look-alike' transaction the relevant share adjustments will follow that for a corresponding designated contract listed on the related exchange (referred to as Options Exchange Adjustment (ISDA defined term), otherwise the share adjustments will be determined by the calculation agent (referred to as Calculation Agent Adjustment (ISDA defined term)).
	 *
	 */
	Boolean getExchangeLookAlike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines how adjustments will be made to the contract should one or more of the extraordinary events occur.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines how adjustments will be made to the contract should one or more of the extraordinary events occur.
	 *
	 */
	MethodOfAdjustmentEnum getMethodOfAdjustment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of shares per option comprised in the option transaction supplement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of shares per option comprised in the option transaction supplement.
	 *
	 */
	BigDecimal getOptionEntitlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the contract multiplier that can be associated with an index option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the contract multiplier that can be associated with an index option.
	 *
	 */
	BigDecimal getMultiplier();
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
	 * Provision The variance swap details.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The variance swap details.
	 *
	 */
	VarianceSwapTransactionSupplement getVarianceSwapTransactionSupplement();

	/*********************** Build Methods  ***********************/
	VarianceOptionTransactionSupplement build();
	
	VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder toBuilder();
	
	static VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder builder() {
		return new VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VarianceOptionTransactionSupplement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VarianceOptionTransactionSupplement> getType() {
		return VarianceOptionTransactionSupplement.class;
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
		processRosetta(path.newSubPath("equityPremium"), processor, EquityPremium.class, getEquityPremium());
		processRosetta(path.newSubPath("equityExercise"), processor, EquityExerciseValuationSettlement.class, getEquityExercise());
		processor.processBasic(path.newSubPath("exchangeLookAlike"), Boolean.class, getExchangeLookAlike(), this);
		processor.processBasic(path.newSubPath("methodOfAdjustment"), MethodOfAdjustmentEnum.class, getMethodOfAdjustment(), this);
		processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		processRosetta(path.newSubPath("clearingInstructions"), processor, SwaptionPhysicalSettlement.class, getClearingInstructions());
		processRosetta(path.newSubPath("varianceSwapTransactionSupplement"), processor, VarianceSwapTransactionSupplement.class, getVarianceSwapTransactionSupplement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VarianceOptionTransactionSupplementBuilder extends VarianceOptionTransactionSupplement, OptionBase.OptionBaseBuilder {
		EquityPremium.EquityPremiumBuilder getOrCreateEquityPremium();
		@Override
		EquityPremium.EquityPremiumBuilder getEquityPremium();
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getOrCreateEquityExercise();
		@Override
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getEquityExercise();
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreateClearingInstructions();
		@Override
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getClearingInstructions();
		VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder getOrCreateVarianceSwapTransactionSupplement();
		@Override
		VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder getVarianceSwapTransactionSupplement();
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setId(String id);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addProductType(ProductType productType);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addProductType(ProductType productType, int idx);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addProductType(List<? extends ProductType> productType);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setProductType(List<? extends ProductType> productType);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addProductId(ProductId productId);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addProductId(ProductId productId, int idx);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addProductId(List<? extends ProductId> productId);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setProductId(List<? extends ProductId> productId);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addAssetClass(AssetClass assetClass);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		@Override
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setOptionType(OptionTypeEnum optionType);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setEquityPremium(EquityPremium equityPremium);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setEquityExercise(EquityExerciseValuationSettlement equityExercise);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setExchangeLookAlike(Boolean exchangeLookAlike);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum methodOfAdjustment);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setOptionEntitlement(BigDecimal optionEntitlement);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setMultiplier(BigDecimal multiplier);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setClearingInstructions(SwaptionPhysicalSettlement clearingInstructions);
		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setVarianceSwapTransactionSupplement(VarianceSwapTransactionSupplement varianceSwapTransactionSupplement);

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
			processRosetta(path.newSubPath("equityPremium"), processor, EquityPremium.EquityPremiumBuilder.class, getEquityPremium());
			processRosetta(path.newSubPath("equityExercise"), processor, EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder.class, getEquityExercise());
			processor.processBasic(path.newSubPath("exchangeLookAlike"), Boolean.class, getExchangeLookAlike(), this);
			processor.processBasic(path.newSubPath("methodOfAdjustment"), MethodOfAdjustmentEnum.class, getMethodOfAdjustment(), this);
			processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
			processRosetta(path.newSubPath("clearingInstructions"), processor, SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder.class, getClearingInstructions());
			processRosetta(path.newSubPath("varianceSwapTransactionSupplement"), processor, VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder.class, getVarianceSwapTransactionSupplement());
		}
		

		VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of VarianceOptionTransactionSupplement  ***********************/
	class VarianceOptionTransactionSupplementImpl extends OptionBase.OptionBaseImpl implements VarianceOptionTransactionSupplement {
		private final EquityPremium equityPremium;
		private final EquityExerciseValuationSettlement equityExercise;
		private final Boolean exchangeLookAlike;
		private final MethodOfAdjustmentEnum methodOfAdjustment;
		private final BigDecimal optionEntitlement;
		private final BigDecimal multiplier;
		private final SwaptionPhysicalSettlement clearingInstructions;
		private final VarianceSwapTransactionSupplement varianceSwapTransactionSupplement;
		
		protected VarianceOptionTransactionSupplementImpl(VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder builder) {
			super(builder);
			this.equityPremium = ofNullable(builder.getEquityPremium()).map(f->f.build()).orElse(null);
			this.equityExercise = ofNullable(builder.getEquityExercise()).map(f->f.build()).orElse(null);
			this.exchangeLookAlike = builder.getExchangeLookAlike();
			this.methodOfAdjustment = builder.getMethodOfAdjustment();
			this.optionEntitlement = builder.getOptionEntitlement();
			this.multiplier = builder.getMultiplier();
			this.clearingInstructions = ofNullable(builder.getClearingInstructions()).map(f->f.build()).orElse(null);
			this.varianceSwapTransactionSupplement = ofNullable(builder.getVarianceSwapTransactionSupplement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("equityPremium")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("equityPremium")
		public EquityPremium getEquityPremium() {
			return equityPremium;
		}
		
		@Override
		@RosettaAttribute("equityExercise")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("equityExercise")
		public EquityExerciseValuationSettlement getEquityExercise() {
			return equityExercise;
		}
		
		@Override
		@RosettaAttribute("exchangeLookAlike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeLookAlike")
		public Boolean getExchangeLookAlike() {
			return exchangeLookAlike;
		}
		
		@Override
		@RosettaAttribute("methodOfAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("methodOfAdjustment")
		public MethodOfAdjustmentEnum getMethodOfAdjustment() {
			return methodOfAdjustment;
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("clearingInstructions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingInstructions")
		public SwaptionPhysicalSettlement getClearingInstructions() {
			return clearingInstructions;
		}
		
		@Override
		@RosettaAttribute("varianceSwapTransactionSupplement")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("varianceSwapTransactionSupplement")
		public VarianceSwapTransactionSupplement getVarianceSwapTransactionSupplement() {
			return varianceSwapTransactionSupplement;
		}
		
		@Override
		public VarianceOptionTransactionSupplement build() {
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder toBuilder() {
			VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEquityPremium()).ifPresent(builder::setEquityPremium);
			ofNullable(getEquityExercise()).ifPresent(builder::setEquityExercise);
			ofNullable(getExchangeLookAlike()).ifPresent(builder::setExchangeLookAlike);
			ofNullable(getMethodOfAdjustment()).ifPresent(builder::setMethodOfAdjustment);
			ofNullable(getOptionEntitlement()).ifPresent(builder::setOptionEntitlement);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
			ofNullable(getClearingInstructions()).ifPresent(builder::setClearingInstructions);
			ofNullable(getVarianceSwapTransactionSupplement()).ifPresent(builder::setVarianceSwapTransactionSupplement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceOptionTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(equityPremium, _that.getEquityPremium())) return false;
			if (!Objects.equals(equityExercise, _that.getEquityExercise())) return false;
			if (!Objects.equals(exchangeLookAlike, _that.getExchangeLookAlike())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			if (!Objects.equals(varianceSwapTransactionSupplement, _that.getVarianceSwapTransactionSupplement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (equityPremium != null ? equityPremium.hashCode() : 0);
			_result = 31 * _result + (equityExercise != null ? equityExercise.hashCode() : 0);
			_result = 31 * _result + (exchangeLookAlike != null ? exchangeLookAlike.hashCode() : 0);
			_result = 31 * _result + (methodOfAdjustment != null ? methodOfAdjustment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			_result = 31 * _result + (varianceSwapTransactionSupplement != null ? varianceSwapTransactionSupplement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceOptionTransactionSupplement {" +
				"equityPremium=" + this.equityPremium + ", " +
				"equityExercise=" + this.equityExercise + ", " +
				"exchangeLookAlike=" + this.exchangeLookAlike + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"multiplier=" + this.multiplier + ", " +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"varianceSwapTransactionSupplement=" + this.varianceSwapTransactionSupplement +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VarianceOptionTransactionSupplement  ***********************/
	class VarianceOptionTransactionSupplementBuilderImpl extends OptionBase.OptionBaseBuilderImpl implements VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder {
	
		protected EquityPremium.EquityPremiumBuilder equityPremium;
		protected EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder equityExercise;
		protected Boolean exchangeLookAlike;
		protected MethodOfAdjustmentEnum methodOfAdjustment;
		protected BigDecimal optionEntitlement;
		protected BigDecimal multiplier;
		protected SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder clearingInstructions;
		protected VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder varianceSwapTransactionSupplement;
		
		@Override
		@RosettaAttribute("equityPremium")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("equityPremium")
		public EquityPremium.EquityPremiumBuilder getEquityPremium() {
			return equityPremium;
		}
		
		@Override
		public EquityPremium.EquityPremiumBuilder getOrCreateEquityPremium() {
			EquityPremium.EquityPremiumBuilder result;
			if (equityPremium!=null) {
				result = equityPremium;
			}
			else {
				result = equityPremium = EquityPremium.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityExercise")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("equityExercise")
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getEquityExercise() {
			return equityExercise;
		}
		
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder getOrCreateEquityExercise() {
			EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder result;
			if (equityExercise!=null) {
				result = equityExercise;
			}
			else {
				result = equityExercise = EquityExerciseValuationSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangeLookAlike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeLookAlike")
		public Boolean getExchangeLookAlike() {
			return exchangeLookAlike;
		}
		
		@Override
		@RosettaAttribute("methodOfAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("methodOfAdjustment")
		public MethodOfAdjustmentEnum getMethodOfAdjustment() {
			return methodOfAdjustment;
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
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
		@RosettaAttribute("varianceSwapTransactionSupplement")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("varianceSwapTransactionSupplement")
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder getVarianceSwapTransactionSupplement() {
			return varianceSwapTransactionSupplement;
		}
		
		@Override
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder getOrCreateVarianceSwapTransactionSupplement() {
			VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder result;
			if (varianceSwapTransactionSupplement!=null) {
				result = varianceSwapTransactionSupplement;
			}
			else {
				result = varianceSwapTransactionSupplement = VarianceSwapTransactionSupplement.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addProductId(List<? extends ProductId> productIds) {
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
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setProductId(List<? extends ProductId> productIds) {
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
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("optionType")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setOptionType(OptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("equityPremium")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("equityPremium")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setEquityPremium(EquityPremium _equityPremium) {
			this.equityPremium = _equityPremium == null ? null : _equityPremium.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equityExercise")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("equityExercise")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setEquityExercise(EquityExerciseValuationSettlement _equityExercise) {
			this.equityExercise = _equityExercise == null ? null : _equityExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeLookAlike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeLookAlike")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setExchangeLookAlike(Boolean _exchangeLookAlike) {
			this.exchangeLookAlike = _exchangeLookAlike == null ? null : _exchangeLookAlike;
			return this;
		}
		
		@RosettaAttribute("methodOfAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("methodOfAdjustment")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setMethodOfAdjustment(MethodOfAdjustmentEnum _methodOfAdjustment) {
			this.methodOfAdjustment = _methodOfAdjustment == null ? null : _methodOfAdjustment;
			return this;
		}
		
		@RosettaAttribute("optionEntitlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionEntitlement")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setOptionEntitlement(BigDecimal _optionEntitlement) {
			this.optionEntitlement = _optionEntitlement == null ? null : _optionEntitlement;
			return this;
		}
		
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiplier")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setMultiplier(BigDecimal _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier;
			return this;
		}
		
		@RosettaAttribute("clearingInstructions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingInstructions")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setClearingInstructions(SwaptionPhysicalSettlement _clearingInstructions) {
			this.clearingInstructions = _clearingInstructions == null ? null : _clearingInstructions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("varianceSwapTransactionSupplement")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("varianceSwapTransactionSupplement")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder setVarianceSwapTransactionSupplement(VarianceSwapTransactionSupplement _varianceSwapTransactionSupplement) {
			this.varianceSwapTransactionSupplement = _varianceSwapTransactionSupplement == null ? null : _varianceSwapTransactionSupplement.toBuilder();
			return this;
		}
		
		@Override
		public VarianceOptionTransactionSupplement build() {
			return new VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementImpl(this);
		}
		
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder prune() {
			super.prune();
			if (equityPremium!=null && !equityPremium.prune().hasData()) equityPremium = null;
			if (equityExercise!=null && !equityExercise.prune().hasData()) equityExercise = null;
			if (clearingInstructions!=null && !clearingInstructions.prune().hasData()) clearingInstructions = null;
			if (varianceSwapTransactionSupplement!=null && !varianceSwapTransactionSupplement.prune().hasData()) varianceSwapTransactionSupplement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEquityPremium()!=null && getEquityPremium().hasData()) return true;
			if (getEquityExercise()!=null && getEquityExercise().hasData()) return true;
			if (getExchangeLookAlike()!=null) return true;
			if (getMethodOfAdjustment()!=null) return true;
			if (getOptionEntitlement()!=null) return true;
			if (getMultiplier()!=null) return true;
			if (getClearingInstructions()!=null && getClearingInstructions().hasData()) return true;
			if (getVarianceSwapTransactionSupplement()!=null && getVarianceSwapTransactionSupplement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder o = (VarianceOptionTransactionSupplement.VarianceOptionTransactionSupplementBuilder) other;
			
			merger.mergeRosetta(getEquityPremium(), o.getEquityPremium(), this::setEquityPremium);
			merger.mergeRosetta(getEquityExercise(), o.getEquityExercise(), this::setEquityExercise);
			merger.mergeRosetta(getClearingInstructions(), o.getClearingInstructions(), this::setClearingInstructions);
			merger.mergeRosetta(getVarianceSwapTransactionSupplement(), o.getVarianceSwapTransactionSupplement(), this::setVarianceSwapTransactionSupplement);
			
			merger.mergeBasic(getExchangeLookAlike(), o.getExchangeLookAlike(), this::setExchangeLookAlike);
			merger.mergeBasic(getMethodOfAdjustment(), o.getMethodOfAdjustment(), this::setMethodOfAdjustment);
			merger.mergeBasic(getOptionEntitlement(), o.getOptionEntitlement(), this::setOptionEntitlement);
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceOptionTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(equityPremium, _that.getEquityPremium())) return false;
			if (!Objects.equals(equityExercise, _that.getEquityExercise())) return false;
			if (!Objects.equals(exchangeLookAlike, _that.getExchangeLookAlike())) return false;
			if (!Objects.equals(methodOfAdjustment, _that.getMethodOfAdjustment())) return false;
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(clearingInstructions, _that.getClearingInstructions())) return false;
			if (!Objects.equals(varianceSwapTransactionSupplement, _that.getVarianceSwapTransactionSupplement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (equityPremium != null ? equityPremium.hashCode() : 0);
			_result = 31 * _result + (equityExercise != null ? equityExercise.hashCode() : 0);
			_result = 31 * _result + (exchangeLookAlike != null ? exchangeLookAlike.hashCode() : 0);
			_result = 31 * _result + (methodOfAdjustment != null ? methodOfAdjustment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (clearingInstructions != null ? clearingInstructions.hashCode() : 0);
			_result = 31 * _result + (varianceSwapTransactionSupplement != null ? varianceSwapTransactionSupplement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceOptionTransactionSupplementBuilder {" +
				"equityPremium=" + this.equityPremium + ", " +
				"equityExercise=" + this.equityExercise + ", " +
				"exchangeLookAlike=" + this.exchangeLookAlike + ", " +
				"methodOfAdjustment=" + this.methodOfAdjustment + ", " +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"multiplier=" + this.multiplier + ", " +
				"clearingInstructions=" + this.clearingInstructions + ", " +
				"varianceSwapTransactionSupplement=" + this.varianceSwapTransactionSupplement +
			'}' + " " + super.toString();
		}
	}
}

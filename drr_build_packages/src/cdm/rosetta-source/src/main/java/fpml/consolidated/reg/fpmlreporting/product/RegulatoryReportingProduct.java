package fpml.consolidated.reg.fpmlreporting.product;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.reg.fpmlreporting.product.meta.RegulatoryReportingProductMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
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
 * Provision Simple product representation providing key information about trade economics of any type of trade for regulatory reporting purposes. DEPRECATED. Reason: Not used. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegulatoryReportingProduct", builder=RegulatoryReportingProduct.RegulatoryReportingProductBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingProduct", model="fpml", builder=RegulatoryReportingProduct.RegulatoryReportingProductBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingProduct extends Product {

	RegulatoryReportingProductMeta metaData = new RegulatoryReportingProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	RegulatoryReportingProductParties getParties();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	RegulatoryReportingProductDates getDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	RegulatoryReportingProductSizes getSizes();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	RegulatoryReportingProductUnderlyers getUnderlyers();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	RegulatoryReportingProductPriceTerms getPriceTerms();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	RegulatoryReportingProductCalculationTerms getOtherCalculationTerms();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	RegulatoryReportingNonCDEOptionDetails getOptionDetails();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	RegulatoryReportingProductSettlementDetails getSettlementDetails();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<? extends RegReportingPayment> getOtherPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	RegulatoryReportingProductCreditDetails getCreditDetails();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	RegulatoryReportingProductNonCDEFxDetails getFxDetails();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	RegulatoryReportingNonCDEProductCommodityDetails getCommodityDetails();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingProduct build();
	
	RegulatoryReportingProduct.RegulatoryReportingProductBuilder toBuilder();
	
	static RegulatoryReportingProduct.RegulatoryReportingProductBuilder builder() {
		return new RegulatoryReportingProduct.RegulatoryReportingProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingProduct> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingProduct> getType() {
		return RegulatoryReportingProduct.class;
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
		processRosetta(path.newSubPath("parties"), processor, RegulatoryReportingProductParties.class, getParties());
		processRosetta(path.newSubPath("dates"), processor, RegulatoryReportingProductDates.class, getDates());
		processRosetta(path.newSubPath("sizes"), processor, RegulatoryReportingProductSizes.class, getSizes());
		processRosetta(path.newSubPath("underlyers"), processor, RegulatoryReportingProductUnderlyers.class, getUnderlyers());
		processRosetta(path.newSubPath("priceTerms"), processor, RegulatoryReportingProductPriceTerms.class, getPriceTerms());
		processRosetta(path.newSubPath("otherCalculationTerms"), processor, RegulatoryReportingProductCalculationTerms.class, getOtherCalculationTerms());
		processRosetta(path.newSubPath("optionDetails"), processor, RegulatoryReportingNonCDEOptionDetails.class, getOptionDetails());
		processRosetta(path.newSubPath("settlementDetails"), processor, RegulatoryReportingProductSettlementDetails.class, getSettlementDetails());
		processRosetta(path.newSubPath("otherPayment"), processor, RegReportingPayment.class, getOtherPayment());
		processRosetta(path.newSubPath("creditDetails"), processor, RegulatoryReportingProductCreditDetails.class, getCreditDetails());
		processRosetta(path.newSubPath("fxDetails"), processor, RegulatoryReportingProductNonCDEFxDetails.class, getFxDetails());
		processRosetta(path.newSubPath("commodityDetails"), processor, RegulatoryReportingNonCDEProductCommodityDetails.class, getCommodityDetails());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingProductBuilder extends RegulatoryReportingProduct, Product.ProductBuilder {
		RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder getOrCreateParties();
		@Override
		RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder getParties();
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder getOrCreateDates();
		@Override
		RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder getDates();
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder getOrCreateSizes();
		@Override
		RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder getSizes();
		RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder getOrCreateUnderlyers();
		@Override
		RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder getUnderlyers();
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder getOrCreatePriceTerms();
		@Override
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder getPriceTerms();
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder getOrCreateOtherCalculationTerms();
		@Override
		RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder getOtherCalculationTerms();
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder getOrCreateOptionDetails();
		@Override
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder getOptionDetails();
		RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder getOrCreateSettlementDetails();
		@Override
		RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder getSettlementDetails();
		RegReportingPayment.RegReportingPaymentBuilder getOrCreateOtherPayment(int index);
		@Override
		List<? extends RegReportingPayment.RegReportingPaymentBuilder> getOtherPayment();
		RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder getOrCreateCreditDetails();
		@Override
		RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder getCreditDetails();
		RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder getOrCreateFxDetails();
		@Override
		RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder getFxDetails();
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder getOrCreateCommodityDetails();
		@Override
		RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder getCommodityDetails();
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setId(String id);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addProductType(ProductType productType);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addProductType(ProductType productType, int idx);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addProductType(List<? extends ProductType> productType);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setProductType(List<? extends ProductType> productType);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addProductId(ProductId productId);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addProductId(ProductId productId, int idx);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addProductId(List<? extends ProductId> productId);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setProductId(List<? extends ProductId> productId);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addAssetClass(AssetClass assetClass);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setAssetClass(List<? extends AssetClass> assetClass);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setParties(RegulatoryReportingProductParties parties);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setDates(RegulatoryReportingProductDates dates);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setSizes(RegulatoryReportingProductSizes sizes);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setUnderlyers(RegulatoryReportingProductUnderlyers underlyers);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setPriceTerms(RegulatoryReportingProductPriceTerms priceTerms);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setOtherCalculationTerms(RegulatoryReportingProductCalculationTerms otherCalculationTerms);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setOptionDetails(RegulatoryReportingNonCDEOptionDetails optionDetails);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setSettlementDetails(RegulatoryReportingProductSettlementDetails settlementDetails);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addOtherPayment(RegReportingPayment otherPayment);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addOtherPayment(RegReportingPayment otherPayment, int idx);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder addOtherPayment(List<? extends RegReportingPayment> otherPayment);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setOtherPayment(List<? extends RegReportingPayment> otherPayment);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setCreditDetails(RegulatoryReportingProductCreditDetails creditDetails);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setFxDetails(RegulatoryReportingProductNonCDEFxDetails fxDetails);
		RegulatoryReportingProduct.RegulatoryReportingProductBuilder setCommodityDetails(RegulatoryReportingNonCDEProductCommodityDetails commodityDetails);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("parties"), processor, RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder.class, getParties());
			processRosetta(path.newSubPath("dates"), processor, RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder.class, getDates());
			processRosetta(path.newSubPath("sizes"), processor, RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder.class, getSizes());
			processRosetta(path.newSubPath("underlyers"), processor, RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder.class, getUnderlyers());
			processRosetta(path.newSubPath("priceTerms"), processor, RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder.class, getPriceTerms());
			processRosetta(path.newSubPath("otherCalculationTerms"), processor, RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder.class, getOtherCalculationTerms());
			processRosetta(path.newSubPath("optionDetails"), processor, RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder.class, getOptionDetails());
			processRosetta(path.newSubPath("settlementDetails"), processor, RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder.class, getSettlementDetails());
			processRosetta(path.newSubPath("otherPayment"), processor, RegReportingPayment.RegReportingPaymentBuilder.class, getOtherPayment());
			processRosetta(path.newSubPath("creditDetails"), processor, RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder.class, getCreditDetails());
			processRosetta(path.newSubPath("fxDetails"), processor, RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder.class, getFxDetails());
			processRosetta(path.newSubPath("commodityDetails"), processor, RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder.class, getCommodityDetails());
		}
		

		RegulatoryReportingProduct.RegulatoryReportingProductBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingProduct  ***********************/
	class RegulatoryReportingProductImpl extends Product.ProductImpl implements RegulatoryReportingProduct {
		private final RegulatoryReportingProductParties parties;
		private final RegulatoryReportingProductDates dates;
		private final RegulatoryReportingProductSizes sizes;
		private final RegulatoryReportingProductUnderlyers underlyers;
		private final RegulatoryReportingProductPriceTerms priceTerms;
		private final RegulatoryReportingProductCalculationTerms otherCalculationTerms;
		private final RegulatoryReportingNonCDEOptionDetails optionDetails;
		private final RegulatoryReportingProductSettlementDetails settlementDetails;
		private final List<? extends RegReportingPayment> otherPayment;
		private final RegulatoryReportingProductCreditDetails creditDetails;
		private final RegulatoryReportingProductNonCDEFxDetails fxDetails;
		private final RegulatoryReportingNonCDEProductCommodityDetails commodityDetails;
		
		protected RegulatoryReportingProductImpl(RegulatoryReportingProduct.RegulatoryReportingProductBuilder builder) {
			super(builder);
			this.parties = ofNullable(builder.getParties()).map(f->f.build()).orElse(null);
			this.dates = ofNullable(builder.getDates()).map(f->f.build()).orElse(null);
			this.sizes = ofNullable(builder.getSizes()).map(f->f.build()).orElse(null);
			this.underlyers = ofNullable(builder.getUnderlyers()).map(f->f.build()).orElse(null);
			this.priceTerms = ofNullable(builder.getPriceTerms()).map(f->f.build()).orElse(null);
			this.otherCalculationTerms = ofNullable(builder.getOtherCalculationTerms()).map(f->f.build()).orElse(null);
			this.optionDetails = ofNullable(builder.getOptionDetails()).map(f->f.build()).orElse(null);
			this.settlementDetails = ofNullable(builder.getSettlementDetails()).map(f->f.build()).orElse(null);
			this.otherPayment = ofNullable(builder.getOtherPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditDetails = ofNullable(builder.getCreditDetails()).map(f->f.build()).orElse(null);
			this.fxDetails = ofNullable(builder.getFxDetails()).map(f->f.build()).orElse(null);
			this.commodityDetails = ofNullable(builder.getCommodityDetails()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("parties")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parties")
		public RegulatoryReportingProductParties getParties() {
			return parties;
		}
		
		@Override
		@RosettaAttribute("dates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dates")
		public RegulatoryReportingProductDates getDates() {
			return dates;
		}
		
		@Override
		@RosettaAttribute("sizes")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sizes")
		public RegulatoryReportingProductSizes getSizes() {
			return sizes;
		}
		
		@Override
		@RosettaAttribute("underlyers")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyers")
		public RegulatoryReportingProductUnderlyers getUnderlyers() {
			return underlyers;
		}
		
		@Override
		@RosettaAttribute("priceTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceTerms")
		public RegulatoryReportingProductPriceTerms getPriceTerms() {
			return priceTerms;
		}
		
		@Override
		@RosettaAttribute("otherCalculationTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherCalculationTerms")
		public RegulatoryReportingProductCalculationTerms getOtherCalculationTerms() {
			return otherCalculationTerms;
		}
		
		@Override
		@RosettaAttribute("optionDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionDetails")
		public RegulatoryReportingNonCDEOptionDetails getOptionDetails() {
			return optionDetails;
		}
		
		@Override
		@RosettaAttribute("settlementDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDetails")
		public RegulatoryReportingProductSettlementDetails getSettlementDetails() {
			return settlementDetails;
		}
		
		@Override
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPayment")
		public List<? extends RegReportingPayment> getOtherPayment() {
			return otherPayment;
		}
		
		@Override
		@RosettaAttribute("creditDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditDetails")
		public RegulatoryReportingProductCreditDetails getCreditDetails() {
			return creditDetails;
		}
		
		@Override
		@RosettaAttribute("fxDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxDetails")
		public RegulatoryReportingProductNonCDEFxDetails getFxDetails() {
			return fxDetails;
		}
		
		@Override
		@RosettaAttribute("commodityDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityDetails")
		public RegulatoryReportingNonCDEProductCommodityDetails getCommodityDetails() {
			return commodityDetails;
		}
		
		@Override
		public RegulatoryReportingProduct build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder toBuilder() {
			RegulatoryReportingProduct.RegulatoryReportingProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingProduct.RegulatoryReportingProductBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getParties()).ifPresent(builder::setParties);
			ofNullable(getDates()).ifPresent(builder::setDates);
			ofNullable(getSizes()).ifPresent(builder::setSizes);
			ofNullable(getUnderlyers()).ifPresent(builder::setUnderlyers);
			ofNullable(getPriceTerms()).ifPresent(builder::setPriceTerms);
			ofNullable(getOtherCalculationTerms()).ifPresent(builder::setOtherCalculationTerms);
			ofNullable(getOptionDetails()).ifPresent(builder::setOptionDetails);
			ofNullable(getSettlementDetails()).ifPresent(builder::setSettlementDetails);
			ofNullable(getOtherPayment()).ifPresent(builder::setOtherPayment);
			ofNullable(getCreditDetails()).ifPresent(builder::setCreditDetails);
			ofNullable(getFxDetails()).ifPresent(builder::setFxDetails);
			ofNullable(getCommodityDetails()).ifPresent(builder::setCommodityDetails);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryReportingProduct _that = getType().cast(o);
		
			if (!Objects.equals(parties, _that.getParties())) return false;
			if (!Objects.equals(dates, _that.getDates())) return false;
			if (!Objects.equals(sizes, _that.getSizes())) return false;
			if (!Objects.equals(underlyers, _that.getUnderlyers())) return false;
			if (!Objects.equals(priceTerms, _that.getPriceTerms())) return false;
			if (!Objects.equals(otherCalculationTerms, _that.getOtherCalculationTerms())) return false;
			if (!Objects.equals(optionDetails, _that.getOptionDetails())) return false;
			if (!Objects.equals(settlementDetails, _that.getSettlementDetails())) return false;
			if (!ListEquals.listEquals(otherPayment, _that.getOtherPayment())) return false;
			if (!Objects.equals(creditDetails, _that.getCreditDetails())) return false;
			if (!Objects.equals(fxDetails, _that.getFxDetails())) return false;
			if (!Objects.equals(commodityDetails, _that.getCommodityDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (parties != null ? parties.hashCode() : 0);
			_result = 31 * _result + (dates != null ? dates.hashCode() : 0);
			_result = 31 * _result + (sizes != null ? sizes.hashCode() : 0);
			_result = 31 * _result + (underlyers != null ? underlyers.hashCode() : 0);
			_result = 31 * _result + (priceTerms != null ? priceTerms.hashCode() : 0);
			_result = 31 * _result + (otherCalculationTerms != null ? otherCalculationTerms.hashCode() : 0);
			_result = 31 * _result + (optionDetails != null ? optionDetails.hashCode() : 0);
			_result = 31 * _result + (settlementDetails != null ? settlementDetails.hashCode() : 0);
			_result = 31 * _result + (otherPayment != null ? otherPayment.hashCode() : 0);
			_result = 31 * _result + (creditDetails != null ? creditDetails.hashCode() : 0);
			_result = 31 * _result + (fxDetails != null ? fxDetails.hashCode() : 0);
			_result = 31 * _result + (commodityDetails != null ? commodityDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProduct {" +
				"parties=" + this.parties + ", " +
				"dates=" + this.dates + ", " +
				"sizes=" + this.sizes + ", " +
				"underlyers=" + this.underlyers + ", " +
				"priceTerms=" + this.priceTerms + ", " +
				"otherCalculationTerms=" + this.otherCalculationTerms + ", " +
				"optionDetails=" + this.optionDetails + ", " +
				"settlementDetails=" + this.settlementDetails + ", " +
				"otherPayment=" + this.otherPayment + ", " +
				"creditDetails=" + this.creditDetails + ", " +
				"fxDetails=" + this.fxDetails + ", " +
				"commodityDetails=" + this.commodityDetails +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingProduct  ***********************/
	class RegulatoryReportingProductBuilderImpl extends Product.ProductBuilderImpl implements RegulatoryReportingProduct.RegulatoryReportingProductBuilder {
	
		protected RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder parties;
		protected RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder dates;
		protected RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder sizes;
		protected RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder underlyers;
		protected RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder priceTerms;
		protected RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder otherCalculationTerms;
		protected RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder optionDetails;
		protected RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder settlementDetails;
		protected List<RegReportingPayment.RegReportingPaymentBuilder> otherPayment = new ArrayList<>();
		protected RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder creditDetails;
		protected RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder fxDetails;
		protected RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder commodityDetails;
		
		@Override
		@RosettaAttribute("parties")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parties")
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder getParties() {
			return parties;
		}
		
		@Override
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder getOrCreateParties() {
			RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder result;
			if (parties!=null) {
				result = parties;
			}
			else {
				result = parties = RegulatoryReportingProductParties.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dates")
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder getDates() {
			return dates;
		}
		
		@Override
		public RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder getOrCreateDates() {
			RegulatoryReportingProductDates.RegulatoryReportingProductDatesBuilder result;
			if (dates!=null) {
				result = dates;
			}
			else {
				result = dates = RegulatoryReportingProductDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sizes")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sizes")
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder getSizes() {
			return sizes;
		}
		
		@Override
		public RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder getOrCreateSizes() {
			RegulatoryReportingProductSizes.RegulatoryReportingProductSizesBuilder result;
			if (sizes!=null) {
				result = sizes;
			}
			else {
				result = sizes = RegulatoryReportingProductSizes.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyers")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyers")
		public RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder getUnderlyers() {
			return underlyers;
		}
		
		@Override
		public RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder getOrCreateUnderlyers() {
			RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder result;
			if (underlyers!=null) {
				result = underlyers;
			}
			else {
				result = underlyers = RegulatoryReportingProductUnderlyers.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceTerms")
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder getPriceTerms() {
			return priceTerms;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder getOrCreatePriceTerms() {
			RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder result;
			if (priceTerms!=null) {
				result = priceTerms;
			}
			else {
				result = priceTerms = RegulatoryReportingProductPriceTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherCalculationTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherCalculationTerms")
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder getOtherCalculationTerms() {
			return otherCalculationTerms;
		}
		
		@Override
		public RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder getOrCreateOtherCalculationTerms() {
			RegulatoryReportingProductCalculationTerms.RegulatoryReportingProductCalculationTermsBuilder result;
			if (otherCalculationTerms!=null) {
				result = otherCalculationTerms;
			}
			else {
				result = otherCalculationTerms = RegulatoryReportingProductCalculationTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionDetails")
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder getOptionDetails() {
			return optionDetails;
		}
		
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder getOrCreateOptionDetails() {
			RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder result;
			if (optionDetails!=null) {
				result = optionDetails;
			}
			else {
				result = optionDetails = RegulatoryReportingNonCDEOptionDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDetails")
		public RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder getSettlementDetails() {
			return settlementDetails;
		}
		
		@Override
		public RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder getOrCreateSettlementDetails() {
			RegulatoryReportingProductSettlementDetails.RegulatoryReportingProductSettlementDetailsBuilder result;
			if (settlementDetails!=null) {
				result = settlementDetails;
			}
			else {
				result = settlementDetails = RegulatoryReportingProductSettlementDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPayment")
		public List<? extends RegReportingPayment.RegReportingPaymentBuilder> getOtherPayment() {
			return otherPayment;
		}
		
		@Override
		public RegReportingPayment.RegReportingPaymentBuilder getOrCreateOtherPayment(int index) {
			if (otherPayment==null) {
				this.otherPayment = new ArrayList<>();
			}
			return getIndex(otherPayment, index, () -> {
						RegReportingPayment.RegReportingPaymentBuilder newOtherPayment = RegReportingPayment.builder();
						return newOtherPayment;
					});
		}
		
		@Override
		@RosettaAttribute("creditDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditDetails")
		public RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder getCreditDetails() {
			return creditDetails;
		}
		
		@Override
		public RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder getOrCreateCreditDetails() {
			RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder result;
			if (creditDetails!=null) {
				result = creditDetails;
			}
			else {
				result = creditDetails = RegulatoryReportingProductCreditDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxDetails")
		public RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder getFxDetails() {
			return fxDetails;
		}
		
		@Override
		public RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder getOrCreateFxDetails() {
			RegulatoryReportingProductNonCDEFxDetails.RegulatoryReportingProductNonCDEFxDetailsBuilder result;
			if (fxDetails!=null) {
				result = fxDetails;
			}
			else {
				result = fxDetails = RegulatoryReportingProductNonCDEFxDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityDetails")
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder getCommodityDetails() {
			return commodityDetails;
		}
		
		@Override
		public RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder getOrCreateCommodityDetails() {
			RegulatoryReportingNonCDEProductCommodityDetails.RegulatoryReportingNonCDEProductCommodityDetailsBuilder result;
			if (commodityDetails!=null) {
				result = commodityDetails;
			}
			else {
				result = commodityDetails = RegulatoryReportingNonCDEProductCommodityDetails.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addProductId(List<? extends ProductId> productIds) {
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
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setProductId(List<? extends ProductId> productIds) {
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
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("parties")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parties")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setParties(RegulatoryReportingProductParties _parties) {
			this.parties = _parties == null ? null : _parties.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dates")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setDates(RegulatoryReportingProductDates _dates) {
			this.dates = _dates == null ? null : _dates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sizes")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sizes")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setSizes(RegulatoryReportingProductSizes _sizes) {
			this.sizes = _sizes == null ? null : _sizes.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyers")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyers")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setUnderlyers(RegulatoryReportingProductUnderlyers _underlyers) {
			this.underlyers = _underlyers == null ? null : _underlyers.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceTerms")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setPriceTerms(RegulatoryReportingProductPriceTerms _priceTerms) {
			this.priceTerms = _priceTerms == null ? null : _priceTerms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherCalculationTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherCalculationTerms")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setOtherCalculationTerms(RegulatoryReportingProductCalculationTerms _otherCalculationTerms) {
			this.otherCalculationTerms = _otherCalculationTerms == null ? null : _otherCalculationTerms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionDetails")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setOptionDetails(RegulatoryReportingNonCDEOptionDetails _optionDetails) {
			this.optionDetails = _optionDetails == null ? null : _optionDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDetails")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setSettlementDetails(RegulatoryReportingProductSettlementDetails _settlementDetails) {
			this.settlementDetails = _settlementDetails == null ? null : _settlementDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otherPayment")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addOtherPayment(RegReportingPayment _otherPayment) {
			if (_otherPayment != null) {
				this.otherPayment.add(_otherPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addOtherPayment(RegReportingPayment _otherPayment, int idx) {
			getIndex(this.otherPayment, idx, () -> _otherPayment.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder addOtherPayment(List<? extends RegReportingPayment> otherPayments) {
			if (otherPayments != null) {
				for (final RegReportingPayment toAdd : otherPayments) {
					this.otherPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("otherPayment")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setOtherPayment(List<? extends RegReportingPayment> otherPayments) {
			if (otherPayments == null) {
				this.otherPayment = new ArrayList<>();
			} else {
				this.otherPayment = otherPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("creditDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditDetails")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setCreditDetails(RegulatoryReportingProductCreditDetails _creditDetails) {
			this.creditDetails = _creditDetails == null ? null : _creditDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxDetails")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setFxDetails(RegulatoryReportingProductNonCDEFxDetails _fxDetails) {
			this.fxDetails = _fxDetails == null ? null : _fxDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commodityDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityDetails")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder setCommodityDetails(RegulatoryReportingNonCDEProductCommodityDetails _commodityDetails) {
			this.commodityDetails = _commodityDetails == null ? null : _commodityDetails.toBuilder();
			return this;
		}
		
		@Override
		public RegulatoryReportingProduct build() {
			return new RegulatoryReportingProduct.RegulatoryReportingProductImpl(this);
		}
		
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder prune() {
			super.prune();
			if (parties!=null && !parties.prune().hasData()) parties = null;
			if (dates!=null && !dates.prune().hasData()) dates = null;
			if (sizes!=null && !sizes.prune().hasData()) sizes = null;
			if (underlyers!=null && !underlyers.prune().hasData()) underlyers = null;
			if (priceTerms!=null && !priceTerms.prune().hasData()) priceTerms = null;
			if (otherCalculationTerms!=null && !otherCalculationTerms.prune().hasData()) otherCalculationTerms = null;
			if (optionDetails!=null && !optionDetails.prune().hasData()) optionDetails = null;
			if (settlementDetails!=null && !settlementDetails.prune().hasData()) settlementDetails = null;
			otherPayment = otherPayment.stream().filter(b->b!=null).<RegReportingPayment.RegReportingPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (creditDetails!=null && !creditDetails.prune().hasData()) creditDetails = null;
			if (fxDetails!=null && !fxDetails.prune().hasData()) fxDetails = null;
			if (commodityDetails!=null && !commodityDetails.prune().hasData()) commodityDetails = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getParties()!=null && getParties().hasData()) return true;
			if (getDates()!=null && getDates().hasData()) return true;
			if (getSizes()!=null && getSizes().hasData()) return true;
			if (getUnderlyers()!=null && getUnderlyers().hasData()) return true;
			if (getPriceTerms()!=null && getPriceTerms().hasData()) return true;
			if (getOtherCalculationTerms()!=null && getOtherCalculationTerms().hasData()) return true;
			if (getOptionDetails()!=null && getOptionDetails().hasData()) return true;
			if (getSettlementDetails()!=null && getSettlementDetails().hasData()) return true;
			if (getOtherPayment()!=null && getOtherPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditDetails()!=null && getCreditDetails().hasData()) return true;
			if (getFxDetails()!=null && getFxDetails().hasData()) return true;
			if (getCommodityDetails()!=null && getCommodityDetails().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProduct.RegulatoryReportingProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryReportingProduct.RegulatoryReportingProductBuilder o = (RegulatoryReportingProduct.RegulatoryReportingProductBuilder) other;
			
			merger.mergeRosetta(getParties(), o.getParties(), this::setParties);
			merger.mergeRosetta(getDates(), o.getDates(), this::setDates);
			merger.mergeRosetta(getSizes(), o.getSizes(), this::setSizes);
			merger.mergeRosetta(getUnderlyers(), o.getUnderlyers(), this::setUnderlyers);
			merger.mergeRosetta(getPriceTerms(), o.getPriceTerms(), this::setPriceTerms);
			merger.mergeRosetta(getOtherCalculationTerms(), o.getOtherCalculationTerms(), this::setOtherCalculationTerms);
			merger.mergeRosetta(getOptionDetails(), o.getOptionDetails(), this::setOptionDetails);
			merger.mergeRosetta(getSettlementDetails(), o.getSettlementDetails(), this::setSettlementDetails);
			merger.mergeRosetta(getOtherPayment(), o.getOtherPayment(), this::getOrCreateOtherPayment);
			merger.mergeRosetta(getCreditDetails(), o.getCreditDetails(), this::setCreditDetails);
			merger.mergeRosetta(getFxDetails(), o.getFxDetails(), this::setFxDetails);
			merger.mergeRosetta(getCommodityDetails(), o.getCommodityDetails(), this::setCommodityDetails);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryReportingProduct _that = getType().cast(o);
		
			if (!Objects.equals(parties, _that.getParties())) return false;
			if (!Objects.equals(dates, _that.getDates())) return false;
			if (!Objects.equals(sizes, _that.getSizes())) return false;
			if (!Objects.equals(underlyers, _that.getUnderlyers())) return false;
			if (!Objects.equals(priceTerms, _that.getPriceTerms())) return false;
			if (!Objects.equals(otherCalculationTerms, _that.getOtherCalculationTerms())) return false;
			if (!Objects.equals(optionDetails, _that.getOptionDetails())) return false;
			if (!Objects.equals(settlementDetails, _that.getSettlementDetails())) return false;
			if (!ListEquals.listEquals(otherPayment, _that.getOtherPayment())) return false;
			if (!Objects.equals(creditDetails, _that.getCreditDetails())) return false;
			if (!Objects.equals(fxDetails, _that.getFxDetails())) return false;
			if (!Objects.equals(commodityDetails, _that.getCommodityDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (parties != null ? parties.hashCode() : 0);
			_result = 31 * _result + (dates != null ? dates.hashCode() : 0);
			_result = 31 * _result + (sizes != null ? sizes.hashCode() : 0);
			_result = 31 * _result + (underlyers != null ? underlyers.hashCode() : 0);
			_result = 31 * _result + (priceTerms != null ? priceTerms.hashCode() : 0);
			_result = 31 * _result + (otherCalculationTerms != null ? otherCalculationTerms.hashCode() : 0);
			_result = 31 * _result + (optionDetails != null ? optionDetails.hashCode() : 0);
			_result = 31 * _result + (settlementDetails != null ? settlementDetails.hashCode() : 0);
			_result = 31 * _result + (otherPayment != null ? otherPayment.hashCode() : 0);
			_result = 31 * _result + (creditDetails != null ? creditDetails.hashCode() : 0);
			_result = 31 * _result + (fxDetails != null ? fxDetails.hashCode() : 0);
			_result = 31 * _result + (commodityDetails != null ? commodityDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductBuilder {" +
				"parties=" + this.parties + ", " +
				"dates=" + this.dates + ", " +
				"sizes=" + this.sizes + ", " +
				"underlyers=" + this.underlyers + ", " +
				"priceTerms=" + this.priceTerms + ", " +
				"otherCalculationTerms=" + this.otherCalculationTerms + ", " +
				"optionDetails=" + this.optionDetails + ", " +
				"settlementDetails=" + this.settlementDetails + ", " +
				"otherPayment=" + this.otherPayment + ", " +
				"creditDetails=" + this.creditDetails + ", " +
				"fxDetails=" + this.fxDetails + ", " +
				"commodityDetails=" + this.commodityDetails +
			'}' + " " + super.toString();
		}
	}
}

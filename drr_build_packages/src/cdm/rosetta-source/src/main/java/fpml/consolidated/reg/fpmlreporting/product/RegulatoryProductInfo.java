package fpml.consolidated.reg.fpmlreporting.product;

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
import fpml.consolidated.reg.fpmlreporting.product.meta.RegulatoryProductInfoMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Product data fields required by regulators in satisfaction of non-public (recordkeeping) regulatory reporting regulations. These are identified where possible using CPMI-IOSCO Common Data Element lexicon and terminology, but include additional fields required by other regulations. This product is not intended to provide the full trade economics required for confirmation or valuation purposes. This product allows a simpler representation of OTC derivative products that have full standardized representations in FpML. DEPRECATED. Reason: Not used. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegulatoryProductInfo", builder=RegulatoryProductInfo.RegulatoryProductInfoBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryProductInfo", model="fpml", builder=RegulatoryProductInfo.RegulatoryProductInfoBuilderImpl.class, version="2.1.1")
public interface RegulatoryProductInfo extends RegulatoryReportingProduct {

	RegulatoryProductInfoMeta metaData = new RegulatoryProductInfoMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RegulatoryProductInfo build();
	
	RegulatoryProductInfo.RegulatoryProductInfoBuilder toBuilder();
	
	static RegulatoryProductInfo.RegulatoryProductInfoBuilder builder() {
		return new RegulatoryProductInfo.RegulatoryProductInfoBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryProductInfo> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryProductInfo> getType() {
		return RegulatoryProductInfo.class;
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
	interface RegulatoryProductInfoBuilder extends RegulatoryProductInfo, RegulatoryReportingProduct.RegulatoryReportingProductBuilder {
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setId(String id);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addProductType(ProductType productType);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addProductType(ProductType productType, int idx);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addProductType(List<? extends ProductType> productType);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setProductType(List<? extends ProductType> productType);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addProductId(ProductId productId);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addProductId(ProductId productId, int idx);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addProductId(List<? extends ProductId> productId);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setProductId(List<? extends ProductId> productId);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addAssetClass(AssetClass assetClass);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setParties(RegulatoryReportingProductParties parties);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setDates(RegulatoryReportingProductDates dates);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setSizes(RegulatoryReportingProductSizes sizes);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setUnderlyers(RegulatoryReportingProductUnderlyers underlyers);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setPriceTerms(RegulatoryReportingProductPriceTerms priceTerms);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setOtherCalculationTerms(RegulatoryReportingProductCalculationTerms otherCalculationTerms);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setOptionDetails(RegulatoryReportingNonCDEOptionDetails optionDetails);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setSettlementDetails(RegulatoryReportingProductSettlementDetails settlementDetails);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addOtherPayment(RegReportingPayment otherPayment);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addOtherPayment(RegReportingPayment otherPayment, int idx);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder addOtherPayment(List<? extends RegReportingPayment> otherPayment);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setOtherPayment(List<? extends RegReportingPayment> otherPayment);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setCreditDetails(RegulatoryReportingProductCreditDetails creditDetails);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setFxDetails(RegulatoryReportingProductNonCDEFxDetails fxDetails);
		@Override
		RegulatoryProductInfo.RegulatoryProductInfoBuilder setCommodityDetails(RegulatoryReportingNonCDEProductCommodityDetails commodityDetails);

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
		

		RegulatoryProductInfo.RegulatoryProductInfoBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryProductInfo  ***********************/
	class RegulatoryProductInfoImpl extends RegulatoryReportingProduct.RegulatoryReportingProductImpl implements RegulatoryProductInfo {
		
		protected RegulatoryProductInfoImpl(RegulatoryProductInfo.RegulatoryProductInfoBuilder builder) {
			super(builder);
		}
		
		@Override
		public RegulatoryProductInfo build() {
			return this;
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder toBuilder() {
			RegulatoryProductInfo.RegulatoryProductInfoBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryProductInfo.RegulatoryProductInfoBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryProductInfo {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryProductInfo  ***********************/
	class RegulatoryProductInfoBuilderImpl extends RegulatoryReportingProduct.RegulatoryReportingProductBuilderImpl implements RegulatoryProductInfo.RegulatoryProductInfoBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addProductId(List<? extends ProductId> productIds) {
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
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setProductId(List<? extends ProductId> productIds) {
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
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setParties(RegulatoryReportingProductParties _parties) {
			this.parties = _parties == null ? null : _parties.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dates")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setDates(RegulatoryReportingProductDates _dates) {
			this.dates = _dates == null ? null : _dates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sizes")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sizes")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setSizes(RegulatoryReportingProductSizes _sizes) {
			this.sizes = _sizes == null ? null : _sizes.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyers")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyers")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setUnderlyers(RegulatoryReportingProductUnderlyers _underlyers) {
			this.underlyers = _underlyers == null ? null : _underlyers.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceTerms")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setPriceTerms(RegulatoryReportingProductPriceTerms _priceTerms) {
			this.priceTerms = _priceTerms == null ? null : _priceTerms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherCalculationTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherCalculationTerms")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setOtherCalculationTerms(RegulatoryReportingProductCalculationTerms _otherCalculationTerms) {
			this.otherCalculationTerms = _otherCalculationTerms == null ? null : _otherCalculationTerms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionDetails")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setOptionDetails(RegulatoryReportingNonCDEOptionDetails _optionDetails) {
			this.optionDetails = _optionDetails == null ? null : _optionDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDetails")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setSettlementDetails(RegulatoryReportingProductSettlementDetails _settlementDetails) {
			this.settlementDetails = _settlementDetails == null ? null : _settlementDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otherPayment")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addOtherPayment(RegReportingPayment _otherPayment) {
			if (_otherPayment != null) {
				this.otherPayment.add(_otherPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addOtherPayment(RegReportingPayment _otherPayment, int idx) {
			getIndex(this.otherPayment, idx, () -> _otherPayment.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder addOtherPayment(List<? extends RegReportingPayment> otherPayments) {
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
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setOtherPayment(List<? extends RegReportingPayment> otherPayments) {
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
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setCreditDetails(RegulatoryReportingProductCreditDetails _creditDetails) {
			this.creditDetails = _creditDetails == null ? null : _creditDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxDetails")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setFxDetails(RegulatoryReportingProductNonCDEFxDetails _fxDetails) {
			this.fxDetails = _fxDetails == null ? null : _fxDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commodityDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityDetails")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder setCommodityDetails(RegulatoryReportingNonCDEProductCommodityDetails _commodityDetails) {
			this.commodityDetails = _commodityDetails == null ? null : _commodityDetails.toBuilder();
			return this;
		}
		
		@Override
		public RegulatoryProductInfo build() {
			return new RegulatoryProductInfo.RegulatoryProductInfoImpl(this);
		}
		
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryProductInfo.RegulatoryProductInfoBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryProductInfo.RegulatoryProductInfoBuilder o = (RegulatoryProductInfo.RegulatoryProductInfoBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryProductInfoBuilder {" +
			'}' + " " + super.toString();
		}
	}
}

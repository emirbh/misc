package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.FxVarianceSwapMeta;
import fpml.consolidated.shared.AdjustableOrAdjustedDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
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
 * Provision An FX variance swap transaction definition.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An FX variance swap transaction definition.
 *
 */
@RosettaDataType(value="FxVarianceSwap", builder=FxVarianceSwap.FxVarianceSwapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxVarianceSwap", model="fpml", builder=FxVarianceSwap.FxVarianceSwapBuilderImpl.class, version="2.1.1")
public interface FxVarianceSwap extends FxPerformanceSwap {

	FxVarianceSwapMeta metaData = new FxVarianceSwapMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxVarianceSwap build();
	
	FxVarianceSwap.FxVarianceSwapBuilder toBuilder();
	
	static FxVarianceSwap.FxVarianceSwapBuilder builder() {
		return new FxVarianceSwap.FxVarianceSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxVarianceSwap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxVarianceSwap> getType() {
		return FxVarianceSwap.class;
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
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("vegaNotional"), processor, NonNegativeMoney.class, getVegaNotional());
		processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.class, getNotional());
		processRosetta(path.newSubPath("fixedLeg"), processor, FxPerformanceFixedLeg.class, getFixedLeg());
		processRosetta(path.newSubPath("floatingLeg"), processor, FxPerformanceFloatingLeg.class, getFloatingLeg());
		processRosetta(path.newSubPath("fixingInformationSource"), processor, FxSpotRateSource.class, getFixingInformationSource());
		processRosetta(path.newSubPath("fixingSchedule"), processor, FxFixingScheduleSimple.class, getFixingSchedule());
		processor.processBasic(path.newSubPath("valuationDate"), ZonedDateTime.class, getValuationDate(), this);
		processRosetta(path.newSubPath("valuationDateOffset"), processor, FxValuationDateOffset.class, getValuationDateOffset());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedDate.class, getSettlementDate());
		processor.processBasic(path.newSubPath("annualizationFactor"), BigDecimal.class, getAnnualizationFactor(), this);
		processor.processBasic(path.newSubPath("meanAdjustment"), Boolean.class, getMeanAdjustment(), this);
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.class, getCashSettlement());
		processor.processBasic(path.newSubPath("numberOfReturns"), Integer.class, getNumberOfReturns(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxVarianceSwapBuilder extends FxVarianceSwap, FxPerformanceSwap.FxPerformanceSwapBuilder {
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setId(String id);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addProductType(ProductType productType);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addProductType(ProductType productType, int idx);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addProductType(List<? extends ProductType> productType);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setProductType(List<? extends ProductType> productType);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addProductId(ProductId productId);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addProductId(ProductId productId, int idx);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addProductId(List<? extends ProductId> productId);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setProductId(List<? extends ProductId> productId);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addAssetClass(AssetClass assetClass);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setVegaNotional(NonNegativeMoney vegaNotional);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setNotional(NonNegativeMoney notional);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setFixedLeg(FxPerformanceFixedLeg fixedLeg);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setFloatingLeg(FxPerformanceFloatingLeg floatingLeg);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setFixingInformationSource(FxSpotRateSource fixingInformationSource);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setFixingSchedule(FxFixingScheduleSimple fixingSchedule);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setValuationDate(ZonedDateTime valuationDate);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setValuationDateOffset(FxValuationDateOffset valuationDateOffset);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setSettlementDate(AdjustableOrAdjustedDate settlementDate);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setAnnualizationFactor(BigDecimal annualizationFactor);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setMeanAdjustment(Boolean meanAdjustment);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addAdditionalPayment(Payment additionalPayment);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addAdditionalPayment(Payment additionalPayment, int idx);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayment);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayment);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setCashSettlement(FxCashSettlementSimple cashSettlement);
		@Override
		FxVarianceSwap.FxVarianceSwapBuilder setNumberOfReturns(Integer numberOfReturns);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("vegaNotional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getVegaNotional());
			processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNotional());
			processRosetta(path.newSubPath("fixedLeg"), processor, FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder.class, getFixedLeg());
			processRosetta(path.newSubPath("floatingLeg"), processor, FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder.class, getFloatingLeg());
			processRosetta(path.newSubPath("fixingInformationSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getFixingInformationSource());
			processRosetta(path.newSubPath("fixingSchedule"), processor, FxFixingScheduleSimple.FxFixingScheduleSimpleBuilder.class, getFixingSchedule());
			processor.processBasic(path.newSubPath("valuationDate"), ZonedDateTime.class, getValuationDate(), this);
			processRosetta(path.newSubPath("valuationDateOffset"), processor, FxValuationDateOffset.FxValuationDateOffsetBuilder.class, getValuationDateOffset());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder.class, getSettlementDate());
			processor.processBasic(path.newSubPath("annualizationFactor"), BigDecimal.class, getAnnualizationFactor(), this);
			processor.processBasic(path.newSubPath("meanAdjustment"), Boolean.class, getMeanAdjustment(), this);
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.FxCashSettlementSimpleBuilder.class, getCashSettlement());
			processor.processBasic(path.newSubPath("numberOfReturns"), Integer.class, getNumberOfReturns(), this);
		}
		

		FxVarianceSwap.FxVarianceSwapBuilder prune();
	}

	/*********************** Immutable Implementation of FxVarianceSwap  ***********************/
	class FxVarianceSwapImpl extends FxPerformanceSwap.FxPerformanceSwapImpl implements FxVarianceSwap {
		
		protected FxVarianceSwapImpl(FxVarianceSwap.FxVarianceSwapBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxVarianceSwap build() {
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder toBuilder() {
			FxVarianceSwap.FxVarianceSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxVarianceSwap.FxVarianceSwapBuilder builder) {
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
			return "FxVarianceSwap {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxVarianceSwap  ***********************/
	class FxVarianceSwapBuilderImpl extends FxPerformanceSwap.FxPerformanceSwapBuilderImpl implements FxVarianceSwap.FxVarianceSwapBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxVarianceSwap.FxVarianceSwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public FxVarianceSwap.FxVarianceSwapBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public FxVarianceSwap.FxVarianceSwapBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public FxVarianceSwap.FxVarianceSwapBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addProductId(List<? extends ProductId> productIds) {
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
		public FxVarianceSwap.FxVarianceSwapBuilder setProductId(List<? extends ProductId> productIds) {
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
		public FxVarianceSwap.FxVarianceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxVarianceSwap.FxVarianceSwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public FxVarianceSwap.FxVarianceSwapBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public FxVarianceSwap.FxVarianceSwapBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vegaNotional")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("vegaNotional")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setVegaNotional(NonNegativeMoney _vegaNotional) {
			this.vegaNotional = _vegaNotional == null ? null : _vegaNotional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notional")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setNotional(NonNegativeMoney _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fixedLeg")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setFixedLeg(FxPerformanceFixedLeg _fixedLeg) {
			this.fixedLeg = _fixedLeg == null ? null : _fixedLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("floatingLeg")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setFloatingLeg(FxPerformanceFloatingLeg _floatingLeg) {
			this.floatingLeg = _floatingLeg == null ? null : _floatingLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingInformationSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingInformationSource")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setFixingInformationSource(FxSpotRateSource _fixingInformationSource) {
			this.fixingInformationSource = _fixingInformationSource == null ? null : _fixingInformationSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingSchedule")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fixingSchedule")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setFixingSchedule(FxFixingScheduleSimple _fixingSchedule) {
			this.fixingSchedule = _fixingSchedule == null ? null : _fixingSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDate")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setValuationDate(ZonedDateTime _valuationDate) {
			this.valuationDate = _valuationDate == null ? null : _valuationDate;
			return this;
		}
		
		@RosettaAttribute("valuationDateOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDateOffset")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setValuationDateOffset(FxValuationDateOffset _valuationDateOffset) {
			this.valuationDateOffset = _valuationDateOffset == null ? null : _valuationDateOffset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementDate")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setSettlementDate(AdjustableOrAdjustedDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("annualizationFactor")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("annualizationFactor")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setAnnualizationFactor(BigDecimal _annualizationFactor) {
			this.annualizationFactor = _annualizationFactor == null ? null : _annualizationFactor;
			return this;
		}
		
		@RosettaAttribute("meanAdjustment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("meanAdjustment")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setMeanAdjustment(Boolean _meanAdjustment) {
			this.meanAdjustment = _meanAdjustment == null ? null : _meanAdjustment;
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addAdditionalPayment(Payment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addAdditionalPayment(Payment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments != null) {
				for (final Payment toAdd : additionalPayments) {
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
		public FxVarianceSwap.FxVarianceSwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
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
		public FxVarianceSwap.FxVarianceSwapBuilder setCashSettlement(FxCashSettlementSimple _cashSettlement) {
			this.cashSettlement = _cashSettlement == null ? null : _cashSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("numberOfReturns")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfReturns")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder setNumberOfReturns(Integer _numberOfReturns) {
			this.numberOfReturns = _numberOfReturns == null ? null : _numberOfReturns;
			return this;
		}
		
		@Override
		public FxVarianceSwap build() {
			return new FxVarianceSwap.FxVarianceSwapImpl(this);
		}
		
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxVarianceSwap.FxVarianceSwapBuilder prune() {
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
		public FxVarianceSwap.FxVarianceSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxVarianceSwap.FxVarianceSwapBuilder o = (FxVarianceSwap.FxVarianceSwapBuilder) other;
			
			
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
			return "FxVarianceSwapBuilder {" +
			'}' + " " + super.toString();
		}
	}
}

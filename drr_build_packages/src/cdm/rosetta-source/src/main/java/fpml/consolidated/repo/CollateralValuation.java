package fpml.consolidated.repo;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.repo.meta.CollateralValuationMeta;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision This type is used in Repo trades, to specify the valuation of a specific piece of collateral in the transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision This type is used in Repo trades, to specify the valuation of a specific piece of collateral in the transaction.
 *
 */
@RosettaDataType(value="CollateralValuation", builder=CollateralValuation.CollateralValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CollateralValuation", model="fpml", builder=CollateralValuation.CollateralValuationBuilderImpl.class, version="2.1.1")
public interface CollateralValuation extends RosettaModelObject {

	CollateralValuationMeta metaData = new CollateralValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Total nominal amount of the security.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Total nominal amount of the security.
	 *
	 */
	Money getNominalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of units (securities).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of units (securities).
	 *
	 */
	BigDecimal getQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Bond clean price, expressed in percentage points, 100 is the initial value of the bond.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Bond clean price, expressed in percentage points, 100 is the initial value of the bond.
	 *
	 */
	BigDecimal getCleanPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Accruals, relationship is clean price and accruals equals dirty price, all prices are expressed in percentage points, 100 is the initial value of the bond.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Accruals, relationship is clean price and accruals equals dirty price, all prices are expressed in percentage points, 100 is the initial value of the bond.
	 *
	 */
	BigDecimal getAccruals();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Bond dirty price, expressed in percentage points, 100 is the initial value of the bond.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Bond dirty price, expressed in percentage points, 100 is the initial value of the bond.
	 *
	 */
	BigDecimal getDirtyPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Bond price relative to a Benchmark.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Bond price relative to a Benchmark.
	 *
	 */
	RelativePrice getRelativePrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Yield to Maturity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Yield to Maturity.
	 *
	 */
	BigDecimal getYieldToMaturity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The inflation factor is specified for inflation-linked products which require some additional elements to calculate prices correctly.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The inflation factor is specified for inflation-linked products which require some additional elements to calculate prices correctly.
	 *
	 */
	BigDecimal getInflationFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Bond all-in-price which is a price that includes all relevant price adjustments (i.e. accrued interest, haircut or margin ratio, inflation factor,etc.). It expresses a price in terms of percentage of nominal amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Bond all-in-price which is a price that includes all relevant price adjustments (i.e. accrued interest, haircut or margin ratio, inflation factor,etc.). It expresses a price in terms of percentage of nominal amount.
	 *
	 */
	BigDecimal getAllInPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Accruals expressed as amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Accruals expressed as amount.
	 *
	 */
	Money getAccrualsAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of units (index or securities).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of units (index or securities).
	 *
	 */
	BigDecimal getNumberOfUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The price of each unit.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The price of each unit.
	 *
	 */
	NonNegativeMoney getUnitPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to explicitly identify which asset is being valued.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to explicitly identify which asset is being valued.
	 *
	 */
	AssetReference getAssetReference();

	/*********************** Build Methods  ***********************/
	CollateralValuation build();
	
	CollateralValuation.CollateralValuationBuilder toBuilder();
	
	static CollateralValuation.CollateralValuationBuilder builder() {
		return new CollateralValuation.CollateralValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralValuation> getType() {
		return CollateralValuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("nominalAmount"), processor, Money.class, getNominalAmount());
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processor.processBasic(path.newSubPath("cleanPrice"), BigDecimal.class, getCleanPrice(), this);
		processor.processBasic(path.newSubPath("accruals"), BigDecimal.class, getAccruals(), this);
		processor.processBasic(path.newSubPath("dirtyPrice"), BigDecimal.class, getDirtyPrice(), this);
		processRosetta(path.newSubPath("relativePrice"), processor, RelativePrice.class, getRelativePrice());
		processor.processBasic(path.newSubPath("yieldToMaturity"), BigDecimal.class, getYieldToMaturity(), this);
		processor.processBasic(path.newSubPath("inflationFactor"), BigDecimal.class, getInflationFactor(), this);
		processor.processBasic(path.newSubPath("allInPrice"), BigDecimal.class, getAllInPrice(), this);
		processRosetta(path.newSubPath("accrualsAmount"), processor, Money.class, getAccrualsAmount());
		processor.processBasic(path.newSubPath("numberOfUnits"), BigDecimal.class, getNumberOfUnits(), this);
		processRosetta(path.newSubPath("unitPrice"), processor, NonNegativeMoney.class, getUnitPrice());
		processRosetta(path.newSubPath("assetReference"), processor, AssetReference.class, getAssetReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralValuationBuilder extends CollateralValuation, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateNominalAmount();
		@Override
		Money.MoneyBuilder getNominalAmount();
		RelativePrice.RelativePriceBuilder getOrCreateRelativePrice();
		@Override
		RelativePrice.RelativePriceBuilder getRelativePrice();
		Money.MoneyBuilder getOrCreateAccrualsAmount();
		@Override
		Money.MoneyBuilder getAccrualsAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateUnitPrice();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getUnitPrice();
		AssetReference.AssetReferenceBuilder getOrCreateAssetReference();
		@Override
		AssetReference.AssetReferenceBuilder getAssetReference();
		CollateralValuation.CollateralValuationBuilder setNominalAmount(Money nominalAmount);
		CollateralValuation.CollateralValuationBuilder setQuantity(BigDecimal quantity);
		CollateralValuation.CollateralValuationBuilder setCleanPrice(BigDecimal cleanPrice);
		CollateralValuation.CollateralValuationBuilder setAccruals(BigDecimal accruals);
		CollateralValuation.CollateralValuationBuilder setDirtyPrice(BigDecimal dirtyPrice);
		CollateralValuation.CollateralValuationBuilder setRelativePrice(RelativePrice relativePrice);
		CollateralValuation.CollateralValuationBuilder setYieldToMaturity(BigDecimal yieldToMaturity);
		CollateralValuation.CollateralValuationBuilder setInflationFactor(BigDecimal inflationFactor);
		CollateralValuation.CollateralValuationBuilder setAllInPrice(BigDecimal allInPrice);
		CollateralValuation.CollateralValuationBuilder setAccrualsAmount(Money accrualsAmount);
		CollateralValuation.CollateralValuationBuilder setNumberOfUnits(BigDecimal numberOfUnits);
		CollateralValuation.CollateralValuationBuilder setUnitPrice(NonNegativeMoney unitPrice);
		CollateralValuation.CollateralValuationBuilder setAssetReference(AssetReference assetReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("nominalAmount"), processor, Money.MoneyBuilder.class, getNominalAmount());
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processor.processBasic(path.newSubPath("cleanPrice"), BigDecimal.class, getCleanPrice(), this);
			processor.processBasic(path.newSubPath("accruals"), BigDecimal.class, getAccruals(), this);
			processor.processBasic(path.newSubPath("dirtyPrice"), BigDecimal.class, getDirtyPrice(), this);
			processRosetta(path.newSubPath("relativePrice"), processor, RelativePrice.RelativePriceBuilder.class, getRelativePrice());
			processor.processBasic(path.newSubPath("yieldToMaturity"), BigDecimal.class, getYieldToMaturity(), this);
			processor.processBasic(path.newSubPath("inflationFactor"), BigDecimal.class, getInflationFactor(), this);
			processor.processBasic(path.newSubPath("allInPrice"), BigDecimal.class, getAllInPrice(), this);
			processRosetta(path.newSubPath("accrualsAmount"), processor, Money.MoneyBuilder.class, getAccrualsAmount());
			processor.processBasic(path.newSubPath("numberOfUnits"), BigDecimal.class, getNumberOfUnits(), this);
			processRosetta(path.newSubPath("unitPrice"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getUnitPrice());
			processRosetta(path.newSubPath("assetReference"), processor, AssetReference.AssetReferenceBuilder.class, getAssetReference());
		}
		

		CollateralValuation.CollateralValuationBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralValuation  ***********************/
	class CollateralValuationImpl implements CollateralValuation {
		private final Money nominalAmount;
		private final BigDecimal quantity;
		private final BigDecimal cleanPrice;
		private final BigDecimal accruals;
		private final BigDecimal dirtyPrice;
		private final RelativePrice relativePrice;
		private final BigDecimal yieldToMaturity;
		private final BigDecimal inflationFactor;
		private final BigDecimal allInPrice;
		private final Money accrualsAmount;
		private final BigDecimal numberOfUnits;
		private final NonNegativeMoney unitPrice;
		private final AssetReference assetReference;
		
		protected CollateralValuationImpl(CollateralValuation.CollateralValuationBuilder builder) {
			this.nominalAmount = ofNullable(builder.getNominalAmount()).map(f->f.build()).orElse(null);
			this.quantity = builder.getQuantity();
			this.cleanPrice = builder.getCleanPrice();
			this.accruals = builder.getAccruals();
			this.dirtyPrice = builder.getDirtyPrice();
			this.relativePrice = ofNullable(builder.getRelativePrice()).map(f->f.build()).orElse(null);
			this.yieldToMaturity = builder.getYieldToMaturity();
			this.inflationFactor = builder.getInflationFactor();
			this.allInPrice = builder.getAllInPrice();
			this.accrualsAmount = ofNullable(builder.getAccrualsAmount()).map(f->f.build()).orElse(null);
			this.numberOfUnits = builder.getNumberOfUnits();
			this.unitPrice = ofNullable(builder.getUnitPrice()).map(f->f.build()).orElse(null);
			this.assetReference = ofNullable(builder.getAssetReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("nominalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nominalAmount")
		public Money getNominalAmount() {
			return nominalAmount;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("cleanPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cleanPrice")
		public BigDecimal getCleanPrice() {
			return cleanPrice;
		}
		
		@Override
		@RosettaAttribute("accruals")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruals")
		public BigDecimal getAccruals() {
			return accruals;
		}
		
		@Override
		@RosettaAttribute("dirtyPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dirtyPrice")
		public BigDecimal getDirtyPrice() {
			return dirtyPrice;
		}
		
		@Override
		@RosettaAttribute("relativePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativePrice")
		public RelativePrice getRelativePrice() {
			return relativePrice;
		}
		
		@Override
		@RosettaAttribute("yieldToMaturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("yieldToMaturity")
		public BigDecimal getYieldToMaturity() {
			return yieldToMaturity;
		}
		
		@Override
		@RosettaAttribute("inflationFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inflationFactor")
		public BigDecimal getInflationFactor() {
			return inflationFactor;
		}
		
		@Override
		@RosettaAttribute("allInPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allInPrice")
		public BigDecimal getAllInPrice() {
			return allInPrice;
		}
		
		@Override
		@RosettaAttribute("accrualsAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accrualsAmount")
		public Money getAccrualsAmount() {
			return accrualsAmount;
		}
		
		@Override
		@RosettaAttribute("numberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfUnits")
		public BigDecimal getNumberOfUnits() {
			return numberOfUnits;
		}
		
		@Override
		@RosettaAttribute("unitPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unitPrice")
		public NonNegativeMoney getUnitPrice() {
			return unitPrice;
		}
		
		@Override
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("assetReference")
		public AssetReference getAssetReference() {
			return assetReference;
		}
		
		@Override
		public CollateralValuation build() {
			return this;
		}
		
		@Override
		public CollateralValuation.CollateralValuationBuilder toBuilder() {
			CollateralValuation.CollateralValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralValuation.CollateralValuationBuilder builder) {
			ofNullable(getNominalAmount()).ifPresent(builder::setNominalAmount);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getCleanPrice()).ifPresent(builder::setCleanPrice);
			ofNullable(getAccruals()).ifPresent(builder::setAccruals);
			ofNullable(getDirtyPrice()).ifPresent(builder::setDirtyPrice);
			ofNullable(getRelativePrice()).ifPresent(builder::setRelativePrice);
			ofNullable(getYieldToMaturity()).ifPresent(builder::setYieldToMaturity);
			ofNullable(getInflationFactor()).ifPresent(builder::setInflationFactor);
			ofNullable(getAllInPrice()).ifPresent(builder::setAllInPrice);
			ofNullable(getAccrualsAmount()).ifPresent(builder::setAccrualsAmount);
			ofNullable(getNumberOfUnits()).ifPresent(builder::setNumberOfUnits);
			ofNullable(getUnitPrice()).ifPresent(builder::setUnitPrice);
			ofNullable(getAssetReference()).ifPresent(builder::setAssetReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValuation _that = getType().cast(o);
		
			if (!Objects.equals(nominalAmount, _that.getNominalAmount())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(cleanPrice, _that.getCleanPrice())) return false;
			if (!Objects.equals(accruals, _that.getAccruals())) return false;
			if (!Objects.equals(dirtyPrice, _that.getDirtyPrice())) return false;
			if (!Objects.equals(relativePrice, _that.getRelativePrice())) return false;
			if (!Objects.equals(yieldToMaturity, _that.getYieldToMaturity())) return false;
			if (!Objects.equals(inflationFactor, _that.getInflationFactor())) return false;
			if (!Objects.equals(allInPrice, _that.getAllInPrice())) return false;
			if (!Objects.equals(accrualsAmount, _that.getAccrualsAmount())) return false;
			if (!Objects.equals(numberOfUnits, _that.getNumberOfUnits())) return false;
			if (!Objects.equals(unitPrice, _that.getUnitPrice())) return false;
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nominalAmount != null ? nominalAmount.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (cleanPrice != null ? cleanPrice.hashCode() : 0);
			_result = 31 * _result + (accruals != null ? accruals.hashCode() : 0);
			_result = 31 * _result + (dirtyPrice != null ? dirtyPrice.hashCode() : 0);
			_result = 31 * _result + (relativePrice != null ? relativePrice.hashCode() : 0);
			_result = 31 * _result + (yieldToMaturity != null ? yieldToMaturity.hashCode() : 0);
			_result = 31 * _result + (inflationFactor != null ? inflationFactor.hashCode() : 0);
			_result = 31 * _result + (allInPrice != null ? allInPrice.hashCode() : 0);
			_result = 31 * _result + (accrualsAmount != null ? accrualsAmount.hashCode() : 0);
			_result = 31 * _result + (numberOfUnits != null ? numberOfUnits.hashCode() : 0);
			_result = 31 * _result + (unitPrice != null ? unitPrice.hashCode() : 0);
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValuation {" +
				"nominalAmount=" + this.nominalAmount + ", " +
				"quantity=" + this.quantity + ", " +
				"cleanPrice=" + this.cleanPrice + ", " +
				"accruals=" + this.accruals + ", " +
				"dirtyPrice=" + this.dirtyPrice + ", " +
				"relativePrice=" + this.relativePrice + ", " +
				"yieldToMaturity=" + this.yieldToMaturity + ", " +
				"inflationFactor=" + this.inflationFactor + ", " +
				"allInPrice=" + this.allInPrice + ", " +
				"accrualsAmount=" + this.accrualsAmount + ", " +
				"numberOfUnits=" + this.numberOfUnits + ", " +
				"unitPrice=" + this.unitPrice + ", " +
				"assetReference=" + this.assetReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralValuation  ***********************/
	class CollateralValuationBuilderImpl implements CollateralValuation.CollateralValuationBuilder {
	
		protected Money.MoneyBuilder nominalAmount;
		protected BigDecimal quantity;
		protected BigDecimal cleanPrice;
		protected BigDecimal accruals;
		protected BigDecimal dirtyPrice;
		protected RelativePrice.RelativePriceBuilder relativePrice;
		protected BigDecimal yieldToMaturity;
		protected BigDecimal inflationFactor;
		protected BigDecimal allInPrice;
		protected Money.MoneyBuilder accrualsAmount;
		protected BigDecimal numberOfUnits;
		protected NonNegativeMoney.NonNegativeMoneyBuilder unitPrice;
		protected AssetReference.AssetReferenceBuilder assetReference;
		
		@Override
		@RosettaAttribute("nominalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nominalAmount")
		public Money.MoneyBuilder getNominalAmount() {
			return nominalAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateNominalAmount() {
			Money.MoneyBuilder result;
			if (nominalAmount!=null) {
				result = nominalAmount;
			}
			else {
				result = nominalAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("cleanPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cleanPrice")
		public BigDecimal getCleanPrice() {
			return cleanPrice;
		}
		
		@Override
		@RosettaAttribute("accruals")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruals")
		public BigDecimal getAccruals() {
			return accruals;
		}
		
		@Override
		@RosettaAttribute("dirtyPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dirtyPrice")
		public BigDecimal getDirtyPrice() {
			return dirtyPrice;
		}
		
		@Override
		@RosettaAttribute("relativePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativePrice")
		public RelativePrice.RelativePriceBuilder getRelativePrice() {
			return relativePrice;
		}
		
		@Override
		public RelativePrice.RelativePriceBuilder getOrCreateRelativePrice() {
			RelativePrice.RelativePriceBuilder result;
			if (relativePrice!=null) {
				result = relativePrice;
			}
			else {
				result = relativePrice = RelativePrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("yieldToMaturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("yieldToMaturity")
		public BigDecimal getYieldToMaturity() {
			return yieldToMaturity;
		}
		
		@Override
		@RosettaAttribute("inflationFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inflationFactor")
		public BigDecimal getInflationFactor() {
			return inflationFactor;
		}
		
		@Override
		@RosettaAttribute("allInPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allInPrice")
		public BigDecimal getAllInPrice() {
			return allInPrice;
		}
		
		@Override
		@RosettaAttribute("accrualsAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accrualsAmount")
		public Money.MoneyBuilder getAccrualsAmount() {
			return accrualsAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAccrualsAmount() {
			Money.MoneyBuilder result;
			if (accrualsAmount!=null) {
				result = accrualsAmount;
			}
			else {
				result = accrualsAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfUnits")
		public BigDecimal getNumberOfUnits() {
			return numberOfUnits;
		}
		
		@Override
		@RosettaAttribute("unitPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unitPrice")
		public NonNegativeMoney.NonNegativeMoneyBuilder getUnitPrice() {
			return unitPrice;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateUnitPrice() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (unitPrice!=null) {
				result = unitPrice;
			}
			else {
				result = unitPrice = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("assetReference")
		public AssetReference.AssetReferenceBuilder getAssetReference() {
			return assetReference;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateAssetReference() {
			AssetReference.AssetReferenceBuilder result;
			if (assetReference!=null) {
				result = assetReference;
			}
			else {
				result = assetReference = AssetReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("nominalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nominalAmount")
		@Override
		public CollateralValuation.CollateralValuationBuilder setNominalAmount(Money _nominalAmount) {
			this.nominalAmount = _nominalAmount == null ? null : _nominalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantity")
		@Override
		public CollateralValuation.CollateralValuationBuilder setQuantity(BigDecimal _quantity) {
			this.quantity = _quantity == null ? null : _quantity;
			return this;
		}
		
		@RosettaAttribute("cleanPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cleanPrice")
		@Override
		public CollateralValuation.CollateralValuationBuilder setCleanPrice(BigDecimal _cleanPrice) {
			this.cleanPrice = _cleanPrice == null ? null : _cleanPrice;
			return this;
		}
		
		@RosettaAttribute("accruals")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accruals")
		@Override
		public CollateralValuation.CollateralValuationBuilder setAccruals(BigDecimal _accruals) {
			this.accruals = _accruals == null ? null : _accruals;
			return this;
		}
		
		@RosettaAttribute("dirtyPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dirtyPrice")
		@Override
		public CollateralValuation.CollateralValuationBuilder setDirtyPrice(BigDecimal _dirtyPrice) {
			this.dirtyPrice = _dirtyPrice == null ? null : _dirtyPrice;
			return this;
		}
		
		@RosettaAttribute("relativePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativePrice")
		@Override
		public CollateralValuation.CollateralValuationBuilder setRelativePrice(RelativePrice _relativePrice) {
			this.relativePrice = _relativePrice == null ? null : _relativePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("yieldToMaturity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("yieldToMaturity")
		@Override
		public CollateralValuation.CollateralValuationBuilder setYieldToMaturity(BigDecimal _yieldToMaturity) {
			this.yieldToMaturity = _yieldToMaturity == null ? null : _yieldToMaturity;
			return this;
		}
		
		@RosettaAttribute("inflationFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inflationFactor")
		@Override
		public CollateralValuation.CollateralValuationBuilder setInflationFactor(BigDecimal _inflationFactor) {
			this.inflationFactor = _inflationFactor == null ? null : _inflationFactor;
			return this;
		}
		
		@RosettaAttribute("allInPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allInPrice")
		@Override
		public CollateralValuation.CollateralValuationBuilder setAllInPrice(BigDecimal _allInPrice) {
			this.allInPrice = _allInPrice == null ? null : _allInPrice;
			return this;
		}
		
		@RosettaAttribute("accrualsAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accrualsAmount")
		@Override
		public CollateralValuation.CollateralValuationBuilder setAccrualsAmount(Money _accrualsAmount) {
			this.accrualsAmount = _accrualsAmount == null ? null : _accrualsAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("numberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfUnits")
		@Override
		public CollateralValuation.CollateralValuationBuilder setNumberOfUnits(BigDecimal _numberOfUnits) {
			this.numberOfUnits = _numberOfUnits == null ? null : _numberOfUnits;
			return this;
		}
		
		@RosettaAttribute("unitPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unitPrice")
		@Override
		public CollateralValuation.CollateralValuationBuilder setUnitPrice(NonNegativeMoney _unitPrice) {
			this.unitPrice = _unitPrice == null ? null : _unitPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("assetReference")
		@Override
		public CollateralValuation.CollateralValuationBuilder setAssetReference(AssetReference _assetReference) {
			this.assetReference = _assetReference == null ? null : _assetReference.toBuilder();
			return this;
		}
		
		@Override
		public CollateralValuation build() {
			return new CollateralValuation.CollateralValuationImpl(this);
		}
		
		@Override
		public CollateralValuation.CollateralValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValuation.CollateralValuationBuilder prune() {
			if (nominalAmount!=null && !nominalAmount.prune().hasData()) nominalAmount = null;
			if (relativePrice!=null && !relativePrice.prune().hasData()) relativePrice = null;
			if (accrualsAmount!=null && !accrualsAmount.prune().hasData()) accrualsAmount = null;
			if (unitPrice!=null && !unitPrice.prune().hasData()) unitPrice = null;
			if (assetReference!=null && !assetReference.prune().hasData()) assetReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNominalAmount()!=null && getNominalAmount().hasData()) return true;
			if (getQuantity()!=null) return true;
			if (getCleanPrice()!=null) return true;
			if (getAccruals()!=null) return true;
			if (getDirtyPrice()!=null) return true;
			if (getRelativePrice()!=null && getRelativePrice().hasData()) return true;
			if (getYieldToMaturity()!=null) return true;
			if (getInflationFactor()!=null) return true;
			if (getAllInPrice()!=null) return true;
			if (getAccrualsAmount()!=null && getAccrualsAmount().hasData()) return true;
			if (getNumberOfUnits()!=null) return true;
			if (getUnitPrice()!=null && getUnitPrice().hasData()) return true;
			if (getAssetReference()!=null && getAssetReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValuation.CollateralValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralValuation.CollateralValuationBuilder o = (CollateralValuation.CollateralValuationBuilder) other;
			
			merger.mergeRosetta(getNominalAmount(), o.getNominalAmount(), this::setNominalAmount);
			merger.mergeRosetta(getRelativePrice(), o.getRelativePrice(), this::setRelativePrice);
			merger.mergeRosetta(getAccrualsAmount(), o.getAccrualsAmount(), this::setAccrualsAmount);
			merger.mergeRosetta(getUnitPrice(), o.getUnitPrice(), this::setUnitPrice);
			merger.mergeRosetta(getAssetReference(), o.getAssetReference(), this::setAssetReference);
			
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeBasic(getCleanPrice(), o.getCleanPrice(), this::setCleanPrice);
			merger.mergeBasic(getAccruals(), o.getAccruals(), this::setAccruals);
			merger.mergeBasic(getDirtyPrice(), o.getDirtyPrice(), this::setDirtyPrice);
			merger.mergeBasic(getYieldToMaturity(), o.getYieldToMaturity(), this::setYieldToMaturity);
			merger.mergeBasic(getInflationFactor(), o.getInflationFactor(), this::setInflationFactor);
			merger.mergeBasic(getAllInPrice(), o.getAllInPrice(), this::setAllInPrice);
			merger.mergeBasic(getNumberOfUnits(), o.getNumberOfUnits(), this::setNumberOfUnits);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValuation _that = getType().cast(o);
		
			if (!Objects.equals(nominalAmount, _that.getNominalAmount())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(cleanPrice, _that.getCleanPrice())) return false;
			if (!Objects.equals(accruals, _that.getAccruals())) return false;
			if (!Objects.equals(dirtyPrice, _that.getDirtyPrice())) return false;
			if (!Objects.equals(relativePrice, _that.getRelativePrice())) return false;
			if (!Objects.equals(yieldToMaturity, _that.getYieldToMaturity())) return false;
			if (!Objects.equals(inflationFactor, _that.getInflationFactor())) return false;
			if (!Objects.equals(allInPrice, _that.getAllInPrice())) return false;
			if (!Objects.equals(accrualsAmount, _that.getAccrualsAmount())) return false;
			if (!Objects.equals(numberOfUnits, _that.getNumberOfUnits())) return false;
			if (!Objects.equals(unitPrice, _that.getUnitPrice())) return false;
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nominalAmount != null ? nominalAmount.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (cleanPrice != null ? cleanPrice.hashCode() : 0);
			_result = 31 * _result + (accruals != null ? accruals.hashCode() : 0);
			_result = 31 * _result + (dirtyPrice != null ? dirtyPrice.hashCode() : 0);
			_result = 31 * _result + (relativePrice != null ? relativePrice.hashCode() : 0);
			_result = 31 * _result + (yieldToMaturity != null ? yieldToMaturity.hashCode() : 0);
			_result = 31 * _result + (inflationFactor != null ? inflationFactor.hashCode() : 0);
			_result = 31 * _result + (allInPrice != null ? allInPrice.hashCode() : 0);
			_result = 31 * _result + (accrualsAmount != null ? accrualsAmount.hashCode() : 0);
			_result = 31 * _result + (numberOfUnits != null ? numberOfUnits.hashCode() : 0);
			_result = 31 * _result + (unitPrice != null ? unitPrice.hashCode() : 0);
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValuationBuilder {" +
				"nominalAmount=" + this.nominalAmount + ", " +
				"quantity=" + this.quantity + ", " +
				"cleanPrice=" + this.cleanPrice + ", " +
				"accruals=" + this.accruals + ", " +
				"dirtyPrice=" + this.dirtyPrice + ", " +
				"relativePrice=" + this.relativePrice + ", " +
				"yieldToMaturity=" + this.yieldToMaturity + ", " +
				"inflationFactor=" + this.inflationFactor + ", " +
				"allInPrice=" + this.allInPrice + ", " +
				"accrualsAmount=" + this.accrualsAmount + ", " +
				"numberOfUnits=" + this.numberOfUnits + ", " +
				"unitPrice=" + this.unitPrice + ", " +
				"assetReference=" + this.assetReference +
			'}';
		}
	}
}

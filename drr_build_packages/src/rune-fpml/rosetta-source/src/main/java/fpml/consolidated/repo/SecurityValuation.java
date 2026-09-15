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
import fpml.consolidated.asset.GenericSecurity;
import fpml.consolidated.asset.PriceQuoteUnits;
import fpml.consolidated.repo.meta.SecurityValuationMeta;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PositiveMoney;
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
@RosettaDataType(value="SecurityValuation", builder=SecurityValuation.SecurityValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SecurityValuation", model="fpml", builder=SecurityValuation.SecurityValuationBuilderImpl.class, version="2.1.1")
public interface SecurityValuation extends RosettaModelObject {

	SecurityValuationMeta metaData = new SecurityValuationMeta();

	/*********************** Getter Methods  ***********************/
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
	GenericSecurity getSecurity();
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
	 * Provision The price of each unit (security).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The price of each unit (security).
	 *
	 */
	NonNegativeMoney getUnitPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The optional units in which the price is expressed. If not supplied, this is assumed to be a price/value in currency units.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The optional units in which the price is expressed. If not supplied, this is assumed to be a price/value in currency units.
	 *
	 */
	PriceQuoteUnits getQuoteUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Market / Fair Value amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Market / Fair Value amount.
	 *
	 */
	PositiveMoney getValuationAmount();

	/*********************** Build Methods  ***********************/
	SecurityValuation build();
	
	SecurityValuation.SecurityValuationBuilder toBuilder();
	
	static SecurityValuation.SecurityValuationBuilder builder() {
		return new SecurityValuation.SecurityValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecurityValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecurityValuation> getType() {
		return SecurityValuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("security"), processor, GenericSecurity.class, getSecurity());
		processRosetta(path.newSubPath("nominalAmount"), processor, Money.class, getNominalAmount());
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processor.processBasic(path.newSubPath("cleanPrice"), BigDecimal.class, getCleanPrice(), this);
		processor.processBasic(path.newSubPath("accruals"), BigDecimal.class, getAccruals(), this);
		processor.processBasic(path.newSubPath("dirtyPrice"), BigDecimal.class, getDirtyPrice(), this);
		processRosetta(path.newSubPath("relativePrice"), processor, RelativePrice.class, getRelativePrice());
		processor.processBasic(path.newSubPath("yieldToMaturity"), BigDecimal.class, getYieldToMaturity(), this);
		processor.processBasic(path.newSubPath("inflationFactor"), BigDecimal.class, getInflationFactor(), this);
		processor.processBasic(path.newSubPath("allInPrice"), BigDecimal.class, getAllInPrice(), this);
		processRosetta(path.newSubPath("unitPrice"), processor, NonNegativeMoney.class, getUnitPrice());
		processRosetta(path.newSubPath("quoteUnits"), processor, PriceQuoteUnits.class, getQuoteUnits());
		processRosetta(path.newSubPath("valuationAmount"), processor, PositiveMoney.class, getValuationAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecurityValuationBuilder extends SecurityValuation, RosettaModelObjectBuilder {
		GenericSecurity.GenericSecurityBuilder getOrCreateSecurity();
		@Override
		GenericSecurity.GenericSecurityBuilder getSecurity();
		Money.MoneyBuilder getOrCreateNominalAmount();
		@Override
		Money.MoneyBuilder getNominalAmount();
		RelativePrice.RelativePriceBuilder getOrCreateRelativePrice();
		@Override
		RelativePrice.RelativePriceBuilder getRelativePrice();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateUnitPrice();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getUnitPrice();
		PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateQuoteUnits();
		@Override
		PriceQuoteUnits.PriceQuoteUnitsBuilder getQuoteUnits();
		PositiveMoney.PositiveMoneyBuilder getOrCreateValuationAmount();
		@Override
		PositiveMoney.PositiveMoneyBuilder getValuationAmount();
		SecurityValuation.SecurityValuationBuilder setSecurity(GenericSecurity security);
		SecurityValuation.SecurityValuationBuilder setNominalAmount(Money nominalAmount);
		SecurityValuation.SecurityValuationBuilder setQuantity(BigDecimal quantity);
		SecurityValuation.SecurityValuationBuilder setCleanPrice(BigDecimal cleanPrice);
		SecurityValuation.SecurityValuationBuilder setAccruals(BigDecimal accruals);
		SecurityValuation.SecurityValuationBuilder setDirtyPrice(BigDecimal dirtyPrice);
		SecurityValuation.SecurityValuationBuilder setRelativePrice(RelativePrice relativePrice);
		SecurityValuation.SecurityValuationBuilder setYieldToMaturity(BigDecimal yieldToMaturity);
		SecurityValuation.SecurityValuationBuilder setInflationFactor(BigDecimal inflationFactor);
		SecurityValuation.SecurityValuationBuilder setAllInPrice(BigDecimal allInPrice);
		SecurityValuation.SecurityValuationBuilder setUnitPrice(NonNegativeMoney unitPrice);
		SecurityValuation.SecurityValuationBuilder setQuoteUnits(PriceQuoteUnits quoteUnits);
		SecurityValuation.SecurityValuationBuilder setValuationAmount(PositiveMoney valuationAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("security"), processor, GenericSecurity.GenericSecurityBuilder.class, getSecurity());
			processRosetta(path.newSubPath("nominalAmount"), processor, Money.MoneyBuilder.class, getNominalAmount());
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processor.processBasic(path.newSubPath("cleanPrice"), BigDecimal.class, getCleanPrice(), this);
			processor.processBasic(path.newSubPath("accruals"), BigDecimal.class, getAccruals(), this);
			processor.processBasic(path.newSubPath("dirtyPrice"), BigDecimal.class, getDirtyPrice(), this);
			processRosetta(path.newSubPath("relativePrice"), processor, RelativePrice.RelativePriceBuilder.class, getRelativePrice());
			processor.processBasic(path.newSubPath("yieldToMaturity"), BigDecimal.class, getYieldToMaturity(), this);
			processor.processBasic(path.newSubPath("inflationFactor"), BigDecimal.class, getInflationFactor(), this);
			processor.processBasic(path.newSubPath("allInPrice"), BigDecimal.class, getAllInPrice(), this);
			processRosetta(path.newSubPath("unitPrice"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getUnitPrice());
			processRosetta(path.newSubPath("quoteUnits"), processor, PriceQuoteUnits.PriceQuoteUnitsBuilder.class, getQuoteUnits());
			processRosetta(path.newSubPath("valuationAmount"), processor, PositiveMoney.PositiveMoneyBuilder.class, getValuationAmount());
		}
		

		SecurityValuation.SecurityValuationBuilder prune();
	}

	/*********************** Immutable Implementation of SecurityValuation  ***********************/
	class SecurityValuationImpl implements SecurityValuation {
		private final GenericSecurity security;
		private final Money nominalAmount;
		private final BigDecimal quantity;
		private final BigDecimal cleanPrice;
		private final BigDecimal accruals;
		private final BigDecimal dirtyPrice;
		private final RelativePrice relativePrice;
		private final BigDecimal yieldToMaturity;
		private final BigDecimal inflationFactor;
		private final BigDecimal allInPrice;
		private final NonNegativeMoney unitPrice;
		private final PriceQuoteUnits quoteUnits;
		private final PositiveMoney valuationAmount;
		
		protected SecurityValuationImpl(SecurityValuation.SecurityValuationBuilder builder) {
			this.security = ofNullable(builder.getSecurity()).map(f->f.build()).orElse(null);
			this.nominalAmount = ofNullable(builder.getNominalAmount()).map(f->f.build()).orElse(null);
			this.quantity = builder.getQuantity();
			this.cleanPrice = builder.getCleanPrice();
			this.accruals = builder.getAccruals();
			this.dirtyPrice = builder.getDirtyPrice();
			this.relativePrice = ofNullable(builder.getRelativePrice()).map(f->f.build()).orElse(null);
			this.yieldToMaturity = builder.getYieldToMaturity();
			this.inflationFactor = builder.getInflationFactor();
			this.allInPrice = builder.getAllInPrice();
			this.unitPrice = ofNullable(builder.getUnitPrice()).map(f->f.build()).orElse(null);
			this.quoteUnits = ofNullable(builder.getQuoteUnits()).map(f->f.build()).orElse(null);
			this.valuationAmount = ofNullable(builder.getValuationAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("security")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("security")
		public GenericSecurity getSecurity() {
			return security;
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
		@RosettaAttribute("unitPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unitPrice")
		public NonNegativeMoney getUnitPrice() {
			return unitPrice;
		}
		
		@Override
		@RosettaAttribute("quoteUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quoteUnits")
		public PriceQuoteUnits getQuoteUnits() {
			return quoteUnits;
		}
		
		@Override
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationAmount")
		public PositiveMoney getValuationAmount() {
			return valuationAmount;
		}
		
		@Override
		public SecurityValuation build() {
			return this;
		}
		
		@Override
		public SecurityValuation.SecurityValuationBuilder toBuilder() {
			SecurityValuation.SecurityValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityValuation.SecurityValuationBuilder builder) {
			ofNullable(getSecurity()).ifPresent(builder::setSecurity);
			ofNullable(getNominalAmount()).ifPresent(builder::setNominalAmount);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getCleanPrice()).ifPresent(builder::setCleanPrice);
			ofNullable(getAccruals()).ifPresent(builder::setAccruals);
			ofNullable(getDirtyPrice()).ifPresent(builder::setDirtyPrice);
			ofNullable(getRelativePrice()).ifPresent(builder::setRelativePrice);
			ofNullable(getYieldToMaturity()).ifPresent(builder::setYieldToMaturity);
			ofNullable(getInflationFactor()).ifPresent(builder::setInflationFactor);
			ofNullable(getAllInPrice()).ifPresent(builder::setAllInPrice);
			ofNullable(getUnitPrice()).ifPresent(builder::setUnitPrice);
			ofNullable(getQuoteUnits()).ifPresent(builder::setQuoteUnits);
			ofNullable(getValuationAmount()).ifPresent(builder::setValuationAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityValuation _that = getType().cast(o);
		
			if (!Objects.equals(security, _that.getSecurity())) return false;
			if (!Objects.equals(nominalAmount, _that.getNominalAmount())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(cleanPrice, _that.getCleanPrice())) return false;
			if (!Objects.equals(accruals, _that.getAccruals())) return false;
			if (!Objects.equals(dirtyPrice, _that.getDirtyPrice())) return false;
			if (!Objects.equals(relativePrice, _that.getRelativePrice())) return false;
			if (!Objects.equals(yieldToMaturity, _that.getYieldToMaturity())) return false;
			if (!Objects.equals(inflationFactor, _that.getInflationFactor())) return false;
			if (!Objects.equals(allInPrice, _that.getAllInPrice())) return false;
			if (!Objects.equals(unitPrice, _that.getUnitPrice())) return false;
			if (!Objects.equals(quoteUnits, _that.getQuoteUnits())) return false;
			if (!Objects.equals(valuationAmount, _that.getValuationAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			_result = 31 * _result + (nominalAmount != null ? nominalAmount.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (cleanPrice != null ? cleanPrice.hashCode() : 0);
			_result = 31 * _result + (accruals != null ? accruals.hashCode() : 0);
			_result = 31 * _result + (dirtyPrice != null ? dirtyPrice.hashCode() : 0);
			_result = 31 * _result + (relativePrice != null ? relativePrice.hashCode() : 0);
			_result = 31 * _result + (yieldToMaturity != null ? yieldToMaturity.hashCode() : 0);
			_result = 31 * _result + (inflationFactor != null ? inflationFactor.hashCode() : 0);
			_result = 31 * _result + (allInPrice != null ? allInPrice.hashCode() : 0);
			_result = 31 * _result + (unitPrice != null ? unitPrice.hashCode() : 0);
			_result = 31 * _result + (quoteUnits != null ? quoteUnits.hashCode() : 0);
			_result = 31 * _result + (valuationAmount != null ? valuationAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityValuation {" +
				"security=" + this.security + ", " +
				"nominalAmount=" + this.nominalAmount + ", " +
				"quantity=" + this.quantity + ", " +
				"cleanPrice=" + this.cleanPrice + ", " +
				"accruals=" + this.accruals + ", " +
				"dirtyPrice=" + this.dirtyPrice + ", " +
				"relativePrice=" + this.relativePrice + ", " +
				"yieldToMaturity=" + this.yieldToMaturity + ", " +
				"inflationFactor=" + this.inflationFactor + ", " +
				"allInPrice=" + this.allInPrice + ", " +
				"unitPrice=" + this.unitPrice + ", " +
				"quoteUnits=" + this.quoteUnits + ", " +
				"valuationAmount=" + this.valuationAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of SecurityValuation  ***********************/
	class SecurityValuationBuilderImpl implements SecurityValuation.SecurityValuationBuilder {
	
		protected GenericSecurity.GenericSecurityBuilder security;
		protected Money.MoneyBuilder nominalAmount;
		protected BigDecimal quantity;
		protected BigDecimal cleanPrice;
		protected BigDecimal accruals;
		protected BigDecimal dirtyPrice;
		protected RelativePrice.RelativePriceBuilder relativePrice;
		protected BigDecimal yieldToMaturity;
		protected BigDecimal inflationFactor;
		protected BigDecimal allInPrice;
		protected NonNegativeMoney.NonNegativeMoneyBuilder unitPrice;
		protected PriceQuoteUnits.PriceQuoteUnitsBuilder quoteUnits;
		protected PositiveMoney.PositiveMoneyBuilder valuationAmount;
		
		@Override
		@RosettaAttribute("security")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("security")
		public GenericSecurity.GenericSecurityBuilder getSecurity() {
			return security;
		}
		
		@Override
		public GenericSecurity.GenericSecurityBuilder getOrCreateSecurity() {
			GenericSecurity.GenericSecurityBuilder result;
			if (security!=null) {
				result = security;
			}
			else {
				result = security = GenericSecurity.builder();
			}
			
			return result;
		}
		
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
		@RosettaAttribute("quoteUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quoteUnits")
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getQuoteUnits() {
			return quoteUnits;
		}
		
		@Override
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateQuoteUnits() {
			PriceQuoteUnits.PriceQuoteUnitsBuilder result;
			if (quoteUnits!=null) {
				result = quoteUnits;
			}
			else {
				result = quoteUnits = PriceQuoteUnits.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationAmount")
		public PositiveMoney.PositiveMoneyBuilder getValuationAmount() {
			return valuationAmount;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateValuationAmount() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (valuationAmount!=null) {
				result = valuationAmount;
			}
			else {
				result = valuationAmount = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("security")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("security")
		@Override
		public SecurityValuation.SecurityValuationBuilder setSecurity(GenericSecurity _security) {
			this.security = _security == null ? null : _security.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nominalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nominalAmount")
		@Override
		public SecurityValuation.SecurityValuationBuilder setNominalAmount(Money _nominalAmount) {
			this.nominalAmount = _nominalAmount == null ? null : _nominalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantity")
		@Override
		public SecurityValuation.SecurityValuationBuilder setQuantity(BigDecimal _quantity) {
			this.quantity = _quantity == null ? null : _quantity;
			return this;
		}
		
		@RosettaAttribute("cleanPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cleanPrice")
		@Override
		public SecurityValuation.SecurityValuationBuilder setCleanPrice(BigDecimal _cleanPrice) {
			this.cleanPrice = _cleanPrice == null ? null : _cleanPrice;
			return this;
		}
		
		@RosettaAttribute("accruals")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accruals")
		@Override
		public SecurityValuation.SecurityValuationBuilder setAccruals(BigDecimal _accruals) {
			this.accruals = _accruals == null ? null : _accruals;
			return this;
		}
		
		@RosettaAttribute("dirtyPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dirtyPrice")
		@Override
		public SecurityValuation.SecurityValuationBuilder setDirtyPrice(BigDecimal _dirtyPrice) {
			this.dirtyPrice = _dirtyPrice == null ? null : _dirtyPrice;
			return this;
		}
		
		@RosettaAttribute("relativePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativePrice")
		@Override
		public SecurityValuation.SecurityValuationBuilder setRelativePrice(RelativePrice _relativePrice) {
			this.relativePrice = _relativePrice == null ? null : _relativePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("yieldToMaturity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("yieldToMaturity")
		@Override
		public SecurityValuation.SecurityValuationBuilder setYieldToMaturity(BigDecimal _yieldToMaturity) {
			this.yieldToMaturity = _yieldToMaturity == null ? null : _yieldToMaturity;
			return this;
		}
		
		@RosettaAttribute("inflationFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inflationFactor")
		@Override
		public SecurityValuation.SecurityValuationBuilder setInflationFactor(BigDecimal _inflationFactor) {
			this.inflationFactor = _inflationFactor == null ? null : _inflationFactor;
			return this;
		}
		
		@RosettaAttribute("allInPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allInPrice")
		@Override
		public SecurityValuation.SecurityValuationBuilder setAllInPrice(BigDecimal _allInPrice) {
			this.allInPrice = _allInPrice == null ? null : _allInPrice;
			return this;
		}
		
		@RosettaAttribute("unitPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unitPrice")
		@Override
		public SecurityValuation.SecurityValuationBuilder setUnitPrice(NonNegativeMoney _unitPrice) {
			this.unitPrice = _unitPrice == null ? null : _unitPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quoteUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quoteUnits")
		@Override
		public SecurityValuation.SecurityValuationBuilder setQuoteUnits(PriceQuoteUnits _quoteUnits) {
			this.quoteUnits = _quoteUnits == null ? null : _quoteUnits.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationAmount")
		@Override
		public SecurityValuation.SecurityValuationBuilder setValuationAmount(PositiveMoney _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount.toBuilder();
			return this;
		}
		
		@Override
		public SecurityValuation build() {
			return new SecurityValuation.SecurityValuationImpl(this);
		}
		
		@Override
		public SecurityValuation.SecurityValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityValuation.SecurityValuationBuilder prune() {
			if (security!=null && !security.prune().hasData()) security = null;
			if (nominalAmount!=null && !nominalAmount.prune().hasData()) nominalAmount = null;
			if (relativePrice!=null && !relativePrice.prune().hasData()) relativePrice = null;
			if (unitPrice!=null && !unitPrice.prune().hasData()) unitPrice = null;
			if (quoteUnits!=null && !quoteUnits.prune().hasData()) quoteUnits = null;
			if (valuationAmount!=null && !valuationAmount.prune().hasData()) valuationAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSecurity()!=null && getSecurity().hasData()) return true;
			if (getNominalAmount()!=null && getNominalAmount().hasData()) return true;
			if (getQuantity()!=null) return true;
			if (getCleanPrice()!=null) return true;
			if (getAccruals()!=null) return true;
			if (getDirtyPrice()!=null) return true;
			if (getRelativePrice()!=null && getRelativePrice().hasData()) return true;
			if (getYieldToMaturity()!=null) return true;
			if (getInflationFactor()!=null) return true;
			if (getAllInPrice()!=null) return true;
			if (getUnitPrice()!=null && getUnitPrice().hasData()) return true;
			if (getQuoteUnits()!=null && getQuoteUnits().hasData()) return true;
			if (getValuationAmount()!=null && getValuationAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityValuation.SecurityValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityValuation.SecurityValuationBuilder o = (SecurityValuation.SecurityValuationBuilder) other;
			
			merger.mergeRosetta(getSecurity(), o.getSecurity(), this::setSecurity);
			merger.mergeRosetta(getNominalAmount(), o.getNominalAmount(), this::setNominalAmount);
			merger.mergeRosetta(getRelativePrice(), o.getRelativePrice(), this::setRelativePrice);
			merger.mergeRosetta(getUnitPrice(), o.getUnitPrice(), this::setUnitPrice);
			merger.mergeRosetta(getQuoteUnits(), o.getQuoteUnits(), this::setQuoteUnits);
			merger.mergeRosetta(getValuationAmount(), o.getValuationAmount(), this::setValuationAmount);
			
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeBasic(getCleanPrice(), o.getCleanPrice(), this::setCleanPrice);
			merger.mergeBasic(getAccruals(), o.getAccruals(), this::setAccruals);
			merger.mergeBasic(getDirtyPrice(), o.getDirtyPrice(), this::setDirtyPrice);
			merger.mergeBasic(getYieldToMaturity(), o.getYieldToMaturity(), this::setYieldToMaturity);
			merger.mergeBasic(getInflationFactor(), o.getInflationFactor(), this::setInflationFactor);
			merger.mergeBasic(getAllInPrice(), o.getAllInPrice(), this::setAllInPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityValuation _that = getType().cast(o);
		
			if (!Objects.equals(security, _that.getSecurity())) return false;
			if (!Objects.equals(nominalAmount, _that.getNominalAmount())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(cleanPrice, _that.getCleanPrice())) return false;
			if (!Objects.equals(accruals, _that.getAccruals())) return false;
			if (!Objects.equals(dirtyPrice, _that.getDirtyPrice())) return false;
			if (!Objects.equals(relativePrice, _that.getRelativePrice())) return false;
			if (!Objects.equals(yieldToMaturity, _that.getYieldToMaturity())) return false;
			if (!Objects.equals(inflationFactor, _that.getInflationFactor())) return false;
			if (!Objects.equals(allInPrice, _that.getAllInPrice())) return false;
			if (!Objects.equals(unitPrice, _that.getUnitPrice())) return false;
			if (!Objects.equals(quoteUnits, _that.getQuoteUnits())) return false;
			if (!Objects.equals(valuationAmount, _that.getValuationAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			_result = 31 * _result + (nominalAmount != null ? nominalAmount.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (cleanPrice != null ? cleanPrice.hashCode() : 0);
			_result = 31 * _result + (accruals != null ? accruals.hashCode() : 0);
			_result = 31 * _result + (dirtyPrice != null ? dirtyPrice.hashCode() : 0);
			_result = 31 * _result + (relativePrice != null ? relativePrice.hashCode() : 0);
			_result = 31 * _result + (yieldToMaturity != null ? yieldToMaturity.hashCode() : 0);
			_result = 31 * _result + (inflationFactor != null ? inflationFactor.hashCode() : 0);
			_result = 31 * _result + (allInPrice != null ? allInPrice.hashCode() : 0);
			_result = 31 * _result + (unitPrice != null ? unitPrice.hashCode() : 0);
			_result = 31 * _result + (quoteUnits != null ? quoteUnits.hashCode() : 0);
			_result = 31 * _result + (valuationAmount != null ? valuationAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityValuationBuilder {" +
				"security=" + this.security + ", " +
				"nominalAmount=" + this.nominalAmount + ", " +
				"quantity=" + this.quantity + ", " +
				"cleanPrice=" + this.cleanPrice + ", " +
				"accruals=" + this.accruals + ", " +
				"dirtyPrice=" + this.dirtyPrice + ", " +
				"relativePrice=" + this.relativePrice + ", " +
				"yieldToMaturity=" + this.yieldToMaturity + ", " +
				"inflationFactor=" + this.inflationFactor + ", " +
				"allInPrice=" + this.allInPrice + ", " +
				"unitPrice=" + this.unitPrice + ", " +
				"quoteUnits=" + this.quoteUnits + ", " +
				"valuationAmount=" + this.valuationAmount +
			'}';
		}
	}
}

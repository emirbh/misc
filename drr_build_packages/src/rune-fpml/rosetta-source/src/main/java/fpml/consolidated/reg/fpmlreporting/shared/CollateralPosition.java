package fpml.consolidated.reg.fpmlreporting.shared;

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
import fpml.consolidated.reg.fpmlreporting.shared.meta.CollateralPositionMeta;
import fpml.consolidated.repo.RelativePrice;
import fpml.consolidated.repo.SecurityValuation;
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
@RosettaDataType(value="CollateralPosition", builder=CollateralPosition.CollateralPositionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CollateralPosition", model="fpml", builder=CollateralPosition.CollateralPositionBuilderImpl.class, version="2.1.1")
public interface CollateralPosition extends SecurityValuation {

	CollateralPositionMeta metaData = new CollateralPositionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element defining an initial margin expressed as a ratio of the Market Value of the collateral to the Purchase Price. A default value of initial margin ratio of 1.00 means there is no margin and thus no risk related with the collateral. See GMRA 2000 paragraph 2(z) and GMRA 2011 paragraph 2(bb).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element defining an initial margin expressed as a ratio of the Market Value of the collateral to the Purchase Price. A default value of initial margin ratio of 1.00 means there is no margin and thus no risk related with the collateral. See GMRA 2000 paragraph 2(z) and GMRA 2011 paragraph 2(bb).
	 *
	 */
	BigDecimal getMarginRatio();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element defining a haircut expressed as the percentage difference between the Market Value of the collateral and the Purchase Price of the repo and calculated as 100 multiplied by a ratio of the difference between the Market Value of the collateral and the Purchase Price of the repo to the Market Value of the collateral. Haircut is alternative way to adjust the value of collateral sold in a repurchase agreement to initial margin ratio. Because an initial margin is a percentage of the Purchase Price, while a haircut is a percentage of the Market Value of collateral, the arithmetic of initial margins and haircuts is slightly different. For example, an initial margin of 102% is not equivalent to a haircut of 2%, but to 1.961% (ie 100/102%). See GMRA 2011 paragraph 2(aa).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element defining a haircut expressed as the percentage difference between the Market Value of the collateral and the Purchase Price of the repo and calculated as 100 multiplied by a ratio of the difference between the Market Value of the collateral and the Purchase Price of the repo to the Market Value of the collateral. Haircut is alternative way to adjust the value of collateral sold in a repurchase agreement to initial margin ratio. Because an initial margin is a percentage of the Purchase Price, while a haircut is a percentage of the Market Value of collateral, the arithmetic of initial margins and haircuts is slightly different. For example, an initial margin of 102% is not equivalent to a haircut of 2%, but to 1.961% (ie 100/102%). See GMRA 2011 paragraph 2(aa).
	 *
	 */
	BigDecimal getHaircut();

	/*********************** Build Methods  ***********************/
	CollateralPosition build();
	
	CollateralPosition.CollateralPositionBuilder toBuilder();
	
	static CollateralPosition.CollateralPositionBuilder builder() {
		return new CollateralPosition.CollateralPositionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralPosition> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralPosition> getType() {
		return CollateralPosition.class;
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
		processor.processBasic(path.newSubPath("marginRatio"), BigDecimal.class, getMarginRatio(), this);
		processor.processBasic(path.newSubPath("haircut"), BigDecimal.class, getHaircut(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralPositionBuilder extends CollateralPosition, SecurityValuation.SecurityValuationBuilder {
		@Override
		CollateralPosition.CollateralPositionBuilder setSecurity(GenericSecurity security);
		@Override
		CollateralPosition.CollateralPositionBuilder setNominalAmount(Money nominalAmount);
		@Override
		CollateralPosition.CollateralPositionBuilder setQuantity(BigDecimal quantity);
		@Override
		CollateralPosition.CollateralPositionBuilder setCleanPrice(BigDecimal cleanPrice);
		@Override
		CollateralPosition.CollateralPositionBuilder setAccruals(BigDecimal accruals);
		@Override
		CollateralPosition.CollateralPositionBuilder setDirtyPrice(BigDecimal dirtyPrice);
		@Override
		CollateralPosition.CollateralPositionBuilder setRelativePrice(RelativePrice relativePrice);
		@Override
		CollateralPosition.CollateralPositionBuilder setYieldToMaturity(BigDecimal yieldToMaturity);
		@Override
		CollateralPosition.CollateralPositionBuilder setInflationFactor(BigDecimal inflationFactor);
		@Override
		CollateralPosition.CollateralPositionBuilder setAllInPrice(BigDecimal allInPrice);
		@Override
		CollateralPosition.CollateralPositionBuilder setUnitPrice(NonNegativeMoney unitPrice);
		@Override
		CollateralPosition.CollateralPositionBuilder setQuoteUnits(PriceQuoteUnits quoteUnits);
		@Override
		CollateralPosition.CollateralPositionBuilder setValuationAmount(PositiveMoney valuationAmount);
		CollateralPosition.CollateralPositionBuilder setMarginRatio(BigDecimal marginRatio);
		CollateralPosition.CollateralPositionBuilder setHaircut(BigDecimal haircut);

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
			processor.processBasic(path.newSubPath("marginRatio"), BigDecimal.class, getMarginRatio(), this);
			processor.processBasic(path.newSubPath("haircut"), BigDecimal.class, getHaircut(), this);
		}
		

		CollateralPosition.CollateralPositionBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralPosition  ***********************/
	class CollateralPositionImpl extends SecurityValuation.SecurityValuationImpl implements CollateralPosition {
		private final BigDecimal marginRatio;
		private final BigDecimal haircut;
		
		protected CollateralPositionImpl(CollateralPosition.CollateralPositionBuilder builder) {
			super(builder);
			this.marginRatio = builder.getMarginRatio();
			this.haircut = builder.getHaircut();
		}
		
		@Override
		@RosettaAttribute("marginRatio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marginRatio")
		public BigDecimal getMarginRatio() {
			return marginRatio;
		}
		
		@Override
		@RosettaAttribute("haircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("haircut")
		public BigDecimal getHaircut() {
			return haircut;
		}
		
		@Override
		public CollateralPosition build() {
			return this;
		}
		
		@Override
		public CollateralPosition.CollateralPositionBuilder toBuilder() {
			CollateralPosition.CollateralPositionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralPosition.CollateralPositionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMarginRatio()).ifPresent(builder::setMarginRatio);
			ofNullable(getHaircut()).ifPresent(builder::setHaircut);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CollateralPosition _that = getType().cast(o);
		
			if (!Objects.equals(marginRatio, _that.getMarginRatio())) return false;
			if (!Objects.equals(haircut, _that.getHaircut())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (marginRatio != null ? marginRatio.hashCode() : 0);
			_result = 31 * _result + (haircut != null ? haircut.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPosition {" +
				"marginRatio=" + this.marginRatio + ", " +
				"haircut=" + this.haircut +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CollateralPosition  ***********************/
	class CollateralPositionBuilderImpl extends SecurityValuation.SecurityValuationBuilderImpl implements CollateralPosition.CollateralPositionBuilder {
	
		protected BigDecimal marginRatio;
		protected BigDecimal haircut;
		
		@Override
		@RosettaAttribute("marginRatio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marginRatio")
		public BigDecimal getMarginRatio() {
			return marginRatio;
		}
		
		@Override
		@RosettaAttribute("haircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("haircut")
		public BigDecimal getHaircut() {
			return haircut;
		}
		
		@RosettaAttribute("security")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("security")
		@Override
		public CollateralPosition.CollateralPositionBuilder setSecurity(GenericSecurity _security) {
			this.security = _security == null ? null : _security.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nominalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nominalAmount")
		@Override
		public CollateralPosition.CollateralPositionBuilder setNominalAmount(Money _nominalAmount) {
			this.nominalAmount = _nominalAmount == null ? null : _nominalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantity")
		@Override
		public CollateralPosition.CollateralPositionBuilder setQuantity(BigDecimal _quantity) {
			this.quantity = _quantity == null ? null : _quantity;
			return this;
		}
		
		@RosettaAttribute("cleanPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cleanPrice")
		@Override
		public CollateralPosition.CollateralPositionBuilder setCleanPrice(BigDecimal _cleanPrice) {
			this.cleanPrice = _cleanPrice == null ? null : _cleanPrice;
			return this;
		}
		
		@RosettaAttribute("accruals")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accruals")
		@Override
		public CollateralPosition.CollateralPositionBuilder setAccruals(BigDecimal _accruals) {
			this.accruals = _accruals == null ? null : _accruals;
			return this;
		}
		
		@RosettaAttribute("dirtyPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dirtyPrice")
		@Override
		public CollateralPosition.CollateralPositionBuilder setDirtyPrice(BigDecimal _dirtyPrice) {
			this.dirtyPrice = _dirtyPrice == null ? null : _dirtyPrice;
			return this;
		}
		
		@RosettaAttribute("relativePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativePrice")
		@Override
		public CollateralPosition.CollateralPositionBuilder setRelativePrice(RelativePrice _relativePrice) {
			this.relativePrice = _relativePrice == null ? null : _relativePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("yieldToMaturity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("yieldToMaturity")
		@Override
		public CollateralPosition.CollateralPositionBuilder setYieldToMaturity(BigDecimal _yieldToMaturity) {
			this.yieldToMaturity = _yieldToMaturity == null ? null : _yieldToMaturity;
			return this;
		}
		
		@RosettaAttribute("inflationFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inflationFactor")
		@Override
		public CollateralPosition.CollateralPositionBuilder setInflationFactor(BigDecimal _inflationFactor) {
			this.inflationFactor = _inflationFactor == null ? null : _inflationFactor;
			return this;
		}
		
		@RosettaAttribute("allInPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allInPrice")
		@Override
		public CollateralPosition.CollateralPositionBuilder setAllInPrice(BigDecimal _allInPrice) {
			this.allInPrice = _allInPrice == null ? null : _allInPrice;
			return this;
		}
		
		@RosettaAttribute("unitPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unitPrice")
		@Override
		public CollateralPosition.CollateralPositionBuilder setUnitPrice(NonNegativeMoney _unitPrice) {
			this.unitPrice = _unitPrice == null ? null : _unitPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quoteUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quoteUnits")
		@Override
		public CollateralPosition.CollateralPositionBuilder setQuoteUnits(PriceQuoteUnits _quoteUnits) {
			this.quoteUnits = _quoteUnits == null ? null : _quoteUnits.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationAmount")
		@Override
		public CollateralPosition.CollateralPositionBuilder setValuationAmount(PositiveMoney _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("marginRatio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marginRatio")
		@Override
		public CollateralPosition.CollateralPositionBuilder setMarginRatio(BigDecimal _marginRatio) {
			this.marginRatio = _marginRatio == null ? null : _marginRatio;
			return this;
		}
		
		@RosettaAttribute("haircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("haircut")
		@Override
		public CollateralPosition.CollateralPositionBuilder setHaircut(BigDecimal _haircut) {
			this.haircut = _haircut == null ? null : _haircut;
			return this;
		}
		
		@Override
		public CollateralPosition build() {
			return new CollateralPosition.CollateralPositionImpl(this);
		}
		
		@Override
		public CollateralPosition.CollateralPositionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPosition.CollateralPositionBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMarginRatio()!=null) return true;
			if (getHaircut()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPosition.CollateralPositionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CollateralPosition.CollateralPositionBuilder o = (CollateralPosition.CollateralPositionBuilder) other;
			
			
			merger.mergeBasic(getMarginRatio(), o.getMarginRatio(), this::setMarginRatio);
			merger.mergeBasic(getHaircut(), o.getHaircut(), this::setHaircut);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CollateralPosition _that = getType().cast(o);
		
			if (!Objects.equals(marginRatio, _that.getMarginRatio())) return false;
			if (!Objects.equals(haircut, _that.getHaircut())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (marginRatio != null ? marginRatio.hashCode() : 0);
			_result = 31 * _result + (haircut != null ? haircut.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPositionBuilder {" +
				"marginRatio=" + this.marginRatio + ", " +
				"haircut=" + this.haircut +
			'}' + " " + super.toString();
		}
	}
}

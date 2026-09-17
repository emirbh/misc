package fpml.consolidated.com;

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
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.meta.CommoditySpreadMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Money;
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
@RosettaDataType(value="CommoditySpread", builder=CommoditySpread.CommoditySpreadBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommoditySpread", model="fpml", builder=CommoditySpread.CommoditySpreadBuilderImpl.class, version="2.1.1")
public interface CommoditySpread extends Money {

	CommoditySpreadMeta metaData = new CommoditySpreadMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision spreadConversionFactor should be used when the unit of measure of the Commodity Reference Price and the unit of measure in which the spread is quoted are different. The value of spreadConversionFactor is the number of units of measure in which the spread is quoted per unit of measure of the Commodity Reference Price.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision spreadConversionFactor should be used when the unit of measure of the Commodity Reference Price and the unit of measure in which the spread is quoted are different. The value of spreadConversionFactor is the number of units of measure in which the spread is quoted per unit of measure of the Commodity Reference Price.
	 *
	 */
	BigDecimal getSpreadConversionFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision spreadUnit should be used when the unit of measure of the Commodity Reference Price and the unit of measure in which the spread is quoted are different. The value of spreadUnit is the unit of measure in which the spread is quoted.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision spreadUnit should be used when the unit of measure of the Commodity Reference Price and the unit of measure in which the spread is quoted are different. The value of spreadUnit is the unit of measure in which the spread is quoted.
	 *
	 */
	QuantityUnit getSpreadUnit();

	/*********************** Build Methods  ***********************/
	CommoditySpread build();
	
	CommoditySpread.CommoditySpreadBuilder toBuilder();
	
	static CommoditySpread.CommoditySpreadBuilder builder() {
		return new CommoditySpread.CommoditySpreadBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySpread> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommoditySpread> getType() {
		return CommoditySpread.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("spreadConversionFactor"), BigDecimal.class, getSpreadConversionFactor(), this);
		processRosetta(path.newSubPath("spreadUnit"), processor, QuantityUnit.class, getSpreadUnit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySpreadBuilder extends CommoditySpread, Money.MoneyBuilder {
		QuantityUnit.QuantityUnitBuilder getOrCreateSpreadUnit();
		@Override
		QuantityUnit.QuantityUnitBuilder getSpreadUnit();
		@Override
		CommoditySpread.CommoditySpreadBuilder setId(String id);
		@Override
		CommoditySpread.CommoditySpreadBuilder setCurrency(Currency currency);
		@Override
		CommoditySpread.CommoditySpreadBuilder setAmount(BigDecimal amount);
		CommoditySpread.CommoditySpreadBuilder setSpreadConversionFactor(BigDecimal spreadConversionFactor);
		CommoditySpread.CommoditySpreadBuilder setSpreadUnit(QuantityUnit spreadUnit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("spreadConversionFactor"), BigDecimal.class, getSpreadConversionFactor(), this);
			processRosetta(path.newSubPath("spreadUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getSpreadUnit());
		}
		

		CommoditySpread.CommoditySpreadBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySpread  ***********************/
	class CommoditySpreadImpl extends Money.MoneyImpl implements CommoditySpread {
		private final BigDecimal spreadConversionFactor;
		private final QuantityUnit spreadUnit;
		
		protected CommoditySpreadImpl(CommoditySpread.CommoditySpreadBuilder builder) {
			super(builder);
			this.spreadConversionFactor = builder.getSpreadConversionFactor();
			this.spreadUnit = ofNullable(builder.getSpreadUnit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("spreadConversionFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadConversionFactor")
		public BigDecimal getSpreadConversionFactor() {
			return spreadConversionFactor;
		}
		
		@Override
		@RosettaAttribute("spreadUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadUnit")
		public QuantityUnit getSpreadUnit() {
			return spreadUnit;
		}
		
		@Override
		public CommoditySpread build() {
			return this;
		}
		
		@Override
		public CommoditySpread.CommoditySpreadBuilder toBuilder() {
			CommoditySpread.CommoditySpreadBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySpread.CommoditySpreadBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSpreadConversionFactor()).ifPresent(builder::setSpreadConversionFactor);
			ofNullable(getSpreadUnit()).ifPresent(builder::setSpreadUnit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommoditySpread _that = getType().cast(o);
		
			if (!Objects.equals(spreadConversionFactor, _that.getSpreadConversionFactor())) return false;
			if (!Objects.equals(spreadUnit, _that.getSpreadUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (spreadConversionFactor != null ? spreadConversionFactor.hashCode() : 0);
			_result = 31 * _result + (spreadUnit != null ? spreadUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySpread {" +
				"spreadConversionFactor=" + this.spreadConversionFactor + ", " +
				"spreadUnit=" + this.spreadUnit +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommoditySpread  ***********************/
	class CommoditySpreadBuilderImpl extends Money.MoneyBuilderImpl implements CommoditySpread.CommoditySpreadBuilder {
	
		protected BigDecimal spreadConversionFactor;
		protected QuantityUnit.QuantityUnitBuilder spreadUnit;
		
		@Override
		@RosettaAttribute("spreadConversionFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadConversionFactor")
		public BigDecimal getSpreadConversionFactor() {
			return spreadConversionFactor;
		}
		
		@Override
		@RosettaAttribute("spreadUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadUnit")
		public QuantityUnit.QuantityUnitBuilder getSpreadUnit() {
			return spreadUnit;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder getOrCreateSpreadUnit() {
			QuantityUnit.QuantityUnitBuilder result;
			if (spreadUnit!=null) {
				result = spreadUnit;
			}
			else {
				result = spreadUnit = QuantityUnit.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommoditySpread.CommoditySpreadBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public CommoditySpread.CommoditySpreadBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public CommoditySpread.CommoditySpreadBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("spreadConversionFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadConversionFactor")
		@Override
		public CommoditySpread.CommoditySpreadBuilder setSpreadConversionFactor(BigDecimal _spreadConversionFactor) {
			this.spreadConversionFactor = _spreadConversionFactor == null ? null : _spreadConversionFactor;
			return this;
		}
		
		@RosettaAttribute("spreadUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadUnit")
		@Override
		public CommoditySpread.CommoditySpreadBuilder setSpreadUnit(QuantityUnit _spreadUnit) {
			this.spreadUnit = _spreadUnit == null ? null : _spreadUnit.toBuilder();
			return this;
		}
		
		@Override
		public CommoditySpread build() {
			return new CommoditySpread.CommoditySpreadImpl(this);
		}
		
		@Override
		public CommoditySpread.CommoditySpreadBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySpread.CommoditySpreadBuilder prune() {
			super.prune();
			if (spreadUnit!=null && !spreadUnit.prune().hasData()) spreadUnit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSpreadConversionFactor()!=null) return true;
			if (getSpreadUnit()!=null && getSpreadUnit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySpread.CommoditySpreadBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommoditySpread.CommoditySpreadBuilder o = (CommoditySpread.CommoditySpreadBuilder) other;
			
			merger.mergeRosetta(getSpreadUnit(), o.getSpreadUnit(), this::setSpreadUnit);
			
			merger.mergeBasic(getSpreadConversionFactor(), o.getSpreadConversionFactor(), this::setSpreadConversionFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommoditySpread _that = getType().cast(o);
		
			if (!Objects.equals(spreadConversionFactor, _that.getSpreadConversionFactor())) return false;
			if (!Objects.equals(spreadUnit, _that.getSpreadUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (spreadConversionFactor != null ? spreadConversionFactor.hashCode() : 0);
			_result = 31 * _result + (spreadUnit != null ? spreadUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySpreadBuilder {" +
				"spreadConversionFactor=" + this.spreadConversionFactor + ", " +
				"spreadUnit=" + this.spreadUnit +
			'}' + " " + super.toString();
		}
	}
}

package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.CashflowNotionalMeta;
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
 * Provision The notional/principal value/quantity/volume used to compute the cashflow.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The notional/principal value/quantity/volume used to compute the cashflow.
 *
 */
@RosettaDataType(value="CashflowNotional", builder=CashflowNotional.CashflowNotionalBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CashflowNotional", model="fpml", builder=CashflowNotional.CashflowNotionalBuilderImpl.class, version="2.1.1")
public interface CashflowNotional extends RosettaModelObject {

	CashflowNotionalMeta metaData = new CashflowNotionalMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 */
	Currency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The units in which an amount (not monetary) is denominated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The units in which an amount (not monetary) is denominated.
	 *
	 */
	String getUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The quantity of notional (in currency or other units).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The quantity of notional (in currency or other units).
	 *
	 */
	BigDecimal getAmount();

	/*********************** Build Methods  ***********************/
	CashflowNotional build();
	
	CashflowNotional.CashflowNotionalBuilder toBuilder();
	
	static CashflowNotional.CashflowNotionalBuilder builder() {
		return new CashflowNotional.CashflowNotionalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashflowNotional> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CashflowNotional> getType() {
		return CashflowNotional.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("units"), String.class, getUnits(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashflowNotionalBuilder extends CashflowNotional, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		CashflowNotional.CashflowNotionalBuilder setId(String id);
		CashflowNotional.CashflowNotionalBuilder setCurrency(Currency currency);
		CashflowNotional.CashflowNotionalBuilder setUnits(String units);
		CashflowNotional.CashflowNotionalBuilder setAmount(BigDecimal amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("units"), String.class, getUnits(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		}
		

		CashflowNotional.CashflowNotionalBuilder prune();
	}

	/*********************** Immutable Implementation of CashflowNotional  ***********************/
	class CashflowNotionalImpl implements CashflowNotional {
		private final String id;
		private final Currency currency;
		private final String units;
		private final BigDecimal amount;
		
		protected CashflowNotionalImpl(CashflowNotional.CashflowNotionalBuilder builder) {
			this.id = builder.getId();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.units = builder.getUnits();
			this.amount = builder.getAmount();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("units")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("units")
		public String getUnits() {
			return units;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		public CashflowNotional build() {
			return this;
		}
		
		@Override
		public CashflowNotional.CashflowNotionalBuilder toBuilder() {
			CashflowNotional.CashflowNotionalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashflowNotional.CashflowNotionalBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getUnits()).ifPresent(builder::setUnits);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashflowNotional _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(units, _that.getUnits())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (units != null ? units.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowNotional {" +
				"id=" + this.id + ", " +
				"currency=" + this.currency + ", " +
				"units=" + this.units + ", " +
				"amount=" + this.amount +
			'}';
		}
	}

	/*********************** Builder Implementation of CashflowNotional  ***********************/
	class CashflowNotionalBuilderImpl implements CashflowNotional.CashflowNotionalBuilder {
	
		protected String id;
		protected Currency.CurrencyBuilder currency;
		protected String units;
		protected BigDecimal amount;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("units")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("units")
		public String getUnits() {
			return units;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CashflowNotional.CashflowNotionalBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public CashflowNotional.CashflowNotionalBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("units")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("units")
		@Override
		public CashflowNotional.CashflowNotionalBuilder setUnits(String _units) {
			this.units = _units == null ? null : _units;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public CashflowNotional.CashflowNotionalBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@Override
		public CashflowNotional build() {
			return new CashflowNotional.CashflowNotionalImpl(this);
		}
		
		@Override
		public CashflowNotional.CashflowNotionalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashflowNotional.CashflowNotionalBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getUnits()!=null) return true;
			if (getAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashflowNotional.CashflowNotionalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashflowNotional.CashflowNotionalBuilder o = (CashflowNotional.CashflowNotionalBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getUnits(), o.getUnits(), this::setUnits);
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashflowNotional _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(units, _that.getUnits())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (units != null ? units.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowNotionalBuilder {" +
				"id=" + this.id + ", " +
				"currency=" + this.currency + ", " +
				"units=" + this.units + ", " +
				"amount=" + this.amount +
			'}';
		}
	}
}

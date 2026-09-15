package fpml.consolidated.asset;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.asset.meta.ActualPriceMeta;
import fpml.consolidated.fpmlenum.PriceExpressionEnum;
import fpml.consolidated.shared.Currency;
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
@RosettaDataType(value="ActualPrice", builder=ActualPrice.ActualPriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ActualPrice", model="fpml", builder=ActualPrice.ActualPriceBuilderImpl.class, version="2.1.1")
public interface ActualPrice extends RosettaModelObject {

	ActualPriceMeta metaData = new ActualPriceMeta();

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
	 * Provision Specifies the currency associated with the net price. This element is not present if the price is expressed in percentage terms (as specified through the priceExpression element).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the currency associated with the net price. This element is not present if the price is expressed in percentage terms (as specified through the priceExpression element).
	 *
	 */
	Currency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the net price amount. In the case of a fixed income security or a convertible bond, this price includes the accrued interests.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the net price amount. In the case of a fixed income security or a convertible bond, this price includes the accrued interests.
	 *
	 */
	BigDecimal getAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the price is expressed in absolute or relative terms.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the price is expressed in absolute or relative terms.
	 *
	 */
	PriceExpressionEnum getPriceExpression();

	/*********************** Build Methods  ***********************/
	ActualPrice build();
	
	ActualPrice.ActualPriceBuilder toBuilder();
	
	static ActualPrice.ActualPriceBuilder builder() {
		return new ActualPrice.ActualPriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ActualPrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ActualPrice> getType() {
		return ActualPrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("priceExpression"), PriceExpressionEnum.class, getPriceExpression(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ActualPriceBuilder extends ActualPrice, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		ActualPrice.ActualPriceBuilder setId(String id);
		ActualPrice.ActualPriceBuilder setCurrency(Currency currency);
		ActualPrice.ActualPriceBuilder setAmount(BigDecimal amount);
		ActualPrice.ActualPriceBuilder setPriceExpression(PriceExpressionEnum priceExpression);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("priceExpression"), PriceExpressionEnum.class, getPriceExpression(), this);
		}
		

		ActualPrice.ActualPriceBuilder prune();
	}

	/*********************** Immutable Implementation of ActualPrice  ***********************/
	class ActualPriceImpl implements ActualPrice {
		private final String id;
		private final Currency currency;
		private final BigDecimal amount;
		private final PriceExpressionEnum priceExpression;
		
		protected ActualPriceImpl(ActualPrice.ActualPriceBuilder builder) {
			this.id = builder.getId();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.amount = builder.getAmount();
			this.priceExpression = builder.getPriceExpression();
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
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("priceExpression")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceExpression")
		public PriceExpressionEnum getPriceExpression() {
			return priceExpression;
		}
		
		@Override
		public ActualPrice build() {
			return this;
		}
		
		@Override
		public ActualPrice.ActualPriceBuilder toBuilder() {
			ActualPrice.ActualPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ActualPrice.ActualPriceBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getPriceExpression()).ifPresent(builder::setPriceExpression);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActualPrice _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(priceExpression, _that.getPriceExpression())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (priceExpression != null ? priceExpression.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActualPrice {" +
				"id=" + this.id + ", " +
				"currency=" + this.currency + ", " +
				"amount=" + this.amount + ", " +
				"priceExpression=" + this.priceExpression +
			'}';
		}
	}

	/*********************** Builder Implementation of ActualPrice  ***********************/
	class ActualPriceBuilderImpl implements ActualPrice.ActualPriceBuilder {
	
		protected String id;
		protected Currency.CurrencyBuilder currency;
		protected BigDecimal amount;
		protected PriceExpressionEnum priceExpression;
		
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
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("priceExpression")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceExpression")
		public PriceExpressionEnum getPriceExpression() {
			return priceExpression;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ActualPrice.ActualPriceBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public ActualPrice.ActualPriceBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amount")
		@Override
		public ActualPrice.ActualPriceBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("priceExpression")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceExpression")
		@Override
		public ActualPrice.ActualPriceBuilder setPriceExpression(PriceExpressionEnum _priceExpression) {
			this.priceExpression = _priceExpression == null ? null : _priceExpression;
			return this;
		}
		
		@Override
		public ActualPrice build() {
			return new ActualPrice.ActualPriceImpl(this);
		}
		
		@Override
		public ActualPrice.ActualPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActualPrice.ActualPriceBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getAmount()!=null) return true;
			if (getPriceExpression()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActualPrice.ActualPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ActualPrice.ActualPriceBuilder o = (ActualPrice.ActualPriceBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeBasic(getPriceExpression(), o.getPriceExpression(), this::setPriceExpression);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActualPrice _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(priceExpression, _that.getPriceExpression())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (priceExpression != null ? priceExpression.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActualPriceBuilder {" +
				"id=" + this.id + ", " +
				"currency=" + this.currency + ", " +
				"amount=" + this.amount + ", " +
				"priceExpression=" + this.priceExpression +
			'}';
		}
	}
}

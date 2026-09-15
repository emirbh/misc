package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.EquityStrikeMeta;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
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
 * Provision A type for defining the strike price for an equity option. The strike price is either: (i) in respect of an index option transaction, the level of the relevant index specified or otherwise determined in the transaction; or (ii) in respect of a share option transaction, the price per share specified or otherwise determined in the transaction. This can be expressed either as a percentage of notional amount or as an absolute value.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining the strike price for an equity option. The strike price is either: (i) in respect of an index option transaction, the level of the relevant index specified or otherwise determined in the transaction; or (ii) in respect of a share option transaction, the price per share specified or otherwise determined in the transaction. This can be expressed either as a percentage of notional amount or as an absolute value.
 *
 */
@RosettaDataType(value="EquityStrike", builder=EquityStrike.EquityStrikeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityStrike", model="fpml", builder=EquityStrike.EquityStrikeBuilderImpl.class, version="2.1.1")
public interface EquityStrike extends RosettaModelObject {

	EquityStrikeMeta metaData = new EquityStrikeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The price or level at which the option has been struck.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The price or level at which the option has been struck.
	 *
	 */
	BigDecimal getStrikePrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The price or level expressed as a percentage of the forward starting spot price. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The price or level expressed as a percentage of the forward starting spot price. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getStrikePercentage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the strike is determined, where this is not the effective date of a forward starting option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the strike is determined, where this is not the effective date of a forward starting option.
	 *
	 */
	AdjustableOrRelativeDate getStrikeDeterminationDate();
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

	/*********************** Build Methods  ***********************/
	EquityStrike build();
	
	EquityStrike.EquityStrikeBuilder toBuilder();
	
	static EquityStrike.EquityStrikeBuilder builder() {
		return new EquityStrike.EquityStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityStrike> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityStrike> getType() {
		return EquityStrike.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
		processor.processBasic(path.newSubPath("strikePercentage"), BigDecimal.class, getStrikePercentage(), this);
		processRosetta(path.newSubPath("strikeDeterminationDate"), processor, AdjustableOrRelativeDate.class, getStrikeDeterminationDate());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityStrikeBuilder extends EquityStrike, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStrikeDeterminationDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStrikeDeterminationDate();
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		EquityStrike.EquityStrikeBuilder setStrikePrice(BigDecimal strikePrice);
		EquityStrike.EquityStrikeBuilder setStrikePercentage(BigDecimal strikePercentage);
		EquityStrike.EquityStrikeBuilder setStrikeDeterminationDate(AdjustableOrRelativeDate strikeDeterminationDate);
		EquityStrike.EquityStrikeBuilder setCurrency(Currency currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
			processor.processBasic(path.newSubPath("strikePercentage"), BigDecimal.class, getStrikePercentage(), this);
			processRosetta(path.newSubPath("strikeDeterminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getStrikeDeterminationDate());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
		}
		

		EquityStrike.EquityStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of EquityStrike  ***********************/
	class EquityStrikeImpl implements EquityStrike {
		private final BigDecimal strikePrice;
		private final BigDecimal strikePercentage;
		private final AdjustableOrRelativeDate strikeDeterminationDate;
		private final Currency currency;
		
		protected EquityStrikeImpl(EquityStrike.EquityStrikeBuilder builder) {
			this.strikePrice = builder.getStrikePrice();
			this.strikePercentage = builder.getStrikePercentage();
			this.strikeDeterminationDate = ofNullable(builder.getStrikeDeterminationDate()).map(f->f.build()).orElse(null);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePrice")
		public BigDecimal getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		@RosettaAttribute("strikePercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePercentage")
		public BigDecimal getStrikePercentage() {
			return strikePercentage;
		}
		
		@Override
		@RosettaAttribute("strikeDeterminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeDeterminationDate")
		public AdjustableOrRelativeDate getStrikeDeterminationDate() {
			return strikeDeterminationDate;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		public EquityStrike build() {
			return this;
		}
		
		@Override
		public EquityStrike.EquityStrikeBuilder toBuilder() {
			EquityStrike.EquityStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityStrike.EquityStrikeBuilder builder) {
			ofNullable(getStrikePrice()).ifPresent(builder::setStrikePrice);
			ofNullable(getStrikePercentage()).ifPresent(builder::setStrikePercentage);
			ofNullable(getStrikeDeterminationDate()).ifPresent(builder::setStrikeDeterminationDate);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityStrike _that = getType().cast(o);
		
			if (!Objects.equals(strikePrice, _that.getStrikePrice())) return false;
			if (!Objects.equals(strikePercentage, _that.getStrikePercentage())) return false;
			if (!Objects.equals(strikeDeterminationDate, _that.getStrikeDeterminationDate())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (strikePercentage != null ? strikePercentage.hashCode() : 0);
			_result = 31 * _result + (strikeDeterminationDate != null ? strikeDeterminationDate.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityStrike {" +
				"strikePrice=" + this.strikePrice + ", " +
				"strikePercentage=" + this.strikePercentage + ", " +
				"strikeDeterminationDate=" + this.strikeDeterminationDate + ", " +
				"currency=" + this.currency +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityStrike  ***********************/
	class EquityStrikeBuilderImpl implements EquityStrike.EquityStrikeBuilder {
	
		protected BigDecimal strikePrice;
		protected BigDecimal strikePercentage;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder strikeDeterminationDate;
		protected Currency.CurrencyBuilder currency;
		
		@Override
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePrice")
		public BigDecimal getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		@RosettaAttribute("strikePercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePercentage")
		public BigDecimal getStrikePercentage() {
			return strikePercentage;
		}
		
		@Override
		@RosettaAttribute("strikeDeterminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeDeterminationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStrikeDeterminationDate() {
			return strikeDeterminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStrikeDeterminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (strikeDeterminationDate!=null) {
				result = strikeDeterminationDate;
			}
			else {
				result = strikeDeterminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
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
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePrice")
		@Override
		public EquityStrike.EquityStrikeBuilder setStrikePrice(BigDecimal _strikePrice) {
			this.strikePrice = _strikePrice == null ? null : _strikePrice;
			return this;
		}
		
		@RosettaAttribute("strikePercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePercentage")
		@Override
		public EquityStrike.EquityStrikeBuilder setStrikePercentage(BigDecimal _strikePercentage) {
			this.strikePercentage = _strikePercentage == null ? null : _strikePercentage;
			return this;
		}
		
		@RosettaAttribute("strikeDeterminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeDeterminationDate")
		@Override
		public EquityStrike.EquityStrikeBuilder setStrikeDeterminationDate(AdjustableOrRelativeDate _strikeDeterminationDate) {
			this.strikeDeterminationDate = _strikeDeterminationDate == null ? null : _strikeDeterminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public EquityStrike.EquityStrikeBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@Override
		public EquityStrike build() {
			return new EquityStrike.EquityStrikeImpl(this);
		}
		
		@Override
		public EquityStrike.EquityStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityStrike.EquityStrikeBuilder prune() {
			if (strikeDeterminationDate!=null && !strikeDeterminationDate.prune().hasData()) strikeDeterminationDate = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrikePrice()!=null) return true;
			if (getStrikePercentage()!=null) return true;
			if (getStrikeDeterminationDate()!=null && getStrikeDeterminationDate().hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityStrike.EquityStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityStrike.EquityStrikeBuilder o = (EquityStrike.EquityStrikeBuilder) other;
			
			merger.mergeRosetta(getStrikeDeterminationDate(), o.getStrikeDeterminationDate(), this::setStrikeDeterminationDate);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getStrikePrice(), o.getStrikePrice(), this::setStrikePrice);
			merger.mergeBasic(getStrikePercentage(), o.getStrikePercentage(), this::setStrikePercentage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityStrike _that = getType().cast(o);
		
			if (!Objects.equals(strikePrice, _that.getStrikePrice())) return false;
			if (!Objects.equals(strikePercentage, _that.getStrikePercentage())) return false;
			if (!Objects.equals(strikeDeterminationDate, _that.getStrikeDeterminationDate())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (strikePercentage != null ? strikePercentage.hashCode() : 0);
			_result = 31 * _result + (strikeDeterminationDate != null ? strikeDeterminationDate.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityStrikeBuilder {" +
				"strikePrice=" + this.strikePrice + ", " +
				"strikePercentage=" + this.strikePercentage + ", " +
				"strikeDeterminationDate=" + this.strikeDeterminationDate + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
}

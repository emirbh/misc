package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LcAccrualMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A full definition of the accrual characteristics of a letter of credit. This structure defines both the underlying letter of credit issuance fee rate as well as any FX rates applied.
 *
 */
@RosettaDataType(value="LcAccrual", builder=LcAccrual.LcAccrualBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LcAccrual", model="fpml", builder=LcAccrual.LcAccrualBuilderImpl.class, version="2.1.1")
public interface LcAccrual extends FeeRateOptionBase {

	LcAccrualMeta metaData = new LcAccrualMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which the letter of credit accrual is denominated. This field should ONLY be populated when the accrual currency is different to the base letter of credit currency.
	 *
	 */
	Currency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines exchange rate between the letter of credit accrual and letter of credit currencies.
	 *
	 */
	FxTerms getLcFxRate();

	/*********************** Build Methods  ***********************/
	LcAccrual build();
	
	LcAccrual.LcAccrualBuilder toBuilder();
	
	static LcAccrual.LcAccrualBuilder builder() {
		return new LcAccrual.LcAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcAccrual> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LcAccrual> getType() {
		return LcAccrual.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("lcFxRate"), processor, FxTerms.class, getLcFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcAccrualBuilder extends LcAccrual, FeeRateOptionBase.FeeRateOptionBaseBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		FxTerms.FxTermsBuilder getOrCreateLcFxRate();
		@Override
		FxTerms.FxTermsBuilder getLcFxRate();
		@Override
		LcAccrual.LcAccrualBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		@Override
		LcAccrual.LcAccrualBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		@Override
		LcAccrual.LcAccrualBuilder setPaymentFrequency(Period paymentFrequency);
		@Override
		LcAccrual.LcAccrualBuilder setRate(BigDecimal rate);
		LcAccrual.LcAccrualBuilder setCurrency(Currency currency);
		LcAccrual.LcAccrualBuilder setLcFxRate(FxTerms lcFxRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("lcFxRate"), processor, FxTerms.FxTermsBuilder.class, getLcFxRate());
		}
		

		LcAccrual.LcAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of LcAccrual  ***********************/
	class LcAccrualImpl extends FeeRateOptionBase.FeeRateOptionBaseImpl implements LcAccrual {
		private final Currency currency;
		private final FxTerms lcFxRate;
		
		protected LcAccrualImpl(LcAccrual.LcAccrualBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.lcFxRate = ofNullable(builder.getLcFxRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("lcFxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcFxRate")
		public FxTerms getLcFxRate() {
			return lcFxRate;
		}
		
		@Override
		public LcAccrual build() {
			return this;
		}
		
		@Override
		public LcAccrual.LcAccrualBuilder toBuilder() {
			LcAccrual.LcAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcAccrual.LcAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getLcFxRate()).ifPresent(builder::setLcFxRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcAccrual _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(lcFxRate, _that.getLcFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (lcFxRate != null ? lcFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcAccrual {" +
				"currency=" + this.currency + ", " +
				"lcFxRate=" + this.lcFxRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcAccrual  ***********************/
	class LcAccrualBuilderImpl extends FeeRateOptionBase.FeeRateOptionBaseBuilderImpl implements LcAccrual.LcAccrualBuilder {
	
		protected Currency.CurrencyBuilder currency;
		protected FxTerms.FxTermsBuilder lcFxRate;
		
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
		@RosettaAttribute("lcFxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcFxRate")
		public FxTerms.FxTermsBuilder getLcFxRate() {
			return lcFxRate;
		}
		
		@Override
		public FxTerms.FxTermsBuilder getOrCreateLcFxRate() {
			FxTerms.FxTermsBuilder result;
			if (lcFxRate!=null) {
				result = lcFxRate;
			}
			else {
				result = lcFxRate = FxTerms.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		@Override
		public LcAccrual.LcAccrualBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public LcAccrual.LcAccrualBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public LcAccrual.LcAccrualBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public LcAccrual.LcAccrualBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public LcAccrual.LcAccrualBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcFxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lcFxRate")
		@Override
		public LcAccrual.LcAccrualBuilder setLcFxRate(FxTerms _lcFxRate) {
			this.lcFxRate = _lcFxRate == null ? null : _lcFxRate.toBuilder();
			return this;
		}
		
		@Override
		public LcAccrual build() {
			return new LcAccrual.LcAccrualImpl(this);
		}
		
		@Override
		public LcAccrual.LcAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcAccrual.LcAccrualBuilder prune() {
			super.prune();
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (lcFxRate!=null && !lcFxRate.prune().hasData()) lcFxRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getLcFxRate()!=null && getLcFxRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcAccrual.LcAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LcAccrual.LcAccrualBuilder o = (LcAccrual.LcAccrualBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getLcFxRate(), o.getLcFxRate(), this::setLcFxRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcAccrual _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(lcFxRate, _that.getLcFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (lcFxRate != null ? lcFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcAccrualBuilder {" +
				"currency=" + this.currency + ", " +
				"lcFxRate=" + this.lcFxRate +
			'}' + " " + super.toString();
		}
	}
}

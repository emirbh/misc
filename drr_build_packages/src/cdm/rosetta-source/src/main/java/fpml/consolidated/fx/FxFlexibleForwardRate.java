package fpml.consolidated.fx;

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
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.meta.FxFlexibleForwardRateMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.QuotedCurrencyPair;
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
@RosettaDataType(value="FxFlexibleForwardRate", builder=FxFlexibleForwardRate.FxFlexibleForwardRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxFlexibleForwardRate", model="fpml", builder=FxFlexibleForwardRate.FxFlexibleForwardRateBuilderImpl.class, version="2.1.1")
public interface FxFlexibleForwardRate extends QuotedCurrencyPair {

	FxFlexibleForwardRateMeta metaData = new FxFlexibleForwardRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Constant rate value, applicable for the duration of the execution period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Constant rate value, applicable for the duration of the execution period.
	 *
	 */
	BigDecimal getRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The spot exchange rate for the specified currency pair as per the specified quote basis, as at the trade date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The spot exchange rate for the specified currency pair as per the specified quote basis, as at the trade date.
	 *
	 */
	BigDecimal getSpotRate();

	/*********************** Build Methods  ***********************/
	FxFlexibleForwardRate build();
	
	FxFlexibleForwardRate.FxFlexibleForwardRateBuilder toBuilder();
	
	static FxFlexibleForwardRate.FxFlexibleForwardRateBuilder builder() {
		return new FxFlexibleForwardRate.FxFlexibleForwardRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFlexibleForwardRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxFlexibleForwardRate> getType() {
		return FxFlexibleForwardRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency1"), processor, Currency.class, getCurrency1());
		processRosetta(path.newSubPath("currency2"), processor, Currency.class, getCurrency2());
		processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFlexibleForwardRateBuilder extends FxFlexibleForwardRate, QuotedCurrencyPair.QuotedCurrencyPairBuilder {
		@Override
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setCurrency1(Currency currency1);
		@Override
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setCurrency2(Currency currency2);
		@Override
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setQuoteBasis(QuoteBasisEnum quoteBasis);
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setRate(BigDecimal rate);
		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setSpotRate(BigDecimal spotRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency1"), processor, Currency.CurrencyBuilder.class, getCurrency1());
			processRosetta(path.newSubPath("currency2"), processor, Currency.CurrencyBuilder.class, getCurrency2());
			processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		}
		

		FxFlexibleForwardRate.FxFlexibleForwardRateBuilder prune();
	}

	/*********************** Immutable Implementation of FxFlexibleForwardRate  ***********************/
	class FxFlexibleForwardRateImpl extends QuotedCurrencyPair.QuotedCurrencyPairImpl implements FxFlexibleForwardRate {
		private final BigDecimal rate;
		private final BigDecimal spotRate;
		
		protected FxFlexibleForwardRateImpl(FxFlexibleForwardRate.FxFlexibleForwardRateBuilder builder) {
			super(builder);
			this.rate = builder.getRate();
			this.spotRate = builder.getSpotRate();
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		public FxFlexibleForwardRate build() {
			return this;
		}
		
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder toBuilder() {
			FxFlexibleForwardRate.FxFlexibleForwardRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFlexibleForwardRate.FxFlexibleForwardRateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFlexibleForwardRate _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForwardRate {" +
				"rate=" + this.rate + ", " +
				"spotRate=" + this.spotRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxFlexibleForwardRate  ***********************/
	class FxFlexibleForwardRateBuilderImpl extends QuotedCurrencyPair.QuotedCurrencyPairBuilderImpl implements FxFlexibleForwardRate.FxFlexibleForwardRateBuilder {
	
		protected BigDecimal rate;
		protected BigDecimal spotRate;
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@RosettaAttribute("currency1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency1")
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setCurrency1(Currency _currency1) {
			this.currency1 = _currency1 == null ? null : _currency1.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currency2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency2")
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setCurrency2(Currency _currency2) {
			this.currency2 = _currency2 == null ? null : _currency2.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quoteBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quoteBasis")
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setQuoteBasis(QuoteBasisEnum _quoteBasis) {
			this.quoteBasis = _quoteBasis == null ? null : _quoteBasis;
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotRate")
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder setSpotRate(BigDecimal _spotRate) {
			this.spotRate = _spotRate == null ? null : _spotRate;
			return this;
		}
		
		@Override
		public FxFlexibleForwardRate build() {
			return new FxFlexibleForwardRate.FxFlexibleForwardRateImpl(this);
		}
		
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRate()!=null) return true;
			if (getSpotRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFlexibleForwardRate.FxFlexibleForwardRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxFlexibleForwardRate.FxFlexibleForwardRateBuilder o = (FxFlexibleForwardRate.FxFlexibleForwardRateBuilder) other;
			
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFlexibleForwardRate _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFlexibleForwardRateBuilder {" +
				"rate=" + this.rate + ", " +
				"spotRate=" + this.spotRate +
			'}' + " " + super.toString();
		}
	}
}

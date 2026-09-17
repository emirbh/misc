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
import fpml.consolidated.fx.meta.CrossRateMeta;
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
 * Provision A type that is used for including the currency exchange rates used to cross between the traded currencies for non-base currency FX contracts.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that is used for including the currency exchange rates used to cross between the traded currencies for non-base currency FX contracts.
 *
 */
@RosettaDataType(value="CrossRate", builder=CrossRate.CrossRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CrossRate", model="fpml", builder=CrossRate.CrossRateBuilderImpl.class, version="2.1.1")
public interface CrossRate extends QuotedCurrencyPair {

	CrossRateMeta metaData = new CrossRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The exchange rate used to cross between the traded currencies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The exchange rate used to cross between the traded currencies.
	 *
	 */
	BigDecimal getRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional element used for FX forwards and certain types of FX OTC options. For deals consumated in the FX Forwards Market, this represents the current market rate for a particular currency pair.
	 *
	 */
	BigDecimal getSpotRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional element used for deals consumated in the FX Forwards market. Forward points represent the interest rate differential between the two currencies traded and are quoted as a preminum or a discount. Forward points are added to, or subtracted from, the spot rate to create the rate of the forward trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional element used for deals consumated in the FX Forwards market. Forward points represent the interest rate differential between the two currencies traded and are quoted as a preminum or a discount. Forward points are added to, or subtracted from, the spot rate to create the rate of the forward trade.
	 *
	 */
	BigDecimal getForwardPoints();

	/*********************** Build Methods  ***********************/
	CrossRate build();
	
	CrossRate.CrossRateBuilder toBuilder();
	
	static CrossRate.CrossRateBuilder builder() {
		return new CrossRate.CrossRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CrossRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CrossRate> getType() {
		return CrossRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency1"), processor, Currency.class, getCurrency1());
		processRosetta(path.newSubPath("currency2"), processor, Currency.class, getCurrency2());
		processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processor.processBasic(path.newSubPath("forwardPoints"), BigDecimal.class, getForwardPoints(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CrossRateBuilder extends CrossRate, QuotedCurrencyPair.QuotedCurrencyPairBuilder {
		@Override
		CrossRate.CrossRateBuilder setCurrency1(Currency currency1);
		@Override
		CrossRate.CrossRateBuilder setCurrency2(Currency currency2);
		@Override
		CrossRate.CrossRateBuilder setQuoteBasis(QuoteBasisEnum quoteBasis);
		CrossRate.CrossRateBuilder setRate(BigDecimal rate);
		CrossRate.CrossRateBuilder setSpotRate(BigDecimal spotRate);
		CrossRate.CrossRateBuilder setForwardPoints(BigDecimal forwardPoints);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency1"), processor, Currency.CurrencyBuilder.class, getCurrency1());
			processRosetta(path.newSubPath("currency2"), processor, Currency.CurrencyBuilder.class, getCurrency2());
			processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processor.processBasic(path.newSubPath("forwardPoints"), BigDecimal.class, getForwardPoints(), this);
		}
		

		CrossRate.CrossRateBuilder prune();
	}

	/*********************** Immutable Implementation of CrossRate  ***********************/
	class CrossRateImpl extends QuotedCurrencyPair.QuotedCurrencyPairImpl implements CrossRate {
		private final BigDecimal rate;
		private final BigDecimal spotRate;
		private final BigDecimal forwardPoints;
		
		protected CrossRateImpl(CrossRate.CrossRateBuilder builder) {
			super(builder);
			this.rate = builder.getRate();
			this.spotRate = builder.getSpotRate();
			this.forwardPoints = builder.getForwardPoints();
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("forwardPoints")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forwardPoints")
		public BigDecimal getForwardPoints() {
			return forwardPoints;
		}
		
		@Override
		public CrossRate build() {
			return this;
		}
		
		@Override
		public CrossRate.CrossRateBuilder toBuilder() {
			CrossRate.CrossRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CrossRate.CrossRateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getForwardPoints()).ifPresent(builder::setForwardPoints);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CrossRate _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(forwardPoints, _that.getForwardPoints())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (forwardPoints != null ? forwardPoints.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CrossRate {" +
				"rate=" + this.rate + ", " +
				"spotRate=" + this.spotRate + ", " +
				"forwardPoints=" + this.forwardPoints +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CrossRate  ***********************/
	class CrossRateBuilderImpl extends QuotedCurrencyPair.QuotedCurrencyPairBuilderImpl implements CrossRate.CrossRateBuilder {
	
		protected BigDecimal rate;
		protected BigDecimal spotRate;
		protected BigDecimal forwardPoints;
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("forwardPoints")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forwardPoints")
		public BigDecimal getForwardPoints() {
			return forwardPoints;
		}
		
		@RosettaAttribute("currency1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency1")
		@Override
		public CrossRate.CrossRateBuilder setCurrency1(Currency _currency1) {
			this.currency1 = _currency1 == null ? null : _currency1.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currency2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency2")
		@Override
		public CrossRate.CrossRateBuilder setCurrency2(Currency _currency2) {
			this.currency2 = _currency2 == null ? null : _currency2.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quoteBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quoteBasis")
		@Override
		public CrossRate.CrossRateBuilder setQuoteBasis(QuoteBasisEnum _quoteBasis) {
			this.quoteBasis = _quoteBasis == null ? null : _quoteBasis;
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rate")
		@Override
		public CrossRate.CrossRateBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotRate")
		@Override
		public CrossRate.CrossRateBuilder setSpotRate(BigDecimal _spotRate) {
			this.spotRate = _spotRate == null ? null : _spotRate;
			return this;
		}
		
		@RosettaAttribute("forwardPoints")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forwardPoints")
		@Override
		public CrossRate.CrossRateBuilder setForwardPoints(BigDecimal _forwardPoints) {
			this.forwardPoints = _forwardPoints == null ? null : _forwardPoints;
			return this;
		}
		
		@Override
		public CrossRate build() {
			return new CrossRate.CrossRateImpl(this);
		}
		
		@Override
		public CrossRate.CrossRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CrossRate.CrossRateBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRate()!=null) return true;
			if (getSpotRate()!=null) return true;
			if (getForwardPoints()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CrossRate.CrossRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CrossRate.CrossRateBuilder o = (CrossRate.CrossRateBuilder) other;
			
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			merger.mergeBasic(getForwardPoints(), o.getForwardPoints(), this::setForwardPoints);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CrossRate _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(forwardPoints, _that.getForwardPoints())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (forwardPoints != null ? forwardPoints.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CrossRateBuilder {" +
				"rate=" + this.rate + ", " +
				"spotRate=" + this.spotRate + ", " +
				"forwardPoints=" + this.forwardPoints +
			'}' + " " + super.toString();
		}
	}
}

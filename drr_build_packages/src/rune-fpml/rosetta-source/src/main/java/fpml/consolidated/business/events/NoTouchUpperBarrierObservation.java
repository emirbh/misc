package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.NoTouchUpperBarrierObservationMeta;
import fpml.consolidated.shared.PositiveMoney;
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
@RosettaDataType(value="NoTouchUpperBarrierObservation", builder=NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NoTouchUpperBarrierObservation", model="fpml", builder=NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilderImpl.class, version="2.1.1")
public interface NoTouchUpperBarrierObservation extends RosettaModelObject {

	NoTouchUpperBarrierObservationMeta metaData = new NoTouchUpperBarrierObservationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The rate value (level) which was attained/breached, in order to trigger the barrier event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The rate value (level) which was attained/breached, in order to trigger the barrier event.
	 *
	 */
	BigDecimal getTriggerRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the currency pair and quote basis for an FX rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the currency pair and quote basis for an FX rate.
	 *
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The maximum value observed during the condition period
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The maximum value observed during the condition period
	 *
	 */
	ObservedRate getMaximumObservedRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The price value (level) which was attained/breached, in order to trigger the barrier event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The price value (level) which was attained/breached, in order to trigger the barrier event.
	 *
	 */
	PositiveMoney getTriggerPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The maximum value observed during the condition period
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The maximum value observed during the condition period
	 *
	 */
	ObservedPrice getMaximumObservedPrice();

	/*********************** Build Methods  ***********************/
	NoTouchUpperBarrierObservation build();
	
	NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder toBuilder();
	
	static NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder builder() {
		return new NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoTouchUpperBarrierObservation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NoTouchUpperBarrierObservation> getType() {
		return NoTouchUpperBarrierObservation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("maximumObservedRate"), processor, ObservedRate.class, getMaximumObservedRate());
		processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.class, getTriggerPrice());
		processRosetta(path.newSubPath("maximumObservedPrice"), processor, ObservedPrice.class, getMaximumObservedPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoTouchUpperBarrierObservationBuilder extends NoTouchUpperBarrierObservation, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		ObservedRate.ObservedRateBuilder getOrCreateMaximumObservedRate();
		@Override
		ObservedRate.ObservedRateBuilder getMaximumObservedRate();
		PositiveMoney.PositiveMoneyBuilder getOrCreateTriggerPrice();
		@Override
		PositiveMoney.PositiveMoneyBuilder getTriggerPrice();
		ObservedPrice.ObservedPriceBuilder getOrCreateMaximumObservedPrice();
		@Override
		ObservedPrice.ObservedPriceBuilder getMaximumObservedPrice();
		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setTriggerRate(BigDecimal triggerRate);
		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setMaximumObservedRate(ObservedRate maximumObservedRate);
		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setTriggerPrice(PositiveMoney triggerPrice);
		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setMaximumObservedPrice(ObservedPrice maximumObservedPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("maximumObservedRate"), processor, ObservedRate.ObservedRateBuilder.class, getMaximumObservedRate());
			processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.PositiveMoneyBuilder.class, getTriggerPrice());
			processRosetta(path.newSubPath("maximumObservedPrice"), processor, ObservedPrice.ObservedPriceBuilder.class, getMaximumObservedPrice());
		}
		

		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder prune();
	}

	/*********************** Immutable Implementation of NoTouchUpperBarrierObservation  ***********************/
	class NoTouchUpperBarrierObservationImpl implements NoTouchUpperBarrierObservation {
		private final BigDecimal triggerRate;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final ObservedRate maximumObservedRate;
		private final PositiveMoney triggerPrice;
		private final ObservedPrice maximumObservedPrice;
		
		protected NoTouchUpperBarrierObservationImpl(NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder builder) {
			this.triggerRate = builder.getTriggerRate();
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.maximumObservedRate = ofNullable(builder.getMaximumObservedRate()).map(f->f.build()).orElse(null);
			this.triggerPrice = ofNullable(builder.getTriggerPrice()).map(f->f.build()).orElse(null);
			this.maximumObservedPrice = ofNullable(builder.getMaximumObservedPrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("maximumObservedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumObservedRate")
		public ObservedRate getMaximumObservedRate() {
			return maximumObservedRate;
		}
		
		@Override
		@RosettaAttribute("triggerPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerPrice")
		public PositiveMoney getTriggerPrice() {
			return triggerPrice;
		}
		
		@Override
		@RosettaAttribute("maximumObservedPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumObservedPrice")
		public ObservedPrice getMaximumObservedPrice() {
			return maximumObservedPrice;
		}
		
		@Override
		public NoTouchUpperBarrierObservation build() {
			return this;
		}
		
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder toBuilder() {
			NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder builder) {
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getMaximumObservedRate()).ifPresent(builder::setMaximumObservedRate);
			ofNullable(getTriggerPrice()).ifPresent(builder::setTriggerPrice);
			ofNullable(getMaximumObservedPrice()).ifPresent(builder::setMaximumObservedPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchUpperBarrierObservation _that = getType().cast(o);
		
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(maximumObservedRate, _that.getMaximumObservedRate())) return false;
			if (!Objects.equals(triggerPrice, _that.getTriggerPrice())) return false;
			if (!Objects.equals(maximumObservedPrice, _that.getMaximumObservedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (maximumObservedRate != null ? maximumObservedRate.hashCode() : 0);
			_result = 31 * _result + (triggerPrice != null ? triggerPrice.hashCode() : 0);
			_result = 31 * _result + (maximumObservedPrice != null ? maximumObservedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchUpperBarrierObservation {" +
				"triggerRate=" + this.triggerRate + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"maximumObservedRate=" + this.maximumObservedRate + ", " +
				"triggerPrice=" + this.triggerPrice + ", " +
				"maximumObservedPrice=" + this.maximumObservedPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of NoTouchUpperBarrierObservation  ***********************/
	class NoTouchUpperBarrierObservationBuilderImpl implements NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder {
	
		protected BigDecimal triggerRate;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected ObservedRate.ObservedRateBuilder maximumObservedRate;
		protected PositiveMoney.PositiveMoneyBuilder triggerPrice;
		protected ObservedPrice.ObservedPriceBuilder maximumObservedPrice;
		
		@Override
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("maximumObservedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumObservedRate")
		public ObservedRate.ObservedRateBuilder getMaximumObservedRate() {
			return maximumObservedRate;
		}
		
		@Override
		public ObservedRate.ObservedRateBuilder getOrCreateMaximumObservedRate() {
			ObservedRate.ObservedRateBuilder result;
			if (maximumObservedRate!=null) {
				result = maximumObservedRate;
			}
			else {
				result = maximumObservedRate = ObservedRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerPrice")
		public PositiveMoney.PositiveMoneyBuilder getTriggerPrice() {
			return triggerPrice;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateTriggerPrice() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (triggerPrice!=null) {
				result = triggerPrice;
			}
			else {
				result = triggerPrice = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("maximumObservedPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumObservedPrice")
		public ObservedPrice.ObservedPriceBuilder getMaximumObservedPrice() {
			return maximumObservedPrice;
		}
		
		@Override
		public ObservedPrice.ObservedPriceBuilder getOrCreateMaximumObservedPrice() {
			ObservedPrice.ObservedPriceBuilder result;
			if (maximumObservedPrice!=null) {
				result = maximumObservedPrice;
			}
			else {
				result = maximumObservedPrice = ObservedPrice.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerRate")
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setTriggerRate(BigDecimal _triggerRate) {
			this.triggerRate = _triggerRate == null ? null : _triggerRate;
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("maximumObservedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumObservedRate")
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setMaximumObservedRate(ObservedRate _maximumObservedRate) {
			this.maximumObservedRate = _maximumObservedRate == null ? null : _maximumObservedRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerPrice")
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setTriggerPrice(PositiveMoney _triggerPrice) {
			this.triggerPrice = _triggerPrice == null ? null : _triggerPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("maximumObservedPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumObservedPrice")
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder setMaximumObservedPrice(ObservedPrice _maximumObservedPrice) {
			this.maximumObservedPrice = _maximumObservedPrice == null ? null : _maximumObservedPrice.toBuilder();
			return this;
		}
		
		@Override
		public NoTouchUpperBarrierObservation build() {
			return new NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationImpl(this);
		}
		
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (maximumObservedRate!=null && !maximumObservedRate.prune().hasData()) maximumObservedRate = null;
			if (triggerPrice!=null && !triggerPrice.prune().hasData()) triggerPrice = null;
			if (maximumObservedPrice!=null && !maximumObservedPrice.prune().hasData()) maximumObservedPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTriggerRate()!=null) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getMaximumObservedRate()!=null && getMaximumObservedRate().hasData()) return true;
			if (getTriggerPrice()!=null && getTriggerPrice().hasData()) return true;
			if (getMaximumObservedPrice()!=null && getMaximumObservedPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder o = (NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getMaximumObservedRate(), o.getMaximumObservedRate(), this::setMaximumObservedRate);
			merger.mergeRosetta(getTriggerPrice(), o.getTriggerPrice(), this::setTriggerPrice);
			merger.mergeRosetta(getMaximumObservedPrice(), o.getMaximumObservedPrice(), this::setMaximumObservedPrice);
			
			merger.mergeBasic(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchUpperBarrierObservation _that = getType().cast(o);
		
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(maximumObservedRate, _that.getMaximumObservedRate())) return false;
			if (!Objects.equals(triggerPrice, _that.getTriggerPrice())) return false;
			if (!Objects.equals(maximumObservedPrice, _that.getMaximumObservedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (maximumObservedRate != null ? maximumObservedRate.hashCode() : 0);
			_result = 31 * _result + (triggerPrice != null ? triggerPrice.hashCode() : 0);
			_result = 31 * _result + (maximumObservedPrice != null ? maximumObservedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchUpperBarrierObservationBuilder {" +
				"triggerRate=" + this.triggerRate + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"maximumObservedRate=" + this.maximumObservedRate + ", " +
				"triggerPrice=" + this.triggerPrice + ", " +
				"maximumObservedPrice=" + this.maximumObservedPrice +
			'}';
		}
	}
}

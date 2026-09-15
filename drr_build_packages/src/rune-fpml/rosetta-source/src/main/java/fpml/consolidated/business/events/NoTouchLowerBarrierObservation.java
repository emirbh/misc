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
import fpml.consolidated.business.events.meta.NoTouchLowerBarrierObservationMeta;
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
@RosettaDataType(value="NoTouchLowerBarrierObservation", builder=NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NoTouchLowerBarrierObservation", model="fpml", builder=NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilderImpl.class, version="2.1.1")
public interface NoTouchLowerBarrierObservation extends RosettaModelObject {

	NoTouchLowerBarrierObservationMeta metaData = new NoTouchLowerBarrierObservationMeta();

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
	 * Provision The minimum value observed during the condition period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The minimum value observed during the condition period.
	 *
	 */
	ObservedRate getMinimumObservedRate();
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
	 * Provision The minimum value observed during the condition period
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The minimum value observed during the condition period
	 *
	 */
	ObservedPrice getMinimumObservedPrice();

	/*********************** Build Methods  ***********************/
	NoTouchLowerBarrierObservation build();
	
	NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder toBuilder();
	
	static NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder builder() {
		return new NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoTouchLowerBarrierObservation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NoTouchLowerBarrierObservation> getType() {
		return NoTouchLowerBarrierObservation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("minimumObservedRate"), processor, ObservedRate.class, getMinimumObservedRate());
		processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.class, getTriggerPrice());
		processRosetta(path.newSubPath("minimumObservedPrice"), processor, ObservedPrice.class, getMinimumObservedPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoTouchLowerBarrierObservationBuilder extends NoTouchLowerBarrierObservation, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		ObservedRate.ObservedRateBuilder getOrCreateMinimumObservedRate();
		@Override
		ObservedRate.ObservedRateBuilder getMinimumObservedRate();
		PositiveMoney.PositiveMoneyBuilder getOrCreateTriggerPrice();
		@Override
		PositiveMoney.PositiveMoneyBuilder getTriggerPrice();
		ObservedPrice.ObservedPriceBuilder getOrCreateMinimumObservedPrice();
		@Override
		ObservedPrice.ObservedPriceBuilder getMinimumObservedPrice();
		NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setTriggerRate(BigDecimal triggerRate);
		NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setMinimumObservedRate(ObservedRate minimumObservedRate);
		NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setTriggerPrice(PositiveMoney triggerPrice);
		NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setMinimumObservedPrice(ObservedPrice minimumObservedPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("minimumObservedRate"), processor, ObservedRate.ObservedRateBuilder.class, getMinimumObservedRate());
			processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.PositiveMoneyBuilder.class, getTriggerPrice());
			processRosetta(path.newSubPath("minimumObservedPrice"), processor, ObservedPrice.ObservedPriceBuilder.class, getMinimumObservedPrice());
		}
		

		NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder prune();
	}

	/*********************** Immutable Implementation of NoTouchLowerBarrierObservation  ***********************/
	class NoTouchLowerBarrierObservationImpl implements NoTouchLowerBarrierObservation {
		private final BigDecimal triggerRate;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final ObservedRate minimumObservedRate;
		private final PositiveMoney triggerPrice;
		private final ObservedPrice minimumObservedPrice;
		
		protected NoTouchLowerBarrierObservationImpl(NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder builder) {
			this.triggerRate = builder.getTriggerRate();
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.minimumObservedRate = ofNullable(builder.getMinimumObservedRate()).map(f->f.build()).orElse(null);
			this.triggerPrice = ofNullable(builder.getTriggerPrice()).map(f->f.build()).orElse(null);
			this.minimumObservedPrice = ofNullable(builder.getMinimumObservedPrice()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("minimumObservedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumObservedRate")
		public ObservedRate getMinimumObservedRate() {
			return minimumObservedRate;
		}
		
		@Override
		@RosettaAttribute("triggerPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerPrice")
		public PositiveMoney getTriggerPrice() {
			return triggerPrice;
		}
		
		@Override
		@RosettaAttribute("minimumObservedPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumObservedPrice")
		public ObservedPrice getMinimumObservedPrice() {
			return minimumObservedPrice;
		}
		
		@Override
		public NoTouchLowerBarrierObservation build() {
			return this;
		}
		
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder toBuilder() {
			NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder builder) {
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getMinimumObservedRate()).ifPresent(builder::setMinimumObservedRate);
			ofNullable(getTriggerPrice()).ifPresent(builder::setTriggerPrice);
			ofNullable(getMinimumObservedPrice()).ifPresent(builder::setMinimumObservedPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchLowerBarrierObservation _that = getType().cast(o);
		
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(minimumObservedRate, _that.getMinimumObservedRate())) return false;
			if (!Objects.equals(triggerPrice, _that.getTriggerPrice())) return false;
			if (!Objects.equals(minimumObservedPrice, _that.getMinimumObservedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (minimumObservedRate != null ? minimumObservedRate.hashCode() : 0);
			_result = 31 * _result + (triggerPrice != null ? triggerPrice.hashCode() : 0);
			_result = 31 * _result + (minimumObservedPrice != null ? minimumObservedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchLowerBarrierObservation {" +
				"triggerRate=" + this.triggerRate + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"minimumObservedRate=" + this.minimumObservedRate + ", " +
				"triggerPrice=" + this.triggerPrice + ", " +
				"minimumObservedPrice=" + this.minimumObservedPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of NoTouchLowerBarrierObservation  ***********************/
	class NoTouchLowerBarrierObservationBuilderImpl implements NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder {
	
		protected BigDecimal triggerRate;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected ObservedRate.ObservedRateBuilder minimumObservedRate;
		protected PositiveMoney.PositiveMoneyBuilder triggerPrice;
		protected ObservedPrice.ObservedPriceBuilder minimumObservedPrice;
		
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
		@RosettaAttribute("minimumObservedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumObservedRate")
		public ObservedRate.ObservedRateBuilder getMinimumObservedRate() {
			return minimumObservedRate;
		}
		
		@Override
		public ObservedRate.ObservedRateBuilder getOrCreateMinimumObservedRate() {
			ObservedRate.ObservedRateBuilder result;
			if (minimumObservedRate!=null) {
				result = minimumObservedRate;
			}
			else {
				result = minimumObservedRate = ObservedRate.builder();
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
		@RosettaAttribute("minimumObservedPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumObservedPrice")
		public ObservedPrice.ObservedPriceBuilder getMinimumObservedPrice() {
			return minimumObservedPrice;
		}
		
		@Override
		public ObservedPrice.ObservedPriceBuilder getOrCreateMinimumObservedPrice() {
			ObservedPrice.ObservedPriceBuilder result;
			if (minimumObservedPrice!=null) {
				result = minimumObservedPrice;
			}
			else {
				result = minimumObservedPrice = ObservedPrice.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerRate")
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setTriggerRate(BigDecimal _triggerRate) {
			this.triggerRate = _triggerRate == null ? null : _triggerRate;
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minimumObservedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumObservedRate")
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setMinimumObservedRate(ObservedRate _minimumObservedRate) {
			this.minimumObservedRate = _minimumObservedRate == null ? null : _minimumObservedRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerPrice")
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setTriggerPrice(PositiveMoney _triggerPrice) {
			this.triggerPrice = _triggerPrice == null ? null : _triggerPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minimumObservedPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumObservedPrice")
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder setMinimumObservedPrice(ObservedPrice _minimumObservedPrice) {
			this.minimumObservedPrice = _minimumObservedPrice == null ? null : _minimumObservedPrice.toBuilder();
			return this;
		}
		
		@Override
		public NoTouchLowerBarrierObservation build() {
			return new NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationImpl(this);
		}
		
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (minimumObservedRate!=null && !minimumObservedRate.prune().hasData()) minimumObservedRate = null;
			if (triggerPrice!=null && !triggerPrice.prune().hasData()) triggerPrice = null;
			if (minimumObservedPrice!=null && !minimumObservedPrice.prune().hasData()) minimumObservedPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTriggerRate()!=null) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getMinimumObservedRate()!=null && getMinimumObservedRate().hasData()) return true;
			if (getTriggerPrice()!=null && getTriggerPrice().hasData()) return true;
			if (getMinimumObservedPrice()!=null && getMinimumObservedPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder o = (NoTouchLowerBarrierObservation.NoTouchLowerBarrierObservationBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getMinimumObservedRate(), o.getMinimumObservedRate(), this::setMinimumObservedRate);
			merger.mergeRosetta(getTriggerPrice(), o.getTriggerPrice(), this::setTriggerPrice);
			merger.mergeRosetta(getMinimumObservedPrice(), o.getMinimumObservedPrice(), this::setMinimumObservedPrice);
			
			merger.mergeBasic(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchLowerBarrierObservation _that = getType().cast(o);
		
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(minimumObservedRate, _that.getMinimumObservedRate())) return false;
			if (!Objects.equals(triggerPrice, _that.getTriggerPrice())) return false;
			if (!Objects.equals(minimumObservedPrice, _that.getMinimumObservedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (minimumObservedRate != null ? minimumObservedRate.hashCode() : 0);
			_result = 31 * _result + (triggerPrice != null ? triggerPrice.hashCode() : 0);
			_result = 31 * _result + (minimumObservedPrice != null ? minimumObservedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchLowerBarrierObservationBuilder {" +
				"triggerRate=" + this.triggerRate + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"minimumObservedRate=" + this.minimumObservedRate + ", " +
				"triggerPrice=" + this.triggerPrice + ", " +
				"minimumObservedPrice=" + this.minimumObservedPrice +
			'}';
		}
	}
}

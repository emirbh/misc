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
import fpml.consolidated.business.events.meta.TriggerRateObservationMeta;
import fpml.consolidated.fpmlenum.TriggerConditionEnum;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
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
@RosettaDataType(value="TriggerRateObservation", builder=TriggerRateObservation.TriggerRateObservationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TriggerRateObservation", model="fpml", builder=TriggerRateObservation.TriggerRateObservationBuilderImpl.class, version="2.1.1")
public interface TriggerRateObservation extends RosettaModelObject {

	TriggerRateObservationMeta metaData = new TriggerRateObservationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the rate observation occurred, in order to trigger the barrier event.observationDate
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the rate observation occurred, in order to trigger the barrier event.observationDate
	 *
	 */
	ZonedDateTime getObservationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time at which the observation occurred.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time at which the observation occurred.
	 *
	 */
	BusinessCenterTime getObservationTime();
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
	InformationSource getInformationSource();
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
	 * Provision The observed rate value which triggered the barrier event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The observed rate value which triggered the barrier event.
	 *
	 */
	BigDecimal getObservedRate();
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
	 * Provision The observed price value which triggered the barrier event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The observed price value which triggered the barrier event.
	 *
	 */
	PositiveMoney getObservedPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The side of the trigger rate/price (level) on which a rate observation occurred, in order to trigger the barrier event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The side of the trigger rate/price (level) on which a rate observation occurred, in order to trigger the barrier event.
	 *
	 */
	TriggerConditionEnum getTriggerCondition();

	/*********************** Build Methods  ***********************/
	TriggerRateObservation build();
	
	TriggerRateObservation.TriggerRateObservationBuilder toBuilder();
	
	static TriggerRateObservation.TriggerRateObservationBuilder builder() {
		return new TriggerRateObservation.TriggerRateObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TriggerRateObservation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TriggerRateObservation> getType() {
		return TriggerRateObservation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationDate"), ZonedDateTime.class, getObservationDate(), this);
		processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.class, getObservationTime());
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("observedRate"), BigDecimal.class, getObservedRate(), this);
		processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.class, getTriggerPrice());
		processRosetta(path.newSubPath("observedPrice"), processor, PositiveMoney.class, getObservedPrice());
		processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TriggerRateObservationBuilder extends TriggerRateObservation, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getObservationTime();
		InformationSource.InformationSourceBuilder getOrCreateInformationSource();
		@Override
		InformationSource.InformationSourceBuilder getInformationSource();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		PositiveMoney.PositiveMoneyBuilder getOrCreateTriggerPrice();
		@Override
		PositiveMoney.PositiveMoneyBuilder getTriggerPrice();
		PositiveMoney.PositiveMoneyBuilder getOrCreateObservedPrice();
		@Override
		PositiveMoney.PositiveMoneyBuilder getObservedPrice();
		TriggerRateObservation.TriggerRateObservationBuilder setObservationDate(ZonedDateTime observationDate);
		TriggerRateObservation.TriggerRateObservationBuilder setObservationTime(BusinessCenterTime observationTime);
		TriggerRateObservation.TriggerRateObservationBuilder setInformationSource(InformationSource informationSource);
		TriggerRateObservation.TriggerRateObservationBuilder setTriggerRate(BigDecimal triggerRate);
		TriggerRateObservation.TriggerRateObservationBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		TriggerRateObservation.TriggerRateObservationBuilder setObservedRate(BigDecimal observedRate);
		TriggerRateObservation.TriggerRateObservationBuilder setTriggerPrice(PositiveMoney triggerPrice);
		TriggerRateObservation.TriggerRateObservationBuilder setObservedPrice(PositiveMoney observedPrice);
		TriggerRateObservation.TriggerRateObservationBuilder setTriggerCondition(TriggerConditionEnum triggerCondition);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationDate"), ZonedDateTime.class, getObservationDate(), this);
			processRosetta(path.newSubPath("observationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationTime());
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("observedRate"), BigDecimal.class, getObservedRate(), this);
			processRosetta(path.newSubPath("triggerPrice"), processor, PositiveMoney.PositiveMoneyBuilder.class, getTriggerPrice());
			processRosetta(path.newSubPath("observedPrice"), processor, PositiveMoney.PositiveMoneyBuilder.class, getObservedPrice());
			processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
		}
		

		TriggerRateObservation.TriggerRateObservationBuilder prune();
	}

	/*********************** Immutable Implementation of TriggerRateObservation  ***********************/
	class TriggerRateObservationImpl implements TriggerRateObservation {
		private final ZonedDateTime observationDate;
		private final BusinessCenterTime observationTime;
		private final InformationSource informationSource;
		private final BigDecimal triggerRate;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final BigDecimal observedRate;
		private final PositiveMoney triggerPrice;
		private final PositiveMoney observedPrice;
		private final TriggerConditionEnum triggerCondition;
		
		protected TriggerRateObservationImpl(TriggerRateObservation.TriggerRateObservationBuilder builder) {
			this.observationDate = builder.getObservationDate();
			this.observationTime = ofNullable(builder.getObservationTime()).map(f->f.build()).orElse(null);
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
			this.triggerRate = builder.getTriggerRate();
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.observedRate = builder.getObservedRate();
			this.triggerPrice = ofNullable(builder.getTriggerPrice()).map(f->f.build()).orElse(null);
			this.observedPrice = ofNullable(builder.getObservedPrice()).map(f->f.build()).orElse(null);
			this.triggerCondition = builder.getTriggerCondition();
		}
		
		@Override
		@RosettaAttribute("observationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationDate")
		public ZonedDateTime getObservationDate() {
			return observationDate;
		}
		
		@Override
		@RosettaAttribute("observationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationTime")
		public BusinessCenterTime getObservationTime() {
			return observationTime;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("informationSource")
		public InformationSource getInformationSource() {
			return informationSource;
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
		@RosettaAttribute("observedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observedRate")
		public BigDecimal getObservedRate() {
			return observedRate;
		}
		
		@Override
		@RosettaAttribute("triggerPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerPrice")
		public PositiveMoney getTriggerPrice() {
			return triggerPrice;
		}
		
		@Override
		@RosettaAttribute("observedPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observedPrice")
		public PositiveMoney getObservedPrice() {
			return observedPrice;
		}
		
		@Override
		@RosettaAttribute("triggerCondition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerCondition")
		public TriggerConditionEnum getTriggerCondition() {
			return triggerCondition;
		}
		
		@Override
		public TriggerRateObservation build() {
			return this;
		}
		
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder toBuilder() {
			TriggerRateObservation.TriggerRateObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TriggerRateObservation.TriggerRateObservationBuilder builder) {
			ofNullable(getObservationDate()).ifPresent(builder::setObservationDate);
			ofNullable(getObservationTime()).ifPresent(builder::setObservationTime);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getObservedRate()).ifPresent(builder::setObservedRate);
			ofNullable(getTriggerPrice()).ifPresent(builder::setTriggerPrice);
			ofNullable(getObservedPrice()).ifPresent(builder::setObservedPrice);
			ofNullable(getTriggerCondition()).ifPresent(builder::setTriggerCondition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriggerRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(observationDate, _that.getObservationDate())) return false;
			if (!Objects.equals(observationTime, _that.getObservationTime())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(observedRate, _that.getObservedRate())) return false;
			if (!Objects.equals(triggerPrice, _that.getTriggerPrice())) return false;
			if (!Objects.equals(observedPrice, _that.getObservedPrice())) return false;
			if (!Objects.equals(triggerCondition, _that.getTriggerCondition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationDate != null ? observationDate.hashCode() : 0);
			_result = 31 * _result + (observationTime != null ? observationTime.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (observedRate != null ? observedRate.hashCode() : 0);
			_result = 31 * _result + (triggerPrice != null ? triggerPrice.hashCode() : 0);
			_result = 31 * _result + (observedPrice != null ? observedPrice.hashCode() : 0);
			_result = 31 * _result + (triggerCondition != null ? triggerCondition.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerRateObservation {" +
				"observationDate=" + this.observationDate + ", " +
				"observationTime=" + this.observationTime + ", " +
				"informationSource=" + this.informationSource + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"observedRate=" + this.observedRate + ", " +
				"triggerPrice=" + this.triggerPrice + ", " +
				"observedPrice=" + this.observedPrice + ", " +
				"triggerCondition=" + this.triggerCondition +
			'}';
		}
	}

	/*********************** Builder Implementation of TriggerRateObservation  ***********************/
	class TriggerRateObservationBuilderImpl implements TriggerRateObservation.TriggerRateObservationBuilder {
	
		protected ZonedDateTime observationDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder observationTime;
		protected InformationSource.InformationSourceBuilder informationSource;
		protected BigDecimal triggerRate;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected BigDecimal observedRate;
		protected PositiveMoney.PositiveMoneyBuilder triggerPrice;
		protected PositiveMoney.PositiveMoneyBuilder observedPrice;
		protected TriggerConditionEnum triggerCondition;
		
		@Override
		@RosettaAttribute("observationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationDate")
		public ZonedDateTime getObservationDate() {
			return observationDate;
		}
		
		@Override
		@RosettaAttribute("observationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getObservationTime() {
			return observationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateObservationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (observationTime!=null) {
				result = observationTime;
			}
			else {
				result = observationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("informationSource")
		public InformationSource.InformationSourceBuilder getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource() {
			InformationSource.InformationSourceBuilder result;
			if (informationSource!=null) {
				result = informationSource;
			}
			else {
				result = informationSource = InformationSource.builder();
			}
			
			return result;
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
		@RosettaAttribute("observedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observedRate")
		public BigDecimal getObservedRate() {
			return observedRate;
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
		@RosettaAttribute("observedPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observedPrice")
		public PositiveMoney.PositiveMoneyBuilder getObservedPrice() {
			return observedPrice;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateObservedPrice() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (observedPrice!=null) {
				result = observedPrice;
			}
			else {
				result = observedPrice = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerCondition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerCondition")
		public TriggerConditionEnum getTriggerCondition() {
			return triggerCondition;
		}
		
		@RosettaAttribute("observationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationDate")
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder setObservationDate(ZonedDateTime _observationDate) {
			this.observationDate = _observationDate == null ? null : _observationDate;
			return this;
		}
		
		@RosettaAttribute("observationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationTime")
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder setObservationTime(BusinessCenterTime _observationTime) {
			this.observationTime = _observationTime == null ? null : _observationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("informationSource")
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder setInformationSource(InformationSource _informationSource) {
			this.informationSource = _informationSource == null ? null : _informationSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerRate")
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder setTriggerRate(BigDecimal _triggerRate) {
			this.triggerRate = _triggerRate == null ? null : _triggerRate;
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observedRate")
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder setObservedRate(BigDecimal _observedRate) {
			this.observedRate = _observedRate == null ? null : _observedRate;
			return this;
		}
		
		@RosettaAttribute("triggerPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerPrice")
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder setTriggerPrice(PositiveMoney _triggerPrice) {
			this.triggerPrice = _triggerPrice == null ? null : _triggerPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observedPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observedPrice")
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder setObservedPrice(PositiveMoney _observedPrice) {
			this.observedPrice = _observedPrice == null ? null : _observedPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerCondition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerCondition")
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder setTriggerCondition(TriggerConditionEnum _triggerCondition) {
			this.triggerCondition = _triggerCondition == null ? null : _triggerCondition;
			return this;
		}
		
		@Override
		public TriggerRateObservation build() {
			return new TriggerRateObservation.TriggerRateObservationImpl(this);
		}
		
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder prune() {
			if (observationTime!=null && !observationTime.prune().hasData()) observationTime = null;
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (triggerPrice!=null && !triggerPrice.prune().hasData()) triggerPrice = null;
			if (observedPrice!=null && !observedPrice.prune().hasData()) observedPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationDate()!=null) return true;
			if (getObservationTime()!=null && getObservationTime().hasData()) return true;
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			if (getTriggerRate()!=null) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getObservedRate()!=null) return true;
			if (getTriggerPrice()!=null && getTriggerPrice().hasData()) return true;
			if (getObservedPrice()!=null && getObservedPrice().hasData()) return true;
			if (getTriggerCondition()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriggerRateObservation.TriggerRateObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TriggerRateObservation.TriggerRateObservationBuilder o = (TriggerRateObservation.TriggerRateObservationBuilder) other;
			
			merger.mergeRosetta(getObservationTime(), o.getObservationTime(), this::setObservationTime);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getTriggerPrice(), o.getTriggerPrice(), this::setTriggerPrice);
			merger.mergeRosetta(getObservedPrice(), o.getObservedPrice(), this::setObservedPrice);
			
			merger.mergeBasic(getObservationDate(), o.getObservationDate(), this::setObservationDate);
			merger.mergeBasic(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			merger.mergeBasic(getObservedRate(), o.getObservedRate(), this::setObservedRate);
			merger.mergeBasic(getTriggerCondition(), o.getTriggerCondition(), this::setTriggerCondition);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriggerRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(observationDate, _that.getObservationDate())) return false;
			if (!Objects.equals(observationTime, _that.getObservationTime())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(observedRate, _that.getObservedRate())) return false;
			if (!Objects.equals(triggerPrice, _that.getTriggerPrice())) return false;
			if (!Objects.equals(observedPrice, _that.getObservedPrice())) return false;
			if (!Objects.equals(triggerCondition, _that.getTriggerCondition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationDate != null ? observationDate.hashCode() : 0);
			_result = 31 * _result + (observationTime != null ? observationTime.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (observedRate != null ? observedRate.hashCode() : 0);
			_result = 31 * _result + (triggerPrice != null ? triggerPrice.hashCode() : 0);
			_result = 31 * _result + (observedPrice != null ? observedPrice.hashCode() : 0);
			_result = 31 * _result + (triggerCondition != null ? triggerCondition.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerRateObservationBuilder {" +
				"observationDate=" + this.observationDate + ", " +
				"observationTime=" + this.observationTime + ", " +
				"informationSource=" + this.informationSource + ", " +
				"triggerRate=" + this.triggerRate + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"observedRate=" + this.observedRate + ", " +
				"triggerPrice=" + this.triggerPrice + ", " +
				"observedPrice=" + this.observedPrice + ", " +
				"triggerCondition=" + this.triggerCondition +
			'}';
		}
	}
}

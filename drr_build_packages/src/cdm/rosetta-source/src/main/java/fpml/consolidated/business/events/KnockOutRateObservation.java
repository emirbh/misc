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
import fpml.consolidated.business.events.meta.KnockOutRateObservationMeta;
import fpml.consolidated.fpmlenum.TriggerConditionEnum;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.NonNegativePayment;
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
 * Provision Describes an observation that caused a barrier knock out to trigger
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes an observation that caused a barrier knock out to trigger
 *
 */
@RosettaDataType(value="KnockOutRateObservation", builder=KnockOutRateObservation.KnockOutRateObservationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="KnockOutRateObservation", model="fpml", builder=KnockOutRateObservation.KnockOutRateObservationBuilderImpl.class, version="2.1.1")
public interface KnockOutRateObservation extends TriggerRateObservation {

	KnockOutRateObservationMeta metaData = new KnockOutRateObservationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Any rebate payable as a result of the knock out
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Any rebate payable as a result of the knock out
	 *
	 */
	NonNegativePayment getRebatePayment();

	/*********************** Build Methods  ***********************/
	KnockOutRateObservation build();
	
	KnockOutRateObservation.KnockOutRateObservationBuilder toBuilder();
	
	static KnockOutRateObservation.KnockOutRateObservationBuilder builder() {
		return new KnockOutRateObservation.KnockOutRateObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends KnockOutRateObservation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends KnockOutRateObservation> getType() {
		return KnockOutRateObservation.class;
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
		processRosetta(path.newSubPath("rebatePayment"), processor, NonNegativePayment.class, getRebatePayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface KnockOutRateObservationBuilder extends KnockOutRateObservation, TriggerRateObservation.TriggerRateObservationBuilder {
		NonNegativePayment.NonNegativePaymentBuilder getOrCreateRebatePayment();
		@Override
		NonNegativePayment.NonNegativePaymentBuilder getRebatePayment();
		@Override
		KnockOutRateObservation.KnockOutRateObservationBuilder setObservationDate(ZonedDateTime observationDate);
		@Override
		KnockOutRateObservation.KnockOutRateObservationBuilder setObservationTime(BusinessCenterTime observationTime);
		@Override
		KnockOutRateObservation.KnockOutRateObservationBuilder setInformationSource(InformationSource informationSource);
		@Override
		KnockOutRateObservation.KnockOutRateObservationBuilder setTriggerRate(BigDecimal triggerRate);
		@Override
		KnockOutRateObservation.KnockOutRateObservationBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		@Override
		KnockOutRateObservation.KnockOutRateObservationBuilder setObservedRate(BigDecimal observedRate);
		@Override
		KnockOutRateObservation.KnockOutRateObservationBuilder setTriggerPrice(PositiveMoney triggerPrice);
		@Override
		KnockOutRateObservation.KnockOutRateObservationBuilder setObservedPrice(PositiveMoney observedPrice);
		@Override
		KnockOutRateObservation.KnockOutRateObservationBuilder setTriggerCondition(TriggerConditionEnum triggerCondition);
		KnockOutRateObservation.KnockOutRateObservationBuilder setRebatePayment(NonNegativePayment rebatePayment);

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
			processRosetta(path.newSubPath("rebatePayment"), processor, NonNegativePayment.NonNegativePaymentBuilder.class, getRebatePayment());
		}
		

		KnockOutRateObservation.KnockOutRateObservationBuilder prune();
	}

	/*********************** Immutable Implementation of KnockOutRateObservation  ***********************/
	class KnockOutRateObservationImpl extends TriggerRateObservation.TriggerRateObservationImpl implements KnockOutRateObservation {
		private final NonNegativePayment rebatePayment;
		
		protected KnockOutRateObservationImpl(KnockOutRateObservation.KnockOutRateObservationBuilder builder) {
			super(builder);
			this.rebatePayment = ofNullable(builder.getRebatePayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rebatePayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rebatePayment")
		public NonNegativePayment getRebatePayment() {
			return rebatePayment;
		}
		
		@Override
		public KnockOutRateObservation build() {
			return this;
		}
		
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder toBuilder() {
			KnockOutRateObservation.KnockOutRateObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(KnockOutRateObservation.KnockOutRateObservationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRebatePayment()).ifPresent(builder::setRebatePayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			KnockOutRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(rebatePayment, _that.getRebatePayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rebatePayment != null ? rebatePayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KnockOutRateObservation {" +
				"rebatePayment=" + this.rebatePayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of KnockOutRateObservation  ***********************/
	class KnockOutRateObservationBuilderImpl extends TriggerRateObservation.TriggerRateObservationBuilderImpl implements KnockOutRateObservation.KnockOutRateObservationBuilder {
	
		protected NonNegativePayment.NonNegativePaymentBuilder rebatePayment;
		
		@Override
		@RosettaAttribute("rebatePayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rebatePayment")
		public NonNegativePayment.NonNegativePaymentBuilder getRebatePayment() {
			return rebatePayment;
		}
		
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder getOrCreateRebatePayment() {
			NonNegativePayment.NonNegativePaymentBuilder result;
			if (rebatePayment!=null) {
				result = rebatePayment;
			}
			else {
				result = rebatePayment = NonNegativePayment.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("observationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationDate")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder setObservationDate(ZonedDateTime _observationDate) {
			this.observationDate = _observationDate == null ? null : _observationDate;
			return this;
		}
		
		@RosettaAttribute("observationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationTime")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder setObservationTime(BusinessCenterTime _observationTime) {
			this.observationTime = _observationTime == null ? null : _observationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("informationSource")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder setInformationSource(InformationSource _informationSource) {
			this.informationSource = _informationSource == null ? null : _informationSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerRate")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder setTriggerRate(BigDecimal _triggerRate) {
			this.triggerRate = _triggerRate == null ? null : _triggerRate;
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observedRate")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder setObservedRate(BigDecimal _observedRate) {
			this.observedRate = _observedRate == null ? null : _observedRate;
			return this;
		}
		
		@RosettaAttribute("triggerPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerPrice")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder setTriggerPrice(PositiveMoney _triggerPrice) {
			this.triggerPrice = _triggerPrice == null ? null : _triggerPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observedPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observedPrice")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder setObservedPrice(PositiveMoney _observedPrice) {
			this.observedPrice = _observedPrice == null ? null : _observedPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerCondition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerCondition")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder setTriggerCondition(TriggerConditionEnum _triggerCondition) {
			this.triggerCondition = _triggerCondition == null ? null : _triggerCondition;
			return this;
		}
		
		@RosettaAttribute("rebatePayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rebatePayment")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder setRebatePayment(NonNegativePayment _rebatePayment) {
			this.rebatePayment = _rebatePayment == null ? null : _rebatePayment.toBuilder();
			return this;
		}
		
		@Override
		public KnockOutRateObservation build() {
			return new KnockOutRateObservation.KnockOutRateObservationImpl(this);
		}
		
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder prune() {
			super.prune();
			if (rebatePayment!=null && !rebatePayment.prune().hasData()) rebatePayment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRebatePayment()!=null && getRebatePayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KnockOutRateObservation.KnockOutRateObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			KnockOutRateObservation.KnockOutRateObservationBuilder o = (KnockOutRateObservation.KnockOutRateObservationBuilder) other;
			
			merger.mergeRosetta(getRebatePayment(), o.getRebatePayment(), this::setRebatePayment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			KnockOutRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(rebatePayment, _that.getRebatePayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rebatePayment != null ? rebatePayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KnockOutRateObservationBuilder {" +
				"rebatePayment=" + this.rebatePayment +
			'}' + " " + super.toString();
		}
	}
}

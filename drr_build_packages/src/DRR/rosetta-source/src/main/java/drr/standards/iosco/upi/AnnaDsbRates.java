package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbRatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbRates", builder=AnnaDsbRates.AnnaDsbRatesBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbRates", model="drr", builder=AnnaDsbRates.AnnaDsbRatesBuilderImpl.class, version="7.7.0")
public interface AnnaDsbRates extends RosettaModelObject {

	AnnaDsbRatesMeta metaData = new AnnaDsbRatesMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger();
	String getReferenceRate();
	String getUnderlierCharacteristic();
	String getUnderlyingInstrumentISIN();
	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getOtherLegReferenceRateTermUnit();
	String getNotionalCurrency();
	AnnaDsbOtherLegUnderlying getOtherLegUnderlying();
	String getOtherNotionalCurrency();
	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getReferenceRateTermUnit();
	Integer getOtherLegReferenceRateTermValue();
	String getOtherLegReferenceRate();
	AnnaDsbUnderlying getUnderlying();
	AnnaDsbUnderlierCharacteristicEnum getOtherLegUnderlierCharacteristic();
	Integer getReferenceRateTermValue();
	String getUnderlierName();

	/*********************** Build Methods  ***********************/
	AnnaDsbRates build();
	
	AnnaDsbRates.AnnaDsbRatesBuilder toBuilder();
	
	static AnnaDsbRates.AnnaDsbRatesBuilder builder() {
		return new AnnaDsbRates.AnnaDsbRatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbRates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbRates> getType() {
		return AnnaDsbRates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
		processor.processBasic(path.newSubPath("ReferenceRate"), String.class, getReferenceRate(), this);
		processor.processBasic(path.newSubPath("UnderlierCharacteristic"), String.class, getUnderlierCharacteristic(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentISIN"), String.class, getUnderlyingInstrumentISIN(), this);
		processor.processBasic(path.newSubPath("OtherLegReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getOtherLegReferenceRateTermUnit(), this);
		processor.processBasic(path.newSubPath("NotionalCurrency"), String.class, getNotionalCurrency(), this);
		processRosetta(path.newSubPath("OtherLegUnderlying"), processor, AnnaDsbOtherLegUnderlying.class, getOtherLegUnderlying());
		processor.processBasic(path.newSubPath("OtherNotionalCurrency"), String.class, getOtherNotionalCurrency(), this);
		processor.processBasic(path.newSubPath("ReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getReferenceRateTermUnit(), this);
		processor.processBasic(path.newSubPath("OtherLegReferenceRateTermValue"), Integer.class, getOtherLegReferenceRateTermValue(), this);
		processor.processBasic(path.newSubPath("OtherLegReferenceRate"), String.class, getOtherLegReferenceRate(), this);
		processRosetta(path.newSubPath("Underlying"), processor, AnnaDsbUnderlying.class, getUnderlying());
		processor.processBasic(path.newSubPath("OtherLegUnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getOtherLegUnderlierCharacteristic(), this);
		processor.processBasic(path.newSubPath("ReferenceRateTermValue"), Integer.class, getReferenceRateTermValue(), this);
		processor.processBasic(path.newSubPath("UnderlierName"), String.class, getUnderlierName(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbRatesBuilder extends AnnaDsbRates, RosettaModelObjectBuilder {
		AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder getOrCreateOtherLegUnderlying();
		@Override
		AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder getOtherLegUnderlying();
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getOrCreateUnderlying();
		@Override
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getUnderlying();
		AnnaDsbRates.AnnaDsbRatesBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum ReturnorPayoutTrigger);
		AnnaDsbRates.AnnaDsbRatesBuilder setReferenceRate(String ReferenceRate);
		AnnaDsbRates.AnnaDsbRatesBuilder setUnderlierCharacteristic(String UnderlierCharacteristic);
		AnnaDsbRates.AnnaDsbRatesBuilder setUnderlyingInstrumentISIN(String UnderlyingInstrumentISIN);
		AnnaDsbRates.AnnaDsbRatesBuilder setOtherLegReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum OtherLegReferenceRateTermUnit);
		AnnaDsbRates.AnnaDsbRatesBuilder setNotionalCurrency(String NotionalCurrency);
		AnnaDsbRates.AnnaDsbRatesBuilder setOtherLegUnderlying(AnnaDsbOtherLegUnderlying OtherLegUnderlying);
		AnnaDsbRates.AnnaDsbRatesBuilder setOtherNotionalCurrency(String OtherNotionalCurrency);
		AnnaDsbRates.AnnaDsbRatesBuilder setReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum ReferenceRateTermUnit);
		AnnaDsbRates.AnnaDsbRatesBuilder setOtherLegReferenceRateTermValue(Integer OtherLegReferenceRateTermValue);
		AnnaDsbRates.AnnaDsbRatesBuilder setOtherLegReferenceRate(String OtherLegReferenceRate);
		AnnaDsbRates.AnnaDsbRatesBuilder setUnderlying(AnnaDsbUnderlying Underlying);
		AnnaDsbRates.AnnaDsbRatesBuilder setOtherLegUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum OtherLegUnderlierCharacteristic);
		AnnaDsbRates.AnnaDsbRatesBuilder setReferenceRateTermValue(Integer ReferenceRateTermValue);
		AnnaDsbRates.AnnaDsbRatesBuilder setUnderlierName(String UnderlierName);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
			processor.processBasic(path.newSubPath("ReferenceRate"), String.class, getReferenceRate(), this);
			processor.processBasic(path.newSubPath("UnderlierCharacteristic"), String.class, getUnderlierCharacteristic(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentISIN"), String.class, getUnderlyingInstrumentISIN(), this);
			processor.processBasic(path.newSubPath("OtherLegReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getOtherLegReferenceRateTermUnit(), this);
			processor.processBasic(path.newSubPath("NotionalCurrency"), String.class, getNotionalCurrency(), this);
			processRosetta(path.newSubPath("OtherLegUnderlying"), processor, AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder.class, getOtherLegUnderlying());
			processor.processBasic(path.newSubPath("OtherNotionalCurrency"), String.class, getOtherNotionalCurrency(), this);
			processor.processBasic(path.newSubPath("ReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getReferenceRateTermUnit(), this);
			processor.processBasic(path.newSubPath("OtherLegReferenceRateTermValue"), Integer.class, getOtherLegReferenceRateTermValue(), this);
			processor.processBasic(path.newSubPath("OtherLegReferenceRate"), String.class, getOtherLegReferenceRate(), this);
			processRosetta(path.newSubPath("Underlying"), processor, AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder.class, getUnderlying());
			processor.processBasic(path.newSubPath("OtherLegUnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getOtherLegUnderlierCharacteristic(), this);
			processor.processBasic(path.newSubPath("ReferenceRateTermValue"), Integer.class, getReferenceRateTermValue(), this);
			processor.processBasic(path.newSubPath("UnderlierName"), String.class, getUnderlierName(), this);
		}
		

		AnnaDsbRates.AnnaDsbRatesBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbRates  ***********************/
	class AnnaDsbRatesImpl implements AnnaDsbRates {
		private final AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		private final String referenceRate;
		private final String underlierCharacteristic;
		private final String underlyingInstrumentISIN;
		private final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum otherLegReferenceRateTermUnit;
		private final String notionalCurrency;
		private final AnnaDsbOtherLegUnderlying otherLegUnderlying;
		private final String otherNotionalCurrency;
		private final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum referenceRateTermUnit;
		private final Integer otherLegReferenceRateTermValue;
		private final String otherLegReferenceRate;
		private final AnnaDsbUnderlying underlying;
		private final AnnaDsbUnderlierCharacteristicEnum otherLegUnderlierCharacteristic;
		private final Integer referenceRateTermValue;
		private final String underlierName;
		
		protected AnnaDsbRatesImpl(AnnaDsbRates.AnnaDsbRatesBuilder builder) {
			this.returnorPayoutTrigger = builder.getReturnorPayoutTrigger();
			this.referenceRate = builder.getReferenceRate();
			this.underlierCharacteristic = builder.getUnderlierCharacteristic();
			this.underlyingInstrumentISIN = builder.getUnderlyingInstrumentISIN();
			this.otherLegReferenceRateTermUnit = builder.getOtherLegReferenceRateTermUnit();
			this.notionalCurrency = builder.getNotionalCurrency();
			this.otherLegUnderlying = ofNullable(builder.getOtherLegUnderlying()).map(f->f.build()).orElse(null);
			this.otherNotionalCurrency = builder.getOtherNotionalCurrency();
			this.referenceRateTermUnit = builder.getReferenceRateTermUnit();
			this.otherLegReferenceRateTermValue = builder.getOtherLegReferenceRateTermValue();
			this.otherLegReferenceRate = builder.getOtherLegReferenceRate();
			this.underlying = ofNullable(builder.getUnderlying()).map(f->f.build()).orElse(null);
			this.otherLegUnderlierCharacteristic = builder.getOtherLegUnderlierCharacteristic();
			this.referenceRateTermValue = builder.getReferenceRateTermValue();
			this.underlierName = builder.getUnderlierName();
		}
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("ReferenceRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRate")
		public String getReferenceRate() {
			return referenceRate;
		}
		
		@Override
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierCharacteristic")
		public String getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentISIN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentISIN")
		public String getUnderlyingInstrumentISIN() {
			return underlyingInstrumentISIN;
		}
		
		@Override
		@RosettaAttribute("OtherLegReferenceRateTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRateTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getOtherLegReferenceRateTermUnit() {
			return otherLegReferenceRateTermUnit;
		}
		
		@Override
		@RosettaAttribute("NotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NotionalCurrency")
		public String getNotionalCurrency() {
			return notionalCurrency;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlying")
		public AnnaDsbOtherLegUnderlying getOtherLegUnderlying() {
			return otherLegUnderlying;
		}
		
		@Override
		@RosettaAttribute("OtherNotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherNotionalCurrency")
		public String getOtherNotionalCurrency() {
			return otherNotionalCurrency;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getReferenceRateTermUnit() {
			return referenceRateTermUnit;
		}
		
		@Override
		@RosettaAttribute("OtherLegReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRateTermValue")
		public Integer getOtherLegReferenceRateTermValue() {
			return otherLegReferenceRateTermValue;
		}
		
		@Override
		@RosettaAttribute("OtherLegReferenceRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRate")
		public String getOtherLegReferenceRate() {
			return otherLegReferenceRate;
		}
		
		@Override
		@RosettaAttribute("Underlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Underlying")
		public AnnaDsbUnderlying getUnderlying() {
			return underlying;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getOtherLegUnderlierCharacteristic() {
			return otherLegUnderlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermValue")
		public Integer getReferenceRateTermValue() {
			return referenceRateTermValue;
		}
		
		@Override
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierName")
		public String getUnderlierName() {
			return underlierName;
		}
		
		@Override
		public AnnaDsbRates build() {
			return this;
		}
		
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder toBuilder() {
			AnnaDsbRates.AnnaDsbRatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbRates.AnnaDsbRatesBuilder builder) {
			ofNullable(getReturnorPayoutTrigger()).ifPresent(builder::setReturnorPayoutTrigger);
			ofNullable(getReferenceRate()).ifPresent(builder::setReferenceRate);
			ofNullable(getUnderlierCharacteristic()).ifPresent(builder::setUnderlierCharacteristic);
			ofNullable(getUnderlyingInstrumentISIN()).ifPresent(builder::setUnderlyingInstrumentISIN);
			ofNullable(getOtherLegReferenceRateTermUnit()).ifPresent(builder::setOtherLegReferenceRateTermUnit);
			ofNullable(getNotionalCurrency()).ifPresent(builder::setNotionalCurrency);
			ofNullable(getOtherLegUnderlying()).ifPresent(builder::setOtherLegUnderlying);
			ofNullable(getOtherNotionalCurrency()).ifPresent(builder::setOtherNotionalCurrency);
			ofNullable(getReferenceRateTermUnit()).ifPresent(builder::setReferenceRateTermUnit);
			ofNullable(getOtherLegReferenceRateTermValue()).ifPresent(builder::setOtherLegReferenceRateTermValue);
			ofNullable(getOtherLegReferenceRate()).ifPresent(builder::setOtherLegReferenceRate);
			ofNullable(getUnderlying()).ifPresent(builder::setUnderlying);
			ofNullable(getOtherLegUnderlierCharacteristic()).ifPresent(builder::setOtherLegUnderlierCharacteristic);
			ofNullable(getReferenceRateTermValue()).ifPresent(builder::setReferenceRateTermValue);
			ofNullable(getUnderlierName()).ifPresent(builder::setUnderlierName);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbRates _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(referenceRate, _that.getReferenceRate())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(underlyingInstrumentISIN, _that.getUnderlyingInstrumentISIN())) return false;
			if (!Objects.equals(otherLegReferenceRateTermUnit, _that.getOtherLegReferenceRateTermUnit())) return false;
			if (!Objects.equals(notionalCurrency, _that.getNotionalCurrency())) return false;
			if (!Objects.equals(otherLegUnderlying, _that.getOtherLegUnderlying())) return false;
			if (!Objects.equals(otherNotionalCurrency, _that.getOtherNotionalCurrency())) return false;
			if (!Objects.equals(referenceRateTermUnit, _that.getReferenceRateTermUnit())) return false;
			if (!Objects.equals(otherLegReferenceRateTermValue, _that.getOtherLegReferenceRateTermValue())) return false;
			if (!Objects.equals(otherLegReferenceRate, _that.getOtherLegReferenceRate())) return false;
			if (!Objects.equals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(otherLegUnderlierCharacteristic, _that.getOtherLegUnderlierCharacteristic())) return false;
			if (!Objects.equals(referenceRateTermValue, _that.getReferenceRateTermValue())) return false;
			if (!Objects.equals(underlierName, _that.getUnderlierName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceRate != null ? referenceRate.hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentISIN != null ? underlyingInstrumentISIN.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRateTermUnit != null ? otherLegReferenceRateTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (notionalCurrency != null ? notionalCurrency.hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlying != null ? otherLegUnderlying.hashCode() : 0);
			_result = 31 * _result + (otherNotionalCurrency != null ? otherNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermUnit != null ? referenceRateTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRateTermValue != null ? otherLegReferenceRateTermValue.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRate != null ? otherLegReferenceRate.hashCode() : 0);
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierCharacteristic != null ? otherLegUnderlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceRateTermValue != null ? referenceRateTermValue.hashCode() : 0);
			_result = 31 * _result + (underlierName != null ? underlierName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbRates {" +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"ReferenceRate=" + this.referenceRate + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"UnderlyingInstrumentISIN=" + this.underlyingInstrumentISIN + ", " +
				"OtherLegReferenceRateTermUnit=" + this.otherLegReferenceRateTermUnit + ", " +
				"NotionalCurrency=" + this.notionalCurrency + ", " +
				"OtherLegUnderlying=" + this.otherLegUnderlying + ", " +
				"OtherNotionalCurrency=" + this.otherNotionalCurrency + ", " +
				"ReferenceRateTermUnit=" + this.referenceRateTermUnit + ", " +
				"OtherLegReferenceRateTermValue=" + this.otherLegReferenceRateTermValue + ", " +
				"OtherLegReferenceRate=" + this.otherLegReferenceRate + ", " +
				"Underlying=" + this.underlying + ", " +
				"OtherLegUnderlierCharacteristic=" + this.otherLegUnderlierCharacteristic + ", " +
				"ReferenceRateTermValue=" + this.referenceRateTermValue + ", " +
				"UnderlierName=" + this.underlierName +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbRates  ***********************/
	class AnnaDsbRatesBuilderImpl implements AnnaDsbRates.AnnaDsbRatesBuilder {
	
		protected AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		protected String referenceRate;
		protected String underlierCharacteristic;
		protected String underlyingInstrumentISIN;
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum otherLegReferenceRateTermUnit;
		protected String notionalCurrency;
		protected AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder otherLegUnderlying;
		protected String otherNotionalCurrency;
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum referenceRateTermUnit;
		protected Integer otherLegReferenceRateTermValue;
		protected String otherLegReferenceRate;
		protected AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder underlying;
		protected AnnaDsbUnderlierCharacteristicEnum otherLegUnderlierCharacteristic;
		protected Integer referenceRateTermValue;
		protected String underlierName;
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("ReferenceRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRate")
		public String getReferenceRate() {
			return referenceRate;
		}
		
		@Override
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierCharacteristic")
		public String getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentISIN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentISIN")
		public String getUnderlyingInstrumentISIN() {
			return underlyingInstrumentISIN;
		}
		
		@Override
		@RosettaAttribute("OtherLegReferenceRateTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRateTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getOtherLegReferenceRateTermUnit() {
			return otherLegReferenceRateTermUnit;
		}
		
		@Override
		@RosettaAttribute("NotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NotionalCurrency")
		public String getNotionalCurrency() {
			return notionalCurrency;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlying")
		public AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder getOtherLegUnderlying() {
			return otherLegUnderlying;
		}
		
		@Override
		public AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder getOrCreateOtherLegUnderlying() {
			AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder result;
			if (otherLegUnderlying!=null) {
				result = otherLegUnderlying;
			}
			else {
				result = otherLegUnderlying = AnnaDsbOtherLegUnderlying.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("OtherNotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherNotionalCurrency")
		public String getOtherNotionalCurrency() {
			return otherNotionalCurrency;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getReferenceRateTermUnit() {
			return referenceRateTermUnit;
		}
		
		@Override
		@RosettaAttribute("OtherLegReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRateTermValue")
		public Integer getOtherLegReferenceRateTermValue() {
			return otherLegReferenceRateTermValue;
		}
		
		@Override
		@RosettaAttribute("OtherLegReferenceRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRate")
		public String getOtherLegReferenceRate() {
			return otherLegReferenceRate;
		}
		
		@Override
		@RosettaAttribute("Underlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Underlying")
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getUnderlying() {
			return underlying;
		}
		
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getOrCreateUnderlying() {
			AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder result;
			if (underlying!=null) {
				result = underlying;
			}
			else {
				result = underlying = AnnaDsbUnderlying.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getOtherLegUnderlierCharacteristic() {
			return otherLegUnderlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermValue")
		public Integer getReferenceRateTermValue() {
			return referenceRateTermValue;
		}
		
		@Override
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierName")
		public String getUnderlierName() {
			return underlierName;
		}
		
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum _returnorPayoutTrigger) {
			this.returnorPayoutTrigger = _returnorPayoutTrigger == null ? null : _returnorPayoutTrigger;
			return this;
		}
		
		@RosettaAttribute("ReferenceRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReferenceRate")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setReferenceRate(String _referenceRate) {
			this.referenceRate = _referenceRate == null ? null : _referenceRate;
			return this;
		}
		
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierCharacteristic")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setUnderlierCharacteristic(String _underlierCharacteristic) {
			this.underlierCharacteristic = _underlierCharacteristic == null ? null : _underlierCharacteristic;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentISIN")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentISIN")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setUnderlyingInstrumentISIN(String _underlyingInstrumentISIN) {
			this.underlyingInstrumentISIN = _underlyingInstrumentISIN == null ? null : _underlyingInstrumentISIN;
			return this;
		}
		
		@RosettaAttribute("OtherLegReferenceRateTermUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegReferenceRateTermUnit")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setOtherLegReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum _otherLegReferenceRateTermUnit) {
			this.otherLegReferenceRateTermUnit = _otherLegReferenceRateTermUnit == null ? null : _otherLegReferenceRateTermUnit;
			return this;
		}
		
		@RosettaAttribute("NotionalCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("NotionalCurrency")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setNotionalCurrency(String _notionalCurrency) {
			this.notionalCurrency = _notionalCurrency == null ? null : _notionalCurrency;
			return this;
		}
		
		@RosettaAttribute("OtherLegUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegUnderlying")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setOtherLegUnderlying(AnnaDsbOtherLegUnderlying _otherLegUnderlying) {
			this.otherLegUnderlying = _otherLegUnderlying == null ? null : _otherLegUnderlying.toBuilder();
			return this;
		}
		
		@RosettaAttribute("OtherNotionalCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherNotionalCurrency")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setOtherNotionalCurrency(String _otherNotionalCurrency) {
			this.otherNotionalCurrency = _otherNotionalCurrency == null ? null : _otherNotionalCurrency;
			return this;
		}
		
		@RosettaAttribute("ReferenceRateTermUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReferenceRateTermUnit")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum _referenceRateTermUnit) {
			this.referenceRateTermUnit = _referenceRateTermUnit == null ? null : _referenceRateTermUnit;
			return this;
		}
		
		@RosettaAttribute("OtherLegReferenceRateTermValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegReferenceRateTermValue")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setOtherLegReferenceRateTermValue(Integer _otherLegReferenceRateTermValue) {
			this.otherLegReferenceRateTermValue = _otherLegReferenceRateTermValue == null ? null : _otherLegReferenceRateTermValue;
			return this;
		}
		
		@RosettaAttribute("OtherLegReferenceRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegReferenceRate")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setOtherLegReferenceRate(String _otherLegReferenceRate) {
			this.otherLegReferenceRate = _otherLegReferenceRate == null ? null : _otherLegReferenceRate;
			return this;
		}
		
		@RosettaAttribute("Underlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Underlying")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setUnderlying(AnnaDsbUnderlying _underlying) {
			this.underlying = _underlying == null ? null : _underlying.toBuilder();
			return this;
		}
		
		@RosettaAttribute("OtherLegUnderlierCharacteristic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegUnderlierCharacteristic")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setOtherLegUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum _otherLegUnderlierCharacteristic) {
			this.otherLegUnderlierCharacteristic = _otherLegUnderlierCharacteristic == null ? null : _otherLegUnderlierCharacteristic;
			return this;
		}
		
		@RosettaAttribute("ReferenceRateTermValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReferenceRateTermValue")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setReferenceRateTermValue(Integer _referenceRateTermValue) {
			this.referenceRateTermValue = _referenceRateTermValue == null ? null : _referenceRateTermValue;
			return this;
		}
		
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierName")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder setUnderlierName(String _underlierName) {
			this.underlierName = _underlierName == null ? null : _underlierName;
			return this;
		}
		
		@Override
		public AnnaDsbRates build() {
			return new AnnaDsbRates.AnnaDsbRatesImpl(this);
		}
		
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder prune() {
			if (otherLegUnderlying!=null && !otherLegUnderlying.prune().hasData()) otherLegUnderlying = null;
			if (underlying!=null && !underlying.prune().hasData()) underlying = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReturnorPayoutTrigger()!=null) return true;
			if (getReferenceRate()!=null) return true;
			if (getUnderlierCharacteristic()!=null) return true;
			if (getUnderlyingInstrumentISIN()!=null) return true;
			if (getOtherLegReferenceRateTermUnit()!=null) return true;
			if (getNotionalCurrency()!=null) return true;
			if (getOtherLegUnderlying()!=null && getOtherLegUnderlying().hasData()) return true;
			if (getOtherNotionalCurrency()!=null) return true;
			if (getReferenceRateTermUnit()!=null) return true;
			if (getOtherLegReferenceRateTermValue()!=null) return true;
			if (getOtherLegReferenceRate()!=null) return true;
			if (getUnderlying()!=null && getUnderlying().hasData()) return true;
			if (getOtherLegUnderlierCharacteristic()!=null) return true;
			if (getReferenceRateTermValue()!=null) return true;
			if (getUnderlierName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbRates.AnnaDsbRatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbRates.AnnaDsbRatesBuilder o = (AnnaDsbRates.AnnaDsbRatesBuilder) other;
			
			merger.mergeRosetta(getOtherLegUnderlying(), o.getOtherLegUnderlying(), this::setOtherLegUnderlying);
			merger.mergeRosetta(getUnderlying(), o.getUnderlying(), this::setUnderlying);
			
			merger.mergeBasic(getReturnorPayoutTrigger(), o.getReturnorPayoutTrigger(), this::setReturnorPayoutTrigger);
			merger.mergeBasic(getReferenceRate(), o.getReferenceRate(), this::setReferenceRate);
			merger.mergeBasic(getUnderlierCharacteristic(), o.getUnderlierCharacteristic(), this::setUnderlierCharacteristic);
			merger.mergeBasic(getUnderlyingInstrumentISIN(), o.getUnderlyingInstrumentISIN(), this::setUnderlyingInstrumentISIN);
			merger.mergeBasic(getOtherLegReferenceRateTermUnit(), o.getOtherLegReferenceRateTermUnit(), this::setOtherLegReferenceRateTermUnit);
			merger.mergeBasic(getNotionalCurrency(), o.getNotionalCurrency(), this::setNotionalCurrency);
			merger.mergeBasic(getOtherNotionalCurrency(), o.getOtherNotionalCurrency(), this::setOtherNotionalCurrency);
			merger.mergeBasic(getReferenceRateTermUnit(), o.getReferenceRateTermUnit(), this::setReferenceRateTermUnit);
			merger.mergeBasic(getOtherLegReferenceRateTermValue(), o.getOtherLegReferenceRateTermValue(), this::setOtherLegReferenceRateTermValue);
			merger.mergeBasic(getOtherLegReferenceRate(), o.getOtherLegReferenceRate(), this::setOtherLegReferenceRate);
			merger.mergeBasic(getOtherLegUnderlierCharacteristic(), o.getOtherLegUnderlierCharacteristic(), this::setOtherLegUnderlierCharacteristic);
			merger.mergeBasic(getReferenceRateTermValue(), o.getReferenceRateTermValue(), this::setReferenceRateTermValue);
			merger.mergeBasic(getUnderlierName(), o.getUnderlierName(), this::setUnderlierName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbRates _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(referenceRate, _that.getReferenceRate())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(underlyingInstrumentISIN, _that.getUnderlyingInstrumentISIN())) return false;
			if (!Objects.equals(otherLegReferenceRateTermUnit, _that.getOtherLegReferenceRateTermUnit())) return false;
			if (!Objects.equals(notionalCurrency, _that.getNotionalCurrency())) return false;
			if (!Objects.equals(otherLegUnderlying, _that.getOtherLegUnderlying())) return false;
			if (!Objects.equals(otherNotionalCurrency, _that.getOtherNotionalCurrency())) return false;
			if (!Objects.equals(referenceRateTermUnit, _that.getReferenceRateTermUnit())) return false;
			if (!Objects.equals(otherLegReferenceRateTermValue, _that.getOtherLegReferenceRateTermValue())) return false;
			if (!Objects.equals(otherLegReferenceRate, _that.getOtherLegReferenceRate())) return false;
			if (!Objects.equals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(otherLegUnderlierCharacteristic, _that.getOtherLegUnderlierCharacteristic())) return false;
			if (!Objects.equals(referenceRateTermValue, _that.getReferenceRateTermValue())) return false;
			if (!Objects.equals(underlierName, _that.getUnderlierName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceRate != null ? referenceRate.hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentISIN != null ? underlyingInstrumentISIN.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRateTermUnit != null ? otherLegReferenceRateTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (notionalCurrency != null ? notionalCurrency.hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlying != null ? otherLegUnderlying.hashCode() : 0);
			_result = 31 * _result + (otherNotionalCurrency != null ? otherNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermUnit != null ? referenceRateTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRateTermValue != null ? otherLegReferenceRateTermValue.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRate != null ? otherLegReferenceRate.hashCode() : 0);
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierCharacteristic != null ? otherLegUnderlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceRateTermValue != null ? referenceRateTermValue.hashCode() : 0);
			_result = 31 * _result + (underlierName != null ? underlierName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbRatesBuilder {" +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"ReferenceRate=" + this.referenceRate + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"UnderlyingInstrumentISIN=" + this.underlyingInstrumentISIN + ", " +
				"OtherLegReferenceRateTermUnit=" + this.otherLegReferenceRateTermUnit + ", " +
				"NotionalCurrency=" + this.notionalCurrency + ", " +
				"OtherLegUnderlying=" + this.otherLegUnderlying + ", " +
				"OtherNotionalCurrency=" + this.otherNotionalCurrency + ", " +
				"ReferenceRateTermUnit=" + this.referenceRateTermUnit + ", " +
				"OtherLegReferenceRateTermValue=" + this.otherLegReferenceRateTermValue + ", " +
				"OtherLegReferenceRate=" + this.otherLegReferenceRate + ", " +
				"Underlying=" + this.underlying + ", " +
				"OtherLegUnderlierCharacteristic=" + this.otherLegUnderlierCharacteristic + ", " +
				"ReferenceRateTermValue=" + this.referenceRateTermValue + ", " +
				"UnderlierName=" + this.underlierName +
			'}';
		}
	}
}

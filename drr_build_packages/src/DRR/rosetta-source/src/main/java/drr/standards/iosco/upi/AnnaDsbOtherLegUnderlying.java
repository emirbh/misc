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
import drr.standards.iosco.upi.meta.AnnaDsbOtherLegUnderlyingMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbOtherLegUnderlying", builder=AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbOtherLegUnderlying", model="drr", builder=AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilderImpl.class, version="7.7.0")
public interface AnnaDsbOtherLegUnderlying extends RosettaModelObject {

	AnnaDsbOtherLegUnderlyingMeta metaData = new AnnaDsbOtherLegUnderlyingMeta();

	/*********************** Getter Methods  ***********************/
	String getOtherLegUnderlierID();
	String getOtherLegReferenceRate();
	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getOtherLegReferenceRateTermUnit();
	AnnaDsbUnderlierCharacteristicEnum getOtherLegUnderlierCharacteristic();
	AnnaDsbOtherLegUnderlierIDSourceEnum getOtherLegUnderlierIDSource();
	AnnaDsbEmpty getBasket();
	Integer getOtherLegReferenceRateTermValue();

	/*********************** Build Methods  ***********************/
	AnnaDsbOtherLegUnderlying build();
	
	AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder toBuilder();
	
	static AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder builder() {
		return new AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbOtherLegUnderlying> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbOtherLegUnderlying> getType() {
		return AnnaDsbOtherLegUnderlying.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("OtherLegUnderlierID"), String.class, getOtherLegUnderlierID(), this);
		processor.processBasic(path.newSubPath("OtherLegReferenceRate"), String.class, getOtherLegReferenceRate(), this);
		processor.processBasic(path.newSubPath("OtherLegReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getOtherLegReferenceRateTermUnit(), this);
		processor.processBasic(path.newSubPath("OtherLegUnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getOtherLegUnderlierCharacteristic(), this);
		processor.processBasic(path.newSubPath("OtherLegUnderlierIDSource"), AnnaDsbOtherLegUnderlierIDSourceEnum.class, getOtherLegUnderlierIDSource(), this);
		processRosetta(path.newSubPath("Basket"), processor, AnnaDsbEmpty.class, getBasket());
		processor.processBasic(path.newSubPath("OtherLegReferenceRateTermValue"), Integer.class, getOtherLegReferenceRateTermValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbOtherLegUnderlyingBuilder extends AnnaDsbOtherLegUnderlying, RosettaModelObjectBuilder {
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateBasket();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getBasket();
		AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setOtherLegUnderlierID(String OtherLegUnderlierID);
		AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setOtherLegReferenceRate(String OtherLegReferenceRate);
		AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setOtherLegReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum OtherLegReferenceRateTermUnit);
		AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setOtherLegUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum OtherLegUnderlierCharacteristic);
		AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setOtherLegUnderlierIDSource(AnnaDsbOtherLegUnderlierIDSourceEnum OtherLegUnderlierIDSource);
		AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setBasket(AnnaDsbEmpty Basket);
		AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setOtherLegReferenceRateTermValue(Integer OtherLegReferenceRateTermValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("OtherLegUnderlierID"), String.class, getOtherLegUnderlierID(), this);
			processor.processBasic(path.newSubPath("OtherLegReferenceRate"), String.class, getOtherLegReferenceRate(), this);
			processor.processBasic(path.newSubPath("OtherLegReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getOtherLegReferenceRateTermUnit(), this);
			processor.processBasic(path.newSubPath("OtherLegUnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getOtherLegUnderlierCharacteristic(), this);
			processor.processBasic(path.newSubPath("OtherLegUnderlierIDSource"), AnnaDsbOtherLegUnderlierIDSourceEnum.class, getOtherLegUnderlierIDSource(), this);
			processRosetta(path.newSubPath("Basket"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getBasket());
			processor.processBasic(path.newSubPath("OtherLegReferenceRateTermValue"), Integer.class, getOtherLegReferenceRateTermValue(), this);
		}
		

		AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbOtherLegUnderlying  ***********************/
	class AnnaDsbOtherLegUnderlyingImpl implements AnnaDsbOtherLegUnderlying {
		private final String otherLegUnderlierID;
		private final String otherLegReferenceRate;
		private final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum otherLegReferenceRateTermUnit;
		private final AnnaDsbUnderlierCharacteristicEnum otherLegUnderlierCharacteristic;
		private final AnnaDsbOtherLegUnderlierIDSourceEnum otherLegUnderlierIDSource;
		private final AnnaDsbEmpty basket;
		private final Integer otherLegReferenceRateTermValue;
		
		protected AnnaDsbOtherLegUnderlyingImpl(AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder builder) {
			this.otherLegUnderlierID = builder.getOtherLegUnderlierID();
			this.otherLegReferenceRate = builder.getOtherLegReferenceRate();
			this.otherLegReferenceRateTermUnit = builder.getOtherLegReferenceRateTermUnit();
			this.otherLegUnderlierCharacteristic = builder.getOtherLegUnderlierCharacteristic();
			this.otherLegUnderlierIDSource = builder.getOtherLegUnderlierIDSource();
			this.basket = ofNullable(builder.getBasket()).map(f->f.build()).orElse(null);
			this.otherLegReferenceRateTermValue = builder.getOtherLegReferenceRateTermValue();
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierID")
		public String getOtherLegUnderlierID() {
			return otherLegUnderlierID;
		}
		
		@Override
		@RosettaAttribute("OtherLegReferenceRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRate")
		public String getOtherLegReferenceRate() {
			return otherLegReferenceRate;
		}
		
		@Override
		@RosettaAttribute("OtherLegReferenceRateTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRateTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getOtherLegReferenceRateTermUnit() {
			return otherLegReferenceRateTermUnit;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getOtherLegUnderlierCharacteristic() {
			return otherLegUnderlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierIDSource")
		public AnnaDsbOtherLegUnderlierIDSourceEnum getOtherLegUnderlierIDSource() {
			return otherLegUnderlierIDSource;
		}
		
		@Override
		@RosettaAttribute("Basket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Basket")
		public AnnaDsbEmpty getBasket() {
			return basket;
		}
		
		@Override
		@RosettaAttribute("OtherLegReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRateTermValue")
		public Integer getOtherLegReferenceRateTermValue() {
			return otherLegReferenceRateTermValue;
		}
		
		@Override
		public AnnaDsbOtherLegUnderlying build() {
			return this;
		}
		
		@Override
		public AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder toBuilder() {
			AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder builder) {
			ofNullable(getOtherLegUnderlierID()).ifPresent(builder::setOtherLegUnderlierID);
			ofNullable(getOtherLegReferenceRate()).ifPresent(builder::setOtherLegReferenceRate);
			ofNullable(getOtherLegReferenceRateTermUnit()).ifPresent(builder::setOtherLegReferenceRateTermUnit);
			ofNullable(getOtherLegUnderlierCharacteristic()).ifPresent(builder::setOtherLegUnderlierCharacteristic);
			ofNullable(getOtherLegUnderlierIDSource()).ifPresent(builder::setOtherLegUnderlierIDSource);
			ofNullable(getBasket()).ifPresent(builder::setBasket);
			ofNullable(getOtherLegReferenceRateTermValue()).ifPresent(builder::setOtherLegReferenceRateTermValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbOtherLegUnderlying _that = getType().cast(o);
		
			if (!Objects.equals(otherLegUnderlierID, _that.getOtherLegUnderlierID())) return false;
			if (!Objects.equals(otherLegReferenceRate, _that.getOtherLegReferenceRate())) return false;
			if (!Objects.equals(otherLegReferenceRateTermUnit, _that.getOtherLegReferenceRateTermUnit())) return false;
			if (!Objects.equals(otherLegUnderlierCharacteristic, _that.getOtherLegUnderlierCharacteristic())) return false;
			if (!Objects.equals(otherLegUnderlierIDSource, _that.getOtherLegUnderlierIDSource())) return false;
			if (!Objects.equals(basket, _that.getBasket())) return false;
			if (!Objects.equals(otherLegReferenceRateTermValue, _that.getOtherLegReferenceRateTermValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (otherLegUnderlierID != null ? otherLegUnderlierID.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRate != null ? otherLegReferenceRate.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRateTermUnit != null ? otherLegReferenceRateTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierCharacteristic != null ? otherLegUnderlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierIDSource != null ? otherLegUnderlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (basket != null ? basket.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRateTermValue != null ? otherLegReferenceRateTermValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbOtherLegUnderlying {" +
				"OtherLegUnderlierID=" + this.otherLegUnderlierID + ", " +
				"OtherLegReferenceRate=" + this.otherLegReferenceRate + ", " +
				"OtherLegReferenceRateTermUnit=" + this.otherLegReferenceRateTermUnit + ", " +
				"OtherLegUnderlierCharacteristic=" + this.otherLegUnderlierCharacteristic + ", " +
				"OtherLegUnderlierIDSource=" + this.otherLegUnderlierIDSource + ", " +
				"Basket=" + this.basket + ", " +
				"OtherLegReferenceRateTermValue=" + this.otherLegReferenceRateTermValue +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbOtherLegUnderlying  ***********************/
	class AnnaDsbOtherLegUnderlyingBuilderImpl implements AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder {
	
		protected String otherLegUnderlierID;
		protected String otherLegReferenceRate;
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum otherLegReferenceRateTermUnit;
		protected AnnaDsbUnderlierCharacteristicEnum otherLegUnderlierCharacteristic;
		protected AnnaDsbOtherLegUnderlierIDSourceEnum otherLegUnderlierIDSource;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder basket;
		protected Integer otherLegReferenceRateTermValue;
		
		@Override
		@RosettaAttribute("OtherLegUnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierID")
		public String getOtherLegUnderlierID() {
			return otherLegUnderlierID;
		}
		
		@Override
		@RosettaAttribute("OtherLegReferenceRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRate")
		public String getOtherLegReferenceRate() {
			return otherLegReferenceRate;
		}
		
		@Override
		@RosettaAttribute("OtherLegReferenceRateTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRateTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getOtherLegReferenceRateTermUnit() {
			return otherLegReferenceRateTermUnit;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getOtherLegUnderlierCharacteristic() {
			return otherLegUnderlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierIDSource")
		public AnnaDsbOtherLegUnderlierIDSourceEnum getOtherLegUnderlierIDSource() {
			return otherLegUnderlierIDSource;
		}
		
		@Override
		@RosettaAttribute("Basket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Basket")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getBasket() {
			return basket;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateBasket() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (basket!=null) {
				result = basket;
			}
			else {
				result = basket = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("OtherLegReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRateTermValue")
		public Integer getOtherLegReferenceRateTermValue() {
			return otherLegReferenceRateTermValue;
		}
		
		@RosettaAttribute("OtherLegUnderlierID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegUnderlierID")
		@Override
		public AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setOtherLegUnderlierID(String _otherLegUnderlierID) {
			this.otherLegUnderlierID = _otherLegUnderlierID == null ? null : _otherLegUnderlierID;
			return this;
		}
		
		@RosettaAttribute("OtherLegReferenceRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegReferenceRate")
		@Override
		public AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setOtherLegReferenceRate(String _otherLegReferenceRate) {
			this.otherLegReferenceRate = _otherLegReferenceRate == null ? null : _otherLegReferenceRate;
			return this;
		}
		
		@RosettaAttribute("OtherLegReferenceRateTermUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegReferenceRateTermUnit")
		@Override
		public AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setOtherLegReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum _otherLegReferenceRateTermUnit) {
			this.otherLegReferenceRateTermUnit = _otherLegReferenceRateTermUnit == null ? null : _otherLegReferenceRateTermUnit;
			return this;
		}
		
		@RosettaAttribute("OtherLegUnderlierCharacteristic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegUnderlierCharacteristic")
		@Override
		public AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setOtherLegUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum _otherLegUnderlierCharacteristic) {
			this.otherLegUnderlierCharacteristic = _otherLegUnderlierCharacteristic == null ? null : _otherLegUnderlierCharacteristic;
			return this;
		}
		
		@RosettaAttribute("OtherLegUnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegUnderlierIDSource")
		@Override
		public AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setOtherLegUnderlierIDSource(AnnaDsbOtherLegUnderlierIDSourceEnum _otherLegUnderlierIDSource) {
			this.otherLegUnderlierIDSource = _otherLegUnderlierIDSource == null ? null : _otherLegUnderlierIDSource;
			return this;
		}
		
		@RosettaAttribute("Basket")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Basket")
		@Override
		public AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setBasket(AnnaDsbEmpty _basket) {
			this.basket = _basket == null ? null : _basket.toBuilder();
			return this;
		}
		
		@RosettaAttribute("OtherLegReferenceRateTermValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegReferenceRateTermValue")
		@Override
		public AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder setOtherLegReferenceRateTermValue(Integer _otherLegReferenceRateTermValue) {
			this.otherLegReferenceRateTermValue = _otherLegReferenceRateTermValue == null ? null : _otherLegReferenceRateTermValue;
			return this;
		}
		
		@Override
		public AnnaDsbOtherLegUnderlying build() {
			return new AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingImpl(this);
		}
		
		@Override
		public AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder prune() {
			if (basket!=null && !basket.prune().hasData()) basket = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOtherLegUnderlierID()!=null) return true;
			if (getOtherLegReferenceRate()!=null) return true;
			if (getOtherLegReferenceRateTermUnit()!=null) return true;
			if (getOtherLegUnderlierCharacteristic()!=null) return true;
			if (getOtherLegUnderlierIDSource()!=null) return true;
			if (getBasket()!=null && getBasket().hasData()) return true;
			if (getOtherLegReferenceRateTermValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder o = (AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder) other;
			
			merger.mergeRosetta(getBasket(), o.getBasket(), this::setBasket);
			
			merger.mergeBasic(getOtherLegUnderlierID(), o.getOtherLegUnderlierID(), this::setOtherLegUnderlierID);
			merger.mergeBasic(getOtherLegReferenceRate(), o.getOtherLegReferenceRate(), this::setOtherLegReferenceRate);
			merger.mergeBasic(getOtherLegReferenceRateTermUnit(), o.getOtherLegReferenceRateTermUnit(), this::setOtherLegReferenceRateTermUnit);
			merger.mergeBasic(getOtherLegUnderlierCharacteristic(), o.getOtherLegUnderlierCharacteristic(), this::setOtherLegUnderlierCharacteristic);
			merger.mergeBasic(getOtherLegUnderlierIDSource(), o.getOtherLegUnderlierIDSource(), this::setOtherLegUnderlierIDSource);
			merger.mergeBasic(getOtherLegReferenceRateTermValue(), o.getOtherLegReferenceRateTermValue(), this::setOtherLegReferenceRateTermValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbOtherLegUnderlying _that = getType().cast(o);
		
			if (!Objects.equals(otherLegUnderlierID, _that.getOtherLegUnderlierID())) return false;
			if (!Objects.equals(otherLegReferenceRate, _that.getOtherLegReferenceRate())) return false;
			if (!Objects.equals(otherLegReferenceRateTermUnit, _that.getOtherLegReferenceRateTermUnit())) return false;
			if (!Objects.equals(otherLegUnderlierCharacteristic, _that.getOtherLegUnderlierCharacteristic())) return false;
			if (!Objects.equals(otherLegUnderlierIDSource, _that.getOtherLegUnderlierIDSource())) return false;
			if (!Objects.equals(basket, _that.getBasket())) return false;
			if (!Objects.equals(otherLegReferenceRateTermValue, _that.getOtherLegReferenceRateTermValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (otherLegUnderlierID != null ? otherLegUnderlierID.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRate != null ? otherLegReferenceRate.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRateTermUnit != null ? otherLegReferenceRateTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierCharacteristic != null ? otherLegUnderlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierIDSource != null ? otherLegUnderlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (basket != null ? basket.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRateTermValue != null ? otherLegReferenceRateTermValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbOtherLegUnderlyingBuilder {" +
				"OtherLegUnderlierID=" + this.otherLegUnderlierID + ", " +
				"OtherLegReferenceRate=" + this.otherLegReferenceRate + ", " +
				"OtherLegReferenceRateTermUnit=" + this.otherLegReferenceRateTermUnit + ", " +
				"OtherLegUnderlierCharacteristic=" + this.otherLegUnderlierCharacteristic + ", " +
				"OtherLegUnderlierIDSource=" + this.otherLegUnderlierIDSource + ", " +
				"Basket=" + this.basket + ", " +
				"OtherLegReferenceRateTermValue=" + this.otherLegReferenceRateTermValue +
			'}';
		}
	}
}

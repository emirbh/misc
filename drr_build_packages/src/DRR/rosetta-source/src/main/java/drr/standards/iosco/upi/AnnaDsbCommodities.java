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
import drr.standards.iosco.upi.meta.AnnaDsbCommoditiesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbCommodities", builder=AnnaDsbCommodities.AnnaDsbCommoditiesBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbCommodities", model="drr", builder=AnnaDsbCommodities.AnnaDsbCommoditiesBuilderImpl.class, version="7.7.0")
public interface AnnaDsbCommodities extends RosettaModelObject {

	AnnaDsbCommoditiesMeta metaData = new AnnaDsbCommoditiesMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger();
	String getSubProduct();
	AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic();
	String getReferenceRate();
	String getAdditionalSubProduct();
	String getOtherReferenceRate();
	String getNotionalCurrency();
	String getOtherNotionalCurrency();
	AnnaDsbOtherUnderlying getOtherUnderlying();
	AnnaDsbUnderlierCharacteristicEnum getOtherUnderlierCharacteristic();
	String getOtherSubProduct();
	AnnaDsbUnderlying getUnderlying();
	AnnaDsbBaseProduct getOtherBaseProduct();
	String getUnderlyingInstrumentIndex();
	String getUnderlyingInstrumentIndexProp();
	AnnaDsbBaseProduct getBaseProduct();
	String getUnderlierName();
	String getOtherAdditionalSubProduct();

	/*********************** Build Methods  ***********************/
	AnnaDsbCommodities build();
	
	AnnaDsbCommodities.AnnaDsbCommoditiesBuilder toBuilder();
	
	static AnnaDsbCommodities.AnnaDsbCommoditiesBuilder builder() {
		return new AnnaDsbCommodities.AnnaDsbCommoditiesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbCommodities> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbCommodities> getType() {
		return AnnaDsbCommodities.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
		processor.processBasic(path.newSubPath("SubProduct"), String.class, getSubProduct(), this);
		processor.processBasic(path.newSubPath("UnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getUnderlierCharacteristic(), this);
		processor.processBasic(path.newSubPath("ReferenceRate"), String.class, getReferenceRate(), this);
		processor.processBasic(path.newSubPath("AdditionalSubProduct"), String.class, getAdditionalSubProduct(), this);
		processor.processBasic(path.newSubPath("OtherReferenceRate"), String.class, getOtherReferenceRate(), this);
		processor.processBasic(path.newSubPath("NotionalCurrency"), String.class, getNotionalCurrency(), this);
		processor.processBasic(path.newSubPath("OtherNotionalCurrency"), String.class, getOtherNotionalCurrency(), this);
		processRosetta(path.newSubPath("OtherUnderlying"), processor, AnnaDsbOtherUnderlying.class, getOtherUnderlying());
		processor.processBasic(path.newSubPath("OtherUnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getOtherUnderlierCharacteristic(), this);
		processor.processBasic(path.newSubPath("OtherSubProduct"), String.class, getOtherSubProduct(), this);
		processRosetta(path.newSubPath("Underlying"), processor, AnnaDsbUnderlying.class, getUnderlying());
		processRosetta(path.newSubPath("OtherBaseProduct"), processor, AnnaDsbBaseProduct.class, getOtherBaseProduct());
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndex"), String.class, getUnderlyingInstrumentIndex(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexProp"), String.class, getUnderlyingInstrumentIndexProp(), this);
		processRosetta(path.newSubPath("BaseProduct"), processor, AnnaDsbBaseProduct.class, getBaseProduct());
		processor.processBasic(path.newSubPath("UnderlierName"), String.class, getUnderlierName(), this);
		processor.processBasic(path.newSubPath("OtherAdditionalSubProduct"), String.class, getOtherAdditionalSubProduct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbCommoditiesBuilder extends AnnaDsbCommodities, RosettaModelObjectBuilder {
		AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder getOrCreateOtherUnderlying();
		@Override
		AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder getOtherUnderlying();
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getOrCreateUnderlying();
		@Override
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getUnderlying();
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder getOrCreateOtherBaseProduct();
		@Override
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder getOtherBaseProduct();
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder getOrCreateBaseProduct();
		@Override
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder getBaseProduct();
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum ReturnorPayoutTrigger);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setSubProduct(String SubProduct);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum UnderlierCharacteristic);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setReferenceRate(String ReferenceRate);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setAdditionalSubProduct(String AdditionalSubProduct);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherReferenceRate(String OtherReferenceRate);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setNotionalCurrency(String NotionalCurrency);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherNotionalCurrency(String OtherNotionalCurrency);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherUnderlying(AnnaDsbOtherUnderlying OtherUnderlying);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum OtherUnderlierCharacteristic);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherSubProduct(String OtherSubProduct);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setUnderlying(AnnaDsbUnderlying Underlying);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherBaseProduct(AnnaDsbBaseProduct OtherBaseProduct);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setUnderlyingInstrumentIndex(String UnderlyingInstrumentIndex);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setUnderlyingInstrumentIndexProp(String UnderlyingInstrumentIndexProp);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setBaseProduct(AnnaDsbBaseProduct BaseProduct);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setUnderlierName(String UnderlierName);
		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherAdditionalSubProduct(String OtherAdditionalSubProduct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
			processor.processBasic(path.newSubPath("SubProduct"), String.class, getSubProduct(), this);
			processor.processBasic(path.newSubPath("UnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getUnderlierCharacteristic(), this);
			processor.processBasic(path.newSubPath("ReferenceRate"), String.class, getReferenceRate(), this);
			processor.processBasic(path.newSubPath("AdditionalSubProduct"), String.class, getAdditionalSubProduct(), this);
			processor.processBasic(path.newSubPath("OtherReferenceRate"), String.class, getOtherReferenceRate(), this);
			processor.processBasic(path.newSubPath("NotionalCurrency"), String.class, getNotionalCurrency(), this);
			processor.processBasic(path.newSubPath("OtherNotionalCurrency"), String.class, getOtherNotionalCurrency(), this);
			processRosetta(path.newSubPath("OtherUnderlying"), processor, AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder.class, getOtherUnderlying());
			processor.processBasic(path.newSubPath("OtherUnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getOtherUnderlierCharacteristic(), this);
			processor.processBasic(path.newSubPath("OtherSubProduct"), String.class, getOtherSubProduct(), this);
			processRosetta(path.newSubPath("Underlying"), processor, AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder.class, getUnderlying());
			processRosetta(path.newSubPath("OtherBaseProduct"), processor, AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder.class, getOtherBaseProduct());
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndex"), String.class, getUnderlyingInstrumentIndex(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexProp"), String.class, getUnderlyingInstrumentIndexProp(), this);
			processRosetta(path.newSubPath("BaseProduct"), processor, AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder.class, getBaseProduct());
			processor.processBasic(path.newSubPath("UnderlierName"), String.class, getUnderlierName(), this);
			processor.processBasic(path.newSubPath("OtherAdditionalSubProduct"), String.class, getOtherAdditionalSubProduct(), this);
		}
		

		AnnaDsbCommodities.AnnaDsbCommoditiesBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbCommodities  ***********************/
	class AnnaDsbCommoditiesImpl implements AnnaDsbCommodities {
		private final AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		private final String subProduct;
		private final AnnaDsbUnderlierCharacteristicEnum underlierCharacteristic;
		private final String referenceRate;
		private final String additionalSubProduct;
		private final String otherReferenceRate;
		private final String notionalCurrency;
		private final String otherNotionalCurrency;
		private final AnnaDsbOtherUnderlying otherUnderlying;
		private final AnnaDsbUnderlierCharacteristicEnum otherUnderlierCharacteristic;
		private final String otherSubProduct;
		private final AnnaDsbUnderlying underlying;
		private final AnnaDsbBaseProduct otherBaseProduct;
		private final String underlyingInstrumentIndex;
		private final String underlyingInstrumentIndexProp;
		private final AnnaDsbBaseProduct baseProduct;
		private final String underlierName;
		private final String otherAdditionalSubProduct;
		
		protected AnnaDsbCommoditiesImpl(AnnaDsbCommodities.AnnaDsbCommoditiesBuilder builder) {
			this.returnorPayoutTrigger = builder.getReturnorPayoutTrigger();
			this.subProduct = builder.getSubProduct();
			this.underlierCharacteristic = builder.getUnderlierCharacteristic();
			this.referenceRate = builder.getReferenceRate();
			this.additionalSubProduct = builder.getAdditionalSubProduct();
			this.otherReferenceRate = builder.getOtherReferenceRate();
			this.notionalCurrency = builder.getNotionalCurrency();
			this.otherNotionalCurrency = builder.getOtherNotionalCurrency();
			this.otherUnderlying = ofNullable(builder.getOtherUnderlying()).map(f->f.build()).orElse(null);
			this.otherUnderlierCharacteristic = builder.getOtherUnderlierCharacteristic();
			this.otherSubProduct = builder.getOtherSubProduct();
			this.underlying = ofNullable(builder.getUnderlying()).map(f->f.build()).orElse(null);
			this.otherBaseProduct = ofNullable(builder.getOtherBaseProduct()).map(f->f.build()).orElse(null);
			this.underlyingInstrumentIndex = builder.getUnderlyingInstrumentIndex();
			this.underlyingInstrumentIndexProp = builder.getUnderlyingInstrumentIndexProp();
			this.baseProduct = ofNullable(builder.getBaseProduct()).map(f->f.build()).orElse(null);
			this.underlierName = builder.getUnderlierName();
			this.otherAdditionalSubProduct = builder.getOtherAdditionalSubProduct();
		}
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("SubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SubProduct")
		public String getSubProduct() {
			return subProduct;
		}
		
		@Override
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("ReferenceRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRate")
		public String getReferenceRate() {
			return referenceRate;
		}
		
		@Override
		@RosettaAttribute("AdditionalSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("AdditionalSubProduct")
		public String getAdditionalSubProduct() {
			return additionalSubProduct;
		}
		
		@Override
		@RosettaAttribute("OtherReferenceRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherReferenceRate")
		public String getOtherReferenceRate() {
			return otherReferenceRate;
		}
		
		@Override
		@RosettaAttribute("NotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NotionalCurrency")
		public String getNotionalCurrency() {
			return notionalCurrency;
		}
		
		@Override
		@RosettaAttribute("OtherNotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherNotionalCurrency")
		public String getOtherNotionalCurrency() {
			return otherNotionalCurrency;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlying")
		public AnnaDsbOtherUnderlying getOtherUnderlying() {
			return otherUnderlying;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getOtherUnderlierCharacteristic() {
			return otherUnderlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("OtherSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherSubProduct")
		public String getOtherSubProduct() {
			return otherSubProduct;
		}
		
		@Override
		@RosettaAttribute("Underlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Underlying")
		public AnnaDsbUnderlying getUnderlying() {
			return underlying;
		}
		
		@Override
		@RosettaAttribute("OtherBaseProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherBaseProduct")
		public AnnaDsbBaseProduct getOtherBaseProduct() {
			return otherBaseProduct;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		public String getUnderlyingInstrumentIndex() {
			return underlyingInstrumentIndex;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		public String getUnderlyingInstrumentIndexProp() {
			return underlyingInstrumentIndexProp;
		}
		
		@Override
		@RosettaAttribute("BaseProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("BaseProduct")
		public AnnaDsbBaseProduct getBaseProduct() {
			return baseProduct;
		}
		
		@Override
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierName")
		public String getUnderlierName() {
			return underlierName;
		}
		
		@Override
		@RosettaAttribute("OtherAdditionalSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherAdditionalSubProduct")
		public String getOtherAdditionalSubProduct() {
			return otherAdditionalSubProduct;
		}
		
		@Override
		public AnnaDsbCommodities build() {
			return this;
		}
		
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder toBuilder() {
			AnnaDsbCommodities.AnnaDsbCommoditiesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbCommodities.AnnaDsbCommoditiesBuilder builder) {
			ofNullable(getReturnorPayoutTrigger()).ifPresent(builder::setReturnorPayoutTrigger);
			ofNullable(getSubProduct()).ifPresent(builder::setSubProduct);
			ofNullable(getUnderlierCharacteristic()).ifPresent(builder::setUnderlierCharacteristic);
			ofNullable(getReferenceRate()).ifPresent(builder::setReferenceRate);
			ofNullable(getAdditionalSubProduct()).ifPresent(builder::setAdditionalSubProduct);
			ofNullable(getOtherReferenceRate()).ifPresent(builder::setOtherReferenceRate);
			ofNullable(getNotionalCurrency()).ifPresent(builder::setNotionalCurrency);
			ofNullable(getOtherNotionalCurrency()).ifPresent(builder::setOtherNotionalCurrency);
			ofNullable(getOtherUnderlying()).ifPresent(builder::setOtherUnderlying);
			ofNullable(getOtherUnderlierCharacteristic()).ifPresent(builder::setOtherUnderlierCharacteristic);
			ofNullable(getOtherSubProduct()).ifPresent(builder::setOtherSubProduct);
			ofNullable(getUnderlying()).ifPresent(builder::setUnderlying);
			ofNullable(getOtherBaseProduct()).ifPresent(builder::setOtherBaseProduct);
			ofNullable(getUnderlyingInstrumentIndex()).ifPresent(builder::setUnderlyingInstrumentIndex);
			ofNullable(getUnderlyingInstrumentIndexProp()).ifPresent(builder::setUnderlyingInstrumentIndexProp);
			ofNullable(getBaseProduct()).ifPresent(builder::setBaseProduct);
			ofNullable(getUnderlierName()).ifPresent(builder::setUnderlierName);
			ofNullable(getOtherAdditionalSubProduct()).ifPresent(builder::setOtherAdditionalSubProduct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbCommodities _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(subProduct, _that.getSubProduct())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(referenceRate, _that.getReferenceRate())) return false;
			if (!Objects.equals(additionalSubProduct, _that.getAdditionalSubProduct())) return false;
			if (!Objects.equals(otherReferenceRate, _that.getOtherReferenceRate())) return false;
			if (!Objects.equals(notionalCurrency, _that.getNotionalCurrency())) return false;
			if (!Objects.equals(otherNotionalCurrency, _that.getOtherNotionalCurrency())) return false;
			if (!Objects.equals(otherUnderlying, _that.getOtherUnderlying())) return false;
			if (!Objects.equals(otherUnderlierCharacteristic, _that.getOtherUnderlierCharacteristic())) return false;
			if (!Objects.equals(otherSubProduct, _that.getOtherSubProduct())) return false;
			if (!Objects.equals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(otherBaseProduct, _that.getOtherBaseProduct())) return false;
			if (!Objects.equals(underlyingInstrumentIndex, _that.getUnderlyingInstrumentIndex())) return false;
			if (!Objects.equals(underlyingInstrumentIndexProp, _that.getUnderlyingInstrumentIndexProp())) return false;
			if (!Objects.equals(baseProduct, _that.getBaseProduct())) return false;
			if (!Objects.equals(underlierName, _that.getUnderlierName())) return false;
			if (!Objects.equals(otherAdditionalSubProduct, _that.getOtherAdditionalSubProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subProduct != null ? subProduct.hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceRate != null ? referenceRate.hashCode() : 0);
			_result = 31 * _result + (additionalSubProduct != null ? additionalSubProduct.hashCode() : 0);
			_result = 31 * _result + (otherReferenceRate != null ? otherReferenceRate.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency != null ? notionalCurrency.hashCode() : 0);
			_result = 31 * _result + (otherNotionalCurrency != null ? otherNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (otherUnderlying != null ? otherUnderlying.hashCode() : 0);
			_result = 31 * _result + (otherUnderlierCharacteristic != null ? otherUnderlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherSubProduct != null ? otherSubProduct.hashCode() : 0);
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (otherBaseProduct != null ? otherBaseProduct.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndex != null ? underlyingInstrumentIndex.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexProp != null ? underlyingInstrumentIndexProp.hashCode() : 0);
			_result = 31 * _result + (baseProduct != null ? baseProduct.hashCode() : 0);
			_result = 31 * _result + (underlierName != null ? underlierName.hashCode() : 0);
			_result = 31 * _result + (otherAdditionalSubProduct != null ? otherAdditionalSubProduct.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbCommodities {" +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"SubProduct=" + this.subProduct + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"ReferenceRate=" + this.referenceRate + ", " +
				"AdditionalSubProduct=" + this.additionalSubProduct + ", " +
				"OtherReferenceRate=" + this.otherReferenceRate + ", " +
				"NotionalCurrency=" + this.notionalCurrency + ", " +
				"OtherNotionalCurrency=" + this.otherNotionalCurrency + ", " +
				"OtherUnderlying=" + this.otherUnderlying + ", " +
				"OtherUnderlierCharacteristic=" + this.otherUnderlierCharacteristic + ", " +
				"OtherSubProduct=" + this.otherSubProduct + ", " +
				"Underlying=" + this.underlying + ", " +
				"OtherBaseProduct=" + this.otherBaseProduct + ", " +
				"UnderlyingInstrumentIndex=" + this.underlyingInstrumentIndex + ", " +
				"UnderlyingInstrumentIndexProp=" + this.underlyingInstrumentIndexProp + ", " +
				"BaseProduct=" + this.baseProduct + ", " +
				"UnderlierName=" + this.underlierName + ", " +
				"OtherAdditionalSubProduct=" + this.otherAdditionalSubProduct +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbCommodities  ***********************/
	class AnnaDsbCommoditiesBuilderImpl implements AnnaDsbCommodities.AnnaDsbCommoditiesBuilder {
	
		protected AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		protected String subProduct;
		protected AnnaDsbUnderlierCharacteristicEnum underlierCharacteristic;
		protected String referenceRate;
		protected String additionalSubProduct;
		protected String otherReferenceRate;
		protected String notionalCurrency;
		protected String otherNotionalCurrency;
		protected AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder otherUnderlying;
		protected AnnaDsbUnderlierCharacteristicEnum otherUnderlierCharacteristic;
		protected String otherSubProduct;
		protected AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder underlying;
		protected AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder otherBaseProduct;
		protected String underlyingInstrumentIndex;
		protected String underlyingInstrumentIndexProp;
		protected AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder baseProduct;
		protected String underlierName;
		protected String otherAdditionalSubProduct;
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("SubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SubProduct")
		public String getSubProduct() {
			return subProduct;
		}
		
		@Override
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("ReferenceRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRate")
		public String getReferenceRate() {
			return referenceRate;
		}
		
		@Override
		@RosettaAttribute("AdditionalSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("AdditionalSubProduct")
		public String getAdditionalSubProduct() {
			return additionalSubProduct;
		}
		
		@Override
		@RosettaAttribute("OtherReferenceRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherReferenceRate")
		public String getOtherReferenceRate() {
			return otherReferenceRate;
		}
		
		@Override
		@RosettaAttribute("NotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NotionalCurrency")
		public String getNotionalCurrency() {
			return notionalCurrency;
		}
		
		@Override
		@RosettaAttribute("OtherNotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherNotionalCurrency")
		public String getOtherNotionalCurrency() {
			return otherNotionalCurrency;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlying")
		public AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder getOtherUnderlying() {
			return otherUnderlying;
		}
		
		@Override
		public AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder getOrCreateOtherUnderlying() {
			AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder result;
			if (otherUnderlying!=null) {
				result = otherUnderlying;
			}
			else {
				result = otherUnderlying = AnnaDsbOtherUnderlying.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getOtherUnderlierCharacteristic() {
			return otherUnderlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("OtherSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherSubProduct")
		public String getOtherSubProduct() {
			return otherSubProduct;
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
		@RosettaAttribute("OtherBaseProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherBaseProduct")
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder getOtherBaseProduct() {
			return otherBaseProduct;
		}
		
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder getOrCreateOtherBaseProduct() {
			AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder result;
			if (otherBaseProduct!=null) {
				result = otherBaseProduct;
			}
			else {
				result = otherBaseProduct = AnnaDsbBaseProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		public String getUnderlyingInstrumentIndex() {
			return underlyingInstrumentIndex;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		public String getUnderlyingInstrumentIndexProp() {
			return underlyingInstrumentIndexProp;
		}
		
		@Override
		@RosettaAttribute("BaseProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("BaseProduct")
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder getBaseProduct() {
			return baseProduct;
		}
		
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder getOrCreateBaseProduct() {
			AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder result;
			if (baseProduct!=null) {
				result = baseProduct;
			}
			else {
				result = baseProduct = AnnaDsbBaseProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierName")
		public String getUnderlierName() {
			return underlierName;
		}
		
		@Override
		@RosettaAttribute("OtherAdditionalSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherAdditionalSubProduct")
		public String getOtherAdditionalSubProduct() {
			return otherAdditionalSubProduct;
		}
		
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum _returnorPayoutTrigger) {
			this.returnorPayoutTrigger = _returnorPayoutTrigger == null ? null : _returnorPayoutTrigger;
			return this;
		}
		
		@RosettaAttribute("SubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("SubProduct")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setSubProduct(String _subProduct) {
			this.subProduct = _subProduct == null ? null : _subProduct;
			return this;
		}
		
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierCharacteristic")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum _underlierCharacteristic) {
			this.underlierCharacteristic = _underlierCharacteristic == null ? null : _underlierCharacteristic;
			return this;
		}
		
		@RosettaAttribute("ReferenceRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReferenceRate")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setReferenceRate(String _referenceRate) {
			this.referenceRate = _referenceRate == null ? null : _referenceRate;
			return this;
		}
		
		@RosettaAttribute("AdditionalSubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("AdditionalSubProduct")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setAdditionalSubProduct(String _additionalSubProduct) {
			this.additionalSubProduct = _additionalSubProduct == null ? null : _additionalSubProduct;
			return this;
		}
		
		@RosettaAttribute("OtherReferenceRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherReferenceRate")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherReferenceRate(String _otherReferenceRate) {
			this.otherReferenceRate = _otherReferenceRate == null ? null : _otherReferenceRate;
			return this;
		}
		
		@RosettaAttribute("NotionalCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("NotionalCurrency")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setNotionalCurrency(String _notionalCurrency) {
			this.notionalCurrency = _notionalCurrency == null ? null : _notionalCurrency;
			return this;
		}
		
		@RosettaAttribute("OtherNotionalCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherNotionalCurrency")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherNotionalCurrency(String _otherNotionalCurrency) {
			this.otherNotionalCurrency = _otherNotionalCurrency == null ? null : _otherNotionalCurrency;
			return this;
		}
		
		@RosettaAttribute("OtherUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherUnderlying")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherUnderlying(AnnaDsbOtherUnderlying _otherUnderlying) {
			this.otherUnderlying = _otherUnderlying == null ? null : _otherUnderlying.toBuilder();
			return this;
		}
		
		@RosettaAttribute("OtherUnderlierCharacteristic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherUnderlierCharacteristic")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum _otherUnderlierCharacteristic) {
			this.otherUnderlierCharacteristic = _otherUnderlierCharacteristic == null ? null : _otherUnderlierCharacteristic;
			return this;
		}
		
		@RosettaAttribute("OtherSubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherSubProduct")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherSubProduct(String _otherSubProduct) {
			this.otherSubProduct = _otherSubProduct == null ? null : _otherSubProduct;
			return this;
		}
		
		@RosettaAttribute("Underlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Underlying")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setUnderlying(AnnaDsbUnderlying _underlying) {
			this.underlying = _underlying == null ? null : _underlying.toBuilder();
			return this;
		}
		
		@RosettaAttribute("OtherBaseProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherBaseProduct")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherBaseProduct(AnnaDsbBaseProduct _otherBaseProduct) {
			this.otherBaseProduct = _otherBaseProduct == null ? null : _otherBaseProduct.toBuilder();
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setUnderlyingInstrumentIndex(String _underlyingInstrumentIndex) {
			this.underlyingInstrumentIndex = _underlyingInstrumentIndex == null ? null : _underlyingInstrumentIndex;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setUnderlyingInstrumentIndexProp(String _underlyingInstrumentIndexProp) {
			this.underlyingInstrumentIndexProp = _underlyingInstrumentIndexProp == null ? null : _underlyingInstrumentIndexProp;
			return this;
		}
		
		@RosettaAttribute("BaseProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("BaseProduct")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setBaseProduct(AnnaDsbBaseProduct _baseProduct) {
			this.baseProduct = _baseProduct == null ? null : _baseProduct.toBuilder();
			return this;
		}
		
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierName")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setUnderlierName(String _underlierName) {
			this.underlierName = _underlierName == null ? null : _underlierName;
			return this;
		}
		
		@RosettaAttribute("OtherAdditionalSubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherAdditionalSubProduct")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder setOtherAdditionalSubProduct(String _otherAdditionalSubProduct) {
			this.otherAdditionalSubProduct = _otherAdditionalSubProduct == null ? null : _otherAdditionalSubProduct;
			return this;
		}
		
		@Override
		public AnnaDsbCommodities build() {
			return new AnnaDsbCommodities.AnnaDsbCommoditiesImpl(this);
		}
		
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder prune() {
			if (otherUnderlying!=null && !otherUnderlying.prune().hasData()) otherUnderlying = null;
			if (underlying!=null && !underlying.prune().hasData()) underlying = null;
			if (otherBaseProduct!=null && !otherBaseProduct.prune().hasData()) otherBaseProduct = null;
			if (baseProduct!=null && !baseProduct.prune().hasData()) baseProduct = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReturnorPayoutTrigger()!=null) return true;
			if (getSubProduct()!=null) return true;
			if (getUnderlierCharacteristic()!=null) return true;
			if (getReferenceRate()!=null) return true;
			if (getAdditionalSubProduct()!=null) return true;
			if (getOtherReferenceRate()!=null) return true;
			if (getNotionalCurrency()!=null) return true;
			if (getOtherNotionalCurrency()!=null) return true;
			if (getOtherUnderlying()!=null && getOtherUnderlying().hasData()) return true;
			if (getOtherUnderlierCharacteristic()!=null) return true;
			if (getOtherSubProduct()!=null) return true;
			if (getUnderlying()!=null && getUnderlying().hasData()) return true;
			if (getOtherBaseProduct()!=null && getOtherBaseProduct().hasData()) return true;
			if (getUnderlyingInstrumentIndex()!=null) return true;
			if (getUnderlyingInstrumentIndexProp()!=null) return true;
			if (getBaseProduct()!=null && getBaseProduct().hasData()) return true;
			if (getUnderlierName()!=null) return true;
			if (getOtherAdditionalSubProduct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbCommodities.AnnaDsbCommoditiesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbCommodities.AnnaDsbCommoditiesBuilder o = (AnnaDsbCommodities.AnnaDsbCommoditiesBuilder) other;
			
			merger.mergeRosetta(getOtherUnderlying(), o.getOtherUnderlying(), this::setOtherUnderlying);
			merger.mergeRosetta(getUnderlying(), o.getUnderlying(), this::setUnderlying);
			merger.mergeRosetta(getOtherBaseProduct(), o.getOtherBaseProduct(), this::setOtherBaseProduct);
			merger.mergeRosetta(getBaseProduct(), o.getBaseProduct(), this::setBaseProduct);
			
			merger.mergeBasic(getReturnorPayoutTrigger(), o.getReturnorPayoutTrigger(), this::setReturnorPayoutTrigger);
			merger.mergeBasic(getSubProduct(), o.getSubProduct(), this::setSubProduct);
			merger.mergeBasic(getUnderlierCharacteristic(), o.getUnderlierCharacteristic(), this::setUnderlierCharacteristic);
			merger.mergeBasic(getReferenceRate(), o.getReferenceRate(), this::setReferenceRate);
			merger.mergeBasic(getAdditionalSubProduct(), o.getAdditionalSubProduct(), this::setAdditionalSubProduct);
			merger.mergeBasic(getOtherReferenceRate(), o.getOtherReferenceRate(), this::setOtherReferenceRate);
			merger.mergeBasic(getNotionalCurrency(), o.getNotionalCurrency(), this::setNotionalCurrency);
			merger.mergeBasic(getOtherNotionalCurrency(), o.getOtherNotionalCurrency(), this::setOtherNotionalCurrency);
			merger.mergeBasic(getOtherUnderlierCharacteristic(), o.getOtherUnderlierCharacteristic(), this::setOtherUnderlierCharacteristic);
			merger.mergeBasic(getOtherSubProduct(), o.getOtherSubProduct(), this::setOtherSubProduct);
			merger.mergeBasic(getUnderlyingInstrumentIndex(), o.getUnderlyingInstrumentIndex(), this::setUnderlyingInstrumentIndex);
			merger.mergeBasic(getUnderlyingInstrumentIndexProp(), o.getUnderlyingInstrumentIndexProp(), this::setUnderlyingInstrumentIndexProp);
			merger.mergeBasic(getUnderlierName(), o.getUnderlierName(), this::setUnderlierName);
			merger.mergeBasic(getOtherAdditionalSubProduct(), o.getOtherAdditionalSubProduct(), this::setOtherAdditionalSubProduct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbCommodities _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(subProduct, _that.getSubProduct())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(referenceRate, _that.getReferenceRate())) return false;
			if (!Objects.equals(additionalSubProduct, _that.getAdditionalSubProduct())) return false;
			if (!Objects.equals(otherReferenceRate, _that.getOtherReferenceRate())) return false;
			if (!Objects.equals(notionalCurrency, _that.getNotionalCurrency())) return false;
			if (!Objects.equals(otherNotionalCurrency, _that.getOtherNotionalCurrency())) return false;
			if (!Objects.equals(otherUnderlying, _that.getOtherUnderlying())) return false;
			if (!Objects.equals(otherUnderlierCharacteristic, _that.getOtherUnderlierCharacteristic())) return false;
			if (!Objects.equals(otherSubProduct, _that.getOtherSubProduct())) return false;
			if (!Objects.equals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(otherBaseProduct, _that.getOtherBaseProduct())) return false;
			if (!Objects.equals(underlyingInstrumentIndex, _that.getUnderlyingInstrumentIndex())) return false;
			if (!Objects.equals(underlyingInstrumentIndexProp, _that.getUnderlyingInstrumentIndexProp())) return false;
			if (!Objects.equals(baseProduct, _that.getBaseProduct())) return false;
			if (!Objects.equals(underlierName, _that.getUnderlierName())) return false;
			if (!Objects.equals(otherAdditionalSubProduct, _that.getOtherAdditionalSubProduct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subProduct != null ? subProduct.hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceRate != null ? referenceRate.hashCode() : 0);
			_result = 31 * _result + (additionalSubProduct != null ? additionalSubProduct.hashCode() : 0);
			_result = 31 * _result + (otherReferenceRate != null ? otherReferenceRate.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency != null ? notionalCurrency.hashCode() : 0);
			_result = 31 * _result + (otherNotionalCurrency != null ? otherNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (otherUnderlying != null ? otherUnderlying.hashCode() : 0);
			_result = 31 * _result + (otherUnderlierCharacteristic != null ? otherUnderlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherSubProduct != null ? otherSubProduct.hashCode() : 0);
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (otherBaseProduct != null ? otherBaseProduct.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndex != null ? underlyingInstrumentIndex.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexProp != null ? underlyingInstrumentIndexProp.hashCode() : 0);
			_result = 31 * _result + (baseProduct != null ? baseProduct.hashCode() : 0);
			_result = 31 * _result + (underlierName != null ? underlierName.hashCode() : 0);
			_result = 31 * _result + (otherAdditionalSubProduct != null ? otherAdditionalSubProduct.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbCommoditiesBuilder {" +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"SubProduct=" + this.subProduct + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"ReferenceRate=" + this.referenceRate + ", " +
				"AdditionalSubProduct=" + this.additionalSubProduct + ", " +
				"OtherReferenceRate=" + this.otherReferenceRate + ", " +
				"NotionalCurrency=" + this.notionalCurrency + ", " +
				"OtherNotionalCurrency=" + this.otherNotionalCurrency + ", " +
				"OtherUnderlying=" + this.otherUnderlying + ", " +
				"OtherUnderlierCharacteristic=" + this.otherUnderlierCharacteristic + ", " +
				"OtherSubProduct=" + this.otherSubProduct + ", " +
				"Underlying=" + this.underlying + ", " +
				"OtherBaseProduct=" + this.otherBaseProduct + ", " +
				"UnderlyingInstrumentIndex=" + this.underlyingInstrumentIndex + ", " +
				"UnderlyingInstrumentIndexProp=" + this.underlyingInstrumentIndexProp + ", " +
				"BaseProduct=" + this.baseProduct + ", " +
				"UnderlierName=" + this.underlierName + ", " +
				"OtherAdditionalSubProduct=" + this.otherAdditionalSubProduct +
			'}';
		}
	}
}

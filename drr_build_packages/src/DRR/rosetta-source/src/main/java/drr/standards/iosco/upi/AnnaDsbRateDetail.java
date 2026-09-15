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
import drr.standards.iosco.upi.meta.AnnaDsbRateDetailMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbRateDetail", builder=AnnaDsbRateDetail.AnnaDsbRateDetailBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbRateDetail", model="drr", builder=AnnaDsbRateDetail.AnnaDsbRateDetailBuilderImpl.class, version="7.7.0")
public interface AnnaDsbRateDetail extends RosettaModelObject {

	AnnaDsbRateDetailMeta metaData = new AnnaDsbRateDetailMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbUnderlyingAssetTypeEnum getUnderlyingAssetType();
	AnnaDsbCFIOptionStyleandTypeEnum getOptionStyleandType();
	AnnaDsbValuationMethodorTriggerEnum getValuationMethodorTrigger();
	AnnaDsbDeliveryTypeEnum getDeliveryType();
	AnnaDsbNotionalScheduleEnum getNotionalSchedule();
	AnnaDsbSingleorMultiCurrencyEnum getSingleorMultiCurrency();

	/*********************** Build Methods  ***********************/
	AnnaDsbRateDetail build();
	
	AnnaDsbRateDetail.AnnaDsbRateDetailBuilder toBuilder();
	
	static AnnaDsbRateDetail.AnnaDsbRateDetailBuilder builder() {
		return new AnnaDsbRateDetail.AnnaDsbRateDetailBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbRateDetail> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbRateDetail> getType() {
		return AnnaDsbRateDetail.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("UnderlyingAssetType"), AnnaDsbUnderlyingAssetTypeEnum.class, getUnderlyingAssetType(), this);
		processor.processBasic(path.newSubPath("OptionStyleandType"), AnnaDsbCFIOptionStyleandTypeEnum.class, getOptionStyleandType(), this);
		processor.processBasic(path.newSubPath("ValuationMethodorTrigger"), AnnaDsbValuationMethodorTriggerEnum.class, getValuationMethodorTrigger(), this);
		processor.processBasic(path.newSubPath("DeliveryType"), AnnaDsbDeliveryTypeEnum.class, getDeliveryType(), this);
		processor.processBasic(path.newSubPath("NotionalSchedule"), AnnaDsbNotionalScheduleEnum.class, getNotionalSchedule(), this);
		processor.processBasic(path.newSubPath("SingleorMultiCurrency"), AnnaDsbSingleorMultiCurrencyEnum.class, getSingleorMultiCurrency(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbRateDetailBuilder extends AnnaDsbRateDetail, RosettaModelObjectBuilder {
		AnnaDsbRateDetail.AnnaDsbRateDetailBuilder setUnderlyingAssetType(AnnaDsbUnderlyingAssetTypeEnum UnderlyingAssetType);
		AnnaDsbRateDetail.AnnaDsbRateDetailBuilder setOptionStyleandType(AnnaDsbCFIOptionStyleandTypeEnum OptionStyleandType);
		AnnaDsbRateDetail.AnnaDsbRateDetailBuilder setValuationMethodorTrigger(AnnaDsbValuationMethodorTriggerEnum ValuationMethodorTrigger);
		AnnaDsbRateDetail.AnnaDsbRateDetailBuilder setDeliveryType(AnnaDsbDeliveryTypeEnum DeliveryType);
		AnnaDsbRateDetail.AnnaDsbRateDetailBuilder setNotionalSchedule(AnnaDsbNotionalScheduleEnum NotionalSchedule);
		AnnaDsbRateDetail.AnnaDsbRateDetailBuilder setSingleorMultiCurrency(AnnaDsbSingleorMultiCurrencyEnum SingleorMultiCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("UnderlyingAssetType"), AnnaDsbUnderlyingAssetTypeEnum.class, getUnderlyingAssetType(), this);
			processor.processBasic(path.newSubPath("OptionStyleandType"), AnnaDsbCFIOptionStyleandTypeEnum.class, getOptionStyleandType(), this);
			processor.processBasic(path.newSubPath("ValuationMethodorTrigger"), AnnaDsbValuationMethodorTriggerEnum.class, getValuationMethodorTrigger(), this);
			processor.processBasic(path.newSubPath("DeliveryType"), AnnaDsbDeliveryTypeEnum.class, getDeliveryType(), this);
			processor.processBasic(path.newSubPath("NotionalSchedule"), AnnaDsbNotionalScheduleEnum.class, getNotionalSchedule(), this);
			processor.processBasic(path.newSubPath("SingleorMultiCurrency"), AnnaDsbSingleorMultiCurrencyEnum.class, getSingleorMultiCurrency(), this);
		}
		

		AnnaDsbRateDetail.AnnaDsbRateDetailBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbRateDetail  ***********************/
	class AnnaDsbRateDetailImpl implements AnnaDsbRateDetail {
		private final AnnaDsbUnderlyingAssetTypeEnum underlyingAssetType;
		private final AnnaDsbCFIOptionStyleandTypeEnum optionStyleandType;
		private final AnnaDsbValuationMethodorTriggerEnum valuationMethodorTrigger;
		private final AnnaDsbDeliveryTypeEnum deliveryType;
		private final AnnaDsbNotionalScheduleEnum notionalSchedule;
		private final AnnaDsbSingleorMultiCurrencyEnum singleorMultiCurrency;
		
		protected AnnaDsbRateDetailImpl(AnnaDsbRateDetail.AnnaDsbRateDetailBuilder builder) {
			this.underlyingAssetType = builder.getUnderlyingAssetType();
			this.optionStyleandType = builder.getOptionStyleandType();
			this.valuationMethodorTrigger = builder.getValuationMethodorTrigger();
			this.deliveryType = builder.getDeliveryType();
			this.notionalSchedule = builder.getNotionalSchedule();
			this.singleorMultiCurrency = builder.getSingleorMultiCurrency();
		}
		
		@Override
		@RosettaAttribute("UnderlyingAssetType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingAssetType")
		public AnnaDsbUnderlyingAssetTypeEnum getUnderlyingAssetType() {
			return underlyingAssetType;
		}
		
		@Override
		@RosettaAttribute("OptionStyleandType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OptionStyleandType")
		public AnnaDsbCFIOptionStyleandTypeEnum getOptionStyleandType() {
			return optionStyleandType;
		}
		
		@Override
		@RosettaAttribute("ValuationMethodorTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ValuationMethodorTrigger")
		public AnnaDsbValuationMethodorTriggerEnum getValuationMethodorTrigger() {
			return valuationMethodorTrigger;
		}
		
		@Override
		@RosettaAttribute("DeliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DeliveryType")
		public AnnaDsbDeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("NotionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NotionalSchedule")
		public AnnaDsbNotionalScheduleEnum getNotionalSchedule() {
			return notionalSchedule;
		}
		
		@Override
		@RosettaAttribute("SingleorMultiCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SingleorMultiCurrency")
		public AnnaDsbSingleorMultiCurrencyEnum getSingleorMultiCurrency() {
			return singleorMultiCurrency;
		}
		
		@Override
		public AnnaDsbRateDetail build() {
			return this;
		}
		
		@Override
		public AnnaDsbRateDetail.AnnaDsbRateDetailBuilder toBuilder() {
			AnnaDsbRateDetail.AnnaDsbRateDetailBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbRateDetail.AnnaDsbRateDetailBuilder builder) {
			ofNullable(getUnderlyingAssetType()).ifPresent(builder::setUnderlyingAssetType);
			ofNullable(getOptionStyleandType()).ifPresent(builder::setOptionStyleandType);
			ofNullable(getValuationMethodorTrigger()).ifPresent(builder::setValuationMethodorTrigger);
			ofNullable(getDeliveryType()).ifPresent(builder::setDeliveryType);
			ofNullable(getNotionalSchedule()).ifPresent(builder::setNotionalSchedule);
			ofNullable(getSingleorMultiCurrency()).ifPresent(builder::setSingleorMultiCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbRateDetail _that = getType().cast(o);
		
			if (!Objects.equals(underlyingAssetType, _that.getUnderlyingAssetType())) return false;
			if (!Objects.equals(optionStyleandType, _that.getOptionStyleandType())) return false;
			if (!Objects.equals(valuationMethodorTrigger, _that.getValuationMethodorTrigger())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(notionalSchedule, _that.getNotionalSchedule())) return false;
			if (!Objects.equals(singleorMultiCurrency, _that.getSingleorMultiCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyingAssetType != null ? underlyingAssetType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionStyleandType != null ? optionStyleandType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationMethodorTrigger != null ? valuationMethodorTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (notionalSchedule != null ? notionalSchedule.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (singleorMultiCurrency != null ? singleorMultiCurrency.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbRateDetail {" +
				"UnderlyingAssetType=" + this.underlyingAssetType + ", " +
				"OptionStyleandType=" + this.optionStyleandType + ", " +
				"ValuationMethodorTrigger=" + this.valuationMethodorTrigger + ", " +
				"DeliveryType=" + this.deliveryType + ", " +
				"NotionalSchedule=" + this.notionalSchedule + ", " +
				"SingleorMultiCurrency=" + this.singleorMultiCurrency +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbRateDetail  ***********************/
	class AnnaDsbRateDetailBuilderImpl implements AnnaDsbRateDetail.AnnaDsbRateDetailBuilder {
	
		protected AnnaDsbUnderlyingAssetTypeEnum underlyingAssetType;
		protected AnnaDsbCFIOptionStyleandTypeEnum optionStyleandType;
		protected AnnaDsbValuationMethodorTriggerEnum valuationMethodorTrigger;
		protected AnnaDsbDeliveryTypeEnum deliveryType;
		protected AnnaDsbNotionalScheduleEnum notionalSchedule;
		protected AnnaDsbSingleorMultiCurrencyEnum singleorMultiCurrency;
		
		@Override
		@RosettaAttribute("UnderlyingAssetType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingAssetType")
		public AnnaDsbUnderlyingAssetTypeEnum getUnderlyingAssetType() {
			return underlyingAssetType;
		}
		
		@Override
		@RosettaAttribute("OptionStyleandType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OptionStyleandType")
		public AnnaDsbCFIOptionStyleandTypeEnum getOptionStyleandType() {
			return optionStyleandType;
		}
		
		@Override
		@RosettaAttribute("ValuationMethodorTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ValuationMethodorTrigger")
		public AnnaDsbValuationMethodorTriggerEnum getValuationMethodorTrigger() {
			return valuationMethodorTrigger;
		}
		
		@Override
		@RosettaAttribute("DeliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DeliveryType")
		public AnnaDsbDeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("NotionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NotionalSchedule")
		public AnnaDsbNotionalScheduleEnum getNotionalSchedule() {
			return notionalSchedule;
		}
		
		@Override
		@RosettaAttribute("SingleorMultiCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SingleorMultiCurrency")
		public AnnaDsbSingleorMultiCurrencyEnum getSingleorMultiCurrency() {
			return singleorMultiCurrency;
		}
		
		@RosettaAttribute("UnderlyingAssetType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingAssetType")
		@Override
		public AnnaDsbRateDetail.AnnaDsbRateDetailBuilder setUnderlyingAssetType(AnnaDsbUnderlyingAssetTypeEnum _underlyingAssetType) {
			this.underlyingAssetType = _underlyingAssetType == null ? null : _underlyingAssetType;
			return this;
		}
		
		@RosettaAttribute("OptionStyleandType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OptionStyleandType")
		@Override
		public AnnaDsbRateDetail.AnnaDsbRateDetailBuilder setOptionStyleandType(AnnaDsbCFIOptionStyleandTypeEnum _optionStyleandType) {
			this.optionStyleandType = _optionStyleandType == null ? null : _optionStyleandType;
			return this;
		}
		
		@RosettaAttribute("ValuationMethodorTrigger")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ValuationMethodorTrigger")
		@Override
		public AnnaDsbRateDetail.AnnaDsbRateDetailBuilder setValuationMethodorTrigger(AnnaDsbValuationMethodorTriggerEnum _valuationMethodorTrigger) {
			this.valuationMethodorTrigger = _valuationMethodorTrigger == null ? null : _valuationMethodorTrigger;
			return this;
		}
		
		@RosettaAttribute("DeliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("DeliveryType")
		@Override
		public AnnaDsbRateDetail.AnnaDsbRateDetailBuilder setDeliveryType(AnnaDsbDeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("NotionalSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("NotionalSchedule")
		@Override
		public AnnaDsbRateDetail.AnnaDsbRateDetailBuilder setNotionalSchedule(AnnaDsbNotionalScheduleEnum _notionalSchedule) {
			this.notionalSchedule = _notionalSchedule == null ? null : _notionalSchedule;
			return this;
		}
		
		@RosettaAttribute("SingleorMultiCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("SingleorMultiCurrency")
		@Override
		public AnnaDsbRateDetail.AnnaDsbRateDetailBuilder setSingleorMultiCurrency(AnnaDsbSingleorMultiCurrencyEnum _singleorMultiCurrency) {
			this.singleorMultiCurrency = _singleorMultiCurrency == null ? null : _singleorMultiCurrency;
			return this;
		}
		
		@Override
		public AnnaDsbRateDetail build() {
			return new AnnaDsbRateDetail.AnnaDsbRateDetailImpl(this);
		}
		
		@Override
		public AnnaDsbRateDetail.AnnaDsbRateDetailBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbRateDetail.AnnaDsbRateDetailBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnderlyingAssetType()!=null) return true;
			if (getOptionStyleandType()!=null) return true;
			if (getValuationMethodorTrigger()!=null) return true;
			if (getDeliveryType()!=null) return true;
			if (getNotionalSchedule()!=null) return true;
			if (getSingleorMultiCurrency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbRateDetail.AnnaDsbRateDetailBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbRateDetail.AnnaDsbRateDetailBuilder o = (AnnaDsbRateDetail.AnnaDsbRateDetailBuilder) other;
			
			
			merger.mergeBasic(getUnderlyingAssetType(), o.getUnderlyingAssetType(), this::setUnderlyingAssetType);
			merger.mergeBasic(getOptionStyleandType(), o.getOptionStyleandType(), this::setOptionStyleandType);
			merger.mergeBasic(getValuationMethodorTrigger(), o.getValuationMethodorTrigger(), this::setValuationMethodorTrigger);
			merger.mergeBasic(getDeliveryType(), o.getDeliveryType(), this::setDeliveryType);
			merger.mergeBasic(getNotionalSchedule(), o.getNotionalSchedule(), this::setNotionalSchedule);
			merger.mergeBasic(getSingleorMultiCurrency(), o.getSingleorMultiCurrency(), this::setSingleorMultiCurrency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbRateDetail _that = getType().cast(o);
		
			if (!Objects.equals(underlyingAssetType, _that.getUnderlyingAssetType())) return false;
			if (!Objects.equals(optionStyleandType, _that.getOptionStyleandType())) return false;
			if (!Objects.equals(valuationMethodorTrigger, _that.getValuationMethodorTrigger())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(notionalSchedule, _that.getNotionalSchedule())) return false;
			if (!Objects.equals(singleorMultiCurrency, _that.getSingleorMultiCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyingAssetType != null ? underlyingAssetType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionStyleandType != null ? optionStyleandType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationMethodorTrigger != null ? valuationMethodorTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (notionalSchedule != null ? notionalSchedule.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (singleorMultiCurrency != null ? singleorMultiCurrency.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbRateDetailBuilder {" +
				"UnderlyingAssetType=" + this.underlyingAssetType + ", " +
				"OptionStyleandType=" + this.optionStyleandType + ", " +
				"ValuationMethodorTrigger=" + this.valuationMethodorTrigger + ", " +
				"DeliveryType=" + this.deliveryType + ", " +
				"NotionalSchedule=" + this.notionalSchedule + ", " +
				"SingleorMultiCurrency=" + this.singleorMultiCurrency +
			'}';
		}
	}
}

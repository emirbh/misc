package drr.standards.iosco.upi;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import drr.standards.iosco.upi.meta.AnnaDsbDerivedMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbDerived", builder=AnnaDsbDerived.AnnaDsbDerivedBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbDerived", model="drr", builder=AnnaDsbDerived.AnnaDsbDerivedBuilderImpl.class, version="7.7.0")
public interface AnnaDsbDerived extends RosettaModelObject {

	AnnaDsbDerivedMeta metaData = new AnnaDsbDerivedMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger();
	String getUnderlierCharacteristic();
	AnnaDsbValuationMethodorTriggerEnum getValuationMethodorTrigger();
	String getShortName();
	AnnaDsbUnderlyingIssuerTypeEnum getUnderlyingIssuerType();
	String getClassificationType();
	AnnaDsbOptionExerciseStyleEnum getOptionExerciseStyle();
	AnnaDsbUnderlyingAssetTypeEnum getUnderlyingAssetType();
	AnnaDsbSingleorMultiCurrencyEnum getSingleorMultiCurrency();
	AnnaDsbCFIDeliveryTypeEnum getCFIDeliveryType();
	List<? extends AnnaDsbUnderlyingRecord> getUnderlyingRecord();
	AnnaDsbCFIOptionStyleandTypeEnum getCFIOptionStyleandType();
	String getUnderlierName();
	AnnaDsbUnderlyingAssetClass getUnderlyingAssetClass();
	AnnaDsbDeliveryTypeEnum getDeliveryType();
	String getFurtherGrouping();

	/*********************** Build Methods  ***********************/
	AnnaDsbDerived build();
	
	AnnaDsbDerived.AnnaDsbDerivedBuilder toBuilder();
	
	static AnnaDsbDerived.AnnaDsbDerivedBuilder builder() {
		return new AnnaDsbDerived.AnnaDsbDerivedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbDerived> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbDerived> getType() {
		return AnnaDsbDerived.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
		processor.processBasic(path.newSubPath("UnderlierCharacteristic"), String.class, getUnderlierCharacteristic(), this);
		processor.processBasic(path.newSubPath("ValuationMethodorTrigger"), AnnaDsbValuationMethodorTriggerEnum.class, getValuationMethodorTrigger(), this);
		processor.processBasic(path.newSubPath("ShortName"), String.class, getShortName(), this);
		processor.processBasic(path.newSubPath("UnderlyingIssuerType"), AnnaDsbUnderlyingIssuerTypeEnum.class, getUnderlyingIssuerType(), this);
		processor.processBasic(path.newSubPath("ClassificationType"), String.class, getClassificationType(), this);
		processor.processBasic(path.newSubPath("OptionExerciseStyle"), AnnaDsbOptionExerciseStyleEnum.class, getOptionExerciseStyle(), this);
		processor.processBasic(path.newSubPath("UnderlyingAssetType"), AnnaDsbUnderlyingAssetTypeEnum.class, getUnderlyingAssetType(), this);
		processor.processBasic(path.newSubPath("SingleorMultiCurrency"), AnnaDsbSingleorMultiCurrencyEnum.class, getSingleorMultiCurrency(), this);
		processor.processBasic(path.newSubPath("CFIDeliveryType"), AnnaDsbCFIDeliveryTypeEnum.class, getCFIDeliveryType(), this);
		processRosetta(path.newSubPath("UnderlyingRecord"), processor, AnnaDsbUnderlyingRecord.class, getUnderlyingRecord());
		processor.processBasic(path.newSubPath("CFIOptionStyleandType"), AnnaDsbCFIOptionStyleandTypeEnum.class, getCFIOptionStyleandType(), this);
		processor.processBasic(path.newSubPath("UnderlierName"), String.class, getUnderlierName(), this);
		processRosetta(path.newSubPath("UnderlyingAssetClass"), processor, AnnaDsbUnderlyingAssetClass.class, getUnderlyingAssetClass());
		processor.processBasic(path.newSubPath("DeliveryType"), AnnaDsbDeliveryTypeEnum.class, getDeliveryType(), this);
		processor.processBasic(path.newSubPath("FurtherGrouping"), String.class, getFurtherGrouping(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbDerivedBuilder extends AnnaDsbDerived, RosettaModelObjectBuilder {
		AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder getOrCreateUnderlyingRecord(int index);
		@Override
		List<? extends AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder> getUnderlyingRecord();
		AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder getOrCreateUnderlyingAssetClass();
		@Override
		AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder getUnderlyingAssetClass();
		AnnaDsbDerived.AnnaDsbDerivedBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum ReturnorPayoutTrigger);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setUnderlierCharacteristic(String UnderlierCharacteristic);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setValuationMethodorTrigger(AnnaDsbValuationMethodorTriggerEnum ValuationMethodorTrigger);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setShortName(String ShortName);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setUnderlyingIssuerType(AnnaDsbUnderlyingIssuerTypeEnum UnderlyingIssuerType);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setClassificationType(String ClassificationType);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setOptionExerciseStyle(AnnaDsbOptionExerciseStyleEnum OptionExerciseStyle);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setUnderlyingAssetType(AnnaDsbUnderlyingAssetTypeEnum UnderlyingAssetType);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setSingleorMultiCurrency(AnnaDsbSingleorMultiCurrencyEnum SingleorMultiCurrency);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setCFIDeliveryType(AnnaDsbCFIDeliveryTypeEnum CFIDeliveryType);
		AnnaDsbDerived.AnnaDsbDerivedBuilder addUnderlyingRecord(AnnaDsbUnderlyingRecord UnderlyingRecord);
		AnnaDsbDerived.AnnaDsbDerivedBuilder addUnderlyingRecord(AnnaDsbUnderlyingRecord UnderlyingRecord, int idx);
		AnnaDsbDerived.AnnaDsbDerivedBuilder addUnderlyingRecord(List<? extends AnnaDsbUnderlyingRecord> UnderlyingRecord);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setUnderlyingRecord(List<? extends AnnaDsbUnderlyingRecord> UnderlyingRecord);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setCFIOptionStyleandType(AnnaDsbCFIOptionStyleandTypeEnum CFIOptionStyleandType);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setUnderlierName(String UnderlierName);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setUnderlyingAssetClass(AnnaDsbUnderlyingAssetClass UnderlyingAssetClass);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setDeliveryType(AnnaDsbDeliveryTypeEnum DeliveryType);
		AnnaDsbDerived.AnnaDsbDerivedBuilder setFurtherGrouping(String FurtherGrouping);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
			processor.processBasic(path.newSubPath("UnderlierCharacteristic"), String.class, getUnderlierCharacteristic(), this);
			processor.processBasic(path.newSubPath("ValuationMethodorTrigger"), AnnaDsbValuationMethodorTriggerEnum.class, getValuationMethodorTrigger(), this);
			processor.processBasic(path.newSubPath("ShortName"), String.class, getShortName(), this);
			processor.processBasic(path.newSubPath("UnderlyingIssuerType"), AnnaDsbUnderlyingIssuerTypeEnum.class, getUnderlyingIssuerType(), this);
			processor.processBasic(path.newSubPath("ClassificationType"), String.class, getClassificationType(), this);
			processor.processBasic(path.newSubPath("OptionExerciseStyle"), AnnaDsbOptionExerciseStyleEnum.class, getOptionExerciseStyle(), this);
			processor.processBasic(path.newSubPath("UnderlyingAssetType"), AnnaDsbUnderlyingAssetTypeEnum.class, getUnderlyingAssetType(), this);
			processor.processBasic(path.newSubPath("SingleorMultiCurrency"), AnnaDsbSingleorMultiCurrencyEnum.class, getSingleorMultiCurrency(), this);
			processor.processBasic(path.newSubPath("CFIDeliveryType"), AnnaDsbCFIDeliveryTypeEnum.class, getCFIDeliveryType(), this);
			processRosetta(path.newSubPath("UnderlyingRecord"), processor, AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder.class, getUnderlyingRecord());
			processor.processBasic(path.newSubPath("CFIOptionStyleandType"), AnnaDsbCFIOptionStyleandTypeEnum.class, getCFIOptionStyleandType(), this);
			processor.processBasic(path.newSubPath("UnderlierName"), String.class, getUnderlierName(), this);
			processRosetta(path.newSubPath("UnderlyingAssetClass"), processor, AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder.class, getUnderlyingAssetClass());
			processor.processBasic(path.newSubPath("DeliveryType"), AnnaDsbDeliveryTypeEnum.class, getDeliveryType(), this);
			processor.processBasic(path.newSubPath("FurtherGrouping"), String.class, getFurtherGrouping(), this);
		}
		

		AnnaDsbDerived.AnnaDsbDerivedBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbDerived  ***********************/
	class AnnaDsbDerivedImpl implements AnnaDsbDerived {
		private final AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		private final String underlierCharacteristic;
		private final AnnaDsbValuationMethodorTriggerEnum valuationMethodorTrigger;
		private final String shortName;
		private final AnnaDsbUnderlyingIssuerTypeEnum underlyingIssuerType;
		private final String classificationType;
		private final AnnaDsbOptionExerciseStyleEnum optionExerciseStyle;
		private final AnnaDsbUnderlyingAssetTypeEnum underlyingAssetType;
		private final AnnaDsbSingleorMultiCurrencyEnum singleorMultiCurrency;
		private final AnnaDsbCFIDeliveryTypeEnum cFIDeliveryType;
		private final List<? extends AnnaDsbUnderlyingRecord> underlyingRecord;
		private final AnnaDsbCFIOptionStyleandTypeEnum cFIOptionStyleandType;
		private final String underlierName;
		private final AnnaDsbUnderlyingAssetClass underlyingAssetClass;
		private final AnnaDsbDeliveryTypeEnum deliveryType;
		private final String furtherGrouping;
		
		protected AnnaDsbDerivedImpl(AnnaDsbDerived.AnnaDsbDerivedBuilder builder) {
			this.returnorPayoutTrigger = builder.getReturnorPayoutTrigger();
			this.underlierCharacteristic = builder.getUnderlierCharacteristic();
			this.valuationMethodorTrigger = builder.getValuationMethodorTrigger();
			this.shortName = builder.getShortName();
			this.underlyingIssuerType = builder.getUnderlyingIssuerType();
			this.classificationType = builder.getClassificationType();
			this.optionExerciseStyle = builder.getOptionExerciseStyle();
			this.underlyingAssetType = builder.getUnderlyingAssetType();
			this.singleorMultiCurrency = builder.getSingleorMultiCurrency();
			this.cFIDeliveryType = builder.getCFIDeliveryType();
			this.underlyingRecord = ofNullable(builder.getUnderlyingRecord()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.cFIOptionStyleandType = builder.getCFIOptionStyleandType();
			this.underlierName = builder.getUnderlierName();
			this.underlyingAssetClass = ofNullable(builder.getUnderlyingAssetClass()).map(f->f.build()).orElse(null);
			this.deliveryType = builder.getDeliveryType();
			this.furtherGrouping = builder.getFurtherGrouping();
		}
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierCharacteristic")
		public String getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("ValuationMethodorTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ValuationMethodorTrigger")
		public AnnaDsbValuationMethodorTriggerEnum getValuationMethodorTrigger() {
			return valuationMethodorTrigger;
		}
		
		@Override
		@RosettaAttribute("ShortName")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ShortName")
		public String getShortName() {
			return shortName;
		}
		
		@Override
		@RosettaAttribute("UnderlyingIssuerType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingIssuerType")
		public AnnaDsbUnderlyingIssuerTypeEnum getUnderlyingIssuerType() {
			return underlyingIssuerType;
		}
		
		@Override
		@RosettaAttribute("ClassificationType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ClassificationType")
		public String getClassificationType() {
			return classificationType;
		}
		
		@Override
		@RosettaAttribute("OptionExerciseStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OptionExerciseStyle")
		public AnnaDsbOptionExerciseStyleEnum getOptionExerciseStyle() {
			return optionExerciseStyle;
		}
		
		@Override
		@RosettaAttribute("UnderlyingAssetType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingAssetType")
		public AnnaDsbUnderlyingAssetTypeEnum getUnderlyingAssetType() {
			return underlyingAssetType;
		}
		
		@Override
		@RosettaAttribute("SingleorMultiCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SingleorMultiCurrency")
		public AnnaDsbSingleorMultiCurrencyEnum getSingleorMultiCurrency() {
			return singleorMultiCurrency;
		}
		
		@Override
		@RosettaAttribute("CFIDeliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CFIDeliveryType")
		public AnnaDsbCFIDeliveryTypeEnum getCFIDeliveryType() {
			return cFIDeliveryType;
		}
		
		@Override
		@RosettaAttribute("UnderlyingRecord")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("UnderlyingRecord")
		public List<? extends AnnaDsbUnderlyingRecord> getUnderlyingRecord() {
			return underlyingRecord;
		}
		
		@Override
		@RosettaAttribute("CFIOptionStyleandType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CFIOptionStyleandType")
		public AnnaDsbCFIOptionStyleandTypeEnum getCFIOptionStyleandType() {
			return cFIOptionStyleandType;
		}
		
		@Override
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierName")
		public String getUnderlierName() {
			return underlierName;
		}
		
		@Override
		@RosettaAttribute("UnderlyingAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingAssetClass")
		public AnnaDsbUnderlyingAssetClass getUnderlyingAssetClass() {
			return underlyingAssetClass;
		}
		
		@Override
		@RosettaAttribute("DeliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DeliveryType")
		public AnnaDsbDeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("FurtherGrouping")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("FurtherGrouping")
		public String getFurtherGrouping() {
			return furtherGrouping;
		}
		
		@Override
		public AnnaDsbDerived build() {
			return this;
		}
		
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder toBuilder() {
			AnnaDsbDerived.AnnaDsbDerivedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbDerived.AnnaDsbDerivedBuilder builder) {
			ofNullable(getReturnorPayoutTrigger()).ifPresent(builder::setReturnorPayoutTrigger);
			ofNullable(getUnderlierCharacteristic()).ifPresent(builder::setUnderlierCharacteristic);
			ofNullable(getValuationMethodorTrigger()).ifPresent(builder::setValuationMethodorTrigger);
			ofNullable(getShortName()).ifPresent(builder::setShortName);
			ofNullable(getUnderlyingIssuerType()).ifPresent(builder::setUnderlyingIssuerType);
			ofNullable(getClassificationType()).ifPresent(builder::setClassificationType);
			ofNullable(getOptionExerciseStyle()).ifPresent(builder::setOptionExerciseStyle);
			ofNullable(getUnderlyingAssetType()).ifPresent(builder::setUnderlyingAssetType);
			ofNullable(getSingleorMultiCurrency()).ifPresent(builder::setSingleorMultiCurrency);
			ofNullable(getCFIDeliveryType()).ifPresent(builder::setCFIDeliveryType);
			ofNullable(getUnderlyingRecord()).ifPresent(builder::setUnderlyingRecord);
			ofNullable(getCFIOptionStyleandType()).ifPresent(builder::setCFIOptionStyleandType);
			ofNullable(getUnderlierName()).ifPresent(builder::setUnderlierName);
			ofNullable(getUnderlyingAssetClass()).ifPresent(builder::setUnderlyingAssetClass);
			ofNullable(getDeliveryType()).ifPresent(builder::setDeliveryType);
			ofNullable(getFurtherGrouping()).ifPresent(builder::setFurtherGrouping);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbDerived _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(valuationMethodorTrigger, _that.getValuationMethodorTrigger())) return false;
			if (!Objects.equals(shortName, _that.getShortName())) return false;
			if (!Objects.equals(underlyingIssuerType, _that.getUnderlyingIssuerType())) return false;
			if (!Objects.equals(classificationType, _that.getClassificationType())) return false;
			if (!Objects.equals(optionExerciseStyle, _that.getOptionExerciseStyle())) return false;
			if (!Objects.equals(underlyingAssetType, _that.getUnderlyingAssetType())) return false;
			if (!Objects.equals(singleorMultiCurrency, _that.getSingleorMultiCurrency())) return false;
			if (!Objects.equals(cFIDeliveryType, _that.getCFIDeliveryType())) return false;
			if (!ListEquals.listEquals(underlyingRecord, _that.getUnderlyingRecord())) return false;
			if (!Objects.equals(cFIOptionStyleandType, _that.getCFIOptionStyleandType())) return false;
			if (!Objects.equals(underlierName, _that.getUnderlierName())) return false;
			if (!Objects.equals(underlyingAssetClass, _that.getUnderlyingAssetClass())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(furtherGrouping, _that.getFurtherGrouping())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.hashCode() : 0);
			_result = 31 * _result + (valuationMethodorTrigger != null ? valuationMethodorTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shortName != null ? shortName.hashCode() : 0);
			_result = 31 * _result + (underlyingIssuerType != null ? underlyingIssuerType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (classificationType != null ? classificationType.hashCode() : 0);
			_result = 31 * _result + (optionExerciseStyle != null ? optionExerciseStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingAssetType != null ? underlyingAssetType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (singleorMultiCurrency != null ? singleorMultiCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cFIDeliveryType != null ? cFIDeliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingRecord != null ? underlyingRecord.hashCode() : 0);
			_result = 31 * _result + (cFIOptionStyleandType != null ? cFIOptionStyleandType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierName != null ? underlierName.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetClass != null ? underlyingAssetClass.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (furtherGrouping != null ? furtherGrouping.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbDerived {" +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"ValuationMethodorTrigger=" + this.valuationMethodorTrigger + ", " +
				"ShortName=" + this.shortName + ", " +
				"UnderlyingIssuerType=" + this.underlyingIssuerType + ", " +
				"ClassificationType=" + this.classificationType + ", " +
				"OptionExerciseStyle=" + this.optionExerciseStyle + ", " +
				"UnderlyingAssetType=" + this.underlyingAssetType + ", " +
				"SingleorMultiCurrency=" + this.singleorMultiCurrency + ", " +
				"CFIDeliveryType=" + this.cFIDeliveryType + ", " +
				"UnderlyingRecord=" + this.underlyingRecord + ", " +
				"CFIOptionStyleandType=" + this.cFIOptionStyleandType + ", " +
				"UnderlierName=" + this.underlierName + ", " +
				"UnderlyingAssetClass=" + this.underlyingAssetClass + ", " +
				"DeliveryType=" + this.deliveryType + ", " +
				"FurtherGrouping=" + this.furtherGrouping +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbDerived  ***********************/
	class AnnaDsbDerivedBuilderImpl implements AnnaDsbDerived.AnnaDsbDerivedBuilder {
	
		protected AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		protected String underlierCharacteristic;
		protected AnnaDsbValuationMethodorTriggerEnum valuationMethodorTrigger;
		protected String shortName;
		protected AnnaDsbUnderlyingIssuerTypeEnum underlyingIssuerType;
		protected String classificationType;
		protected AnnaDsbOptionExerciseStyleEnum optionExerciseStyle;
		protected AnnaDsbUnderlyingAssetTypeEnum underlyingAssetType;
		protected AnnaDsbSingleorMultiCurrencyEnum singleorMultiCurrency;
		protected AnnaDsbCFIDeliveryTypeEnum cFIDeliveryType;
		protected List<AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder> underlyingRecord = new ArrayList<>();
		protected AnnaDsbCFIOptionStyleandTypeEnum cFIOptionStyleandType;
		protected String underlierName;
		protected AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder underlyingAssetClass;
		protected AnnaDsbDeliveryTypeEnum deliveryType;
		protected String furtherGrouping;
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierCharacteristic")
		public String getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("ValuationMethodorTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ValuationMethodorTrigger")
		public AnnaDsbValuationMethodorTriggerEnum getValuationMethodorTrigger() {
			return valuationMethodorTrigger;
		}
		
		@Override
		@RosettaAttribute("ShortName")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ShortName")
		public String getShortName() {
			return shortName;
		}
		
		@Override
		@RosettaAttribute("UnderlyingIssuerType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingIssuerType")
		public AnnaDsbUnderlyingIssuerTypeEnum getUnderlyingIssuerType() {
			return underlyingIssuerType;
		}
		
		@Override
		@RosettaAttribute("ClassificationType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ClassificationType")
		public String getClassificationType() {
			return classificationType;
		}
		
		@Override
		@RosettaAttribute("OptionExerciseStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OptionExerciseStyle")
		public AnnaDsbOptionExerciseStyleEnum getOptionExerciseStyle() {
			return optionExerciseStyle;
		}
		
		@Override
		@RosettaAttribute("UnderlyingAssetType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingAssetType")
		public AnnaDsbUnderlyingAssetTypeEnum getUnderlyingAssetType() {
			return underlyingAssetType;
		}
		
		@Override
		@RosettaAttribute("SingleorMultiCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SingleorMultiCurrency")
		public AnnaDsbSingleorMultiCurrencyEnum getSingleorMultiCurrency() {
			return singleorMultiCurrency;
		}
		
		@Override
		@RosettaAttribute("CFIDeliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CFIDeliveryType")
		public AnnaDsbCFIDeliveryTypeEnum getCFIDeliveryType() {
			return cFIDeliveryType;
		}
		
		@Override
		@RosettaAttribute("UnderlyingRecord")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("UnderlyingRecord")
		public List<? extends AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder> getUnderlyingRecord() {
			return underlyingRecord;
		}
		
		@Override
		public AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder getOrCreateUnderlyingRecord(int index) {
			if (underlyingRecord==null) {
				this.underlyingRecord = new ArrayList<>();
			}
			return getIndex(underlyingRecord, index, () -> {
						AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder newUnderlyingRecord = AnnaDsbUnderlyingRecord.builder();
						return newUnderlyingRecord;
					});
		}
		
		@Override
		@RosettaAttribute("CFIOptionStyleandType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CFIOptionStyleandType")
		public AnnaDsbCFIOptionStyleandTypeEnum getCFIOptionStyleandType() {
			return cFIOptionStyleandType;
		}
		
		@Override
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierName")
		public String getUnderlierName() {
			return underlierName;
		}
		
		@Override
		@RosettaAttribute("UnderlyingAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingAssetClass")
		public AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder getUnderlyingAssetClass() {
			return underlyingAssetClass;
		}
		
		@Override
		public AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder getOrCreateUnderlyingAssetClass() {
			AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder result;
			if (underlyingAssetClass!=null) {
				result = underlyingAssetClass;
			}
			else {
				result = underlyingAssetClass = AnnaDsbUnderlyingAssetClass.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("DeliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DeliveryType")
		public AnnaDsbDeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("FurtherGrouping")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("FurtherGrouping")
		public String getFurtherGrouping() {
			return furtherGrouping;
		}
		
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum _returnorPayoutTrigger) {
			this.returnorPayoutTrigger = _returnorPayoutTrigger == null ? null : _returnorPayoutTrigger;
			return this;
		}
		
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierCharacteristic")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setUnderlierCharacteristic(String _underlierCharacteristic) {
			this.underlierCharacteristic = _underlierCharacteristic == null ? null : _underlierCharacteristic;
			return this;
		}
		
		@RosettaAttribute("ValuationMethodorTrigger")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ValuationMethodorTrigger")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setValuationMethodorTrigger(AnnaDsbValuationMethodorTriggerEnum _valuationMethodorTrigger) {
			this.valuationMethodorTrigger = _valuationMethodorTrigger == null ? null : _valuationMethodorTrigger;
			return this;
		}
		
		@RosettaAttribute("ShortName")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ShortName")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setShortName(String _shortName) {
			this.shortName = _shortName == null ? null : _shortName;
			return this;
		}
		
		@RosettaAttribute("UnderlyingIssuerType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingIssuerType")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setUnderlyingIssuerType(AnnaDsbUnderlyingIssuerTypeEnum _underlyingIssuerType) {
			this.underlyingIssuerType = _underlyingIssuerType == null ? null : _underlyingIssuerType;
			return this;
		}
		
		@RosettaAttribute("ClassificationType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ClassificationType")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setClassificationType(String _classificationType) {
			this.classificationType = _classificationType == null ? null : _classificationType;
			return this;
		}
		
		@RosettaAttribute("OptionExerciseStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OptionExerciseStyle")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setOptionExerciseStyle(AnnaDsbOptionExerciseStyleEnum _optionExerciseStyle) {
			this.optionExerciseStyle = _optionExerciseStyle == null ? null : _optionExerciseStyle;
			return this;
		}
		
		@RosettaAttribute("UnderlyingAssetType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingAssetType")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setUnderlyingAssetType(AnnaDsbUnderlyingAssetTypeEnum _underlyingAssetType) {
			this.underlyingAssetType = _underlyingAssetType == null ? null : _underlyingAssetType;
			return this;
		}
		
		@RosettaAttribute("SingleorMultiCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("SingleorMultiCurrency")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setSingleorMultiCurrency(AnnaDsbSingleorMultiCurrencyEnum _singleorMultiCurrency) {
			this.singleorMultiCurrency = _singleorMultiCurrency == null ? null : _singleorMultiCurrency;
			return this;
		}
		
		@RosettaAttribute("CFIDeliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("CFIDeliveryType")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setCFIDeliveryType(AnnaDsbCFIDeliveryTypeEnum _cFIDeliveryType) {
			this.cFIDeliveryType = _cFIDeliveryType == null ? null : _cFIDeliveryType;
			return this;
		}
		
		@RosettaAttribute("UnderlyingRecord")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("UnderlyingRecord")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder addUnderlyingRecord(AnnaDsbUnderlyingRecord _underlyingRecord) {
			if (_underlyingRecord != null) {
				this.underlyingRecord.add(_underlyingRecord.toBuilder());
			}
			return this;
		}
		
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder addUnderlyingRecord(AnnaDsbUnderlyingRecord _underlyingRecord, int idx) {
			getIndex(this.underlyingRecord, idx, () -> _underlyingRecord.toBuilder());
			return this;
		}
		
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder addUnderlyingRecord(List<? extends AnnaDsbUnderlyingRecord> underlyingRecords) {
			if (underlyingRecords != null) {
				for (final AnnaDsbUnderlyingRecord toAdd : underlyingRecords) {
					this.underlyingRecord.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("UnderlyingRecord")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("UnderlyingRecord")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setUnderlyingRecord(List<? extends AnnaDsbUnderlyingRecord> underlyingRecords) {
			if (underlyingRecords == null) {
				this.underlyingRecord = new ArrayList<>();
			} else {
				this.underlyingRecord = underlyingRecords.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("CFIOptionStyleandType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("CFIOptionStyleandType")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setCFIOptionStyleandType(AnnaDsbCFIOptionStyleandTypeEnum _cFIOptionStyleandType) {
			this.cFIOptionStyleandType = _cFIOptionStyleandType == null ? null : _cFIOptionStyleandType;
			return this;
		}
		
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierName")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setUnderlierName(String _underlierName) {
			this.underlierName = _underlierName == null ? null : _underlierName;
			return this;
		}
		
		@RosettaAttribute("UnderlyingAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingAssetClass")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setUnderlyingAssetClass(AnnaDsbUnderlyingAssetClass _underlyingAssetClass) {
			this.underlyingAssetClass = _underlyingAssetClass == null ? null : _underlyingAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("DeliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("DeliveryType")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setDeliveryType(AnnaDsbDeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("FurtherGrouping")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("FurtherGrouping")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder setFurtherGrouping(String _furtherGrouping) {
			this.furtherGrouping = _furtherGrouping == null ? null : _furtherGrouping;
			return this;
		}
		
		@Override
		public AnnaDsbDerived build() {
			return new AnnaDsbDerived.AnnaDsbDerivedImpl(this);
		}
		
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder prune() {
			underlyingRecord = underlyingRecord.stream().filter(b->b!=null).<AnnaDsbUnderlyingRecord.AnnaDsbUnderlyingRecordBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (underlyingAssetClass!=null && !underlyingAssetClass.prune().hasData()) underlyingAssetClass = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReturnorPayoutTrigger()!=null) return true;
			if (getUnderlierCharacteristic()!=null) return true;
			if (getValuationMethodorTrigger()!=null) return true;
			if (getShortName()!=null) return true;
			if (getUnderlyingIssuerType()!=null) return true;
			if (getClassificationType()!=null) return true;
			if (getOptionExerciseStyle()!=null) return true;
			if (getUnderlyingAssetType()!=null) return true;
			if (getSingleorMultiCurrency()!=null) return true;
			if (getCFIDeliveryType()!=null) return true;
			if (getUnderlyingRecord()!=null && getUnderlyingRecord().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCFIOptionStyleandType()!=null) return true;
			if (getUnderlierName()!=null) return true;
			if (getUnderlyingAssetClass()!=null && getUnderlyingAssetClass().hasData()) return true;
			if (getDeliveryType()!=null) return true;
			if (getFurtherGrouping()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbDerived.AnnaDsbDerivedBuilder o = (AnnaDsbDerived.AnnaDsbDerivedBuilder) other;
			
			merger.mergeRosetta(getUnderlyingRecord(), o.getUnderlyingRecord(), this::getOrCreateUnderlyingRecord);
			merger.mergeRosetta(getUnderlyingAssetClass(), o.getUnderlyingAssetClass(), this::setUnderlyingAssetClass);
			
			merger.mergeBasic(getReturnorPayoutTrigger(), o.getReturnorPayoutTrigger(), this::setReturnorPayoutTrigger);
			merger.mergeBasic(getUnderlierCharacteristic(), o.getUnderlierCharacteristic(), this::setUnderlierCharacteristic);
			merger.mergeBasic(getValuationMethodorTrigger(), o.getValuationMethodorTrigger(), this::setValuationMethodorTrigger);
			merger.mergeBasic(getShortName(), o.getShortName(), this::setShortName);
			merger.mergeBasic(getUnderlyingIssuerType(), o.getUnderlyingIssuerType(), this::setUnderlyingIssuerType);
			merger.mergeBasic(getClassificationType(), o.getClassificationType(), this::setClassificationType);
			merger.mergeBasic(getOptionExerciseStyle(), o.getOptionExerciseStyle(), this::setOptionExerciseStyle);
			merger.mergeBasic(getUnderlyingAssetType(), o.getUnderlyingAssetType(), this::setUnderlyingAssetType);
			merger.mergeBasic(getSingleorMultiCurrency(), o.getSingleorMultiCurrency(), this::setSingleorMultiCurrency);
			merger.mergeBasic(getCFIDeliveryType(), o.getCFIDeliveryType(), this::setCFIDeliveryType);
			merger.mergeBasic(getCFIOptionStyleandType(), o.getCFIOptionStyleandType(), this::setCFIOptionStyleandType);
			merger.mergeBasic(getUnderlierName(), o.getUnderlierName(), this::setUnderlierName);
			merger.mergeBasic(getDeliveryType(), o.getDeliveryType(), this::setDeliveryType);
			merger.mergeBasic(getFurtherGrouping(), o.getFurtherGrouping(), this::setFurtherGrouping);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbDerived _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(valuationMethodorTrigger, _that.getValuationMethodorTrigger())) return false;
			if (!Objects.equals(shortName, _that.getShortName())) return false;
			if (!Objects.equals(underlyingIssuerType, _that.getUnderlyingIssuerType())) return false;
			if (!Objects.equals(classificationType, _that.getClassificationType())) return false;
			if (!Objects.equals(optionExerciseStyle, _that.getOptionExerciseStyle())) return false;
			if (!Objects.equals(underlyingAssetType, _that.getUnderlyingAssetType())) return false;
			if (!Objects.equals(singleorMultiCurrency, _that.getSingleorMultiCurrency())) return false;
			if (!Objects.equals(cFIDeliveryType, _that.getCFIDeliveryType())) return false;
			if (!ListEquals.listEquals(underlyingRecord, _that.getUnderlyingRecord())) return false;
			if (!Objects.equals(cFIOptionStyleandType, _that.getCFIOptionStyleandType())) return false;
			if (!Objects.equals(underlierName, _that.getUnderlierName())) return false;
			if (!Objects.equals(underlyingAssetClass, _that.getUnderlyingAssetClass())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(furtherGrouping, _that.getFurtherGrouping())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.hashCode() : 0);
			_result = 31 * _result + (valuationMethodorTrigger != null ? valuationMethodorTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shortName != null ? shortName.hashCode() : 0);
			_result = 31 * _result + (underlyingIssuerType != null ? underlyingIssuerType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (classificationType != null ? classificationType.hashCode() : 0);
			_result = 31 * _result + (optionExerciseStyle != null ? optionExerciseStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingAssetType != null ? underlyingAssetType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (singleorMultiCurrency != null ? singleorMultiCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (cFIDeliveryType != null ? cFIDeliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingRecord != null ? underlyingRecord.hashCode() : 0);
			_result = 31 * _result + (cFIOptionStyleandType != null ? cFIOptionStyleandType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierName != null ? underlierName.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetClass != null ? underlyingAssetClass.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (furtherGrouping != null ? furtherGrouping.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbDerivedBuilder {" +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"ValuationMethodorTrigger=" + this.valuationMethodorTrigger + ", " +
				"ShortName=" + this.shortName + ", " +
				"UnderlyingIssuerType=" + this.underlyingIssuerType + ", " +
				"ClassificationType=" + this.classificationType + ", " +
				"OptionExerciseStyle=" + this.optionExerciseStyle + ", " +
				"UnderlyingAssetType=" + this.underlyingAssetType + ", " +
				"SingleorMultiCurrency=" + this.singleorMultiCurrency + ", " +
				"CFIDeliveryType=" + this.cFIDeliveryType + ", " +
				"UnderlyingRecord=" + this.underlyingRecord + ", " +
				"CFIOptionStyleandType=" + this.cFIOptionStyleandType + ", " +
				"UnderlierName=" + this.underlierName + ", " +
				"UnderlyingAssetClass=" + this.underlyingAssetClass + ", " +
				"DeliveryType=" + this.deliveryType + ", " +
				"FurtherGrouping=" + this.furtherGrouping +
			'}';
		}
	}
}

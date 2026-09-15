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
import drr.standards.iosco.upi.meta.AnnaDsbAttributesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbAttributes", builder=AnnaDsbAttributes.AnnaDsbAttributesBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbAttributes", model="drr", builder=AnnaDsbAttributes.AnnaDsbAttributesBuilderImpl.class, version="7.7.0")
public interface AnnaDsbAttributes extends RosettaModelObject {

	AnnaDsbAttributesMeta metaData = new AnnaDsbAttributesMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger();
	String getAdditionalSubProduct();
	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getUnderlyingInstrumentIndexTermUnit();
	AnnaDsbValuationMethodorTriggerEnum getValuationMethodorTrigger();
	String getUnderlyingInstrumentISIN();
	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getOtherLegReferenceRateTermUnit();
	AnnaDsbNotionalScheduleEnum getNotionalSchedule();
	AnnaDsbOtherUnderlying getOtherUnderlying();
	AnnaDsbUnderlyingIssuerTypeEnum getUnderlyingIssuerType();
	AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource();
	AnnaDsbPlaceofSettlementEnum getPlaceofSettlement();
	Integer getUnderlyingInstrumentIndexTermValue();
	String getSettlementCurrency();
	String getUnderlyingInstrumentIndex();
	AnnaDsbBaseProduct getBaseProduct();
	String getUnderlyingInstrumentUPI();
	AnnaDsbOtherLegUnderlierType getOtherLegUnderlierType();
	AnnaDsbUnderlyingAssetClass getUnderlyingAssetClass();
	AnnaDsbOptionTypeEnum getOptionType();
	AnnaDsbDeliveryTypeEnum getDeliveryType();
	AnnaDsbContractSpecificationEnum getContractSpecification();
	String getSubProduct();
	AnnaDsbDebtSeniorityEnum getDebtSeniority();
	String getReferenceRate();
	AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic();
	String getOtherUnderlierID();
	AnnaDsbOtherUnderlierIDSourceEnum getOtherUnderlierIDSource();
	String getUnderlierID();
	String getOtherReferenceRate();
	String getNotionalCurrency();
	AnnaDsbOtherLegUnderlying getOtherLegUnderlying();
	String getOtherNotionalCurrency();
	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getReferenceRateTermUnit();
	AnnaDsbOptionExerciseStyleEnum getOptionExerciseStyle();
	AnnaDsbUnderlyingAssetTypeEnum getUnderlyingAssetType();
	Integer getOtherLegReferenceRateTermValue();
	AnnaDsbUnderlierCharacteristicEnum getOtherUnderlierCharacteristic();
	String getOtherLegUnderlierID();
	String getOtherSubProduct();
	String getOtherLegReferenceRate();
	AnnaDsbUnderlying getUnderlying();
	AnnaDsbBaseProduct getOtherBaseProduct();
	String getUnderlyingInstrumentIndexProp();
	Integer getReferenceRateTermValue();
	AnnaDsbOtherLegUnderlierIDSourceEnum getOtherLegUnderlierIDSource();
	String getOtherAdditionalSubProduct();
	AnnaDsbCategory getCategory();

	/*********************** Build Methods  ***********************/
	AnnaDsbAttributes build();
	
	AnnaDsbAttributes.AnnaDsbAttributesBuilder toBuilder();
	
	static AnnaDsbAttributes.AnnaDsbAttributesBuilder builder() {
		return new AnnaDsbAttributes.AnnaDsbAttributesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbAttributes> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbAttributes> getType() {
		return AnnaDsbAttributes.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
		processor.processBasic(path.newSubPath("AdditionalSubProduct"), String.class, getAdditionalSubProduct(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getUnderlyingInstrumentIndexTermUnit(), this);
		processor.processBasic(path.newSubPath("ValuationMethodorTrigger"), AnnaDsbValuationMethodorTriggerEnum.class, getValuationMethodorTrigger(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentISIN"), String.class, getUnderlyingInstrumentISIN(), this);
		processor.processBasic(path.newSubPath("OtherLegReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getOtherLegReferenceRateTermUnit(), this);
		processor.processBasic(path.newSubPath("NotionalSchedule"), AnnaDsbNotionalScheduleEnum.class, getNotionalSchedule(), this);
		processRosetta(path.newSubPath("OtherUnderlying"), processor, AnnaDsbOtherUnderlying.class, getOtherUnderlying());
		processor.processBasic(path.newSubPath("UnderlyingIssuerType"), AnnaDsbUnderlyingIssuerTypeEnum.class, getUnderlyingIssuerType(), this);
		processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
		processor.processBasic(path.newSubPath("PlaceofSettlement"), AnnaDsbPlaceofSettlementEnum.class, getPlaceofSettlement(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermValue"), Integer.class, getUnderlyingInstrumentIndexTermValue(), this);
		processor.processBasic(path.newSubPath("SettlementCurrency"), String.class, getSettlementCurrency(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndex"), String.class, getUnderlyingInstrumentIndex(), this);
		processRosetta(path.newSubPath("BaseProduct"), processor, AnnaDsbBaseProduct.class, getBaseProduct());
		processor.processBasic(path.newSubPath("UnderlyingInstrumentUPI"), String.class, getUnderlyingInstrumentUPI(), this);
		processRosetta(path.newSubPath("OtherLegUnderlierType"), processor, AnnaDsbOtherLegUnderlierType.class, getOtherLegUnderlierType());
		processRosetta(path.newSubPath("UnderlyingAssetClass"), processor, AnnaDsbUnderlyingAssetClass.class, getUnderlyingAssetClass());
		processor.processBasic(path.newSubPath("OptionType"), AnnaDsbOptionTypeEnum.class, getOptionType(), this);
		processor.processBasic(path.newSubPath("DeliveryType"), AnnaDsbDeliveryTypeEnum.class, getDeliveryType(), this);
		processor.processBasic(path.newSubPath("ContractSpecification"), AnnaDsbContractSpecificationEnum.class, getContractSpecification(), this);
		processor.processBasic(path.newSubPath("SubProduct"), String.class, getSubProduct(), this);
		processor.processBasic(path.newSubPath("DebtSeniority"), AnnaDsbDebtSeniorityEnum.class, getDebtSeniority(), this);
		processor.processBasic(path.newSubPath("ReferenceRate"), String.class, getReferenceRate(), this);
		processor.processBasic(path.newSubPath("UnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getUnderlierCharacteristic(), this);
		processor.processBasic(path.newSubPath("OtherUnderlierID"), String.class, getOtherUnderlierID(), this);
		processor.processBasic(path.newSubPath("OtherUnderlierIDSource"), AnnaDsbOtherUnderlierIDSourceEnum.class, getOtherUnderlierIDSource(), this);
		processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
		processor.processBasic(path.newSubPath("OtherReferenceRate"), String.class, getOtherReferenceRate(), this);
		processor.processBasic(path.newSubPath("NotionalCurrency"), String.class, getNotionalCurrency(), this);
		processRosetta(path.newSubPath("OtherLegUnderlying"), processor, AnnaDsbOtherLegUnderlying.class, getOtherLegUnderlying());
		processor.processBasic(path.newSubPath("OtherNotionalCurrency"), String.class, getOtherNotionalCurrency(), this);
		processor.processBasic(path.newSubPath("ReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getReferenceRateTermUnit(), this);
		processor.processBasic(path.newSubPath("OptionExerciseStyle"), AnnaDsbOptionExerciseStyleEnum.class, getOptionExerciseStyle(), this);
		processor.processBasic(path.newSubPath("UnderlyingAssetType"), AnnaDsbUnderlyingAssetTypeEnum.class, getUnderlyingAssetType(), this);
		processor.processBasic(path.newSubPath("OtherLegReferenceRateTermValue"), Integer.class, getOtherLegReferenceRateTermValue(), this);
		processor.processBasic(path.newSubPath("OtherUnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getOtherUnderlierCharacteristic(), this);
		processor.processBasic(path.newSubPath("OtherLegUnderlierID"), String.class, getOtherLegUnderlierID(), this);
		processor.processBasic(path.newSubPath("OtherSubProduct"), String.class, getOtherSubProduct(), this);
		processor.processBasic(path.newSubPath("OtherLegReferenceRate"), String.class, getOtherLegReferenceRate(), this);
		processRosetta(path.newSubPath("Underlying"), processor, AnnaDsbUnderlying.class, getUnderlying());
		processRosetta(path.newSubPath("OtherBaseProduct"), processor, AnnaDsbBaseProduct.class, getOtherBaseProduct());
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexProp"), String.class, getUnderlyingInstrumentIndexProp(), this);
		processor.processBasic(path.newSubPath("ReferenceRateTermValue"), Integer.class, getReferenceRateTermValue(), this);
		processor.processBasic(path.newSubPath("OtherLegUnderlierIDSource"), AnnaDsbOtherLegUnderlierIDSourceEnum.class, getOtherLegUnderlierIDSource(), this);
		processor.processBasic(path.newSubPath("OtherAdditionalSubProduct"), String.class, getOtherAdditionalSubProduct(), this);
		processRosetta(path.newSubPath("Category"), processor, AnnaDsbCategory.class, getCategory());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbAttributesBuilder extends AnnaDsbAttributes, RosettaModelObjectBuilder {
		AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder getOrCreateOtherUnderlying();
		@Override
		AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder getOtherUnderlying();
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder getOrCreateBaseProduct();
		@Override
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder getBaseProduct();
		AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder getOrCreateOtherLegUnderlierType();
		@Override
		AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder getOtherLegUnderlierType();
		AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder getOrCreateUnderlyingAssetClass();
		@Override
		AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder getUnderlyingAssetClass();
		AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder getOrCreateOtherLegUnderlying();
		@Override
		AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder getOtherLegUnderlying();
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getOrCreateUnderlying();
		@Override
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getUnderlying();
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder getOrCreateOtherBaseProduct();
		@Override
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder getOtherBaseProduct();
		AnnaDsbCategory.AnnaDsbCategoryBuilder getOrCreateCategory();
		@Override
		AnnaDsbCategory.AnnaDsbCategoryBuilder getCategory();
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum ReturnorPayoutTrigger);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setAdditionalSubProduct(String AdditionalSubProduct);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum UnderlyingInstrumentIndexTermUnit);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setValuationMethodorTrigger(AnnaDsbValuationMethodorTriggerEnum ValuationMethodorTrigger);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingInstrumentISIN(String UnderlyingInstrumentISIN);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum OtherLegReferenceRateTermUnit);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setNotionalSchedule(AnnaDsbNotionalScheduleEnum NotionalSchedule);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherUnderlying(AnnaDsbOtherUnderlying OtherUnderlying);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingIssuerType(AnnaDsbUnderlyingIssuerTypeEnum UnderlyingIssuerType);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum UnderlierIDSource);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setPlaceofSettlement(AnnaDsbPlaceofSettlementEnum PlaceofSettlement);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingInstrumentIndexTermValue(Integer UnderlyingInstrumentIndexTermValue);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setSettlementCurrency(String SettlementCurrency);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingInstrumentIndex(String UnderlyingInstrumentIndex);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setBaseProduct(AnnaDsbBaseProduct BaseProduct);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingInstrumentUPI(String UnderlyingInstrumentUPI);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegUnderlierType(AnnaDsbOtherLegUnderlierType OtherLegUnderlierType);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingAssetClass(AnnaDsbUnderlyingAssetClass UnderlyingAssetClass);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOptionType(AnnaDsbOptionTypeEnum OptionType);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setDeliveryType(AnnaDsbDeliveryTypeEnum DeliveryType);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setContractSpecification(AnnaDsbContractSpecificationEnum ContractSpecification);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setSubProduct(String SubProduct);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setDebtSeniority(AnnaDsbDebtSeniorityEnum DebtSeniority);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setReferenceRate(String ReferenceRate);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum UnderlierCharacteristic);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherUnderlierID(String OtherUnderlierID);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherUnderlierIDSource(AnnaDsbOtherUnderlierIDSourceEnum OtherUnderlierIDSource);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlierID(String UnderlierID);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherReferenceRate(String OtherReferenceRate);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setNotionalCurrency(String NotionalCurrency);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegUnderlying(AnnaDsbOtherLegUnderlying OtherLegUnderlying);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherNotionalCurrency(String OtherNotionalCurrency);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum ReferenceRateTermUnit);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOptionExerciseStyle(AnnaDsbOptionExerciseStyleEnum OptionExerciseStyle);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingAssetType(AnnaDsbUnderlyingAssetTypeEnum UnderlyingAssetType);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegReferenceRateTermValue(Integer OtherLegReferenceRateTermValue);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum OtherUnderlierCharacteristic);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegUnderlierID(String OtherLegUnderlierID);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherSubProduct(String OtherSubProduct);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegReferenceRate(String OtherLegReferenceRate);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlying(AnnaDsbUnderlying Underlying);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherBaseProduct(AnnaDsbBaseProduct OtherBaseProduct);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingInstrumentIndexProp(String UnderlyingInstrumentIndexProp);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setReferenceRateTermValue(Integer ReferenceRateTermValue);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegUnderlierIDSource(AnnaDsbOtherLegUnderlierIDSourceEnum OtherLegUnderlierIDSource);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherAdditionalSubProduct(String OtherAdditionalSubProduct);
		AnnaDsbAttributes.AnnaDsbAttributesBuilder setCategory(AnnaDsbCategory Category);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
			processor.processBasic(path.newSubPath("AdditionalSubProduct"), String.class, getAdditionalSubProduct(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getUnderlyingInstrumentIndexTermUnit(), this);
			processor.processBasic(path.newSubPath("ValuationMethodorTrigger"), AnnaDsbValuationMethodorTriggerEnum.class, getValuationMethodorTrigger(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentISIN"), String.class, getUnderlyingInstrumentISIN(), this);
			processor.processBasic(path.newSubPath("OtherLegReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getOtherLegReferenceRateTermUnit(), this);
			processor.processBasic(path.newSubPath("NotionalSchedule"), AnnaDsbNotionalScheduleEnum.class, getNotionalSchedule(), this);
			processRosetta(path.newSubPath("OtherUnderlying"), processor, AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder.class, getOtherUnderlying());
			processor.processBasic(path.newSubPath("UnderlyingIssuerType"), AnnaDsbUnderlyingIssuerTypeEnum.class, getUnderlyingIssuerType(), this);
			processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("PlaceofSettlement"), AnnaDsbPlaceofSettlementEnum.class, getPlaceofSettlement(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermValue"), Integer.class, getUnderlyingInstrumentIndexTermValue(), this);
			processor.processBasic(path.newSubPath("SettlementCurrency"), String.class, getSettlementCurrency(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndex"), String.class, getUnderlyingInstrumentIndex(), this);
			processRosetta(path.newSubPath("BaseProduct"), processor, AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder.class, getBaseProduct());
			processor.processBasic(path.newSubPath("UnderlyingInstrumentUPI"), String.class, getUnderlyingInstrumentUPI(), this);
			processRosetta(path.newSubPath("OtherLegUnderlierType"), processor, AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder.class, getOtherLegUnderlierType());
			processRosetta(path.newSubPath("UnderlyingAssetClass"), processor, AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder.class, getUnderlyingAssetClass());
			processor.processBasic(path.newSubPath("OptionType"), AnnaDsbOptionTypeEnum.class, getOptionType(), this);
			processor.processBasic(path.newSubPath("DeliveryType"), AnnaDsbDeliveryTypeEnum.class, getDeliveryType(), this);
			processor.processBasic(path.newSubPath("ContractSpecification"), AnnaDsbContractSpecificationEnum.class, getContractSpecification(), this);
			processor.processBasic(path.newSubPath("SubProduct"), String.class, getSubProduct(), this);
			processor.processBasic(path.newSubPath("DebtSeniority"), AnnaDsbDebtSeniorityEnum.class, getDebtSeniority(), this);
			processor.processBasic(path.newSubPath("ReferenceRate"), String.class, getReferenceRate(), this);
			processor.processBasic(path.newSubPath("UnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getUnderlierCharacteristic(), this);
			processor.processBasic(path.newSubPath("OtherUnderlierID"), String.class, getOtherUnderlierID(), this);
			processor.processBasic(path.newSubPath("OtherUnderlierIDSource"), AnnaDsbOtherUnderlierIDSourceEnum.class, getOtherUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
			processor.processBasic(path.newSubPath("OtherReferenceRate"), String.class, getOtherReferenceRate(), this);
			processor.processBasic(path.newSubPath("NotionalCurrency"), String.class, getNotionalCurrency(), this);
			processRosetta(path.newSubPath("OtherLegUnderlying"), processor, AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder.class, getOtherLegUnderlying());
			processor.processBasic(path.newSubPath("OtherNotionalCurrency"), String.class, getOtherNotionalCurrency(), this);
			processor.processBasic(path.newSubPath("ReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getReferenceRateTermUnit(), this);
			processor.processBasic(path.newSubPath("OptionExerciseStyle"), AnnaDsbOptionExerciseStyleEnum.class, getOptionExerciseStyle(), this);
			processor.processBasic(path.newSubPath("UnderlyingAssetType"), AnnaDsbUnderlyingAssetTypeEnum.class, getUnderlyingAssetType(), this);
			processor.processBasic(path.newSubPath("OtherLegReferenceRateTermValue"), Integer.class, getOtherLegReferenceRateTermValue(), this);
			processor.processBasic(path.newSubPath("OtherUnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getOtherUnderlierCharacteristic(), this);
			processor.processBasic(path.newSubPath("OtherLegUnderlierID"), String.class, getOtherLegUnderlierID(), this);
			processor.processBasic(path.newSubPath("OtherSubProduct"), String.class, getOtherSubProduct(), this);
			processor.processBasic(path.newSubPath("OtherLegReferenceRate"), String.class, getOtherLegReferenceRate(), this);
			processRosetta(path.newSubPath("Underlying"), processor, AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder.class, getUnderlying());
			processRosetta(path.newSubPath("OtherBaseProduct"), processor, AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder.class, getOtherBaseProduct());
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexProp"), String.class, getUnderlyingInstrumentIndexProp(), this);
			processor.processBasic(path.newSubPath("ReferenceRateTermValue"), Integer.class, getReferenceRateTermValue(), this);
			processor.processBasic(path.newSubPath("OtherLegUnderlierIDSource"), AnnaDsbOtherLegUnderlierIDSourceEnum.class, getOtherLegUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("OtherAdditionalSubProduct"), String.class, getOtherAdditionalSubProduct(), this);
			processRosetta(path.newSubPath("Category"), processor, AnnaDsbCategory.AnnaDsbCategoryBuilder.class, getCategory());
		}
		

		AnnaDsbAttributes.AnnaDsbAttributesBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbAttributes  ***********************/
	class AnnaDsbAttributesImpl implements AnnaDsbAttributes {
		private final AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		private final String additionalSubProduct;
		private final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum underlyingInstrumentIndexTermUnit;
		private final AnnaDsbValuationMethodorTriggerEnum valuationMethodorTrigger;
		private final String underlyingInstrumentISIN;
		private final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum otherLegReferenceRateTermUnit;
		private final AnnaDsbNotionalScheduleEnum notionalSchedule;
		private final AnnaDsbOtherUnderlying otherUnderlying;
		private final AnnaDsbUnderlyingIssuerTypeEnum underlyingIssuerType;
		private final AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		private final AnnaDsbPlaceofSettlementEnum placeofSettlement;
		private final Integer underlyingInstrumentIndexTermValue;
		private final String settlementCurrency;
		private final String underlyingInstrumentIndex;
		private final AnnaDsbBaseProduct baseProduct;
		private final String underlyingInstrumentUPI;
		private final AnnaDsbOtherLegUnderlierType otherLegUnderlierType;
		private final AnnaDsbUnderlyingAssetClass underlyingAssetClass;
		private final AnnaDsbOptionTypeEnum optionType;
		private final AnnaDsbDeliveryTypeEnum deliveryType;
		private final AnnaDsbContractSpecificationEnum contractSpecification;
		private final String subProduct;
		private final AnnaDsbDebtSeniorityEnum debtSeniority;
		private final String referenceRate;
		private final AnnaDsbUnderlierCharacteristicEnum underlierCharacteristic;
		private final String otherUnderlierID;
		private final AnnaDsbOtherUnderlierIDSourceEnum otherUnderlierIDSource;
		private final String underlierID;
		private final String otherReferenceRate;
		private final String notionalCurrency;
		private final AnnaDsbOtherLegUnderlying otherLegUnderlying;
		private final String otherNotionalCurrency;
		private final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum referenceRateTermUnit;
		private final AnnaDsbOptionExerciseStyleEnum optionExerciseStyle;
		private final AnnaDsbUnderlyingAssetTypeEnum underlyingAssetType;
		private final Integer otherLegReferenceRateTermValue;
		private final AnnaDsbUnderlierCharacteristicEnum otherUnderlierCharacteristic;
		private final String otherLegUnderlierID;
		private final String otherSubProduct;
		private final String otherLegReferenceRate;
		private final AnnaDsbUnderlying underlying;
		private final AnnaDsbBaseProduct otherBaseProduct;
		private final String underlyingInstrumentIndexProp;
		private final Integer referenceRateTermValue;
		private final AnnaDsbOtherLegUnderlierIDSourceEnum otherLegUnderlierIDSource;
		private final String otherAdditionalSubProduct;
		private final AnnaDsbCategory category;
		
		protected AnnaDsbAttributesImpl(AnnaDsbAttributes.AnnaDsbAttributesBuilder builder) {
			this.returnorPayoutTrigger = builder.getReturnorPayoutTrigger();
			this.additionalSubProduct = builder.getAdditionalSubProduct();
			this.underlyingInstrumentIndexTermUnit = builder.getUnderlyingInstrumentIndexTermUnit();
			this.valuationMethodorTrigger = builder.getValuationMethodorTrigger();
			this.underlyingInstrumentISIN = builder.getUnderlyingInstrumentISIN();
			this.otherLegReferenceRateTermUnit = builder.getOtherLegReferenceRateTermUnit();
			this.notionalSchedule = builder.getNotionalSchedule();
			this.otherUnderlying = ofNullable(builder.getOtherUnderlying()).map(f->f.build()).orElse(null);
			this.underlyingIssuerType = builder.getUnderlyingIssuerType();
			this.underlierIDSource = builder.getUnderlierIDSource();
			this.placeofSettlement = builder.getPlaceofSettlement();
			this.underlyingInstrumentIndexTermValue = builder.getUnderlyingInstrumentIndexTermValue();
			this.settlementCurrency = builder.getSettlementCurrency();
			this.underlyingInstrumentIndex = builder.getUnderlyingInstrumentIndex();
			this.baseProduct = ofNullable(builder.getBaseProduct()).map(f->f.build()).orElse(null);
			this.underlyingInstrumentUPI = builder.getUnderlyingInstrumentUPI();
			this.otherLegUnderlierType = ofNullable(builder.getOtherLegUnderlierType()).map(f->f.build()).orElse(null);
			this.underlyingAssetClass = ofNullable(builder.getUnderlyingAssetClass()).map(f->f.build()).orElse(null);
			this.optionType = builder.getOptionType();
			this.deliveryType = builder.getDeliveryType();
			this.contractSpecification = builder.getContractSpecification();
			this.subProduct = builder.getSubProduct();
			this.debtSeniority = builder.getDebtSeniority();
			this.referenceRate = builder.getReferenceRate();
			this.underlierCharacteristic = builder.getUnderlierCharacteristic();
			this.otherUnderlierID = builder.getOtherUnderlierID();
			this.otherUnderlierIDSource = builder.getOtherUnderlierIDSource();
			this.underlierID = builder.getUnderlierID();
			this.otherReferenceRate = builder.getOtherReferenceRate();
			this.notionalCurrency = builder.getNotionalCurrency();
			this.otherLegUnderlying = ofNullable(builder.getOtherLegUnderlying()).map(f->f.build()).orElse(null);
			this.otherNotionalCurrency = builder.getOtherNotionalCurrency();
			this.referenceRateTermUnit = builder.getReferenceRateTermUnit();
			this.optionExerciseStyle = builder.getOptionExerciseStyle();
			this.underlyingAssetType = builder.getUnderlyingAssetType();
			this.otherLegReferenceRateTermValue = builder.getOtherLegReferenceRateTermValue();
			this.otherUnderlierCharacteristic = builder.getOtherUnderlierCharacteristic();
			this.otherLegUnderlierID = builder.getOtherLegUnderlierID();
			this.otherSubProduct = builder.getOtherSubProduct();
			this.otherLegReferenceRate = builder.getOtherLegReferenceRate();
			this.underlying = ofNullable(builder.getUnderlying()).map(f->f.build()).orElse(null);
			this.otherBaseProduct = ofNullable(builder.getOtherBaseProduct()).map(f->f.build()).orElse(null);
			this.underlyingInstrumentIndexProp = builder.getUnderlyingInstrumentIndexProp();
			this.referenceRateTermValue = builder.getReferenceRateTermValue();
			this.otherLegUnderlierIDSource = builder.getOtherLegUnderlierIDSource();
			this.otherAdditionalSubProduct = builder.getOtherAdditionalSubProduct();
			this.category = ofNullable(builder.getCategory()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("AdditionalSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("AdditionalSubProduct")
		public String getAdditionalSubProduct() {
			return additionalSubProduct;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getUnderlyingInstrumentIndexTermUnit() {
			return underlyingInstrumentIndexTermUnit;
		}
		
		@Override
		@RosettaAttribute("ValuationMethodorTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ValuationMethodorTrigger")
		public AnnaDsbValuationMethodorTriggerEnum getValuationMethodorTrigger() {
			return valuationMethodorTrigger;
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
		@RosettaAttribute("NotionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NotionalSchedule")
		public AnnaDsbNotionalScheduleEnum getNotionalSchedule() {
			return notionalSchedule;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlying")
		public AnnaDsbOtherUnderlying getOtherUnderlying() {
			return otherUnderlying;
		}
		
		@Override
		@RosettaAttribute("UnderlyingIssuerType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingIssuerType")
		public AnnaDsbUnderlyingIssuerTypeEnum getUnderlyingIssuerType() {
			return underlyingIssuerType;
		}
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("PlaceofSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("PlaceofSettlement")
		public AnnaDsbPlaceofSettlementEnum getPlaceofSettlement() {
			return placeofSettlement;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermValue")
		public Integer getUnderlyingInstrumentIndexTermValue() {
			return underlyingInstrumentIndexTermValue;
		}
		
		@Override
		@RosettaAttribute("SettlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SettlementCurrency")
		public String getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		public String getUnderlyingInstrumentIndex() {
			return underlyingInstrumentIndex;
		}
		
		@Override
		@RosettaAttribute("BaseProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("BaseProduct")
		public AnnaDsbBaseProduct getBaseProduct() {
			return baseProduct;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentUPI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentUPI")
		public String getUnderlyingInstrumentUPI() {
			return underlyingInstrumentUPI;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierType")
		public AnnaDsbOtherLegUnderlierType getOtherLegUnderlierType() {
			return otherLegUnderlierType;
		}
		
		@Override
		@RosettaAttribute("UnderlyingAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingAssetClass")
		public AnnaDsbUnderlyingAssetClass getUnderlyingAssetClass() {
			return underlyingAssetClass;
		}
		
		@Override
		@RosettaAttribute("OptionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OptionType")
		public AnnaDsbOptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("DeliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DeliveryType")
		public AnnaDsbDeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("ContractSpecification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ContractSpecification")
		public AnnaDsbContractSpecificationEnum getContractSpecification() {
			return contractSpecification;
		}
		
		@Override
		@RosettaAttribute("SubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SubProduct")
		public String getSubProduct() {
			return subProduct;
		}
		
		@Override
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DebtSeniority")
		public AnnaDsbDebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
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
		public AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierID")
		public String getOtherUnderlierID() {
			return otherUnderlierID;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierIDSource")
		public AnnaDsbOtherUnderlierIDSourceEnum getOtherUnderlierIDSource() {
			return otherUnderlierIDSource;
		}
		
		@Override
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierID")
		public String getUnderlierID() {
			return underlierID;
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
		@RosettaAttribute("OtherLegReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRateTermValue")
		public Integer getOtherLegReferenceRateTermValue() {
			return otherLegReferenceRateTermValue;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getOtherUnderlierCharacteristic() {
			return otherUnderlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierID")
		public String getOtherLegUnderlierID() {
			return otherLegUnderlierID;
		}
		
		@Override
		@RosettaAttribute("OtherSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherSubProduct")
		public String getOtherSubProduct() {
			return otherSubProduct;
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
		@RosettaAttribute("OtherBaseProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherBaseProduct")
		public AnnaDsbBaseProduct getOtherBaseProduct() {
			return otherBaseProduct;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		public String getUnderlyingInstrumentIndexProp() {
			return underlyingInstrumentIndexProp;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermValue")
		public Integer getReferenceRateTermValue() {
			return referenceRateTermValue;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierIDSource")
		public AnnaDsbOtherLegUnderlierIDSourceEnum getOtherLegUnderlierIDSource() {
			return otherLegUnderlierIDSource;
		}
		
		@Override
		@RosettaAttribute("OtherAdditionalSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherAdditionalSubProduct")
		public String getOtherAdditionalSubProduct() {
			return otherAdditionalSubProduct;
		}
		
		@Override
		@RosettaAttribute("Category")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Category")
		public AnnaDsbCategory getCategory() {
			return category;
		}
		
		@Override
		public AnnaDsbAttributes build() {
			return this;
		}
		
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder toBuilder() {
			AnnaDsbAttributes.AnnaDsbAttributesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbAttributes.AnnaDsbAttributesBuilder builder) {
			ofNullable(getReturnorPayoutTrigger()).ifPresent(builder::setReturnorPayoutTrigger);
			ofNullable(getAdditionalSubProduct()).ifPresent(builder::setAdditionalSubProduct);
			ofNullable(getUnderlyingInstrumentIndexTermUnit()).ifPresent(builder::setUnderlyingInstrumentIndexTermUnit);
			ofNullable(getValuationMethodorTrigger()).ifPresent(builder::setValuationMethodorTrigger);
			ofNullable(getUnderlyingInstrumentISIN()).ifPresent(builder::setUnderlyingInstrumentISIN);
			ofNullable(getOtherLegReferenceRateTermUnit()).ifPresent(builder::setOtherLegReferenceRateTermUnit);
			ofNullable(getNotionalSchedule()).ifPresent(builder::setNotionalSchedule);
			ofNullable(getOtherUnderlying()).ifPresent(builder::setOtherUnderlying);
			ofNullable(getUnderlyingIssuerType()).ifPresent(builder::setUnderlyingIssuerType);
			ofNullable(getUnderlierIDSource()).ifPresent(builder::setUnderlierIDSource);
			ofNullable(getPlaceofSettlement()).ifPresent(builder::setPlaceofSettlement);
			ofNullable(getUnderlyingInstrumentIndexTermValue()).ifPresent(builder::setUnderlyingInstrumentIndexTermValue);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getUnderlyingInstrumentIndex()).ifPresent(builder::setUnderlyingInstrumentIndex);
			ofNullable(getBaseProduct()).ifPresent(builder::setBaseProduct);
			ofNullable(getUnderlyingInstrumentUPI()).ifPresent(builder::setUnderlyingInstrumentUPI);
			ofNullable(getOtherLegUnderlierType()).ifPresent(builder::setOtherLegUnderlierType);
			ofNullable(getUnderlyingAssetClass()).ifPresent(builder::setUnderlyingAssetClass);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getDeliveryType()).ifPresent(builder::setDeliveryType);
			ofNullable(getContractSpecification()).ifPresent(builder::setContractSpecification);
			ofNullable(getSubProduct()).ifPresent(builder::setSubProduct);
			ofNullable(getDebtSeniority()).ifPresent(builder::setDebtSeniority);
			ofNullable(getReferenceRate()).ifPresent(builder::setReferenceRate);
			ofNullable(getUnderlierCharacteristic()).ifPresent(builder::setUnderlierCharacteristic);
			ofNullable(getOtherUnderlierID()).ifPresent(builder::setOtherUnderlierID);
			ofNullable(getOtherUnderlierIDSource()).ifPresent(builder::setOtherUnderlierIDSource);
			ofNullable(getUnderlierID()).ifPresent(builder::setUnderlierID);
			ofNullable(getOtherReferenceRate()).ifPresent(builder::setOtherReferenceRate);
			ofNullable(getNotionalCurrency()).ifPresent(builder::setNotionalCurrency);
			ofNullable(getOtherLegUnderlying()).ifPresent(builder::setOtherLegUnderlying);
			ofNullable(getOtherNotionalCurrency()).ifPresent(builder::setOtherNotionalCurrency);
			ofNullable(getReferenceRateTermUnit()).ifPresent(builder::setReferenceRateTermUnit);
			ofNullable(getOptionExerciseStyle()).ifPresent(builder::setOptionExerciseStyle);
			ofNullable(getUnderlyingAssetType()).ifPresent(builder::setUnderlyingAssetType);
			ofNullable(getOtherLegReferenceRateTermValue()).ifPresent(builder::setOtherLegReferenceRateTermValue);
			ofNullable(getOtherUnderlierCharacteristic()).ifPresent(builder::setOtherUnderlierCharacteristic);
			ofNullable(getOtherLegUnderlierID()).ifPresent(builder::setOtherLegUnderlierID);
			ofNullable(getOtherSubProduct()).ifPresent(builder::setOtherSubProduct);
			ofNullable(getOtherLegReferenceRate()).ifPresent(builder::setOtherLegReferenceRate);
			ofNullable(getUnderlying()).ifPresent(builder::setUnderlying);
			ofNullable(getOtherBaseProduct()).ifPresent(builder::setOtherBaseProduct);
			ofNullable(getUnderlyingInstrumentIndexProp()).ifPresent(builder::setUnderlyingInstrumentIndexProp);
			ofNullable(getReferenceRateTermValue()).ifPresent(builder::setReferenceRateTermValue);
			ofNullable(getOtherLegUnderlierIDSource()).ifPresent(builder::setOtherLegUnderlierIDSource);
			ofNullable(getOtherAdditionalSubProduct()).ifPresent(builder::setOtherAdditionalSubProduct);
			ofNullable(getCategory()).ifPresent(builder::setCategory);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbAttributes _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(additionalSubProduct, _that.getAdditionalSubProduct())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermUnit, _that.getUnderlyingInstrumentIndexTermUnit())) return false;
			if (!Objects.equals(valuationMethodorTrigger, _that.getValuationMethodorTrigger())) return false;
			if (!Objects.equals(underlyingInstrumentISIN, _that.getUnderlyingInstrumentISIN())) return false;
			if (!Objects.equals(otherLegReferenceRateTermUnit, _that.getOtherLegReferenceRateTermUnit())) return false;
			if (!Objects.equals(notionalSchedule, _that.getNotionalSchedule())) return false;
			if (!Objects.equals(otherUnderlying, _that.getOtherUnderlying())) return false;
			if (!Objects.equals(underlyingIssuerType, _that.getUnderlyingIssuerType())) return false;
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(placeofSettlement, _that.getPlaceofSettlement())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermValue, _that.getUnderlyingInstrumentIndexTermValue())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(underlyingInstrumentIndex, _that.getUnderlyingInstrumentIndex())) return false;
			if (!Objects.equals(baseProduct, _that.getBaseProduct())) return false;
			if (!Objects.equals(underlyingInstrumentUPI, _that.getUnderlyingInstrumentUPI())) return false;
			if (!Objects.equals(otherLegUnderlierType, _that.getOtherLegUnderlierType())) return false;
			if (!Objects.equals(underlyingAssetClass, _that.getUnderlyingAssetClass())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(contractSpecification, _that.getContractSpecification())) return false;
			if (!Objects.equals(subProduct, _that.getSubProduct())) return false;
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			if (!Objects.equals(referenceRate, _that.getReferenceRate())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(otherUnderlierID, _that.getOtherUnderlierID())) return false;
			if (!Objects.equals(otherUnderlierIDSource, _that.getOtherUnderlierIDSource())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			if (!Objects.equals(otherReferenceRate, _that.getOtherReferenceRate())) return false;
			if (!Objects.equals(notionalCurrency, _that.getNotionalCurrency())) return false;
			if (!Objects.equals(otherLegUnderlying, _that.getOtherLegUnderlying())) return false;
			if (!Objects.equals(otherNotionalCurrency, _that.getOtherNotionalCurrency())) return false;
			if (!Objects.equals(referenceRateTermUnit, _that.getReferenceRateTermUnit())) return false;
			if (!Objects.equals(optionExerciseStyle, _that.getOptionExerciseStyle())) return false;
			if (!Objects.equals(underlyingAssetType, _that.getUnderlyingAssetType())) return false;
			if (!Objects.equals(otherLegReferenceRateTermValue, _that.getOtherLegReferenceRateTermValue())) return false;
			if (!Objects.equals(otherUnderlierCharacteristic, _that.getOtherUnderlierCharacteristic())) return false;
			if (!Objects.equals(otherLegUnderlierID, _that.getOtherLegUnderlierID())) return false;
			if (!Objects.equals(otherSubProduct, _that.getOtherSubProduct())) return false;
			if (!Objects.equals(otherLegReferenceRate, _that.getOtherLegReferenceRate())) return false;
			if (!Objects.equals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(otherBaseProduct, _that.getOtherBaseProduct())) return false;
			if (!Objects.equals(underlyingInstrumentIndexProp, _that.getUnderlyingInstrumentIndexProp())) return false;
			if (!Objects.equals(referenceRateTermValue, _that.getReferenceRateTermValue())) return false;
			if (!Objects.equals(otherLegUnderlierIDSource, _that.getOtherLegUnderlierIDSource())) return false;
			if (!Objects.equals(otherAdditionalSubProduct, _that.getOtherAdditionalSubProduct())) return false;
			if (!Objects.equals(category, _that.getCategory())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalSubProduct != null ? additionalSubProduct.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermUnit != null ? underlyingInstrumentIndexTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationMethodorTrigger != null ? valuationMethodorTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentISIN != null ? underlyingInstrumentISIN.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRateTermUnit != null ? otherLegReferenceRateTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (notionalSchedule != null ? notionalSchedule.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherUnderlying != null ? otherUnderlying.hashCode() : 0);
			_result = 31 * _result + (underlyingIssuerType != null ? underlyingIssuerType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (placeofSettlement != null ? placeofSettlement.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermValue != null ? underlyingInstrumentIndexTermValue.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndex != null ? underlyingInstrumentIndex.hashCode() : 0);
			_result = 31 * _result + (baseProduct != null ? baseProduct.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentUPI != null ? underlyingInstrumentUPI.hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierType != null ? otherLegUnderlierType.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetClass != null ? underlyingAssetClass.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (contractSpecification != null ? contractSpecification.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subProduct != null ? subProduct.hashCode() : 0);
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceRate != null ? referenceRate.hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherUnderlierID != null ? otherUnderlierID.hashCode() : 0);
			_result = 31 * _result + (otherUnderlierIDSource != null ? otherUnderlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			_result = 31 * _result + (otherReferenceRate != null ? otherReferenceRate.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency != null ? notionalCurrency.hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlying != null ? otherLegUnderlying.hashCode() : 0);
			_result = 31 * _result + (otherNotionalCurrency != null ? otherNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermUnit != null ? referenceRateTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionExerciseStyle != null ? optionExerciseStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingAssetType != null ? underlyingAssetType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRateTermValue != null ? otherLegReferenceRateTermValue.hashCode() : 0);
			_result = 31 * _result + (otherUnderlierCharacteristic != null ? otherUnderlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierID != null ? otherLegUnderlierID.hashCode() : 0);
			_result = 31 * _result + (otherSubProduct != null ? otherSubProduct.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRate != null ? otherLegReferenceRate.hashCode() : 0);
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (otherBaseProduct != null ? otherBaseProduct.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexProp != null ? underlyingInstrumentIndexProp.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermValue != null ? referenceRateTermValue.hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierIDSource != null ? otherLegUnderlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherAdditionalSubProduct != null ? otherAdditionalSubProduct.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbAttributes {" +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"AdditionalSubProduct=" + this.additionalSubProduct + ", " +
				"UnderlyingInstrumentIndexTermUnit=" + this.underlyingInstrumentIndexTermUnit + ", " +
				"ValuationMethodorTrigger=" + this.valuationMethodorTrigger + ", " +
				"UnderlyingInstrumentISIN=" + this.underlyingInstrumentISIN + ", " +
				"OtherLegReferenceRateTermUnit=" + this.otherLegReferenceRateTermUnit + ", " +
				"NotionalSchedule=" + this.notionalSchedule + ", " +
				"OtherUnderlying=" + this.otherUnderlying + ", " +
				"UnderlyingIssuerType=" + this.underlyingIssuerType + ", " +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"PlaceofSettlement=" + this.placeofSettlement + ", " +
				"UnderlyingInstrumentIndexTermValue=" + this.underlyingInstrumentIndexTermValue + ", " +
				"SettlementCurrency=" + this.settlementCurrency + ", " +
				"UnderlyingInstrumentIndex=" + this.underlyingInstrumentIndex + ", " +
				"BaseProduct=" + this.baseProduct + ", " +
				"UnderlyingInstrumentUPI=" + this.underlyingInstrumentUPI + ", " +
				"OtherLegUnderlierType=" + this.otherLegUnderlierType + ", " +
				"UnderlyingAssetClass=" + this.underlyingAssetClass + ", " +
				"OptionType=" + this.optionType + ", " +
				"DeliveryType=" + this.deliveryType + ", " +
				"ContractSpecification=" + this.contractSpecification + ", " +
				"SubProduct=" + this.subProduct + ", " +
				"DebtSeniority=" + this.debtSeniority + ", " +
				"ReferenceRate=" + this.referenceRate + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"OtherUnderlierID=" + this.otherUnderlierID + ", " +
				"OtherUnderlierIDSource=" + this.otherUnderlierIDSource + ", " +
				"UnderlierID=" + this.underlierID + ", " +
				"OtherReferenceRate=" + this.otherReferenceRate + ", " +
				"NotionalCurrency=" + this.notionalCurrency + ", " +
				"OtherLegUnderlying=" + this.otherLegUnderlying + ", " +
				"OtherNotionalCurrency=" + this.otherNotionalCurrency + ", " +
				"ReferenceRateTermUnit=" + this.referenceRateTermUnit + ", " +
				"OptionExerciseStyle=" + this.optionExerciseStyle + ", " +
				"UnderlyingAssetType=" + this.underlyingAssetType + ", " +
				"OtherLegReferenceRateTermValue=" + this.otherLegReferenceRateTermValue + ", " +
				"OtherUnderlierCharacteristic=" + this.otherUnderlierCharacteristic + ", " +
				"OtherLegUnderlierID=" + this.otherLegUnderlierID + ", " +
				"OtherSubProduct=" + this.otherSubProduct + ", " +
				"OtherLegReferenceRate=" + this.otherLegReferenceRate + ", " +
				"Underlying=" + this.underlying + ", " +
				"OtherBaseProduct=" + this.otherBaseProduct + ", " +
				"UnderlyingInstrumentIndexProp=" + this.underlyingInstrumentIndexProp + ", " +
				"ReferenceRateTermValue=" + this.referenceRateTermValue + ", " +
				"OtherLegUnderlierIDSource=" + this.otherLegUnderlierIDSource + ", " +
				"OtherAdditionalSubProduct=" + this.otherAdditionalSubProduct + ", " +
				"Category=" + this.category +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbAttributes  ***********************/
	class AnnaDsbAttributesBuilderImpl implements AnnaDsbAttributes.AnnaDsbAttributesBuilder {
	
		protected AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		protected String additionalSubProduct;
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum underlyingInstrumentIndexTermUnit;
		protected AnnaDsbValuationMethodorTriggerEnum valuationMethodorTrigger;
		protected String underlyingInstrumentISIN;
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum otherLegReferenceRateTermUnit;
		protected AnnaDsbNotionalScheduleEnum notionalSchedule;
		protected AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder otherUnderlying;
		protected AnnaDsbUnderlyingIssuerTypeEnum underlyingIssuerType;
		protected AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		protected AnnaDsbPlaceofSettlementEnum placeofSettlement;
		protected Integer underlyingInstrumentIndexTermValue;
		protected String settlementCurrency;
		protected String underlyingInstrumentIndex;
		protected AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder baseProduct;
		protected String underlyingInstrumentUPI;
		protected AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder otherLegUnderlierType;
		protected AnnaDsbUnderlyingAssetClass.AnnaDsbUnderlyingAssetClassBuilder underlyingAssetClass;
		protected AnnaDsbOptionTypeEnum optionType;
		protected AnnaDsbDeliveryTypeEnum deliveryType;
		protected AnnaDsbContractSpecificationEnum contractSpecification;
		protected String subProduct;
		protected AnnaDsbDebtSeniorityEnum debtSeniority;
		protected String referenceRate;
		protected AnnaDsbUnderlierCharacteristicEnum underlierCharacteristic;
		protected String otherUnderlierID;
		protected AnnaDsbOtherUnderlierIDSourceEnum otherUnderlierIDSource;
		protected String underlierID;
		protected String otherReferenceRate;
		protected String notionalCurrency;
		protected AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder otherLegUnderlying;
		protected String otherNotionalCurrency;
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum referenceRateTermUnit;
		protected AnnaDsbOptionExerciseStyleEnum optionExerciseStyle;
		protected AnnaDsbUnderlyingAssetTypeEnum underlyingAssetType;
		protected Integer otherLegReferenceRateTermValue;
		protected AnnaDsbUnderlierCharacteristicEnum otherUnderlierCharacteristic;
		protected String otherLegUnderlierID;
		protected String otherSubProduct;
		protected String otherLegReferenceRate;
		protected AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder underlying;
		protected AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder otherBaseProduct;
		protected String underlyingInstrumentIndexProp;
		protected Integer referenceRateTermValue;
		protected AnnaDsbOtherLegUnderlierIDSourceEnum otherLegUnderlierIDSource;
		protected String otherAdditionalSubProduct;
		protected AnnaDsbCategory.AnnaDsbCategoryBuilder category;
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("AdditionalSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("AdditionalSubProduct")
		public String getAdditionalSubProduct() {
			return additionalSubProduct;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getUnderlyingInstrumentIndexTermUnit() {
			return underlyingInstrumentIndexTermUnit;
		}
		
		@Override
		@RosettaAttribute("ValuationMethodorTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ValuationMethodorTrigger")
		public AnnaDsbValuationMethodorTriggerEnum getValuationMethodorTrigger() {
			return valuationMethodorTrigger;
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
		@RosettaAttribute("NotionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NotionalSchedule")
		public AnnaDsbNotionalScheduleEnum getNotionalSchedule() {
			return notionalSchedule;
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
		@RosettaAttribute("UnderlyingIssuerType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingIssuerType")
		public AnnaDsbUnderlyingIssuerTypeEnum getUnderlyingIssuerType() {
			return underlyingIssuerType;
		}
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("PlaceofSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("PlaceofSettlement")
		public AnnaDsbPlaceofSettlementEnum getPlaceofSettlement() {
			return placeofSettlement;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermValue")
		public Integer getUnderlyingInstrumentIndexTermValue() {
			return underlyingInstrumentIndexTermValue;
		}
		
		@Override
		@RosettaAttribute("SettlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SettlementCurrency")
		public String getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		public String getUnderlyingInstrumentIndex() {
			return underlyingInstrumentIndex;
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
		@RosettaAttribute("UnderlyingInstrumentUPI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentUPI")
		public String getUnderlyingInstrumentUPI() {
			return underlyingInstrumentUPI;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierType")
		public AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder getOtherLegUnderlierType() {
			return otherLegUnderlierType;
		}
		
		@Override
		public AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder getOrCreateOtherLegUnderlierType() {
			AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder result;
			if (otherLegUnderlierType!=null) {
				result = otherLegUnderlierType;
			}
			else {
				result = otherLegUnderlierType = AnnaDsbOtherLegUnderlierType.builder();
			}
			
			return result;
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
		@RosettaAttribute("OptionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OptionType")
		public AnnaDsbOptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("DeliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DeliveryType")
		public AnnaDsbDeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("ContractSpecification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ContractSpecification")
		public AnnaDsbContractSpecificationEnum getContractSpecification() {
			return contractSpecification;
		}
		
		@Override
		@RosettaAttribute("SubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SubProduct")
		public String getSubProduct() {
			return subProduct;
		}
		
		@Override
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DebtSeniority")
		public AnnaDsbDebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
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
		public AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierID")
		public String getOtherUnderlierID() {
			return otherUnderlierID;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierIDSource")
		public AnnaDsbOtherUnderlierIDSourceEnum getOtherUnderlierIDSource() {
			return otherUnderlierIDSource;
		}
		
		@Override
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierID")
		public String getUnderlierID() {
			return underlierID;
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
		@RosettaAttribute("OtherLegReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegReferenceRateTermValue")
		public Integer getOtherLegReferenceRateTermValue() {
			return otherLegReferenceRateTermValue;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getOtherUnderlierCharacteristic() {
			return otherUnderlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierID")
		public String getOtherLegUnderlierID() {
			return otherLegUnderlierID;
		}
		
		@Override
		@RosettaAttribute("OtherSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherSubProduct")
		public String getOtherSubProduct() {
			return otherSubProduct;
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
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		public String getUnderlyingInstrumentIndexProp() {
			return underlyingInstrumentIndexProp;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermValue")
		public Integer getReferenceRateTermValue() {
			return referenceRateTermValue;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherLegUnderlierIDSource")
		public AnnaDsbOtherLegUnderlierIDSourceEnum getOtherLegUnderlierIDSource() {
			return otherLegUnderlierIDSource;
		}
		
		@Override
		@RosettaAttribute("OtherAdditionalSubProduct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherAdditionalSubProduct")
		public String getOtherAdditionalSubProduct() {
			return otherAdditionalSubProduct;
		}
		
		@Override
		@RosettaAttribute("Category")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Category")
		public AnnaDsbCategory.AnnaDsbCategoryBuilder getCategory() {
			return category;
		}
		
		@Override
		public AnnaDsbCategory.AnnaDsbCategoryBuilder getOrCreateCategory() {
			AnnaDsbCategory.AnnaDsbCategoryBuilder result;
			if (category!=null) {
				result = category;
			}
			else {
				result = category = AnnaDsbCategory.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum _returnorPayoutTrigger) {
			this.returnorPayoutTrigger = _returnorPayoutTrigger == null ? null : _returnorPayoutTrigger;
			return this;
		}
		
		@RosettaAttribute("AdditionalSubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("AdditionalSubProduct")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setAdditionalSubProduct(String _additionalSubProduct) {
			this.additionalSubProduct = _additionalSubProduct == null ? null : _additionalSubProduct;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexTermUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermUnit")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum _underlyingInstrumentIndexTermUnit) {
			this.underlyingInstrumentIndexTermUnit = _underlyingInstrumentIndexTermUnit == null ? null : _underlyingInstrumentIndexTermUnit;
			return this;
		}
		
		@RosettaAttribute("ValuationMethodorTrigger")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ValuationMethodorTrigger")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setValuationMethodorTrigger(AnnaDsbValuationMethodorTriggerEnum _valuationMethodorTrigger) {
			this.valuationMethodorTrigger = _valuationMethodorTrigger == null ? null : _valuationMethodorTrigger;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentISIN")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentISIN")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingInstrumentISIN(String _underlyingInstrumentISIN) {
			this.underlyingInstrumentISIN = _underlyingInstrumentISIN == null ? null : _underlyingInstrumentISIN;
			return this;
		}
		
		@RosettaAttribute("OtherLegReferenceRateTermUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegReferenceRateTermUnit")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum _otherLegReferenceRateTermUnit) {
			this.otherLegReferenceRateTermUnit = _otherLegReferenceRateTermUnit == null ? null : _otherLegReferenceRateTermUnit;
			return this;
		}
		
		@RosettaAttribute("NotionalSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("NotionalSchedule")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setNotionalSchedule(AnnaDsbNotionalScheduleEnum _notionalSchedule) {
			this.notionalSchedule = _notionalSchedule == null ? null : _notionalSchedule;
			return this;
		}
		
		@RosettaAttribute("OtherUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherUnderlying")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherUnderlying(AnnaDsbOtherUnderlying _otherUnderlying) {
			this.otherUnderlying = _otherUnderlying == null ? null : _otherUnderlying.toBuilder();
			return this;
		}
		
		@RosettaAttribute("UnderlyingIssuerType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingIssuerType")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingIssuerType(AnnaDsbUnderlyingIssuerTypeEnum _underlyingIssuerType) {
			this.underlyingIssuerType = _underlyingIssuerType == null ? null : _underlyingIssuerType;
			return this;
		}
		
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierIDSource")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum _underlierIDSource) {
			this.underlierIDSource = _underlierIDSource == null ? null : _underlierIDSource;
			return this;
		}
		
		@RosettaAttribute("PlaceofSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("PlaceofSettlement")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setPlaceofSettlement(AnnaDsbPlaceofSettlementEnum _placeofSettlement) {
			this.placeofSettlement = _placeofSettlement == null ? null : _placeofSettlement;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexTermValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermValue")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingInstrumentIndexTermValue(Integer _underlyingInstrumentIndexTermValue) {
			this.underlyingInstrumentIndexTermValue = _underlyingInstrumentIndexTermValue == null ? null : _underlyingInstrumentIndexTermValue;
			return this;
		}
		
		@RosettaAttribute("SettlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("SettlementCurrency")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setSettlementCurrency(String _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingInstrumentIndex(String _underlyingInstrumentIndex) {
			this.underlyingInstrumentIndex = _underlyingInstrumentIndex == null ? null : _underlyingInstrumentIndex;
			return this;
		}
		
		@RosettaAttribute("BaseProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("BaseProduct")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setBaseProduct(AnnaDsbBaseProduct _baseProduct) {
			this.baseProduct = _baseProduct == null ? null : _baseProduct.toBuilder();
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentUPI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentUPI")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingInstrumentUPI(String _underlyingInstrumentUPI) {
			this.underlyingInstrumentUPI = _underlyingInstrumentUPI == null ? null : _underlyingInstrumentUPI;
			return this;
		}
		
		@RosettaAttribute("OtherLegUnderlierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegUnderlierType")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegUnderlierType(AnnaDsbOtherLegUnderlierType _otherLegUnderlierType) {
			this.otherLegUnderlierType = _otherLegUnderlierType == null ? null : _otherLegUnderlierType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("UnderlyingAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingAssetClass")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingAssetClass(AnnaDsbUnderlyingAssetClass _underlyingAssetClass) {
			this.underlyingAssetClass = _underlyingAssetClass == null ? null : _underlyingAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("OptionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OptionType")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOptionType(AnnaDsbOptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("DeliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("DeliveryType")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setDeliveryType(AnnaDsbDeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("ContractSpecification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ContractSpecification")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setContractSpecification(AnnaDsbContractSpecificationEnum _contractSpecification) {
			this.contractSpecification = _contractSpecification == null ? null : _contractSpecification;
			return this;
		}
		
		@RosettaAttribute("SubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("SubProduct")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setSubProduct(String _subProduct) {
			this.subProduct = _subProduct == null ? null : _subProduct;
			return this;
		}
		
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("DebtSeniority")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setDebtSeniority(AnnaDsbDebtSeniorityEnum _debtSeniority) {
			this.debtSeniority = _debtSeniority == null ? null : _debtSeniority;
			return this;
		}
		
		@RosettaAttribute("ReferenceRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReferenceRate")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setReferenceRate(String _referenceRate) {
			this.referenceRate = _referenceRate == null ? null : _referenceRate;
			return this;
		}
		
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierCharacteristic")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum _underlierCharacteristic) {
			this.underlierCharacteristic = _underlierCharacteristic == null ? null : _underlierCharacteristic;
			return this;
		}
		
		@RosettaAttribute("OtherUnderlierID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherUnderlierID")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherUnderlierID(String _otherUnderlierID) {
			this.otherUnderlierID = _otherUnderlierID == null ? null : _otherUnderlierID;
			return this;
		}
		
		@RosettaAttribute("OtherUnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherUnderlierIDSource")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherUnderlierIDSource(AnnaDsbOtherUnderlierIDSourceEnum _otherUnderlierIDSource) {
			this.otherUnderlierIDSource = _otherUnderlierIDSource == null ? null : _otherUnderlierIDSource;
			return this;
		}
		
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierID")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlierID(String _underlierID) {
			this.underlierID = _underlierID == null ? null : _underlierID;
			return this;
		}
		
		@RosettaAttribute("OtherReferenceRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherReferenceRate")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherReferenceRate(String _otherReferenceRate) {
			this.otherReferenceRate = _otherReferenceRate == null ? null : _otherReferenceRate;
			return this;
		}
		
		@RosettaAttribute("NotionalCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("NotionalCurrency")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setNotionalCurrency(String _notionalCurrency) {
			this.notionalCurrency = _notionalCurrency == null ? null : _notionalCurrency;
			return this;
		}
		
		@RosettaAttribute("OtherLegUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegUnderlying")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegUnderlying(AnnaDsbOtherLegUnderlying _otherLegUnderlying) {
			this.otherLegUnderlying = _otherLegUnderlying == null ? null : _otherLegUnderlying.toBuilder();
			return this;
		}
		
		@RosettaAttribute("OtherNotionalCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherNotionalCurrency")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherNotionalCurrency(String _otherNotionalCurrency) {
			this.otherNotionalCurrency = _otherNotionalCurrency == null ? null : _otherNotionalCurrency;
			return this;
		}
		
		@RosettaAttribute("ReferenceRateTermUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReferenceRateTermUnit")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum _referenceRateTermUnit) {
			this.referenceRateTermUnit = _referenceRateTermUnit == null ? null : _referenceRateTermUnit;
			return this;
		}
		
		@RosettaAttribute("OptionExerciseStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OptionExerciseStyle")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOptionExerciseStyle(AnnaDsbOptionExerciseStyleEnum _optionExerciseStyle) {
			this.optionExerciseStyle = _optionExerciseStyle == null ? null : _optionExerciseStyle;
			return this;
		}
		
		@RosettaAttribute("UnderlyingAssetType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingAssetType")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingAssetType(AnnaDsbUnderlyingAssetTypeEnum _underlyingAssetType) {
			this.underlyingAssetType = _underlyingAssetType == null ? null : _underlyingAssetType;
			return this;
		}
		
		@RosettaAttribute("OtherLegReferenceRateTermValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegReferenceRateTermValue")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegReferenceRateTermValue(Integer _otherLegReferenceRateTermValue) {
			this.otherLegReferenceRateTermValue = _otherLegReferenceRateTermValue == null ? null : _otherLegReferenceRateTermValue;
			return this;
		}
		
		@RosettaAttribute("OtherUnderlierCharacteristic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherUnderlierCharacteristic")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum _otherUnderlierCharacteristic) {
			this.otherUnderlierCharacteristic = _otherUnderlierCharacteristic == null ? null : _otherUnderlierCharacteristic;
			return this;
		}
		
		@RosettaAttribute("OtherLegUnderlierID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegUnderlierID")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegUnderlierID(String _otherLegUnderlierID) {
			this.otherLegUnderlierID = _otherLegUnderlierID == null ? null : _otherLegUnderlierID;
			return this;
		}
		
		@RosettaAttribute("OtherSubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherSubProduct")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherSubProduct(String _otherSubProduct) {
			this.otherSubProduct = _otherSubProduct == null ? null : _otherSubProduct;
			return this;
		}
		
		@RosettaAttribute("OtherLegReferenceRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegReferenceRate")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegReferenceRate(String _otherLegReferenceRate) {
			this.otherLegReferenceRate = _otherLegReferenceRate == null ? null : _otherLegReferenceRate;
			return this;
		}
		
		@RosettaAttribute("Underlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Underlying")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlying(AnnaDsbUnderlying _underlying) {
			this.underlying = _underlying == null ? null : _underlying.toBuilder();
			return this;
		}
		
		@RosettaAttribute("OtherBaseProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherBaseProduct")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherBaseProduct(AnnaDsbBaseProduct _otherBaseProduct) {
			this.otherBaseProduct = _otherBaseProduct == null ? null : _otherBaseProduct.toBuilder();
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setUnderlyingInstrumentIndexProp(String _underlyingInstrumentIndexProp) {
			this.underlyingInstrumentIndexProp = _underlyingInstrumentIndexProp == null ? null : _underlyingInstrumentIndexProp;
			return this;
		}
		
		@RosettaAttribute("ReferenceRateTermValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReferenceRateTermValue")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setReferenceRateTermValue(Integer _referenceRateTermValue) {
			this.referenceRateTermValue = _referenceRateTermValue == null ? null : _referenceRateTermValue;
			return this;
		}
		
		@RosettaAttribute("OtherLegUnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherLegUnderlierIDSource")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherLegUnderlierIDSource(AnnaDsbOtherLegUnderlierIDSourceEnum _otherLegUnderlierIDSource) {
			this.otherLegUnderlierIDSource = _otherLegUnderlierIDSource == null ? null : _otherLegUnderlierIDSource;
			return this;
		}
		
		@RosettaAttribute("OtherAdditionalSubProduct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherAdditionalSubProduct")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setOtherAdditionalSubProduct(String _otherAdditionalSubProduct) {
			this.otherAdditionalSubProduct = _otherAdditionalSubProduct == null ? null : _otherAdditionalSubProduct;
			return this;
		}
		
		@RosettaAttribute("Category")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Category")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder setCategory(AnnaDsbCategory _category) {
			this.category = _category == null ? null : _category.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbAttributes build() {
			return new AnnaDsbAttributes.AnnaDsbAttributesImpl(this);
		}
		
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder prune() {
			if (otherUnderlying!=null && !otherUnderlying.prune().hasData()) otherUnderlying = null;
			if (baseProduct!=null && !baseProduct.prune().hasData()) baseProduct = null;
			if (otherLegUnderlierType!=null && !otherLegUnderlierType.prune().hasData()) otherLegUnderlierType = null;
			if (underlyingAssetClass!=null && !underlyingAssetClass.prune().hasData()) underlyingAssetClass = null;
			if (otherLegUnderlying!=null && !otherLegUnderlying.prune().hasData()) otherLegUnderlying = null;
			if (underlying!=null && !underlying.prune().hasData()) underlying = null;
			if (otherBaseProduct!=null && !otherBaseProduct.prune().hasData()) otherBaseProduct = null;
			if (category!=null && !category.prune().hasData()) category = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReturnorPayoutTrigger()!=null) return true;
			if (getAdditionalSubProduct()!=null) return true;
			if (getUnderlyingInstrumentIndexTermUnit()!=null) return true;
			if (getValuationMethodorTrigger()!=null) return true;
			if (getUnderlyingInstrumentISIN()!=null) return true;
			if (getOtherLegReferenceRateTermUnit()!=null) return true;
			if (getNotionalSchedule()!=null) return true;
			if (getOtherUnderlying()!=null && getOtherUnderlying().hasData()) return true;
			if (getUnderlyingIssuerType()!=null) return true;
			if (getUnderlierIDSource()!=null) return true;
			if (getPlaceofSettlement()!=null) return true;
			if (getUnderlyingInstrumentIndexTermValue()!=null) return true;
			if (getSettlementCurrency()!=null) return true;
			if (getUnderlyingInstrumentIndex()!=null) return true;
			if (getBaseProduct()!=null && getBaseProduct().hasData()) return true;
			if (getUnderlyingInstrumentUPI()!=null) return true;
			if (getOtherLegUnderlierType()!=null && getOtherLegUnderlierType().hasData()) return true;
			if (getUnderlyingAssetClass()!=null && getUnderlyingAssetClass().hasData()) return true;
			if (getOptionType()!=null) return true;
			if (getDeliveryType()!=null) return true;
			if (getContractSpecification()!=null) return true;
			if (getSubProduct()!=null) return true;
			if (getDebtSeniority()!=null) return true;
			if (getReferenceRate()!=null) return true;
			if (getUnderlierCharacteristic()!=null) return true;
			if (getOtherUnderlierID()!=null) return true;
			if (getOtherUnderlierIDSource()!=null) return true;
			if (getUnderlierID()!=null) return true;
			if (getOtherReferenceRate()!=null) return true;
			if (getNotionalCurrency()!=null) return true;
			if (getOtherLegUnderlying()!=null && getOtherLegUnderlying().hasData()) return true;
			if (getOtherNotionalCurrency()!=null) return true;
			if (getReferenceRateTermUnit()!=null) return true;
			if (getOptionExerciseStyle()!=null) return true;
			if (getUnderlyingAssetType()!=null) return true;
			if (getOtherLegReferenceRateTermValue()!=null) return true;
			if (getOtherUnderlierCharacteristic()!=null) return true;
			if (getOtherLegUnderlierID()!=null) return true;
			if (getOtherSubProduct()!=null) return true;
			if (getOtherLegReferenceRate()!=null) return true;
			if (getUnderlying()!=null && getUnderlying().hasData()) return true;
			if (getOtherBaseProduct()!=null && getOtherBaseProduct().hasData()) return true;
			if (getUnderlyingInstrumentIndexProp()!=null) return true;
			if (getReferenceRateTermValue()!=null) return true;
			if (getOtherLegUnderlierIDSource()!=null) return true;
			if (getOtherAdditionalSubProduct()!=null) return true;
			if (getCategory()!=null && getCategory().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbAttributes.AnnaDsbAttributesBuilder o = (AnnaDsbAttributes.AnnaDsbAttributesBuilder) other;
			
			merger.mergeRosetta(getOtherUnderlying(), o.getOtherUnderlying(), this::setOtherUnderlying);
			merger.mergeRosetta(getBaseProduct(), o.getBaseProduct(), this::setBaseProduct);
			merger.mergeRosetta(getOtherLegUnderlierType(), o.getOtherLegUnderlierType(), this::setOtherLegUnderlierType);
			merger.mergeRosetta(getUnderlyingAssetClass(), o.getUnderlyingAssetClass(), this::setUnderlyingAssetClass);
			merger.mergeRosetta(getOtherLegUnderlying(), o.getOtherLegUnderlying(), this::setOtherLegUnderlying);
			merger.mergeRosetta(getUnderlying(), o.getUnderlying(), this::setUnderlying);
			merger.mergeRosetta(getOtherBaseProduct(), o.getOtherBaseProduct(), this::setOtherBaseProduct);
			merger.mergeRosetta(getCategory(), o.getCategory(), this::setCategory);
			
			merger.mergeBasic(getReturnorPayoutTrigger(), o.getReturnorPayoutTrigger(), this::setReturnorPayoutTrigger);
			merger.mergeBasic(getAdditionalSubProduct(), o.getAdditionalSubProduct(), this::setAdditionalSubProduct);
			merger.mergeBasic(getUnderlyingInstrumentIndexTermUnit(), o.getUnderlyingInstrumentIndexTermUnit(), this::setUnderlyingInstrumentIndexTermUnit);
			merger.mergeBasic(getValuationMethodorTrigger(), o.getValuationMethodorTrigger(), this::setValuationMethodorTrigger);
			merger.mergeBasic(getUnderlyingInstrumentISIN(), o.getUnderlyingInstrumentISIN(), this::setUnderlyingInstrumentISIN);
			merger.mergeBasic(getOtherLegReferenceRateTermUnit(), o.getOtherLegReferenceRateTermUnit(), this::setOtherLegReferenceRateTermUnit);
			merger.mergeBasic(getNotionalSchedule(), o.getNotionalSchedule(), this::setNotionalSchedule);
			merger.mergeBasic(getUnderlyingIssuerType(), o.getUnderlyingIssuerType(), this::setUnderlyingIssuerType);
			merger.mergeBasic(getUnderlierIDSource(), o.getUnderlierIDSource(), this::setUnderlierIDSource);
			merger.mergeBasic(getPlaceofSettlement(), o.getPlaceofSettlement(), this::setPlaceofSettlement);
			merger.mergeBasic(getUnderlyingInstrumentIndexTermValue(), o.getUnderlyingInstrumentIndexTermValue(), this::setUnderlyingInstrumentIndexTermValue);
			merger.mergeBasic(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeBasic(getUnderlyingInstrumentIndex(), o.getUnderlyingInstrumentIndex(), this::setUnderlyingInstrumentIndex);
			merger.mergeBasic(getUnderlyingInstrumentUPI(), o.getUnderlyingInstrumentUPI(), this::setUnderlyingInstrumentUPI);
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getDeliveryType(), o.getDeliveryType(), this::setDeliveryType);
			merger.mergeBasic(getContractSpecification(), o.getContractSpecification(), this::setContractSpecification);
			merger.mergeBasic(getSubProduct(), o.getSubProduct(), this::setSubProduct);
			merger.mergeBasic(getDebtSeniority(), o.getDebtSeniority(), this::setDebtSeniority);
			merger.mergeBasic(getReferenceRate(), o.getReferenceRate(), this::setReferenceRate);
			merger.mergeBasic(getUnderlierCharacteristic(), o.getUnderlierCharacteristic(), this::setUnderlierCharacteristic);
			merger.mergeBasic(getOtherUnderlierID(), o.getOtherUnderlierID(), this::setOtherUnderlierID);
			merger.mergeBasic(getOtherUnderlierIDSource(), o.getOtherUnderlierIDSource(), this::setOtherUnderlierIDSource);
			merger.mergeBasic(getUnderlierID(), o.getUnderlierID(), this::setUnderlierID);
			merger.mergeBasic(getOtherReferenceRate(), o.getOtherReferenceRate(), this::setOtherReferenceRate);
			merger.mergeBasic(getNotionalCurrency(), o.getNotionalCurrency(), this::setNotionalCurrency);
			merger.mergeBasic(getOtherNotionalCurrency(), o.getOtherNotionalCurrency(), this::setOtherNotionalCurrency);
			merger.mergeBasic(getReferenceRateTermUnit(), o.getReferenceRateTermUnit(), this::setReferenceRateTermUnit);
			merger.mergeBasic(getOptionExerciseStyle(), o.getOptionExerciseStyle(), this::setOptionExerciseStyle);
			merger.mergeBasic(getUnderlyingAssetType(), o.getUnderlyingAssetType(), this::setUnderlyingAssetType);
			merger.mergeBasic(getOtherLegReferenceRateTermValue(), o.getOtherLegReferenceRateTermValue(), this::setOtherLegReferenceRateTermValue);
			merger.mergeBasic(getOtherUnderlierCharacteristic(), o.getOtherUnderlierCharacteristic(), this::setOtherUnderlierCharacteristic);
			merger.mergeBasic(getOtherLegUnderlierID(), o.getOtherLegUnderlierID(), this::setOtherLegUnderlierID);
			merger.mergeBasic(getOtherSubProduct(), o.getOtherSubProduct(), this::setOtherSubProduct);
			merger.mergeBasic(getOtherLegReferenceRate(), o.getOtherLegReferenceRate(), this::setOtherLegReferenceRate);
			merger.mergeBasic(getUnderlyingInstrumentIndexProp(), o.getUnderlyingInstrumentIndexProp(), this::setUnderlyingInstrumentIndexProp);
			merger.mergeBasic(getReferenceRateTermValue(), o.getReferenceRateTermValue(), this::setReferenceRateTermValue);
			merger.mergeBasic(getOtherLegUnderlierIDSource(), o.getOtherLegUnderlierIDSource(), this::setOtherLegUnderlierIDSource);
			merger.mergeBasic(getOtherAdditionalSubProduct(), o.getOtherAdditionalSubProduct(), this::setOtherAdditionalSubProduct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbAttributes _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(additionalSubProduct, _that.getAdditionalSubProduct())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermUnit, _that.getUnderlyingInstrumentIndexTermUnit())) return false;
			if (!Objects.equals(valuationMethodorTrigger, _that.getValuationMethodorTrigger())) return false;
			if (!Objects.equals(underlyingInstrumentISIN, _that.getUnderlyingInstrumentISIN())) return false;
			if (!Objects.equals(otherLegReferenceRateTermUnit, _that.getOtherLegReferenceRateTermUnit())) return false;
			if (!Objects.equals(notionalSchedule, _that.getNotionalSchedule())) return false;
			if (!Objects.equals(otherUnderlying, _that.getOtherUnderlying())) return false;
			if (!Objects.equals(underlyingIssuerType, _that.getUnderlyingIssuerType())) return false;
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(placeofSettlement, _that.getPlaceofSettlement())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermValue, _that.getUnderlyingInstrumentIndexTermValue())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(underlyingInstrumentIndex, _that.getUnderlyingInstrumentIndex())) return false;
			if (!Objects.equals(baseProduct, _that.getBaseProduct())) return false;
			if (!Objects.equals(underlyingInstrumentUPI, _that.getUnderlyingInstrumentUPI())) return false;
			if (!Objects.equals(otherLegUnderlierType, _that.getOtherLegUnderlierType())) return false;
			if (!Objects.equals(underlyingAssetClass, _that.getUnderlyingAssetClass())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(contractSpecification, _that.getContractSpecification())) return false;
			if (!Objects.equals(subProduct, _that.getSubProduct())) return false;
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			if (!Objects.equals(referenceRate, _that.getReferenceRate())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(otherUnderlierID, _that.getOtherUnderlierID())) return false;
			if (!Objects.equals(otherUnderlierIDSource, _that.getOtherUnderlierIDSource())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			if (!Objects.equals(otherReferenceRate, _that.getOtherReferenceRate())) return false;
			if (!Objects.equals(notionalCurrency, _that.getNotionalCurrency())) return false;
			if (!Objects.equals(otherLegUnderlying, _that.getOtherLegUnderlying())) return false;
			if (!Objects.equals(otherNotionalCurrency, _that.getOtherNotionalCurrency())) return false;
			if (!Objects.equals(referenceRateTermUnit, _that.getReferenceRateTermUnit())) return false;
			if (!Objects.equals(optionExerciseStyle, _that.getOptionExerciseStyle())) return false;
			if (!Objects.equals(underlyingAssetType, _that.getUnderlyingAssetType())) return false;
			if (!Objects.equals(otherLegReferenceRateTermValue, _that.getOtherLegReferenceRateTermValue())) return false;
			if (!Objects.equals(otherUnderlierCharacteristic, _that.getOtherUnderlierCharacteristic())) return false;
			if (!Objects.equals(otherLegUnderlierID, _that.getOtherLegUnderlierID())) return false;
			if (!Objects.equals(otherSubProduct, _that.getOtherSubProduct())) return false;
			if (!Objects.equals(otherLegReferenceRate, _that.getOtherLegReferenceRate())) return false;
			if (!Objects.equals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(otherBaseProduct, _that.getOtherBaseProduct())) return false;
			if (!Objects.equals(underlyingInstrumentIndexProp, _that.getUnderlyingInstrumentIndexProp())) return false;
			if (!Objects.equals(referenceRateTermValue, _that.getReferenceRateTermValue())) return false;
			if (!Objects.equals(otherLegUnderlierIDSource, _that.getOtherLegUnderlierIDSource())) return false;
			if (!Objects.equals(otherAdditionalSubProduct, _that.getOtherAdditionalSubProduct())) return false;
			if (!Objects.equals(category, _that.getCategory())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalSubProduct != null ? additionalSubProduct.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermUnit != null ? underlyingInstrumentIndexTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationMethodorTrigger != null ? valuationMethodorTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentISIN != null ? underlyingInstrumentISIN.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRateTermUnit != null ? otherLegReferenceRateTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (notionalSchedule != null ? notionalSchedule.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherUnderlying != null ? otherUnderlying.hashCode() : 0);
			_result = 31 * _result + (underlyingIssuerType != null ? underlyingIssuerType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (placeofSettlement != null ? placeofSettlement.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermValue != null ? underlyingInstrumentIndexTermValue.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndex != null ? underlyingInstrumentIndex.hashCode() : 0);
			_result = 31 * _result + (baseProduct != null ? baseProduct.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentUPI != null ? underlyingInstrumentUPI.hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierType != null ? otherLegUnderlierType.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetClass != null ? underlyingAssetClass.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (contractSpecification != null ? contractSpecification.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subProduct != null ? subProduct.hashCode() : 0);
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceRate != null ? referenceRate.hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherUnderlierID != null ? otherUnderlierID.hashCode() : 0);
			_result = 31 * _result + (otherUnderlierIDSource != null ? otherUnderlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			_result = 31 * _result + (otherReferenceRate != null ? otherReferenceRate.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency != null ? notionalCurrency.hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlying != null ? otherLegUnderlying.hashCode() : 0);
			_result = 31 * _result + (otherNotionalCurrency != null ? otherNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermUnit != null ? referenceRateTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionExerciseStyle != null ? optionExerciseStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingAssetType != null ? underlyingAssetType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRateTermValue != null ? otherLegReferenceRateTermValue.hashCode() : 0);
			_result = 31 * _result + (otherUnderlierCharacteristic != null ? otherUnderlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierID != null ? otherLegUnderlierID.hashCode() : 0);
			_result = 31 * _result + (otherSubProduct != null ? otherSubProduct.hashCode() : 0);
			_result = 31 * _result + (otherLegReferenceRate != null ? otherLegReferenceRate.hashCode() : 0);
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (otherBaseProduct != null ? otherBaseProduct.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexProp != null ? underlyingInstrumentIndexProp.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermValue != null ? referenceRateTermValue.hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierIDSource != null ? otherLegUnderlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherAdditionalSubProduct != null ? otherAdditionalSubProduct.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbAttributesBuilder {" +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"AdditionalSubProduct=" + this.additionalSubProduct + ", " +
				"UnderlyingInstrumentIndexTermUnit=" + this.underlyingInstrumentIndexTermUnit + ", " +
				"ValuationMethodorTrigger=" + this.valuationMethodorTrigger + ", " +
				"UnderlyingInstrumentISIN=" + this.underlyingInstrumentISIN + ", " +
				"OtherLegReferenceRateTermUnit=" + this.otherLegReferenceRateTermUnit + ", " +
				"NotionalSchedule=" + this.notionalSchedule + ", " +
				"OtherUnderlying=" + this.otherUnderlying + ", " +
				"UnderlyingIssuerType=" + this.underlyingIssuerType + ", " +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"PlaceofSettlement=" + this.placeofSettlement + ", " +
				"UnderlyingInstrumentIndexTermValue=" + this.underlyingInstrumentIndexTermValue + ", " +
				"SettlementCurrency=" + this.settlementCurrency + ", " +
				"UnderlyingInstrumentIndex=" + this.underlyingInstrumentIndex + ", " +
				"BaseProduct=" + this.baseProduct + ", " +
				"UnderlyingInstrumentUPI=" + this.underlyingInstrumentUPI + ", " +
				"OtherLegUnderlierType=" + this.otherLegUnderlierType + ", " +
				"UnderlyingAssetClass=" + this.underlyingAssetClass + ", " +
				"OptionType=" + this.optionType + ", " +
				"DeliveryType=" + this.deliveryType + ", " +
				"ContractSpecification=" + this.contractSpecification + ", " +
				"SubProduct=" + this.subProduct + ", " +
				"DebtSeniority=" + this.debtSeniority + ", " +
				"ReferenceRate=" + this.referenceRate + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"OtherUnderlierID=" + this.otherUnderlierID + ", " +
				"OtherUnderlierIDSource=" + this.otherUnderlierIDSource + ", " +
				"UnderlierID=" + this.underlierID + ", " +
				"OtherReferenceRate=" + this.otherReferenceRate + ", " +
				"NotionalCurrency=" + this.notionalCurrency + ", " +
				"OtherLegUnderlying=" + this.otherLegUnderlying + ", " +
				"OtherNotionalCurrency=" + this.otherNotionalCurrency + ", " +
				"ReferenceRateTermUnit=" + this.referenceRateTermUnit + ", " +
				"OptionExerciseStyle=" + this.optionExerciseStyle + ", " +
				"UnderlyingAssetType=" + this.underlyingAssetType + ", " +
				"OtherLegReferenceRateTermValue=" + this.otherLegReferenceRateTermValue + ", " +
				"OtherUnderlierCharacteristic=" + this.otherUnderlierCharacteristic + ", " +
				"OtherLegUnderlierID=" + this.otherLegUnderlierID + ", " +
				"OtherSubProduct=" + this.otherSubProduct + ", " +
				"OtherLegReferenceRate=" + this.otherLegReferenceRate + ", " +
				"Underlying=" + this.underlying + ", " +
				"OtherBaseProduct=" + this.otherBaseProduct + ", " +
				"UnderlyingInstrumentIndexProp=" + this.underlyingInstrumentIndexProp + ", " +
				"ReferenceRateTermValue=" + this.referenceRateTermValue + ", " +
				"OtherLegUnderlierIDSource=" + this.otherLegUnderlierIDSource + ", " +
				"OtherAdditionalSubProduct=" + this.otherAdditionalSubProduct + ", " +
				"Category=" + this.category +
			'}';
		}
	}
}

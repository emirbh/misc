package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbAttributes;
import drr.standards.iosco.upi.AnnaDsbBaseProduct;
import drr.standards.iosco.upi.AnnaDsbCategory;
import drr.standards.iosco.upi.AnnaDsbContractSpecificationEnum;
import drr.standards.iosco.upi.AnnaDsbDebtSeniorityEnum;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import drr.standards.iosco.upi.AnnaDsbOptionExerciseStyleEnum;
import drr.standards.iosco.upi.AnnaDsbOptionTypeEnum;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlierType;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlying;
import drr.standards.iosco.upi.AnnaDsbOtherUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbOtherUnderlying;
import drr.standards.iosco.upi.AnnaDsbPlaceofSettlementEnum;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierCharacteristicEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetClass;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingIssuerTypeEnum;
import drr.standards.iosco.upi.AnnaDsbValuationMethodorTriggerEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbAttributesOnlyExistsValidator implements ValidatorWithArg<AnnaDsbAttributes, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbAttributes> ValidationResult<AnnaDsbAttributes> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ReturnorPayoutTrigger", ExistenceChecker.isSet((AnnaDsbReturnorPayoutTriggerEnum) o.getReturnorPayoutTrigger()))
				.put("AdditionalSubProduct", ExistenceChecker.isSet((String) o.getAdditionalSubProduct()))
				.put("UnderlyingInstrumentIndexTermUnit", ExistenceChecker.isSet((AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getUnderlyingInstrumentIndexTermUnit()))
				.put("ValuationMethodorTrigger", ExistenceChecker.isSet((AnnaDsbValuationMethodorTriggerEnum) o.getValuationMethodorTrigger()))
				.put("UnderlyingInstrumentISIN", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentISIN()))
				.put("OtherLegReferenceRateTermUnit", ExistenceChecker.isSet((AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getOtherLegReferenceRateTermUnit()))
				.put("NotionalSchedule", ExistenceChecker.isSet((AnnaDsbNotionalScheduleEnum) o.getNotionalSchedule()))
				.put("OtherUnderlying", ExistenceChecker.isSet((AnnaDsbOtherUnderlying) o.getOtherUnderlying()))
				.put("UnderlyingIssuerType", ExistenceChecker.isSet((AnnaDsbUnderlyingIssuerTypeEnum) o.getUnderlyingIssuerType()))
				.put("UnderlierIDSource", ExistenceChecker.isSet((AnnaDsbUnderlierIDSourceEnum) o.getUnderlierIDSource()))
				.put("PlaceofSettlement", ExistenceChecker.isSet((AnnaDsbPlaceofSettlementEnum) o.getPlaceofSettlement()))
				.put("UnderlyingInstrumentIndexTermValue", ExistenceChecker.isSet((Integer) o.getUnderlyingInstrumentIndexTermValue()))
				.put("SettlementCurrency", ExistenceChecker.isSet((String) o.getSettlementCurrency()))
				.put("UnderlyingInstrumentIndex", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentIndex()))
				.put("BaseProduct", ExistenceChecker.isSet((AnnaDsbBaseProduct) o.getBaseProduct()))
				.put("UnderlyingInstrumentUPI", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentUPI()))
				.put("OtherLegUnderlierType", ExistenceChecker.isSet((AnnaDsbOtherLegUnderlierType) o.getOtherLegUnderlierType()))
				.put("UnderlyingAssetClass", ExistenceChecker.isSet((AnnaDsbUnderlyingAssetClass) o.getUnderlyingAssetClass()))
				.put("OptionType", ExistenceChecker.isSet((AnnaDsbOptionTypeEnum) o.getOptionType()))
				.put("DeliveryType", ExistenceChecker.isSet((AnnaDsbDeliveryTypeEnum) o.getDeliveryType()))
				.put("ContractSpecification", ExistenceChecker.isSet((AnnaDsbContractSpecificationEnum) o.getContractSpecification()))
				.put("SubProduct", ExistenceChecker.isSet((String) o.getSubProduct()))
				.put("DebtSeniority", ExistenceChecker.isSet((AnnaDsbDebtSeniorityEnum) o.getDebtSeniority()))
				.put("ReferenceRate", ExistenceChecker.isSet((String) o.getReferenceRate()))
				.put("UnderlierCharacteristic", ExistenceChecker.isSet((AnnaDsbUnderlierCharacteristicEnum) o.getUnderlierCharacteristic()))
				.put("OtherUnderlierID", ExistenceChecker.isSet((String) o.getOtherUnderlierID()))
				.put("OtherUnderlierIDSource", ExistenceChecker.isSet((AnnaDsbOtherUnderlierIDSourceEnum) o.getOtherUnderlierIDSource()))
				.put("UnderlierID", ExistenceChecker.isSet((String) o.getUnderlierID()))
				.put("OtherReferenceRate", ExistenceChecker.isSet((String) o.getOtherReferenceRate()))
				.put("NotionalCurrency", ExistenceChecker.isSet((String) o.getNotionalCurrency()))
				.put("OtherLegUnderlying", ExistenceChecker.isSet((AnnaDsbOtherLegUnderlying) o.getOtherLegUnderlying()))
				.put("OtherNotionalCurrency", ExistenceChecker.isSet((String) o.getOtherNotionalCurrency()))
				.put("ReferenceRateTermUnit", ExistenceChecker.isSet((AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getReferenceRateTermUnit()))
				.put("OptionExerciseStyle", ExistenceChecker.isSet((AnnaDsbOptionExerciseStyleEnum) o.getOptionExerciseStyle()))
				.put("UnderlyingAssetType", ExistenceChecker.isSet((AnnaDsbUnderlyingAssetTypeEnum) o.getUnderlyingAssetType()))
				.put("OtherLegReferenceRateTermValue", ExistenceChecker.isSet((Integer) o.getOtherLegReferenceRateTermValue()))
				.put("OtherUnderlierCharacteristic", ExistenceChecker.isSet((AnnaDsbUnderlierCharacteristicEnum) o.getOtherUnderlierCharacteristic()))
				.put("OtherLegUnderlierID", ExistenceChecker.isSet((String) o.getOtherLegUnderlierID()))
				.put("OtherSubProduct", ExistenceChecker.isSet((String) o.getOtherSubProduct()))
				.put("OtherLegReferenceRate", ExistenceChecker.isSet((String) o.getOtherLegReferenceRate()))
				.put("Underlying", ExistenceChecker.isSet((AnnaDsbUnderlying) o.getUnderlying()))
				.put("OtherBaseProduct", ExistenceChecker.isSet((AnnaDsbBaseProduct) o.getOtherBaseProduct()))
				.put("UnderlyingInstrumentIndexProp", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentIndexProp()))
				.put("ReferenceRateTermValue", ExistenceChecker.isSet((Integer) o.getReferenceRateTermValue()))
				.put("OtherLegUnderlierIDSource", ExistenceChecker.isSet((AnnaDsbOtherLegUnderlierIDSourceEnum) o.getOtherLegUnderlierIDSource()))
				.put("OtherAdditionalSubProduct", ExistenceChecker.isSet((String) o.getOtherAdditionalSubProduct()))
				.put("Category", ExistenceChecker.isSet((AnnaDsbCategory) o.getCategory()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbAttributes", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbAttributes", path, "");
		}
		return failure("AnnaDsbAttributes", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbAttributes", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

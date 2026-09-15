package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbCFIDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbCFIOptionStyleandTypeEnum;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbDerived;
import drr.standards.iosco.upi.AnnaDsbOptionExerciseStyleEnum;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbSingleorMultiCurrencyEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetClass;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingIssuerTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingRecord;
import drr.standards.iosco.upi.AnnaDsbValuationMethodorTriggerEnum;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbDerivedOnlyExistsValidator implements ValidatorWithArg<AnnaDsbDerived, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbDerived> ValidationResult<AnnaDsbDerived> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ReturnorPayoutTrigger", ExistenceChecker.isSet((AnnaDsbReturnorPayoutTriggerEnum) o.getReturnorPayoutTrigger()))
				.put("UnderlierCharacteristic", ExistenceChecker.isSet((String) o.getUnderlierCharacteristic()))
				.put("ValuationMethodorTrigger", ExistenceChecker.isSet((AnnaDsbValuationMethodorTriggerEnum) o.getValuationMethodorTrigger()))
				.put("ShortName", ExistenceChecker.isSet((String) o.getShortName()))
				.put("UnderlyingIssuerType", ExistenceChecker.isSet((AnnaDsbUnderlyingIssuerTypeEnum) o.getUnderlyingIssuerType()))
				.put("ClassificationType", ExistenceChecker.isSet((String) o.getClassificationType()))
				.put("OptionExerciseStyle", ExistenceChecker.isSet((AnnaDsbOptionExerciseStyleEnum) o.getOptionExerciseStyle()))
				.put("UnderlyingAssetType", ExistenceChecker.isSet((AnnaDsbUnderlyingAssetTypeEnum) o.getUnderlyingAssetType()))
				.put("SingleorMultiCurrency", ExistenceChecker.isSet((AnnaDsbSingleorMultiCurrencyEnum) o.getSingleorMultiCurrency()))
				.put("CFIDeliveryType", ExistenceChecker.isSet((AnnaDsbCFIDeliveryTypeEnum) o.getCFIDeliveryType()))
				.put("UnderlyingRecord", ExistenceChecker.isSet((List<? extends AnnaDsbUnderlyingRecord>) o.getUnderlyingRecord()))
				.put("CFIOptionStyleandType", ExistenceChecker.isSet((AnnaDsbCFIOptionStyleandTypeEnum) o.getCFIOptionStyleandType()))
				.put("UnderlierName", ExistenceChecker.isSet((String) o.getUnderlierName()))
				.put("UnderlyingAssetClass", ExistenceChecker.isSet((AnnaDsbUnderlyingAssetClass) o.getUnderlyingAssetClass()))
				.put("DeliveryType", ExistenceChecker.isSet((AnnaDsbDeliveryTypeEnum) o.getDeliveryType()))
				.put("FurtherGrouping", ExistenceChecker.isSet((String) o.getFurtherGrouping()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbDerived", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbDerived", path, "");
		}
		return failure("AnnaDsbDerived", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbDerived", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

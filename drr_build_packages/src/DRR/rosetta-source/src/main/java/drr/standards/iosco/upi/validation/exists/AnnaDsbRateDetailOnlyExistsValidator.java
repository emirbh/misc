package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbCFIOptionStyleandTypeEnum;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import drr.standards.iosco.upi.AnnaDsbRateDetail;
import drr.standards.iosco.upi.AnnaDsbSingleorMultiCurrencyEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetTypeEnum;
import drr.standards.iosco.upi.AnnaDsbValuationMethodorTriggerEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbRateDetailOnlyExistsValidator implements ValidatorWithArg<AnnaDsbRateDetail, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbRateDetail> ValidationResult<AnnaDsbRateDetail> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("UnderlyingAssetType", ExistenceChecker.isSet((AnnaDsbUnderlyingAssetTypeEnum) o.getUnderlyingAssetType()))
				.put("OptionStyleandType", ExistenceChecker.isSet((AnnaDsbCFIOptionStyleandTypeEnum) o.getOptionStyleandType()))
				.put("ValuationMethodorTrigger", ExistenceChecker.isSet((AnnaDsbValuationMethodorTriggerEnum) o.getValuationMethodorTrigger()))
				.put("DeliveryType", ExistenceChecker.isSet((AnnaDsbDeliveryTypeEnum) o.getDeliveryType()))
				.put("NotionalSchedule", ExistenceChecker.isSet((AnnaDsbNotionalScheduleEnum) o.getNotionalSchedule()))
				.put("SingleorMultiCurrency", ExistenceChecker.isSet((AnnaDsbSingleorMultiCurrencyEnum) o.getSingleorMultiCurrency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbRateDetail", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbRateDetail", path, "");
		}
		return failure("AnnaDsbRateDetail", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbRateDetail", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

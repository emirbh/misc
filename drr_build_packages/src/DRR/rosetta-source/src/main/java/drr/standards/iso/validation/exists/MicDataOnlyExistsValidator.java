package drr.standards.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iso.MicData;
import drr.standards.iso.MicMarketCategoryEnum;
import drr.standards.iso.MicTypeEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MicDataOnlyExistsValidator implements ValidatorWithArg<MicData, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MicData> ValidationResult<MicData> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("mic", ExistenceChecker.isSet((String) o.getMic()))
				.put("operatingMic", ExistenceChecker.isSet((String) o.getOperatingMic()))
				.put("micType", ExistenceChecker.isSet((MicTypeEnum) o.getMicType()))
				.put("nameInstitutionDescription", ExistenceChecker.isSet((String) o.getNameInstitutionDescription()))
				.put("legalEntityName", ExistenceChecker.isSet((String) o.getLegalEntityName()))
				.put("marketCategory", ExistenceChecker.isSet((MicMarketCategoryEnum) o.getMarketCategory()))
				.put("marketCategoryEsma", ExistenceChecker.isSet((MicMarketCategoryEnum) o.getMarketCategoryEsma()))
				.put("marketCategoryFca", ExistenceChecker.isSet((MicMarketCategoryEnum) o.getMarketCategoryFca()))
				.put("acronym", ExistenceChecker.isSet((String) o.getAcronym()))
				.put("countryCode", ExistenceChecker.isSet((String) o.getCountryCode()))
				.put("city", ExistenceChecker.isSet((String) o.getCity()))
				.put("website", ExistenceChecker.isSet((String) o.getWebsite()))
				.put("status", ExistenceChecker.isSet((String) o.getStatus()))
				.put("creationDate", ExistenceChecker.isSet((Date) o.getCreationDate()))
				.put("lastUpdateDate", ExistenceChecker.isSet((Date) o.getLastUpdateDate()))
				.put("lastValidationDate", ExistenceChecker.isSet((Date) o.getLastValidationDate()))
				.put("expiryDate", ExistenceChecker.isSet((Date) o.getExpiryDate()))
				.put("micValidation", ExistenceChecker.isSet((Boolean) o.getMicValidation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MicData", ValidationResult.ValidationType.ONLY_EXISTS, "MicData", path, "");
		}
		return failure("MicData", ValidationResult.ValidationType.ONLY_EXISTS, "MicData", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package drr.enrichment.lei.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.enrichment.lei.LeiCategoryEnum;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.LeiGeneralCategoryEnum;
import drr.enrichment.lei.LeiRegistrationStatusEnum;
import drr.enrichment.lei.LeiStatusEnum;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LeiDataOnlyExistsValidator implements ValidatorWithArg<LeiData, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LeiData> ValidationResult<LeiData> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("lei", ExistenceChecker.isSet((String) o.getLei()))
				.put("entityName", ExistenceChecker.isSet((String) o.getEntityName()))
				.put("entityCategory", ExistenceChecker.isSet((LeiCategoryEnum) o.getEntityCategory()))
				.put("entityStatus", ExistenceChecker.isSet((LeiStatusEnum) o.getEntityStatus()))
				.put("branchEntityStatus", ExistenceChecker.isSet((LeiStatusEnum) o.getBranchEntityStatus()))
				.put("generalCategory", ExistenceChecker.isSet((LeiGeneralCategoryEnum) o.getGeneralCategory()))
				.put("registrationStatus", ExistenceChecker.isSet((LeiRegistrationStatusEnum) o.getRegistrationStatus()))
				.put("registrationDate", ExistenceChecker.isSet((ZonedDateTime) o.getRegistrationDate()))
				.put("published", ExistenceChecker.isSet((Boolean) o.getPublished()))
				.put("leiValidation", ExistenceChecker.isSet((Boolean) o.getLeiValidation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LeiData", ValidationResult.ValidationType.ONLY_EXISTS, "LeiData", path, "");
		}
		return failure("LeiData", ValidationResult.ValidationType.ONLY_EXISTS, "LeiData", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

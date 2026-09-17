package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.datetime.CustomisableOffset;
import cdm.legaldocumentation.csa.CustodianEventEndDate;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CustodianEventEndDateOnlyExistsValidator implements ValidatorWithArg<CustodianEventEndDate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CustodianEventEndDate> ValidationResult<CustodianEventEndDate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("daysAfterCustodianEvent", ExistenceChecker.isSet((CustomisableOffset) o.getDaysAfterCustodianEvent()))
				.put("releaseDate", ExistenceChecker.isSet((CustomisableOffset) o.getReleaseDate()))
				.put("safekeepingPeriodExpiry", ExistenceChecker.isSet((CustomisableOffset) o.getSafekeepingPeriodExpiry()))
				.put("dateOfTimelyStatement", ExistenceChecker.isSet((CustomisableOffset) o.getDateOfTimelyStatement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CustodianEventEndDate", ValidationResult.ValidationType.ONLY_EXISTS, "CustodianEventEndDate", path, "");
		}
		return failure("CustodianEventEndDate", ValidationResult.ValidationType.ONLY_EXISTS, "CustodianEventEndDate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

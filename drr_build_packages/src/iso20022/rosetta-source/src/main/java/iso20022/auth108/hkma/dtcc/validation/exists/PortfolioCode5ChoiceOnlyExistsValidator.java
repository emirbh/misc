package iso20022.auth108.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.hkma.dtcc.NotApplicable1Code;
import iso20022.auth108.hkma.dtcc.PortfolioCode5Choice;
import iso20022.auth108.hkma.dtcc.PortfolioIdentification3;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PortfolioCode5ChoiceOnlyExistsValidator implements ValidatorWithArg<PortfolioCode5Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PortfolioCode5Choice> ValidationResult<PortfolioCode5Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("prtfl", ExistenceChecker.isSet((PortfolioIdentification3) o.getPrtfl()))
				.put("noPrtfl", ExistenceChecker.isSet((NotApplicable1Code) o.getNoPrtfl()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PortfolioCode5Choice", ValidationResult.ValidationType.ONLY_EXISTS, "PortfolioCode5Choice", path, "");
		}
		return failure("PortfolioCode5Choice", ValidationResult.ValidationType.ONLY_EXISTS, "PortfolioCode5Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

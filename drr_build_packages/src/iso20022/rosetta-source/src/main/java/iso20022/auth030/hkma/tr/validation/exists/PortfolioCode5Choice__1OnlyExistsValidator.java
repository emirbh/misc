package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.NotApplicable1Code;
import iso20022.auth030.hkma.tr.PortfolioCode5Choice__1;
import iso20022.auth030.hkma.tr.PortfolioIdentification3__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PortfolioCode5Choice__1OnlyExistsValidator implements ValidatorWithArg<PortfolioCode5Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PortfolioCode5Choice__1> ValidationResult<PortfolioCode5Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("prtfl", ExistenceChecker.isSet((PortfolioIdentification3__1) o.getPrtfl()))
				.put("noPrtfl", ExistenceChecker.isSet((NotApplicable1Code) o.getNoPrtfl()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PortfolioCode5Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "PortfolioCode5Choice__1", path, "");
		}
		return failure("PortfolioCode5Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "PortfolioCode5Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

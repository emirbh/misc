package iso20022.auth030.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.FixedRate10__1;
import iso20022.auth030.hkma.dtcc.InterestComputationMethodFormat7__1;
import iso20022.auth030.hkma.dtcc.InterestRateFrequency3Choice__1;
import iso20022.auth030.hkma.dtcc.SecuritiesTransactionPrice14Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FixedRate10__1OnlyExistsValidator implements ValidatorWithArg<FixedRate10__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FixedRate10__1> ValidationResult<FixedRate10__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rate", ExistenceChecker.isSet((SecuritiesTransactionPrice14Choice__1) o.getRate()))
				.put("dayCnt", ExistenceChecker.isSet((InterestComputationMethodFormat7__1) o.getDayCnt()))
				.put("pmtFrqcy", ExistenceChecker.isSet((InterestRateFrequency3Choice__1) o.getPmtFrqcy()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FixedRate10__1", ValidationResult.ValidationType.ONLY_EXISTS, "FixedRate10__1", path, "");
		}
		return failure("FixedRate10__1", ValidationResult.ValidationType.ONLY_EXISTS, "FixedRate10__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

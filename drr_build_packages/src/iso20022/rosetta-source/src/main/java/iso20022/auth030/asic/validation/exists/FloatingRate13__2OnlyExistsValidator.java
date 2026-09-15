package iso20022.auth030.asic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.FloatingRate13__2;
import iso20022.auth030.asic.FloatingRateIdentification8Choice__1;
import iso20022.auth030.asic.InterestComputationMethodFormat7__1;
import iso20022.auth030.asic.InterestRateContractTerm4__2;
import iso20022.auth030.asic.InterestRateFrequency3Choice__1;
import iso20022.auth030.asic.SecuritiesTransactionPrice20Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FloatingRate13__2OnlyExistsValidator implements ValidatorWithArg<FloatingRate13__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingRate13__2> ValidationResult<FloatingRate13__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rate", ExistenceChecker.isSet((FloatingRateIdentification8Choice__1) o.getRate()))
				.put("refPrd", ExistenceChecker.isSet((InterestRateContractTerm4__2) o.getRefPrd()))
				.put("sprd", ExistenceChecker.isSet((SecuritiesTransactionPrice20Choice__1) o.getSprd()))
				.put("dayCnt", ExistenceChecker.isSet((InterestComputationMethodFormat7__1) o.getDayCnt()))
				.put("pmtFrqcy", ExistenceChecker.isSet((InterestRateFrequency3Choice__1) o.getPmtFrqcy()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRate13__2", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRate13__2", path, "");
		}
		return failure("FloatingRate13__2", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRate13__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

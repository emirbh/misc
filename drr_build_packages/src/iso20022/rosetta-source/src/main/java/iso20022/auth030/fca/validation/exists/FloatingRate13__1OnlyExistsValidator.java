package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.FloatingRate13__1;
import iso20022.auth030.fca.FloatingRateIdentification8Choice__1;
import iso20022.auth030.fca.InterestComputationMethodFormat7__1;
import iso20022.auth030.fca.InterestRateContractTerm4__2;
import iso20022.auth030.fca.InterestRateFrequency3Choice__2;
import iso20022.auth030.fca.SecuritiesTransactionPrice20Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FloatingRate13__1OnlyExistsValidator implements ValidatorWithArg<FloatingRate13__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingRate13__1> ValidationResult<FloatingRate13__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("nm", ExistenceChecker.isSet((String) o.getNm()))
				.put("rate", ExistenceChecker.isSet((FloatingRateIdentification8Choice__1) o.getRate()))
				.put("refPrd", ExistenceChecker.isSet((InterestRateContractTerm4__2) o.getRefPrd()))
				.put("sprd", ExistenceChecker.isSet((SecuritiesTransactionPrice20Choice__1) o.getSprd()))
				.put("dayCnt", ExistenceChecker.isSet((InterestComputationMethodFormat7__1) o.getDayCnt()))
				.put("pmtFrqcy", ExistenceChecker.isSet((InterestRateFrequency3Choice__2) o.getPmtFrqcy()))
				.put("rstFrqcy", ExistenceChecker.isSet((InterestRateFrequency3Choice__2) o.getRstFrqcy()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRate13__1", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRate13__1", path, "");
		}
		return failure("FloatingRate13__1", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRate13__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.CounterpartyTradeNature15Choice__2;
import iso20022.auth030.esma.FinancialInstitutionSector1__1;
import iso20022.auth030.esma.NoReasonCode;
import iso20022.auth030.esma.NonFinancialInstitutionSector10__2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CounterpartyTradeNature15Choice__2OnlyExistsValidator implements ValidatorWithArg<CounterpartyTradeNature15Choice__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CounterpartyTradeNature15Choice__2> ValidationResult<CounterpartyTradeNature15Choice__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fi", ExistenceChecker.isSet((FinancialInstitutionSector1__1) o.getFi()))
				.put("nfi", ExistenceChecker.isSet((NonFinancialInstitutionSector10__2) o.getNfi()))
				.put("cntrlCntrPty", ExistenceChecker.isSet((NoReasonCode) o.getCntrlCntrPty()))
				.put("othr", ExistenceChecker.isSet((NoReasonCode) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CounterpartyTradeNature15Choice__2", ValidationResult.ValidationType.ONLY_EXISTS, "CounterpartyTradeNature15Choice__2", path, "");
		}
		return failure("CounterpartyTradeNature15Choice__2", ValidationResult.ValidationType.ONLY_EXISTS, "CounterpartyTradeNature15Choice__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

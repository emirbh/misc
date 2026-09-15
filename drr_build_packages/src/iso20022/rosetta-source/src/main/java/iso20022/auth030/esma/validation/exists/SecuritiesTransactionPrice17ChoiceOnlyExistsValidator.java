package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AmountAndDirection106;
import iso20022.auth030.esma.PriceStatus1Code;
import iso20022.auth030.esma.SecuritiesTransactionPrice17Choice;
import iso20022.auth030.esma.SecuritiesTransactionPrice5;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SecuritiesTransactionPrice17ChoiceOnlyExistsValidator implements ValidatorWithArg<SecuritiesTransactionPrice17Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SecuritiesTransactionPrice17Choice> ValidationResult<SecuritiesTransactionPrice17Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("mntryVal", ExistenceChecker.isSet((AmountAndDirection106) o.getMntryVal()))
				.put("unit", ExistenceChecker.isSet((BigDecimal) o.getUnit()))
				.put("pctg", ExistenceChecker.isSet((BigDecimal) o.getPctg()))
				.put("yld", ExistenceChecker.isSet((BigDecimal) o.getYld()))
				.put("dcml", ExistenceChecker.isSet((BigDecimal) o.getDcml()))
				.put("pdgPric", ExistenceChecker.isSet((PriceStatus1Code) o.getPdgPric()))
				.put("othr", ExistenceChecker.isSet((SecuritiesTransactionPrice5) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecuritiesTransactionPrice17Choice", ValidationResult.ValidationType.ONLY_EXISTS, "SecuritiesTransactionPrice17Choice", path, "");
		}
		return failure("SecuritiesTransactionPrice17Choice", ValidationResult.ValidationType.ONLY_EXISTS, "SecuritiesTransactionPrice17Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

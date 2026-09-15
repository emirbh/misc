package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.PriceData2__1;
import iso20022.auth030.esma.Schedule1;
import iso20022.auth030.esma.SecuritiesTransactionPrice17Choice__1;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PriceData2__1OnlyExistsValidator implements ValidatorWithArg<PriceData2__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PriceData2__1> ValidationResult<PriceData2__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("pric", ExistenceChecker.isSet((SecuritiesTransactionPrice17Choice__1) o.getPric()))
				.put("schdlPrd", ExistenceChecker.isSet((List<? extends Schedule1>) o.getSchdlPrd()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PriceData2__1", ValidationResult.ValidationType.ONLY_EXISTS, "PriceData2__1", path, "");
		}
		return failure("PriceData2__1", ValidationResult.ValidationType.ONLY_EXISTS, "PriceData2__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

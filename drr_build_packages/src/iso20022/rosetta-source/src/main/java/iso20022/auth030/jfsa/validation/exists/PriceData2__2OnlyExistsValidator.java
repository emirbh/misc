package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.PriceData2__2;
import iso20022.auth030.jfsa.SecuritiesTransactionPrice17Choice__1;
import iso20022.auth030.jfsa.UnitOfMeasure8Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PriceData2__2OnlyExistsValidator implements ValidatorWithArg<PriceData2__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PriceData2__2> ValidationResult<PriceData2__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("pric", ExistenceChecker.isSet((SecuritiesTransactionPrice17Choice__1) o.getPric()))
				.put("unitOfMeasr", ExistenceChecker.isSet((UnitOfMeasure8Choice__1) o.getUnitOfMeasr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PriceData2__2", ValidationResult.ValidationType.ONLY_EXISTS, "PriceData2__2", path, "");
		}
		return failure("PriceData2__2", ValidationResult.ValidationType.ONLY_EXISTS, "PriceData2__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

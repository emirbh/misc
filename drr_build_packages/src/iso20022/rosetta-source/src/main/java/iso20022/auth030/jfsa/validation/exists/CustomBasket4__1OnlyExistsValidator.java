package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.BasketConstituents3__1;
import iso20022.auth030.jfsa.CustomBasket4__1;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CustomBasket4__1OnlyExistsValidator implements ValidatorWithArg<CustomBasket4__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CustomBasket4__1> ValidationResult<CustomBasket4__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("strr", ExistenceChecker.isSet((String) o.getStrr()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("cnsttnts", ExistenceChecker.isSet((List<? extends BasketConstituents3__1>) o.getCnsttnts()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CustomBasket4__1", ValidationResult.ValidationType.ONLY_EXISTS, "CustomBasket4__1", path, "");
		}
		return failure("CustomBasket4__1", ValidationResult.ValidationType.ONLY_EXISTS, "CustomBasket4__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

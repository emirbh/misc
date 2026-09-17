package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.legaldocumentation.csa.ExcludedProducts;
import cdm.legaldocumentation.csa.ExposureScopeProductEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ExcludedProductsOnlyExistsValidator implements ValidatorWithArg<ExcludedProducts, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ExcludedProducts> ValidationResult<ExcludedProducts> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("product", ExistenceChecker.isSet((List<ExposureScopeProductEnum>) o.getProduct()))
				.put("branch", ExistenceChecker.isSet((List<BusinessCenterEnum>) o.getBranch()))
				.put("excluded", ExistenceChecker.isSet((Boolean) o.getExcluded()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExcludedProducts", ValidationResult.ValidationType.ONLY_EXISTS, "ExcludedProducts", path, "");
		}
		return failure("ExcludedProducts", ValidationResult.ValidationType.ONLY_EXISTS, "ExcludedProducts", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

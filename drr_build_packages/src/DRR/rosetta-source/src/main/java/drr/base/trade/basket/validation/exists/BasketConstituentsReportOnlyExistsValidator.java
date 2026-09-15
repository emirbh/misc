package drr.base.trade.basket.validation.exists;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.basket.BasketConstituentsReport;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BasketConstituentsReportOnlyExistsValidator implements ValidatorWithArg<BasketConstituentsReport, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BasketConstituentsReport> ValidationResult<BasketConstituentsReport> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet((String) o.getIdentifier()))
				.put("source", ExistenceChecker.isSet((AssetIdTypeEnum) o.getSource()))
				.put("numberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getNumberOfUnits()))
				.put("unitOfMeasure", ExistenceChecker.isSet((String) o.getUnitOfMeasure()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BasketConstituentsReport", ValidationResult.ValidationType.ONLY_EXISTS, "BasketConstituentsReport", path, "");
		}
		return failure("BasketConstituentsReport", ValidationResult.ValidationType.ONLY_EXISTS, "BasketConstituentsReport", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

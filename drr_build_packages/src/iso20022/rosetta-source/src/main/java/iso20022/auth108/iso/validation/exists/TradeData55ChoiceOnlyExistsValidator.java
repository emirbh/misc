package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.ReportPeriodActivity1Code;
import iso20022.auth108.iso.TradeData55Choice;
import iso20022.auth108.iso.TradeReport31Choice;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeData55ChoiceOnlyExistsValidator implements ValidatorWithArg<TradeData55Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeData55Choice> ValidationResult<TradeData55Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dataSetActn", ExistenceChecker.isSet((ReportPeriodActivity1Code) o.getDataSetActn()))
				.put("rpt", ExistenceChecker.isSet((List<? extends TradeReport31Choice>) o.getRpt()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeData55Choice", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData55Choice", path, "");
		}
		return failure("TradeData55Choice", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData55Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

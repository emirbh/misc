package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.MarginReportData7;
import iso20022.auth108.iso.TradeReport31Choice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeReport31ChoiceOnlyExistsValidator implements ValidatorWithArg<TradeReport31Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeReport31Choice> ValidationResult<TradeReport31Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("new", ExistenceChecker.isSet((MarginReportData7) o.getNew()))
				.put("mrgnUpd", ExistenceChecker.isSet((MarginReportData7) o.getMrgnUpd()))
				.put("err", ExistenceChecker.isSet((MarginReportData7) o.getErr()))
				.put("crrctn", ExistenceChecker.isSet((MarginReportData7) o.getCrrctn()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeReport31Choice", ValidationResult.ValidationType.ONLY_EXISTS, "TradeReport31Choice", path, "");
		}
		return failure("TradeReport31Choice", ValidationResult.ValidationType.ONLY_EXISTS, "TradeReport31Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

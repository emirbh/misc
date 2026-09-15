package iso20022.auth108.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.fca.MarginReportData7__1;
import iso20022.auth108.fca.MarginReportData7__2;
import iso20022.auth108.fca.TradeReport31Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeReport31Choice__1OnlyExistsValidator implements ValidatorWithArg<TradeReport31Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeReport31Choice__1> ValidationResult<TradeReport31Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("mrgnUpd", ExistenceChecker.isSet((MarginReportData7__1) o.getMrgnUpd()))
				.put("crrctn", ExistenceChecker.isSet((MarginReportData7__2) o.getCrrctn()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeReport31Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeReport31Choice__1", path, "");
		}
		return failure("TradeReport31Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeReport31Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

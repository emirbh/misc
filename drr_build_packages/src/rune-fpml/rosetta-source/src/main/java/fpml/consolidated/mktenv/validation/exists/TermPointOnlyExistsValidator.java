package fpml.consolidated.mktenv.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.mktenv.TermPoint;
import fpml.consolidated.riskdef.TimeDimension;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TermPointOnlyExistsValidator implements ValidatorWithArg<TermPoint, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TermPoint> ValidationResult<TermPoint> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("term", ExistenceChecker.isSet((TimeDimension) o.getTerm()))
				.put("bid", ExistenceChecker.isSet((BigDecimal) o.getBid()))
				.put("mid", ExistenceChecker.isSet((BigDecimal) o.getMid()))
				.put("ask", ExistenceChecker.isSet((BigDecimal) o.getAsk()))
				.put("spreadValue", ExistenceChecker.isSet((BigDecimal) o.getSpreadValue()))
				.put("definition", ExistenceChecker.isSet((AssetReference) o.getDefinition()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TermPoint", ValidationResult.ValidationType.ONLY_EXISTS, "TermPoint", path, "");
		}
		return failure("TermPoint", ValidationResult.ValidationType.ONLY_EXISTS, "TermPoint", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

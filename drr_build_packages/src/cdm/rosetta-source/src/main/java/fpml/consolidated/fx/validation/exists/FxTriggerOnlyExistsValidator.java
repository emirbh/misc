package fpml.consolidated.fx.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.TriggerConditionEnum;
import fpml.consolidated.fx.FxTrigger;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTriggerOnlyExistsValidator implements ValidatorWithArg<FxTrigger, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTrigger> ValidationResult<FxTrigger> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("triggerCondition", ExistenceChecker.isSet((TriggerConditionEnum) o.getTriggerCondition()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("triggerRate", ExistenceChecker.isSet((BigDecimal) o.getTriggerRate()))
				.put("spotRate", ExistenceChecker.isSet((BigDecimal) o.getSpotRate()))
				.put("informationSource", ExistenceChecker.isSet((List<? extends InformationSource>) o.getInformationSource()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTrigger", ValidationResult.ValidationType.ONLY_EXISTS, "FxTrigger", path, "");
		}
		return failure("FxTrigger", ValidationResult.ValidationType.ONLY_EXISTS, "FxTrigger", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

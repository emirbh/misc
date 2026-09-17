package fpml.consolidated.fx.targets.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.FxSettlementAdjustmentMethodEnum;
import fpml.consolidated.fx.targets.FxExchangedCurrency;
import fpml.consolidated.fx.targets.FxStrike;
import fpml.consolidated.fx.targets.FxStrikeReference;
import fpml.consolidated.fx.targets.FxTargetPhysicalSettlement;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetPhysicalSettlementOnlyExistsValidator implements ValidatorWithArg<FxTargetPhysicalSettlement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTargetPhysicalSettlement> ValidationResult<FxTargetPhysicalSettlement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("exchangedCurrency1", ExistenceChecker.isSet((FxExchangedCurrency) o.getExchangedCurrency1()))
				.put("exchangedCurrency2", ExistenceChecker.isSet((FxExchangedCurrency) o.getExchangedCurrency2()))
				.put("settlementAdjustmentStyle", ExistenceChecker.isSet((FxSettlementAdjustmentMethodEnum) o.getSettlementAdjustmentStyle()))
				.put("strike", ExistenceChecker.isSet((FxStrike) o.getStrike()))
				.put("strikeReference", ExistenceChecker.isSet((FxStrikeReference) o.getStrikeReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTargetPhysicalSettlement", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetPhysicalSettlement", path, "");
		}
		return failure("FxTargetPhysicalSettlement", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetPhysicalSettlement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

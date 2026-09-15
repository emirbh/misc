package fpml.consolidated.fx.targets.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxSettlementPeriodBarrier;
import fpml.consolidated.fx.targets.FxTargetSettlementPeriod;
import fpml.consolidated.fx.targets.FxTargetSettlementPeriodPayoff;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetSettlementPeriodOnlyExistsValidator implements ValidatorWithArg<FxTargetSettlementPeriod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTargetSettlementPeriod> ValidationResult<FxTargetSettlementPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expiryDate", ExistenceChecker.isSet((ZonedDateTime) o.getExpiryDate()))
				.put("settlementDate", ExistenceChecker.isSet((ZonedDateTime) o.getSettlementDate()))
				.put("notionalAmount", ExistenceChecker.isSet((BigDecimal) o.getNotionalAmount()))
				.put("pivot", ExistenceChecker.isSet((BigDecimal) o.getPivot()))
				.put("payoff", ExistenceChecker.isSet((List<? extends FxTargetSettlementPeriodPayoff>) o.getPayoff()))
				.put("barrier", ExistenceChecker.isSet((List<? extends FxSettlementPeriodBarrier>) o.getBarrier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTargetSettlementPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetSettlementPeriod", path, "");
		}
		return failure("FxTargetSettlementPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetSettlementPeriod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

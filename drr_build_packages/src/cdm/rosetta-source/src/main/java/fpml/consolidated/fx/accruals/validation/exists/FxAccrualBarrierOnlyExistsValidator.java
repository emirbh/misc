package fpml.consolidated.fx.accruals.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.ConditionEnum;
import fpml.consolidated.fpmlenum.FxAccrualKnockoutBarrierRetentionEnum;
import fpml.consolidated.fpmlenum.FxBarrierScopeEnum;
import fpml.consolidated.fpmlenum.FxBarrierStyleEnum;
import fpml.consolidated.fpmlenum.FxBarrierTypeSimpleEnum;
import fpml.consolidated.fx.accruals.FxAccrualBarrier;
import fpml.consolidated.fx.accruals.FxRateObservableReference;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import fpml.consolidated.shared.Schedule;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualBarrierOnlyExistsValidator implements ValidatorWithArg<FxAccrualBarrier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualBarrier> ValidationResult<FxAccrualBarrier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("barrierType", ExistenceChecker.isSet((FxBarrierTypeSimpleEnum) o.getBarrierType()))
				.put("style", ExistenceChecker.isSet((FxBarrierStyleEnum) o.getStyle()))
				.put("scope", ExistenceChecker.isSet((FxBarrierScopeEnum) o.getScope()))
				.put("condition", ExistenceChecker.isSet((ConditionEnum) o.getCondition()))
				.put("triggerRate", ExistenceChecker.isSet((Schedule) o.getTriggerRate()))
				.put("observationStartDate", ExistenceChecker.isSet((ZonedDateTime) o.getObservationStartDate()))
				.put("observationStartTime", ExistenceChecker.isSet((BusinessCenterTime) o.getObservationStartTime()))
				.put("observationEndDate", ExistenceChecker.isSet((ZonedDateTime) o.getObservationEndDate()))
				.put("observationEndTime", ExistenceChecker.isSet((BusinessCenterTime) o.getObservationEndTime()))
				.put("accrualRetention", ExistenceChecker.isSet((FxAccrualKnockoutBarrierRetentionEnum) o.getAccrualRetention()))
				.put("observableReference", ExistenceChecker.isSet((FxRateObservableReference) o.getObservableReference()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("informationSource", ExistenceChecker.isSet((List<? extends InformationSource>) o.getInformationSource()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualBarrier", ValidationResult.ValidationType.ONLY_EXISTS, "FxAccrualBarrier", path, "");
		}
		return failure("FxAccrualBarrier", ValidationResult.ValidationType.ONLY_EXISTS, "FxAccrualBarrier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

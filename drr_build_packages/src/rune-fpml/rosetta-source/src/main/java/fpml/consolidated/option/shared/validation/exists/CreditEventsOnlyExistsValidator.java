package fpml.consolidated.option.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.CreditEventNotice;
import fpml.consolidated.option.shared.CreditEvents;
import fpml.consolidated.option.shared.FailureToPay;
import fpml.consolidated.option.shared.Restructuring;
import fpml.consolidated.shared.Money;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditEventsOnlyExistsValidator implements ValidatorWithArg<CreditEvents, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditEvents> ValidationResult<CreditEvents> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("bankruptcy", ExistenceChecker.isSet((Boolean) o.getBankruptcy()))
				.put("failureToPay", ExistenceChecker.isSet((FailureToPay) o.getFailureToPay()))
				.put("failureToPayPrincipal", ExistenceChecker.isSet((Boolean) o.getFailureToPayPrincipal()))
				.put("failureToPayInterest", ExistenceChecker.isSet((Boolean) o.getFailureToPayInterest()))
				.put("obligationDefault", ExistenceChecker.isSet((Boolean) o.getObligationDefault()))
				.put("obligationAcceleration", ExistenceChecker.isSet((Boolean) o.getObligationAcceleration()))
				.put("repudiationMoratorium", ExistenceChecker.isSet((Boolean) o.getRepudiationMoratorium()))
				.put("restructuring", ExistenceChecker.isSet((Restructuring) o.getRestructuring()))
				.put("governmentalIntervention", ExistenceChecker.isSet((Boolean) o.getGovernmentalIntervention()))
				.put("distressedRatingsDowngrade", ExistenceChecker.isSet((Boolean) o.getDistressedRatingsDowngrade()))
				.put("maturityExtension", ExistenceChecker.isSet((Boolean) o.getMaturityExtension()))
				.put("writedown", ExistenceChecker.isSet((Boolean) o.getWritedown()))
				.put("impliedWritedown", ExistenceChecker.isSet((Boolean) o.getImpliedWritedown()))
				.put("defaultRequirement", ExistenceChecker.isSet((Money) o.getDefaultRequirement()))
				.put("creditEventNotice", ExistenceChecker.isSet((CreditEventNotice) o.getCreditEventNotice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditEvents", ValidationResult.ValidationType.ONLY_EXISTS, "CreditEvents", path, "");
		}
		return failure("CreditEvents", ValidationResult.ValidationType.ONLY_EXISTS, "CreditEvents", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

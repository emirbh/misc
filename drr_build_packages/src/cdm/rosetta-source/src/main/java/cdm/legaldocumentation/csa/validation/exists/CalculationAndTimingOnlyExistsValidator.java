package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.BespokeCalculationDate;
import cdm.legaldocumentation.csa.BespokeCalculationTime;
import cdm.legaldocumentation.csa.CalculationAgentTerms;
import cdm.legaldocumentation.csa.CalculationAndTiming;
import cdm.legaldocumentation.csa.CalculationDateLocation;
import cdm.legaldocumentation.csa.CollateralValuationAgent;
import cdm.legaldocumentation.csa.LegacyValuationAgent;
import cdm.legaldocumentation.csa.LegacyValuationDate;
import cdm.legaldocumentation.csa.LegacyValuationTime;
import cdm.legaldocumentation.csa.NotificationTime;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CalculationAndTimingOnlyExistsValidator implements ValidatorWithArg<CalculationAndTiming, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CalculationAndTiming> ValidationResult<CalculationAndTiming> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationAgentTerms", ExistenceChecker.isSet((CalculationAgentTerms) o.getCalculationAgentTerms()))
				.put("bespokeCalculationDate", ExistenceChecker.isSet((BespokeCalculationDate) o.getBespokeCalculationDate()))
				.put("bespokeCalculationTime", ExistenceChecker.isSet((BespokeCalculationTime) o.getBespokeCalculationTime()))
				.put("calculationDateLocation", ExistenceChecker.isSet((CalculationDateLocation) o.getCalculationDateLocation()))
				.put("notificationTime", ExistenceChecker.isSet((NotificationTime) o.getNotificationTime()))
				.put("collateralValuationAgent", ExistenceChecker.isSet((CollateralValuationAgent) o.getCollateralValuationAgent()))
				.put("cashSettlementDay", ExistenceChecker.isSet((String) o.getCashSettlementDay()))
				.put("securitiesSettlementDay", ExistenceChecker.isSet((String) o.getSecuritiesSettlementDay()))
				.put("legacyValuationDate", ExistenceChecker.isSet((LegacyValuationDate) o.getLegacyValuationDate()))
				.put("legacyValuationTime", ExistenceChecker.isSet((LegacyValuationTime) o.getLegacyValuationTime()))
				.put("legacyValuationAgent", ExistenceChecker.isSet((LegacyValuationAgent) o.getLegacyValuationAgent()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CalculationAndTiming", ValidationResult.ValidationType.ONLY_EXISTS, "CalculationAndTiming", path, "");
		}
		return failure("CalculationAndTiming", ValidationResult.ValidationType.ONLY_EXISTS, "CalculationAndTiming", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.legaldocumentation.transaction.Clause;
import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.observable.asset.ValuationPostponement;
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

public class EscrowArrangementOnlyExistsValidator implements ValidatorWithArg<EscrowArrangement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EscrowArrangement> ValidationResult<EscrowArrangement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("escrowArrangementIsApplicable", ExistenceChecker.isSet((Boolean) o.getEscrowArrangementIsApplicable()))
				.put("maximumDaysOfDisruption", ExistenceChecker.isSet((ValuationPostponement) o.getMaximumDaysOfDisruption()))
				.put("bespokeEscrowArrangements", ExistenceChecker.isSet((Clause) o.getBespokeEscrowArrangements()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EscrowArrangement", ValidationResult.ValidationType.ONLY_EXISTS, "EscrowArrangement", path, "");
		}
		return failure("EscrowArrangement", ValidationResult.ValidationType.ONLY_EXISTS, "EscrowArrangement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

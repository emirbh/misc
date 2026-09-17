package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.base.staticdata.party.AncillaryEntity;
import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.Nationalization;
import cdm.observable.asset.ValuationPostponement;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NationalizationOnlyExistsValidator implements ValidatorWithArg<Nationalization, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Nationalization> ValidationResult<Nationalization> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("nationalizationIsApplicable", ExistenceChecker.isSet((Boolean) o.getNationalizationIsApplicable()))
				.put("relevantAffiliate", ExistenceChecker.isSet((List<? extends AncillaryEntity>) o.getRelevantAffiliate()))
				.put("escrowArrangement", ExistenceChecker.isSet((EscrowArrangement) o.getEscrowArrangement()))
				.put("assignmentOfClaim", ExistenceChecker.isSet((Boolean) o.getAssignmentOfClaim()))
				.put("maximumDaysOfDisruption", ExistenceChecker.isSet((ValuationPostponement) o.getMaximumDaysOfDisruption()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Nationalization", ValidationResult.ValidationType.ONLY_EXISTS, "Nationalization", path, "");
		}
		return failure("Nationalization", ValidationResult.ValidationType.ONLY_EXISTS, "Nationalization", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

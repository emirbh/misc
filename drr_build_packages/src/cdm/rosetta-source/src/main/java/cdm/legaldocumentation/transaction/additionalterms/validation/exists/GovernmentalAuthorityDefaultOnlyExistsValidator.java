package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.GovernmentalAuthorityDefault;
import cdm.legaldocumentation.transaction.additionalterms.SpecifiedValueEnum;
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

public class GovernmentalAuthorityDefaultOnlyExistsValidator implements ValidatorWithArg<GovernmentalAuthorityDefault, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GovernmentalAuthorityDefault> ValidationResult<GovernmentalAuthorityDefault> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("governmentalAuthorityDefaultIsApplicable", ExistenceChecker.isSet((Boolean) o.getGovernmentalAuthorityDefaultIsApplicable()))
				.put("escrowArrangement", ExistenceChecker.isSet((EscrowArrangement) o.getEscrowArrangement()))
				.put("localSubstituteProvisionType", ExistenceChecker.isSet((FxSubstitutionProvisionTypeEnum) o.getLocalSubstituteProvisionType()))
				.put("specifiedValue", ExistenceChecker.isSet((SpecifiedValueEnum) o.getSpecifiedValue()))
				.put("maximumDaysOfDisruption", ExistenceChecker.isSet((ValuationPostponement) o.getMaximumDaysOfDisruption()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GovernmentalAuthorityDefault", ValidationResult.ValidationType.ONLY_EXISTS, "GovernmentalAuthorityDefault", path, "");
		}
		return failure("GovernmentalAuthorityDefault", ValidationResult.ValidationType.ONLY_EXISTS, "GovernmentalAuthorityDefault", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.FxBenchmarkObligationDefault;
import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.SpecifiedValueEnum;
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

public class FxBenchmarkObligationDefaultOnlyExistsValidator implements ValidatorWithArg<FxBenchmarkObligationDefault, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxBenchmarkObligationDefault> ValidationResult<FxBenchmarkObligationDefault> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("benchmarkObligationDefaultIsApplicable", ExistenceChecker.isSet((Boolean) o.getBenchmarkObligationDefaultIsApplicable()))
				.put("localSubstituteProvisionType", ExistenceChecker.isSet((FxSubstitutionProvisionTypeEnum) o.getLocalSubstituteProvisionType()))
				.put("specifiedValue", ExistenceChecker.isSet((SpecifiedValueEnum) o.getSpecifiedValue()))
				.put("escrowArrangement", ExistenceChecker.isSet((EscrowArrangement) o.getEscrowArrangement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxBenchmarkObligationDefault", ValidationResult.ValidationType.ONLY_EXISTS, "FxBenchmarkObligationDefault", path, "");
		}
		return failure("FxBenchmarkObligationDefault", ValidationResult.ValidationType.ONLY_EXISTS, "FxBenchmarkObligationDefault", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

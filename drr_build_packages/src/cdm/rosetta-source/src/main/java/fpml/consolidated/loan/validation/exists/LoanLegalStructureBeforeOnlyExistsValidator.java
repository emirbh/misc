package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.LoanLegalStructureBefore;
import fpml.consolidated.loan.LoanLegalStructureBeforeChoice;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanLegalStructureBeforeOnlyExistsValidator implements ValidatorWithArg<LoanLegalStructureBefore, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanLegalStructureBefore> ValidationResult<LoanLegalStructureBefore> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dealReference", ExistenceChecker.isSet((DealReference) o.getDealReference()))
				.put("facilityReference", ExistenceChecker.isSet((List<? extends FacilityReference>) o.getFacilityReference()))
				.put("loanLegalStructureBeforeChoice", ExistenceChecker.isSet((List<? extends LoanLegalStructureBeforeChoice>) o.getLoanLegalStructureBeforeChoice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanLegalStructureBefore", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalStructureBefore", path, "");
		}
		return failure("LoanLegalStructureBefore", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalStructureBefore", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

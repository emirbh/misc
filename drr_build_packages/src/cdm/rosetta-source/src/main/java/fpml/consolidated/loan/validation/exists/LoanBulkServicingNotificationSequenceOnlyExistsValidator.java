package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.FacilityIdentifier;
import fpml.consolidated.loan.FacilitySummary;
import fpml.consolidated.loan.LoanBulkServicingNotificationSequence;
import fpml.consolidated.loan.LoanBulkServicingNotificationSequenceChoice;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanBulkServicingNotificationSequenceOnlyExistsValidator implements ValidatorWithArg<LoanBulkServicingNotificationSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanBulkServicingNotificationSequence> ValidationResult<LoanBulkServicingNotificationSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dealIdentifier", ExistenceChecker.isSet((DealIdentifier) o.getDealIdentifier()))
				.put("dealSummary", ExistenceChecker.isSet((DealSummary) o.getDealSummary()))
				.put("facilityIdentifier", ExistenceChecker.isSet((FacilityIdentifier) o.getFacilityIdentifier()))
				.put("facilitySummary", ExistenceChecker.isSet((FacilitySummary) o.getFacilitySummary()))
				.put("loanBulkServicingNotificationSequenceChoice", ExistenceChecker.isSet((List<? extends LoanBulkServicingNotificationSequenceChoice>) o.getLoanBulkServicingNotificationSequenceChoice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanBulkServicingNotificationSequence", ValidationResult.ValidationType.ONLY_EXISTS, "LoanBulkServicingNotificationSequence", path, "");
		}
		return failure("LoanBulkServicingNotificationSequence", ValidationResult.ValidationType.ONLY_EXISTS, "LoanBulkServicingNotificationSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

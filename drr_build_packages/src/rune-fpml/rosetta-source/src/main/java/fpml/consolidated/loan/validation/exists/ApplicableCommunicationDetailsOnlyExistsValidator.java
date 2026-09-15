package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApplicableAssets;
import fpml.consolidated.loan.ApplicableCommunicationDetails;
import fpml.consolidated.loan.ApplicableCommunicationDetailsChoice;
import fpml.consolidated.loan.ApplicableTransactions;
import fpml.consolidated.loan.AssociationToAssetIdentifier;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ApplicableCommunicationDetailsOnlyExistsValidator implements ValidatorWithArg<ApplicableCommunicationDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ApplicableCommunicationDetails> ValidationResult<ApplicableCommunicationDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet((AssociationToAssetIdentifier) o.getIdentifier()))
				.put("applicableAssets", ExistenceChecker.isSet((ApplicableAssets) o.getApplicableAssets()))
				.put("applicableTransactions", ExistenceChecker.isSet((ApplicableTransactions) o.getApplicableTransactions()))
				.put("applicableCommunicationDetailsChoice", ExistenceChecker.isSet((List<? extends ApplicableCommunicationDetailsChoice>) o.getApplicableCommunicationDetailsChoice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ApplicableCommunicationDetails", ValidationResult.ValidationType.ONLY_EXISTS, "ApplicableCommunicationDetails", path, "");
		}
		return failure("ApplicableCommunicationDetails", ValidationResult.ValidationType.ONLY_EXISTS, "ApplicableCommunicationDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

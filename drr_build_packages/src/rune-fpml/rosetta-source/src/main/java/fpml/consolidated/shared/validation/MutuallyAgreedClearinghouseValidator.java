package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.MutuallyAgreedClearinghouse;
import fpml.consolidated.shared.OrganizationIdentifier;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MutuallyAgreedClearinghouseValidator implements Validator<MutuallyAgreedClearinghouse> {

	private List<ComparisonResult> getComparisonResults(MutuallyAgreedClearinghouse o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("identifier", (OrganizationIdentifier) o.getIdentifier() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MutuallyAgreedClearinghouse o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MutuallyAgreedClearinghouse", ValidationResult.ValidationType.CARDINALITY, "MutuallyAgreedClearinghouse", path, "", res.getError());
				}
				return success("MutuallyAgreedClearinghouse", ValidationResult.ValidationType.CARDINALITY, "MutuallyAgreedClearinghouse", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.Allocations;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AllocationsValidator implements Validator<Allocations> {

	private List<ComparisonResult> getComparisonResults(Allocations o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("allocatingPartyReference", (PartyReference) o.getAllocatingPartyReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Allocations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Allocations", ValidationResult.ValidationType.CARDINALITY, "Allocations", path, "", res.getError());
				}
				return success("Allocations", ValidationResult.ValidationType.CARDINALITY, "Allocations", path, "");
			})
			.collect(toList());
	}

}

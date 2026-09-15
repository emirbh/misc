package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityCommitment;
import fpml.consolidated.loan.FacilityPosition;
import fpml.consolidated.loan.FacilityReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FacilityPositionValidator implements Validator<FacilityPosition> {

	private List<ComparisonResult> getComparisonResults(FacilityPosition o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("facilityReference", (FacilityReference) o.getFacilityReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("commitment", (FacilityCommitment) o.getCommitment() != null ? 1 : 0, 1, 1), 
				checkCardinality("priorCommitment", (FacilityCommitment) o.getPriorCommitment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityPosition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityPosition", ValidationResult.ValidationType.CARDINALITY, "FacilityPosition", path, "", res.getError());
				}
				return success("FacilityPosition", ValidationResult.ValidationType.CARDINALITY, "FacilityPosition", path, "");
			})
			.collect(toList());
	}

}

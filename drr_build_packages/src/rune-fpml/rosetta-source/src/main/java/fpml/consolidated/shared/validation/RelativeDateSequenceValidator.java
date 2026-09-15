package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.DateReference;
import fpml.consolidated.shared.RelativeDateSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RelativeDateSequenceValidator implements Validator<RelativeDateSequence> {

	private List<ComparisonResult> getComparisonResults(RelativeDateSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateRelativeTo", (DateReference) o.getDateRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCentersReference", (BusinessCentersReference) o.getBusinessCentersReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCenters", (BusinessCenters) o.getBusinessCenters() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelativeDateSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelativeDateSequence", ValidationResult.ValidationType.CARDINALITY, "RelativeDateSequence", path, "", res.getError());
				}
				return success("RelativeDateSequence", ValidationResult.ValidationType.CARDINALITY, "RelativeDateSequence", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.StartingDate;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.DateReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class StartingDateValidator implements Validator<StartingDate> {

	private List<ComparisonResult> getComparisonResults(StartingDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateRelativeTo", (DateReference) o.getDateRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustableDate", (AdjustableDate) o.getAdjustableDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StartingDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StartingDate", ValidationResult.ValidationType.CARDINALITY, "StartingDate", path, "", res.getError());
				}
				return success("StartingDate", ValidationResult.ValidationType.CARDINALITY, "StartingDate", path, "");
			})
			.collect(toList());
	}

}

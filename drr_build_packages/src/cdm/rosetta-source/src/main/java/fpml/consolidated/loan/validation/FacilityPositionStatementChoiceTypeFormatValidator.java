package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityPositionStatementChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FacilityPositionStatementChoiceTypeFormatValidator implements Validator<FacilityPositionStatementChoice> {

	private List<ComparisonResult> getComparisonResults(FacilityPositionStatementChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityPositionStatementChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityPositionStatementChoice", ValidationResult.ValidationType.TYPE_FORMAT, "FacilityPositionStatementChoice", path, "", res.getError());
				}
				return success("FacilityPositionStatementChoice", ValidationResult.ValidationType.TYPE_FORMAT, "FacilityPositionStatementChoice", path, "");
			})
			.collect(toList());
	}

}

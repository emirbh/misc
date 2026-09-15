package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.FacilityExecutionExceptionDeclaration;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class FacilityExecutionExceptionDeclarationTypeFormatValidator implements Validator<FacilityExecutionExceptionDeclaration> {

	private List<ComparisonResult> getComparisonResults(FacilityExecutionExceptionDeclaration o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("reason", o.getReason(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityExecutionExceptionDeclaration o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityExecutionExceptionDeclaration", ValidationResult.ValidationType.TYPE_FORMAT, "FacilityExecutionExceptionDeclaration", path, "", res.getError());
				}
				return success("FacilityExecutionExceptionDeclaration", ValidationResult.ValidationType.TYPE_FORMAT, "FacilityExecutionExceptionDeclaration", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.DeliverableObligations;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class DeliverableObligationsTypeFormatValidator implements Validator<DeliverableObligations> {

	private List<ComparisonResult> getComparisonResults(DeliverableObligations o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("excluded", o.getExcluded(), 1, empty(), empty()), 
				checkString("othReferenceEntityObligations", o.getOthReferenceEntityObligations(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliverableObligations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DeliverableObligations", ValidationResult.ValidationType.TYPE_FORMAT, "DeliverableObligations", path, "", res.getError());
				}
				return success("DeliverableObligations", ValidationResult.ValidationType.TYPE_FORMAT, "DeliverableObligations", path, "");
			})
			.collect(toList());
	}

}

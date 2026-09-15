package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ValuationDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ValuationDetailsTypeFormatValidator implements Validator<ValuationDetails> {

	private List<ComparisonResult> getComparisonResults(ValuationDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationDetails", ValidationResult.ValidationType.TYPE_FORMAT, "ValuationDetails", path, "", res.getError());
				}
				return success("ValuationDetails", ValidationResult.ValidationType.TYPE_FORMAT, "ValuationDetails", path, "");
			})
			.collect(toList());
	}

}

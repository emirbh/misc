package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.ReceivedMarginOrCollateral6;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReceivedMarginOrCollateral6TypeFormatValidator implements Validator<ReceivedMarginOrCollateral6> {

	private List<ComparisonResult> getComparisonResults(ReceivedMarginOrCollateral6 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReceivedMarginOrCollateral6 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReceivedMarginOrCollateral6", ValidationResult.ValidationType.TYPE_FORMAT, "ReceivedMarginOrCollateral6", path, "", res.getError());
				}
				return success("ReceivedMarginOrCollateral6", ValidationResult.ValidationType.TYPE_FORMAT, "ReceivedMarginOrCollateral6", path, "");
			})
			.collect(toList());
	}

}

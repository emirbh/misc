package iso20022.auth108.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.hkma.tr.PostedMarginOrCollateral6__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PostedMarginOrCollateral6__1TypeFormatValidator implements Validator<PostedMarginOrCollateral6__1> {

	private List<ComparisonResult> getComparisonResults(PostedMarginOrCollateral6__1 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PostedMarginOrCollateral6__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PostedMarginOrCollateral6__1", ValidationResult.ValidationType.TYPE_FORMAT, "PostedMarginOrCollateral6__1", path, "", res.getError());
				}
				return success("PostedMarginOrCollateral6__1", ValidationResult.ValidationType.TYPE_FORMAT, "PostedMarginOrCollateral6__1", path, "");
			})
			.collect(toList());
	}

}

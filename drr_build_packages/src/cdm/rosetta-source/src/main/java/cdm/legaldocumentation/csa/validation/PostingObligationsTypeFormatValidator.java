package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.PostingObligations;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PostingObligationsTypeFormatValidator implements Validator<PostingObligations> {

	private List<ComparisonResult> getComparisonResults(PostingObligations o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PostingObligations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PostingObligations", ValidationResult.ValidationType.TYPE_FORMAT, "PostingObligations", path, "", res.getError());
				}
				return success("PostingObligations", ValidationResult.ValidationType.TYPE_FORMAT, "PostingObligations", path, "");
			})
			.collect(toList());
	}

}

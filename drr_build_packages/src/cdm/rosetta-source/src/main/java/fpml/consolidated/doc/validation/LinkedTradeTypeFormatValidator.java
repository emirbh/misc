package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.LinkedTrade;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LinkedTradeTypeFormatValidator implements Validator<LinkedTrade> {

	private List<ComparisonResult> getComparisonResults(LinkedTrade o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LinkedTrade o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LinkedTrade", ValidationResult.ValidationType.TYPE_FORMAT, "LinkedTrade", path, "", res.getError());
				}
				return success("LinkedTrade", ValidationResult.ValidationType.TYPE_FORMAT, "LinkedTrade", path, "");
			})
			.collect(toList());
	}

}

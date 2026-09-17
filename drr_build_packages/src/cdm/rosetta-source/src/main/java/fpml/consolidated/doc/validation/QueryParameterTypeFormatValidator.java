package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.QueryParameter;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class QueryParameterTypeFormatValidator implements Validator<QueryParameter> {

	private List<ComparisonResult> getComparisonResults(QueryParameter o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QueryParameter o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QueryParameter", ValidationResult.ValidationType.TYPE_FORMAT, "QueryParameter", path, "", res.getError());
				}
				return success("QueryParameter", ValidationResult.ValidationType.TYPE_FORMAT, "QueryParameter", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.QueryParameterOperator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class QueryParameterOperatorValidator implements Validator<QueryParameterOperator> {

	private List<ComparisonResult> getComparisonResults(QueryParameterOperator o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("queryParameterOperatorScheme", (String) o.getQueryParameterOperatorScheme() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QueryParameterOperator o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QueryParameterOperator", ValidationResult.ValidationType.CARDINALITY, "QueryParameterOperator", path, "", res.getError());
				}
				return success("QueryParameterOperator", ValidationResult.ValidationType.CARDINALITY, "QueryParameterOperator", path, "");
			})
			.collect(toList());
	}

}

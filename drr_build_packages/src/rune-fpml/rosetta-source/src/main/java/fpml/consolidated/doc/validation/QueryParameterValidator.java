package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.QueryParameter;
import fpml.consolidated.doc.QueryParameterId;
import fpml.consolidated.doc.QueryParameterOperator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class QueryParameterValidator implements Validator<QueryParameter> {

	private List<ComparisonResult> getComparisonResults(QueryParameter o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("queryParameterId", (QueryParameterId) o.getQueryParameterId() != null ? 1 : 0, 0, 1), 
				checkCardinality("queryParameterValue", (String) o.getQueryParameterValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("queryParameterOperator", (QueryParameterOperator) o.getQueryParameterOperator() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QueryParameter o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QueryParameter", ValidationResult.ValidationType.CARDINALITY, "QueryParameter", path, "", res.getError());
				}
				return success("QueryParameter", ValidationResult.ValidationType.CARDINALITY, "QueryParameter", path, "");
			})
			.collect(toList());
	}

}

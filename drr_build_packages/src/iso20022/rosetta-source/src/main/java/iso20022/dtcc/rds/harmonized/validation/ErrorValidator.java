package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ErrorValidator implements Validator<iso20022.dtcc.rds.harmonized.Error> {

	private List<ComparisonResult> getComparisonResults(iso20022.dtcc.rds.harmonized.Error o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("errorCode", (String) o.getErrorCode() != null ? 1 : 0, 1, 1), 
				checkCardinality("errorReason", (String) o.getErrorReason() != null ? 1 : 0, 1, 1), 
				checkCardinality("errorJurisdiction", (String) o.getErrorJurisdiction() != null ? 1 : 0, 1, 1), 
				checkCardinality("errorFor", (String) o.getErrorFor() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, iso20022.dtcc.rds.harmonized.Error o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Error", ValidationResult.ValidationType.CARDINALITY, "Error", path, "", res.getError());
				}
				return success("Error", ValidationResult.ValidationType.CARDINALITY, "Error", path, "");
			})
			.collect(toList());
	}

}

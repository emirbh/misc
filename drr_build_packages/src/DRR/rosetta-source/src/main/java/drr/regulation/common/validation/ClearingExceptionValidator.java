package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ClearingException;
import drr.regulation.common.ClearingExceptionDeclaration;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingExceptionValidator implements Validator<ClearingException> {

	private List<ComparisonResult> getComparisonResults(ClearingException o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("clearingException", (Boolean) o.getClearingException() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingExceptionDeclaration", (ClearingExceptionDeclaration) o.getClearingExceptionDeclaration() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingException o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingException", ValidationResult.ValidationType.CARDINALITY, "ClearingException", path, "", res.getError());
				}
				return success("ClearingException", ValidationResult.ValidationType.CARDINALITY, "ClearingException", path, "");
			})
			.collect(toList());
	}

}

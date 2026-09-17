package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.DividendConditions;
import fpml.consolidated.eq.shared.Return;
import fpml.consolidated.fpmlenum.ReturnTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReturnValidator implements Validator<Return> {

	private List<ComparisonResult> getComparisonResults(Return o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("returnType", (ReturnTypeEnum) o.getReturnType() != null ? 1 : 0, 1, 1), 
				checkCardinality("dividendConditions", (DividendConditions) o.getDividendConditions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Return o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Return", ValidationResult.ValidationType.CARDINALITY, "Return", path, "", res.getError());
				}
				return success("Return", ValidationResult.ValidationType.CARDINALITY, "Return", path, "");
			})
			.collect(toList());
	}

}

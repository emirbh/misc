package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.PercentageTolerance;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PercentageToleranceValidator implements Validator<PercentageTolerance> {

	private List<ComparisonResult> getComparisonResults(PercentageTolerance o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("postitive", (BigDecimal) o.getPostitive() != null ? 1 : 0, 0, 1), 
				checkCardinality("negative", (BigDecimal) o.getNegative() != null ? 1 : 0, 0, 1), 
				checkCardinality("option", (PartyReference) o.getOption() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PercentageTolerance o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PercentageTolerance", ValidationResult.ValidationType.CARDINALITY, "PercentageTolerance", path, "", res.getError());
				}
				return success("PercentageTolerance", ValidationResult.ValidationType.CARDINALITY, "PercentageTolerance", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CoalAttributePercentage;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CoalAttributePercentageValidator implements Validator<CoalAttributePercentage> {

	private List<ComparisonResult> getComparisonResults(CoalAttributePercentage o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("standardContent", (BigDecimal) o.getStandardContent() != null ? 1 : 0, 0, 1), 
				checkCardinality("rejectionLimit", (BigDecimal) o.getRejectionLimit() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalAttributePercentage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalAttributePercentage", ValidationResult.ValidationType.CARDINALITY, "CoalAttributePercentage", path, "", res.getError());
				}
				return success("CoalAttributePercentage", ValidationResult.ValidationType.CARDINALITY, "CoalAttributePercentage", path, "");
			})
			.collect(toList());
	}

}

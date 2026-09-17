package fpml.consolidated.repo.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.CollateralValuation;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CollateralValuationTypeFormatValidator implements Validator<CollateralValuation> {

	private List<ComparisonResult> getComparisonResults(CollateralValuation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("quantity", o.getQuantity(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("numberOfUnits", o.getNumberOfUnits(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralValuation", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralValuation", path, "", res.getError());
				}
				return success("CollateralValuation", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralValuation", path, "");
			})
			.collect(toList());
	}

}

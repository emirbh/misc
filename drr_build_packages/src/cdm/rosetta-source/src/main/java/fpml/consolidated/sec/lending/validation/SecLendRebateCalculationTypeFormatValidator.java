package fpml.consolidated.sec.lending.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.sec.lending.SecLendRebateCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecLendRebateCalculationTypeFormatValidator implements Validator<SecLendRebateCalculation> {

	private List<ComparisonResult> getComparisonResults(SecLendRebateCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecLendRebateCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecLendRebateCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "SecLendRebateCalculation", path, "", res.getError());
				}
				return success("SecLendRebateCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "SecLendRebateCalculation", path, "");
			})
			.collect(toList());
	}

}

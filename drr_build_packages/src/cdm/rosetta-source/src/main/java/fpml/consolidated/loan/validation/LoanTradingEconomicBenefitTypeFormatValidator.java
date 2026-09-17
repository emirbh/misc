package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanTradingEconomicBenefit;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradingEconomicBenefitTypeFormatValidator implements Validator<LoanTradingEconomicBenefit> {

	private List<ComparisonResult> getComparisonResults(LoanTradingEconomicBenefit o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingEconomicBenefit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingEconomicBenefit", ValidationResult.ValidationType.TYPE_FORMAT, "LoanTradingEconomicBenefit", path, "", res.getError());
				}
				return success("LoanTradingEconomicBenefit", ValidationResult.ValidationType.TYPE_FORMAT, "LoanTradingEconomicBenefit", path, "");
			})
			.collect(toList());
	}

}

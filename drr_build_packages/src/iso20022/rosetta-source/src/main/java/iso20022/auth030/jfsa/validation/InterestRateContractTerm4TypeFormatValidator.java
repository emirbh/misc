package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.InterestRateContractTerm4;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class InterestRateContractTerm4TypeFormatValidator implements Validator<InterestRateContractTerm4> {

	private List<ComparisonResult> getComparisonResults(InterestRateContractTerm4 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("val", o.getVal(), of(3), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRateContractTerm4 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestRateContractTerm4", ValidationResult.ValidationType.TYPE_FORMAT, "InterestRateContractTerm4", path, "", res.getError());
				}
				return success("InterestRateContractTerm4", ValidationResult.ValidationType.TYPE_FORMAT, "InterestRateContractTerm4", path, "");
			})
			.collect(toList());
	}

}

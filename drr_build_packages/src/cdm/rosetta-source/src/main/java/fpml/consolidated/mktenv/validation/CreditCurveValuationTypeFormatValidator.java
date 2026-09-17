package fpml.consolidated.mktenv.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.mktenv.CreditCurveValuation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditCurveValuationTypeFormatValidator implements Validator<CreditCurveValuation> {

	private List<ComparisonResult> getComparisonResults(CreditCurveValuation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditCurveValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditCurveValuation", ValidationResult.ValidationType.TYPE_FORMAT, "CreditCurveValuation", path, "", res.getError());
				}
				return success("CreditCurveValuation", ValidationResult.ValidationType.TYPE_FORMAT, "CreditCurveValuation", path, "");
			})
			.collect(toList());
	}

}

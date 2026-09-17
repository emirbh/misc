package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.CreditDefaultSwapChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditDefaultSwapChoiceTypeFormatValidator implements Validator<CreditDefaultSwapChoice> {

	private List<ComparisonResult> getComparisonResults(CreditDefaultSwapChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultSwapChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditDefaultSwapChoice", ValidationResult.ValidationType.TYPE_FORMAT, "CreditDefaultSwapChoice", path, "", res.getError());
				}
				return success("CreditDefaultSwapChoice", ValidationResult.ValidationType.TYPE_FORMAT, "CreditDefaultSwapChoice", path, "");
			})
			.collect(toList());
	}

}

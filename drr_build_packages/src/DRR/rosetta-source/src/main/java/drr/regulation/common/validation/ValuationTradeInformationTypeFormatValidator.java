package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ValuationTradeInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ValuationTradeInformationTypeFormatValidator implements Validator<ValuationTradeInformation> {

	private List<ComparisonResult> getComparisonResults(ValuationTradeInformation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationTradeInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationTradeInformation", ValidationResult.ValidationType.TYPE_FORMAT, "ValuationTradeInformation", path, "", res.getError());
				}
				return success("ValuationTradeInformation", ValidationResult.ValidationType.TYPE_FORMAT, "ValuationTradeInformation", path, "");
			})
			.collect(toList());
	}

}

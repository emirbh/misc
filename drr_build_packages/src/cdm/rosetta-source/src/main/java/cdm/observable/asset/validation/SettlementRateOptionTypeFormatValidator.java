package cdm.observable.asset.validation;

import cdm.observable.asset.SettlementRateOption;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SettlementRateOptionTypeFormatValidator implements Validator<SettlementRateOption> {

	private List<ComparisonResult> getComparisonResults(SettlementRateOption o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementRateOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementRateOption", ValidationResult.ValidationType.TYPE_FORMAT, "SettlementRateOption", path, "", res.getError());
				}
				return success("SettlementRateOption", ValidationResult.ValidationType.TYPE_FORMAT, "SettlementRateOption", path, "");
			})
			.collect(toList());
	}

}

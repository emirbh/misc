package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.FxCashSettlement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxCashSettlementTypeFormatValidator implements Validator<FxCashSettlement> {

	private List<ComparisonResult> getComparisonResults(FxCashSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCashSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCashSettlement", ValidationResult.ValidationType.TYPE_FORMAT, "FxCashSettlement", path, "", res.getError());
				}
				return success("FxCashSettlement", ValidationResult.ValidationType.TYPE_FORMAT, "FxCashSettlement", path, "");
			})
			.collect(toList());
	}

}

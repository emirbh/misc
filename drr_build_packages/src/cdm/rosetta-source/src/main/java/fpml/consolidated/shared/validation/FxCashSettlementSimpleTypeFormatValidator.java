package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.FxCashSettlementSimple;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxCashSettlementSimpleTypeFormatValidator implements Validator<FxCashSettlementSimple> {

	private List<ComparisonResult> getComparisonResults(FxCashSettlementSimple o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCashSettlementSimple o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCashSettlementSimple", ValidationResult.ValidationType.TYPE_FORMAT, "FxCashSettlementSimple", path, "", res.getError());
				}
				return success("FxCashSettlementSimple", ValidationResult.ValidationType.TYPE_FORMAT, "FxCashSettlementSimple", path, "");
			})
			.collect(toList());
	}

}

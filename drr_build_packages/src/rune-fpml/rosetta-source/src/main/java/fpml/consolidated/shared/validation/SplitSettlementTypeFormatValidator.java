package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.SplitSettlement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SplitSettlementTypeFormatValidator implements Validator<SplitSettlement> {

	private List<ComparisonResult> getComparisonResults(SplitSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SplitSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SplitSettlement", ValidationResult.ValidationType.TYPE_FORMAT, "SplitSettlement", path, "", res.getError());
				}
				return success("SplitSettlement", ValidationResult.ValidationType.TYPE_FORMAT, "SplitSettlement", path, "");
			})
			.collect(toList());
	}

}

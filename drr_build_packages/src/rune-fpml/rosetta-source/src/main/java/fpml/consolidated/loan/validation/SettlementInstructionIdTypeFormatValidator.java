package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.SettlementInstructionId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SettlementInstructionIdTypeFormatValidator implements Validator<SettlementInstructionId> {

	private List<ComparisonResult> getComparisonResults(SettlementInstructionId o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementInstructionId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementInstructionId", ValidationResult.ValidationType.TYPE_FORMAT, "SettlementInstructionId", path, "", res.getError());
				}
				return success("SettlementInstructionId", ValidationResult.ValidationType.TYPE_FORMAT, "SettlementInstructionId", path, "");
			})
			.collect(toList());
	}

}

package drr.base.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.TransactionReportInstructionBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TransactionReportInstructionBaseTypeFormatValidator implements Validator<TransactionReportInstructionBase> {

	private List<ComparisonResult> getComparisonResults(TransactionReportInstructionBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransactionReportInstructionBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransactionReportInstructionBase", ValidationResult.ValidationType.TYPE_FORMAT, "TransactionReportInstructionBase", path, "", res.getError());
				}
				return success("TransactionReportInstructionBase", ValidationResult.ValidationType.TYPE_FORMAT, "TransactionReportInstructionBase", path, "");
			})
			.collect(toList());
	}

}

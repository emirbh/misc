package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.TransactionReportInstruction;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TransactionReportInstructionTypeFormatValidator implements Validator<TransactionReportInstruction> {

	private List<ComparisonResult> getComparisonResults(TransactionReportInstruction o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransactionReportInstruction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransactionReportInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "TransactionReportInstruction", path, "", res.getError());
				}
				return success("TransactionReportInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "TransactionReportInstruction", path, "");
			})
			.collect(toList());
	}

}

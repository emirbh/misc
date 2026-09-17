package cdm.event.common.validation;

import cdm.event.common.BillingSummaryInstruction;
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

public class BillingSummaryInstructionTypeFormatValidator implements Validator<BillingSummaryInstruction> {

	private List<ComparisonResult> getComparisonResults(BillingSummaryInstruction o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BillingSummaryInstruction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BillingSummaryInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "BillingSummaryInstruction", path, "", res.getError());
				}
				return success("BillingSummaryInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "BillingSummaryInstruction", path, "");
			})
			.collect(toList());
	}

}

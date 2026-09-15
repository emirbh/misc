package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ValuationReportInstruction;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ValuationReportInstructionTypeFormatValidator implements Validator<ValuationReportInstruction> {

	private List<ComparisonResult> getComparisonResults(ValuationReportInstruction o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationReportInstruction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationReportInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "ValuationReportInstruction", path, "", res.getError());
				}
				return success("ValuationReportInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "ValuationReportInstruction", path, "");
			})
			.collect(toList());
	}

}

package cdm.legaldocumentation.transaction.validation;

import cdm.legaldocumentation.transaction.MasterConfirmationBase;
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

public class MasterConfirmationBaseTypeFormatValidator implements Validator<MasterConfirmationBase> {

	private List<ComparisonResult> getComparisonResults(MasterConfirmationBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterConfirmationBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterConfirmationBase", ValidationResult.ValidationType.TYPE_FORMAT, "MasterConfirmationBase", path, "", res.getError());
				}
				return success("MasterConfirmationBase", ValidationResult.ValidationType.TYPE_FORMAT, "MasterConfirmationBase", path, "");
			})
			.collect(toList());
	}

}

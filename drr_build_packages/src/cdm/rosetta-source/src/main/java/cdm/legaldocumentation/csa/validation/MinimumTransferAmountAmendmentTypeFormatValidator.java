package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.MinimumTransferAmountAmendment;
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

public class MinimumTransferAmountAmendmentTypeFormatValidator implements Validator<MinimumTransferAmountAmendment> {

	private List<ComparisonResult> getComparisonResults(MinimumTransferAmountAmendment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MinimumTransferAmountAmendment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MinimumTransferAmountAmendment", ValidationResult.ValidationType.TYPE_FORMAT, "MinimumTransferAmountAmendment", path, "", res.getError());
				}
				return success("MinimumTransferAmountAmendment", ValidationResult.ValidationType.TYPE_FORMAT, "MinimumTransferAmountAmendment", path, "");
			})
			.collect(toList());
	}

}

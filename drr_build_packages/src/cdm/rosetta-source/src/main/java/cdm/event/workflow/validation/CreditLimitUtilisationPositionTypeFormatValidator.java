package cdm.event.workflow.validation;

import cdm.event.workflow.CreditLimitUtilisationPosition;
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

public class CreditLimitUtilisationPositionTypeFormatValidator implements Validator<CreditLimitUtilisationPosition> {

	private List<ComparisonResult> getComparisonResults(CreditLimitUtilisationPosition o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditLimitUtilisationPosition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditLimitUtilisationPosition", ValidationResult.ValidationType.TYPE_FORMAT, "CreditLimitUtilisationPosition", path, "", res.getError());
				}
				return success("CreditLimitUtilisationPosition", ValidationResult.ValidationType.TYPE_FORMAT, "CreditLimitUtilisationPosition", path, "");
			})
			.collect(toList());
	}

}

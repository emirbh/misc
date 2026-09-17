package cdm.observable.asset.validation;

import cdm.observable.asset.CreditNotations;
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

public class CreditNotationsTypeFormatValidator implements Validator<CreditNotations> {

	private List<ComparisonResult> getComparisonResults(CreditNotations o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditNotations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditNotations", ValidationResult.ValidationType.TYPE_FORMAT, "CreditNotations", path, "", res.getError());
				}
				return success("CreditNotations", ValidationResult.ValidationType.TYPE_FORMAT, "CreditNotations", path, "");
			})
			.collect(toList());
	}

}

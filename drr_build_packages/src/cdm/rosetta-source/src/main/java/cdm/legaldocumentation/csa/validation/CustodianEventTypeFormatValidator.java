package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CustodianEvent;
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

public class CustodianEventTypeFormatValidator implements Validator<CustodianEvent> {

	private List<ComparisonResult> getComparisonResults(CustodianEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodianEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustodianEvent", ValidationResult.ValidationType.TYPE_FORMAT, "CustodianEvent", path, "", res.getError());
				}
				return success("CustodianEvent", ValidationResult.ValidationType.TYPE_FORMAT, "CustodianEvent", path, "");
			})
			.collect(toList());
	}

}

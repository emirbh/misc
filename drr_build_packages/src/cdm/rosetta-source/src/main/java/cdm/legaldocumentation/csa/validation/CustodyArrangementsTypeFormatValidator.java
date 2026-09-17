package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CustodyArrangements;
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

public class CustodyArrangementsTypeFormatValidator implements Validator<CustodyArrangements> {

	private List<ComparisonResult> getComparisonResults(CustodyArrangements o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodyArrangements o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustodyArrangements", ValidationResult.ValidationType.TYPE_FORMAT, "CustodyArrangements", path, "", res.getError());
				}
				return success("CustodyArrangements", ValidationResult.ValidationType.TYPE_FORMAT, "CustodyArrangements", path, "");
			})
			.collect(toList());
	}

}

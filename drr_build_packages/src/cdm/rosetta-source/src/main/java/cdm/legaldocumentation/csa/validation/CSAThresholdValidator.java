package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CSAThreshold;
import cdm.legaldocumentation.csa.ThresholdType;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CSAThresholdValidator implements Validator<CSAThreshold> {

	private List<ComparisonResult> getComparisonResults(CSAThreshold o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("thresholdType", (ThresholdType) o.getThresholdType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAThreshold o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CSAThreshold", ValidationResult.ValidationType.CARDINALITY, "CSAThreshold", path, "", res.getError());
				}
				return success("CSAThreshold", ValidationResult.ValidationType.CARDINALITY, "CSAThreshold", path, "");
			})
			.collect(toList());
	}

}

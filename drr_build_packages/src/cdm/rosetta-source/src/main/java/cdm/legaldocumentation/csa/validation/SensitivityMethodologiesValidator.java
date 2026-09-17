package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.SensitivityMethodologies;
import cdm.legaldocumentation.csa.SensitivityMethodology;
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

public class SensitivityMethodologiesValidator implements Validator<SensitivityMethodologies> {

	private List<ComparisonResult> getComparisonResults(SensitivityMethodologies o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("sensitivityToEquity", (SensitivityMethodology) o.getSensitivityToEquity() != null ? 1 : 0, 1, 1), 
				checkCardinality("sensitivityToCommodity", (SensitivityMethodology) o.getSensitivityToCommodity() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivityMethodologies o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SensitivityMethodologies", ValidationResult.ValidationType.CARDINALITY, "SensitivityMethodologies", path, "", res.getError());
				}
				return success("SensitivityMethodologies", ValidationResult.ValidationType.CARDINALITY, "SensitivityMethodologies", path, "");
			})
			.collect(toList());
	}

}

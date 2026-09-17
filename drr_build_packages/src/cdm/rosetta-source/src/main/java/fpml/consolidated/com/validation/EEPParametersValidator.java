package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.EEPParameters;
import fpml.consolidated.com.EEPRiskPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EEPParametersValidator implements Validator<EEPParameters> {

	private List<ComparisonResult> getComparisonResults(EEPParameters o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eEPApplicable", (Boolean) o.getEEPApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("riskPeriod", (EEPRiskPeriod) o.getRiskPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("equivalentApplicable", (Boolean) o.getEquivalentApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("penaltyApplicable", (Boolean) o.getPenaltyApplicable() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EEPParameters o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EEPParameters", ValidationResult.ValidationType.CARDINALITY, "EEPParameters", path, "", res.getError());
				}
				return success("EEPParameters", ValidationResult.ValidationType.CARDINALITY, "EEPParameters", path, "");
			})
			.collect(toList());
	}

}

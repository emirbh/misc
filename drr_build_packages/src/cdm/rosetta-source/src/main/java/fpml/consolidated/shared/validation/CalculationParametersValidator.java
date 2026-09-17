package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.CalculationMethodEnum;
import fpml.consolidated.shared.BusinessCentersOrReference;
import fpml.consolidated.shared.CalculationParameters;
import fpml.consolidated.shared.ObservationOffset;
import fpml.consolidated.shared.ObservationShiftParameters;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CalculationParametersValidator implements Validator<CalculationParameters> {

	private List<ComparisonResult> getComparisonResults(CalculationParameters o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationMethod", (CalculationMethodEnum) o.getCalculationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("applicableBusinessDays", (BusinessCentersOrReference) o.getApplicableBusinessDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("lookback", (ObservationOffset) o.getLookback() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationShift", (ObservationShiftParameters) o.getObservationShift() != null ? 1 : 0, 0, 1), 
				checkCardinality("lockout", (ObservationOffset) o.getLockout() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationCapRate", (BigDecimal) o.getObservationCapRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationFloorRate", (BigDecimal) o.getObservationFloorRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationParameters o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationParameters", ValidationResult.ValidationType.CARDINALITY, "CalculationParameters", path, "", res.getError());
				}
				return success("CalculationParameters", ValidationResult.ValidationType.CARDINALITY, "CalculationParameters", path, "");
			})
			.collect(toList());
	}

}

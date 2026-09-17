package cdm.observable.asset.calculatedrate.validation;

import cdm.base.datetime.BusinessCenters;
import cdm.observable.asset.calculatedrate.ObservationPeriodDatesEnum;
import cdm.observable.asset.calculatedrate.ObservationShiftCalculation;
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

public class ObservationShiftCalculationValidator implements Validator<ObservationShiftCalculation> {

	private List<ComparisonResult> getComparisonResults(ObservationShiftCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("offsetDays", (Integer) o.getOffsetDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationBase", (ObservationPeriodDatesEnum) o.getCalculationBase() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalBusinessDays", (BusinessCenters) o.getAdditionalBusinessDays() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationShiftCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservationShiftCalculation", ValidationResult.ValidationType.CARDINALITY, "ObservationShiftCalculation", path, "", res.getError());
				}
				return success("ObservationShiftCalculation", ValidationResult.ValidationType.CARDINALITY, "ObservationShiftCalculation", path, "");
			})
			.collect(toList());
	}

}

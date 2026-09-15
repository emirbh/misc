package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.ObservationPeriodDatesEnum;
import fpml.consolidated.shared.BusinessCentersOrReference;
import fpml.consolidated.shared.ObservationShiftParameters;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ObservationShiftParametersValidator implements Validator<ObservationShiftParameters> {

	private List<ComparisonResult> getComparisonResults(ObservationShiftParameters o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("offsetDays", (Integer) o.getOffsetDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationPeriodDates", (ObservationPeriodDatesEnum) o.getObservationPeriodDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalBusinessDays", (BusinessCentersOrReference) o.getAdditionalBusinessDays() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationShiftParameters o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservationShiftParameters", ValidationResult.ValidationType.CARDINALITY, "ObservationShiftParameters", path, "", res.getError());
				}
				return success("ObservationShiftParameters", ValidationResult.ValidationType.CARDINALITY, "ObservationShiftParameters", path, "");
			})
			.collect(toList());
	}

}

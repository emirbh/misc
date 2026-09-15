package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.EarlyTerminationProvision;
import fpml.consolidated.ird.ExercisePeriod;
import fpml.consolidated.ird.MandatoryEarlyTermination;
import fpml.consolidated.ird.OptionalEarlyTermination;
import fpml.consolidated.shared.Period;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EarlyTerminationProvisionValidator implements Validator<EarlyTerminationProvision> {

	private List<ComparisonResult> getComparisonResults(EarlyTerminationProvision o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("mandatoryEarlyTermination", (MandatoryEarlyTermination) o.getMandatoryEarlyTermination() != null ? 1 : 0, 0, 1), 
				checkCardinality("mandatoryEarlyTerminationDateTenor", (Period) o.getMandatoryEarlyTerminationDateTenor() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionalEarlyTermination", (OptionalEarlyTermination) o.getOptionalEarlyTermination() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionalEarlyTerminationParameters", (ExercisePeriod) o.getOptionalEarlyTerminationParameters() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EarlyTerminationProvision o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EarlyTerminationProvision", ValidationResult.ValidationType.CARDINALITY, "EarlyTerminationProvision", path, "", res.getError());
				}
				return success("EarlyTerminationProvision", ValidationResult.ValidationType.CARDINALITY, "EarlyTerminationProvision", path, "");
			})
			.collect(toList());
	}

}

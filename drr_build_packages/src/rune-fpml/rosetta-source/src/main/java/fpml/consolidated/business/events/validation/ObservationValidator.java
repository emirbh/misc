package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.Observation;
import fpml.consolidated.business.events.ObservationReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ObservationValidator implements Validator<Observation> {

	private List<ComparisonResult> getComparisonResults(Observation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationReference", (ObservationReference) o.getObservationReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("weight", (BigDecimal) o.getWeight() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Observation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Observation", ValidationResult.ValidationType.CARDINALITY, "Observation", path, "", res.getError());
				}
				return success("Observation", ValidationResult.ValidationType.CARDINALITY, "Observation", path, "");
			})
			.collect(toList());
	}

}

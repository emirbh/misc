package cdm.event.common.validation;

import cdm.event.common.CorporateAction;
import cdm.event.common.CreditEvent;
import cdm.event.common.ObservationEvent;
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

public class ObservationEventValidator implements Validator<ObservationEvent> {

	private List<ComparisonResult> getComparisonResults(ObservationEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("creditEvent", (CreditEvent) o.getCreditEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("corporateAction", (CorporateAction) o.getCorporateAction() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservationEvent", ValidationResult.ValidationType.CARDINALITY, "ObservationEvent", path, "", res.getError());
				}
				return success("ObservationEvent", ValidationResult.ValidationType.CARDINALITY, "ObservationEvent", path, "");
			})
			.collect(toList());
	}

}

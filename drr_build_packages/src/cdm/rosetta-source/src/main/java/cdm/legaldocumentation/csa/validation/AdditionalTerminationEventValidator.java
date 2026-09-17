package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.AdditionalTerminationEvent;
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

public class AdditionalTerminationEventValidator implements Validator<AdditionalTerminationEvent> {

	private List<ComparisonResult> getComparisonResults(AdditionalTerminationEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 1, 1), 
				checkCardinality("applicableParty", (List<CounterpartyRoleEnum>) o.getApplicableParty() == null ? 0 : o.getApplicableParty().size(), 1, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalTerminationEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdditionalTerminationEvent", ValidationResult.ValidationType.CARDINALITY, "AdditionalTerminationEvent", path, "", res.getError());
				}
				return success("AdditionalTerminationEvent", ValidationResult.ValidationType.CARDINALITY, "AdditionalTerminationEvent", path, "");
			})
			.collect(toList());
	}

}

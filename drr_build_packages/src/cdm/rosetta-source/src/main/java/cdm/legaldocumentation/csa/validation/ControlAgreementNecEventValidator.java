package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.ControlAgreementNecEvent;
import cdm.legaldocumentation.csa.ControlAgreementNecEventElection;
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

public class ControlAgreementNecEventValidator implements Validator<ControlAgreementNecEvent> {

	private List<ComparisonResult> getComparisonResults(ControlAgreementNecEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("controlAgreementNecEventElection", (List<? extends ControlAgreementNecEventElection>) o.getControlAgreementNecEventElection() == null ? 0 : o.getControlAgreementNecEventElection().size(), 2, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ControlAgreementNecEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ControlAgreementNecEvent", ValidationResult.ValidationType.CARDINALITY, "ControlAgreementNecEvent", path, "", res.getError());
				}
				return success("ControlAgreementNecEvent", ValidationResult.ValidationType.CARDINALITY, "ControlAgreementNecEvent", path, "");
			})
			.collect(toList());
	}

}

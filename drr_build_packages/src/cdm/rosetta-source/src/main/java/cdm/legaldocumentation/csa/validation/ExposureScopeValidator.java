package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.ExposureScope;
import cdm.legaldocumentation.csa.LegacyExposureScopeElection;
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

public class ExposureScopeValidator implements Validator<ExposureScope> {

	private List<ComparisonResult> getComparisonResults(ExposureScope o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyElection", (List<? extends LegacyExposureScopeElection>) o.getPartyElection() == null ? 0 : o.getPartyElection().size(), 0, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExposureScope o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExposureScope", ValidationResult.ValidationType.CARDINALITY, "ExposureScope", path, "", res.getError());
				}
				return success("ExposureScope", ValidationResult.ValidationType.CARDINALITY, "ExposureScope", path, "");
			})
			.collect(toList());
	}

}

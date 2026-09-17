package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.RegulatorId;
import fpml.consolidated.doc.SupervisorRegistration;
import fpml.consolidated.shared.SupervisoryBody;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SupervisorRegistrationValidator implements Validator<SupervisorRegistration> {

	private List<ComparisonResult> getComparisonResults(SupervisorRegistration o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("supervisoryBody", (SupervisoryBody) o.getSupervisoryBody() != null ? 1 : 0, 1, 1), 
				checkCardinality("registrationNumber", (RegulatorId) o.getRegistrationNumber() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SupervisorRegistration o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SupervisorRegistration", ValidationResult.ValidationType.CARDINALITY, "SupervisorRegistration", path, "", res.getError());
				}
				return success("SupervisorRegistration", ValidationResult.ValidationType.CARDINALITY, "SupervisorRegistration", path, "");
			})
			.collect(toList());
	}

}

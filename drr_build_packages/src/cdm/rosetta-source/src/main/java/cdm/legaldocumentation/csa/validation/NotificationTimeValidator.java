package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.NotificationTime;
import cdm.legaldocumentation.csa.NotificationTimeElection;
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

public class NotificationTimeValidator implements Validator<NotificationTime> {

	private List<ComparisonResult> getComparisonResults(NotificationTime o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyElections", (List<? extends NotificationTimeElection>) o.getPartyElections() == null ? 0 : o.getPartyElections().size(), 2, 2), 
				checkCardinality("disputeNotificationReference", (Boolean) o.getDisputeNotificationReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("transferTimingProviso", (Boolean) o.getTransferTimingProviso() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotificationTime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotificationTime", ValidationResult.ValidationType.CARDINALITY, "NotificationTime", path, "", res.getError());
				}
				return success("NotificationTime", ValidationResult.ValidationType.CARDINALITY, "NotificationTime", path, "");
			})
			.collect(toList());
	}

}

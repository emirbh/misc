package cdm.legaldocumentation.csa.validation;

import cdm.base.datetime.BusinessCenterTime;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
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

public class NotificationTimeElectionValidator implements Validator<NotificationTimeElection> {

	private List<ComparisonResult> getComparisonResults(NotificationTimeElection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (CounterpartyRoleEnum) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("notificationTime", (BusinessCenterTime) o.getNotificationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("customNotification", (String) o.getCustomNotification() != null ? 1 : 0, 0, 1), 
				checkCardinality("localBusinessDay", (Boolean) o.getLocalBusinessDay() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotificationTimeElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotificationTimeElection", ValidationResult.ValidationType.CARDINALITY, "NotificationTimeElection", path, "", res.getError());
				}
				return success("NotificationTimeElection", ValidationResult.ValidationType.CARDINALITY, "NotificationTimeElection", path, "");
			})
			.collect(toList());
	}

}

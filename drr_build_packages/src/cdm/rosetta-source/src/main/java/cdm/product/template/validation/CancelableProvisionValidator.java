package cdm.product.template.validation;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.BusinessCenterTime;
import cdm.base.datetime.Period;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.event.common.Transfer;
import cdm.product.template.CallingPartyEnum;
import cdm.product.template.CancelableProvision;
import cdm.product.template.CancelableProvisionAdjustedDates;
import cdm.product.template.ExerciseNotice;
import cdm.product.template.ExerciseTerms;
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

public class CancelableProvisionValidator implements Validator<CancelableProvision> {

	private List<ComparisonResult> getComparisonResults(CancelableProvision o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("buyer", (CounterpartyRoleEnum) o.getBuyer() != null ? 1 : 0, 1, 1), 
				checkCardinality("seller", (CounterpartyRoleEnum) o.getSeller() != null ? 1 : 0, 1, 1), 
				checkCardinality("exerciseNotice", (ExerciseNotice) o.getExerciseNotice() != null ? 1 : 0, 0, 1), 
				checkCardinality("followUpConfirmation", (Boolean) o.getFollowUpConfirmation() != null ? 1 : 0, 1, 1), 
				checkCardinality("cancelableProvisionAdjustedDates", (CancelableProvisionAdjustedDates) o.getCancelableProvisionAdjustedDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialFee", (Transfer) o.getInitialFee() != null ? 1 : 0, 0, 1), 
				checkCardinality("callingParty", (CallingPartyEnum) o.getCallingParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("earliestDate", (AdjustableOrRelativeDate) o.getEarliestDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDate", (AdjustableOrRelativeDate) o.getExpirationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDates) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectivePeriod", (Period) o.getEffectivePeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("earliestCancellationTime", (BusinessCenterTime) o.getEarliestCancellationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestCancelationTime", (BusinessCenterTime) o.getLatestCancelationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseTerms", (ExerciseTerms) o.getExerciseTerms() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CancelableProvision o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CancelableProvision", ValidationResult.ValidationType.CARDINALITY, "CancelableProvision", path, "", res.getError());
				}
				return success("CancelableProvision", ValidationResult.ValidationType.CARDINALITY, "CancelableProvision", path, "");
			})
			.collect(toList());
	}

}

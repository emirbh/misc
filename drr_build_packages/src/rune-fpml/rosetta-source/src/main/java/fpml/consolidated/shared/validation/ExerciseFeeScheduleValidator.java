package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AmountSchedule;
import fpml.consolidated.shared.ExerciseFeeSchedule;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.Schedule;
import fpml.consolidated.shared.ScheduleReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExerciseFeeScheduleValidator implements Validator<ExerciseFeeSchedule> {

	private List<ComparisonResult> getComparisonResults(ExerciseFeeSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalReference", (ScheduleReference) o.getNotionalReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("feeAmountSchedule", (AmountSchedule) o.getFeeAmountSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("feeRateSchedule", (Schedule) o.getFeeRateSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("feePaymentDate", (RelativeDateOffset) o.getFeePaymentDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseFeeSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExerciseFeeSchedule", ValidationResult.ValidationType.CARDINALITY, "ExerciseFeeSchedule", path, "", res.getError());
				}
				return success("ExerciseFeeSchedule", ValidationResult.ValidationType.CARDINALITY, "ExerciseFeeSchedule", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.RequestedWithdrawalAction;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.doc.Trade;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class WithdrawalValidator implements Validator<Withdrawal> {

	private List<ComparisonResult> getComparisonResults(Withdrawal o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("trade", (Trade) o.getTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("requestedAction", (RequestedWithdrawalAction) o.getRequestedAction() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Withdrawal o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Withdrawal", ValidationResult.ValidationType.CARDINALITY, "Withdrawal", path, "", res.getError());
				}
				return success("Withdrawal", ValidationResult.ValidationType.CARDINALITY, "Withdrawal", path, "");
			})
			.collect(toList());
	}

}

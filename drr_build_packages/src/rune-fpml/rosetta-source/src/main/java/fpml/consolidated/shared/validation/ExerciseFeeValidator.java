package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.ExerciseFee;
import fpml.consolidated.shared.NotionalReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelativeDateOffset;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExerciseFeeValidator implements Validator<ExerciseFee> {

	private List<ComparisonResult> getComparisonResults(ExerciseFee o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalReference", (NotionalReference) o.getNotionalReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("feeAmount", (BigDecimal) o.getFeeAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("feeRate", (BigDecimal) o.getFeeRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("feePaymentDate", (RelativeDateOffset) o.getFeePaymentDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseFee o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExerciseFee", ValidationResult.ValidationType.CARDINALITY, "ExerciseFee", path, "", res.getError());
				}
				return success("ExerciseFee", ValidationResult.ValidationType.CARDINALITY, "ExerciseFee", path, "");
			})
			.collect(toList());
	}

}

package cdm.product.template.validation;

import cdm.base.datetime.RelativeDateOffset;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.observable.asset.metafields.ReferenceWithMetaMoney;
import cdm.product.template.ExerciseFee;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
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
				checkCardinality("payer", (CounterpartyRoleEnum) o.getPayer() != null ? 1 : 0, 1, 1), 
				checkCardinality("receiver", (CounterpartyRoleEnum) o.getReceiver() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalReference", (ReferenceWithMetaMoney) o.getNotionalReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("feeAmount", (BigDecimal) o.getFeeAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("feeRate", (BigDecimal) o.getFeeRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("feePaymentDate", (RelativeDateOffset) o.getFeePaymentDate() != null ? 1 : 0, 1, 1)
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

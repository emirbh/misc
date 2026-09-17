package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.CashSettlementPaymentDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CashSettlementPaymentDateTypeFormatValidator implements Validator<CashSettlementPaymentDate> {

	private List<ComparisonResult> getComparisonResults(CashSettlementPaymentDate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashSettlementPaymentDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CashSettlementPaymentDate", ValidationResult.ValidationType.TYPE_FORMAT, "CashSettlementPaymentDate", path, "", res.getError());
				}
				return success("CashSettlementPaymentDate", ValidationResult.ValidationType.TYPE_FORMAT, "CashSettlementPaymentDate", path, "");
			})
			.collect(toList());
	}

}

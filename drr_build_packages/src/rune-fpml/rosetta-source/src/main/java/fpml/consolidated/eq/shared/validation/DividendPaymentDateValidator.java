package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.DividendPaymentDate;
import fpml.consolidated.fpmlenum.DividendDateReferenceEnum;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.Offset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DividendPaymentDateValidator implements Validator<DividendPaymentDate> {

	private List<ComparisonResult> getComparisonResults(DividendPaymentDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dividendDateReference", (DividendDateReferenceEnum) o.getDividendDateReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDateOffset", (Offset) o.getPaymentDateOffset() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustableDate", (AdjustableDate) o.getAdjustableDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPaymentDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendPaymentDate", ValidationResult.ValidationType.CARDINALITY, "DividendPaymentDate", path, "", res.getError());
				}
				return success("DividendPaymentDate", ValidationResult.ValidationType.CARDINALITY, "DividendPaymentDate", path, "");
			})
			.collect(toList());
	}

}

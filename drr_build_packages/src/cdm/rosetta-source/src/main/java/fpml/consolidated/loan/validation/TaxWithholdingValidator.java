package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.TaxWithholding;
import fpml.consolidated.loan.WithholdingTaxReason;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TaxWithholdingValidator implements Validator<TaxWithholding> {

	private List<ComparisonResult> getComparisonResults(TaxWithholding o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amount", (NonNegativeMoney) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("taxRate", (BigDecimal) o.getTaxRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("reason", (WithholdingTaxReason) o.getReason() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TaxWithholding o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TaxWithholding", ValidationResult.ValidationType.CARDINALITY, "TaxWithholding", path, "", res.getError());
				}
				return success("TaxWithholding", ValidationResult.ValidationType.CARDINALITY, "TaxWithholding", path, "");
			})
			.collect(toList());
	}

}

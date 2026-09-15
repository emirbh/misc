package fpml.consolidated.dividend.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class DividendSwapOptionTransactionSupplementTypeFormatValidator implements Validator<DividendSwapOptionTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(DividendSwapOptionTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("optionEntitlement", o.getOptionEntitlement(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("multiplier", o.getMultiplier(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendSwapOptionTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendSwapOptionTransactionSupplement", ValidationResult.ValidationType.TYPE_FORMAT, "DividendSwapOptionTransactionSupplement", path, "", res.getError());
				}
				return success("DividendSwapOptionTransactionSupplement", ValidationResult.ValidationType.TYPE_FORMAT, "DividendSwapOptionTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.CashflowNotional;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CashflowNotionalValidator implements Validator<CashflowNotional> {

	private List<ComparisonResult> getComparisonResults(CashflowNotional o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("units", (String) o.getUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("amount", (BigDecimal) o.getAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashflowNotional o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CashflowNotional", ValidationResult.ValidationType.CARDINALITY, "CashflowNotional", path, "", res.getError());
				}
				return success("CashflowNotional", ValidationResult.ValidationType.CARDINALITY, "CashflowNotional", path, "");
			})
			.collect(toList());
	}

}

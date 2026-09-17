package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.CashSettlementTerms;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CashSettlementTermsTypeFormatValidator implements Validator<CashSettlementTerms> {

	private List<ComparisonResult> getComparisonResults(CashSettlementTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("dealer", o.getDealer(), 1, empty(), empty()), 
				checkNumber("cashSettlementBusinessDays", o.getCashSettlementBusinessDays(), empty(), of(0), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashSettlementTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CashSettlementTerms", ValidationResult.ValidationType.TYPE_FORMAT, "CashSettlementTerms", path, "", res.getError());
				}
				return success("CashSettlementTerms", ValidationResult.ValidationType.TYPE_FORMAT, "CashSettlementTerms", path, "");
			})
			.collect(toList());
	}

}

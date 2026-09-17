package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.AccountingStandardEnum;
import fpml.consolidated.fpmlenum.InventoryAccountingMethodEnum;
import fpml.consolidated.loan.LoanCovenantObligationAccountingDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationAccountingDetailsValidator implements Validator<LoanCovenantObligationAccountingDetails> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationAccountingDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accountingStandard", (AccountingStandardEnum) o.getAccountingStandard() != null ? 1 : 0, 1, 1), 
				checkCardinality("inventoryMethod", (InventoryAccountingMethodEnum) o.getInventoryMethod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationAccountingDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationAccountingDetails", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationAccountingDetails", path, "", res.getError());
				}
				return success("LoanCovenantObligationAccountingDetails", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationAccountingDetails", path, "");
			})
			.collect(toList());
	}

}

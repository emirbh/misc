package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.PartySelector;
import fpml.consolidated.ird.ReplacementValueCalculationAgentDeterminationMethod;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReplacementValueCalculationAgentDeterminationMethodValidator implements Validator<ReplacementValueCalculationAgentDeterminationMethod> {

	private List<ComparisonResult> getComparisonResults(ReplacementValueCalculationAgentDeterminationMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashSettlementCurrency", (Currency) o.getCashSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlementReferenceBanks", (CashSettlementReferenceBanks) o.getCashSettlementReferenceBanks() != null ? 1 : 0, 0, 1), 
				checkCardinality("protectedParty", (PartySelector) o.getProtectedParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashCollateralCurrency", (Currency) o.getCashCollateralCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReplacementValueCalculationAgentDeterminationMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReplacementValueCalculationAgentDeterminationMethod", ValidationResult.ValidationType.CARDINALITY, "ReplacementValueCalculationAgentDeterminationMethod", path, "", res.getError());
				}
				return success("ReplacementValueCalculationAgentDeterminationMethod", ValidationResult.ValidationType.CARDINALITY, "ReplacementValueCalculationAgentDeterminationMethod", path, "");
			})
			.collect(toList());
	}

}

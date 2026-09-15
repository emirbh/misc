package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CashSettlementReferenceBanksValidator implements Validator<CashSettlementReferenceBanks> {

	private List<ComparisonResult> getComparisonResults(CashSettlementReferenceBanks o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashSettlementReferenceBanks o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CashSettlementReferenceBanks", ValidationResult.ValidationType.CARDINALITY, "CashSettlementReferenceBanks", path, "", res.getError());
				}
				return success("CashSettlementReferenceBanks", ValidationResult.ValidationType.CARDINALITY, "CashSettlementReferenceBanks", path, "");
			})
			.collect(toList());
	}

}

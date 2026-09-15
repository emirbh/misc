package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.SettlementDetails;
import fpml.consolidated.loan.SettlementInstructionId;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.SettlementInstruction;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SettlementDetailsValidator implements Validator<SettlementDetails> {

	private List<ComparisonResult> getComparisonResults(SettlementDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (SettlementInstructionId) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementInstruction", (SettlementInstruction) o.getSettlementInstruction() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementDetails", ValidationResult.ValidationType.CARDINALITY, "SettlementDetails", path, "", res.getError());
				}
				return success("SettlementDetails", ValidationResult.ValidationType.CARDINALITY, "SettlementDetails", path, "");
			})
			.collect(toList());
	}

}

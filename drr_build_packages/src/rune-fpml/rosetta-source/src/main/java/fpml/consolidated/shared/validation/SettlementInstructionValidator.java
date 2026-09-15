package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Beneficiary;
import fpml.consolidated.shared.CorrespondentInformation;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SettlementInstruction;
import fpml.consolidated.shared.SettlementMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SettlementInstructionValidator implements Validator<SettlementInstruction> {

	private List<ComparisonResult> getComparisonResults(SettlementInstruction o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementMethod", (SettlementMethod) o.getSettlementMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("correspondentInformation", (CorrespondentInformation) o.getCorrespondentInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("beneficiaryBank", (Beneficiary) o.getBeneficiaryBank() != null ? 1 : 0, 0, 1), 
				checkCardinality("beneficiary", (Beneficiary) o.getBeneficiary() != null ? 1 : 0, 0, 1), 
				checkCardinality("depositoryPartyReference", (PartyReference) o.getDepositoryPartyReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementInstruction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementInstruction", ValidationResult.ValidationType.CARDINALITY, "SettlementInstruction", path, "", res.getError());
				}
				return success("SettlementInstruction", ValidationResult.ValidationType.CARDINALITY, "SettlementInstruction", path, "");
			})
			.collect(toList());
	}

}

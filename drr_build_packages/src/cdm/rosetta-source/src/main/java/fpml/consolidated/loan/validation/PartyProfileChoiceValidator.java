package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApplicableCommunicationDetails;
import fpml.consolidated.loan.ApplicableSettlementInstructionDetails;
import fpml.consolidated.loan.PartyProfileChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyProfileChoiceValidator implements Validator<PartyProfileChoice> {

	private List<ComparisonResult> getComparisonResults(PartyProfileChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("communicationDetails", (ApplicableCommunicationDetails) o.getCommunicationDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementInstructionDetails", (ApplicableSettlementInstructionDetails) o.getSettlementInstructionDetails() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyProfileChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyProfileChoice", ValidationResult.ValidationType.CARDINALITY, "PartyProfileChoice", path, "", res.getError());
				}
				return success("PartyProfileChoice", ValidationResult.ValidationType.CARDINALITY, "PartyProfileChoice", path, "");
			})
			.collect(toList());
	}

}

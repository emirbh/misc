package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.ReturnSwapEarlyTermination;
import fpml.consolidated.eq.shared.StartingDate;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReturnSwapEarlyTerminationValidator implements Validator<ReturnSwapEarlyTermination> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapEarlyTermination o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("startingDate", (StartingDate) o.getStartingDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapEarlyTermination o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapEarlyTermination", ValidationResult.ValidationType.CARDINALITY, "ReturnSwapEarlyTermination", path, "", res.getError());
				}
				return success("ReturnSwapEarlyTermination", ValidationResult.ValidationType.CARDINALITY, "ReturnSwapEarlyTermination", path, "");
			})
			.collect(toList());
	}

}

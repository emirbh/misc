package cdm.legaldocumentation.master.isda.validation;

import cdm.base.staticdata.party.Party;
import cdm.legaldocumentation.master.isda.AutomaticEarlyTerminationElection;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AutomaticEarlyTerminationElectionValidator implements Validator<AutomaticEarlyTerminationElection> {

	private List<ComparisonResult> getComparisonResults(AutomaticEarlyTerminationElection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (Party) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("isApplicable", (Boolean) o.getIsApplicable() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AutomaticEarlyTerminationElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AutomaticEarlyTerminationElection", ValidationResult.ValidationType.CARDINALITY, "AutomaticEarlyTerminationElection", path, "", res.getError());
				}
				return success("AutomaticEarlyTerminationElection", ValidationResult.ValidationType.CARDINALITY, "AutomaticEarlyTerminationElection", path, "");
			})
			.collect(toList());
	}

}

package cdm.legaldocumentation.master.isda.validation;

import cdm.legaldocumentation.master.isda.AutomaticEarlyTermination;
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

public class AutomaticEarlyTerminationValidator implements Validator<AutomaticEarlyTermination> {

	private List<ComparisonResult> getComparisonResults(AutomaticEarlyTermination o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fallbackAET", (Boolean) o.getFallbackAET() != null ? 1 : 0, 1, 1), 
				checkCardinality("indemnity", (Boolean) o.getIndemnity() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyElection", (List<? extends AutomaticEarlyTerminationElection>) o.getPartyElection() == null ? 0 : o.getPartyElection().size(), 0, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AutomaticEarlyTermination o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AutomaticEarlyTermination", ValidationResult.ValidationType.CARDINALITY, "AutomaticEarlyTermination", path, "", res.getError());
				}
				return success("AutomaticEarlyTermination", ValidationResult.ValidationType.CARDINALITY, "AutomaticEarlyTermination", path, "");
			})
			.collect(toList());
	}

}

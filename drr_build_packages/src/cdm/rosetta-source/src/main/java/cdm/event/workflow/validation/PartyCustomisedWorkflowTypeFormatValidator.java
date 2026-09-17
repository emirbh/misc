package cdm.event.workflow.validation;

import cdm.event.workflow.PartyCustomisedWorkflow;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyCustomisedWorkflowTypeFormatValidator implements Validator<PartyCustomisedWorkflow> {

	private List<ComparisonResult> getComparisonResults(PartyCustomisedWorkflow o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyCustomisedWorkflow o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyCustomisedWorkflow", ValidationResult.ValidationType.TYPE_FORMAT, "PartyCustomisedWorkflow", path, "", res.getError());
				}
				return success("PartyCustomisedWorkflow", ValidationResult.ValidationType.TYPE_FORMAT, "PartyCustomisedWorkflow", path, "");
			})
			.collect(toList());
	}

}

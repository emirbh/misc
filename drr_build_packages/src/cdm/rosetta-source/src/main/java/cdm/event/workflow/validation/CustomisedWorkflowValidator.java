package cdm.event.workflow.validation;

import cdm.event.workflow.CustomisedWorkflow;
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

public class CustomisedWorkflowValidator implements Validator<CustomisedWorkflow> {

	private List<ComparisonResult> getComparisonResults(CustomisedWorkflow o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("itemName", (String) o.getItemName() != null ? 1 : 0, 1, 1), 
				checkCardinality("itemValue", (String) o.getItemValue() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustomisedWorkflow o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustomisedWorkflow", ValidationResult.ValidationType.CARDINALITY, "CustomisedWorkflow", path, "", res.getError());
				}
				return success("CustomisedWorkflow", ValidationResult.ValidationType.CARDINALITY, "CustomisedWorkflow", path, "");
			})
			.collect(toList());
	}

}

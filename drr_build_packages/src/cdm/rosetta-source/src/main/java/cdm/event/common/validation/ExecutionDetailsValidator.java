package cdm.event.common.validation;

import cdm.base.staticdata.identifier.IdentifiedList;
import cdm.base.staticdata.party.LegalEntity;
import cdm.event.common.ExecutionDetails;
import cdm.event.common.ExecutionTypeEnum;
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

public class ExecutionDetailsValidator implements Validator<ExecutionDetails> {

	private List<ComparisonResult> getComparisonResults(ExecutionDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("executionType", (ExecutionTypeEnum) o.getExecutionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("executionVenue", (LegalEntity) o.getExecutionVenue() != null ? 1 : 0, 0, 1), 
				checkCardinality("packageReference", (IdentifiedList) o.getPackageReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExecutionDetails", ValidationResult.ValidationType.CARDINALITY, "ExecutionDetails", path, "", res.getError());
				}
				return success("ExecutionDetails", ValidationResult.ValidationType.CARDINALITY, "ExecutionDetails", path, "");
			})
			.collect(toList());
	}

}

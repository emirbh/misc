package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExerciseNoticeValidator implements Validator<ExerciseNotice> {

	private List<ComparisonResult> getComparisonResults(ExerciseNotice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseNoticePartyReference", (PartyReference) o.getExerciseNoticePartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCenter", (BusinessCenter) o.getBusinessCenter() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseNotice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExerciseNotice", ValidationResult.ValidationType.CARDINALITY, "ExerciseNotice", path, "", res.getError());
				}
				return success("ExerciseNotice", ValidationResult.ValidationType.CARDINALITY, "ExerciseNotice", path, "");
			})
			.collect(toList());
	}

}

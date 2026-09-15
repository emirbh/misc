package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.ExerciseDate1Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExerciseDate1Choice__1Validator implements Validator<ExerciseDate1Choice__1> {

	private List<ComparisonResult> getComparisonResults(ExerciseDate1Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("frstExrcDt", (Date) o.getFrstExrcDt() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseDate1Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExerciseDate1Choice__1", ValidationResult.ValidationType.CARDINALITY, "ExerciseDate1Choice__1", path, "", res.getError());
				}
				return success("ExerciseDate1Choice__1", ValidationResult.ValidationType.CARDINALITY, "ExerciseDate1Choice__1", path, "");
			})
			.collect(toList());
	}

}

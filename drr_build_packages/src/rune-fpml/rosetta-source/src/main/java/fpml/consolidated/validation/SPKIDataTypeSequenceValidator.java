package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.SPKIDataTypeSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SPKIDataTypeSequenceValidator implements Validator<SPKIDataTypeSequence> {

	private List<ComparisonResult> getComparisonResults(SPKIDataTypeSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("spkiSexp", (String) o.getSpkiSexp() != null ? 1 : 0, 1, 1), 
				checkCardinality("anyContents", (String) o.getAnyContents() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SPKIDataTypeSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SPKIDataTypeSequence", ValidationResult.ValidationType.CARDINALITY, "SPKIDataTypeSequence", path, "", res.getError());
				}
				return success("SPKIDataTypeSequence", ValidationResult.ValidationType.CARDINALITY, "SPKIDataTypeSequence", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.SPKIDataType;
import fpml.consolidated.SPKIDataTypeSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SPKIDataTypeValidator implements Validator<SPKIDataType> {

	private List<ComparisonResult> getComparisonResults(SPKIDataType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("spkiDataTypeSequence", (List<? extends SPKIDataTypeSequence>) o.getSpkiDataTypeSequence() == null ? 0 : o.getSpkiDataTypeSequence().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SPKIDataType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SPKIDataType", ValidationResult.ValidationType.CARDINALITY, "SPKIDataType", path, "", res.getError());
				}
				return success("SPKIDataType", ValidationResult.ValidationType.CARDINALITY, "SPKIDataType", path, "");
			})
			.collect(toList());
	}

}

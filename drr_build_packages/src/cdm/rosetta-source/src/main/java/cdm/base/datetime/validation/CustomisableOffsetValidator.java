package cdm.base.datetime.validation;

import cdm.base.datetime.CustomisableOffset;
import cdm.base.datetime.Offset;
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

public class CustomisableOffsetValidator implements Validator<CustomisableOffset> {

	private List<ComparisonResult> getComparisonResults(CustomisableOffset o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("offset", (Offset) o.getOffset() != null ? 1 : 0, 0, 1), 
				checkCardinality("customProvision", (String) o.getCustomProvision() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustomisableOffset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustomisableOffset", ValidationResult.ValidationType.CARDINALITY, "CustomisableOffset", path, "", res.getError());
				}
				return success("CustomisableOffset", ValidationResult.ValidationType.CARDINALITY, "CustomisableOffset", path, "");
			})
			.collect(toList());
	}

}

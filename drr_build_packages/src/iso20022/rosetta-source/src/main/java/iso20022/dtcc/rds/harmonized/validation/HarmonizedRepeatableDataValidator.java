package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.HarmonizedRepeatableData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class HarmonizedRepeatableDataValidator implements Validator<HarmonizedRepeatableData> {

	private List<ComparisonResult> getComparisonResults(HarmonizedRepeatableData o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, HarmonizedRepeatableData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("HarmonizedRepeatableData", ValidationResult.ValidationType.CARDINALITY, "HarmonizedRepeatableData", path, "", res.getError());
				}
				return success("HarmonizedRepeatableData", ValidationResult.ValidationType.CARDINALITY, "HarmonizedRepeatableData", path, "");
			})
			.collect(toList());
	}

}

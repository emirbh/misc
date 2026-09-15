package drr.enrichment.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.upi.UpiData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class UpiDataTypeFormatValidator implements Validator<UpiData> {

	private List<ComparisonResult> getComparisonResults(UpiData o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UpiData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UpiData", ValidationResult.ValidationType.TYPE_FORMAT, "UpiData", path, "", res.getError());
				}
				return success("UpiData", ValidationResult.ValidationType.TYPE_FORMAT, "UpiData", path, "");
			})
			.collect(toList());
	}

}

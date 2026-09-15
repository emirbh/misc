package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbCommodities;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbCommoditiesTypeFormatValidator implements Validator<AnnaDsbCommodities> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbCommodities o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbCommodities o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbCommodities", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbCommodities", path, "", res.getError());
				}
				return success("AnnaDsbCommodities", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbCommodities", path, "");
			})
			.collect(toList());
	}

}

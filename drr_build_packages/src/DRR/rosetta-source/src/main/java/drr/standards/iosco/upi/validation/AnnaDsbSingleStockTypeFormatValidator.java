package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbSingleStock;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbSingleStockTypeFormatValidator implements Validator<AnnaDsbSingleStock> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbSingleStock o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbSingleStock o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbSingleStock", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbSingleStock", path, "", res.getError());
				}
				return success("AnnaDsbSingleStock", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbSingleStock", path, "");
			})
			.collect(toList());
	}

}

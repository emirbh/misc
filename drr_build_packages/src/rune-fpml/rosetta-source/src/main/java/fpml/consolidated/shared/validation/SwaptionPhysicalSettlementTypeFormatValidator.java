package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SwaptionPhysicalSettlementTypeFormatValidator implements Validator<SwaptionPhysicalSettlement> {

	private List<ComparisonResult> getComparisonResults(SwaptionPhysicalSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SwaptionPhysicalSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SwaptionPhysicalSettlement", ValidationResult.ValidationType.TYPE_FORMAT, "SwaptionPhysicalSettlement", path, "", res.getError());
				}
				return success("SwaptionPhysicalSettlement", ValidationResult.ValidationType.TYPE_FORMAT, "SwaptionPhysicalSettlement", path, "");
			})
			.collect(toList());
	}

}

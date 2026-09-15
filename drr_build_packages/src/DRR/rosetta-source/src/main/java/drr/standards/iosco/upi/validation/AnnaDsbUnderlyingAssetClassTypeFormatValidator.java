package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetClass;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbUnderlyingAssetClassTypeFormatValidator implements Validator<AnnaDsbUnderlyingAssetClass> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbUnderlyingAssetClass o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbUnderlyingAssetClass o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbUnderlyingAssetClass", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbUnderlyingAssetClass", path, "", res.getError());
				}
				return success("AnnaDsbUnderlyingAssetClass", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbUnderlyingAssetClass", path, "");
			})
			.collect(toList());
	}

}

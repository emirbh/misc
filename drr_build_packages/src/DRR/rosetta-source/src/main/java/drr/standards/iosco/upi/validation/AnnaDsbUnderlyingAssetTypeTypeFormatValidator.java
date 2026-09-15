package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbUnderlyingAssetTypeTypeFormatValidator implements Validator<AnnaDsbUnderlyingAssetType> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbUnderlyingAssetType o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbUnderlyingAssetType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbUnderlyingAssetType", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbUnderlyingAssetType", path, "", res.getError());
				}
				return success("AnnaDsbUnderlyingAssetType", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbUnderlyingAssetType", path, "");
			})
			.collect(toList());
	}

}

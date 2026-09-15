package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbFRGT;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbFRGTTypeFormatValidator implements Validator<AnnaDsbFRGT> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbFRGT o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbFRGT o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbFRGT", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbFRGT", path, "", res.getError());
				}
				return success("AnnaDsbFRGT", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbFRGT", path, "");
			})
			.collect(toList());
	}

}

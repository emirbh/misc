package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbOTHC;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbOTHCTypeFormatValidator implements Validator<AnnaDsbOTHC> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbOTHC o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbOTHC o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbOTHC", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbOTHC", path, "", res.getError());
				}
				return success("AnnaDsbOTHC", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbOTHC", path, "");
			})
			.collect(toList());
	}

}

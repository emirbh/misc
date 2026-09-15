package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbCDSSingleName;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbCDSSingleNameTypeFormatValidator implements Validator<AnnaDsbCDSSingleName> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbCDSSingleName o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbCDSSingleName o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbCDSSingleName", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbCDSSingleName", path, "", res.getError());
				}
				return success("AnnaDsbCDSSingleName", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbCDSSingleName", path, "");
			})
			.collect(toList());
	}

}

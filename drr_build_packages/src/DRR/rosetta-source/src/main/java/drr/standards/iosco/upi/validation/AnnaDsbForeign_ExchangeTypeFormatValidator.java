package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbForeign_Exchange;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbForeign_ExchangeTypeFormatValidator implements Validator<AnnaDsbForeign_Exchange> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbForeign_Exchange o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbForeign_Exchange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbForeign_Exchange", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbForeign_Exchange", path, "", res.getError());
				}
				return success("AnnaDsbForeign_Exchange", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbForeign_Exchange", path, "");
			})
			.collect(toList());
	}

}

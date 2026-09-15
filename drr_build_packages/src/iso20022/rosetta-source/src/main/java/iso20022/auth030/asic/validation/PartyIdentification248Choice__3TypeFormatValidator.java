package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.PartyIdentification248Choice__3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyIdentification248Choice__3TypeFormatValidator implements Validator<PartyIdentification248Choice__3> {

	private List<ComparisonResult> getComparisonResults(PartyIdentification248Choice__3 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyIdentification248Choice__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyIdentification248Choice__3", ValidationResult.ValidationType.TYPE_FORMAT, "PartyIdentification248Choice__3", path, "", res.getError());
				}
				return success("PartyIdentification248Choice__3", ValidationResult.ValidationType.TYPE_FORMAT, "PartyIdentification248Choice__3", path, "");
			})
			.collect(toList());
	}

}

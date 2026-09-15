package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.PartyIdentification248Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyIdentification248ChoiceTypeFormatValidator implements Validator<PartyIdentification248Choice> {

	private List<ComparisonResult> getComparisonResults(PartyIdentification248Choice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyIdentification248Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyIdentification248Choice", ValidationResult.ValidationType.TYPE_FORMAT, "PartyIdentification248Choice", path, "", res.getError());
				}
				return success("PartyIdentification248Choice", ValidationResult.ValidationType.TYPE_FORMAT, "PartyIdentification248Choice", path, "");
			})
			.collect(toList());
	}

}

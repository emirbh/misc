package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.SecuredPartyRightsEvent;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecuredPartyRightsEventTypeFormatValidator implements Validator<SecuredPartyRightsEvent> {

	private List<ComparisonResult> getComparisonResults(SecuredPartyRightsEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecuredPartyRightsEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecuredPartyRightsEvent", ValidationResult.ValidationType.TYPE_FORMAT, "SecuredPartyRightsEvent", path, "", res.getError());
				}
				return success("SecuredPartyRightsEvent", ValidationResult.ValidationType.TYPE_FORMAT, "SecuredPartyRightsEvent", path, "");
			})
			.collect(toList());
	}

}

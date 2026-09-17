package cdm.legaldocumentation.common.validation;

import cdm.legaldocumentation.common.UmbrellaAgreementEntity;
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

public class UmbrellaAgreementEntityTypeFormatValidator implements Validator<UmbrellaAgreementEntity> {

	private List<ComparisonResult> getComparisonResults(UmbrellaAgreementEntity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UmbrellaAgreementEntity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UmbrellaAgreementEntity", ValidationResult.ValidationType.TYPE_FORMAT, "UmbrellaAgreementEntity", path, "", res.getError());
				}
				return success("UmbrellaAgreementEntity", ValidationResult.ValidationType.TYPE_FORMAT, "UmbrellaAgreementEntity", path, "");
			})
			.collect(toList());
	}

}

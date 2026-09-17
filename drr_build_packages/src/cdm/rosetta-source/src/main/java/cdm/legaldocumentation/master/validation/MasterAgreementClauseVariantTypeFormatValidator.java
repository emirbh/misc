package cdm.legaldocumentation.master.validation;

import cdm.legaldocumentation.master.MasterAgreementClauseVariant;
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

public class MasterAgreementClauseVariantTypeFormatValidator implements Validator<MasterAgreementClauseVariant> {

	private List<ComparisonResult> getComparisonResults(MasterAgreementClauseVariant o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementClauseVariant o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreementClauseVariant", ValidationResult.ValidationType.TYPE_FORMAT, "MasterAgreementClauseVariant", path, "", res.getError());
				}
				return success("MasterAgreementClauseVariant", ValidationResult.ValidationType.TYPE_FORMAT, "MasterAgreementClauseVariant", path, "");
			})
			.collect(toList());
	}

}

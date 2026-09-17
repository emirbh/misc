package cdm.legaldocumentation.master.validation;

import cdm.legaldocumentation.master.MasterAgreementClause;
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

public class MasterAgreementClauseTypeFormatValidator implements Validator<MasterAgreementClause> {

	private List<ComparisonResult> getComparisonResults(MasterAgreementClause o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementClause o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreementClause", ValidationResult.ValidationType.TYPE_FORMAT, "MasterAgreementClause", path, "", res.getError());
				}
				return success("MasterAgreementClause", ValidationResult.ValidationType.TYPE_FORMAT, "MasterAgreementClause", path, "");
			})
			.collect(toList());
	}

}

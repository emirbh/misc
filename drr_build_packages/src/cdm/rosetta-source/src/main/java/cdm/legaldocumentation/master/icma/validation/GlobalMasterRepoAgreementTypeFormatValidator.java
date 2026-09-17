package cdm.legaldocumentation.master.icma.validation;

import cdm.legaldocumentation.master.icma.GlobalMasterRepoAgreement;
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

public class GlobalMasterRepoAgreementTypeFormatValidator implements Validator<GlobalMasterRepoAgreement> {

	private List<ComparisonResult> getComparisonResults(GlobalMasterRepoAgreement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GlobalMasterRepoAgreement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GlobalMasterRepoAgreement", ValidationResult.ValidationType.TYPE_FORMAT, "GlobalMasterRepoAgreement", path, "", res.getError());
				}
				return success("GlobalMasterRepoAgreement", ValidationResult.ValidationType.TYPE_FORMAT, "GlobalMasterRepoAgreement", path, "");
			})
			.collect(toList());
	}

}

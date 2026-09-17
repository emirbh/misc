package cdm.legaldocumentation.master.validation;

import cdm.legaldocumentation.master.MasterAgreementElections;
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

public class MasterAgreementElectionsTypeFormatValidator implements Validator<MasterAgreementElections> {

	private List<ComparisonResult> getComparisonResults(MasterAgreementElections o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementElections o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreementElections", ValidationResult.ValidationType.TYPE_FORMAT, "MasterAgreementElections", path, "", res.getError());
				}
				return success("MasterAgreementElections", ValidationResult.ValidationType.TYPE_FORMAT, "MasterAgreementElections", path, "");
			})
			.collect(toList());
	}

}

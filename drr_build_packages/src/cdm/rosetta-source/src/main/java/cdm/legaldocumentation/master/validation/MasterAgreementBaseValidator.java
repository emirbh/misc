package cdm.legaldocumentation.master.validation;

import cdm.legaldocumentation.master.MasterAgreementBase;
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

public class MasterAgreementBaseValidator implements Validator<MasterAgreementBase> {

	private List<ComparisonResult> getComparisonResults(MasterAgreementBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreementBase", ValidationResult.ValidationType.CARDINALITY, "MasterAgreementBase", path, "", res.getError());
				}
				return success("MasterAgreementBase", ValidationResult.ValidationType.CARDINALITY, "MasterAgreementBase", path, "");
			})
			.collect(toList());
	}

}

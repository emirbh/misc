package cdm.legaldocumentation.master.validation;

import cdm.legaldocumentation.master.MasterAgreementSchedule;
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

public class MasterAgreementScheduleTypeFormatValidator implements Validator<MasterAgreementSchedule> {

	private List<ComparisonResult> getComparisonResults(MasterAgreementSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreementSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "MasterAgreementSchedule", path, "", res.getError());
				}
				return success("MasterAgreementSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "MasterAgreementSchedule", path, "");
			})
			.collect(toList());
	}

}

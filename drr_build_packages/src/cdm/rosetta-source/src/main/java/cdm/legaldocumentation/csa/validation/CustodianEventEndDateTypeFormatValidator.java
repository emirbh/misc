package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CustodianEventEndDate;
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

public class CustodianEventEndDateTypeFormatValidator implements Validator<CustodianEventEndDate> {

	private List<ComparisonResult> getComparisonResults(CustodianEventEndDate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodianEventEndDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustodianEventEndDate", ValidationResult.ValidationType.TYPE_FORMAT, "CustodianEventEndDate", path, "", res.getError());
				}
				return success("CustodianEventEndDate", ValidationResult.ValidationType.TYPE_FORMAT, "CustodianEventEndDate", path, "");
			})
			.collect(toList());
	}

}

package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.BusinessUnit;
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

public class BusinessUnitTypeFormatValidator implements Validator<BusinessUnit> {

	private List<ComparisonResult> getComparisonResults(BusinessUnit o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessUnit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessUnit", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessUnit", path, "", res.getError());
				}
				return success("BusinessUnit", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessUnit", path, "");
			})
			.collect(toList());
	}

}

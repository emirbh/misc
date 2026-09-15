package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.NonFinancialInstitutionSector10;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NonFinancialInstitutionSector10TypeFormatValidator implements Validator<NonFinancialInstitutionSector10> {

	private List<ComparisonResult> getComparisonResults(NonFinancialInstitutionSector10 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonFinancialInstitutionSector10 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonFinancialInstitutionSector10", ValidationResult.ValidationType.TYPE_FORMAT, "NonFinancialInstitutionSector10", path, "", res.getError());
				}
				return success("NonFinancialInstitutionSector10", ValidationResult.ValidationType.TYPE_FORMAT, "NonFinancialInstitutionSector10", path, "");
			})
			.collect(toList());
	}

}

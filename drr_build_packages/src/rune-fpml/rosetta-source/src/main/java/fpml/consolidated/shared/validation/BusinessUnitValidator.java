package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessUnit;
import fpml.consolidated.shared.ContactInformation;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.Unit;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BusinessUnitValidator implements Validator<BusinessUnit> {

	private List<ComparisonResult> getComparisonResults(BusinessUnit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessUnitId", (Unit) o.getBusinessUnitId() != null ? 1 : 0, 0, 1), 
				checkCardinality("contactInfo", (ContactInformation) o.getContactInfo() != null ? 1 : 0, 0, 1), 
				checkCardinality("country", (CountryCode) o.getCountry() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessUnit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessUnit", ValidationResult.ValidationType.CARDINALITY, "BusinessUnit", path, "", res.getError());
				}
				return success("BusinessUnit", ValidationResult.ValidationType.CARDINALITY, "BusinessUnit", path, "");
			})
			.collect(toList());
	}

}

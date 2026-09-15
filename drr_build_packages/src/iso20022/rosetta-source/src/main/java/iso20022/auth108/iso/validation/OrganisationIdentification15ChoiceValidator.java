package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.OrganisationIdentification15Choice;
import iso20022.auth108.iso.OrganisationIdentification38;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OrganisationIdentification15ChoiceValidator implements Validator<OrganisationIdentification15Choice> {

	private List<ComparisonResult> getComparisonResults(OrganisationIdentification15Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lei", (String) o.getLei() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (OrganisationIdentification38) o.getOthr() != null ? 1 : 0, 0, 1), 
				checkCardinality("anyBIC", (String) o.getAnyBIC() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganisationIdentification15Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OrganisationIdentification15Choice", ValidationResult.ValidationType.CARDINALITY, "OrganisationIdentification15Choice", path, "", res.getError());
				}
				return success("OrganisationIdentification15Choice", ValidationResult.ValidationType.CARDINALITY, "OrganisationIdentification15Choice", path, "");
			})
			.collect(toList());
	}

}

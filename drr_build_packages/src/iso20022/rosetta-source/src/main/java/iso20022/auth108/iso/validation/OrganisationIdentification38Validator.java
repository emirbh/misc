package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.GenericIdentification175;
import iso20022.auth108.iso.OrganisationIdentification38;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OrganisationIdentification38Validator implements Validator<OrganisationIdentification38> {

	private List<ComparisonResult> getComparisonResults(OrganisationIdentification38 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (GenericIdentification175) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("nm", (String) o.getNm() != null ? 1 : 0, 0, 1), 
				checkCardinality("dmcl", (String) o.getDmcl() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganisationIdentification38 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OrganisationIdentification38", ValidationResult.ValidationType.CARDINALITY, "OrganisationIdentification38", path, "", res.getError());
				}
				return success("OrganisationIdentification38", ValidationResult.ValidationType.CARDINALITY, "OrganisationIdentification38", path, "");
			})
			.collect(toList());
	}

}

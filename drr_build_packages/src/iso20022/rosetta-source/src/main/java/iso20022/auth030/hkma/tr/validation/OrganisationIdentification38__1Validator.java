package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.GenericIdentification175__2;
import iso20022.auth030.hkma.tr.OrganisationIdentification38__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OrganisationIdentification38__1Validator implements Validator<OrganisationIdentification38__1> {

	private List<ComparisonResult> getComparisonResults(OrganisationIdentification38__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (GenericIdentification175__2) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("nm", (String) o.getNm() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganisationIdentification38__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OrganisationIdentification38__1", ValidationResult.ValidationType.CARDINALITY, "OrganisationIdentification38__1", path, "", res.getError());
				}
				return success("OrganisationIdentification38__1", ValidationResult.ValidationType.CARDINALITY, "OrganisationIdentification38__1", path, "");
			})
			.collect(toList());
	}

}

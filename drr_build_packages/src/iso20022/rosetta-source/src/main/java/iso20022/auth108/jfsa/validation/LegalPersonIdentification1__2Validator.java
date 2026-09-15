package iso20022.auth108.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.jfsa.LegalPersonIdentification1__2;
import iso20022.auth108.jfsa.OrganisationIdentification15Choice__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LegalPersonIdentification1__2Validator implements Validator<LegalPersonIdentification1__2> {

	private List<ComparisonResult> getComparisonResults(LegalPersonIdentification1__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (OrganisationIdentification15Choice__2) o.getId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalPersonIdentification1__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegalPersonIdentification1__2", ValidationResult.ValidationType.CARDINALITY, "LegalPersonIdentification1__2", path, "", res.getError());
				}
				return success("LegalPersonIdentification1__2", ValidationResult.ValidationType.CARDINALITY, "LegalPersonIdentification1__2", path, "");
			})
			.collect(toList());
	}

}

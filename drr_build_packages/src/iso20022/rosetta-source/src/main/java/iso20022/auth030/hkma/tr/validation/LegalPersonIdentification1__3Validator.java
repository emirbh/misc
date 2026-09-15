package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.LegalPersonIdentification1__3;
import iso20022.auth030.hkma.tr.OrganisationIdentification15Choice__3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LegalPersonIdentification1__3Validator implements Validator<LegalPersonIdentification1__3> {

	private List<ComparisonResult> getComparisonResults(LegalPersonIdentification1__3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (OrganisationIdentification15Choice__3) o.getId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalPersonIdentification1__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegalPersonIdentification1__3", ValidationResult.ValidationType.CARDINALITY, "LegalPersonIdentification1__3", path, "", res.getError());
				}
				return success("LegalPersonIdentification1__3", ValidationResult.ValidationType.CARDINALITY, "LegalPersonIdentification1__3", path, "");
			})
			.collect(toList());
	}

}

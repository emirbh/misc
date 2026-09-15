package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.NaturalPersonIdentification2__1;
import iso20022.auth030.hkma.tr.OrganisationIdentification15Choice__3;
import iso20022.auth030.hkma.tr.PartyIdentification236Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyIdentification236Choice__1Validator implements Validator<PartyIdentification236Choice__1> {

	private List<ComparisonResult> getComparisonResults(PartyIdentification236Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lgl", (OrganisationIdentification15Choice__3) o.getLgl() != null ? 1 : 0, 0, 1), 
				checkCardinality("ntrl", (NaturalPersonIdentification2__1) o.getNtrl() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyIdentification236Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyIdentification236Choice__1", ValidationResult.ValidationType.CARDINALITY, "PartyIdentification236Choice__1", path, "", res.getError());
				}
				return success("PartyIdentification236Choice__1", ValidationResult.ValidationType.CARDINALITY, "PartyIdentification236Choice__1", path, "");
			})
			.collect(toList());
	}

}

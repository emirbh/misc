package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.LegalPersonIdentification1;
import iso20022.auth108.iso.NaturalPersonIdentification3;
import iso20022.auth108.iso.PartyIdentification248Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyIdentification248ChoiceValidator implements Validator<PartyIdentification248Choice> {

	private List<ComparisonResult> getComparisonResults(PartyIdentification248Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lgl", (LegalPersonIdentification1) o.getLgl() != null ? 1 : 0, 0, 1), 
				checkCardinality("ntrl", (NaturalPersonIdentification3) o.getNtrl() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyIdentification248Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyIdentification248Choice", ValidationResult.ValidationType.CARDINALITY, "PartyIdentification248Choice", path, "", res.getError());
				}
				return success("PartyIdentification248Choice", ValidationResult.ValidationType.CARDINALITY, "PartyIdentification248Choice", path, "");
			})
			.collect(toList());
	}

}

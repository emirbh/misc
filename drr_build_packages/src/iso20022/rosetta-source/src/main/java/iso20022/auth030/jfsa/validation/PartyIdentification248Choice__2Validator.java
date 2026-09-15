package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.LegalPersonIdentification1__2;
import iso20022.auth030.jfsa.NaturalPersonIdentification3__1;
import iso20022.auth030.jfsa.PartyIdentification248Choice__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyIdentification248Choice__2Validator implements Validator<PartyIdentification248Choice__2> {

	private List<ComparisonResult> getComparisonResults(PartyIdentification248Choice__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lgl", (LegalPersonIdentification1__2) o.getLgl() != null ? 1 : 0, 0, 1), 
				checkCardinality("ntrl", (NaturalPersonIdentification3__1) o.getNtrl() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyIdentification248Choice__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyIdentification248Choice__2", ValidationResult.ValidationType.CARDINALITY, "PartyIdentification248Choice__2", path, "", res.getError());
				}
				return success("PartyIdentification248Choice__2", ValidationResult.ValidationType.CARDINALITY, "PartyIdentification248Choice__2", path, "");
			})
			.collect(toList());
	}

}

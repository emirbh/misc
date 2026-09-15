package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.LegalPersonIdentification1__4;
import iso20022.auth030.asic.NaturalPersonIdentification3__3;
import iso20022.auth030.asic.PartyIdentification248Choice__4;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyIdentification248Choice__4Validator implements Validator<PartyIdentification248Choice__4> {

	private List<ComparisonResult> getComparisonResults(PartyIdentification248Choice__4 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lgl", (LegalPersonIdentification1__4) o.getLgl() != null ? 1 : 0, 0, 1), 
				checkCardinality("ntrl", (NaturalPersonIdentification3__3) o.getNtrl() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyIdentification248Choice__4 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyIdentification248Choice__4", ValidationResult.ValidationType.CARDINALITY, "PartyIdentification248Choice__4", path, "", res.getError());
				}
				return success("PartyIdentification248Choice__4", ValidationResult.ValidationType.CARDINALITY, "PartyIdentification248Choice__4", path, "");
			})
			.collect(toList());
	}

}

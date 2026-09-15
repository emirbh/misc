package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.LegalPersonIdentification1__5;
import iso20022.auth030.hkma.dtcc.NaturalPersonIdentification3__2;
import iso20022.auth030.hkma.dtcc.PartyIdentification248Choice__5;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyIdentification248Choice__5Validator implements Validator<PartyIdentification248Choice__5> {

	private List<ComparisonResult> getComparisonResults(PartyIdentification248Choice__5 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lgl", (LegalPersonIdentification1__5) o.getLgl() != null ? 1 : 0, 0, 1), 
				checkCardinality("ntrl", (NaturalPersonIdentification3__2) o.getNtrl() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyIdentification248Choice__5 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyIdentification248Choice__5", ValidationResult.ValidationType.CARDINALITY, "PartyIdentification248Choice__5", path, "", res.getError());
				}
				return success("PartyIdentification248Choice__5", ValidationResult.ValidationType.CARDINALITY, "PartyIdentification248Choice__5", path, "");
			})
			.collect(toList());
	}

}

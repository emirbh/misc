package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.FrenchLawAddendum;
import cdm.legaldocumentation.csa.JapaneseSecuritiesProvisions;
import cdm.legaldocumentation.csa.JurisdictionRelatedTerms;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class JurisdictionRelatedTermsValidator implements Validator<JurisdictionRelatedTerms> {

	private List<ComparisonResult> getComparisonResults(JurisdictionRelatedTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("japaneseSecuritiesProvisions", (JapaneseSecuritiesProvisions) o.getJapaneseSecuritiesProvisions() != null ? 1 : 0, 0, 1), 
				checkCardinality("exclusiveJurisdiction", (Boolean) o.getExclusiveJurisdiction() != null ? 1 : 0, 0, 1), 
				checkCardinality("juryWaiver", (Boolean) o.getJuryWaiver() != null ? 1 : 0, 0, 1), 
				checkCardinality("frenchLawAddendum", (FrenchLawAddendum) o.getFrenchLawAddendum() != null ? 1 : 0, 0, 1), 
				checkCardinality("belgianLawSecurityAgreement", (Boolean) o.getBelgianLawSecurityAgreement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, JurisdictionRelatedTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("JurisdictionRelatedTerms", ValidationResult.ValidationType.CARDINALITY, "JurisdictionRelatedTerms", path, "", res.getError());
				}
				return success("JurisdictionRelatedTerms", ValidationResult.ValidationType.CARDINALITY, "JurisdictionRelatedTerms", path, "");
			})
			.collect(toList());
	}

}

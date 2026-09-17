package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.LegacyConsentEnum;
import cdm.legaldocumentation.csa.Substitution;
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

public class SubstitutionValidator implements Validator<Substitution> {

	private List<ComparisonResult> getComparisonResults(Substitution o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("needsConsent", (Boolean) o.getNeedsConsent() != null ? 1 : 0, 1, 1), 
				checkCardinality("substitutionDateLanguage", (String) o.getSubstitutionDateLanguage() != null ? 1 : 0, 0, 1), 
				checkCardinality("specificConsentLanguage", (String) o.getSpecificConsentLanguage() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyConsent", (LegacyConsentEnum) o.getLegacyConsent() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Substitution o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Substitution", ValidationResult.ValidationType.CARDINALITY, "Substitution", path, "", res.getError());
				}
				return success("Substitution", ValidationResult.ValidationType.CARDINALITY, "Substitution", path, "");
			})
			.collect(toList());
	}

}

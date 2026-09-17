package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.common.OtherAgreementTerms;
import cdm.legaldocumentation.csa.OtherAgreements;
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

public class OtherAgreementsValidator implements Validator<OtherAgreements> {

	private List<ComparisonResult> getComparisonResults(OtherAgreements o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("otherCsa", (OtherAgreementTerms) o.getOtherCsa() != null ? 1 : 0, 0, 1), 
				checkCardinality("japaneseLawCsa", (OtherAgreementTerms) o.getJapaneseLawCsa() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OtherAgreements o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OtherAgreements", ValidationResult.ValidationType.CARDINALITY, "OtherAgreements", path, "", res.getError());
				}
				return success("OtherAgreements", ValidationResult.ValidationType.CARDINALITY, "OtherAgreements", path, "");
			})
			.collect(toList());
	}

}

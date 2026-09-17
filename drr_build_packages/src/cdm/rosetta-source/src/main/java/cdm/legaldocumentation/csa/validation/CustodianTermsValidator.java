package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.LegalEntity;
import cdm.legaldocumentation.csa.CustodianTerms;
import cdm.observable.asset.CreditNotation;
import cdm.observable.asset.Money;
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

public class CustodianTermsValidator implements Validator<CustodianTerms> {

	private List<ComparisonResult> getComparisonResults(CustodianTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("minimumAssets", (Money) o.getMinimumAssets() != null ? 1 : 0, 0, 1), 
				checkCardinality("minimumRating", (CreditNotation) o.getMinimumRating() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialDesignation", (LegalEntity) o.getInitialDesignation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodianTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustodianTerms", ValidationResult.ValidationType.CARDINALITY, "CustodianTerms", path, "", res.getError());
				}
				return success("CustodianTerms", ValidationResult.ValidationType.CARDINALITY, "CustodianTerms", path, "");
			})
			.collect(toList());
	}

}

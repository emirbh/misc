package cdm.legaldocumentation.transaction.validation;

import cdm.legaldocumentation.transaction.EquityAdditionalTerms;
import cdm.legaldocumentation.transaction.TransactionAdditionalTerms;
import cdm.legaldocumentation.transaction.additionalterms.FxAdditionalTerms;
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

public class TransactionAdditionalTermsValidator implements Validator<TransactionAdditionalTerms> {

	private List<ComparisonResult> getComparisonResults(TransactionAdditionalTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("equityAdditionalTerms", (EquityAdditionalTerms) o.getEquityAdditionalTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("foreignExchangeAdditionalTerms", (FxAdditionalTerms) o.getForeignExchangeAdditionalTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("commoditiesAdditionalTerms", (String) o.getCommoditiesAdditionalTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditAdditionalTerms", (String) o.getCreditAdditionalTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestRateAdditionalTerms", (String) o.getInterestRateAdditionalTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("digitalAssetAdditionalTerms", (String) o.getDigitalAssetAdditionalTerms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransactionAdditionalTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransactionAdditionalTerms", ValidationResult.ValidationType.CARDINALITY, "TransactionAdditionalTerms", path, "", res.getError());
				}
				return success("TransactionAdditionalTerms", ValidationResult.ValidationType.CARDINALITY, "TransactionAdditionalTerms", path, "");
			})
			.collect(toList());
	}

}

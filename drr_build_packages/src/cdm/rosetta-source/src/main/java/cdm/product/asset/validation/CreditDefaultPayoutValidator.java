package cdm.product.asset.validation;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.observable.asset.TransactedPrice;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.common.settlement.PrincipalPayments;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.SettlementTerms;
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

public class CreditDefaultPayoutValidator implements Validator<CreditDefaultPayout> {

	private List<ComparisonResult> getComparisonResults(CreditDefaultPayout o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payerReceiver", (PayerReceiver) o.getPayerReceiver() != null ? 1 : 0, 1, 1), 
				checkCardinality("priceQuantity", (ResolvablePriceQuantity) o.getPriceQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("principalPayment", (PrincipalPayments) o.getPrincipalPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementTerms", (SettlementTerms) o.getSettlementTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("generalTerms", (GeneralTerms) o.getGeneralTerms() != null ? 1 : 0, 1, 1), 
				checkCardinality("transactedPrice", (TransactedPrice) o.getTransactedPrice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultPayout o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditDefaultPayout", ValidationResult.ValidationType.CARDINALITY, "CreditDefaultPayout", path, "", res.getError());
				}
				return success("CreditDefaultPayout", ValidationResult.ValidationType.CARDINALITY, "CreditDefaultPayout", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.com.NonPeriodicFixedPriceLeg;
import fpml.consolidated.com.QuantityReference;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NonPeriodicFixedPriceLegValidator implements Validator<NonPeriodicFixedPriceLeg> {

	private List<ComparisonResult> getComparisonResults(NonPeriodicFixedPriceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedPrice", (CommodityFixedPrice) o.getFixedPrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("totalPrice", (NonNegativeMoney) o.getTotalPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityReference", (QuantityReference) o.getQuantityReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativePaymentDates", (CommodityRelativePaymentDates) o.getRelativePaymentDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDates", (AdjustableDatesOrRelativeDateOffset) o.getPaymentDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterAgreementPaymentDates", (Boolean) o.getMasterAgreementPaymentDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonPeriodicFixedPriceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonPeriodicFixedPriceLeg", ValidationResult.ValidationType.CARDINALITY, "NonPeriodicFixedPriceLeg", path, "", res.getError());
				}
				return success("NonPeriodicFixedPriceLeg", ValidationResult.ValidationType.CARDINALITY, "NonPeriodicFixedPriceLeg", path, "");
			})
			.collect(toList());
	}

}

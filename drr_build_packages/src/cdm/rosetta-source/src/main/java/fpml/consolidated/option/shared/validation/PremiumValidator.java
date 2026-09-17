package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.PremiumTypeEnum;
import fpml.consolidated.option.shared.Premium;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PremiumValidator implements Validator<Premium> {

	private List<ComparisonResult> getComparisonResults(Premium o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentAmount", (NonNegativeMoney) o.getPaymentAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDate", (AdjustableOrRelativeDate) o.getPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("premiumType", (PremiumTypeEnum) o.getPremiumType() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricePerOption", (Money) o.getPricePerOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("percentageOfNotional", (BigDecimal) o.getPercentageOfNotional() != null ? 1 : 0, 0, 1), 
				checkCardinality("discountFactor", (BigDecimal) o.getDiscountFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("presentValueAmount", (Money) o.getPresentValueAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Premium o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Premium", ValidationResult.ValidationType.CARDINALITY, "Premium", path, "", res.getError());
				}
				return success("Premium", ValidationResult.ValidationType.CARDINALITY, "Premium", path, "");
			})
			.collect(toList());
	}

}

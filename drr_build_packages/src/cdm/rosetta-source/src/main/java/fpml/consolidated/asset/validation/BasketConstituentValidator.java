package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.BasketConstituent;
import fpml.consolidated.asset.ConstituentWeight;
import fpml.consolidated.asset.DividendPayout;
import fpml.consolidated.asset.PendingPayment;
import fpml.consolidated.asset.Price;
import fpml.consolidated.asset.UnderlyerLoanRate;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Collateral;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SpreadScheduleReference;
import fpml.consolidated.shared.UnderlyerInterestLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BasketConstituentValidator implements Validator<BasketConstituent> {

	private List<ComparisonResult> getComparisonResults(BasketConstituent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingAsset", (Asset) o.getUnderlyingAsset() != null ? 1 : 0, 1, 1), 
				checkCardinality("constituentWeight", (ConstituentWeight) o.getConstituentWeight() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerPrice", (Price) o.getUnderlyerPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerNotional", (Money) o.getUnderlyerNotional() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerSpread", (SpreadScheduleReference) o.getUnderlyerSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerFinancing", (UnderlyerInterestLeg) o.getUnderlyerFinancing() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerLoanRate", (UnderlyerLoanRate) o.getUnderlyerLoanRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerCollateral", (Collateral) o.getUnderlyerCollateral() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPayout", (DividendPayout) o.getDividendPayout() != null ? 1 : 0, 0, 1), 
				checkCardinality("couponPayment", (PendingPayment) o.getCouponPayment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketConstituent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasketConstituent", ValidationResult.ValidationType.CARDINALITY, "BasketConstituent", path, "", res.getError());
				}
				return success("BasketConstituent", ValidationResult.ValidationType.CARDINALITY, "BasketConstituent", path, "");
			})
			.collect(toList());
	}

}

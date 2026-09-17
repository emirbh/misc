package fpml.consolidated.repo.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.DeliveryMethod;
import fpml.consolidated.repo.RepoFarLeg;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxRate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RepoFarLegValidator implements Validator<RepoFarLeg> {

	private List<ComparisonResult> getComparisonResults(RepoFarLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (AdjustableOrRelativeDate) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementAmount", (Money) o.getSettlementAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementCurrency", (Currency) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxRate", (FxRate) o.getFxRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryMethod", (DeliveryMethod) o.getDeliveryMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryDate", (AdjustableOrRelativeDate) o.getDeliveryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("repoInterest", (BigDecimal) o.getRepoInterest() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoFarLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepoFarLeg", ValidationResult.ValidationType.CARDINALITY, "RepoFarLeg", path, "", res.getError());
				}
				return success("RepoFarLeg", ValidationResult.ValidationType.CARDINALITY, "RepoFarLeg", path, "");
			})
			.collect(toList());
	}

}

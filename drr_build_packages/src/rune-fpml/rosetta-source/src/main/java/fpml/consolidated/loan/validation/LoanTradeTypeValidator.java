package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.BuySellEnum;
import fpml.consolidated.fpmlenum.LoanTradingAccrualSettlementEnum;
import fpml.consolidated.fpmlenum.LoanTradingAssocEnum;
import fpml.consolidated.fpmlenum.LoanTradingDocTypeEnum;
import fpml.consolidated.fpmlenum.LoanTradingFormOfPurchaseEnum;
import fpml.consolidated.fpmlenum.LoanTradingTypeEnum;
import fpml.consolidated.fpmlenum.LoanTradingVotingRightsEnum;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.LoanTradeType;
import fpml.consolidated.loan.LoanTransferFee;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.TradeId;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradeTypeValidator implements Validator<LoanTradeType> {

	private List<ComparisonResult> getComparisonResults(LoanTradeType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("issuer", (IssuerId) o.getIssuer() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeId", (TradeId) o.getTradeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("accountReference", (AccountReference) o.getAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityReference", (FacilityReference) o.getFacilityReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (NonNegativeMoney) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeDate", (ZonedDateTime) o.getTradeDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketType", (LoanTradingTypeEnum) o.getMarketType() != null ? 1 : 0, 1, 1), 
				checkCardinality("whenIssuedFlag", (Boolean) o.getWhenIssuedFlag() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradingAssociation", (LoanTradingAssocEnum) o.getTradingAssociation() != null ? 1 : 0, 1, 1), 
				checkCardinality("formOfPurchase", (LoanTradingFormOfPurchaseEnum) o.getFormOfPurchase() != null ? 1 : 0, 1, 1), 
				checkCardinality("remittedBy", (BuySellEnum) o.getRemittedBy() != null ? 1 : 0, 1, 1), 
				checkCardinality("price", (BigDecimal) o.getPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("transferFee", (LoanTransferFee) o.getTransferFee() != null ? 1 : 0, 0, 1), 
				checkCardinality("documentationType", (LoanTradingDocTypeEnum) o.getDocumentationType() != null ? 1 : 0, 0, 1), 
				checkCardinality("accrualSettlementType", (LoanTradingAccrualSettlementEnum) o.getAccrualSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("delayedCompensationFlag", (Boolean) o.getDelayedCompensationFlag() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherFeesBenefactor", (BuySellEnum) o.getOtherFeesBenefactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralRequiredFlag", (Boolean) o.getCollateralRequiredFlag() != null ? 1 : 0, 0, 1), 
				checkCardinality("votingRights", (LoanTradingVotingRightsEnum) o.getVotingRights() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradeType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradeType", ValidationResult.ValidationType.CARDINALITY, "LoanTradeType", path, "", res.getError());
				}
				return success("LoanTradeType", ValidationResult.ValidationType.CARDINALITY, "LoanTradeType", path, "");
			})
			.collect(toList());
	}

}

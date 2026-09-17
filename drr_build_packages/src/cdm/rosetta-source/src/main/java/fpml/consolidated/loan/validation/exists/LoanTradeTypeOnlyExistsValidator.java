package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeIdentifierChoice;
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
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradeTypeOnlyExistsValidator implements ValidatorWithArg<LoanTradeType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradeType> ValidationResult<LoanTradeType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("issuer", ExistenceChecker.isSet((IssuerId) o.getIssuer()))
				.put("tradeId", ExistenceChecker.isSet((TradeId) o.getTradeId()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("accountReference", ExistenceChecker.isSet((AccountReference) o.getAccountReference()))
				.put("tradeIdentifierChoice", ExistenceChecker.isSet((List<? extends TradeIdentifierChoice>) o.getTradeIdentifierChoice()))
				.put("facilityReference", ExistenceChecker.isSet((FacilityReference) o.getFacilityReference()))
				.put("amount", ExistenceChecker.isSet((NonNegativeMoney) o.getAmount()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("tradeDate", ExistenceChecker.isSet((ZonedDateTime) o.getTradeDate()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("buyerAccountReference", ExistenceChecker.isSet((AccountReference) o.getBuyerAccountReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("sellerAccountReference", ExistenceChecker.isSet((AccountReference) o.getSellerAccountReference()))
				.put("marketType", ExistenceChecker.isSet((LoanTradingTypeEnum) o.getMarketType()))
				.put("whenIssuedFlag", ExistenceChecker.isSet((Boolean) o.getWhenIssuedFlag()))
				.put("tradingAssociation", ExistenceChecker.isSet((LoanTradingAssocEnum) o.getTradingAssociation()))
				.put("formOfPurchase", ExistenceChecker.isSet((LoanTradingFormOfPurchaseEnum) o.getFormOfPurchase()))
				.put("remittedBy", ExistenceChecker.isSet((BuySellEnum) o.getRemittedBy()))
				.put("price", ExistenceChecker.isSet((BigDecimal) o.getPrice()))
				.put("transferFee", ExistenceChecker.isSet((LoanTransferFee) o.getTransferFee()))
				.put("documentationType", ExistenceChecker.isSet((LoanTradingDocTypeEnum) o.getDocumentationType()))
				.put("accrualSettlementType", ExistenceChecker.isSet((LoanTradingAccrualSettlementEnum) o.getAccrualSettlementType()))
				.put("delayedCompensationFlag", ExistenceChecker.isSet((Boolean) o.getDelayedCompensationFlag()))
				.put("otherFeesBenefactor", ExistenceChecker.isSet((BuySellEnum) o.getOtherFeesBenefactor()))
				.put("collateralRequiredFlag", ExistenceChecker.isSet((Boolean) o.getCollateralRequiredFlag()))
				.put("votingRights", ExistenceChecker.isSet((LoanTradingVotingRightsEnum) o.getVotingRights()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradeType", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradeType", path, "");
		}
		return failure("LoanTradeType", ValidationResult.ValidationType.ONLY_EXISTS, "LoanTradeType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

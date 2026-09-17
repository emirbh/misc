package fpml.consolidated.fpmlreturn.swaps.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.ExtraordinaryEvents;
import fpml.consolidated.eq.shared.PrincipalExchangeFeatures;
import fpml.consolidated.eq.shared.ReturnSwapAdditionalPayment;
import fpml.consolidated.fpmlenum.EarlyTerminationDateEnum;
import fpml.consolidated.fpmlenum.FeeElectionEnum;
import fpml.consolidated.fpmlreturn.swaps.EquitySwapTransactionSupplement;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.DirectionalLeg;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquitySwapTransactionSupplementOnlyExistsValidator implements ValidatorWithArg<EquitySwapTransactionSupplement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquitySwapTransactionSupplement> ValidationResult<EquitySwapTransactionSupplement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("buyerAccountReference", ExistenceChecker.isSet((AccountReference) o.getBuyerAccountReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("sellerAccountReference", ExistenceChecker.isSet((AccountReference) o.getSellerAccountReference()))
				.put("returnSwapLeg", ExistenceChecker.isSet((List<? extends DirectionalLeg>) o.getReturnSwapLeg()))
				.put("principalExchangeFeatures", ExistenceChecker.isSet((PrincipalExchangeFeatures) o.getPrincipalExchangeFeatures()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends ReturnSwapAdditionalPayment>) o.getAdditionalPayment()))
				.put("mutualEarlyTermination", ExistenceChecker.isSet((Boolean) o.getMutualEarlyTermination()))
				.put("optionalEarlyTermination", ExistenceChecker.isSet((Boolean) o.getOptionalEarlyTermination()))
				.put("optionalEarlyTerminationDate", ExistenceChecker.isSet((EarlyTerminationDateEnum) o.getOptionalEarlyTerminationDate()))
				.put("optionalEarlyTerminationElectingPartyReference", ExistenceChecker.isSet((PartyReference) o.getOptionalEarlyTerminationElectingPartyReference()))
				.put("breakFundingRecovery", ExistenceChecker.isSet((Boolean) o.getBreakFundingRecovery()))
				.put("breakFeeElection", ExistenceChecker.isSet((FeeElectionEnum) o.getBreakFeeElection()))
				.put("breakFeeRate", ExistenceChecker.isSet((BigDecimal) o.getBreakFeeRate()))
				.put("multipleExchangeIndexAnnexFallback", ExistenceChecker.isSet((Boolean) o.getMultipleExchangeIndexAnnexFallback()))
				.put("componentSecurityIndexAnnexFallback", ExistenceChecker.isSet((Boolean) o.getComponentSecurityIndexAnnexFallback()))
				.put("localJurisdiction", ExistenceChecker.isSet((CountryCode) o.getLocalJurisdiction()))
				.put("relevantJurisdiction", ExistenceChecker.isSet((CountryCode) o.getRelevantJurisdiction()))
				.put("extraordinaryEvents", ExistenceChecker.isSet((ExtraordinaryEvents) o.getExtraordinaryEvents()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquitySwapTransactionSupplement", ValidationResult.ValidationType.ONLY_EXISTS, "EquitySwapTransactionSupplement", path, "");
		}
		return failure("EquitySwapTransactionSupplement", ValidationResult.ValidationType.ONLY_EXISTS, "EquitySwapTransactionSupplement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

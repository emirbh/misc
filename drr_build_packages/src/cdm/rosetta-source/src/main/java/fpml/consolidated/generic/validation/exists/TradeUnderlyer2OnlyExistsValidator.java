package fpml.consolidated.generic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.cd.IndexReferenceInformation;
import fpml.consolidated.com.CoalProduct;
import fpml.consolidated.com.ElectricityProduct;
import fpml.consolidated.com.GasProduct;
import fpml.consolidated.com.OilProduct;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.generic.GenericProductExchangeRate;
import fpml.consolidated.generic.TradeUnderlyer2;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.FloatingRate;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.QuotedCurrencyPair;
import fpml.consolidated.shared.Schedule;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeUnderlyer2OnlyExistsValidator implements ValidatorWithArg<TradeUnderlyer2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeUnderlyer2> ValidationResult<TradeUnderlyer2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("floatingRate", ExistenceChecker.isSet((FloatingRate) o.getFloatingRate()))
				.put("fixedRate", ExistenceChecker.isSet((Schedule) o.getFixedRate()))
				.put("exchangeRate", ExistenceChecker.isSet((GenericProductExchangeRate) o.getExchangeRate()))
				.put("underlyingAsset", ExistenceChecker.isSet((Asset) o.getUnderlyingAsset()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("referenceEntity", ExistenceChecker.isSet((LegalEntity) o.getReferenceEntity()))
				.put("indexReferenceInformation", ExistenceChecker.isSet((IndexReferenceInformation) o.getIndexReferenceInformation()))
				.put("gas", ExistenceChecker.isSet((GasProduct) o.getGas()))
				.put("oil", ExistenceChecker.isSet((OilProduct) o.getOil()))
				.put("coal", ExistenceChecker.isSet((CoalProduct) o.getCoal()))
				.put("electricity", ExistenceChecker.isSet((ElectricityProduct) o.getElectricity()))
				.put("averagingMethod", ExistenceChecker.isSet((AveragingMethodEnum) o.getAveragingMethod()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("buyerAccountReference", ExistenceChecker.isSet((AccountReference) o.getBuyerAccountReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("sellerAccountReference", ExistenceChecker.isSet((AccountReference) o.getSellerAccountReference()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeUnderlyer2", ValidationResult.ValidationType.ONLY_EXISTS, "TradeUnderlyer2", path, "");
		}
		return failure("TradeUnderlyer2", ValidationResult.ValidationType.ONLY_EXISTS, "TradeUnderlyer2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.FraDiscountingEnum;
import fpml.consolidated.ird.Fra;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.IdentifiedRate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.RequiredIdentifierDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FraOnlyExistsValidator implements ValidatorWithArg<Fra, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Fra> ValidationResult<Fra> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("adjustedEffectiveDate", ExistenceChecker.isSet((RequiredIdentifierDate) o.getAdjustedEffectiveDate()))
				.put("adjustedTerminationDate", ExistenceChecker.isSet((ZonedDateTime) o.getAdjustedTerminationDate()))
				.put("paymentDate", ExistenceChecker.isSet((AdjustableDate) o.getPaymentDate()))
				.put("fixingDateOffset", ExistenceChecker.isSet((RelativeDateOffset) o.getFixingDateOffset()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("calculationPeriodNumberOfDays", ExistenceChecker.isSet((Integer) o.getCalculationPeriodNumberOfDays()))
				.put("notional", ExistenceChecker.isSet((Money) o.getNotional()))
				.put("fixedRate", ExistenceChecker.isSet((IdentifiedRate) o.getFixedRate()))
				.put("floatingRateIndex", ExistenceChecker.isSet((FloatingRateIndex) o.getFloatingRateIndex()))
				.put("indexTenor", ExistenceChecker.isSet((List<? extends Period>) o.getIndexTenor()))
				.put("fraDiscounting", ExistenceChecker.isSet((FraDiscountingEnum) o.getFraDiscounting()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends Payment>) o.getAdditionalPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Fra", ValidationResult.ValidationType.ONLY_EXISTS, "Fra", path, "");
		}
		return failure("Fra", ValidationResult.ValidationType.ONLY_EXISTS, "Fra", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

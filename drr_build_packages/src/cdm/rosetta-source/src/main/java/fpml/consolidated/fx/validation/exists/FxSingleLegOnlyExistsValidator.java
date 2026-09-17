package fpml.consolidated.fx.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.DealtCurrencyEnum;
import fpml.consolidated.fpmlenum.FxTenorPeriodEnum;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.fx.FxDisruption;
import fpml.consolidated.fx.FxSingleLeg;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FxCashSettlement;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxSingleLegOnlyExistsValidator implements ValidatorWithArg<FxSingleLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxSingleLeg> ValidationResult<FxSingleLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("exchangedCurrency1", ExistenceChecker.isSet((Payment) o.getExchangedCurrency1()))
				.put("exchangedCurrency2", ExistenceChecker.isSet((Payment) o.getExchangedCurrency2()))
				.put("dealtCurrency", ExistenceChecker.isSet((DealtCurrencyEnum) o.getDealtCurrency()))
				.put("tenorName", ExistenceChecker.isSet((FxTenorPeriodEnum) o.getTenorName()))
				.put("tenorPeriod", ExistenceChecker.isSet((Period) o.getTenorPeriod()))
				.put("valueDate", ExistenceChecker.isSet((ZonedDateTime) o.getValueDate()))
				.put("currency1ValueDate", ExistenceChecker.isSet((ZonedDateTime) o.getCurrency1ValueDate()))
				.put("currency2ValueDate", ExistenceChecker.isSet((ZonedDateTime) o.getCurrency2ValueDate()))
				.put("exchangeRate", ExistenceChecker.isSet((ExchangeRate) o.getExchangeRate()))
				.put("nonDeliverableSettlement", ExistenceChecker.isSet((FxCashSettlement) o.getNonDeliverableSettlement()))
				.put("disruption", ExistenceChecker.isSet((List<? extends FxDisruption>) o.getDisruption()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxSingleLeg", ValidationResult.ValidationType.ONLY_EXISTS, "FxSingleLeg", path, "");
		}
		return failure("FxSingleLeg", ValidationResult.ValidationType.ONLY_EXISTS, "FxSingleLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

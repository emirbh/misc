package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AssetMeasureType;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.asset.PriceQuoteUnits;
import fpml.consolidated.asset.PricingModel;
import fpml.consolidated.asset.QuoteTiming;
import fpml.consolidated.asset.ReportingCurrencyType;
import fpml.consolidated.fpmlenum.QuotationSideEnum;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.CashflowType;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.InformationSource;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BasicQuotationOnlyExistsValidator implements ValidatorWithArg<BasicQuotation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BasicQuotation> ValidationResult<BasicQuotation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("value", ExistenceChecker.isSet((BigDecimal) o.getValue()))
				.put("measureType", ExistenceChecker.isSet((AssetMeasureType) o.getMeasureType()))
				.put("quoteUnits", ExistenceChecker.isSet((PriceQuoteUnits) o.getQuoteUnits()))
				.put("side", ExistenceChecker.isSet((QuotationSideEnum) o.getSide()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("currencyType", ExistenceChecker.isSet((ReportingCurrencyType) o.getCurrencyType()))
				.put("timing", ExistenceChecker.isSet((QuoteTiming) o.getTiming()))
				.put("businessCenter", ExistenceChecker.isSet((BusinessCenter) o.getBusinessCenter()))
				.put("exchangeId", ExistenceChecker.isSet((ExchangeId) o.getExchangeId()))
				.put("informationSource", ExistenceChecker.isSet((List<? extends InformationSource>) o.getInformationSource()))
				.put("pricingModel", ExistenceChecker.isSet((PricingModel) o.getPricingModel()))
				.put("time", ExistenceChecker.isSet((ZonedDateTime) o.getTime()))
				.put("valuationDate", ExistenceChecker.isSet((ZonedDateTime) o.getValuationDate()))
				.put("expiryTime", ExistenceChecker.isSet((ZonedDateTime) o.getExpiryTime()))
				.put("cashflowType", ExistenceChecker.isSet((CashflowType) o.getCashflowType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BasicQuotation", ValidationResult.ValidationType.ONLY_EXISTS, "BasicQuotation", path, "");
		}
		return failure("BasicQuotation", ValidationResult.ValidationType.ONLY_EXISTS, "BasicQuotation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

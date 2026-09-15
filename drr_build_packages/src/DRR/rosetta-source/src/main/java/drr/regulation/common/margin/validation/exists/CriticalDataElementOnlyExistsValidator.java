package drr.regulation.common.margin.validation.exists;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.margin.CriticalDataElement;
import drr.standards.iso.CollateralisationType3Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CriticalDataElementOnlyExistsValidator implements ValidatorWithArg<CriticalDataElement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CriticalDataElement> ValidationResult<CriticalDataElement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("reportingTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getReportingTimestamp()))
				.put("counterparty1", ExistenceChecker.isSet((String) o.getCounterparty1()))
				.put("counterparty2IdentifierType", ExistenceChecker.isSet((Boolean) o.getCounterparty2IdentifierType()))
				.put("counterparty2", ExistenceChecker.isSet((String) o.getCounterparty2()))
				.put("collateralPortfolioCode", ExistenceChecker.isSet((String) o.getCollateralPortfolioCode()))
				.put("collateralPortfolioIndicator", ExistenceChecker.isSet((Boolean) o.getCollateralPortfolioIndicator()))
				.put("uti", ExistenceChecker.isSet((String) o.getUti()))
				.put("collateralisationCategory", ExistenceChecker.isSet((CollateralisationType3Code) o.getCollateralisationCategory()))
				.put("initialMarginPostedByTheCounterparty1PreHaircut", ExistenceChecker.isSet((BigDecimal) o.getInitialMarginPostedByTheCounterparty1PreHaircut()))
				.put("initialMarginPostedByTheCounterparty1PostHaircut", ExistenceChecker.isSet((BigDecimal) o.getInitialMarginPostedByTheCounterparty1PostHaircut()))
				.put("initialMarginPostedByCounterparty1Currency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getInitialMarginPostedByCounterparty1Currency()))
				.put("variationMarginPostedByTheCounterparty1PreHaircut", ExistenceChecker.isSet((BigDecimal) o.getVariationMarginPostedByTheCounterparty1PreHaircut()))
				.put("variationMarginPostedByTheCounterparty1PostHaircut", ExistenceChecker.isSet((BigDecimal) o.getVariationMarginPostedByTheCounterparty1PostHaircut()))
				.put("variationMarginPostedByCounterparty1Currency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getVariationMarginPostedByCounterparty1Currency()))
				.put("initialMarginCollectedByCounterparty1PreHaircut", ExistenceChecker.isSet((BigDecimal) o.getInitialMarginCollectedByCounterparty1PreHaircut()))
				.put("initialMarginCollectedByCounterparty1PostHaircut", ExistenceChecker.isSet((BigDecimal) o.getInitialMarginCollectedByCounterparty1PostHaircut()))
				.put("initialMarginCollectedByCounterparty1Currency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getInitialMarginCollectedByCounterparty1Currency()))
				.put("variationMarginCollectedByTheCounterparty1PreHaircut", ExistenceChecker.isSet((BigDecimal) o.getVariationMarginCollectedByTheCounterparty1PreHaircut()))
				.put("variationMarginCollectedByTheCounterparty1PostHaircut", ExistenceChecker.isSet((BigDecimal) o.getVariationMarginCollectedByTheCounterparty1PostHaircut()))
				.put("variationMarginCollectedByCounterparty1Currency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getVariationMarginCollectedByCounterparty1Currency()))
				.put("excessCollateralPostedByTheCounterparty1", ExistenceChecker.isSet((BigDecimal) o.getExcessCollateralPostedByTheCounterparty1()))
				.put("currencyOfTheExcessCollateralPosted", ExistenceChecker.isSet((String) o.getCurrencyOfTheExcessCollateralPosted()))
				.put("excessCollateralCollectedByTheCounterparty1", ExistenceChecker.isSet((BigDecimal) o.getExcessCollateralCollectedByTheCounterparty1()))
				.put("currencyOfTheExcessCollateralCollected", ExistenceChecker.isSet((String) o.getCurrencyOfTheExcessCollateralCollected()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CriticalDataElement", ValidationResult.ValidationType.ONLY_EXISTS, "CriticalDataElement", path, "");
		}
		return failure("CriticalDataElement", ValidationResult.ValidationType.ONLY_EXISTS, "CriticalDataElement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

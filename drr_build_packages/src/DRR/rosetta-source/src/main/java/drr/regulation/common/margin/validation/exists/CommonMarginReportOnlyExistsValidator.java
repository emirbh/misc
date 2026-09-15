package drr.regulation.common.margin.validation.exists;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.margin.CommonMarginReport;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommonMarginReportOnlyExistsValidator implements ValidatorWithArg<CommonMarginReport, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommonMarginReport> ValidationResult<CommonMarginReport> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("collateralTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getCollateralTimestamp()))
				.put("variationMarginCollateralPortfolioCode", ExistenceChecker.isSet((String) o.getVariationMarginCollateralPortfolioCode()))
				.put("initialMarginCollateralPortfolioCode", ExistenceChecker.isSet((String) o.getInitialMarginCollateralPortfolioCode()))
				.put("reportSubmittingEntityID", ExistenceChecker.isSet((String) o.getReportSubmittingEntityID()))
				.put("actionType", ExistenceChecker.isSet((MarginActionEnum) o.getActionType()))
				.put("eventDate", ExistenceChecker.isSet((Date) o.getEventDate()))
				.put("eventTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getEventTimestamp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommonMarginReport", ValidationResult.ValidationType.ONLY_EXISTS, "CommonMarginReport", path, "");
		}
		return failure("CommonMarginReport", ValidationResult.ValidationType.ONLY_EXISTS, "CommonMarginReport", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

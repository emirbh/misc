package drr.regulation.csa.rewrite.margin.validation;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.csa.rewrite.margin.CSAMarginReport;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CSAMarginReportValidator implements Validator<CSAMarginReport> {

	private List<ComparisonResult> getComparisonResults(CSAMarginReport o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportingTimestamp", (ZonedDateTime) o.getReportingTimestamp() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterparty1", (String) o.getCounterparty1() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterparty2IdentifierType", (Boolean) o.getCounterparty2IdentifierType() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterparty2", (String) o.getCounterparty2() != null ? 1 : 0, 1, 1), 
				checkCardinality("collateralPortfolioCode", (String) o.getCollateralPortfolioCode() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralPortfolioIndicator", (Boolean) o.getCollateralPortfolioIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("uti", (String) o.getUti() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralisationCategory", (CollateralisationType3Code) o.getCollateralisationCategory() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialMarginPostedByTheCounterparty1PreHaircut", (BigDecimal) o.getInitialMarginPostedByTheCounterparty1PreHaircut() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialMarginPostedByTheCounterparty1PostHaircut", (BigDecimal) o.getInitialMarginPostedByTheCounterparty1PostHaircut() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialMarginPostedByCounterparty1Currency", (ISOCurrencyCodeEnum) o.getInitialMarginPostedByCounterparty1Currency() != null ? 1 : 0, 0, 1), 
				checkCardinality("variationMarginPostedByTheCounterparty1PreHaircut", (BigDecimal) o.getVariationMarginPostedByTheCounterparty1PreHaircut() != null ? 1 : 0, 0, 1), 
				checkCardinality("variationMarginPostedByTheCounterparty1PostHaircut", (BigDecimal) o.getVariationMarginPostedByTheCounterparty1PostHaircut() != null ? 1 : 0, 0, 1), 
				checkCardinality("variationMarginPostedByCounterparty1Currency", (ISOCurrencyCodeEnum) o.getVariationMarginPostedByCounterparty1Currency() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialMarginCollectedByCounterparty1PreHaircut", (BigDecimal) o.getInitialMarginCollectedByCounterparty1PreHaircut() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialMarginCollectedByCounterparty1PostHaircut", (BigDecimal) o.getInitialMarginCollectedByCounterparty1PostHaircut() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialMarginCollectedByCounterparty1Currency", (ISOCurrencyCodeEnum) o.getInitialMarginCollectedByCounterparty1Currency() != null ? 1 : 0, 0, 1), 
				checkCardinality("variationMarginCollectedByTheCounterparty1PreHaircut", (BigDecimal) o.getVariationMarginCollectedByTheCounterparty1PreHaircut() != null ? 1 : 0, 0, 1), 
				checkCardinality("variationMarginCollectedByTheCounterparty1PostHaircut", (BigDecimal) o.getVariationMarginCollectedByTheCounterparty1PostHaircut() != null ? 1 : 0, 0, 1), 
				checkCardinality("variationMarginCollectedByCounterparty1Currency", (ISOCurrencyCodeEnum) o.getVariationMarginCollectedByCounterparty1Currency() != null ? 1 : 0, 0, 1), 
				checkCardinality("excessCollateralPostedByTheCounterparty1", (BigDecimal) o.getExcessCollateralPostedByTheCounterparty1() != null ? 1 : 0, 0, 1), 
				checkCardinality("currencyOfTheExcessCollateralPosted", (String) o.getCurrencyOfTheExcessCollateralPosted() != null ? 1 : 0, 0, 1), 
				checkCardinality("excessCollateralCollectedByTheCounterparty1", (BigDecimal) o.getExcessCollateralCollectedByTheCounterparty1() != null ? 1 : 0, 0, 1), 
				checkCardinality("currencyOfTheExcessCollateralCollected", (String) o.getCurrencyOfTheExcessCollateralCollected() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralTimestamp", (ZonedDateTime) o.getCollateralTimestamp() != null ? 1 : 0, 0, 1), 
				checkCardinality("variationMarginCollateralPortfolioCode", (String) o.getVariationMarginCollateralPortfolioCode() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialMarginCollateralPortfolioCode", (String) o.getInitialMarginCollateralPortfolioCode() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportSubmittingEntityID", (String) o.getReportSubmittingEntityID() != null ? 1 : 0, 1, 1), 
				checkCardinality("actionType", (MarginActionEnum) o.getActionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("eventDate", (Date) o.getEventDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventTimestamp", (ZonedDateTime) o.getEventTimestamp() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterparty2IdentifierSource", (String) o.getCounterparty2IdentifierSource() != null ? 1 : 0, 1, 1), 
				checkCardinality("portfolioContainingNonReportableComponentIndicator", (Boolean) o.getPortfolioContainingNonReportableComponentIndicator() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeParty1IDType", (PartyIdentifierTypeEnum) o.getTradeParty1IDType() != null ? 1 : 0, 1, 1), 
				checkCardinality("submittingPartyIDType", (PartyIdentifierTypeEnum) o.getSubmittingPartyIDType() != null ? 1 : 0, 1, 1), 
				checkCardinality("usiID", (String) o.getUsiID() != null ? 1 : 0, 1, 1), 
				checkCardinality("usiIDPrefix", (String) o.getUsiIDPrefix() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeParty1ReportingDestination", (List<SupervisoryBodyEnum>) o.getTradeParty1ReportingDestination() == null ? 0 : o.getTradeParty1ReportingDestination().size(), 1, 0), 
				checkCardinality("comment1", (String) o.getComment1() != null ? 1 : 0, 1, 1), 
				checkCardinality("messageID", (String) o.getMessageID() != null ? 1 : 0, 1, 1), 
				checkCardinality("messageType", (String) o.getMessageType() != null ? 1 : 0, 1, 1), 
				checkCardinality("version", (String) o.getVersion() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAMarginReport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CSAMarginReport", ValidationResult.ValidationType.CARDINALITY, "CSAMarginReport", path, "", res.getError());
				}
				return success("CSAMarginReport", ValidationResult.ValidationType.CARDINALITY, "CSAMarginReport", path, "");
			})
			.collect(toList());
	}

}

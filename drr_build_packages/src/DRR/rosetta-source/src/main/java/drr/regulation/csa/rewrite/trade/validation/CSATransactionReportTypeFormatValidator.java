package drr.regulation.csa.rewrite.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CSATransactionReportTypeFormatValidator implements Validator<CSATransactionReport> {

	private List<ComparisonResult> getComparisonResults(CSATransactionReport o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("counterparty1", o.getCounterparty1(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("counterparty2", o.getCounterparty2(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkString("beneficiary1", o.getBeneficiary1(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkString("buyerIdentifier", o.getBuyerIdentifier(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkString("sellerIdentifier", o.getSellerIdentifier(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkString("centralCounterparty", o.getCentralCounterparty(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("clearingMember", o.getClearingMember(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkNumber("callAmount", o.getCallAmount(), of(25), of(5), empty(), empty()), 
				checkNumber("putAmount", o.getPutAmount(), of(25), of(5), empty(), empty()), 
				checkNumber("delta", o.getDelta(), of(25), of(5), empty(), empty()), 
				checkString("packageIdentifier", o.getPackageIdentifier(), 1, of(100), of(Pattern.compile("[a-zA-Z0-9]{1,100}"))), 
				checkString("priceUnitOfMeasure", o.getPriceUnitOfMeasure(), 1, of(4), empty()), 
				checkNumber("optionPremiumAmount", o.getOptionPremiumAmount(), of(25), of(5), empty(), empty()), 
				checkNumber("exchangeRate", o.getExchangeRate(), of(18), of(13), empty(), empty()), 
				checkString("exchangeRateBasis", o.getExchangeRateBasis(), 7, of(7), of(Pattern.compile("[A-Z]{3,3}/[A-Z]{3,3}"))), 
				checkNumber("cdSIndexAttachmentPoint", o.getCdSIndexAttachmentPoint(), of(11), of(10), empty(), empty()), 
				checkNumber("cdSIndexDetachmentPoint", o.getCdSIndexDetachmentPoint(), of(11), of(10), empty(), empty()), 
				checkString("priorUTI", o.getPriorUTI(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}"))), 
				checkNumber("valuationAmount", o.getValuationAmount(), of(25), of(5), empty(), empty()), 
				checkString("customBasketCode", o.getCustomBasketCode(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}"))), 
				checkString("underlyingIdOther", o.getUnderlyingIdOther(), 1, of(210), empty()), 
				checkString("underlyingAssetTradingPlatformIdentifier", o.getUnderlyingAssetTradingPlatformIdentifier(), 1, of(4), empty()), 
				checkString("underlyingAssetPriceSource", o.getUnderlyingAssetPriceSource(), 1, of(50), of(Pattern.compile("[a-zA-Z0-9]{1,50}"))), 
				checkString("eventIdentifier", o.getEventIdentifier(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}"))), 
				checkString("platformIdentifier", o.getPlatformIdentifier(), 1, of(4), empty()), 
				checkString("executionAgentCounterparty2", o.getExecutionAgentCounterparty2(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("corporateSectorOfTheCounterparty1", o.getCorporateSectorOfTheCounterparty1(), 1, of(4), empty()), 
				checkString("corporateSectorOfTheCounterparty2", o.getCorporateSectorOfTheCounterparty2(), 1, of(4), empty()), 
				checkString("counterparty2Name", o.getCounterparty2Name(), 1, of(150), empty()), 
				checkString("reportSubmittingEntityID", o.getReportSubmittingEntityID(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("entityResponsibleForReporting", o.getEntityResponsibleForReporting(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("brokerID", o.getBrokerID(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkNumber("masterAgreementVersion", o.getMasterAgreementVersion(), empty(), of(0), empty(), empty()), 
				checkString("secondaryTransactionIdentifier", o.getSecondaryTransactionIdentifier(), 1, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkString("underlyingIdentification", o.getUnderlyingIdentification(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}[A-Z0-9]{9,9}[0-9]{1,1}"))), 
				checkString("nameOfTheUnderlyingIndex", o.getNameOfTheUnderlyingIndex(), 1, of(50), of(Pattern.compile("[a-zA-Z0-9 \\:.\\-_\\&]{1,50}"))), 
				checkString("swapLinkID", o.getSwapLinkID(), 1, of(35), of(Pattern.compile("[a-zA-Z0-9]{1,35}"))), 
				checkString("priorUTIProprietary", o.getPriorUTIProprietary(), 0, of(72), of(Pattern.compile("[a-zA-Z0-9]{1}[a-zA-Z0-9\\:.\\-_]{0,70}[a-zA-Z0-9]{1}"))), 
				checkString("uniqueTransactionIdentifier", o.getUniqueTransactionIdentifier(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18}[0-9]{2}(?:[A-Z0-9\\:.\\-_]{0,31}[A-Z0-9])?"))), 
				checkString("uniqueTransactionIdentifierProprietary", o.getUniqueTransactionIdentifierProprietary(), 0, of(72), of(Pattern.compile("[a-zA-Z0-9]{1}[a-zA-Z0-9\\:.\\-_]{0,70}[a-zA-Z0-9]{1}"))), 
				checkString("originalSwapUTI", o.getOriginalSwapUTI(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}"))), 
				checkString("subsequentPositionUTI", o.getSubsequentPositionUTI(), 0, of(52), of(Pattern.compile("[a-zA-Z0-9]{1}[a-zA-Z0-9\\:.\\-_]{0,50}[a-zA-Z0-9]{1}"))), 
				checkString("originalSwapSDRIdentifier", o.getOriginalSwapSDRIdentifier(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("priorUSI", o.getPriorUSI(), 1, of(42), of(Pattern.compile("[a-zA-Z0-9]{1,42}"))), 
				checkString("newSDRIdentifier", o.getNewSDRIdentifier(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkNumber("series", o.getSeries(), of(5), of(0), empty(), empty()), 
				checkNumber("indexFactor", o.getIndexFactor(), of(11), of(10), empty(), empty()), 
				checkNumber("seriesVersion", o.getSeriesVersion(), of(5), of(0), empty(), empty()), 
				checkString("initialMarginCollateralPortfolioCode", o.getInitialMarginCollateralPortfolioCode(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}"))), 
				checkString("variationMarginCollateralPortfolioCode", o.getVariationMarginCollateralPortfolioCode(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}"))), 
				checkString("countryAndProvinceOrTerritoryOfIndividual", o.getCountryAndProvinceOrTerritoryOfIndividual(), 1, of(5), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CSATransactionReport", ValidationResult.ValidationType.TYPE_FORMAT, "CSATransactionReport", path, "", res.getError());
				}
				return success("CSATransactionReport", ValidationResult.ValidationType.TYPE_FORMAT, "CSATransactionReport", path, "");
			})
			.collect(toList());
	}

}

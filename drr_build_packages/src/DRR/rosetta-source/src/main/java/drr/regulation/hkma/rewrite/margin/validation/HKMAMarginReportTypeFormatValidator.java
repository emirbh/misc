package drr.regulation.hkma.rewrite.margin.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.hkma.rewrite.margin.HKMAMarginReport;
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

public class HKMAMarginReportTypeFormatValidator implements Validator<HKMAMarginReport> {

	private List<ComparisonResult> getComparisonResults(HKMAMarginReport o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("counterparty1", o.getCounterparty1(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("counterparty2", o.getCounterparty2(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkString("collateralPortfolioCode", o.getCollateralPortfolioCode(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}"))), 
				checkString("uti", o.getUti(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18}[0-9]{2}[A-Z0-9]{0,32}"))), 
				checkNumber("initialMarginPostedByTheCounterparty1PreHaircut", o.getInitialMarginPostedByTheCounterparty1PreHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("initialMarginPostedByTheCounterparty1PostHaircut", o.getInitialMarginPostedByTheCounterparty1PostHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("variationMarginPostedByTheCounterparty1PreHaircut", o.getVariationMarginPostedByTheCounterparty1PreHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("variationMarginPostedByTheCounterparty1PostHaircut", o.getVariationMarginPostedByTheCounterparty1PostHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("initialMarginCollectedByCounterparty1PreHaircut", o.getInitialMarginCollectedByCounterparty1PreHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("initialMarginCollectedByCounterparty1PostHaircut", o.getInitialMarginCollectedByCounterparty1PostHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("variationMarginCollectedByTheCounterparty1PreHaircut", o.getVariationMarginCollectedByTheCounterparty1PreHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("variationMarginCollectedByTheCounterparty1PostHaircut", o.getVariationMarginCollectedByTheCounterparty1PostHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("excessCollateralPostedByTheCounterparty1", o.getExcessCollateralPostedByTheCounterparty1(), of(25), of(5), empty(), empty()), 
				checkNumber("excessCollateralCollectedByTheCounterparty1", o.getExcessCollateralCollectedByTheCounterparty1(), of(25), of(5), empty(), empty()), 
				checkString("variationMarginCollateralPortfolioCode", o.getVariationMarginCollateralPortfolioCode(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}"))), 
				checkString("initialMarginCollateralPortfolioCode", o.getInitialMarginCollateralPortfolioCode(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}"))), 
				checkNumber("numberRecords", o.getNumberRecords(), of(25), of(5), empty(), empty()), 
				checkString("counterparty2Name", o.getCounterparty2Name(), 1, of(105), of(Pattern.compile("[a-zA-Z0-9]{1,105}"))), 
				checkString("entityResponsibleForReporting", o.getEntityResponsibleForReporting(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMAMarginReport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("HKMAMarginReport", ValidationResult.ValidationType.TYPE_FORMAT, "HKMAMarginReport", path, "", res.getError());
				}
				return success("HKMAMarginReport", ValidationResult.ValidationType.TYPE_FORMAT, "HKMAMarginReport", path, "");
			})
			.collect(toList());
	}

}

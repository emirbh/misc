package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CommonCollateralReport;
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

public class CommonCollateralReportTypeFormatValidator implements Validator<CommonCollateralReport> {

	private List<ComparisonResult> getComparisonResults(CommonCollateralReport o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("uti", o.getUti(), 0, of(52), of(Pattern.compile("[a-zA-Z0-9]{1}[a-zA-Z0-9\\:.\\-_]{0,50}[a-zA-Z0-9]{1}"))), 
				checkNumber("initialMarginPostedByTheCounterparty1PreHaircut", o.getInitialMarginPostedByTheCounterparty1PreHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("initialMarginPostedByTheCounterparty1PostHaircut", o.getInitialMarginPostedByTheCounterparty1PostHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("variationMarginPostedByTheCounterparty1PreHaircut", o.getVariationMarginPostedByTheCounterparty1PreHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("variationMarginPostedByTheCounterparty1PostHaircut", o.getVariationMarginPostedByTheCounterparty1PostHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("initialMarginCollectedByCounterparty1PreHaircut", o.getInitialMarginCollectedByCounterparty1PreHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("initialMarginCollectedByCounterparty1PostHaircut", o.getInitialMarginCollectedByCounterparty1PostHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("variationMarginCollectedByTheCounterparty1PreHaircut", o.getVariationMarginCollectedByTheCounterparty1PreHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("variationMarginCollectedByTheCounterparty1PostHaircut", o.getVariationMarginCollectedByTheCounterparty1PostHaircut(), of(25), of(5), empty(), empty()), 
				checkNumber("excessCollateralPostedByTheCounterparty1", o.getExcessCollateralPostedByTheCounterparty1(), of(25), of(5), empty(), empty()), 
				checkNumber("excessCollateralCollectedByTheCounterparty1", o.getExcessCollateralCollectedByTheCounterparty1(), of(25), of(5), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonCollateralReport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonCollateralReport", ValidationResult.ValidationType.TYPE_FORMAT, "CommonCollateralReport", path, "", res.getError());
				}
				return success("CommonCollateralReport", ValidationResult.ValidationType.TYPE_FORMAT, "CommonCollateralReport", path, "");
			})
			.collect(toList());
	}

}

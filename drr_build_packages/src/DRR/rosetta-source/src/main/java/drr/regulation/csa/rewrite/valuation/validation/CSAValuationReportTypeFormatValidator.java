package drr.regulation.csa.rewrite.valuation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.valuation.CSAValuationReport;
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

public class CSAValuationReportTypeFormatValidator implements Validator<CSAValuationReport> {

	private List<ComparisonResult> getComparisonResults(CSAValuationReport o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("counterparty1", o.getCounterparty1(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("counterparty2", o.getCounterparty2(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkNumber("valuationAmount", o.getValuationAmount(), of(25), of(5), empty(), empty()), 
				checkNumber("delta", o.getDelta(), of(25), of(5), empty(), empty()), 
				checkString("entityResponsibleForReporting", o.getEntityResponsibleForReporting(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("counterparty2IdentifierSource", o.getCounterparty2IdentifierSource(), 1, of(4), empty()), 
				checkString("uniqueTransactionIdentifier", o.getUniqueTransactionIdentifier(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18}[0-9]{2}(?:[A-Z0-9\\:.\\-_]{0,31}[A-Z0-9])?"))), 
				checkString("uniqueTransactionIdentifierProprietary", o.getUniqueTransactionIdentifierProprietary(), 0, of(72), of(Pattern.compile("[a-zA-Z0-9]{1}[a-zA-Z0-9\\:.\\-_]{0,70}[a-zA-Z0-9]{1}"))), 
				checkString("variationMarginCollateralPortfolioCode", o.getVariationMarginCollateralPortfolioCode(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}"))), 
				checkString("initialMarginCollateralPortfolioCode", o.getInitialMarginCollateralPortfolioCode(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}"))), 
				checkNumber("lastFloatingReferenceValueLeg1", o.getLastFloatingReferenceValueLeg1(), of(11), of(10), empty(), empty()), 
				checkNumber("lastFloatingReferenceValueLeg2", o.getLastFloatingReferenceValueLeg2(), of(11), of(10), empty(), empty()), 
				checkString("uniqueProductIdentifier", o.getUniqueProductIdentifier(), 1, of(52), of(Pattern.compile("[a-zA-Z0-9]{1,52}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAValuationReport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CSAValuationReport", ValidationResult.ValidationType.TYPE_FORMAT, "CSAValuationReport", path, "", res.getError());
				}
				return success("CSAValuationReport", ValidationResult.ValidationType.TYPE_FORMAT, "CSAValuationReport", path, "");
			})
			.collect(toList());
	}

}

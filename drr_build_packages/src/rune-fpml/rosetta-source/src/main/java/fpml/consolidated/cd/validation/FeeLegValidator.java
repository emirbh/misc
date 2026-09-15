package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.cd.InitialPayment;
import fpml.consolidated.cd.PeriodicPayment;
import fpml.consolidated.fpmlenum.QuotationStyleEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FeeLegValidator implements Validator<FeeLeg> {

	private List<ComparisonResult> getComparisonResults(FeeLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialPayment", (InitialPayment) o.getInitialPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodicPayment", (PeriodicPayment) o.getPeriodicPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketFixedRate", (BigDecimal) o.getMarketFixedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDelay", (Boolean) o.getPaymentDelay() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialPoints", (BigDecimal) o.getInitialPoints() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketPrice", (BigDecimal) o.getMarketPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotationStyle", (QuotationStyleEnum) o.getQuotationStyle() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeeLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FeeLeg", ValidationResult.ValidationType.CARDINALITY, "FeeLeg", path, "", res.getError());
				}
				return success("FeeLeg", ValidationResult.ValidationType.CARDINALITY, "FeeLeg", path, "");
			})
			.collect(toList());
	}

}

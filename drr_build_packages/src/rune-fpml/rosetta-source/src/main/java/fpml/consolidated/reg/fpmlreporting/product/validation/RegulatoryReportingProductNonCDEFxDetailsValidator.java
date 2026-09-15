package fpml.consolidated.reg.fpmlreporting.product.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductNonCDEFxDetails;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingProductNonCDEFxDetailsValidator implements Validator<RegulatoryReportingProductNonCDEFxDetails> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingProductNonCDEFxDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fxType", (String) o.getFxType() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryCurrency", (Currency) o.getDeliveryCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryCurrency2", (Currency) o.getDeliveryCurrency2() != null ? 1 : 0, 0, 1), 
				checkCardinality("forwardExchangeRate", (BigDecimal) o.getForwardExchangeRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingProductNonCDEFxDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingProductNonCDEFxDetails", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingProductNonCDEFxDetails", path, "", res.getError());
				}
				return success("RegulatoryReportingProductNonCDEFxDetails", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingProductNonCDEFxDetails", path, "");
			})
			.collect(toList());
	}

}

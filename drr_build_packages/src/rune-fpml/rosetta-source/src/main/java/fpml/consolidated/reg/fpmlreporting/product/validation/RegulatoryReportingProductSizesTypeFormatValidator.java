package fpml.consolidated.reg.fpmlreporting.product.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductSizes;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingProductSizesTypeFormatValidator implements Validator<RegulatoryReportingProductSizes> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingProductSizes o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("quantity", o.getQuantity(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("quantityFrequency", o.getQuantityFrequency(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("totalNotionalQuantity", o.getTotalNotionalQuantity(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingProductSizes o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingProductSizes", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryReportingProductSizes", path, "", res.getError());
				}
				return success("RegulatoryReportingProductSizes", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryReportingProductSizes", path, "");
			})
			.collect(toList());
	}

}

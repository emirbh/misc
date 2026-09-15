package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityMarketDisruption;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CommodityMarketDisruptionTypeFormatValidator implements Validator<CommodityMarketDisruption> {

	private List<ComparisonResult> getComparisonResults(CommodityMarketDisruption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("maximumNumberOfDaysOfDisruption", o.getMaximumNumberOfDaysOfDisruption(), empty(), of(0), of(new BigDecimal("0")), empty()), 
				checkNumber("minimumFuturesContracts", o.getMinimumFuturesContracts(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMarketDisruption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityMarketDisruption", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityMarketDisruption", path, "", res.getError());
				}
				return success("CommodityMarketDisruption", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityMarketDisruption", path, "");
			})
			.collect(toList());
	}

}

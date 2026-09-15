package drr.regulation.jfsa.rewrite.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.jfsa.rewrite.trade.NotionalQuantityScheduleLeg1Report;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NotionalQuantityScheduleLeg1ReportValidator implements Validator<NotionalQuantityScheduleLeg1Report> {

	private List<ComparisonResult> getComparisonResults(NotionalQuantityScheduleLeg1Report o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", (Date) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("endDate", (Date) o.getEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("value", (BigDecimal) o.getValue() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalQuantityScheduleLeg1Report o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalQuantityScheduleLeg1Report", ValidationResult.ValidationType.CARDINALITY, "NotionalQuantityScheduleLeg1Report", path, "", res.getError());
				}
				return success("NotionalQuantityScheduleLeg1Report", ValidationResult.ValidationType.CARDINALITY, "NotionalQuantityScheduleLeg1Report", path, "");
			})
			.collect(toList());
	}

}

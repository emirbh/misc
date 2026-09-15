package drr.regulation.jfsa.rewrite.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.jfsa.rewrite.trade.NotionalQuantityScheduleLeg1Report;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class NotionalQuantityScheduleLeg1ReportTypeFormatValidator implements Validator<NotionalQuantityScheduleLeg1Report> {

	private List<ComparisonResult> getComparisonResults(NotionalQuantityScheduleLeg1Report o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("value", o.getValue(), of(25), of(5), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalQuantityScheduleLeg1Report o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalQuantityScheduleLeg1Report", ValidationResult.ValidationType.TYPE_FORMAT, "NotionalQuantityScheduleLeg1Report", path, "", res.getError());
				}
				return success("NotionalQuantityScheduleLeg1Report", ValidationResult.ValidationType.TYPE_FORMAT, "NotionalQuantityScheduleLeg1Report", path, "");
			})
			.collect(toList());
	}

}

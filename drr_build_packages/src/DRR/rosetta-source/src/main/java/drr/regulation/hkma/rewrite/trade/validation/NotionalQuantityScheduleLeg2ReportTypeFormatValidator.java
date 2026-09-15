package drr.regulation.hkma.rewrite.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.hkma.rewrite.trade.NotionalQuantityScheduleLeg2Report;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class NotionalQuantityScheduleLeg2ReportTypeFormatValidator implements Validator<NotionalQuantityScheduleLeg2Report> {

	private List<ComparisonResult> getComparisonResults(NotionalQuantityScheduleLeg2Report o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("quantity", o.getQuantity(), of(25), of(5), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalQuantityScheduleLeg2Report o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalQuantityScheduleLeg2Report", ValidationResult.ValidationType.TYPE_FORMAT, "NotionalQuantityScheduleLeg2Report", path, "", res.getError());
				}
				return success("NotionalQuantityScheduleLeg2Report", ValidationResult.ValidationType.TYPE_FORMAT, "NotionalQuantityScheduleLeg2Report", path, "");
			})
			.collect(toList());
	}

}

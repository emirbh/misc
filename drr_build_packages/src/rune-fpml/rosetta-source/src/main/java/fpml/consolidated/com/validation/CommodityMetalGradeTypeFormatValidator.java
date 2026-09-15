package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityMetalGrade;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CommodityMetalGradeTypeFormatValidator implements Validator<CommodityMetalGrade> {

	private List<ComparisonResult> getComparisonResults(CommodityMetalGrade o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("commodityMetalGradeScheme", o.getCommodityMetalGradeScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMetalGrade o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityMetalGrade", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityMetalGrade", path, "", res.getError());
				}
				return success("CommodityMetalGrade", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityMetalGrade", path, "");
			})
			.collect(toList());
	}

}

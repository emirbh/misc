package fpml.consolidated.reg.fpmlreporting.product.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.OptionTypeEnum;
import fpml.consolidated.generic.GenericExerciseStyle;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingNonCDEOptionDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingNonCDEOptionDetailsValidator implements Validator<RegulatoryReportingNonCDEOptionDetails> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingNonCDEOptionDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("optionType", (OptionTypeEnum) o.getOptionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseStyle", (GenericExerciseStyle) o.getExerciseStyle() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingNonCDEOptionDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingNonCDEOptionDetails", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingNonCDEOptionDetails", path, "", res.getError());
				}
				return success("RegulatoryReportingNonCDEOptionDetails", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingNonCDEOptionDetails", path, "");
			})
			.collect(toList());
	}

}

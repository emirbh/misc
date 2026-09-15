package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.ReportingSide;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.RegimeReportingSide;
import drr.regulation.common.SupervisoryBodyEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegimeReportingSideValidator implements Validator<RegimeReportingSide> {

	private List<ComparisonResult> getComparisonResults(RegimeReportingSide o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("regimeName", (RegimeNameEnum) o.getRegimeName() != null ? 1 : 0, 1, 1), 
				checkCardinality("supervisoryBody", (SupervisoryBodyEnum) o.getSupervisoryBody() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingSide", (ReportingSide) o.getReportingSide() != null ? 1 : 0, 0, 1), 
				checkCardinality("delegatedReportingSide", (ReportingSide) o.getDelegatedReportingSide() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegimeReportingSide o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegimeReportingSide", ValidationResult.ValidationType.CARDINALITY, "RegimeReportingSide", path, "", res.getError());
				}
				return success("RegimeReportingSide", ValidationResult.ValidationType.CARDINALITY, "RegimeReportingSide", path, "");
			})
			.collect(toList());
	}

}

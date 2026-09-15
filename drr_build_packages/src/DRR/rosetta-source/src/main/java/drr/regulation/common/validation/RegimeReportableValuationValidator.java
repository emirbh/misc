package drr.regulation.common.validation;

import cdm.product.collateral.Collateral;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.RegimeReportableValuation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ValuationDetails;
import drr.standards.iso.ReportLevelEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegimeReportableValuationValidator implements Validator<RegimeReportableValuation> {

	private List<ComparisonResult> getComparisonResults(RegimeReportableValuation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("valuationDetails", (ValuationDetails) o.getValuationDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportableInformation", (ReportableInformation) o.getReportableInformation() != null ? 1 : 0, 1, 1), 
				checkCardinality("collateralDetails", (Collateral) o.getCollateralDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("level", (ReportLevelEnum) o.getLevel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegimeReportableValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegimeReportableValuation", ValidationResult.ValidationType.CARDINALITY, "RegimeReportableValuation", path, "", res.getError());
				}
				return success("RegimeReportableValuation", ValidationResult.ValidationType.CARDINALITY, "RegimeReportableValuation", path, "");
			})
			.collect(toList());
	}

}

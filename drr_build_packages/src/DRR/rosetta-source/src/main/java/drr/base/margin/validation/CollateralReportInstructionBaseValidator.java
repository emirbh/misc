package drr.base.margin.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.margin.CollateralDetails;
import drr.base.margin.CollateralReportInstructionBase;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.ReportingSide;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralReportInstructionBaseValidator implements Validator<CollateralReportInstructionBase> {

	private List<ComparisonResult> getComparisonResults(CollateralReportInstructionBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("collateralDetails", (CollateralDetails) o.getCollateralDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportableInformation", (ReportableInformationBase) o.getReportableInformation() != null ? 1 : 0, 1, 1), 
				checkCardinality("reportingSide", (ReportingSide) o.getReportingSide() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralReportInstructionBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralReportInstructionBase", ValidationResult.ValidationType.CARDINALITY, "CollateralReportInstructionBase", path, "", res.getError());
				}
				return success("CollateralReportInstructionBase", ValidationResult.ValidationType.CARDINALITY, "CollateralReportInstructionBase", path, "");
			})
			.collect(toList());
	}

}

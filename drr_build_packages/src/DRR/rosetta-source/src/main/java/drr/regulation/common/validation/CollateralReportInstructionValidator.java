package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.margin.CollateralDetails;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.ReportableInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralReportInstructionValidator implements Validator<CollateralReportInstruction> {

	private List<ComparisonResult> getComparisonResults(CollateralReportInstruction o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("collateralDetails", (CollateralDetails) o.getCollateralDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportableInformation", (ReportableInformation) o.getReportableInformation() != null ? 1 : 0, 1, 1), 
				checkCardinality("reportingSide", (ReportingSide) o.getReportingSide() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralReportInstruction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralReportInstruction", ValidationResult.ValidationType.CARDINALITY, "CollateralReportInstruction", path, "", res.getError());
				}
				return success("CollateralReportInstruction", ValidationResult.ValidationType.CARDINALITY, "CollateralReportInstruction", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.RegReportingPackageInfo;
import fpml.consolidated.shared.IssuerTradeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegReportingPackageInfoValidator implements Validator<RegReportingPackageInfo> {

	private List<ComparisonResult> getComparisonResults(RegReportingPackageInfo o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("packageIdentifier", (IssuerTradeId) o.getPackageIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("pacakageWithNonReportableComponent", (Boolean) o.getPacakageWithNonReportableComponent() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegReportingPackageInfo o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegReportingPackageInfo", ValidationResult.ValidationType.CARDINALITY, "RegReportingPackageInfo", path, "", res.getError());
				}
				return success("RegReportingPackageInfo", ValidationResult.ValidationType.CARDINALITY, "RegReportingPackageInfo", path, "");
			})
			.collect(toList());
	}

}

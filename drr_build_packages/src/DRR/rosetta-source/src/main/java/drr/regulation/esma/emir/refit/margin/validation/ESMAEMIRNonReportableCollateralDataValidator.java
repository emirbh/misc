package drr.regulation.esma.emir.refit.margin.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRNonReportableCollateralData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ESMAEMIRNonReportableCollateralDataValidator implements Validator<ESMAEMIRNonReportableCollateralData> {

	private List<ComparisonResult> getComparisonResults(ESMAEMIRNonReportableCollateralData o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("enrichment", (EnrichmentData) o.getEnrichment() != null ? 1 : 0, 0, 1), 
				checkCardinality("mic", (String) o.getMic() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRNonReportableCollateralData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ESMAEMIRNonReportableCollateralData", ValidationResult.ValidationType.CARDINALITY, "ESMAEMIRNonReportableCollateralData", path, "", res.getError());
				}
				return success("ESMAEMIRNonReportableCollateralData", ValidationResult.ValidationType.CARDINALITY, "ESMAEMIRNonReportableCollateralData", path, "");
			})
			.collect(toList());
	}

}

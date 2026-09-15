package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.AbsoluteTolerance;
import fpml.consolidated.com.OilDelivery;
import fpml.consolidated.com.OilPipelineDelivery;
import fpml.consolidated.com.OilTransferDelivery;
import fpml.consolidated.com.PercentageTolerance;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OilDeliveryValidator implements Validator<OilDelivery> {

	private List<ComparisonResult> getComparisonResults(OilDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("pipeline", (OilPipelineDelivery) o.getPipeline() != null ? 1 : 0, 0, 1), 
				checkCardinality("transfer", (OilTransferDelivery) o.getTransfer() != null ? 1 : 0, 0, 1), 
				checkCardinality("importerOfRecord", (PartyReference) o.getImporterOfRecord() != null ? 1 : 0, 0, 1), 
				checkCardinality("absoluteTolerance", (AbsoluteTolerance) o.getAbsoluteTolerance() != null ? 1 : 0, 0, 1), 
				checkCardinality("percentageTolerance", (PercentageTolerance) o.getPercentageTolerance() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OilDelivery", ValidationResult.ValidationType.CARDINALITY, "OilDelivery", path, "", res.getError());
				}
				return success("OilDelivery", ValidationResult.ValidationType.CARDINALITY, "OilDelivery", path, "");
			})
			.collect(toList());
	}

}

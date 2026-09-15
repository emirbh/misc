package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbAGRI;
import drr.standards.iosco.upi.AnnaDsbAdditionalSubProduct;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbAGRIValidator implements Validator<AnnaDsbAGRI> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbAGRI o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("SEAF", (AnnaDsbEmpty) o.getSEAF() != null ? 1 : 0, 0, 1), 
				checkCardinality("GRIN", (AnnaDsbAdditionalSubProduct) o.getGRIN() != null ? 1 : 0, 0, 1), 
				checkCardinality("OOLI", (AnnaDsbAdditionalSubProduct) o.getOOLI() != null ? 1 : 0, 0, 1), 
				checkCardinality("POTA", (AnnaDsbEmpty) o.getPOTA() != null ? 1 : 0, 0, 1), 
				checkCardinality("DIRY", (AnnaDsbEmpty) o.getDIRY() != null ? 1 : 0, 0, 1), 
				checkCardinality("FRST", (AnnaDsbEmpty) o.getFRST() != null ? 1 : 0, 0, 1), 
				checkCardinality("SOFT", (AnnaDsbAdditionalSubProduct) o.getSOFT() != null ? 1 : 0, 0, 1), 
				checkCardinality("LSTK", (AnnaDsbEmpty) o.getLSTK() != null ? 1 : 0, 0, 1), 
				checkCardinality("GROS", (AnnaDsbAdditionalSubProduct) o.getGROS() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbAGRI o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbAGRI", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbAGRI", path, "", res.getError());
				}
				return success("AnnaDsbAGRI", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbAGRI", path, "");
			})
			.collect(toList());
	}

}

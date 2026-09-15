package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbFRTL;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbFRTLValidator implements Validator<AnnaDsbFRTL> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbFRTL o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("AMMO", (AnnaDsbEmpty) o.getAMMO() != null ? 1 : 0, 0, 1), 
				checkCardinality("SLPH", (AnnaDsbEmpty) o.getSLPH() != null ? 1 : 0, 0, 1), 
				checkCardinality("DAPH", (AnnaDsbEmpty) o.getDAPH() != null ? 1 : 0, 0, 1), 
				checkCardinality("PTSH", (AnnaDsbEmpty) o.getPTSH() != null ? 1 : 0, 0, 1), 
				checkCardinality("UREA", (AnnaDsbEmpty) o.getUREA() != null ? 1 : 0, 0, 1), 
				checkCardinality("UAAN", (AnnaDsbEmpty) o.getUAAN() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbFRTL o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbFRTL", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbFRTL", path, "", res.getError());
				}
				return success("AnnaDsbFRTL", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbFRTL", path, "");
			})
			.collect(toList());
	}

}

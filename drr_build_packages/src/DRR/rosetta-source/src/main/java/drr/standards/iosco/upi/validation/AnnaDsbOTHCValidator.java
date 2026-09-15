package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbOTHC;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbOTHCValidator implements Validator<AnnaDsbOTHC> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbOTHC o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("DLVR", (AnnaDsbEmpty) o.getDLVR() != null ? 1 : 0, 0, 1), 
				checkCardinality("NDLV", (AnnaDsbEmpty) o.getNDLV() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbOTHC o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbOTHC", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbOTHC", path, "", res.getError());
				}
				return success("AnnaDsbOTHC", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbOTHC", path, "");
			})
			.collect(toList());
	}

}

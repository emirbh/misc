package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbPAPR;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbPAPRValidator implements Validator<AnnaDsbPAPR> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbPAPR o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("PULP", (AnnaDsbEmpty) o.getPULP() != null ? 1 : 0, 0, 1), 
				checkCardinality("NSPT", (AnnaDsbEmpty) o.getNSPT() != null ? 1 : 0, 0, 1), 
				checkCardinality("RCVP", (AnnaDsbEmpty) o.getRCVP() != null ? 1 : 0, 0, 1), 
				checkCardinality("CBRD", (AnnaDsbEmpty) o.getCBRD() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbPAPR o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbPAPR", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbPAPR", path, "", res.getError());
				}
				return success("AnnaDsbPAPR", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbPAPR", path, "");
			})
			.collect(toList());
	}

}

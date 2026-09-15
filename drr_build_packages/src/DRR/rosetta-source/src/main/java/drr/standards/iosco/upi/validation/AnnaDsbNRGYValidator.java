package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbAdditionalSubProduct;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbNRGY;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbNRGYValidator implements Validator<AnnaDsbNRGY> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbNRGY o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("RNNG", (AnnaDsbEmpty) o.getRNNG() != null ? 1 : 0, 0, 1), 
				checkCardinality("LGHT", (AnnaDsbEmpty) o.getLGHT() != null ? 1 : 0, 0, 1), 
				checkCardinality("ELEC", (AnnaDsbAdditionalSubProduct) o.getELEC() != null ? 1 : 0, 0, 1), 
				checkCardinality("DIST", (AnnaDsbEmpty) o.getDIST() != null ? 1 : 0, 0, 1), 
				checkCardinality("COAL", (AnnaDsbEmpty) o.getCOAL() != null ? 1 : 0, 0, 1), 
				checkCardinality("INRG", (AnnaDsbEmpty) o.getINRG() != null ? 1 : 0, 0, 1), 
				checkCardinality("OILP", (AnnaDsbAdditionalSubProduct) o.getOILP() != null ? 1 : 0, 0, 1), 
				checkCardinality("NGAS", (AnnaDsbAdditionalSubProduct) o.getNGAS() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbNRGY o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbNRGY", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbNRGY", path, "", res.getError());
				}
				return success("AnnaDsbNRGY", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbNRGY", path, "");
			})
			.collect(toList());
	}

}

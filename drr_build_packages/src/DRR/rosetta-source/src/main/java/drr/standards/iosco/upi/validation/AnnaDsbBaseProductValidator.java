package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbAGRI;
import drr.standards.iosco.upi.AnnaDsbBaseProduct;
import drr.standards.iosco.upi.AnnaDsbENVR;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbFRGT;
import drr.standards.iosco.upi.AnnaDsbFRTL;
import drr.standards.iosco.upi.AnnaDsbINDP;
import drr.standards.iosco.upi.AnnaDsbMETL;
import drr.standards.iosco.upi.AnnaDsbNRGY;
import drr.standards.iosco.upi.AnnaDsbOTHC;
import drr.standards.iosco.upi.AnnaDsbPAPR;
import drr.standards.iosco.upi.AnnaDsbPOLY;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbBaseProductValidator implements Validator<AnnaDsbBaseProduct> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbBaseProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("AGRI", (AnnaDsbAGRI) o.getAGRI() != null ? 1 : 0, 0, 1), 
				checkCardinality("ENVR", (AnnaDsbENVR) o.getENVR() != null ? 1 : 0, 0, 1), 
				checkCardinality("FRTL", (AnnaDsbFRTL) o.getFRTL() != null ? 1 : 0, 0, 1), 
				checkCardinality("OTHC", (AnnaDsbOTHC) o.getOTHC() != null ? 1 : 0, 0, 1), 
				checkCardinality("INFL", (AnnaDsbEmpty) o.getINFL() != null ? 1 : 0, 0, 1), 
				checkCardinality("POLY", (AnnaDsbPOLY) o.getPOLY() != null ? 1 : 0, 0, 1), 
				checkCardinality("OTHR", (AnnaDsbEmpty) o.getOTHR() != null ? 1 : 0, 0, 1), 
				checkCardinality("MCEX", (AnnaDsbEmpty) o.getMCEX() != null ? 1 : 0, 0, 1), 
				checkCardinality("NRGY", (AnnaDsbNRGY) o.getNRGY() != null ? 1 : 0, 0, 1), 
				checkCardinality("INDP", (AnnaDsbINDP) o.getINDP() != null ? 1 : 0, 0, 1), 
				checkCardinality("OEST", (AnnaDsbEmpty) o.getOEST() != null ? 1 : 0, 0, 1), 
				checkCardinality("METL", (AnnaDsbMETL) o.getMETL() != null ? 1 : 0, 0, 1), 
				checkCardinality("PAPR", (AnnaDsbPAPR) o.getPAPR() != null ? 1 : 0, 0, 1), 
				checkCardinality("FRGT", (AnnaDsbFRGT) o.getFRGT() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbBaseProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbBaseProduct", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbBaseProduct", path, "", res.getError());
				}
				return success("AnnaDsbBaseProduct", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbBaseProduct", path, "");
			})
			.collect(toList());
	}

}

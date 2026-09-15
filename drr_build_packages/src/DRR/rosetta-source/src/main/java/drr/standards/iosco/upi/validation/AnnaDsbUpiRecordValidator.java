package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbAttributesRecord;
import drr.standards.iosco.upi.AnnaDsbDerived;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbIdentifier;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbUpiRecordValidator implements Validator<AnnaDsbUpiRecord> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbUpiRecord o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("Identifier", (AnnaDsbIdentifier) o.getIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("Header", (AnnaDsbHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("Derived", (AnnaDsbDerived) o.getDerived() != null ? 1 : 0, 1, 1), 
				checkCardinality("Attributes", (AnnaDsbAttributesRecord) o.getAttributes() != null ? 1 : 0, 1, 1), 
				checkCardinality("TemplateVersion", (Integer) o.getTemplateVersion() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbUpiRecord o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbUpiRecord", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbUpiRecord", path, "", res.getError());
				}
				return success("AnnaDsbUpiRecord", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbUpiRecord", path, "");
			})
			.collect(toList());
	}

}

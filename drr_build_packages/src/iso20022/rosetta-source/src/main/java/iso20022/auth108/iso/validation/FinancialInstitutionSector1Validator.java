package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.FinancialInstitutionSector1;
import iso20022.auth108.iso.FinancialPartyClassification2Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FinancialInstitutionSector1Validator implements Validator<FinancialInstitutionSector1> {

	private List<ComparisonResult> getComparisonResults(FinancialInstitutionSector1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("sctr", (List<? extends FinancialPartyClassification2Choice>) o.getSctr() == null ? 0 : o.getSctr().size(), 1, 0), 
				checkCardinality("clrThrshld", (Boolean) o.getClrThrshld() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinancialInstitutionSector1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FinancialInstitutionSector1", ValidationResult.ValidationType.CARDINALITY, "FinancialInstitutionSector1", path, "", res.getError());
				}
				return success("FinancialInstitutionSector1", ValidationResult.ValidationType.CARDINALITY, "FinancialInstitutionSector1", path, "");
			})
			.collect(toList());
	}

}

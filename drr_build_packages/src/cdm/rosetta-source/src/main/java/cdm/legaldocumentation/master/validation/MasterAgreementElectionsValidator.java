package cdm.legaldocumentation.master.validation;

import cdm.legaldocumentation.master.MasterAgreementElections;
import cdm.legaldocumentation.master.icma.GlobalMasterRepoAgreement;
import cdm.legaldocumentation.master.isda.MasterAgreement;
import cdm.legaldocumentation.master.isla.GlobalMasterSecuritiesLendingAgreement;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MasterAgreementElectionsValidator implements Validator<MasterAgreementElections> {

	private List<ComparisonResult> getComparisonResults(MasterAgreementElections o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("islaGmsla", (GlobalMasterSecuritiesLendingAgreement) o.getIslaGmsla() != null ? 1 : 0, 0, 1), 
				checkCardinality("icmaGmra", (GlobalMasterRepoAgreement) o.getIcmaGmra() != null ? 1 : 0, 0, 1), 
				checkCardinality("isdaMaster", (MasterAgreement) o.getIsdaMaster() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementElections o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreementElections", ValidationResult.ValidationType.CARDINALITY, "MasterAgreementElections", path, "", res.getError());
				}
				return success("MasterAgreementElections", ValidationResult.ValidationType.CARDINALITY, "MasterAgreementElections", path, "");
			})
			.collect(toList());
	}

}

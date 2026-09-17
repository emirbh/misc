package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CollateralManagementAgreement;
import cdm.legaldocumentation.csa.validation.CollateralManagementAgreementTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CollateralManagementAgreementValidator;
import cdm.legaldocumentation.csa.validation.exists.CollateralManagementAgreementOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=CollateralManagementAgreement.class)
public class CollateralManagementAgreementMeta implements RosettaMetaData<CollateralManagementAgreement> {

	@Override
	public List<Validator<? super CollateralManagementAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralManagementAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralManagementAgreement> validator(ValidatorFactory factory) {
		return factory.<CollateralManagementAgreement>create(CollateralManagementAgreementValidator.class);
	}

	@Override
	public Validator<? super CollateralManagementAgreement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralManagementAgreement>create(CollateralManagementAgreementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralManagementAgreement> validator() {
		return new CollateralManagementAgreementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralManagementAgreement> typeFormatValidator() {
		return new CollateralManagementAgreementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralManagementAgreement, Set<String>> onlyExistsValidator() {
		return new CollateralManagementAgreementOnlyExistsValidator();
	}
}

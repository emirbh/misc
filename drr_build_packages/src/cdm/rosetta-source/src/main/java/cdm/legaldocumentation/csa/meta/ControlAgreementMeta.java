package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ControlAgreement;
import cdm.legaldocumentation.csa.validation.ControlAgreementTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ControlAgreementValidator;
import cdm.legaldocumentation.csa.validation.exists.ControlAgreementOnlyExistsValidator;
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
@RosettaMeta(model=ControlAgreement.class)
public class ControlAgreementMeta implements RosettaMetaData<ControlAgreement> {

	@Override
	public List<Validator<? super ControlAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ControlAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ControlAgreement> validator(ValidatorFactory factory) {
		return factory.<ControlAgreement>create(ControlAgreementValidator.class);
	}

	@Override
	public Validator<? super ControlAgreement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ControlAgreement>create(ControlAgreementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ControlAgreement> validator() {
		return new ControlAgreementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ControlAgreement> typeFormatValidator() {
		return new ControlAgreementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ControlAgreement, Set<String>> onlyExistsValidator() {
		return new ControlAgreementOnlyExistsValidator();
	}
}

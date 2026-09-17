package cdm.legaldocumentation.master.isda.meta;

import cdm.legaldocumentation.master.isda.MasterAgreement;
import cdm.legaldocumentation.master.isda.validation.MasterAgreementTypeFormatValidator;
import cdm.legaldocumentation.master.isda.validation.MasterAgreementValidator;
import cdm.legaldocumentation.master.isda.validation.exists.MasterAgreementOnlyExistsValidator;
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
@RosettaMeta(model=MasterAgreement.class)
public class MasterAgreementMeta implements RosettaMetaData<MasterAgreement> {

	@Override
	public List<Validator<? super MasterAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MasterAgreement> validator(ValidatorFactory factory) {
		return factory.<MasterAgreement>create(MasterAgreementValidator.class);
	}

	@Override
	public Validator<? super MasterAgreement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MasterAgreement>create(MasterAgreementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreement> validator() {
		return new MasterAgreementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreement> typeFormatValidator() {
		return new MasterAgreementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterAgreement, Set<String>> onlyExistsValidator() {
		return new MasterAgreementOnlyExistsValidator();
	}
}

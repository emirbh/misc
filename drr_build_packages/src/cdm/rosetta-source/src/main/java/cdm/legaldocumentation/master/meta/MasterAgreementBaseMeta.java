package cdm.legaldocumentation.master.meta;

import cdm.legaldocumentation.master.MasterAgreementBase;
import cdm.legaldocumentation.master.validation.MasterAgreementBaseTypeFormatValidator;
import cdm.legaldocumentation.master.validation.MasterAgreementBaseValidator;
import cdm.legaldocumentation.master.validation.exists.MasterAgreementBaseOnlyExistsValidator;
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
@RosettaMeta(model=MasterAgreementBase.class)
public class MasterAgreementBaseMeta implements RosettaMetaData<MasterAgreementBase> {

	@Override
	public List<Validator<? super MasterAgreementBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterAgreementBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MasterAgreementBase> validator(ValidatorFactory factory) {
		return factory.<MasterAgreementBase>create(MasterAgreementBaseValidator.class);
	}

	@Override
	public Validator<? super MasterAgreementBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MasterAgreementBase>create(MasterAgreementBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreementBase> validator() {
		return new MasterAgreementBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreementBase> typeFormatValidator() {
		return new MasterAgreementBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterAgreementBase, Set<String>> onlyExistsValidator() {
		return new MasterAgreementBaseOnlyExistsValidator();
	}
}

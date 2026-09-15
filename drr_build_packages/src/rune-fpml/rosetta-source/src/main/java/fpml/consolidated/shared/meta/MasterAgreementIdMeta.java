package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MasterAgreementId;
import fpml.consolidated.shared.validation.MasterAgreementIdTypeFormatValidator;
import fpml.consolidated.shared.validation.MasterAgreementIdValidator;
import fpml.consolidated.shared.validation.exists.MasterAgreementIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MasterAgreementId.class)
public class MasterAgreementIdMeta implements RosettaMetaData<MasterAgreementId> {

	@Override
	public List<Validator<? super MasterAgreementId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterAgreementId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MasterAgreementId> validator(ValidatorFactory factory) {
		return factory.<MasterAgreementId>create(MasterAgreementIdValidator.class);
	}

	@Override
	public Validator<? super MasterAgreementId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MasterAgreementId>create(MasterAgreementIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreementId> validator() {
		return new MasterAgreementIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreementId> typeFormatValidator() {
		return new MasterAgreementIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterAgreementId, Set<String>> onlyExistsValidator() {
		return new MasterAgreementIdOnlyExistsValidator();
	}
}

package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MasterAgreementVersion;
import fpml.consolidated.shared.validation.MasterAgreementVersionTypeFormatValidator;
import fpml.consolidated.shared.validation.MasterAgreementVersionValidator;
import fpml.consolidated.shared.validation.exists.MasterAgreementVersionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MasterAgreementVersion.class)
public class MasterAgreementVersionMeta implements RosettaMetaData<MasterAgreementVersion> {

	@Override
	public List<Validator<? super MasterAgreementVersion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterAgreementVersion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MasterAgreementVersion> validator(ValidatorFactory factory) {
		return factory.<MasterAgreementVersion>create(MasterAgreementVersionValidator.class);
	}

	@Override
	public Validator<? super MasterAgreementVersion> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MasterAgreementVersion>create(MasterAgreementVersionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreementVersion> validator() {
		return new MasterAgreementVersionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreementVersion> typeFormatValidator() {
		return new MasterAgreementVersionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterAgreementVersion, Set<String>> onlyExistsValidator() {
		return new MasterAgreementVersionOnlyExistsValidator();
	}
}

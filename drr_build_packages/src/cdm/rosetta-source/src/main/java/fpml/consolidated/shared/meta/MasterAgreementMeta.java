package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MasterAgreement;
import fpml.consolidated.shared.validation.MasterAgreementTypeFormatValidator;
import fpml.consolidated.shared.validation.MasterAgreementValidator;
import fpml.consolidated.shared.validation.exists.MasterAgreementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
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

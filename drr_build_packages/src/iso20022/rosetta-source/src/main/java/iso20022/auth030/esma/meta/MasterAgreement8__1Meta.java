package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.MasterAgreement8__1;
import iso20022.auth030.esma.validation.MasterAgreement8__1TypeFormatValidator;
import iso20022.auth030.esma.validation.MasterAgreement8__1Validator;
import iso20022.auth030.esma.validation.exists.MasterAgreement8__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MasterAgreement8__1.class)
public class MasterAgreement8__1Meta implements RosettaMetaData<MasterAgreement8__1> {

	@Override
	public List<Validator<? super MasterAgreement8__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterAgreement8__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MasterAgreement8__1> validator(ValidatorFactory factory) {
		return factory.<MasterAgreement8__1>create(MasterAgreement8__1Validator.class);
	}

	@Override
	public Validator<? super MasterAgreement8__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MasterAgreement8__1>create(MasterAgreement8__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreement8__1> validator() {
		return new MasterAgreement8__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreement8__1> typeFormatValidator() {
		return new MasterAgreement8__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterAgreement8__1, Set<String>> onlyExistsValidator() {
		return new MasterAgreement8__1OnlyExistsValidator();
	}
}

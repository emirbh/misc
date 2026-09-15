package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.SecurityIdentification46__1;
import iso20022.auth030.hkma.dtcc.validation.SecurityIdentification46__1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.SecurityIdentification46__1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.SecurityIdentification46__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SecurityIdentification46__1.class)
public class SecurityIdentification46__1Meta implements RosettaMetaData<SecurityIdentification46__1> {

	@Override
	public List<Validator<? super SecurityIdentification46__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecurityIdentification46__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityIdentification46__1> validator(ValidatorFactory factory) {
		return factory.<SecurityIdentification46__1>create(SecurityIdentification46__1Validator.class);
	}

	@Override
	public Validator<? super SecurityIdentification46__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecurityIdentification46__1>create(SecurityIdentification46__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecurityIdentification46__1> validator() {
		return new SecurityIdentification46__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super SecurityIdentification46__1> typeFormatValidator() {
		return new SecurityIdentification46__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityIdentification46__1, Set<String>> onlyExistsValidator() {
		return new SecurityIdentification46__1OnlyExistsValidator();
	}
}

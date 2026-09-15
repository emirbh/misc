package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.GenericIdentification175__1;
import iso20022.auth030.hkma.tr.validation.GenericIdentification175__1TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.GenericIdentification175__1Validator;
import iso20022.auth030.hkma.tr.validation.exists.GenericIdentification175__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericIdentification175__1.class)
public class GenericIdentification175__1Meta implements RosettaMetaData<GenericIdentification175__1> {

	@Override
	public List<Validator<? super GenericIdentification175__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericIdentification175__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericIdentification175__1> validator(ValidatorFactory factory) {
		return factory.<GenericIdentification175__1>create(GenericIdentification175__1Validator.class);
	}

	@Override
	public Validator<? super GenericIdentification175__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericIdentification175__1>create(GenericIdentification175__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericIdentification175__1> validator() {
		return new GenericIdentification175__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericIdentification175__1> typeFormatValidator() {
		return new GenericIdentification175__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericIdentification175__1, Set<String>> onlyExistsValidator() {
		return new GenericIdentification175__1OnlyExistsValidator();
	}
}

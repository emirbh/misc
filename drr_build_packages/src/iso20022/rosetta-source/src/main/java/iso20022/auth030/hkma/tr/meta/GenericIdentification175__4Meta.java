package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.GenericIdentification175__4;
import iso20022.auth030.hkma.tr.validation.GenericIdentification175__4TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.GenericIdentification175__4Validator;
import iso20022.auth030.hkma.tr.validation.exists.GenericIdentification175__4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericIdentification175__4.class)
public class GenericIdentification175__4Meta implements RosettaMetaData<GenericIdentification175__4> {

	@Override
	public List<Validator<? super GenericIdentification175__4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericIdentification175__4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericIdentification175__4> validator(ValidatorFactory factory) {
		return factory.<GenericIdentification175__4>create(GenericIdentification175__4Validator.class);
	}

	@Override
	public Validator<? super GenericIdentification175__4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericIdentification175__4>create(GenericIdentification175__4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericIdentification175__4> validator() {
		return new GenericIdentification175__4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericIdentification175__4> typeFormatValidator() {
		return new GenericIdentification175__4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericIdentification175__4, Set<String>> onlyExistsValidator() {
		return new GenericIdentification175__4OnlyExistsValidator();
	}
}

package iso20022.auth108.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.hkma.dtcc.GenericIdentification175__2;
import iso20022.auth108.hkma.dtcc.validation.GenericIdentification175__2TypeFormatValidator;
import iso20022.auth108.hkma.dtcc.validation.GenericIdentification175__2Validator;
import iso20022.auth108.hkma.dtcc.validation.exists.GenericIdentification175__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericIdentification175__2.class)
public class GenericIdentification175__2Meta implements RosettaMetaData<GenericIdentification175__2> {

	@Override
	public List<Validator<? super GenericIdentification175__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericIdentification175__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericIdentification175__2> validator(ValidatorFactory factory) {
		return factory.<GenericIdentification175__2>create(GenericIdentification175__2Validator.class);
	}

	@Override
	public Validator<? super GenericIdentification175__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericIdentification175__2>create(GenericIdentification175__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericIdentification175__2> validator() {
		return new GenericIdentification175__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericIdentification175__2> typeFormatValidator() {
		return new GenericIdentification175__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericIdentification175__2, Set<String>> onlyExistsValidator() {
		return new GenericIdentification175__2OnlyExistsValidator();
	}
}

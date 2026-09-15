package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.PTRREvent2__1;
import iso20022.auth030.esma.validation.PTRREvent2__1TypeFormatValidator;
import iso20022.auth030.esma.validation.PTRREvent2__1Validator;
import iso20022.auth030.esma.validation.exists.PTRREvent2__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PTRREvent2__1.class)
public class PTRREvent2__1Meta implements RosettaMetaData<PTRREvent2__1> {

	@Override
	public List<Validator<? super PTRREvent2__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PTRREvent2__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PTRREvent2__1> validator(ValidatorFactory factory) {
		return factory.<PTRREvent2__1>create(PTRREvent2__1Validator.class);
	}

	@Override
	public Validator<? super PTRREvent2__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PTRREvent2__1>create(PTRREvent2__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PTRREvent2__1> validator() {
		return new PTRREvent2__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PTRREvent2__1> typeFormatValidator() {
		return new PTRREvent2__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PTRREvent2__1, Set<String>> onlyExistsValidator() {
		return new PTRREvent2__1OnlyExistsValidator();
	}
}

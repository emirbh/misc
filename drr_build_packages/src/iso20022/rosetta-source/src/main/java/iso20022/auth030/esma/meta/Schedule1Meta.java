package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.Schedule1;
import iso20022.auth030.esma.validation.Schedule1TypeFormatValidator;
import iso20022.auth030.esma.validation.Schedule1Validator;
import iso20022.auth030.esma.validation.exists.Schedule1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Schedule1.class)
public class Schedule1Meta implements RosettaMetaData<Schedule1> {

	@Override
	public List<Validator<? super Schedule1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Schedule1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Schedule1> validator(ValidatorFactory factory) {
		return factory.<Schedule1>create(Schedule1Validator.class);
	}

	@Override
	public Validator<? super Schedule1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Schedule1>create(Schedule1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Schedule1> validator() {
		return new Schedule1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super Schedule1> typeFormatValidator() {
		return new Schedule1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Schedule1, Set<String>> onlyExistsValidator() {
		return new Schedule1OnlyExistsValidator();
	}
}

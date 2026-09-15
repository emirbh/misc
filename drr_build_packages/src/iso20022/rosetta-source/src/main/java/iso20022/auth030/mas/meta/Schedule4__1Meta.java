package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.Schedule4__1;
import iso20022.auth030.mas.validation.Schedule4__1TypeFormatValidator;
import iso20022.auth030.mas.validation.Schedule4__1Validator;
import iso20022.auth030.mas.validation.exists.Schedule4__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Schedule4__1.class)
public class Schedule4__1Meta implements RosettaMetaData<Schedule4__1> {

	@Override
	public List<Validator<? super Schedule4__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Schedule4__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Schedule4__1> validator(ValidatorFactory factory) {
		return factory.<Schedule4__1>create(Schedule4__1Validator.class);
	}

	@Override
	public Validator<? super Schedule4__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Schedule4__1>create(Schedule4__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Schedule4__1> validator() {
		return new Schedule4__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super Schedule4__1> typeFormatValidator() {
		return new Schedule4__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Schedule4__1, Set<String>> onlyExistsValidator() {
		return new Schedule4__1OnlyExistsValidator();
	}
}

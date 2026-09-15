package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.TimePeriodDetails1;
import iso20022.auth030.fca.validation.TimePeriodDetails1TypeFormatValidator;
import iso20022.auth030.fca.validation.TimePeriodDetails1Validator;
import iso20022.auth030.fca.validation.exists.TimePeriodDetails1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TimePeriodDetails1.class)
public class TimePeriodDetails1Meta implements RosettaMetaData<TimePeriodDetails1> {

	@Override
	public List<Validator<? super TimePeriodDetails1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TimePeriodDetails1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TimePeriodDetails1> validator(ValidatorFactory factory) {
		return factory.<TimePeriodDetails1>create(TimePeriodDetails1Validator.class);
	}

	@Override
	public Validator<? super TimePeriodDetails1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TimePeriodDetails1>create(TimePeriodDetails1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TimePeriodDetails1> validator() {
		return new TimePeriodDetails1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TimePeriodDetails1> typeFormatValidator() {
		return new TimePeriodDetails1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TimePeriodDetails1, Set<String>> onlyExistsValidator() {
		return new TimePeriodDetails1OnlyExistsValidator();
	}
}

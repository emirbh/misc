package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.DatePeriod1;
import iso20022.auth030.fca.validation.DatePeriod1TypeFormatValidator;
import iso20022.auth030.fca.validation.DatePeriod1Validator;
import iso20022.auth030.fca.validation.exists.DatePeriod1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DatePeriod1.class)
public class DatePeriod1Meta implements RosettaMetaData<DatePeriod1> {

	@Override
	public List<Validator<? super DatePeriod1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DatePeriod1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DatePeriod1> validator(ValidatorFactory factory) {
		return factory.<DatePeriod1>create(DatePeriod1Validator.class);
	}

	@Override
	public Validator<? super DatePeriod1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DatePeriod1>create(DatePeriod1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DatePeriod1> validator() {
		return new DatePeriod1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super DatePeriod1> typeFormatValidator() {
		return new DatePeriod1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DatePeriod1, Set<String>> onlyExistsValidator() {
		return new DatePeriod1OnlyExistsValidator();
	}
}

package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.CounterpartySpecificData36__5;
import iso20022.auth030.fca.validation.CounterpartySpecificData36__5TypeFormatValidator;
import iso20022.auth030.fca.validation.CounterpartySpecificData36__5Validator;
import iso20022.auth030.fca.validation.exists.CounterpartySpecificData36__5OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CounterpartySpecificData36__5.class)
public class CounterpartySpecificData36__5Meta implements RosettaMetaData<CounterpartySpecificData36__5> {

	@Override
	public List<Validator<? super CounterpartySpecificData36__5>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CounterpartySpecificData36__5, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CounterpartySpecificData36__5> validator(ValidatorFactory factory) {
		return factory.<CounterpartySpecificData36__5>create(CounterpartySpecificData36__5Validator.class);
	}

	@Override
	public Validator<? super CounterpartySpecificData36__5> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CounterpartySpecificData36__5>create(CounterpartySpecificData36__5TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CounterpartySpecificData36__5> validator() {
		return new CounterpartySpecificData36__5Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CounterpartySpecificData36__5> typeFormatValidator() {
		return new CounterpartySpecificData36__5TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CounterpartySpecificData36__5, Set<String>> onlyExistsValidator() {
		return new CounterpartySpecificData36__5OnlyExistsValidator();
	}
}

package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.CounterpartySpecificData36__2;
import iso20022.auth030.fca.validation.CounterpartySpecificData36__2TypeFormatValidator;
import iso20022.auth030.fca.validation.CounterpartySpecificData36__2Validator;
import iso20022.auth030.fca.validation.exists.CounterpartySpecificData36__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CounterpartySpecificData36__2.class)
public class CounterpartySpecificData36__2Meta implements RosettaMetaData<CounterpartySpecificData36__2> {

	@Override
	public List<Validator<? super CounterpartySpecificData36__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CounterpartySpecificData36__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CounterpartySpecificData36__2> validator(ValidatorFactory factory) {
		return factory.<CounterpartySpecificData36__2>create(CounterpartySpecificData36__2Validator.class);
	}

	@Override
	public Validator<? super CounterpartySpecificData36__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CounterpartySpecificData36__2>create(CounterpartySpecificData36__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CounterpartySpecificData36__2> validator() {
		return new CounterpartySpecificData36__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CounterpartySpecificData36__2> typeFormatValidator() {
		return new CounterpartySpecificData36__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CounterpartySpecificData36__2, Set<String>> onlyExistsValidator() {
		return new CounterpartySpecificData36__2OnlyExistsValidator();
	}
}

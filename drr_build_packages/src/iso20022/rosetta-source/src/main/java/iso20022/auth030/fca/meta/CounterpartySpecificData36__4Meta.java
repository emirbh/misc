package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.CounterpartySpecificData36__4;
import iso20022.auth030.fca.validation.CounterpartySpecificData36__4TypeFormatValidator;
import iso20022.auth030.fca.validation.CounterpartySpecificData36__4Validator;
import iso20022.auth030.fca.validation.exists.CounterpartySpecificData36__4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CounterpartySpecificData36__4.class)
public class CounterpartySpecificData36__4Meta implements RosettaMetaData<CounterpartySpecificData36__4> {

	@Override
	public List<Validator<? super CounterpartySpecificData36__4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CounterpartySpecificData36__4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CounterpartySpecificData36__4> validator(ValidatorFactory factory) {
		return factory.<CounterpartySpecificData36__4>create(CounterpartySpecificData36__4Validator.class);
	}

	@Override
	public Validator<? super CounterpartySpecificData36__4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CounterpartySpecificData36__4>create(CounterpartySpecificData36__4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CounterpartySpecificData36__4> validator() {
		return new CounterpartySpecificData36__4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CounterpartySpecificData36__4> typeFormatValidator() {
		return new CounterpartySpecificData36__4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CounterpartySpecificData36__4, Set<String>> onlyExistsValidator() {
		return new CounterpartySpecificData36__4OnlyExistsValidator();
	}
}

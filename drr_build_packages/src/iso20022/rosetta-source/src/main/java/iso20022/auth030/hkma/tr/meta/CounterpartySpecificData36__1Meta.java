package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.CounterpartySpecificData36__1;
import iso20022.auth030.hkma.tr.validation.CounterpartySpecificData36__1TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.CounterpartySpecificData36__1Validator;
import iso20022.auth030.hkma.tr.validation.exists.CounterpartySpecificData36__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CounterpartySpecificData36__1.class)
public class CounterpartySpecificData36__1Meta implements RosettaMetaData<CounterpartySpecificData36__1> {

	@Override
	public List<Validator<? super CounterpartySpecificData36__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CounterpartySpecificData36__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CounterpartySpecificData36__1> validator(ValidatorFactory factory) {
		return factory.<CounterpartySpecificData36__1>create(CounterpartySpecificData36__1Validator.class);
	}

	@Override
	public Validator<? super CounterpartySpecificData36__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CounterpartySpecificData36__1>create(CounterpartySpecificData36__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CounterpartySpecificData36__1> validator() {
		return new CounterpartySpecificData36__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CounterpartySpecificData36__1> typeFormatValidator() {
		return new CounterpartySpecificData36__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CounterpartySpecificData36__1, Set<String>> onlyExistsValidator() {
		return new CounterpartySpecificData36__1OnlyExistsValidator();
	}
}

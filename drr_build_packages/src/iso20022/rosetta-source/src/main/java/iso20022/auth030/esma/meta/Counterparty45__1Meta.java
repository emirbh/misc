package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.Counterparty45__1;
import iso20022.auth030.esma.validation.Counterparty45__1TypeFormatValidator;
import iso20022.auth030.esma.validation.Counterparty45__1Validator;
import iso20022.auth030.esma.validation.exists.Counterparty45__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Counterparty45__1.class)
public class Counterparty45__1Meta implements RosettaMetaData<Counterparty45__1> {

	@Override
	public List<Validator<? super Counterparty45__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Counterparty45__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Counterparty45__1> validator(ValidatorFactory factory) {
		return factory.<Counterparty45__1>create(Counterparty45__1Validator.class);
	}

	@Override
	public Validator<? super Counterparty45__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Counterparty45__1>create(Counterparty45__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Counterparty45__1> validator() {
		return new Counterparty45__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super Counterparty45__1> typeFormatValidator() {
		return new Counterparty45__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Counterparty45__1, Set<String>> onlyExistsValidator() {
		return new Counterparty45__1OnlyExistsValidator();
	}
}

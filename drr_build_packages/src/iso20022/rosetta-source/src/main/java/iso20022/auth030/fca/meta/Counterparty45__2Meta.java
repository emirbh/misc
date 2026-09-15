package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.Counterparty45__2;
import iso20022.auth030.fca.validation.Counterparty45__2TypeFormatValidator;
import iso20022.auth030.fca.validation.Counterparty45__2Validator;
import iso20022.auth030.fca.validation.exists.Counterparty45__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Counterparty45__2.class)
public class Counterparty45__2Meta implements RosettaMetaData<Counterparty45__2> {

	@Override
	public List<Validator<? super Counterparty45__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Counterparty45__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Counterparty45__2> validator(ValidatorFactory factory) {
		return factory.<Counterparty45__2>create(Counterparty45__2Validator.class);
	}

	@Override
	public Validator<? super Counterparty45__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Counterparty45__2>create(Counterparty45__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Counterparty45__2> validator() {
		return new Counterparty45__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super Counterparty45__2> typeFormatValidator() {
		return new Counterparty45__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Counterparty45__2, Set<String>> onlyExistsValidator() {
		return new Counterparty45__2OnlyExistsValidator();
	}
}

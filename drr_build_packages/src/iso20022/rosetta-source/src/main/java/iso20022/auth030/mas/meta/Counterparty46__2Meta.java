package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.Counterparty46__2;
import iso20022.auth030.mas.validation.Counterparty46__2TypeFormatValidator;
import iso20022.auth030.mas.validation.Counterparty46__2Validator;
import iso20022.auth030.mas.validation.exists.Counterparty46__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Counterparty46__2.class)
public class Counterparty46__2Meta implements RosettaMetaData<Counterparty46__2> {

	@Override
	public List<Validator<? super Counterparty46__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Counterparty46__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Counterparty46__2> validator(ValidatorFactory factory) {
		return factory.<Counterparty46__2>create(Counterparty46__2Validator.class);
	}

	@Override
	public Validator<? super Counterparty46__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Counterparty46__2>create(Counterparty46__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Counterparty46__2> validator() {
		return new Counterparty46__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super Counterparty46__2> typeFormatValidator() {
		return new Counterparty46__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Counterparty46__2, Set<String>> onlyExistsValidator() {
		return new Counterparty46__2OnlyExistsValidator();
	}
}

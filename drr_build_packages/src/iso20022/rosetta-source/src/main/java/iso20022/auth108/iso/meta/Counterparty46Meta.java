package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.Counterparty46;
import iso20022.auth108.iso.validation.Counterparty46TypeFormatValidator;
import iso20022.auth108.iso.validation.Counterparty46Validator;
import iso20022.auth108.iso.validation.exists.Counterparty46OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Counterparty46.class)
public class Counterparty46Meta implements RosettaMetaData<Counterparty46> {

	@Override
	public List<Validator<? super Counterparty46>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Counterparty46, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Counterparty46> validator(ValidatorFactory factory) {
		return factory.<Counterparty46>create(Counterparty46Validator.class);
	}

	@Override
	public Validator<? super Counterparty46> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Counterparty46>create(Counterparty46TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Counterparty46> validator() {
		return new Counterparty46Validator();
	}

	@Deprecated
	@Override
	public Validator<? super Counterparty46> typeFormatValidator() {
		return new Counterparty46TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Counterparty46, Set<String>> onlyExistsValidator() {
		return new Counterparty46OnlyExistsValidator();
	}
}

package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.Counterparty45;
import iso20022.auth108.iso.validation.Counterparty45TypeFormatValidator;
import iso20022.auth108.iso.validation.Counterparty45Validator;
import iso20022.auth108.iso.validation.exists.Counterparty45OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Counterparty45.class)
public class Counterparty45Meta implements RosettaMetaData<Counterparty45> {

	@Override
	public List<Validator<? super Counterparty45>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Counterparty45, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Counterparty45> validator(ValidatorFactory factory) {
		return factory.<Counterparty45>create(Counterparty45Validator.class);
	}

	@Override
	public Validator<? super Counterparty45> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Counterparty45>create(Counterparty45TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Counterparty45> validator() {
		return new Counterparty45Validator();
	}

	@Deprecated
	@Override
	public Validator<? super Counterparty45> typeFormatValidator() {
		return new Counterparty45TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Counterparty45, Set<String>> onlyExistsValidator() {
		return new Counterparty45OnlyExistsValidator();
	}
}

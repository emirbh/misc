package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.SecuritiesTransactionPrice5;
import iso20022.auth030.esma.validation.SecuritiesTransactionPrice5TypeFormatValidator;
import iso20022.auth030.esma.validation.SecuritiesTransactionPrice5Validator;
import iso20022.auth030.esma.validation.exists.SecuritiesTransactionPrice5OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SecuritiesTransactionPrice5.class)
public class SecuritiesTransactionPrice5Meta implements RosettaMetaData<SecuritiesTransactionPrice5> {

	@Override
	public List<Validator<? super SecuritiesTransactionPrice5>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecuritiesTransactionPrice5, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecuritiesTransactionPrice5> validator(ValidatorFactory factory) {
		return factory.<SecuritiesTransactionPrice5>create(SecuritiesTransactionPrice5Validator.class);
	}

	@Override
	public Validator<? super SecuritiesTransactionPrice5> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecuritiesTransactionPrice5>create(SecuritiesTransactionPrice5TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecuritiesTransactionPrice5> validator() {
		return new SecuritiesTransactionPrice5Validator();
	}

	@Deprecated
	@Override
	public Validator<? super SecuritiesTransactionPrice5> typeFormatValidator() {
		return new SecuritiesTransactionPrice5TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecuritiesTransactionPrice5, Set<String>> onlyExistsValidator() {
		return new SecuritiesTransactionPrice5OnlyExistsValidator();
	}
}

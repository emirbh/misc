package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.SecuritiesTransactionPrice17Choice;
import iso20022.auth030.esma.validation.SecuritiesTransactionPrice17ChoiceTypeFormatValidator;
import iso20022.auth030.esma.validation.SecuritiesTransactionPrice17ChoiceValidator;
import iso20022.auth030.esma.validation.datarule.SecuritiesTransactionPrice17ChoiceChoice;
import iso20022.auth030.esma.validation.exists.SecuritiesTransactionPrice17ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SecuritiesTransactionPrice17Choice.class)
public class SecuritiesTransactionPrice17ChoiceMeta implements RosettaMetaData<SecuritiesTransactionPrice17Choice> {

	@Override
	public List<Validator<? super SecuritiesTransactionPrice17Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SecuritiesTransactionPrice17Choice>create(SecuritiesTransactionPrice17ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SecuritiesTransactionPrice17Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecuritiesTransactionPrice17Choice> validator(ValidatorFactory factory) {
		return factory.<SecuritiesTransactionPrice17Choice>create(SecuritiesTransactionPrice17ChoiceValidator.class);
	}

	@Override
	public Validator<? super SecuritiesTransactionPrice17Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecuritiesTransactionPrice17Choice>create(SecuritiesTransactionPrice17ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecuritiesTransactionPrice17Choice> validator() {
		return new SecuritiesTransactionPrice17ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecuritiesTransactionPrice17Choice> typeFormatValidator() {
		return new SecuritiesTransactionPrice17ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecuritiesTransactionPrice17Choice, Set<String>> onlyExistsValidator() {
		return new SecuritiesTransactionPrice17ChoiceOnlyExistsValidator();
	}
}

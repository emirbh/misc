package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.validation.TransactionInformationTypeFormatValidator;
import drr.regulation.common.validation.TransactionInformationValidator;
import drr.regulation.common.validation.exists.TransactionInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=TransactionInformation.class)
public class TransactionInformationMeta implements RosettaMetaData<TransactionInformation> {

	@Override
	public List<Validator<? super TransactionInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransactionInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TransactionInformation> validator(ValidatorFactory factory) {
		return factory.<TransactionInformation>create(TransactionInformationValidator.class);
	}

	@Override
	public Validator<? super TransactionInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TransactionInformation>create(TransactionInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TransactionInformation> validator() {
		return new TransactionInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TransactionInformation> typeFormatValidator() {
		return new TransactionInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransactionInformation, Set<String>> onlyExistsValidator() {
		return new TransactionInformationOnlyExistsValidator();
	}
}

package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApplicableTransactionType;
import fpml.consolidated.loan.validation.ApplicableTransactionTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.ApplicableTransactionTypeValidator;
import fpml.consolidated.loan.validation.exists.ApplicableTransactionTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ApplicableTransactionType.class)
public class ApplicableTransactionTypeMeta implements RosettaMetaData<ApplicableTransactionType> {

	@Override
	public List<Validator<? super ApplicableTransactionType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ApplicableTransactionType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApplicableTransactionType> validator(ValidatorFactory factory) {
		return factory.<ApplicableTransactionType>create(ApplicableTransactionTypeValidator.class);
	}

	@Override
	public Validator<? super ApplicableTransactionType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ApplicableTransactionType>create(ApplicableTransactionTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableTransactionType> validator() {
		return new ApplicableTransactionTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableTransactionType> typeFormatValidator() {
		return new ApplicableTransactionTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApplicableTransactionType, Set<String>> onlyExistsValidator() {
		return new ApplicableTransactionTypeOnlyExistsValidator();
	}
}

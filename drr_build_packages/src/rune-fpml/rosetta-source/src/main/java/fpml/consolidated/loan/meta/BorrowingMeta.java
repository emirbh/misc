package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.Borrowing;
import fpml.consolidated.loan.validation.BorrowingTypeFormatValidator;
import fpml.consolidated.loan.validation.BorrowingValidator;
import fpml.consolidated.loan.validation.exists.BorrowingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Borrowing.class)
public class BorrowingMeta implements RosettaMetaData<Borrowing> {

	@Override
	public List<Validator<? super Borrowing>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Borrowing, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Borrowing> validator(ValidatorFactory factory) {
		return factory.<Borrowing>create(BorrowingValidator.class);
	}

	@Override
	public Validator<? super Borrowing> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Borrowing>create(BorrowingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Borrowing> validator() {
		return new BorrowingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Borrowing> typeFormatValidator() {
		return new BorrowingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Borrowing, Set<String>> onlyExistsValidator() {
		return new BorrowingOnlyExistsValidator();
	}
}

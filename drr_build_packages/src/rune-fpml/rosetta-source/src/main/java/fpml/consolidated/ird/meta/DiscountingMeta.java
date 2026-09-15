package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.Discounting;
import fpml.consolidated.ird.validation.DiscountingTypeFormatValidator;
import fpml.consolidated.ird.validation.DiscountingValidator;
import fpml.consolidated.ird.validation.exists.DiscountingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Discounting.class)
public class DiscountingMeta implements RosettaMetaData<Discounting> {

	@Override
	public List<Validator<? super Discounting>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Discounting, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Discounting> validator(ValidatorFactory factory) {
		return factory.<Discounting>create(DiscountingValidator.class);
	}

	@Override
	public Validator<? super Discounting> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Discounting>create(DiscountingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Discounting> validator() {
		return new DiscountingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Discounting> typeFormatValidator() {
		return new DiscountingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Discounting, Set<String>> onlyExistsValidator() {
		return new DiscountingOnlyExistsValidator();
	}
}

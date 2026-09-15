package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.Compounding;
import fpml.consolidated.eq.shared.validation.CompoundingTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.CompoundingValidator;
import fpml.consolidated.eq.shared.validation.exists.CompoundingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Compounding.class)
public class CompoundingMeta implements RosettaMetaData<Compounding> {

	@Override
	public List<Validator<? super Compounding>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Compounding, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Compounding> validator(ValidatorFactory factory) {
		return factory.<Compounding>create(CompoundingValidator.class);
	}

	@Override
	public Validator<? super Compounding> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Compounding>create(CompoundingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Compounding> validator() {
		return new CompoundingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Compounding> typeFormatValidator() {
		return new CompoundingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Compounding, Set<String>> onlyExistsValidator() {
		return new CompoundingOnlyExistsValidator();
	}
}

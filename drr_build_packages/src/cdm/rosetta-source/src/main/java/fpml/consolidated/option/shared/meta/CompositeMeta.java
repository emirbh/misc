package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.Composite;
import fpml.consolidated.option.shared.validation.CompositeTypeFormatValidator;
import fpml.consolidated.option.shared.validation.CompositeValidator;
import fpml.consolidated.option.shared.validation.exists.CompositeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Composite.class)
public class CompositeMeta implements RosettaMetaData<Composite> {

	@Override
	public List<Validator<? super Composite>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Composite, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Composite> validator(ValidatorFactory factory) {
		return factory.<Composite>create(CompositeValidator.class);
	}

	@Override
	public Validator<? super Composite> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Composite>create(CompositeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Composite> validator() {
		return new CompositeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Composite> typeFormatValidator() {
		return new CompositeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Composite, Set<String>> onlyExistsValidator() {
		return new CompositeOnlyExistsValidator();
	}
}

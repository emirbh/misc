package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Warrant;
import fpml.consolidated.asset.validation.WarrantTypeFormatValidator;
import fpml.consolidated.asset.validation.WarrantValidator;
import fpml.consolidated.asset.validation.exists.WarrantOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Warrant.class)
public class WarrantMeta implements RosettaMetaData<Warrant> {

	@Override
	public List<Validator<? super Warrant>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Warrant, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Warrant> validator(ValidatorFactory factory) {
		return factory.<Warrant>create(WarrantValidator.class);
	}

	@Override
	public Validator<? super Warrant> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Warrant>create(WarrantTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Warrant> validator() {
		return new WarrantValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Warrant> typeFormatValidator() {
		return new WarrantTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Warrant, Set<String>> onlyExistsValidator() {
		return new WarrantOnlyExistsValidator();
	}
}

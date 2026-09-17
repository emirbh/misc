package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Bond;
import fpml.consolidated.asset.validation.BondTypeFormatValidator;
import fpml.consolidated.asset.validation.BondValidator;
import fpml.consolidated.asset.validation.datarule.BondChoice;
import fpml.consolidated.asset.validation.exists.BondOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Bond.class)
public class BondMeta implements RosettaMetaData<Bond> {

	@Override
	public List<Validator<? super Bond>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Bond>create(BondChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Bond, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Bond> validator(ValidatorFactory factory) {
		return factory.<Bond>create(BondValidator.class);
	}

	@Override
	public Validator<? super Bond> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Bond>create(BondTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Bond> validator() {
		return new BondValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Bond> typeFormatValidator() {
		return new BondTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Bond, Set<String>> onlyExistsValidator() {
		return new BondOnlyExistsValidator();
	}
}

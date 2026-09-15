package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Bond;
import fpml.consolidated.asset.ConvertibleBond;
import fpml.consolidated.asset.validation.ConvertibleBondTypeFormatValidator;
import fpml.consolidated.asset.validation.ConvertibleBondValidator;
import fpml.consolidated.asset.validation.datarule.BondChoice;
import fpml.consolidated.asset.validation.exists.ConvertibleBondOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ConvertibleBond.class)
public class ConvertibleBondMeta implements RosettaMetaData<ConvertibleBond> {

	@Override
	public List<Validator<? super ConvertibleBond>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Bond>create(BondChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ConvertibleBond, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConvertibleBond> validator(ValidatorFactory factory) {
		return factory.<ConvertibleBond>create(ConvertibleBondValidator.class);
	}

	@Override
	public Validator<? super ConvertibleBond> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConvertibleBond>create(ConvertibleBondTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConvertibleBond> validator() {
		return new ConvertibleBondValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConvertibleBond> typeFormatValidator() {
		return new ConvertibleBondTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConvertibleBond, Set<String>> onlyExistsValidator() {
		return new ConvertibleBondOnlyExistsValidator();
	}
}

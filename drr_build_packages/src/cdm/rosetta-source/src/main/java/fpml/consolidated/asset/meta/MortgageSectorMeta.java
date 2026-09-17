package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.MortgageSector;
import fpml.consolidated.asset.validation.MortgageSectorTypeFormatValidator;
import fpml.consolidated.asset.validation.MortgageSectorValidator;
import fpml.consolidated.asset.validation.exists.MortgageSectorOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MortgageSector.class)
public class MortgageSectorMeta implements RosettaMetaData<MortgageSector> {

	@Override
	public List<Validator<? super MortgageSector>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MortgageSector, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MortgageSector> validator(ValidatorFactory factory) {
		return factory.<MortgageSector>create(MortgageSectorValidator.class);
	}

	@Override
	public Validator<? super MortgageSector> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MortgageSector>create(MortgageSectorTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MortgageSector> validator() {
		return new MortgageSectorValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MortgageSector> typeFormatValidator() {
		return new MortgageSectorTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MortgageSector, Set<String>> onlyExistsValidator() {
		return new MortgageSectorOnlyExistsValidator();
	}
}

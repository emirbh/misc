package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.validation.AssetClassTypeFormatValidator;
import fpml.consolidated.shared.validation.AssetClassValidator;
import fpml.consolidated.shared.validation.exists.AssetClassOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AssetClass.class)
public class AssetClassMeta implements RosettaMetaData<AssetClass> {

	@Override
	public List<Validator<? super AssetClass>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetClass, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClass> validator(ValidatorFactory factory) {
		return factory.<AssetClass>create(AssetClassValidator.class);
	}

	@Override
	public Validator<? super AssetClass> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClass>create(AssetClassTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClass> validator() {
		return new AssetClassValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClass> typeFormatValidator() {
		return new AssetClassTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClass, Set<String>> onlyExistsValidator() {
		return new AssetClassOnlyExistsValidator();
	}
}

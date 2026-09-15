package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AssetPool;
import fpml.consolidated.asset.validation.AssetPoolTypeFormatValidator;
import fpml.consolidated.asset.validation.AssetPoolValidator;
import fpml.consolidated.asset.validation.exists.AssetPoolOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AssetPool.class)
public class AssetPoolMeta implements RosettaMetaData<AssetPool> {

	@Override
	public List<Validator<? super AssetPool>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetPool, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetPool> validator(ValidatorFactory factory) {
		return factory.<AssetPool>create(AssetPoolValidator.class);
	}

	@Override
	public Validator<? super AssetPool> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetPool>create(AssetPoolTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetPool> validator() {
		return new AssetPoolValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetPool> typeFormatValidator() {
		return new AssetPoolTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetPool, Set<String>> onlyExistsValidator() {
		return new AssetPoolOnlyExistsValidator();
	}
}

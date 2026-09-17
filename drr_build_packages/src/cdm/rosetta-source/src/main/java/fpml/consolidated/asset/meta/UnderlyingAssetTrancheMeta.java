package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.UnderlyingAssetTranche;
import fpml.consolidated.asset.validation.UnderlyingAssetTrancheTypeFormatValidator;
import fpml.consolidated.asset.validation.UnderlyingAssetTrancheValidator;
import fpml.consolidated.asset.validation.exists.UnderlyingAssetTrancheOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=UnderlyingAssetTranche.class)
public class UnderlyingAssetTrancheMeta implements RosettaMetaData<UnderlyingAssetTranche> {

	@Override
	public List<Validator<? super UnderlyingAssetTranche>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnderlyingAssetTranche, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UnderlyingAssetTranche> validator(ValidatorFactory factory) {
		return factory.<UnderlyingAssetTranche>create(UnderlyingAssetTrancheValidator.class);
	}

	@Override
	public Validator<? super UnderlyingAssetTranche> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UnderlyingAssetTranche>create(UnderlyingAssetTrancheTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UnderlyingAssetTranche> validator() {
		return new UnderlyingAssetTrancheValidator();
	}

	@Deprecated
	@Override
	public Validator<? super UnderlyingAssetTranche> typeFormatValidator() {
		return new UnderlyingAssetTrancheTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnderlyingAssetTranche, Set<String>> onlyExistsValidator() {
		return new UnderlyingAssetTrancheOnlyExistsValidator();
	}
}

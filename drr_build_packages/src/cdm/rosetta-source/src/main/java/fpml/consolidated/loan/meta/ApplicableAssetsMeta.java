package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApplicableAssets;
import fpml.consolidated.loan.validation.ApplicableAssetsTypeFormatValidator;
import fpml.consolidated.loan.validation.ApplicableAssetsValidator;
import fpml.consolidated.loan.validation.datarule.ApplicableAssetsChoice;
import fpml.consolidated.loan.validation.exists.ApplicableAssetsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ApplicableAssets.class)
public class ApplicableAssetsMeta implements RosettaMetaData<ApplicableAssets> {

	@Override
	public List<Validator<? super ApplicableAssets>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ApplicableAssets>create(ApplicableAssetsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ApplicableAssets, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApplicableAssets> validator(ValidatorFactory factory) {
		return factory.<ApplicableAssets>create(ApplicableAssetsValidator.class);
	}

	@Override
	public Validator<? super ApplicableAssets> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ApplicableAssets>create(ApplicableAssetsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableAssets> validator() {
		return new ApplicableAssetsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableAssets> typeFormatValidator() {
		return new ApplicableAssetsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApplicableAssets, Set<String>> onlyExistsValidator() {
		return new ApplicableAssetsOnlyExistsValidator();
	}
}

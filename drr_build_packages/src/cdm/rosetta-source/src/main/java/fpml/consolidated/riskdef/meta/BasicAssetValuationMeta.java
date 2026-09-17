package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.BasicAssetValuation;
import fpml.consolidated.riskdef.validation.BasicAssetValuationTypeFormatValidator;
import fpml.consolidated.riskdef.validation.BasicAssetValuationValidator;
import fpml.consolidated.riskdef.validation.exists.BasicAssetValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BasicAssetValuation.class)
public class BasicAssetValuationMeta implements RosettaMetaData<BasicAssetValuation> {

	@Override
	public List<Validator<? super BasicAssetValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BasicAssetValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BasicAssetValuation> validator(ValidatorFactory factory) {
		return factory.<BasicAssetValuation>create(BasicAssetValuationValidator.class);
	}

	@Override
	public Validator<? super BasicAssetValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BasicAssetValuation>create(BasicAssetValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BasicAssetValuation> validator() {
		return new BasicAssetValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BasicAssetValuation> typeFormatValidator() {
		return new BasicAssetValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasicAssetValuation, Set<String>> onlyExistsValidator() {
		return new BasicAssetValuationOnlyExistsValidator();
	}
}

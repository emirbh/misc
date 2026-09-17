package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.Illiquidity;
import cdm.legaldocumentation.transaction.additionalterms.validation.IlliquidityTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.IlliquidityValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.IlliquidityOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=Illiquidity.class)
public class IlliquidityMeta implements RosettaMetaData<Illiquidity> {

	@Override
	public List<Validator<? super Illiquidity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Illiquidity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Illiquidity> validator(ValidatorFactory factory) {
		return factory.<Illiquidity>create(IlliquidityValidator.class);
	}

	@Override
	public Validator<? super Illiquidity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Illiquidity>create(IlliquidityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Illiquidity> validator() {
		return new IlliquidityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Illiquidity> typeFormatValidator() {
		return new IlliquidityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Illiquidity, Set<String>> onlyExistsValidator() {
		return new IlliquidityOnlyExistsValidator();
	}
}

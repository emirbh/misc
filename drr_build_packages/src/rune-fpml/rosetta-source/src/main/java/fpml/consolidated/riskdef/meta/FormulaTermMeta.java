package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.FormulaTerm;
import fpml.consolidated.riskdef.validation.FormulaTermTypeFormatValidator;
import fpml.consolidated.riskdef.validation.FormulaTermValidator;
import fpml.consolidated.riskdef.validation.exists.FormulaTermOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FormulaTerm.class)
public class FormulaTermMeta implements RosettaMetaData<FormulaTerm> {

	@Override
	public List<Validator<? super FormulaTerm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FormulaTerm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FormulaTerm> validator(ValidatorFactory factory) {
		return factory.<FormulaTerm>create(FormulaTermValidator.class);
	}

	@Override
	public Validator<? super FormulaTerm> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FormulaTerm>create(FormulaTermTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FormulaTerm> validator() {
		return new FormulaTermValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FormulaTerm> typeFormatValidator() {
		return new FormulaTermTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FormulaTerm, Set<String>> onlyExistsValidator() {
		return new FormulaTermOnlyExistsValidator();
	}
}

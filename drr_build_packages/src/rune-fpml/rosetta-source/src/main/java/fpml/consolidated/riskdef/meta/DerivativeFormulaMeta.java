package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.DerivativeFormula;
import fpml.consolidated.riskdef.validation.DerivativeFormulaTypeFormatValidator;
import fpml.consolidated.riskdef.validation.DerivativeFormulaValidator;
import fpml.consolidated.riskdef.validation.exists.DerivativeFormulaOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DerivativeFormula.class)
public class DerivativeFormulaMeta implements RosettaMetaData<DerivativeFormula> {

	@Override
	public List<Validator<? super DerivativeFormula>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DerivativeFormula, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DerivativeFormula> validator(ValidatorFactory factory) {
		return factory.<DerivativeFormula>create(DerivativeFormulaValidator.class);
	}

	@Override
	public Validator<? super DerivativeFormula> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DerivativeFormula>create(DerivativeFormulaTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeFormula> validator() {
		return new DerivativeFormulaValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeFormula> typeFormatValidator() {
		return new DerivativeFormulaTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativeFormula, Set<String>> onlyExistsValidator() {
		return new DerivativeFormulaOnlyExistsValidator();
	}
}

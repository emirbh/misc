package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Formula;
import fpml.consolidated.shared.validation.FormulaTypeFormatValidator;
import fpml.consolidated.shared.validation.FormulaValidator;
import fpml.consolidated.shared.validation.exists.FormulaOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Formula.class)
public class FormulaMeta implements RosettaMetaData<Formula> {

	@Override
	public List<Validator<? super Formula>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Formula, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Formula> validator(ValidatorFactory factory) {
		return factory.<Formula>create(FormulaValidator.class);
	}

	@Override
	public Validator<? super Formula> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Formula>create(FormulaTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Formula> validator() {
		return new FormulaValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Formula> typeFormatValidator() {
		return new FormulaTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Formula, Set<String>> onlyExistsValidator() {
		return new FormulaOnlyExistsValidator();
	}
}

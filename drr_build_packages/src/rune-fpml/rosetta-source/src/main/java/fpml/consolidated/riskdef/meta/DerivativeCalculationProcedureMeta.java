package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.DerivativeCalculationProcedure;
import fpml.consolidated.riskdef.validation.DerivativeCalculationProcedureTypeFormatValidator;
import fpml.consolidated.riskdef.validation.DerivativeCalculationProcedureValidator;
import fpml.consolidated.riskdef.validation.datarule.DerivativeCalculationProcedureChoice;
import fpml.consolidated.riskdef.validation.exists.DerivativeCalculationProcedureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DerivativeCalculationProcedure.class)
public class DerivativeCalculationProcedureMeta implements RosettaMetaData<DerivativeCalculationProcedure> {

	@Override
	public List<Validator<? super DerivativeCalculationProcedure>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DerivativeCalculationProcedure>create(DerivativeCalculationProcedureChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DerivativeCalculationProcedure, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DerivativeCalculationProcedure> validator(ValidatorFactory factory) {
		return factory.<DerivativeCalculationProcedure>create(DerivativeCalculationProcedureValidator.class);
	}

	@Override
	public Validator<? super DerivativeCalculationProcedure> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DerivativeCalculationProcedure>create(DerivativeCalculationProcedureTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeCalculationProcedure> validator() {
		return new DerivativeCalculationProcedureValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DerivativeCalculationProcedure> typeFormatValidator() {
		return new DerivativeCalculationProcedureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativeCalculationProcedure, Set<String>> onlyExistsValidator() {
		return new DerivativeCalculationProcedureOnlyExistsValidator();
	}
}

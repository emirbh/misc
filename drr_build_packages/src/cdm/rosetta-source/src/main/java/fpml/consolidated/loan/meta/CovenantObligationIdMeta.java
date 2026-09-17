package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CovenantObligationId;
import fpml.consolidated.loan.validation.CovenantObligationIdTypeFormatValidator;
import fpml.consolidated.loan.validation.CovenantObligationIdValidator;
import fpml.consolidated.loan.validation.exists.CovenantObligationIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CovenantObligationId.class)
public class CovenantObligationIdMeta implements RosettaMetaData<CovenantObligationId> {

	@Override
	public List<Validator<? super CovenantObligationId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CovenantObligationId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CovenantObligationId> validator(ValidatorFactory factory) {
		return factory.<CovenantObligationId>create(CovenantObligationIdValidator.class);
	}

	@Override
	public Validator<? super CovenantObligationId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CovenantObligationId>create(CovenantObligationIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CovenantObligationId> validator() {
		return new CovenantObligationIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CovenantObligationId> typeFormatValidator() {
		return new CovenantObligationIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CovenantObligationId, Set<String>> onlyExistsValidator() {
		return new CovenantObligationIdOnlyExistsValidator();
	}
}

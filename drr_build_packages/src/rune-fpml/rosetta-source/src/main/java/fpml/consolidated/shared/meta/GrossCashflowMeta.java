package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.GrossCashflow;
import fpml.consolidated.shared.validation.GrossCashflowTypeFormatValidator;
import fpml.consolidated.shared.validation.GrossCashflowValidator;
import fpml.consolidated.shared.validation.exists.GrossCashflowOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GrossCashflow.class)
public class GrossCashflowMeta implements RosettaMetaData<GrossCashflow> {

	@Override
	public List<Validator<? super GrossCashflow>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GrossCashflow, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GrossCashflow> validator(ValidatorFactory factory) {
		return factory.<GrossCashflow>create(GrossCashflowValidator.class);
	}

	@Override
	public Validator<? super GrossCashflow> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GrossCashflow>create(GrossCashflowTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GrossCashflow> validator() {
		return new GrossCashflowValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GrossCashflow> typeFormatValidator() {
		return new GrossCashflowTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GrossCashflow, Set<String>> onlyExistsValidator() {
		return new GrossCashflowOnlyExistsValidator();
	}
}

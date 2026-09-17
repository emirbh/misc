package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.ReturnLegValuation;
import fpml.consolidated.eq.shared.validation.ReturnLegValuationTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.ReturnLegValuationValidator;
import fpml.consolidated.eq.shared.validation.exists.ReturnLegValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReturnLegValuation.class)
public class ReturnLegValuationMeta implements RosettaMetaData<ReturnLegValuation> {

	@Override
	public List<Validator<? super ReturnLegValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnLegValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnLegValuation> validator(ValidatorFactory factory) {
		return factory.<ReturnLegValuation>create(ReturnLegValuationValidator.class);
	}

	@Override
	public Validator<? super ReturnLegValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnLegValuation>create(ReturnLegValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnLegValuation> validator() {
		return new ReturnLegValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnLegValuation> typeFormatValidator() {
		return new ReturnLegValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnLegValuation, Set<String>> onlyExistsValidator() {
		return new ReturnLegValuationOnlyExistsValidator();
	}
}
